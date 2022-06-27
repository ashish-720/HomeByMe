package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;

@Test
public class VerifyInspirationPage extends Browser {

	@Test()
	public void verifyFilterByRoomCategories() {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.goToInspiration()
			.verifyFilters("Staff picks","All rooms", "NA", "NA", "NA")
			.clearFilters()
			.filterByRoomCategory("Dining room")
			.checkFilterResults(true, "All", "Dining room", "NA", "NA", "NA")
			.clickHbmLogo()
			;
	}
	
	@Test(dependsOnMethods = "verifyFilterByRoomCategories")
	public void verifyFilters() {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.goToInspiration()
			.applyFilter("All", "Living Room", "Contemporary", "Black", "Maisons du monde")
			.verifyFilters("All", "Living Room", "Contemporary", "Black", "Maisons du monde")
			.checkFilterResults(true, "All", "Living Room", "Contemporary", "Black", "Maisons du monde")
			.clickHbmLogo();
	}

	@Test(dependsOnMethods = "verifyFilters")
	public void verifyFiltersNoResults() {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.goToInspiration()
			.clearFilters()
			.applyFilter("Staff picks", "Living Room", "Contemporary", "Black", "Castorama")
			.verifyFilters("Staff picks", "Living Room", "Contemporary", "Black", "Castorama")
			.checkFilterResults(false, "Staff picks", "Living Room", "Contemporary", "Black", "Castorama")
			.clearFilters()
			.verifyFilters("All", "All rooms", "NA", "NA", "NA")
			.checkFilterResults(true, "All", "All rooms", "NA", "NA", "NA")
			.clickHbmLogo();
	}
	
	@Test(dataProvider = "loginData", dataProviderClass = SignUpData.class,dependsOnMethods = "verifyFiltersNoResults")
	public void verifyFeedPage(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToInspiration()
			.verifyFeedPage()
			.logout();
	}

	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class,dependsOnMethods = "verifyFeedPage")
	public void addToStaffPicks(SignUpData signUpData) {		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToInspiration()
			.clearFilters()
			.addToStaffPicks()
			.logout();
		;	
	}
}
