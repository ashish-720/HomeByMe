package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class RoundedCornerEdgeCut extends Browser {
	@Test
	public void roundedCornerEdgeCutTest(){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.addProduct("U2DA80", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.replaceProperty(-115, -11,  "Worktop","ACRYLIC WHITE", "",true, "")
		.verifyReplaceProperty(-115, -11, "Worktop","ACRYLIC WHITE")
		.worktopEditor(-115, -11)
		.editWorktopYes()
		.cornerCutForWallPanel(-36, -148, "Inner", "", "", "", "", "", "180 mm")
		.zoomIn(5)
		.addEdgeProduct(-85, -280, "DKACRYLIC_BADEDGE", "no")
		.changeEdgeProduct(-85, -280, "", "")
		.cancelWorktopEditor()
		.worktopEditor(14, 30)
		.editWorktopYes()
		.cornerCutForWallPanel(-36, -148, "Outer", "", "", "", "", "", "180 mm")
		.zoomIn(5)
		.addEdgeProduct(-75, -280, "DKACRYLIC_BADEDGE", "no")
		.verifyEdgeSymbol(0, 0, 1)
		.changeEdgeProduct(-75, -280, "ACRYLIC EDGE POLISHED", "")
		.verifyEdgeSymbol(1, 0, 0);
	}
}
