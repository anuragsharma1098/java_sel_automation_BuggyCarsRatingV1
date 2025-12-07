package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import PageObject.HomePage;
import PageObject.MyAccountPage;

public class TC002_LoginTest extends BaseClass {
	@Test
	public void verifyLogin() {
		logger.info("***** Starting TC002_LoginTest *****");
		try {
			// Code to verify login functionality
			HomePage homePage = new HomePage(driver);

			homePage.setUsername(configProp.getProperty("username"));
			homePage.setPassword(configProp.getProperty("password"));
			homePage.clickLogin();
			logger.info("Clicked on Login button");

			// MyAccount page object
			MyAccountPage myAccountPage = new MyAccountPage(driver);
			boolean targetPage = myAccountPage.isMyAccountPageDisplayed();
			Assert.assertTrue(targetPage, "Login failed - My Account page not displayed");
		} catch (Exception e) {
			logger.error("Error occurred during login: " + e.getMessage());
			logger.debug("Error details: ", e.getMessage());
			Assert.fail("Test case failed due to exception: " + e.getMessage());
		}

		logger.info("***** Finished TC002_LoginTest *****");
	}
}
