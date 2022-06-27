package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistBTWallUnitToObstacleCeiling extends Browser {
	@Test
	public void minDistBTWallUnitToObstacleCeiling() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
//		.step3().verifyPrice("0,00")
//		.addProduct("HOR400", true, false, false)
//		.position(-128,-97, "420 mm", "20 mm", "")
//		.checkBusinessRuleShowIn3D("Distance between wall cabinet and ceiling", true)
//		.undo(2)
//		.verifyBusinessRuleRemoved("Distance between wall cabinet and ceiling")
//		.deleteProduct(-128, -120)
//		.clickFloorplan()
		.addProduct("Cube",false,false)	
		.threeDView()
		.editItemDimensionProperties(-39,83, "", "", "150 mm", "", "", 0)
		.position(-39,83, "1096 mm", "50 mm")
		.position(-121,88, "1874 mm", "3500 mm")
		.zoomIn(3)
		.elevateProduct(-148,3, -148, -20)
		.position(-155, -54, "1563 mm", "0 mm")
		.step3()
		.addProduct("HOR400", true, false, false)
		.position(-8, -90, "1680 mm", "1900 mm", "")
		.checkBusinessRuleShowIn3D("Distance between wall cabinet to obstacle", true)
		.undo(2)
		.verifyBusinessRuleRemoved("Distance between wall cabinet to obstacle");
	}

}
