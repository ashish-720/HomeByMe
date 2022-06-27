package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.StartNow;

public class PriceTest1 extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void priceTestOne(SignUpData signUpData){

		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.login(signUpData)
		.openMyProjectList()
		.searchProject("ODT_PRICE_TEST")
		.openProject(0, "ODT_PRICE_TEST")
//		.openProject()
//		.twoDView().threeDView()
		.verifyMemberPrice("15 218,90")
		.verifyPrice("16 919,10")
		.verifyPriceInformation("15 218,90","", "48 months")
		.step4()
		.verifyPriceInStep4("16 919,10")
		.clickDesignStep()
		.verifyPrice("16 919,10")
		.worktopEditor(-59, 168)
		.verifyPriceInWorktop("5 153,10")
		.createCutOut(-135, -173, "Circle", "", "", "", "", "120 mm")
		.verifyWorktopCutOut(-134, -173, "", "", "", "120 mm", "626 mm", "355 mm")
		.validateWorktopEditor()
		.worktopEditor(131, 34)
		.deleteCutOrCutOuts(-146, -186)
		.validateWorktopEditor()
		.verifyPrice("16 919,10")
		.clickSave(signUpData)
		.closePlanner()
		.openMyProjectList()
		.searchProject("ODT_PRICE_TEST")
//		.openProject()
		.openProject(0, "ODT_PRICE_TEST")
		.verifyPrice("16 919,10")
		.worktopEditor(-61, 183)
		.verifyPriceInWorktop("5 153,10")
		.editWaterfall(-1, 15)
		.verifyPriceInWorktop("5 153,10")
		.createCutOut(0, 0, "Circle", "", "", "", "100 mm", "")
		.verifyPriceInWorktop("5 263,10")
		.undoInWorktopEditor(driver, 3)
		.verifyPriceInWorktop("5 153,10")
		
		.validateWorktopEditor()
		.verifyPrice("16 919,10")
		.clickSave(signUpData)
		.closePlanner()
		.openMyProjectList()
		.searchProject("ODT_PRICE_TEST")
		.openProject(0, "ODT_PRICE_TEST")
//		.openProject()
		.verifyPrice("16 919,10")
		.replaceProperty(-56, 182,"Worktop", "WOOD OAK", "all", true,"yes")
		.verifyReducedPrice("12 166,00")
		.verifyPrice("12 266,00");

	}
}
