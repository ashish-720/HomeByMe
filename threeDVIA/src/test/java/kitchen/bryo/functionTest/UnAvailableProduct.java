package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class UnAvailableProduct extends Browser {
	@Test
	public void unAvailableProductTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.addProduct("U2DA50", true, false, false)
		.addProduct("WG6002", false, false, false)
		.replaceProductFromEdit(-115, -11, "Base Cabinet - 1486",  false, true, false)
		.verifyPrice("3 836,00");
		

	}
	
}
