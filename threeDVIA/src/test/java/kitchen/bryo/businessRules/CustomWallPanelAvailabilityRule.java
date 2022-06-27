package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class CustomWallPanelAvailabilityRule extends Browser {
	@Test
	public void customWallPanelAvailabilityRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.addProperty(-112, -6, "Wall Panel", "GB_WP_LAMINATE", "all", true)
		.wallPanelEditor(-112, -6)
		.editWallPanelYes()
		.zoomIn(4)		
		.removeJointForWallPanel(-256, 53)
		.checkBusinessRuleInWallPanel("There is no product available to make this wall panel")
		.undoInWallPanelEditor(driver, 1)
		.verifyBusinessRuleInWallPanelRemoved("There is no product available to make this wall panel");
	}

}
