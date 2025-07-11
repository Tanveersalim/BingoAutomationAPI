package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.adminranktournament;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Adminrankendpoint {
	
	static ResourceBundle getURL(){
		ResourceBundle routes= ResourceBundle.getBundle("Routes");
		return routes;
	}
	
	public static Response adminrankcreate(String accessToken, adminranktournament payload)
	{
		String post_url= getURL().getString("ranktournamentcreate_post_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		.body(payload)
		
		
		
		.when()
		.post(post_url);
		
		return response;
	
	}
	
	public static Response rankdatafetch(String accessToken)
	{
		String get_url= getURL().getString("ranktournamentfetch_get_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		
		.when()
		.get(get_url);
		
		return response;
	
	}
	
	
	public static Response rankdataupdate(String accessToken, String id, adminranktournament payload)
	{
		String put_url= getURL().getString("ranktournamentupdate_put_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		.body(payload)
		
		
		
		.when()
		.put(put_url+id);
		
		return response;
	
	}
	
	public static Response rankdatadelete(String accessToken, String id)
	{
		String delete_url= getURL().getString("ranktournamentdelete_delete_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		
		
		
		.when()
		.delete(delete_url+id);
		
		return response;
	
	}



}
