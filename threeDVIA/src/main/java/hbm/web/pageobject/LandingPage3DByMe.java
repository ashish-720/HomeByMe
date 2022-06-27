package hbm.web.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class LandingPage3DByMe {

	WebDriver driver;

	public LandingPage3DByMe(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "div#landingpage>div>div#login-link")
	WebElement login;

	@FindBy(css = "div#landingpage>div>div.signup")
	WebElement signup;

	@FindBy(css = "div#landingpage>div>div.logo")
	WebElement logo3DByMe;

	@FindBy(css = "div#landingpage>div>div.landingpage-section1>div.section1-title")
	WebElement section1Title;

	@FindBy(css = "div#landingpage>div>div.landingpage-section1>div.section1-subtitle")
	WebElement section1Subtitle;

	@FindBy(css = "div#landingpage>div>div.landingpage-section1>div.section1-trynow>div.trynow-button")
	WebElement tryNow;

	@FindBy(xpath = "//div[@id='loading'][not(@style='display: none;')]")
	List<WebElement> loadingSpinner;

	public LandingPage3DByMe verifyPage() {
		UtilHBM.waitExplicitDisplayed(driver, logo3DByMe);
		Verification.displayOfWebElement(logo3DByMe);
		Verification.VerifyEquals("Wrong 3DByMe landing page title", driver.getTitle(), "Welcome to 3DBYME");
		Verification.VerifyEquals("Wrong section1Title", section1Title.getText(),
				"Imagine making custom DIY furniture!");
		Verification.VerifyEquals("Wrong section1Subtitle", section1Subtitle.getText(),
				"With an easy-to-use experience");
		Verification.VerifyEquals("Wrong tryNow button test displayed", tryNow.getText(), "Try now");
		Verification.displayOfWebElement(tryNow);
		return this;
	}

	public Login clickLogin() {
		UtilHBM.waitExplicitDisplayed(driver, login);
		UtilHBM.waitExplicitClickable(driver, login);
		login.click();
		do {
			UtilHBM.waitFixTime(200);
		} while (!loadingSpinner.isEmpty());
		return PageFactory.initElements(driver, Login.class);
	}

	public SignUp clickSignUp() {
		UtilHBM.waitExplicitDisplayed(driver, signup);
		UtilHBM.waitExplicitClickable(driver, signup);
		signup.click();
		do {
			UtilHBM.waitFixTime(200);
		} while (!loadingSpinner.isEmpty());
		return PageFactory.initElements(driver, SignUp.class);
	}

	public UserProfilePage close3DByMeTab() {
		driver.close();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		return PageFactory.initElements(driver, UserProfilePage.class);
	}

}
