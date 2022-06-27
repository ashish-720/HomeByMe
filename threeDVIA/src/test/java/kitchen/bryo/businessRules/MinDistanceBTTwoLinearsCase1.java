package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistanceBTTwoLinearsCase1 extends Browser {
	@Test
	public void minDistanceBTTwoLinearsCase1() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3().verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.position(-50, -12, "3351 mm", "2600 mm", "")
		
		.verifyPosition(-58, 21, "2600 mm")
		.position(-58, 21, "837 mm", "50 mm", "")
		.preciseRotation(-101, 39, "180°", "53 mm")
		.checkBusinessRuleShowIn3D("Distance between two linears placed front to front", true);
		
	}

}
