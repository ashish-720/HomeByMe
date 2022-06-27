package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.ProjectPageMediaTab;

@Test
public class VerifyMediaPageAlpha extends Browser {

	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class)
	public void LandingPage(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData).goToMyProjects().openOwnProject(0, "ski23_aug11_ff").goToImagesTab();
		ProjectPageMediaTab projectPageMediaTab = PageFactory.initElements(driver, ProjectPageMediaTab.class);
		projectPageMediaTab.verifyMediaPageAlpha("own",8,20,1,false)
		.sharemedia("Screenshots", false, 1).sharemediaFullscreen("Screenshots", false, 1)
		;
	}
}