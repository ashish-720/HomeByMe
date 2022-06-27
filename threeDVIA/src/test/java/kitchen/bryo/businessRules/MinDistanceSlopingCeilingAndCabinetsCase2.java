package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistanceSlopingCeilingAndCabinetsCase2 extends Browser {
	@Test
	public void minDistanceSlopingCeilingAndCabinetsCase2() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.manageSlopedWalls()
		.addslopedCeiling3D(-156,42, "", "", "")
		.validateSlopedCeiling()
		.step3().verifyPrice("0,00")
		.addProduct("GMO03", true, false, false)
		.twoDView().threeDView()
		.checkBusinessRuleShowIn3D("High cabinet position", true)
		.position(-4, -84, "50 mm", "300 mm", "")
		.verifyBusinessRuleRemoved("High cabinet position");
	}

}
