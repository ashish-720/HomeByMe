package hr.planner.pageObject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Image {
	
	WebDriver driver;
	public Image(WebDriver driver) {
		this.driver = driver;
	}
	
	
	@FindBy(css = "[id='media-sublayer']>footer>.cta-primary-alt-l")
	private WebElement getStarted;
	
	@FindBy(xpath = "[id='media-sublayer']>footer>.cta-secondary-l")
	private WebElement cancel1;
	
	@FindBy(xpath = "//header/h4[text()='Dive in your project thanks to realistic renderings!']")
	private WebElement text01;
	
	@FindBy(xpath = "//div/img[@src='./assets/images/onboarding/onboarding-realistic-image.jpg']")
	private WebElement image1;
	
	@FindBy(xpath = "//div/p[text()='Your image will be accessible on your project page once generated.']")
	private WebElement text02;
	
	@FindBy(css = "label>span.label")
	private WebElement text03;
	
	@FindBy(css = ".text>b.info")
	private WebElement text11;
	
	@FindBy(css = ".text>h3.title")
	private WebElement text12;
	
	@FindBy(css = ".bt-icon>.icon-tools-background>svg")
	private WebElement backgroundImage;
	
	@FindBy(css = ".bt-arrow-next>.icon-action-arrow")
	private WebElement nextArrow;
	
	@FindBy(css = ".bt-arrow-prev>.icon-action-arrow")
	private WebElement previousArrow;
	
	@FindBy(css = ".bt-icon>.icon-tools-azimuth>svg")
	private WebElement sunPosition;
	
	@FindBy(css = ".bt-icon>.icon-tools-azimuth>svg>use")
	private WebElement sunPositionIcon;
	
	@FindBy(css = ".mod-tool-sun-position>.track>.path-circle")
	private WebElement circle;
	
	@FindBy(css = ".bt-icon>.icon-tools-inclination>svg")
	private WebElement sunInclination;
	
	@FindBy(css = ".mod-tool-sun-inclination>.track>.path-arc")
	private WebElement arc;
	
	@FindBy(css = "[class='icon-view-3d']")
	private WebElement viewThreeD;	

	@FindBy(xpath = "//div/button/span[@class='icon-view-fp']")
	private WebElement firstPersonView;
	
	@FindBy(css = ".icon-tools-options")
	private WebElement viewModeOptionsBtn;
	
	@FindBy(css = ".mod-overlay>div>ul>li>span>span>[data-ui-action='opening'")
	private WebElement cameraHeightBtn;
	
	@FindBy(xpath = "//span[text()='Show cut wall']/ancestor::li//label")
	private WebElement showCutWall;
	
	@FindBy(css = ".mod-tool-sun-inclination>input")
	private WebElement angle2;
	
	@FindBy(css = "[id='header-actions']>.cta-primary-alt-l")
	private WebElement generate;
	
	@FindBy(css = "[data-ui-action='sublayer-generate']")
	private WebElement generate2;
	
	@FindBy(css = ".cta-primary-alt-l>[data-i18n='render_hq.generate_button_label']")
	private WebElement generateText;
	
	@FindBy(css = ".cta-secondary-l>[data-i18n='common.cancel']")
	private WebElement cancel2;
	
	@FindBy(css = "[id='success-sublayer']>header>.icon-action-success>use")
	private WebElement successIcon;
	
	@FindBy(css = "[data-i18n='render_hq.sublayer_success.got_it_button']")
	private WebElement okGotIt;
	
	@FindBy(css = "[data-i18n='render_hq.sublayer_success.create_new_button']")
	private WebElement createNew;
	
	@FindBy(css = "[data-i18n='render_360.sublayer_media.title']")
	private WebElement text04;
	
	@FindBy(css = "[id='media-sublayer']>.content>p")
	private WebElement text05;
	
	@FindBy(css = "[data-i18n='render_360.sublayer_media.dont_show_label']")
	private WebElement text06;
	
	@FindBy(xpath = "//div/img[@src='./assets/images/onboarding/onboarding-realistic-image.jpg']")
	private WebElement image2;
	
	@FindBy(css = ".cta-primary-alt-l>[data-i18n='render_360.preview_button_label']")
	private WebElement preview;
	
	@FindBy(css = ".bottom-centered-actions>.cta-primary")
	private WebElement modify;
	
	@FindBy(css = ".header-actions>.cta-primary-alt-l")
	private WebElement generateText360;
	
	@FindBy(css = "[data-i18n='render_360.sublayer_before_sending.title']")
	private WebElement text21;//layer 2 ,text1
	
	@FindBy(css = "[data-i18n='render_360.sublayer_before_sending.message']")
	private WebElement text22;
	
	@FindBy(css = "[id='before-sending-sublayer']>header>.icon-action-info")
	private WebElement Image360icon;
	
	@FindBy(css = "[data-i18n='render_360.sublayer_success.got_it_button']")
	private WebElement okGotIt360;
	
	@FindBy(css = "[data-i18n='render_360.sublayer_success.create_new_button']")
	private WebElement createNew360;
	
	@FindBy(css = "[data-i18n='render_360.sublayer_success.title']")
	private WebElement successTitle360;
	
	@FindBy(css = "[data-i18n='render_360.sublayer_success.message']")
	private WebElement successMessage360;
	
	@FindBy(css = "[data-i18n='render_hq.sublayer_success.title']")
	private WebElement hqSuccesstitle;
	
	@FindBy(css = "[data-i18n='render_hq.sublayer_success.message']")
	private WebElement hqSuccessMessage;
	
	@FindBy(css = "#background-image>[disabled='disabled']")
	private WebElement disabledBackground;
	
	public Image layer1Verification() {
		
		UtilHBM.waitExplicitClickable(driver, getStarted);
		//Verification.displayNAttributeCheckOfElement(image1, "image", "src", "https://preprod-home.enterprise-dev.by.me/Planner/assets/images/onboarding/onboarding-realistic-image.jpg");
		//trying from video
//		Assert.assertTrue(driver.findElement(By.cssSelector("img[src='./assets/images/onboarding/onboarding-realistic-image.jpg']")).isDisplayed());
		Verification.displayOfWebElement(UtilHBM.webElement(driver, "img[src='./assets/images/onboarding/onboarding-realistic-image.jpg']"));
		//If (hard) assert fail than test case execution will be aborted
		Verification.displayNAttributeCheckOfElement(text01, " Heading text ", "text", "Dive in your project thanks to realistic renderings!");
		Verification.displayNAttributeCheckOfElement(text02, " Sub heading text ", "text", "Your image will be accessible on your project page once generated.");
		Verification.displayNAttributeCheckOfElement(text03, " Don't show me again ", "text", "Don't show me again");
		getStarted.click();
		Verification.displayNAttributeCheckOfElement(getStarted, "Get started", "text", "Get started");
		return PageFactory.initElements(driver, Image.class);
	}
	
	public Image disabledbackGroundImage() {
		
		if(!disabledBackground.isEnabled()){
			
			UtilHBM.reportMsg("background image is disabled ");
		}else{
			UtilHBM.reportKO("background image is NOT disabled");	
		}
		return PageFactory.initElements(driver, Image.class);
	}
	
	public Image backGroundImage() {
		
		UtilHBM.waitExplicitClickable(driver, backgroundImage);
		WebElement icon = backgroundImage.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(icon, "Background image icon", "xlink:href", "./assets/icons/icons.svg#icon-tools-background");
		backgroundImage.click();	
		return PageFactory.initElements(driver, Image.class);
	}
	
	public Image nextArrow() {
		UtilHBM.waitExplicitClickable(driver, nextArrow);
		WebElement icon = nextArrow.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(icon, " Next image arrow", "xlink:href", "./assets/icons/icons.svg#icon-action-arrow");
		nextArrow.click();
		return PageFactory.initElements(driver, Image.class);
	}
	
	public Image previousArrow() {
		UtilHBM.waitExplicitClickable(driver, previousArrow);
		WebElement icon = previousArrow.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(icon, " Previous image arrow", "xlink:href", "./assets/icons/icons.svg#icon-action-arrow");
		previousArrow.click();
		return PageFactory.initElements(driver, Image.class);
	}
	
    public Image sunPosition(int xOffset, int yOffset, String angle) {
		
    	UtilHBM.waitExplicitClickable(driver, sunPosition);
    	Verification.displayNAttributeCheckOfElement(sunPositionIcon, "sunPosition icon", "xlink:href", "./assets/icons/icons.svg#icon-tools-azimuth");
    	sunPosition.click();
    
    	new Actions(driver).moveToElement(circle, xOffset, yOffset).click().build().perform();
    	WebElement angle1 = driver.findElement(By.cssSelector(".mod-tool-sun-position>input"));
    	
    	Verification.displayNAttributeCheckOfElement(angle1, "Sun Position Angle is : ", "value", angle);
    	JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript ("document.getElementsByName('sun-position').value='"+angle+"';");
        String s = (String) j.executeScript("return document.getElementsByName('sun-position').value");
        System.out.print("Value entered in hidden field: " +s);
   
    	return PageFactory.initElements(driver, Image.class);
	}
	
	public Image sunInclination(int xOffset, int yOffset, String angle) {
		
		WebElement icon = sunInclination.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(icon, "sunInclination icon", "xlink:href", "./assets/icons/icons.svg#icon-tools-inclination");
		sunInclination.click();
		new Actions(driver).moveToElement(arc, xOffset, yOffset).click().build().perform();
		WebElement angle1 = driver.findElement(By.cssSelector(".mod-tool-sun-inclination>input"));
		
//		WebElement angle1 = driver.findElement(By.cssSelector(".mod-tool-sun-inclination>input[value='"+angle+"']"));
		Verification.displayNAttributeCheckOfElement(angle1, "Sun Inclination Angle is : ", "value", angle);
		return PageFactory.initElements(driver, Image.class);
	}
	
	public Image viewThreeD() {
		UtilHBM.waitExplicitClickable(driver, viewThreeD);
		viewThreeD.click();
		return PageFactory.initElements(driver, Image.class);
	}
	
	public Image firstPersonView() {
		//UtilHBM.waitExplicitClickable(driver, firstPersonView);
		firstPersonView.click();
		return PageFactory.initElements(driver, Image.class);
	}	

	public Image viewModeOptions() {
		UtilHBM.waitExplicitClickable(driver, viewModeOptionsBtn);
		viewModeOptionsBtn.click();
		return PageFactory.initElements(driver, Image.class);
	}
	
	public Image cameraHeightBtn() {
		//UtilHBM.waitExplicitClickable(driver, cameraHeightBtn);
		cameraHeightBtn.click();
		return PageFactory.initElements(driver, Image.class);
	}
	
	public Image cameraHeight(String value) {
		//can select any camera height
		Select sel=new Select(driver.findElement(By.cssSelector(".mod-overlay>div>ul>li>span>span>select[data-ui-action='opening']")));
		sel.selectByValue(value);
//		UtilHBM.webElement(driver, ".mod-overlay>div>ul>li>span>span>[data-ui-action='opening']>[value='"+value+"']").click();
		return PageFactory.initElements(driver, Image.class);
	}
	
	public Image showCutWall() {
		UtilHBM.waitExplicitClickable(driver, showCutWall);
		UtilHBM.turnOffImplicitWaits(driver);
		//int noOfRoomTags = roomTagList.size();
		UtilHBM.reportInfo("Before: "+ showCutWall.findElement(By.tagName("input")).getAttribute("value"));
		showCutWall.click();
		UtilHBM.waitFixTime(500);
		UtilHBM.reportInfo(showCutWall.findElement(By.tagName("input")).getAttribute("value"));
//		if(noOfRoomTags!=roomTagList.size()){
//			UtilHBM.reportOK("Room name display status changed");
//		}else{
//			UtilHBM.reportKO("Room name display status not changed after click on Display Room Name toggle");
//		}
		UtilHBM.turnOnImplicitWaits(driver);
		return PageFactory.initElements(driver, Image.class);
	}
	
	
	public Image generate() {
		
		UtilHBM.waitFixTime(5000);
		UtilHBM.waitExplicitDisplayed(driver, generate);
		Verification.displayNAttributeCheckOfElement(text11, " Heading text ", "text", "Select a position, adjust your settings and generate your image.");
		Verification.displayNAttributeCheckOfElement(text12, " Title ", "text", "Take a realistic picture");
		Verification.displayNAttributeCheckOfElement(generateText, " generate text ", "text", "Generate");
		generate.click();
		UtilHBM.waitExplicitDisplayed(driver, hqSuccessMessage);
		UtilHBM.waitExplicitClickable(driver, okGotIt);
		return PageFactory.initElements(driver, Image.class);
	}
	
	public HomePlanner cancel() {
		//UtilHBM.waitExplicitClickable(driver, drawPlan);
		Verification.displayNAttributeCheckOfElement(cancel2, " generate text ", "text", "Cancel");
		cancel2.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}
	
	public Image layer3Verification() {
		
		Verification.displayNAttributeCheckOfElement(successIcon, "success image icon", "xlink:href", "./assets/icons/icons.svg#icon-action-success");
		Verification.verifyText(hqSuccesstitle, "Your request has been sent", "Success title text verification");
		Verification.verifyText(hqSuccessMessage, "Your realistic image is being generated on our side. We'll let you know as soos as it's ready.", "Success message text verification");
		return PageFactory.initElements(driver, Image.class);
	}
	
	public Image okGotIt() {
		//UtilHBM.waitExplicitClickable(driver, drawPlan);
//		Verification.displayNAttributeCheckOfElement(okGotIt, " ok got it ", "text", "Ok, got it!");
		Verification.verifyText(okGotIt, "Ok, got it!", "Ok, got it button text verification");
		UtilHBM.waitFixTime(1000);
		okGotIt.click();
		return PageFactory.initElements(driver, Image.class);
	}
	
	public Image createNew() {
		//UtilHBM.waitExplicitClickable(driver, drawPlan);
		UtilHBM.waitExplicitDisplayed(driver, createNew);
		Verification.displayNAttributeCheckOfElement(createNew, " create new realistic image ", "text", "create new realistic image");
		createNew.click();
		return PageFactory.initElements(driver, Image.class);
	}
	
	public Image layer1Verification360() {
		
		UtilHBM.waitExplicitClickable(driver, getStarted);
		Verification.displayNAttributeCheckOfElement(text04, " Heading text ", "text", "360° images allow you to create high quality visuals of your project.");
//		Verification.displayNAttributeCheckOfElement(image2, "image", "src", "https://byme-prod-697c4ef6b5ec31e272ee67749bea4b727f31d5b0.s3-eu-west-1.amazonaws.com/data/viewer360/onBoarding/index.html");
		Verification.displayNAttributeCheckOfElement(text05, " Sub heading text ", "text", "Choose a position around which you will rotate. You can also adjust the light settings and the background image.");
		Verification.displayNAttributeCheckOfElement(text06, " Don't show me again ", "text", "Don't show me again");
		getStarted.click();
		return PageFactory.initElements(driver, Image.class);
	}
	
	public Image preview() {
		
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, preview);
		Verification.displayNAttributeCheckOfElement(text11, " Heading text ", "text", "Select a position, adjust your settings and select preview.");
		Verification.displayNAttributeCheckOfElement(preview, "Preview text", "text", "Preview");
		preview.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, Image.class);
	}
	
	public Image modify() {
		UtilHBM.waitExplicitDisplayed(driver, modify);
		Verification.displayNAttributeCheckOfElement(modify, " modify text ", "text", "Modify");
		modify.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, Image.class);
	}
	public Image generate360() {
		
		UtilHBM.waitFixTime(5000);
		UtilHBM.waitExplicitDisplayed(driver, generate);
		Verification.displayNAttributeCheckOfElement(text11, " Heading text ", "text", "Verify your point of view before generating your image");
		Verification.displayNAttributeCheckOfElement(generateText360, " generate text ", "text", "Generate");
		generate.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, Image.class);
	}
	
	public Image generate2() {
		
		UtilHBM.waitFixTime(2000);
		UtilHBM.waitExplicitClickable(driver, generate2);
		WebElement icon = Image360icon.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(icon, "360 image icon", "xlink:href", "./assets/icons/icons.svg#icon-action-info");
		Verification.displayNAttributeCheckOfElement(text21, " Heading text ", "text", "Before sending your request");
		Verification.displayNAttributeCheckOfElement(text22, " Sub-Heading text ", "text", "After generating this 360° image, you will have Infinity remaining credits.");
		Verification.displayNAttributeCheckOfElement(generateText360, " generate text ", "text", "Generate");
		generate2.click();
		UtilHBM.waitExplicitDisplayed(driver, successTitle360);
		
		return PageFactory.initElements(driver, Image.class);
	}
	
	public Image layer3Verification360() {		
		Verification.displayNAttributeCheckOfElement(successIcon, "360 success image icon", "xlink:href", "./assets/icons/icons.svg#icon-action-success");
		Verification.displayNAttributeCheckOfElement(successTitle360, " Heading text ", "text", "Your request has been sent");
		Verification.displayNAttributeCheckOfElement(successMessage360, " Sub-Heading text ", "text", "Your 360° image is being generated. We'll let you know as soos as it's ready.");
		return PageFactory.initElements(driver, Image.class);
	}
	
	public HomePlanner okGotIt360() {
		//UtilHBM.waitExplicitClickable(driver, drawPlan);
		
		Verification.displayNAttributeCheckOfElement(okGotIt360, " ok got it ", "text", "Ok, got it!");
		okGotIt360.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}
	
	public Image createNew360() {
		//UtilHBM.waitExplicitClickable(driver, drawPlan);
		UtilHBM.waitExplicitDisplayed(driver, createNew);
		Verification.displayNAttributeCheckOfElement(createNew360, " create new realistic image ", "text", "Generate");
		createNew360.click();
		return PageFactory.initElements(driver, Image.class);
	}
	
	
}
