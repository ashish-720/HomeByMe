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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WriteCatalogV2DataIds {
	
	public static void main(String[] args) throws IOException {
		
		File f = new File(Setting.testCatalogPath + "testCatalog.txt");
		
		try{
			f.createNewFile();
		}catch (Exception e){
			System.out.println("Catalog file not created");
			e.printStackTrace();
		}

		Writer br = new BufferedWriter(new FileWriter(f, true));
		
//		WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "./src/main/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://homebyme:betatest1@preprod-platform.by.me/");
		driver.get("https://homebyme:betatest1@preprod-home.by.me/en/");
		WebElement tryNow = driver.findElement(By.cssSelector(".button--secondary.button--l.u-mts.open-planner-embed"));
		wait.until(ExpectedConditions.elementToBeClickable(tryNow));
		driver.findElement(By.cssSelector("#popin_tc_privacy_button>div")).click();
		tryNow.click();
//		driver.get("https://preprod-3dplan.by.me/");
//		driver.get("https://homebyme:betatest1@rel-home.by.me/");
//		driver.get("https://rel-home.by.me/");
		
//		driver.findElement(By.cssSelector(".button.more_info.open-planner-embed")).click();
//		UtilHBM.waitFixTime(2000);
//		driver.switchTo().frame("planner-embed-iframe");
		for(String handle:driver.getWindowHandles()){
			System.out.println("Handle: " + handle);
			driver.switchTo().window(handle);
		}
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#trialClose")));
		driver.findElement(By.cssSelector(".close-modal.button-close")).click();
		UtilHBM.waitFixTime(30000);
		driver.findElement(By.cssSelector(".close-banner.close")).click();
		
		UtilHBM.waitFixTime(1000);
		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
		
		driver.findElement(By.cssSelector(".dropdown-list-button.icon.icon-catalogue")).click();
		driver.findElement(By.xpath("//div[@class='dropdown-list-content-item-label'][.='build']")).click();	
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Brand Corner")));
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
			UtilHBM.waitFixTime(2000);
			System.out.println("Clicked on : " + tab);
			if(tab.equalsIgnoreCase("Brand Corner")){
				List<String> brandList = new ArrayList<String>();
				for(WebElement brand: UtilHBM.listOfWebElement(driver, ".brand-thumb-link")){
					String dataId = brand.getAttribute("data-id");
					brandList.add(dataId);
				}
				for(String brandToClick : brandList){
					System.out.println("Brand to be cliked: " + brandToClick);
					while(UtilHBM.listOfWebElement(driver, ".breadcrumbs-item").size()==1){
						UtilHBM.waitExplicitClickable(driver, UtilHBM.webElement(driver, "a[data-id = '"+brandToClick+"']>img"));
						UtilHBM.webElement(driver, "a[data-id = '"+brandToClick+"']>img").click();
						UtilHBM.waitFixTime(1500);
					}
					
					if(UtilHBM.listOfWebElement(driver, ".buttonFavoriteMoreResults").size()>0){
						
						while(UtilHBM.listOfWebElement(driver, ".buttonFavoriteMoreResults").size()>0&& 
								!(UtilHBM.listOfWebElement(driver, ".show-more[style='display: none;']").size()>0)){
							UtilHBM.webElement(driver, ".buttonFavoriteMoreResults").click();
							UtilHBM.waitFixTime(3000);
						}
					}
					List<WebElement> productList = driver.findElements(By.cssSelector(".product-legend"));
					System.out.println("productList created: "+ productList.get(0).getText());
					List<WebElement> productPath = driver.findElements(By.cssSelector(".breadcrumbs-link"));
					System.out.println("productPath list created");
					for(WebElement product:productList){
						//System.out.println(tab + ">"+ productPath.get(1).getText() + ">"+ typeProduct + ";" + product.getText());
						String str = product.findElement(By.tagName("a")).getText() + ";" + tab + ">"+ tab + ">" +brandToClick;
						System.out.println(str);
						br.write(str + "\r\n");	
						String str1 = product.findElement(By.tagName("a")).getAttribute("data-id")+ ";" + tab + ">"+ tab + ">" +brandToClick;
						System.out.println(str1);
						br.write(str1+"\r\n");
				}
					driver.findElement(By.linkText(productPath.get(0).getText())).click();
			}
				
			}else{
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".catalog-link")));
				List<String> catalogFamilyList = new ArrayList<String>();
				for(WebElement family: UtilHBM.listOfWebElement(driver, ".catalog-family")){
					String catalogFamily = family.getText();
					catalogFamilyList.add(catalogFamily);
				}
				for(String family: catalogFamilyList){
					List<String> typeOfProductList = new ArrayList<String>();
					for(WebElement type: driver.findElements(By.xpath("//span[.='" + family + "']/../..//li"))){
						typeOfProductList.add(type.getText());
					}
					for (String typeOfProduct: typeOfProductList){
						while (UtilHBM.listOfWebElement(driver, ".breadcrumbs-item").size()==1){							
							if(typeOfProduct.contains("Children's bedroom furniture")){
								driver.findElement(By.linkText("Children's bedroom furniture")).click();
							}else{
								driver.findElement(By.xpath("//span[.='" + family + "']/../..//a[.='" + typeOfProduct +"']")).click();
							}
							
							UtilHBM.waitFixTime(1500);
							System.out.println(typeOfProduct + "clicked");
						}
						if(UtilHBM.listOfWebElement(driver, ".buttonFavoriteMoreResults").size()>0){							
							while(UtilHBM.listOfWebElement(driver, ".buttonFavoriteMoreResults").size()>0 && 
									!(UtilHBM.listOfWebElement(driver, ".show-more[style='display: none;']").size()>0)){
								UtilHBM.webElement(driver, ".buttonFavoriteMoreResults").click();
								UtilHBM.waitFixTime(3000);
							}
						}
						
						for(WebElement product: UtilHBM.listOfWebElement(driver, ".product-legend")){
							String str = product.findElement(By.tagName("a")).getText() + ";" + tab + ">"+ family + ">"+ typeOfProduct+">" + product.findElement(By.tagName("h3")).getText();
							br.write(str + "\r\n");	
							String str1 = product.findElement(By.tagName("a")).getAttribute("data-id")+ ";" + tab + ">"+ family + ">"+ typeOfProduct+">" + product.findElement(By.tagName("h3")).getText();
							br.write(str1+"\r\n");
						}
						UtilHBM.listOfWebElement(driver, ".breadcrumbs-link").get(0).click();
					}
				}
			}
		}
		br.close();
		driver.close();
		driver.quit();
	}

}
