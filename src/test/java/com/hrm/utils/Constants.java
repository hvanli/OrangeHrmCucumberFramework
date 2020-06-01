package com.hrm.utils;

public class Constants {
	// Since we saved url and browser inside credential.properties file, we do not need to store them inside 
	// Constants class
//	public static final String ORANGEHRM_URL="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
//	public static final String BROWSER="chrome";
	
	public static final String CHROME_DRIVER_FILEPATH=System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver.exe";
	public static final String GECKO_DRIVER_FILEPATH=System.getProperty("user.dir")+"/src/test/resources/drivers/geckodriver.exe";

	public static final int PAGE_LOAD_TIMEOUT=40;
	public static final int IMPLICIT_WAIT_TIME=20;
	public static final int EXPLICIT_WAIT_TIME=30;
	
	public static final String SCREENSHOTS_FILEPATH=System.getProperty("user.dir")+"/target/screenshots/";
	
	public static final String CREDENTIALS_FILEPATH=System.getProperty("user.dir")+"/src/test/resources/configs/Credential.properties";
			
	public static final String TEST_DATA_FILEPATH=System.getProperty("user.dir")+"/src/test/resources/testdata/TestData.xlsx";

	public static final String REPORT_FILEPATH=System.getProperty("user.dir")+"/target/report/Hrms.html";
	
	public static final String OS_NAME=System.getProperty("os.name");
	
	public static final String USER_NAME=System.getProperty("user.name");
	
	public static final String BROWSER=ConfigsReader.getProperty("browser");
}
