package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;

@Test
public class VerifyOurOffersPage extends Browser {

	@Test()
	public void VerifyOurOffersPage1() {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.goToOffers()
				.verifyPage("")
				.goToLandingPage();
	}

	@Test(dataProvider = "emailLogin", dataProviderClass=SignUpData.class)
	public void VerifyOurOffersPage2(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
				.goToOffers()
				.verifyPage("Pro monthly")
				.goTouserHomePage()
				.logout();
	}
	
	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class)
	public void VerifyOurOffersPage3(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
				.goToOffers()
				.verifyPage("Pro yearly")
				.goTouserHomePage()
				.logout();
	}
}
