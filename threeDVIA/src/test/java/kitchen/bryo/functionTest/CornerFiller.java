package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CornerFiller extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void cornerFillerTest(SignUpData signUpData){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.addProductThroughSearch("Cornerfiller", "CORNER FILLER BASE UNIT", true, false)
//		design.addCabinet("Corner filler piece for base unit",
//				"Filler strip angle");
		.replaceProperty(-90,-5, "Plinth", "OPERA", "all", true,"")
		.verifyReplaceProperty(-90,-5, "Plinth", "OPERA")
		.replaceProperty(-90,-5, "Filler Piece", "CONCORDE", "",true, "")
		.editCornerFiller(-90,-5, "45 °", "370 mm",
				"150 mm", "370 mm", "150 mm", "").verifyCornerFiller(
				-89,-8, "45 °", "370 mm", "150 mm",
				"370 mm", "150 mm", "");
	}
}
