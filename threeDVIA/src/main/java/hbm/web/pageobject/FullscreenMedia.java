package hbm.web.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class FullscreenMedia {
	WebDriver driver;
	
	public FullscreenMedia(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath="//div[starts-with(@class,'swiper-slide swiper-slide-active')]/div[@class='swiper-zoom-container']/img[starts-with(@src,'https:')]")
	private WebElement fullScrnImg;
	
	@FindBy(xpath="//button[@class='swiper-button-prev']")
	private WebElement sliderPrevious;
	
	@FindBy(xpath="//button[@class='swiper-button-next']")
	private WebElement sliderNext;
	
	@FindBy(xpath="//article[@id='slider-overlay']/button[@class='button-close button-close--light']")
	private WebElement closeFullScreenMedia;
	
	@FindBy(css="div.media>div")
	List<WebElement> mediaList;

	@FindBy(css="button.buttonSecondary")
	private WebElement deleteMediaNo;
	
	@FindBy(css="div.confirm-box-btns>button.button")
	private WebElement deleteMediaYes;
	
	@FindBy(css="div.confirm-box>p")
	private WebElement deleteDialogBoxText;
	
	public ProjectPage verifyFullscreenMedia(String projectOwnership,String mediaType, int mediaCount) {
		if (!(mediaType.equalsIgnoreCase("360° Images") || mediaType.equalsIgnoreCase("All Medias"))) {
			UtilHBM.waitExplicitDisplayed(driver,fullScrnImg);
			Verification.displayOfWebElement(fullScrnImg);							
			WebElement shareButton11=driver.findElement(By.xpath("//div[starts-with(@class,'swiper-slide swiper-slide-active')]/div/div/ul/li/span/i[@class='icon icon-share u-fs20']/.."));
			UtilHBM.waitExplicitDisplayed(driver, shareButton11);
			UtilHBM.waitExplicitClickable(driver, shareButton11);
			if (projectOwnership.equalsIgnoreCase("own")) {
				WebElement deleteButton11 = driver.findElement(By.xpath("//div[starts-with(@class,'swiper-slide swiper-slide-active')]/div/div/ul/li/span/i[@class='icon icon-trash u-fs20']/../.."));
				Verification.displayOfWebElement(deleteButton11);
			}
			WebElement downloadButton11 = driver.findElement(By.xpath("//div[starts-with(@class,'swiper-slide swiper-slide-active')]/div/div/ul/li/span/i[@class='icon icon-download']/../.."));
			UtilHBM.waitExplicitDisplayed(driver, downloadButton11);
			Verification.displayOfWebElement(downloadButton11);
			Verification.displayOfWebElement(shareButton11);	
			shareButton11.click();
			UtilHBM.waitFixTime(1000);
			ShareContainer shareContainer=PageFactory.initElements(driver, ShareContainer.class);
			shareContainer.verifyShareContainer("media").closeShareContainer();
		}	
		if (mediaCount > 1) {
			UtilHBM.waitExplicitDisplayed(driver, sliderNext);
			Verification.displayOfWebElement(sliderNext);
			UtilHBM.waitExplicitDisplayed(driver, sliderPrevious);
			Verification.displayOfWebElement(sliderPrevious);
		}
		closeFullScreenMedia();
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	public ProjectPage sharemediaFullscreen(String filterMediaText) {
//	public ProjectPageMediaTab sharemediaFullscreen(String filterMediaText) {
		if (!filterMediaText.equalsIgnoreCase("360° Images")) {
			UtilHBM.waitExplicitDisplayed(driver, fullScrnImg);
			Verification.displayOfWebElement(fullScrnImg);
			WebElement shareButton11 = driver.findElement(By.xpath(
					"//div[starts-with(@class,'swiper-slide swiper-slide-active')]/div/div/ul/li/span/i[@class='icon icon-share u-fs20']/.."));
			UtilHBM.waitExplicitDisplayed(driver, shareButton11);
			UtilHBM.waitExplicitClickable(driver, shareButton11);
			Verification.displayOfWebElement(shareButton11);
			shareButton11.click();
			UtilHBM.waitFixTime(1000);
			ShareContainer shareContainer = PageFactory.initElements(driver, ShareContainer.class);
			shareContainer.shareMedia().closeShareContainer();
		}
		UtilHBM.waitExplicitClickable(driver, closeFullScreenMedia);
		closeFullScreenMedia();
//		return PageFactory.initElements(driver, ProjectPageMediaTab.class);
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	public ProjectPage deleteFullScreenMedia(String filterMediaText, String deleteActionYesOrNo) {
		if (!filterMediaText.equalsIgnoreCase("360° Images")) {
			UtilHBM.waitExplicitDisplayed(driver, fullScrnImg);
			Verification.displayOfWebElement(fullScrnImg);
			WebElement deleteButton11 = driver.findElement(By.xpath(
					"//div[starts-with(@class,'swiper-slide swiper-slide-active')]/div/div/ul/li/span/i[@class='icon icon-trash u-fs20']/../.."));
			UtilHBM.waitExplicitDisplayed(driver, deleteButton11);
			UtilHBM.waitExplicitClickable(driver, deleteButton11);
			Verification.displayOfWebElement(deleteButton11);
			deleteButton11.click();
			UtilHBM.waitExplicitClickable(driver, deleteMediaNo);
			Verification.displayOfWebElement(deleteMediaNo);
			Verification.displayOfWebElement(deleteMediaYes);
			Verification.VerifyEquals("Wrong delete dialog box text", deleteDialogBoxText.getText(),
					"Are you sure you want to delete this media?");
			UtilHBM.reportInfo("Delete fullscreen media decision :" + deleteActionYesOrNo);
			if (deleteActionYesOrNo.equalsIgnoreCase("yes")) {
				deleteMediaYes.click();
				UtilHBM.waitTillElementDisappear(driver, "div.confirm>div.confirm-box");

			} else if (deleteActionYesOrNo.equalsIgnoreCase("no")) {
				deleteMediaNo.click();
				UtilHBM.waitTillElementDisappear(driver, "div.confirm>div.confirm-box");
				UtilHBM.waitExplicitClickable(driver, closeFullScreenMedia);
				closeFullScreenMedia();
			}
		} else {
			UtilHBM.reportInfo("Wrong filterMediaText!!");
		}
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	public ProjectPage closeFullScreenMedia() {
		UtilHBM.waitExplicitClickable(driver, closeFullScreenMedia);
		closeFullScreenMedia.click();
//		UtilHBM.waitTillElementDisappear(driver, closeFullScreenMedia);
		return PageFactory.initElements(driver, ProjectPage.class);
	} 
	
	public ProjectPage verifyFullscreenMediaMobile(String projectOwnership,String mediaType, int mediaCount) {
		if (!(mediaType.equalsIgnoreCase("360° Images") || mediaType.equalsIgnoreCase("All Medias"))) {
			UtilHBM.waitExplicitDisplayed(driver,fullScrnImg);
			Verification.displayOfWebElement(fullScrnImg);							
			WebElement shareButton11=driver.findElement(By.xpath("//div[starts-with(@class,'swiper-slide swiper-slide-active')]/div/div/ul/li/span/i[@class='icon icon-share u-fs20']/.."));
			UtilHBM.waitExplicitDisplayed(driver, shareButton11);
			UtilHBM.waitExplicitClickable(driver, shareButton11);
			if (projectOwnership.equalsIgnoreCase("own")) {
				WebElement deleteButton11 = driver.findElement(By.xpath("//div[starts-with(@class,'swiper-slide swiper-slide-active')]/div/div/ul/li/span/i[@class='icon icon-trash u-fs20']/../.."));
				Verification.displayOfWebElement(deleteButton11);
			}
			WebElement downloadButton11 = driver.findElement(By.xpath("//div[starts-with(@class,'swiper-slide swiper-slide-active')]/div/div/ul/li/span/i[@class='icon icon-download']/../.."));
			UtilHBM.waitExplicitDisplayed(driver, downloadButton11);
			Verification.displayOfWebElement(downloadButton11);
			Verification.displayOfWebElement(shareButton11);	
			shareButton11.click();
			UtilHBM.waitFixTime(1000);
			ShareContainer shareContainer=PageFactory.initElements(driver, ShareContainer.class);
			shareContainer.verifyShareContainerMobile("media").closeShareContainer();
		}	
		if (mediaCount > 1) {
			UtilHBM.waitExplicitDisplayed(driver, sliderNext);
			Verification.displayOfWebElement(sliderNext);
			UtilHBM.waitExplicitDisplayed(driver, sliderPrevious);
			Verification.displayOfWebElement(sliderPrevious);
		}
		closeFullScreenMedia();
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
}
