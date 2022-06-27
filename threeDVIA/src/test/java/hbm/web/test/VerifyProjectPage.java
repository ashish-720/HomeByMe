package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.ProjectPage;

@Test
public class VerifyProjectPage extends Browser{

	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class)
	public void verifyProjectPage(SignUpData signUpData){		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
			.goToMyProjects()	
			.openOwnProject(0, "Duplicate")
			.verifyProjectName("Duplicate")
			.verifyOverviewTabPage("OWN",1, 3, "39 m\u00B2", 0, 1,2,40)
			.verifyRoomsTab("Guest room-30 m�,Kitchen-5 m�,Bathroom-2 m�")
			.verifyProductsTab(2, "2")
			.verifyImagesTab("OWN",4,36,1,false)
			.editDescription("House", "Dream", "description to be added")
			.editTags("INL,Automation")
		;
		
//  Verify project page of other user opened from link
		driver.get("https://preprod-home.by.me/en/project/shubham.khisti/ski23jun17cr");
		ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);
		projectPage.verifyProjectName("ski23_jun17_CR")
			.verifyOverviewTabPage("OTHERS", 3, 13, "286 m\u00B2", 1, 0, 44, 22)	
			.verifyRoomsTab("room 8-32 m�,Kitchen-10 m�,Dining room-10 m�,Basement-16 m�,Bedroom-10 m�,room 5-10 m�,Living room-19 m�,Guest room-11 m�,Office-11 m�,Hallway-16 m�,Entertainment room-38 m�,room 9-66 m�,room 4-32 m�")
			.verifyProductsTab(44, "5,3,7,2,7,7,7,1,4,6,1,2,5")
			.verifyImagesTab("OTHERS",2,18,2,false)
			.logout();	
	}
	
//	Verify project page by logging out
//	@Test(dataProvider = "loginData", dataProviderClass=SignUpData.class,dependsOnMethods = "verifyProjectPage")
//	public void verifyProjectPage1(SignUpData signUpData){		
//		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
//		homepage.loginExistingUser(signUpData);			
//		UserHomePage userHomePage = PageFactory.initElements(driver, UserHomePage.class);		
//		userHomePage.goToMyProjects();	
//		MyProjects myProjects=PageFactory.initElements(driver, MyProjects.class);
//		myProjects.openOwnProject(0, "Duplicate")
//		.logoutAndReopenProjectPage()
//		.verifyOverviewTabPage("Others",1, 3, "39 m\u00B2", 0, 1,2,16,false)
//		.verifyProductsTab(2, "2")
//		.verifyImagesTab("Others",4,36,1,false);
//	}
}

