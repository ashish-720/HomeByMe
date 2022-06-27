package enterprise.bathroom.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class OpeningsUsingWall extends Browser {
	@Test
	public void openingUsingWallTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.launchApp()
		.editWallProperties(7, -242, "60 mm", "1500 mm")
				.verifyWallProperties(7, -242, "60 mm", "1500 mm", 0)
				
		       //adding double window in 2d view and then editing it in 3D view
				.editWallProperties(7, -242, "150 mm", "2500 mm")
		        .addOpeningThroughWalls(7,-247,"DOUBLE WINDOW",false)
				.threeDView()
				.editItemDimensionProperties(12, -96, "", "1200 mm", "1000 mm", "", "400 mm", 0)
				//select a opening  -> edit -> change some parameters ->verify
				.verifyItemDimensionProperties(16, -58, "", "1200 mm", "1000 mm", "", "400 mm")
				//Delete window/ door in 3d view
				.delete(16, -58)
			    .twoDView()
				.zoomIn(1)
				.zoomOut(1)
			    .twoDView()
			    .addSlopedCeilingFromWall(234, 13, "1200 mm", "1300 mm", "120 �")
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
