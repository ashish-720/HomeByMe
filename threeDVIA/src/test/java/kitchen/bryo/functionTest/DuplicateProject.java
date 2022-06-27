package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class DuplicateProject extends Browser {

//	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
//	public void duplicateProjectFromDetailsPage(SignUpData signUpData) {
//		
//		StartNow start = PageFactory.initElements(driver, StartNow.class);
//		start.startDemo("en-GB")
//		.login(signUpData)
//		.openMyProjectList()
//		.duplicateProjectFromDetailsPage("ODT Project",  "copy of Duplicate ODT",
//				"duplicated project from project details page")
//		.verifyDuplicatedProOnDetailsPage(4, 9)
//		.goToMyProjects()
//		.verifyDuplicateDelete("Duplicate")
//		.closeMyProjects()
//		.logout();
//	}
//
//	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class, dependsOnMethods="duplicateProjectFromDetailsPage")
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void duplicateProjectFromMyProjects(SignUpData signUpData) {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.login(signUpData)
		.openMyProjectList()
		.searchProject("ODT Project")
		.duplicateProject("ODT Project", 0)
		
//		.duplicateProjectFromMyProjects("ODT Project",  "copy of Duplicate ODT",
//				"duplicated project from my projects page")
//		.verifyDuplicatedProOnDetailsPage(4, 9)
//		.goToMyProjects()
		.verifyDuplicateDelete("Duplicate")
//		.openProjectFromMyProjects("copy of Duplicate ODT")
		.openProject(0, "ODT Project (copy)")
		.verifyProductOnReOpen(287, -234, "W10001");
//		.closePlanner();
//		.logout();
	}

}