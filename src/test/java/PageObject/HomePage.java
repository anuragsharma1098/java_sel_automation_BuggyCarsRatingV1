package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkRegister;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement lnkLogin;

	@FindBy(xpath = "//input[@name='login']")
	WebElement txtUsername;

	@FindBy(xpath = "//input[@name='password']")
	WebElement txtPassword;

	public void clickRegister() {
		lnkRegister.click();
	}

	public void clickLogin() {
		lnkLogin.click();
	}

	public void setUsername(String username) {
		txtUsername.sendKeys(username);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
}
