package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import kitchen.bryo.pageObject.Tooltips;

public class Accessories extends Browser {
	@Test
	public void accessoriesTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.tooltipsForFloorplan()
		.step3()
	
		//FUN121231 :As a user, when entering the design step I am notified about business rules : discoverDesign()
		.discoverDesignGuidelines()
		
		.addProduct("FLOOR LAMP|1125", true, false, false)
		.verifyProduct(-30, 0, "FLOOR LAMP")
//		.productInfo(-30, 0)
		.duplicateProduct(-30, 0)
		.deleteProduct(-70, 0)
		.verifyDelete(-30, 0, "FLOOR LAMP")
		.replaceProductFromEdit(-30, 0, "FLOOR LAMP|2086",true,false, false)
		.verifyReplaceProduct(-27, 36, "FLOOR LAMP")
		.clickFloorplan()
		.roomShape("open",1)
		.splitWall(1, -27)
		.verifySplitRoomSeparator(57, -27,"2000 mm")
		.moveWall(57, -27, 57, -85)
		.verifySplitRoomSeparator(1, -57, "517 mm")

				//Test scenarios for KIT-1906 :As a kitchen retailer, I can define if items are automatically placed on a wall, and I get a warning if they are not
				//Scenario 1 : Items with target position set to 'On wall' gets added as attached to wall whhereas if this setting is not set to 'On wall' the item will not come attached to wall
				.roomType(-0, 50, "Kitchen")
				.step3()
				.addProductThroughSearch("Lamp-V1_notOnWall_ODT", "Lamp-V1_notOnWall_ODT", true, false)
				.verifyProduct(-38, 115, "Lamp-V1_notOnWall_ODT")
				.verifyBusinessRuleRemoved("Item position")
				.addProductThroughSearch("Lamp-V1_onWall_ODT", "Lamp-V1_onWall_ODT", true, false)
				.verifyProduct(143, 35, "Lamp-V1_onWall_ODT")
				.position(143, 35,"2692 mm", "2600 mm", "")
				.position(143, 35,"3702 mm", "3600 mm", "")
				.verifyBusinessRuleRemoved("Item position")

				//Scenario 2 : Removing items with target pos as 'On wall'  from the wall triggers the item position BR
				.translateProduct(143, 35, -50, 0)
				.verifyProduct(94, 35, "Lamp-V1_onWall_ODT")
				.checkBusinessRuleShowIn3D("Item position", true)
				.translateProduct(94, 35, 50, 0)
				.verifyProduct(143, 35, "Lamp-V1_onWall_ODT")
				.verifyBusinessRuleRemoved("Item position");
	}
	
}
