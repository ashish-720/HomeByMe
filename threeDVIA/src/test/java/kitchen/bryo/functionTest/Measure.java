package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class Measure extends Browser {
	@Test
	public void measureTest() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.addProduct("GVARIO03", true, false, true)
		.addProduct("U2DA80", true, false, false)
		.position(-53, -8, "2524 mm", "100 mm", "")
		.measureEdit(-101, -19, 95, -19,"2682 mm");
		
	}
}
