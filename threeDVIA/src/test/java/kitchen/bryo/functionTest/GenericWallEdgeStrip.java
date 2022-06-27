package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class GenericWallEdgeStrip extends Browser {
	@Test
	public void genericWallEdgeStripTest() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch().step3()
// Test scenarios for KIT-2500 sub-task KIT-2585

				 // scenario : Add two cabinets U2DA100 and make them NOT connected to each other
				.addProductThroughSearch("U2DA100", "U2DA100", true, false)		
				.addProductThroughSearch("U2DA100", "U2DA100", true, false)
				
				.position(-53, -37, "1937 mm", "950 mm", "")

				// scenario : Select the wall edge strip product “GEN_WES_WOOD_2” and apply on both cabinets
				.addProperty(-106, -28, "Wall Edge Strip", "GEN_WES_WOOD_2", "all", true)

				// scenario : Check the item list, it should contain the prouduct “WES_WOOD_2_2500” which is the mapping product for the generic wall edge strip.
				.clickProductList()
				.verifyProductInfoInItemList("Accessories and extras","Reference:WES_WOOD_2_2500 > Price:€ 120,00 > Quantity:1 ", "")
				.twoDView()
				.emptyRoom(10, 190, "Kitchen", "16.0 m²", "yes")
				.threeDView()
				// scenario : Add two cabinets U2DA30 and make them NOT connected to each other
				.addProductThroughSearch("U2DA30", "U2DA30", true, false)	
				.addProductThroughSearch("U2DA30", "U2DA30", true, false)	
				.position(-97, -3, "3337 mm", "3000 mm", "")
				.addProductThroughSearch("U2DA30", "U2DA30", true, false)
				.position(-50, -8, "2700 mm", "2000 mm", "")
				// scenario : Select the wall edge strip product “GEN_WES_WOOD_2” and apply on both cabinets
				.addProperty(-119, -6, "Wall Edge Strip", "GEN_WES_WOOD_2", "all", true)

				// scenario : Check the item list, it should contain the prouduct “WES_WOOD_2_600” which is the mapping product for the generic wall edge strip.
				.clickProductList()
				.verifyProductInfoInItemList("Accessories and extras","Reference:WES_WOOD_2_1000 > Price:€ 50,00 > Quantity:1 > Total:€ 50,00 ", "")
				.clickProductList()
				.verifyProductInfoInItemList("Accessories and extras","Reference:WES_WOOD_2_600 > Price:€ 30,00 > Quantity:1 > Total:€ 30,00", "")
				.twoDView()
				.emptyRoom(10, 190, "Kitchen", "16.0 m²", "yes")
				.threeDView()
				// scenario : Add two cabinets U2DA120 and make them NOT connected to each other
				.addProductThroughSearch("U2DA120", "U2DA120", true, false)		
				.addProductThroughSearch("U2DA120", "U2DA120", true, false)
		
				.position(2, -5, "1537 mm", "1200 mm", "")

				// scenario : Select the wall edge strip product “GEN_WES_WOOD_2” and apply on both cabinets
				.addProperty(-106, -28, "Wall Edge Strip", "GEN_WES_WOOD_2", "all", true)

				// scenario : Check the item list, it should contain the prouduct “WES_WOOD_2_2500” which is the mapping product for the generic wall edge strip.
				.clickProductList()
				.verifyProductInfoInItemList("Accessories and extras","Reference:WES_WOOD_2_4000 > Price:€ 180,00 > Quantity:1 > Total:€ 180,00", "");
		
	}
}
