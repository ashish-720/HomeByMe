package kitchen.bryo.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class UndoAndRedoOperationOnLinears extends Browser {
    //Test Scenarios for KIT-2268 : As a user, I can undo/redo when I make operations on linears
    @Test
    public void undoRedoOperationsOnLinears() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
                .startFromScratch()
                .step3()
                .addProduct("U2DA80", true, false, false)

                //Undo-redo operation on deletion/ addition of a linear

                .deleteProperty(-115, -11, "Worktop")
                .verifyDeleteProperty(-115, -11, "Worktop")
                .undo(4)
                .verifyAddProperty(-115, -11, "Worktop", "WOOD OAK")

                .addProperty(-115, -11, "Wall Panel", "GB_WP_LAMINATE", "all", true)
                .verifyAddProperty(-115, -11, "Wall Panel", "GB_WP_LAMINATE")
                .undo(4)
                .verifyDeleteProperty(-115, -11, "Wall Panel")

                .addProperty(-115, -11, "Wall Edge Strip", "GEN_WES_WOOD", "", true)
                .verifyAddProperty(-115, -11, "Wall Edge Strip", "GEN_WES_WOOD")
                .undo(4)
                .verifyDeleteProperty(-115, -11, "Wall Edge Strip")

                // Undo after replace
                .replaceProperty(-115, -11, "Worktop", "ACRYLIC WHITE", "", true,"")
                .verifyReplaceProperty(-115, -11, "Worktop", "ACRYLIC WHITE")
                .verifyPrice("1 206,80")
                .undo(3)
                .verifyReplaceProperty(-115, -11, "Worktop", "WOOD OAK")
                .verifyPrice("803,00")

                .addProperty(-115, -11, "Wall Panel", "GB_WP_LAMINATE", "all", true)
                .replaceProperty(-115, -11, "Wall Panel", "DK_WP_GLASS", "selected", true,"")
                .verifyReplaceProperty(-115, -11, "Wall Panel", "DK_WP_GLASS")
                .verifyPrice("1 312,30")
                .undo(3)
                .verifyReplaceProperty(-115, -11, "Wall Panel", "GB_WP_LAMINATE")
                .verifyPrice("1 003,00")

                .addProperty(-115, -11, "Wall Edge Strip", "GEN_WES_WOOD", "", true)
                .replaceProperty(-115, -11, "Wall Edge Strip", "GEN_WES_ACRYLIC", "",true, "")
                .verifyReplaceProperty(-115, -11, "Wall Edge Strip", "GEN_WES_ACRYLIC")
                .undo(3)
                .verifyReplaceProperty(-115, -11, "Wall Edge Strip", "GEN_WES_WOOD")

                //Undo operation on changing properties of linear
                .replaceProperty(-115, -11, "Worktop", "ACRYLIC WHITE", "",true, "")
                .verifyReplaceProperty(-115, -11, "Worktop", "ACRYLIC WHITE")
                .editWorktopWaterFallOptions(-115, -11, "", "yes","")
                .editWorktopOverHangOptions(-115, -11, "", "100 mm")
                .verifyWorktopOptionsOverhangProperty(-115, -11, "", "100 mm", "", "yes")
                .undo(4)
                .verifyWorktopOptionsOverhangProperty(-115, -11, "", "0 mm", "", "yes")
                .undo(6)
                .verifyWorktopOptionsProperty(-115, -11, "", "0 mm", "", "")

                .replaceProperty(-115, -11, "Wall Panel", "DK_WP_GLASS", "all",true, "")
                .editWallPanelOptionsProperty(-115, -11, "400 mm", "", "true", "")
                .verifyWallPanelOptionsProperty(-115, -11, "400 mm", "", "true", "true", "true", "false")
                .undo(3)
                .verifyWallPanelOptionsProperty(-115, -11, "400 mm", "", "true", "false", "true", "false")
                .undo(3)
                .verifyWallPanelOptionsProperty(-115, -11, "570 mm", "", "true", "false", "true", "false")

                //Undo operation on customized worktop
                .worktopEditor(-115, -11)
                .editWorktopYes()
                .createCutOut(-181, -182, "Rectangle", "200 mm", "200 mm", "no", "", "")
                .validateWorktopEditor()
                .verifyProduct(2, -20, "ACRYLIC WHITE")
                .undo(6)
                .verifyProduct(2, -20, "U2DA80")

                //Undo after customizing and replacing a linear
                .worktopEditor(2, 20)
                .editWorktopYes()
                .createCutOut(-181, -182, "Rectangle", "200 mm", "200 mm", "no", "", "")
                .validateWorktopEditor()
                .verifyProduct(2, 20, "ACRYLIC WHITE")
                .replaceCustomMaterial(2, -20, "ACRYLIC WHITE", "LAMINATE BLACK", "")
                .confirmCustomMaterialChange("Yes")
                .verifyReplaceProperty(2, 20, "Worktop", "LAMINATE BLACK")
                .undo(2)
                .verifyProduct(2, 20, "ACRYLIC WHITE")
                .worktopEditor(2, 20)
                .verifyWorktopCutOut(-175, -175, "200 mm", "200 mm", "", "", "358 mm", "341 mm")
                .validateWorktopEditor("true")

                .wallPanelEditor(2, 20)
                .editWallPanelYes()
                .createCutOutForWallPanel(-220, 30, "Rectangle", "200 mm", "200 mm", "yes", "20 mm", "")
                .validateWallPanelEditor()
                .verifyProduct(30, -43, "DK_WP_GLASS")
                .replaceProperty(2, 20, "Wall Panel Option", "GEN_WP_OAK", "",true, "Yes")
                .verifyReplaceProperty(2, 20, "Wall Panel Option", "GEN_WP_OAK")
                .undo(3)
                .verifyProduct(30, -43, "DK_WP_GLASS")
                .wallPanelEditor(2, 20)
                .verifyCutOutForWallPanel(-215, 28, "200 mm", "200 mm", "20 mm", "", "340 mm", "185 mm")
                .validateWallPanelEditor()

                //Undo after split/merge of worktop
                .twoDView().emptyRoom(-20, -20, "KITCHEN", "16.0 m²", "Yes").threeDView()
                .addProduct("U2DA80", true, false, false)
                .addProduct("U2DA80", true, false, false)
                .worktopEditor(-40, -10)
                .editWorktopYes()
//                .moveWorktop(-127, -175, -36, -175)
//                .validateWorktopEditor("true")
//                .worktopEditor(2, 20, "")
                .splitWorktop(-100, -162)
                .verifySplitInWorktop(-137, -181)
                .validateWorktopEditor()
                .replaceCustomMaterial(30, -5, "ACRYLIC WHITE", "LAMINATE BLACK", "selected")
                .confirmCustomMaterialChange("Yes")
                .verifyProduct(-37, -23, "ACRYLIC WHITE")
                .verifyProduct(30, -5, "LAMINATE BLACK")
                .undo(4)
                .verifyProduct(30, -5, "ACRYLIC WHITE")
                .undo(3)
                .worktopEditor(2, 20)
                .editWorktopYes()
                .verifyWorktopSplitNotPresent(-131, -184)
                .splitWorktop(-125, -151)
                .validateWorktopEditor()
                .worktopEditor(2, 20)
                .mergeWorktops(-137, -180)
                .validateWorktopEditor()
                .undo(1)
                .worktopEditor(2, 20)
                .verifySplitInWorktop(-134, -180)
                .validateWorktopEditor()

                //Undo modifications on free standing worktop
                .addProductThroughSearch("Worktop", "ACRYLIC WHITE", true, false)
                .editFreeStandingWorktopProperties(-20, 50, false, "800 mm", "800 mm", "800 mm")
                .verifyFreeStandingWorktopProperties(-5, 60, "800 mm", "800 mm", "800 mm")
                .undo(6)
                .verifyFreeStandingWorktopProperties(-20, 50, "800 mm", "800 mm", "800 mm")
                .modifyFreestandingWorktop(-20, 50, "")
                .createCutOut(0, 0, "Rectangle", "200 mm", "200 mm", "no", "", "")
                .moveWorktop(55, 20, 100, 20)
                .validateWorktopEditor()
                .undo(1)
                .modifyFreestandingWorktop(-20, 50, "")
                .verifyWorktopCutOutAbsent(0, 0)
                .verifyWorktopDimension(26, 34, "1000 mm")
                .validateWorktopEditor();


    }
}
