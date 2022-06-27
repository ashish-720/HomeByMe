package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

@Test
public class VerifyStaffPicks extends Browser{

	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class)
	public void verifyStaffPicksPage(SignUpData signUpData) {		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToStaffPick()
			.verifyStaffPicksPage(true)
			.logout()
		;
	}
	
	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class,dependsOnMethods = "verifyStaffPicksPage")
	public void verifyAddedStaffPickImgInFeed(SignUpData signUpData) {		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToInspiration()
			.verifyImageAddedInStaffPick()
			.logout();
		;	
	}
	
	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class,dependsOnMethods = "verifyAddedStaffPickImgInFeed")
	public void verifyAddedStaffPickImg(SignUpData signUpData) {		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToStaffPick()
			.verifyImageAddedToStaffPick()
			.clickHbmLogo()
		;
	}	
	

	
	@Test(dependsOnMethods = "verifyAddedStaffPickImg")
	public void removeFrmStaffPicks() {		
		UserHomePage homepage = PageFactory.initElements(driver, UserHomePage.class);
		homepage.goToStaffPick()
			.removeFrmStaffPick()
			.logout()
		;
	}	
	
}