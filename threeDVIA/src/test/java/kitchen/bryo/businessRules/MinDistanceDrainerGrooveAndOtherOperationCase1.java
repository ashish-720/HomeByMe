package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistanceDrainerGrooveAndOtherOperationCase1 extends Browser {
	@Test
	public void minDistanceDrainerGrooveAndOtherOperationCase1(){
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
		.addEdgeCut(-125, -160, "Triple", "", "", "", "", "", "", "")
		.checkWorktopEditorBusinessRules("Distance between drainer grooves and a cut");
		
				
	}

}
