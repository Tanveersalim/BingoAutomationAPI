package api.testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Adminchestendpoint;
import api.endpoints.Signinendpoint;
import api.payload.signin;
import api.payload.adminchest;
import io.restassured.response.Response;

public class Adminchesttestcase {
	
signin signinpayload;
adminchest chestpayload;
Faker faker;
String token;

	@BeforeClass
	public void generateusertestdata() {
		
		signinpayload=new signin();
		chestpayload=new adminchest();
		
		signinpayload.setEmail("admin@hpl.com");
		signinpayload.setPassword("12345678");
		chestpayload.setShortcode("T5Chest");
		chestpayload.setName(chestpayload.getShortcode());
		chestpayload.setImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR9SRRmhH4X5N2e4QalcoxVbzYsD44C-sQv-w&s");
		chestpayload.setImagelarge(chestpayload.getImage());
		chestpayload.setDescription("lorem ipsum");
		
		chestpayload.setTicketcount("300");
		List<adminchest> powerUps = new ArrayList<>();
		powerUps.add(new adminchest("3", "4", "Rare"));
		powerUps.add(new adminchest("1", "2", "Special"));

		// Set powerUps
		chestpayload.setPowerUps(powerUps);
		//response generate
				Response loginresponse = Signinendpoint.signinuser(signinpayload);
				
				//response logs
				loginresponse.then().log().all();
				
				
				//Token Extract
				token = loginresponse.jsonPath().getString("data.accessToken");
				System.out.println("Token: " + token);
		
	}
	
	
	@Test(priority=1)
	public void testadminchestshortcode() {
		
		
		
		//response generate
		Response response = Adminchestendpoint.adminchestshortcode(token);
		
		//Validation
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().log().all();
	}
	
	@Test(priority=2)
	public void testadminchestcreate() {
		
		
		
		//response generate
		Response response = Adminchestendpoint.chestdatacreate(token,chestpayload);
		
		//Validation
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().log().all();
	}

}
