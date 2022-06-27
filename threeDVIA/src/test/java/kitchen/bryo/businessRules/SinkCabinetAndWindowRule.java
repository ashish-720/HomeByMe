package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class SinkCabinetAndWindowRule extends Browser {
	@Test
	public void sinkCabinetAndWindowRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.addProduct("DOUBLE WINDOW",false,false)
		.moveWall(254, 27, 4,-240)	
		.step3()
		.verifyPrice("0,00")
		.addProduct("SPUD100", true, false, false)
		.position(99, -16, "12 mm", "33 mm", "")
		.editFaucetOptionsProperty(99, -16, "", "20 mm", "", "Bottom")
		.checkBusinessRuleShowIn3D("Sink cabinet in front of window", true)
		.clickFloorplan()
		.editItemDimensionProperties(4, -240, "", "1200 mm", "", "", "", 0)
		.step3()
		.verifyBusinessRuleRemoved("Sink cabinet in front of window");
		
	}

}
