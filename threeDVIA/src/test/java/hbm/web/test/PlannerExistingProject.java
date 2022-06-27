package hbm.web.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class PlannerExistingProject extends Browser {
		
	public void landingPageTest(SignUpData signUpData) {
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.checkLinksLayout();
		landingPage.loginExistingUser(signUpData);
	}
	
	@Test(dependsOnMethods = { "landingPageTest" })
	public void login(){		
		UserHomePage homePage = PageFactory.initElements(driver, UserHomePage.class);
		homePage.editLatestProject().twoDView();
//		driver.findElement(By.cssSelector(".link-newProject-overlay")).click();
//		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
//		driver.findElement(By.id("nextStep1")).click();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.addARoom(2, "20", "Bedroom");
	}

}
