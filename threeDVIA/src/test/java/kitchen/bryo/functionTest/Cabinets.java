package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class Cabinets extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void cabinetTest(SignUpData signUpData){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.verifyPrice("0,00")
		.addProduct("GVARIO03", true, false,false)
		.verifyProduct(-120,-80, "GVARIO03")
		.duplicateProductUsingShortCutKey(-120,-80)
		.deleteProductUsingShortCutKey(-70, -77)
//		.tooltipsForStep3()
//		.productInfo(-120,-80)
//		.priceInfoDetails()
		.openClose(-120,-80, -120,-80)
		.addProperty(-120,-80, "Top Cover Panel", "OPERA|16058", "", true)
		.verifyAddProperty(-120,-80,  "Top Cover Panel","OPERA|16058")
		.replaceProperty(-120,-80, "Top Cover Panel", "CONCORDE|15489", "",true,"")
		.verifyReplaceProperty(-120,-80,  "Top Cover Panel","CONCORDE|15489")
		.verifyReplaceProperty(-120,-80, "Right Cover Panel","MADELEINE|13857")
		.replaceProperty(-120,-80, "Right Cover Panel", "CONCORDE|15488", "",true, "")
		.verifyReplaceProperty(-120,-80, "Right Cover Panel","CONCORDE|15488")
		.undo(4)
		.verifyReplaceProperty(-120,-80, "Right Cover Panel","MADELEINE|13857")
		.verifyPrice("")
		.straightFillerPropertyOFF(-120,-80, "Straight filler",
				"Left Cover Panel", "")
		.replaceProperty(-120,-80, "Left Cover Panel", "OPERA|15535", "",true, "")
		.verifyReplaceProperty(-120,-80, "Left Cover Panel","OPERA|15535")
		.addProperty(-120,-80, "Cornice", "MADELEINE|14178", "", true)
		.verifyAddProperty(-120,-80,"Cornice", "MADELEINE|14178")
		.position(-120,-80,"3337 mm", "250 mm", "")
		.verifyPosition(110,-65, "250 mm")
		.viewHeightIn3D("High").verifyViewHeightIn3D("High")
		.displayFront()
//		.priceInfoDetails()
		.deleteProperty(156,69, "FRIDGE")
		.verifyDeleteProperty(156,69, "Fridge")
		.deleteProperty(156,69,"Freezer")
		.verifyDeleteProperty(156,69, "Freezer")
		.addProduct("GVARIO03", true, false,false)
		.verifyDeleteProperty(-153,74, "Fridge")
		.verifyDeleteProperty(-153,74, "Freezer")
		.addDirectProperty(-153,74, "Fridge", "", "")
		.verifyAddProperty(-153,74,"Fridge", "FRIDGE")
		.addDirectProperty(-153,74, "Freezer", "", "")
		.verifyAddProperty(-153,74, "Freezer","JEFF")
		.step4()
//		.verifyPriceInStep4("")	
		.clickDesignStep()
		.verifyViewHeightIn3D("Worktop")
		.addProduct("GVARIO03", true, false,false)
		.verifyAddProperty(-169,74, "Fridge", "FRIDGE")
		.verifyAddProperty(-169,74, "Freezer","JEFF")
		.deleteProperty(-169,74, "Shelf Protector")
		.verifyDeleteProperty(-169,74, "Shelf Protector")
		.replaceProperty(-169,74, "Front", "CONCORDE|15766", "all", true,"")
		.verifyReplaceProperty(-169,74, "Front", "CONCORDE|15766");
//		.productList();

/*//FUN120358 : As a range maintainer, I can test the planner at a future date and get the range with the prices at this date

//		Scenario 1 : I can track Available replacements at future date
				.addProductThroughSearch("U80_HINGERULE", "U80_HINGERULE", true)
				.verifyReplacementOptionsAvailable(-100,-10,"Worktop",9)
				.debugMenu("Other", "Change date");
//		Scenario 2 : I can track Price at future date
		//TODO : on hold until reliable way to change date value for alert popup is found*/
	}
}
