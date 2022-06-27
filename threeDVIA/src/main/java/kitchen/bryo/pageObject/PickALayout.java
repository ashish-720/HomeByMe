package kitchen.bryo.pageObject;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PickALayout {
	WebDriver driver;

	public PickALayout(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "#canvas-wrap-1:not([class*=loading])")
	private WebElement solutionLoaded;
	
	@FindBy(xpath = "//div[@class='canvas-wrap cursor-rotate']")
	private WebElement solutionLoading;
	
	@FindBy(xpath = "//ul/li/button[@data-ui-action='solution']")
	private List<WebElement> numberOfSolutions;

	@FindBy(css = ".mod-design-steps>li>button[data-step='3']")
	private WebElement designYourKitchenButton;

	@FindBy(xpath = "//article[@class='mod-popin-best-solutions-small mod-open']")
	private List<WebElement> bestSolutionPopUp;

	@FindBy(xpath = "//article[@class='mod-popin-overwrite-changes-small mod-open']/div/div/h1")
	private WebElement overwriteSolutionTitle;

	@FindBy(xpath = "//article[@class='mod-popin-overwrite-changes-small mod-open']/div/div/div[@class='text']/div/p")
	private WebElement overwriteSolutionInfo;

	@FindBy(xpath = "//article[@class='mod-popin-overwrite-changes-small mod-open']/div/div/div[@class='text']/p[@class='question']")
	private WebElement overwriteSolutionQuestion;

	@FindBy(css = ".mod-popin-overwrite-changes-small.mod-open")
	private List<WebElement> overwriteSolutionPopUp;

	@FindBy(xpath = "//article[@class='mod-popin-best-solutions-small mod-open']/div/div/h1")
	private WebElement bestSolutionTitle;

	@FindBy(xpath = "//article[@class='mod-popin-best-solutions-small mod-open']/div/div/div[@class='text']/div/p")
	private WebElement bestSolutionInfo;

	@FindBy(xpath = "//article[@class='mod-popin-best-solutions-small mod-open']/div/div/div[@class='text']/p[@class='question']")
	private WebElement bestSolutionQuestion;

//	@FindBy(css = ".mod-popin-best-solutions-small.mod-open>div>footer>button[data-ui-action='secondary-button-action']")
//	WebElement noBestSolution;
//
//	@FindBy(css = ".mod-popin-best-solutions-small.mod-open>div>footer>button[data-ui-action='primary-button-action']")
//	WebElement yesBestSolution;

	@FindBy(css = ".mod-popin-overwrite-changes-small.mod-open")
	private WebElement overwritePopUp;

	@FindBy(css = "div>footer>button[data-ui-action='secondary-button-action']")
	private WebElement noButton;

	@FindBy(css = "article[class^='mod-popin-no-solution'][class*='mod-open']")
	private WebElement noSolutionsFoundPopup;

	@FindBy(css = "div>footer>button[data-ui-action='primary-button-action']")
	private WebElement yesButton;

	@FindBy(css = ".canvas-tools-info-window>.info-title")
	private WebElement solutionInfoTitle;

	@FindBy(css = "p[class='price']>span[data-ui='total-price-container']")
	private WebElement solutionPrice;

	@FindBy(css = "button[data-ui-action='priceInfo']")
	private WebElement priceInfoIcon;
	
	@FindBy(css=".vat")
	private WebElement vatIncluded;

	@FindBy(css = "button[data-more='Show more'][aria-expanded='false']")
	private WebElement showMore;

	@FindBy(css = "button[data-less='Show less'][aria-expanded='true']")
	private WebElement showLess;

	@FindBy(id = "more-content")
	private WebElement moreContent;

	@FindBy(css = "div>div>.canvas-tools-zoom")
	private WebElement canvasTools;

	@FindBy(css = "div>div>.canvas-tools-options")
	private WebElement toolsOption;

	@FindBy(css = "div>div>.mod-overlay-container.mod-open")
	private WebElement viewMode;

	@FindBy(xpath = "//button[@data-ui-action='need-mapping']")
	private WebElement lookingForNeedMappingLink;

	@FindBy(xpath = "//article[@class='mod-popin-help-small mod-open']/div/div/h1")
	private WebElement howCanWeHelpTitle;

	@FindBy(xpath = "//article[@class='mod-popin-help-small mod-open']/div/div/div[@class='text']")
	private WebElement howCanWeHelpInfo;

	@FindBy(xpath = "//footer/button[@class='cta-secondary-xl']/span")
	private WebElement startFromScratchButton;

	@FindBy(xpath = "//footer/button/span[contains(text(),'Update my needs')]")
	private WebElement updateMyNeedsButton;

	@FindBy(xpath = "//footer/div[@class='link']/button[contains(text(),'Update my needs')]")
	private WebElement updateMyNeedsLink;

	@FindBy(xpath = "//footer/button/span[contains(text(),'Edit my floorplan')]")
	private WebElement editMyFloorplanButton;

	@FindBy(id = "project-title")
	private WebElement projectTitle;

	@FindBy(css = "div.main.need-mapping section.step-finish div.titles-container div.tab-finish")
	private WebElement updateNeedsTab;

	@FindBy(xpath = "//button[@class='bt-next']")
	private List<WebElement> nextArrow;

	@FindBy(xpath = "//article[@class='mod-popin-no-solution-2-small mod-open']/div/div")
	private List<WebElement> solutionNotFoundPopUp;

	@FindBy(xpath = "//article[@class='mod-popin-no-solution-2-small mod-open']/div/div")
	private WebElement solutionNotFoundPopUpImage;

	@FindBy(xpath = "//article[@class='mod-popin-no-solution-2-small mod-open']/div/div/h1")
	private WebElement solutionNotFoundPopUpTitle;

	@FindBy(xpath = "//article[@class='mod-popin-no-solution-2-small mod-open']/div/div/div/div/p")
	private WebElement solutionNotFoundPopUpInfo;

	@FindBy(css = "p[class='price']>span>span>span[class='standard-price ']")
	private WebElement regularPrice;

	@FindBy(css = "p[class='price']>span>span[data-ui='current-price']")
	private List<WebElement> currentPrice;

	@FindBy(id = "close-app")
	private WebElement closePlanner;

	@FindBy(css = "button[data-ui-action='save']")
	private WebElement saveIcon;

	@FindBy(css = "article[data-ui-selector='login-popin']")
	private List<WebElement> loginWindow;

	@FindBy(css = "button[data-ui-action='product-list']")
	private WebElement productListIcon;

	@FindBy(id = "zoom-in")
	private WebElement zoomIn;

	@FindBy(id = "zoom-out")
	private WebElement zoomOut;

	@FindBy(xpath = "//div[@id='autoDesign-project-detail']/button")
	private WebElement nextStepButton;
	
	@FindBy(css=".canvas-tools-info-window>div>.title")
	private WebElement templateTitle;

	@FindBy(xpath = "//span[@class='monthly-price']")
	private WebElement monthlyPrice;
	
	@FindBy(xpath = "//div[@class='project-detail']/button[@data-ui-action='customize-this-kitchen']")
	private WebElement nextStepButtonMobile;

	@FindBy(css = ".mod-popin-skip-auto-small.mod-open button[data-ui-action='secondary-button-action']")
	private WebElement noBtnSkipSolutionsMsg;

	public PickALayout findSolutions(String solution) {
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, solutionLoaded);
		UtilHBM.waitExplicitDisplayed(driver, templateTitle);
		UtilHBM.waitFixTime(2000);
		String solutionName1 = templateTitle.getText();
		int a=1;
		while(!(solutionName1.startsWith(solution)) && a<numberOfSolutions.size()){
			UtilHBM.turnOffImplicitWaits(driver);
			if (nextArrow.size() != 0) {
			Actions action=new Actions(driver);
			action.moveToElement(nextArrow.get(0)).click().build().perform();
			UtilHBM.waitFixTime(1000);
			UtilHBM.waitExplicitDisplayed(driver, solutionLoading);
			UtilHBM.waitExplicitDisplayed(driver, "//div[@class='canvas-tools-info-window']/div/p[@class='title']");
			} else {
				numberOfSolutions.get(a).click();
				UtilHBM.waitFixTime(1200);
//				UtilHBM.waitExplicitDisplayed(driver, solutionLoading);
			}
			UtilHBM.turnOnImplicitWaits(driver);			
			UtilHBM.waitExplicitDisplayed(driver, solutionLoaded);
			UtilHBM.waitExplicitDisplayed(driver, "//div[@class='canvas-tools-info-window']/div/p[@class='title']");
			solutionName1 = driver.findElement(By.xpath("//div[@class='canvas-tools-info-window']/div/p[@class='title']")).getText();
			a++;
		}
		if(!solutionName1.startsWith(solution)){
			UtilHBM.reportKO("Expected layout template "+solution+" not found");
		}
		
//		if(!price.isEmpty()){
//			UtilHBM.waitExplicitDisplayed(driver, priceInfoIcon);
//			UtilHBM.waitFixTime(1000);
//			verifyPriceInStep2(price);
//		}
//		TemplatesInformationWindow info1 = PageFactory.initElements(driver,
//				TemplatesInformationWindow.class);
//		info1.verifyTemplateInfo();
//		if (!price.isEmpty()) {
//		info1.verifyTemplatesPrice();
//		}
		

		return this;
	}
	public PickALayout ikeaFindSolutions(String solution, String price) {

//		if (solutionLoading.isDisplayed()) {
//			UtilHBM.reportOK("Generating solutions");
//		} else {
//			UtilHBM.reportKO("Solution loading content not displayed");
//		}

		// WebDriverWait wait = new WebDriverWait(driver, 15);
		// wait.until(ExpectedConditions
		// .visibilityOfAllElements(numberOfSolutions));
		UtilHBM.waitFixTime(1000);
		// UtilHBM.waitTillElementDisappear(driver, ".item.loading");
		if (solutionNotFoundPopUp.size() > 0) {
			String expectedTitle = "We have not found any solution for your kitchen";
			String expectedInfo = "Make sure your kitchen has enough available space on at least one wall.";
			Verification.displayOfWebElement(solutionNotFoundPopUpImage);
			Verification.VerifyEquals("Solution not found title not correct", solutionNotFoundPopUpTitle.getText(),
					expectedTitle);
			Verification.VerifyEquals("Solution not found info not correct", solutionNotFoundPopUpInfo.getText(),
					expectedInfo);
			Verification.displayOfWebElement(startFromScratchButton);
			Verification.displayOfWebElement(
					driver.findElement(By.xpath("//footer/div/button[@data-ui-action='link-action']")));
			Verification.displayOfWebElement(editMyFloorplanButton);
		} else if (numberOfSolutions.size() > 0) {
			UtilHBM.waitFixTime(1000);
			Boolean soluNotFound = true;
			for (int i = 0; i < numberOfSolutions.size(); i++) {
				UtilHBM.waitFixTime(2000);
				String solutionName = driver.findElement(By.cssSelector(".canvas-tools-info-window>div>.title"))
						.getText();
				System.out.println("sol name " + solutionName);
				for (int j = 0; j > driver.findElements(By.xpath("div[@class='canvas-tools-info-window']"))
						.size(); j++) {
					if (!priceInfoIcon.isDisplayed()) {
						UtilHBM.waitFixTime(500);
					} else {
						break;
					}
				}
				if (solutionName.equalsIgnoreCase(solution)) {
					System.out.println("sol  " + solutionName.equalsIgnoreCase(solution));
					UtilHBM.reportOK("Given solution available and solution is " + solutionName);
					UtilHBM.waitFixTime(1000);
					verifyPriceInStep2(price);
					TemplatesInformationWindow info = PageFactory.initElements(driver,
							TemplatesInformationWindow.class);
					info.verifyPickALayoutStep();
					soluNotFound = false;

					break;
				} else {
					soluNotFound = true;
				}
				if (nextArrow.size() != 0) {
					new Actions(driver).moveToElement(nextArrow.get(0)).click().build().perform();
					UtilHBM.waitFixTime(200);
					UtilHBM.waitExplicitDisplayed(driver,
							driver.findElement(By.xpath("//div[@class='canvas-wrap cursor-rotate']")));
				} else {
					numberOfSolutions.get(i).click();
					UtilHBM.waitFixTime(200);
					UtilHBM.waitExplicitDisplayed(driver,
							driver.findElement(By.xpath("//div[@class='canvas-wrap cursor-rotate']")));
				}

			}
			if (soluNotFound == true) {
				UtilHBM.reportMsg("Given solution not available in list");
			}
		} else {
			UtilHBM.reportWarning("Solutions are not generated for given kitchen");
		}

		return this;
	}

	public PickALayout verifyPriceInStep2(String price) {
//		if (!price.isEmpty()) {
//			UtilHBM.waitExplicitDisplayed(driver, priceInfoIcon);
//			WebElement p = driver
//					.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'" + price + "')]"));
//			WebElement currency = driver
//					.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'£')]"));
//			Verification.displayOfWebElement(p);
//			Verification.displayOfWebElement(currency);
//		}
//		*********************PRE-PROD****************************
		if (!price.isEmpty()) {
//			UtilHBM.waitExplicitClickable(driver, productListIcon);
//			WebElement p = driver
//					.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'" + price + "')]"));
			WebElement currency = driver
					.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'\u20AC')]"));
