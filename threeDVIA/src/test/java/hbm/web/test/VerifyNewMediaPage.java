package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

public class VerifyNewMediaPage extends Browser {

	@Test(dataProvider = "loginData", dataProviderClass = SignUpData.class)
	public void verifyMediaPageMyPictures(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToMyProfile()
			.verifyUserDetails("Own","Balasaheb Nirwal")
			.openFirstMedia("own")
			.verifyMediaPage("3dplm", "", "Yes", "All rooms;All colors;All brands")
			.openProfilePage()
			.clickHbmLogo()
			.logout();
	}
	
	@Test(dependsOnMethods = "verifyMediaPageMyPictures")
	public void verifyMediaPageFeedPage() {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage
		.goToInspiration()
//		.verifyMediaPage("No")
		;
	}

	@Test(dataProvider = "loginData", dataProviderClass = SignUpData.class, dependsOnMethods = "verifyMediaPageFeedPage")
	public void verifyMediaPageProjectPage(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)		
			.goToMyProjects()	
			.openOwnProject(0, "Duplicate")
			.verifyProjectName("Duplicate")
			.goToImagesTab()
			.goToMediaType("Realistic images", false)
//			.verifyCopyToClipbioard("media", "Realistic images")
			;
		
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.logout();
			;
	}
}