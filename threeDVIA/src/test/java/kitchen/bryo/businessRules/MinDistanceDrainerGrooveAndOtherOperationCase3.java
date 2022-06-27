package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistanceDrainerGrooveAndOtherOperationCase3 extends Browser {
	@Test
	public void minDistanceDrainerGrooveAndOtherOperationCase3(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProduct("SPUD80", true, false, false)
		.editFaucetOptionsProperty(-54, -2, "", "20 mm", "", "Back")
		.editSinkOptionsProperty(-54, -2, "", "", "Underglued", "", "", "yes", "Left")
		.worktopEditor(-112, -6)
		.editWorktopYes()
		.createCutOut(-178, -188, "Rectangle", "150 mm", "150 mm", "", "", "")
		.zoomIn(3)
		.editCutOutDimension(-249, -259, "296 mm", "620 mm")
		.checkWorktopEditorBusinessRules("Distance between drainer grooves and cut-out")
		.undoInWorktopEditor(driver, 1)
		.verifyBusinessRuleInWorktopEditorRemoved("Distance between drainer grooves and cut-out");
		
				
	}

}
