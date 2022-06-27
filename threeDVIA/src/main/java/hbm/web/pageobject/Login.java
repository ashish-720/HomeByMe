package hbm.web.pageobject;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import kitchen.bryo.pageObject.FloorPlan;
import kitchen.bryo.pageObject.HomeByMeProjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;

	public Login(WebDriver driver) {
		this.driver = driver;
	}
	
	
	@CacheLookup
	@FindBy(css = "article#login>header>p>span")
	WebElement newtoHomeByMeSignup;
		
	@CacheLookup
	@FindBy(css = "article#login>.social-login>.button-social.-facebook")
	WebElement connectWithFacebookButton;

	@CacheLookup
	@FindBy(css = "article#login>.social-login>.button-social.-google")
	WebElement connectWithGoogleButton;
	
	@CacheLookup
	@FindBy(css = "article#login>.social-login>.button-social.-apple")
	WebElement connectWithAppleButton;

	@CacheLookup
	@FindBy(css = "#email_log")
	WebElement userNameTextBox;

	@CacheLookup
	@FindBy(css = "#login_password")
	WebElement passwordTextBox;

	@CacheLookup
	@FindBy(css = "input[type='submit']")
	WebElement loginButton;

	@CacheLookup
	@FindBy(css = "a[type = 'Sign up']")
	WebElement signUp;

	@CacheLookup
	@FindBy(css = ".close-modal button-close")
	WebElement closeButton;

	@CacheLookup
	@FindBy(css = "form>div>p.error-message")
	List<WebElement> invalidCredentialsAlert;

	@CacheLookup
	@FindBy(css = "div.modal.current>a")
	WebElement closeLoginTab;

	@FindBy(css = "#login-form>.input-field>.item-link.link-default")
	private WebElement forgotPwdLink;
	
	@FindBy(css = ".wrapper>aside>#infobox>#confirmtext>header>div>h1")
	private WebElement newMethodMsg;
	
	@FindBy(css = ".wrapper>aside>#infobox>div>.button")
	private WebElement newMethodLoginBtn;

	public Login enterLoginId(String loginId) {
		userNameTextBox.sendKeys(loginId);
		return this;
	}
	
	public Login clearLoginFormFields() {
		userNameTextBox.clear();
		passwordTextBox.clear();
		return this;
	}
	
	public Login enterPassword(String password) {
		passwordTextBox.sendKeys(password);
		return this;
	}

	public UserHomePage clickLOGINButton() {
		loginButton.click();
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public UserHomePage3DByMe clickLOGIN3DByMe() {
		loginButton.click();
		return PageFactory.initElements(driver, UserHomePage3DByMe.class);
	}
	
	public UserHomePage checkLoginSuccess() {
		if(!driver.getCurrentUrl().contains("partner")) {
			UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "html[class=''] .user.u-ptm>h1"));
			UserHomePage homepage = PageFactory.initElements(driver,
					UserHomePage.class);		
			UtilHBM.reportOK("Login success. Username is: "
					+ homepage.welcomeNote.getText().split(" ")[1].split("!")[0]);
		} else {
			UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "html[class=''] .table>.cell>h1"));
		}
		return PageFactory.initElements(driver, UserHomePage.class);
	}

	public ThreeDPlanner clickLOGINButtonTrial() {
		loginButton.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}

	public UserHomePage loginUsingFB(SignUpData signUpData) {
		connectWithFacebookButton.click();
		UtilHBM.waitFixTime(1000);
//		for (String winHandle : driver.getWindowHandles()) {
//			driver.switchTo().window(winHandle);
//		}
		LoginFacebook facebook = PageFactory.initElements(driver,
				LoginFacebook.class);
		facebook.login(signUpData);
		// for (String winHandle: driver.getWindowHandles()){
		// driver.switchTo().window(winHandle);
		// }
//		UserHomePage home = PageFactory
//				.initElements(driver, UserHomePage.class);
//		UtilHBM.waitExplicitDisplayed(driver, home.welcomeLoginId);
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public LoginFacebook connectWithFb() {
		UtilHBM.waitFixTime(1000);
		connectWithFacebookButton.click();		
		return PageFactory.initElements(driver, LoginFacebook.class);
	}
	
	public UserHomePage connectWithFbWithCache() {
		UtilHBM.waitFixTime(1000);
		connectWithFacebookButton.click();		
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public Login connectWithGoogleWithCache() {
		UtilHBM.waitFixTime(1000);
		connectWithGoogleButton.click();		
		return PageFactory.initElements(driver, Login.class);
	}

	public UserHomePage loginUsingGmail(SignUpData signUpData) {
		connectWithGoogleButton.click();
		UtilHBM.waitFixTime(1000);
//		for (String handle : driver.getWindowHandles()) {
//			driver.switchTo().window(handle);
//		}
		LoginGmail gmail = PageFactory.initElements(driver, LoginGmail.class);
		gmail.loginGmailUser(signUpData);
		// for(String handle:driver.getWindowHandles()){
		// driver.switchTo().window(handle);
		// }
//		UserHomePage home = PageFactory
//				.initElements(driver, UserHomePage.class);
//		UtilHBM.waitExplicitDisplayed(driver, home.welcomeLoginId);
		return PageFactory.initElements(driver, UserHomePage.class);
	}

	public UserHomePage login(SignUpData signUpData) {
		enterLoginId(signUpData.getLoginId()).enterPassword(
				signUpData.getPassword()).clickLOGINButton();
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public UserHomePage3DByMe login3DByMe(SignUpData signUpData) {
		return enterLoginId(signUpData.getLoginId()).enterPassword(signUpData.getPassword()).clickLOGIN3DByMe();
	}
	
	public Login loginInvalidUser(SignUpData signUpData) {
		enterLoginId(signUpData.getLoginId()).enterPassword(
				signUpData.getPassword()).clickLOGINButton();
		return PageFactory.initElements(driver, Login.class);
	}

	public ThreeDPlanner loginTrialProject(SignUpData signUpData) {
		return enterLoginId(signUpData.getLoginId()).enterPassword(
				signUpData.getPassword()).clickLOGINButtonTrial();
	}

	public Login checkLoginForInvalidUser(SignUpData signUpData) {
		UtilHBM.waitExplicitDisplayed(driver,invalidCredentialsAlert.get(0));
		if (invalidCredentialsAlert.get(0).getText().contains("Invalid credentials")) {
			UtilHBM.reportOK("Invalid Login test Successful and account deleted for "
					+ signUpData.getLoginId());
		}else {
			UtilHBM.reportKO("Login Successful and account not deleted for "
					+ signUpData.getLoginId());}
		return PageFactory.initElements(driver, Login.class);
	}

	public ForgotPwd forgotPassward() {
		forgotPwdLink.click();
		return PageFactory.initElements(driver, ForgotPwd.class);
	}

	public HomeByMeProjects loginForKitchenHomeByMe(SignUpData signUpData) {
		enterLoginId(signUpData.getLoginId()).enterPassword(
				signUpData.getPassword());
		loginButton.click();
		return PageFactory.initElements(driver, HomeByMeProjects.class);
	}

	public CompleteProfile signUpFromLogin(SignUpData signUpData) {
		UtilHBM.waitExplicitDisplayed(driver, newtoHomeByMeSignup);
		UtilHBM.waitExplicitClickable(driver, newtoHomeByMeSignup);
		newtoHomeByMeSignup.click();
		SignUp signUp = PageFactory.initElements(driver, SignUp.class);
		signUp.enterEmail(signUpData.getLoginId()).enterLoginId(signUpData.getLoginId().split("@")[0])
				.enterRegistrationPassword(signUpData.getPassword()).selectCountry(signUpData.getCountry())
				.acceptTnC().clickSIGNUP();	
//		signUp.enterEmail(signUpData.getLoginId()).enterLoginId(signUpData.getLoginId())
//				.enterRegistrationPassword(signUpData.getPassword()).selectCountry(signUpData.getCountry())
//				.selectYourProfile(signUpData.getYourProfile()).acceptTnC().acceptReceivePromotions().clickSIGNUPMDM();
		return PageFactory.initElements(driver, CompleteProfile.class);
	}
	
	public Login loginNewMethodMsg(){
		Verification.displayNAttributeCheckOfElement(newMethodMsg, "New Method Msg", "text", "New connection method request");
		newMethodLoginBtn.click();
		return PageFactory.initElements(driver, Login.class);
	}

	
	/*---------------------Following methods are used for mobile automation---------------------*/

	public UserHomePage loginMobile(SignUpData signUpData) {
			return enterLoginId(signUpData.getLoginId()).enterPassword(
					signUpData.getPassword()).clickLOGINButton();
		}
	
	public Login signUpFromLoginMobile(SignUpData signUpData) {
		UtilHBM.waitExplicitDisplayed(driver, newtoHomeByMeSignup);
		UtilHBM.waitExplicitClickable(driver, newtoHomeByMeSignup);
		newtoHomeByMeSignup.click();
		return PageFactory.initElements(driver, Login.class);
		}
}
