package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;

@Test
public class UpgradeRenderingImage extends Browser{
	
	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class,priority=1)
	public void upgradeOldRenderingImage(SignUpData signUpData){	
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToMyProjects()
			.openOwnProject(0, "Duplicate")
			.goToImagesTab()
			.upgradeRenderingimage()
			.logout();	
	}

	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class,priority=2)
	public void upgradeNewRenderingImage(SignUpData signUpData){		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToMyProjects()
			.openOwnProject(0, "INL")
			.goToImagesTab()
			.upgradeRenderingimage()
			.logout();
	}
	

}