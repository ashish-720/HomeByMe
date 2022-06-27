package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourRealisticImage {
	
	WebDriver driver;
	
	public YourRealisticImage(WebDriver driver) {
		this.driver=driver;	
	}
	
	@CacheLookup
	@FindBy(css="body>div>div>.modal-title")
	private WebElement title;
	
	@CacheLookup
	@FindBy(css="body>div>.close-modal.button-close")
	private WebElement closeButton;
	
	@CacheLookup
	@FindBy(css="body>div>div>div>span[data-i18n='project.find_snapshot_high_quality']")
	private WebElement freeTextInPanel;		
	
	@FindBy(css="body>div>div>div>div>.w-33.u-mbs.bloc-thumb-snapshot")
	private List<WebElement> imageList;
	
	@FindBy(css="body>div>div>div>div>div[id*='snapshot'][style='display: none;']")
	private List<WebElement> deletedImageList;
	
	@FindBy(css="body>div>div>div>div>div>img[src='./assets/images/placeholder-inprogress-16-9.jpg']")
	private List<WebElement> imagePlaceHolderList;	
	
	@FindBy(css="body>div>div>div>div>div>.thumbnail-snapshots-state")
	private List<WebElement> dateList; 	
	
	@FindBy(css="body>div>div>div>div>div>div>div>a[class$='delete-snapshot'")
	private List<WebElement> deleteButtonList;	
	
	@FindBy(css="body>div>div>div>div>div>div>div>.button.button--small.button--full")
	private List<WebElement> shareButtonList;
	
	@FindBy(css="body>div>div>div>div>div>div>.w-50.shareBox.shareBox--open>div>div>.addthis_button_facebook")
	private WebElement facebook;
	
	@FindBy(css="body>div>div>div>div>div>div>.w-50.shareBox.shareBox--open>div>div>.addthis_button_twitter")
	private WebElement twitter;
	
	@FindBy(css="body>div>div>div>div>div>div>.w-50.shareBox.shareBox--open>div>div>.addthis_button_pinterest_share")
	private WebElement pinterest;
	
	@FindBy(css="body>div>div>div>div>div>div>.w-50.shareBox.shareBox--open>div>div>.addthis_button_email")
	private WebElement email;
	
	@FindBy (css="body>div>.confirm-box>p")
	private WebElement deleteConfirmMessage;
	
	@FindBy (css="body>div>.confirm-box>div>#snapshot_delete_cancel")
	private WebElement deleteNoButton;
	
	@FindBy (css="body>div>.confirm-box>div>#snapshot_delete_ok")
	private WebElement deleteYesButton;
	
	private WebElement shareButton;
	private WebElement deleteButton;
	private WebElement image;
	private String imgDate;	
	
	private String inProgressPlaceHolderPath = "platform.by.me/assets/images/placeholder-inprogress-16-9.jpg";
	private String facebookIcon = "platform.by.me/assets/images/facebook-cube.svg";
	private String twitterIcon = "platform.by.me/assets/images/twitter-cube.svg";
	private String pinterestIcon = "platform.by.me/assets/images/pinterest-cube.svg";
	private String emailIcon = "platform.by.me/assets/images/email-cube.svg";
	private String hyperlink="platform.by.me";
	private String deleteMessageText = "Are you sure to delete this snapshot ?";
	private String description = "You can always find all your snapshots and realistic images in the media section of your project page.";
	private String newImageUrlStart = "https://byme";	
		
	public RealisticImage verifyNewRealisticImage(String dateTime){
		image = imageList.get(0).findElement(By.tagName("img"));
		UtilHBM.waitFixTime(1000);	
		shareButton = imageList.get(0).findElement(By.cssSelector("div>div>.button.button--small.button--full"));
		deleteButton = imageList.get(0).findElement(By.cssSelector("div>div>.buttonSecondary.button--small.button--full.delete-snapshot"));
		imgDate = imageList.get(0).findElement(By.tagName("span")).getText();
		if(!(title.getText().equalsIgnoreCase("Your realistic image"))){
			UtilHBM.reportKO(" 'Your realistic image' heading not displayed or changed");
		}
		if(!(freeTextInPanel.getText().equalsIgnoreCase(description))){
			UtilHBM.reportKO("Free text in Your Realistic Image page is not displayed or is changed");
		}	
		System.out.println("Image in Your realistic image: " + image.getAttribute("src"));
		if(imgDate.equalsIgnoreCase(dateTime) && image.getAttribute("src").endsWith(inProgressPlaceHolderPath)){
			UtilHBM.reportOK("New Image with 'in-progress' placeholder is available in Your Realistic Image page");
			if(!shareButton.getAttribute("class").endsWith("is-disabled")){
				UtilHBM.reportKO("ShareButton is active for Image with In progress placeholder");
			}
			if(!deleteButton.isDisplayed() || !shareButton.isDisplayed() || deleteButton.getAttribute("class").endsWith("is-disabled")){
				UtilHBM.reportKO("Delete/Share Button is not displayed or Delete button is disabled on new image");
			}			
		}else{
			UtilHBM.reportKO("New Image is not available in Your Realistic Image page. Expected image date: " + dateTime + "Actual date: "+imgDate);			
		}	
		UtilHBM.waitExplicitClickable(driver, closeButton);
		closeButton.click();
		return PageFactory.initElements(driver, RealisticImage.class);
	}
	
	public Snapshot verifyNewScreenshot(String dateTime){
		image = imageList.get(0).findElement(By.tagName("img"));
		UtilHBM.waitFixTime(1000);	
		shareButton = imageList.get(0).findElement(By.cssSelector("div>div>.button.button--small.button--full"));
		deleteButton = imageList.get(0).findElement(By.cssSelector("div>div>.buttonSecondary.button--small.button--full.delete-snapshot"));
		imgDate = imageList.get(0).findElement(By.tagName("span")).getText();
		if(!(title.getText().equalsIgnoreCase("YOUR SCREENSHOT"))){
			UtilHBM.reportKO(" 'Your Screenshot' heading not displayed or changed. The heading is " + title.getText());
		}
		if(!(freeTextInPanel.getText().equalsIgnoreCase(description))){
			UtilHBM.reportKO("Free text in Your Screenshot page is not displayed or is changed");
		}	
		System.out.println("Image in Your Screenshot: " + image.getAttribute("src"));
		if(imgDate.equalsIgnoreCase(dateTime) && image.getAttribute("src").startsWith(newImageUrlStart)
				&& image.getAttribute("src").endsWith(".jpg")){
			UtilHBM.reportOK("New Screenshot Image is available in Your Screenshot page");
			if(shareButton.getAttribute("class").endsWith("is-disabled")){
				UtilHBM.reportKO("ShareButton is not active for new ScreenshotImage");
			}
			if(!deleteButton.isDisplayed() || !shareButton.isDisplayed() || deleteButton.getAttribute("class").endsWith("is-disabled")){
				UtilHBM.reportKO("Delete/Share Button is not displayed or Delete button is disabled on new Screenshot image");
			}			
		}else{
			UtilHBM.reportKO("New image is not available in Your Screenshot page. Expected image date: " + dateTime+ "Actual date: "+imgDate );			
		}	
		UtilHBM.waitExplicitClickable(driver, closeButton);
		closeButton.click();
		return PageFactory.initElements(driver, Snapshot.class);
	}
	
	public RealisticImage shareOptionsCheckHQImage(int imageNumber){
		int imageIndex = imageNumber-1;
		image = imageList.get(imageIndex).findElement(By.tagName("img"));
		UtilHBM.waitExplicitClickable(driver, image);
		String imgLink = image.getAttribute("src");
		shareButton = imageList.get(imageIndex).findElement(By.cssSelector("div>div>a[class='button button--small button--full']"));		
		if(imgLink.endsWith(inProgressPlaceHolderPath)){
			UtilHBM.reportKO("Image is not yet generated to test Share Options");			
		}
		shareButton.click();
		UtilHBM.waitExplicitDisplayed(driver, facebook);
		if(facebook.isDisplayed() && 
				facebook.findElement(By.tagName("img")).getAttribute("src").endsWith(facebookIcon) && 
				facebook.findElement(By.tagName("img")).getAttribute("src").startsWith("https://")){
			if(facebook.getAttribute("addthis:url").equalsIgnoreCase(imgLink) 
					&& facebook.getAttribute("addthis:media").equalsIgnoreCase(imgLink) 
					&& facebook.getAttribute("href").contains(hyperlink)){
				UtilHBM.reportOK("Facebook sharing available with correct image link to be shared");					
			}else{				
				UtilHBM.reportKO("Facebook icon is displayed but the facebook page hyperlink or image link to be shared is not correct");
			}
		}else{
			UtilHBM.reportKO("Facebook option in share is not available");
		}
		if(twitter.isDisplayed() && 
				twitter.findElement(By.tagName("img")).getAttribute("src").endsWith(twitterIcon) &&
				twitter.findElement(By.tagName("img")).getAttribute("src").startsWith("https://")){
			if(twitter.getAttribute("addthis:url").equalsIgnoreCase(imgLink) 
					&& twitter.getAttribute("href").contains(hyperlink)){
				UtilHBM.reportOK("twitter sharing available with correct image link to be shared");					
			}else{
				UtilHBM.reportKO("twitter icon is displayed but the twitter page hyperlink or image link to be shared is not correct");
			}
		}else{
			UtilHBM.reportKO("twitter option in share is not available");
		}
		if(pinterest.isDisplayed() && 
				pinterest.findElement(By.tagName("img")).getAttribute("src").endsWith(pinterestIcon) &&
				pinterest.findElement(By.tagName("img")).getAttribute("src").startsWith("https://")){
			if(pinterest.getAttribute("addthis:media").equalsIgnoreCase(imgLink) 
					&& pinterest.getAttribute("href").contains(hyperlink)){
				UtilHBM.reportOK("Pinterest sharing available with correct image link to be shared");					
			}else{
				UtilHBM.reportKO("Pinterest icon is displayed but the twitter page hyperlink or image link to be shared is not correct");
			}
		}else{
			UtilHBM.reportKO("Pinterest option in share is not available");
		}
		if(email.isDisplayed() && 
				email.findElement(By.tagName("img")).getAttribute("src").endsWith(emailIcon) &&
				email.findElement(By.tagName("img")).getAttribute("src").startsWith("https://")){
			if(email.getAttribute("addthis:url").equalsIgnoreCase(imgLink) 
					&& email.getAttribute("href").contains(hyperlink)){
				UtilHBM.reportOK("Email sharing available with correct image link to be shared");					
			}else{
				UtilHBM.reportKO("Email icon is displayed but the twitter page hyperlink or image link to be shared is not correct");
			}
		}else{
			UtilHBM.reportKO("Email option in share is not available");
		}	
		closeButton.click();
		return PageFactory.initElements(driver, RealisticImage.class);
	}
	
	public Snapshot shareOptionsCheckScreenshot(int imageNumber){
		int imageIndex = imageNumber-1;
		image = imageList.get(imageIndex).findElement(By.tagName("img"));
		UtilHBM.waitExplicitClickable(driver, image);
		String imgLink = image.getAttribute("src");
		shareButton = imageList.get(imageIndex).findElement(By.cssSelector("div>div>a[class='button button--small button--full']"));		
		if(imgLink.endsWith(inProgressPlaceHolderPath)){
			UtilHBM.reportKO("Image is not yet generated to test Share Options");			
		}
		shareButton.click();
		if(facebook.isDisplayed() && 
				facebook.findElement(By.tagName("img")).getAttribute("src").endsWith(facebookIcon) &&
				facebook.findElement(By.tagName("img")).getAttribute("src").startsWith("https://")){
			if(facebook.getAttribute("addthis:url").equalsIgnoreCase(imgLink) 
					&& facebook.getAttribute("addthis:media").equalsIgnoreCase(imgLink) 
					&& facebook.getAttribute("href").contains(hyperlink)){
				UtilHBM.reportOK("Facebook sharing available with correct image link to be shared");					
			}else{
				UtilHBM.reportKO("Facebook icon is displayed but the facebook page hyperlink or image link to be shared is not correct");
			}
		}else{
			UtilHBM.reportKO("Facebook option in share is not available");
		}
		if(twitter.isDisplayed() && 
				twitter.findElement(By.tagName("img")).getAttribute("src").endsWith(twitterIcon) &&
				twitter.findElement(By.tagName("img")).getAttribute("src").startsWith("https://")){
			if(twitter.getAttribute("addthis:url").equalsIgnoreCase(imgLink) 
					&& twitter.getAttribute("href").contains(hyperlink)){
				UtilHBM.reportOK("twitter sharing available with correct image link to be shared");					
			}else{
				UtilHBM.reportKO("twitter icon is displayed but the twitter page hyperlink or image link to be shared is not correct");				
			}
		}else{
			UtilHBM.reportKO("twitter option in share is not available");
		}
		if(pinterest.isDisplayed() && 
				pinterest.findElement(By.tagName("img")).getAttribute("src").endsWith(pinterestIcon) &&
				pinterest.findElement(By.tagName("img")).getAttribute("src").startsWith("https://")){
			if(pinterest.getAttribute("addthis:media").equalsIgnoreCase(imgLink) 
					&& pinterest.getAttribute("href").contains(hyperlink)){
				UtilHBM.reportOK("Pinterest sharing available with correct image link to be shared");					
			}else{
				UtilHBM.reportKO("Pinterest icon is displayed but the twitter page hyperlink or image link to be shared is not correct");
			}
		}else{
			UtilHBM.reportKO("Pinterest option in share is not available");
		}
		if(email.isDisplayed() && 
				email.findElement(By.tagName("img")).getAttribute("src").endsWith(emailIcon) &&
				email.findElement(By.tagName("img")).getAttribute("src").startsWith("https://")){
			if(email.getAttribute("addthis:url").equalsIgnoreCase(imgLink) 
					&& email.getAttribute("href").contains(hyperlink)){
				UtilHBM.reportOK("Email sharing available with correct image link to be shared");					
			}else{
				UtilHBM.reportKO("Email icon is displayed but the twitter page hyperlink or image link to be shared is not correct");
			}
		}else{
			UtilHBM.reportKO("Email option in share is not available");
		}	
		closeButton.click();
		return PageFactory.initElements(driver, Snapshot.class);
	}
	
	public RealisticImage deleteHQImage(int imageNumber, int confirm0ForNo1ForYes){
		int imageIndex = imageNumber-1;		
		image = imageList.get(imageIndex).findElement(By.tagName("img"));
		UtilHBM.waitExplicitDisplayed(driver, image);		
		deleteButton = imageList.get(imageIndex).findElement(By.cssSelector("div>div>.buttonSecondary.button--small.button--full.delete-snapshot"));
		deleteButton.click();
		UtilHBM.waitExplicitDisplayed(driver, deleteConfirmMessage);
		if(!deleteConfirmMessage.getText().equalsIgnoreCase(deleteMessageText)){
			UtilHBM.reportKO("Delete confirmation message is not correct or changed");
		}
		if(confirm0ForNo1ForYes==0){
			deleteNoButton.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			if(deletedImageList.size()==0){
				UtilHBM.reportOK("Image is not deleted after click on 'No' in delete confirmation message");
			}else{
				UtilHBM.reportKO("Image is deleted after click on 'No' in delete confirmation message");
			}			
		}else{
			deleteYesButton.click();			
			if(deletedImageList.size()==1){
				UtilHBM.reportOK("Image deleted after click on 'Yes' in delete confirmation message");
			}else{
				UtilHBM.reportKO("No or more than one image is deleted after click on 'Yes' in delete confirmation message");
			}			
		}
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.waitFixTime(1000);
		closeButton.click();
		return PageFactory.initElements(driver, RealisticImage.class);		
	}
	
	public Snapshot deleteScreenshot(int imageNumber, int confirm0ForNo1ForYes){
		int imageIndex = imageNumber-1;		
		image = imageList.get(imageIndex).findElement(By.tagName("img"));
		UtilHBM.waitExplicitDisplayed(driver, image);		
		deleteButton = imageList.get(imageIndex).findElement(By.cssSelector("div>div>.buttonSecondary.button--small.button--full.delete-snapshot"));
		deleteButton.click();
		UtilHBM.waitExplicitClickable(driver, deleteConfirmMessage);
		if(!deleteConfirmMessage.getText().equalsIgnoreCase(deleteMessageText)){
			UtilHBM.reportKO("Delete confirmation message is not correct or changed. Expected message: "+ deleteMessageText + "Actual Text: "+ deleteConfirmMessage.getText());
		}
		if(confirm0ForNo1ForYes==0){
			deleteNoButton.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			if(deletedImageList.size()==0){
				UtilHBM.reportOK("Image is not deleted after click on 'No' in delete confirmation message");
			}else{
				UtilHBM.reportKO("Image is deleted after click on 'No' in delete confirmation message");
			}			
		}else{
			deleteYesButton.click();			
			if(deletedImageList.size()==1){
				UtilHBM.reportOK("Image deleted after click on 'Yes' in delete confirmation message");
			}else{
				UtilHBM.reportKO("No or more than one image is deleted after click on 'Yes' in delete confirmation message");
			}			
		}
		UtilHBM.turnOnImplicitWaits(driver);		
		UtilHBM.waitFixTime(1000);
		closeButton.click();
		return PageFactory.initElements(driver, Snapshot.class);		
	}
}
