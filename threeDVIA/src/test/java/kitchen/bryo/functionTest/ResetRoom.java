package kitchen.bryo.functionTest;

import kitchen.bryo.pageObject.SelectMapping;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class ResetRoom extends Browser {
    @Test
    public void resetRoomTest() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
		.startFromScratch()
                .step3()
                .addProduct("GVARIO03", true, false, false)
                .clickFloorplan()
                .roomShape("Closed", 3)
                .nextStep()
                .skipLayoutNo()
                .waterSupplyPositionPopUp("No", 0, 0)
                .lookingForNeedMapping("Update my needs", SelectMapping.class)
                .updateStyleMapping()
                .updateLayoutMapping("L-shaped")
                .updateCookingMapping("Under worktop")
                .updateRefrigerationMapping("Integrated")
                .generateNewLayouts()
                .findSolutions("87 - L Shaped kitchen")
                .nextStepDesignYourKitchen("No", "No")
                .verifyPrice("7 114,98")
                .twoDView()
                .threeDView()
                .verifyProduct(-4, -15, "SPUD100");


    }

}
