package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class WallPanelMinDimensionABDoubleCutRuleCase1 extends Browser {
	@Test
	public void wallPanelMinDimensionABDoubleCutRuleCase1(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProperty(-112, -6, "Wall Panel", "GB_WP_LAMINATE", "all", true)
		.wallPanelEditor(-112, -6)
		.editWallPanelYes()
		.zoomIn(4)
		.cornerCutForWallPanel(-235, -13, "Double", "", "", "55 mm", "55 mm", "", "", "")
		.editWallPanelDimension(-320, -13, "825 mm", "830 mm", "apply right")
		.checkBusinessRuleInWallPanel("Minimum dimension for a double cut (excluding glass wall panels)")
		.undoInWallPanelEditor(driver, 1)
		.verifyBusinessRuleInWallPanelRemoved("Minimum dimension for a double cut (excluding glass wall panels)");
	}

}
