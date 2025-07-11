package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.adminmarketplace;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Adminmarketplaceendpoint {
	
	static ResourceBundle getURL(){
		ResourceBundle routes= ResourceBundle.getBundle("Routes");
		return routes;
	}

	public static Response adminmarketplaceshortcode(String accessToken)
	{
		String get_url= getURL().getString("marketplaceshortcodefetch_get_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		
		.when()
		.get(get_url);
		
		return response;
	
	}
	
	public static Response marketplacedatafetch(String accessToken)
	{
		String get_urls= getURL().getString("marketplacefetch_get_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		
		.when()
		.get(get_urls);
		
		return response;
	
	}
	
	public static Response marketplacedatacreate(String accessToken, adminmarketplace payload)
	{
		String post_url= getURL().getString("marketplacecreate_post_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		.body(payload)
		
		
		.when()
		.post(post_url);
		
		return response;
	
	}
	
	public static Response marketplacedataupdate(String accessToken, String marketplaceid, adminmarketplace payload)
	{
		String put_url= getURL().getString("marketplaceupdate_put_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		.pathParam("marketplaceid", marketplaceid)
		.body(payload)
		
		
		
		.when()
		.put(put_url);
		
		return response;
	
	}
	
	public static Response marketplacedatadelete(String accessToken, String marketplaceid)
	{
		String delete_url= getURL().getString("marketplacedelete_delete_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		.pathParam("marketplaceid", marketplaceid)
		
		
		.when()
		.delete(delete_url);
		
		return response;
	
	}
	
}
