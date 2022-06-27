package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistanceSlopingCeilingAndCabinetsCase3 extends Browser {
	@Test
	public void minDistanceSlopingCeilingAndCabinetsCase3() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.manageSlopedWalls()
		.addslopedCeiling3D(-156,42, "", "", "")
		.step3().verifyPrice("0,00")
		.addProduct("W6002", true, false, false)
		.twoDView().threeDView()
		.checkBusinessRuleShowIn3D("Wall cabinet position", true)
		.position(1, -74, "1180 mm", "1250 mm", "")
		.verifyBusinessRuleRemoved("Wall cabinet position");
	}

}
