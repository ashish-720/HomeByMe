package hbm.web.mobileTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Mobile;
import hbm.web.pageobject.LandingPage;

@Test
public class VerifyOurOffersPage extends Mobile {

	@Test
	public void VerifyOurOffersPage1() {
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.clickHeaderMenuMobile()
			.clickOurOffers()
			.verifyPage("");
	}
	
	/*
	 * @Test(dataProvider = "loginData", dataProviderClass=SignUpData.class,
	 * dependsOnMethods="VerifyOurOffersPage1") public void
	 * VerifyOurOffersPage2(SignUpData signUpData) { LandingPage landingPage =
	 * PageFactory.initElements(driver, LandingPage.class);
	 * landingPage.clickHeaderMenuMobile() .clickLogin() .loginMobile(signUpData)
	 * .clickHeaderMenuMobile() .clickOurOffers() .verifyPage("Pro monthly")
	 * .clickHeaderMenuMobile() .clickLogout(); }
	 * 
	 * @Test(dataProvider = "loginData", dataProviderClass=SignUpData.class,
	 * dependsOnMethods="VerifyOurOffersPage2") public void
	 * VerifyOurOffersPage3(SignUpData signUpData) { LandingPage landingPage =
	 * PageFactory.initElements(driver, LandingPage.class);
	 * landingPage.clickHeaderMenuMobile() .clickLogin() .loginMobile(signUpData)
	 * .clickHeaderMenuMobile() .clickOurOffers() .verifyPage("Pro yearly")
	 * .clickHeaderMenuMobile() .clickLogout(); }
	 */
}
