package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.signin;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Signinendpoint {
	
	static ResourceBundle getURL(){
		ResourceBundle routes= ResourceBundle.getBundle("Routes");
		return routes;
	}
	
	public static Response signinuser(signin payload)
	{
		String post_url= getURL().getString("signin_post_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(post_url);
		
		return response;
	
	}
	
	

}
