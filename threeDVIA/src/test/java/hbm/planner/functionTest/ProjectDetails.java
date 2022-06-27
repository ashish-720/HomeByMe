package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class ProjectDetails extends Browser {
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void projectDetails(SignUpData signUpData){
		LandingPage homePage = PageFactory.initElements(driver, LandingPage.class);
		homePage.loginExistingUser(signUpData)
		.editLatestProject()
		.twoDView()
		.changeProjectDetails("INL", "Apartment", "Dreamed project")
		.closePlanner()
		.editLatestProject()
		.verifyProjectDetails("INL", "Apartment", "Dreamed project", 1, 1, 25);		
	}

}
