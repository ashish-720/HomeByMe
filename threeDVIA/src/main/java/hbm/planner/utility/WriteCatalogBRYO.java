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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WriteCatalogBRYO {
	
	public static void main(String[] args) throws IOException {
		
		File f = new File(Setting.testCatalogPath + "bryoINLTestCatalog.txt");
		
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
		driver.get("https://kitchenbyme:Next!Gen01@preprod-kitchen.enterprise-dev.by.me");		
		
//		driver.findElement(By.cssSelector(".button.more_info.open-planner-embed")).click();
//		UtilHBM.waitFixTime(2000);
//		driver.switchTo().frame("planner-embed-iframe");
		/*
		for(String handle:driver.getWindowHandles()){
			System.out.println("Handle: " + handle);
			driver.switchTo().window(handle);
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#trialClose")));
		driver.findElement(By.cssSelector("#trialClose")).click();
		for(String handle:driver.getWindowHandles()){
			System.out.println("Handle: " + handle);
			driver.switchTo().window(handle);
		}*/
		UtilHBM.waitFixTime(5000);
		WebElement launchBtn = UtilHBM.webElement(driver, "button[data-ui-action='launch-app']");
		UtilHBM.waitExplicitClickable(driver, launchBtn);
		launchBtn.click();
		UtilHBM.waitFixTime(5000);
		driver.switchTo().frame(
				driver.findElement(By.cssSelector("#embedded-app-frame")));
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("input.room.Tag3D.visibility-visible")));
		List<WebElement> stepList = driver.findElements(By.cssSelector(".mod-design-steps>li>button"));
		String product, id, subCatagory, catagory;
		String stepStr="";
		String mainCatagory="";
		String size="";
		String description="";
		String price="";
		for (WebElement step : stepList){
			if (step.getText().matches("Floorplan|Design your kitchen")){
				stepStr=step.getText();
				step.click();
				UtilHBM.waitFixTime(2000);
				if(stepStr.equalsIgnoreCase("Design your kitchen")){
					WebElement container3D = UtilHBM.webElement(driver, "#bmSVG");
					new Actions(driver).moveToElement(container3D, 10, 0).clickAndHold()
					.pause(500).moveByOffset(20, 10).release().build()
					.perform();
					UtilHBM.waitFixTime(2000);
				}
				List<WebElement> mainCtgList = driver.findElements(By.cssSelector(".bt-icon-label-alt"));
				for (WebElement mainCat: mainCtgList){
					if(mainCat.getText().matches("Room objects|Openings|Covering|Cabinets|Appliances|Dining|Kitchen extras")){
						mainCatagory = mainCat.getText();
						mainCat.click();
						UtilHBM.waitFixTime(2000);
//						List<WebElement> subCtg=driver.findElements(By.cssSelector(".mod-nav-overlay[aria-hidden='false'] .subcat>li"));
						List<WebElement> catList1=UtilHBM.listOfWebElement(driver, ".mod-nav-overlay[aria-hidden='false'] .subcat>li>ul>li");
						List<String> CtgStringList=new ArrayList<String>();
						for(WebElement e: catList1){
							CtgStringList.add(e.getText());							
						}
						for (int i=0;i<CtgStringList.size(); i++){
							mainCat.click();
							UtilHBM.waitFixTime(2000);
							subCatagory=driver.findElement(By.xpath("//button[normalize-space(.)='"+CtgStringList.get(i) +"']/../../preceding-sibling::h2/button")).getText();
							catagory=CtgStringList.get(i);
							driver.findElement(By.xpath("//button[normalize-space(.)='"+CtgStringList.get(i) +"']")).click();
							UtilHBM.waitFixTime(30000);
							List<WebElement> prdList=driver.findElements(By.cssSelector("#catalogbrowser-content-inner>#mod-product-list>li"));
							for(WebElement prd:prdList){
								id=prd.getAttribute("data-ui-id");
								product=prd.findElement(By.cssSelector("div.text>h3.name")).getText().split("\\r?\\n")[0];
								UtilHBM.turnOffImplicitWaits(driver);
								if(prd.findElements(By.cssSelector("div.text .desc")).size()>0){
									description=prd.findElements(By.cssSelector("div.text .desc")).get(0).getText();
								}else{
									description="";
								}
								if(prd.findElements(By.cssSelector("div.text .secondary-desc")).size()>0){
									size=prd.findElements(By.cssSelector("div.text .secondary-desc")).get(0).getText();
								}else{
									size="";
								}
								if(prd.findElements(By.cssSelector("div.text .standard-price")).size()>0){
									price=prd.findElements(By.cssSelector("div.text .standard-price")).get(0).getText();
								}else{
									price="";
								}
								UtilHBM.turnOnImplicitWaits(driver);
								String catString= product +";" + stepStr+">"+mainCatagory+">"+subCatagory+">"+catagory+">"+size+">"+description+">"+price;
								String catStringID= product +"|" + id +";"+stepStr+">"+mainCatagory+">"+subCatagory+">"+catagory+">"+size+">"+description+">"+price;
								System.out.println(catString);
								System.out.println(catStringID);
								br.write(catString+"\r\n");
								br.write(catStringID+"\r\n");	
							}
							UtilHBM.webElement(driver, ".bt-icon-alt[data-ui-action='panel-close']").click();
							UtilHBM.waitFixTime(2000);							
						}
					}
										
				}
			}			
		}		
		br.close();
		driver.close();
		driver.quit();
	}

}
