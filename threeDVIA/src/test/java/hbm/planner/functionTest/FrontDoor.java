package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.MyProjects;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class FrontDoor extends Browser{		
	
	@Test(dataProvider = "loginData", dataProviderClass = SignUpData.class)
	public void frontDoorTest(SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);	
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.clickProjects();
		MyProjects projects = PageFactory.initElements(driver, MyProjects.class);
		projects.editProject(1);		
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.addAProductFromInfoDev("LES EXCLUSIVES - ONDE", 300, 150)
		.editDoorWinPropertiesDev(300, 150, "2000mm", "1000mm", "10", 1, 1)
		.verifyDoorWinPropertiesDev(300, 150, "200.0 cm", "100.0 cm", "10.0 cm")
		.addAProductDev("4870", -300, 150)
		.editDoorWinPropertiesDev(-300, 150, "200", "100", "10", 1, 1)
		.editTwoDWallDimensionDev(0, 300, "581 cm", "650", "left")
		.verify2DWallPropertiesDev(0, 300, "10 cm", "250 cm", "650 cm", 1, "", "")
		.verifyDoorWinPropertiesDev(-370, 150, "200.0 cm", "100.0 cm", "10.0 cm")
		.clickInPlanner(-355, 70)
		.dragNDrop(-355, 68, -348, -50)// stuck 
		;				
	}	
}
