package kitchen.templateEditor.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.templateEditor.pageObject.Floorplan;
import kitchen.templateEditor.pageObject.StartNow;

@Test
public class RoomObject extends Browser {

	public void teRoomObject() {
		StartNow start=PageFactory.initElements(driver, StartNow.class);
		start.startNow();
		Floorplan f1=PageFactory.initElements(driver, Floorplan.class);
		f1.verifyFloorplan()
		.addProduct("COLUMN")
		.goToThreeDView()
		.positionObject(-43,35, 2404,500)
		.changeDimensions(136,-3,800,800,800)
		.duplicateProduct(114,89,51,95)
		.deleteProduct(114,89);
	}
 

}
