package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class EnergyEfficiency extends Browser {
	@Test
	public void energyEfficiencyTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.addProduct("CKT600", true, false, false)
		.customiseProduct(-130,-40, "")
		.replaceAppliancesInCompose(-11, -134, "COOKTOP", "ANTOINE",false)
		.verifyReplaceAppliancesInCompose(-11, -134, "ANTOINE");
		
	}
	
}
