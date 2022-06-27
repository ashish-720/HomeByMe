package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.ProjectPage;
import hbm.web.pageobject.UserHomePage;

@Test
public class DuplicateGalleryProject extends Browser {

	@Test(dataProvider = "loginData", dataProviderClass = SignUpData.class)
	public void duplicateGalleryProject(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
//				.goToGallery().filterProjects("Trending now").filterProjects("Views")
//				.verifyProjectDetails("ski23_jun17_CR", "shubham.khisti", "285 m\u00B2", "13 rooms", "3 floors").openOthersProject("ski23_jun17_CR")
		driver.get("https://preprod-home.by.me/en/project/shubham.khisti/ski23jun17cr");
		ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);
		projectPage.verifyProjectName("ski23_jun17_CR")
				.duplicateGalleryProject("Copy of ski23_jun17_CR")
				.verifyOverviewTabPage("OWN", 3, 13, "286 m\u00B2", 1, 0, 44, 0)
				.verifyProductsTab(44, "5,3,7,2,7,7,7,1,4,6,1,2,5")
				.verifyImagesTab("OWN", 0, 0, 0,false);
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.logout();
	}

	@Test(dataProvider = "loginData", dataProviderClass = SignUpData.class, dependsOnMethods = "duplicateGalleryProject")
	public void verifyDuplicatedProject(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
				.goToMyProjects()
				.openOwnProject(0, "Copy of ski23_jun17_CR")
				.verifyProjectName("Copy of ski23_jun17_CR");
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.logout();
	}
}
