package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDisBetCutoutsAndOtherOperationsRuleForWallPanelCase4 extends Browser {
	@Test
	public void minDisBetCutoutsAndOtherOperationsRuleForWallPanelCase4(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProperty(-112, -6, "Wall Panel", "GB_WP_LAMINATE", "all", true)
		.wallPanelEditor(-112, -6)
		.zoomIn(4)
		.createCutOutForWallPanel(-390, 47, "Rectangle", "155 mm", "155 mm", "", "", "")
		.editWallPanelCutOutDimension(-342, 51, "362 mm", "10 mm")
		.checkBusinessRuleInWallPanel("Minimum distance between cut-out and edge of the wall panel")
		.undoInWallPanelEditor(driver, 1)
		.verifyBusinessRuleInWallPanelRemoved("Minimum distance between cut-out and edge of the wall panel")
		.undoInWallPanelEditor(driver, 5)
		.createCutOutForWallPanel(-390, 47, "Circle", "", "", "", "", "155 mm")
		.editWallPanelCutOutDimension(-342, 51, "440 mm", "70 mm")
		.checkBusinessRuleInWallPanel("Minimum distance between cut-out and edge of the wall panel")
		.undoInWallPanelEditor(driver, 1)
		.verifyBusinessRuleInWallPanelRemoved("Minimum distance between cut-out and edge of the wall panel");
	}

}
