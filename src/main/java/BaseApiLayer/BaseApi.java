package BaseApiLayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class BaseApi {
	
	public RequestSpecification req;

	public String getproperty(String key) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "//src/main/java/ConfigLayer/config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}

	public RequestSpecification requestSpecification() {
		RestAssured.baseURI = getproperty("baseuri");
		
		if(req==null)
		{
			req = RestAssured.given().filter(RequestLoggingFilter.logRequestTo(logs("RequestLogs", "reqlogs")))
				.filter(ResponseLoggingFilter.logResponseTo(logs("ResponseLogs", "resplogs")))
				.contentType(ContentType.JSON)
				.header("Authorization","Bearer "+getproperty("bearertoken"));
			return req;
		}
		return req;
	}

	public PrintStream logs(String foldername, String filename) {
		String date = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
		String path = System.getProperty("user.dir") + "//" + foldername + "//" + filename + date + ".txt";

		try {
			return new PrintStream(new FileOutputStream(path));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return null;
	}

}
