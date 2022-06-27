package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class HobHoodRuleCase1 extends Browser {
	@Test
	public void hobHoodRuleCase1(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.addProduct("U2DA80", true, false, false)
		.addProduct("CKT600", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.addProduct("KET600CHXE", true, false, false)
		.replaceProperty(-112, -6, "Worktop", "ACRYLIC WHITE", "",true, "")
		.position(-124, -83, "3350 mm", "2500 mm", "")
		.checkBusinessRuleShowIn3D("Distance between hood and hob", true)
		.position(-51, -81, "558 mm", "650 mm", "")
		.verifyBusinessRuleRemoved("Distance between hood and hob");

	}

}
