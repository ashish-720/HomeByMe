package kitchen.bryo.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import hbm.web.pageobject.UserHomePage;
import kitchen.bryo.pageObject.MakeItHappen;
import kitchen.bryo.pageObject.StartNow;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ExportProject extends Browser {
	
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void exportProject(SignUpData signUpData) {
		StartNow start = PageFactory.initElements(driver, StartNow.class);
		start.startDemo("en-GB")
		.login(signUpData)
		.openMyProjectList()
		.searchProject("ODT Project")
//		.openProject()
		.openProject(0, "ODT Project")
		.step4()
		.verifyStep4()
		.verifyPriceInStep4("12 242,00");		
	}
	
	@Test(dataProvider = "hbmProdloginData", dataProviderClass = SignUpData.class,dependsOnMethods = "exportProject")
	public void exportToHBM(SignUpData signUpData) {
		MakeItHappen summary=PageFactory.initElements(driver, MakeItHappen.class);
		summary.exportProject()
		.clickHBMConnectLoginButton()
		.loginExitingUser(signUpData)
		.exportToHBM();
	}
	
	@Test(dataProvider = "hbmProdloginData", dataProviderClass = SignUpData.class,dependsOnMethods = "exportToHBM")
	public void verifyExportInHBM(SignUpData signUpData) {
		Browser.openUrl(driver, "https://home.by.me/en/");
		try {
			driver.findElement(By.cssSelector("#footer_tc_privacy_button_3")).click();
		} catch (Exception e) {
			UtilHBM.reportWarning("Accept cookies message not displayed");
			System.out.println("Accept cookies message not displayed");
		}
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.editLatestProject()
		.verifyProjectName("ODT Project")
		.verifyProjectDetails("ODT Project", "Apartment", "Renovation", 1, 1, 20.07)
		.addAProductFromBrandsDev("CHAISE COMO", 180, 50)
		.save()
		.animate(-20, -20)
		.snapshot3D("Project from Bryo", 0)
		.closePlanner()
		.goToMyProjects()
		.openOwnProject(1)
//		.verifyOverviewTabPage("own", 1, 1, "20 m\u00B2", 0, 0, 1, 1)
		.openProject()
		.verifyLogoLinkDev(180, 20)
		.animate(-20, -20)
		.closePlanner()
		.logout();		
	}	
}