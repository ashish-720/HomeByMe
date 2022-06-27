package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistanceSlopingCeilingAndCabinetsCase8 extends Browser {
	@Test
	public void minDistanceSlopingCeilingAndCabinetsCase8() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.manageSlopedWalls()
		.addslopedCeiling3D(-156,42, "", "", "")
		.step3().verifyPrice("0,00")
		.addProduct("W6002", true, false, false)
		.twoDView().threeDView()
		.addProperty(2, -176, "Top Light", "", "", true)
		.position(2, -176, "1180 mm", "1300 mm", "")	
		.checkBusinessRuleShowIn3D("Wall cabinet with top light", true)
		.position(8, -193, "110 mm", "200 mm", "")
		.verifyBusinessRuleRemoved("Wall cabinet with top light");
	}

}
