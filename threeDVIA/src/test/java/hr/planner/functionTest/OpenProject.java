package hr.planner.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;

@Test
public class OpenProject extends Browser{

	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void openProject(SignUpData signUpData) {
	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
		
		home.login(signUpData)
		.myProjects()
		.searchProjectName("HR-ODT")
		.openProject("HR-ODT", 0)
		.verifyProjectName("HR-ODT");
	}
	
}
