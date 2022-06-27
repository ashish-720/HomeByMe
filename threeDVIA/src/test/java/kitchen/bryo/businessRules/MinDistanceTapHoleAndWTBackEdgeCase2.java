package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistanceTapHoleAndWTBackEdgeCase2 extends Browser {
	@Test
	public void minDistanceTapHoleAndWTBackEdgeCase2(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("U2DA80", true, false, false)
		.addProduct("SPUD100", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.editFaucetOptionsProperty(-57, -46, "", "50 mm", "", "Bottom")
		.checkBusinessRuleShowInWorktop("Minimum distance between tap hole and worktop back edge", true)
		.validateWorktopEditor()
		.editFaucetOptionsProperty(-13, 22, "", "20 mm", "", "Bottom")
		.verifyBusinessRuleRemoved("Minimum distance between tap hole and worktop back edge");
		
	}

}
