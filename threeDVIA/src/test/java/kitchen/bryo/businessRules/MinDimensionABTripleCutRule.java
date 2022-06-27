package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDimensionABTripleCutRule extends Browser {
	@Test
	public void minDimensionABTripleCutRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.worktopEditor(-112, -6)
		.editWorktopYes()
		.addEdgeCut(-144, -211, "Triple", "200 mm", "200 mm", "", "", "", "", "")
		.zoomIn(4)
		.editWorktopDimension(-285, -320, "200 mm", "70 mm", "apply below")
		.checkWorktopEditorBusinessRules("Minimum dimension for a triple, right angled cut")
		.undoInWorktopEditor(driver, 1)
		.verifyBusinessRuleInWorktopEditorRemoved("Minimum dimension for a triple, right angled cut");
	}

}
