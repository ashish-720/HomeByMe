package kitchen.templateEditor.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.templateEditor.pageObject.Floorplan;
import kitchen.templateEditor.pageObject.StartNow;

@Test
public class CatalogFilter extends Browser {
	
	public void teCatalogFilter() {
		StartNow start=PageFactory.initElements(driver, StartNow.class);
		start.startNow();
		Floorplan f1=PageFactory.initElements(driver, Floorplan.class);
		f1.verifyFloorplan().goToDesignPage()
		.verifyDesign()
		.checkCatalogFilter("cabinets>Wall cabinets", "Depth", 370)
		.checkCatalogFilter("cabinets>Base cabinets", "Width", 600)
		.checkCatalogFilter("appliances>Sinks", "Width", 400);
		
	}  
}
