package hbm.planner.utility;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Mobile {
	
	public WebDriver driver;
		
	@BeforeClass
	@Parameters({"browser", "link", "nodeURL", "platform", "headless"})	
	public void openBrowser(@Optional("chrome")String browser, @Optional("mobilekitchen") String link, @Optional ("") String nodeURL, @Optional ("android") String platform, @Optional ("false") String headless) throws MalformedURLException{
		switch (browser.toLowerCase()){		
		case "chrome": 
			
			if(platform.equalsIgnoreCase("android")){
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "hbm02");
				cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
				cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
				cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
//				cap.setCapability("skipServerInstallation", true);
				URL url = new URL("http://127.0.0.1:4723/wd/hub");
				driver = new AppiumDriver(url, cap);
				
//				driver = new RemoteWebDriver(url, cap);
				
			}else if(platform.equalsIgnoreCase("ipad")){
				/*
				Map<String, String> iPadChromeEmulation = new HashMap<>();
				iPadChromeEmulation.put("deviceName", "iPad");			
				ChromeOptions iPadChromeOptions = new ChromeOptions();
				iPadChromeOptions.setExperimentalOption("mobileEmulation", iPadChromeEmulation);
				*/
				Map<String, Object> deviceMetrics = new HashMap<>();
				deviceMetrics.put("width", 1024);
				deviceMetrics.put("height", 768);
				deviceMetrics.put("pixelRatio", 2.0);
				Map<String, Object> iPadChromeEmulation = new HashMap<>();
				iPadChromeEmulation.put("deviceMetrics", deviceMetrics);
				iPadChromeEmulation.put("userAgent", "Mozilla/5.0 (iPad; CPU OS 11_0 like Mac OS X) AppleWebKit/604.1.34 (KHTML, like Gecko) Version/11.0 Mobile/15A5341f Safari/604.1");
				ChromeOptions iPadChromeOptions = new ChromeOptions();
				iPadChromeOptions.setExperimentalOption("mobileEmulation", iPadChromeEmulation);			
				driver = new ChromeDriver(iPadChromeOptions);				
			}
					break;	
		case "safari": 
			/*
			 * Following code is comented on Oct 21 2021 after upgrading to Selenium 4
			 * This code was used to launch Safari on Mac 
			driver = new SafariDriver();
//			nodeURL="http://10.89.8.148:5566/wd/hub";
			DesiredCapabilities cap = DesiredCapabilities.safari();
			cap.setBrowserName("safari");
			cap.setPlatform(Platform.MAC);
			driver = new RemoteWebDriver(new URL(nodeURL), cap);
			*/
			if (platform.equalsIgnoreCase("iphone")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
				cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.4");
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro Max");
				cap.setCapability(MobileCapabilityType.UDID, "E40C33B7-22EC-45AC-96FB-4C5086AB0A3E");
				cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
				cap.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
				// cap.setCapability("skipServerInstallation", true);
				URL url = new URL("http://127.0.0.1:4723/wd/hub");
				driver = new AppiumDriver(url, cap);
			} else if (platform.equalsIgnoreCase("ipad")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
				cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.4");
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro Max");
				cap.setCapability(MobileCapabilityType.UDID, "E46787D6-4048-4A6D-AAFE-CA16FA4350B4");
				cap.setCapability(MobileCapabilityType.ORIENTATION, "landscape");
				cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
				cap.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
				// cap.setCapability("skipServerInstallation", true);
				URL url = new URL("http://127.0.0.1:4723/wd/hub");
				driver = new AppiumDriver(url, cap);
			}
			break;		
		}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// while changing timeout limit change it in ThreeDPlanner & Catalog class too
		
		switch (link.toLowerCase()) {
		case "prod":
			driver.get(Setting.prodLink);
			acceptCookie();
			break;
		case "preprod":
			driver.get(Setting.preprod3dPlanByMeLink);
			driver.get(Setting.preProdLink);
			acceptCookie();
//			UtilHBM.waitExplicitClickable(driver, UtilHBM.webElement(driver, ".icon.icon-close.close-autopromo"));
//			UtilHBM.waitExplicitClickable(driver, UtilHBM.webElement(driver, "w-div>span"));
//			UtilHBM.waitFixTime(1000);
//			UtilHBM.webElement(driver, ".icon.icon-close.close-autopromo").click();			
//			UtilHBM.webElement(driver, "w-div>span").click();
			break;
		case "rel":
			driver.get(Setting.rel3dPlanByMeLink);
			driver.get(Setting.relLink);
			acceptCookie();
			break;
		case "partnerplanner":
			driver.get(Setting.preprod3dPlanByMeLink);
			driver.get(Setting.partnerPlanner);
			acceptCookie();
//			driver.findElement(By.cssSelector(".close-modal.button-close")).click();
//			UtilHBM.waitExplicitClickable(driver, UtilHBM.webElement(driver, ".icon.icon-close.close-autopromo"));
//			UtilHBM.webElement(driver, ".icon.icon-close.close-autopromo").click();
			break;
		case "platformdev":
			driver.get(Setting.platformDev);			
			break;
		case "bryo":
			driver.get(Setting.bryoPlanner);
			driver.get(Setting.bryo);
			break;
		case "bryostaging":
			driver.get(Setting.bryoPlannerStaging);
			driver.get(Setting.bryoStaging);
			break;	
		case "bryopreprod":
			driver.get(Setting.bryoPlannerPreprod);
			driver.get(Setting.bryoPreprod);
			break;
		case "mobilekitchen":
			driver.get(Setting.mobileKitchen);
//			driver.get(Setting.bryoPreprod);
			break;
		case "ikea":
			driver.get(Setting.bryoPlannerPreprod);
			break;
		case "bryocloud":
			driver.get(Setting.entPreprodStagingCloud);
			break;
		case "cloud":
			driver.get(Setting.cloud);
			break;
		case "terel":
			driver.get(Setting.teRel);
			break;
		case "tepreprod":
			driver.get(Setting.tePreprod);
			break;
		case "draftsight":						
			driver.manage().window().setSize(new Dimension(300, 742));
			driver.get(Setting.draftsightEmbed);			
			break;
		case "hbm4":
			driver.get(Setting.preprod3dPlanByMeLink);
			driver.get(Setting.mdmpreprod);
			acceptCookie();
//			UtilHBM.webElement(driver, ".icon.icon-close.close-autopromo").click();
			break;
		case "assemblyeditor":
			driver.get(Setting.stagingAssemblyEditor);
			break;
		case "embedhbm":
			driver.get(Setting.preprod3dPlanByMeLink);
			driver.get(Setting.preProdLink);
			String absolutePath=new File(Setting.embedHBMProjects).getAbsolutePath();
			driver.get(absolutePath);
			break;
		case "hrpreprod":
			driver.get(Setting.hrPlannerPreprod);
			driver.get(Setting.hrWidgetPreprod);			
			driver.get(Setting.hrWebPreprod);
			break;	
			
		default:
			break;
		}
	}	
	
	private void acceptCookie(){
		try{
			driver.findElement(By.cssSelector("#footer_tc_privacy_button_3")).click();
		}catch (Exception e){
			UtilHBM.reportWarning("Accept cookies message not displayed");
		}
	}
		
//	@AfterMethod
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
	
//	@AfterMethod
	public void screenCaptureSuccess(ITestResult result) throws IOException{
		if(result.isSuccess()){
			Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
			String browserName = cap.getBrowserName().toLowerCase();
			File imageFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);			
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
}
