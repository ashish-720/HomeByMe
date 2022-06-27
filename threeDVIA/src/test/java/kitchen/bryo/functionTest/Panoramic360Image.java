package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.StartNow;

public class Panoramic360Image extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void panoramic360ImageTest(SignUpData signUpData){
		
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.login(signUpData)
		.openMyProjectList()
		.searchProject("ODT_PanaromicImageTest")
//		.openProject()
		.openProject(0, "ODT_PanaromicImageTest")
		.verifyPrice("")
		.panoramic360Image(3)
		.step4()
		.verifyRenderingInProgress(1);

		

	}
}
