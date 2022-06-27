package kitchen.bryo.pageObject;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import hbm.web.pageobject.DraftSightEmbed;

public class MakeItHappen {
	WebDriver driver;

	public MakeItHappen(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//li[@id='step-finalize']/button[@data-step='4']")
	private WebElement nextStep4;

	@FindBy(css = ".inner-content>h1")
	private WebElement title;

	@FindBy(css = ".inner-content>div>div>p")
	private WebElement info;

	@FindBy(css = ".popin-footer>button[data-ui-action='primary-button-action']")
	private WebElement yesButton;

	@FindBy(css = "button[data-ui-action='share-your-project']")
	private WebElement shareProjectButton;

	@FindBy(css = "button[data-ui-action='mail']")
	private WebElement mail;

	@FindBy(css = "button[data-ui-action='contact-coworker']")
	private WebElement contactCoworkerButton;

	@FindBy(css = ".mod-bubble.position-top-left.mod-open")
	private List<WebElement> shareOptionBubble;

	@FindBy(css = "button[data-ui-action='product-list']")
	private WebElement productListIcon;

	@FindBy(xpath = "//div[@class='project-title']/h2")
	private WebElement step4ProjectName;

	@FindBy(xpath = "//div[@data-ui-selector='total-price-step4']/span/span[contains(@class,'standard-price-label')]")
	private WebElement regularPrice;

	@FindBy(xpath = "//div[@class='project-price']/span/span[@class='reduced-price']")
	private List<WebElement> currentPrice;

	@FindBy(xpath = "//div[@class='project-price']/span/span[@class='membership-price']")
	private List<WebElement> membershipPrice;

	@FindBy(css = "#panel-manual-notes>div>div>div>b")
	private List<WebElement> addNotesError;

	@FindBy(xpath = "//div[@id='project-design-check']/div/button[@data-ui-action='back_to_step3']")
	private WebElement backToDetailsButtonToFix;

	@FindBy(xpath = "//div[@id='step-3-project-detail']/p[@class='project-title']/span[@id='project-title']")
	private WebElement step3ProjectTitle;

	@FindBy(css = "button[data-ui-action='save']")
	private WebElement saveIcon;

	@FindBy(css = "article[data-ui-selector='login-popin']")
	private List<WebElement> loginWindow;

	@FindBy(id = "close-app")
	private WebElement closePlanner;

//	@FindBy(css = "div[class='project-infos-container']>ul>li>button[data-ui-action='action-print']")
//	private WebElement printButton;

	@FindBy(css = "div>button[data-ui-action='action-print']")
	private WebElement printButton;

	@FindBy(css = "input[type='submit']")
	private WebElement loginButton;

	@FindBy(xpath = "//section[@class='form-container']/article/div/form[starts-with(@action,'/login')]")
	private List<WebElement> hbmLoginWindow;

	@FindBy(css = "button[data-ui-action='action-export-hbm']")
	private WebElement exportButton;

	@FindBy(css = "div[class='project-next-steps']>button[data-ui-action='proceed']")
	private WebElement proceedButton;

	@FindBy(xpath = "//ul/li/button[@data-step='1']")
	private WebElement floorPlanStep;

	@FindBy(xpath = "//div[@class='project-price']/div[@id='cash-option']/span[starts-with(@class,'price-container')]/span[starts-with(@class,'standard-price')]")
	private WebElement priceInCashPayOpt;

	@FindBy(xpath = "//ul/li/button[@data-step='3']")
	private WebElement designStep;

	@FindBy(xpath = "//span[@class='vat']")
	private WebElement vat;

	@FindBy(xpath = "//section[@class='modular-project-overview-mainview']/div/div/div[@class='project-image-container']/img")
	private List<WebElement> projectPreview;

	@FindBy(xpath = "//div[@id='cash-option'] //span/button[@data-ui-action='priceInfo']")
	private WebElement priceInfoIconCashPayOpt;

	@FindBy(xpath = "//div[@class='project-design-check']/div[@class='container-cards']/div")
	private List<WebElement> projectDesignCheckSize;

	@FindBy(xpath = "//button/span[contains(.,'2D plans & images')]")
	private WebElement twoDPlanAndImagesTab;

	@FindBy(xpath = "//div[@data-ui-selector='project-plans']/div[@class='empty-section']/p[contains(.,'You have not created any 2D plans of your project.')]")
	private List<WebElement> emptyPlans;

	@FindBy(xpath = "//div[@data-ui-selector='project-images-empty']/div[@class='empty-section']/p[contains(.,'You have not created any images of your project.')]")
	private List<WebElement> emptyImages;

	@FindBy(xpath = "//div[@class='plan-info']/span/following-sibling::span[contains(text(),'Worktop')]")
	private List<WebElement> worktopPlanImages;

	@FindBy(xpath = "//div[@class='plan-info']/span/following-sibling::span[contains(text(),'Wall Panel')]")
	private List<WebElement> wallPanelPlanImages;

	@FindBy(xpath = "//div[@class='plan-info']/span/following-sibling::span[contains(text(),'TopPlan')]")
	private List<WebElement> topPlanImages;

	@FindBy(xpath = "//div[@class='plan-info']/span/following-sibling::span[contains(text(),'FacePlan')]")
	private List<WebElement> facePlanImages;

//	@FindBy(xpath = "//div[@class='project-images']/div/div[@class='img-container']/img[contains(@src,'project-overview-placeholder.jpg')]")
//	private List<WebElement> inProgressImages;

	@FindBy(xpath = "//div[@class='project-images']/div/div/div[@class='img-container']/img[contains(@src,'../media/img/placeholders/hqrenders.jpg')]")
	private List<WebElement> inProgressImages;

	@FindBy(xpath = "//div[@class='project-images']/div/div/div[@class='img-container']/img[contains(@src,'https://byme-enterprise-preprod')]")
	private List<WebElement> generatedImages;

//	@FindBy(xpath = "//div[@class='project-images']/div/div[@class='img-container']/img[starts-with(@src,'https')]")
//	private List<WebElement> generatedImages;

	@FindBy(xpath = "//div[@class='project-images']/div/div[@class='img-container']/img[starts-with(@src,'https')]")
	private List<WebElement> snapShotCount;

	@FindBy(xpath = "//div[@class='project-plans']/div/button/span")
	private WebElement twoDPlanToggle;

	@FindBy(xpath = "//div[@class='project-plans']/div/h3")
	private WebElement twoDPlanHdr;

	@FindBy(xpath = "//div[@class='project-images']/div/button")
	private WebElement imagesToggle;

	@FindBy(xpath = "//div[@class='project-images']/div/h3")
	private WebElement imagesHdr;

	@FindBy(css = "div>p[data-notif-action='hbm_export']")
	private WebElement hbmExportRibbon;

	@FindBy(xpath = "//button[@data-ui-action='item-notes']")
	private WebElement itemNotes;

	@FindBy(xpath = "//div[@class='empty-section-plan']/span[@class='icon-tools-plan']")
	private WebElement planToolsIcon;

	@FindBy(xpath = "//div[@class='empty-section-picture']/span[@class='icon-tools-picture']")
	private WebElement pictureToolsIcon;

	@FindBy(xpath = "//div[@class='empty-section-plan']/div/p[@data-i18n='media_list.plan2D_not_found']")
	private WebElement plan2DNotFoundText;

	@FindBy(xpath = "//div[@class='empty-section-picture']/div/p[@data-i18n='media_list.images_not_found']")
	private WebElement imagesNotFoundText;

	@FindBy(xpath = "//div[@class='empty-section-picture']/div/button[@data-ui-action='create-media-action']")
	private WebElement createOneButton;

	@FindBy(xpath = "//div[@class='img-container']/div[@class='img-container-inner']/img[starts-with(@src,'data:image/jpeg')]")
	private List<WebElement> twoDPlansAndImages;

	@FindBy(xpath = "//div[@class='show-all-images-tile']/button[@data-i18n='kitchen.index.showImages;planner.index.showImages'][contains(text(),'Show images')]")
	private WebElement showImagesButton;

	@FindBy(xpath = "//article[@class='mod-layer-project-medias mod-open']/div/main/header/div/div/button[@data-ui-action='layer-close']")
	private WebElement close2DPlanAndImageLayer;

	@FindBy(xpath = "//button[@class='bt-next-round']")
	private List<WebElement> sliderNavigationNextButton;

	@FindBy(xpath = "//button[@class='bt-prev-round']")
	private List<WebElement> sliderNavigationPreviousButton;

	@FindBy(xpath = "//section[@class='mod-sublayer-media-slider mod-open']/header/button[@class='bt-back']")
	private WebElement backButton;

	@FindBy(xpath = "//button[@data-ui-action='total-price-option']")
	private WebElement cashPayment;

	@FindBy(xpath = "//button[@data-ui-action='monthly-price-option']")
	private WebElement monthlyPayment;

	@FindBy(xpath = "//button[@data-ui-action='total-price-option'][@class='bt-tab']")
	private WebElement cashPaymentActive;

	@FindBy(xpath = "//button[@data-ui-action='monthly-price-option'][@class='bt-tab selected']")
	private WebElement monthlyPaymentActive;

	@FindBy(xpath = "//div[@data-ui-action='show_finance_detail']")
	private WebElement showFinanceDetail;

	@FindBy(xpath = "//p[@data-ui-selector='monthly-description']")
	private WebElement monthlyDescription;

	@FindBy(xpath = "//section[@class='mod-sublayer-media-slider mod-open']/header/button[@data-ui-action='layer-close']/span[@class='icon-view-close']")
	private WebElement closeFullScreenImg;

	@FindBy(xpath = "//section[@class='mod-sublayer-media-slider mod-open']/div/div/div/ul/li[starts-with(@class,'item swiper-slide-active')]/img")
	private List<WebElement> fullWidthMedia;

	@FindBy(xpath = "//section[@class='mod-sublayer-media-slider mod-open']/div/div/div/ul/li[starts-with(@class,'item swiper-slide-active')]/iframe")
	private List<WebElement> fullWidth360;

	@FindBy(xpath = "//div[@id='iframeContainer']/iframe")
	private WebElement iframe;

	@FindBy(xpath = "//div[@class='img-container']/div[@data-ui-action='media-img-clicked']/img[starts-with(@src,'data:')]")
	private List<WebElement> planCount;

	@FindBy(xpath = "//div[@class='loading img-container']/div[@class='img-container-inner-picture-loader']/span[@class='icon-action-reload']")
	private WebElement inProgressLoader;

	@FindBy(xpath = "//div[@class='loading img-container']/div[@class='img-container-inner-picture-loader']/span[@class='icon-action-reload']/following-sibling::span")
	private WebElement inProgressMessage;
	@FindBy(css = "#project-media-module>header>h3")
	private WebElement projectMediaTitle;

	@FindBy(xpath = "//article[@class='mod-popin-back-to-fix-small mod-open']/div/div[@class='inner-content']")
	private WebElement kitchenTools;
	
	@FindBy(xpath = "//article[@class='mod-popin-back-to-fix-small mod-open']/div/div[@class='inner-content']/h1")
	private WebElement issuesToResolveTitle;
	
	@FindBy(xpath = "//article[@class='mod-popin-back-to-fix-small mod-open']/div/div[@class='inner-content']/div/div/p")
	private WebElement issuesToResolveText;
	
	@FindBy(xpath = "//article[@class='mod-popin-back-to-fix-small mod-open']/div/div[@class='inner-content']/div/p[@class='question']")
	private WebElement issuesToResolveQuestion;
	
	@FindBy(xpath = "//article[@class='mod-popin-back-to-fix-small mod-open']/div/footer/button[@class='cta-secondary-xl']")
	private WebElement issuesToResolveNo;
	
	@FindBy(xpath = "//article[@class='mod-popin-back-to-fix-small mod-open']/div/footer/button[@class='cta-primary-alt-xl']")
	private WebElement issuesToResolveYes;
	
	public MakeItHappen step4() {
		System.out.println(nextStep4.getText());
		UtilHBM.waitExplicitDisplayed(driver, nextStep4);
		UtilHBM.waitExplicitClickable(driver, nextStep4);
		new Actions(driver).moveToElement(nextStep4).click().build().perform();
		UtilHBM.waitFixTime(1000);
		return this;
	}

	public MakeItHappen verifyStep4() {
		UtilHBM.waitFixTime(1000);
		if (driver.findElement(By.xpath("//li[@id='step-finalize']")).getAttribute("class").contains("current")) {
			System.out.println("In step 4 ");
			UtilHBM.waitExplicitClickable(driver, printButton);
		}
		if (projectPreview.isEmpty()) {
			UtilHBM.reportKO("Project preview not displayed");
		} else if (projectPreview.get(0).getAttribute("src").startsWith("data:image")) {
			UtilHBM.reportOK("Project preview displayed");
		}
		Verification.displayOfWebElement(step4ProjectName);
		Verification.displayOfWebElement(priceInCashPayOpt);
		Verification.displayOfWebElement(priceInfoIconCashPayOpt);
		Verification.displayOfWebElement(printButton);
		Verification.displayOfWebElement(exportButton);
		Verification.displayOfWebElement(proceedButton);
		UtilHBM.waitFixTime(2000);
//		Verification.displayOfWebElement(driver.findElement(By.xpath(
//				"//button[@class='bt-filter-tab'][@aria-selected='true']/span[contains(.,'Project overview')]")));
//		Verification.displayOfWebElement(
//				driver.findElement(By.xpath("//button[@class='bt-filter-tab']/span[contains(.,'2D plans & images')]")));
		Verification.VerifyEquals("VAT included text not displayed", vat.getText(), "VAT included");
		return this;
	}

	public DraftSightEmbed exportProject() {
		UtilHBM.waitExplicitDisplayed(driver, exportButton);
		UtilHBM.waitExplicitClickable(driver, exportButton);
		exportButton.click();
		UtilHBM.webElement(driver, ".mod-sublayer-media-animated.mod-open>footer>.cta-primary-alt-l").click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("#embedded-app-frame")));
		return PageFactory.initElements(driver, DraftSightEmbed.class);
	}

	public MakeItHappen verifyHBMExportMsg() {
		UtilHBM.waitExplicitDisplayed(driver, hbmExportRibbon);
		Verification.displayNAttributeCheckOfElement(hbmExportRibbon, "HBM Export Confirmaiton msg", "text",
				"A copy of your project was sent to HomeByMe.");
		return PageFactory.initElements(driver, MakeItHappen.class);
	}

	/*
	 * public HomeByMeProjects loginForHBM(SignUpData signUpData) { if
	 * (hbmLoginWindow.size() > 0) { UtilHBM.waitExplicitDisplayed(driver,
	 * loginButton); Login login = PageFactory.initElements(driver, Login.class);
	 * login.loginForKitchenHomeByMe(signUpData);
	 * 
	 * } else { UtilHBM.reportInfo("User already logged in"); }
	 * 
	 * return PageFactory.initElements(driver, HomeByMeProjects.class); }
	 */
	public MakeItHappen verifyPriceInStep4(String price) {
		UtilHBM.waitExplicitDisplayed(driver, step4ProjectName);
		UtilHBM.waitExplicitDisplayed(driver, productListIcon);
		UtilHBM.waitExplicitClickable(driver, productListIcon);
		if (!price.isEmpty()) {
//			WebElement p = driver
//					.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'" + price + "')]"));
			WebElement currency = driver
					.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'\u20AC')]"));
