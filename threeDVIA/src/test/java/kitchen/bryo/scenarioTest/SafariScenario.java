package kitchen.bryo.scenarioTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.FloorPlan;
import kitchen.bryo.pageObject.HomePage;
import kitchen.bryo.pageObject.StartNow;
import kitchen.bryo.pageObject.StylePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SafariScenario extends Browser {
	
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)

	public void safariScenario(SignUpData signUpData){
		StartNow start=PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB");
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.startKitchenDesign();
		StylePage style = PageFactory.initElements(driver, StylePage.class);
		style.selectStyleMapping("Ottawa - Wood","38mm Acrylic Worktop", "170mm Bar Handle")
			.layoutMapping("I-shaped")
			.cookingMapping("Under worktop")
			.refrigerationMapping("Freestanding")
			.startPlanning();
		FloorPlan plan = PageFactory.initElements(driver, FloorPlan.class);
			plan.ceiling("2600 mm")
			.verifyCeiling(-235,25,"2600 mm")
			.splitWall(-248,111)
			.moveWall(-252,122,-400,122)
			.verifyWallProperty(-300, 0, "1247 mm")
			.manageSlopedWalls()
			.addslopedCeiling2D(0,-200,"2000", "", "")
			.editWallDimension(-145,-50, "2222 mm", "apply above")
			.verifyWallProperty(-145,-92, "2222 mm")
			.threeDView()
			.addCovering("PAINT|2", "all")
			.addWaterSupply(230, 0)
			.nextStep()
			.skipLayoutNoReturnPickALayout()
			.findSolutions("82 - I Shaped kitchen")
			.nextStepDesignYourKitchen("No", "Yes")
			.saveProjectInStep3(signUpData, "SafariMacPrj", "Test on Safari Browser")
			.panoramic360Image(2)
			.realisticImage(1)
			.step4()
			.printTestInStep4(2, 6)
			
			
			;
	}
}
