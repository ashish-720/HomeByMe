package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserProfilePage;

@Test
public class Verify3DByMeFrmHBM extends Browser {

	@Test(dataProvider = "hmsLoginData", dataProviderClass = SignUpData.class)
	public void openMyContent3DByMe(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToMyProfile()
			.clickMyContent();
	}

	@Test(dataProvider = "hbmProdloginData", dataProviderClass = SignUpData.class, dependsOnMethods = "openMyContent3DByMe")
	public void verify3DByMeFrmHBM(SignUpData signUpData) {
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		userProfilePage.clickCreateNewContent()
			.verifyPage()
			.clickLogin()
			.login3DByMe(signUpData)
			.verifyOnBoardingScreens()
			.enterProjectName("ODT-" + UtilHBM.getDate(0, "ddMMyyyy"))
			.addProductsToProject()
			.deleteProject()
			.verifyPage()
			.logout()
			.confirmLogoutYes()
			.close3DByMeTab()
			.clickHbmLogo()
			.logout()
			;
	}
}
