package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class ovenRule extends Browser {
	@Test
	public void ovenRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("OVEN|16067", true, false, false)
		.checkBusinessRuleShowIn3D("Oven position", true)
		.position(-112, -6,"3400 mm", "3350 mm", "")
		.verifyPosition(-112, -6, "3350 mm")	
		.verifyBusinessRuleRemoved("Oven position");
	

	}

}
