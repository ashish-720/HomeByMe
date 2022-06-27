package hbm.web.pageobject;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUp {

	WebDriver driver;
	
	public SignUp (WebDriver driver){
		this.driver = driver;
	}
	
	@CacheLookup
	@FindBy(css = "article#register>header>p>span")
	WebElement alreadyHaveAnAccount;
	
	@CacheLookup
	@FindBy(id = "email_reg")
	WebElement emailTextBox;
	
	@CacheLookup
	@FindBy(id = "display_name")
	WebElement userRegistrationUsernameTextBox;
	
	@CacheLookup
	@FindBy(id = "register_password")
	WebElement userRegitrationPasswordTextBox;
	
	@CacheLookup
	@FindBy(id = "user_registration_country")
	WebElement countryDropDown;
	
	@CacheLookup
	@FindBy(css = "label[for='tos']>i")
	WebElement acceptTnC;
	
	@CacheLookup
	@FindBy(css = "label[for='user_social_registration_cgsAccepted']")
	WebElement acceptTnCSocial;
	
	@CacheLookup
	@FindBy(css = "label[for='user_registration_newsletter']")
	WebElement acceptNewsLatter;
	
	@FindBy(css = "label[for='user_social_registration_newsletter']")
	WebElement acceptNewsLatterSocial;
	
	@FindBy(css="article#register>.social-login>.button-social.-google")
	WebElement signUpWithGoogle;
	
	@FindBy(css="article#register>.social-login>.button-social.-facebook")
	WebElement signUpWithFB;
	
	@CacheLookup
	@FindBy(id="user_registration_details_profile_type")
	WebElement yourProfile;
	
	@FindBy(id="user_social_registration_details_profile_type")
	WebElement yourProfileSocialRegistration;
	
	@FindBy(css = "section.form-container>h2")
	WebElement startTheHomeByMeExperience;		
	
	@FindBy(css = "div.modal.current>div>div>form>div.form-item.form-item--link>a[href='#sponsor-code']")
	WebElement sponsorCodeButton;
	
	@FindBy(css = "#sponsor-code>div>label")
	WebElement friendshipCodeLabel;
	
	public SignUp enterLoginId(String loginId){		
		userRegistrationUsernameTextBox.sendKeys(loginId);
		return this;
	}	
	
	public SignUp enterEmail(String emailId){
		emailTextBox.sendKeys(emailId);
		return this;
	}
	
	public SignUp enterUserName (String loginId){
		userRegistrationUsernameTextBox.clear();
		userRegistrationUsernameTextBox.sendKeys(loginId);
		return this;
	}
	
	public SignUp enterRegistrationPassword(String password){
		userRegitrationPasswordTextBox.sendKeys(password);
		return this;
	}
	
	public SignUp selectCountry(String country){
		new Select(countryDropDown).selectByVisibleText(country);		
		return this;
	}
	
	public SignUp acceptTnC (){		
		boolean checkstatus;
		checkstatus = acceptTnC.isSelected();
		if (checkstatus ==true){
			System.out.println("TnC already accepted");						
		} else {
			acceptTnC.click();
		}
		return this;		
	}
	
	public SignUp acceptTnCSocial (){		
		boolean checkstatus;
		checkstatus = acceptTnCSocial.isSelected();
		if (checkstatus ==true){
			System.out.println("TnC already accepted");						
		} else {
			acceptTnCSocial.click();
		}
		return this;		
	}
	
	public SignUp acceptReceivePromotions (){		
		boolean checkstatus;
		checkstatus = acceptNewsLatter.isSelected();
		if (checkstatus ==true){
			System.out.println("TnC already accepted");						
		} else {
			acceptNewsLatter.click();
		}
		return this;		
	}
	
	public SignUp acceptReceivePromotionsSocial (){		
		boolean checkstatus;
		checkstatus = acceptNewsLatterSocial.isSelected();
		if (checkstatus ==true){
			System.out.println("TnC already accepted");						
		} else {
			acceptNewsLatterSocial.click();
		}
		return this;		
	}
	
	public CompleteProfile clickSIGNUP() {
		driver.findElement(By.cssSelector("#signup")).click();		
		UtilHBM.reportOK("New User created.");
		return PageFactory.initElements(driver, CompleteProfile.class);
	}
	
	public ShareDataMDM clickSIGNUPMDM() {
		driver.findElement(By.cssSelector("input[type='submit']")).click();		
		UtilHBM.reportOK("New User created.");
		UtilHBM.waitExplicitClickable(driver, UtilHBM.webElement(driver, ".jquery-modal.blocker[style$='opacity: 0.5;']"));
		UtilHBM.waitExplicitClickable(driver, UtilHBM.webElement(driver, ".profile-initials"));
		return PageFactory.initElements(driver, ShareDataMDM.class);
	}
	
	public CompleteProfile createNewUser (SignUpData signUpData){
		return enterEmail(signUpData.getLoginId()).enterLoginId(signUpData.getLoginId().split("@")[0])
		.enterRegistrationPassword(signUpData.getPassword()).selectCountry(signUpData.getCountry())
//		.selectYourProfile(signUpData.getYourProfile())
		.acceptTnC()
		.clickSIGNUP();		
	}
	
	public Login enterExistingUserEmail(SignUpData signUpData){
		UtilHBM.waitExplicitClickable(driver, emailTextBox);
		enterEmail(signUpData.getLoginId());
		UtilHBM.waitExplicitClickable(driver, userRegitrationPasswordTextBox);
		userRegitrationPasswordTextBox.click();
		return PageFactory.initElements(driver, Login.class); 
	}
	
	public LoginGmail gmailUser(){		
		signUpWithGoogle.click();
		for(String handle:driver.getWindowHandles()){
			driver.switchTo().window(handle);
		}
//		LoginGmail login = PageFactory.initElements(driver, LoginGmail.class);
//		login.loginGmailUser(signUpData);		
////		UtilHBM.waitExplicitDisplayed(driver, yourProfileSocialRegistration);
		return PageFactory.initElements(driver, LoginGmail.class);
	}
	
	public CompleteProfile createFBUser(SignUpData signUpData){		
		signUpWithFB.click();
		for(String handle:driver.getWindowHandles()){
			driver.switchTo().window(handle);
		}
		LoginFacebook login = PageFactory.initElements(driver, LoginFacebook.class);
		login.login(signUpData);		
		return PageFactory.initElements(driver, CompleteProfile.class);
	}
	
	public LoginFacebook facebook(){
		signUpWithFB.click();
		return PageFactory.initElements(driver, LoginFacebook.class);
	}
	
	public UserHomePage loginFromSignUp(SignUpData signUpData){	
		alreadyHaveAnAccount.click();
		Login login = PageFactory.initElements(driver, Login.class);
		login.login(signUpData);	
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public ThreeDPlanner loginTrialProject(SignUpData signUpData){	
		alreadyHaveAnAccount.click();
		Login login = PageFactory.initElements(driver, Login.class);
		login.loginTrialProject(signUpData);		
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	
	/*---------------------Following methods are used for mobile automation---------------------*/
	
	public CompleteProfile signUpMobile (SignUpData signUpData, String rewardCode){
		return enterEmail(signUpData.getEmailId())
				.enterLoginId(signUpData.getLoginId())
				.enterRegistrationPassword(signUpData.getPassword())
				.selectCountry(signUpData.getCountry())
				.clickSIGNUP();		
	}
}
