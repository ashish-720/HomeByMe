package kitchen.bryo.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.SelectMapping;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SolutionLayout extends Browser {
    @Test
    public void solutionLayoutTest() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
		.startFromScratch()
                .moveWall(-7, -250, 7, 250)
                .nextStep()
                .invalidLayout()
                .addWall("wallFromScratch")
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
//                .verifyPrice("7 114,98")
                .clickPickALayout()
                .lookingForNeedMapping("Update my needs", SelectMapping.class)
                .updateStyleMapping()
                .updateLayoutMapping("L-shaped")
                .updateCookingMapping("")
                .updateRefrigerationMapping("")
                .generateNewLayouts()
                .findSolutions("90 - L Shaped kitchen")
                .nextStepDesignYourKitchen("No", "Yes");
//                .verifyPrice("5 637,98");

    }

}
