package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.adminspinreward;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Adminspinrewardendpoint {
	
	static ResourceBundle getURL(){
		ResourceBundle routes= ResourceBundle.getBundle("Routes");
		return routes;
	}
	
	public static Response adminspinrewardcreate(String accessToken, adminspinreward payload)
	{
		String post_url= getURL().getString("spinrewardcreate_post_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		.body(payload)
		
		
		.when()
		.post(post_url);
		
		return response;
	
	}
	
	public static Response spinrewarddatafetch(String accessToken,int limit)
	{
		String get_url= getURL().getString("spinrewardfetch_get_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		.queryParam("limit", limit)
		
		.when()
		.get(get_url);
		
		return response;
	
	}
	
	
	public static Response spinrewarddataupdate(String accessToken, String id, adminspinreward payload)
	{
		String put_url= getURL().getString("spinrewardupdate_put_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		.body(payload)
		
		
		.when()
		.put(put_url+id);
		
		return response;
	
	}
	
	public static Response spinrewarddatadelete(String accessToken, String id)
	{
		String delete_url= getURL().getString("spinrewarddelete_delete_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		
		
		.when()
		.delete(delete_url+id);
		
		return response;
	
	}

}
