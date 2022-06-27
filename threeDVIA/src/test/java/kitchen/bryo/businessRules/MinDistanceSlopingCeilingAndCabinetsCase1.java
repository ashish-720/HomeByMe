package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistanceSlopingCeilingAndCabinetsCase1 extends Browser {
	@Test
	public void minDistanceSlopingCeilingAndCabinetsCase1() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.manageSlopedWalls()
		.addslopedCeiling3D(-156,42, "950 mm", "", "")
		.step3().verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.twoDView().threeDView()
		.checkBusinessRuleShowIn3D("Base cabinet position", true)
		.position(-11, -1, "3137 mm", "3387 mm", "")
		.verifyBusinessRuleRemoved("Base cabinet position");
	}

}
