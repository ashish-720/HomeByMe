package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RealisticImage {
	WebDriver driver;

	public RealisticImage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = ".wrapper>div>div>div>#render-hq-layer>.content>header>.wrap>.text>.title")
	private WebElement realisticImageTitle;

	@FindBy(css = ".tool-list>#background-image>.tool-overlay.mod-open>h4")
	private WebElement backgroundImgText;

	@FindBy(css = "div label>input#natural-light")
	private WebElement naturalLightToggle;

	@FindBy(css = "[data-i18n='sun_beautifier.natural_light']")
	private WebElement naturalLightText;

	@CacheLookup
	@FindBy(css = ".mod-layer-realistic-picture.mod-open .tool-list>#background-image>button")
	private WebElement backgroundImgBtn;

	@FindBy(css = "ul>li>div>div .bt-arrow-next")
	private WebElement arrowImgNext;

	@FindBy(css = "ul>li>div>div .bt-arrow-prev")
	private WebElement arrowImgPrevious;

	@FindBy(css = ".tool-list>#background-image>.tool-overlay.mod-open>div>div>ul>li.displayed>img[srcset$='.jpg']")
	private WebElement backgroundImgCurrent;

	@FindBy(css = "#background-image div>ul>li>img")
	private List<WebElement> backgroundImglist;

	@FindBy(css = "ul>li#tools-sun>button")
	private WebElement sunBtn;

	@CacheLookup
	@FindBy(css = ".tool-list .tool-overlay-lg.mod-open>.tt-toggle>h4")
	private WebElement sunPositionText;

	@FindBy(css = ".tool-overlay-lg.mod-open>.tt-toggle>label>input")
	private WebElement autoSunToggle;

	@FindBy(css = ".mod-notification>p.success.show>span")
	private WebElement autoSunOnNotifiMsg;

	@FindBy(css = ".mod-notification>p.show>span")
	private WebElement autoSunOffNotifiMsg;

	@FindBy(css = ".tool-overlay-lg.mod-open>.tt>span>label>input")
	private WebElement nightModeToggle;

	// @FindBy(css=".tool-overlay-lg.mod-open>.content>.message>p")
	// private WebElement autoSunOnMsg;

	@FindBy(css = ".tool-overlay-lg.mod-open>.content>.actions>li>.message>p")
	private WebElement autoSunOnMsg;

	@FindBy(css = ".tool-overlay-lg.mod-open>.content>.message>.icon-tools-auto>svg")
	private WebElement autoSunOnMsgImg;

	@CacheLookup
	@FindBy(css = ".content>.mod-tool-sun-position>div>.track>.path-circle")
	private WebElement sunPositionCircle;

	// @FindBy(css=".mod-tool-sun-position>[style='transform: rotate(329deg);']")
	// private WebElement sunPositionCircle;

	@CacheLookup
	@FindBy(css = ".mod-tool-sun-position>.handle>.icon-tools-sun")
	private WebElement sunPositionIndicator;

	@FindBy(css = ".mod-tool-sun-position>.icon-tools-change-room")
	private WebElement sunPositionimage;

	@CacheLookup
	@FindBy(css = ".content>.mod-tool-sun-inclination>div>.track>.path-arc")
	private WebElement sunInclinationCircle;

	@CacheLookup
	@FindBy(css = ".mod-tool-sun-inclination>.handle>.icon-tools-sun")
	private WebElement sunInclinationIndicator;

	@FindBy(css = ".tool-list>#tools-characters>button")
	private WebElement characters;

	@FindBy(css = ".tool-overlay-sm.mod-open span>.bt-toggle>#people-visibility")
	private WebElement displayPeopleToggleBtn;

	@FindBy(css = ".tool-overlay-sm.mod-open span[data-i18n='characters_visibility.label']")
	private WebElement displayPeopleLabel;

	@FindBy(css = ".tool-overlay-sm.mod-open li>[data-i18n='characters_visibility.label']")
	private WebElement displayPeopleText;

	@FindBy(css = ".tool-list>#fov-selector>button>.icon-tools-lens")
	private WebElement lensBtn;

	@FindBy(css = ".tool-overlay-sm.mod-open>.content>ul>li>button[data-ui-action='tools-lens-14']")
	private WebElement lens_14;

	@FindBy(css = ".tool-overlay-sm.mod-open>.content>ul>li>button[data-ui-action='tools-lens-24']")
	private WebElement lens_24;

	@FindBy(css = ".tool-overlay-sm.mod-open>.content>ul>li>button[data-ui-action='tools-lens-35']")
	private WebElement lens_35;

	@FindBy(css = ".tool-overlay-sm.mod-open>.content>ul>li>button[data-ui-action='tools-lens-60']")
	private WebElement lens_60;

	@FindBy(css = ".tool-overlay-sm.mod-open>.content>ul>li>button")
	private List<WebElement> lensList;

	@FindBy(css = "ul>li#tools-bulb-alight>button")
	private WebElement lightBtn;

	@CacheLookup
	@FindBy(css = "[data-i18n='lights.overlay.title']")
	private WebElement artifitialLightText;

	@FindBy(css = "[data-i18n='lights.overlay.toggle_button']")
	private WebElement activateLightText;

	@FindBy(css = ".tool-overlay-sm.mod-open>div label>input#artificial-lights-toggle")
	private WebElement lightToggle;

	@FindBy(css = ".tool-overlay-sm.mod-open>div li>label>input#lights-on")
	private WebElement lightOnlyOn;

	@FindBy(css = "[data-i18n='lights.overlay.only_the_ones_on']")
	private WebElement lightOnlyOnText;

	// @FindBy(css =
	// "[data-ui-selector='artificial-lights-radio-container']>label>#lights-all")
	// private WebElement lightAll;

	@FindBy(css = "[data-ui-selector='artificial-lights-radio-container']>label")
	private WebElement lightAll;

	@FindBy(css = "[data-i18n='lights.overlay.all']")
	private WebElement lightAllText;

	@FindBy(css = ".tool-overlay-sm.mod-open>div li>label>input")
	private List<WebElement> lightOneOrAll;

	@CacheLookup
	@FindBy(css = "header>.wrap>#header-actions>button.cta-primary-l")
	private WebElement generateButton;

	@CacheLookup
	@FindBy(css = ".canvas-wrap>.canvas-toolbox>.canvas-tools-viewpoint>svg")
	private WebElement cameraHightIcon;

	@CacheLookup
	@FindBy(css = ".canvas-wrap>.canvas-toolbox>.canvas-tools-viewpoint>form>input")
	private WebElement cameraHeight;

	@CacheLookup
	@FindBy(css = ".canvas-wrap>.canvas-toolbox>.canvas-tools-viewpoint>form>.label")
	private WebElement cameraHeightToolTip;

	@FindBy(css = "header>.wrap>#header-actions>button.cta-secondary-l")
	private WebElement cancelBtn;
	/*
	 * @CacheLookup
	 * 
	 * @FindBy(id = "#notifText") private WebElement
	 * messageHQReceiverNotification;
	 * 
	 * @CacheLookup
	 * 
	 * @FindBy(css = "a[class ='close-notif button button--small']") private
	 * WebElement messageHQReceiverNotificationCloseButton;
	 */

	@FindBy(css = ".mod-layer-realistic-picture.mod-open>div>#media-sublayer>footer>.cta-primary-l")
	private WebElement getStartedBtn;

	@FindBy(css = "#render-hq-layer>div>#media-sublayer>.content>p")
	private WebElement getStartedMsg;

	@FindBy(css = ".mod-layer-realistic-picture.mod-open#render-hq-layer>div>#media-sublayer>.content>img[srcset*='./assets/images/onboarding-realisticimage.jpg']")
	private WebElement getStartedImg;

	private String autoSunMsgText = "We'll set automatically the best light to create the most beautiful image.";

	/*
	 * public ThreeDPlanner realisticImageLarge() {
	 * UtilHBM.waitExplicitDisplayed(driver, currentBackgroundImage);;
	 * snapshotList.click(); UtilHBM.waitFixTime(1000); int i =
	 * UtilHBM.listOfWebElement(driver, ".thumbnail-snapshots-image").size();
	 * UtilHBM.webElement(driver, ".close-modal.button-close").click();
	 * backgroundImage.click(); int a =
	 * Integer.parseInt(UtilHBM.webElement(driver,
	 * ".sliderSnapshotBg-item.slick-slide.slick-current.slick-active"
	 * ).getAttribute("data-slick-index")); UtilHBM.webElement(driver,
	 * ".slick-next.slick-arrow").click(); int b =
	 * Integer.parseInt(UtilHBM.webElement(driver,
	 * ".sliderSnapshotBg-item.slick-slide.slick-current.slick-active"
	 * ).getAttribute("data-slick-index")); if(!(a==b)){
	 * UtilHBM.reportOK("Background Image changed"); }else{
	 * UtilHBM.reportKO("Background image change failed"); }
	 * generateHQImageButton.click(); HQImageSize imagesize =
	 * PageFactory.initElements(driver, HQImageSize.class);
	 * imagesize.generateLargeImage(); HQMessage message =
	 * PageFactory.initElements(driver, HQMessage.class);
	 * message.closeHQMessage(); UtilHBM.waitExplicitDisplayed(driver,
	 * UtilHBM.webElement(driver, "#notifText")); if (UtilHBM.webElement(driver,
	 * "#notifText"
	 * ).getText().contains("You will receive your HQ render soon")){
	 * UtilHBM.reportOK("Large HQ Image request sent"); }else{
	 * UtilHBM.reportKO("Large HQ Image request failed"); }
	 * snapshotList.click(); UtilHBM.waitFixTime(1000); int j =
	 * UtilHBM.listOfWebElement(driver, ".thumbnail-snapshots-image").size();
	 * UtilHBM.webElement(driver, ".close-modal.button-close").click();
	 * closeGenerateHQImageWindow.click(); if(j>i){ UtilHBM.reportOK(
	 * "Number of images varified in YOUR REALISTIC IMAGE panel after capturing new image"
	 * ); }else{ UtilHBM.reportKO(
	 * "Number of images not increased in YOUR REALISTIC IMAGE panel after capturing new image"
	 * ); } return PageFactory.initElements(driver, ThreeDPlanner.class); }
	 */

	public RealisticImage nightMode(Boolean nightModeOn) {
		UtilHBM.waitExplicitClickable(driver, sunBtn);
		sunBtn.click();
		if (nightModeOn) {

			if (autoSunToggle.isSelected()) {
				UtilHBM.reportOK("By default auto sun toggle is ON");
				Verification
						.displayNAttributeCheckOfElement(autoSunOnMsg,
								"auto sun on message text", "text",
								"We'll set automatically the best light to create the most beautiful image.");
				if (nightModeToggle.isSelected()) {
					UtilHBM.reportInfo("Night mode toggle is ON");
				} else {
					nightModeToggle.click();
				}
			} else {
				autoSunToggle.click();
				if (nightModeToggle.isSelected()) {
					UtilHBM.reportInfo("Night mode toggle is ON");
				} else {
					nightModeToggle.click();
				}
			}
		}
		return this;
	}

	
	public RealisticImage displayPeople(boolean displayPeople) {
		UtilHBM.waitExplicitClickable(driver, characters);
		characters.click();
		UtilHBM.waitFixTime(1000);
		if (displayPeople) {
			if (!(displayPeopleToggleBtn.isSelected())) {
				displayPeopleToggleBtn.click();
			}
			Verification.displayNAttributeCheckOfElement(displayPeopleText,
					"Display characters text", "text", "Display characters");
			Verification.selectedWebElement(driver, displayPeopleToggleBtn);
			UtilHBM.reportOK("Display character is selected");
		} else {
			if (displayPeopleToggleBtn.isSelected()) {
				displayPeopleToggleBtn.click();
				Verification.disabledWebElement(displayPeopleToggleBtn);
			}
			if (!displayPeopleToggleBtn.isSelected()) {
				UtilHBM.reportOK("Display people toggle is OFF");
			} else {
				UtilHBM.reportKO("Display people is ON and test is failed");
			}
		}
		return this;
	}

	public RealisticImage lensOption(boolean lens, int lensNumber) {
		if (lens) {
			lensBtn.click();
			if (!lensList.isEmpty()) {
				lensList.get(lensNumber).click();
				if (lensList.get(lensNumber).getAttribute("class")
						.contains("selected")) {
					UtilHBM.reportOK("Desired lens is selected");
				} else {
					UtilHBM.reportKO("Desired lens is not selected in realistic image");
				}

			} else {
				UtilHBM.reportKO("Unable to select desired lens");
			}
		} else {
			UtilHBM.reportOK("No need to change lens");
		}
		return this;
	}

	public ThreeDPlanner realisticImage(String smallOrLarge,
			boolean displayPeople, boolean lens, int lensOption) {
		getStarted();
		/*
		 * settingLink.click(); UtilHBM.waitExplicitDisplayed(driver,
		 * backgroundImgCurrent); UtilHBM.waitExplicitClickable(driver,
		 * backgroundImgCurrent); for(int k=0; k<4; k++){
		 * arrowImgPrevious.click(); UtilHBM.waitFixTime(500); }
		 * realisticImagePageCheck(); if(displayPeople){
		 * displayPeopleToggleBtn.click(); }
		 */
		// setSunPosition(angle);
		// displayPeople(displayPeople);
		// lensOption(lens, lensOption);
		clickGenerateButton().sendHQImageRequest(smallOrLarge).closeHQMessage();
		// UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver,
		// "#notifText"));
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}

	private void realisticImagePageCheck() {
		Verification.verifyText(realisticImageTitle, "Take a realistic image",
				"REALISTIC IMAGE title");
		Verification.displayOfWebElement(cancelBtn);
		/*
		 * Verification.displayOfWebElement(settingIcon);
		 * Verification.displayOfWebElement(settingLink);
		 * if(settingState.getAttribute("class").contains("is-collapse")){
		 * UtilHBM.reportOK("Settings are collapsed by default"); }else{
		 * UtilHBM.reportKO("Settings are not collapsed by default"); }
		 * if(!(backgroundImglist.size()==6)){ UtilHBM.reportKO(
		 * "Number of background images in HQ rendering has changed. Expected images = 6. Actual images = "
		 * +backgroundImglist.size()); }
		 * if(arrowImgPrevious.getAttribute("class").contains("slick-disabled")
		 * && !(arrowImgNext.getAttribute("class").contains("slick-disabled"))){
		 * String imageName = backgroundImgCurrent.getAttribute("alt");
		 * System.out.println("Background list: " + backgroundImglist.size() );
		 * for(int i=0; i<backgroundImglist.size()-1; i++){
		 * arrowImgNext.click(); UtilHBM.waitFixTime(500); }
		 * if(!arrowImgPrevious.getAttribute("class").contains("slick-disabled")
		 * && arrowImgNext.getAttribute("class").contains("slick-disabled") &&
		 * !backgroundImgCurrent
		 * .getAttribute("alt").equalsIgnoreCase(imageName)){ for(int i=0;
		 * i<backgroundImglist.size()-1; i++){ arrowImgPrevious.click();
		 * UtilHBM.waitFixTime(500); }
		 * if(arrowImgPrevious.getAttribute("class").contains("slick-disabled")
		 * && !arrowImgNext.getAttribute("class").contains("slick-disabled") &&
		 * backgroundImgCurrent
		 * .getAttribute("alt").equalsIgnoreCase(imageName)){ UtilHBM.reportOK(
		 * "Background Image, arrow status & its function tested OK"); }else{
		 * UtilHBM.reportKO("Problem in click on Previous Image arrow button");
		 * } }else{
		 * UtilHBM.reportKO("Problem in click on Next Image arrow button"); }
		 * }else{ UtilHBM.reportKO(
		 * "Background Image, arrow status & its function test failed");
		 * UtilHBM.reportKO("previous arrow class: "
		 * +arrowImgPrevious.getAttribute("class"));
		 * UtilHBM.reportKO("previous arrow class: "
		 * +arrowImgNext.getAttribute("class")); }
		 * 
		 * Verification.verifyText(backgroundImgText, "Background image",
		 * "Background image text");
		 * Verification.displayOfWebElement(backgroundImgCurrent);
		 * Verification.verifyText(sunPositionText,
		 * "Sun position and inclination", "Sun position and inclination");
		 * Verification.displayOfWebElement(sunPositionImage);
		 * Verification.displayOfWebElement(sunInclinationImage);
		 * Verification.displayOfWebElement(sunInclinationIndicator);
		 * Verification.displayOfWebElement(displayPeopleLabel);
		 * Verification.displayOfWebElement(displayPeopleToggleBtn);
		 */
		Verification.displayOfWebElement(cameraHightIcon);
		Verification.displayOfWebElement(cameraHeight);
		new Actions(driver).moveToElement(cameraHeight).build().perform();
		UtilHBM.waitFixTime(1000);
		Verification.displayOfWebElement(cameraHeightToolTip);
		Verification.displayOfWebElement(generateButton);
		Verification.verifyText(generateButton, "Generate", "GENERATE button");
	}

	public ThreeDPlanner realisticImageMulti(String smallOrLarge,
			int backgroundNo, boolean naturalLightsOn, boolean displayPeople,
			int noOfImages) {
		getStarted();/*
					 * settingLink.click();
					 * UtilHBM.waitExplicitDisplayed(driver,
					 * backgroundImgCurrent);
					 * UtilHBM.waitExplicitClickable(driver,
					 * backgroundImgCurrent); for(int k=0; k<4; k++){
					 * arrowImgPrevious.click(); UtilHBM.waitFixTime(500); }
					 * realisticImagePageCheck(); if(displayPeople){
					 * displayPeopleToggleBtn.click(); }
					 * UtilHBM.waitExplicitClickable(driver,
					 * backgroundImgCurrent); for(int i=0; i<backgroundNo-1;
					 * i++){ arrowImgNext.click(); UtilHBM.waitFixTime(500); }
					 */
		realisticImagePageCheck();

		setBackground(backgroundNo, naturalLightsOn);
		for (int j = 0; j < noOfImages; j++) {
			clickGenerateButton().sendHQImageRequest(smallOrLarge);
			Message message = PageFactory.initElements(driver, Message.class);
			if (j == noOfImages) {
				message.closeHQMessage();
			} else {
				message.createNewHQImage();
			}
			System.out.println(j);
			UtilHBM.waitFixTime(1000);
		}
		cancelBtn.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}

	public RealisticImage getStarted() {
		UtilHBM.waitExplicitDisplayed(driver, getStartedImg);
		UtilHBM.waitExplicitDisplayed(driver, getStartedBtn);
		UtilHBM.waitExplicitClickable(driver, getStartedBtn);
		UtilHBM.waitFixTime(1000);
		Verification.displayOfWebElement(getStartedMsg);
		getStartedBtn.click();
		UtilHBM.waitTillElementDisappear(driver, getStartedBtn);
		UtilHBM.waitExplicitClickable(driver, backgroundImgBtn);

		return this;
	}

	public HQImageSize clickGenerateButton() {
		UtilHBM.waitExplicitDisplayed(driver, generateButton);
		UtilHBM.waitExplicitClickable(driver, generateButton);
		generateButton.click();
		UtilHBM.waitExplicitDisplayed(driver,
				"//section[@class='mod-sublayer-selectable-list mod-open']/div[@class='content']");
		return PageFactory.initElements(driver, HQImageSize.class);
	}

	public RealisticImage setBackground(int index, boolean naturalLightsOn) {
		backgroundImgBtn.click();
		UtilHBM.waitExplicitDisplayed(driver, naturalLightText);
		if (naturalLightsOn) {
			if (!naturalLightToggle.isSelected()) {
				naturalLightToggle.click();
			}
			Verification.selectedWebElement(driver, naturalLightToggle);
		}
		UtilHBM.waitExplicitDisplayed(driver, backgroundImgCurrent);
		UtilHBM.waitExplicitDisplayed(driver, backgroundImgText);
		String img = backgroundImgCurrent.getAttribute("srcset");
		arrowImgNext.click();
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitDisplayed(driver, backgroundImgCurrent);
		if (img.equalsIgnoreCase(backgroundImgCurrent.getAttribute("srcset"))) {
			UtilHBM.reportKO("Background image in HQ rendering not changed after Next arrow click");
		}
		arrowImgPrevious.click();
		UtilHBM.waitFixTime(500);
		if (!(img.equalsIgnoreCase(backgroundImgCurrent.getAttribute("srcset")))) {
			UtilHBM.reportKO("Background image in HQ rendering not changed after Previous arrow click");
		}
		for (int i = 0; i < index; i++) {
			arrowImgNext.click();
			UtilHBM.waitFixTime(500);
		}
		backgroundImgBtn.click();
		return this;
	}

	public RealisticImage setSunPosition(int x1, int y1, int x2, int y2) {
		UtilHBM.waitExplicitClickable(driver, sunBtn);
		sunBtn.click();
		if (autoSunToggle.isSelected()) {
			UtilHBM.reportOK("By default auto sun toggle is ON");
			Verification
					.displayNAttributeCheckOfElement(autoSunOnMsg,
							"auto sun on message text", "text",
							"We'll set automatically the best light to create the most beautiful image.");

			autoSunToggle.click();
			UtilHBM.waitExplicitDisplayed(driver, autoSunOffNotifiMsg);
			if (!(autoSunToggle.isSelected())
					&& autoSunOffNotifiMsg
							.getText()
							.equalsIgnoreCase(
									"Your plan information will be visible to all users. Do not share your name, address...")) {
				autoSunOffNotifiMsg.getText();
				UtilHBM.reportOK("Auto sun toggle is now OFF and msg appears successfully");
			}
			// autoSunToggle.click();
			// UtilHBM.waitExplicitDisplayed(driver, autoSunOnNotifiMsg);
			UtilHBM.waitFixTime(500);

			// WebElement circle=
			// driver.findElement(By.cssSelector(".mod-tool-sun-inclination>input[value='333']"));

			// WebElement circle =
			// driver.findElement(By.xpath("//div[@class='mod-tool-sun-position']//div[@style=('transform: rotate("+angle+"deg);')]"));

			new Actions(driver).moveToElement(sunPositionCircle, x1, y1)
					.click().build().perform();
			new Actions(driver).moveToElement(sunInclinationCircle, x2, y2)
					.click().build().perform();
			// new
			// Actions(driver).click(driver.findElement(By.cssSelector(".mod-tool-sun-inclination>input[value='"+angle+"']"))).build().perform();
			// Verification.displayNAttributeCheckOfElement(circle,
			// "value of angle", "value", angle);
			Verification.displayOfWebElement(sunPositionIndicator);
			Verification.displayOfWebElement(sunPositionimage);

		} else {
			UtilHBM.reportKO("By default auto sun toggle is not ON");
		}
		sunBtn.click();
		return this;
	}

	public RealisticImage cameraHeight(int x, int y) {
		new Actions(driver).moveToElement(cameraHeight, x, y).click().build()
				.perform();
		return this;
	}

	public RealisticImage artifitialLight(boolean lightsOn, String allOrOnlyON) {
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, lightBtn);
		UtilHBM.waitExplicitClickable(driver, lightBtn);
		lightBtn.click();
		UtilHBM.waitExplicitDisplayed(driver, artifitialLightText);
		Verification.displayNAttributeCheckOfElement(artifitialLightText,
				"Artificial light text", "text", "Artificial lights");
		Verification.displayNAttributeCheckOfElement(activateLightText,
				"Activate light text", "text", "Activate lights");

		if (lightsOn) {
			if (!lightToggle.isSelected()) {
				lightToggle.click();
			}
			Verification.selectedWebElement(driver, lightToggle);
		} else {
			if (lightToggle.isSelected()) {
				lightToggle.click();
				Verification.disabledWebElement(lightToggle);
				if (!lightToggle.isSelected()) {
					UtilHBM.reportOK("Light toggle is OFF");
				} else {
					UtilHBM.reportKO("Light toggle is ON and test is failed");
				}
			}

		}

		if (!allOrOnlyON.isEmpty()) {
			UtilHBM.waitExplicitDisplayed(driver, lightOnlyOn);
			UtilHBM.waitExplicitDisplayed(driver, lightAll);
			if (allOrOnlyON.equalsIgnoreCase("all")) {
				if (!lightAll.isSelected()) {
					lightAll.click();
				}
				Verification.selectedWebElement(driver, lightAll);
			} else {
				if (!lightOnlyOn.isSelected()) {
					lightOnlyOn.click();
				}
				Verification.selectedWebElement(driver, lightOnlyOn);
			}

		}

		/*
		 * if(lightOneOrAll.isEmpty()){
		 * 
		 * UtilHBM.reportOK("By default light toggle is ON");
		 * if(lightToggle.isSelected()){
		 * UtilHBM.reportOK("By default light toggle is ON");
		 * if(turn_light_Off){ lightToggle.click();
		 * if(!lightToggle.isSelected()){
		 * UtilHBM.reportOK("Light toggle is OFF"); } } }else{
		 * UtilHBM.reportKO("light toggle is not ON by default"); }
		 * 
		 * }else{ Verification.displayNAttributeCheckOfElement(lightOnlyOnText,
		 * "Artificial light text", "text", "Artificial lights");
		 * Verification.displayNAttributeCheckOfElement(lightAllText,
		 * "Activate light text", "text", "Activate lights");
		 * 
		 * UtilHBM.waitExplicitDisplayed(driver, lightOnlyOn);
		 * UtilHBM.waitExplicitDisplayed(driver, lightAll);
		 * 
		 * if(lightOnlyOn.isSelected() && !(lightAll.isSelected())){
		 * Verification.displayNAttributeCheckOfElement(lightAllText,
		 * "Activate light text", "text", "Activate lights");
		 * UtilHBM.reportOK("'Only the ones ON' is selected");
		 * UtilHBM.waitExplicitDisplayed(driver, lightAll);
		 * UtilHBM.waitExplicitClickable(driver, lightAll); lightAll.click();
		 * if(!(lightOnlyOn.isSelected()) && lightAll.isSelected()){
		 * UtilHBM.reportOK("'All' is selected"); }
		 * if(!(lightOnlyOn.isSelected()) && lightAll.isSelected() &&
		 * one_light){
		 * Verification.displayNAttributeCheckOfElement(lightOnlyOnText,
		 * "Artificial light text", "text", "Artificial lights");
		 * UtilHBM.reportOK("'All' is selected"); lightOnlyOn.click();
		 * UtilHBM.reportOK("'Only the ones ON' is selected"); }else{
		 * UtilHBM.reportKO("'Only the ones ON' is not selected"); }
		 * if(more_light && lightOnlyOn.isSelected() &&
		 * !(lightAll.isSelected())){
		 * Verification.displayNAttributeCheckOfElement(lightAllText,
		 * "Activate light text", "text", "Activate lights");
		 * UtilHBM.reportOK("'Only the ones ON' is selected");
		 * UtilHBM.waitExplicitClickable(driver, lightAll); lightAll.click();
		 * if(!(lightOnlyOn.isSelected()) && lightAll.isSelected()){
		 * UtilHBM.reportOK("'All' is selected"); }else{
		 * UtilHBM.reportKO("'All' is not selected"); } }
		 * 
		 * } // if(one_light && lightAll.isSelected() &&
		 * !(lightOnlyOn.isSelected())){ // lightOnlyOn.click(); //
		 * UtilHBM.reportOK("Only switched ON light should be ON"); // } // }
		 */
		return this;
	}
}
