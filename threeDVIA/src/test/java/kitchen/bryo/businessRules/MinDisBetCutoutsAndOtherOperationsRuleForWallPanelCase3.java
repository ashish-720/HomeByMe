package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDisBetCutoutsAndOtherOperationsRuleForWallPanelCase3 extends Browser {
	@Test
	public void minDisBetCutoutsAndOtherOperationsRuleForWallPanelCase3(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProperty(-112, -6, "Wall Panel", "GB_WP_LAMINATE", "all", true)
		.wallPanelEditor(-112, -6)
		.editWallPanelYes()
		.zoomIn(4)
		.createCutOutForWallPanel(-345, 47, "Rectangle", "155 mm", "155 mm", "", "", "")
		.createCutOutForWallPanel(-390, 47, "Rectangle", "155 mm", "155 mm", "", "", "")
		.editWallPanelCutOutDimension(-295, 16, "374 mm", "200 mm")
		.checkBusinessRuleInWallPanel("Minimum distance between cut-out and another cut-out")
		.undoInWallPanelEditor(driver, 1)
		.verifyBusinessRuleInWallPanelRemoved("Minimum distance between cut-out and another cut-out")
		.undoInWallPanelEditor(driver, 5)
		.createCutOutForWallPanel(-345, 47, "Circle", "", "", "", "", "155 mm")
		.createCutOutForWallPanel(-390, 47, "Circle", "", "", "", "", "155 mm")
		.editWallPanelCutOutDimension(-295, 16, "385 mm", "275 mm")
		.editWallPanelCutOutDimension(-287, 49, "687 mm", "620 mm")
		.checkBusinessRuleInWallPanel("Minimum distance between cut-out and another cut-out")
		.undoInWallPanelEditor(driver, 1)
		.verifyBusinessRuleInWallPanelRemoved("Minimum distance between cut-out and another cut-out")
		.undoInWallPanelEditor(driver, 5)
		.createCutOutForWallPanel(-345, 47, "Rectangle", "155 mm", "155 mm", "", "", "")
		.createCutOutForWallPanel(-390, 47, "Circle", "", "", "", "", "155 mm")
		.editWallPanelCutOutDimension(-296, 9, "451 mm", "275 mm")
		.checkBusinessRuleInWallPanel("Minimum distance between cut-out and another cut-out")
		.undoInWallPanelEditor(driver, 1)
		.verifyBusinessRuleInWallPanelRemoved("Minimum distance between cut-out and another cut-out");
	}

}
