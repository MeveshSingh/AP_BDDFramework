package Tutorial1;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class patchDemo {

	public static void main(String[] args) {

		RestAssured.baseURI="https://api.github.com";
		
		RequestSpecification httpRequest =RestAssured.given();
		httpRequest.header("Authorization","Bearer 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");
		httpRequest.contentType(ContentType.JSON);
		
		JSONObject json =new JSONObject();
		json.put("name", "Pune1");
		String reqbody =json.toString();
		
		httpRequest.body(reqbody);
		
		Response resp =httpRequest.patch("/repos/prafulp1030/Demo1");
		
		System.out.println(resp.getStatusCode());
		System.out.println(resp.statusLine());
		
		System.out.println(resp.getBody().asString());
		
		
		
	}

}
