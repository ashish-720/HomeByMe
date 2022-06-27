package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class JointToAnyOperationRuleCase5 extends Browser {
	@Test
	public void jointToAnyOperationRuleCase5(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.duplicateProduct(-112, -6)
		.duplicateProduct(-112, -6)
		.worktopEditor(-112, -6)
		.editWorktopYes()
//		.zoomIn(3)
		.addEdgeCut(11, -149, "Triple", "200 mm", "200 mm", "", "", "", "", "")
		
		.editCutOutDimension(-39, -181, "1650 mm", "1400 mm")
		.checkWorktopEditorBusinessRules("Minimum distance between edge cut and a joint.")
		.undoInWorktopEditor(driver, 1)
		.verifyBusinessRuleInWorktopEditorRemoved("Minimum distance between edge cut and a joint.");
	}

}
