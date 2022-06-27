package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import hbm.web.pageobject.FeaturedMediaPage;

@Test
public class VerifyMediaPageWithSamePinProducts extends Browser {

	@Test
	public void verifyMediaPageWithSameProducts() {
		Browser.openUrl(driver, "https://preprod-home.by.me/en/media/34517-855280-livingroom-vintage-black?content=");
		FeaturedMediaPage featuredMediaPage = PageFactory.initElements(driver, FeaturedMediaPage.class);
		featuredMediaPage.verifyMediaDisplayed()
			.verifyPinProducts("CARLOTTA - Grey Tufted Armchair,MAISONS DU MONDE;,GENERIQUE;RIO Polypropylene Outdoor Rug, Multicoloured 180x270,MAISONS DU MONDE;,XXLMAISON");
	}
}
