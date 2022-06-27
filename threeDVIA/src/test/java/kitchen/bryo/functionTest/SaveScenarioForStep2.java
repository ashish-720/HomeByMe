package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.StartNow;

public class SaveScenarioForStep2 extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void saveScenarioForStep2(SignUpData signUpData){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.nextStep()
		.skipLayoutNo()
		.waterSupplyPositionPopUp("No", 0, 0)
		.saveProjectInStep2(signUpData, "SAVE_ODT_IN_STEP_2_" + UtilHBM.getDate(0, "yyyyMMdd"),
				"MY BRYO KITCHEN created on" + UtilHBM.getDate(0, "yyyyMMdd"))
		.closePlanner()
		.logout();

	}

}
