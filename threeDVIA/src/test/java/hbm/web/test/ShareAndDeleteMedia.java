package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

@Test
public class ShareAndDeleteMedia extends Browser{
	
	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class,priority=1)
	public void shareAndDeleteOldMedia(SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToMyProjects()
			.openOwnProject(0, "Duplicate")
			.sharemedia("Realistic images",false, 5)
			.sharemediaFullscreen("Realistic images",false, 5)
			.deleteMedia("Realistic images",5,false, "No")
			.deleteMedia("Realistic images",2,false, "Yes")
			.openProject()
			.threeDView()
			.snapshot3D("3D", 0)
			.snapshot3D("3D", 1)
			.closePlanner()
			.goToMyProjects()
			.openOwnProject(0, "Duplicate")
			.sharemedia("Screenshots",false, 1)
			.sharemediaFullscreen("Screenshots",false, 1)
			.deleteMedia("Screenshots",1,false, "No")
			.deleteMedia("Screenshots",1,false, "Yes")
			.deleteFullScreenMedia("Screenshots",1,false, "Yes")
			.deleteFullScreenMedia("Screenshots",1,false, "No")
			.logout();
	}
	
	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class,priority=2)
	public void shareAndDeleteNewMedia(SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToMyProjects()
			.openOwnProject(0, "INL")
			.sharemedia("Realistic images",false, 2)
			.sharemediaFullscreen("Realistic images",false, 2)
			.logout();	
	}
	
	
}
