package com.hrm.steps;


import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrm.utils.CommonMethods;
import com.hrm.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonMethods{

	@Given("I enter valid username")
	public void i_enter_valid_username() {
		sendText(login.userName, ConfigsReader.getProperty("username"));
	}

	@Given("I enter valid password")
	public void i_enter_valid_password() {
		sendText(login.password, ConfigsReader.getProperty("password"));
	}

	@When("I click login button")
	public void i_click_login_button() {
		jsClick(login.loginBtn);
	}

	@Then("I succussfully login Orange HRM")
	public void i_succussfully_login_Orange_HRM() {
		boolean isLogoDisplayed=dBoard.orangeHrmLogo.isDisplayed();
		Assert.assertTrue(isLogoDisplayed);
	}
	
	@Given("I enter username {string}")
	public void i_enter_username(String string) {
		sendText(login.userName, string);
	}

	@Given("I enter password {string}")
	public void i_enter_password(String string) {
		sendText(login.password, string);
	}

	@Then("I see {string}")
	public void i_see(String string) {
		String actuErrMsg=login.errMsg.getText();
		
		Assert.assertEquals("Error message mismatch", string, actuErrMsg);
	}
	
	@Given("I enter username {string} and password {string}")
	public void i_enter_username_and_password(String string, String string2) {

		sendText(login.userName, string);
		sendText(login.password, string2);
	}
	
	@When("I enter username and password I see error message")
	public void i_enter_username_and_password_I_see_error_message(io.cucumber.datatable.DataTable credentials) {
		
		List<Map<String, String>> maps=credentials.asMaps();
		
		for(Map<String, String> map:maps) {
			sendText(login.userName, map.get("username"));
			sendText(login.password, map.get("password"));
			
			click(login.loginBtn);
			String actErrMsg=login.errMsg.getText();
			String expErrMsg=map.get("errorMsg");
			
			Assert.assertEquals("Error message mismatch", expErrMsg, actErrMsg);			
		}
	}
	
	@When("I enter username and password I see error message without header")
	public void i_enter_username_and_password_I_see_error_message_without_header(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		
		List<List<String>> lists=dataTable.asLists();
		
		for(List<String> list:lists) {
			sendText(login.userName, list.get(0));
			Thread.sleep(1000);
			sendText(login.password, list.get(1));
			Thread.sleep(1000);
			click(login.loginBtn);
			Thread.sleep(1000);
			
			String actErrMsg=login.errMsg.getText();
			String expErrMsg=list.get(2);
			Assert.assertEquals("Error message mismatch", expErrMsg, actErrMsg);
		}
	}
}
