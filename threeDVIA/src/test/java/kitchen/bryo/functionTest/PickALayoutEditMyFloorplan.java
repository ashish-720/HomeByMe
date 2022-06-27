package kitchen.bryo.functionTest;

import kitchen.bryo.pageObject.FloorPlan;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class PickALayoutEditMyFloorplan extends Browser {
	@Test
	public void pickALayoutFloorPlanTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.tooltipsForFloorplan()
		.roomShape("open", 2)
		.nextStep()
		.selectFromSeveralRoom("", -128, -158)
		.skipLayoutNo()
		.waterSupplyPositionPopUp("No", 0, 0)
		.editMyFloorplan()
		.roomType(-170, -110, "Dining room")
		.roomType(20, 0, "Kitchen")

		//Test to check that furniture don't overlap windows/doors in pick a layout step
		.roomShape("closed", 1)
		.addOpeningThroughWalls(10,-246,"DOUBLE WINDOW",false)
		.addOpeningThroughWalls(10,243,"INTERIOR DOOR",false)
		.addOpeningThroughWalls(-247,0,"DOUBLE WINDOW",false)
		.addOpeningThroughWalls(246,0,"DOUBLE WINDOW",false)
		.nextStep().skipLayoutNo().waterSupplyPositionPopUp("No",0,0)
		.noSolutionsFound("Edit my floorplan", FloorPlan.class);
	}

}
