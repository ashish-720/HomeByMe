package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.ProjectPage;
import hbm.web.pageobject.UserHomePage;

@Test
public class VerifyProjectPageInDiffLanguages extends Browser {

	@Test(dataProvider = "loginData", dataProviderClass = SignUpData.class)
	public void verifyProjectPageInDiffLanguages(SignUpData signUpData) {
//		Project page of own project in different languages with login  
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
		ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);
		Browser.openUrl(driver, "https://preprod-home.by.me/fr/projet/3dplm/inlautotestproject-1416");
		projectPage.verifyProjectName("Duplicate");
		Browser.openUrl(driver, "https://preprod-home.by.me/de/projekt/3dplm/inlautotestproject-1416");
		projectPage.verifyProjectName("Duplicate");
		Browser.openUrl(driver, "https://preprod-home.by.me/es/proyecto/3dplm/inlautotestproject-1416");
		projectPage.verifyProjectName("Duplicate");
		Browser.openUrl(driver, "https://preprod-home.by.me/en/project/3dplm/inlautotestproject-1416");
		projectPage.verifyProjectName("Duplicate");
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.logout();
//		Project page of others project in different languages without login 
		Browser.openUrl(driver, "https://preprod-home.by.me/en/project/shubham.khisti/ski23jun17cr");
		projectPage.verifyProjectName("ski23_jun17_CR");
		Browser.openUrl(driver, "https://preprod-home.by.me/fr/projet/shubham.khisti/ski23jun17cr");
		projectPage.verifyProjectName("ski23_jun17_CR");
		Browser.openUrl(driver, "https://preprod-home.by.me/de/projekt/shubham.khisti/ski23jun17cr");
		projectPage.verifyProjectName("ski23_jun17_CR");
		Browser.openUrl(driver, "https://preprod-home.by.me/es/proyecto/shubham.khisti/ski23jun17cr");
		projectPage.verifyProjectName("ski23_jun17_CR");
	}
}
