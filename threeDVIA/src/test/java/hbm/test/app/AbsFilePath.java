package hbm.test.app;

import hbm.planner.utility.Setting;

import java.io.File;

public class AbsFilePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		File f = new File(Setting.imgPath + "Ihina1");
		System.out.println("Absolute file path is: " +  f.getAbsolutePath());
		
		/* code for testing drag & drop between two widgets
		System.setProperty("webdriver.chrome.driver", "./src/main/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://euw1-21swi10523-iam.3dx-staging.3ds.com/cas/login?service=https%3A//euw1-21swi10523-ifwe.3dx-staging.3ds.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		UtilHBM.webElement(driver, "input[name='username']").sendKeys("inl");
		UtilHBM.webElement(driver, "input[name='password']").sendKeys("Bgangasa2!");
		UtilHBM.webElement(driver, "input[type='submit']").click();
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".ds-coachmark-close"));
		UtilHBM.waitExplicitClickable(driver, UtilHBM.webElement(driver, ".ds-coachmark-close"));		
		UtilHBM.webElement(driver, ".ds-coachmark-close").click();
		UtilHBM.waitFixTime(5000);
//		driver.switchTo().frame(UtilHBM.listOfWebElement(driver, ".moduleWrapper iframe").get(0));		
		driver.switchTo().frame(UtilHBM.webElement(driver, "div>div>div>div>div>div>div>div>#frame-94j-JYmA2HcyQ9dpQXOr"));
		UtilHBM.waitExplicitClickable(driver, UtilHBM.webElement(driver, ".w3ddrive.item.inode-item"));
		Actions a = new Actions(driver);
//		a.dragAndDropBy(UtilHBM.webElement(driver, ".w3ddrive.item.inode-item"), 300, 0);
		
		a.moveToElement(UtilHBM.webElement(driver, ".w3ddrive.item.inode-item")).clickAndHold(UtilHBM.webElement(driver, ".w3ddrive.item.inode-item")).build().perform();
//		driver.switchTo().frame(UtilHBM.listOfWebElement(driver, ".moduleWrapper iframe").get(1));		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(UtilHBM.webElement(driver, "#frame-94j-JYmA2HcyQ9dpQXOq"));		
		a.moveToElement(UtilHBM.webElement(driver, "#canvas-div>div>div>.lp-txt-container")).pause(2000).release(UtilHBM.webElement(driver, "#canvas-div>div>div>.lp-txt-container")).build().perform();
		UtilHBM.waitFixTime(5000);
		System.out.println("test done");		
		driver.close();
		driver.quit();
		*/
	}

}
