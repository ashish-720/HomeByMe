package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistanceSlopingCeilingAndCabinetsCase5 extends Browser {
	@Test
	public void minDistanceSlopingCeilingAndCabinetsCase5() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.manageSlopedWalls()
		.addslopedCeiling3D(76,-53, "", "", "")
		.step3().verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProduct("CKT600", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.replaceProperty(-50, -4, "Cooktop", "JEAN BAPTISTE", "",true, "")
		.checkBusinessRuleShowIn3D("Cooktop cabinet position", true)
		.clickFloorplan()
		.manageSlopedWalls()
		.changeSlopedCeiling3D(57, -46, "1500 mm", "", "")
		.validateSlopedCeiling()
		.step3()
		.verifyBusinessRuleRemoved("Cooktop cabinet position");
	}

}
