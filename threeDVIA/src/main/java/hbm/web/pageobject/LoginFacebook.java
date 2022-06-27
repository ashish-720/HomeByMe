package hbm.web.pageobject;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.UtilHBM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFacebook {
	
	WebDriver driver;
	
	public LoginFacebook(WebDriver driver){
		this.driver = driver;
	}
	
	@CacheLookup
	@FindBy(tagName = "title")
	WebElement pageTitle;
	
	@CacheLookup
	@FindBy(id = "homelink")
	WebElement facebookLogo;
	
	@CacheLookup
	@FindBy(id = "email")
	WebElement emailInputBox;
	
	@CacheLookup
	@FindBy(id = "pass")
	WebElement passwordInputBox;
	
	@CacheLookup
	@FindBy(name = "login")
	WebElement loginButton;
	
	@CacheLookup
	@FindBy(name = "cancel")
	WebElement cancelButton;
	
	
	public LoginFacebook enterEmailId(String fBEmailId){
		emailInputBox.click();
		emailInputBox.clear();		
		emailInputBox.sendKeys(fBEmailId);
		return this;
	}
	
	public LoginFacebook enterPassword (String fBPassword){
		passwordInputBox.click();
		passwordInputBox.clear();
		passwordInputBox.sendKeys(fBPassword);
		return this;	
	}
	
	public UserHomePage clickLogin(){
		String handle = driver.getWindowHandle();
		loginButton.click();
		UtilHBM.reportOK("Login using Facebook credential done");
		for(String handle1:driver.getWindowHandles()){
			if(!handle1.equalsIgnoreCase(handle)){
				driver.switchTo().window(handle1);
			}			
		}
//		UtilHBM.waitFixTime(3000);		
		return PageFactory.initElements(driver, UserHomePage.class);
	}	
	
	public UserHomePage login(SignUpData signUpData){
		return enterEmailId(signUpData.getfBEmailId()).enterPassword(signUpData.getfBPassword()).clickLogin();
	}
		
	public Login loginNewMethod(SignUpData signUpData){
		enterEmailId(signUpData.getfBEmailId())
		.enterPassword(signUpData.getfBPassword())
		.clickLogin();
		return PageFactory.initElements(driver, Login.class);
	}	

}
