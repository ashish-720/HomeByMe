package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.ProjectPage;
import hbm.web.pageobject.UserHomePage;

public class LikeProject extends Browser{
	
	@Test(dataProvider = "emailLogin", dataProviderClass = SignUpData.class)
	public void verifyAccountLaCarte(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
//		.goToGallery().openOthersProject("samm's house");
		driver.get("https://preprod-home.by.me/en/project/shubham.khisti/ski23jun17cr");
		ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);
		projectPage.verifyProjectName("ski23_jun17_CR")
//		.likeOperation()
		;
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.logout();	
	}
}
