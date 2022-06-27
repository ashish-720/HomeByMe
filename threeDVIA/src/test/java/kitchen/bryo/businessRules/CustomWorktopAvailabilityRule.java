package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class CustomWorktopAvailabilityRule extends Browser {
	@Test
	public void customWorktopAvailabilityRule(){
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
		.removeJoint(-53, -244)
		.checkWorktopEditorBusinessRules("There is no product available to make this worktop")
		.undoInWorktopEditor(driver, 1)
		.verifyBusinessRuleInWorktopEditorRemoved("There is no product available to make this worktop");
	}

}
