package hbm.test.app;

import hbm.planner.dataobject.NewProjectData;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class RedWirePlatformDev extends Browser{
	
	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class)
	public void hbmRedwireLogin(SignUpData signUpData){		
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.loginDev(signUpData)
//		.addAProduct("2505", "GuestRoom", 0, 0)
//		.editGenericProperties("Beams", "20.0 cm", "25.0 cm", "150.0 cm", "Wood", 0, "1225")
//		.verifyGenericProperties("BeamsEdit", "20.0 cm", "25.0 cm", "150.0 cm", "1225")
		;
	}
	
	@Test(dataProvider = "projectData", dataProviderClass = NewProjectData.class, dependsOnMethods = "hbmRedwireLogin")
	public void redWire(NewProjectData newProjectData){		
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.createProjectDev(newProjectData)			
			.addARoom(10, "40", "Guest room")
			.wallDev("GuestRoom")
			.addAProductDev("LES EXCLUSIVES - ONDE", -243, 246)
			.addAProductDev("Interior door", 280, -182)
			.addAProductDev("LUMYS", -327, -46)
			.editFloorPropertiesDev(-170, -215, "Kitchen", "Vinyl", "4101", 0)
			.editFloorPropertiesDev(170, -225, "Bathroom", "Wall and floor tile", "3961", 0)
			.verifyFloorPropertiesDev(-170, -215, "Kitchen", "Vinyl", "4101", 0)
			.edit2DWallPropertiesDev(-90, -184, "9", "1", "", "")
			.verify2DWallPropertiesDev(-90, -184, "9 cm", "10 cm", "430 cm", 0, "NA", "")
			.addAProductDev("Kitchen set I shape l340", -160, -290)
			.exteriorDev(0, 0, 1, "100")
			.editDoorWinPropertiesDev(-327, -46, "220", "200", "10", 1, 0)
			.editBayDimensionDev(-327, -46, 33, 40)
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
			.save().snapshot3D("3D", 1).snapshot3D("3D", 2)
//			UtilHBM.verifyScreen("HBMRedWireValidation");
			.fpRotateDev(7, "down")
			.realisticImageClick()
			.getStarted()
			.setBackground(2, true)
			.setSunPosition(10, 40, 20, 50)
			//.artifitialLight(true, true)
			//.displayPeople(true)
			.lensOption(true, 0)
			.cameraHeight(0, 20)
			.clickGenerateButton()
			.sendHQImageRequest("small")
			.closeHQMessage()
			.realisticImageClick()
			.getStarted()
			.setBackground(2, true)
			.setSunPosition(10, 40, 20, 50)
			//.artifitialLight(true, true)
			//.displayPeople(true)
			.lensOption(true, 2)
			.cameraHeight(0, 20)
			.clickGenerateButton()
			.sendHQImageRequest("large")
			.closeHQMessage()
			.panoramic360(2)
			.openProject(0)
			.threeDView().twoDView()
			.verifyBayDimensionDev(-327, -46, 40, 1)
			.verifyDoorWinPropertiesDev(-327, -46, "220.0 cm", "200.0 cm", "10.0 cm")
			.verifyGenericPropertiesDev(-120, -25, "90.0 cm", "230.0 cm", "105.0 cm", "2328")
			.editGenericPropertiesDev(-120, -25, "92 cm", "200.0 cm", "100", "Satin paint", 8, "1514")
			.editDoorWinPropertiesDev(-327, -46, "215", "240", "0", 1, 0)
			.editBayDimensionDev(-327, -46, 20, 24)
			.save()
			.threeDView().openProject(0)
			.threeDView().twoDView()						
			.verifyDoorWinPropertiesDev(-327, -46, "215.0 cm", "240.0 cm", "0.0 cm")
			.verifyBayDimensionDev(-327, -46, 24, 1)
			.threeDView()
			.verifyGenericPropertiesDev(-100, 60, "92.0 cm", "200.0 cm", "100.0 cm", "1514")
			.verifyFloorPropertiesDev(-90, -30, "Kitchen", "Vinyl", "4101", 0)
			.verify3DWallPropertiesDev(130, -70, "Matt paint", 3, "10606", 1)
			.snapshot3D("3D", 3);		
	}
}