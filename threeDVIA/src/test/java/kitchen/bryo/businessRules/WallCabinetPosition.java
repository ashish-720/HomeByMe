package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class WallCabinetPosition extends Browser {
	@Test
	public void wallCabinetPositionRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("WG10002", false, false, false)
		.position(-116,-103,"50 mm", "0 mm", "")
		.verifyPosition(-116,-103, "2987 mm")
		.checkBusinessRuleShowIn3D("Wall cabinet position", true)
		.undo(2)
		.verifyBusinessRuleRemoved("Wall cabinet position")
		.deleteProduct(-116,-103)
		.clickFloorplan()
		.addProduct("BOX OBJECT",false,true)	
		.editItemDimensionProperties(-72, -12, "","500 mm", "2000 mm", "","",0)
		.position(-72, -12, "1096 mm", "50 mm")
		.position(-200, -25, "1426 mm", "0 mm")
		.step3()
		.addProduct("WG10002", false, false, false)
		.checkBusinessRuleShowIn3D("Wall cabinet position", true)
		.position(-93, -117,"550 mm", "1550 mm", "")
		.verifyBusinessRuleRemoved("Wall cabinet position");
	

	}

}
