package kitchen.bryo.functionTest;

import kitchen.bryo.pageObject.SelectMapping;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.StartNow;

public class SaveScenarioForStep4 extends Browser {
    @Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
    public void saveScenarioForStep4(SignUpData signUpData) {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
		.startFromScratch()
                .nextStep()
                .skipLayoutNo()
                .waterSupplyPositionPopUp("No", 0, 0)
                .lookingForNeedMapping("Update my needs", SelectMapping.class)
                .updateStyleMapping()
                .updateLayoutMapping("I-shaped")
                .updateCookingMapping("Under worktop")
                .updateRefrigerationMapping("Freestanding")
                .generateNewLayouts()
                .findSolutions("8 - I Shaped kitchen")
                .nextStepDesignYourKitchen("No", "")
                .clickAndDrag()
                .step4()
                .verifyPriceInStep4("6 056,98")
                .saveProjectInStep4(signUpData, "SAVE_ODT_IN_STEP_4_" + UtilHBM.getDate(0, "yyyyMMdd"), "MY BRYO KITCHEN created on" + UtilHBM.getDate(0, "yyyyMMdd"))
                .closePlanner()
                .logout();
    }
}
