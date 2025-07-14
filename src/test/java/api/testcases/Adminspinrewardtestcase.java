package api.testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import api.endpoints.Adminspinrewardendpoint;
import api.endpoints.Signinendpoint;
import api.payload.adminspinreward;
import api.payload.signin;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class Adminspinrewardtestcase {
	
	signin signinpayload;
	adminspinreward adminspinrewardpayload;
	String token;
    String id;
    int limit=100;
    public static Logger log;
	@BeforeClass
	public void generateusertestdata() throws InterruptedException {
		Thread.sleep(7000);
		
		signinpayload=new signin();
		adminspinrewardpayload=new adminspinreward();
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
	
	
	@Test(priority=1, dataProvider = "Spinrewarddata", dataProviderClass = DataProviders.class)
	public void testadminspinrewardcreate(String sectionNumber, String rewardType, String rewardShortCode, String quantity) {
		
		adminspinrewardpayload.setSectionNumber(sectionNumber);
		adminspinrewardpayload.setRewardType(rewardType);
		adminspinrewardpayload.setRewardShortCode(rewardShortCode);
		adminspinrewardpayload.setQuantity(quantity);
		
		//response generate
		Response response = Adminspinrewardendpoint.adminspinrewardcreate(token, adminspinrewardpayload);
		
		//Validation
		Assert.assertEquals(response.getStatusCode(), 201);
		response.then().log().all();
		log.info("Spin Reward Created Successfully");
	}

	@Test(priority=2)
	public void testadminspinrewardfetch() {
		
		
		
		//response generate
		Response getresponse = Adminspinrewardendpoint.spinrewarddatafetch(token,limit);
		
		
		
		//Validation
		Assert.assertEquals(getresponse.getStatusCode(), 200);
		getresponse.then().log().all();
		log.info("Spin Reward Get Successfully");
		
		
		
	}
	
	@Test(priority=3, dataProvider = "Spinrewardupdatedata", dataProviderClass = DataProviders.class)
	public void testadminspinrewardupdate(String sectionNumber, String rewardType, String rewardShortCode, String quantity) {

	    // Fetch ID
		Response getresponse = Adminspinrewardendpoint.spinrewarddatafetch(token,limit);
	    id = getresponse.jsonPath().getString("data[13]._id");

	    //Set payload BEFORE sending update
	    adminspinrewardpayload.setSectionNumber(sectionNumber);
		adminspinrewardpayload.setRewardType(rewardType);
		adminspinrewardpayload.setRewardShortCode(rewardShortCode);
		adminspinrewardpayload.setQuantity(quantity);
		
	  

	    // Send update request
	    Response updateresponse = Adminspinrewardendpoint.spinrewarddataupdate(token, id, adminspinrewardpayload);
	    updateresponse.then().log().all();

	    // Validate response
	    Assert.assertEquals(updateresponse.getStatusCode(), 200);
	    log.info("Spin Reward Updated Successfully");
	}
	
	@Test(priority = 4)
	public void testadminspinrewarddelete() {

	    // Fetch ID
		Response getresponse = Adminspinrewardendpoint.spinrewarddatafetch(token,limit);
		List<String> ids = getresponse.jsonPath().getList("data._id");
		
		 for (int i = 11; i <= 13 && i <= ids.size(); i++) {
		    	
		    	id=ids.get(i);
		    	
		    	 // Send update request
		    	Response deleteresponse = Adminspinrewardendpoint.spinrewarddatadelete(token, id);
			    deleteresponse.then().log().all();

			    // Validate response
			    Assert.assertEquals(deleteresponse.getStatusCode(), 200);
			    
		 }

		 log.info("Spin Reward Deleted Successfully");
	    
	}
}
