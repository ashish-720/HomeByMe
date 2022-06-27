package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class LevelDelete extends Browser{	
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void levelDelete(SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.verifyBeingUpdated().editLatestProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.twoDView().threeDView()
		.deleteFloor("Basement 1", false)
		.deleteFloor("Basement 1", true)
		.save()
		.deleteFloor("First Floor", true).save()
		.closePlanner();
	}
}