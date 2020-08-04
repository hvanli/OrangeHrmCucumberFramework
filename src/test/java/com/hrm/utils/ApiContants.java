package com.hrm.utils;

public class ApiContants {

	public static final String CREATE_USER_URI="166.62.36.207/syntaxapi/api/createUser.php";
	public static final String GENERATE_TOKEN_URI="166.62.36.207/syntaxapi/api/generateToken.php";
	public static final String GET_ALL_EMPLOYEES_URI="166.62.36.207/syntaxapi/api/getAllEmployees.php";
	
	public static final String CREATE_USER_BODY_FILEPATH=System.getProperty("user.dir")+"/src/test/resources/jsonfiles/createUserBody.json";
	public static final String GENERATE_TOKEN_BODY_FILEPATH=System.getProperty("user.dir")+"/src/test/resources/jsonfiles/generateTokenBody.json";

}
