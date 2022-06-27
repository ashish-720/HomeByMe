package kitchen.bryo.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * This ODT covers test scenarions for KIT-1057/KIT-2262 : As a user, I can create arc based on depth or radius
 */
public class WorktopCreateArcBasedOnDepth extends Browser {
    @Test
    public void worktopCreateArcBasedOnDepth() {
                StartNow start = PageFactory.initElements(driver, StartNow.class);
                start.startDemo("en-GB")
        		.startFromScratch()
                .step3()
                .addProduct("U2DA80", true, false, false)
                .replaceProperty(-110, -15, "Worktop", "LAMINATE BLACK", "",true, "")
                .worktopEditor(-110, -15).editWorktopYes()

                //Scenario 1: when Setting radius field , correct value is reflect in the depth field
                .startAddingEdgeCut(-123, -173, "Rounded")
                .setEdgeCutOptions("","","","","","","400 mm","")
                .verifyEdgeCutFieldsLinked()
                .verifyEdgeCutValues("","","","400 mm", "157 mm")
                .clickToCreateEdgeCut()
                .verifyRoundedEdgePresent(-105,-185)
                .verifyWorktopDimension(-105,-185,"157 mm")
                .moveWorktop(-105,-185,-122, -185)

                //Scenario 2: when Setting depth field , correct value is reflect in the radius field and edge cut can be created
                .startAddingEdgeCut(-151, -151, "Rounded")
                .setEdgeCutOptions("","","","","","","","200 mm")
                .verifyEdgeCutFieldsLinked()
                .verifyEdgeCutValues("","","","584 mm", "200 mm")
                .clickToCreateEdgeCut()
                .verifyRoundedEdgePresent(-170,-129)
                .verifyWorktopDimension(-170,-129,"200 mm")
                .moveWorktop(-170,-129,-170, -149)

                //Scenario 3: Proper error message when entering invalid value
                .startAddingEdgeCut(-151, -151, "Rounded")
                .setEdgeCutOptions("","","","","","","","xyz mm")
                .verifyEdgeCutErrorMsg("","","","", "Bad input")
                .verifyEdgeCutValues("","","","440 mm", "")
                .clickToCreateEdgeCut()
                .verifyStraightEdgePresent(-170, -149)
                .startAddingEdgeCut(-151, -151, "Rounded")
                .setEdgeCutOptions("","","","","","","","1 mm")
                .verifyEdgeCutErrorMsg("","","","", "The minimum value is 10 mm.")
                .setEdgeCutOptions("","","","","","","","200 mm")
                .verifyEdgeCutValues("","","","584 mm", "200 mm")
                .clickToCreateEdgeCut()
                .verifyWorktopDimension(-170,-129,"200 mm")
                .moveWorktop(-170,-129,-170, -149);

    }
}
