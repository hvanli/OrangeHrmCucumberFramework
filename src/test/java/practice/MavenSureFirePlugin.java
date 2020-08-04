package practice;

public class MavenSureFirePlugin {

	/* 1. How to run our test from pom.xml file and from command line
	  2. Cucumber Report
	  3. How to run our failed tests
	  
	  Why do we need SureFirePlugin
		1. To run test cases from pom.xml file
		2. To run test cases from command line
		
	Steps to run testCases from command line (Sure Fire Plugin)
	
	1. Include maven-surefire-plugin into pom.xml.file
	2. Add configuration tag to plugin and include name of runner you want to execute
	3. Select jdk library from java library
	4. Include Feature files to Runner class
	5. right click in the page and Click Run Configuration
		Goals---> surefire:test
		Click build
	6. Right click-Run-Maven Clean
	7. Right Click-Run-Maven Test
	
	- How to te run our test from command line
		- open cmd promtp or gitBash
		- navigate to project folder
		- mvn clean
		-mvn test 


	2. How to include Cucumber Report to our project
		1. include maven-cucumber-reporting plugin into pom.xml file
		2. make necessary modifications inside plugin
			-<phase>varify</phase>  ----> <phase>test</phase>
			-modify project name --->  <projectName>OrangeHrmCucumberFramework</projectName>
			- delete optinal lines
			
		3. Include cucumber reporting inside our Runner.java file
		3. Run our test from pom.xml file or from command line
		
	 *  */
}
