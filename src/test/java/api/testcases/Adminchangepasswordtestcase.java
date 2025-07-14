package api.testcases;

import org.testng.Assert;

import org.testng.annotations.Test;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import api.endpoints.Adminforgetpasswordendpoint;
import api.endpoints.Signinendpoint;
import api.payload.adminchangepassword;
import api.payload.signin;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class Adminchangepasswordtestcase {
	
	
	adminchangepassword adminchangepasswordpayload;
	signin signinpayload;
	public static Logger log;
	
	
	@Test(dataProvider = "Changepassworddata", dataProviderClass = DataProviders.class) 
	public void testadminchangepassword(String newPassword) throws InterruptedException {
		Thread.sleep(4000);
		signinpayload=new signin();
		adminchangepasswordpayload=new adminchangepassword();
		log=LogManager.getLogger("BingoAutomation");
		
		signinpayload.setEmail("admin@hpl.com");
		signinpayload.setPassword("Ali12345?!");
		        //response generate
				Response loginresponse = Signinendpoint.signinuser(signinpayload);
				
				//response logs
				loginresponse.then().log().all();
				log.info("User Sign In Successfully");
				
				//Token Extract
				String token = loginresponse.jsonPath().getString("data.accessToken");
				
				//response changepassword
				
				adminchangepasswordpayload.setOldPassword(signinpayload.getPassword());
				adminchangepasswordpayload.setNewPassword(newPassword);
			    Response changepasswordresponse = Adminforgetpasswordendpoint.forgetpassworduser(token, adminchangepasswordpayload);
			    
				
				//Validation
				Assert.assertEquals(changepasswordresponse.getStatusCode(), 201);
				changepasswordresponse.then().log().all();
				log.info("User Password Changed Successfully");
				
		
	}


}
