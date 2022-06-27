package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class WallCabinetTest extends Browser {
	@Test
	public void wallCabinetTest() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.addProduct("W6002", true, false,false)
		.duplicateProductUsingShortCutKey(-120,-80)
		.addProperty(-123, -118, "Cornice", "MADELEINE", "", true)
		.verifyAddProperty(-123, -118, "Cornice", "MADELEINE")
		.addProperty(-123, -118, "Deco Strip", "MADELEINE", "", true)
		.verifyAddProperty(-123, -118, "Deco Strip", "MADELEINE")
		.deleteProduct(-123, -118)
		.undo(1)
		.verifyAddProperty(-123, -118, "Cornice", "MADELEINE")
		.verifyAddProperty(-123, -118, "Deco Strip", "MADELEINE")
		.addProperty(-123, -118, "Top Cover Panel", "OPERA|15530", "all", true)
		.verifyAddProperty(-123, -118, "Top Cover Panel", "OPERA|15530")
		.replaceProperty(-123, -118, "Top Cover Panel", "MADELEINE|13893", "all",true, "")
		.verifyReplaceProperty(-123, -118, "Top Cover Panel", "MADELEINE|13893");
	}

}
