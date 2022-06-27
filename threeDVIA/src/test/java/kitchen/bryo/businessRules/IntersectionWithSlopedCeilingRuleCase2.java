package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class IntersectionWithSlopedCeilingRuleCase2 extends Browser {
	@Test
	public void intersectionWithSlopedCeilingRuleCase2() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
	
		.manageSlopedWalls()
		.addslopedCeiling3D(-156,42, "", "", "")
		.step3().verifyPrice("0,00")
		.addProduct("W6002", true, false, false)
		.twoDView().threeDView()
		.position(-4, -98, "1180 mm", "1000 mm", "")
		.checkBusinessRuleShowIn3D("Cabinet colliding with sloped ceiling", true)
		.undo(2)
		.verifyBusinessRuleRemoved("Cabinet colliding with sloped ceiling");
	}

}
