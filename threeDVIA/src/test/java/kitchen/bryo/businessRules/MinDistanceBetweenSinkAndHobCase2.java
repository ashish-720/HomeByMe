package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistanceBetweenSinkAndHobCase2 extends Browser {
	@Test
	public void minDistanceBetweenSinkAndHobCase2(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("SPUD100", true, false, false)
		.position(-112, -6,"50 mm", "100 mm", "")
		.editSinkOptionsProperty(-112, -6, "", "20 mm", "", "", "Front", "", "")
		.checkBusinessRuleShowIn3D("Minimum distance between sinks and hobs", true)
		.editSinkOptionsProperty(-112, -6, "", "0 mm", "", "", "Front", "", "")
		.editFaucetOptionsProperty(-112, -6, "", "20 mm", "", "Bottom")
		.verifyBusinessRuleRemoved("Minimum distance between sinks and hobs");
		
	}

}
