package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.HomePage;
import kitchen.bryo.pageObject.SelectMapping;
import kitchen.bryo.pageObject.StartNow;

public class PriceTest2 extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void priceTestTwo(SignUpData signUpData){

		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB");
		HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.startKitchenDesign()
        .selectStyleMapping("Stockholm - Black","38mm Acrylic Worktop",null)
        .layoutMapping("II-shaped") 
        .cookingMapping("")
        .refrigerationMapping("")
        .startPlanning()
		.roomShape("closed",3)
		.addProduct("DOUBLE WINDOW|4839", false, false)
		.addProduct("OPENING", false, false)
		.nextStep()
		.waterSupplyPositionPopUp("No", 0, 0)
		.findSolutions("29 - II Shaped kitchen")
		.verifyPriceInStep2("20 204,00")
		.verifyTemplatePriceInStep2("18 955,15","")
		.nextStepDesignYourKitchen("No", "No")
		.verifyPrice("20 204,00")
//		.verifyPriceInformation()
		.twoDView()
		.threeDView()
		.rotateProjectView(5, "left")
		.replaceProperty(-37, 67, "Worktop", "LAMINATE BLACK", "all",true,"")
		.deleteProduct(129, 71)
		.addProduct("CORNER FILLER BASE UNIT", true, false, false)
		.rotateProjectView(10, "right")
		.zoomIn(6)
		.addProduct("U2DA90", false, true, false)
		.translateProduct(7, -88, -196, 6)
		.addProduct("U2DA402", false, true, false)
		.translateProduct(-32, -74, -247, 34)
		.addProduct("U2DA90", false, true, false)
		.worktopEditor(-29, -88)
		.editWorktopYes()
		.verifyPriceInWorktop("2 688,46")
		.createCornerCutOut(104, -205, "", "Outer", "", "", "", "", "", "", "", "", "100 mm")		
		.verifyPriceInWorktop("2 888,46")
		.validateWorktopEditor()
		.verifyPrice("21 357,46")
		.step4()
		.verifyPriceInStep4("21 357,46")
		.clickDesignStep()
		.verifyPrice("21 357,46")
		.saveProjectInStep3(signUpData, "price test_"+UtilHBM.getDate(0, "yyyyMMdd"), "21 357,46")
		.closePlanner()
		.openMyProjectList()
//		.openProjectFromMyProjects("price test_"+UtilHBM.getDate(0, "yyyyMMdd"))
		.openProject(0,"price test_"+UtilHBM.getDate(0, "yyyyMMdd"))
		.verifyPrice("21 357,46");
	
	}
}
