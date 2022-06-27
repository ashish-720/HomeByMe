package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDimensionXYDoubleCutRule extends Browser {
	@Test
	public void minDimensionXYDoubleCutRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.worktopEditor(-112, -6)
		.editWorktopYes()
		.zoomIn(5)
		.createCornerCutOut(-200, -241, "", "Double", "", "", "150 mm", "100 mm", "yes", "", "", "", "")
		.checkWorktopEditorBusinessRules("Minimum dimension for a double, not right angled cut");
		
	}

}
