package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class Coverings extends Browser {
	@Test
	public void coveringTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.addCovering("WALL TILE|9488", "all")
		.verifyLastUsedMaterial("9488")
		.verify3Dwallpaint(22, -80, "WALL TILE")
		.undo(driver, 2)
		.addCoveringByClickingWallFloor(-173, 41,"PAINT|4351","all",0 ,0)
		.clickBlankAfterPaint()
		.verify3Dwallpaint(22, -80, "PAINT|4351")
		.verifyLastUsedMaterial("4351")
		.addCoveringByClickingWallFloor(-173, 41, "PAINT|4363", "selection", -173, 41)
		.applyMaterialIn3D(-173, 41)
		.applyMaterialFromLastUsedList("4351",205,62)
		.verifyLastUsedMaterial("4351")
		.verify3Dwallpaint(205,62, "PAINT|4351")
		.clickBlankAfterPaint()
		.addCoveringUsingFullScreen("Wallpaper|GENERIC_MATERIAL_00815", "selection", 205, 62)
		.applyMaterialIn3D(205, 62)
		.verify3Dwallpaint(-173, 41, "PAINT|4363")
		.verify3Dwallpaint(174, 3, "Wallpaper|GENERIC_MATERIAL_00815")
		.twoDView()
		.addCovering("HARDWOOD|4270","")
		.verify3Dwallpaint(-46, 83, "HARDWOOD|4270")
		.verifyLastUsedMaterial("4351")
		.clickBlankAfterPaint()
		.twoDView()
		.splitWall(-248,111)
		.moveWall(-252,122,-10,122)
		.verifyWallProperty(-10,122, "2075 mm")
		.threeDView()
		.rotateProjectView(30, "Right")
		.addCoveringByClosingCatalog("Wallpaper|GENERIC_MATERIAL_00815", "selection")
		.applyMaterialIn3D(4, -57)
		.addCovering("Tiling|GENERIQUE_009", "selection")
		.applyMaterialIn3D(-144, 89)
		.addCovering("CONCRETE|9489", "selection")	
		.applyMaterialIn3D(220, 48)
		.verifyLastUsedMaterial("9489");
	}
}

