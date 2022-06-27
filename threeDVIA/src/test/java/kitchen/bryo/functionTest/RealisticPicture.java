package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;

public class RealisticPicture extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void realisticImageTest(SignUpData signUpData){

		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.login(signUpData)
		.openMyProjectList()
		.searchProject("ODT_RENDERING_TEST")
		.openProject(0, "ODT_RENDERING_TEST")
//		.realisticImageMultiple("", false, 1)
		.realisticImage(3)
		.step4()
		.verifyStep4()
		.verifyRenderingInProgress(1)
//		.verify2DPlansAndImages("Plans", 2)
		.verify2DPlansAndImages("Images", 2);
	}
}
