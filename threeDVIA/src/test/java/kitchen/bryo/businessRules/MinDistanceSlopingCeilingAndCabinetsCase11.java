package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistanceSlopingCeilingAndCabinetsCase11 extends Browser {
	@Test
	public void minDistanceSlopingCeilingAndCabinetsCase11() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.manageSlopedWalls()
		.addslopedCeiling3D(76,-53, "", "", "")
		.step3().verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProduct("HUS60", true, false, false)
		.addProduct("U2DA80", true, false, false)
		
		.checkBusinessRuleShowIn3D("Oven cabinet position", true)
		.clickFloorplan()
		.manageSlopedWalls()
		.changeSlopedCeiling3D(57, -46, "1500 mm", "", "")
		.validateSlopedCeiling()
		.step3()
		.verifyBusinessRuleRemoved("Oven cabinet position");
	}

}
