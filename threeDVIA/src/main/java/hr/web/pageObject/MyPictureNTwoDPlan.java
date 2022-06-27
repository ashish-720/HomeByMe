package hr.web.pageObject;


import java.util.List;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import hr.planner.pageObject.PopUpLayer1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyPictureNTwoDPlan {

	WebDriver driver;

	public MyPictureNTwoDPlan(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css = ".project-medias-header-actions>button>.icon-action-print")
	private WebElement print;
	
	@FindBy(css = ".tt-3>[data-i18n='project_overview.medias_layer.filters.snapshot']")
	private WebElement snapshots;
	
	@FindBy(css = ".medias-item>.inner-container")
	private WebElement snapshotOne;
	
	
	//write download, delete and share for each media
	
	@FindBy(css = ".tt-3>[data-ui-id='snapshot-sum']")
	private WebElement spanshotsCount;
	
	@FindBy(css = "[data-ui-selector='media-type-3']>.mod-medias-list>.medias-item")
	List<WebElement> screenshotImages;
	
	@FindBy(css = "[data-ui-selector='media-type-2']>.mod-medias-list>.medias-item")
	List<WebElement> realisticImages;
	
	@FindBy(css = "[data-ui-selector='media-type-1']>.mod-medias-list>.medias-item")
	List<WebElement> images360;
	
	public Print printInMyPicture(){
		
		print.click();
		UtilHBM.waitFixTime(1000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.cssSelector("[id='layer-iframe']>iframe")));
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "[data-i18n='print.print_title']"));
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "[data-i18n='print.print_title']"));
		return PageFactory.initElements(driver, Print.class);
	}
	
	public MyPictureNTwoDPlan screenshot(int noOfimages){
		
		UtilHBM.waitExplicitDisplayed(driver, screenshotImages.get(0));
		int noOfScreebshotImages = screenshotImages.size();
		if (noOfScreebshotImages == noOfimages) {
			UtilHBM.reportOK("No of Images in screenshot  are same as No of screenshot");
		} else {
			UtilHBM.reportKO("No of Images in screenshot tab are not same as No of screenshot. All screenshot Images : "
					+ noOfScreebshotImages + " No Of screenshot : " + noOfimages);
		}
		
		return PageFactory.initElements(driver, MyPictureNTwoDPlan.class);
	}
	
	public MyPictureNTwoDPlan realistic(int noOfimages){
		
		UtilHBM.waitExplicitDisplayed(driver, realisticImages.get(0));
		int noOfRealisticImages = realisticImages.size();
		if (noOfRealisticImages == noOfimages) {
			UtilHBM.reportOK("No of Images in realistic  are same as No of realistic");
		} else {
			UtilHBM.reportKO("No of Images in realistic tab are not same as No of realistic. All realistic Images : "
					+ noOfRealisticImages + " No Of realistic : " + noOfimages);
		}
		
		return PageFactory.initElements(driver, MyPictureNTwoDPlan.class);
	}
	
	public MyPictureNTwoDPlan image360Generated(int noOfimages){
		
		UtilHBM.waitExplicitDisplayed(driver, images360.get(0));
		int noOf360Images = images360.size();
		if (noOf360Images == noOfimages) {
			UtilHBM.reportOK("No of Images in 360  are same as No of 360");
		} else {
			UtilHBM.reportKO("No of Images in 360 tab are not same as No of 360. All 360 Images : "
					+ noOf360Images + " No Of 360 images : " + noOfimages);
		}
		
		//images360.get(0);
		new Actions(driver).moveToElement(images360.get(0)).build().perform();
		WebElement imageOf360 = images360.get(0).findElement(By.cssSelector(".inner-container>img"));
		UtilHBM.waitExplicitDisplayed(driver, imageOf360);
		Verification.displayOfWebElement(imageOf360);
		
		
		
		return PageFactory.initElements(driver, MyPictureNTwoDPlan.class);
	}
	
	public PopUpLayer1 share360(){
		
		new Actions(driver).moveToElement(images360.get(0)).build().perform();
		WebElement share360 = images360.get(0).findElement(By.cssSelector(".inner-container>ul [data-ui-action='media-share']"));
		share360.click();
		
		return PageFactory.initElements(driver, PopUpLayer1.class);
	}
	
	public PopUpLayer1 shareRealisticImage(){
		
		new Actions(driver).moveToElement(realisticImages.get(0)).build().perform();
		WebElement shareRealisticImage = realisticImages.get(0).findElement(By.cssSelector(".inner-container>ul [data-ui-action='media-share']"));
		shareRealisticImage.click();
		
		return PageFactory.initElements(driver, PopUpLayer1.class);
	}
	
	public PopUpLayer1 shareScreenshot(){
		
		new Actions(driver).moveToElement(screenshotImages.get(0)).build().perform();
		WebElement shareScreenshotImage = screenshotImages.get(0).findElement(By.cssSelector(".inner-container>ul [data-ui-action='media-share']"));
		shareScreenshotImage.click();
		
		return PageFactory.initElements(driver, PopUpLayer1.class);
	}
	//make for screenshot also
	
	
}
