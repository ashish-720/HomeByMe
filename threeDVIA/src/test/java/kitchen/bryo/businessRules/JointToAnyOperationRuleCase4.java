package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class JointToAnyOperationRuleCase4 extends Browser {
	@Test
	public void jointToAnyOperationRuleCase4(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.duplicateProduct(-112, -6)
		.duplicateProduct(-112, -6)
		.worktopEditor(-112, -6)
		.editWorktopYes()
		.zoomIn(3)
		.createCutOut(-135, -258, "Rectangle", "200 mm", "200 mm", "", "", "")
		.editCutOutDimension(-135, -258, "1650 mm", "800 mm")
		.checkWorktopEditorBusinessRules("Minimum distance between cut-out and adjacent joint.")
		.undoInWorktopEditor(driver, 1)
		.verifyBusinessRuleInWorktopEditorRemoved("Minimum distance between cut-out and adjacent joint.");
	}

}
