package hr.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class ScreenshotImage extends Browser {
	
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void screenshot(SignUpData signUpData) {
	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
	
		home.login(signUpData)
		.myProjects()
		.searchProjectName("HR-ODT")
		.openProject("HR-ODT", 0)
		.takePicture()
		.screenshot()
		.generateScreenshot()
		.viewTwoD()
		.zoomIn(1)
		.zoomOut(1)
		.generateScreenshot()
		.viewScreenshot()
		.myPicture()
//		.closeScreenshot()
		;
			
	}
	
}
