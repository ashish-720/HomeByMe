package kitchen.bryo.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * This ODT covers test scenarions for KIT-2028 : As a user, I can easily remove an arc from a worktop
 */
public class WorktopRemoveArc extends Browser {
    @Test
    public void worktopRemoveArcTest() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
		.startFromScratch()
        .step3()
                .addProduct("U2DA80", true, false, false)
                .replaceProperty(-110, -15, "Worktop", "LAMINATE BLACK", "",true, "")

                //scenario 1 : remove arc from edge cut and verify
                .worktopEditor(-110, -15)
                .editWorktopYes()
                .verifyPriceInWorktop("488,11")
                .addEdgeCut(-126, -181, "Rounded", "", "", "", "", "", "", "500 mm")
                .verifyRoundedEdgePresent(-113, -185)
                .verifyPriceInWorktop("599,52")
                .moveWorktop(-113, -185, -127, -185)
                .verifyStraightEdgePresent(-127, -185)
                .verifyPriceInWorktop("488,11")

                //scenario 2 : undo arc removal to recreate the arc
                .undoInWorktopEditor(driver, 2)
                .verifyRoundedEdgePresent(-113, -185)
                .verifyPriceInWorktop("599,52")
                .moveWorktop(-113, -185, -127, -185)
                .verifyStraightEdgePresent(-127, -185)
                .verifyPriceInWorktop("488,11")

                //scenario 3 : remove arc from corner cut and verify
                .cornerCutForWallPanel(-123, -148, "Outer Rounded", "", "", "", "", "", "200 mm")
                .zoomIn(5)
                .verifyRoundedEdgePresent(-223, -264)
                .verifyPriceInWorktop("688,11")
                .moveWorktop(-223, -264, -228, -275)
                .verifyStraightEdgePresent(-228, -275)
                .verifyPriceInWorktop("688,11")
                .undoInWorktopEditor(driver, 2)
                .verifyRoundedEdgePresent(-223, -264)
                .verifyPriceInWorktop("688,11")

                //scenario 4 : verify arc removal reflected properly in BOM
                .cancelWorktopEditor()
                .clickProductList().verifyProductInfoInItemList("Worktops and wall panels", "Reference:NOLAMINATE > Total:€ 488,11", "")
                .worktopEditor(0, 0)
                .editWorktopYes()
                .addEdgeCut(-126, -181, "Rounded", "", "", "", "", "", "", "500 mm")
                .verifyRoundedEdgePresent(-113, -185)
                .validateWorktopEditor()
                .clickProductList().verifyProductInfoInItemList("Worktops and wall panels", "Reference:NOLAMINATE > Total:€ 599,52", "")
                .clickProductList().verifyProductInfoInItemList("Worktops and wall panels", "Reference:WT_CUT_ARC > Price:€ 100,00 > Total:€ 100,00", "")
                .worktopEditor(0, 0)
                .moveWorktop(-113, -185, -127, -185)
                .verifyStraightEdgePresent(-127, -185)
                .verifyPriceInWorktop("488,11")
                .validateWorktopEditor()
                .clickProductList().verifyProductInfoInItemList("Worktops and wall panels", "Reference:NOLAMINATE > Total:€ 488,11", "")

                //Test Scenarios for KIT-1990 : As a user, I can snap correctly the arc cut in worktop editor (Partially automated )
                .twoDView().emptyRoom(-20, -20, "KITCHEN", "16.0 m²", "Yes").threeDView()
                .addProduct("U2DA80", true, true, false)
                .replaceProperty(-110, -15, "Worktop", "ACRYLIC WHITE", "",true, "")
                .worktopEditor(-110, -15)
                .editWorktopYes()

                //Scenario 1 : Verify we can get proper snap when arc(on corner/edge cut in WT Editor)  becomes a straight line
                //Yellow line when snap occurs needs to be visually verified (cannot be automated )
                .addEdgeCut(-131, -185, "Rounded", "", "", "", "", "", "", "500 mm")
                .verifyRoundedEdgePresent(-120, -185)
                .moveWorktop(-120, -185, -131, -185)
                .verifyStraightEdgePresent(-120, -185)

                .createCornerCutOut(-131, -160, "", "Outer", "", "", "", "", "", "", "", "", "150 mm")
                .zoomIn(5)
                .verifyRoundedEdgePresent(-232, -282)
                .moveWorktop(-232, -282, -239, -284)
                .verifyStraightEdgePresent(-239, -284)

                //Scenario 2 : Verify we can get proper snap when arc becomes tangential/perpendicular to an edge : Cannot be automated

                //Scenario 3 : Verify we can get proper snap for arc (for corner/edge cut while editing waterfall ) becomes a straight line
                .zoomOut(5)
                .addWaterfall(-139, -207,"")
                .editWaterfall(-139, -207)
                .addEdgeCut(-94, -10, "Rounded", "", "", "", "", "", "", "900 mm")
                .verifyRoundedEdgePresent(-138, 2)
                .moveWorktop(-138, 2, -94, 2)
                .verifyStraightEdgePresent(-94, 2)

                .createCornerCutOut(-93, 177, "", "Outer", "", "", "", "", "", "", "", "", "150 mm")
                .verifyRoundedEdgePresent(-77, 158)
                .moveWorktop(-77, 158, -64, 147)
                .verifyStraightEdgePresent(-64, 147);
    }
}
