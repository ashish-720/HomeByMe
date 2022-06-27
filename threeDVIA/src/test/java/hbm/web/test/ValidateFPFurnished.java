package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.NewProjectData;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.BackOffice;
import hbm.web.pageobject.LandingPage;

@Test
public class ValidateFPFurnished extends Browser{

	@Test(dataProvider = "backOffice", dataProviderClass = SignUpData.class)
	public void validateFloorPlanFurnished(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
		.goToBackOffice()
		.validateNewFPRequest("FP2", "FPFurnished1");
	}

	@Test(dataProvider = "projectData", dataProviderClass = NewProjectData.class, dependsOnMethods = "validateFloorPlanFurnished")
	public void fpProjectBackOffice(NewProjectData newProjectData) {
		BackOffice backOffice = PageFactory.initElements(driver, BackOffice.class);
		backOffice.createProject(newProjectData, 1, "40", "Guest room")
		.openProjectFromBackoffice();
	}

	@Test(dataProvider = "backOffice", dataProviderClass = SignUpData.class, dependsOnMethods = "fpProjectBackOffice")
	public void deliverCreatedProject(SignUpData signUpData) {
		BackOffice backOffice = PageFactory.initElements(driver, BackOffice.class);
		backOffice.deliverProject("FP2", "FPFurnished1");
	}
}
