package kitchen.bryo.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ReplaceCabinetWithMultipleCabinets extends Browser {
    //Test Scenarios for KIT-1296 : As a user, I can replace one cabinet for multiple cabinets
    @Test
    public void replaceWithMultipleCabinetsTest() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
		.startFromScratch()
                .step3()

                //Scenario 1: If there are no options to replace item by multiple items do not show the option to enter the layer
                .addProduct("UD4SA50", true, true, false)
//                .verifyMultiReplacePossible(-110, -10, false)
                .addProduct("U2DA80", true, true, false)
//                .verifyMultiReplacePossible(-65, -10, true)

                //Scenario 2 : Verify Generic Overlay
                .replaceWithMultipleProducts(-65, -10)
                .verifyHeader("Replace U2DA80", "Choose a combination that fits your space.", false, true)
                .verifyMultiReplacePopup()

                //Scenarios for Base cabinet
                //Scenario 3: Cabinet selection tabs and validate buttons remain inactive until combination is selected : partially covered in scenario 2 and partially in scenario 4

                //Scenario 4: Medium width cabinets (<=1000 mm): can be replaced with 2 smaller cabinets
                .verifyActivePanel("Combination")
                .verifyAvailableCombinations("400 mm + 400 mm > 500 mm + 300 mm > 300 mm + 500 mm")
                .selectCombination("300 mm + 500 mm")

                .verifyTabsEnabled(true, true, true, false)
                .verifyActivePanel("1st cabinet")
                .selectCabinet("U2DA302")

                .verifyTabsEnabled(true, true, true, false)
                .verifyActivePanel("2nd cabinet")
                .selectCabinet("U2DA50")

                .verifyHeader("Replace U2DA80", "Choose a combination that fits your space.", false, false)
                .validateCombination()
                .verifyProduct(-10, 25, "U2DA302")
                .verifyProduct(15, 30, "U2DA50")

                //Scenario 5: Cancelling after selecting the combinations doesnt replace the cabinet
                .addProduct("U2DA80", true, true, false)
                .replaceWithMultipleProducts(55, 40)
                .selectCombination("300 mm + 500 mm")
                .verifyTabsEnabled(true, true, true, false)
                .waitForActivePanel("1st cabinet")
                .selectCabinet("U2DA302")
                .waitForActivePanel("2nd cabinet")
                .selectCabinet("U2DA50")
                .cancelCombination()
                .verifyProduct(30, 40, "U2DA80")

                //Scenario 5: We can go back and reselect combination even after selecting a cabinet for a combination. We can also select cabinet combinations in any order i.e. for ex, 2nd cabinet and then 1st cabinet
                .replaceWithMultipleProducts(30, 40)
                .selectCombination("300 mm + 500 mm")
                .verifyTabsEnabled(true, true, true, false)
                .waitForActivePanel("1st cabinet")
                .selectCabinet("U2DA302")

                .selectTab("Combination")
                .selectCombination("400 mm + 400 mm")
                .selectTab("2nd Cabinet")
                .selectCabinet("U2DA402")
                .verifyHeader("Replace U2DA80", "Choose a combination that fits your space.", false, true)
                .selectTab("1st Cabinet")
                .selectCabinet("UD4SA40")
                .verifyHeader("Replace U2DA80", "Choose a combination that fits your space.", false, false)
                .validateCombination()

                .verifyProduct(20, 40, "UD4SA40")
                .verifyProduct(48, 40, "U2DA402")

                //Scenario 6 : Able to move, position, duplicate, edit and delete any cabinet insterted through the  Multi-replace feature
                .translateProduct(50,45, 0, 50)
                .verifyProduct(50,95,"U2DA402")
                .position(20,35,"3351 mm", "3000 mm", "")
                .verifyPosition(10,45,"3000 mm")
                .duplicateProduct(-38,25)
                .verifyProduct(40,30,"U2DA302")
                .selectMultipleProducts("50,95 > 10,45 > 40,30 > -38,25 > -15,45").deleteProduct()

                //Scenario 7: Large width cabinets (>1000 mm): can be replaced with 3 smaller cabinets
                .addProduct("UD4SA120", true, true, false)
                .replaceWithMultipleProducts(0,25)
                .verifyHeader("Replace UD4SA120", "Choose a combination that fits your space.", false, true)
                .verifyActivePanel("Combination")
                .verifyAvailableCombinations("600 mm + 600 mm > 800 mm + 400 mm > 400 mm + 800 mm > 300 mm + 900 mm > 900 mm + 300 mm > 600 mm + 300 mm + 300 mm > 450 mm + 450 mm + 300 mm >" +
                        "450 mm + 300 mm + 450 mm > 300 mm + 600 mm + 300 mm > 300 mm + 450 mm + 450 mm > 300 mm + 300 mm + 600 mm > 400 mm + 500 mm + 300 mm > 400 mm + 300 mm + 500 mm >" +
                        "500 mm + 400 mm + 300 mm > 500 mm + 300 mm + 400 mm > 300 mm + 400 mm + 500 mm > 300 mm + 500 mm + 400 mm > 400 mm + 400 mm + 400 mm")
                .selectCombination("500 mm + 300 mm + 400 mm")

                .verifyTabsEnabled(true, true, true, true)
                .verifyActivePanel("1st cabinet")
                .selectCabinet("U2DA50")

                .selectTab("3rd Cabinet")
                .verifyTabsEnabled(true, true, true, true)
                .verifyActivePanel("3rd cabinet")
                .selectCabinet("UD4SA40")

                .selectTab("2nd Cabinet")
                .verifyTabsEnabled(true, true, true, true)
                .verifyActivePanel("2nd cabinet")
                .selectCabinet("U2DA302")

                .verifyHeader("Replace UD4SA120", "Choose a combination that fits your space.", false, false)
                .validateCombination()
                .verifyProduct(-17,28,"U2DA50")
                .verifyProduct(7,36,"U2DA302")
                .verifyProduct(30,43,"UD4SA40")

                .twoDView();




        //Scenarios for wall cabinet


        //Scenarios for high cabinet : Cannot be verified as data for replacement cabinets not present
        //Scenario 2 :
        //TODO : Scenarios to be added


    }
}
