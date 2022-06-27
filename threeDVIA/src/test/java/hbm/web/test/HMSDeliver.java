package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.NewProjectData;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.BackOffice;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

@Test
public class HMSDeliver extends Browser{

	@Test(dataProvider = "backOffice", dataProviderClass = SignUpData.class)
	public void hmsValidate(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData).goToBackOffice().dates().bOValidateHMS("HMS2", "HMSOrder2");
	}

	@Test(dataProvider = "projectData", dataProviderClass = NewProjectData.class, dependsOnMethods = "hmsValidate")
	public void hmsDeliver(NewProjectData newProjectData) {
		BackOffice backOffice = PageFactory.initElements(driver, BackOffice.class);
		backOffice.createProject(newProjectData, 1, "40", "Guest room").deliverHMS("HMS2", "HMSOrder2");
	}
}
