package hbm.web.pageobject;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.UtilHBM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginGmail {
	
	WebDriver driver;
	
	public LoginGmail(WebDriver driver) {
			this.driver=driver;
	}
	
	@CacheLookup
	@FindBy(id="identifierId")
	WebElement emailIdInputBox;
		
	@FindBy(css="#identifierNext")
	WebElement nextButton;
	
	@CacheLookup
	@FindBy(name="password")
	WebElement pwdInputBox;
	
	@FindBy(css="#passwordNext")
	WebElement passwordNextButton;
	
	@CacheLookup
	@FindBy(id="PersistentCookie")
	WebElement staySignedInCheckBox;
	
	@CacheLookup
	@FindBy(id="signIn")
	WebElement signInButton;
	
	@FindBy(css=".zA.zE")
	List<WebElement> emailList;
	
	@FindBy(xpath="//span[.='Reset your password']")
	List<WebElement> resetEmailList;
	
	@FindBy(css="div[aria-label='Refresh']>div>.asf.T-I-J3.J-J5-Ji")
	WebElement refreshEmailList;
	
	@FindBy(xpath="//div[@class='ii gt']//a[.='Reset']")
	WebElement resetBtn;
	
	@FindBy(xpath="//div[@class='ii gt']//a[.='Activate']")
	WebElement activateBtn;
	
	@FindBy(xpath="//div[@class='iH bzn']/div/div/div/div/div[@class='ar9 T-I-J3 J-J5-Ji']/parent::div")
	WebElement deleteEmail;
	
	@FindBy(css="a[aria-label*='Google Account:']")
	WebElement gmailUserIcon;
	
	@FindBy(xpath="//a/div[text()='Sign out']/..")
	WebElement signOutGmail;
	
	@FindBy(css="a[href='https://mail.google.com/mail/#inbox']")
	private WebElement inbox;
	
	@FindBy(xpath="//div[aria-label='Refresh']/div")
	private WebElement refreshBtn;
	
	@FindBy(css=".BHzsHc")
	private WebElement useAnotherAccount;
	
	private LoginGmail enterGmailId(String gmailId){
		emailIdInputBox.click();
		emailIdInputBox.clear();
		emailIdInputBox.sendKeys(gmailId);
		return this;		
	}
	
	private LoginGmail clicknextButton(){
		nextButton.click();
		return this;
	}
	
	private LoginGmail enterPwd(String pwd){
		UtilHBM.waitExplicitClickable(driver, pwdInputBox);
		pwdInputBox.clear();
		pwdInputBox.sendKeys(pwd);		
		return this;
	}
	
	private UserHomePage clickSignIn(){
		/*if(staySignedInCheckBox.isSelected())
			staySignedInCheckBox.click();*/
		//signInButton.click();
		String handle = driver.getWindowHandle();
		passwordNextButton.click();
		UtilHBM.reportOK("Login using gmail credential done");
		for(String handle1:driver.getWindowHandles()){
			if(!handle1.equalsIgnoreCase(handle)){
				driver.switchTo().window(handle1);
			}			
		}
//		UtilHBM.waitFixTime(3000);		
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public UserHomePage loginGmailUser(SignUpData signUpData) {
		String gmailId = signUpData.getGmailId();
		boolean isExistingUserDisplayed = false;
		UtilHBM.turnOffImplicitWaits(driver);
		List<WebElement> existingUser = driver.findElements(
				By.xpath("//div[text()='Signed out']/preceding-sibling::div/div[text()='" + gmailId + "']"));
		isExistingUserDisplayed = !existingUser.isEmpty();
		UtilHBM.turnOnImplicitWaits(driver);
		if (isExistingUserDisplayed) {
			clickExistingUser(gmailId);
		} else {
			enterGmailId(gmailId).clicknextButton();
		}
		LoginGmail loginGmail = PageFactory.initElements(driver, LoginGmail.class);
		loginGmail.enterPwd(signUpData.getGmailPwd()).clickSignIn();
		return PageFactory.initElements(driver, UserHomePage.class);
	}

	private LoginGmail clickExistingUser(String gmailId) {
		UtilHBM.turnOffImplicitWaits(driver);
		List<WebElement> existingUser = driver.findElements(
				By.xpath("//div[text()='Signed out']/preceding-sibling::div/div[text()='" + gmailId + "']"));
		UtilHBM.turnOnImplicitWaits(driver);
		existingUser.get(0).click();
		return this;
	}
	
	public Login loginGmailNewMethod(SignUpData signUpData){
		enterGmailId(signUpData.getGmailId()).clicknextButton().enterPwd(signUpData.getGmailPwd()).clickSignIn();
		return PageFactory.initElements(driver, Login.class);
	}
	
	public LoginGmail openGmailPage(){
		driver.get("https://mail.google.com/mail/");		
		return PageFactory.initElements(driver, LoginGmail.class);
	}
	
	public LoginGmail userAnotherAccount(){
		UtilHBM.waitExplicitClickable(driver, useAnotherAccount);
		useAnotherAccount.click();
		return PageFactory.initElements(driver, LoginGmail.class);
	}
	
	public CompleteProfile signUpGoogle(SignUpData signUpData){
		loginGmailUser(signUpData);		
		return PageFactory.initElements(driver, CompleteProfile.class);
	}
	
	public UserHomePage resetPwdFromGmail(SignUpData signUpData) {
		driver.get("https://mail.google.com/mail/");
		if (!(emailList.size() > 0)) {
			loginGmailUser(signUpData);
		}
		WebElement emailToOpen = null;
		UtilHBM.waitFixTime(10000);
		int i = 0;
		while (i < 5) {
			if (emailList.get(0).getText().contains("account")
					&& emailList.get(0).getText().contains("Password reset")) {
				emailToOpen = emailList.get(0);
				break;
			} else if (emailList.get(1).getText().contains("account")
					&& emailList.get(1).getText().contains("Password reset")) {
				emailToOpen = emailList.get(1);
				break;
			}
			i++;
//			refreshMails();
			UtilHBM.waitFixTime(10000);
		}
		UtilHBM.waitExplicitDisplayed(driver, emailToOpen);
		emailToOpen.click();
		UtilHBM.waitFixTime(2000);
		UtilHBM.waitExplicitClickable(driver, resetBtn);
		String handle = driver.getWindowHandle();
		resetBtn.click();
		driver.switchTo().window(handle);
		UtilHBM.waitExplicitClickable(driver, deleteEmail);
		deleteEmail.click();
		UtilHBM.waitExplicitClickable(driver, gmailUserIcon);
		signOut();
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.println("unexpected pop up not present");
		}
		UtilHBM.waitExplicitDisplayed(driver, "//div[@id='logo']");
		driver.close();
		for (String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}
		ResetForgotPwd resetForgotPwd = PageFactory.initElements(driver, ResetForgotPwd.class);
		resetForgotPwd.resetForgotPwd(signUpData);
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public Login newConnectionMethodActivation(SignUpData signUpData){
		driver.get("https://mail.google.com/mail/");
		if(!(emailList.size()>0)){
			loginGmailUser(signUpData);
		}
		WebElement emailToOpen = null;
		UtilHBM.waitFixTime(10000);
		int i=0;
		while(i<5){
			if(emailList.get(0).getText().contains("account") && emailList.get(0).getText().contains("New connection method")){
				emailToOpen=emailList.get(0);
				break;
			}else if(emailList.get(1).getText().contains("account") && emailList.get(1).getText().contains("New connection method")){
				emailToOpen=emailList.get(1);
				break;
			}
			i++;
//			refreshMails();
			UtilHBM.waitFixTime(10000);
		}
		UtilHBM.waitExplicitDisplayed(driver, emailToOpen);		
		emailToOpen.click();
		UtilHBM.waitFixTime(2000);
		UtilHBM.waitExplicitClickable(driver, activateBtn);
		String handle = driver.getWindowHandle();
		activateBtn.click();
		driver.switchTo().window(handle);		
		deleteEmail.click();
		signOut();
		try{   
		    driver.switchTo().alert().accept();  
		    }catch(Exception e){ 
		    System.out.println("unexpected pop up not present");   
		    }
		driver.close();
		for(String handle1:driver.getWindowHandles()){		
			driver.switchTo().window(handle1);
		}
		return PageFactory.initElements(driver, Login.class);
	}
	
	public SignUp openSignUpFromSponsorMail(SignUpData signUpData) {
		driver.get("https://mail.google.com/mail/");
		if (!(emailList.size() > 0)) {
			loginGmailUser(signUpData);
		}
		WebElement emailToOpen = null;
		UtilHBM.waitFixTime(5000);
		int i = 0;
		while (i < 5) {
			if (emailList.get(0).getText().contains("HomeByMe")
					&& emailList.get(0).getText().contains("Join the HomeByMe adventure")) {
				emailToOpen = emailList.get(0);
				break;
			} else if (emailList.get(1).getText().contains("HomeByMe")
					&& emailList.get(1).getText().contains("Join the HomeByMe adventure")) {
				emailToOpen = emailList.get(1);
				break;
			}
			i++;
//			refreshMails();
			UtilHBM.waitFixTime(10000);
		}
		UtilHBM.waitExplicitDisplayed(driver, emailToOpen);
		emailToOpen.click();
		UtilHBM.waitFixTime(2000);
		UtilHBM.turnOffImplicitWaits(driver);
		List<WebElement> registerWithMyCodeBtn = driver.findElements(By.xpath("//a[text()='Register with my code']"));
		UtilHBM.turnOnImplicitWaits(driver);
		String handle = driver.getWindowHandle();
		if (registerWithMyCodeBtn.isEmpty()) {
			UtilHBM.reportKO("Register with my code button not displayed in mail received!!");
		} else {
			WebElement registerBtn = registerWithMyCodeBtn.get(registerWithMyCodeBtn.size() - 1);
			Actions action = new Actions(driver);
			action.moveToElement(registerBtn).build().perform();
			UtilHBM.waitFixTime(500);
			UtilHBM.waitExplicitDisplayed(driver, registerBtn);
			UtilHBM.waitExplicitClickable(driver, registerBtn);
			registerBtn.click();
		}
		driver.switchTo().window(handle);
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitDisplayed(driver, deleteEmail);
		UtilHBM.waitExplicitClickable(driver, deleteEmail);
		deleteEmail.click();
		UtilHBM.waitFixTime(500);
		signOut();
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.println("unexpected pop up not present");
		}
		UtilHBM.waitExplicitDisplayed(driver, "//div[@id='logo']");
		driver.close();
		for (String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}
		return PageFactory.initElements(driver, SignUp.class);
	}
	
	private LoginGmail signOut() {
		UtilHBM.waitExplicitDisplayed(driver, gmailUserIcon);
		UtilHBM.waitExplicitClickable(driver, gmailUserIcon);
		gmailUserIcon.click();
		WebElement iFrame1=driver.findElement(By.cssSelector("div:nth-child(3)>iframe"));
		UtilHBM.waitExplicitDisplayed(driver, iFrame1);
		driver.switchTo().frame(iFrame1);
		UtilHBM.waitExplicitDisplayed(driver, signOutGmail);
		UtilHBM.waitExplicitClickable(driver, signOutGmail);
		signOutGmail.click();
		return this;
	}
	
	private LoginGmail refreshMails(){
		refreshBtn.click();
		return PageFactory.initElements(driver, LoginGmail.class);
	}

}
