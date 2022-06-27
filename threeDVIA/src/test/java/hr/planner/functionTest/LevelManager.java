package hr.planner.functionTest;

import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class LevelManager extends Browser {
	
	public void levelManger() {
		
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
		
		home.planMyRoomClick()
		.floorPlan()
//		.initialPlan()
		.manageLevel()
		.addFloor()
		.addBasement()
		.floorName("1", "FF")
		.floorHeight("1", "270")
		.floorDelete("2")
		.levelManagerClose();
	}
}
