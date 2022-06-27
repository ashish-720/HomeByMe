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

public class RealisticImage {
	WebDriver driver;

	public RealisticImage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//article[@class='mod-layer-realistic-picture mod-open']/div/section[@class='mod-sublayer-media mod-open']/footer/button[@data-ui-action='sublayer-close']")
	private WebElement getStartedButton;

	@FindBy(css = "h3[data-i18n='[html]kitchen.hq_rendering.title;[html]planner.hq_rendering.title")
	private WebElement realisticImageTitle;

	@FindBy(css = "b[class='info")
	private WebElement realisticInfo;

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

	@FindBy(css = ".canvas-tools-viewpoint")
	private WebElement cameraHeightIcon;

	@FindBy(css = ".canvas-tools-viewpoint>form>input")
	private WebElement cameraHeightHandle;

	@FindBy(css = ".canvas-tools-viewpoint>form>span")
	private WebElement cameraHeightToolTip;

	@FindBy(css = "#rendering-layer>div>header>div>div>button[data-ui-action='command-validate']")
	private WebElement generateButton;

	@FindBy(css = "#rendering-layer>div>section[data-sublayer-step='1']>footer>button[data-action='next']")
	private WebElement generateInfoButton;

	@FindBy(xpath = "//section[@data-sublayer-step='1']/header/h4")
	private WebElement renderingRequestInfoTitle;

	@FindBy(xpath = "//article[@class='mod-layer-realistic-picture mod-open']/div/section[@class='mod-sublayer-media mod-open']/header/h4")
	private WebElement renderingLayerTitle;

	@FindBy(xpath = "//article[@class='mod-layer-realistic-picture mod-open']/div/section[@class='mod-sublayer-media mod-open']/div/p")
	private WebElement renderingLayerInfo;

	@FindBy(xpath = "//article[@class='mod-layer-realistic-picture mod-open']/div/section[@class='mod-sublayer-media mod-open']/div/img")
	private WebElement renderingExampleImg;

	@FindBy(xpath = "//p[@data-i18n='kitchen.hq_rendering.sending.info;planner.hq_rendering.sending.info']")
	private WebElement sendingInfo;

	@FindBy(xpath = "//h4[contains(text(),'Sending request')]")
	private WebElement sendingTitle;

	@FindBy(xpath = "//section[@data-sublayer-step='2']/footer/button[@data-i18n='common.cancel']")
	private WebElement cancelRequest;

	@FindBy(xpath = "//section[@data-sublayer-step='3']/footer/button[@data-ui-action='layer-close']")
	private WebElement okayGotItButton;

	@FindBy(css = "button[id='create_another']")
	private WebElement createAnotherOne;

	@FindBy(css = "button[class='bt-arrow-prev']")
	private WebElement arrowImgPrevious;

	@FindBy(css = "button[class='bt-arrow-next']")
	private WebElement arrowImgNext;

	@FindBy(css = ".overlay-top-title-main .head-2-icon.icon.icon-realistic")
	private WebElement realisticImageTitleIcon;

	@FindBy(css = "ul[data-role='image-list']>li")
	private List<WebElement> backgroundImglist;

	@FindBy(xpath = "//section[@data-sublayer-step='3']/header/h4")
	private WebElement messageRequestSend;

	@FindBy(xpath = "//button[@class='bt-icon selected'][@id='bt-icon-view-fp']")
	private WebElement activeFirstPersonView;

	@FindBy(xpath = "//button[@class='bt-icon '][@id='bt-icon-view-3d']")
	private WebElement threeDview;

	@FindBy(xpath = "//button[@class='bt-icon '][@id='bt-icon-view-fp']")
	private WebElement firstPersonView;

	@FindBy(xpath = "//button[@class='bt-icon selected'][@id='bt-icon-view-3d']")
	private WebElement active3Dview;

	@FindBy(xpath = "//button[@data-ui-action='command-cancel']")
	private WebElement cancelButton;

	public MakeItHappen realisticImage(int backgroundImage) {
		getStartedPage();
		verifyPreviewInFirstPerson();
		UtilHBM.waitExplicitClickable(driver, backgroundImageIcon);
		backgroundImageIcon.click();
		for (int i = 0; i < backgroundImage - 1; i++) {
			arrowImgNext.click();
			UtilHBM.waitFixTime(500);
		}
		generateHQImage();
		UtilHBM.waitFixTime(200);
		okayGotItButton.click();
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		return PageFactory.initElements(driver, MakeItHappen.class);
	}

	public MakeItHappen realisticImageIn3DView() {
		getStartedPage();
		verifyPreviewIn3DView();
		generateButton.click();
//		UtilHBM.waitExplicitDisplayed(driver, renderingRequestInfoTitle);
//		System.out.println("title: "+renderingRequestInfoTitle.getText());
		UtilHBM.waitExplicitDisplayed(driver, sendingTitle);
		Verification.VerifyEquals("Incorrect SENDING REQUEST title", sendingTitle.getText(), "Sending request");
		Verification.VerifyEquals("Incorrect SENDING REQUEST info", sendingInfo.getText(), "No worries, it won’t be long!");
		UtilHBM.waitExplicitDisplayed(driver, messageRequestSend);
		UtilHBM.waitExplicitClickable(driver, okayGotItButton);
		UtilHBM.reportInfo(messageRequestSend.getText());
		System.out.println(messageRequestSend.getText());

		okayGotItButton.click();

		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		return PageFactory.initElements(driver, MakeItHappen.class);
	}

