package hr.web.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.UtilHBM;
import hr.planner.pageObject.HomePlanner;

public class Login {

	WebDriver driver;

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//body[@class='homepage']/div/div//main//article/div//div/fieldset/p/input[@id='input-login-name']")
	private WebElement userName;

	@FindBy(xpath = "//body[@class='homepage']/div/div//main//article/div//div/fieldset/p/input[@id='input-login-password']")
	private WebElement userPassword;

	@FindBy(xpath = "//body[@class='homepage']/div/div//main//article/div//footer/button/span")
	private WebElement login;

	protected LandingPageHR login(SignUpData signUpData) {
	enterUserName(signUpData.getLoginId())
	.enterPassword(signUpData.getPassword())
	.clickLogin();
	return PageFactory.initElements(driver, LandingPageHR.class);
	}
	
	public HomePlanner loginInPlanner(SignUpData signUpData) {
	enterUserName(signUpData.getLoginId())
	.enterPassword(signUpData.getPassword())
	.clickLogin();
	driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src*='https://preprod-home.enterprise-dev.by.me/Planner']"));
	return PageFactory.initElements(driver, HomePlanner.class);
	}
	
	private Login enterUserName(String loginId) {
		userName.clear();
		userName.sendKeys(loginId);
		return this;
	}

	private Login enterPassword(String password) {
		userPassword.clear();
		userPassword.sendKeys(password);
		return this;
	}

	private LandingPageHR clickLogin() {

		login.click();
		
		return PageFactory.initElements(driver, LandingPageHR.class);
	}

		
	
}
