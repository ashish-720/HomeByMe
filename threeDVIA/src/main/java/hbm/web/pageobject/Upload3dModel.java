package hbm.web.pageobject;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class Upload3dModel {

	WebDriver driver;

	public Upload3dModel(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "header>div>div>h3.title")
	List<WebElement> editorTitle;

	@FindBy(css = "header>div>div>div>span")
	WebElement editorText;

	@FindBy(xpath = "/html/body/div[@class='ReactModalPortal']/div/div[@class='ReactModal__Content ReactModal__Content--after-open layer-3deditor-wrapper']/div/div/iframe")
	WebElement threeDEditorIframe;

	@FindBy(xpath = "//header/div/div[@class='header-actions']/button[@title='Close']")
	WebElement closeButton;

	@FindBy(css = "section.mod-sublayer.mod-open>header>h4.tt")
	WebElement cancelText1;

	@FindBy(css = "section.mod-sublayer.mod-open>header>p")
	WebElement cancelText2;

	@FindBy(css = "section.mod-sublayer.mod-open>div.content>h3")
	WebElement cancelText3;

	@FindBy(xpath = "//section[@class='mod-sublayer mod-open']/footer/button[text()='No']")
	WebElement noButton;

	@FindBy(xpath = "//section[@class='mod-sublayer mod-open']/footer/button[text()='Yes']")
	WebElement yesButton;

	@FindBy(xpath = "//section[@class='mod-sublayer-drag-and-drop mod-open']/div/div/label/input[@data-ui-id='upload-input']")
	WebElement uploadFileInput;

	@FindBy(xpath = "//section[@class='mod-sublayer-drag-and-drop mod-open']/div/div/p[1]")
	WebElement uploadText1;

	@FindBy(xpath = "//section[@class='mod-sublayer-drag-and-drop mod-open']/div/div/span[2]")
	WebElement uploadText2;

	@FindBy(xpath = "//section[@class='mod-sublayer-drag-and-drop mod-open']/div/div/label/span[text()='Upload from file']")
	WebElement uploadFileButton;

	@FindBy(xpath = "//div[@class='main-app']/header/div/div[@class='header-actions']/button[@class='cta-primary-alt-l']/span[text()='Next']/..")
	WebElement nextButton;

	@FindBy(xpath = "//header/div/div[@class='header-tools'][1]/ul/li[1]/button[@disabled]")
	WebElement openFromDiskDisabled;
	
	@FindBy(xpath = "//div[@class='wrap layer-header-wrap']/div/ul/li/button[@title='Open from disk'][not(@disabled)]")
	WebElement openFromDiskActive;

	@FindBy(xpath = "//header/div/div[@class='header-tools'][1]/ul/li[2]/button[@disabled]")
	WebElement restoreDefaultModelDisabled;

	@FindBy(xpath = "//header/div/div[@class='header-tools'][2]/ul/li[1]/button[@disabled]")
	WebElement undoDisabled;

	@FindBy(xpath = "//header/div/div[@class='header-tools'][2]/ul/li[2]/button[@disabled]")
	WebElement redoDisabled;

	@FindBy(xpath = "//header/div/div[@class='header-actions']/button[@disabled]")
	WebElement nextButtonDisabled;

	@FindBy(xpath = "//html/body/div[1][@class='main-app loading']/div/div/span[@class='spinner']")
	List<WebElement> loader;

	@FindBy(css = "div.content-inner>header>div>label.label")
	WebElement backPlanLabel;

	@FindBy(css = "div.content-inner>header>div>input#back-plane-toggle")
	WebElement backPlanToggle;

	@FindBy(xpath = "//ul[@class='navigation-list']/li[1]/span[@aria-expanded='true']")
	WebElement dimensions;

	@FindBy(xpath = "//ul[@class='navigation-list']/li[1]/span[@aria-expanded='false']")
	WebElement dimensionsCollapsed;

	@FindBy(xpath = "//ul[@class='navigation-list']/li[1]/ul/li/div[@class='inline-form anchor-section small-inputs locked']/div/p[1]/label")
	WebElement xWidthLabel;

	@FindBy(xpath = "//ul[@class='navigation-list']/li[1]/ul/li/div[@class='inline-form anchor-section small-inputs locked']/div/p[2]/label")
	WebElement yDepthLabel;

	@FindBy(xpath = "//ul[@class='navigation-list']/li[1]/ul/li/div[@class='inline-form anchor-section small-inputs locked']/div/p[3]/label")
	WebElement zHeightLabel;

	@FindBy(xpath = "//span[text()='cm']/preceding-sibling::span/input[@id='dimension-width']")
	WebElement xWidthInput;

	@FindBy(xpath = "//span[text()='cm']/preceding-sibling::span/input[@id='dimension-depth']")
	WebElement yDepthInput;

	@FindBy(xpath = "//span[text()='cm']/preceding-sibling::span/input[@id='dimension-height']")
	WebElement zHeightInput;

	@FindBy(xpath = "//ul[@class='navigation-list']/li[1]/ul/li/div[@class='inline-form anchor-section small-inputs locked']/span[@class='locker']/button")
	WebElement unlockDimensions;

	@FindBy(xpath = "//ul[@class='navigation-list']/li[1]/ul/li/div[@class='inline-form anchor-section small-inputs']/span[@class='locker']/button")
	WebElement lockDimensions;

	@FindBy(xpath = "//ul[@class='navigation-list']/li[1]/ul/li/div[@class='context-dimension']/div/label[@class='label']")
	WebElement humanScaleLabel;

	@FindBy(xpath = "//ul[@class='navigation-list']/li[1]/ul/li/div[@class='context-dimension']/div/input[@id='context-dimension-toggle']")
	WebElement humanScaleToggle;
	
	@FindBy(css = "section[class='mod-sublayer mod-open']>header>svg[class='icon-action-fail']")
	WebElement errorPageImg;
	
	@FindBy(css = "section[class='mod-sublayer mod-open']>header>h4")
	WebElement errorPageText1;
	
	@FindBy(css = "section[class='mod-sublayer mod-open']>div.content>p:nth-child(1)")
	WebElement errorPageText2;
	
	@FindBy(css = "section[class='mod-sublayer mod-open']>div.content>p:nth-child(2)")
	WebElement errorPageText3;
	
	@FindBy(css = "section[class='mod-sublayer mod-open']>div.content>p:nth-child(3)")
	WebElement errorPageText4;

	@FindBy(xpath = "//section[@class='mod-sublayer mod-open']/footer/label/span[text()='Upload a new file']/preceding-sibling::input")
	WebElement uploadFromErrorPage;
	
	@FindBy(xpath = "//section[@class='mod-sublayer mod-open']/footer/button[text()='Cancel']")
	WebElement cancelFromErrorPage;
	
	@FindBy(xpath = "//article[@class='mod-layer-as-content-full-height mod-open']/div/div/div/section/header/h4")
	WebElement openNewFileHeader1;
	
	@FindBy(xpath = "//article[@class='mod-layer-as-content-full-height mod-open']/div/div/div/section/header/p")
	WebElement openNewFileHeader2;
	
	@FindBy(xpath = "//article[@class='mod-layer-as-content-full-height mod-open']/div/div/div/section/div/h3")
	WebElement openNewFileConfirmText;
	
	@FindBy(xpath = "//article[@class='mod-layer-as-content-full-height mod-open']/div/div/div/section/footer/button[text()='No']")
	WebElement openNewFileConfirmNo;
	
	@FindBy(xpath = "//article[@class='mod-layer-as-content-full-height mod-open']/div/div/div/section/footer/label/span[text()='Yes']/preceding-sibling::input")
	WebElement openNewFileConfirmInput;
	

	public Upload3dModel swtichFrame() {
		UtilHBM.waitExplicitDisplayed(driver, threeDEditorIframe);
		driver.switchTo().frame(threeDEditorIframe);
		int i;
		for (i = 0; i < 5; i++) {
			UtilHBM.turnOffImplicitWaits(driver);
			boolean isLoaderDisappreared = editorTitle.isEmpty();
			UtilHBM.turnOffImplicitWaits(driver);
			UtilHBM.waitFixTime(1000);
			if (!isLoaderDisappreared) {
				break;
			}
		}
		UtilHBM.waitExplicitDisplayed(driver, editorTitle.get(0));
		UtilHBM.waitExplicitDisplayed(driver, editorText);
		return this;
	}

	public Upload3dModel verifyUpload3dModelPageDisplayed() {
		UtilHBM.waitExplicitDisplayed(driver, editorTitle.get(0));
		Verification.VerifyEquals("Wrong editorTitle", editorTitle.get(0).getText(), "3D Editor BETA");
		Verification.VerifyEquals("Wrong editorText", editorText.getText(), "Upload a 3D model to get started");
		Verification.displayOfWebElement(uploadFileInput);
		return this;

	}

	public Upload3dModel verifyPageNoFileUploaded() {
		Verification.VerifyEquals("Wrong editorTitle", editorTitle.get(0).getText(), "3D Editor BETA");
		Verification.VerifyEquals("Wrong editorText", editorText.getText(), "Upload a 3D model to get started");
		Verification.VerifyEquals("Wrong uploadText1", uploadText1.getText(), "Drag & Drop your 3d object");
		Verification.VerifyEquals("Wrong uploadText2", uploadText2.getText(), "*.gltf, *.glb, *.obj, *.dae");
		Verification.displayOfWebElement(uploadFileInput);
		Verification.displayOfWebElement(uploadFileButton);
		Verification.displayOfWebElement(openFromDiskDisabled);
		Verification.displayOfWebElement(restoreDefaultModelDisabled);
		Verification.displayOfWebElement(undoDisabled);
		Verification.displayOfWebElement(redoDisabled);
		Verification.displayOfWebElement(nextButtonDisabled);
		return this;
	}

	public Upload3dModel uploadFile(String fileName) {
		UtilHBM.waitExplicitDisplayed(driver, uploadFileInput);
		uploadFileInput.sendKeys(new File(Setting.threeDModelsPath + fileName).getAbsolutePath());
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, Upload3dModel.class);
	}
	
	public Upload3dModel uploadFileFromErrorPage(String fileName) {
		UtilHBM.waitExplicitDisplayed(driver, uploadFromErrorPage);
		uploadFromErrorPage.sendKeys(new File(Setting.threeDModelsPath + fileName).getAbsolutePath());
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, Upload3dModel.class);
	}
	
	public Upload3dModel uploadFileFromOpenNewPage(String fileName) {
		UtilHBM.waitExplicitDisplayed(driver, openNewFileHeader1);
		UtilHBM.waitExplicitDisplayed(driver, openNewFileConfirmInput);
		openNewFileConfirmInput.sendKeys(new File(Setting.threeDModelsPath + fileName).getAbsolutePath());
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, Upload3dModel.class);
	}
	
	public Upload3dModel openFromDisk() {
		UtilHBM.waitExplicitDisplayed(driver, openFromDiskActive);
		UtilHBM.waitExplicitClickable(driver, openFromDiskActive);
		openFromDiskActive.click();
		return this;
	}
	
	public Upload3dModel verifyOpenFromDiskPage() {
		UtilHBM.waitExplicitDisplayed(driver, openNewFileHeader1);
		Verification.VerifyEquals("Wrong openNewFileHeader1", openNewFileHeader1.getText(), "Open a new file");
		Verification.VerifyEquals("Wrong openNewFileHeader2", openNewFileHeader2.getText(), "You are about to open a new file.");
		Verification.VerifyEquals("Wrong openNewFileConfirmText", openNewFileConfirmText.getText(), "Are you sure you want to delete your changes?");
		Verification.displayOfWebElement(openNewFileConfirmNo);
		Verification.displayOfWebElement(openNewFileConfirmInput);
		return this;
	}
	
	public Upload3dModel openNewFileConfirmNo() {
		UtilHBM.waitExplicitDisplayed(driver, openNewFileConfirmNo);
		UtilHBM.waitExplicitClickable(driver, openNewFileConfirmNo);
		openNewFileConfirmNo.click();
		return this;
	}
	
	public Upload3dModel verifyErrorPage() {
		UtilHBM.waitExplicitDisplayed(driver, errorPageImg);
		Verification.displayOfWebElement(errorPageImg);
		Verification.VerifyEquals("Wrong errorPageText1!!", errorPageText1.getText(), "An error occurred");
		Verification.VerifyEquals("Wrong errorPageText2!!", errorPageText2.getText(), "This file is not valid, please try again.");
//		Verification.VerifyEquals("Wrong errorPageText3!!", errorPageText3.getText(), "Can't find a model3D supported file");
//		Verification.VerifyEquals("Wrong errorPageText4!!", errorPageText4.getText(), "Error code:\n4 (Bad input)");
		Verification.displayOfWebElement(cancelFromErrorPage);
		Verification.displayOfWebElement(uploadFromErrorPage);
		return this;
	}
	
	public Upload3dModel cancelFromErrorPage() {
		UtilHBM.waitExplicitDisplayed(driver, cancelFromErrorPage);
		UtilHBM.waitExplicitClickable(driver, cancelFromErrorPage);
		cancelFromErrorPage.click();
		return this;
	}

	public Upload3dModel verifyDimensions(String x, String y, String z) {
		UtilHBM.waitExplicitDisplayed(driver, dimensions);
		Verification.VerifyEquals("Incorretc dimensions text", dimensions.findElement(By.cssSelector("span")).getText(),
				"Dimension");
		UtilHBM.waitExplicitClickable(driver, dimensions);
		dimensions.click();
		UtilHBM.waitExplicitDisplayed(driver, dimensionsCollapsed);
		UtilHBM.waitExplicitClickable(driver, dimensionsCollapsed);
		dimensionsCollapsed.click();
		UtilHBM.waitExplicitDisplayed(driver, xWidthLabel);
		Verification.VerifyEquals("Wrong xWidthLabel!!", xWidthLabel.getText(), "x\nwidth");
		Verification.VerifyEquals("Wrong yDepthLabel!!", yDepthLabel.getText(), "y\ndepth");
		Verification.VerifyEquals("Wrong zHeightLabel!!", zHeightLabel.getText(), "z\nheight");
		Verification.VerifyEquals("x width dimension does not match", xWidthInput.getAttribute("value"), x);
		Verification.VerifyEquals("y depth dimension does not match", yDepthInput.getAttribute("value"), y);
		Verification.VerifyEquals("z height dimension does not match", zHeightInput.getAttribute("value"), z);
		/*
		float xwidthDisplayed = Float.parseFloat(xWidthInput.getAttribute("value"));
		if (xwidthDisplayed == x) {
			UtilHBM.reportOK("Correct value displayed for xWidthInput!!");
		} else {
			UtilHBM.reportKO(
					"Incorrect value displayed for xWidthInput!!Expected : " + x + " , Available : " + xwidthDisplayed);
		}

		float ydepthDisplayed = Float.parseFloat(yDepthInput.getAttribute("value"));
		if (ydepthDisplayed == x) {
			UtilHBM.reportOK("Correct value displayed for yDepthInput !!");
		} else {
			UtilHBM.reportKO(
					"Incorrect value displayed for yDepthInput!!Expected : " + y + " , Available : " + ydepthDisplayed);
		}

		float zheightDisplayed = Float.parseFloat(zHeightInput.getAttribute("value"));
		if (zheightDisplayed == x) {
			UtilHBM.reportOK("Correct value displayed for zHeightInput!!");
		} else {
			UtilHBM.reportKO("Incorrect value displayed for zHeightInput!!Expected : " + z + " , Available : "
					+ zheightDisplayed);
		}
		*/
		return this;
	}

	public Upload3dModel editDimensions(String x, String y, String z, boolean dimensionsLockActive) {
		UtilHBM.waitExplicitClickable(driver, xWidthInput);
		if (dimensionsLockActive) {
			Verification.displayOfWebElement(unlockDimensions);
		} else {
			Verification.displayOfWebElement(unlockDimensions);
			UtilHBM.waitExplicitClickable(driver, unlockDimensions);
			unlockDimensions.click();
			Verification.displayOfWebElement(lockDimensions);
		}
		if (!x.equals("")) {
			xWidthInput.clear();
			xWidthInput.sendKeys(Keys.CONTROL + "a");
			xWidthInput.sendKeys(x + Keys.ENTER);
		}
		if (!y.equals("")) {
			yDepthInput.clear();
			yDepthInput.sendKeys(Keys.CONTROL + "a");
			yDepthInput.sendKeys(y + Keys.ENTER);
		}
		if (!z.equals("")) {
			zHeightInput.clear();
			zHeightInput.sendKeys(Keys.CONTROL + "a");
			zHeightInput.sendKeys(Keys.BACK_SPACE + z + Keys.ENTER);
		}
		return this;
	}

	public Upload3dModel verifyBackPlanToggle(boolean toggleTrueOrFalse) {
		UtilHBM.waitExplicitDisplayed(driver, backPlanLabel);
		Verification.VerifyEquals("Wrong backPlan", backPlanLabel.getText(), "Model's back plan");
		if (toggleTrueOrFalse) {
			if (backPlanToggle.isSelected()) {
				UtilHBM.reportOK("back plan toggle is active!!");
			} else {
				UtilHBM.reportKO("Back plan toggle is not active!!Expected toggle status : " + toggleTrueOrFalse);
			}
		} else {
			if (backPlanToggle.isSelected()) {
				UtilHBM.reportKO("Back plan toggle is active!!Expected toggle status : " + toggleTrueOrFalse);
			} else {
				UtilHBM.reportOK("back plan toggle is not active!!");
			}
		}
		return this;
	}

	public Upload3dModel clickBackPlanToggle() {
		UtilHBM.waitExplicitClickable(driver, backPlanLabel);
		backPlanLabel.click();
		return this;
	}

	public Upload3dModel clickHumanScaleToggle() {
		UtilHBM.waitExplicitClickable(driver, humanScaleLabel);
		humanScaleLabel.click();
		return this;
	}

	public Upload3dModel verifyHumanScaleToggle(boolean toggleTrueOrFalse) {
		UtilHBM.waitExplicitDisplayed(driver, humanScaleLabel);
		Verification.VerifyEquals("Wrong humanScaleLabel", humanScaleLabel.getText(), "Human scale");
		if (toggleTrueOrFalse) {
			if (humanScaleToggle.isSelected()) {
				UtilHBM.reportOK("Human scale toggle is active!!");
			} else {
				UtilHBM.reportKO("Human scale toggle is not active!!Expected toggle status : " + toggleTrueOrFalse);
			}
		} else {
			if (humanScaleToggle.isSelected()) {
				UtilHBM.reportKO("Human scale toggle is active!!Expected toggle status : " + toggleTrueOrFalse);
			} else {
				UtilHBM.reportOK("Human scale toggle is not active!!");
			}
		}
		return this;
	}

	public Upload3dModel clickCloseButton() {
		UtilHBM.waitExplicitDisplayed(driver, closeButton);
		UtilHBM.waitExplicitClickable(driver, closeButton);
		closeButton.click();
		return this;
	}

	public Save3DModel clickNextButton() {
		UtilHBM.waitExplicitDisplayed(driver, nextButton);
		UtilHBM.waitExplicitClickable(driver, nextButton);
		nextButton.click();
		int i;
		boolean temp = false;
		for (i = 0; i < 10; i++) {
			UtilHBM.turnOffImplicitWaits(driver);
			boolean isLoaderDisappreared = loader.isEmpty();
			UtilHBM.turnOnImplicitWaits(driver);
			UtilHBM.waitFixTime(1000);
			if (isLoaderDisappreared) {
				UtilHBM.reportInfo("Loader displayed for " + i + " seconds after clicking next button");
				temp = true;
				break;
			}
		}
		if (!temp) {
			UtilHBM.reportKO("Loader displayed for more than 10 seconds");
		}
		return PageFactory.initElements(driver, Save3DModel.class);
	}

	public Upload3dModel verifyCancelDialog() {
		UtilHBM.waitExplicitDisplayed(driver, cancelText1);
		Verification.VerifyEquals("Wrong cancelText1", cancelText1.getText(), "Cancel all your changes");
		Verification.VerifyEquals("Wrong cancelText2", cancelText2.getText(),
				"You are about to close the configurator.");
		Verification.VerifyEquals("Wrong cancelText3", cancelText3.getText(),
				"Are you sure you want to cancel your changes?");
		Verification.displayOfWebElement(noButton);
		Verification.displayOfWebElement(yesButton);
		return this;
	}

	public UserProfilePage clickCancelYes() {
		UtilHBM.waitExplicitDisplayed(driver, yesButton);
		UtilHBM.waitExplicitClickable(driver, yesButton);
		yesButton.click();
		driver.switchTo().parentFrame();
		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
		UtilHBM.waitExplicitDisplayed(driver, userProfilePage.importYourOwn3DCProduct);
		return PageFactory.initElements(driver, UserProfilePage.class);
	}

	public Upload3dModel clickCancelNo() {
		UtilHBM.waitExplicitDisplayed(driver, noButton);
		UtilHBM.waitExplicitClickable(driver, noButton);
		noButton.click();
		return this;
	}

	public ThreeDPlanner clickCancelYesPlanner() {
		UtilHBM.waitExplicitDisplayed(driver, yesButton);
		UtilHBM.waitExplicitClickable(driver, yesButton);
		yesButton.click();
		UtilHBM.waitFixTime(1000);
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}

}
