package hbm.web.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class NeedMoreFPInfo extends Browser {
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
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.logout();		
	}	

	@Test(dataProvider = "backOffice", dataProviderClass = SignUpData.class,dependsOnMethods = "buyFloorplanFurnished")
	public void needMoreFPInformation(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToBackOffice()
			.needMoreFPInformation("FP2", "FPFurnished1");
	}
}

