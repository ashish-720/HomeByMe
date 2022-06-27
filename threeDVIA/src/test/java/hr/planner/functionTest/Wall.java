package hr.planner.functionTest;

import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class Wall extends Browser {
	
	public void wall() {
		
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
		
		home.planMyRoomClick()
		
		.floorPlan()
		.addWall()
		.drawWall("-162;-162>-500;-162>-500;160>-162;160")
		.validate()
		.verifyNoOfRoomTag(2)
		.viewTwoD()
		.editWall(-154, -10, "20", "240")
		.splitWall()
		.clickInPlanner(-154, -10)
		.deleteProd()
		.verifyNoOfRoomTag(1)
		.undo()
		.verifyNoOfRoomTag(2)
		
		;
	}
}
