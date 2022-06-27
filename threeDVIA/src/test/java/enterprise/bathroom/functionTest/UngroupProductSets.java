package enterprise.bathroom.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

//Test scenarios for KIT-2170 : As a user, I can ungroup products sets
public class UngroupProductSets extends Browser {
    @Test
    public void ungroupProductSets() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.launchApp()
                .step3()
                .addProductThroughSearch("Toilets", "Suspended toilet set", true, false)

                //Scenario 1 :  Grouped Products can be ungrouped
                .ungroupProduct(-90,-2)
                .verifyProductsUngrouped("-124,-19 > -90, 0")
                .verifyProduct(-124,-19, "Suspended toilet")
                .verifyProduct(-90,0, "Vanity unit")


                //Scenario 2 : Ungrouped products action can undone and the grouped product can be moved as a group
                .undo(8)
                .translateProduct(-90,-2,100,7)
                .verifyProduct(-26,-3,"Suspended toilet set")
                .position(-26,-3, "1911 mm","1000 mm", "")
                .verifyProduct(40,-7,"Suspended toilet set");

//                //Scenario 3 : After ungouping, each product can be moved individually
//                .ungroupProduct(-18,3)
//                .translateProduct(-18,3, 149, -28)
//                .position(75,65, "2524 mm", "300 mm", "")
//                .verifyProduct(75,140, "XZ3 Table Round")
//                .verifyProduct(-100,60, "CHAIR")
//                .verifyProduct(25,30, "CHAIR")
//                .verifyProduct(120,30, "CHAIR")
//                .verifyProduct(75,-10, "CHAIR");
    }
}
