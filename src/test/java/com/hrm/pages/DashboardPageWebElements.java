package com.hrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.testbase.BaseClass;

public class DashboardPageWebElements extends BaseClass{

	/* 
	 @FindBy(id="")
	 @FindBy(name="")
	 @FindBy(className="")
	 @FindBy(xpath="")
	 
	 Locators used with the @FindBy annotations:
		className
		css
		name
		xpath
		tagName
		linkText
		partialLinkText
 */
	@FindBy(xpath="//div[@id='branding']/a/img")
	public WebElement orangeHrmLogo;
	
	@FindBy(id="menu_pim_viewPimModule")
	public WebElement PimBtn;
	
	@FindBy(id="menu_pim_addEmployee")
	public WebElement addEmpBtn;
	
	public DashboardPageWebElements() {
		PageFactory.initElements(driver, this);
	}
}
