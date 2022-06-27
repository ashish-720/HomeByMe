package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class TripleCutMaxDepthRule extends Browser {
	@Test
	public void tripleCutMaxDepthRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.worktopEditor(-112, -6)
		.addEdgeCut(-192,-249,  "Triple", "500 mm", "500 mm", "", "", "", "", "")
		.checkWorktopEditorBusinessRules("Depth of triple cut")
		.editWorktopDimension(-166, -212, "500 mm", "300 mm", "apply below")
		.verifyBusinessRuleInWorktopEditorRemoved("Depth of triple cut");
		
		
	}

}
