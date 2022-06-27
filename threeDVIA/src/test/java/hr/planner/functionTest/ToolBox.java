package hr.planner.functionTest;

import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class ToolBox extends Browser {
	
	public void toolBox() {
		
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
		
		home.planMyRoomClick()
		.zoomIn(1)
		.zoomOut(1)		
//		.floorLevelBtn()
//		.levelSelector("Basement 1")
		.levelToLevelManager()		
		.addFloor()
		.addBasement()
		.floorName("1", "FF")
		.floorHeight("1", "270")
		.floorDelete("2")		
		.levelManagerClose()
		.viewModeOptions()
		.cameraHeight("1m") //option= 2.3 , 1.7  , 1 , 0.2
		.viewTwoD()
		.viewModeOptions()
		.displayRoomName()
		.displayRoomArea()
		;
//		.viewThreeD();
		//need to check when view mode options are disabled
	}
		

	

}
