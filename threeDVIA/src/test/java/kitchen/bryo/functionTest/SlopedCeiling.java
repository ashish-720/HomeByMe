package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class SlopedCeiling extends Browser {
	@Test
	public void slopedCeilingTest() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
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
		.threeDView()
		.step3()
		.addProduct("U2DA80", true, false, false)
		.addProduct("SPUDSA60", true, false, false)
		.addProperty(-125,-25, "Wall Panel", "GB_WP_LAMINATE", "all", true)
		.verifyAddProperty(-125,-25,"Wall Panel", "GB_WP_LAMINATE")
		.addProduct("W6002", true, false, false)
		.checkBusinessRuleShowIn3D("Wall cabinet position", true)
		.tooltipsForPosition(163,-56)
		.position(163,-56, "220 mm", "320 mm", "")
		.verifyPosition(163,-56, "320 mm")
		.verifyBusinessRuleRemoved("Wall cabinet position")
		.checkBusinessRuleShowInWallPanel("Wall panel colliding with sloped ceiling")
		.editWallPanelDimension(-67, 44,"550 mm", "200 mm", "above")
		.verifyBusinessRuleInWallPanelRemoved("Wall panel colliding with sloped ceiling")
		.validateWallPanelEditor()
		.verifyBusinessRuleRemoved("Wall panel colliding with sloping ceiling");
//		.checkBusinessRuleShowInWorktop("Minimum distance between a sink or hob and end of worktop", true)
//		.editWorktopDimension(-85, -148, "1480 mm", "1578 mm", "apply right")
//		.verifyBusinessRuleInWorktopEditorRemoved("Minimum distance between a sink or hob and end of worktop")
//		.validateWorktopEditor()
//		.verifyBusinessRuleRemoved("Minimum distance between a sink or hob and end of worktop");
		

	}

}
