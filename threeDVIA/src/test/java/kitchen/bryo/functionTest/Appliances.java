package kitchen.bryo.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Appliances extends Browser {
	@Test
	public void appliancesTest(){
		
			StartNow start = PageFactory.initElements(driver, StartNow.class);
			start.startDemo("en-GB")
			.startFromScratch().step3().verifyPrice("0,00")
			//		.addProduct("SPUDSA80", false, false, "1 238,97", "")
					.addProduct("SPUD80", true, false, false)
					.addProduct("U2DA80", true, false, false)
					.replaceProperty(-113, -50, "Front", "CONCORDE", "all",true, "")
					.verifyReplaceProperty(-113, -50, "Front", "CONCORDE")
					.replaceProperty(-113, -50, "Front", "MADELEINE", "all",true, "")
					.verifyReplaceProperty(-113, -50, "Front", "MADELEINE")
					.verifyAddProperty(-113, -50, "Handle", "LAURA").duplicateProduct(-41, -9)
					.openClose(28, -12, 28, -12).deleteProduct(28, -12).undo(1)
					.openClose(28, -12, 28, -12).deleteProductUsingShortCutKey(28, -12)
					.deleteProduct(-41, -9)
//					.productInfo(-107, -3)
					.openClose(-107, -3, -107, -3)
					.replaceProperty(-107, -3, "Sink", "KALADIN", "",true, "")
					.verifyReplaceProperty(-107, -3, "Sink", "KALADIN")
					.editSinkOptionsProperty(-107, -3, "15 mm", "", "Underglued", "Left", "Bottom", "", "")
					.verifySinkOptionsProperty(-107, -3, "15 mm", "", "Underglued", "Left", "Bottom", "")
					.checkBusinessRuleShowIn3D("Sink cabinet position", true)
					.position(-107, -3, "50 mm", "100 mm", "").verifyPosition(-107, -3, "100 mm")
					.verifyBusinessRuleRemoved("Sink cabinet position")
					.editSinkOptionsProperty(-107, -3, "", "", "", "", "", "yes", "Right")
					.verifySinkOptionsProperty(-107, -3, "", "", "", "", "", "Right")
					.addProduct("U2DA80", true, false, false).worktopEditor(-107, -3)
					.editWorktopYes()
					.createCutOut(-65, -170, "Rectangle", "100 mm", "100 mm", "", "", "")
					.editCutOutDimension(-66, -170, "1355 mm", "1000 mm")				
					.checkWorktopEditorBusinessRules("Minimum distance between drainer grooves and cut-out")
					.editWorktopDimension(-106, -167, "630 mm", "300 mm", "")
					.verifyWorktopDimension(-67, -168, "300 mm")
					.verifyBusinessRuleInWorktopEditorRemoved("Minimum distance between drainer grooves and cut-out")
					.validateWorktopEditor().checkBusinessRuleShowIn3D("Distance between tap hole and sink", true)
					.editFaucetOptionsProperty(-48, 10, "10 mm", "20 mm", "Right", "Back")
					.verifyFaucetOptionsProperty(-48, 10, "10 mm","", "20 mm","", "Right", "Back")
					.verifyBusinessRuleRemoved("Distance between tap hole and sink").verifyPrice("1 825,00");

			}
}
