package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class ProductTestIn2DView extends Browser {
	@Test
	public void twoDProductTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.twoDView()
		.addProduct("HUS60", true, false, false)
		.checkBusinessRuleShowIn2D("Area of worktop around the cooking unit")
		.position(192, -197, "50 mm", "850 mm", "")
		.verifyPosition(200,-93, "850 mm")
		.addProduct("UD4SA80", true, true, false)
		.checkBusinessRuleShowInWorktop("Minimum distance between a sink or hob and end of worktop", true)
		.editWorktopDimension(142, -96, "1493 mm", "1580 mm", "apply below")
		.verifyBusinessRuleInWorktopEditorRemoved("Minimum distance between a sink or hob and end of worktop")
		.validateWorktopEditor()
		.verifyPrice("")
		.twoDView()
		.checkBusinessRuleShowIn2D("Area of worktop around the cooking unit")
		.deleteProperty(200,-93, "Worktop")
		.verifyDeleteProperty(200,-93, "Worktop")
		.addProperty(192,-197, "Worktop", "LAMINATE DOUBLE", "", true)
		.verifyAddProperty(192,-197, "Worktop", "LAMINATE DOUBLE")
		.addProduct("UD4SA80", true, true, false)
		.verifyBusinessRuleRemoved("Area of worktop around the cooking unit");
		

	}
	
}
