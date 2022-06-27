package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class FurnitureIntersectRule extends Browser {
	@Test
	public void furnitureIntersectRule() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.verifyCeiling(-235, 25, "2000 mm").step3().verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.allowCollision(-112, -6, "3150 mm", "3000 mm")
		.verifyPosition(-112, -6, "606 mm")
		.checkBusinessRuleShowIn3D("Item position", true)
		.undo(4)
		.verifyBusinessRuleRemoved("Item position");
	}

}
