package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.adminpointwager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Adminpointwagerendpoint {
	
	static ResourceBundle getURL(){
		ResourceBundle routes= ResourceBundle.getBundle("Routes");
		return routes;
	}
	
	public static Response adminpointwagercreate(String accessToken, adminpointwager payload)
	{
		String post_url= getURL().getString("pointwagercreate_post_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		.body(payload)
		
		
		.when()
		.post(post_url);
		
		return response;
	
	}
	
	public static Response pointwagerdatafetch(String accessToken,int limit)
	{
		String get_url= getURL().getString("pointwagerfetch_get_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		.queryParam("limit", limit)
		
		.when()
		.get(get_url);
		
		return response;
	
	}
	
	
	public static Response pointwagerdataupdate(String accessToken, String id, adminpointwager payload)
	{
		String put_url= getURL().getString("pointwagerupdate_put_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		.body(payload)
		
		
		.when()
		.put(put_url+id);
		
		return response;
	
	}
	
	public static Response pointwagerdelete(String accessToken, String id)
	{
		String delete_url= getURL().getString("pointwagerdelete_delete_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
	
		
		
		.when()
		.delete(delete_url+id);
		
		return response;
	
	}


	

}
