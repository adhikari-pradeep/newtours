package com.qa.newtours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.newtours.utils.Constants;
import com.qa.newtours.utils.ElementUtil;

import io.qameta.allure.Step;

public class RegisterPage {

	private WebDriver driver;
	ElementUtil elementUtil;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}
	
	//By locators or Object repository 
	
	private By Firstname = By.name("firstName");
	private By Lastname = By.name("lastName");
	private By Phone = By.name("phone");
	private By EmailId = By.name("userName");
	private By Address = By.name("address1");
	private By City = By.name("city");
	private By State = By.name("state");
	private By ZipCode = By.name("postalCode");
	private By Country = By.name("country");
	private By UserID = By.name("email");
	private By Password = By.name("password");
	private By ConfirmPassword = By.name("confirmPassword");
	private By Submit = By.name("submit");
	private By RegistrationMessage = By.xpath("//b[contains(text(),'Note: Your user name')]");
	
	
	//Page Actions
	
	
	@Step("new user is registering")
	public void createNewUser(String firstname, String lastname, String phone, String email, String address, String city, String state, String zipcode,
								String country, String username, String password, String confirmPassword) {
		
		elementUtil.doSendKeys(Firstname, firstname);
		elementUtil.doSendKeys(Lastname, lastname);
		elementUtil.doSendKeys(Phone, phone);
		elementUtil.doSendKeys(EmailId, email);
		elementUtil.doSendKeys(Address, address);
		elementUtil.doSendKeys(City, city);
		elementUtil.doSendKeys(State, state);
		elementUtil.doSendKeys(ZipCode, zipcode);
		
		elementUtil.selectDropDownValueByVisibleText(Country, country);
		
		elementUtil.doSendKeys(UserID, username);
		elementUtil.doSendKeys(Password, password);
		elementUtil.doSendKeys(ConfirmPassword, confirmPassword);
		elementUtil.doClick(Submit);
		
	}
	
	@Step("User Registration message validation")
	public String verifyRegistration() {
		return elementUtil.doGetText(RegistrationMessage);
		
	}
	
}
