package hr.planner.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;

@Test
public class NewProject extends Browser {
	
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void openNewProject(SignUpData signUpData) {
	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
		home.login(signUpData)
		.myProjects()
		.newProject()
		.verifyProjectName("PROJECT NAME");
	}
	
}
