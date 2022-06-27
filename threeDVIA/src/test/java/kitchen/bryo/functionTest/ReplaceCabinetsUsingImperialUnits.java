package kitchen.bryo.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ReplaceCabinetsUsingImperialUnits extends Browser {
    //Test Scenarios for KIT-1733 : As a user, I can replace cabinets using imperial units
    @Test
    public void replaceCabinetsUsingImperialUnitsTest() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        driver.get("https://staging-bryo.enterprise.by.me/en-US/");
        start.setBryoAccessCode()
        .startDemo("en-GB");
        driver.get("https://staging-bryo.enterprise.by.me/en-US/");

        start.startFromScratch()
                .step3()

                //Scenario 1: If there are no options to replace item by multiple items do not show the option to enter the layer
                .addProduct("U2DA40US", true, false, false)
                .verifyMultiReplacePossible(-110, -10, false)
                .addProduct("U80US", true, false, false)
                .verifyMultiReplacePossible(-65, -10, true)

                //Scenario 2 : Verify Generic Overlay
                .replaceWithMultipleProducts(-65, -10)
                .verifyHeader("Replace U80US", "Choose a combination that fits your space.", false, true)
                .verifyMultiReplacePopup()

                //Scenario 4: Able to replace cabinets with two smaller cabinets
                .verifyActivePanel("Combination")
                .verifyAvailableCombinations("16\" + 16\"")
                .selectCombination("16\" + 16\"")

                .verifyTabsEnabled(true, true, true, false)
                .verifyActivePanel("1st cabinet")
                .selectCabinet("U2DA40US")

                .verifyTabsEnabled(true, true, true, false)
                .verifyActivePanel("2nd cabinet")
                .selectCabinet("U2DA402US")

                .verifyHeader("Replace U2DA80", "Choose a combination that fits your space.", false, false)
                .validateCombination()
                .verifyProduct(-10, 25, "U2DA40US")
                .verifyProduct(15, 30, "U2DA402US")

                //Scenario 3: Cancelling after selecting the combinations doesnt replace the cabinet
                .addProduct("UD2SA60US", true, true, false)
                .replaceWithMultipleProducts(40, 30)
                .selectCombination("12\" + 12\"")
                .verifyTabsEnabled(true, true, true, false)
                .waitForActivePanel("1st cabinet")
                .selectCabinet("U2DA30US")
                .waitForActivePanel("2nd cabinet")
                .selectCabinet("U2DA302US")
                .cancelCombination()
                .verifyProduct(40, 30, "UD2SA60US")


                //Scenario 5 : Able to move, position, duplicate, edit and delete any cabinet insterted through the  Multi-replace feature
                .translateProduct(10, 25, 0, 50)
                .verifyProduct(20, 80, "U2DA402US")
                .position(-10, 15, "131 1/2\"", "80\"", "")
                .verifyPosition(-60, 50, "80\"")
                .duplicateProduct(20, 80)
                .verifyProduct(40, 75, "U2DA402US")
                .selectMultipleProducts("20,80 > 40,75 > -60,50").deleteProduct();
    }
}
