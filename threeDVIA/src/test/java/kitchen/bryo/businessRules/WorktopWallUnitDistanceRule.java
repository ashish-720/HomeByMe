package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class WorktopWallUnitDistanceRule extends Browser {
	@Test
	public void worktopWallUnitDistanceRule() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3().verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProduct("W6002", true, false, false)
		.position(-116,-103, "600 mm", "400 mm", "")
		.checkBusinessRuleShowIn3D("Distance between wall units and worktop", true)
		.undo(2)
		.verifyBusinessRuleRemoved("Distance between wall units and worktop");
		
	}

}
