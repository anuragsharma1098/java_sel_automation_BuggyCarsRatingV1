package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	// Constructor
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logoutLink;

	// Methods
	public boolean isMyAccountPageDisplayed() {
		try {
			return logoutLink.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
