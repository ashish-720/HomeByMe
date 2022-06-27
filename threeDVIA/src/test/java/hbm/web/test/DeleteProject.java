package hbm.web.test;	

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class DeleteProject extends Browser{
	
//	@Test(dataProvider="loginData", dataProviderClass = SignUpData.class)
//	public void deleteProjectByName(SignUpData signUpData){
//		LandingPage home = PageFactory.initElements(driver, LandingPage.class);
//		home.loginExistingUser(signUpData)
//			.goToMyProjects()
//			.openOwnProject(3, "Duplicate1")
//			.verifyProjectName("Duplicate1")
//			.deleteProject()
//			.verifyUserHomePage(3)	
//			.logout();		
//	}
	@Test(dataProvider="loginData", dataProviderClass = SignUpData.class, priority=1)
	public void deleteProject(SignUpData signUpData){
		LandingPage home = PageFactory.initElements(driver, LandingPage.class);
		home.loginExistingUser(signUpData)	
			.goToMyProjects()
			.openOwnProject(10, "INL")
			.deleteProject()
			.verifyPageTitle()
			.goToMyProjects()
			.openOwnProject(10, "GalleryProject")
			.deleteProject()
			.verifyPageTitle()
			.goToMyProjects()
			.openOwnProject(5, "Annotations")
			.deleteProject()
			.verifyPageTitle();
		for (int i = 0; i < 3; i++) {
			UserHomePage userHomePage = PageFactory.initElements(driver, UserHomePage.class);
			userHomePage.goToMyProjects()
				.openOwnProject(10, "Copy of Duplicate")
				.deleteProject()
				.verifyPageTitle();
			System.out.println(i);
		}
		UserHomePage userHomePage = PageFactory.initElements(driver, UserHomePage.class);
		userHomePage.logout();
	}
	
	@Test(dataProvider="hmsLoginData", dataProviderClass = SignUpData.class, priority=2)
	public void deleteProjectIDS(SignUpData signUpData){
		LandingPage home = PageFactory.initElements(driver, LandingPage.class);
		home.loginExistingUser(signUpData)
			.goToMyProjects()
			.openOwnProject(5, "GalleryProject")
			.deleteProject()
			.verifyPageTitle()
			.goToMyProjects()
			.openOwnProject(5, "INL_AUTO_TEST_PROJECT")
			.deleteProject()
			.verifyPageTitle()
			.goToMyProjects()
			.openOwnProject(5, "Partner embedded Project")
			.deleteProject()
			.verifyPageTitle()
			.goToMyProjects()
			.openOwnProject(4, "IDS1 copy")
			.deleteProject()
			.verifyPageTitle()
			.goToMyProjects()
			.openOwnProject(4, "IDS2 copy")
			.deleteProject()
			.verifyPageTitle()
			.logout();
	}
}
