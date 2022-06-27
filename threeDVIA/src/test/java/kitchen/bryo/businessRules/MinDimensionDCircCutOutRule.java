package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDimensionDCircCutOutRule extends Browser {
	@Test
	public void minDimensionDCircCutOutRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.worktopEditor(-112, -6)
		.editWorktopYes()
		.createCutOut(-180, -188, "Circle", "", "", "", "", "5 mm")
		.zoomIn(4)
		.verifyWorktopCutOut(-276, -284, "", "", "", "55 mm", "", "");
	}

}
