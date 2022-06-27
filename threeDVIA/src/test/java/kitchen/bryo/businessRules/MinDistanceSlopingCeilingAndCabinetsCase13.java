package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistanceSlopingCeilingAndCabinetsCase13 extends Browser {
	@Test
	public void minDistanceSlopingCeilingAndCabinetsCase13() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.manageSlopedWalls()
		.addslopedCeiling3D(76,-53, "1000 mm", "", "")
		.step3().verifyPrice("0,00")
		.addProduct("Washer", true, false, false)
		.position(-111, -4, "3410 mm", "3000 mm", "")
		.checkBusinessRuleShowIn3D("Washing machine position", true)
		.clickFloorplan()
		.manageSlopedWalls()
		.changeSlopedCeiling3D(57, -46, "1500 mm", "", "")
		.validateSlopedCeiling()
		.step3()
		.verifyBusinessRuleRemoved("Washing machine position");
	}

}
