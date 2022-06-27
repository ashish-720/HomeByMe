package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class Staircase extends Browser{
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void staircase(SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.editLatestProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.twoDView().addFloorOrBasementOrPlan(1, 0, "250", "").changeActiveFloor("Ground floor")
		.addAProductDev("4988", -200, -100)	
		.dragNDrop(-200, -100, -70, 100)
		.threeDView().changeActiveFloor("First floor")
		.editFloorPropertiesDev(-120, 0, "Kitchen", "Mosaic Tile", "8775", 0)			
		.changeActiveFloor("Ground floor")
		.editGenericPropertiesDev(-70, 50, "", "50.0 cm", "300.0 cm", "", 0, "")
		.verifyGenericPropertiesDev(-56, 56, "270.0 cm", "50.0 cm", "300.0 cm", "")
		.changeActiveFloor("First floor")
		.verifyFloorPropertiesDev(-120, 0, "Kitchen", "Mosaic Tile", "8775", 0)
		.undo(20)
		.snapshot3D("3D", 1)
		.verifyFloorPropertiesDev(-120, 0, "Kitchen", "Mosaic Tile", "8775", 0)
		.changeActiveFloor("Ground floor")
		.deleteDev(-56, 56).changeActiveFloor("First floor")
		.verifyFloorPropertiesDev(-100, 0, "Kitchen", "Mosaic Tile", "8775", 0)
		.snapshot3D("3D", 2)
		;
	}
}