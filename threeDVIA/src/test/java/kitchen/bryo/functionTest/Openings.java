package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class Openings extends Browser {
	@Test
	public void openingTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.ceiling("4000 mm")
		.verifyCeiling(7,-242,"4000 mm")
		.addProduct("DOUBLE WINDOW",false,false)
		.tooltipsForOpenings()
		.editItemDimensionProperties(259,-83,"","1300 mm", "1000 mm", "","800 mm", -1)
		.verifyItemDimensionProperties(244,56,"","1300 mm", "1000 mm", "", "800 mm")
		.editBayDimensions(244,56, 1350, 300)
		.verifyBayDimension(251,108, 300, 1)
		.addProduct("FIXED WINDOW",false,false)
		.editItemDimensionProperties(249,-60,"","850 mm", "800 mm", "","500 mm", -1)
		.verifyItemDimensionProperties(249,-80,"","850 mm", "800 mm", "", "500 mm")
		.replaceProductFromEdit(249, -80, "0")
		.addProduct("GLASS DOOR",false,false)
		.verifyItemDimensionProperties(-246,21,"","1900 mm", "2100 mm", "", "")
		.delete(-246, 21)
		.addProduct("INTERIOR DOOR",false,false)
		.replaceProductFromEdit(-246, 21, "OPENING")
		.verifyItemDimensionProperties(-246,21,"","950 mm", "2100 mm", "", "")
		.addWall("singleWall")
		.moveWall(-246, 21, 0, -160)
		.verifyItemDimensionProperties(0, -155, "","950 mm", "2100 mm", "", "")
		.deleteWall(-181, -155)
		.verifyDeletedWall(0, -155, "Room", "16.0 m²");
	
		
		
		
		
//		plan.threeDView();
	}

}
