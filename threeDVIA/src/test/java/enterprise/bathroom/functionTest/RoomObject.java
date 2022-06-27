package enterprise.bathroom.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class RoomObject extends Browser {
	@Test
	public void roomObjectsTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.launchApp()
		.addProduct("COLUMN|9622",false,false)
//		.productInfo(-75, -14);
		.position(-75, -14, "2579 mm", "850 mm")
		.verifyPosition(131,-9, "850 mm")
		.threeDView()
		.verifyPosition(108, 12, "850 mm")
		.translateProduct(111,5, -44,19)
		.verifyPosition(63,56, "1368 mm")
		.undo(driver,5)
		.verifyPosition(108, 12, "850 mm")
		.editItemDimensionProperties(108, 12, "","300 mm", "1500 mm", "300 mm","",0)
		.verifyItemDimensionProperties(101, 93,"", "300 mm", "1500 mm", "300 mm","")
		.duplicate(101, 93)
		.verifyItemDimensionProperties(101, 93,"", "300 mm", "1500 mm", "300 mm","")
		.addProduct("BOX OBJECT",false,false)	
		.addProduct("COLUMN",false,false)	
		.duplicateMultipleProducts("roomObjectMultipleDup1")
		.twoDView().threeDView()
		.positionMultipleProducts("roomObjectMultiplePosition", "525 mm", "1075 mm")
		.verifyMultipeProductsPosition("roomObjectMultipleVerifyPosition", "1075 mm")
		.deleteMultipleProducts("roomObjectMultipleDelete");
	}

}
