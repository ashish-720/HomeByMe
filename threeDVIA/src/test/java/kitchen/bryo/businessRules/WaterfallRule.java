package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class WaterfallRule extends Browser {
	@Test
	public void waterfallRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.duplicateProduct(-112, -6)
		.duplicateProduct(-112, -6)
		.replaceProperty(-112, -6, "Worktop","ACRYLIC WHITE", "", true,"")
		.verifyReplaceProperty(-112, -6, "Worktop","ACRYLIC WHITE")
		.editWorktopWaterFallOptions(-112, -6, "no", "yes","")
		.worktopEditor(-112, -6)
		.editWorktopYes()
		.zoomIn(3)
		.editWorktopDimension(-86, -220, "2491 mm", "2550 mm", "apply right")
		.checkWorktopEditorBusinessRules("Waterfall worktops")
		.undoInWorktopEditor(driver, 1)
		.verifyBusinessRuleInWorktopEditorRemoved("Waterfall worktops");
	}

}
