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
public class BuyFPFurnished extends Browser{

	@Test(dataProvider = "hmsLoginData", dataProviderClass=SignUpData.class)
	public void buyFloorplanFurnished(SignUpData signUpData){		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToOffers()
			.openServicesTab()
			.clickDiscoverFPS()
			.buyFloorPlanServicesSticky("FP1")
			.editFPInformation("FP2")
			.makePayment("2", "FPFurnished1", "FP2", "No");
//			.makePaymentNew("2", "FPFurnished1", "FP2", "No")
			UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
			home.logout();			
	}	
	
	@Test(dataProvider = "backOffice", dataProviderClass = SignUpData.class,dependsOnMethods = "buyFloorplanFurnished")
	public void validateFPSRequestFurnished(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToBackOffice()
			.validateNewFPRequest("FP2", "FPFurnished1");
	}

	@Test(dataProvider = "projectData", dataProviderClass = NewProjectData.class, dependsOnMethods = "validateFPSRequestFurnished")
	public void createFurninshedProjectBackOffice(NewProjectData newProjectData) {
		BackOffice backOffice = PageFactory.initElements(driver, BackOffice.class);
		backOffice.createProject(newProjectData, 1, "40", "Guest room")
			.openProjectFromBackoffice();
	}

	@Test(dataProvider = "backOffice", dataProviderClass = SignUpData.class, dependsOnMethods = "createFurninshedProjectBackOffice")
	public void deliverCreatedFurnishedProject(SignUpData signUpData) {
		BackOffice backOffice = PageFactory.initElements(driver, BackOffice.class);
		backOffice.deliverProject("FP2", "FPFurnished1");
	}
}
