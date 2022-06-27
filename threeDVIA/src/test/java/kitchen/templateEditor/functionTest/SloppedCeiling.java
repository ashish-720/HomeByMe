package kitchen.templateEditor.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;

import kitchen.templateEditor.pageObject.Floorplan;
import kitchen.templateEditor.pageObject.StartNow;

@Test
public class SloppedCeiling extends Browser {

	
	public void teSloppedCeiling() {
		StartNow start=PageFactory.initElements(driver, StartNow.class);
		start.startNow();
		Floorplan floorplan=PageFactory.initElements(driver, Floorplan.class);
		floorplan.verifyFloorplan()
		.sloppedCeiling(185, 113, 1500,"hdist",900)
		.verifySlopedCeiling(185, 113, 1500, "hdist",900);
		
	}
}
