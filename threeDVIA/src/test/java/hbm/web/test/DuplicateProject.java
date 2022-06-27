package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.MyProjects;
import hbm.web.pageobject.UserHomePage;

@Test
public class DuplicateProject extends Browser{
	
	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class)
	public void verifyLatestProjectInUserhomePage(SignUpData signUpData){		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToMyProjects()
			.openOwnProject(0, "Duplicate")
			.verifyProjectName("Duplicate")
			.editTags("AddingToTop")
			.clickHbmLogo()
			.verifyFirstProject("Duplicate", true);
		}
	
	@Test(dependsOnMethods="verifyLatestProjectInUserhomePage")
	public void duplicateProjectUserHomePage() {
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.duplicateProject("Duplicate")
			.verifyOverviewTabPage("OWN", 1, 3, "39 m\u00B2", 0, 1, 2, 0)
			.verifyRoomsTab("Guest room-30 m²,Kitchen-5 m²,Bathroom-2 m²")
			.verifyProductsTab(2, "2")
			.verifyImagesTab("OWN", 0, 0, 0,false)
			.goToMyProjects()
			.verifyFirstProject("Copy of Duplicate", true)
			;
	}

	@Test(dependsOnMethods="duplicateProjectUserHomePage")
	public void duplicateProjectMyProjects() {
		MyProjects myProjects = PageFactory.initElements(driver, MyProjects.class);
		myProjects.duplicateProject("Duplicate")
			.verifyOverviewTabPage("OWN", 1, 3, "39 m\u00B2", 0, 1, 2, 0)
			.verifyRoomsTab("Guest room-30 m²,Kitchen-5 m²,Bathroom-2 m²")
			.verifyProductsTab(2, "2")
			.verifyImagesTab("OWN", 0, 0, 0, false)
			.goToMyProjects()
			.verifyFirstProject("Copy of Duplicate", true)
			;
	}
	
	@Test(dependsOnMethods="duplicateProjectMyProjects")
	public void duplicateProject(){		
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.goToMyProjects()
			.openOwnProject(0, "Duplicate")
			.duplicateOwnProject("Copy of Duplicate")
			.verifyOverviewTabPage("OWN",1, 3, "39 m\u00B2", 0, 1,2,0)
			.verifyRoomsTab("Guest room-30 m²,Kitchen-5 m²,Bathroom-2 m²")
			.verifyProductsTab(2, "2")
			.verifyImagesTab("OWN", 0, 0, 0, false)
			.goToMyProjects()
			.verifyFirstProject("Copy of Duplicate", true)
			.logout();
	}
}