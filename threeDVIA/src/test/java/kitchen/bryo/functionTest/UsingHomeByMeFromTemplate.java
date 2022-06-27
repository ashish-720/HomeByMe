package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.MakeItYours;
import kitchen.bryo.pageObject.SelectMapping;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class UsingHomeByMeFromTemplate extends Browser {
    @Test(dataProvider = "hbmProdloginData", dataProviderClass = SignUpData.class)
    public void hbmProjectUsingTemplateTest(SignUpData signUpData) {
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.startDemo("en-GB")
		.startFromScratch()
                .useHomeByMeProject()
                .clickHBMConnectLoginButton()
                .loginExitingUser(signUpData)
                .selectProjectForBryo("Project (32)", 0)
//		.loginForHBM(signUpData)
//		.selectHomeByMeProject("Project (32)")
                .selectFromSeveralRoom("Ground Floor", -185, -74)
                .verifyImportedHBMProject(0, 0)
                .nextStep()
                .skipLayoutNo()
                .waterSupplyPositionPopUp("No", 0, 0)
                .lookingForNeedMapping("Update my needs", SelectMapping.class)
                .updateStyleMapping()
                .updateLayoutMapping("L-shaped")
                .updateCookingMapping("Under worktop")
                .updateRefrigerationMapping("Freestanding")
                .generateNewLayouts()
                .findSolutions("48 - L Shaped kitchen")
                .nextStepDesignYourKitchen("No", "Yes")
                .verifyPrice("5 471,00")
                .addProperty(179, 121, "Wall Panel", "GB_WP_LAMINATE", "all", true)
                .verifyAddProperty(179,121, "Wall Panel", "GB_WP_LAMINATE")
                .replaceProperty(179,121, "Plinth", "OPERA", "",true, "")
                .verifyReplaceProperty(179,121, "Plinth", "OPERA")
                .replaceProperty(322,-138, "Front", "CONCORDE", "all", true,"")
                .verifyReplaceProperty(322,-138, "Front", "CONCORDE")
//                .priceInfoDetails()
                .replaceProperty(244,191, "Worktop", "ACRYLIC WHITE", "",true, "")
                .verifyReplaceProperty(244,191, "Worktop", "ACRYLIC WHITE")
                .worktopEditor(244,191)
                .editWorktopYes()
                .tooltipsWorktop()
                .zoomIn(13)
//                .verifyPriceInWorktop("1 810,50")
                .createCutOut(-455, -205, "Rectangle", "150 mm", "150 mm", "", "", "")
                .verifyWorktopCutOut(-455, -205, "150 mm", "150 mm", "", "", "290 mm", "195 mm")
                .validateWorktopEditor()
                .deleteProduct(48, -352)
                .deleteProduct(424, -116)
                .wallPanelEditor(14,15)
                .editWallPanelYes()
                .createCutOutForWallPanel(45, 25, "Circle", "", "", "", "", "100 mm")
                .validateWallPanelEditor();

    }

    @Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class, dependsOnMethods = "hbmProjectUsingTemplateTest")
    public void saveHBMProjectUsingTemplateTest(SignUpData signUpData) {
        MakeItYours save = PageFactory.initElements(driver, MakeItYours.class);
        save.saveProjectInStep3(signUpData, "HBM_ODT_TEST" + UtilHBM.getDate(0, "yyyyMMdd"), "HBM test kitchen template_" + UtilHBM.getDate(0, "yyyyMMdd"))
//                .verifyPrice("8 632,50")
                .closePlanner()
                .openMyProjectList()
                .searchProject("HBM_ODT_TEST" + UtilHBM.getDate(0, "yyyyMMdd"))
                .openProject(0, "HBM_ODT_TEST" + UtilHBM.getDate(0, "yyyyMMdd"))
//                .openProject()
                .twoDView().threeDView()
               .verifyProductOnReOpen(-28, 83, "SPUD60")
//                .verifyPriceInformation("8 487,00")
                .verifyReplaceProperty(-28, 83, "Wall Panel", "GB_WP_LAMINATE")
                .wallPanelEditor(-28, 83)
                .validateWallPanelEditor();
//                .verifyPrice("8 632,50");
    }
}
