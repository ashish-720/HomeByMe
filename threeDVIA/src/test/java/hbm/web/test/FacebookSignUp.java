package hbm.web.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.LoginGmail;
import hbm.web.pageobject.UserHomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class FacebookSignUp extends Browser{
	
	@Test(dataProvider="fBLoginData", dataProviderClass=SignUpData.class)
	public void signUpFacebook(SignUpData signUpData){
		LandingPage home = PageFactory.initElements(driver, LandingPage.class);
		home.signUpFB(signUpData)
		.verifyCompleteProfileDialog()
			.completeProfile("Individual", "", false)
			.checkLoginStatus("Dvia QA");
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.logout();
	}
	
//	@Test(dataProvider="gmailLoginData", dataProviderClass=SignUpData.class, dependsOnMethods="signUpFacebook")
//	public void forgotHBMPwdFB(SignUpData signUpData){
//		LandingPage home = PageFactory.initElements(driver, LandingPage.class);
//		home.forgotPassward(signUpData);		
//	}
//	
//	@Test(dataProvider="gmailLoginData", dataProviderClass=SignUpData.class, dependsOnMethods="forgotHBMPwdFB")
//	public void resetHBMPwdFB(SignUpData signUpData){
//		LoginGmail reset = PageFactory.initElements(driver, LoginGmail.class);
//		reset.resetPwdFromGmail(signUpData);		
//	}
//	
//	@Test(dataProvider="emailLogin", dataProviderClass=SignUpData.class, dependsOnMethods="resetHBMPwdFB")
//	public void loginEmailAfterResetPwdFB(SignUpData signUpData){		
//		LandingPage home = PageFactory.initElements(driver, LandingPage.class);
//		home.loginExistingUser(signUpData);
//		UserHomePage user= PageFactory.initElements(driver, UserHomePage.class);
//		user.logout();
//	}

}
