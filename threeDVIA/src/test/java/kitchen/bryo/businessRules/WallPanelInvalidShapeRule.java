package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class WallPanelInvalidShapeRule extends Browser {
	@Test
	public void wallPanelInvalidShapeRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.addProperty(-112, -6, "Wall Panel", "GB_WP_LAMINATE", "all", true)
		.wallPanelEditor(-112, -6)
		.editWallPanelYes()
		.zoomIn(4)		
		.cornerCutForWallPanel(-70, -12, "Single", "300 mm", "900 mm", "", "", "", "", "")
		.checkBusinessRuleInWallPanel("Wall panel shape")
		.undoInWallPanelEditor(driver, 2)
		.verifyBusinessRuleInWallPanelRemoved("Wall panel shape");
	}

}
