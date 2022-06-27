package hbm.planner.pageobject;

import hbm.planner.dataobject.SignUpData;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OldSignUp {

WebDriver driver;
	
	public OldSignUp (WebDriver driver){
		this.driver = driver;
	}
		
	public OldSignUp enterLoginId(String loginId){
		driver.findElement(By.id("username")).sendKeys(loginId);
		return this;
	}
	
	public OldSignUp enterPassword (String password){
		driver.findElement(By.id("password")).sendKeys(password);
		return this;				
	}
	
	public UserHomePage clickLOGIN (){
		//driver.findElement(By.linkText("LOG IN")).click();
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		return new UserHomePage(driver);
	}
	
	public UserHomePage login (SignUpData signUpData){		
		driver.findElement(By.linkText("SIGN UP")).click();
		driver.findElement(By.linkText("Already have an account? Log in")).click();				
		return enterLoginId(signUpData.getLoginId()).
				enterPassword(signUpData.getPassword()).clickLOGIN();
	}
	
	public OldSignUp enterEmail(String emailId){
		driver.findElement(By.id("user_registration_email")).sendKeys(emailId);
		return this;
	}
	
	public OldSignUp enterUserName (String loginId){
		driver.findElement(By.id("user_registration_username")).clear();
		driver.findElement(By.id("user_registration_username")).sendKeys(loginId);
		return this;
	}
	
	public OldSignUp enterRegistrationPassword(String password){
		driver.findElement(By.id("user_registration_password")).sendKeys(password);
		return this;
	}
	
	public OldSignUp selectCountry(String country){
		new Select(driver.findElement(By.id("user_registration_country"))).selectByVisibleText(country);		
		return this;
	}
	
	public OldSignUp acceptTnC (){
		WebElement e = driver.findElement(By.cssSelector("label[for='user_registration_cgsAccepted']"));
		boolean checkstatus;
		checkstatus = e.isSelected();
		if (checkstatus ==true){
			System.out.println("TnC already accepted");						
		} else {
			e.click();
		}
		return this;		
	}
	
	public OldSignUp acceptReceivePromotions (){
		WebElement e = driver.findElement(By.cssSelector("label[for='user_registration_newsletter']"));
		boolean checkstatus;
		checkstatus = e.isSelected();
		if (checkstatus ==true){
			System.out.println("TnC already accepted");						
		} else {
			e.click();
		}
		return this;		
	}
	
	public UserHomePage clickSIGNUP() {
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		return new UserHomePage(driver);
	}
	
	
	public UserHomePage createNewUser (SignUpData signUpData){
		//driver.findElement(By.cssSelector("a[href='#signup']")).click();
		driver.findElement(By.linkText("SIGN UP")).click();
		driver.findElement(By.linkText("SIGN UP WITH YOUR EMAIL")).click();
		return enterEmail(signUpData.getEmailId()).enterLoginId(signUpData.getLoginId())
		.enterPassword(signUpData.getPassword()).selectCountry(signUpData.getCountry())
		.acceptTnC().acceptReceivePromotions().clickSIGNUP();
		
	}
}
