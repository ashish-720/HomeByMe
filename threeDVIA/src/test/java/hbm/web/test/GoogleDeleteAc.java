package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.MyAccount;

import hbm.web.pageobject.UserHomePage;

@Test
public class GoogleDeleteAc extends Browser{
	
	
	@Test(dataProvider = "gmailLoginData", dataProviderClass=SignUpData.class)
	public void deleteGoogleAccount(SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
		UserHomePage userHomePage = PageFactory.initElements(driver, UserHomePage.class);		
		userHomePage.goToAccountPage();		
		MyAccount myAccount=PageFactory.initElements(driver, MyAccount.class);
		myAccount.clickPrivateInfo().deleteAccount(signUpData, "social");		
	}
	
	@Test(dataProvider="gmailLoginData", dataProviderClass=SignUpData.class, dependsOnMethods="deleteGoogleAccount")
	public void invalidUserGoogle(SignUpData signUpData){
		LandingPage home = PageFactory.initElements(driver, LandingPage.class);
		home.loginInvalidUser(signUpData);
	}	
}