package com.qa.newtours.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.newtours.utils.Constants;
import com.qa.newtours.base.BaseTest;
import com.qa.newtours.listeners.TestAllureListener;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Listeners(TestAllureListener.class)
@Epic ("EPIC-100 design registration page module for newtours application")
@Story("US-101: desin all features of registration page - new user registration module, registration successful message verification")

public class RegisterPageTest extends BaseTest{
	
	
//	@BeforeClass
//	public void registratioPAgeSetup() {
//		registerPage = loginPage.doClickRegister();
//	}
	
	
	@Severity(SeverityLevel.NORMAL)
	@Description("this method is responsipble about new user registration")
	@Test(priority = 1)
	
	public void userRegistrationTest() {
		registerPage = loginPage.doClickRegister();
		registerPage.createNewUser("bems", "id", "7778946541", "bemsid@noemail.com", "123 okc st", "OKC", "OK", "71000", "UNITED STATES", "bemsid", "bemsid", "bemsid");
		
	}

	@Severity(SeverityLevel.NORMAL)
	@Description("this method is responsipble about title verify successfull registration message")
	@Test(priority = 2)
	
	public void registrationMessage() {
		String ActualMessage = registerPage.verifyRegistration();
		Assert.assertEquals(ActualMessage, Constants.USER_REGISTRATION_MESSAGE);
	}
	
}
