package kitchen.bryo.functionTest;

import kitchen.bryo.pageObject.MakeItYours;
import kitchen.bryo.pageObject.StartNow;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.HomePage;

public class PickALayoutStartFromScratch extends Browser {
	@Test
	public void pickALayoutStartFromScratchTest(){
		StartNow start=PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB");
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.startKitchenDesign()
		.selectStyleMapping("Stockholm - White","28mm Timber Worktop", null)
		.layoutMapping("U-shaped")
		.cookingMapping("Integrated")
		.refrigerationMapping("Integrated")
		.startPlanning()
		.nextStep()
		.waterSupplyPositionPopUp("No", 0, 0)
		.findSolutions("72 - U Shaped kitchen")
		.showMore()
		.showAppliances("Hoods")
		.showAppliances("Cooktops")
		.showLess()
		.verifyPriceInStep2("18 886,98")
		.lookingForNeedMapping("Start from scratch", MakeItYours.class)
		.addProduct("W6002", false, false, false)		
		.verifyProduct(-30, -185, "W6002")
		.verifyReplaceProperty(-30, -185, "Front", "CONCORDE")
		.verifyPrice("1 167,00");

	}

}
