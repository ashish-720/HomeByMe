package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistanceSlopingCeilingAndCabinetsCase10 extends Browser {
	@Test
	public void minDistanceSlopingCeilingAndCabinetsCase10() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.manageSlopedWalls()
		.addslopedCeiling3D(-156,42, "1150 mm", "", "")
		.step3().verifyPrice("0,00")
		.addProduct("SPUD80", true, false, false)
		.twoDView().threeDView()
		
		.checkBusinessRuleShowIn3D("Sink cabinet position", true)
		.position(-14, 4, "3137 mm", "3087 mm", "")
		.undo(1)
		.verifyBusinessRuleRemoved("Sink cabinet position");
	}

}
