package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class WallPanelMinDimensionABDoubleCutRuleCase2 extends Browser {
	@Test
	public void wallPanelMinDimensionABDoubleCutRuleCase2(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProperty(-112, -6, "Wall Panel", "GB_WP_LAMINATE", "all", true)
		.wallPanelEditor(-112, -6)
		.editWallPanelYes()
		.zoomIn(4)
		.cornerCutForWallPanel(-235, -13, "Double", "", "", "150 mm", "100 mm", "yes", "175 mm", "200 mm")
		.editWallPanelDimension(-235, 50, "450 mm", "520 mm", "apply above")
		.checkBusinessRuleInWallPanel("Minimum dimension for a double cut (excluding glass wall panels)")
		.undoInWallPanelEditor(driver, 1)
		.verifyBusinessRuleInWallPanelRemoved("Minimum dimension for a double cut (excluding glass wall panels)");
	}

}
