package hbm.web.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class DraftSightEmbed {

	WebDriver driver;

	public DraftSightEmbed(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "body>#app>div>header>div>img[src='https://d31ax5swi3lxrl.cloudfront.net/dist/images/logotype-hbm.0dae6526cae0bf44172868a62138ae17.svg']")
	private WebElement hbmLogo;

	@FindBy(css = "#email_log")
	WebElement loginId;

	@FindBy(css = "#login_password")
	private WebElement password;

	@FindBy(css = "#login-form>.input-field>.item-link.link-default")
	private WebElement forgotPwdLink;

	@FindBy(css = "input[type='submit']")
	private WebElement loginButton;

	@FindBy(css = "article#login>.social-login>.button-social.-facebook")
	private WebElement facebook;

	@FindBy(css = "#app>section>main>.wrapper>.form-container>.u-mtl>.social-connections.flex.flex-center>a[href$='google']")
	private WebElement google;

	@FindBy(css = "#app>section>main>.wrapper>.form-container>.u-mtl.u-pbs.u-txtCenter>a[title='Sign up']")
	private WebElement signUp;

	@FindBy(css = "#sendpassword>header>h1")
	private WebElement forgotPwdTitle;

	@FindBy(css = "#sendpassword>header>p")
	private WebElement forgotPwdText;

	@FindBy(css = "#forgotpwd-form>.input-field>#pwd_email")
	private WebElement forgotPwdEmailInputBox;

	@FindBy(css = "#forgotpwd-form>.input-field.form-button>input#forgotPwd")
	private WebElement forgotPwdSendBtn;

	@FindBy(css = "#sendpassword>header>h1>i.icon-chevron-left")
	private WebElement backToLoginLink;

	@FindBy(css = "div.wrapper>section.form-container.hbm-connect-container>article.u-mtl>p.hbm-connect-description")
	private WebElement hbmConnectLoginText;

	@FindBy(css = "div.wrapper>section.form-container.hbm-connect-container>article.u-mtl>a#login-embed-button")
	private WebElement hbmConnectLoginButton;

	public DraftSightProject loginExitingUser(SignUpData signUpData) {
		UtilHBM.waitExplicitDisplayed(driver, loginId);
		loginId.sendKeys(signUpData.getLoginId());
		password.sendKeys(signUpData.getPassword());
		loginButton.click();
		for (String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}
		return PageFactory.initElements(driver, DraftSightProject.class);
	}

	public DraftSightEmbed clickHBMConnectLoginButton() {
		try {
			driver.findElement(By.cssSelector("#footer_tc_privacy_button_3")).click();
		} catch (Exception e) {
			UtilHBM.reportWarning("Accept cookies message not displayed");
			System.out.println("Accept cookies message not displayed");
		}
		UtilHBM.waitExplicitDisplayed(driver, hbmConnectLoginText);
		Verification.VerifyEquals("Wrong hbmConnectLoginText!!", hbmConnectLoginText.getText(),
				"Please login to your HomeByMe account by clicking on the \"Login\" button below.");
		UtilHBM.waitExplicitDisplayed(driver, hbmConnectLoginButton);
		UtilHBM.waitExplicitClickable(driver, hbmConnectLoginButton);
		hbmConnectLoginButton.click();
		
		UtilHBM.waitFixTime(1000);
		for (String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}
		return PageFactory.initElements(driver, DraftSightEmbed.class);
	}

	public DraftSightProject loginFB(SignUpData signUpData) {
		facebook.click();
		LoginFacebook fb = PageFactory.initElements(driver, LoginFacebook.class);
		fb.login(signUpData);
		return PageFactory.initElements(driver, DraftSightProject.class);
	}

	public DraftSightProject loginGoogle(SignUpData signUpData) {
		google.click();
		LoginGmail google = PageFactory.initElements(driver, LoginGmail.class);
		google.loginGmailUser(signUpData);
		return PageFactory.initElements(driver, DraftSightProject.class);
	}

	public DraftSightEmbed checkForgotPwdPage() {
		clickForgotPwdLink();
		UtilHBM.waitExplicitDisplayed(driver, forgotPwdSendBtn);
		Verification.displayNAttributeCheckOfElement(forgotPwdTitle, "Forgot Page Title", "Text",
				"Reset your password");
		Verification.displayOfWebElement(forgotPwdText);
		UtilHBM.waitExplicitClickable(driver, forgotPwdEmailInputBox);
		forgotPwdEmailInputBox.sendKeys("test@test.com");
		Verification.displayNAttributeCheckOfElement(forgotPwdEmailInputBox, "email input box", "value",
				"test@test.com");
		Verification.displayOfWebElement(forgotPwdSendBtn);
		clickBackToLogin();
		UtilHBM.waitExplicitDisplayed(driver, facebook);
		return this;
	}

	public DraftSightEmbed clickForgotPwdLink() {
		UtilHBM.waitExplicitDisplayed(driver, forgotPwdLink);
		UtilHBM.waitExplicitClickable(driver, forgotPwdLink);
		forgotPwdLink.click();
		return PageFactory.initElements(driver, DraftSightEmbed.class);
	}

	public DraftSightEmbed clickBackToLogin() {
		backToLoginLink.click();
		return PageFactory.initElements(driver, DraftSightEmbed.class);
	}

	public DraftSightEmbed verifyLogout() {
		UtilHBM.waitFixTime(1000);
		for (String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}
		UtilHBM.waitExplicitClickable(driver, hbmConnectLoginButton);
		Verification.displayOfWebElement(hbmConnectLoginButton);
		UtilHBM.reportOK("Log out success!!");
		return PageFactory.initElements(driver, DraftSightEmbed.class);
	}

}
