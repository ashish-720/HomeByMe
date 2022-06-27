package enterprise.bathroom.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class EditWall extends Browser {
	@Test
	public void editWallTest() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.launchApp()
		.editWallDimension(-243, -93, "3000 mm", "apply above")
		.verifyWallProperty(-243, -93, "3000 mm")
		.editWallProperties(-243, -93, "90 mm","")
		.verifyWallProperties(-243, -93, "90 mm","2500 mm",1);
	}

}
