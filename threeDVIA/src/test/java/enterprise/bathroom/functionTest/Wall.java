package enterprise.bathroom.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Wall extends Browser {
	@Test
	public void createWallTest() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.launchApp()
		.addWall("bryoRoomAddWall")
		.deleteWall(0,0)
		.undo(driver, 1)
		.redo(driver, 1)
		.addWall("bryoRoomAddWall")
		.delete(0,0)
		.addRoomSeparators("bryoRoomAddSeparation")
		.undo(driver, 2)
		.splitWall(0, 0)
		.moveWall(113, 0, 99, -110)
		.verifyWallProperty(200, -106, "2075 mm");
		
	}

}
