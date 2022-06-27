package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.HomePage;
import kitchen.bryo.pageObject.StartNow;

public class LinearProduct extends Browser {
	@Test
	public void linearProductTest(){
		StartNow start=PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB");
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.startKitchenDesign()
		.selectStyleMapping("Stockholm - White","28mm Timber Worktop", null)
		.layoutMapping("")
		.cookingMapping("")
		.refrigerationMapping("")
		.startPlanning()
		.step3()
		.addProduct("UD2SA80", true, false, false)
		.translateProduct(-103, -10, 6, 100)
		.duplicateProduct(-86, 97)
		.worktopEditor(-86, 97)
		.verifyWorktopDimension(-73, 41, "1660 mm")
		.validateWorktopEditor()
		.replaceProperty(-86, 97,"Back Cover Panel", "MADELEINE", "all", true,"")
		.verifyReplaceProperty(-86, 97,"Back Cover Panel", "MADELEINE");

	}

}
