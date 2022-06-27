package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class HingeTest extends Browser {
	@Test
	public void hingeTest() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch().step3()
// Test scenarios for KIT-1679 :As a range maintainer, I can manage the hinge on each cabinet

				 // scenario :1 
				.addProductThroughSearch("U80_HINGERULE", "U80_HINGERULE", true, false)
				.verifyProduct(-106,-5, "U80_HINGERULE")
				.clickProductList().verifyProductInfoInItemList("Cabinets","Picture:crosscut/U80_HINGERULE > Reference:U80_HINGERULE > Price:€ 585,00 > Quantity:1 > Total:€ 585,00", "")
				.clickProductList()
				.verifyProductInfoInItemList("Cabinets","Picture:thumbnail/Hinge 125 > Reference:H125 > Price:€ 6,00 > Quantity:2 > Total:€ 12,00", "")
				.replaceProperty(-106,-5, "Front", "CONCORDE|14119", "", true,"")
				.verifyReplaceProperty(-106,-5, "Front", "CONCORDE")
				.twoDView()
				.threeDView()
				.clickProductList()
				.verifyProductInfoInItemList("Cabinets","Reference:H110 > Price:€ 8,00 > Quantity:2 > Total:€ 16,00", "")
				.undo(6)
				.deleteProduct(4,16)
				// scenario : 2
				.addProductThroughSearch("U80_HINGERULE", "U80_HINGERULE", true, false)		
				.verifyProduct(4,16, "U80_HINGERULE")
				.clickProductList()
				.verifyProductInfoInItemList("Cabinets","Reference:H125 > Price:€ 6,00 > Quantity:2 > Total:€ 12,00", "")
				.customiseProduct(4,16, "")
				.addItemInCabinet("INTERNAL DRAWER 100", false)
				.validateComposeFurniture()
				.verifyProduct(-12,16,"Custom Product")
				.clickProductList()
				.verifyProductInfoInItemList("Cabinets","Picture:thumbnail/Hinge 153 > Reference:H153 > Price:€ 12,00 > Quantity:2 > Total:€ 24,00", "")
				.customiseProduct(-12,16, "")
				.deleteComposeProduct(30, 98)
				.addItemInCabinet("DOOR 400_HINGERULE", false)
				.addItemInCabinet("DOOR 400_HINGERULE", false)
				.validateComposeFurniture()
				.verifyProduct(-12,16,"Custom Product")
				.clickProductList()
				.verifyProductInfoInItemList("Cabinets","Reference:H153 > Price:€ 12,00 > Quantity:1 > Total:€ 12,00", "1")
				.clickProductList()
				.verifyProductInfoInItemList("Cabinets","Reference:H125 > Price:€ 6,00 > Quantity:1 > Total:€ 6,00", "1")
				.deleteProduct(-12,16)
				//scenario: 3
				.addProductThroughSearch("UEDK88_HINGERULE", "UEDK88_HINGERULE", true, false)
				.verifyProduct(-12,16, "UEDK88_HINGERULE")
				.clickProductList()
				.verifyProductInfoInItemList("Cabinets","Reference:H153 > Price:€ 12,00 > Quantity:1 > Total:€ 12,00", "1")
				.deleteProduct(-12, 16)
				//scenario: 4
				.addProductThroughSearch("WED6802_HINGERULE", "WED6802_HINGERULE", true, false)
				.verifyProduct(-5,-80, "WED6802_HINGERULE")
				.twoDView()
				.threeDView()
				.clickProductList()
				.verifyProductInfoInItemList("Cabinets","Reference:H45 > Price:€ 6,00 > Quantity:1 > Total:€ 6,00", "1")
				.deleteProduct(-5, -80)
				//scenario: 5
				.addProductThroughSearch("GVARIO03_HINGERULE", "GVARIO03_HINGERULE", true, false)
				.verifyProduct(-20,-25, "GVARIO03_HINGERULE")
				.clickProductList()
				.verifyProductInfoInItemList("Cabinets","Reference:H95 > Price:€ 6,00 > Quantity:3 > Total:€ 18,00", "")
				.replaceProperty(-20,-25, "Front", "CONCORDE|14119", "", true,"")
				.clickProductList()
				.verifyProductInfoInItemList("Cabinets","Reference:H95 > Price:€ 6,00 > Quantity:3 > Total:€ 18,00", "");
				
				
	}
}
