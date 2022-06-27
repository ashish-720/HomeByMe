package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class WorktopInvalidShapeRule extends Browser {
	@Test
	public void worktopInvalidShapeRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.worktopEditor(-112, -6)
		.editWorktopYes()
		.zoomIn(5)
		.createCornerCutOut(-227, -280, "", "Single", "900 mm", "1200 mm", "", "", "", "", "", "", "")	
		.checkWorktopEditorBusinessRules("Worktop shape")
		.undoInWorktopEditor(driver, 3)
		.verifyBusinessRuleInWorktopEditorRemoved("Worktop shape");
	}

}
