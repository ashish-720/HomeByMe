package hbm.web.pageobject;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPwd {
	
	WebDriver driver;
	
	public ForgotPwd(WebDriver driver){
		this.driver=driver;
	}
	
	@CacheLookup
	@FindBy(css="#sendpassword>#forgotpwd-form>.input-field>#pwd_email")
	private WebElement emailInputBox;
	
	@CacheLookup
	@FindBy(css="#sendpassword>#forgotpwd-form>.input-field.form-button>#forgotPwd")
	private WebElement sendButton;
	
	@FindBy(css="#forgotpassword>#confirmpassword>header>p")
	private WebElement confirmationMsg;
	
	@FindBy(css="#forgotpassword>#confirmpassword>header>h1")
	private WebElement confirmationMsgThankYou;
	
	@FindBy(css="#forgotpassword>#confirmpassword>div>.button")
	private WebElement loginBtn;
	
	
	public Login sendLinkResetPwd(SignUpData signUpData){
		UtilHBM.waitExplicitDisplayed(driver, emailInputBox);
//		emailInputBox.clear();
		emailInputBox.sendKeys(signUpData.getEmailId());
		sendButton.click();
		UtilHBM.waitExplicitDisplayed(driver, confirmationMsg);
		Verification.verifyText(confirmationMsg, "An email with a link to reset your password was sent to your email.", "Reset Pwd link sent confirmation");
		Verification.displayNAttributeCheckOfElement(confirmationMsgThankYou, "Thank you msg in reset pwd", "text", "Thank you!");
		loginBtn.click();
		return PageFactory.initElements(driver, Login.class);
	}
	

}
