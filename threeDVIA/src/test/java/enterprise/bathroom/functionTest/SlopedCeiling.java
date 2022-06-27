package enterprise.bathroom.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SlopedCeiling extends Browser {
	@Test
	public void slopedCeilingTest() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.launchApp()
		.manageSlopedWalls()
		.addslopedCeiling3D(191,88, "1500 mm", "", "")
		.manageSlopedWalls()
		.verifySlopedCeiling3D(115,-15,"1500 mm","","")
		.deleteSlopedCeiling(115,-15)
		.verifyDeleteSlopedCeiling3D(191,88)
		.manageSlopedWalls()
		.addslopedCeiling2D(-201,37, "1200 mm", "", "")
		.manageSlopedWalls()
		.verifySlopedCeiling2D(-201,37,"1200 mm","","")
		.deleteSlopedCeiling(-201,37)
		.verifyDeleteSlopedCeiling2D()
		.manageSlopedWalls()
		.addslopedCeiling3D(0,-100, "1200 mm", "750 mm", "")
		.verifySlopedCeiling3DTo2D()
		.threeDView();

		

	}

}
