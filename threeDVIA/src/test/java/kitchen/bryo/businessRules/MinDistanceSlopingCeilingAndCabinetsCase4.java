package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistanceSlopingCeilingAndCabinetsCase4 extends Browser {
	@Test
	public void minDistanceSlopingCeilingAndCabinetsCase4() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.manageSlopedWalls()
		.addslopedCeiling3D(-156,42, "1200 mm", "500 mm", "")
		.step3().verifyPrice("0,00")
		.addProduct("FRIDGE US", true, false, false)
		.twoDView().threeDView()
		.position(-14, 3, "2877 mm", "2876 mm", "")
		.checkBusinessRuleShowIn3D("Freestanding fridge cabinet position", true)
		.position(-14, 3, "2876 mm", "2790 mm", "")
		.verifyBusinessRuleRemoved("Freestanding fridge cabinet position");
	}

}
