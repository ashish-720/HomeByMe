package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.IFactoryAnnotation;

public class HQImageSize {

	WebDriver driver;
	public HQImageSize(WebDriver driver) {
		this.driver = driver;		
	}
	
	@FindBy(css="#choose-quality-sublayer>header>button>.icon-view-close")
	private WebElement closeButton;	
	
	@FindBy(xpath="//input[@id='Free']/..")
	private WebElement stdDefinitionOption;
	
	@FindBy(css=".form-radio.radio-picture>label[for='Free']>.label>.title")
	private WebElement stdDefinitionLabel;
	
	@FindBy(css=".form-radio.radio-picture>label[for='Free']>.label>.subtitle")
	private WebElement stdDefinitionSizeLabel;
	
	@FindBy(css="label[for='Free']>.label-price>span.text+span>span+span")
	private WebElement stdDefinitionCredits;
	
	@FindBy(xpath="//input[@id='High']/..")
	private WebElement highDefinitionImageOption;
	
	@FindBy(css=".form-radio.radio-picture>label[for='High']>.label>.title")
	private WebElement highDefinitionImgLabel;
	
	@FindBy(css="label[for='High']>.label>.subtitle")
	private WebElement highDefinitionImgSizeLabel;
	
	@FindBy(css="label[for='High']>.label-price")
	private WebElement highDefinitionImgCredits;
	
//	@FindBy(css="#media-name")
//	private WebElement imageNameInputBox;
	
	@FindBy(css=".content-footer>button[data-ui-selector='quality-chosen']")
	private WebElement createYourRealiticImageBtn;
	
	@FindBy(css="#High>.info>p")
	private WebElement limitReachedMsgHigh;
	
	@FindBy(css=".content-header>.subtitle>span")
	private WebElement subscribeMsg;
	
	@FindBy(css=".content-header>.subtitle>button")
	private WebElement subscribeLearnMoreLink;	
	
	@FindBy(id=".label-price>button.cta-primary-sm")
	private WebElement buyCreditsBtn;	
	
	@FindBy(css="header>.icon-action-fail+h4")
	private WebElement errorOccurredMsg;
	
	public Message sendHQImageRequest(String smallOrLarge){
		UtilHBM.waitExplicitClickable(driver, stdDefinitionOption);
		verifyImageQualityPage();
		selectImageQuality(smallOrLarge)
		.verifyImageQualitySelection(smallOrLarge);
		clickCreateButton();
//		UtilHBM.waitTillElementDisappear(driver, ".jquery-modal.blocker");		
		return PageFactory.initElements(driver, Message.class);
	}
	
	public Message sendHQImageRequest(String smallOrLarge, String noOfHQCreditsavailable){
		UtilHBM.waitExplicitClickable(driver, stdDefinitionOption);
		verifyImageQualityPage(noOfHQCreditsavailable);
		verifyImageQualityPage();
		selectImageQuality(smallOrLarge)
		.verifyImageQualitySelection(smallOrLarge);
		clickCreateButton();
//		UtilHBM.waitTillElementDisappear(driver, ".jquery-modal.blocker");		
		return PageFactory.initElements(driver, Message.class);
	}
		
	private HQImageSize selectImageQuality(String smallOrLarge){
		if(smallOrLarge.equalsIgnoreCase("small")){
			UtilHBM.waitExplicitClickable(driver, stdDefinitionOption);
			stdDefinitionOption.click();
		}else{
			UtilHBM.waitExplicitClickable(driver, highDefinitionImageOption);
			highDefinitionImageOption.click();
		}
		return PageFactory.initElements(driver, HQImageSize.class);
	}
	private void verifyImageQualitySelection(String smallOrLarge){
		WebElement selectionState;
		if(smallOrLarge.equalsIgnoreCase("small")){
			selectionState = stdDefinitionOption.findElement(By.tagName("input"));
			if (!selectionState.isSelected()){
				UtilHBM.reportKO("Low Resolution option not selected for HQ image request");
			}
		}else{
			selectionState = highDefinitionImageOption.findElement(By.tagName("input"));
			if(!selectionState.isSelected()){
				UtilHBM.reportKO("High Resolution option not selected for HQ image request");
			}		
		}
	}
	
	private Message clickCreateButton(){
		createYourRealiticImageBtn.click();
		return PageFactory.initElements(driver, Message.class);
	}
	
	private void verifyImageQualityPage(String noOfHQCreditsavailable){
		Verification.displayNAttributeCheckOfElement(stdDefinitionLabel, "Low Resolution lable", "text", "Standard definition");
		Verification.displayNAttributeCheckOfElement(stdDefinitionSizeLabel, "Low Resolution Size label", "text", "(640x360px)");
		Verification.displayNAttributeCheckOfElement(stdDefinitionCredits, "Low Resolution Credits", "text", "Unlimited");
		Verification.displayNAttributeCheckOfElement(highDefinitionImgLabel, "Realitic Image lable", "text", "High definition");
		Verification.displayNAttributeCheckOfElement(highDefinitionImgSizeLabel, "Realitic Image Size lable", "text", "(1920x1080px)");
		if(noOfHQCreditsavailable.equalsIgnoreCase("Unlimited")){
			Verification.displayNAttributeCheckOfElement(highDefinitionImgCredits, "Realitic Image Credits", "text", "Unlimited");
		}else{
			Verification.displayNAttributeCheckOfElement(highDefinitionImgCredits, "Realitic Image Credits", "text", noOfHQCreditsavailable);
			Verification.displayNAttributeCheckOfElement(subscribeMsg, "Subscribe message", "text", "Subscribe to get unlimited HD images");
			Verification.displayNAttributeCheckOfElement(subscribeLearnMoreLink, "Subscribe Learn more link", "text", "more info");			
		}
	}
	
	private void verifyImageQualityPage(){
		Verification.displayNAttributeCheckOfElement(stdDefinitionLabel, "Low Resolution lable", "text", "Standard definition");
		Verification.displayNAttributeCheckOfElement(stdDefinitionSizeLabel, "Low Resolution Size label", "text", "(640x360px)");
		Verification.displayNAttributeCheckOfElement(stdDefinitionCredits, "Low Resolution Credits", "text", "Unlimited");
		Verification.displayNAttributeCheckOfElement(highDefinitionImgLabel, "Realitic Image lable", "text", "High definition");
		Verification.displayNAttributeCheckOfElement(highDefinitionImgSizeLabel, "Realitic Image Size lable", "text", "(1920x1080px)");
	}
}
