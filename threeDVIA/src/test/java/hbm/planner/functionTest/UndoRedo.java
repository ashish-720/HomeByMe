package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class UndoRedo extends Browser{
	
	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class)
	public void undoRedo(SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.editLatestProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.twoDView().threeDView()
		.addAProductWithoutFilterDev("Etagère murale SAN FRANCISCO", 150, 110)
		.editGenericPropertiesDev(150, 110, "50", "180", "30", "Wood",0, "")
		.undo(5)
		.verifyGenericPropertiesDev(150, 110, "50.0 cm", "165.0 cm", "25.0 cm", "")
		.editGenericPropertiesDev(150, 110, "50", "180", "30", "Wood", 0, "1225")
		.undo(5).redo(5)
		.verifyGenericPropertiesDev(150, 110, "50.0 cm", "180.0 cm", "30.0 cm", "1225")				
		.edit3DWallPropertiesDev(100, 50, "Wallpaper", 0, "8762", 0)
		.edit3DWallPropertiesDev(100, 50, "Wallpaper", 0, "8576", 0)
		.undo(4)
		.edit3DWallPropertiesDev(100, 50, "Wallpaper", 0, "8754", 0)
		.undo(3).redo(4)
		.verify3DWallPropertiesDev(100, 50, "Wallpaper", 0, "8754", 0);	
	}
}
