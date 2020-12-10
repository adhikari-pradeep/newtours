package com.qa.newtours.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.newtours.pages.ContactsPage;
import com.qa.newtours.pages.HomePage;
import com.qa.newtours.pages.LoginPage;


public class BaseTest {
	
	WebDriver driver;
	public Properties prop;
	public BasePage basePage;
	public LoginPage loginPage;
	public HomePage homePage;
	public ContactsPage contactsPage;
	
	
	@Parameters("browser")
	@BeforeTest
	public void setUp(String browserName) {
		System.out.println("browserName is : " +browserName);
		basePage = new BasePage();
		prop = basePage.init_prop();
		prop.setProperty("browser", browserName);
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);

	}
	

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
