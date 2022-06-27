package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistanceSlopingCeilingAndCabinetsCase12 extends Browser {
	@Test
	public void minDistanceSlopingCeilingAndCabinetsCase12() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.manageSlopedWalls()
		.addslopedCeiling3D(76,-53, "1000 mm", "", "")
		.step3().verifyPrice("0,00")
		.addProduct("DISHWASHER", true, false, false)
		.position(-111, -4, "3550 mm", "3000 mm", "")
		.checkBusinessRuleShowIn3D("Dishwasher cabinet position", true)
		.clickFloorplan()
		.manageSlopedWalls()
		.changeSlopedCeiling3D(57, -46, "1500 mm", "", "")
		.validateSlopedCeiling()
		.step3()
		.verifyBusinessRuleRemoved("Dishwasher cabinet position");
	}

}
