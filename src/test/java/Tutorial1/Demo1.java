package Tutorial1;

import BaseApiLayer.BaseApi;
import Resources.GitRepositoryTestData;
import Resources.UtilsClass;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo1 {

	public static void main(String[] args) {

		BaseApi base = new BaseApi();

		RequestSpecification httprequest = base.requestSpecification();

		GitRepositoryTestData git = new GitRepositoryTestData();

		String reqBody = git.createGitRepository("Demo7", "created by Rest API", "https://github.com", false, false,
				false, false);

		httprequest.body(reqBody);

		Response resp = httprequest.when().post("/user/repos");

		
		
		
		System.out.println(resp.statusCode());
		System.out.println(resp.statusLine());

		String respbody = resp.body().asString();

		String name = UtilsClass.captureValueFromRespBody(resp, "name");

		System.out.println("git repo name is " + name);

		BaseApi base1 = new BaseApi();
		
		RequestSpecification req =base.requestSpecification();

		Response res = req.when().get("/repos/" + base.getproperty("username") + "/" + name);

		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());

		String aname = UtilsClass.captureValueFromRespBody(res, "name");

		if (name.equals(aname)) {
			System.out.println("test case is pass");
		} else {
			System.out.println("test case is fail");
		}

		
		
		
		
		
		
		
		
		
		
		
		
	}

}
