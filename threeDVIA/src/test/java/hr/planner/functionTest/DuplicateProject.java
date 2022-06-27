package hr.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class DuplicateProject extends Browser {

	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void duplicateProject(SignUpData signUpData) {
	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
		
		home.login(signUpData)
		.myProjects()
		.searchProjectName("Duplicate-HR")
		.duplicateProject("Duplicate-HR", 0)
		.verifyDuplicateProjectName("Duplicate-HR (copy)", 0)		
		.openProjectPage("Duplicate-HR (copy)", 0)
		.duplicateProjectFromProjectPage()
		.verifyProjectPageName("Duplicate-HR (copy) (copy)")
		
		;

	}
}
