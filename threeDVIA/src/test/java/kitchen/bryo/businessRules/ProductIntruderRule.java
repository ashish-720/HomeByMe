package kitchen.bryo.businessRules;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.HomePage;

public class ProductIntruderRule extends Browser {
	@Test
	public void productIntruderRule() {
		  HomePage home = PageFactory.initElements(driver, HomePage.class);
	        home.startKitchenDesign()
	                .selectStyleMapping("Ottawa - Beige", "", "")
	                .layoutMapping("L-Shaped").cookingMapping("").refrigerationMapping("integrated").startPlanning()
	                .nextStep()
	                .waterSupplyPositionPopUp("No", 0, 0)
	                .findSolutions("87 - L Shaped kitchen").nextStepDesignYourKitchen("No", "No")
		.twoDView().threeDView()
		//KIT:1091 -As a user, I am notified if my project contains multiple styles
		.addProduct("U2DA80", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.replaceProperty(-114, -47, "Front", "CONCORDE", "selection", true,"")
		.duplicateProduct(-114, -47)
		.duplicateProduct(-114, -47)
		.replaceProperty(57, 39, "Front", "MADELEINE", "selection",true, "")
		.replaceProperty(137, 132, "Front", "OPERA", "selection",true, "")
		.checkBusinessRuleShowIn3D("Various product styles", true)
		.undo(6)
		.verifyBusinessRuleRemoved("Various product styles");
		
	}

}
