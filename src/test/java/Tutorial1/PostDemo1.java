package Tutorial1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostDemo1 {
	
	public static void main(String[] args) throws JsonProcessingException {
		
		RestAssured.baseURI="https://api.github.com";
		RestAssured.basePath="/user";
		
		RequestSpecification httpRequest =RestAssured.given();
		
		httpRequest.header("Authorization","Bearer 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");
		
		httpRequest.contentType(ContentType.JSON);
		
		GitRepo git =new GitRepo();
		git.setName("Demo1");
		git.setDescription("This Repo is created by  using  Rest Assured");
		git.setHomepage("https://github.com");
		git.setPrivate(false);
		git.setIs_template(true);
		
		ObjectMapper mapper =new ObjectMapper();
		String reqbody =mapper.writeValueAsString(git);
		
		httpRequest.body(reqbody);
		
		Response resp =httpRequest.post("/repos");
		
		System.out.println(resp.statusCode());
		System.out.println(resp.statusLine());
		
		String body =resp.getBody().asString();
		JsonPath json =new JsonPath(body);
		String a =json.getString("name");
		System.out.println(a);
		
		String b =resp.getBody().jsonPath().getString("name");
		System.out.println(b);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
