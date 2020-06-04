package com.hrm.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import com.hrm.pages.LoginPageWebElements;
import com.hrm.utils.CommonMethods;
import com.hrm.utils.Constants;
import com.hrm.utils.ExcelUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeSteps extends CommonMethods{
	
	@Given("I logged in Orange HRM")
	public void i_logged_in_Orange_HRM() {
		LoginPageWebElements.login();
	}

	@When("I navigated to Add Employee page")
	public void i_navigated_to_Add_Employee_page() {
		Actions action=new Actions(driver);
		action.moveToElement(dBoard.PimBtn).perform();
		action.moveToElement(dBoard.addEmpBtn).click().perform();
	}

//	@Then("I enter employee information from excel file and save employee successfully")
//	public void i_enter_employee_information_from_excel_file_and_save_employee_successfully() throws InterruptedException {
//
//		List<ArrayList<String>> dataSet=ExcelUtility.excelIntoListOfList(Constants.TEST_DATA_FILEPATH, "addEmp");
//		
//		for(ArrayList<String> data:dataSet){
//			
//			Thread.sleep(4000);
//			click(addEmp.createLoginDetailsBtn);
//			
//			sendText(addEmp.firstName, data.get(0));
//			sendText(addEmp.middleName, data.get(1));
//			sendText(addEmp.lastName, data.get(2));
//			
//			String expEmpId=addEmp.empId.getAttribute("value");
//			
//			
//			sendText(addEmp.userName, data.get(3));
//			sendText(addEmp.password, data.get(4));
//			sendText(addEmp.confirmPassword, data.get(4));
//			
//			click(addEmp.saveBtn);
//			
//			String actEmpId=pDetails.empId.getAttribute("value");
//			
//			Assert.assertEquals("EmpId Mismatch", expEmpId, actEmpId);
//			
//			Actions action=new Actions(driver);
//			action.moveToElement(pDetails.PimBtn).perform();
//			action.moveToElement(pDetails.addEmpBtn).click().perform();
//			
//			Thread.sleep(4000);
//		}
//	}
	
	@Then("I enter employee information from excel file and save employee successfully")
	public void i_enter_employee_information_from_excel_file_and_save_employee_successfully() throws InterruptedException {

		List<Map<String, String>> dataSet=ExcelUtility.excelIntoListOfMaps(Constants.TEST_DATA_FILEPATH, "addEmp");
		
		for(Map<String, String> data:dataSet) {
			Thread.sleep(4000);
			
			sendText(addEmp.firstName, data.get("firstName"));
			sendText(addEmp.middleName, data.get("middleName"));
			sendText(addEmp.lastName, data.get("lastName"));
			
			String expEmpId=addEmp.empId.getAttribute("value");
			click(addEmp.createLoginDetailsBtn);
			
			sendText(addEmp.userName, data.get("userName"));
			sendText(addEmp.password, data.get("password"));
			sendText(addEmp.confirmPassword, data.get("password"));
			
			click(addEmp.saveBtn);
			String actEmpId=pDetails.empId.getAttribute("value");
			Assert.assertEquals("EmpId Mismatch", expEmpId, actEmpId);
			
			Actions action=new Actions(driver);
			action.moveToElement(pDetails.PimBtn).perform();
			action.moveToElement(pDetails.addEmpBtn).click().perform();
			
			Thread.sleep(4000);
		}
	}
}


