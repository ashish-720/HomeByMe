package kitchen.templateEditor.scenarioTest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.templateEditor.pageObject.AddProducts;
import kitchen.templateEditor.pageObject.Design;
import kitchen.templateEditor.pageObject.Floorplan;
import kitchen.templateEditor.pageObject.StartNow;

@Test
public class AddProductsToCatalogData extends Browser {
		
		public void teAddProductToCatalogData() throws IOException {
			StartNow start=PageFactory.initElements(driver, StartNow.class);
			start.startNow();
			Floorplan f1=PageFactory.initElements(driver, Floorplan.class);
			f1.verifyFloorplan().goToDesignPage();
			AddProducts addProducts=PageFactory.initElements(driver, AddProducts.class);
//			addProducts.addToCatalog("templateEditorFloorplan");
			Design d1=PageFactory.initElements(driver, Design.class);
			d1.verifyDesign();
			addProducts.addToCatalog("templateEditorCatalog");
		} 
		
		
}
