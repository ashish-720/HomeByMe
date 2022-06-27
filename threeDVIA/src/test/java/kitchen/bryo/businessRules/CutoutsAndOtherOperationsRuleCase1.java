package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class CutoutsAndOtherOperationsRuleCase1 extends Browser {
	@Test
	public void cutoutsAndOtherOperationsRuleCase1(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.worktopEditor(-112, -6)
		.editWorktopYes()
		.createCutOut(-67, -188, "Rectangle", "200 mm", "200 mm", "", "", "")
		.createCutOut(-141, -188, "Rectangle", "200 mm", "200 mm", "", "", "")
		.editCutOutDimension(-70, -192, "189 mm", "620 mm")
		
		.checkWorktopEditorBusinessRules("Minimum distance between cut-outs and any other operation")
		.undoInWorktopEditor(driver, 2)
		.verifyBusinessRuleInWorktopEditorRemoved("Minimum distance between cut-outs and any other operation")
		.deleteCutOrCutOuts(-141, -188)
		.createCutOut(-141, -188, "Circle", "", "", "", "", "200 mm")
		.editCutOutDimension(-67, -188, "189 mm", "620 mm")
		
		.checkWorktopEditorBusinessRules("Minimum distance between cut-outs and any other operation")
		.undoInWorktopEditor(driver, 2)
		.verifyBusinessRuleInWorktopEditorRemoved("Minimum distance between cut-outs and any other operation");
		
	}

}
