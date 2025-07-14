package api.testcases;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import api.endpoints.Adminavatarendpoint;
import api.endpoints.Signinendpoint;
import api.payload.adminavatar;
import api.payload.signin;
import api.utilities.DataProviders;
import io.restassured.response.Response;


public class Adminavatartestcase {
	
	
	
	signin signinpayload;
	adminavatar adminavatarpayload;
	String token;
    String id;
    public static Logger log;

	@BeforeClass
	public void generateusertestdata() throws InterruptedException {
		Thread.sleep(4000);
		
		signinpayload=new signin();
		adminavatarpayload=new adminavatar();
		log=LogManager.getLogger("BingoAutomation");
		signinpayload.setEmail("admin@hpl.com");
		signinpayload.setPassword("Ali12345?!");
		
				Response loginresponse = Signinendpoint.signinuser(signinpayload);
				
				//response logs
				loginresponse.then().log().all();
				
				token = loginresponse.jsonPath().getString("data.accessToken");
			    log.info("User Sign In Successfully");
				
		
	}
	
	
	@Test(priority=1, dataProvider = "Avatardata", dataProviderClass = DataProviders.class)
	public void testadminavatarcreate(String avatarUrl,String defaults) {
		
		
		
		adminavatarpayload.setAvatarUrl(avatarUrl);
		adminavatarpayload.setDefaults(defaults);
		//response generate
		Response response = Adminavatarendpoint.adminsavatarcreate(token, adminavatarpayload);
		
		//Validation
		Assert.assertEquals(response.getStatusCode(), 201);
		response.then().log().all();
		log.info("Avatar Created Successfully");
		
	}

	@Test(priority=2)
	public void testadminavatarfetch() {
		
		
		
		//response generate
		Response getresponse = Adminavatarendpoint.avatardatafetch(token);
		
		
		
		//Validation
		Assert.assertEquals(getresponse.getStatusCode(), 200);
		getresponse.then().log().all();
		log.info("Avatar Get Successfully");
		
		
		
	}
	
	@Test(priority=3, dataProvider = "Avatarupdatedata", dataProviderClass = DataProviders.class)
	public void testadminavatarupdate(String AvatarUrl, String defaults) {

	    // Fetch ID
		Response getresponse = Adminavatarendpoint.avatardatafetch(token);
	    id = getresponse.jsonPath().getString("data[3]._id");

	    //Set payload BEFORE sending update
	    adminavatarpayload.setAvatarUrl(AvatarUrl);
		adminavatarpayload.setDefaults(defaults);
		
	  

	    // Send update request
	    Response updateresponse = Adminavatarendpoint.avatardataupdate(token, id, adminavatarpayload);
	    updateresponse.then().log().all();

	    // Validate response
	    Assert.assertEquals(updateresponse.getStatusCode(), 200);
	    log.info("Avatar Updated Successfully");
	}
	
	@Test(priority = 4)
	public void testadminavatardelete() {

	    // Fetch ID
		Response getresponse = Adminavatarendpoint.avatardatafetch(token);
		List<String> ids = getresponse.jsonPath().getList("data._id");
		for (int i = 2; i <= 3 && i <= ids.size(); i++) {
			
			id=ids.get(i);
			
			System.out.println("setAvatarUrl: " + id);
			
			// Send update request
		    Response deleteresponse = Adminavatarendpoint.avatardatadelete(token, id);
		    deleteresponse.then().log().all();

		    // Validate response
		    Assert.assertEquals(deleteresponse.getStatusCode(), 200);
		    
		   
		}
	    
		log.info("Avatar Deleted Successfully");
	    
	}

}
