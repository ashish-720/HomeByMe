package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class IllustrationWallPanel extends Browser {
	@Test
	public void illustrationWallPanelTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.addProduct("U2DA80", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.position(-50, -14, "825 mm", "1825 mm", "")
		.verifyPosition(25, -13, "1000 mm")
		.addProperty(-115,-11, "Wall Panel", "GB_WP_LAMINATE", "selection", true)
		.addProperty(26,-9, "Wall Panel", "illustration wall panel", "", true)
		.wallPanelEditor(26, -9)
		.editWallPanelYes()
		.verifyWallPanelTypes("Custom and precut","Illustration purpose only")
		.validateWallPanelEditor()
		.deleteProduct(-74, 30)
		.wallPanelEditor(62, 37);
//		.verifyWallPanelTypes("","Illustration purpose only");
		
		
	}
}
