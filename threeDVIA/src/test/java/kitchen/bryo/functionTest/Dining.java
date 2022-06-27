package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class Dining extends Browser {
	@Test
	public void diningTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
//		.addDining("0", "Junior chairs")
		.addProduct("BABY CHAIR", true, false, false)
//		.productInfo(-42,49)
		.replaceProduct(-29,67, "CHAIR",true, false, false)
		.verifyReplaceProduct(-27,74, "CHAIR")
		.deleteProduct(-27,74)
		.undo(1)
		.verifyProduct(-27,74, "CHAIR");
		
	}
}
