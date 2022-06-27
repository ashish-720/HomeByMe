package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;

@Test
public class VerifyRS4toNonRS4 extends Browser {

	@Test(priority=1)
	public void verifyRS4toNonRS4WithoutLogin() {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.goToMagazine()
			.goToInspiration()
			.verifyPageTitle()
			.goToMagazine()
			.goToOffers()
			.verifyPageTitle()
			.goToMagazine()
			.goToLandingPage()
			;
		}
	
	@Test(dataProvider = "loginData", dataProviderClass = SignUpData.class,priority=2)
	public void verifyRS4toNonRS4WithLogin(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToMagazine()
			.clickHBMLogo()
			.verifyPageTitle()
			.goToMagazine()
			.goToInspiration()
			.verifyPageTitle()
			.goToMagazine()
			.goToOffers()
			.verifyPageTitle()
			.goToMagazine()
			.goToMyProjects()
			.verifyPageTitle()
			.goToMagazine()
			.goToAccountPage()
			.verifyPageTitle()
			.goToMagazine()
			.goToMyProfile()
			.verifyPageTitle()
			.goToMagazine()
			.goToStaffPick()
			.verifyPageTitle()
			.goToMagazine()
			.goToBackOffice()
			.verifyPageTitle()
			.clickBackToSite()
			.goToMagazine()
			.goToMyCollections()
			.verifyPageTitle()
			.goToMagazine()
			.logout()
			.verifyPageTitle()
		;
	}
}
