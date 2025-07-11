package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.adminchest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Adminchestendpoint {
	
	static ResourceBundle getURL(){
		ResourceBundle routes= ResourceBundle.getBundle("Routes");
		return routes;
	}
	
	public static Response adminchestshortcode(String accessToken)
	{
		String post_urlshortcode= getURL().getString("shortcode_get_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		
		.when()
		.get(post_urlshortcode);
		
		return response;
	
	}
	
	public static Response chestdatafetch(String accessToken)
	{
		String get_url= getURL().getString("adminchest_get_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		
		.when()
		.get(get_url);
		
		return response;
	
	}
	
	public static Response chestdatacreate(String accessToken, adminchest payload)
	{
		String post_url= getURL().getString("adminchest_post_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		.body(payload)
		
		
		.when()
		.post(post_url);
		
		return response;
	
	}
	
	public static Response chestdataupdate(String accessToken, String chestid, adminchest payload)
	{
		String put_url= getURL().getString("adminchest_put_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		.pathParam("chestid", chestid)
		.body(payload)
		
		
		
		.when()
		.put(put_url);
		
		return response;
	
	}
	
	public static Response chestdatadelete(String accessToken, String chestid)
	{
		String delete_url= getURL().getString("adminchest_delete_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		.pathParam("chestid", chestid)
		
		
		.when()
		.delete(delete_url);
		
		return response;
	
	}
	

}
