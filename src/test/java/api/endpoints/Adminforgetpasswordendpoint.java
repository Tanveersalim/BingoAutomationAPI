package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.adminchangepassword;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Adminforgetpasswordendpoint {
	
	static ResourceBundle getURL(){
		ResourceBundle routes= ResourceBundle.getBundle("Routes");
		return routes;
	}
	
	public static Response forgetpassworduser(String Token, adminchangepassword payload)
	{
		String post_url= getURL().getString("changepassword_post_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + Token)
		.body(payload)
		
		
		
		.when()
		.post(post_url);
		
		return response;
	
	}

}
