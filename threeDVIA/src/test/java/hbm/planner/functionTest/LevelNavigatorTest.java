package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class LevelNavigatorTest extends Browser{	
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void levelNavigator(SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
		.editLatestProject()
		.twoDView()
		.addFloorOrBasementOrPlan(1, 1, "200", "Ihina1.png").verifyFloorPlanInfo()			
		.addAProductFromInfoDev("BIBLIOTHEQUE B1", -150, -200)		
		.addAProductFromInfoDev("Century Unlimited multicolore coloré mat", 0, 200)
		.snapshot3D("3D", 2)
		.verifyLogoLinkDev(-110, -40)
		.changeFloorPlan("RoundBed.png")
		.threeDView()
		.changeActiveFloor("First Floor")
		.twoDView()
		.edit2DWallPropertiesDev(100, 300, "", "", "200", "100")
		.addAProductDev("Rooftop Window", 0, 280)
		.editDoorWinPropertiesDev(0, 250, "80", "70", "", 0, 0)
		.verifyDoorWinPropertiesDev(0, 250, "80.0 cm", "70.0 cm", "")
		.editBayDimensionDev(0, 250, 255, 300)
		.verifyBayDimensionDev(-40, 250, 300, 1)
		.threeDView()
		.addAProductDev("Dressing Saint Sulpice", 150, 100)
		.editFloorPropertiesDev(-100, 0, "Bedroom", "Carpet", "7883", 0)
		.verifyFloorPropertiesDev(-100, 0, "Bedroom", "Carpet", "7883", 0)
		.editCeilingPropertiesDev(-100, 0, "Bedroom", "Wall and floor tile", "9363", 0)
		.snapshot()
		.threeDView()
		.verifyCeilingPropertiesDev(-100, 0, "Bedroom", "Wall and floor tile", "9363", 0)
		.editFloorPropertiesDev(-100, 0, true, false)
		.verifyFloorPropertiesDev(-100, 0, true, false)
		.lockFloor("First Floor")
		.verifylockFloor()
		.lockMsgDesignFloorPlan("DesignAWall")
		.lockMsgDesignFloorPlan("AddARoom")	
		.lockMsgDesignFloorPlan("roomSeparator")
		.lockMsgDesignFloorPlan("Exterior")
		.twoDView()
		.lockMsgBuild("LES EXCLUSIVES - ONDE", 0, 0)
		.verifyLockInPlanner(true, 100, 300)
		.unLockFloor("First Floor")
		.addFloorOrBasementOrPlan(1, 0, "200", "Ihina1.png").verifyFloorPlanInfo()
		.threeDView()
		.snapshot()
		.deleteFloor("Second floor", true)
		.save().closePlanner()
		.editLatestProject()
		.changeActiveFloor("First Floor")
//		.fpMoveFontOrBack(20, "back")
		.fpRotateDev(20, "down")
		
//		.dragNDrop(0, 20, 0, 340)
		//.edit3DWallPropertiesDev(100,0, "Satin paint", 7, "10666", 0)
		
		.edit3DWallPropertiesDev(100,0, "Satin paint", 7, "10684", 0)
//		.fpRotateDev(20, "right")
		.edit3DWallPropertiesDev(100, -100, "Concrete & Bricks", 7, "8170", 0)
		.snapshot3D("3D", 1)
		.save().closePlanner()
		.editLatestProject()
		.twoDView()
		.changeActiveFloor("First Floor")
		.verify2DWallPropertiesDev(100, 300, "10 cm", "250 cm", "581 cm", 1, "200 cm", "100 cm")
		.verifyDoorWinPropertiesDev(-40, 250, "80.0 cm", "70.0 cm", "")
		.verifyBayDimensionDev(-40, 250, 300, 1)
		.threeDView()		
		.save()
		.twoDView()
		.threeDView()
		.verifyLogoLinkDev(150, 100)
//		.fpMoveFontOrBack(20, "back")
		.fpRotateDev(20, "down")
//		.dragNDrop(0, 20, 0, 340)
		.verify3DWallPropertiesDev(100, 0, "Satin paint", 7, "10684", 1)
		.verify3DWallPropertiesDev(100, -100, "Concrete & Bricks", 7, "8170", 1)
		.save();
	}
}