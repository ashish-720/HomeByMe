package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class IntersectionWithSlopedCeilingRuleCase1 extends Browser {
	@Test
	public void intersectionWithSlopedCeilingRuleCase1() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.manageSlopedWalls()
		.addslopedCeiling3D(-156,42, "850 mm", "", "")
		.step3().verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.twoDView().threeDView()
		.checkBusinessRuleShowIn3D("Cabinet colliding with sloped ceiling", true)
		.position(0, -16, "3137 mm", "2900", "")
		.verifyBusinessRuleRemoved("Cabinet colliding with sloped ceiling");
	}

}
