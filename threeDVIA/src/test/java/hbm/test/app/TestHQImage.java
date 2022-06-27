package hbm.test.app;

import java.util.List;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestHQImage extends Browser {
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void testHQ(SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
		UserHomePage useHome = PageFactory.initElements(driver, UserHomePage.class);
		useHome.editLatestProject().twoDView();		
		List<WebElement> roomList = driver.findElements(By.cssSelector("input[placeholder='room']"));
		UtilHBM.waitExplicitClickable(driver, roomList.get(1));
		roomList.get(1).click();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.closePlanner();			
		useHome.logout();
		homepage.loginExistingUser(signUpData);
		useHome.logout();		
	}

}
