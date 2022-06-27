package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class WallEdgeStrip extends Browser {
	@Test	
	public void wallEdgeStripTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
//		.addCabinet("U2DA80", "Base Cabinets")
		.addProduct("U2DA80", true, false, false)
		.addProperty(-115,-11, "Wall Edge Strip", "GEN_WES_WOOD", "", true)
		.verifyAddProperty(-115,-11, "Wall Edge Strip","GEN_WES_WOOD")
		.replaceProperty(-115,-11, "Wall Edge Strip", "GEN_WES_ACRYLIC", "", true,"")
		.verifyReplaceProperty(-115,-11, "Wall Edge Strip","GEN_WES_ACRYLIC")
		.wallEdgeStripEditor(-115,-11)
		.addWallEdgeStrip(-186,-159)
		.changeEdge(-186,-159,"ACRYLIC EDGE NOT POLISHED", "ACRYLIC EDGE NOT POLISHED", "ACRYLIC EDGE NOT POLISHED")
		.undoInWallEdgeStrip(driver, 5)
		.verifyRemoveWallEdgeStrip(-186,-159)
		.redoInWallEdgeStrip(driver, 5)
		.verifyAddedWallEdgeStrip(-186,-159)
		.removeWallEdgeStrip(-186,-159)
		
	//Kit-1822
		.addWallEdgeStrip(-132,-190)
		.changeEdge(-132,-190,"Choose a reference / no edge", "Choose a reference / no edge", "Choose a reference / no edge")
		.verifyAddedWallEdgeStrip(-132,-190)

	//Test scenario for FUN120666 : As a user, I can zoom further in linear editors : wall edge strip
		.clickAndDrag(180, 190)
		.zoomIn(22)
		.addWallEdgeStrip(-460,0)

	//Kit-1822
		.validateWallEdgeStripEditor()
	    .zoomIn(9)
		.verifyCustomMaterial(107, -88, "GEN_WES_ACRYLIC")
		.replaceCustomMaterial(107, -88, "GEN_WES_ACRYLIC", "GEN_WES_WOOD", "all")
		.verifyReplaceProperty(3,51, "Wall Edge Strip", "GEN_WES_WOOD")
		.deleteProduct(107, -88)
		.verifyDeleteProperty(12,45, "Wall Edge Strip");
	}
}
