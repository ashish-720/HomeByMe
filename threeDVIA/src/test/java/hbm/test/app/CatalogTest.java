package hbm.test.app;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CatalogTest {

	WebDriver driver;
	
	public CatalogTest(WebDriver driver){
		this.driver = driver;
	}
			
	public void printLinks(){		
		List<WebElement> listCatagory = driver.findElements(By.cssSelector(".catalog-family"));
		List<WebElement> listComp = driver.findElements(By.cssSelector(".catalog-list a"));
		List<WebElement> catagory = driver.findElements(By.cssSelector("catalog-box flex flex--separate>div"));
		for (WebElement comp:listCatagory){
			System.out.println(comp.getText());
		}
		System.out.println("--------------------");
		for (WebElement ctg: listComp){
			System.out.println(ctg.getText());			
		}
		
		System.out.println("--------------------");
		
		for (WebElement ctglist:catagory){
			System.out.println(ctglist.getText());
		}
		System.out.println("********************************");
	}

	
	public void clickBuilding(){		
		
		driver.findElement(By.linkText("ADD A PRODUCT")).click();
		
//		for(String handle:driver.getWindowHandles()){
//			driver.switchTo().window(handle);
//			System.out.println(handle);
//			
//		}
		
		try{			
			driver.findElement(By.linkText("Furniture")).click();
			//driver.findElement(By.xpath("//a[@class='catalog-link'][.='Front doors']")).click();
			System.out.println("Furniture clicked");
		}catch (Exception e){
			System.out.println("Furniture not found");
			e.printStackTrace();			
		}
		
		try{
			driver.findElement(By.linkText("Living room storage")).click();
			System.out.println("Living room storage opened");			
		} catch (Exception e){
			System.out.println("Living room storage not opened");
			e.printStackTrace();
		}
		try{
			driver.findElement(By.linkText("FURNITURE")).click();
			System.out.println("Furniture clicked");
		}catch (Exception e){
			System.out.println("Furniture not found");
			e.printStackTrace();		
		}
	}
}
