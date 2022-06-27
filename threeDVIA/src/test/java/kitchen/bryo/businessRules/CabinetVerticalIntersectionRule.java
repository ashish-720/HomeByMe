package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class CabinetVerticalIntersectionRule extends Browser {
	@Test
	public void cabinetVerticalIntersectionRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.ceiling("2000 mm")
		.verifyCeiling(-235,25,"2000 mm")
		.step3()
		.verifyPrice("0,00")
		.addProduct("GMO03", true, false, false)
		.addProperty(-120,-80, "Top Light", "", "", true)
		.checkBusinessRuleShowIn3D("Unit Collision", true);
	}

}
