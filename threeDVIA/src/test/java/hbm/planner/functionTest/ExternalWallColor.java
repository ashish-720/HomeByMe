package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ExternalWallColor extends Browser {
		
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)	
	public void externalWallColor(SignUpData signUpData){
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.loginExistingUser(signUpData);		
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.editLatestProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.twoDView().editTwoDWallDimensionDev(0, -100, "295 cm", "200", "below")
		.editTwoDWallDimensionDev(-295, 0, "581 cm", "20", "Below")
		.threeDView()
//		.threeDWallProperties("exWallColor", "Satin paint", 4, 10331, 0)	
		.edit3DWallPropertiesDev(100, 0, "Matt paint", 5, "10270", 0)
		.verify3DWallPropertiesDev(100, 0, "Matt paint", 5, "10270", 0)
		.edit3DWallPropertiesDev(100, 0, "Concrete & Bricks", 0, "4334", 0)
		.verify3DWallPropertiesDev(100, 0, "Concrete & Bricks", 0, "4334", 0);		
	}
}
