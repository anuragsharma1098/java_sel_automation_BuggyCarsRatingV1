package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AccountRegistrationPage;
import PageObject.HomePage;
import TestBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	@Test
	public void verifyRegistration() {
		// Code to verify account registration
		HomePage homePage = new HomePage(driver);
		homePage.clickRegister();

		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);

		// regPage.setLogin("johndoe123");
		regPage.setLogin(randomString());

		// regPage.setFirstName("John");
		regPage.setFirstName(randomString().toUpperCase());

		// regPage.setLastName("Doe");
		regPage.setLastName(randomString().toUpperCase());

		String pwd = randomAlphaNumeric();
		regPage.setPassword(pwd);
		regPage.setConfirmPassword(pwd);

		regPage.clickRegister();

		String confmsg = regPage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Registration is successful");
	}
}
