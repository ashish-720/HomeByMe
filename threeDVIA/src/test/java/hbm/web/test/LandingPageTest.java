package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import hbm.web.pageobject.LandingPage;

@Test
public class LandingPageTest extends Browser {
	@Test(priority=1)
	public void landingPageVerification() {
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		Verification.VerifyEquals("Landing Page title not correct", driver.getTitle(), "Home inspirations trends and decorating ideas | HomeByMe");
		landingPage
		.verifyLanguages("HBMLn")
		.verifyPage();		
	}
	
	@Parameters("link")
	@Test(priority=2)
	public void landingPageVerifyLinks(@Optional("preprod") String link) {
		UtilHBM.verifyLinks(driver, "LandingPageNew");
	}

	@Test(priority=3)
	public void offersPageVerification() {
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.goToOffers()
			.verifyPage("")
			.goToLandingPage();
	}

	
}    