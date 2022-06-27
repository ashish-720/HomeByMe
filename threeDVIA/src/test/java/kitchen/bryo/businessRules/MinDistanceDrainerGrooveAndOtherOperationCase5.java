package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistanceDrainerGrooveAndOtherOperationCase5 extends Browser {
	@Test
	public void minDistanceDrainerGrooveAndOtherOperationCase5(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProduct("SPUD80", true, false, false)
		.editFaucetOptionsProperty(-54, -2, "", "20 mm", "", "Back")
		.editSinkOptionsProperty(-54, -2, "", "", "Underglued", "", "", "yes", "Right")
		.worktopEditor(-112, -6)
		.editWorktopYes()
		.zoomIn(3)
		.editWorktopDimension(-179, -184, "1680 mm", "1800 mm", "apply right")
		.checkWorktopEditorBusinessRules("Distance between drainer grooves and worktop edge")
		.editWorktopDimension(-179, -184, "1800 mm", "1820 mm","apply right")
		.verifyBusinessRuleInWorktopEditorRemoved("Distance between drainer grooves and worktop edge");
		
				
	}

}
