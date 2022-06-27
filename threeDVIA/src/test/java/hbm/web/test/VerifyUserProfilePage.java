package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

public class VerifyUserProfilePage extends Browser {

	@Test(dataProvider = "loginData", dataProviderClass = SignUpData.class)
	public void verifyUserProfilePageOwn(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToMyProfile()
			.verifyUserDetails("Own","3DPLM")
			.verifyMyPictures("3DPLM ",true)
			.editProfile()
			.clickHbmLogo();
	}

	@Test(dataProvider = "loginData", dataProviderClass = SignUpData.class,dependsOnMethods="verifyUserProfilePageOwn")
	public void verifyOtherUsersProfilePage1(SignUpData signUpData) {
		UserHomePage userHomePage=PageFactory.initElements(driver, UserHomePage.class);
		userHomePage.goToInspiration()
			.clickUserProfileLink("shubham.khisti")
			.verifyOtherUsersProfilePage("shubham.khisti")
			.clickHbmLogo()
			.logout();
	}
	
	@Test(dependsOnMethods="verifyOtherUsersProfilePage1")
	public void verifyOtherUsersProfilePage2() {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.goToInspiration()
			.clickUserProfileLink("shubham.khisti")
			.verifyOtherUsersProfilePage("shubham.khisti")
			.clickHbmLogo();
	}

	@Test(dependsOnMethods="verifyOtherUsersProfilePage2")
	public void verifyOtherUsersProfilePage3() {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.goToInspiration()
			.applyFilter("All", "Living Room", "Contemporary", "Brown", "Maisons du monde")
			.verifyFilters("All", "Living Room", "Contemporary", "Brown", "Maisons du monde")
			.clickUserProfileLink("reetie.y+08")
			.verifyOtherUsersProfilePage("reetie.y+08")
			.clickHbmLogo();
	}
	
	@Test(dependsOnMethods="verifyOtherUsersProfilePage3")
	public void verifyUsersProfilePageFromImgPage() {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.goToInspiration()
			.openImageOfUser("shubham.khisti")
			.openProfilePage()
			.verifyOtherUsersProfilePage("shubham.khisti")
			.clickHbmLogo();
	}
}
