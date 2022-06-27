package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class MinDistanceOvenAndCornerCabinetRule extends Browser {
	@Test
	public void minDistanceOvenAndCornerCabinetRule() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB").startFromScratch()
		.step3().verifyPrice("0,00")
		.addProduct("UEDBD10060L", true, false, false)
		.rotateProduct(-112, -6, 25, 25)
		.translateProduct(-112, -6, -110, 0)
		.addProduct("HUS60", true, false, false)
		.position(-11,-28, "2074 mm", "2712 mm", "")
		.checkBusinessRuleShowIn3D("Minimum distance between oven and corner cabinet", true)
		.deleteProduct(-57, -36)
		.addProduct("U2DA30", true, false, false)
		.position(-27,-28, "612 mm", "0 mm", "")
		.addProduct("HUS60", true, false, false)
		.verifyBusinessRuleRemoved("Minimum distance between oven and corner cabinet");
		
	}

}
