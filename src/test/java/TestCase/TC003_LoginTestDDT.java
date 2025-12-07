package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import PageObject.HomePage;
import PageObject.MyAccountPage;
import Utilities.DataProviders;

public class TC003_LoginTestDDT extends BaseClass {
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verify_loginDDT(String user, String pwd, String exp) {

		logger.info("Starting TC003_LoginTestDDT");
		try {
			HomePage hp = new HomePage(driver);

			hp.setUsername(user);
			hp.setPassword(pwd);
			hp.clickLogin();

			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageDisplayed();
			if (exp.equalsIgnoreCase("Valid")) {
				if (targetPage) {
					logger.info("Login test passed");
					macc.clickLogout();
					Assert.assertTrue(true);
				} else {
					logger.error("Login test failed");
					Assert.assertTrue(false);
				}
			}
			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage) {
					logger.error("Login test failed");
					macc.clickLogout();
					Assert.assertTrue(false);
				} else {
					logger.info("Login test passed");
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			logger.fatal("Login test failed due to exception: " + e.getMessage());
			Assert.fail();
		}
		logger.info("Finished TC003_LoginTestDDT");
	}

}
