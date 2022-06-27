package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDimensionRCutRule extends Browser {
	@Test
	public void minDimensionRCutRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.worktopEditor(-112, -6)
		.editWorktopYes()
		.zoomIn(5)
		.createCornerCutOut(-200, -241, "", "Inner Rounded", "", "", "", "", "", "", "", "80 mm", "")
		.createCornerCutOut(-200, -241, "", "Inner Rounded", "", "", "", "", "", "", "", "95 mm", "");
	}

}
