package kitchen.bryo.functionTest;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.SelectMapping;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class DeleteMultipleProducts extends Browser {
    @Test
    public void deleteMultipleProductsTest() {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
		.startFromScratch()
                .roomShape("open", 3)
                .nextStep()
                .selectFromSeveralRoom("", -80, 100)
                .skipLayoutNo()
                .waterSupplyPositionPopUp("No", 0, 0)
                .lookingForNeedMapping("Update my needs", SelectMapping.class)
                .updateStyleMapping()
                .updateLayoutMapping("I-shaped")
                .updateCookingMapping("Under worktop")
                .updateRefrigerationMapping("Integrated")
                .generateNewLayouts()
                .findSolutions("81 - I Shaped kitchen")
                .nextStepDesignYourKitchen("No", "")
                .twoDView()
                .threeDView()
                .deleteMultipleProducts("deleteMultipleProductsInStep3")
                .verifyPrice("5 159,00")
                .undo(1)
                .verifyPrice("7 425,98")
                .rotateProjectView(11, "right")
                .positionMultipleProducts("positionMultipleProductsInStep3", "4426 mm", "1426 mm")
                .verifyPositionMultipleProducts("verifyPositionMultipleProductsInStep3", "1426 mm")
                .checkBusinessRuleShowIn3D("Area of worktop around the cooking unit", true)
                .verifyPrice("7 776,98")
                .undo(10)
                .verifyPrice("7 425,98")
                .twoDView().threeDView()
                .duplicateMultipleProducts("duplicateMultipleProductsInStep3")
                .verifyPrice("10 106,96");
    }

}
