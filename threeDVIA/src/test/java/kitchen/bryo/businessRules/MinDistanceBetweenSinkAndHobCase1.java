package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistanceBetweenSinkAndHobCase1 extends Browser {
	@Test
	public void minDistanceBetweenSinkAndHobCase1(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("SPUD40", true, false, false)
		
		.position(-112, -6,"50 mm", "100 mm", "")
		.editFaucetOptionsProperty(-112, -6, "", "20 mm", "", "Back")
		.addProduct("CKT600", true, false, false)
		.replaceProperty(-80, -13, "Cooktop", "JEAN BAPTISTE", "",true, "")
		
		.checkBusinessRuleShowIn3D("Minimum distance between sinks and hobs", true)
		.position(-80, -13, "525 mm", "850 mm", "")
		.addProduct("U2DA30", true, true, false)
		.addProduct("U2DA80", true, false, false)
		.verifyBusinessRuleRemoved("Minimum distance between sinks and hobs");
		
	}

}
