package kitchen.bryo.functionTest;

import kitchen.bryo.pageObject.SelectMapping;
import kitchen.bryo.pageObject.StartNow;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.HomePage;

public class PickALayoutUpdateNeeds extends Browser {
    @Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
    public void pickALayoutUpdateNeedsTest(SignUpData signUpData) {
    	StartNow start=PageFactory.initElements(driver, StartNow.class);
    	start.startDemo("en-GB");
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.startKitchenDesign()
                .selectStyleMapping("Ottawa - Wood", "38mm Acrylic Worktop", "170mm Bar Handle")
                .layoutMapping("I-shaped")
                .cookingMapping("Integrated")
                .refrigerationMapping("Integrated")
                .startPlanning()
                .nextStep()
                .waterSupplyPositionPopUp("No", 0, 0)
//		 .findSolutions("15 - I Shaped kitchen","14 705,00")
//		 .zoomIn(6)
//		 .productList("15-I-shaped-kitchen-BOM.txt","14 705,00")
//		 .zoomOut(5)
//		 .lookingForNeedMapping("Update my needs", "Signature", "L-shaped","Integrated", "Integrated")
                .lookingForNeedMapping("Update my needs", SelectMapping.class)
                .updateStyleMapping("Stockholm - Black","38mm Acrylic Worktop",null)
                .updateLayoutMapping("L-shaped")
                .updateCookingMapping("Integrated")
                .updateRefrigerationMapping("Integrated")
                .generateNewLayouts()
                .findSolutions("51 - L Shaped kitchen")
                .zoomOut(3)
                .nextStepDesignYourKitchen("No", "")
                .clickProductList()
                .verifyPriceTotal("")
                .closeProductList()
//                .verifyPrice("24 789,08")
                .replaceProperty(24, 30, "Front", "OPERA", "all", true,"")
                .verifyReplaceProperty(24, 30, "Front", "OPERA")
                .addProperty(24, 30, "Wall Panel", "GB_WP_LAMINATE", "all", true)
        		.verifyAddProperty(24, 30,"Wall Panel", "GB_WP_LAMINATE")
            	.verifyWallPanelOptionsProperty(24, 30, "", "Side 1", "", "", "", "")
        		.editWallPanelOptionsProperty(24, 30, "", "Side 2", "", "")
        		.verifyWallPanelOptionsProperty(24, 30, "", "Side 2", "", "", "", "")
                .saveProjectInStep3(signUpData, "ODT_PickALayoutUpdateNeedsTest", "Fronts test")
                .closePlanner()
                .openMyProjectList()
//                .openProjectFromMyProjects("ODT_PickALayoutUpdateNeedsTest")
                .openProject(0,"ODT_PickALayoutUpdateNeedsTest")
                .verifyReplaceProperty(24, 30, "Front", "OPERA")
                .verifyWallPanelOptionsProperty(24, 30, "", "Side 2", "", "", "", "");


    }

}
