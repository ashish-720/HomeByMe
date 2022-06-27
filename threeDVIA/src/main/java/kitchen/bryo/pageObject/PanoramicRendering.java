package kitchen.bryo.pageObject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PanoramicRendering {
	WebDriver driver;

	public PanoramicRendering(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//article[@class='mod-layer-360 mod-open']/div/section[@class='mod-sublayer-media mod-open']/footer/button[@data-ui-action='sublayer-close']")
	private WebElement getStartedButton;

	@FindBy(css = "h4[data-i18n='kitchen.render_360.sublayer_media.title;planner.render_360.sublayer_media.title']")
	private  WebElement panoramicImageTitle;

	@FindBy(xpath = "//section[@class='mod-sublayer-media mod-open']/div[@class='content']/p")
	private  WebElement panoramicInfo;

	@FindBy(xpath = "//iframe[@src='https://byme-prod-697c4ef6b5ec31e272ee67749bea4b727f31d5b0.s3-eu-west-1.amazonaws.com/data/viewer360/onBoarding/index.html?app=Kitchen']")
	private WebElement panoramicImageIframe;
	
	@FindBy(xpath = "//article[@class='mod-layer-360 mod-open']/div/header/div/div/h3[@data-i18n='kitchen.render_360.title;planner.render_360.title']")
	private WebElement render360Title;
	
	@FindBy(xpath = "//b[@class='info']")
	private WebElement render360Info;
	
	@FindBy(id = "background-image")
	private WebElement backgroundImageIcon;

	@FindBy(css = "#background-image>div>h4")
	private WebElement backgroundImgText;

	@FindBy(id = "light-position")
	private WebElement lightPositionIcon;

	@FindBy(css = "#light-position>div>h4")
	private WebElement lightPositionText;

	@FindBy(css = ".mod-tool-sun-position")
	private WebElement lightPositionImage;

	@FindBy(id = "light-inclination")
	private WebElement lightInclinationIcon;

	@FindBy(css = "#light-inclination>div>h4")
	private WebElement lightInclinationText;

	@FindBy(css = ".mod-tool-sun-inclination")
	private WebElement lightInclinationImage;

	
	@FindBy(css = "button[data-ui-action='layer-validate']")
	private WebElement generateButton;

	@FindBy(css = "button[data-ui-selector='layer-360-return-to-step-1']")
	private WebElement launchPreview;

	@FindBy(xpath = "//h4[@data-i18n='kitchen.render_360.sublayer_before_sending.title;planner.render_360.sublayer_before_sending.title']")
	private WebElement renderingRequestTitle;

	@FindBy(xpath = "//p[@data-i18n='kitchen.render_360.sublayer_before_sending.message;planner.render_360.sublayer_before_sending.message']")
	private WebElement renderingRequestInfo;
	
	@FindBy(xpath = "//button[@data-ui-action='sublayer-generate']")
	private WebElement subLayerGenerateButton;
	
	
	@FindBy(xpath = "//p[@data-i18n='kitchen.render_360.sublayer_loader.info']")
	private WebElement sendingInfo;

	@FindBy(xpath = "//h4[@data-i18n='kitchen.render_image.title;planner.render_image.title']")
	private WebElement sendingTitle;

	@FindBy(xpath = "//button[@data-i18n='kitchen.render_image.got_it_button;planner.render_image.got_it_button']")
	private WebElement okayGotItButton;

		
	@FindBy(css = "button[class='bt-arrow-prev']")
	private WebElement arrowImgPrevious;

	@FindBy(css = "button[class='bt-arrow-next']")
	private WebElement arrowImgNext;

	@FindBy(css = ".overlay-top-title-main .head-2-icon.icon.icon-realistic")
	private WebElement realisticImageTitleIcon;

	@FindBy(css = "ul[data-role='image-list']>li")
	private List<WebElement> backgroundImglist;

	@FindBy(xpath = "//h4[@data-i18n='kitchen.render_image.title;planner.render_image.title']")
	private WebElement messageRequestSend;

	@FindBy(xpath = "//p[@data-i18n='kitchen.render_image.message;planner.render_image.message']")
	private WebElement messageRequestSendInfo;

	public MakeItHappen render360Image(int backgroundImage) {
		infoPageCheck();
		render360ImagePageDetails();
		UtilHBM.waitExplicitClickable(driver, backgroundImageIcon);
		backgroundImageIcon.click();
			for(int i=0; i<backgroundImage-1; i++){			
				arrowImgNext.click();			
				UtilHBM.waitFixTime(500);				
			}
		generateButton.click();
//		UtilHBM.waitExplicitClickable(driver, generateInfoButton);
		Verification.verifyText(renderingRequestTitle, "Before sending your request",
				"Before sending your request title");
		Verification.verifyText(renderingRequestInfo, "360° images will be available on your project page when complete.",
				"Before sending your request info");
		subLayerGenerateButton.click();
//		UtilHBM.waitTillElementDisappear(driver, "section[data-sublayer-step='1']");
//		UtilHBM.waitExplicitDisplayed(driver, cancelRequest);
		Verification.verifyText(sendingTitle, "Sending request", "SENDING REQUEST title");
//		Verification.verifyText(sendingInfo, "No worries, it won’t be long!", "SENDING REQUEST info");
		UtilHBM.waitExplicitDisplayed(driver, messageRequestSend);
		Verification.verifyText(messageRequestSend, "Your request has been sent",
				"Request send title");
		Verification.verifyText(messageRequestSendInfo, "Your image is being generated and will be available as part of your project shortly.",
				"Request send info");
		UtilHBM.waitExplicitClickable(driver, okayGotItButton);
		UtilHBM.reportInfo(messageRequestSend.getText());
		okayGotItButton.click();
			UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		return PageFactory.initElements(driver, MakeItHappen.class);
	}

	private void render360ImagePageDetails() {
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//article[@class='mod-layer-360 mod-open']")));
UtilHBM.waitExplicitDisplayed(driver, render360Title);
		Verification.verifyText(render360Title, "Create a 360° image", "360° IMAGE title");
		Verification.verifyText(render360Info, "Select a position, adjust your settings and generate your image.",
				"360° IMAGE Instructions");
//		UtilHBM.waitTillElementDisappear(driver, ".mod-sublayer-media");
		backgroundImageIcon.click();
		UtilHBM.waitExplicitDisplayed(driver, backgroundImgText);
		Verification.verifyText(backgroundImgText, "Background image", "Background image text");
		for (int i = 0; i < backgroundImglist.size() - 1; i++) {
			arrowImgNext.click();
			UtilHBM.waitFixTime(500);
		}
		for (int i = 0; i < backgroundImglist.size() - 1; i++) {
			arrowImgPrevious.click();
			UtilHBM.waitFixTime(500);
		}
		lightPositionIcon.click();
		UtilHBM.waitExplicitDisplayed(driver, lightPositionText);
		Verification.verifyText(lightPositionText, "Sun position", "Sun Position");
		Verification.displayOfWebElement(lightPositionImage);
		lightInclinationIcon.click();
		UtilHBM.waitExplicitDisplayed(driver, lightInclinationText);
		Verification.verifyText(lightInclinationText, "Sun inclination", "Sun Inclination");
		Verification.displayOfWebElement(lightInclinationImage);

		Verification.displayOfWebElement(generateButton);
		Verification.verifyText(generateButton, "Generate", "GENERATE button");

	}

	private PanoramicRendering infoPageCheck() {
		UtilHBM.waitExplicitDisplayed(driver, getStartedButton);
		String expectedTitle = "360° images allow you to create high quality visuals of your project.";
		String expectedInfo = "360° images will be available on your project page when complete.";

		Verification.VerifyEquals("Render 360° images title not correct", panoramicImageTitle.getText(),
				expectedTitle);
		Verification.VerifyEquals("Render 360° images info not correct", panoramicInfo.getText(),
				expectedInfo);
		Verification.displayOfWebElement(panoramicImageIframe);
		UtilHBM.waitExplicitDisplayed(driver, getStartedButton);
		UtilHBM.waitExplicitClickable(driver, getStartedButton);
		getStartedButton.sendKeys(Keys.ENTER);
		return this;
	}

//	public PanoramicRendering generateImage() {
//		UtilHBM.waitExplicitClickable(driver, generateInfoButton);
//		generateInfoButton.click();
//		UtilHBM.waitExplicitClickable(driver, okayGotItButton);
//		okayGotItButton.click();
//		return PageFactory.initElements(driver, PanoramicRendering.class);
//	}

	// public MakeItHappen savePopUpInfo() {
	// String expectedTitle = "Save your project";
	// String expectedInfo =
	// "Your project has to be saved before doing this action. Would you like to
	// save it now?";
	//
	// Verification.VerifyEquals("Save project title not correct",           
	// title.getText(), expectedTitle);
	// Verification.VerifyEquals("Save project info not correct",
	// info.getText(), expectedInfo);
	// yesButton.click();
	// UtilHBM.waitFixTime(2000);
	// return PageFactory.initElements(driver, MakeItHappen.class);
	// }

}