	public MakeItHappen realisticImageMultiple(String viewHeight, boolean showWallCut, int noOfImages) {
		getStartedPage();
		verifyPreviewInFirstPerson();
		if (!viewHeight.isEmpty() || showWallCut == true) {
			new Actions(driver).moveToElement(threeDview).build().perform();
			threeDview.sendKeys(Keys.ENTER);
			MakeItYours height = PageFactory.initElements(driver, MakeItYours.class);
			height.viewHeightIn3D(viewHeight);
			if (showWallCut == true) {
				driver.findElement(By.cssSelector("label[data-ui-action='front-displayer']")).click();
			}
			generateHQImage();
		} else {
			new Actions(driver).moveToElement(threeDview).build().perform();
			threeDview.sendKeys(Keys.ENTER);
			generateHQImage();
		}
		if (noOfImages > 0) {
			for (int i = 0; i <= noOfImages; i++) {
				UtilHBM.waitExplicitDisplayed(driver, createAnotherOne);
				UtilHBM.waitExplicitClickable(driver, createAnotherOne);
				createAnotherOne.click();
				// realisticImagePageDetails();
				UtilHBM.waitExplicitClickable(driver, generateButton);
				generateButton.click();
				Verification.VerifyEquals("Incorrect SENDING REQUEST title", sendingTitle.getText(), "Sending request");
				Verification.verifyText(sendingInfo, "No worries, it won’t be long!", "SENDING REQUEST info");
				UtilHBM.waitExplicitDisplayed(driver, messageRequestSend);
				UtilHBM.waitFixTime(1000);
			}
			okayGotItButton.click();
		} else {
			okayGotItButton.click();
		}
//		okayGotItButton.click();
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
//		UtilHBM.waitTillElementDisappear(driver, ".mod-layer-realistic-picture");

		return PageFactory.initElements(driver, MakeItHappen.class);
	}

	private void verifyPreviewInFirstPerson() {
		Verification.displayOfWebElement(activeFirstPersonView);
		Verification.displayOfWebElement(threeDview);
		verifyBackgroundImage();
		verifyRenderingLayer();
		verifyCameraHeight();

	}

	private void verifyPreviewIn3DView() {
		Verification.displayOfWebElement(driver.findElement(By.xpath("//li[@id='background-image']/button[@class='bt-icon'][@disabled]")));
		Verification.displayOfWebElement(active3Dview);
		Verification.displayOfWebElement(firstPersonView);
		verifyRenderingLayer();
	}
private void click3DView() {
	UtilHBM.waitExplicitDisplayed(driver, threeDview);
	UtilHBM.waitExplicitDisplayed(driver, threeDview);
	threeDview.click();
}
	private void verifyRenderingLayer() {
		Verification.verifyText(realisticImageTitle, "Create a realistic image", "REALISTIC IMAGE title");
		Verification.verifyText(realisticInfo, "Select a position, adjust your settings and generate your image.",
				"REALISTIC IMAGE Instructions");
//	UtilHBM.waitTillElementDisappear(driver, ".mod-sublayer-media");

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
		Verification.displayOfWebElement(cancelButton);
	}

	private void verifyBackgroundImage() {
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
	}

	private void verifyCameraHeight() {
		Verification.displayOfWebElement(cameraHeightIcon);
		Verification.displayOfWebElement(cameraHeightHandle);
		new Actions(driver).moveToElement(cameraHeightHandle).build().perform();
		UtilHBM.waitFixTime(1000);
		Verification.displayOfWebElement(cameraHeightToolTip);
	}

	private RealisticImage getStartedPage() {
		UtilHBM.waitExplicitDisplayed(driver, getStartedButton);
		String expectedTitle = "Realistic images allow you to create high quality visuals of your project.";
		String expectedInfo = "High quality images will be available on your project page when complete.";

		Verification.VerifyEquals("Rendering layer title not correct", renderingLayerTitle.getText(), expectedTitle);
		Verification.VerifyEquals("Rendering layer info not correct", renderingLayerInfo.getText(), expectedInfo);
		Verification.displayOfWebElement(renderingExampleImg);
		UtilHBM.waitExplicitDisplayed(driver, getStartedButton);
		UtilHBM.waitExplicitClickable(driver, getStartedButton);
		getStartedButton.sendKeys(Keys.ENTER);
		return this;
	}

	public void generateHQImage() {
		generateButton.click();
//	UtilHBM.waitExplicitDisplayed(driver, renderingRequestInfoTitle);
//	System.out.println("title: "+renderingRequestInfoTitle.getText());
		UtilHBM.waitExplicitDisplayed(driver, sendingTitle);
		Verification.VerifyEquals("Incorrect SENDING REQUEST title", sendingTitle.getText(), "Sending request");
		Verification.verifyText(sendingInfo, "No worries, it won’t be long!", "SENDING REQUEST info");
		UtilHBM.waitExplicitDisplayed(driver, messageRequestSend);
		UtilHBM.waitExplicitClickable(driver, okayGotItButton);
		UtilHBM.reportInfo(messageRequestSend.getText());
		System.out.println(messageRequestSend.getText());
	}
//	public RealisticImage generateImage() {
//		UtilHBM.waitExplicitClickable(driver, generateInfoButton);
//		generateInfoButton.click();
//		UtilHBM.waitExplicitClickable(driver, okayGotItButton);
//		okayGotItButton.click();
//		return PageFactory.initElements(driver, RealisticImage.class);
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
