package hbm.test.app;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class TestFunctions {

//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//
//		SignUpData s = new SignUpData();
//		
//		System.out.println(s.getLoginId());
//		System.out.println(s.getPassword());
//	}
WebDriver driver = new FirefoxDriver();
WebDriverWait wait = new WebDriverWait(driver, 5000);
	
	public void printCatalogLinks(){
		
		driver.get("https://3dplan.by.me/?ln=en&projectId=127");
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#trialClose")));
		driver.findElement(By.cssSelector("#trialClose")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		System.out.println("Location of room label X: " + driver.findElements(By.cssSelector(".room.Tag3D.visibility-visible.pointer-events-deactivated")).get(0).getLocation().getX());
		WebElement label = driver.findElements(By.cssSelector(".room.Tag3D.visibility-visible.pointer-events-deactivated")).get(0);
		new Actions(driver).click(label).build().perform();
		
//		driver.findElement(By.cssSelector(".panelProduct-btn-label")).click();
		
//		CatalogTest catalog = new CatalogTest(driver);
//		catalog.printLinks();
//		
//		driver.findElement(By.cssSelector("a[data-href = '#Furniture']")).click();
//		for (String winHandle: driver.getWindowHandles()){
//			System.out.println(driver.getWindowHandle());
//			driver.switchTo().window(winHandle);
//		}
//		catalog.printLinks();
//		
//		driver.findElement(By.cssSelector("a[data-href = '#Decoration]'")).click();
//		for (String winHandle: driver.getWindowHandles()){
//			System.out.println(driver.getWindowHandle());
//			driver.switchTo().window(winHandle);
//		}
//		catalog.printLinks();
//		
//		driver.findElement(By.cssSelector("a[data-href = '#Brands']")).click();
//		for (String winHandle: driver.getWindowHandles()){
//			System.out.println(driver.getWindowHandle());
//			driver.switchTo().window(winHandle);
//		}
//		catalog.printLinks();

		driver.close();
		driver.quit();
	}
	
}
