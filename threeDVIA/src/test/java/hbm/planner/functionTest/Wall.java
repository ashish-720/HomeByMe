package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class Wall extends Browser{
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void wallCreation(SignUpData signUpData){
		LandingPage homePage = PageFactory.initElements(driver, LandingPage.class);
		homePage.loginExistingUser(signUpData);
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.editLatestProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.twoDView().threeDView()
		.edit3DWallPropertiesDev(-100, -100, "Satin paint", 7, "4463", 0)
		.twoDView()
		.edit2DWallPropertiesDev(-100, -295,"12", "1000 mm", "", "")
		.verify2DWallPropertiesDev(-100, -295, "12 cm", "100 cm", "285 cm", 0,"", "")
		.threeDView()
		.verify3DWallPropertiesDev(-100, -100, "Satin paint", 7, "4463", 0)
		.twoDView()
		.verify2DWallPropertiesDev(-100, -295, "12 cm", "100 cm", "285 cm", 0,"", "")
		.edit2DWallPropertiesDev(-100, -295, "", "roomHt", "", "")
		.threeDView()
		.verify3DWallPropertiesDev(-100, -200, "Satin paint", 7, "4463", 0)
		.twoDView()
		.verify2DWallPropertiesDev(-100, -295, "12 cm", "250 cm", "285 cm", 1,"", "")
		.wallDev("Wall")
		.edit2DWallPropertiesDev(-100, 0, "5", "100", "", "")
		.verify2DWallPropertiesDev(-100, 0, "5 cm", "100 cm", "", 0, "", "")
		.editFloorPropertiesDev(-100, -20, "Library", "Hardwood", "4295", 0)
		.roomSeparationDev("RoomSeparator")
		.editFloorPropertiesDev(100, 100, "Library", "Hardwood", "4295", 0)
		.threeDView()
//		.verify3DWallPropertiesDev(-100, -200, "Satin paint", 7, "4463", 0) comment tag to be removed after fixing IR 
		.verifyFloorPropertiesDev(-100, 0, "Library", "Hardwood", "4295", 0)
		.verifyProjectDetails("INL", "Apartment", "Dreamed project", 1, 3, 24.83)
		.deleteRoom(-100, 0)
		.verifyProjectDetails("INL", "Apartment", "Dreamed project", 1, 2, 16.64);		
	}
}
