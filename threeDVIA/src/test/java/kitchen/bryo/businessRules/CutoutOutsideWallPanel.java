package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class CutoutOutsideWallPanel extends Browser {
	@Test
	public void cutoutOutsideWallPanel(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProperty(-112, -6, "Wall Panel", "GB_WP_LAMINATE", "all", true)
		.wallPanelEditor(-112, -6)
		.editWallPanelYes()
		.zoomIn(4)
		.createCutOutForWallPanel(-336, 42, "Rectangle", "150 mm", "150 mm", "", "", "")
		
		.editWallPanelCutOutDimension(-338, 30, "365 mm", "1200 mm")
		
		.checkBusinessRuleInWallPanel("Wall panel cut-out position")
		.undoInWallPanelEditor(driver, 1)
		.verifyBusinessRuleInWallPanelRemoved("Wall panel cut-out position");
	}

}
