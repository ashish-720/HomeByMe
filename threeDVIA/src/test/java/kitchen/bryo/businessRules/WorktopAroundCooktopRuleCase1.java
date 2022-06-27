package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class WorktopAroundCooktopRuleCase1 extends Browser {
	@Test
	public void worktopAroundCooktopRuleCase1() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3().verifyPrice("0,00")
		.addProduct("CKT600", true, false, false)
		.replaceProperty(-116, -5, "Worktop", "ACRYLIC WHITE", "",true, "")
		.checkBusinessRuleShowIn3D("Area of worktop around the cooking unit", true)
		.position(-116, -5, "50 mm", "850 mm", "")
		.addProduct("U2DA80", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.verifyBusinessRuleRemoved("Area of worktop around the cooking unit");
		
		
	}

}
