package hbm.web.pageobject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Academy {
	
	WebDriver driver;
	
	public Academy(WebDriver driver) {
		this.driver = driver;
	}
	
	@CacheLookup
	@FindBy(css = ".header-logo")
	WebElement homebymeLink;
	
	@CacheLookup
	@FindBy(linkText = "Magazine")
	WebElement academy;
	
	@FindBy(css=".FooterVignettes--text>.footer--elements>.fLeft.pictos")
	private List<WebElement> exploreLinkImgList;
	
	public Academy checkFeaturedArticles(){		
		academy.click();
		List<WebElement> articleList = driver.findElements(By.cssSelector(".academy--vignettes "));
		List<WebElement> articleImageList = driver.findElements(By.cssSelector(".academy--vignettes  img[src*='http']"));
		if (articleImageList.size()==articleList.size() && articleList.size()>0){
			UtilHBM.reportOK("All article images are displayed in Academy Page.");
			UtilHBM.reportOK("Number of articles in Academy page = " + articleList.size());
			UtilHBM.reportOK("Number of articles with image in Academy page = " + articleImageList.size() + "<font color='black'>");
		}else if(!(articleList.size()>0)){
			UtilHBM.reportKO("Something is worng. There are no articles in academy page");
		}else {
			Reporter.log("<font color='red'>" + "All articles images not displayed in Academy Page." + "<br>" );
			Reporter.log("Number of articles in Academy page = " + articleList.size() + "<br>");
			Reporter.log("Number of articles with images in Academy page = " + articleImageList.size() + "<font color='black'>" + "<br>");
		}
		return PageFactory.initElements(driver, Academy.class);
	}
	
		public Academy checkAspectsOfInteriorDesign(){
			List<String> aspectList= new ArrayList<String>();
			for (WebElement element:driver.findElements(By.cssSelector(".whiteButton"))){
				aspectList.add(element.getText());
			}
			if(aspectList.size()>0){
				for (String aspect:aspectList){
					Reporter.log("Checking page: " + aspect + " | A link from Academy Page." +  "<br>");
					driver.findElement(By.linkText(aspect)).click();
					System.out.println(aspect + ";" + driver.getTitle());
					driver.navigate().back();
				}				
			}else{
				UtilHBM.reportKO("Some thing is wrong or chaned on page. No links are available like: OutDoor, Batchroom etc in Academy Page");
			}
						
			return PageFactory.initElements(driver, Academy.class);
		}
		
		public Academy checkExploreLinks(){
			for(WebElement temp: exploreLinkImgList){
				Verification.displayOfWebElement(temp);
			}
			
			for(int i=0; i<exploreLinkImgList.size(); i++){
				List<WebElement> exploreH2 = UtilHBM.listOfWebElement(driver, ".FooterVignettes--text>.footer--elements>.fRight.text-tutoriaux>h2>a");
				String title = exploreH2.get(i).getText().toLowerCase();
				exploreH2.get(i).click();
				String pageTitle = driver.getTitle().toLowerCase();
							
				if(pageTitle.contains("error") || !(pageTitle.contains(title))){
					UtilHBM.reportKO("Error after lick on link in Magzine. Expected Title: " + title + " Actual Title: " + pageTitle);					
				}
				driver.navigate().back();
			}
			
			for(int i=0; i<exploreLinkImgList.size(); i++){
				List<WebElement> exploreH2 = UtilHBM.listOfWebElement(driver, ".FooterVignettes--text>.footer--elements>.fRight.text-tutoriaux>span>a");
				String title = exploreH2.get(i).getText().toLowerCase();;
				exploreH2.get(i).click();
				String pageTitle = driver.getTitle().toLowerCase();;
				if(pageTitle.contains("error") || !(pageTitle.contains(title))){
					UtilHBM.reportKO("Error after lick on link in Magzine. Expected Title: " + title + " Actual Title: " + pageTitle);					
				}
				driver.navigate().back();
			}
			return PageFactory.initElements(driver, Academy.class);
		}
	

}
