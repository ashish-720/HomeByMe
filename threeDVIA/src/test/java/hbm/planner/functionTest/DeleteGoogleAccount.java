package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.MyAccount;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class DeleteGoogleAccount  extends Browser{
	@Test(dataProvider = "gmailLoginData", dataProviderClass=SignUpData.class)
	public void deleteGoogleAccount(SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginGmailUser(signUpData)
		.goToAccountPage();		
		MyAccount myAccount=PageFactory.initElements(driver, MyAccount.class);
		myAccount.clickPrivateInfo().deleteAccount(signUpData, "social");		
	}


//	@Test(dataProvider="gmailLoginData", dataProviderClass=SignUpData.class,  dependsOnMethods="deleteGoogleAccount")
//	public void invalidUserGoogle(SignUpData signUpData){
//		LandingPage home = PageFactory.initElements(driver, LandingPage.class);
//		home.loginGmailUser(signUpData)
//		;
//	}	

	
}

