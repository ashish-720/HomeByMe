package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class ThicknessForHobOvenCabinetRule extends Browser {
	@Test
	public void thicknessForHobOvenCabinetRule(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("CKT600", true, false, false)
		.checkBusinessRuleShowIn3D("Worktop thickness", true)
		.replaceProperty(-112, -6, "Cooktop", "JEAN BAPTISTE", "",true, "")
		.verifyBusinessRuleRemoved("Worktop thickness")
		.undo(3)
		.checkBusinessRuleShowIn3D("Worktop thickness", true)
		.replaceProperty(-112, -6, "Worktop", "ACRYLIC WHITE", "",true, "")
		.verifyBusinessRuleRemoved("Worktop thickness");
		
	}

}
