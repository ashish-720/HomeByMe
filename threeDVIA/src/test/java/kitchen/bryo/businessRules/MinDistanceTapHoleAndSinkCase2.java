package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistanceTapHoleAndSinkCase2 extends Browser {
	@Test
	public void minDistanceTapHoleAndSinkCase2(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProduct("SPUD80", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.checkBusinessRuleShowIn3D("Distance between tap hole and sink", true)
		.editFaucetOptionsProperty(-57, -46, "", "20 mm", "", "Back")
		.verifyBusinessRuleRemoved("Distance between tap hole and sink");
		
	}

}
