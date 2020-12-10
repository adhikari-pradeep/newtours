package com.qa.newtours.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.newtours.utils.Constants;
import com.qa.newtours.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class RegisterPageTest extends BaseTest{
	
	
	@BeforeClass
	public void registratioPAgeSetup() {
		registerPage = loginPage.doClickRegister();
	}
	
	
	@Severity(SeverityLevel.NORMAL)
	@Description("this method is responsipble about new user registration")
	@Test(priority = 1)
	
	public void userRegistrationTest() {
		
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
