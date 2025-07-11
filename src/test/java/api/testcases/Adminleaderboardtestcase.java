package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import api.endpoints.Adminleaderboardendpoint;
import api.endpoints.Signinendpoint;
import api.payload.signin;
import io.restassured.response.Response;

public class Adminleaderboardtestcase {
	
signin signinpayload;
public static Logger log;
	
	@BeforeClass
	public void generateusertestdata() throws InterruptedException {
		Thread.sleep(7000);
		
		signinpayload=new signin();
		log=LogManager.getLogger("BingoAutomation");
		signinpayload.setEmail("admin@hpl.com");
		signinpayload.setPassword("Ali12345?!");
		
	}
	
	
	@Test
	public void testadminleaderboard() {
		
		
		//response generate
		Response loginresponse = Signinendpoint.signinuser(signinpayload);
		
		//response logs
		loginresponse.then().log().all();
		log.info("User Sign In Successfully");
		
		//Token Extract
		String token = loginresponse.jsonPath().getString("data.accessToken");
		//response generate
		Response response = Adminleaderboardendpoint.adminleaderboard(token);
		
		//Validation
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().log().all();
		log.info("Leaderboard Get Successfully");
	}


}
