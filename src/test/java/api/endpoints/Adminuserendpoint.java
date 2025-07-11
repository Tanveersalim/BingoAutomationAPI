package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Adminuserendpoint {
	
	static ResourceBundle getURL(){
		ResourceBundle routes= ResourceBundle.getBundle("Routes");
		return routes;
	}
	
	public static Response adminuserfetchbyid(String accessToken, String id)
	{
		String getbyid_url= getURL().getString("userfetchbyid_get_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		
		
		.when()
		.get(getbyid_url+id);
		
		return response;
	
	}
	
	public static Response adminuserfetch(String accessToken)
	{
		String get_url= getURL().getString("userfetch_get_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		
		.when()
		.get(get_url);
		
		return response;
	
	}

}
