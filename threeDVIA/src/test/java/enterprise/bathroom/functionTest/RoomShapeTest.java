package enterprise.bathroom.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class RoomShapeTest extends Browser {
	@Test
	public void roomShapeTest() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.launchApp()
		.roomShape("Closed", 2)
		.roomType(-15,135, "Bathroom")
		.verifyRoomType(-15,135,"Bathroom", "Bathroom")
		.deleteWall(236, 30)
		.undo(driver, 2)
		.nextStep();
	}

}


