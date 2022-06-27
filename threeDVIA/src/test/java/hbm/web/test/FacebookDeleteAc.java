package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.MyAccount;

import hbm.web.pageobject.UserHomePage;

@Test
public class FacebookDeleteAc extends Browser{
	
	
	@Test(dataProvider = "fBLoginData", dataProviderClass=SignUpData.class)
	public void deleteAccountFB(SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginFBUser(signUpData);
		UserHomePage userHomePage = PageFactory.initElements(driver, UserHomePage.class);		
		userHomePage.goToAccountPage();		
		MyAccount myAccount=PageFactory.initElements(driver, MyAccount.class);
		myAccount.clickPrivateInfo().deleteAccount(signUpData, "social");	
	}
	
	@Test(dataProvider="emailLogin", dataProviderClass=SignUpData.class, dependsOnMethods="deleteAccountFB")
	public void invalidUserFB(SignUpData signUpData){
		LandingPage home = PageFactory.initElements(driver, LandingPage.class);
		home.loginInvalidUser(signUpData);
	}	
}