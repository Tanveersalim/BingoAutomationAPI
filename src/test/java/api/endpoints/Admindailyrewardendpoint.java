package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.admindailyreward;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Admindailyrewardendpoint {
	
	static ResourceBundle getURL(){
		ResourceBundle routes= ResourceBundle.getBundle("Routes");
		return routes;
	}
	
	public static Response admindailyrewardcreate(String accessToken, admindailyreward payload)
	{
		String post_url= getURL().getString("dalilyrewardcreate_post_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		.body(payload)
		
		
		.when()
		.post(post_url);
		
		return response;
	
	}
	
	public static Response dailyrewarddatafetch(String accessToken, int limit)
	{
		String get_url= getURL().getString("dailyrewardfetch_get_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		.queryParam("limit", limit)
		
		.when()
		.get(get_url);
		
		return response;
	
	}
	
	
	public static Response dailyrewarddataupdate(String accessToken, String id, admindailyreward payload)
	{
		String put_url= getURL().getString("dalilyrewardupdate_put_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		.body(payload)
		
		
		
		.when()
		.put(put_url+id);
		
		return response;
	
	}
	
	public static Response dailyrewarddatadelete(String accessToken, String id)
	{
		String delete_url= getURL().getString("dailyrewarddelete_delete_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		
		
		
		.when()
		.delete(delete_url+id);
		
		return response;
	
	}


}
