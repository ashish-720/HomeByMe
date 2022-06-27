package enterprise.bathroom.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class BathsAndShowers extends Browser {
	@Test
	public void bathsAndShowerTest(){
		
			StartNow start = PageFactory.initElements(driver, StartNow.class);
			start.launchApp()
					.step3()

	//Adding "Swing Door Shower" product:
					.addProductBathroom("Swing Door Shower", true, false, false)
					.replaceProperty(-113, -50, "Shower Tray", "Shower Tray - Black", "",true, "")
					.verifyReplaceProperty(-113, -50, "Shower Tray", "Shower Tray - Black")
					.replaceProperty(-113, -50, "Shower Tray", "Shower Tray", "", true,"")
					.verifyReplaceProperty(-113, -50, "Shower Tray", "Shower Tray")
					.duplicateProduct(-113, -50)
					.openClose(-42, -54, -42, -54)
					.deleteProduct(-42, -54)
					.undo(1)
					.openClose(-42, -54, -42, -54)
					.deleteProductUsingShortCutKey(-40, -28)
					.deleteProduct(-113, -50)
					.undo(1)
					.openClose(-113, -50, -113, -50)
					.verifyReplaceProperty(-113, -50, "Shower Tray", "Shower Tray")
					.deleteProductUsingShortCutKey(-113, -50)
//
	//Adding "Walk in shower" product:
					.addProductBathroom("Walk in Shower", true, false, false)
					.addProductBathroom("Swing Door Shower",true,false,false)
					.replaceProperty(-113, -50, "Shower Tray", "Shower Tray - Black", "all",true, "")
					.verifyReplaceProperty(-113, -50, "Shower Tray", "Shower Tray - Black")
					.replaceProperty(-113, -50, "Shower Tray", "Shower Tray", "all", true,"")
					.verifyReplaceProperty(-113, -50, "Shower Tray", "Shower Tray")
					.position(-9,-50,"1900 mm","100 mm", "")
					.deleteProduct(124, -56)
					.undo(1)

	//	Adding "Bathtub assembly" product:
					.addProductBathroom("Bathtub assembly", true, false, false)
					.verifyProduct(14,-14,"Bathtub assembly")
					.position(14,-9,"3250 mm", "600 mm","")
					.duplicateProduct(10,152)
					.deleteProduct(10,152)
					.position(126,-43, "3071 mm", "400 mm","")
					.duplicateProduct(157,164)
					.deleteProduct(157,164)
					.verifyProduct(126,-43,"Swing Door Shower")
					.undo(1)
					.redo(driver,1);














//					.editSinkOptionsProperty(-107, -3, "15 mm", "", "Underglued", "Left", "Bottom", "", "")
//					.verifySinkOptionsProperty(-107, -3, "15 mm", "", "Underglued", "Left", "Bottom", "")
//					.checkBusinessRuleShowIn3D("Sink cabinet position", true)
//					.position(-107, -3, "50 mm", "100 mm", "").verifyPosition(-107, -3, "100 mm")
//					.verifyBusinessRuleRemoved("Sink cabinet position")
//					.editSinkOptionsProperty(-107, -3, "", "", "", "", "", "yes", "Right")
//					.verifySinkOptionsProperty(-107, -3, "", "", "", "", "", "Right")
//					.addProduct("U2DA80", true, false, false).worktopEditor(-107, -3)
//					.editWorktopYes()
//					.createCutOut(-65, -170, "Rectangle", "100 mm", "100 mm", "", "", "")
//					.editCutOutDimension(-66, -170, "1355 mm", "1000 mm")
//					.checkWorktopEditorBusinessRules("Minimum distance between drainer grooves and cut-out")
//					.editWorktopDimension(-106, -167, "630 mm", "300 mm", "")
//					.verifyWorktopDimension(-67, -168, "300 mm")
//					.verifyBusinessRuleInWorktopEditorRemoved("Minimum distance between drainer grooves and cut-out")
//					.validateWorktopEditor().checkBusinessRuleShowIn3D("Distance between tap hole and sink", true)
//					.editFaucetOptionsProperty(-48, 10, "10 mm", "20 mm", "Right", "Back")
//					.verifyFaucetOptionsProperty(-48, 10, "10 mm","", "20 mm","", "Right", "Back")
//					.verifyBusinessRuleRemoved("Distance between tap hole and sink").verifyPrice("1 825,00");

			}
}
