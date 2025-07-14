package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.admincurrency;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Admincurrencyendpoint {
	
	static ResourceBundle getURL(){
		ResourceBundle routes= ResourceBundle.getBundle("Routes");
		return routes;
	}
	
	public static Response admincurrencyupdate(String accessToken, String id, admincurrency payload)
	{
		String put_url= getURL().getString("currencyupdate_put_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		.body(payload)
		
		
		
		.when()
		.put(put_url+id);
		
		return response;
	
	}
	
	public static Response currencydatafetch(String accessToken)
	{
		String get_url= getURL().getString("currencyfetch_get_url");
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer " + accessToken)
		
		.when()
		.get(get_url);
		
		return response;
	
	}

}
