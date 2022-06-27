package hbm.planner.utility;

import com.google.common.collect.Iterables;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Browser {
	
	protected WebDriver driver;
	public static String mainWindowHandle;
		
	@BeforeClass
	@Parameters({"browser", "link", "nodeURL", "platform", "headless"})	
	public void openBrowser(@Optional("chrome")String browser, @Optional("entpreprodstagingcloud") String link, @Optional ("") String nodeURL, @Optional ("win") String platform, @Optional ("false") String headless) throws MalformedURLException{
		switch (browser.toLowerCase()){		
		case "chrome": 
			if(platform.equalsIgnoreCase("mac")){
				System.setProperty("webdriver.chrome.driver", "./src/main/ChromeDriver/mac/chromedriver");
			}else{
				System.setProperty("webdriver.chrome.driver", "./src/main/ChromeDriver/chromedriver.exe");
			}
			if(platform.equalsIgnoreCase("iphone")){
				Map<String, String> mobileEmulation = new HashMap<>();
				mobileEmulation.put("deviceName", "iPhone 6/7/8");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
				driver = new ChromeDriver(chromeOptions);				
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
			}else if(platform.equalsIgnoreCase("zap")){
				Proxy proxy = new Proxy();
				proxy.setHttpProxy("localhost:8099");
				proxy.setSslProxy("localhost:8099");
				ChromeOptions options = new ChromeOptions();
				options.setCapability("proxy", proxy);
				options.addArguments("start-maximized");
				options.addArguments("--ignore-certificate-errors");
				options.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(options);
			}else{
//				driver = new ChromeDriver();
				/*	nodeURL="http://10.89.8.148:5566/wd/hub";
					DesiredCapabilities cap = DesiredCapabilities.chrome();
					cap.setBrowserName("chrome");
					cap.setPlatform(Platform.LINUX);
					driver = new RemoteWebDriver(new URL(nodeURL), cap);
					*/
					if(nodeURL.isEmpty()){
						/*if(platform.equalsIgnoreCase("mac")){
							System.setProperty("webdriver.chrome.driver", "./src/main/ChromeDriver/mac/chromedriver");
						}else{
							System.setProperty("webdriver.chrome.driver", "./src/main/ChromeDriver/chromedriver.exe");
						}*/
//						driver = new ChromeDriver();
						if (headless.equalsIgnoreCase("true")){
							ChromeOptions options = new ChromeOptions();
							if(link.equalsIgnoreCase("draftsight")){
								options.addArguments("window-size=300, 742");
							}else{
								options.addArguments("window-size=1280, 990");
							}					
							options.addArguments("headless");
							driver = new ChromeDriver(options);				
						}else{
							driver = new ChromeDriver();
						}				
					}else{
						/*
						 * Following code is commented on Oct 21, 2021 after upgrading to Selenium 4.
						 * This code was used to launch Chrome on linux or on docker container
						DesiredCapabilities cap = DesiredCapabilities.chrome();
						cap.setBrowserName("chrome");
						if(platform.equalsIgnoreCase("linux")){
							cap.setPlatform(Platform.LINUX);
						}else if (platform.contains("win")){
							cap.setPlatform(Platform.WINDOWS);
						}				
						driver = new RemoteWebDriver(new URL(nodeURL), cap);	
						*/			
					}
			}

					break;	
		case "ie": 
//			System.setProperty("webdriver.ie.driver", "./src/main/IEdriver/IEDriverServer.exe");
//			driver = new InternetExplorerDriver();
			break;
		case "safari": 
			driver = new SafariDriver();
//			nodeURL="http://10.89.8.148:5566/wd/hub";
//			DesiredCapabilities cap = DesiredCapabilities.safari();
//			cap.setBrowserName("safari");
//			cap.setPlatform(Platform.MAC);
//			driver = new RemoteWebDriver(new URL(nodeURL), cap);
			break;
		case "edge": 
			System.setProperty("webdriver.edge.driver", "./src/main/EdgeDriver/msedgedriver.exe");
			driver = new EdgeDriver();
			break;
			
		case "ff": 
			System.setProperty("webdriver.gecko.driver", "./src/main/GeckoDriver/geckodriver.exe");
//			nodeURL="http://10.89.8.148:5566/wd/hub";
			if(nodeURL.isEmpty()){		
				if(headless.equalsIgnoreCase("true")){
					FirefoxOptions options = new FirefoxOptions();
					options.setHeadless(true);				
					driver = new FirefoxDriver(options);
				}else{
					driver = new FirefoxDriver();
				}								
			}else{
				/*
				 * Following code is commented on Oct 21, 2021 after upgrading to Selenium 4.
				 * This code was used to launch Firefox on linux or on docker container
				 * 
				DesiredCapabilities cap1 = DesiredCapabilities.firefox();
				cap1.setBrowserName("firefox");
				if(platform.equalsIgnoreCase("linux")){
					cap1.setPlatform(Platform.LINUX);
				}else if (platform.contains("win")){
					cap1.setPlatform(Platform.WINDOWS);
				}				
				driver = new RemoteWebDriver(new URL(nodeURL), cap1);		
				*/		
			}
			break;
		}
//		driver.manage().window().maximize();
		mainWindowHandle=driver.getWindowHandle();
		driver.manage().window().setSize(new Dimension(1296, 1000));
		driver.manage().window().setPosition(new Point(0,0));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// while changing timeout limit change it in ThreeDPlanner & Catalog class too
		
		switch (link.toLowerCase()) {
		case "prod":
			driver.get(Setting.prodLink);
			acceptCookie();
			break;
		case "preprod":
//			driver.get(Setting.preprod3dPlanByMeLink);
			driver.get(Setting.preProdLink);		
			acceptCookie();
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
//			driver.get(Setting.bryoPlanner);
			driver.get(Setting.bryo);
			bryoAccessCode();
			break;
		case "bryostaging":
//			driver.get(Setting.bryoPlannerStaging);
			driver.get(Setting.bryoStaging);
			bryoAccessCode();
			break;	
		case "bryopreprodstaging":
			driver.get(Setting.bryoWidget);
			driver.get(Setting.bryoPreprodStaging);
			bryoAccessCode();
			break;	
		case "bryopreprod":
			driver.get(Setting.bryoWidget);
			driver.get(Setting.bryoPreprod);
			bryoAccessCode();
			break;
		case "bryopreprodtestaccesscode":
			driver.get(Setting.bryoWidget);
			driver.get(Setting.bryoPreprod);
			bryoTestAccessCode();
			break;
		case "bryopreprodbeta":
			driver.get(Setting.bryoWidget);
			driver.get(Setting.bryoPreprodBeta);
			bryoAccessCode();
			break;
		case "bryopreprodalpha":
			driver.get(Setting.bryoWidget);
			driver.get(Setting.bryoPreprodAlpha);
			bryoAccessCode();
			break;
		case "kitchenalpha":
			driver.get(Setting.mobileKitchen);
			break;
		case "ikea":
			driver.get(Setting.ikeaPlanner);
			break;
		case "preprodkitchen":
			driver.get(Setting.bryoPlannerPreprod);
			break;
		case "entpreprodstagingcloud":
			driver.get(Setting.entPreprodStagingCloud);
			break;
		case "entpreprodnewcloud":
			driver.get(Setting.entPreprodNewCloud);
			break;
		case "entpreprodcloud":
			driver.get(Setting.entPreprodCloud);
			break;
		case "cloud":
			driver.get(Setting.cloud);
			break;
		case "newcloud":
			driver.get(Setting.newCloud);
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
			acceptCookie();
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
		case "hrpreprodus":
			driver.get(Setting.hrPlannerPreprod);
			driver.get(Setting.hrWidgetPreprod);			
			driver.get(Setting.hrUSWebPreprod);
			break;
		case "hbmbuildid":
			driver.get(Setting.hbmBuildId);			
			break;
		case "enterprisebuildid":
			driver.get(Setting.enterpriseBuildId);			
			break;
		case "enterprisestagingbuildid":
			driver.get(Setting.enterpriseStagingBuildId);
			break;
		case "bathroom":
			driver.get("https://preprod-bathroom.enterprise-dev.by.me/");
			break;
		case "bathroommobile":
		case "bathroomalpha":
				driver.get("https://preprod-bathroom.enterprise-dev.by.me/?appAlpha");
				break;
			default:
			break;
		}
	}	
	
	private void acceptCookie() {
		try {
			driver.findElement(By.cssSelector("#footer_tc_privacy_button_3")).click();
		} catch (Exception e) {
			UtilHBM.reportWarning("Accept cookies message not displayed");
			System.out.println("Accept cookies message not displayed");
		}
	}
	
	private void bryoAccessCode(){
		WebElement accessCode = driver.findElement(By.cssSelector("#access-code"));
//		WebElement startGBDemo = driver.findElement(By.cssSelector(".locale-switch-box>button[data-locale='en-GB']"));
		UtilHBM.waitExplicitDisplayed(driver, accessCode);
		accessCode.sendKeys("Next!Gen01");
//		startGBDemo.click();
		
		
	}

	private void bryoTestAccessCode(){
		WebElement accessCode = driver.findElement(By.cssSelector("#access-code"));
		WebElement startGBDemo = driver.findElement(By.cssSelector(".locale-switch-box>button[data-locale='en-GB']"));
		UtilHBM.waitExplicitDisplayed(driver, accessCode);

		//Scenario 1 : If start demo is clicked without entering any access code
		startGBDemo.click();
		UtilHBM.waitFixTime(1000);
		accessCode = driver.findElement(By.cssSelector("#access-code"));
		Verification.VerifyEquals("Access code input box border color not as expected when access code is wrong",accessCode.getCssValue("border-color"), "rgb(199, 72, 85)");
		Verification.VerifyEquals("Incorrect access code error message not displayed...", accessCode.findElement(By.xpath(".//parent::div/b[@class='error']")).getText(),"Incorrect access code");
		Verification.VerifyEquals("Access code error msg text color not as expected",accessCode.findElement(By.xpath(".//parent::div/b[@class='error']")).getCssValue("color"), "rgba(199, 72, 85, 1)");

		//Scenario 2 : If start demo is clicked by entering wrong access code
		accessCode.sendKeys("Next!Gen00");
		startGBDemo.click();
		UtilHBM.waitFixTime(1000);
		accessCode = driver.findElement(By.cssSelector("#access-code"));
		Verification.VerifyEquals("Access code input box border color not as expected when access code is wrong",accessCode.getCssValue("border-color"), "rgb(199, 72, 85)");
		Verification.VerifyEquals("Incorrect access code error message not displayed...", accessCode.findElement(By.xpath(".//parent::div/b[@class='error']")).getText(),"Incorrect access code");
		Verification.VerifyEquals("Access code error msg text color not as expected",accessCode.findElement(By.xpath(".//parent::div/b[@class='error']")).getCssValue("color"), "rgba(199, 72, 85, 1)");

		accessCode.clear();
		accessCode.sendKeys("Next!gen01");
		startGBDemo.click();
		UtilHBM.waitFixTime(1000);
		accessCode = driver.findElement(By.cssSelector("#access-code"));
		Verification.VerifyEquals("Access code input box border color not as expected when access code is wrong",accessCode.getCssValue("border-color"), "rgb(199, 72, 85)");
		Verification.VerifyEquals("Incorrect access code error message not displayed...", accessCode.findElement(By.xpath(".//parent::div/b[@class='error']")).getText(),"Incorrect access code");
		Verification.VerifyEquals("Access code error msg text color not as expected",accessCode.findElement(By.xpath(".//parent::div/b[@class='error']")).getCssValue("color"), "rgba(199, 72, 85, 1)");

		//Scenario 3 : User tries to access website by entering url to browser directly
		driver.get("https://preprod-bryo.enterprise-dev.by.me/en-GB/");
		UtilHBM.waitFixTime(1000);
		Verification.VerifyEquals("Url check whithout entering correct access code", driver.getCurrentUrl(), "https://preprod-bryo.enterprise-dev.by.me/");

		//Scenario 4 : If start demo is clicked by entering correct access code
		accessCode = driver.findElement(By.cssSelector("#access-code"));
		startGBDemo = driver.findElement(By.cssSelector(".locale-switch-box>button[data-locale='en-GB']"));
		accessCode.sendKeys("Next!Gen01");
		startGBDemo.click();
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, "//a[@href='./collection-paris.html']/span[text()='Discover']");
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
	
	public static void openUrl(WebDriver driver, String url){
		driver.get(url);
		try{
			driver.switchTo().alert().accept();
			UtilHBM.turnOffImplicitWaits(driver);
			if(driver.findElements(By.cssSelector("#popin_tc_privacy_button>div")).size()>0){
				driver.findElement(By.cssSelector("#popin_tc_privacy_button>div")).click();
				UtilHBM.waitFixTime(1000);
			}
			UtilHBM.turnOnImplicitWaits(driver);
		}catch(NoAlertPresentException e){
			
		}		
	}

	public static String openUrlInNewTab(WebDriver driver, String url){
		driver.switchTo().newWindow(WindowType.TAB);
		String newTabHandle= Iterables.get(driver.getWindowHandles(),driver.getWindowHandles().size()-1);
		driver .switchTo().window(newTabHandle);
		driver.get(url);
		try{
			driver.switchTo().alert().accept();
			UtilHBM.turnOffImplicitWaits(driver);
			if(driver.findElements(By.cssSelector("#popin_tc_privacy_button>div")).size()>0){
				driver.findElement(By.cssSelector("#popin_tc_privacy_button>div")).click();
				UtilHBM.waitFixTime(1000);
			}
			UtilHBM.turnOnImplicitWaits(driver);
		}catch(NoAlertPresentException e){

		}
		return newTabHandle;
	}

	public static void switchToWindow(WebDriver driver, String windowHandle){
		driver.switchTo().window(windowHandle);
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
