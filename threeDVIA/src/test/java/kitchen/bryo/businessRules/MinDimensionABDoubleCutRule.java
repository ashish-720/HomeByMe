package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDimensionABDoubleCutRule extends Browser {
	@Test
	public void minDimensionABDoubleCutRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.worktopEditor(-112, -6)
		.editWorktopYes()
		.createCornerCutOut(-125, -150, "", "Double", "", "", "100 mm", "100 mm", "", "", "", "", "")
		.editWorktopDimension(-175, -150, "780 mm", "800 mm", "apply right")
		.editWorktopDimension(-125, -183, "535 mm", "600 mm", "apply below")
		.checkWorktopEditorBusinessRules("Minimum dimension for a double, right angled cut")
		.undoInWorktopEditor(driver, 3)
		.verifyBusinessRuleInWorktopEditorRemoved("Minimum dimension for a double, right angled cut");
	}

}
