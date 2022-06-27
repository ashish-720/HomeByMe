package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class CutOutCutToEOWRuleCase3 extends Browser {
	@Test
	public void cutOutCutToEOWRuleCase3(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("SPUD80", true, false, false)
		.position(-112, -6, "50 mm", "100 mm", "")
		.editFaucetOptionsProperty(-112, -6, "", "20 mm", "", "Back")
		.addProduct("U2DA80", true, false, false)
		.editSinkOptionsProperty(-112, -6, "160 mm", "", "", "Right", "", "", "")
		.checkBusinessRuleShowInWorktop("Minimum distance between a sink or hob and end of worktop", true)
		.validateWorktopEditor()
		.editSinkOptionsProperty(-43, -8, "0 mm", "", "", "Right", "", "", "")
		.verifyBusinessRuleRemoved("Minimum distance between a sink or hob and end of worktop");
			
		
		
	}

}
