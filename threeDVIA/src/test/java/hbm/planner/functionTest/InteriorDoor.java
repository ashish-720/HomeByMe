package hbm.planner.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

public class InteriorDoor extends Browser {
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void interiorDoor (SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.editLatestProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.twoDView().addAProductDev("4888", 300, 150)
		.editDoorWinPropertiesDev(300, 150, "200", "95", "", 0, 1)
		.verifyDoorWinPropertiesDev(300, 150, "200.0 cm", "95.0 cm", "0.0 cm")
		.editBayDimensionDev(300, 150, 98, 80)
		.verifyBayDimensionDev(300, 133, 80, 1);		
	}
}