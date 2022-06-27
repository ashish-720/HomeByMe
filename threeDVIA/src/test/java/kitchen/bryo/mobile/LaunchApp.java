package kitchen.bryo.mobile;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.Mobile;
import hbm.planner.utility.UtilHBM;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.ProjectPage;
import kitchen.bryo.pageObject.HomePage;
import kitchen.bryo.pageObject.SelectMapping;
import kitchen.bryo.pageObject.StartNow;
import kitchen.bryo.pageObject.StylePage;


@Test
public class LaunchApp extends Browser {

	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void kitchenTestOnMobile(SignUpData signUpData) {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start
//		.launchApp()
		.startDemo("en-GB")
		.startFromScratchMobile()
		.ceilingHeightMobile("3000 mm")

//		FUN124212 : As a user, I cannot access upload 2D plan functionality when using a mobile device
		.initiatePlanMobile().verifyInitiatePlanOptionsAvailableMobile("Change the room shape > Use a HomeByMe project > Use a measuring code > Import laser measurements")

//		.verifyCeiling(-235, 25, "3000 mm")
		.editWallDimension(-5, -125, "4604 mm", "apply right")
//		.verifyWallPropertyMobile(-5, -125, "4604 mm")
		.splitWallMobile(-130, -2)

//		FUN123442: As a user, I can edit wall and floor coverings when using a mobile device
//		Testcases :
//			1. The Paint & Covering option should not be visible in the mobile device in the floorplan state.
//			2. When user select the wall in 3d, the wall related catalogue for covering should open and after selecting any product it will ask you for the Apply/ Apply to all. When selecting any option the covering should be applied, and the catalogue browser should be get closed itself.
//			3. When user select the floor in 3d, the flooring related catalogue for covering should open and after selecting any product it will ask you for the Apply/ Apply to all. When selecting any option the covering should be applied, and the catalogue browser should be get closed itself. 
		.threeDViewMobile()
		.addCoveringByClickingWallFloorMobile(42, -117,"PAINT|4351","all")
		.clickBlankAfterPaintMobile()
		.verify3DwallpaintMobile(42, -117, "PAINT|4351")
		.verifyLastUsedMaterial("4351")
		.addCoveringByClickingWallFloorMobile(42, -117, "PAINT|4363", "selection")
		.clickBlankAfterPaintMobile()
		.clickBlankAfterPaintMobile()
		.clickWallFloorMobile(42, -117)
		.applyMaterialFromLastUsedList("4351",42,-117)
		.clickBlankAfterPaintMobile()
		.clickWallFloorMobile(42, -117)
		.verifyLastUsedMaterial("4351")
		.closeCoveringCatalogMobile()
		.clickBlankAfterPaintMobile()
		//FUN123442 : END
		.openBottomSheet()
//		.moveWallMobile(-138, 145, -100, 145)
//		.verifyWallProperty(-100, 145, "2075 mm");
		.addProductMobile("INTERIOR DOOR", false, false)
		.addProductMobile("DOUBLE WINDOW", false, false)

//		FUN123929 : As a user, I cannot edit the position of items when using a mobile device
		.verifyBottomSheetToolsForProductMobile(0, 106,"Edit > Duplicate > Delete")

		.addWaterSupplyMobile(135, 40)
		.nextStep()
		.skipLayoutNoReturnPickALayout()
		 .lookingForNeedMappingMobile("Update my needs", SelectMapping.class)
         .updateStyleMappingMobile("Stockholm - Black","38mm Acrylic Worktop",null)
         .updateLayoutMapping("L-shaped")
         .updateCookingMapping("Integrated")
         .updateRefrigerationMapping("Integrated")
         .generateNewLayouts()
		.findSolutionsMobile("53")
		.nextStepDesignYourKitchenMobile("No", "")
		.twoDViewMobile()
		.threeDViewMobile()
		.deleteProductMobile(-125, 5)
		.openBottomSheet()
		.addProductMobile("GVARIO03", false, false, false)
		.addProductThroughSearchMobile("W6002", "W6002", false)

//		FUN123929 : As a user, I cannot edit the position of items when using a mobile device
		.verifyBottomSheetToolsForCabinetMobile(104, -40,"Edit > Open > Duplicate > Delete")

		.openCloseMobile(-30, 25, -30, 25)
		.duplicateProductMobile(104, -40)
		.saveProjectInStep3Mobile(signUpData, "MobileODT_"+ UtilHBM.getDate(0, "yyyyMMdd"), "Mobile ODT")
		.closePlannerMobile()
		.openMyProjectListMobile()
		.openProjectMobile(0, "MobileODT_"+ UtilHBM.getDate(0, "yyyyMMdd"))
		.step4Mobile()
		.verifyProjectNameAndPriceMobile("MobileODT_"+ UtilHBM.getDate(0, "yyyyMMdd"),"");
		
	}
	
}
