package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class DragAndDropItems extends Browser {
	@Test
	public void dragAndDrop(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		//KIT-71 : As a user, I can drag and drop items from the side menu
	      
//adding openings using drag and drop
		.addProductUsingDragDrop("DOUBLE WINDOW",false,false,30,-235)
		.moveWall(30, -235, 30, -245)
		.editItemDimensionProperties(30,-245,"","1300 mm", "1000 mm", "","800 mm", -1)
 //adding room objects using drag and drop in 2D view
		.addProductUsingDragDrop("BOX OBJECT",false,false,-70,16)
		//add verification to verify edit panel
		.delete(-70, 16)
//adding room objects using drag and drop in 3D view
		.threeDView()
		.addProductUsingDragDrop("COLUMN",false,false,10,70)
		.delete(10, 0)
//adding cabinets using drag and drop in 2D view
		.step3()
		.twoDView()
		.addProductUsingDragDrop("U2DA80",false,false,0,0)
		.verifyProduct(0, 0, "U2DA80")
		.deleteProduct(0, 0)
//adding cabinets using drag and drop in 3D view
		.threeDView()
		.addProductUsingDragDrop("W6002",false,false,0,0)
		.verifyProduct(-5, -20, "W6002")
		.deleteProduct(0, 0)
//adding appliances using drag and drop in 3D view
		.addProductUsingDragDrop("CKT600",false,false,105,16)
		.verifyProduct(105, 16, "CKT600")
//adding dining using drag and drop in 3D view
		.addProductUsingDragDrop("BABY CHAIR",false,false,0,60)
		.verifyProduct(1, 24, "BABY CHAIR")
//adding kitchen extras using drag and drop in 3D view
		.addProductUsingDragDrop("WOODEN SHELF",false,false,-92,140)
		.verifyProduct(-92, 140, "WOODEN SHELF");
	}

}
