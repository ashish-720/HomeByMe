package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;

@Test
public class DeleteAccount extends Browser{
	
	
	@Test(dataProvider = "newUserSignUpData", dataProviderClass=SignUpData.class)
	public void deleteAccount(SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
				.goToAccountPage()
//				.clickPurchases().verifyPurchase("Additional projects", 1)
				.clickPrivateInfo()
				.deleteAccount(signUpData, "hbm")
				.verifyPageTitle();
	}
	
	@Test(dataProvider="newUserSignUpData", dataProviderClass=SignUpData.class, dependsOnMethods="deleteAccount")
	public void invalidUser(SignUpData signUpData){
		LandingPage home = PageFactory.initElements(driver, LandingPage.class);
		home.loginInvalidUser(signUpData);
	}	
}