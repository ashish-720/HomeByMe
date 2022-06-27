package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class CutoutsAndOtherOperationsRuleCase2 extends Browser {
	@Test
	public void cutoutsAndOtherOperationsRuleCase2(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProduct("CKT600", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.replaceProperty(-112, -6, "Worktop", "ACRYLIC WHITE", "",true, "")
		.worktopEditor(-112, -6)
		.editWorktopYes()
		.createCutOut(-13, -199, "Rectangle", "200 mm", "200 mm", "", "", "")
		.editCutOutDimension(-13, -199, "1782 mm", "1450 mm")
		.checkWorktopEditorBusinessRules("Minimum distance between cut-outs and any other operation")
		.undoInWorktopEditor(driver, 2)
		.verifyBusinessRuleInWorktopEditorRemoved("Minimum distance between cut-outs and any other operation")
		.deleteCutOrCutOuts(-13, -199)
		.createCutOut(-13, -199, "Circle", "", "", "", "", "200 mm")
		.editCutOutDimension(-13, -199, "1882 mm", "1550 mm")
		.checkWorktopEditorBusinessRules("Minimum distance between cut-outs and any other operation")
		.undoInWorktopEditor(driver, 1)
		.verifyBusinessRuleInWorktopEditorRemoved("Minimum distance between cut-outs and any other operation");
		
	}

}
