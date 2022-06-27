package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class ConfirmLogout3DByMe {

	WebDriver driver;

	public ConfirmLogout3DByMe(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "article#logout>header>h1")
	private WebElement logoutText1;

	@FindBy(css = "article#logout>header>p")
	private WebElement logoutText2;

	@FindBy(css = "article#logout>button.button")
	private WebElement logoutYes;

	@FindBy(css = "article#logout>button.button--alt")
	private WebElement logoutNo;

	public LandingPage3DByMe confirmLogoutYes() {
		UtilHBM.waitExplicitDisplayed(driver, logoutText1);
		Verification.VerifyEquals("Wrong logoutText1", logoutText1.getText(), "Are you sure you want to logout?");
		Verification.VerifyEquals("Wrong logoutText2", logoutText2.getText(),
				"If you choose to move out, you’re going to be disconnected from all ByMe applications.");
		Verification.VerifyEquals("Wrong logoutYes Text", logoutYes.getText(), "Yes, let's move out");
		Verification.VerifyEquals("Wrong logoutNo Text", logoutNo.getText(), "No, stay signed in");
		UtilHBM.waitExplicitClickable(driver, logoutYes);
		logoutYes.click();
		return PageFactory.initElements(driver, LandingPage3DByMe.class);
	}

	public UserHomePage3DByMe confirmLogoutNo() {
		UtilHBM.waitExplicitDisplayed(driver, logoutText1);
		UtilHBM.waitExplicitClickable(driver, logoutNo);
		logoutNo.click();
		return PageFactory.initElements(driver, UserHomePage3DByMe.class);
	}
}
