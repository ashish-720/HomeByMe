package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class AdjacentWallUnitsRule extends Browser {
	@Test
	public void adjacentWallUnitsRule() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3().verifyPrice("0,00")
		.addProduct("GMO03", true, false, false)
		.addProduct("W6002", true, false, false)
		.position(-88,-127, "220 mm", "100 mm", "")
		.checkBusinessRuleShowIn3D("Wall units alignment", true)
		.undo(2)
		.verifyBusinessRuleRemoved("Wall units alignment");
		
	}

}
