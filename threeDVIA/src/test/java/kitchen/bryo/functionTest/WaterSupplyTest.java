package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class WaterSupplyTest extends Browser {
	@Test
	public void waterSupplyTest() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.addWaterSupply(-239,60).verifyWaterSupply();

	}

}
