package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import api.endpoints.Adminuserendpoint;
import api.endpoints.Signinendpoint;
import api.payload.signin;
import io.restassured.response.Response;

public class Adminusertestcase {
	
	signin signinpayload;
	public static Logger log;
	String token;
    String id;

	@BeforeClass
	public void generateusertestdata() throws InterruptedException {
		
		Thread.sleep(4000);
		
		signinpayload=new signin();
		log=LogManager.getLogger("BingoAutomation");
		signinpayload.setEmail("admin@hpl.com");
		signinpayload.setPassword("Ali12345?!");
		
		
		
		
		
				Response loginresponse = Signinendpoint.signinuser(signinpayload);
				
				//response logs
				loginresponse.then().log().all();
				log.info("User Sign In Successfully");
				
				//Token Extract
				token = loginresponse.jsonPath().getString("data.accessToken");
				
				
		
	}
	
	
	@Test(priority=1)
	public void testadminuserfetch() {
		
		
		
		//response generate
		Response response = Adminuserendpoint.adminuserfetch(token);
		
		//Validation
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().log().all();
		log.info("User Data Get Successfully");
	}

	@Test(priority=2)
	public void testadminuserfetchbyid() {
		
		Response response = Adminuserendpoint.adminuserfetch(token);
		id = response.jsonPath().getString("data[2]._id");
		//response generate
		Response getresponsebyid = Adminuserendpoint.adminuserfetchbyid(token, id);
		
		
		
		//Validation
		Assert.assertEquals(getresponsebyid.getStatusCode(), 200);
		getresponsebyid.then().log().all();
		log.info("User Data GetbyID Successfully");
		
		
		
	}

}
