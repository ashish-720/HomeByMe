package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class WorktopOverhangSizeRule extends Browser {
	@Test
	public void worktopOverhangSizeRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.worktopEditor(-112, -6)
		.editWorktopYes()
		.zoomIn(3)
		.editWorktopDimension(-198, -218, "1680 mm", "1937 mm", "apply right")
		.checkWorktopEditorBusinessRules("Maximum overhang without support")
		.undoInWorktopEditor(driver, 1)
		.verifyBusinessRuleInWorktopEditorRemoved("Maximum overhang without support");
		
				
	}

}
