package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class WallPanelMinDimensionABTripleCutRule extends Browser {
	@Test
	public void wallPanelMinDimensionABTripleCutRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProperty(-112, -6, "Wall Panel", "GB_WP_LAMINATE", "all", true)
		.wallPanelEditor(-112, -6)
		.editWallPanelYes()
		.zoomIn(4)
		.addWallPanelEdgeCut(-250, 30, "Triple", "150 mm", "150 mm", "", "", "")
		.editWallPanelDimension(-256, 32, "150 mm", "90 mm","apply left")
		.checkBusinessRuleInWallPanel("Minimum dimension for a triple cut (excluding glass wall panels)")
		.undoInWallPanelEditor(driver, 1)
		.verifyBusinessRuleInWallPanelRemoved("Minimum dimension for a triple cut (excluding glass wall panels)");
	}

}
