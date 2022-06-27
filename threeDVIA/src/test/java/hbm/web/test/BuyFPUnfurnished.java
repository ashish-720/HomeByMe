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
public class BuyFPUnfurnished extends Browser{

	@Test(dataProvider = "hmsLoginData", dataProviderClass=SignUpData.class)
	public void buyFloorplanUnfurnished(SignUpData signUpData) {		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToOffers()
			.openServicesTab()
			.clickDiscoverFPS()
			.buyFloorPlanServices("FP3")
			.editFPInformation("FP4")	
			.makePayment("2", "FPUnfurnished1", "FP4", "No");
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.logout();		
	}	
	
	@Test(dataProvider = "backOffice", dataProviderClass = SignUpData.class, dependsOnMethods = "buyFloorplanUnfurnished")
	public void validateFPSRequestUnfurnished(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
		.goToBackOffice()
		.validateNewFPRequest("FP4", "FPUnfurnished1");
	}

	@Test(dataProvider = "projectData", dataProviderClass = NewProjectData.class, dependsOnMethods = "validateFPSRequestUnfurnished")
	public void createUnfurninshedProjectBackOffice(NewProjectData newProjectData) {
		BackOffice backOffice = PageFactory.initElements(driver, BackOffice.class);
		backOffice.createProject(newProjectData, 1, "40", "Guest room")
		.openProjectFromBackoffice();
	}

	@Test(dataProvider = "backOffice", dataProviderClass = SignUpData.class, dependsOnMethods = "createUnfurninshedProjectBackOffice")
	public void deliverCreatedUnfurnishedProject(SignUpData signUpData)  {
		BackOffice backOffice = PageFactory.initElements(driver, BackOffice.class);
		backOffice.deliverProject("FP4", "FPUnfurnished1");
	}
}
