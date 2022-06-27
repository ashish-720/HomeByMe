package enterprise.bathroom.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class DragAndDropItems extends Browser {
	@Test
	public void dragAndDropTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.launchApp()
		//KIT-71 : As a user, I can drag and drop items from the side menu


//adding openings using drag and drop
				.addProductUsingDragDrop("DOUBLE WINDOW",false,false,-6,-30)
				.moveWall(-6, -30, 30, -245)
				.editItemDimensionProperties(30,-245,"","1300 mm", "1000 mm", "","800 mm", 1) // TBD: changeWallSide
				.threeDView()
				.twoDView()
				.delete(30,-245)
				.threeDView()
				.twoDView()

//adding room objects using drag and drop in 2D view
		.addProductUsingDragDrop("BOX OBJECT",false,false,-70,16)
		.delete(-70, 16)

//adding room objects using drag and drop in 3D view
				.threeDView()
				.addProductUsingDragDrop("COLUMN",false,false,10,70)
				.delete(10, 0)
		.undo(driver,1)
		.redo(driver,1)
				.undo(driver,1)
		.position(10,0,"1772 mm", "1000 mm");









	}

}
