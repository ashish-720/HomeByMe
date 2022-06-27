package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class AddProductFromInfo extends Browser {
	@Test
	public void addProductFromInfoPopUpTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.addProductFromInfo("GVARIO03", true, false, true);

	}
}
