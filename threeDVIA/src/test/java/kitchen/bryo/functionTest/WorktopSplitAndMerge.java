package kitchen.bryo.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * KIT-1587 :  Verify split and merge of worktop
 */

public class WorktopSplitAndMerge extends Browser {
    @Test
    public void WorktopSplitAndMergeTest() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
		.startFromScratch()
                .step3()
                .addProduct("U2DA602", true, true, false)
                .addProduct("U2DA80", true, true, false)
                .addProduct("UD2SA120", true, true, false)
                .replaceProperty(-20, -0, "Worktop", "ACRYLIC WHITE", "", true,"")

                //Scenario : split worktop and verify
                .worktopEditor(-20, -0)
                .editWorktopYes()
                .splitWorktop(0, -149)
                .verifySplitInWorktop(-77, -190)

//                Scenario : verify undo/redo works after split on worktop editor
                .undoInWorktopEditor(driver,3)
                .verifyWorktopSplitNotPresent(-77, -190)
                .verifyMemberPriceInWorktop("834,65")
                .redoInWorktopEditor(driver,1)
                .verifySplitInWorktop(-77, -190)
                .verifyMemberPriceInWorktop("834,70")

                //Scenario : reshape worktops after split
                .moveSplit(-80,-190,-120,-190)
                .moveSplit(-80,-190,-120,-190)
                .verifySplitInWorktop(-120, -190)

                //Scenario : Add cut, cutout , joint, waterfall on split worktop
                .createCutOut(-190, -200, "Rectangle", "35 mm", "35 mm", "no", "", "")
                .verifyWorktopCutOut(-190, -200, "35 mm", "35 mm", "", "", "279 mm", "364 mm")
                .createCutOut(50, -200, "Circle", "", "", "", "", "50 mm")
                .verifyWorktopCutOut(50, -200, "", "", "", "50 mm", "254 mm", "296 mm")
                .addEdgeCut(20,-150, "Triple cut", "", "", "", "", "", "", "")
                .verifyEdgeCut(20, -150, "802 mm")
                .cornerCutForWallPanel(75, -150, "Double", "55 mm", "55 mm", "", "", "", "")
                .verifyCornerCutForWallPanel(40, -150, "702 mm")
                .addWaterfall(75, -185, "")
                .verifyMemberPriceInWorktop("1 692,10")
                .validateWorktopEditor()

                //verify split  worktop in 3D - verify replace one of the split worktop and delete one of the split worktop
                .twoDView().threeDView()
                .replaceCustomMaterial(-85,-15,"ACRYLIC WHITE","LAMINATE BLACK", "selected")
                .confirmCustomMaterialChange("Yes")
                .verifyProduct(-85,-15,"LAMINATE BLACK")
                .deleteProduct(-85,-15)
                .verifyProduct(-85,-15,"U2DA602")
                .verifyProduct(60,0,"ACRYLIC WHITE")

                //Scenario : Merge worktop and verify
                .modifyFreestandingWorktop(60,0, "")
                .moveSplit(-120,-190,-228,-190)
                .splitWorktop(-90, -150)
                .verifySplitInWorktop(-125, -190)
                .mergeWorktops(-125, -190)
                .verifyWorktopSplitNotPresent(-125, -190)
                .verifyMemberPriceInWorktop("1 529,15")
                .validateWorktopEditor();
    }
}
