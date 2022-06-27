package kitchen.bryo.scenarioTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.FloorPlan;
import kitchen.bryo.pageObject.HomePage;
import kitchen.bryo.pageObject.StartNow;
import kitchen.bryo.pageObject.StylePage;

public class BryoDemoScenarioTest extends Browser {

	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)

	public void demoScenarioTest(SignUpData signUpData) {
		if (driver.getCurrentUrl().contains("preprod-bryo")) {
			StartNow start = PageFactory.initElements(driver, StartNow.class);
			start.startDemo("en-GB");
			HomePage home = PageFactory.initElements(driver, HomePage.class);
			home.startKitchenDesign();
			StylePage style = PageFactory.initElements(driver, StylePage.class);
			style.selectStyleMapping("Paris - Grey", "38mm Acrylic Worktop", "143mm Bar Handle")
					.layoutMapping("L-shaped").cookingMapping("Integrated").refrigerationMapping("Integrated")
					.startPlanning();
			FloorPlan plan = PageFactory.initElements(driver, FloorPlan.class);
			plan.ceiling("3000 mm").verifyCeiling(-235, 25, "3000 mm")
					.editWallDimension(27, -251, "4604 mm", "apply right").verifyWallProperty(27, -251, "4604 mm")
					.splitWall(-248, 111).moveWall(-252, 122, -10, 122).verifyWallProperty(-10, 122, "2075 mm")
					.editWallDimension(-249, -92, "2222 mm", "apply above").verifyWallProperty(-249, -92, "2222 mm")
					.editWallDimension(-180, 2, "816 mm", "apply right").verifyWallProperty(-180, 2, "816 mm")
					.editWallDimension(-156, 119, "2445 mm", "apply below").verifyWallProperty(-156, 119, "2445 mm")
					.addProduct("INTERIOR DOOR", false, false).moveWall(-157, 149, -62, 304)
					.editBayDimensions(-63, 250, 392, 300).verifyBayDimension(-63, 250, 300, 1)
					.moveWall(250, 250, 280, 250).addProduct("DOUBLE WINDOW", false, false)
					.moveWall(-164, 158, -26, -242)
					.editItemDimensionProperties(-26, -242, "", "1200 mm", "1250 mm", "", "1300 mm", 0)
					.verifyItemDimensionProperties(-26, -242, "", "1200 mm", "1250 mm", "", "1300 mm")
					.editBayDimensions(-26, -242, 1519, 750).verifyBayDimension(-114, -242, 750, 1)
					.addProduct("PATIO DOOR|4875", false, false).moveWall(-164, 158, 242, -47)
					.editBayDimensions(242, -47, 533, 700).verifyBayDimension(243, -93, 700, 1).duplicate(243, -93)
					.moveWall(-164, 158, 249, 137).editBayDimensions(249, 137, 2370, 2650)
					.verifyBayDimension(249, 137, 2650, 1).addCovering("PAINT|4351", "selection").applyMaterialIn3D(74, -125).clickBlankAfterPaint()
					.addCovering("PAINT|4351", "selection").applyMaterialIn3D(-156, -111).addCovering("HARDWOOD|4270", "").applyMaterialIn3D(94, 74).nextStep()
					.waterSupplyPositionPopUp("Yes", -9, -204)
					.findSolutions("L shaped kitchen with integrated oven and fridge - 2")
					.nextStepDesignYourKitchen("No", "").twoDView().threeDView().rotateProjectView(1, "right")
					.replaceProperty(90, 0, "Cooktop", "JEAN BAPTISTE", "",true, "")
					.verifyReplaceProperty(90, 0, "Cooktop", "JEAN BAPTISTE")
					.replaceProperty(-10, -20, "Faucet", "BENJ", "",true, "")
					.verifyReplaceProperty(-10, -20, "Faucet", "BENJ")
					.replaceProperty(-10, -20, "Worktop", "LAMINATE BLACK", "all",true, "")
					.verifyReplaceProperty(-10, -20, "Worktop", "LAMINATE BLACK")
					.replaceProperty(-10, -20, "Front", "OPERA", "all", true,"")
					.verifyReplaceProperty(-10, -20, "Front", "OPERA")
					.replaceProperty(-10, -20, "Front", "MADELEINE", "all",true, "")
					.verifyReplaceProperty(-10, -20, "Front", "MADELEINE")
					.replaceProperty(-10, -20, "Handle", "LAURA", "all", true,"")
					.verifyReplaceProperty(-10, -20, "Handle", "LAURA")
					.addProperty(161, -83, "Deco Strip", "MADELEINE", "all", true)
					.verifyAddProperty(161, -83, "Deco Strip", "MADELEINE")
					.addProperty(164, -143, "Cornice", "MADELEINE", "selection", true)
					.verifyAddProperty(164, -143, "Cornice", "MADELEINE")
					.addDirectProperty(164, -143, "Top Light", "", "").verifyAddProperty(164, -143, "Top Light", "CHARLOTTE")
					.rotateProjectView(21, "left").zoomIn(6).addDirectProperty(-89, -159, "Top Light", "", "")
					.verifyAddProperty(-89, -159, "Top Light", "CHARLOTTE").addDirectProperty(-13, -35, "Top Light", "", "")
					.verifyAddProperty(-13, -35, "Top Light", "CHARLOTTE").addDirectProperty(36, -145, "Top Light", "", "")
					.verifyAddProperty(36, -145, "Top Light", "CHARLOTTE").addDirectProperty(86, -157, "Top Light", "", "")
					.verifyAddProperty(86, -157, "Top Light", "CHARLOTTE").twoDView().threeDView()
					.editWorktopOverHangOptions(54, 110, "", "250 mm")
					.verifyWorktopOptionsProperty(54, 110, "30 mm", "250 mm", "", "")
					//		.productList()
					.saveProjectInStep3(signUpData, "ODT_DEMO_SCENARIO" + UtilHBM.getDate(0, "yyyyMMdd"),
							"MY BRYO KITCHEN created on" + UtilHBM.getDate(0, "yyyyMMdd"))
					.closePlanner()
					.openMyProjectList()
					.openProject(0, "ODT_DEMO_SCENARIO" + UtilHBM.getDate(0, "yyyyMMdd"))
					.verifyWorktopOptionsProperty(54, 110, "30 mm", "250 mm", "", "").viewHeightIn3D("Worktop")
					.verifyViewHeightIn3D("Worktop").displayFront().twoDView().threeDView()
					.rotateProjectView(20, "left").replaceProductFromEdit(33, -105, "UD2SA30", true, false, false)
					.deleteProduct(46, -131).addProductThroughSearch("W6002", "W6002", true, false)
					.verifyReplaceProperty(46, -131, "Front", "MADELEINE").twoDView().threeDView()
					.replaceProperty(27, -36, "Worktop", "ACRYLIC WHITE", "all",true, "")
					.twoDView().threeDView()
					.verifyReplaceProperty(27, -36, "Worktop", "ACRYLIC WHITE")
					.zoomOut(4)
					.worktopEditor(63,106).editWorktopYes().zoomIn(3)
					.addWaterfall(-58,2, "4 298,90")
					.validateWorktopEditor()
					.twoDView().threeDView().addProperty(-11, -34, "Wall Panel", "DK_WP_GLASS", "all", true)
					.verifyAddProperty(-11, -34, "Wall Panel", "DK_WP_GLASS")
					.editWallPanelOptionsProperty(-11, -34, "200 mm", "", "17 324,10", "")
					.verifyWallPanelOptionsProperty(-11, -34, "200 mm", "", "", "", "", "")
					.checkBusinessRuleShowIn3D("Distance between gas hob and wall panel", true).step4()
					.clickDesignStep().realisticImage(2);

		} else {
			StartNow start = PageFactory.initElements(driver, StartNow.class);
			start.startDemo("en-GB");
			HomePage home = PageFactory.initElements(driver, HomePage.class);
			home.startKitchenDesign();
			StylePage style = PageFactory.initElements(driver, StylePage.class);
			style.selectStyleMapping("Paris - Grey", "38mm Acrylic Worktop", "143mm Bar Handle")
					.layoutMapping("L-shaped").cookingMapping("Integrated").refrigerationMapping("Integrated")
					.startPlanning();
			FloorPlan plan = PageFactory.initElements(driver, FloorPlan.class);
			plan.ceiling("3000 mm").verifyCeiling(-260, 21, "3000 mm")
					.editWallDimension(27, -251, "4604 mm", "apply right").verifyWallProperty(27, -251, "4604 mm")
					.splitWall(-248, 111).moveWall(-252, 122, -10, 122).verifyWallProperty(-10, 122, "2075 mm")
					.editWallDimension(-249, -92, "2222 mm", "apply above").verifyWallProperty(-249, -92, "2222 mm")
					.editWallDimension(-139, 2, "816 mm", "apply right").verifyWallProperty(-139, 2, "816 mm")
					.editWallDimension(-156, 119, "2445 mm", "apply below").verifyWallProperty(-156, 119, "2445 mm")
					.addProduct("INTERIOR DOOR", false, false).moveWall(-157, 149, -62, 304)
					.editBayDimensions(-56, 302, 274, 300).verifyBayDimension(-56, 302, 300, 1)
					.moveWall(316, 305, 351, 287).addProduct("DOUBLE WINDOW", false, false)
					.moveWall(-149, 109, 28, -301)
					.editItemDimensionProperties(61, -282, "", "1200 mm", "1250 mm", "", "1300 mm", 0)
					.verifyItemDimensionProperties(61, -282, "", "1200 mm", "1250 mm", "", "1300 mm")
					.editBayDimensions(61, -282, 1630, 750).verifyBayDimension(-85, -282, 750, 1)
					.addProduct("PATIO DOOR|4875", false, false).moveWall(-149, 109, 318, -46)
					.editBayDimensions(331, -66, 1265, 700).verifyBayDimension(331, -66, 700, 1).duplicate(333, -73)
					.moveWall(327, -222, 351, 224).editBayDimensions(348, 198, 2558, 2650)
					.verifyBayDimension(249, 137, 2650, 1).addCovering("PAINT|4351", "selection").applyMaterialIn3D(74, -125)
					.addCovering("PAINT|4351", "selection").applyMaterialIn3D(-156, -111).addCovering("HARDWOOD|4270", "").applyMaterialIn3D(94, 74).nextStep()
					.waterSupplyPositionPopUp("Yes", -9, -204)
					.findSolutions("L shaped kitchen with integrated oven and fridge - 2")
					.nextStepDesignYourKitchen("No", "").twoDView().threeDView()
					.replaceProperty(82, -33, "Cooktop", "600MM GAS HOB", "",true, "")
					.verifyReplaceProperty(82, -33, "Cooktop", "600MM GAS HOB")
					.replaceProperty(-11, -49, "Faucet", "STAINLESS STEEL MIXER FAUCET", "",true, "")
					.verifyReplaceProperty(-11, -49, "Faucet", "STAINLESS STEEL MIXER FAUCET")
					.replaceProperty(-11, -49, "Worktop", "38MM LAMINATE WORKTOP", "all", true,"")
					.verifyReplaceProperty(-11, -49, "Worktop", "38MM LAMINATE WORKTOP")
					.replaceProperty(-11, -49, "Front", "OTTAWA", "all",true, "")
					.verifyReplaceProperty(-11, -49, "Front", "OTTAWA")
					.replaceProperty(-11, -49, "Front", "PARIS", "all", true,"")
					.verifyReplaceProperty(-11, -49, "Front", "PARIS")
					.replaceProperty(-11, -49, "Handle", "143MM BAR HANDLE", "all",true, "")
					.verifyReplaceProperty(-11, -49, "Handle", "143MM BAR HANDLE")
					.replaceProperty(-11, -49, "Handle", "234MM BAR HANDLE", "all",true, "")
					.verifyReplaceProperty(-11, -49, "Handle", "234MM BAR HANDLE")
					.replaceProperty(-11, -49, "Handle", "170MM BAR HANDLE", "all", true,"")
					.verifyReplaceProperty(-11, -49, "Handle", "170MM BAR HANDLE")
					.addProperty(160, -115, "Deco Strip", "PARIS|1", "all", true)
					.verifyAddProperty(160, -115, "Deco Strip", "PARIS")
					.addProperty(158, -169, "Cornice", "PARIS", "selection", true)
					.verifyAddProperty(158, -169, "Cornice", "PARIS").rotateProjectView(20, "left")
					.addProperty(244, -134, "Top Light", "", "", true)
					.verifyAddProperty(244, -134, "Top Light", "LED CABINET LIGHT")
					.addProperty(-35, -137, "Top Light", "", "", true)
					.verifyAddProperty(-35, -137, "Top Light", "LED CABINET LIGHT")
					.addProperty(7, -156, "Top Light", "", "", true)
					.verifyAddProperty(7, -156, "Top Light", "LED CABINET LIGHT")
					.addProperty(31, -149, "Top Light", "", "", true)
					.verifyAddProperty(31, -149, "Top Light", "LED CABINET LIGHT")
					.addProperty(62, -160, "Top Light", "", "", true)
					.verifyAddProperty(62, -160, "Top Light", "LED CABINET LIGHT").twoDView().threeDView()
					.editWorktopOverHangOptions(29, 40, "250 mm", "")
					.verifyWorktopOptionsProperty(29, 40, "250 mm", "", "", "")
					//			.productList()
					.saveProjectInStep3(signUpData, "ODT_DEMO_SCENARIO" + UtilHBM.getDate(0, "yyyyMMdd"),
							"MY BRYO KITCHEN created on" + UtilHBM.getDate(0, "yyyyMMdd"))
					.closePlanner().openMyProjectList()
					.openProject(0, "ODT_DEMO_SCENARIO" + UtilHBM.getDate(0, "yyyyMMdd"))
					.viewHeightIn3D("Worktop").verifyViewHeightIn3D("Worktop").displayFront().twoDView().threeDView()
					.rotateProjectView(20, "left")
					.replaceProductFromEdit(40, -69, "UD2SA30", true, false, false).deleteProduct(65, -170)
					.addProductThroughSearch("W6002", "W6002", true, false)
					//.position(65, -170, "673 mm", "563 mm", "16 871,00")
					//.verifyPosition(65, -170, "563 mm")
					//.position(65, -170, "62 mm", "75 mm", "16 921,00")
					//.verifyPosition(65, -170, "75 mm")
					//.verifyAddProperty(65, -170, "Cornice")
					.twoDView().threeDView().replaceProperty(29, 40, "Worktop", "38MM ACRYLIC WORKTOP", "all", true,"")
					.verifyReplaceProperty(29, 40, "Worktop", "38MM ACRYLIC WORKTOP").worktopEditor(-51, 22).zoomIn(3)
					.addWaterfall(-105, -13, "921.00").checkWorktopEditorBusinessRules("Missing edge finishes")
					//.addWaterfallEdges(-105, -13, "ALUMINIUM EDGE", "ALUMINIUM EDGE")
					//.verifyWaterfallEdges(-105, -13, "ALUMINIUM EDGE", "ALUMINIUM EDGE")
					//.worktopEditorBusinessRulesRemoved("Missing edge finishes")
					.validateWorktopEditor()
					.twoDView().threeDView().addProperty(27, -46, "Wall Panel", "6MM GLASS WALL PANEL", "all", true)
					.verifyAddProperty(27, -46, "Wall Panel", "6MM GLASS WALL PANEL")
					.editWallPanelOptionsProperty(27, -46, "200 mm", "", "16,833.90", "")
					.verifyWallPanelOptionsProperty(27, -46, "200 mm", "", "", "", "", "")
					.checkBusinessRuleShowIn3D("Distance between gas hob and wall panel", true).step4()
					.clickDesignStep().realisticImage(2);

		}
	}
}
