package hr.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.UserHomePage;
import hr.planner.pageObject.HomePlanner;
import hr.web.pageObject.LandingPageHR;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


	@Test
	public class ExportToHBM extends Browser {
		
		@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
		public void bryoLogin(SignUpData signUpData) {
		
			LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
		
			home.login(signUpData)
			.myProjects()
			.searchProjectName("Duplicate-HR")
			.openProject("Duplicate-HR", 0)
			.verifyProjectName("Duplicate-HR")
			;

			
					
		}
		@Test(dataProvider = "hbmProdloginData", dataProviderClass = SignUpData.class)
		public void homeByMeProjectImport(SignUpData signUpData) {	
			HomePlanner home = PageFactory.initElements(driver, HomePlanner.class);	
			home.export()
			.clickHBMConnectLoginButton()
			.loginExitingUser(signUpData)
			.exportToHBM()
			;
					
		}
		

		@Test(dataProvider = "hbmProdloginData", dataProviderClass = SignUpData.class)
		public void verifyExportProjectInHBM(SignUpData signUpData) {
			Browser.openUrl(driver, "https://home.by.me/en/");
			UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
			home.editLatestProject()
			.verifyProjectName("Duplicate-HR")
			.verifyProjectDetails("Duplicate-HR", "Apartment", "Renovation", 1, 1, 20.07)
			.addAProductDev("Chair phantom", -40, 50)
			.save()
			.snapshot3D("Project from Bryo", 0)
			.closePlanner()
			.goToMyProjects()
			.openOwnProject(1)
			//.verifyOverviewTabPage("own", 1, 1, "20 m\u00B2", 0, 0, 1, 1)
			.openProject()
			.verifyLogoLinkDev(-43, 20)
			.closePlanner()
			.logout();		
		}
		
	}