package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;

@Test
public class PartnerPageTest extends Browser {

	@Test
	public void partnerFormTest() {
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.goToBrandPage().clickBecomeAPartner().partnerForm();
	}
}
