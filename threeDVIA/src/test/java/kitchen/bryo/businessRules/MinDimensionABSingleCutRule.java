package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDimensionABSingleCutRule extends Browser {
	@Test
	public void minDimensionABSingleCutRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.worktopEditor(-112, -6)
		.editWorktopYes()
		.zoomIn(5)
		.createCornerCutOut(-210, -255, "", "Single", "100 mm", "100 mm", "", "", "", "", "", "", "")
		.verifyBusinessRuleInWorktopEditorRemoved("Minimum dimension for a single cut")
		.editWorktopDimension(-250, -253, "780 mm", "800 mm", "apply right")
		.editWorktopDimension(-208, -300, "555 mm", "600 mm", "apply below")
		.checkWorktopEditorBusinessRules("Minimum dimension for a single cut")
		.undoInWorktopEditor(driver, 3)
		.verifyBusinessRuleInWorktopEditorRemoved("Minimum dimension for a single cut")

//		FUN120662 : As a retailer, I can differentiate if a single cut is part or full depth
		//Scenario : check rule for worktop
		.clickAndDrag(280, 260)
		.zoomIn(4)
		.moveWorktop(145, 14, 145, -50)
		.editWorktopDimension(52, 43, "780 mm", "871 mm", "apply right")
		.moveWorktop(169, -58, 145, -65)
		.moveWorktop(145, -65, 145, -138)
		.verifyWorktopDimension(90, -138, "880 mm")
		.verifyWorktopDimension(52, 43, "871 mm")
		.checkWorktopEditorBusinessRules("Minimum dimension for a single cut", "The minimum size of this operation is 10 mm. Current: 9 mm")
		.zoomIn(4)
		.moveWorktop(217, 64, 210, 64)
		.verifyBusinessRuleInWorktopEditorRemoved("Minimum dimension for a single cut");
	}
}
