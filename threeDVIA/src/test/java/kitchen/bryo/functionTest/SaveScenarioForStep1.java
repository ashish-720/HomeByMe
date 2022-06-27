package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.StartNow;

public class SaveScenarioForStep1 extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void saveScenarioForStep1(SignUpData signUpData){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.saveProjectInStep1(signUpData, "SAVE_ODT_IN_STEP_1_" + UtilHBM.getDate(0, "dd_MM_yyyy"),"MY BRYO KITCHEN created on" + UtilHBM.getDate(0, "dd_MM_yyyy"))
		.closePlanner()
		.logout();
	}

}
