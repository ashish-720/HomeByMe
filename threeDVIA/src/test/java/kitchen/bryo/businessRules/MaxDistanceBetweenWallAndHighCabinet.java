package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MaxDistanceBetweenWallAndHighCabinet extends Browser {
	@Test
	public void maxDistanceBetweenWallAndHighCabinetRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("GMO03", true, false, false)
		.position(-128, -103,"50 mm", "330 mm", "")
		.verifyPosition(-90,-50, "330 mm")
		.position(-90,-50,"3351 mm", "3000 mm", "")
		.verifyPosition(-90, -50, "3000 mm")
		.checkBusinessRuleShowIn3D("Maximum distance between high cabinet and wall", true)
		.undo(10)
		.verifyBusinessRuleRemoved("Maximum distance between high cabinet and wall")
		.verifyPosition(-128, -103, "50 mm")
		.deleteProduct(-128, -103)
		.addProduct("FRIDGE US", true, false, false)
		.position(-128, -103,"3091 mm", "2930 mm", "")
		.verifyPosition(-90,-50, "3000 mm")
		.position(-90,-50,"3235 mm", "3000 mm", "")
		.verifyPosition(-105, -48, "3000 mm")
		.checkBusinessRuleShowIn3D("Maximum distance between freestanding appliance and wall", true)
		.undo(4)
		.verifyBusinessRuleRemoved("Maximum distance between freestanding appliance and wall")
		.deleteProduct(-90, -50)
		.addProduct("DISHWASHER", true, false, false)
		.position(-121, -10,"3550 mm", "3000 mm", "")
		.verifyPosition(-83, -8, "3000 mm")
		.position(-83, -8,"3393 mm", "3000 mm", "")
		.verifyPosition(-86, -10, "3000 mm")
		.checkBusinessRuleShowIn3D("Maximum distance between freestanding appliance and wall", true)
		.undo(4)
		.verifyBusinessRuleRemoved("Maximum distance between freestanding appliance and wall")
		.deleteProduct(-78, -33)
		.addProduct("Washer", true, false, false)
		.position(-121, -10,"3410 mm", "3000 mm", "")
		.verifyPosition(-83, -8, "3000 mm")
		.position(-83, -8,"3410 mm", "3000 mm", "")
		.verifyPosition(-106, -29, "3000 mm")
		.checkBusinessRuleShowIn3D("Maximum distance between freestanding appliance and wall", true)
		.undo(4)
		.verifyBusinessRuleRemoved("Maximum distance between freestanding appliance and wall")
		.deleteProduct(-100, -41)
		.addProduct("OVEN|16067", true, false, false)
		.position(-121, -10,"3400 mm", "3000 mm", "")
		.verifyPosition(-83, -8, "3000 mm")
		.position(-83, -8,"3352 mm", "3000 mm", "")
		.verifyPosition(-106, -29, "3000 mm")
		.checkBusinessRuleShowIn3D("Maximum distance between freestanding appliance and wall", true)
		.undo(4)
		.verifyBusinessRuleRemoved("Maximum distance between freestanding appliance and wall");

	}

}
