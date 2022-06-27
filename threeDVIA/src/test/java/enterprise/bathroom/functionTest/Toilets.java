package enterprise.bathroom.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Toilets extends Browser {
	@Test
	public void toiletTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.launchApp()
		.step3()
		.addProductBathroom("Freestanding toilet", true,false,false)
		.verifyProduct(-124,-12,"Freestanding toilet")
		.position(-124,-12,"3617 mm","1800 mm","")
		.duplicateProduct(10,-26)
		.deleteProduct(-124,-12)
		.undo(1)
		.addProductBathroom("Freestanding toilet", true,false,false)
		.duplicateProduct(10,-26)
				.deleteProduct(-65,-27)
				.deleteProduct(12,-21)
				.deleteProduct(-118,-18)
				.undo(1);


		
	}
}
