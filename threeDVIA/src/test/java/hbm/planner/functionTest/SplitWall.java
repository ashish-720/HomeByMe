package hbm.planner.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

public class SplitWall extends Browser{
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void splitWall(SignUpData signUpData){
		LandingPage home= PageFactory.initElements(driver, LandingPage.class);
		home.loginExistingUser(signUpData);
		UserHomePage userHome= PageFactory.initElements(driver, UserHomePage.class);
		userHome.editLatestProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.twoDView().splitWallDev(-295, 100).threeDView().twoDView()
		.editTwoDWallDimensionDev(100, 295, "581 cm", "8000 mm", "left")
		.verify2DWallPropertiesDev(100, 295, "10 cm", "250 cm", "800 cm", 1, "", "")
		.verify2DWallPropertiesDev(-400, 0, "10 cm", "250 cm", "219 cm", 1, "", "")
		.threeDView().edit3DWallPropertiesDev(-300, 0, "Wood", 0, "9627", 0)		
		.addFromBalloonDev(-350, 0, "LES EXCLUSIVES - ONDE", -400, 0)
		.verifyLogoLinkDev(-400, 0)
		.threeDView()
		.verify3DWallPropertiesDev(-300, 0, "Wood", 0, "9627", 0);		
	}
	
}
