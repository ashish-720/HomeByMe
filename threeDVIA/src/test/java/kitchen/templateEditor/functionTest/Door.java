package kitchen.templateEditor.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.templateEditor.pageObject.Floorplan;
import kitchen.templateEditor.pageObject.StartNow;

@Test
public class Door extends Browser {

	
	public void teDoor() {
		StartNow start=PageFactory.initElements(driver, StartNow.class);
		start.startNow();
		Floorplan f1=PageFactory.initElements(driver, Floorplan.class);
		f1.verifyFloorplan()
		.addProduct("INTERIOR DOOR").editOpening(245, 0, 1000, 1500).editBayPositionOpening(245, 0, 1550, 1000).duplicateProduct(245, 0, 251, -65);
	}
}
