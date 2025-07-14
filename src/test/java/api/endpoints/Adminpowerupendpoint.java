package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.adminpowerup;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Adminpowerupendpoint {
	
	static ResourceBundle getURL(){
		ResourceBundle routes= ResourceBundle.getBundle("Routes");
		return routes;
	}
	
	public static Response adminpowerupcreate(String accessToken, adminpowerup payload)
	{
		String post_url= getURL().getString("powerupcreate_post_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		.body(payload)
		
		
		.when()
		.post(post_url);
		
		return response;
	
	}
	
	public static Response powerupdatafetch(String accessToken)
	{
		String get_url= getURL().getString("powerupfetch_get_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		
		.when()
		.get(get_url);
		
		return response;
	
	}
	
	
	public static Response powerupdataupdate(String accessToken, String id, adminpowerup payload)
	{
		String put_url= getURL().getString("powerup_put_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		.body(payload)
		
		
		.when()
		.put(put_url + id);
		
		return response;
	
	}
	
	public static Response powerupdelete(String accessToken, String id)
	{
		String delete_url= getURL().getString("powerup_delete_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
	
		
		
		.when()
		.delete(delete_url + id);
		
		return response;
	
	}
	

}
