package com.qa.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.newtours.base.BasePage;
import com.qa.newtours.utils.Constants;
import com.qa.newtours.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage{

	private WebDriver driver;
	ElementUtil elementUtil;
	
	
	//By locators or Object repository 
	
	private By emailId = By.name("userName");
	private By password = By.name("password");
	private By submitBtn = By.name("submit");
	private By signUpLink = By.linkText("REGISTER");
	  
	
	//constructor
	public LoginPage(WebDriver driver) {
//		elementUtil = new ElementUtil(driver);
		this.driver = driver;
		elementUtil=  new ElementUtil(driver);
	}
	
	
	//Page Actions
		@Step("getting login page title")
		public String getLoginPageTitle() {
//			return driver.getTitle();
			return elementUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);
		}
		
		@Step("getting sign up link exist on login page")
		public boolean isSignUpLinkExist() {
			//return driver.findElement(signUpLink).isDisplayed();
			return elementUtil.doDoIsDisplayed(signUpLink);
		}
		
		@Step("user login with username : {0} and password : {1}")
		public HomePage doLogin(String un, String pwd) {
			
			System.out.println("Login to app.....");
//			driver.findElement(emailId).sendKeys(un);
//			driver.findElement(password).sendKeys(pwd);
//			driver.findElement(loginButton).click();
			elementUtil.doSendKeys(emailId, un);
			elementUtil.doSendKeys(password, pwd);
			elementUtil.doClick(submitBtn);
			
			return new HomePage(driver);

	
		}
}
