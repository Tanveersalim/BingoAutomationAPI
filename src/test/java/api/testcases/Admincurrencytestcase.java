package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import api.endpoints.Admincurrencyendpoint;
import api.endpoints.Signinendpoint;
import api.payload.signin;
import api.utilities.DataProviders;
import api.payload.admincurrency;
import io.restassured.response.Response;

public class Admincurrencytestcase {

	admincurrency currencypayload;
	signin signinpayload;
	String token;
    String id;
    public static Logger log;
    
	@BeforeClass
	public void generateusertestdata() throws InterruptedException {
		
		Thread.sleep(4000);
		
		currencypayload=new admincurrency();
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
	
	
	@Test(priority=2, dataProvider = "Currencydata", dataProviderClass = DataProviders.class)
	public void testadmicurrencyupdate(String image, String imagelarge, String description, String name, String defaultCount) {
		
		
		Response response = Admincurrencyendpoint.currencydatafetch(token);
		
		id = response.jsonPath().getString("data[0]._id");
		
		currencypayload.setImage(image);
		currencypayload.setImageLarge(imagelarge);
		currencypayload.setDescription(description);
		currencypayload.setName(name);
		currencypayload.setDefaultCount(defaultCount);
		
		//response generate
		Response updateresponse = Admincurrencyendpoint.admincurrencyupdate(token, id, currencypayload);
		
		//Validation
		Assert.assertEquals(updateresponse.getStatusCode(), 200);
		updateresponse.then().log().all();
		log.info("Currency Updated Successfully");
	}

	@Test(priority=1)
	public void testadmincurrencyfetch() {
		
		
		//response generate
		Response getresponsebyid = Admincurrencyendpoint.currencydatafetch(token);
		
		
		
		//Validation
		Assert.assertEquals(getresponsebyid.getStatusCode(), 200);
		getresponsebyid.then().log().all();
		log.info("Currency Get Successfully");
		
		
		
	}
}
