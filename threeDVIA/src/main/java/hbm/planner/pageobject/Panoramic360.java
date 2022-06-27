package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Panoramic360 {
	WebDriver driver;
	
	public Panoramic360(WebDriver driver) {
	this.driver = driver;
	}	
	
	@FindBy(css="body>div>div>.icon.icon-panoramic")
	private WebElement panoramicIconPopup;
	
	@FindBy(css="body>div>div>.modal-title")
	private WebElement panoramicTitlePopup;
	
	@FindBy(css="body>div>div>div>div>div>div>.u-center.modal-description.slick-slide")
	private List<WebElement> slideList;
	
	@FindBy(css="body>div>div>div>div>div>div>div[data-slick-index='0']>span[data-i18n='command.popin.panoramic_title']")
	private WebElement popupSlide1P1;
	
	@FindBy(css="body>div>div>div>div>div>div>div[data-slick-index='0']>iframe")
	private WebElement popupSlide1360Tour;
	
	@FindBy(css="body>div>div>div>div>div>div>div>.step-description>.u-center.u-mts")
	private WebElement popupSlide1P2;	
		
	@FindBy(css="body>div>div>div>div>div>.slick-dots>li")
	private List<WebElement> dotList;
	
	@FindBy(css="body>div>div>div>div>div>div>div[aria-describedby*='slick-slide']>.icon-vr>img")
	private WebElement vrIcon;		
	
	@FindBy(css="body>div>div>div>div>div>#next")
	private WebElement nextButton;
	
	@FindBy(css="body>div>div>div>div>div>div>div[aria-describedby*='slick-slide']>img")
	private WebElement popupSlide2Img;
	
	@FindBy(css="body>div>div>div>div>div>div>div[aria-describedby*='slick-slide']>div>span[data-i18n='command.popin.panoramic_txt1']")
	private WebElement popupSlide2P1;
	
	@FindBy(css="body>div>div>div>div>div>div>div[aria-describedby*='slick-slide']>div>span[data-i18n='command.popin.panoramic_txt2']")
	private WebElement popupSlide2P2;
	
	@FindBy(css="body>div>div>div>div>div>#getStarted")
	private WebElement nextButtonGetStarted;
	
	@FindBy(css="body>div>div>div>div>div>#dontShowPopin")
	private WebElement dontShowPopinCheckBox;
	
	@FindBy(css="body>div>div>div>div>div>.dont-show-popin-label")
	private WebElement dontShowPopinLabel;
	
	@FindBy(css="body>div>div>div>div>div>.head-2-icon.icon.icon-panoramic")
	private WebElement panoramicTitleIcon;
		
	@FindBy(css="body>div>div>div>div>div>span[data-i18n='command.blocker.rendering360.title']")
	private WebElement panoramicTitle;
	
	@FindBy(css="body>div>div>div>div>p")
	private WebElement instruction;		
	
	@FindBy(css="body>div>div>div>div>.dropdown-link-blocker.u-prn")
	private WebElement settingLink;	
	
	@FindBy(css=".dropdown-link-blocker.u-prn>.icon.icon-settings")
	private WebElement settingIcon;
	
	@CacheLookup
	@FindBy(css=".dropdown-link-blocker.u-prn>span[data-i18n='command.blocker.rendering360.settings']")
	private WebElement settingText;
		
	@FindBy(css="body>div>div>div>.overlayDropdown.dropdown--blocker")
	private WebElement settingState;	
	
	@CacheLookup
	@FindBy(css="body>div>div>div>div>ul>li>p[data-i18n='snapshot.background_image']")
	private WebElement backgroundImgText;
	
	@FindBy(css="body>div>div>div>div>ul>li>div>div>.slick-next.slick-arrow")
	private WebElement arrowImgNext;
	
	@FindBy(css="body>div>div>div>div>ul>li>div>div>.slick-prev.slick-arrow")
	private WebElement arrowImgPrevious;
		
	@FindBy(css="body>div>div>div>div>ul>li>div>div>div>div>.sliderSnapshotBg-item.slick-slide.slick-current.slick-active>img[src$='.jpg']")
	private WebElement backgroundImgCurrent;
	
	@FindBy(css=".sliderSnapshotBg-item.slick-slide")
	private List<WebElement> backgroundImglist;
	
	@FindBy(css="body>div>div>div>div>ul>li>div>p[data-i18n='overlaytop.light_position']")
	private WebElement sunPositionText;

	@FindBy(css="ul>li>.light-position-container>div>div>.jcs")
	private WebElement sunPositionImage;
	
	@FindBy(css="ul>li>.light-position-container>div>div>.jcs-indicator")
	private WebElement sunPositionIndicator;

	@FindBy(css="ul>li>div>p[data-i18n='overlaytop.light_intensity']")
	private WebElement sunInclinationText;
	
	@FindBy(css="body>div>div>div>div>ul>li>.light-inclination-container>div>div>.jcs")
	private WebElement sunInclinationImage;
	
	@FindBy(css="ul>li>.light-inclination-container>div>div>.jcs-indicator")
	private WebElement sunInclinationIndicator;	
	
	@FindBy(css="body>div>div>.button.rendering-blocker-preview-button")
	private WebElement previewButton;

	@FindBy(css="body>div>div>div>.camera-height-container>.icon.icon-camera-height")
	private WebElement cameraHightIcon;
	
	@FindBy(css=".camera-height-container>div>.noUi-base>.noUi-origin.noUi-connect")
	private WebElement cameraHeight;

	@FindBy(css=".camera-height-container>div>div>div>.noUi-handle.noUi-handle-upper")
	private WebElement cameraHeightHandle;

	@FindBy(css=".camera-height-container>div>div>div>div>.noUi-tooltip")
	private WebElement cameraHeightToolTip;
	
	@FindBy(css="body>div>.overlay-top>#cancel-design-tool")
	private WebElement closeButton;
	
	@FindBy(css="body>div>div>div>div>#back-link")
	private WebElement backToMyFloorPlan;

	private String popupSlide1TextP1 = "360° images allow you to create virtual visits of your project.";
	private String popupSlide1TextP2 = "You can share them on your favorite social networks as well as immersive yourself into the room using Virtual Reality on your smartphone.";
	private String vrIconImage = "https://preprod-platform.by.me/assets/images/rendering360/picture-icon-vr@1x.png";
	private String popupSlide1360 = "https://byme-preprod-697c4ef6b5ec31e272ee67749bea4b727f31d5b0.s3-eu-west-1.amazonaws.com/data/viewer360/onBoarding/index.html";
	private String popupSlide2Image = "https://preprod-platform.by.me/assets/images/rendering360/onboarding-thumb@1x.png";
	private String popupSlide2TextP1 = "Choose a position around which you will rotate.";
	private String popupSlide2TextP2 = "Adjust the light settings and background image.";
	private String dontShowAgainLabelText = "Don't show this message again";	
	private String title = "360° IMAGE";
	private String instructionText1 = "Select a position, adjust your settings and select preview.";	
	
	private Panoramic360 infoSlide (){		
		Verification.displayOfWebElement(panoramicIconPopup);
		Verification.displayNAttributeCheckOfElement(panoramicTitlePopup, "Popup Title", "text", "360° IMAGE");
		Verification.displayNAttributeCheckOfElement(popupSlide1P1, "Slide1Text1", "text", popupSlide1TextP1);
		Verification.displayNAttributeCheckOfElement(popupSlide1360Tour, "360 tour on panoramic info panel", "src", popupSlide1360);
		Verification.displayNAttributeCheckOfElement(popupSlide1P2, "Slide1Text1", "text", popupSlide1TextP2);
		Verification.displayNAttributeCheckOfElement(vrIcon, "VR Icon in 360 info panel", "src", vrIconImage);
		if(!dotList.get(0).getAttribute("class").equalsIgnoreCase("slick-active") && 
				!dotList.get(0).findElement(By.tagName("button")).isDisplayed()){
			UtilHBM.reportKO("Dot is not displayed or is not active for slide in 360° IMAGE info panel");
		}
		if(slideList.get(1).isDisplayed()){
			UtilHBM.reportKO("Slide2 is displayed with slide 1 in 360° IMAGE info panel");
		}
		nextButton.click();
		UtilHBM.waitExplicitDisplayed(driver, popupSlide2Img);
		Verification.displayNAttributeCheckOfElement(popupSlide2Img, "popup slide 2 image", "src", popupSlide2Image);
		Verification.displayNAttributeCheckOfElement(popupSlide2P1, "First line on slide 2 of popup", "text", popupSlide2TextP1);
		Verification.displayNAttributeCheckOfElement(popupSlide2P2, "Second line on slide 2 of popup", "text", popupSlide2TextP2);
		Verification.disabledWebElement(dontShowPopinCheckBox);
		Verification.displayNAttributeCheckOfElement(dontShowPopinLabel, "Do not show popup again", "text", dontShowAgainLabelText);
		nextButtonGetStarted.click();
		return this;
	}
	
	public ThreeDPlanner panoramic360(int backgroundNo){		
		UtilHBM.waitExplicitClickable(driver, popupSlide1360Tour);
		infoSlide();
		settingOpen();
//		Verification.displayNAttributeCheckOfElement(settingState, "Setting link status", "class", "overlayDropdown dropdown--blocker is-collapse");
		for(int k=0; k<4; k++){
			arrowImgPrevious.click();
			UtilHBM.waitFixTime(500);
		}
		panoramic360PageCheck();		
		for(int i=0; i<backgroundNo-1; i++){
			arrowImgNext.click();				
			UtilHBM.waitFixTime(500);				
		}
		if(!backgroundImglist.get(backgroundNo-1).isDisplayed()){
			UtilHBM.reportKO("Correct backgroud is not set for Panoramic 360");
		}
		
		settingClose();
		settingOpen();
		
//		setSunPosition(x1,y1, x2, y2);
//		cameraHeight(0, 7);
		previewButton.click();
		UtilHBM.waitFixTime(3000);
		
		Panoramic360Generate generate = PageFactory.initElements(driver, Panoramic360Generate.class);
		generate.modifyPanoramic();
		settingClose();
		if(!(backgroundImgCurrent.isDisplayed() || backgroundImgText.isDisplayed() || sunInclinationImage.isDisplayed() || sunPositionImage.isDisplayed())){
			UtilHBM.reportKO("collapse Setting panel KO ");
		}
		previewButton.click();
		UtilHBM.waitFixTime(2000);
		generate.generatePanoramic();		
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	private Panoramic360 panoramic360PageCheck(){
		UtilHBM.waitExplicitDisplayed(driver, backgroundImgCurrent);
		if(!(backgroundImgCurrent.isDisplayed() || backgroundImgText.isDisplayed() || sunInclinationImage.isDisplayed() || sunPositionImage.isDisplayed())){
			UtilHBM.reportKO("Open Setting panel KO ");
		}
		Verification.displayOfWebElement(panoramicTitleIcon);
		Verification.displayNAttributeCheckOfElement(panoramicTitle, "Panoramic Title", "text", title);
		Verification.displayNAttributeCheckOfElement(instruction, "Instructions1", "text", instructionText1);
		Verification.displayNAttributeCheckOfElement(settingLink, "Setting button", "text", "SETTINGS");
		Verification.displayNAttributeCheckOfElement(backgroundImgText, "Background image text", "text", "Background image");
		Verification.displayNAttributeCheckOfElement(sunPositionText, "Sun position text", "text", "Sun position");
		Verification.displayNAttributeCheckOfElement(sunInclinationText, "Sun Inclination text", "text", "Sun inclination");		
		Verification.displayOfWebElement(closeButton);
		Verification.displayOfWebElement(settingIcon);
		Verification.displayOfWebElement(backgroundImgCurrent);
		Verification.displayOfWebElement(sunPositionImage);
		Verification.displayOfWebElement(sunPositionIndicator);		
		Verification.displayOfWebElement(sunInclinationImage);
		Verification.displayOfWebElement(sunInclinationIndicator);	
		Verification.displayOfWebElement(cameraHightIcon);
		Verification.displayOfWebElement(cameraHeight);		
		Verification.displayOfWebElement(cameraHeightHandle);		
		new Actions(driver).moveToElement(cameraHeightHandle).build().perform();
		UtilHBM.waitFixTime(1000);
		Verification.displayOfWebElement(cameraHeightToolTip);
		Verification.displayNAttributeCheckOfElement(previewButton, "Preview Button", "text", "PREVIEW");
		if(settingState.getAttribute("class").contains("is-collapse")){
			UtilHBM.reportOK("Settings are collapsed as expected");
		}else{
			UtilHBM.reportKO("Settings are not collapsed. It is expected to be collapsed");
		}
		if(!(backgroundImglist.size()==6)){
			UtilHBM.reportKO("Number of background images in 360 rendering is changed. Expected images = 6. Actual images = " +backgroundImglist.size());
		}
		if(arrowImgPrevious.getAttribute("class").contains("slick-disabled") &&
				!(arrowImgNext.getAttribute("class").contains("slick-disabled"))){			
			String imageName = backgroundImgCurrent.getAttribute("alt");
			System.out.println("Background list: " + backgroundImglist.size() );
			for(int i=0; i<backgroundImglist.size()-1; i++){				
				arrowImgNext.click();				
				UtilHBM.waitFixTime(500);				
			}
			if(!arrowImgPrevious.getAttribute("class").contains("slick-disabled") &&
				arrowImgNext.getAttribute("class").contains("slick-disabled") &&
				!backgroundImgCurrent.getAttribute("alt").equalsIgnoreCase(imageName)){								
				for(int i=0; i<backgroundImglist.size()-1; i++){
					arrowImgPrevious.click();
					UtilHBM.waitFixTime(500);					
				}
				if(arrowImgPrevious.getAttribute("class").contains("slick-disabled") &&
						!arrowImgNext.getAttribute("class").contains("slick-disabled") &&
						backgroundImgCurrent.getAttribute("alt").equalsIgnoreCase(imageName)){
					UtilHBM.reportOK("Background Image, arrow status & its function tested OK");
				}else{
					UtilHBM.reportKO("Problem in click on Previous Image arrow button");
				}
			}else{
				UtilHBM.reportKO("Problem in click on Next Image arrow button");
			}
		}else{
			UtilHBM.reportKO("Background Image, arrow status & its function test failed");
		}		
		return PageFactory.initElements(driver, Panoramic360.class);
	}
	
	private Panoramic360 settingOpen(){
		settingLink.click();
		UtilHBM.waitExplicitDisplayed(driver, backgroundImgCurrent);
		UtilHBM.waitExplicitClickable(driver, backgroundImgCurrent);
		return PageFactory.initElements(driver, Panoramic360.class);
	}
	private Panoramic360 settingClose(){
		settingLink.click();
//		Verification.displayNAttributeCheckOfElement(settingState, "Setting link status", "class", "overlayDropdown dropdown--blocker");
		return PageFactory.initElements(driver, Panoramic360.class);
	}
	
	public Panoramic360 setSunPosition(int x1, int y1, int x2, int y2){
//		Verification.displayNAttributeCheckOfElement(sunPositionText, "Sun Position Text", "text", "Sun position");
//		Verification.displayNAttributeCheckOfElement(sunInclinationText, "Sun Inclination Text", "text", "Sun inclination");
		
		Verification.displayOfWebElement(sunPositionIndicator);
		Verification.displayOfWebElement(sunInclinationIndicator);
		UtilHBM.waitFixTime(1000);
		new Actions(driver).moveToElement(sunPositionIndicator, x1, y1).click().build().perform();
		new Actions(driver).moveToElement(sunInclinationIndicator, x2, y2).click().build().perform();
		
		return PageFactory.initElements(driver, Panoramic360.class);
	}
	
	public Panoramic360 cameraHeight(int x, int y){
		Verification.displayOfWebElement(cameraHightIcon);
		new Actions(driver).moveToElement(cameraHeight, x, y).click().build().perform();
		return PageFactory.initElements(driver, Panoramic360.class);
	}
	
}
