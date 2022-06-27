package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class SinkCabinetPosition extends Browser {
	@Test
	public void sinkCabinetPositionRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("SPUD100", true, false, false)
		.checkBusinessRuleShowIn3D("Sink cabinet position", true)
		.position(-112, -6,"50 mm", "100 mm", "")
		.verifyPosition(-112, -6, "100 mm")	
		.verifyBusinessRuleRemoved("Sink cabinet position")
		.deleteProduct(-112, -6)
		.clickFloorplan()
		.addProduct("BOX OBJECT",false,true)	
		.editItemDimensionProperties(-72, -12, "","500 mm", "1500 mm", "","",0)
		.position(-72, -12, "1096 mm", "50 mm")
		.position(-200, -25, "1426 mm", "0 mm")
		.step3()
		.addProduct("SPUD100", true, false, false)
		.checkBusinessRuleShowIn3D("Sink cabinet position", true)
		.position(-72, -2,"550 mm", "1550 mm", "")
		.verifyBusinessRuleRemoved("Sink cabinet position");
	

	}

}
