package kitchen.templateEditor.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.templateEditor.pageObject.Floorplan;
import kitchen.templateEditor.pageObject.StartNow;

@Test
public class CeilingHeight extends Browser {

	
	public void teCeilingHeight() {
		StartNow start=PageFactory.initElements(driver, StartNow.class);
		start.startNow();
		Floorplan f1=PageFactory.initElements(driver, Floorplan.class);
		f1.verifyFloorplan()
		.changeCeilingHeight(5000)
		.verifyCeilingHeight(-5, -245, 5000);
		
	}
}
