package hbm.planner.scenarioTest;

import hbm.planner.dataobject.NewProjectData;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class HBMRedwire extends Browser {

	@Test(dataProvider = "loginData", dataProviderClass = SignUpData.class)
	public void hbmRedwireLogin(SignUpData signUpData) {
		LandingPage landingPage= PageFactory.initElements(driver, LandingPage.class);
		landingPage.loginExistingUser(signUpData);
	}

	@Test(dataProvider = "projectData", dataProviderClass = NewProjectData.class, dependsOnMethods = "hbmRedwireLogin")
	public void hbmRedwire(NewProjectData newProjectData) {		
		UserHomePage userHomePage = PageFactory.initElements(driver, UserHomePage.class);
		userHomePage.createEmptyProject(newProjectData);
		ThreeDPlanner planner = PageFactory.initElements(driver,
				ThreeDPlanner.class);
		planner.addARoom(10, "40", "Guest room")
		.wallDev("GuestRoom")
		.addAProductDev("LES EXCLUSIVES - ONDE", -243, 246)
		.addAProductDev("Interior door", 280, -182)
		.addAProductDev("LUMYS", -327, -46)
		.editFloorPropertiesDev(-170, -215, "Kitchen", "Vinyl", "4101", 0)
		.editFloorPropertiesDev(170, -225, "Bathroom", "Wall and floor tile", "3961", 0)
		.verifyFloorPropertiesDev(-170, -215, "Kitchen", "Vinyl", "4101", 0)
		.edit2DWallPropertiesDev(-90, -184, "9", "1", "", "")
		.verify2DWallPropertiesDev(-90, -184, "9 cm", "10 cm", "431 cm", 0, "NA", "")
//		.addAProductDev("Kitchen set I shape l340", -160, -290)
		.addAProductDev("5008", -287, -287)
		.addAProductDev("Under sink unit l100", -214, -287)
		.addAProductDev("Base cabinet 5 drawers l60", -131, -290)
		.addAProductDev("1752", -80, -290)
		.addAProductDev("Base cabinet 1 locker l60", -20, -290)
		.threeDView()
		.addAProductDev("Wall cabinet 2 lockers l100", -160, -143)
		.addAProductDev("1990", -60, -157)
		.editGenericPropertiesDev(-55, -75, "91", "", "65.4", "", 0, "")
		.editGenericPropertiesDev(-150, -70, "", "", "", "Wood", 0, "1221")
		.verifyGenericPropertiesDev(-55, -75, "91.0 cm", "50.0 cm", "65.4 cm", "")
		.verifyGenericPropertiesDev(-150, -70, "113.0 cm", "100.0 cm", "65.4 cm", "1221")
		.exteriorDev(0, 0, 1, "100")
		.editDoorWinPropertiesDev(-327, -46, "220", "200", "10", 1, 0)
		.editBayDimensionDev(-327, -46, 34, 40)
		.threeDView()
		.verifyFloorPropertiesDev(-50, -30, "Kitchen", "Vinyl", "4101", 0)
		.zoomOut(3)			
		.edit3DWallPropertiesDev(40, -100, "Wall and floor tile", 0, "9363", 0)
		.edit3DWallPropertiesDev(100, -70, "Matt paint", 3, "10606", 0)
		.editGenericPropertiesDev(-90, -60, "", "", "", "Plastic", 0, "2279")
		.addAProductDev("Hancock Moore Bernard sofa", -70, 60)
		.editGenericPropertiesDev(-70, 60, "90", "230", "105", "Fabric", 0, "2328")
		.verifyGenericPropertiesDev(-70, 60, "90.0 cm", "230.0 cm", "105.0 cm", "2328")
		.fpRotateDev(20, "left")
		.edit3DWallPropertiesDev(-210, -45, "Matt paint", 6, "10103", 1)
		.save()
		.snapshot3D("3D", 1)
		.snapshot3D("3D", 2)
//		UtilHBM.verifyScreen("HBMRedWireValidation");
		.fpRotateDev(7, "down")
		.realisticImageClick()
		.getStarted()
		.setBackground(2, true)
		.setSunPosition(10, 40, 20, 50)
		//.displayPeople(true)
		.lensOption(true, 0)
		.clickGenerateButton()
		.sendHQImageRequest("small")
		.closeHQMessage()
		//.realisticImage("small", false)
		.realisticImageClick()
		.getStarted()
		.setBackground(1, true)
		.setSunPosition(10, 40, 20, 50)
		//.displayPeople(true)
		.lensOption(true, 0)
		.clickGenerateButton()
		.sendHQImageRequest("Large")
		.closeHQMessage()
//		.realisticImage("large", false)
		.panoramic360(2)
		.closePlanner()
		.editLatestProject()
		.twoDView()
		.verifyBayDimensionDev(-327, -46, 40, 1)
		.verifyDoorWinPropertiesDev(-327, -46, "220.0 cm", "200.0 cm", "10.0 cm")
		.verifyGenericPropertiesDev(-120, -25, "90.0 cm", "230.0 cm", "105.0 cm", "2328")
//		.editGenericPropertiesDev(-120, -25, "92 cm", "200.0 cm", "100", "Satin paint", 8, "1514")
		.editGenericPropertiesDev(-120, -25, "92 cm", "200.0 cm", "100", "Satin paint", 9, "1507")
		.editDoorWinPropertiesDev(-327, -46, "215", "240", "0", 1, 0)
		
		.save()
		.editBayDimensionDev(-327, -46, 81, 76)
//		.editBayDimensionDev(-327, -46, 20, 24)
		.threeDView()
		.fpRotateDev(50, "left")
		.fpRotateDev(40, "up")
		.fpRotateDev(95, "left")
		.edit3DWallPropertiesDev(-160, -200, "Satin paint", 9, "4365", 0)
		.addAProductDev("Ensemble salon de jardin", -230, -180)
		.realisticImageClick()
		.getStarted()
		.setBackground(1,false)
		.setSunPosition(10, 40, 20, 50)
		//.displayPeople(true)
		.lensOption(true, 0)
		.clickGenerateButton()
		.sendHQImageRequest("Large")
		.closeHQMessage()
//		.realisticImage("large", false)
		.realisticImageClick()
		.getStarted()
		.setBackground(1,false)
		.setSunPosition(10, 40, 20, 50)
		//.displayPeople(false)
		.lensOption(true, 0)
		.clickGenerateButton()
		.sendHQImageRequest("small")
		.closeHQMessage()
//		.realisticImage("small", false)
		.panoramic360(3)
		.save()
		.threeDView().closePlanner()
		.editLatestProject()
		.twoDView()
		.verifyDoorWinPropertiesDev(-327, -46, "215.0 cm", "240.0 cm", "0.0 cm")
		.verifyBayDimensionDev(-327, -46, 76, 1)
//		.verifyBayDimensionDev(-327, -46, 24, 1)
		.snapshot2D("No Mtl + On Floor + Dim + Area", "on floor", false, true, "large", true, true, false, false)
		.threeDView()
		.verifyGenericPropertiesDev(-55, -75, "91.0 cm", "50.0 cm", "65.4 cm", "")
		.verifyGenericPropertiesDev(-150, -70, "113.0 cm", "100.0 cm", "65.4 cm", "1221")
		.verifyGenericPropertiesDev(-100, 60, "92.0 cm", "200.0 cm", "100.0 cm", "1507")
		.verifyFloorPropertiesDev(-90, -30, "Kitchen", "Vinyl", "4101", 0)
		.verify3DWallPropertiesDev(130, -70, "Matt paint", 3, "10606", 1)		
		.snapshot3D("3D", 4)
//		UtilHBM.verifyScreen("HBMRedWireValidation1");
//		ThreeDPlanner planner1 = PageFactory.initElements(driver,
//				ThreeDPlanner.class);
//		planner1
		.fpRotateDev(50, "left")
		.fpRotateDev(40, "up")
		.fpRotateDev(95, "left")
		.verify3DWallPropertiesDev(-160, -200, "Satin paint", 9, "4365", 0)
		.firstPersonView()
		.snapshot()
		.closePlanner()
		.editLatestProject()
		.threeDView()
		.addAProductDev("Ensemble lit double & chevet", 140, 50)
		.ungroup(140, 50)
		.includeAccessories(100, 0)
		.dragNDrop(140, 100, 140, 200)
		//.snapshot3D("Include Accessories drag in 3D")
		.includeAccessories(140, 85)
		.clickDuplicateBubble()
		.dragNDrop(250, 85, 280, 85)
		.clickDuplicateBubble()
		//.snapshot3D("Include Accessories drag and duplicate in 3D")
		.includeAccessories(140, 85)
		.clickDeleteBubble()
		.includeAccessories(398, 85)
		.clickDeleteBubble()
		.includeAccessories(552, 85)
		.clickDeleteBubble()
		.editFloorPropertiesDev(210, 120,"Kitchen", "Mosaic Tile", "8775", 0)
		.verifyFloorPropertiesDev(210, 120,"Kitchen", "Mosaic Tile", "8775", 0)
		//.snapshot3D("Include Accessories delete in 3D")
		.save()
		.twoDView()
		.includeAccessories(84, -152)
		.clickDeleteBubble()
		.includeAccessories(289, -152)
		.clickDeleteBubble()
		.threeDView()
		.deleteDev(146, -28)
		.reUseDev(140, -90)
		.clickInPlanner(300, 70)
		.reUseValidate()
		.verify3DWallPropertiesDev(300, 70, "Matt paint", 3, "10606", 1)
		//.snapshot3D("reuse")
		.save()
		.twoDView()
		.addAProductFromCommunityContentDev("Table","table", "672", 100, -35)
		.myContent(60, 4, 0, 150, "Module L100 H231 P60 IMAGINE")
		.clickInfoBubble(100, -35)
		.verifyCommunityContentProductSheet("8E465FF3-5C71-4C88-A4D7-124E21F2A94E/Thumbnails", "Pallavi" , "table", "P")
		.deleteDev(0, 150)
		.addAProductDev("Module W100 H231 D60 IMAGINE", 157, -150)
		.configure(157, -155)
		.threeDView()
		.editCeilingPropertiesDev(0, 150, "Kitchen", "Wall and floor tile", "9363", 0)
		.threeDView()
		.verifyCeilingPropertiesDev(0, 150, "Kitchen", "Wall and floor tile", "9363", 0)
		
		
		.addAProductSearchDev("lustre_32_light_RT_HQ", -100, -100)
		
//		.lightsOff(-100, -100)
		.lightsOn(-100, -100)
		.lightsOff(-100, -100)
		.lightsOn(-100, -100)
		.addAProductDev("1501", 50, 100)
		
//		.addAProductSearchDev("FGN2_LUSTRE_12k_lumen", -100, -100)
//		.lightsOn(-100, -100)
//		.lightsOff(-100, -100)
//		.lightsOn(-100, -100)
		.fpRotateDev(20, "right")
		.fpRotateDev(13, "down")
		.realisticImageClick()
		.getStarted()
		.setBackground(1, true)
		.setSunPosition(10, 40, 20, 50)
		.displayPeople(true)
		.lensOption(true, 0)
		.clickGenerateButton()
		.sendHQImageRequest("Large")
		.closeHQMessage()
//		.realisticImage("large", false)
		.save()
		.closePlanner()
		;		
		
	}
	/*
	@Test(dataProvider = "loginData", dataProviderClass = SignUpData.class, dependsOnMethods = { "testPlanner" })
	public void checkProjectDetails(SignUpData signUpData) {
		UserHomePage userHomePage = PageFactory.initElements(driver,
				UserHomePage.class);
		userHomePage.clickHomeTab().projectDetails(1);
	}
	*/

}
