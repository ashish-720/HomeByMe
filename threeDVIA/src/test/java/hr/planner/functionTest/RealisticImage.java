package hr.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class RealisticImage extends Browser {
	
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void realisticImage(SignUpData signUpData) {
	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
	
		home.login(signUpData)
		.myProjects()
		.searchProjectName("HR-ODT")
		.openProject("HR-ODT", 0)
		.takePicture()
		.realisticImage()
		.layer1Verification()
		.disabledbackGroundImage()
		.sunPosition(30, 40, "146") //angle verification failed
		.sunInclination(10, 60, "270")
		.generate()
		.layer3Verification() //verification failed
		.createNew()
		.firstPersonView()
		.viewThreeD()
		.viewModeOptions()
		.cameraHeightBtn()
		.cameraHeight("1.7")
		.showCutWall()
		.generate()
		.layer3Verification()
		.createNew()
		.firstPersonView()
		.backGroundImage()
		.nextArrow()
		.sunPosition(30, 40, "146") //angle verification failed
		.sunInclination(30, 40, "146")
		.generate()
		.layer3Verification()
		.okGotIt()
		;
			
	}
	
}
