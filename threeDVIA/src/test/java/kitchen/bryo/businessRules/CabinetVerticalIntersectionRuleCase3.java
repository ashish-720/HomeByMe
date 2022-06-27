package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class CabinetVerticalIntersectionRuleCase3 extends Browser {
	@Test
	public void cabinetVerticalIntersectionRuleCase3(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.ceiling("2280 mm")
		.verifyCeiling(-235,25,"2280 mm")
		.step3()
		.verifyPrice("0,00")
		.addProduct("GMO03", true, false, false)
		.addProperty(-120,-80, "Top Cover Panel", "MADELEINE", "", true)
		.checkBusinessRuleShowIn3D("Unit Collision", true);
	}

}
