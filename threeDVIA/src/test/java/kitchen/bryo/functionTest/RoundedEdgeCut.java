package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class RoundedEdgeCut extends Browser {
	@Test
	public void roundedEdgeCutTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.addProduct("U2DA80", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.replaceProperty(-115, -11,  "Worktop","ACRYLIC WHITE", "",true, "")
		.verifyReplaceProperty(-115, -11, "Worktop","ACRYLIC WHITE")
		.worktopEditor(-115, -11)
		.editWorktopYes()
		.verifyPriceInWorktop("1 188,70")
		.addEdgeCut(-78, -154, "Rounded", "", "", "", "", "", "", "2000 mm")
		.changeEdgeProduct(-95, -115, "", "");
	}
}
