package api.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import api.endpoints.Signinendpoint;
import api.payload.signin;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class Adminsignintestcase {
	
	
	signin signinpayload;
	public static Logger log;
	
	
	@Test(dataProvider = "Signindata", dataProviderClass = DataProviders.class)
	public void testadminsignin(String email, String password) throws InterruptedException {
		
		Thread.sleep(20000);
		
		signinpayload=new signin();
		log=LogManager.getLogger("BingoAutomation");
		signinpayload.setEmail(email);
		signinpayload.setPassword(password);
		//response generate
	    Response response = Signinendpoint.signinuser(signinpayload);
		
		//response logs
		response.then().log().all();
		
		//Validation
		Assert.assertEquals(response.getStatusCode(), 200);
		log.info("User Sign In Successfully");
	}

}
