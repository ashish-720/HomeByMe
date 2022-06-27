package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class Worktop extends Browser {
	@Test
	public void worktopEditorTest() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.addProduct("U2DA80", true, false, false)
		.editWorktopOverHangOptions(-115, -11, "", "-1 mm")
		.editWorktopOverHangOptions(-115, -11, "", "251 mm")
		.deleteProperty(-115, -11, "Worktop")
		.verifyDeleteProperty(-115, -11, "Worktop")
		.addProperty(-115, -11, "Worktop","LAMINATE BLACK", "", true)
		.verifyAddProperty(-115, -11, "Worktop","LAMINATE BLACK")
		.worktopEditor(-115, -11)
		.editWorktopYes()
		.deleteWorktop(-181, -182)
		.verifyPriceInWorktop("0,00")
		.undoInWorktopEditor(driver, 2)
		.verifyPriceInWorktop("488,11")
		.verifyDeletedWorktopRestored(-181, -182)
		.createCutOut(-181, -182, "Rectangle", "34 mm", "34 mm", "yes", "2 mm", "")
		.createCutOut(-181, -170, "Circle", "", "", "", "", "5 mm")
		.cancelWorktopEditor()
		.verifyProduct(-4, 13, "U2DA80")
		.verifyAddProperty(-4, 13, "Worktop", "LAMINATE BLACK")
		.worktopEditor(-4, 13)
		//KIT:1678 -As a user, when closing the "more about worktop/wall panel types" I am presented with the previous pop-in
		.editWorktopByCheckingLearnMoreAboutWorkop()
		//KIT:1678 END
		.createCutOut(-181, -182, "Rectangle", "200 mm", "200 mm", "no", "", "")
		.validateWorktopEditor()
		.replaceCustomMaterial(15, -13, "LAMINATE BLACK","ACRYLIC WHITE", "")
		.confirmCustomMaterialChange("Yes")
		.verifyReplaceProperty(-4, 13, "Worktop","ACRYLIC WHITE")
		.twoDView()
		.threeDView()
		.worktopEditor(-6, -17)
		.editWorktopYes()
//		.tooltipsWorktop()
		.cornerCutForWallPanel(-129, -156, "Inner Rounded", "", "", "", "", "","140 mm")
		.verifyCornerCutForWallPanel(-133, -177, "495 mm")
		.createCutOut(-181, -182, "Rectangle", "200 mm", "200 mm", "no", "", "")
		.verifyWorktopCutOut(-182, -187, "200 mm", "200 mm", "", "", "347 mm", "218 mm")
//		.verifyPriceInWorktop("689,80")
		.verifyWorktopCutOut(-182, -187, "200 mm", "200 mm", "", "", "347 mm", "218 mm")
		.undoInWorktopEditor(driver, 4)
		.verifyDeletedCutOut(-182, -187)
//		.verifyPriceInWorktop("589,80")
		.addJoint(-185, -159)
//		.verifyPriceInWorktop("917,80")
		.addWaterfall(-137, -203, "1 393,20")
//		.verifyPriceInWorktop("1 392,40")
		.editWaterfall(-137, -203)
//		.verifyPriceInWorktop("1 393,00")
		.addJoint(0, -161)
//		.verifyPriceInWorktop("1 881,80")
		.addEdgeCut(-89, 30, "Triple cut", "", "", "", "", "", "", "")
//		.verifyEdgeCut(-41, -39, "390 mm")
//		.verifyPriceInWorktop("2 050,80")
		.mainWorktopView("2 051,20")
		.addSplitEdge(-165, -137)
		.verifySplit(-165, -137, "318 mm")
//		.verifyPriceInWorktop("2 050,80")
		.addEdgeCut(-204, -158, "Triple cut", "145 mm", "145 mm", "220 mm", "no", "", "", "")
		.verifyEdgeCut(-216, -163, "343 mm")
//		.verifyPriceInWorktop("2 180,00")
//		.validateWorktopEditor()
//		.verifyPrice("2 893,00")
//		.worktopEditor(-23,-12, "2 180,00")
//		.cancelWorktopEditor()
//		.verifyPrice("2 893,00");
		.validateWorktopEditor()

//		Test scenarios for KIT-1810 : User notified if worktop overlaps
				//scenario 1 : BR triggered when there is a overlap while spliting and moving worktop edges
				.twoDView().emptyRoom(200, 200, "KITCHEN", "16.0 m²", "Yes").threeDView()
//				.verifyPrice("0,00")
				.addProduct("U2DA602", true, true, false)
				.addProduct("U2DA80", true, true, false)
				.replaceProperty(-65, -10, "Worktop", "ACRYLIC WHITE", "", true,"")
				.verifyReplaceProperty(-65, -10, "Worktop", "ACRYLIC WHITE")
				.worktopEditor(-65, -10)
				.editWorktopYes()
				.splitWorktop(-100, -150)
				.verifySplitInWorktop(-134, -180)
				.moveSplit(-134, -180,-94,-180)
				.moveSplit(-134, -180,-20,-180)
				.checkWorktopEditorBusinessRules("Worktop position")
				.validateWorktopEditor()
				.checkBusinessRuleShowIn3D("Worktop position", true)

				//scenario 2 : BR triggered when overlap occurs between a custom worktop on a cabinet and a freestanding worktop
				.twoDView().threeDView()
				.deleteProduct(-28,-24).deleteProduct(26,-5)
//				.selectMultipleProducts("-25,-68 > 27,-53").deleteProduct("")
				.addProperty(0,25,"Worktop", "ACRYLIC WHITE", "", true)
				.worktopEditor(0,25)
				.editWorktopYes()
				.createCutOut(-200, -200, "Rectangle", "200 mm", "200 mm", "", "", "")
				.validateWorktopEditor()
				.addProductThroughSearch("Worktop", "ACRYLIC WHITE", true, false)
				.editFreeStandingWorktopProperties(0,45,false,"","", "880 mm")
				.clickBlank()
				.translateProduct(0,45,0, -50)
				.checkBusinessRuleShowIn3D("Worktop position", true)
				.modifyFreestandingWorktop(0,0,"")
				.checkWorktopEditorBusinessRules("Worktop position")
				.cancelWorktopEditor();
	}
}
