package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class Wall extends Browser {
	@Test
	public void createWallTest() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.addWall("bryoRoomAddWall")
		.delete(0,0)
		.undo(driver, 1)
		.redo(driver, 1)
		.addRoomSeparators("bryoRoomAddSeparation")
		.undo(driver, 2)
		.splitWall(0, 0)
		.moveWall(-50, 0, -50, -76)
		.verifyWallProperty(-50, -76, "2075 mm");
		
	}

}
