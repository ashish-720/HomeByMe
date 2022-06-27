package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.MakeItYours;
import kitchen.bryo.pageObject.StartNow;

public class Waterfall extends Browser {
	@Test
	public void waterfallTest() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
				.startFromScratch()
				.step3()
//		.addCabinet("U2DA80", "Base Cabinets")
				.addProduct("U2DA80", true, false, false)
				.replaceProperty(-115, -11, "Worktop", "ACRYLIC WHITE", "",true, "")
				.verifyReplaceProperty(-115, -11, "Worktop", "ACRYLIC WHITE")
				.editWorktopWaterFallOptions(-115, -11, "", "yes","")
//		.verifyPrice("1 669,70")
				.worktopEditor(-115, -11)
				.editWorktopYes()
				.removeWaterfall(-130, -184)
				.addWaterfall(-130, -184, "")
				.editWaterfall(-120, -171)
				.cancelWorktopEditor()
//		.verifyPrice("1 669,70")
				.worktopEditor(-13, 9)
				.editWorktopYes()
				.editWaterfall(-137, -203)
				.createCutOut(-4, -15, "Circle", "", "", "", "", "155 mm")
				.verifyWorktopCutOut(4, 8, "", "", "", "155 mm", "316 mm", "440 mm")
				.addEdgeCut(115, 21, "Triple cut", "", "", "", "", "", "", "")
				.verifyEdgeCut(115, 72, "390 mm")
				.addSplitEdge(-109, 39)
				.verifySplit(-115, 21, "440 mm")
				.moveSplit(-115, 95, -175, 95)
				.verifyPriceInWorktop("1 358,80")
				.validateWorktopEditor();
	}
//		.verifyPrice("2 006,40");



	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class,dependsOnMethods = "waterfallTest")
	public void saveWaterfall(SignUpData signUpData) {
		MakeItYours save=PageFactory.initElements(driver, MakeItYours.class);
		save.saveProjectInStep3(signUpData, "ODT_WaterFall_Test" + UtilHBM.getDate(0, "yyyyMMdd"), "Save waterfall test")
		.closePlanner()
		.openMyProjectList()
		.searchProject("ODT_WaterFall_Test" + UtilHBM.getDate(0, "yyyyMMdd"))
		.openProject(0, "ODT_WaterFall_Test" + UtilHBM.getDate(0, "yyyyMMdd"))
//		.openProject()
//		.verifyPrice("2 006,40")
		.replaceCustomMaterial(-5, -24, "ACRYLIC WHITE", "QUARTZ GREY", "")
		.confirmCustomMaterialChange("Yes")
		.verifyReplaceProperty(-30, -5, "Worktop", "QUARTZ GREY")
		.undo(3)
		.verifyCustomMaterial(-5, -24, "ACRYLIC WHITE")
//		.verifyPrice("")
//		.priceInfoDetails();


		//Test scenarios for KIT-1895 : Business rule generated when waterfall colliding with worktop
				.twoDView().emptyRoom(200, 200, "KITCHEN", "16.0 m²", "Yes").threeDView()
				.addProduct("U2DA80", true, true, false)
				.editWorktopWaterFallOptions(-120, -50, "","yes","")
				.checkBusinessRulesCount(0, 0, 0)
				.verifyWorktopOptionsOverhangProperty(-120, -50, "0 mm", "41 mm", "", "true")
				.editWorktopOverHangOptions(-120, -50, "", "40 mm")
				.checkBusinessRulesCount(0, 1, 0)
				.checkBusinessRuleShowInWorktop("Waterfall worktop position", true)
				.cancelWorktopEditor()

		//Test scenarios for KIT-2110 : As a range maintainer, I want to be able to specify the waterfall inset
				//Scenario 1 : For worktops having 'waterfallType' option set to 'straight' , the app distr. settings for waterfall inset are used
				.twoDView().emptyRoom(200, 200, "KITCHEN", "16.0 m²", "Yes").threeDView()
				.addProduct("U2DA80", true, true, false).translateProduct(100, 0)
				.verifyWorktopOptionsProperty(0, -20, "30 mm", "30 mm", "", "")
				.editWorktopWaterFallOptions(0, -20,"yes", "yes","")
				.verifyWorktopOptionsProperty(0, -20, "41 mm", "41 mm", "", "")
				.worktopEditor(0, -20)
				.editWorktopYes()
				.verifyWorktopDimension(-5, -143, "882 mm")
				.verifyWorktopDimension(30, -180, "635 mm")
				.editWaterfall(30, -180)
				.verifyWorktopDimension(0, -150, "634 mm")
				.cancelWorktopEditor()

				//Scenario 2 : For worktops not having 'waterfallType' option set to 'straight' , the app distr. settings for waterfall inset are not used
				.editWorktopWaterFallOptions(0, 25,"no", "no","")
				.replaceProperty(0,25, "Worktop Option" , "LAMINATE BLACK","", true,"")
				.verifyWorktopOptionsProperty(0,25, "30 mm", "30 mm", "", "")
				.editWorktopWaterFallOptions(0, 25,"yes", "yes","")
				.verifyWorktopOptionsProperty(0,25, "38 mm", "38 mm", "", "")
				.worktopEditor(0,25)
				.editWorktopYes()
				.verifyWorktopDimension(-5, -143, "876 mm")
				.verifyWorktopDimension(30, -180, "635 mm")
				.editWaterfall(30, -180)
				.verifyWorktopDimension(0, -160, "635 mm")
				.cancelWorktopEditor()

				//Scenario 3: When cabinet back is not against a wall
				.translateProduct(0, 25, -10, 50)
				.worktopEditor(-10,70)
				.editWorktopYes()
				.verifyWorktopDimension(-16, -8, "876 mm")
				.verifyWorktopDimension(30, -45, "635 mm")
				.editWaterfall(30, -45)
				.verifyWorktopDimension(-5, -155, "635 mm")
				.cancelWorktopEditor()

				.editWorktopWaterFallOptions(-20,75,"no", "no","")
				.replaceProperty(-20,75, "Worktop Option" , "ACRYLIC WHITE","",true, "")
				.verifyWorktopOptionsProperty(-20,75, "30 mm", "30 mm", "", "")


		;

	}
}
