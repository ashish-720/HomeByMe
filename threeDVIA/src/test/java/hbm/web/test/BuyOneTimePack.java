package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

@Test
public class BuyOneTimePack extends Browser{

	@Test(dataProvider = "newUserSignUpData", dataProviderClass=SignUpData.class)
	public void buyOneTimePack(SignUpData signUpData){	
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
		.goToOffers()
		.buyOneTimePack()
		.makePayment("1", "", "LaCarte1", "No");
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.logout();		
	}	
	
}
