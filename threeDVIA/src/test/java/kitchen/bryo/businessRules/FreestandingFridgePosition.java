package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class FreestandingFridgePosition extends Browser {
	@Test
	public void freestandingFridgePositionRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("FRIDGE US", true, false, false)
		.checkBusinessRuleShowIn3D("Freestanding fridge position", true)
		.position(-112, -6,"3091 mm", "2940 mm", "")
		.verifyPosition(-112, -6, "150 mm")
		.verifyBusinessRuleRemoved("Freestanding fridge position")
		.deleteProduct(-112, -6)
		.clickFloorplan()
		.addProduct("BOX OBJECT",false,false)	
		.editItemDimensionProperties(-72, -12, "","500 mm", "1500 mm", "","",0)
		.position(-72, -12, "1096 mm", "50 mm")
		.position(-200, -25, "1426 mm", "0 mm")
		.step3()
		.addProduct("FRIDGE US", true, false, false)
		.checkBusinessRuleShowIn3D("Freestanding fridge position", true)
		.position(-72, -2,"550 mm", "1550 mm", "")
		.verifyBusinessRuleRemoved("Freestanding fridge position");
	

	}

}
