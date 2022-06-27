package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class OpeningCollisionRule extends Browser {
	@Test
	public void openingCollisionRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.addProduct("DOUBLE WINDOW",false,false)
		.moveWall(254, 27, 4,-240)	
		.step3()
		.verifyPrice("0,00")
		.addProduct("GMO03", true, false, false)
		.position(-110, -46, "50 mm", "850 mm", "")
		.checkBusinessRuleShowIn3D("Item position", true)
		.position(-56, -46,"850 mm", "50 mm", "")
		.verifyPosition(-110, -46, "50 mm")	
		.verifyBusinessRuleRemoved("Item position");
	

	}

}
