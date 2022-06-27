package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

	@Test
	public class RejectFPRequest extends Browser{		
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
			
		@Test(dataProvider="backOffice", dataProviderClass=SignUpData.class,dependsOnMethods = "buyFloorplanUnfurnished")
		public void rejectFPRequest(SignUpData signUpData){
			LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
			homepage.loginExistingUser(signUpData)
				.goToBackOffice()
				.dates()
				.rejectFloorPlanRequest("FP4", "FPUnfurnished1");	
		}
}
