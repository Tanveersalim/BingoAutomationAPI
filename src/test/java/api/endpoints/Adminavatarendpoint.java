package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.adminavatar;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Adminavatarendpoint {
	
	static ResourceBundle getURL(){
		ResourceBundle routes= ResourceBundle.getBundle("Routes");
		return routes;
	}
	
	public static Response adminsavatarcreate(String accessToken, adminavatar payload)
	{
		String post_url= getURL().getString("avatarcreate_post_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		.body(payload)
		
		
		.when()
		.post(post_url);
		
		return response;
	
	}
	
	public static Response avatardatafetch(String accessToken)
	{
		String get_url= getURL().getString("avatarfetch_get_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		
		.when()
		.get(get_url);
		
		return response;
	
	}
	
	
	public static Response avatardataupdate(String accessToken, String id, adminavatar payload)
	{
		String put_url= getURL().getString("avatarupdate_put_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		
		.body(payload)
		
		
		
		.when()
		.put(put_url+id);
		
		return response;
	
	}
	
	public static Response avatardatadelete(String accessToken, String id)
	{
		String delete_url= getURL().getString("avatardelete_delete_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		
		
		.when()
		.delete(delete_url+id);
		
		return response;
	
	}



}
