package hbm.planner.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BrowserOld {
	
	protected WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser", "link"})	
	public void openBrowser(@Optional("ff")String browser, @Optional("prod") String link){		
		if (browser.equalsIgnoreCase("FF")){			
			driver = new FirefoxDriver();	
		}else if (browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "./src/main/ChromeDriver/chromedriver.exe");
			driver = new ChromeDriver();	
		}else if (browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "./src/main/IEdriver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else if(browser.equalsIgnoreCase("safari")){
			driver = new SafariDriver();
		}else if(browser.equalsIgnoreCase("Edge")){
			System.setProperty("webdriver.edge.driver", "./src/main/EdgeDriver/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		// while changing timeout limit change it in ThreeDPlanner & Catalog class too
		if (link.equalsIgnoreCase("prod")){
			driver.get(Setting.prodLink);
			try{
				driver.findElement(By.id("accept-cookie-law")).click();
			}catch (Exception e){
				UtilHBM.reportWarning("Accept cookies message not displayed");
			}
		}else if(link.equalsIgnoreCase("preprod")){	
			driver.get(Setting.preprod3dPlanByMeLink);
			driver.get(Setting.preProdLink);
			try{
				driver.findElement(By.id("accept-cookie-law")).click();
			}catch (Exception e){
				UtilHBM.reportWarning("Accept cookies message not displayed");
			}
		}else if(link.equalsIgnoreCase("rel")){	
			driver.get(Setting.rel3dPlanByMeLink);
			driver.get(Setting.relLink);
			try{
				driver.findElement(By.id("accept-cookie-law")).click();
			}catch (Exception e){
				UtilHBM.reportWarning("Accept cookies message not displayed");
			}
		}else if(link.equalsIgnoreCase("ikea")){
			driver.get(Setting.bryo);
		}
		
	}	
	
	@AfterMethod
	public void screenCapture(ITestResult result) throws IOException{
		if(!result.isSuccess()){
			Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
			String browserName = cap.getBrowserName().toLowerCase();
			File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);			
			String imageFileName = result.getMethod().getMethodName()
					+ new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss")
			.format(new GregorianCalendar().getTime()) + browserName +".png";			
			File failureImageFile = new File(Setting.screenCapturePath+imageFileName);
			imageFile.renameTo(failureImageFile);
//			FileUtils.moveFile(imageFile, failureImageFile);			
		}
	}
	
	@AfterMethod
	public void screenCaptureSuccess(ITestResult result) throws IOException{
		if(result.isSuccess()){
			Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
			String browserName = cap.getBrowserName().toLowerCase();
			File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);			
			String imageFileName = result.getMethod().getMethodName()
					+ new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss")
			.format(new GregorianCalendar().getTime()) + browserName + ".png";			
			File failureImageFile = new File(Setting.screenCapturePath+imageFileName);
			imageFile.renameTo(failureImageFile);
//			FileUtils.moveFile(imageFile, failureImageFile);			
		}					
	}
	
	@AfterClass
	public void closeBrowser(){		
		driver.close();
		driver.quit();
	}
	
	/*
	private void preprodAuth(String browser, String link){
		if(link.contains("preprod") && browser.equalsIgnoreCase("chrome")){
			UtilHBM.waitForImg("preprodChromeAuthWin", 60);
			UtilHBM.clickImg("preprodChromeAuthWin");
			try {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_H);
				r.keyRelease(KeyEvent.VK_H);
				r.keyPress(KeyEvent.VK_O);
				r.keyRelease(KeyEvent.VK_O);
				r.keyPress(KeyEvent.VK_M);
				r.keyRelease(KeyEvent.VK_M);
				r.keyPress(KeyEvent.VK_E);
				r.keyRelease(KeyEvent.VK_E);
				r.keyPress(KeyEvent.VK_B);
				r.keyRelease(KeyEvent.VK_B);
				r.keyPress(KeyEvent.VK_Y);
				r.keyRelease(KeyEvent.VK_Y);
				r.keyPress(KeyEvent.VK_M);
				r.keyRelease(KeyEvent.VK_M);
				r.keyPress(KeyEvent.VK_E);
				r.keyRelease(KeyEvent.VK_E);
				r.keyPress(KeyEvent.VK_TAB);
				r.keyRelease(KeyEvent.VK_TAB);
				r.keyPress(KeyEvent.VK_B);
				r.keyRelease(KeyEvent.VK_B);
				r.keyPress(KeyEvent.VK_E);
				r.keyRelease(KeyEvent.VK_E);
				r.keyPress(KeyEvent.VK_T);
				r.keyRelease(KeyEvent.VK_T);
				r.keyPress(KeyEvent.VK_A);
				r.keyRelease(KeyEvent.VK_A);
				r.keyPress(KeyEvent.VK_T);
				r.keyRelease(KeyEvent.VK_T);
				r.keyPress(KeyEvent.VK_E);
				r.keyRelease(KeyEvent.VK_E);
				r.keyPress(KeyEvent.VK_S);
				r.keyRelease(KeyEvent.VK_S);
				r.keyPress(KeyEvent.VK_T);
				r.keyRelease(KeyEvent.VK_T);
				r.keyPress(KeyEvent.VK_1);
				r.keyRelease(KeyEvent.VK_1);
				
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	*/
	
	
}
