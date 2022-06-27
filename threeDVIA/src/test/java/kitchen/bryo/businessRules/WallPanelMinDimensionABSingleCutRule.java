package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class WallPanelMinDimensionABSingleCutRule extends Browser {
	@Test
	public void wallPanelMinDimensionABSingleCutRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProperty(-112, -6, "Wall Panel", "GB_WP_LAMINATE", "all", true)
		.wallPanelEditor(-112, -6).editWallPanelYes()
		.zoomIn(4)
		.cornerCutForWallPanel(-235, -13, "Single", "55 mm", "55 mm", "", "", "", "", "")
		.editWallPanelDimension(-320, -13, "825 mm", "830 mm", "apply right")
		.checkBusinessRuleInWallPanel("Minimum dimension for a single cut (excluding glass wall panels)")
		.undoInWallPanelEditor(driver, 1)
		.verifyBusinessRuleInWallPanelRemoved("Minimum dimension for a single cut (excluding glass wall panels)")


	//FUN120662 : As a retailer, I can differentiate if a single cut is part or full depth
		//Scenario : check rule for wall panel
		.clickAndDrag(350, 0)
		.zoomIn(8)
		.moveCutOut(246, -2, 246, 100)
		.editWallPanelDimension(40, -29, "825 mm", "871 mm", "apply right")
		.moveCutOut(267, 93, 246, 100)
		.moveCutOut(246, 100, 246, 247)
		.verifyWallPanelDimension(40, -29, "871 mm")
		.verifyWallPanelDimension(40, 247, "880 mm")
		.checkBusinessRuleInWallPanel("Minimum dimension for a single cut","The minimum size of this operation is 10 mm. Current: 9 mm")
		.moveCutOut(242, -30, 225, -30)
		.verifyBusinessRuleInWallPanelRemoved("Minimum dimension for a single cut");
	}

}
