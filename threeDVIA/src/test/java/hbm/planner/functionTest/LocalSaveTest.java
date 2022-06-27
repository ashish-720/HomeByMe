package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.LocalSave;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LocalSaveTest extends Browser {
		
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)	
	public void localSave(SignUpData signUpData){
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.loginExistingUser(signUpData);		
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.editLatestProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.twoDView().editTwoDWallDimensionDev(0, -100, "295 cm", "200", "below")
		.editTwoDWallDimensionDev(-295, 0, "581 cm", "20", "Below")
		.threeDView()
		.edit3DWallPropertiesDev(100, 0, "Satin paint", 4, "10330", 0);		
		LocalSave save = PageFactory.initElements(driver, LocalSave.class);
		save.openLocalVersion("yes");			
		planner.verify3DWallPropertiesDev(100, 0, "Satin paint", 4, "10330", 0);
//		UtilHBM.verifyScreen("exWallColorPurple");
	}
}
