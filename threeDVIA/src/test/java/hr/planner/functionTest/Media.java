package hr.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class Media extends Browser{

	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void myMedia(SignUpData signUpData) {
	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
		
		home.login(signUpData)
		.myProjects()
		.searchProjectName("Duplicate-HR")
		.openProject("Duplicate-HR", 0)
		.verifyProjectName("Duplicate-HR")
		.projectOverview()
		.projectName("Duplicate-HR", "£2,844.00")
		.myPicture()
		.priceDetail()
		.projectOverview()
		.close()
		.myMedia()
		.projectName("Duplicate-HR", "£2,844.00")
		.close()
		;
	}
	
}