//			Verification.displayOfWebElement(p);
			Verification.displayOfWebElement(currency);
			String p1 = driver.findElement(By.xpath("//span[@class='standard-price ']")).getText()
					.replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", "");
			System.out.println("price 1:" + p1);
			System.out.println("price:" + price);
			System.out.println(p1.equals(price));
			if (p1.equalsIgnoreCase(price)) {
				UtilHBM.reportOK("Step 4 : Expected price: " + price + " SAME as actual price: " + p1);
			} else {
				UtilHBM.reportKO("Step 4 : Expected price: " + price + " NOT SAME as actual price: " + p1);
			}
		}
		return this;
	}

	public SaveProject clickSave(SignUpData signUpData) {
		UtilHBM.waitExplicitDisplayed(driver, saveIcon);
		UtilHBM.waitExplicitClickable(driver, saveIcon);
		saveIcon.click();

		login(signUpData);
		return PageFactory.initElements(driver, SaveProject.class);

	}

	public MakeItHappen login(SignUpData signUpData) {
		driver.switchTo().parentFrame();
		if (loginWindow.size() > 0) {
			KitchenLogin login = PageFactory.initElements(driver, KitchenLogin.class);
			login.login(signUpData);

		} else {
			UtilHBM.reportMsg("User already logged in");
		}
		driver.switchTo().frame(driver.findElement(By.cssSelector("#iframeContainer>iframe")));
		return PageFactory.initElements(driver, MakeItHappen.class);
	}

	public MakeItHappen saveProjectInStep4(SignUpData signUpData, String name, String desc) {
		clickSave(signUpData).saveProject(name, desc);
		return PageFactory.initElements(driver, MakeItHappen.class);
	}

	public StartNow closePlanner() {
		UtilHBM.waitFixTime(2500);
		closePlanner.click();
		driver.switchTo().parentFrame();
		return PageFactory.initElements(driver, StartNow.class);
	}

	public StartNow saveChanges() {
		if (driver.findElement(By.cssSelector(".mod-popin-unsaved-changes-small.mod-open")).isDisplayed()) {
			driver.findElement(By.cssSelector(
					".mod-popin-unsaved-changes-small.mod-open>div>footer>button[data-ui-action='primary-button-action']"))
					.click();
		}
		return PageFactory.initElements(driver, StartNow.class);
	}

	public MakeItYours clickDesignStep() {
		System.out.println("in design");
		UtilHBM.waitExplicitDisplayed(driver, designStep);
		UtilHBM.waitExplicitClickable(driver, designStep);
		Actions action = new Actions(driver);
		action.moveToElement(designStep).build().perform();
		designStep.click();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours backToDetails() {
		UtilHBM.waitExplicitDisplayed(driver, backToDetailsButtonToFix);
		UtilHBM.waitExplicitClickable(driver, backToDetailsButtonToFix);
		backToDetailsButtonToFix.click();
		UtilHBM.waitExplicitDisplayed(driver, step3ProjectTitle);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItHappen verifyBusinessRulesList() {
//		Verification.displayOfWebElement(backToDetailsButton);

		if (projectDesignCheckSize.size() > 0) {
			for (WebElement rules : projectDesignCheckSize) {
//				List<String> businessRulesDetails = Arrays.asList(BusinessRules.getRuleType().split(":"));
//				String ruleType = businessRulesDetails.get(0);
//				String ruleCount = businessRulesDetails.get(1);
//				System.out.println("ruleType in step 4 :"+ruleType +" with count : "+ruleCount);
				if (rules.isDisplayed()) {
					String[] part = rules.getText().split(" ");
					System.out.println("part: " + part);
					System.out.println("part 0 :" + part[0]);
					System.out.println("part 1 :" + part[1]);

//					if (ruleType.equalsIgnoreCase(part[0])) {
//
//						UtilHBM.reportOK("Rule type displayed in step 4 : " + part[1] + " with count : " + part[0]
//								+ " is same as in step 3 : " + ruleType + "with count " + ruleCount);
//					} else {
//						UtilHBM.reportKO("Rule type displayed in step 4 : " + part[1] + " with count " + part[0]
//								+ " is different than that in step 3 : " + ruleType + "with count " + ruleCount);
//					}

				}
			}
		}

		else {
			UtilHBM.reportKO("No Business rule displayed");
		}

		return this;
	}

	public MakeItHappen verifyProjectTitleDetails() {
//		Verification.displayOfWebElement(backToDetailsButton);
		List<String> projectDetails = Arrays.asList(MakeItYours.getProjName().split(":"));
		String projName = projectDetails.get(0);
		String projStandardPrice = projectDetails.get(1);
		if (projName.equalsIgnoreCase(step4ProjectName.getText())) {
			UtilHBM.reportOK("Project name displayed in step 4 : " + step4ProjectName.getText()
					+ " is same as in step 3 : " + projName);
		} else {
			UtilHBM.reportOK("Project name displayed in step 4 : " + step4ProjectName.getText()
					+ " is different than that in step 3: " + projName);
		}
		UtilHBM.waitExplicitDisplayed(driver, regularPrice);
		if (projStandardPrice.equalsIgnoreCase(regularPrice.getText())) {
			UtilHBM.reportOK("Regular Price displayed in step 4: " + regularPrice.getText() + " is same as in step 3 :"
					+ projStandardPrice);
		} else
			UtilHBM.reportOK("Regular Price displayed in step 4 :" + regularPrice.getText()
					+ " is different than that in step 3 :" + projStandardPrice);

		return this;
	}

	public MakeItHappen share() {
		Actions action = new Actions(driver);
		action.moveToElement(shareProjectButton).click().perform();
		Share share = PageFactory.initElements(driver, Share.class);
		share.verifyShare();
		return PageFactory.initElements(driver, MakeItHappen.class);
	}

//	public MakeItHappen coworker() {
//		Actions action = new Actions(driver);
//		action.moveToElement(contactCoworkerButton).click().perform();
//		if (driver.findElements(By.cssSelector(".unsaved-changes-alert-mod-popin.mod-open")).size() > 0) {
//			if (driver.findElement(By.cssSelector(".unsaved-changes-alert-mod-popin.mod-open")).isDisplayed()) {
//				driver.findElement(By.cssSelector(
//						".unsaved-changes-alert-mod-popin.mod-open>div>footer>button[data-ui-action='primary-button-action']"))
//						.click();
//				ContactCoWorker contact = PageFactory.initElements(driver, ContactCoWorker.class);
//				contact.checkContactPage();
//			}
//
//		} else {
//			ContactCoWorker contact = PageFactory.initElements(driver, ContactCoWorker.class);
//			contact.checkContactPage();
//		}
//
//		return PageFactory.initElements(driver, MakeItHappen.class);
//	}

	public Print clickPrint() {
		printButton.click();
		return PageFactory.initElements(driver, Print.class);
	}

	public MakeItHappen printTestInStep4(int renderCount, int planCount) {
		clickPrint().verifyMediasDisplayed(renderCount, planCount);
		return PageFactory.initElements(driver, MakeItHappen.class);
	}

	public FloorPlan clickfloorPlan() {
		floorPlanStep.click();
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public MakeItHappen verifyBusinessRules(int expireCount, int warningCount, int recommendCount) {
		if (expireCount == 0 && warningCount == 0 && recommendCount == 0 && driver
				.findElements(
						By.xpath("//h3[@data-i18n='kitchen.help_center.design_ok;planner.help_center.design_ok']"))
				.size() > 0) {
			UtilHBM.reportOK("Design is error free");
		} else if (projectDesignCheckSize.size() > 0) {
			for (WebElement rules : projectDesignCheckSize) {

				if (rules.isDisplayed()) {
					UtilHBM.waitExplicitDisplayed(driver, rules);
					UtilHBM.waitExplicitClickable(driver, rules);
					String[] part = rules.getText().split(" ");
					System.out.println("part[1] : " + part[1]);
					if (part[1].contains("Expired")) {
						int expire = Integer.parseInt(part[0]);
						System.err.println("step 4 : " + expire);
						if (expire == expireCount) {
							UtilHBM.reportOK("Expired products count in step 4 is correct and count is :" + expire);
						}
					}
					if (part[1].contains("Warnings")) {

						int warn = Integer.parseInt(part[0]);

						if (warn == warningCount) {
							UtilHBM.reportOK("Warning products count in step 4 is correct and count is :" + warn);
						}
					}
					if (part[1].contains("Recommendations")) {

						int tip = Integer.parseInt(part[0]);

						if (tip == recommendCount) {
							UtilHBM.reportOK(
									"Recommendations products count in step 4 is correct and count is :" + tip);
						}
					}
				}
			}
			backToDetails();
		}
		return this;
	}

//	public MakeItHappen twoDPlansAndImagesBeforeSave(int plans, int images) {
//		twoDPlanAndImagesTab.click();
//		UtilHBM.waitFixTime(500);
//		Verification.displayOfWebElement(driver.findElement(
//				By.xpath("//button[@class='bt-filter-tab selected']/span[contains(.,'2D plans & images')]")));
//		if (plans == 0 && emptyPlans.size() > 0) {
//			UtilHBM.reportInfo("You have not created any 2D plans of your project in step 4.");
//		} else 
////		if (topPlanImages.size() > 0) {
////			UtilHBM.reportInfo("Number of top plans displayed in step 4 are :" + topPlanImages.size());
////		}
////		if (facePlanImages.size() > 0) {
////			UtilHBM.reportInfo("Number of face plans displayed in step 4 are :" + facePlanImages.size());
////		}
//if(driver.findElements(By.xpath("//div[@data-ui-selector='project-plans']/div[@class='plan-container']/div/img")).size()>0) {
//	UtilHBM.reportInfo("Number of  plans displayed in step 4 are :" + driver.findElements(By.xpath("//div[@data-ui-selector='project-plans']/div[@class='plan-container']/div/img")).size());
//}
//		int twoDPlanImagesCount=driver.findElements(By.xpath("//div[@data-ui-selector='project-plans']/div[@class='plan-container']/div/img")).size();
////		int twoDPlanImagesCount = topPlanImages.size() + facePlanImages.size();
//		if (twoDPlanImagesCount == plans) {
//			UtilHBM.reportOK("Correct number of 2D plan images displayed before project save in step 4 and number of 2D plans  are "
//					+ twoDPlanImagesCount);
//
//		} else {
//			UtilHBM.reportKO("Incorrect number of 2D plans displayed before project save in step 4 and number of 2D plans are  " + twoDPlanImagesCount);
//		}
//
//		if (images == 0 && emptyImages.size() > 0) {
//			UtilHBM.reportInfo("You have not created any images of your project in step 4.");
//		} else
//			UtilHBM.reportKO("No message displayed for empty images tab in step 4");
//		return this;
//	}
//
//	public MakeItHappen twoDPlansAndImagesAfterSave(int plans, int images) {
//
//		twoDPlanAndImagesTab.click();
//		Verification.displayOfWebElement(driver.findElement(
//				By.xpath("//button[@class='bt-filter-tab selected']/span[contains(.,'2D plans & images')]")));
//		UtilHBM.waitExplicitClickable(driver, twoDPlanHdr);
//		UtilHBM.waitExplicitDisplayed(driver, "//div[@aria-hidden='false']/div[@class='project-plans']/div/button");
//		twoDPlanHdr.click();
//		Verification.displayOfWebElement(driver.findElement(By.xpath(
//				"//div[@class='project-plans']/div[@class='mod-togglable-section-toggler']/button[@aria-expanded='false']")));
//		imagesHdr.click();
//		Verification.displayOfWebElement(driver.findElement(By.xpath(
//				"//div[@class='project-images']/div[@class='mod-togglable-section-toggler']/button[@aria-expanded='false']")));
//		UtilHBM.waitExplicitClickable(driver, twoDPlanHdr);
//		twoDPlanHdr.click();
//		Verification.displayOfWebElement(driver.findElement(By.xpath(
//				"//div[@class='project-plans']/div[@class='mod-togglable-section-toggler active']/button[@aria-expanded='true']")));
//		imagesHdr.click();
//		Verification.displayOfWebElement(driver.findElement(By.xpath(
//				"//div[@class='project-images']/div[@class='mod-togglable-section-toggler active']/button[@aria-expanded='true']")));
//		UtilHBM.waitFixTime(1000);
//		if (plans == 0 && emptyPlans.size() > 0) {
//			UtilHBM.reportInfo("You have not created any 2D plans of your project in step 4.");
//		} else 
////			if (topPlanImages.size() > 0) {
////			UtilHBM.reportInfo("Number of top plans displayed in step 4 are :" + topPlanImages.size());
////		}
////		if (facePlanImages.size() > 0) {
////			UtilHBM.reportInfo("Number of face plans displayed in step 4 are :" + facePlanImages.size());
////		}
//		if(driver.findElements(By.xpath("//div[@data-ui-selector='project-plans']/div[@class='plan-container']/div/img")).size()>0) {
//			UtilHBM.reportInfo("Number of  plans displayed in step 4 are :" + driver.findElements(By.xpath("//div[@data-ui-selector='project-plans']/div[@class='plan-container']/div/img")).size());
//		}
//				int twoDPlanImagesCount=driver.findElements(By.xpath("//div[@data-ui-selector='project-plans']/div[@class='plan-container']/div/img")).size();
////		int twoDPlanImagesCount = topPlanImages.size() + facePlanImages.size();
//		if (twoDPlanImagesCount == plans) {
//			UtilHBM.reportOK("Correct number of 2D plan images displayed after project save in step 4 and number of 2D plan images are "
//					+ twoDPlanImagesCount);
//
//		} else {
//			UtilHBM.reportKO("Incorrect number of 2D plans displayed after project save in step 4 and number of 2D plans are  " + twoDPlanImagesCount);
//		}
//		System.out.println("2d plans " + twoDPlanImagesCount);
//		if (images == 0 && emptyImages.size() > 0) {
//			UtilHBM.reportInfo("You have not created any images of your project in step 4.");
//		}
//		int hqImagesCount = inProgressImages.size();
//		int totalCount = hqImagesCount + snapShotCount.size();
//		if (totalCount == images) {
//			UtilHBM.reportOK("Correct number of medias displayed in step 4 and number of medias are " + totalCount);
//			if (inProgressImages.size() > 0) {
//				UtilHBM.reportInfo("HQ rendering image is in progress and number of images in progress are :"
//						+ inProgressImages.size() + " and snapshots count are :" + snapShotCount.size());
//			}
//
//		}
//		System.out.println("images " + totalCount);
//		return this;
//	}
//
	public MakeItHappen deliveryService() {
		UtilHBM.waitExplicitDisplayed(driver, exportButton);
		DeliveryAndInstallationService service = PageFactory.initElements(driver, DeliveryAndInstallationService.class);
		service.toggleServices().deliveryService();
		return this;
	}

	public MakeItHappen installationService() {
		UtilHBM.waitExplicitDisplayed(driver, exportButton);
		DeliveryAndInstallationService service = PageFactory.initElements(driver, DeliveryAndInstallationService.class);
		service.installationService().installationPrice();
		return this;
	}

	public MakeItHappen verifyItemNoteAndProductListIconsDistinguishable() {
		Verification.VerifyEquals("Item note icon not distinguishable...", itemNotes
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"./assets/icons/icons.svg#icon-action-notes");
		Verification.VerifyEquals("Product list icon not distinguishable...", productListIcon
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"./assets/icons/icons.svg#icon-function-product-list");
		return this;
	}

	public ItemNotes itemNotes() {
		UtilHBM.waitExplicitDisplayed(driver, itemNotes);
		UtilHBM.waitExplicitClickable(driver, itemNotes);
		itemNotes.click();
		return PageFactory.initElements(driver, ItemNotes.class);
	}

	public MakeItHappen verifyEmptyPlansAndImages() {
		Verification.VerifyEquals("Item note icon not distinguishable...", planToolsIcon
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"./assets/icons/icons.svg#icon-tools-plan");
		Verification.VerifyEquals("Item note icon not distinguishable...", pictureToolsIcon
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"./assets/icons/icons.svg#icon-tools-picture");
		Verification.VerifyEquals("2D plan not found text not correct", plan2DNotFoundText.getText(),
				"You have not created any 2D plans of your project.");
		Verification.VerifyEquals("Images not found text not correct", imagesNotFoundText.getText(),
				"You have not created any images of your project.");
		Verification.displayOfWebElement(createOneButton);
		clickCreateOne();
		return this;
	}

	public MakeItYours clickCreateOne() {
		createOneButton.click();
		MakeItYours tooltip = PageFactory.initElements(driver, MakeItYours.class);
		tooltip.verifyRealisticToolTip();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

//	public TwoDPlansAndImagesCheck verifyFullScreenImgSrc() {
//		UtilHBM.waitFixTime(3500);
//		List<WebElement> mediaImg = driver
//				.findElements(By.xpath("//div[@class='img-container']/div[@data-ui-action='media-img-clicked']/img"));
//		int mediaListSize = mediaImg.size();
//		for (int i = 0; i < mediaListSize; i++) {
//		WebElement currentImg = mediaImg.get(i);
//		String imgSrc = currentImg.getAttribute("src");
//		System.out.println("img SRC: " + imgSrc);
//		
//		Actions action=new Actions(driver);
//		action.moveToElement(currentImg).click().build().perform();
//		driver.switchTo().parentFrame();
//		System.out.println("img SRC 1: " + fullWidthMedia.get(0).getAttribute("src"));
//		if (fullWidthMedia.get(0).getAttribute("src").equals(imgSrc)) {
//			UtilHBM.reportOK("Image displayed correctly in fullscreen mode");
//		} else {
//			UtilHBM.reportKO("Invalid img displayed in full screen");
//		}
//
//		action.moveToElement(closeFullScreenImg).click().build().perform();
//		driver.switchTo().frame(iframe);
//		}
//		return PageFactory.initElements(driver, TwoDPlansAndImagesCheck.class);
//	}
//
	public TwoDPlansAndImagesCheck clickShowImages() {
		TwoDPlansAndImagesCheck plans = PageFactory.initElements(driver, TwoDPlansAndImagesCheck.class);
		plans.showImages();
		return PageFactory.initElements(driver, TwoDPlansAndImagesCheck.class);
	}
public TwoDPlansAndImagesCheck clickShowImagesStaging() {
	Verification.displayOfWebElement(showImagesButton);
	UtilHBM.waitExplicitClickable(driver, showImagesButton);
	UtilHBM.waitFixTime(3000);
	showImagesButton.click();
	driver.switchTo().frame(UtilHBM.webElement(driver,"iframe[src*='https://preprod-staging-widgets.enterprise-dev.by.me/Medias/embed.html']"));
	return PageFactory.initElements(driver, TwoDPlansAndImagesCheck.class);
}
	public MakeItHappen verify2DPlansAndImages(String type, int count) {
		UtilHBM.waitExplicitDisplayed(driver, projectMediaTitle);
		Assert.assertEquals(projectMediaTitle.getText(), "Images & 2D Plans", "Project Media Title not correct");
		UtilHBM.waitFixTime(3500);
		List<WebElement> mediaImg = driver.findElements(By.xpath(
				"//div[@class='img-container']/div[@data-ui-action='media-img-clicked']/img[contains(@src,'.jpg')]"));
		int mediaListSize = mediaImg.size();

		if (planCount.size() == count && type.equalsIgnoreCase("Plans")) {
			for (int i = 0; i < planCount.size(); i++) {
				WebElement currentImg = planCount.get(i);
				String imgSrc = currentImg.getAttribute("src");
				System.out.println("img SRC: " + imgSrc);
				Actions action = new Actions(driver);
				action.moveToElement(currentImg).click().build().perform();
				driver.switchTo().frame(UtilHBM.webElement(driver,
						"iframe[src*='https://preprod-widgets.enterprise-dev.by.me/Medias/embed.html']"));
//				UtilHBM.waitExplicitDisplayed(driver, closeFullScreenImg);
				UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector(".bt-back")));
				System.out.println("img SRC 1: " + fullWidthMedia.get(0).getAttribute("src"));
				if (fullWidthMedia.get(0).getAttribute("src").equals(imgSrc)) {
					UtilHBM.reportOK("2D plan displayed correctly in fullscreen mode");
				} else {
					UtilHBM.reportKO("Invalid 2D plans displayed in full screen");
				}
				action.moveToElement(closeFullScreenImg).build().perform();
				closeFullScreenImg.click();
				UtilHBM.waitFixTime(200);
				driver.switchTo().parentFrame();
				UtilHBM.waitExplicitDisplayed(driver, showImagesButton);
				UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath(
						"//h3[@data-i18n=\"kitchen.index.2d_plans_pictures;planner.index.2d_plans_pictures\"]")));
			}

		} else if (mediaListSize == count && type.equalsIgnoreCase("Images")) {
			for (int i = 0; i < mediaListSize; i++) {
				WebElement currentImg = mediaImg.get(i);
				String imgSrc = currentImg.getAttribute("src");
				System.out.println("img SRC: " + imgSrc);
				Actions action = new Actions(driver);
				action.moveToElement(currentImg).build().perform();
				action.moveToElement(currentImg).click().build().perform();
				UtilHBM.waitFixTime(1000);
				driver.switchTo().frame(UtilHBM.webElement(driver,
						"iframe[src*='https://preprod-widgets.enterprise-dev.by.me/Medias/embed.html']"));
//				UtilHBM.waitExplicitDisplayed(driver, closeFullScreenImg);
				UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector(".bt-back")));
				UtilHBM.waitExplicitDisplayed(driver, fullWidthMedia.get(0));
				System.out.println("img SRC 1: " + fullWidthMedia.get(0).getAttribute("src"));
				if (fullWidthMedia.get(0).getAttribute("src").equals(imgSrc)) {
					UtilHBM.reportOK("Images displayed correctly in fullscreen mode");
				} else {
					UtilHBM.reportKO("Invalid images displayed in full screen");
				}
				action.moveToElement(closeFullScreenImg).build().perform();
				closeFullScreenImg.click();
				driver.switchTo().parentFrame();
				UtilHBM.waitExplicitDisplayed(driver, showImagesButton);
				UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath(
						"//h3[@data-i18n=\"kitchen.index.2d_plans_pictures;planner.index.2d_plans_pictures\"]")));
			}
		} else
			UtilHBM.reportKO("Something wrong with 2D plans and Images!!");

		return PageFactory.initElements(driver, MakeItHappen.class);
	}

	public MakeItHappen verifyRenderingInProgress(int count) {
		UtilHBM.waitFixTime(3500);
		List<WebElement> inProgressImg = driver.findElements(By.xpath(
				"//div[@class='loading img-container']/div[@data-ui-action='media-img-clicked']/img[contains(@src,'.jpg')]"));
		int inProgressListSize = inProgressImg.size();
		if (inProgressListSize == count) {
			for (int i = 0; i < inProgressListSize; i++) {
				UtilHBM.waitExplicitDisplayed(driver, inProgressLoader);
				Verification.VerifyEquals("In progress loader icon not distinguishable...",
						inProgressLoader.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']"))
								.getAttribute("xlink:href"),
						"./assets/icons/icons.svg#icon-action-reload");
				Verification.VerifyEquals("Verification for rendering in progress failed ", inProgressMessage.getText(),
						"Rendering in progress");
				WebElement currentImg = inProgressImg.get(i);
				String imgSrc = currentImg.getAttribute("src");
				System.out.println("img SRC: " + imgSrc);
				Actions action = new Actions(driver);
				action.moveToElement(currentImg).click().build().perform();

				UtilHBM.waitExplicitDisplayed(driver, inProgressImg.get(0));
			}
		} else
			UtilHBM.reportKO("Incorrect in progress images count!!");

		return PageFactory.initElements(driver, MakeItHappen.class);
	}

	public MakeItHappen clickMonthlyPayment() {
		UtilHBM.waitFixTime(1000);
		Verification.displayOfWebElement(cashPaymentActive);
		UtilHBM.waitExplicitClickable(driver, monthlyPayment);
		monthlyPayment.click();
		Verification.displayOfWebElement(monthlyPaymentActive);
		return this;
	}

	public MakeItHappen verifyPricePerMonthInStep4(String pricePerMonth) {
		if (!pricePerMonth.isEmpty() && driver.findElement(By.xpath(
				"//div[@id='monthly-option']/span[@data-ui='total-price-container']/span/span[@class='monthly'][contains(text(),'/ month')]"))
				.isDisplayed()) {

			String p1 = driver.findElement(By.xpath(
					"//div[@id='monthly-option']/span[@data-ui='total-price-container']/span/span[contains(text(),'€')]"))
					.getText().trim().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", "");
			System.out.println("p1:" + p1);
			if (p1.equalsIgnoreCase(pricePerMonth)) {
				UtilHBM.reportOK("Step 4 : Expected price: " + pricePerMonth + " SAME as actual price: " + p1);
			} else {
				UtilHBM.reportKO("Step 4 : Expected price " + pricePerMonth + " NOT SAME as actual price: " + p1);
			}

			Verification.VerifyEquals("See details about finance text not displayed", showFinanceDetail.getText(),
					"See details about finance");
			Verification.VerifyEquals("Monthly-description text not displayed", monthlyDescription.getText(),
					"Credit is subject to approval. Terms may differ based on your financial circumstances and borrowing history");

		}
		return PageFactory.initElements(driver, MakeItHappen.class);
	}

	public FinanceOptions clickShowFinanceDetail() {
		UtilHBM.waitExplicitClickable(driver, showFinanceDetail);
		showFinanceDetail.click();
		return PageFactory.initElements(driver, FinanceOptions.class);
	}

	public MakeItHappen verifyProjectNameAndPriceMobile(String projName, String price) {

		if (projName.equalsIgnoreCase(step4ProjectName.getText())) {
			UtilHBM.reportOK("Project name displayed in step 4 : " + step4ProjectName.getText());
		} else {
			UtilHBM.reportOK("Project name not displayed in step 4 : " + step4ProjectName.getText());
		}
		UtilHBM.waitExplicitDisplayed(driver, regularPrice);
		if (price.equalsIgnoreCase(regularPrice.getText())) {
			UtilHBM.reportOK("Regular Price displayed in step 4: " + regularPrice.getText());
		} else
			UtilHBM.reportOK("Regular Price not displayed in step 4 :" + regularPrice.getText());

		return this;
	}
	public MakeItHappen checkRulesOnStep3ToStep4(String issuesToResolveYesNo) {
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//article[@class='mod-popin-back-to-fix-small mod-open']")));
		Verification.VerifyEquals("Kitchen tool icon in Issues to resolve pop-up not distinguishable...", kitchenTools
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"./assets/icons/icons.svg#icon-tools-kitchen");
		String titleText = "Issues to resolve";
		String message = "Your design contains issues that could have an impact on installation and usability. We recommend to review these issues.";
		String question = "Do you want to resolve the issues?";

		Verification.displayNAttributeCheckOfElement(issuesToResolveTitle, "Issues to resolve title", "text",
				titleText);
		Verification.displayNAttributeCheckOfElement(issuesToResolveText, "Issues to resolve info", "text",
				message);
	Verification.displayNAttributeCheckOfElement(issuesToResolveQuestion, "Issues to resolve question",
			"text", question);
	if (issuesToResolveYesNo.equalsIgnoreCase("yes")) {
		issuesToResolveYes.click();
	BusinessRules rules=PageFactory.initElements(driver, BusinessRules.class);
    rules.checkBusinessRuleShowIn3D("Base cabinet position", true);
	}
	else if (issuesToResolveYesNo.equalsIgnoreCase("no")) {
		issuesToResolveNo.click();
		Verification.displayOfWebElement(driver.findElement(By.xpath("//article[@class='mod-popin-unsaved-changes-small mod-open']")));
		Verification.displayOfWebElement(driver.findElement(By.xpath("//li[@id='step-finalize'][@class='current']")));
	}else {
		UtilHBM.reportKO("Something wrong with checkRules..!!");
	}
		return PageFactory.initElements(driver, MakeItHappen.class);
	}
	
	public MakeItHappen clickProceedButton() {
		UtilHBM.waitExplicitDisplayed(driver, proceedButton);
		UtilHBM.waitExplicitClickable(driver, proceedButton);
		proceedButton.click();
		return PageFactory.initElements(driver, MakeItHappen.class);
	}
}
