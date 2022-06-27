package kitchen.bryo.functionTest;

import kitchen.bryo.pageObject.SelectMapping;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class OverwriteSolution extends Browser {
    @Test
    public void overWriteSolutionTest() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
		.startFromScratch()
                .step3()
                .addProduct("GVARIO03", true, false, false)
                .addProduct("GVARIO03", true, false, false)
                .addProduct("U2DA80", true, false, false)
                .addProduct("U2DA80", true, false, false)
                .addProduct("W6002", true, false, false)
                .translateProduct(58, -5, -150, 45)
                .rotateProduct(-111, 34, -90, 45)
                .addProduct("U2DA80", true, false, false)
                .translateProduct(58, -5, 150, 45)
                .addProduct("DALINAR", true, false, false)
                .verifyReplaceProperty(-112, 32, "Left Cover Panel", "MADELEINE")
                .verifyReplaceProperty(147, 34, "Right Cover Panel", "MADELEINE")
                .verifyPrice("")
                .clickFloorplan()
                .nextStep()
                .skipLayoutNo()
                .waterSupplyPositionPopUp("Yes", -239, 60)
                .lookingForNeedMapping("Update my needs", SelectMapping.class)
                .updateStyleMapping()
                .updateLayoutMapping("II-shaped")
                .updateCookingMapping("Under worktop")
                .updateRefrigerationMapping("Integrated")
                .generateNewLayouts()
                .findSolutions("22 - II Shaped Kitchen")
                .nextStepDesignYourKitchen("No", "Yes")
                .verifyPrice("12 055,98");
    }

}
