package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyImages {
	
	WebDriver driver;
	
	public MyImages(WebDriver driver) {
		 this.driver=driver;
	}
	
	
	@FindBy(css=".mod-layer-medias.mod-open header>div>div>h3.title")
	private WebElement title;
	
	@FindBy(css=".mod-layer-medias.mod-open header>div>div>.info")
	private WebElement titleInfo;
	
	@FindBy(css=".mod-layer-medias.mod-open>div>header>div>div>.cta-primary-alt-l")
	private WebElement okBtn;
	
	@FindBy(css=".mod-filters-tab>ul>li>button[data-ui-filter='all']")
	private WebElement allTab;
	
	@FindBy(css=".mod-filters-tab>ul>li>button[data-ui-filter='realistic']")
	private WebElement realisticTab;
	
	@FindBy(css=".mod-filters-tab>ul>li>button[data-ui-filter='360']")
	private WebElement panoramicTab;
	
	@FindBy(css=".mod-filters-tab>ul>li>button[data-ui-filter='snapshot']")
	private WebElement snapshotTab;
	
	@FindBy(css=".mod-medias-list>.medias-item[data-ui-visible-in-filter='true']>.inner-container")
	private List<WebElement> allMediaList;
	
	@FindBy(css=".mod-medias-list>.medias-item[data-ui-media-type='realistic'][data-ui-visible-in-filter='true']>.inner-container")
	private List<WebElement> realisticMediaList;
	
	@FindBy(css=".mod-medias-list>.medias-item[data-ui-media-type='360'][data-ui-visible-in-filter='true']>.inner-container")
	private List<WebElement> panoramicMediaList;
	
	@FindBy(css=".mod-medias-list>.medias-item[data-ui-media-type='snapshot'][data-ui-visible-in-filter='true']>.inner-container")
	private List<WebElement> snapshotMediaList;
	
	
	protected MyImages all(){
		allTab.click();		
		return this;
	}
	
	public int getMediaCount(String tab){
		int count=0;
		switch (tab.toLowerCase()) {
		case "all":
			count=Integer.parseInt(allTab.findElement(By.className("counter")).getText());
			break;
		case "realistic":
		count=Integer.parseInt(realisticTab.findElement(By.className("counter")).getText());
		break;
		case "360":
			count=Integer.parseInt(panoramicTab.findElement(By.className("counter")).getText());
			break;
		case "snapshot":
			count=Integer.parseInt(snapshotTab.findElement(By.className("counter")).getText());
			break;		
		default:
			break;
		}		
		return count;
	}
	
	protected MyImages activateTab(String tab, int noOfMedia) {
		switch (tab.toLowerCase()) {
		case "all":
			if(!(allTab.getAttribute("class").contains("active"))){
				allTab.click();
				UtilHBM.waitExplicitDisplayed(driver, "//button[@class='bt-filter-tab active'][@data-ui-filter='all']");	
			}			
			if(!(allMediaList.size()==noOfMedia)){
				UtilHBM.reportKO("All images in 'All' tab are not displayed. Number of images expected = "+noOfMedia+ ", actual images displayed= "+allMediaList.size());
			}
			break;
		case "realistic":
			if(!(realisticTab.getAttribute("class").contains("active"))){
				realisticTab.click();
				UtilHBM.waitExplicitDisplayed(driver, "//button[@class='bt-filter-tab active'][@data-ui-filter='realistic']");	
			}			
			if(!(realisticMediaList.size()==noOfMedia)){
				UtilHBM.reportKO("All images in 'Realistic images' tab are not displayed. Number of HQ images expected = "+noOfMedia+ ", actual images displayed= "+realisticMediaList.size());
			}
		break;
		case "360":
			panoramicTab.click();
			UtilHBM.waitExplicitDisplayed(driver, "//button[@class='bt-filter-tab active'][@data-ui-filter='360']");
			if(!(panoramicMediaList.size()==noOfMedia)){
				UtilHBM.reportKO("All images in '360 images' tab are not displayed. Number of images expected = "+noOfMedia+ ", actual images displayed= "+panoramicMediaList.size());
			}
			break;
		case "snapshot":
			snapshotTab.click();
			UtilHBM.waitExplicitDisplayed(driver, "//button[@class='bt-filter-tab active'][@data-ui-filter='snapshot']");
			if(!(snapshotMediaList.size()==noOfMedia)){
				UtilHBM.reportKO("All images in 'Snapshot images' tab are not displayed. Number of images expected = "+noOfMedia+ ", actual images displayed= "+snapshotMediaList.size());
			}
			break;		
		default:
			break;
		}			
		return this;
	}
	
	public MyImages checkImageCount(int realistic, int panoramic, int snapshot) {
		if(realistic!=0 && panoramic!=0 && snapshot!=0){
			int allCount=Integer.parseInt(allTab.findElement(By.className("counter")).getText());
			if(realistic!=0){
				int hqCount=Integer.parseInt(realisticTab.findElement(By.className("counter")).getText());
				if(!(realistic==hqCount)){
					UtilHBM.reportKO("Realtic image count is not correct. Expected images = "+realistic+ ", actual images = " + hqCount);
				}
			}
			if(panoramic!=0){
				int hq360Count=Integer.parseInt(panoramicTab.findElement(By.className("counter")).getText());
				if(!(panoramic==hq360Count)){
					UtilHBM.reportKO("360 image count is not correct. Expected images = "+panoramic+ ", actual images = " + hq360Count);
				}
			}
			if(snapshot!=0){
				int snapCount=Integer.parseInt(snapshotTab.findElement(By.className("counter")).getText());	
				if(!(snapshot==snapCount)){
					UtilHBM.reportKO("Snapshot image count is not correct. Expected images = "+snapshot+ ", actual images = " + snapCount);
				}
			}	
			if(!(allCount==realistic+panoramic+snapshot)){
				UtilHBM.reportKO("Image count in 'All' tab is not correct. Expected images = "+realistic+panoramic+snapshot+ ", actual images = " + allCount);
			}
		}
		return PageFactory.initElements(driver, MyImages.class);
		
	}
	
	public MyImages deleteMedia(int index, String mediaType, int noOfMediaOfType, boolean deleteConfirm) {
		int noOfMedia = getMediaCount(mediaType);
		int noOfAllMedia = getMediaCount("all");
		activateTab(mediaType, noOfMediaOfType);
		new Actions(driver).moveToElement(allMediaList.get(index)).pause(500)
		.click(allMediaList.get(index).findElement(By.cssSelector("button[title='Delete']"))).build().perform();
		WebElement confirmMsgTitle = allMediaList.get(index).findElement(By.cssSelector(".inner-overlay>.title"));
		WebElement yesBtn = allMediaList.get(index).findElement(By.cssSelector(".inner-overlay>.cta-primary"));
		WebElement noBtn = allMediaList.get(index).findElement(By.cssSelector(".inner-overlay>.cta-secondary"));
		Verification.displayNAttributeCheckOfElement(confirmMsgTitle, "Delete confirmation title", "text", "Delete this media?");
		if(deleteConfirm){
			yesBtn.click();
			if(!(getMediaCount(mediaType)==noOfMedia-1 && allMediaList.size()==noOfMedia-1 && getMediaCount("all")==noOfAllMedia-1)){
				UtilHBM.reportKO(mediaType + index +"is not deleted. Before delete the media count was "+ noOfMedia +" & after delete it is "+getMediaCount(mediaType));
			}
		}else{
			noBtn.click();
			if(!(getMediaCount(mediaType)==noOfMedia && allMediaList.size()==noOfMedia)){
				UtilHBM.reportKO(mediaType + index +"is deleted. Before delete the media count was "+ noOfMedia +" & after delete it is "+getMediaCount(mediaType));
			}
		}
		return PageFactory.initElements(driver, MyImages.class);
	}
	
	public MyImages shareMediaFrmPreview(int index, String mediaType, int noOfMediaOfType) {
		activateTab(mediaType, noOfMediaOfType);
		String imageSrc=allMediaList.get(index).findElement(By.tagName("img")).getAttribute("src");
		String image = imageSrc.split("_")[0];
		UtilHBM.waitExplicitDisplayed(driver, allMediaList.get(index));
		new Actions(driver).moveToElement(allMediaList.get(index)).build().perform();
		WebElement shareBtn = allMediaList.get(index).findElement(By.cssSelector("span[class='icon-action-share']"));
		UtilHBM.waitExplicitDisplayed(driver, shareBtn);
		shareBtn.click();
		Share share = PageFactory.initElements(driver, Share.class);
		share.verifyShare(image, mediaType);
		return PageFactory.initElements(driver, MyImages.class);
	}
	
	public ThreeDPlanner closeMyImages() {		
		okBtn.click();
		UtilHBM.waitExplicitClickable(driver, UtilHBM.webElement(driver, "#canvas"));
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	

}
