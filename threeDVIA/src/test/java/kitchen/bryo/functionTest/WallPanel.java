package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class WallPanel extends Browser {
	@Test
	public void wallPanelTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.addProduct("U2DA80", true, false, false)
		.addProperty(-115,-30, "Wall Panel", "NO_WP_LAMINATE", "all", true)
//		.verifyReducedOrMemberPrice("reduced-price", "953,00")
		.verifyAddProperty(-115,-30,"Wall Panel", "NO_WP_LAMINATE")
		.editWallPanelOptionsProperty(-115,-30, "400 mm", "", "838,20", "")
		.verifyWallPanelOptionsProperty(-115,-30, "400 mm", "", "", "", "", "")
		.wallPanelEditor(-115,-30)
		.editWallPanelYes()
		.toolTipsWallPanel()
		//FUN121949 :As a user, I can delete a wall panel within the wall panel editor
		.deleteWallpanel(-226, 41)
//		.verifyPriceInWallPanel("0,00") // uncomment after IR correction for price pop-up
		.undoInWallPanelEditor(driver, 2)
		.verifyPriceInWallPanel("100,00")
		.verifyDeletedWallpanelRestored(-226, 41)
		//FUN121949: END
		.verifyWallPanelHeight(-226,41, "400 mm")
		.changeGrainDirection(-226,41)
		.createCutOutForWallPanel(-235,41, "Rectangle","200 mm", "200 mm", "yes", "20 mm", "")
		.changeGrainDirection(-256, 31)
		.verifyPriceInWallPanel("135,20")
		.addSplit(-250,15)
		.editWallPanelDimension(-250, 15, "440 mm","600 mm", "left")
		.verifyWallPanelDimension(-250, 15, "600 mm")
		.checkBusinessRuleInWallPanel("Wall panel position")
		.undoInWallPanelEditor(driver, 2)
		.verifyBusinessRuleInWallPanelRemoved("Wall panel position")
		.cancelWallPanelEditor()
		.twoDView()
		.threeDView()
		.editWallPanelOptionsProperty(3,16, "550 mm", "", "851,40", "")
		.wallPanelEditor(3,16)
		.editWallPanelYes()
		.verifyWallPanelHeight(-224,28, "550 mm")
		.addWallPanelJoint(-217,-8,"440 mm")
		.dragJoint(-223, 29, -205, -15)
		.verifyWallPanelDimension(-205, 40, "565 mm")
		.undoInWallPanelEditor(driver, 3)
		//editor.verifyWallPanelJoint("bryoVerifyWallPanelJoint");
		.verifyWallPanelJoint(-228,31, "880 mm")
		//editor.verifyWallPanelRemoveJoint("bryoVerifyWallPanelRemoveJoint");
		.createCutOutForWallPanel(-224,28, "Rectangle","200 mm", "200 mm", "yes", "20 mm", "")
		.verifyCutOutForWallPanel(-224,28,"200 mm","200 mm","20 mm","", "347 mm", "175 mm")
		.deleteCutOrCutOuts(-224,28)
		.verifyDeletedCutOrCutOut(-224,28)
		.createCutOutForWallPanel(-237,41, "Rectangle","200 mm", "200 mm", "yes", "20 mm", "")
		.verifyCutOutForWallPanel(-237,41,"200 mm","200 mm","20 mm","", "347 mm", "175 mm")
		.moveCutOut(-237, 41, -50, 35)
		.verifyCutOutForWallPanel(-50, 35,"200 mm","200 mm","20 mm","", "1550 mm", "")
		.checkBusinessRuleInWallPanel("Wall panel cut-out position")
		.undoInWallPanelEditor(driver, 1)
		.verifyBusinessRuleInWallPanelRemoved("Wall panel cut-out position")
		.undoInWallPanelEditor(driver, 5)
		.verifyDeletedCutOrCutOut(-237,41)
		.createCutOutForWallPanel(-224,28, "Circle","", "", "", "", "150 mm")
		.verifyCutOutForWallPanel(-224,28,"","","","150 mm", "347 mm", "175 mm")
		.deleteCutOrCutOuts(-224,28)
		.editWallPanelDimension(-217,-8,"880 mm", "900 mm","right")
		.verifyWallPanelDimension(-217,-8, "900 mm")
		.cornerCutForWallPanel(-159, -10, "Double","","", "115 mm", "115 mm", "no", "", "")
		.verifyCornerCutForWallPanel(-224,28, "115 mm")
		.addWallPanelEdgeCut(-217,-8, "145 mm","145 mm", "220 mm", "no", "", "")
		.verifyWallPanelEdgeCut(-217,-8,"608 mm")
		.validateWallPanelEditor()
		.twoDView()
		.threeDView()
		.verifyCustomMaterial(8,-40, "NO_WP_LAMINATE")
		.deleteProduct(8, -40)
		.undo(1)
		.redo(driver, 1)
		.undo(1)
		.replaceCustomMaterial(8,-40, "NO_WP_LAMINATE", "GEN_WP_OAK", "")
		.confirmCustomMaterialChange("Yes")
		.verifyReplaceProperty(3,-17, "Wall Panel", "GEN_WP_OAK")
		.deleteProperty(3,-17, "Wall Panel")
		.verifyDeleteProperty(3,-17, "Wall Panel")

		//Test for KIT-1701 : As a kitchen retailer, I can choose to hide the replace button
				.verifyReplaceButtonPresent(3,-17, "yes")
				.addProductThroughSearch("ODT_BoxAssembly_KIT1701","ODT_BoxAssembly_KIT1701", true, false)
				.verifyReplaceButtonPresent(32, -5, "no")

        //Test scenario for FUN120666 : As a user, I can zoom further in linear editors : wallpanel
				.addProperty(25,25, "wallPanelOption", "DK_WP_GLASS", "selected", true)
				.wallPanelEditor(25,25).editWallPanelYes()
				.editWallPanelDimension(-115,-8,"630 mm","900 mm","apply right")
				.clickAndDrag(110,-20)
				.zoomIn(20)
				.addWallPanelEdgeCut(-450, 65, "100 mm", "100 mm", "200 mm", "no", "", "")
				.addWallPanelEdgeCut(165, -241, "100 mm", "100 mm", "600 mm", "no", "", "")
				.validateWallPanelEditor();
	}
}
