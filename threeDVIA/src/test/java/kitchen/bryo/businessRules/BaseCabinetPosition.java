package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class BaseCabinetPosition extends Browser {
	@Test
	public void baseCabinetPositionRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.position(-112, -6,"50 mm", "0 mm", "")
		.verifyPosition(-112, -6, "3187 mm")
		.checkBusinessRuleShowIn3D("Base cabinet position", true)
		.undo(4)
		.verifyBusinessRuleRemoved("Base cabinet position")
		.deleteProduct(-112, -6)
		.clickFloorplan()
		.addProduct("BOX OBJECT",false,false)	
		.editItemDimensionProperties(-72, -12, "","500 mm", "1500 mm", "","",0)
		.position(-72, -12, "1096 mm", "50 mm")
		.position(-200, -25, "1426 mm", "0 mm")
		.step3()
		.addProduct("U2DA80", true, false, false)
		.checkBusinessRuleShowIn3D("Base cabinet position", true)
		.position(-72, -2,"550 mm", "1550 mm", "")
		.verifyBusinessRuleRemoved("Base cabinet position");
	}

}
