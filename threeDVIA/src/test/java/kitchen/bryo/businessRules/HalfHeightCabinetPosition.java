package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class HalfHeightCabinetPosition extends Browser {
	@Test
	public void halfHeightabinetPositionRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("test_HalfHeightCabinet", true, false, false)
		.position(-124, -61,"50 mm", "0 mm", "")
		.verifyPosition(-124, -61, "3387 mm")
		.checkBusinessRuleShowIn3D("Half Height Cabinet Position", true)
		.undo(4)
		.verifyBusinessRuleRemoved("Half Height Cabinet Position")
		.verifyPosition(-124, -61, "50 mm")
		.deleteProduct(-112, -6)
		.clickFloorplan()
		.addProduct("BOX OBJECT",false,false)	
		.editItemDimensionProperties(-72, -12, "","500 mm", "1500 mm", "","",0)
		.position(-72, -12, "1096 mm", "50 mm")
		.position(-200, -25, "1426 mm", "0 mm")
		.step3()
		.addProduct("test_HalfHeightCabinet", true, false, false)
		.checkBusinessRuleShowIn3D("Half Height Cabinet Position", true)
		.position(-72, -2,"550 mm", "1550 mm", "")
		.verifyBusinessRuleRemoved("Half Height Cabinet Position");
	

	}

}
