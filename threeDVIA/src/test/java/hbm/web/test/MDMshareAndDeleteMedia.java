package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

@Test
public class MDMshareAndDeleteMedia extends Browser{

	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class)
	public void mdmShareAndDeleteMedia(SignUpData signUpData){		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
		.goToMyProjects()
		.openOwnProjectMDM("Duplicate")
		.verifyProjectName("Duplicate")
		.openProject()
		.threeDView()
		.snapshot3D("3D", 2)
		.snapshot3D("3D", 3)
		.closePlanner()
		.goToMyProjects()
		.openOwnProjectMDM("Duplicate")
//		.sharemediaMDM("Screenshots",2)
//		.deleteMediaMDM("Screenshots",3,"No")
//		.deleteMediaMDM("Screenshots",3,"Yes")
		.sharemedia("Screenshots",true, 2)
		.sharemediaFullscreen("Screenshots",true, 2)
		.deleteMedia("Screenshots",3, true, "No")
		.deleteMedia("Screenshots",3, true, "Yes")
		.deleteFullScreenMedia("Screenshots",3, true, "No")
		.deleteFullScreenMedia("Screenshots",3, true, "Yes")
		;
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.logoutHBM4();
	}
}
