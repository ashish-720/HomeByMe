package kitchen.threeDCloudByMe.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.UtilHBM;
import hbm.web.pageobject.Login;
import hbm.web.pageobject.UserHomePage;


public class Login3DCloudByMe {
	
	WebDriver driver;
	
	public Login3DCloudByMe(WebDriver driver) {
		 this.driver=driver;
	}
	
	@CacheLookup
	@FindBy(css=".form-group>#username")
	WebElement username;
	
	@CacheLookup
	@FindBy(css=".form-group>#password")
	WebElement pwd;
	
	@CacheLookup
	@FindBy(id="_submit")
	WebElement submit;
	
	@CacheLookup
	@FindBy(css = "#email_log")
	WebElement userNameTextBox;

	@CacheLookup
	@FindBy(css = "#login_password")
	WebElement passwordTextBox;

	@CacheLookup
	@FindBy(css = "input[type='submit']")
	WebElement loginButton;

	public Content login(SignUpData signUpData) {
		enterLoginId(signUpData.getLoginId()).enterPassword(
				signUpData.getPassword()).clickLOGINButton();
		return PageFactory.initElements(driver, Content.class);
//		if (driver.getCurrentUrl().contains("openid"))
//			openIdLogin(signUpData);
//		else {
//			username.sendKeys(signUpData.getLoginId());
//			pwd.sendKeys(signUpData.getPassword());
//			submit.click();
//		}
//		return PageFactory.initElements(driver, Content.class);
	}
	
	public Login3DCloudByMe verifyLogout()
	{
		UtilHBM.waitExplicitDisplayed(driver, loginButton);
		UtilHBM.reportOK("Successfully logged out");
		return this;
	}
	
	public Login3DCloudByMe enterLoginId(String loginId) {
		userNameTextBox.sendKeys(loginId);
		return this;
	}
	
	public Login3DCloudByMe enterPassword(String password) {
		passwordTextBox.sendKeys(password);
		return this;
	}

	public UserHomePage clickLOGINButton() {
		loginButton.click();
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public Content openIdLogin(SignUpData signUpData) {
		enterLoginId(signUpData.getLoginId()).enterPassword(
				signUpData.getPassword()).clickLOGINButton();
		return PageFactory.initElements(driver, Content.class);
	}
}
