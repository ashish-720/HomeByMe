package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class FillerGap extends Browser {
	@Test
	public void fillerGapTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		//FUN118337 : As a developer, I simplify the automatic cover-panels algorithm and make sure it handles every cases
		.threeDView()
		//add a round column in a corner (width = depth = 150mm)
		.addProductUsingDragDrop("COLUMN|9622", false, false, -120, 0)
		.position(-120, 0, "3790 mm", "3850 mm")
		.verifyPosition(-120, 0, "3850 mm")
		.position(-120, 0, "3759 mm", "3850 mm")
		.verifyPosition(-130, -28, "3850 mm")
		.step3()
		//add a wall cabinet next to the column so that it builds an automatic filler with the wall
		.addProductThroughSearch("W6002", "W6002", true, false)
		// check that the wall cabinet has *no* cover panel on the side where there is the column, and that there is no gap between the wall cabinet and the column. 
		.verifyPosition(-130, -110, "150 mm")
		.straightFillerPropertyOFF(-130, -110, "Straight filler","Left Cover Panel", "283,00")
		.replaceProperty(-130, -110, "Left Cover Panel", "CONCORDE", "",true, "")
		.verifyPosition(-130, -110, "137 mm")
		.straightFillerPropertyON(-130, -110, "Straight filler","Left Cover Panel", "283,00")
		//FUN118337 : END
		.addProduct("U2DA80",true,false,false)
		.addProduct("UD2SA80",true,true,false)	
		.translateProduct(-37,-8, 10,-8)
		.verifyPrice("1 791,00")
		.straightFillerPropertyOFF(-17,-8, "Straight filler","Left Cover Panel", "1 791,00")
		.replaceProperty(-17,-8, "Left Cover Panel", "CONCORDE", "selection", true,"")
		.straightFillerPropertyON(-17,-8, "Straight filler","Left Cover Panel", "1 791,00");
//		
//		//FUN122521 :As a user, I want an automatic filler to be applied between a cabinet and a free shape
//		.twoDView()
//		.emptyRoom(0, 0, "Kitchen", "16.0", "yes")
//		.clickFloorplan()
//		.threeDView()
//		.delete(-130, -28)
//		.twoDView()
//		.addProduct("Cube", false, false)
////		.editItemDimensionProperties(-82, -11, "", "", "2500 mm", "750 mm", "", 0)
//		.translateProduct(-82, -11, -243, -243)
//		.step3()
//		.rotateProjectView(25, "right")
//		.addProduct("GMO03",true,false,false)
//		.position(-101, -34, "500 mm", "550 mm", "")
//		.straightFillerPropertyOFF(-101, -34, "Straight filler","Left Cover Panel", "")
//		.straightFillerPropertyON(-101, -34, "Straight filler","left", "")
//		.deleteProduct(-101, -34)
//		.addProduct("W6002", true, false, false)
//		.position(-102, -66, "500 mm", "550 mm", "")
//		.straightFillerPropertyOFF(-102, -66, "Straight filler","Left Cover Panel", "")
//		.straightFillerPropertyON(-102, -66, "Straight filler","left", "")
//		.deleteProduct(-101, -34)
//		.addProduct("U2DA1002", true, false, false)
//		.position(-81, 8, "500 mm", "550 mm", "")
//		.straightFillerPropertyOFF(-81, 8, "Straight filler","Left Cover Panel", "")
//		.straightFillerPropertyON(-81, 8, "Straight filler","left", "");
//		.editItemDimensionProperties(-82, -11, "", "250 mm", "2500 mm", "250 mm", "", 0)
//		.translateProduct(-78, -13, -247, -150)
//		.step3()
//		.addProduct("GMO03",true,false,false)
//		.straightFillerPropertyOFF(-102, -66, "Straight filler","Left Cover Panel", "")
//		.straightFillerPropertyON(-102, -66, "Straight filler","left", "");
	}

}
