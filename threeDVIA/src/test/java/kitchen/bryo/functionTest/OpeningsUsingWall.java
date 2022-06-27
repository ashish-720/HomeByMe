package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class OpeningsUsingWall extends Browser {
	@Test
	public void openingUsingWallTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.editWallProperties(7, -242, "60 mm", "1500 mm")
				.verifyWallProperties(7, -242, "60 mm", "1500 mm", 0)
				.addOpeningThroughWalls(-235, 25, "GLASS DOOR", false)
				
//KIT-1834 : Edit/remove openings in walls in 3D view
		       //adding double window in 2d view and then editing it in 3D view
				.editWallProperties(7, -242, "150 mm", "2500 mm")
		        .addOpeningThroughWalls(7,-247,"DOUBLE WINDOW",false)
				.threeDView()
				.editItemDimensionProperties(-20, -100, "", "1200 mm", "1000 mm", "", "400 mm", 0)
				//select a opening  -> edit -> change some parameters ->verify
				.verifyItemDimensionProperties(16, -58, "", "1200 mm", "1000 mm", "", "400 mm")
				//Delete window/ door in 3d view
				.delete(16, -58)
			    .twoDView()
			    //adding glass door in 2d view and then editing it in 3D view
			   .addOpeningThroughWalls(7,-247, "GLASS DOOR", false)
		     	.threeDView()
				.editItemDimensionProperties(12, -96, "", "900 mm", "2100 mm", "","",0)
				.verifyItemDimensionProperties(16, -58, "","900 mm", "2100 mm", "","")
		        //Delete window/ door in 3d view
			     .delete(16, -58) 
				.addCoveringByClickingWallFloor(16, -58, "PAINT|4339", "Selection", 16, -58)
				.zoomIn(1)
				.zoomOut(1)
			    .verify3Dwallpaint(16,-58,"PAINT|4339")
			    .twoDView()   
//KIt-1834 ends here
			    .addSlopedCeilingFromWall(234, 13, "1200 mm", "1300 mm", "120 °")
				.editSlopedCeilingFromWall(234, 13, 175, 65, "1200 mm", "1300 mm", "")
				.addOpeningThroughWalls(234, 13, "ROOF WINDOW", false)
				.editItemDimensionProperties(174, -4, "", "750 mm", "800 mm", "", "", 0)
				.verifyItemDimensionProperties(174, -4, "", "750 mm", "800 mm", "", "")
				.duplicate(174, -4)
				.verifyItemDimensionProperties(141, 105, "", "750 mm", "800 mm", "", "")
				.duplicate(141, 105)
				.duplicate(141, 105)
				.verifyNoSpaceAvailable();
	
	
	}

}
