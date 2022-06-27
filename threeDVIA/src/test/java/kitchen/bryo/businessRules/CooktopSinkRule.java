package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class CooktopSinkRule extends Browser {
	@Test
	public void cooktopSinkRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProduct("CKT600", true, false, false)
		.addProduct("SPUD80", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.editFaucetOptionsProperty(7, -8, "", "20 mm", "", "Back")
		.replaceProperty(-80, -13, "Worktop", "ACRYLIC WHITE", "", true,"")
		.checkBusinessRuleShowIn3D("Distance between sink and hob", true)
		.deleteProduct(7, -8)
		.deleteProduct(87, -9)
		
		.addProduct("U2DA30", true, true, false)
		.addProduct("SPUD80", true, false, false)
		.editFaucetOptionsProperty(34, -16, "", "20 mm", "", "Back")
		.addProduct("U2DA80", true, false, false)
		.verifyBusinessRuleRemoved("Distance between sink and hob");
		
	}

}
