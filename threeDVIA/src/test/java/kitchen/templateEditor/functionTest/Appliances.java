package kitchen.templateEditor.functionTest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.templateEditor.pageObject.Floorplan;
import kitchen.templateEditor.pageObject.StartNow;
@Test
public class Appliances extends Browser {
	public void teAppliances() throws IOException {
		
		StartNow start=PageFactory.initElements(driver, StartNow.class);
		start.startNow();
		Floorplan f1=PageFactory.initElements(driver, Floorplan.class);
		f1.verifyFloorplan().goToDesignPage()
		.verifyDesign()
		.addProduct("CKT600", true)
		.replacementProperty(-112,2, "cooktop","ANTOINE", 3)
		.duplicateFurniture("CKT600", -112, 2, -66,13)
		.deleteProduct("CKT600", -66, 13)
		.addProduct("SPUDSA60", true)
		.replacementProperty(-64,12,"sink", "KALADIN", 3)
		.duplicateFurniture("SPUDSA60", -64,12, -66,13)
		.deleteProduct("SPUDSA60", -17,1);
		
	}
}
