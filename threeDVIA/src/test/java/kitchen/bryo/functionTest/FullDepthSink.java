package kitchen.bryo.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.HomePage;
import kitchen.bryo.pageObject.StartNow;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FullDepthSink extends Browser {
    @Test
    public void fullDepthSinkTest() {
    	StartNow start=PageFactory.initElements(driver, StartNow.class);
    	start.startDemo("en-GB");
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.startKitchenDesign()
                /**
                 * Full depth sink insertion, settings and pricing
                 * -	Open the kitchen planner and go to “design your kitchen” step.
                 * -	Add a sink cabinet and select a full depth sink.
                 * -	Add a cabinet on the left and another on the right. Both must be in contact and aligned with the first cabinet.
                 * -	Check that the worktop is divided in 2 parts that end exactly at the edges on the left and on the right of the full depth sink.  --- chk dims in WE
                 * -	Check that there is no overhang on those 2 worktops that are in collision with the full depth sink. - verify overhang values
                 * -	Select the cabinet on the left of the full depth sink. Open the “edit” menu and go to worktop options. Check that it is not possible to change the value of the overhang on the right.
                 * -	Select the cabinet on the right of the full depth sink. Open the “edit” menu and go to worktop options. Check that it is not possible to change the value of the overhang on the left.
                 * -	Check the help center. There should not be any warning message about the overlap of the sink on the front of the cabinet, and no warning about the sink is next to the wall.
                 * -	Open the “edit” menu and check that you can’t change the mounting
                 * -	Open the “edit” menu and check that you can’t change the offsets to move the sink
                 * -	Open the “edit” menu and check that you can’t change the offsets to move the tap (it is included in the sink)
                 * -	Check the pricing list. No cutout should be priced.
                 */
                .selectStyleMapping("", "28mm Timber Worktop", "")
                .layoutMapping("").cookingMapping("").refrigerationMapping("").startPlanning()
                .step3()
                .verifyPrice("0,00")
                .addProduct("U2DA602", true, true, false)
                .addProduct("SPUDSA60_FullDepthSink", true, true, false)
                .addProduct("U2DA80", true, true, false)
                .worktopEditor(-20, -10)
                .editWorktopYes()
                .verifyWorktopDimension(-40, -158, "830 mm").verifyWorktopDimension(-195, -158, "650 mm")
                .verifyWorktopEdgePresent(-87, -190).verifyWorktopEdgePresent(-158, -190)
                .cancelWorktopEditor()
                .twoDView().threeDView()
                .verifyPosition(-60, 10, "50 mm")
                .verifyPosition(-20, 20, "625 mm")
                .verifyPosition(25, 30, "1225 mm")

                .verifyWorktopOptionsOverhangProperty(-60, 10, "", "0 mm", "", "false")
                .verifyWorktopOptionsOverhangProperty(25, 20, "0 mm", "", "false", "")
                .checkBusinessRulesCount(0, 0, 0)
                .verifySinkOffsets(-20,20, "0", "false", "0", "false", "", "")
                .verifySinkMounting(-20,20, "Topmounted", "false")
                .verifySinkDrainerGrooves(-20,20, "false", "false", "", "")
                .verifyFaucetOptionsProperty(-20,20, "0 mm", "false", "0 mm", "false", "", "")
                .clickProductList().verifyIfItemPriced("startsWith", "Worktops and wall panels", "WT_CUTOUT_", false)

                /**
                 * Worktop thickness
                 * -	Before doing this test, you must know what worktop thickness is compatible with the full depth sink you will use.
                 * -	Open the kitchen planner and go to “design your kitchen” step.
                 * -	Add a sink cabinet.
                 * -	Add a cabinet on the left and another on the right. Both must be in contact and aligned with the first cabinet.
                 *
                 *              ---replace the FD sink with a normal sink in our current setup and we will get the same setup as mentioned in the above steps
                 *
                 * -	Go to the “edit” menu and replace the worktop by a product with a thickness that is not compatible with the full depth sink you will use. --ACRYLIC WHITE
                 * -	Go to the “edit” menu of the cabinet placed in the middle and select a full depth sink.
                 * -	Check the help center. There must be a warning about the incompatibility of worktop thickness and full depth sink.
                 * -	Select the cabinet on the left of the full depth sink. Go to the “edit” menu and replace the worktop by a product with a thickness that is compatible with the full depth sink you have inserted.
                 * -	Check the help center. There must be a warning about the incompatibility of worktop thickness and full depth sink.
                 * -	Select the cabinet on the right of the full depth sink. Go to the “edit” menu and replace the worktop by a product with a thickness that is compatible with the full depth sink you have inserted.
                 * -	Check the help center. There must be no warning about the incompatibility of worktop thickness and full depth sink.
                 *
                 */
                .replaceProperty(-20,20, "Sink", "KALADIN", "",true, "")
                .verifyReplaceProperty(-20,20, "Sink", "KALADIN")
                .replaceProperty(-60,10, "Worktop", "ACRYLIC WHITE", "",true, "")
                .verifyReplaceProperty(-20,20, "Worktop", "ACRYLIC WHITE")
                .checkBusinessRulesCount(0, 0, 0)

                .replaceProperty(-20,20, "Sink", "AMMERAN 60cm", "",true, "")
                .verifyReplaceProperty(-20,20, "Sink", "AMMERAN 60cm")
                .checkBusinessRulesCount(0, 1, 0)
                .checkBusinessRuleShowIn3D("Worktop incompatible", true)
                .replaceProperty(25,30, "Worktop", "WOOD OAK", "selection",true, "")
                .verifyReplaceProperty(25,30, "Worktop", "WOOD OAK")
                .checkBusinessRulesCount(0, 1, 0)
                .checkBusinessRuleShowIn3D("Worktop incompatible", true)

                .replaceProperty(-60,10, "Worktop", "WOOD OAK", "selection",true, "")
                .verifyReplaceProperty(-60,10, "Worktop", "WOOD OAK")
                .checkBusinessRulesCount(0, 0, 0)

                /**
                 * Sink replacement on automatically generated worktops
                 * -	Open the kitchen planner and go to “design your kitchen” step.
                 * -	Add a sink cabinet and select a regular sink.
                 * -	Go to the “edit” menu, replace the sink by a full depth sink.
                 * -            -we already have a setup with a cabinet with FDS and two normal cabinets on either side of it
                 * -	Check that the worktop is divided in 2 parts that end exactly at the edges on the left and on the right of the full depth sink. - already covered in scenario 1
                 * -	Go to the “edit” menu, replace the full depth sink by another full depth sink.
                 * -	Check that the worktop is divided in 2 parts that end exactly at the edges on the left and on the right of the full depth sink.
                 * -	Go to the “edit” menu, replace the full depth sink by a regular sink.
                 * -	Check that the worktop is regenerated so that there is only one worktop with a proper cut for the regular sink.
                 */
                .positionMultipleProducts("moveCabinetsToTheRight_FullDepthSink", "1937 mm", "1887 mm")
                .clickBlank()
                .replaceProperty(-20,20, "Sink", "OLOFSJON 120cm", "",true, "")
                .verifyReplaceProperty(-20,20, "Sink", "OLOFSJON 120cm")
                .worktopEditor(25,30)
                .editWorktopYes()
                .verifyWorktopDimension(-215, -147, "100 mm").verifyWorktopDimension(-30, -147, "830 mm")
                .verifyWorktopEdgePresent(-215, -190).verifyWorktopEdgePresent(-83, -190)
                .cancelWorktopEditor()

                .twoDView().threeDView()
                .checkBusinessRulesCount(0, 0, 0)
                .replaceProperty(-20,20, "Sink", "KALADIN", "",true, "")
                .verifyReplaceProperty(-20,20, "Sink", "KALADIN")
                .worktopEditor(-20,20)
                .editWorktopYes()
                .verifyWorktopDimension(-35, -158, "2130 mm")
                .verifyWorktopEdgePresent(-232, -190).verifyWorktopEdgePresent(15, -190)
                .verifyWorktopCutOut(-120, -190, "355 mm", "426 mm", "15 mm", "", "823 mm", "952 mm")
                .cancelWorktopEditor()
                .twoDView().threeDView()
                /**
                 * Sink replacement on edited worktops
                 * -	Open the kitchen planner and go to “design your kitchen” step.
                 * -	Add a sink cabinet and select a regular sink.
                 *              --already have the setup
                 * -	Go to the “edit” menu, go to the worktop options and access to the worktop editor
                 * -	Change the grain of the worktop and validate to exit the worktop editor. The worktop is now an edited worktop.  > purpose is to change the WT to custom WT so adding a joint instead
                 * -	Select the sink cabinet and go to “edit” menu. Replace the regular sink by a full depth sink.
                 * -	There should be a collision between the full depth sink and the worktop. Check the help center and check that the corresponding warning is displayed.
                 * -	Go to the worktop editor. Edit the worktop so that there is no more collision with the sink.
                 * -	Select the sink cabinet and go to “edit” menu. Replace the full depth sink by a regular sink.
                 * -	There should a hole in the worktop around the sink. Check the help center and check that the corresponding warning is displayed
                 */
                .worktopEditor(-20,20)
                .editWorktopYes()
                .createCutOut(-30, -180, "Rectangle", "200 mm", "200 mm", "", "", "")
                .validateWorktopEditor()
                .twoDView().threeDView()
                .verifyProduct(20, -5, "WOOD OAK")
                .replaceProperty(-20,20, "Sink", "AMMERAN 60cm", "", true,"")
                .verifyReplaceProperty(-20,20, "Sink", "AMMERAN 60cm")
                .checkBusinessRulesCount(0, 1, 0)
                .checkBusinessRuleShowInWorktop("Full depth sink overlaps", false)
                .moveWorktop(-227, -190, -80, -190)
                .verifyBusinessRuleInWorktopEditorRemoved("Full depth sink overlaps")
                .validateWorktopEditor()

                .twoDView().threeDView()
                .replaceProperty(-20,20, "Sink", "KALADIN", "",true, "")
                .verifyReplaceProperty(-20,20, "Sink", "KALADIN")
                .verifyWorktopOptionsProperty(-20,20, "No worktop possible on this cabinet.")
                .checkBusinessRulesCount(0, 1, 0)
                .checkBusinessRuleShowInWorktop("Sink without a worktop", false)
                .cancelWorktopEditor()

                /**
                 * End of linear
                 * -	Open the kitchen planner and go to “design your kitchen” step.
                 * -	Add a sink cabinet and select a full depth sink with the same width than the cabinet.
                 * -	Place the cabinet at the end of a linear.
                 * -	Check that there is no overhang at the end of a linear (no automatically generated worktop).
                 */
                .twoDView().emptyRoom(200, 200, "KITCHEN", "16.0 m²", "Yes").threeDView()
                .verifyPrice("0,00")
                .addProduct("U2DA602", true, true, false)
                .addProduct("U2DA80", true, true, false)
                .addProduct("SPUDSA60_FullDepthSink", true, true, false)

                .twoDView().threeDView()
                .translateProduct(35,30, 100, 70).clickBlank()
                .replaceProperty(130, 110, "Sink", "AMMERAN 60cm", "",true, "")
                .verifyReplaceProperty(130,110, "Sink", "AMMERAN 60cm").clickBlank()
                .translateProduct(130,110, -90, -75).clickBlank()
                .verifyWorktopOptionsProperty(35,30, "No worktop possible on this cabinet.")
                .worktopEditor(-15, 20)
                .editWorktopYes()
                .verifyWorktopDimension(-128, -158, "1450 mm")
                .verifyWorktopEdgePresent(-63, -190)
                .cancelWorktopEditor()

                /**
                 * Islands
                 * -	Open the kitchen planner and go to “design your kitchen” step.
                 * -	Add a sink cabinet and select a full depth sink with the same width than the cabinet.
                 * -	Place the cabinet on an island. The depth of the island must be equal to the depth of the cabinet with a full depth sink.
                 * -	Check that the worktop is divided in 2 parts that end exactly at the edges on the left and on the right of the full depth sink.
                 * -	Place the cabinet on an island of 2x3 cabinets, in the middle.
                 * -	Check that the worktop is divided in several parts to cover all cabinets and to border the full depth sink properly.
                 */
                .twoDView().twoDView().emptyRoom(0, 0, "KITCHEN", "16.0 m²", "Yes").threeDView()
                .verifyPrice("0,00")
                .addProduct("U2DA602", true, true, false)
                .addProduct("SPUDSA60_FullDepthSink", true, true, false)
                .addProduct("U2DA80", true, true, false)
                .twoDView().threeDView()
                .replaceProperty(-20, 20, "Sink", "KALADIN", "",true, "")
                .verifyReplaceProperty(-20, 20, "Sink", "KALADIN")
                .selectMultipleProducts("-60,10 > -20,20 > 25,30").translateProduct(0, 100)
                .worktopEditor(-80, 100)
                .editWorktopYes()
                .verifyWorktopSplitNotPresent(-33, 61).verifyWorktopSplitNotPresent(34, 61)
                .verifyWorktopDimension(0, 96, "2060 mm")
                .cancelWorktopEditor()

                .twoDView().threeDView()
                .replaceProperty(0,130, "Sink", "AMMERAN 60cm", "",true, "")
                .verifyReplaceProperty(0,130, "Sink", "AMMERAN 60cm")
                .verifyWorktopOptionsOverhangProperty(-50,130, "30 mm", "0 mm", "true", "false")
                .verifyWorktopOptionsOverhangProperty(60,130, "0 mm", "30 mm", "false", "true")
                .worktopEditor(-50,130)
                .editWorktopYes()
                .verifyWorktopEdgePresent(-34, 69).verifyWorktopEdgePresent(36, 69)
                .verifyWorktopDimension(-61, 102, "630 mm").verifyWorktopDimension(80, 102, "830 mm")
                .cancelWorktopEditor()

                .twoDView().threeDView()
                .replaceProperty(0,130, "Sink", "KALADIN", "",true, "")
                .verifyReplaceProperty(0,130, "Sink", "KALADIN")
                .selectMultipleProducts("-50,130 > 0,130 > 60,130").duplicateProduct()
                .selectMultipleProducts("-110,-5 > -65,-5 > -10,-5").rotateProduct(-50, 0)
                .selectMultipleProducts("-110,-5 > -65,-5 > -10,-5").translateProduct(90, 85)
                .worktopEditor(-40, 120)
                .editWorktopYes()
                .verifyWorktopSplitNotPresent(-33, 61).verifyWorktopSplitNotPresent(36, 61).verifyJoint(-30, 28, "635 mm")
                .verifyWorktopDimension(40, 100, "2060 mm").verifyWorktopDimension(133, 40, "1270 mm")
                .cancelWorktopEditor()

                .twoDView().threeDView()
                .replaceProperty(0,130, "Sink", "AMMERAN 60cm", "selected", true,"")
                .verifyReplaceProperty(0,130, "Sink", "AMMERAN 60cm")
                .verifyReplaceProperty(17, 40, "Sink", "KALADIN")
                .worktopEditor(60,130)
                .editWorktopYes()
                .verifyWorktopEdgePresent(-33, 60).verifyWorktopEdgePresent(36, 60).verifyWorktopEdgePresent(0, 26)
                .verifySplitInWorktop(-65, 26).verifySplitInWorktop(85, 26)
                .verifyWorktopDimension(-60, 100, "630 mm").verifyWorktopDimension(70, 100, "830 mm")
                .verifyWorktopDimension(36, 64, "635 mm").verifyWorktopDimension(-34, 64, "635 mm").verifyWorktopDimension(133, -5, "635 mm")
                .cancelWorktopEditor()

                /**
                 Full depth sink larger than a cabinet
                 -	Open the kitchen planner and go to “design your kitchen” step.
                 -	Add a sink cabinet and select a full depth sink that covers more than 1 cabinet (full depth sink with drainboard).
                 -	Add another cabinet under the drainboard
                 -	Check that the worktop is divided in 2 parts that end exactly at the edges on the left and on the right of the full depth sink.
                 -	Select this other cabinet and go to the “edit” menu. Check that you can’t edit the sink from the “edit” menu of this cabinet.
                 -	Check that there is no filler between the 2 cabinets. Check that the edge of the cabinet is aligned with the edge of the sink, then check that there is no message in the help center.
                 -	Move the cabinet placed under the drainboard of the full depth sink so that the edge of the cabinet is not aligned with the edge of the sink. Check that there is a message to warn the user in the help center.
                 */
                .twoDView().twoDView().emptyRoom(0, -120, "KITCHEN", "16.0 m²", "Yes").threeDView()
                .verifyPrice("0,00")
                .addProduct("U2DA80", true, true, false)
                .addProduct("SPUDSA80_FullDepthSink", false, true, false)
                .addProduct("U2DA602", true, true, false)
                .addProduct("U2DA602", true, true, false)
                .twoDView().threeDView()
                .verifyPosition(-30,30, "825 mm")
                .verifyPosition(-30,30, "1750 mm")
                .verifyPosition(15,35, "1625 mm")
                .verifyPosition(15,35, "1750 mm")
                .worktopEditor(-90, 30)
                .editWorktopYes()
                .verifyWorktopDimension(-160, -147, "850 mm").verifyWorktopDimension(60, -147, "630 mm")
                .verifyWorktopEdgePresent(-124, -190).verifyWorktopEdgePresent(28, -190)
                .cancelWorktopEditor()
                .twoDView().threeDView()
                .selectProduct(15,35).editProperty().verifyEditablePropertyPresent("SINK", "false")
                .selectProduct(15,35).editProperty().verifyEditablePropertyPresent("Straight Filler", "false")
                .selectProduct(-30,30).editProperty().verifyEditablePropertyPresent("Straight Filler", "false")
                .checkBusinessRulesCount(0, 0, 0)

                .selectMultipleProducts("65,40 > 15,35").translateProduct(10, 0)
                .checkBusinessRulesCount(0, 1, 0)
                .checkBusinessRuleShowIn3D("Full depth sink position", true)

                .selectMultipleProducts("30,30 > 75,30").deleteProduct()
                .addProduct("U2DA80", true, true, false)
                .checkBusinessRulesCount(0, 1, 0)
                .checkBusinessRuleShowIn3D("Full depth sink position", true)

                .deleteProduct(15,35)
                .addProduct("UD2SA45", true, true, false)
                .checkBusinessRulesCount(0, 1, 0)
                .checkBusinessRuleShowIn3D("Full depth sink position", true)

                .addProduct("UD2SA45", true, true, false)
                .checkBusinessRulesCount(0, 1, 0)
                .checkBusinessRuleShowIn3D("Full depth sink position", true)

                .selectMultipleProducts("15,35 > 50,35").deleteProduct()
                .addProduct("U2DA602", true, true, false)
                .translateProduct(20, 40, 0, 5)
                .checkBusinessRulesCount(0, 1, 0)
                .checkBusinessRuleShowInWorktop("Full depth sink overlaps", true)
                .cancelWorktopEditor();
    }
}
