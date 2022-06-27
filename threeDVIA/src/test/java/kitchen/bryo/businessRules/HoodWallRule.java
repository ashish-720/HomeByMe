package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class HoodWallRule extends Browser {
	@Test
	public void hoodWallRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		
		.addProduct("ISLANDHOOD90", true, false, false)
		.position(-116,-103,"3100 mm", "2900 mm", "")
		.verifyPosition(-103, -102, "2900 mm")
		.position(-103, -102,"3400 mm", "3000 mm", "")
		.verifyPosition(-112, -62, "3000 mm")
		.checkBusinessRuleShowIn3D("Unit position", true)
		.undo(3)
		.verifyBusinessRuleRemoved("Unit position")
		.verifyPosition(-97,-62, "50 mm");

	}

}
