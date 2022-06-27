package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class FurnitureGapRule extends Browser {
	@Test
	public void furnitureGapRule() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3().verifyPrice("0,00")
		.addProduct("GMO03", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.position(-63, -4, "638 mm", "658 mm", "")
		.checkBusinessRuleShowIn3D("Item position", true)
		.undo(2)
		.verifyBusinessRuleRemoved("Item position");
		
		
	}

}
