package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CornerCabinet extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void cornerCabinetTest(SignUpData signUpData){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.addProduct("WED6802", true, false, false)
		.addProperty(-129, -88, "Cornice", "MADELEINE", "", true)
		.verifyAddProperty(-129, -88, "Cornice", "MADELEINE")
		.addProperty(-129, -88, "Deco Strip", "MADELEINE", "", true)
		.verifyAddProperty(-129, -88, "Deco Strip", "MADELEINE")
		.addProduct("UEDK88", true, false, false);
		
	}
}
