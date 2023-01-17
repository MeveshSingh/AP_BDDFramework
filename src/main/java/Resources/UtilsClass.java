package Resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class UtilsClass {

	public static String convertJavaToJson(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}
		return json;
	}
	
	
	public static String captureValueFromRespBody(Response resp ,String key)
	{
		return resp.getBody().jsonPath().getString(key);	
	}
	
	

}
