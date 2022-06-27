package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDisBetCutoutsAndOtherOperationsRuleForWallPanelCase2 extends Browser {
	@Test
	public void minDisBetCutoutsAndOtherOperationsRuleForWallPanelCase2(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProperty(-112, -6, "Wall Panel", "GB_WP_LAMINATE", "all", true)
		.wallPanelEditor(-112, -6)
		.editWallPanelYes()
		.zoomIn(4)
		.createCutOutForWallPanel(-390, 47, "Rectangle", "55 mm", "55 mm", "", "", "")
		.editWallPanelCutOutDimension(-342, 51, "412 mm", "10 mm")
		.checkBusinessRuleInWallPanel("Minimum distance between cut-out and edge of the wall panel")
		.undoInWallPanelEditor(driver, 1)
		.verifyBusinessRuleInWallPanelRemoved("Minimum distance between cut-out and edge of the wall panel")
		.undoInWallPanelEditor(driver, 5)
		.createCutOutForWallPanel(-390, 47, "Circle", "", "", "", "", "55 mm")
		.editWallPanelCutOutDimension(-342, 51, "440 mm", "10 mm")
		.checkBusinessRuleInWallPanel("Minimum distance between cut-out and edge of the wall panel")
		.undoInWallPanelEditor(driver, 1)
		.verifyBusinessRuleInWallPanelRemoved("Minimum distance between cut-out and edge of the wall panel");
	}

}
