package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistanceSlopingCeilingAndCabinetsCase6 extends Browser {
	@Test
	public void minDistanceSlopingCeilingAndCabinetsCase6() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.manageSlopedWalls()
		.addslopedCeiling3D(76,-53, "", "", "")
		.step3().verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProperty(-111, -4, "Wall Panel", "GB_WP_LAMINATE", "all", true)
		.checkBusinessRuleShowInWallPanel("Wall panel position",true)
		.validateWallPanelEditor()
		.editWallPanelOptionsProperty(0, 0, "200 mm", "", "", "")
		.verifyBusinessRuleRemoved("Wall panel position");
	}

}
