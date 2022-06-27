package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.ProjectPage;
import hbm.web.pageobject.UserHomePage;


public class SaveGalleryProject extends Browser {

	@Test(dataProvider = "hmsLoginData", dataProviderClass = SignUpData.class)
	public void saveProjectFromFeed(SignUpData signUpData) {
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);	
		landingPage.goToInspiration()
			.applyFilter("All", "Living Room", "Contemporary", "Black", "Maisons du monde")
			.openImageAtIndex(0) 
			.openProject()
			.threeDView()
			.twoDView()
			.saveGalleryProject(signUpData, "ODTSavedFromFeed-" + UtilHBM.getDate(0, "ddMMyyyy"))
			.closePlanner()
			.goToMyProjects()
			.closeDiscountPopupIfAvailable()
			.openOwnProject(1)
			.verifyProjectName("ODTSavedFromFeed-" + UtilHBM.getDate(0, "ddMMyyyy"))
			.verifyOverviewTabPage("OWN", 2, 5, "48 m\u00B2", 1, 0, 20, 0)
			.verifyRoomsTab("Living room-8 m�,Bedroom-10 m�,Entertainment room-6 m�,Office-5 m�,Kid�s room-16 m�")
			.verifyProductsTab(20, "9,4,2,5,2")
			.verifyImagesTab("OWN", 0, 0, 0, false);
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.logout();
	}
	
	@Test(dataProvider = "hmsLoginData", dataProviderClass = SignUpData.class, dependsOnMethods = "saveProjectFromFeed")
	public void saveOtherUsersProject(SignUpData signUpData) {
		driver.get("https://preprod-home.by.me/en/project/shubham.khisti/ski23jun17cr");
		ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);
		projectPage.verifyProjectName("ski23_jun17_CR")
			.openProject()
			.threeDView()
			.twoDView()
			.saveGalleryProject(signUpData, "ODTOtherUsersProject-" + UtilHBM.getDate(0, "ddMMyyyy"))
			.closePlanner()
			.goToMyProjects()
			.closeDiscountPopupIfAvailable()
			.openOwnProject(1)
			.verifyProjectName( "ODTOtherUsersProject-" + UtilHBM.getDate(0, "ddMMyyyy"))
			.verifyOverviewTabPage("OWN", 3, 13, "286 m\u00B2", 1, 0, 44, 0)	
			.verifyRoomsTab("room 8-32 m�,Kitchen-10 m�,Dining room-10 m�,Basement-16 m�,Bedroom-10 m�,room 5-10 m�,Living room-19 m�,Guest room-11 m�,Office-11 m�,Hallway-16 m�,Entertainment room-38 m�,room 9-66 m�,room 4-32 m�")
			.verifyProductsTab(44, "5,3,7,2,7,7,7,1,4,6,1,2,5")
			.verifyImagesTab("OWN", 0, 0, 0,false);
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.logout();
	}
}
