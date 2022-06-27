package hbm.web.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.LoginGmail;
import hbm.web.pageobject.UserHomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class GoogleSignUp extends Browser{
	
	@Test(dataProvider="gmailLoginData", dataProviderClass=SignUpData.class)
	public void signUpGoogle(SignUpData signUpData){
		LandingPage home = PageFactory.initElements(driver, LandingPage.class);
		home.signUp()
		.gmailUser()
		.signUpGoogle(signUpData)
		.completeProfile("Individual", "", false)	
		.closeDiscountPopupIfAvailable()
		.logout();
	}
	
	@Test(dataProvider="gmailLoginData", dataProviderClass=SignUpData.class, dependsOnMethods="signUpGoogle")
	public void forgotHBMPwd(SignUpData signUpData){
		LandingPage home = PageFactory.initElements(driver, LandingPage.class);
		home.login()
		.forgotPassward()
		.sendLinkResetPwd(signUpData);		
	}
	
	@Test(dataProvider="gmailLoginData", dataProviderClass=SignUpData.class, dependsOnMethods="forgotHBMPwd")
	public void resetHBMPwd(SignUpData signUpData){
		LoginGmail reset = PageFactory.initElements(driver, LoginGmail.class);
		reset.resetPwdFromGmail(signUpData)
		.checkLoginStatus("3dvia qa")
		.logout();		
	}
	
	@Test(dataProvider="gmailLoginData", dataProviderClass=SignUpData.class, dependsOnMethods="resetHBMPwd")
	public void loginEmailAfterResetPwd(SignUpData signUpData){		
		LandingPage home = PageFactory.initElements(driver, LandingPage.class);
		home.loginExistingUser(signUpData);
		UserHomePage user= PageFactory.initElements(driver, UserHomePage.class);
		user.logout();
	}

}
