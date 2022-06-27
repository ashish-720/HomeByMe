package kitchen.templateEditor.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.templateEditor.pageObject.Floorplan;
import kitchen.templateEditor.pageObject.StartNow;

@Test
public class Covering extends Browser {

	
	public void teCovering() {
		StartNow start=PageFactory.initElements(driver, StartNow.class);
		start.startNow();
		Floorplan f1=PageFactory.initElements(driver, Floorplan.class);
		f1.verifyFloorplan()
		.applyCoveringUsingWall(206	,78, "PAINT", "2", "Apply")
		.applyCovering("PAINT", "Apply", "0", 0,-74);
		} 
}
