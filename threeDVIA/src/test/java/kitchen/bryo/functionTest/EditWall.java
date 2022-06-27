package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class EditWall extends Browser {
	@Test
	public void editWallTest() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.editWallDimension(-243, -93, "3000 mm", "apply above")
		.verifyWallProperty(-243, -93, "3000 mm")
		.editWallProperties(-243, -93, "90 mm","")
		.verifyWallProperties(-243, -93, "90 mm","2500 mm",1);
//		plan.splitWall(-243, -93, "bryoSplitWall", "bryoSplitWallDestination", "bryoSplitWallFinal");
//		plan.verifySplitWall(-287, 129, "1455 mm");
	}

}
