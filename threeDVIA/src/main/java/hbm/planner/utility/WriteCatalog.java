package hbm.planner.utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WriteCatalog {
	
	public static void main(String[] args) throws IOException {
		
		File f = new File(Setting.testCatalogPath + "testCatalot.txt");
		
		try{
			f.createNewFile();
		}catch (Exception e){
			System.out.println("Catalog file not created");
			e.printStackTrace();
		}

		Writer br = new BufferedWriter(new FileWriter(f, true));
		
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://3dplan.by.me/?ln=en&projectId=127#");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#trialClose")));
		driver.findElement(By.cssSelector("#trialClose")).click();
		driver.findElement(By.linkText("ADD A PRODUCT")).click();		
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Brands")));
		//driver.findElement(By.cssSelector(".close-modal button-close")).click();
		List<WebElement> topBarList = driver.findElements(By.cssSelector(".tab-item>a"));		
		List<String> tabNameList = new ArrayList<String>();
		for (WebElement tab1: topBarList){
			String tabName = tab1.getText();
			tabNameList.add(tabName);
		}
		for (String tab:tabNameList){			
			System.out.println("tabText: " + tab);
			driver.findElement(By.linkText(tab)).click();
			System.out.println("Clicked on : " + tab);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".catalog-link")));
			List<WebElement> catalogLinkList = driver.findElements(By.cssSelector(".catalog-link"));
			List<String> catagoryList = new ArrayList<String>();
			for (WebElement tempCatagory: catalogLinkList){
				String catagory = tempCatagory.getText();
				catagoryList.add(catagory);				
			}			
			for(String typeProduct:catagoryList){				
				System.out.println("type: " + typeProduct);
				driver.findElement(By.linkText(typeProduct)).click();
				List<WebElement> productList = driver.findElements(By.cssSelector(".product-legend>a"));
				System.out.println("productList created: "+ productList.get(0).getText());
				List<WebElement> productPath = driver.findElements(By.cssSelector(".breadcrumbs-link"));
				System.out.println("productPath list created");
				for(WebElement product:productList){
					//System.out.println(tab + ">"+ productPath.get(1).getText() + ">"+ typeProduct + ";" + product.getText());
					String str = tab + ">"+ productPath.get(1).getText() + ">"+ typeProduct + ";" + product.getText();
					br.write(str + "\r\n");					
				}
				driver.findElement(By.linkText(productPath.get(1).getText())).click();
			}
		}
		br.close();
		driver.close();
		driver.quit();
	}

}
