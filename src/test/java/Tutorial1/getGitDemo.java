package Tutorial1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getGitDemo {

	public static void main(String[] args) {
		
		RestAssured.baseURI="https://api.github.com";
		
		RequestSpecification httpRequest =RestAssured.given();
		
		httpRequest.header("Authorization","Bearer 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");

		Response resp =httpRequest.get("/repos/prafulp1030/RestAssuredDemo");
		
		System.out.println(resp.statusCode());
		System.out.println(resp.statusLine());

	}

}
