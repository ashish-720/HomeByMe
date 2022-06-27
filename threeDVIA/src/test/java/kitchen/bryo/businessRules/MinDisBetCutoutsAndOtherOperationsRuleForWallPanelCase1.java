package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDisBetCutoutsAndOtherOperationsRuleForWallPanelCase1 extends Browser {
	@Test
	public void minDisBetCutoutsAndOtherOperationsRuleForWallPanelCase1(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)	
		.addProperty(-112, -6, "Wall Panel", "GB_WP_LAMINATE", "all", true)
		.wallPanelEditor(-112, -6)
		.editWallPanelYes()
		.zoomIn(4)
		.createCutOutForWallPanel(-345, 47, "Rectangle", "55 mm", "55 mm", "", "", "")
		.createCutOutForWallPanel(-390, 47, "Rectangle", "55 mm", "55 mm", "", "", "")
		.editWallPanelCutOutDimension(-295, 16, "399 mm", "248 mm")
		.editWallPanelCutOutDimension(-296, 47, "619 mm", "475 mm")
		.checkBusinessRuleInWallPanel("Minimum distance between cut-out and another cut-out")
		.undoInWallPanelEditor(driver, 1)
		.verifyBusinessRuleInWallPanelRemoved("Minimum distance between cut-out and another cut-out")
		.undoInWallPanelEditor(driver, 5)
		.createCutOutForWallPanel(-345, 47, "Circle", "", "", "", "", "55 mm")
		.createCutOutForWallPanel(-390, 47, "Circle", "", "", "", "", "55 mm")
		.editWallPanelCutOutDimension(-295, 21, "401 mm", "275 mm")
		.editWallPanelCutOutDimension(-293, 47, "668 mm", "500 mm")
		.checkBusinessRuleInWallPanel("Minimum distance between cut-out and another cut-out")
		.undoInWallPanelEditor(driver, 1)
		.verifyBusinessRuleInWallPanelRemoved("Minimum distance between cut-out and another cut-out")
		.undoInWallPanelEditor(driver, 5)
		.createCutOutForWallPanel(-345, 47, "Rectangle", "55 mm", "55 mm", "", "", "")
		.createCutOutForWallPanel(-390, 47, "Circle", "", "", "", "", "55 mm")
		.editWallPanelCutOutDimension(-291, 12, "426 mm", "300 mm")
		.editWallPanelCutOutDimension(-298, 41, "646 mm", "500 mm")
		.checkBusinessRuleInWallPanel("Minimum distance between cut-out and another cut-out")
		.undoInWallPanelEditor(driver, 1)
		.verifyBusinessRuleInWallPanelRemoved("Minimum distance between cut-out and another cut-out");
	}

}
