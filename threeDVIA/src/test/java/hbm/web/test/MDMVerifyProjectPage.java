package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;

public class MDMVerifyProjectPage extends Browser {

	
	@Test(dataProvider="hmsLoginData", dataProviderClass=SignUpData.class)
	public void mdmVerifyProjectPage1(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUserMDM(signUpData)
		.goToMyProjectsMDM()
		.openOwnProjectMDM("IDS1")
		.verifyProjectName("IDS1")
		.editTags("INL,Automation")
		.clickHbmLogoMDM()
		.logoutHBM4()
		;		
	}
	@Test(dataProvider="hmsLoginData", dataProviderClass=SignUpData.class,dependsOnMethods="mdmVerifyProjectPage1")
	public void mdmVerifyProjectPage2(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUserMDM(signUpData)
		.goToMyProjectsMDM()
		.openOwnProjectMDM("IDS2")
		.verifyProjectName("IDS2")
		.editTags("INL,Automation")
		.clickHbmLogoMDM()
		.logoutHBM4()
		;		
	}
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class,dependsOnMethods="mdmVerifyProjectPage2")
	public void mdmVerifyProjectPageNew(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUserMDM(signUpData)
		.goToMyProjectsMDM()
		.openOwnProjectMDM( "INL_AUTO_TEST_PROJECT")
		.verifyProjectName( "INL_AUTO_TEST_PROJECT")
		.verifyOverviewTabMDM("OWN",1, 3, "39 m\u00B2", 0, 1,2,12)
		.verifyProductsTabMDM(2)	
		.verifyImagesTabMDM("OWN",6,4,2)
		.editDescription("House", "Dream", "description to be added")
		.editTags("INL,Automation")
//		.addNewComment("New comment is here!!!")
		.clickHbmLogoMDM()
		.logoutHBM4()
		;		
	}
}
