package kitchen.bryo.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.HomePage;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class DrainerGroovesTest extends Browser {
    @Test
    public void drainerGroovesTest() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB");
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.startKitchenDesign()
                .selectStyleMapping("Stockholm - White", "28mm Timber Worktop", null)
                .layoutMapping("U-shaped")
                .cookingMapping("Integrated")
                .refrigerationMapping("Integrated")
                .startPlanning()
                .nextStep()
                .waterSupplyPositionPopUp("No", 0, 0)
                .findSolutions("72 - U Shaped kitchen")
                .nextStepDesignYourKitchen("No", "")

                /* TEST SCENARIOS FOR KIT-1589
                In order for the planner to generate drainer grooves it is given that all of these are true and combined on the cabinet that’s being edited:
                    1) worktopType = custom
                    2) worktopMaterial = Quartz or Acrylic or Ceramic.
                    3) sinkMounting = underglued or moulded.
                 */
                //Scenario 1 : verify Drainer groove generation not possible if any of the above criteria not satisfied
                .verifyReplaceProperty(-180, 90, "Worktop Option", "WOOD OAK")
                .verifySinkDrainerGrooves(-180, 90, "false", "false", "", "")
                .editSinkOptionsProperty(-180, 90, "", "", "Underglued", "", "", "", "")
                .verifySinkDrainerGrooves(-180, 90, "false", "false", "", "")

                .replaceProperty(-180, 90, "Worktop Option", "ACRYLIC WHITE", "",true, "")
                .editSinkOptionsProperty(-180, 90, "", "", "Topmounted", "", "", "", "")
                .verifySinkDrainerGrooves(-180, 90, "false", "false", "", "")


                //Scenario 2 : Verify drainer grooves can be added if all the conditions satisfied
                .editSinkOptionsProperty(-180, 90, "", "", "Underglued", "", "", "", "")
                .verifySinkDrainerGrooves(-180, 90, "false", "true", "", "")
                .editSinkOptionsProperty(-180, 90, "", "", "", "", "", "yes", "")
                .verifySinkDrainerGrooves(-180, 90, "true", "true", "Right", "true")

                //Scenario 3 : Verify Drainer grooves posiioncan be edited
                .editSinkOptionsProperty(-180, 90, "", "", "", "", "", "", "Left")
                .verifySinkDrainerGrooves(-180, 90, "true", "true", "Left", "true")
                .editSinkOptionsProperty(-180, 90, "", "", "", "", "", "", "Left & Right")
                .verifySinkDrainerGrooves(-180, 90, "true", "true", "Left & Right", "true")

                //Scenario 4 : If any of the conditions are no longer satiisfied, ability to generate drainer grooves is disabled
                .editSinkOptionsProperty(-180, 90, "", "", "Topmounted", "", "", "", "")
                .verifySinkDrainerGrooves(-180, 90, "false", "false", "", "")
                .editSinkOptionsProperty(-180, 90, "", "", "Underglued", "", "", "yes", "Left")
                .replaceProperty(-180, 90, "Worktop Option", "WOOD OAK", "",true, "")
                .verifyReplaceProperty(-180, 90, "Worktop Option", "WOOD OAK")
                .verifySinkDrainerGrooves(-180, 90, "false", "false", "", "");

    }

}
