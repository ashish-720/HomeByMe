package hr.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class Take360Image extends Browser {
	
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void take360Image(SignUpData signUpData) {
	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
	
		home.login(signUpData)
		.myProjects()
		.searchProjectName("HR-ODT")
		.openProject("HR-ODT", 0)
		.takePicture()
		.take360Image()
		.layer1Verification360()
		.backGroundImage()
		.nextArrow()
		.nextArrow()
		.previousArrow()
		.sunPosition(30, 40, "146")
		.sunInclination(10, 60, "270")
		.preview() 
//		.modify()
//		.preview()
		.generate360()
		.generate2()
		.layer3Verification360()
		.okGotIt360()
		//loading layer veriification not done
		
		;
			
	}
	
}