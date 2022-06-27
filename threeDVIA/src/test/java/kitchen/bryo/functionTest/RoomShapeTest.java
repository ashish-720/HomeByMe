package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.FloorPlan;
import kitchen.bryo.pageObject.StartNow;

public class RoomShapeTest extends Browser {
	@Test
	public void roomShapeTest() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.tooltipsForFloorplan()
		.roomShape("Open", 2)
		.roomType(-15,135, "Kitchen")
		.verifyRoomType(-15,135,"Kitchen", "Kitchen")
		.deleteWall(236, 30)
		.deleteWall(-65, -30)
		.nextStep()
		.invalidLayout()
		.undo(driver, 5)
		.splitWall(-116, -27)
		.moveWall(-95, -27, -28, 1)
		.verifySplitRoomSeparator(-59, 0, "1037 mm")
		.nextStep()
		.skipLayoutNo()
		.waterSupplyPositionPopUp("Yes", 211, 4)
		.showMore()
		.showAppliances("Cooktops")
		.showLess();
	}

}
