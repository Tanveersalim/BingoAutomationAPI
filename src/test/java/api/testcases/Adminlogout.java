package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import api.endpoints.Signinendpoint;
import api.endpoints.Adminlogoutendpoint;
import api.payload.signin;
import io.restassured.response.Response;

public class Adminlogout {
	
signin signinpayload;
public static Logger log;
	
	@BeforeClass
	public void generateusertestdata() throws InterruptedException {
		
		Thread.sleep(4000);
		
		signinpayload=new signin();
		log=LogManager.getLogger("BingoAutomation");
		signinpayload.setEmail("admin@hpl.com");
		signinpayload.setPassword("Ali12345?!");
		
	}
	
	
	@Test
	public void testadminlogout() {
		
		
		//response generate
		Response loginresponse = Signinendpoint.signinuser(signinpayload);
		
		//response logs
		loginresponse.then().log().all();
		log.info("User Sign In Successfully");
		
		//Token Extract
		String token = loginresponse.jsonPath().getString("data.accessToken");
		//response generate
		Response response = Adminlogoutendpoint.adminlogout(token);
		
		//Validation
		Assert.assertEquals(response.getStatusCode(), 201);
		response.then().log().all();
		log.info("User Logout Successfully");
	}


}
