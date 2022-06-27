package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

@Test
public class PurchaseAdditionalProjects extends Browser{

	@Test(dataProvider = "emailLogin", dataProviderClass=SignUpData.class)
	public void purchaseAdditionalProjects(SignUpData signUpData) {		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToOffers()
			.openPacksTab()
			.purchaseAddnlProjects("10")
			.makePayment("2", "", "LaCarte1", "No");	
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.logout();	
	}	
}