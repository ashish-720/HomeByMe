package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.UtilHBM;

public class ResetForgotPwd {

	WebDriver driver;

	public ResetForgotPwd(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "pwd")
	private WebElement forgotPwdFirstInputBox;

	@FindBy(id = "pwd2")
	private WebElement forgotPwdSecondInputBox;

	@FindBy(css = ".input-field.form-button>#change_pwd")
	private WebElement submitBtn;

//	verify reset password of user from link opened from gmail
	public UserHomePage resetForgotPwd(SignUpData signUpData) {
		UtilHBM.waitExplicitDisplayed(driver, forgotPwdFirstInputBox);
		forgotPwdFirstInputBox.clear();
		forgotPwdFirstInputBox.sendKeys(signUpData.getPassword());
		forgotPwdSecondInputBox.clear();
		forgotPwdSecondInputBox.sendKeys(signUpData.getPassword());
		submitBtn.click();		
		return PageFactory.initElements(driver, UserHomePage.class);
	}
}
