package api.testcases;



import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import api.endpoints.Adminpowerupendpoint;

import api.endpoints.Signinendpoint;
import api.payload.adminpowerup;
import api.payload.signin;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class Adminpoweruptestcase {
	
	
	signin signinpayload;
	adminpowerup adminpoweruppayload;
	String token;
    String id;
    public static Logger log;
	@BeforeClass
	public void generateusertestdata() throws InterruptedException {
		Thread.sleep(7000);
		
		signinpayload=new signin();
		adminpoweruppayload=new adminpowerup();
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
	
	
	@Test(priority=1, dataProvider = "Powerupsdata", dataProviderClass = DataProviders.class)
	public void testadminpowerupcreate(String shortCode, String name, String image, String imageLarge, String rarity, String defaultCount, String description) {
		
		
		adminpoweruppayload.setShortCode(shortCode);
		adminpoweruppayload.setName(name);
		adminpoweruppayload.setImage(image);
		adminpoweruppayload.setImageLarge(imageLarge);
		adminpoweruppayload.setRarity(rarity);
		adminpoweruppayload.setDefaultCount(defaultCount);
		adminpoweruppayload.setDescription(description);
		//response generate
		Response response = Adminpowerupendpoint.adminpowerupcreate(token, adminpoweruppayload);
		
		//Validation
		Assert.assertEquals(response.getStatusCode(), 201);
		response.then().log().all();
		log.info("PowerUp Created Successfully");
	}

	@Test(priority=2)
	public void testadminpowerupfetch() {
		
		
		
		//response generate
		Response getresponse = Adminpowerupendpoint.powerupdatafetch(token);
		
		
		
		//Validation
		Assert.assertEquals(getresponse.getStatusCode(), 200);
		getresponse.then().log().all();
		log.info("PowerUp Get Successfully");
		
		
		
	}
	
	@Test(priority=3, dataProvider = "Powerupsupdatedata", dataProviderClass = DataProviders.class)
	public void testadminpowerupupdate(String name, String image, String imageLarge, String description, String rarity, String defaultCount) {

	    // Fetch ID
	    Response getresponse = Adminpowerupendpoint.powerupdatafetch(token);
	    id = getresponse.jsonPath().getString("data[8]._id");
	    //Set payload BEFORE sending update
		adminpoweruppayload.setName(name);
		adminpoweruppayload.setImage(image);
		adminpoweruppayload.setImageLarge(imageLarge);
		adminpoweruppayload.setRarity(rarity);
		adminpoweruppayload.setDefaultCount(defaultCount);
		adminpoweruppayload.setDescription(description);
		
	  

	    // Send update request
	    Response updateresponse = Adminpowerupendpoint.powerupdataupdate(token, id, adminpoweruppayload);
	    updateresponse.then().log().all();

	    // Validate response
	    Assert.assertEquals(updateresponse.getStatusCode(), 200);
	    log.info("PowerUp Updated Successfully");
	}
	
	@Test(priority = 4)
	public void testadminpowerpdelete() {

	    // Fetch ID
	    Response getresponse = Adminpowerupendpoint.powerupdatafetch(token);
	    List<String> ids = getresponse.jsonPath().getList("data._id");
	    for (int i = 6; i <= 8 && i <= ids.size(); i++) {
	    	
	    	id=ids.get(i);
	    	
	    	 // Send update request
		    Response deleteresponse = Adminpowerupendpoint.powerupdelete(token, id);
		    deleteresponse.then().log().all();

		    // Validate response
		    Assert.assertEquals(deleteresponse.getStatusCode(), 200);
		    log.info("PowerUp Deleted Successfully");
	    }

	   
	}

}
