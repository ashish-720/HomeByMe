package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class UnitPosition extends Browser {
	@Test
	public void unitPositionRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("W6002", true, false, false)
		.position(-116,-103,"3337 mm", "3237 mm", "")
		.verifyPosition(-103, -102, "330 mm")
		.position(-103, -102,"3581 mm", "3000 mm", "")
		.verifyPosition(-112, -62, "3000 mm")
		.checkBusinessRuleShowIn3D("Unit position", true)
		.undo(4)
		.verifyBusinessRuleRemoved("Unit position")
		.verifyPosition(-116,-103, "50 mm")
		.deleteProduct(-116, -103)
		.addProduct("WED6802", true, false, false)
		.position(-116,-103,"3312 mm", "3000 mm", "")
		.verifyPosition(-103, -102, "3000 mm")
		.position(-103, -102,"3312 mm", "3000 mm", "")
		.verifyPosition(-112, -62, "3000 mm")
		.checkBusinessRuleShowIn3D("Unit position", true)
		.undo(4)
		.verifyBusinessRuleRemoved("Unit position")
		.verifyPosition(-116,-103, "50 mm")
		.deleteProduct(-116, -103)
		.addProduct("ISLANDHOOD90", true, false, false)
		.position(-116,-103,"3100 mm", "2900 mm", "")
		.verifyPosition(-103, -102, "2900 mm")
		.position(-103, -102,"3400 mm", "3000 mm", "")
		.verifyPosition(-112, -62, "3000 mm")
		.checkBusinessRuleShowIn3D("Unit position", true)
		.undo(4)
		.verifyBusinessRuleRemoved("Unit position")
		.verifyPosition(-116,-103, "50 mm");

	}

}
