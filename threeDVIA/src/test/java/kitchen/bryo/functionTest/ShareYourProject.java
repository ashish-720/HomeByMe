package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ShareYourProject extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void shareProjectTest(SignUpData signUpData){
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.startFromScratch()
		.step3()
		.addProduct("GVARIO03", true, false, false)
		.addProduct("U2DA80", true, false, false)
		.addProduct("HOR400", true, false, false)
		.step4()
		.verifyStep4()
		.saveProjectInStep4(signUpData, "ODT_ShareProject", "share project test")
		.share();
	}
}
