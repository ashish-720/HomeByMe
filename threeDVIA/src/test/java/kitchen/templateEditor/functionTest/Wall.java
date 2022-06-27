package kitchen.templateEditor.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.FloorPlan;
import kitchen.templateEditor.pageObject.Floorplan;
import kitchen.templateEditor.pageObject.StartNow;


@Test
public class Wall extends Browser {
	public void teWall() {
		StartNow start=PageFactory.initElements(driver, StartNow.class);
		start.startNow();
		Floorplan f1=PageFactory.initElements(driver, Floorplan.class);
		f1.verifyFloorplan();
		FloorPlan floorPlan=PageFactory.initElements(driver, FloorPlan.class);
		floorPlan.addWall("bryoRoomAddWall")
		.delete(0,0)
		.addRoomSeparators("bryoRoomAddSeparation");
	}
}
