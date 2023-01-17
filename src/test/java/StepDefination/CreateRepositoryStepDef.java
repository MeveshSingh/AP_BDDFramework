package StepDefination;



import org.junit.Assert;

import BaseApiLayer.BaseApi;
import Resources.GitRepositoryTestData;
import Resources.UtilsClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class CreateRepositoryStepDef{
	static BaseApi base;
	RequestSpecification httpRequest;
	Response resp;
	static String names;
	
	@Given("user create a new repository by entering repo name,desc, homepage, repo type and issue type")
	public void user_create_a_new_repository_by_entering_repo_name_desc_homepage_repo_type_and_issue_type() {
		base =new BaseApi();
		httpRequest= base.requestSpecification();
		GitRepositoryTestData git =new GitRepositoryTestData();
		String reqbody =git.createGitRepository("Sample6", "Sample 1 Repository created by API", base.getproperty("homepage"), false, false, false, false);
		httpRequest.body(reqbody);
	}

	@When("user hit post request")
	public void user_hit_post_request() {
		resp =httpRequest.post("/user/repos").then().log().all().extract().response();
	}
	
	
	@Then("user validate status {string} is {int}")
	public void user_validate_status_is(String key, Integer status) {
	    
		if(key.equalsIgnoreCase("postcode"))
		{
			Assert.assertEquals(status.intValue(), resp.statusCode());
		}
		else if(key.equalsIgnoreCase("getcode") || key.equalsIgnoreCase("patchcode"))
		{	
			Assert.assertEquals(status.intValue(), resp.statusCode());	
		}
		else if(key.equalsIgnoreCase("deletecode"))
		{
			Assert.assertEquals(status.intValue(), resp.statusCode());
		}
	}



	@Then("user validate status {string} is {string}")
	public void user_validate_status_is(String key, String value) {
		
		if(key.equalsIgnoreCase("line"))
		{
			Assert.assertEquals(value, resp.statusLine());
		}
		else if(key.equalsIgnoreCase("getline") || key.equalsIgnoreCase("patchline"))
		{
			Assert.assertEquals(value, resp.statusLine());
		}
		else if(key.equalsIgnoreCase("deleteline"))
		{
			Assert.assertEquals(value, resp.statusLine());
		}
	}

	@Then("user validate response body")
	public void user_validate_response_body() 
	{
		names =UtilsClass.captureValueFromRespBody(resp, "name");
		Assert.assertEquals(resp.getBody().asString().contains(names),true);
	}

	@Then("user validate response content type header is {string}")
	public void user_validate_response_content_type_header_is(String value) {
	 
			Assert.assertEquals(value, resp.contentType());
	}
	
	@Given("user get request specification object and add bearer token")
	public void user_get_request_specification_object_and_add_bearer_token() {
	   base =new BaseApi();
	   httpRequest=  base.requestSpecification();
	}
	
	@When("user hit get request")
	public void user_hit_get_request() {
		resp =httpRequest.get("/repos/"+base.getproperty("username")+"/"+names);
	}
	
	
	@Given("user get request specification object and add bearer token and user added latest repo name")
	public void user_get_request_specification_object_and_add_bearer_token_and_user_added_latest_repo_name() {
	
		base = new BaseApi();
		httpRequest =base.requestSpecification();
		
		GitRepositoryTestData git =new GitRepositoryTestData();
		String reqBody =git.updateNewRepositoryName("demo121");	
		httpRequest.body(reqBody);
	}
	
	@When("user hit patch request")
	public void user_hit_patch_request() {
		resp =httpRequest.patch("/repos/"+base.getproperty("username")+"/"+names);
	}
	
	
	@When("user hit delete request")
	public void user_hit_delete_request() {
		resp =httpRequest.delete("/repos/"+base.getproperty("username")+"/"+names);

	}

}