//			Verification.displayOfWebElement(p);
			Verification.displayOfWebElement(currency);
			String p1 = driver.findElement(By.xpath("//span[@class='standard-price ']")).getText().trim()
					.replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", "");
			System.out.println("p1:" + p1);
			if (p1.equalsIgnoreCase(price)) {
				UtilHBM.reportOK("Step 2 : Expected price: " + price + " SAME as actual price: " + p1);
			} else {
				UtilHBM.reportKO("Step 2 : Expected price " + price + " NOT SAME as actual price: " + p1);
			}
		}
		return PageFactory.initElements(driver, PickALayout.class);
	}
	public PickALayout verifyPricePerMonthInStep2(String pricePerMonth) {

		if (!pricePerMonth.isEmpty()) {
//			String a="or €&nbsp;358,78 per month*";
//			String a1=a.replaceAll("&nbsp;", "");
//			a.substring(a.indexOf("or €&nbsp;")+1, a.indexOf(" per month*"));
//			System.out.println("a: "+a1);
//			System.out.println("a: "+a1.substring(a1.indexOf("or €")+4, a.indexOf(" per month*")));
////			WebElement currency = monthlyPrice.findElement(By.xpath("[contains(text(),'\u20AC')]"));
////			Verification.displayOfWebElement(p);
////			Verification.displayOfWebElement(currency);
			if(monthlyPrice.getText().contains("or")&&monthlyPrice.getText().contains("per month*")&&monthlyPrice.getText().contains("€")) {
				String p1 = monthlyPrice.getText().trim()
						.replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", "");
				System.out.println("p1:" + p1);
				if (p1.equalsIgnoreCase(pricePerMonth)) {
					UtilHBM.reportOK("Step 2 : Expected price: " + pricePerMonth + " SAME as actual price: " + p1);
				} else {
					UtilHBM.reportKO("Step 2 : Expected price " + pricePerMonth + " NOT SAME as actual price: " + p1);
				}
			}
			
		}
		return PageFactory.initElements(driver, PickALayout.class);
	}
	public PickALayout verifyTemplatePriceInStep2(String price,String pricePerMonth) {
		TemplatesInformationWindow info1 = PageFactory.initElements(driver,
				TemplatesInformationWindow.class);
		info1.verifyPickALayoutStep();
		if (!price.isEmpty()) {
		info1.verifyTemplatesPrice(price,pricePerMonth);
		}
return PageFactory.initElements(driver, PickALayout.class);
	}
	public ProductList clickProductList() {
		UtilHBM.waitExplicitDisplayed(driver, productListIcon);
		UtilHBM.waitExplicitClickable(driver, productListIcon);
		new Actions(driver).moveToElement(productListIcon).click().build().perform();
		return PageFactory.initElements(driver, ProductList.class);
	}

	public PickALayout productList(String filePath, String price) {
		clickProductList().productListDetails(filePath, price);
		return this;
	}

	public MakeItYours nextStepDesignYourKitchen(String YesNoBestSolution, String YesNoOverwriteSolution) {
		nextStepButton.click();
		UtilHBM.waitFixTime(1000);
//		designYourKitchenButton.click();
//		UtilHBM.waitExplicitDisplayed(driver, designYourKitchenButton);
		if (bestSolutionPopUp.size() > 0 && bestSolutionPopUp.get(0).isDisplayed()) {
			System.out.println("size " + bestSolutionPopUp.size());
			String expectedTitle = "Choose the best solution";
			String expectedInfo = "Make sure to look at all the kitchen layouts that you can choose from to find the best solution.";
			String expectedQuestion = "Do you want to see these solutions?";
			Verification.VerifyEquals("Best solution title not correct", bestSolutionTitle.getText(), expectedTitle);
			Verification.VerifyEquals("Best solution  info not correct", bestSolutionInfo.getText(), expectedInfo);
			Verification.VerifyEquals("Best solution  question not correct", bestSolutionQuestion.getText(),
					expectedQuestion);
			Verification.displayOfWebElement(yesButton);
			if (YesNoBestSolution.equalsIgnoreCase("yes")) {
				yesButton.click();
			} else {
				new Actions(driver).moveToElement(noButton).click().build().perform();
				UtilHBM.waitFixTime(2500);
			}
		}
		if (overwriteSolutionPopUp.size() > 0 && overwriteSolutionPopUp.get(0).isDisplayed()) {
			String expectedTitle = "Continue with this kitchen";
			String expectedInfo = "The layout you selected will replace the previous kitchen design you made.";
			String expectedQuestion = "Do you want to overwrite your previous design?";
			Verification.VerifyEquals("Overwrite solution title not correct", overwriteSolutionTitle.getText(),
					expectedTitle);
			Verification.VerifyEquals("Overwrite solution info not correct", overwriteSolutionInfo.getText(),
					expectedInfo);
			Verification.VerifyEquals("Overwrite solution question not correct", overwriteSolutionQuestion.getText(),
					expectedQuestion);
			Verification.displayOfWebElement(yesButton);
			if (YesNoOverwriteSolution.equalsIgnoreCase("yes")) {
				yesButton.click();
			} else {
				new Actions(driver).moveToElement(noButton).click().build().perform();
				UtilHBM.waitFixTime(2500);
			}
		}
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	/**
	 * @param option - possible values(ignores case) ["Start from scratch", "Go back to my design", "Update my needs"(default)]
	 * @param type - class object for the page class to be navigated to after this method is executed . For ex. "Update my needs" lands user on the SelectMapping page so basically use the following
	 *             for option values  :
	 *               Start from scratch : MakeItYours.class
	 *               Go back to my design : FloorPlan.class
	 *               Update my needs :  SelectMapping.class
	 * @return Page object of the page user will be navigated to based on the option/type entered
	 */
	public <T> T lookingForNeedMapping(String option, Class<T> type) {
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, priceInfoIcon);
		UtilHBM.waitExplicitClickable(driver, lookingForNeedMappingLink);
		new Actions(driver).moveToElement(lookingForNeedMappingLink).click().build().perform();
		driver.findElement(By.cssSelector("button[data-ui-action='popin-close']")).click();
		UtilHBM.waitExplicitClickable(driver, lookingForNeedMappingLink);
		new Actions(driver).moveToElement(lookingForNeedMappingLink).click().build().perform();
		UtilHBM.waitExplicitDisplayed(driver, howCanWeHelpTitle);
		String expectedTitle = "How can we help you?";
		String expectedInfo = "You can update your preferences to see more solutions to use as a basis or directly design your own kitchen.";
		Verification.VerifyEquals("How can we help you? title not correct", howCanWeHelpTitle.getText(), expectedTitle);
		Verification.VerifyEquals("How can we help you? info not correct", howCanWeHelpInfo.getText(), expectedInfo);
//		Verification.displayOfWebElement(startFromScratchButton);		
		Verification.displayOfWebElement(updateMyNeedsButton);
		if (option.equalsIgnoreCase("Start from scratch")) {
			Verification.displayNAttributeCheckOfElement(startFromScratchButton, "Start from scratch", "text", "Start from scratch");
			startFromScratch();
		} else if (option.equalsIgnoreCase("Go back to my design")) {
			Verification.displayNAttributeCheckOfElement(startFromScratchButton, "Go Back to My Design", "text", "Go back to my design");
			MakeItYours design = PageFactory.initElements(driver, MakeItYours.class);
			design.priceInfoDetails("","");
		} else {
			updateMyNeeds();
		}
		return PageFactory.initElements(driver, type);
	}

	public MakeItYours startFromScratch() {
		startFromScratchButton.click();
		if (projectTitle.isDisplayed())
			UtilHBM.reportOK("User redirected to step 3 using start from scratch");
		else
			UtilHBM.reportKO("User is not redirected to step 3 using start from scratch");
		return PageFactory.initElements(driver, MakeItYours.class);

	}

	public SelectMapping updateMyNeeds() {
		UtilHBM.turnOffImplicitWaits(driver);
		if(driver.findElements(By.cssSelector("article[class^='mod-popin-no-solution'][class*='mod-open']")).size()>0){
			UtilHBM.waitExplicitDisplayed(driver, updateMyNeedsLink);
			new Actions(driver).moveToElement(updateMyNeedsLink).click().build().perform();
		}else{
			UtilHBM.waitExplicitDisplayed(driver, updateMyNeedsButton);
			new Actions(driver).moveToElement(updateMyNeedsButton).click().build().perform();
		}
		UtilHBM.turnOnImplicitWaits(driver);

		driver.switchTo().parentFrame();
		UtilHBM.waitExplicitDisplayed(driver, updateNeedsTab);
		if (updateNeedsTab.isDisplayed()) {
			UtilHBM.reportOK("select mapping options");
//			StylePage mapping = PageFactory.initElements(driver, StylePage.class);
//			mapping.updateNeedMappings(style, layout, cooking, refrigeration);
		} else
			UtilHBM.reportKO("No mapping options");
		return PageFactory.initElements(driver, SelectMapping.class);

	}

	public FloorPlan editMyFloorplan() {
		String expectedTitle = "We have not found any solution for your kitchen";
		String expectedInfo = "Make sure your kitchen has enough available space on at least one wall.";
		UtilHBM.waitExplicitDisplayed(driver, solutionNotFoundPopUpImage);
		Verification.VerifyEquals("Solution not found title not correct", solutionNotFoundPopUpTitle.getText(),
				expectedTitle);
		Verification.VerifyEquals("Solution not found info not correct", solutionNotFoundPopUpInfo.getText(),
				expectedInfo);
		Verification.displayNAttributeCheckOfElement(startFromScratchButton, "Design from scratch", "text", "Design from scratch");
		Verification.displayOfWebElement(
				driver.findElement(By.xpath("//footer/div/button[@data-ui-action='link-action']")));
		Verification.displayOfWebElement(editMyFloorplanButton);
		editMyFloorplanButton.click();
		String step = driver.findElement(By.cssSelector(".current")).getText();
		if (step.equalsIgnoreCase("Floorplan")) {
			UtilHBM.reportOK("switched to floorplan step");

		} else
			UtilHBM.reportKO("Not switched to floorplan step");
		return PageFactory.initElements(driver, FloorPlan.class);

	}

	public SaveProject clickSave(SignUpData signUpData) {
		UtilHBM.waitExplicitDisplayed(driver, saveIcon);
		UtilHBM.waitExplicitClickable(driver, saveIcon);
		saveIcon.click();
		
		login(signUpData);
		return PageFactory.initElements(driver, SaveProject.class);

	}

	public PickALayout login(SignUpData signUpData) {
		driver.switchTo().parentFrame();
		if (loginWindow.size() > 0) {
			KitchenLogin login = PageFactory.initElements(driver, KitchenLogin.class);
			login.login(signUpData);

		} else {
			UtilHBM.reportInfo("User already logged in");
		}
		driver.switchTo().frame(driver.findElement(By.cssSelector("#iframeContainer>iframe")));
		return PageFactory.initElements(driver, PickALayout.class);
	}

	public PickALayout saveProjectInStep2(SignUpData signUpData, String name, String desc) {
		clickSave(signUpData).saveProject(name, desc);
		return PageFactory.initElements(driver, PickALayout.class);
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

	public PickALayout zoomIn(int zoomIncount) {
		UtilHBM.waitFixTime(1000);
		for (int i = 1; i <= zoomIncount; i++) {
			zoomIn.click();
			UtilHBM.waitFixTime(500);

		}
		return this;
	}

	public PickALayout zoomOut(int zoomOutcount) {
		for (int i = 1; i <= zoomOutcount; i++) {
			zoomOut.click();
			UtilHBM.waitFixTime(500);

		}
		return this;
	}
	
	public PickALayout showMore(){
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		showMore.click();	
		List<WebElement>elements = driver.findElements(By.cssSelector("button[data-more='Show more']"));
			if(elements.size()>0){
				
				UtilHBM.reportOK("Appliances displayed");						 
					
			}else {
				UtilHBM.reportKO("Appliances not displayed after click on Show more in step 2");
			}
			 return PageFactory.initElements(driver,PickALayout.class);
		}
	
	public PickALayout showLess(){
		showLess.click();	
		UtilHBM.waitExplicitDisplayed(driver, showMore);
		UtilHBM.turnOffImplicitWaits(driver);
		List<WebElement>elements = driver.findElements(By.cssSelector("#more-content[aria-hidden='false'] button[data-ui-action='show-appliance']"));
			if(elements.size()==0){				
				UtilHBM.reportOK("Appliances list hidden after showless");	
			}else {
				UtilHBM.reportKO("Appliances not hidden after click on Show less in step 2");
			}
			UtilHBM.turnOnImplicitWaits(driver);
			 return PageFactory.initElements(driver,PickALayout.class);
		}
	
	public PickALayout showAppliances(String appliance){		
			WebElement showAppliance = driver.findElement(By.xpath("//li[@class='card-show-item']/p[.='"+appliance+"']/following-sibling::button"));
			showAppliance.click();
			UtilHBM.waitFixTime(1000);
			 return PageFactory.initElements(driver,PickALayout.class);
		}
//	<********************************MOBILE METHODS********************************>
	public PickALayout findSolutionsMobile(String solution) {
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, solutionLoaded);
		UtilHBM.waitExplicitDisplayed(driver, templateTitle);
		UtilHBM.waitFixTime(2000);
		String solutionName1 = templateTitle.getText();
		boolean isTemplateAvailable=false;
		for(WebElement a:numberOfSolutions) {
				UtilHBM.turnOnImplicitWaits(driver);			
					UtilHBM.waitExplicitDisplayed(driver, solutionLoaded);
					UtilHBM.waitExplicitDisplayed(driver, "//div[@class='canvas-tools-info-window']/div/p[@class='title']");
				int x=1;
				if(numberOfSolutions.size()>0 &&numberOfSolutions.get(0).isDisplayed()){	
					if(!(solutionName1.startsWith(solution))) {
					Actions action=new Actions(driver);
					action.moveToElement(numberOfSolutions.get(x)).click().build().perform();
					UtilHBM.waitFixTime(3000);
					UtilHBM.waitExplicitDisplayed(driver, solutionLoading);
					x++;	
					}
				}
				isTemplateAvailable=true;
				UtilHBM.turnOnImplicitWaits(driver);			
					UtilHBM.waitExplicitDisplayed(driver, solutionLoaded);
					UtilHBM.waitExplicitDisplayed(driver, "//div[@class='canvas-tools-info-window']/div/p[@class='title']");
					solutionName1 = driver.findElement(By.xpath("//div[@class='canvas-tools-info-window']/div/p[@class='title']")).getText();
				break;
			
			}
		if(!solutionName1.startsWith(solution)){
			UtilHBM.reportKO("Expected layout template "+solution+" not found");
		}

		return this;
	}
	public <T> T lookingForNeedMappingMobile(String option, Class<T> type) {
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, lookingForNeedMappingLink);
		UtilHBM.waitExplicitClickable(driver, lookingForNeedMappingLink);
		lookingForNeedMappingLink.click();
		driver.findElement(By.cssSelector("button[data-ui-action='popin-close']")).click();
		UtilHBM.waitExplicitClickable(driver, lookingForNeedMappingLink);
		new Actions(driver).moveToElement(lookingForNeedMappingLink).click().build().perform();
		UtilHBM.waitExplicitDisplayed(driver, howCanWeHelpTitle);
		String expectedTitle = "How can we help you?";
		String expectedInfo = "You can update your preferences to see more solutions to use as a basis or directly design your own kitchen.";
		Verification.VerifyEquals("How can we help you? title not correct", howCanWeHelpTitle.getText(), expectedTitle);
		Verification.VerifyEquals("How can we help you? info not correct", howCanWeHelpInfo.getText(), expectedInfo);
