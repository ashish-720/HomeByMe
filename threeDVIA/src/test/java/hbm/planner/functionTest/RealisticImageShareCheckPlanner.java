package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class RealisticImageShareCheckPlanner extends Browser {
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void realisticImageShareCheckPlanner(SignUpData signUpData){
		
		LandingPage homePage = PageFactory.initElements(driver, LandingPage.class);
		homePage
		.loginExistingUser(signUpData)		
		.goToMyProjects().openOwnProject(0, "Duplicate").openProject()
		.myImages()
		.checkImageCount(36, 0, 5)
		.shareMediaFrmPreview(2, "snapshot", 5)
		.shareMediaFrmPreview(1, "realistic", 36)
		.shareMediaFrmPreview(0, "360", 1)
		.closeMyImages();
	}
}
