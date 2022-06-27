package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

@Test
public class VerifyImageRemovedFromStaffPicks extends Browser{

	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class)
	public void verifyAddedStaffPickImgInFeed(SignUpData signUpData) {		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToInspiration()
			.verifyImageRemovedFrmStaffPick()
			.clickHbmLogo()
		;	
	}
	
	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class)
	public void verifyAddedStaffPickImg(SignUpData signUpData) {		
		UserHomePage homepage = PageFactory.initElements(driver, UserHomePage.class);
		homepage.goToStaffPick()
			.verifyImageRemovedFrmStaffPick()
			.logout()
		;
	}	
	

}
