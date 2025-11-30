package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	WebDriver driver;

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement txtLogin;

	@FindBy(xpath = "//input[@id='firstName']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='lastName']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='confirmPassword']")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//button[normalize-space()='Register']")
	WebElement btnRegister;

	@FindBy(xpath = "//div[@class='result alert alert-success']")
	WebElement msgConfirmation;

	public void setLogin(String login) {
		txtLogin.sendKeys(login);
	}

	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void setConfirmPassword(String password) {
		txtConfirmPassword.sendKeys(password);
	}

	public void clickRegister() {
		btnRegister.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return msgConfirmation.getText();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
