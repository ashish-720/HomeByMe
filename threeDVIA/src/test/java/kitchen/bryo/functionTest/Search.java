package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class Search extends Browser {
	@Test
	public void searchTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		//FUN119287 : As a user, I can replace a corner cabinet by another corner only of the same side (left/right)
		.addProductThroughSearch("UEDBD10060L", "UEDBD10060L", true,false)
		.replaceProductFromEdit(-115, -11, "UEDBD10060L2", true, false, false)
		
		.addProductThroughSearch("Table", "DINING TABLE", true,false)
		.verifySearchProduct(-60,60,"DINING TABLE")
		.addProductThroughSearchUsingShortCutKeys("Shelves", "IRON SHELVES",false)
		.verifySearchProduct(-8, 128,"IRON SHELVES")
		.addProductThroughSearch("Cooktop", "CKT800", true,false)
		.verifyProduct(-102, -1, "CKT800")
		.addProductThroughSearch("Wall Panel", "GEN_WP_OAK", true,false)
//		.verifyPriceInformation()
		
		//KIT-1944: As a range maintainer, I can choose the "depth" parameter as a directionParameter in the linearPercentageByItem pricing method.
		.twoDView().threeDView()
		.addProductThroughSearch("side panel", "Side Panel (depthPercentage)", true,false)
		.clickAndDrag()
		.verifySearchProduct(33,130,"SIDE PANEL (DEPTHPERCENTAGE)")
		.selectProduct(33,130).editProperty().editFurniture("800 mm", "", "")
		.verifyPrice("1 892,00")
		.clickProductList()
		.verifyProductInfoInItemList("Accessories and extras", "Reference:TestLinearPercentageDepth > Name:Side Panel (depthPercentage)\nH=800 W=19 D=590 > Price:€ 1,00 > Quantity:2 > Total:€ 2,00","")
		
		//FUN120357 :As a user, I want to see more relevant results when I search products
		.searchAndAddCabinet("base cabinet", "U2DA4037", true,false,"370","400")
		.searchAndAddWorktop("Worktop", "ACRYLIC WHITE", true,false,"custom","acrylic","38")
		.addProductThroughSearch("u2da", "U2DA452", true, false)
		.addProductThroughSearch("black chair", "Brenda chair", true, true)
		.searchAndAddCabinet("corner", "UEDBD10060R2_KP8500", true,false,"680","")
		.addProductThroughSearch("80x80", "W8002", true, false)
		.addProductThroughSearch("stainless", "BENJ", true, false)
		.addProductThroughSearch("freezer", "GVARIO03", true, false)
		.searchAndAddCabinet("cooktop drawer", "KDSA60", true,false,"","600");
		
		
	}
}
