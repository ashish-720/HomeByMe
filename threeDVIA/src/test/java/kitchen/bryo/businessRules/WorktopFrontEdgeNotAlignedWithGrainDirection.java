package kitchen.bryo.businessRules;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

//Test scenarios for FUN120658 : As a user, I am notified if the worktop front edge is not aligned with the grain direction
public class WorktopFrontEdgeNotAlignedWithGrainDirection extends Browser {
    @Test
    public void worktopFrontEdgeNotAlignedWithGrainDirection() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB").startFromScratch()
                .step3().verifyPrice("0,00")
                .addProduct("U2DA80", true, true, false)
//				Scenario 1 : BR triggered when change in grain direction results in WT front perpendicular to grain direction
                .replaceProperty(-116, -5, "Worktop", "ACRYLIC WHITE", "",true, "")
                .verifyBusinessRuleRemoved("")
                .worktopEditor(-116, -5)
                .editWorktopYes()
                .verifyBusinessRuleInWorktopEditorRemoved("")
                .changeGrainDirection(-164, -182)
                .checkWorktopEditorBusinessRules("Front edge position")
                .validateWorktopEditor()
                .checkBusinessRuleShowInWorktop("Front edge position", false)
//                .checkBusinessRuleShowInWorktop("Grain Direction and Front Edge Compatibility", false)

//				Scenario 2 : BR removed when change in grain direction  in WT is parallel to front
                .changeGrainDirection(-164, -182)
                .verifyBusinessRuleInWorktopEditorRemoved("Front edge position")
                .validateWorktopEditor()
                .verifyBusinessRuleRemoved("Front edge position")

//				Scenario 3 : BR triggered when change in worktop front results in WT front perpendicular to grain direction
                .worktopEditor(0, 10)
                .verifyBusinessRuleInWorktopEditorRemoved("Front edge position")
                .changeEdgeProduct(-130, -180, "DKACRYLIC_ALU", "yes")
                .checkWorktopEditorBusinessRules("Front edge position")
                .validateWorktopEditor()
                .checkBusinessRuleShowInWorktop("Front edge position", false)
                .changeEdgeProduct(-130, -180, "DKACRYLIC_ALU", "no")
                .verifyBusinessRuleInWorktopEditorRemoved("Front edge position")
                .validateWorktopEditor()
                .verifyBusinessRuleRemoved("Front edge position")

//				Scenario 4 : BR triggered when there are multiple edges and one of them is not parallel to grain direction
                .worktopEditor(0, 10)
                .verifyBusinessRuleInWorktopEditorRemoved("Front edge position")
                .addSplitEdge(-175, -160)
                .changeEdgeProduct(-150, -160, "DKACRYLIC_ALU", "no")
                .verifyBusinessRuleInWorktopEditorRemoved("Front edge position")
                .changeGrainDirection(-164, -182)
                .checkWorktopEditorBusinessRules("Front edge position")
                .changeEdgeProduct(-210, -160, "DKACRYLIC_ALU", "no")
                .verifyBusinessRuleInWorktopEditorRemoved("Front edge position")
                .validateWorktopEditor()

//				Scenario 5 : BR triggered for precut WT
                .replaceProperty(0, 10, "Worktop", "WOOD OAK", "", true,"Yes")
                .verifyBusinessRuleRemoved("Front edge position")
                .worktopEditor(0, 10)
                .editWorktopYes()
                .verifyBusinessRuleInWorktopEditorRemoved("Front edge position")
                .changeGrainDirection(-164, -182)
                .checkWorktopEditorBusinessRules("Front edge position")
                .validateWorktopEditor()
                .checkBusinessRuleShowInWorktop("Front edge position", false)
                .changeGrainDirection(-164, -182)
                .verifyBusinessRuleInWorktopEditorRemoved("Front edge position")
                .validateWorktopEditor()
                .verifyBusinessRuleRemoved("Front edge position");
    }

}
