package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistanceSlopingCeilingAndCabinetsCase9 extends Browser {
	@Test
	public void minDistanceSlopingCeilingAndCabinetsCase9() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.manageSlopedWalls()
		.addslopedCeiling3D(-156,42, "1600 mm", "", "")
		.step3().verifyPrice("0,00")
		.addProduct("test_HalfHeightCabinet", true, false, false)
		.twoDView().threeDView()
		.checkBusinessRuleShowIn3D("Half Height cabinet position", true)
		.position(-13, -113, "175 mm", "350 mm", "")
		.verifyBusinessRuleRemoved("Half Height cabinet position");
	}

}
