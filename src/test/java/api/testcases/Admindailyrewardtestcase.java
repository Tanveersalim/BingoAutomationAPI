package api.testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import api.endpoints.Admindailyrewardendpoint;
import api.endpoints.Signinendpoint;
import api.payload.admindailyreward;
import api.payload.signin;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class Admindailyrewardtestcase {
	
	signin signinpayload;
	admindailyreward admindailyrewardpayload;
	String token;
    String id;
    int limit=100;
    public static Logger log;
    
	@BeforeClass
	public void generateusertestdata() throws InterruptedException {
		
		Thread.sleep(7000);
		
		signinpayload=new signin();
		admindailyrewardpayload=new admindailyreward();
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
	
	
	@Test(priority=1, dataProvider = "Dailyrewarddata", dataProviderClass = DataProviders.class)
	public void testadmindailyrewardcreate(String day, String rewardType, String rewardShortCode, String quantity) {
		
		admindailyrewardpayload.setDay(day);
		admindailyrewardpayload.setRewardType(rewardType);
		admindailyrewardpayload.setRewardShortCode(rewardShortCode);
		admindailyrewardpayload.setQuantity(quantity);
		
		//response generate
		Response response = Admindailyrewardendpoint.admindailyrewardcreate(token, admindailyrewardpayload);
		
		//Validation
		Assert.assertEquals(response.getStatusCode(), 201);
		response.then().log().all();
		log.info("Daily Reward Created Successfully");
	}

	@Test(priority=2)
	public void testadmindailyrewardfetch() {
		
		
		
		//response generate
		Response getresponse = Admindailyrewardendpoint.dailyrewarddatafetch(token,limit);
		
		
		
		//Validation
		Assert.assertEquals(getresponse.getStatusCode(), 200);
		getresponse.then().log().all();
		log.info("Daily Reward Get Successfully");
		
		
		
	}
	
	@Test(priority=3, dataProvider = "Dailyrewardupdatedata", dataProviderClass = DataProviders.class)
	public void testadmindailyrewardupdate(String day, String rewardType, String rewardShortCode, String quantity) {

	    // Fetch ID
		Response getresponse = Admindailyrewardendpoint.dailyrewarddatafetch(token,limit);
	    id = getresponse.jsonPath().getString("data[0]._id");

	    //Set payload BEFORE sending update
	    admindailyrewardpayload.setDay(day);
		admindailyrewardpayload.setRewardType(rewardType);
		admindailyrewardpayload.setRewardShortCode(rewardShortCode);
		admindailyrewardpayload.setQuantity(quantity);
	

	    // Send update request
	    Response updateresponse = Admindailyrewardendpoint.dailyrewarddataupdate(token, id, admindailyrewardpayload);
	    updateresponse.then().log().all();

	    // Validate response
	    Assert.assertEquals(updateresponse.getStatusCode(), 200);
	    log.info("Daily Reward Updated Successfully");
	    
	}
	
	@Test(priority = 4)
	public void testadmindailyrewarddelete() {

	    // Fetch ID
		Response getresponse = Admindailyrewardendpoint.dailyrewarddatafetch(token,limit);
		getresponse.then().log().all();
		
		List<String> ids = getresponse.jsonPath().getList("data._id");
		for (int i = 30; i <= 32 && i <= ids.size(); i++) {
			
			id=ids.get(i);
		    // Send update request
		    Response deleteresponse = Admindailyrewardendpoint.dailyrewarddatadelete(token, id);
		    deleteresponse.then().log().all();

		    // Validate response
		    Assert.assertEquals(deleteresponse.getStatusCode(), 200);
		
		}
		log.info("Daily Reward Deleted Successfully");
	    
	}

}
