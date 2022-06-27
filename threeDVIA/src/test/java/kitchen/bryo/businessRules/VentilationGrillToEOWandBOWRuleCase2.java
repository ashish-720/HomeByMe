package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class VentilationGrillToEOWandBOWRuleCase2 extends Browser {
	@Test
	public void ventilationGrillToEOWandBOWRuleCase2(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.duplicateProduct(-112, -6)
		.addProductThroughSearch("Grill", "Aeration Grid", true, false)
		.rotateProjectView(10, "left")
		.zoomIn(7)
		.position(-65, 256, "1258 mm", "1000 mm", "")
		.elevateProduct(-65, 256, -252, 101)
		.position(-196, 200, "468 mm", "950 mm", "")
		.position(-226, 114, "1961 mm", "60 mm", "")
		.position(7, -194, "2516 mm", "2350 mm", "")
		.position(39, -187, "70 mm", "0 mm", "")
		.checkBusinessRuleShowInWorktop("Minimum distance between ventilation grill to end of the worktop.", true)
		.editWorktopYes()
		.validateWorktopEditor()
		.zoomIn(9)
		.rotateProjectView(4, "up")
		.position(123, 42, "1166 mm", "1000 mm", "")
		.verifyBusinessRuleRemoved("Minimum distance between ventilation grill to end of the worktop.");
		
	}

}
