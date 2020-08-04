package com.hrm.Api.steps;

import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.junit.Test;

import com.hrm.utils.ApiContants;
import com.hrm.utils.CommonMethods;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GenerateTokenApiSteps extends CommonMethods {

	private static RequestSpecification request;
	private Response response;
	public static String token;

//	@Given("user generates a token")
	@Test
	public void user_generates_a_token() {

		request=given().header("Content-Type", "application/json");
		
		response=request.body(readJson(ApiContants.GENERATE_TOKEN_BODY_FILEPATH))
				.when().post(ApiContants.GENERATE_TOKEN_URI);
		
		response.prettyPrint();
		
		token= "Bearer "+response.jsonPath().getString("token");
		
		System.out.println(token);

		
		Assert.assertEquals(200, response.getStatusCode());
	}
}
