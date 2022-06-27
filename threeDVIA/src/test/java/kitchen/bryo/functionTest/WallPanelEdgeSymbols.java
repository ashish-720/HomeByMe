package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class WallPanelEdgeSymbols extends Browser {
	@Test
	public void wallPanelEdgeSymbolsTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.addProduct("U2DA80", true, false, false)
		.addProductThroughSearch("U2DA100", "U2DA100", true, false)
		.twoDView().threeDView()
		.translateProduct(16, 30, -152, 28)
		.addProperty(-12,9, "Wall Panel", "GB_WP_LAMINATE", "all", true)
		.verifyAddProperty(-12,9,"Wall Panel", "GB_WP_LAMINATE")
		.replaceProperty(-12,9, "Wall Panel", "DK_WP_GLASS", "all",true, "")
		.wallPanelEditor(-12,9)
		.editWallPanelYes()
		.verifyEdgeSymbol(4, 0)
		.changeEdgeProduct(-217,-8, "DK_WP_GLASSEDGE_NONPOLISHED")
	
	//KIT-1822 : As a user, I can deselect an edge
		
		.changeEdgeProduct(-156,35, "Choose a reference / no edge") //changing polished edge product to no edge KIT-1822
		.verifyEdgeSymbol(2, 1)
		.changeEdgeProduct(-283, 30, "Choose a reference / no edge")
		.verifyEdgeSymbol(1, 2)
		.checkBusinessRuleInWallPanel("Missing edge finishes")
		.addEdgeProduct(-283, 30, "DK_WP_GLASSEDGE_POLISHED")
		.verifyEdgeSymbol(2, 1)
		.verifyBusinessRuleInWallPanelRemoved("Missing edge finishes")
		.validateWallPanelEditor()
		.modifyCustomizedWallPanel(97,-42)
		.validateWallPanelEditor()
//		FUN121949 :	As a user, I can delete a wall panel within the wall panel editor :IR-940266
		.addProperty(-32, 40, "Wall Panel", "NO_WP_LAMINATE", "", true)
		.wallPanelEditor(-32, 40)
		.switchWallPanelLayer(-224,-9, "880 mm")
		.deleteWallpanel(-226, 41)
		.verifyPriceInWallPanel("58,30")
		.switchWallPanelLayer(10, -7, "1060 mm")
		.validateWallPanelEditor()
		.verifyPrice("1 609,30")
		.verifyDeleteProperty(78, 20, "Wall Panel")
		.verifyAddProperty(-32,40,"Wall Panel", "NO_WP_LAMINATE");
//		FUN121949 : END
		}
}