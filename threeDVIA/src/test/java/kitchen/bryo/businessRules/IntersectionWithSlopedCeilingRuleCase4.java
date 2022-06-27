package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class IntersectionWithSlopedCeilingRuleCase4 extends Browser {
	@Test
	public void intersectionWithSlopedCeilingRuleCase4() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
	
		.manageSlopedWalls()
		.addslopedCeiling3D(-156,42, "", "", "")
		.step3().verifyPrice("0,00")
		.addProduct("test_HalfHeightCabinet", true, false, false)
		.twoDView().threeDView()
		.checkBusinessRuleShowIn3D("Cabinet colliding with sloped ceiling", true)
		.position(0, 0, "2894 mm", "2794 mm", "")
		.verifyBusinessRuleRemoved("Cabinet colliding with sloped ceiling");
	}

}
