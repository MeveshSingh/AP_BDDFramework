package Tutorial2;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class EndToEndGitFlow {
	private RequestSpecification httpRequest;
	private String repoName;

	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI = "https://api.github.com";
		httpRequest = RestAssured.given()
				.header("Authorization", "Bearer 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")
				.contentType(ContentType.JSON);
	}

	@Test(priority = 1)
	public void postRequest() throws JsonProcessingException
	{
		GitRepoPojo gitrepo =new GitRepoPojo().setName("Sample1").setDescription("Sample1 repo created by Rest")
		.setHomepage("https://github.com")
		.setPrivate(false)
		.setIs_template(true);
		
		String reqbody =new ObjectMapper().writeValueAsString(gitrepo);
		Response resp =httpRequest.body(reqbody).when().post("user/repos").then().log().all().extract().response();
		
		System.out.println(resp.statusCode());
		System.out.println(resp.statusLine());
		repoName =resp.getBody().jsonPath().getString("name");
		System.out.println("====================== Post Request Logs Ended ==================");
	}
	
	@Test(priority = 2)
	public void getRequestAfterPost()
	{
		System.out.println("====================== Get Request Logs Started ==================");
		
		Response resp =httpRequest.get("repos/prafulp1030/"+repoName).then().log().all().extract().response();
		
		System.out.println("====================== get Request Logs Ended ==================");
	}
	
	@Test(priority = 3)
	public void patchDemo() throws JsonProcessingException
	{
		System.out.println("====================== patch Request Logs Started ==================");

		GitRepoPojo gitrepo =new GitRepoPojo().setName("Pune2");
		String reqbody =new ObjectMapper().writeValueAsString(gitrepo);
		
		Response resp =httpRequest.body(reqbody).when().patch("repos/prafulp1030/"+repoName).then().log().all().extract().response();
		
		repoName =resp.getBody().jsonPath().getString("name");
		
		System.out.println("====================== patch Request Logs Ended ==================");

	}
	
	
	@Test(priority = 4)
	public void getRequestAfterPatch()
	{
		System.out.println("====================== Get Request Logs Started ==================");
		
		Response resp =httpRequest.get("repos/prafulp1030/"+repoName).then().log().all().extract().response();
		
		System.out.println("====================== get Request Logs Ended ==================");
	}
	
	@Test(priority = 5)
	public void deleteRequest() throws InterruptedException
	{
		
		Thread.sleep(40000);
		System.out.println("====================== Delete Request Logs Started ==================");

		Response resp =httpRequest.delete("repos/prafulp1030/"+repoName).then().log().all().extract().response();
		System.out.println(resp.getStatusCode());
		
		System.out.println("====================== delete Request Logs Ended ==================");

	}
	
	@Test(priority = 6)
	public void getRequestAfterdelete()
	{
		System.out.println("====================== Get Request Logs Started ==================");
		
		Response resp =httpRequest.get("repos/prafulp1030/"+repoName).then().log().all().extract().response();
		
		Assert.assertEquals(resp.statusCode(), 404);
		
	}
}
