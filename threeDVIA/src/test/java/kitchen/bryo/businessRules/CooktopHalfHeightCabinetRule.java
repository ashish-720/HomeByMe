package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class CooktopHalfHeightCabinetRule extends Browser {
	@Test
	public void cooktopHalfHeightCabinetRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("test_HalfHeightCabinet", true, false, false)
		.addProduct("CKT600", true, false, false)
		.checkBusinessRuleShowIn3D("Distance between hob and half high cabinet", true)
		.position(-63, -4, "638 mm", "820 mm", "")
		.replaceProperty(-63, -4, "Worktop","ACRYLIC WHITE", "",true, "")
		.addProduct("U2DA80", true, false, false)
		.verifyBusinessRuleRemoved("Distance between hob and half high cabinet");
		
	}

}
