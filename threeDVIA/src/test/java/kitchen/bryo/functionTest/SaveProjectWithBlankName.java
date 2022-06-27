package kitchen.bryo.functionTest;

import kitchen.bryo.pageObject.SelectMapping;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.StartNow;

public class SaveProjectWithBlankName extends Browser {
    @Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
    public void saveProjectWithBlankName(SignUpData signUpData) {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
		.startFromScratch()
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
                .nextStepDesignYourKitchen("No", "")
                .clickAndDrag()
                .twoDView()
                .threeDView()
                .saveProjectInStep3(signUpData, " ", " ")
                .checkProjectDetails("", "7 114,98")
                .step4()
                .verifyProjectTitleDetails()
                .closePlanner()
                .openMyProjectList()
//                .openProjectFromMyProjects("0")
                .openProject(0, "")
                .checkProjectDetails("", "7 114,98");
    }

}
