package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import api.endpoints.Adminpointwagerendpoint;
import api.endpoints.Signinendpoint;
import api.payload.adminpointwager;
import api.payload.signin;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class Adminpointswagertestcase {
	
	signin signinpayload;
	adminpointwager adminpointwagerpayload;
	String token;
    String id;
    int limit=100;
    public static Logger log;
	@BeforeClass
	public void generateusertestdata() throws InterruptedException {
		Thread.sleep(15000);
		
		signinpayload=new signin();
		adminpointwagerpayload=new adminpointwager();
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
	
	
	@Test(priority=1, dataProvider = "pointswagerdata", dataProviderClass = DataProviders.class)
	public void testadminpointwagercreate(String count,String multiplier,String type) {
		
		
		adminpointwagerpayload.setCount(count);
		adminpointwagerpayload.setMultiplier(multiplier);
		adminpointwagerpayload.setType(type);
		//response generate
		Response response = Adminpointwagerendpoint.adminpointwagercreate(token, adminpointwagerpayload);
		
		//Validation
		Assert.assertEquals(response.getStatusCode(), 201);
		response.then().log().all();
		log.info("Points Wager Created Successfully");
	}

	@Test(priority=2)
	public void testadminpointwagerfetch() {
		
		
		
		//response generate
		Response getresponse = Adminpointwagerendpoint.pointwagerdatafetch(token,limit);
		
		
		
		//Validation
		Assert.assertEquals(getresponse.getStatusCode(), 200);
		getresponse.then().log().all();
		log.info("Points Wager Get Successfully");
		
		
		
	}
	
	@Test(priority=3, dataProvider = "pointswagerupdatedata", dataProviderClass = DataProviders.class)
	public void testadminpointwagerupdate(String count,String multiplier,String type) {

	    // Fetch ID
		Response getresponse = Adminpointwagerendpoint.pointwagerdatafetch(token,limit);
	    id = getresponse.jsonPath().getString("data[15]._id");

	    //Set payload BEFORE sending update
	    adminpointwagerpayload.setCount(count);
		adminpointwagerpayload.setMultiplier(multiplier);
		adminpointwagerpayload.setType(type);
		
	  

	    // Send update request
	    Response updateresponse = Adminpointwagerendpoint.pointwagerdataupdate(token, id, adminpointwagerpayload);
	    updateresponse.then().log().all();

	    // Validate response
	    Assert.assertEquals(updateresponse.getStatusCode(), 200);
	    log.info("Points Wager Updated Successfully");
	}
	
	@Test(priority = 4)
	public void testadminpointwagerdelete() {

	    // Fetch ID
		Response getresponse = Adminpointwagerendpoint.pointwagerdatafetch(token,limit);
	    id = getresponse.jsonPath().getString("data[15]._id");

	    // Send update request
	    Response deleteresponse = Adminpointwagerendpoint.pointwagerdelete(token, id);
	    deleteresponse.then().log().all();

	    // Validate response
	    Assert.assertEquals(deleteresponse.getStatusCode(), 200);
	    log.info("Points Wager Deleted Successfully");
	}

}
