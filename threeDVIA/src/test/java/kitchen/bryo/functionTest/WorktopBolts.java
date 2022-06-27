package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class WorktopBolts extends Browser {
    @Test
    public void worktopBoltsTest() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
		.startFromScratch()
                .step3()
                .addNonVisibleItems("Kitchen accessories", "WORKTOP BOLTS", 4, 1).verifyPrice("27,00")
                .verifyNonVisibleItems("Kitchen accessories", "WORKTOP BOLTS", 3)
                .addProduct("U2DA80", true, true, false)
                .verifyProduct(-100, -5, "U2DA80")
                .addProductThroughSearch("U2DA100", "U2DA100", true, false)
                .verifySearchProduct(-35, 0, "U2DA100");

    }
}
