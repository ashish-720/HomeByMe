package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

public class VerifyImageFeed extends Browser {

	
	@Test(dataProvider = "loginData", dataProviderClass = SignUpData.class,priority = 1)
	public void verifyImageFeedMyPictures(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToMyProfile()
			.goToBottomOfList()
			.verifyMediaAvailableAtIndex(30)
			.clickHbmLogo()
			.logout()
			;
	}
	
	@Test(priority = 2)
	public void verifyImageFeedInspirationPage() {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.goToInspiration()
		.goToBottomOfList()
		.verifyMediaAvailableAtIndex(30)
			.clearFilters()
			.goToBottomOfList()
			.verifyMediaAvailableAtIndex(30)
			.clickHbmLogo();
	}
}
