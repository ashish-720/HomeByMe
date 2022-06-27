package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class WorktopWallPanelTypes extends Browser {
	@Test
public void worktopWallPanelTypesTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.addProduct("U2DA80", true, false, false)
		
		//KIT:1678 -As a user, when closing the "more about worktop/wall panel types" I am presented with the previous pop-in
		.worktopEditor(-115, -11)
		.editWorktopByCheckingLearnMoreAboutWorkop()
		.verifyPriceInWorktop("");
//		.worktopWallPanelTypes(-115, -11, "");
				
	}
}
