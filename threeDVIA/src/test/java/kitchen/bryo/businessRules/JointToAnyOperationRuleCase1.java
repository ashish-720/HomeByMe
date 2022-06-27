package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class JointToAnyOperationRuleCase1 extends Browser {
	@Test
	public void jointToAnyOperationRuleCase1(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.duplicateProduct(-112, -6)
		.worktopEditor(-112, -6)
		.editWorktopYes()
		.addJoint(-130, -150)
		.zoomIn(3)
		.editCutOutDimension(-175, -230, "840 mm", "1600 mm")
		.checkWorktopEditorBusinessRules("Minimum distance between joint and end of worktop.")
		.undoInWorktopEditor(driver, 1)
		.verifyBusinessRuleInWorktopEditorRemoved("Minimum distance between joint and end of worktop.");
	}

}