//		Verification.displayOfWebElement(startFromScratchButton);		
		Verification.displayOfWebElement(updateMyNeedsButton);
		if (option.equalsIgnoreCase("Start from scratch")) {
			Verification.displayNAttributeCheckOfElement(startFromScratchButton, "Start from scratch", "text", "Start from scratch");
			startFromScratch();
		} else if (option.equalsIgnoreCase("Go back to my design")) {
			Verification.displayNAttributeCheckOfElement(startFromScratchButton, "Go Back to My Design", "text", "Go back to my design");
			MakeItYours design = PageFactory.initElements(driver, MakeItYours.class);
			design.priceInfoDetails("","");
		} else {
			updateMyNeeds();
		}
		return PageFactory.initElements(driver, type);
	}
	public MakeItYours nextStepDesignYourKitchenMobile(String YesNoBestSolution, String YesNoOverwriteSolution) {
		nextStepButtonMobile.click();
		UtilHBM.waitFixTime(1000);
//		designYourKitchenButton.click();
//		UtilHBM.waitExplicitDisplayed(driver, designYourKitchenButton);
		if (bestSolutionPopUp.size() > 0 && bestSolutionPopUp.get(0).isDisplayed()) {
			System.out.println("size " + bestSolutionPopUp.size());
			String expectedTitle = "Choose the best solution";
			String expectedInfo = "Make sure to look at all the kitchen layouts that you can choose from to find the best solution.";
			String expectedQuestion = "Do you want to see these solutions?";
			Verification.VerifyEquals("Best solution title not correct", bestSolutionTitle.getText(), expectedTitle);
			Verification.VerifyEquals("Best solution  info not correct", bestSolutionInfo.getText(), expectedInfo);
			Verification.VerifyEquals("Best solution  question not correct", bestSolutionQuestion.getText(),
					expectedQuestion);
			Verification.displayOfWebElement(yesButton);
			if (YesNoBestSolution.equalsIgnoreCase("yes")) {
				yesButton.click();
			} else {
				new Actions(driver).moveToElement(noButton).click().build().perform();
				UtilHBM.waitFixTime(2500);
			}
		}
		if (overwriteSolutionPopUp.size() > 0 && overwriteSolutionPopUp.get(0).isDisplayed()) {
			String expectedTitle = "Continue with this kitchen";
			String expectedInfo = "The layout you selected will replace the previous kitchen design you made.";
			String expectedQuestion = "Do you want to overwrite your previous design?";
			Verification.VerifyEquals("Overwrite solution title not correct", overwriteSolutionTitle.getText(),
					expectedTitle);
			Verification.VerifyEquals("Overwrite solution info not correct", overwriteSolutionInfo.getText(),
					expectedInfo);
			Verification.VerifyEquals("Overwrite solution question not correct", overwriteSolutionQuestion.getText(),
					expectedQuestion);
			Verification.displayOfWebElement(yesButton);
			if (YesNoOverwriteSolution.equalsIgnoreCase("yes")) {
				yesButton.click();
			} else {
				new Actions(driver).moveToElement(noButton).click().build().perform();
				UtilHBM.waitFixTime(2500);
			}
		}
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public PickALayout skipLayoutNo() {
		UtilHBM.waitExplicitDisplayed(driver, noBtnSkipSolutionsMsg);
		UtilHBM.waitExplicitClickable(driver, noBtnSkipSolutionsMsg);
		noBtnSkipSolutionsMsg.click();
		return this;
	}

	/**
	 * @param option - possible values(ignores case) ["Start from scratch", "Go back to my design", "Update my needs"(default)]
	 * @param type - class object for the page class to be navigated to after this method is executed . For ex. "Update my needs" lands user on the SelectMapping page so basically use the following
	 *             for option values  :
	 *               Design from scratch : MakeItYours.class
	 *               Edit my floorplan : FloorPlan.class
	 *               Update my needs :  SelectMapping.class
	 * @return Page object of the page user will be navigated to based on the option/type entered
	 */
	public <T> T noSolutionsFound(String option, Class<T> type) {
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, noSolutionsFoundPopup);

		String expectedTitle = "We have not found any solution for your kitchen";
		String expectedInfo = "Make sure your kitchen has enough available space on at least one wall.";
		Verification.VerifyEquals("No solutions found popup  title not correct", noSolutionsFoundPopup.findElement(By.cssSelector("h1")).getText().trim(), expectedTitle);
		Verification.VerifyEquals("No solutions found popup info not correct", noSolutionsFoundPopup.findElement(By.cssSelector("div.text p")).getText(), expectedInfo);
		if (option.equalsIgnoreCase("Design from scratch")) {
			Verification.displayNAttributeCheckOfElement(startFromScratchButton, "Start from scratch", "text", "Start from scratch");
			startFromScratch();
		} else if (option.equalsIgnoreCase("Edit my floorplan")) {
			Verification.displayNAttributeCheckOfElement(editMyFloorplanButton, "Edit my floorplan", "text", "Edit my floorplan");
			editMyFloorplan();
		} else {
			updateMyNeeds();
		}
		return PageFactory.initElements(driver, type);
	}

}