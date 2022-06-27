package enterprise.bathroom.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Measure extends Browser {
	@Test
	public void measureTest() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.launchApp()
		.step3()
		.addProductBathroom("Swing Door Shower",true, false, false)
		.addProductBathroom("Freestanding toilet", true, false, false)
		.position(-56, -27, "2717 mm", "100 mm", "")
		.measureEdit(-77, -4, 110, 18,"2870 mm");
		
	}
}
