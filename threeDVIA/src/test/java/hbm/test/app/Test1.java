package hbm.test.app;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.UtilHBM;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.Login;
import hbm.web.pageobject.UserHomePage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class Test1 {
	
	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
//	public void checkLink(){
//		driver.get("https://3dplan.by.me/?ln=en&projectId=127#");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#trialClose")));
//		driver.findElement(By.cssSelector("#trialClose")).click();
//		CatalogTest test = new CatalogTest(driver);
//		test.clickBuilding();
//		driver.close();
//		driver.quit();
//		
//	}
	@Test(dataProvider = "loginData", dataProviderClass = SignUpData.class)
	public void TestCatalog(SignUpData signUpData){
//		driver.get("https://3dplan.by.me/?ln=en&projectId=127#");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#trialClose")));
//		driver.findElement(By.cssSelector("#trialClose")).click();
//		ThreeDPlanner threedplanner = PageFactory.initElements(driver, ThreeDPlanner.class);
//		threedplanner.addAProduct("LES EXCLUSIVES - ONDE", "LeftWall.png", 0, 0);
//		driver.close();
//		driver.quit();
		driver.get("https://home.by.me/en/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#trialClose")));
//		driver.findElement(By.cssSelector("#trialClose")).click();
//		System.out.println("Close Trial");
//		driver.findElement(By.id("btn-ok")).click();
		LandingPage l = PageFactory.initElements(driver, LandingPage.class);
		l.loginExistingUser(signUpData);	
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.editLatestProject().twoDView();
		driver.findElement(By.linkText("ADD A PRODUCT")).click();;
		UtilHBM.waitExplicitDisplayed(driver, driver.findElements(By.cssSelector(".catalog-inner")).get(0));
		System.out.println(driver.findElements(By.cssSelector(".catalog-inner")).get(0).getText().split("\r\n|\r|\n")[0]);
//		driver.get("https://3dplan.by.me/?ln=en&projectId=71271");
//		UtilHBM.waitFixTime(10000);
//		ThreeDPlanner threedplanner = PageFactory.initElements(driver, ThreeDPlanner.class);
//		threedplanner.addAProduct("LUMYS", "GuestRoom.png", -0, -0).threeDView().realisticImage("small").realisticImage("small").realisticImage("small").closePlanner();
		driver.close();
		driver.quit();
	}

	
}
