package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class EcoFee extends Browser {
	@Test
	public void ecoFeeTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.ecoFeeProduct("U2DA80", "U2DA80", "");
		
		
	}
}
