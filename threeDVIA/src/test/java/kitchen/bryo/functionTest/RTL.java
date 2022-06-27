package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.HomePage;
import kitchen.bryo.pageObject.StartNow;

public class RTL extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void rightToLeftAppTest(SignUpData signUpData){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("ar-EG");
		HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.startKitchenDesign()
        .selectStyleMapping()
        .layoutMapping("I-shaped")
        .cookingMapping("Integrated")
        .refrigerationMapping("Integrated")
        .startPlanning()
        .nextStep()
		.waterSupplyPositionPopUp("No", 0, 0)
		.findSolutions("13")
		.nextStepDesignYourKitchen("No", "No")
//		.openClose(0, 0, 0, 0)
		.twoDView()
		.emptyRoom(-30, -175, "Kitchen", "16.0", "yes")
		.threeDView()
		.addProductThroughSearch("U2DA80", "U2DA80", true, false)
//		.addProduct("UD4SA40", true, false, false)
		.worktopEditor(-111, -2)
		.editWorktopYes()
		.createCutOut(-170, -180, "Rectangle", "150 mm", "200 mm", "", "", "")
		.validateWorktopEditor()
		.addProperty(-10, 7, "Wall Panel", "GB_WP_LAMINATE", "all", true)
		.wallPanelEditor(-8, -19)
		.editWallPanelYes()
		.createCutOutForWallPanel(-224, 30, "Circle", "", "", "", "", "150 mm")
		.validateWallPanelEditor()
		.customiseProduct(-11, 12, "")
		.addItemInCabinet("INTERNAL DRAWER 100", false)
		.editComposeReplaceProperty(170, -5, "Drawer Front", "CONCORDE|14125", false)
		.validateComposeFurniture()
		.saveProjectInStep3(signUpData, "RTL_ODT_TEST_"+UtilHBM.getDate(0, "yyyyMMdd"), "Right To Left Test")
		.step4()
		.printTestInStep4(0, 0)
		.closePlanner()
		.openMyProjectList()
		.searchProject("RTL_ODT_TEST")
		.openProject(0, "RTL_ODT_TEST_"+UtilHBM.getDate(0, "yyyyMMdd"))
//		.openProject()
		.verifyProductOnReOpen(-11, 12, "U2DA80");
	}

}
