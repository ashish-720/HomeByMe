package hr.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class OpenProjectPage extends Browser {

	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void openProjectPage(SignUpData signUpData) {
	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
		
		home.login(signUpData)
		.myProjects()
		.searchProjectName("HR-ODT")
		.openProjectPage("HR-ODT", 0)
		.verifyProjectPageName("HR-ODT")
		;
	}
}
