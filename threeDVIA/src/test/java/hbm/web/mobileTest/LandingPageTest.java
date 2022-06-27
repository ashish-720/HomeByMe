package hbm.web.mobileTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import hbm.planner.utility.Mobile;
import hbm.web.pageobject.LandingPage;

@Test
public class LandingPageTest extends Mobile {
	
@Test
	public void LandingPage (@Optional("preprod") String link){
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.verifyPageMobile();
	}
	
}
