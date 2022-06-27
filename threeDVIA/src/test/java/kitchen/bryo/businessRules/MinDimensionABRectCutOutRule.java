package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDimensionABRectCutOutRule extends Browser {
	@Test
	public void minDimensionABRectCutOutRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.worktopEditor(-112, -6)
		.editWorktopYes()
		.createCutOut(-180, -188, "Rectangle", "30 mm", "30 mm", "", "", "")
		.zoomIn(4)
		.verifyWorktopCutOut(-276, -284, "100 mm", "100 mm", "", "", "440 mm", "209 mm");
	}

}
