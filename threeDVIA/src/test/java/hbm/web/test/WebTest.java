package hbm.web.test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import hbm.web.pageobject.Academy;
import hbm.web.pageobject.Gallery;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.Login;
import hbm.web.pageobject.LoginFacebook;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

	@Test
public class WebTest extends Browser{
	
	@Test	
	public void testLandingPage(){		
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.verifyPage();		
		Verification.VerifyEquals("Landing Page title not correct", driver.getTitle(), "Free and on line 3D home design planner - Homebyme");		
		UtilHBM.verifyLinks(driver, "LandingPage");
	}
	
	@Test(dependsOnMethods = {"testLandingPage"})
	public void checkGallaryPage(){
		Gallery gallery = PageFactory.initElements(driver, Gallery.class);
		gallery.checkFeaturedProject();
	}
	
	@Test(dependsOnMethods = {"checkGallaryPage"})
	public void checkAcademyPage(){
		Academy academy = PageFactory.initElements(driver, Academy.class);
		academy.checkFeaturedArticles();
		academy.checkAspectsOfInteriorDesign();
	}
	
	@Test(dependsOnMethods = {"checkGallaryPage"}, dataProvider = "loginData", dataProviderClass = SignUpData.class)
	public void testLogin (SignUpData signUpData){
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		landingPage.signUpExistingUser(signUpData);		
	}
	
	@Test(dependsOnMethods = {"testLogin"})
	public void testLogout(){
		UserHomePage homepage = PageFactory.initElements(driver, UserHomePage.class);
		homepage.logout();		
	}
	
	@Test(dependsOnMethods = {"testLogout"}, dataProvider = "loginData", dataProviderClass = SignUpData.class)
	public void testFacebookLogin(SignUpData signUpData){
		LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
		String currentWindowHandle = driver.getWindowHandle();
		landingPage.loginExistingUser(signUpData);
		UtilHBM.pageCapture(driver, "LoginPanel");
		Login login = PageFactory.initElements(driver, Login.class);
		login.loginUsingFB(signUpData);
		for (String winHandle: driver.getWindowHandles()){			
			driver.switchTo().window(winHandle);
		}
		UtilHBM.pageCapture(driver, "FacebookLogin");
		LoginFacebook facebook = PageFactory.initElements(driver, LoginFacebook.class);
		facebook.login(signUpData);
		driver.switchTo().window(currentWindowHandle);
	}
	
	@Test(dependsOnMethods = {"testFacebookLogin"})
	public void testLogout1(){
		UserHomePage homepage = PageFactory.initElements(driver, UserHomePage.class);
		homepage.logout();
	}
	

}
