package practice;

import org.junit.Test;

import com.hrm.utils.ApiContants;
import com.hrm.utils.CommonMethods;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUser extends CommonMethods{
	
	private static Response response;
	private static RequestSpecification request;

	@Test
	public void createUser() {
		request=given().header("Content-Type", "application/json");
		

		response=request.body(ApiContants.CREATE_USER_BODY_FILEPATH).when().post(ApiContants.CREATE_USER_URI);
		
		response.prettyPrint();
	}
}
