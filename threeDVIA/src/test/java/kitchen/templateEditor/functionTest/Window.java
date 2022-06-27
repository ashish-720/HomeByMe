package kitchen.templateEditor.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.templateEditor.pageObject.Floorplan;
import kitchen.templateEditor.pageObject.StartNow;

@Test
public class Window extends Browser {

	public void teWindow() {
		StartNow start=PageFactory.initElements(driver, StartNow.class);
		start.startNow();
		Floorplan f1=PageFactory.initElements(driver, Floorplan.class);
		f1.verifyFloorplan()
		.addProduct("DOUBLE WINDOW").editOpening(249,2, 1200,600,1000).editBayPositionOpening(249, 2, 1049, 500).duplicateProduct(249, 10, 249, 25)
		.deleteProduct(249, 25);
	}
}
