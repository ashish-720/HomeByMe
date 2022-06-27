package kitchen.bryo.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

//Test scenarios for KIT-2170 : As a user, I can ungroup products sets
public class UngroupProductSets extends Browser {
    @Test
    public void ungroupProductSets() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
		.startFromScratch()
                .step3()
                .addProductThroughSearch("Dining set", "Dining set for dev", true, false)

                //Scenario 1 :  Grouped Products can be ungrouped
                .ungroupProduct(-25,70)
                .verifyProductsUngrouped("-25,70 > -25,10")
                .verifyProduct(-25,70, "XZ3 Table Round")
                .verifyProduct(-25,10, "CHAIR")


                //Scenario 2 : Ungrouped products action can undone and the grouped product can be moved as a group
                .undo(8)
                .translateProduct(-25,70,115,100)
                .verifyProduct(85,140,"Dining set for dev")
                .position(85,140, "2216 mm","200 mm", "")
                .verifyProduct(75,15,"Dining set for dev")

                //Scenario 3 : After ungouping, each product can be moved individually
                .ungroupProduct(75,15)
                .translateProduct(75,15, 0, 150)
                .position(75,55, "2504 mm", "300 mm", "")
                .verifyProduct(75,140, "XZ3 Table Round")
                .verifyProduct(-100,55, "CHAIR")
                .verifyProduct(25,30, "CHAIR")
                .verifyProduct(120,30, "CHAIR")
                .verifyProduct(75,-10, "CHAIR");
    }
}
