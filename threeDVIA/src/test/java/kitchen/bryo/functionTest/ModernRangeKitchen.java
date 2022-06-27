package kitchen.bryo.functionTest;

import kitchen.bryo.pageObject.SelectMapping;
import kitchen.bryo.pageObject.StartNow;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.HomePage;

public class ModernRangeKitchen extends Browser {
    @Test
    public void modernRangeTest() {
    	StartNow start =PageFactory.initElements(driver, StartNow.class);
    	start.startDemo("en-GB");
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.startKitchenDesign()
                .selectStyleMapping("Stockholm - White","28mm Timber Worktop", "")
                .layoutMapping("L-shaped")
                .cookingMapping("Integrated")
                .refrigerationMapping("Integrated")
                .startPlanning()
                .nextStep()
                .waterSupplyPositionPopUp("No", 0, 0)
                .findSolutions("88 - L Shaped kitchen")
                .lookingForNeedMapping("Update my needs", SelectMapping.class)
                .updateStyleMapping("Paris - Grey", "38mm Acrylic Worktop", "170mm Bar Handle")
                .updateLayoutMapping("U-shaped")
                .updateCookingMapping("Integrated")
                .updateRefrigerationMapping("Integrated")
                .generateNewLayouts()
                .findSolutions("75 - U Shaped template")
                .nextStepDesignYourKitchen("No", "")
                .verifyPrice("24 411,70");
    }

}
