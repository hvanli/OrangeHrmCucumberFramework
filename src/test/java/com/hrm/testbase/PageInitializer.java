package com.hrm.testbase;

import com.hrm.pages.AddEmployeePageWebElements;
import com.hrm.pages.DashboardPageWebElements;
import com.hrm.pages.LoginPageWebElements;
import com.hrm.pages.PersonalDetailsPageWebElements;

public class PageInitializer extends BaseClass{

	public static LoginPageWebElements login;
	public static DashboardPageWebElements dBoard;
	public static AddEmployeePageWebElements addEmp;
	public static PersonalDetailsPageWebElements pDetails;
	
	public void initializeAllPages() {
		login=new LoginPageWebElements();
		dBoard=new DashboardPageWebElements();
		addEmp=new AddEmployeePageWebElements();
		pDetails=new PersonalDetailsPageWebElements();
	}
}
