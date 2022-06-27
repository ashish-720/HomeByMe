package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.MakeItYours;
import kitchen.bryo.pageObject.StartNow;

public class WaterfallTypeWorktopJoint extends Browser {
	@Test
	public void waterfallTypeWorktopJointTest() {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
				.startFromScratch()
				.step3()
				//FUN120529 :As a user, I can design with an angled or straight waterfall worktop joint
				.addProduct("U2DA80", true, false, false)
				.replaceProperty(-115, -11, "Worktop", "ACRYLIC WHITE ANGLED", "",true, "")
				.verifyReplaceProperty(-115, -11, "Worktop", "ACRYLIC WHITE ANGLED")
				.editWorktopWaterFallOptions(-115, -11, "", "yes","Angled")
				.worktopEditor(-115, -11)
				.editWorktopYes()
				.editWaterfall(-120, -171)
				.verifyWorktopDimension(-122, -4, "918 mm")
				.changeWaterFallType(0, -179, "Straight")
				.verifyWorktopDimension(-122, -4, "880 mm")
				.validateWorktopEditor()
				.twoDView().threeDView()
				.worktopEditor(0, 0)
				.editWaterfall(-120, -171)
				.verifyWorktopDimension(-122, -4, "880 mm")
				.addEdgeCut(0, -151, "Triple", "100 mm", "100 mm", "318 mm", "yes", "120 mm", "120 mm", "")
				.verifyEdgeCut(-85, -151, "147 mm")
				.changeWaterFallType(-85, -151, "Angled")
				.verifyEdgeCut(0, -151, "635 mm")
				.verifyWorktopDimension(-122, -4, "918 mm")
				.validateWorktopEditor()
//				FUN120529 : As a user, I can design with an angled or straight waterfall worktop joint : IR-942324
				.deleteProperty(0, 0, "Worktop")
				.addProperty(0, 0, "Worktop", "ODT_LAMINATE CONCRETE", "", true)
				.editWorktopWaterFallOptions(-6, 9, "", "yes","Angled")
				.verifyWorktopOptionsOverhangProperty(-6, 9, "0 mm", "28 mm", "false", "true")
				.editWorktopWaterFallOptions(-6, 9, "", "yes","Straight")
				.verifyWorktopOptionsOverhangProperty(-6, 9, "0 mm", "108 mm", "false", "true")
				.editWorktopWaterFallOptions(-6, 9, "", "yes","Angled")
				.verifyWorktopOptionsOverhangProperty(-6, 9, "0 mm", "28 mm", "false", "true")
				.editWorktopWaterFallOptions(-6, 9, "", "yes","Straight")
				.verifyWorktopOptionsOverhangProperty(-6, 9, "0 mm", "108 mm", "false", "true")
				.worktopEditor(-15, -12)
				.editWorktopYes()
				.editWaterfall(-120, -171)
				.verifyWorktopDimension(6, -151, "575 mm")
				.verifyWorktopDimension(-92, -4, "880 mm")
				.changeWaterFallType(6, -151, "Angled")
				.verifyWorktopDimension(6, -151, "635 mm")
				.verifyWorktopDimension(-121, -4, "908 mm")
				.changeWaterFallType(12, -166, "Straight")
				.verifyWorktopDimension(6, -151, "575 mm")
				.verifyWorktopDimension(-92, -4, "880 mm");
//				FUN120529 : END
	}
}
