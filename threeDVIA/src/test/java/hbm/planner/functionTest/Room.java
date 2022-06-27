package hbm.planner.functionTest;

import hbm.planner.dataobject.NewProjectData;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class Room extends Browser{
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void loginRoom(SignUpData signUpData ){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);		
	}
	
	@Test(dataProvider="projectDataODT", dataProviderClass=NewProjectData.class, dependsOnMethods={"loginRoom"})
	public void createRoom(NewProjectData newProjectData){
		UserHomePage userHomePage = PageFactory.initElements(driver, UserHomePage.class);
		userHomePage.createEmptyProject(newProjectData);
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.addARoom(2, "25", "Guest room").threeDView().save().closePlanner();		
	}

}
