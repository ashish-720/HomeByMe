package hbm.planner.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

public class RealisticImageDeletekPlanner extends Browser {
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void realisticImageDeletekPlanner(SignUpData signUpData){	
		LandingPage homePage = PageFactory.initElements(driver, LandingPage.class);
		homePage.loginExistingUser(signUpData);
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.editLatestProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.myImages()
		.deleteMedia(1, "realistic", 4, false)
		.deleteMedia(1, "realistic", 4, true)
		.closeMyImages();		
	}
}
