package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class CabinetVerticalIntersectionRuleCase2 extends Browser {
	@Test
	public void cabinetVerticalIntersectionRuleCase2(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("W6002", true, false, false)
		.addProperty(-120,-80, "Cornice", "MADELEINE", "", true)
		.viewHeightIn3D("High")
		.position(-154,38,"1480 mm", "1700 mm", "")
		.checkBusinessRuleShowIn3D("Unit Collision", true);
	}

}
