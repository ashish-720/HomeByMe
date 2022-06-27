package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistanceSlopingCeilingAndCabinetsCase7 extends Browser {
	@Test
	public void minDistanceSlopingCeilingAndCabinetsCase7() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.manageSlopedWalls()
		.addslopedCeiling3D(-156,42, "", "", "")
		.step3().verifyPrice("0,00")
		.addProduct("GMO03", true, false, false)
		.twoDView().threeDView()
		.addProperty(-13, -113, "Top Light", "", "", true)
		.position(-13, -113, "1180 mm", "1300 mm", "")	
		.checkBusinessRuleShowIn3D("High cabinet with top light", true)
		.position(12, -136, "1300 mm", "1400 mm", "")
		.verifyBusinessRuleRemoved("High cabinet with top light");
	}

}
