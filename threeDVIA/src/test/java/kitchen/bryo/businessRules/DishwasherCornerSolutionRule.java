package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class DishwasherCornerSolutionRule extends Browser {
	@Test
	public void dishwasherCornerSolutionRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.addProduct("UEDK88", true, false, false)
		.addProduct("DISHWASHER", true, false, false)
		.checkBusinessRuleShowIn3D("Distance between dishwasher and corner", true)
		.deleteProduct(-54, -6)
		.addProduct("U2DA30", true, false, false)
		.addProduct("DISHWASHER", true, false, false)
		.verifyBusinessRuleRemoved("Distance between dishwasher and corner");

	}

}
