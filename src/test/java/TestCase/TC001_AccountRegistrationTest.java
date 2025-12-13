package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AccountRegistrationPage;
import PageObject.HomePage;
import TestBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	@Test(groups = { "regression", "master" })
	public void verifyRegistration() {
		logger.info("***** Started TC001_AccountRegistrationTest *****");
		try {
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
		} catch (Exception e) {
			logger.error("Error occurred during registration: " + e.getMessage());
			logger.debug("Error details: ", e.getMessage());
			Assert.fail("Test case failed due to exception: " + e.getMessage());
		}
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
	}
}
