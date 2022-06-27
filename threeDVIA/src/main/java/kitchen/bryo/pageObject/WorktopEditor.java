package kitchen.bryo.pageObject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorktopEditor {
	WebDriver driver;

	public WorktopEditor(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "button[data-ui-action='changeGrainDirection']")
	private WebElement changeGrainDirection;

	@FindBy(xpath = "//section[@class='mod-overlay mod-open']/div/ul/li/span/button[@data-ui-action='rotateFiberNext']")
	private WebElement changeGrainDirectionNext;

	@FindBy(xpath = "//section[@class='mod-overlay mod-open']/div/ul/li/span/button[@data-ui-action='rotateFiberPrevious']")
	private WebElement changeGrainDirectionPrevious;

	@FindBy(css = "button[data-ui-action='addCutOut']")
	private WebElement addCutOut;
	
	@FindBy(css="button[data-ui-action='deleteWorktop']")
	private WebElement deleteWorktop;

	@FindBy(css = "[id*='cutout-rectang'][id$='-val-1']")
	private WebElement rectangleValue1;

	@FindBy(css = "[id*='cutout-rectang'][id$='-val-2']")
	private WebElement rectangleValue2;

	@FindBy(css = "footer>button[class='cta-secondary-icon']")
	private WebElement deleteCuts;

	@FindBy(css = ".mod-overlay-container.mod-open")
	private List<WebElement> balloon;

	@FindBy(css = ".mod-overlay-container.mod-open section.mod-overlay:nth-of-type(1) h3.title")
	private WebElement balloonHeader;

	@FindBy(id = "cornercut-simple-val-1")
	private WebElement cornerCutSimpleValue1;

	@FindBy(id = "cornercut-simple-val-2")
	private WebElement cornerCutSimpleValue2;

	@FindBy(id = "cornercut-double-val-1")
	private WebElement cornerCutDoubleValue1;

	@FindBy(id = "cornercut-double-val-2")
	private WebElement cornerCutDoubleValue2;

	@FindBy(css = "#cornercut-2>p[class='more-options']>label>span[class='state']")
	private WebElement cornerCutDoubleMoreOption;

	@FindBy(id = "cornercut-double-val-3")
	private WebElement cornerCutDoubleValue3;

	@FindBy(id = "cornercut-rectangle-val-4")
	private WebElement cornerCutDoubleValue4;

	@FindBy(id = "cornercut-invert-val-1")
	private WebElement cornerCutInvertValue1;

	@FindBy(id = "cornercut-rounded-val-1")
	private WebElement cornerCutRoundedValue1;

	@FindBy(css = "button[data-i18n='common.create']")
	private WebElement createButton;

	@FindBy(css = "button[data-ui-action='addJoint']")
	private WebElement addJointButton;

	@FindBy(css = "button[data-ui-action='removeJoint']")
	private WebElement removeJointButton;

	@FindBy(css = "button[data-ui-action='addEdgeCut']")
	private WebElement addEdgeCutButton;

	@FindBy(id = "edgecut-triple-val-1")
	private WebElement edgeCutTripleValue1;

	@FindBy(id = "edgecut-triple-val-2")
	private WebElement edgeCutTripleValue2;

	@FindBy(id = "edgecut-triple-val-3")
	private WebElement edgeCutTripleValue3;

	@FindBy(xpath = "//fieldset[@id='edgecut-1']/p[@class='more-options']/label/span[@class='state']")
	private WebElement edgeCutMoreOptions;

	@FindBy(id = "edgecut-triple-val-4")
	private WebElement edgeCutTripleValue4;

	@FindBy(id = "edgecut-rectangle-val-5")
	private WebElement edgeCutTripleValue5;

	@FindBy(id = "edgecut-rounded-val-1")
	private WebElement edgeCutRoundedValue1;

	@FindBy(id = "edgecut-rounded-val-2")
	private WebElement edgeCutRoundedValue2;

	@FindBy(css = "button[data-ui-action='splitEdge']")
	private WebElement splitEdgeButton;

	@FindBy(css = "button[data-ui-action='command-validate']")
	private WebElement validateWorktopEditor;

	@FindBy(css = "button[data-ui-action='command-cancel']")
	private WebElement cancelWorktopEditor;

	@FindBy(css = "input[class^='measure-input']")
	private List<WebElement> measureInput;

	@FindBy(css = "input[class='measure-input']")
	private List<WebElement> measureInputCutOut;

	@FindBy(css = "input[placeholder='Measure2D']")
	private List<WebElement> measure2D;

	@FindBy(xpath = "//div/input[@class='measure-edit-input']")
	private WebElement measureInputEdit;

	@FindBy(xpath = "//div/button[@data-apply-type='above']")
	private WebElement applyAbove;

	@FindBy(xpath = "//div/button[@data-apply-type='below']")
	private WebElement applyBelow;

	@FindBy(xpath = "//div/button[@data-apply-type='left']")
	private WebElement applyLeft;

	@FindBy(xpath = "//div/button[@data-apply-type='right']")
	private WebElement applyRight;

	@FindBy(css = "button[data-ui-action='addWaterFall']")
	private WebElement addWaterfallButton;

	@FindBy(css = "button[data-ui-action='editWaterFall']")
	private WebElement editWaterfallButton;

	@FindBy(css = "button[data-ui-action='back-worktop-editor']")
	private WebElement backWorktopEditorButton;

	@FindBy(xpath = "//div[@class='mod-overlay-container mod-open']/div/section/div/ul/li/span/button[@data-ui-action='removeWaterFall']")
	private WebElement removeWaterFallButton;

	@FindBy(css = "button[data-ui-action='addWaterFallEdge']")
	private WebElement addWaterFallEdge;

	@FindBy(css = "select[data-ui-action='waterFallLeftEdgeProduct']")
	private WebElement waterFallLeftEdgeProduct;

	@FindBy(css = "select[data-ui-action='waterFallRightEdgeProduct']")
	private WebElement waterFallRightEdgeProduct;

	@FindBy(css = "button[data-ui-action='changeEdgeProduct']")
	private WebElement changeEdgeProductButton;

	@FindBy(css = "button[data-ui-action='changeWaterFallType']")
	private WebElement changeWaterFallTypeButton;
	
	@FindBy(css = "select[data-ui-action='waterFallType']")
	private WebElement chooseWaterFallType;
	
	@FindBy(css = "button[data-ui-action='addEdgeProduct']")
	private WebElement addEdgeProductButton;

	@FindBy(css = "select[data-ui-action='edgeProduct']")
	private WebElement edgeProduct;

	@FindBy(css = ".bt-back .icon-action-arrow")
	private WebElement backBtnEdgePrd;

	@FindBy(css = "span[name='edgeProduct']>span")
	private WebElement selectedEdgeProduct;

	@FindBy(css = "span[name='waterFallleftEdgeProduct']>span")
	private WebElement selectedLeftWaterFallEdgeProduct;

	@FindBy(css = "span[name='waterFallRightEdgeProduct']>span")
	private WebElement selectedRightWaterFallEdgeProduct;

	@FindBy(xpath = "//span[@class='icon-action-info']")
	private WebElement worktopEditorPrice;

	@FindBy(xpath = "//article[@class='mod-popin-alert-price mod-open']/div/header/div/div/h3")
	private WebElement worktopPriceTitle;

	@FindBy(xpath = "//article[@class='mod-popin-alert-price mod-open']/div/header/div/div/b")
	private WebElement worktopPriceInfo;

	@FindBy(css = ".mod-popin-alert-price.mod-open>div>div>div>div>p")
	private WebElement worktopPriceContent;

	@FindBy(css = ".mod-popin-worktop-editor-small.mod-open>div>footer>div>button[data-ui-action='link-action']")
	private WebElement worktopLearnMoreLink;

	@FindBy(css = ".mod-popin-alert-price.mod-open>div>div>div>div>button")
	private WebElement worktopEditorLearnMoreLink;

	@FindBy(css = ".mod-popin-alert-price.mod-open>div>header>div>div>button[data-ui-action='popin-close']")
	private WebElement closeWorktopPricePopUp;

	@FindBy(css = ".mod-popin-worktop-editor-small.mod-open>div")
	private WebElement editWorktopPopUp;

	@FindBy(css = ".inner-content>h1")
	private WebElement editWorktopTitle;

	@FindBy(css = ".inner-content>.text>div>p")
	private WebElement editWorktopMessage;

	@FindBy(css = ".popin-footer .cta-primary-alt-xl")
	private WebElement editWorktopYes;

	@FindBy(id = "bmSVG")
	private WebElement container3D;

	@FindBy(xpath = "//li/article/h3/b")
	private List<WebElement> businessRulesList;

	@FindBy(id = "show-help")
	private WebElement helpButton;

	@FindBy(id = "refresh_check_without_change")
	private WebElement refresh;

	@FindBy(css = ".mod-overlay-container.mod-open>div>.mod-overlay>header>h3")
	private WebElement removeJointOverlay;

	@FindBy(id = "zoom-in")
	private WebElement zoomIn;

	@FindBy(id = "zoom-out")
	private WebElement zoomOut;

	@FindBy(css = "p>label>span[class='state']>svg")
	private WebElement cutOutMoreOptions;

	@FindBy(css = "input[id*='cutout-rectang'][id$='-val-3']")
	private WebElement cutOutRadius;

	@FindBy(xpath = "//input[@id='cutout-cutout-circle-val-1']")
	private WebElement cutOutDiameter;

	@FindBy(xpath = "//form/ul/li/button[@data-ui-action='undo']/span[@class='icon-action-undo']")
	private WebElement undoButton;

	@FindBy(xpath = "//form/ul/li/button[@data-ui-action='redo']/span[@class='icon-action-redo']")
	private WebElement redoButton;

	@FindBy(xpath = "//div/div/div[@id='sketcher-mod-view-3d']")
	private WebElement worktopEditorContainer;

	@FindBy(id = "cornercut-double-val-1")
	private WebElement cornerCutA;

	@FindBy(id = "cornercut-double-val-2")
	private WebElement cornerCutB;

	@FindBy(css = "fieldset[id='cornercut-2']>p[class='more-options']>label>span[class='state']")
	private WebElement nonStraightCornerCut;

	@FindBy(id = "cornercut-double-val-3")
	private WebElement cornerCutX;

	@FindBy(id = "cornercut-rectangle-val-4")
	private WebElement cornerCutY;

	@FindBy(css = "button[data-ui-action='addCut']")
	private WebElement addCornerCut;

	@FindBy(css = ".SketcherMeasure.Tag3D")
	private List<WebElement> cornercutTags;

	@FindBy(id = "cornercut-invert-val-1")
	private WebElement cornerCutRadius;

	@FindBy(css = "button[data-ui-action='addEdgeProduct']")
	private WebElement addCornerCutEdge;

	@FindBy(css = "select[data-ui-action='edgeProduct']")
	private WebElement cornerCutEdgeProduct;

	@FindBy(css = "button[data-ui-action='changeEdgeProduct']")
	private WebElement changeCornerCutEdge;

	@FindBy(xpath = "//button[@data-ui-action='priceInfo']")
	private WebElement priceInfoIcon;

	@FindBy(xpath = "//li[@class='checkbox-action']/span/label/span[@class='state']")
	private WebElement frontOption;

	@FindBy(xpath = "//span[@class='illustration']/img[starts-with(@src,'data:image/svg+xml;base64')]")
	private WebElement edgeSymbols;

	@FindBy(css = "div[class='mod-overlay-container-legend mod-open']>div>section[data-ui-selector='edge-finish-section']>header>h3")
	private WebElement edgeLegendTitle;

	@FindBy(xpath = "//section[@data-ui-selector='edge-finish-section']/header/button[@data-ui-selector='toggler-btn']")
	private WebElement edgeLegendToggle;

	@FindBy(css = "div[class='mod-overlay-container-legend mod-open']>div>section[data-ui-selector='worktop-types-section']>header>h3")
	private WebElement worktopTypeTitle;

	@FindBy(xpath = "//section[@data-ui-selector='worktop-types-section']/header/button[@data-ui-selector='toggler-btn']")
	private WebElement worktopTypeToggle;

	@FindBy(xpath = "//span[@class='illustration']/img[starts-with(@src,'data:image/svg+xml;base64, PHN2ZyBpZD0iTGF5ZXJfMSIgZGF0YS1uYW1lPSJMYXllciAxIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCA1OTUuMjggNTk1LjI4Ij48ZGVmcz48c3R5bGU+LmNscy0xe2ZpbGw6bm9uZTtzdHJva2U6IzAwMDtzdHJva2UtbGluZWNhcDpyb3VuZDtzdHJva2UtbGluZWpvaW46cm91bmQ7c3Ryb2tlLXdpZHRoOjEwcHg7fTwvc3R5bGU+PC9kZWZzPjx0aXRsZT5TeW1ib2xzPC90aXRsZT48cmVjdCBjbGFzcz0iY2xzLTEiIHg9IjE0LjE4IiB5PSIxMy41NCIgd2lkdGg9IjU2Ni45MyIgaGVpZ2h0PSI1NjYuOTMiLz48cmVjdCBjbGFzcz0iY2xzLTEiIHg9Ijg1LjA0IiB5PSI4NC40IiB3aWR0aD0iNDI1LjIiIGhlaWdodD0iNDI1LjIiLz48L3N2Zz4=')]")
	private List<WebElement> aluminiumEdge;

	@FindBy(xpath = "//span[@class='illustration']/img[starts-with(@src,'data:image/svg+xml;base64, PHN2ZyBpZD0iTGF5ZXJfMSIgZGF0YS1uYW1lPSJMYXllciAxIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCA1OTUuMjggNTk1LjI4Ij48ZGVmcz48c3R5bGU+LmNscy0xe2ZpbGw6bm9uZTtzdHJva2U6IzAwMDtzdHJva2UtbGluZWNhcDpyb3VuZDtzdHJva2UtbGluZWpvaW46cm91bmQ7c3Ryb2tlLXdpZHRoOjEwcHg7fTwvc3R5bGU+PC9kZWZzPjx0aXRsZT5TeW1ib2xzPC90aXRsZT48bGluZSBjbGFzcz0iY2xzLTEiIHgxPSIxNC4xOCIgeTE9IjEzLjU0IiB4Mj0iNTgxLjEiIHkyPSI1ODAuNDciLz48bGluZSBjbGFzcz0iY2xzLTEiIHgxPSI1ODEuMSIgeTE9IjEzLjU0IiB4Mj0iNTgxLjEiIHkyPSI1ODAuNDciLz48bGluZSBjbGFzcz0iY2xzLTEiIHgxPSIxNC4xOCIgeTE9IjU4MC40NyIgeDI9IjE0LjE4IiB5Mj0iMTMuNTQiLz48L3N2Zz4=')]")
	private List<WebElement> noEdge;

	@FindBy(xpath = "//span[@class='illustration']/img[starts-with(@src,'data:image/svg+xml;base64, PHN2ZyBpZD0iTGF5ZXJfMSIgZGF0YS1uYW1lPSJMYXllciAxIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCA1OTUuMjggNTk1LjI4Ij48ZGVmcz48c3R5bGU+LmNscy0xe2ZpbGw6bm9uZTtzdHJva2U6IzAwMDtzdHJva2UtbGluZWNhcDpyb3VuZDtzdHJva2UtbGluZWpvaW46cm91bmQ7c3Ryb2tlLXdpZHRoOjEwcHg7fTwvc3R5bGU+PC9kZWZzPjx0aXRsZT5TeW1ib2xzPC90aXRsZT48bGluZSBjbGFzcz0iY2xzLTEiIHgxPSIxNC4xOCIgeTE9IjEzLjU0IiB4Mj0iNTgxLjEiIHkyPSI1ODAuNDciLz48bGluZSBjbGFzcz0iY2xzLTEiIHgxPSI1ODEuMSIgeTE9IjEzLjU0IiB4Mj0iMTQuMTgiIHkyPSI1ODAuNDciLz48L3N2Zz4=')]")
	private List<WebElement> badEdge;

	@FindBy(xpath = "//figure[@id='edge-finish-content']/ul/li/span[contains(text(),'Aluminium')]")
	private WebElement aluminiumEdgeLegend;

	@FindBy(xpath = "//figure[@id='edge-finish-content']/ul/li/span[contains(text(),'No edge')]")
	private WebElement noEdgeLegend;

	@FindBy(xpath = "//figure[@id='edge-finish-content']/ul/li/span[contains(text(),'Bad edge')]")
	private WebElement badEdgeLegend;

	@FindBy(css = "figure[data-ui-selector='worktop-types-legend-list']>ul>li>span[id='WorktopTypes-illustration-0']>svg[class='icon-worktop-custom']")
	private WebElement customPrecutSVG;

	@FindBy(xpath = "//button[@data-ui-action='worktop-types-info']")
	private WebElement worktopTypeInfo;

	@FindBy(xpath = "//li/span/span[contains(text(),'Display edge symbols')]/../following-sibling::span/label/input[@name='front-displayer']")
	private WebElement displayEdgeSymbolsToggle;

	@FindBy(css = "button[data-ui-action='splitWorktop']")
	private WebElement splitWorktopButton;

	@FindBy(css = "button[data-ui-action='mergeWorktops']")
	private WebElement mergeWorktopsButton;

	@FindBy(xpath = "//h1[text()='Wall edge strip modification']/../following-sibling::footer//span")
	private WebElement wallEdgeStripModificationOKBtn;

	@FindBy(css = "b[class='error']")
	private WebElement errorMsg;
	
	public WorktopEditor moveWorktop(int x, int y, int x1, int y1) {
		UtilHBM.waitFixTime(2000);
		Actions action = new Actions(driver);
//		action.moveToElement(container3D, x, y - 10).clickAndHold().pause(500).release().pause(500).build().perform();
		action.moveToElement(worktopEditorContainer, x, y).clickAndHold().pause(1000)
				.dragAndDropBy(worktopEditorContainer, x1, y1).pause(1000).release().build().perform();
		clickBlank();
		return PageFactory.initElements(driver, WorktopEditor.class);
	}

	public WorktopEditor verifyWorktopEditorDetails() {
		editWorktopYes();

		return PageFactory.initElements(driver, WorktopEditor.class);
	}

	public WorktopEditor verifyPriceInWorktop(String price) {
//		if (!price.isEmpty()) {
//			WebElement p = driver
//					.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'" + price + "')]"));
//			WebElement currency = driver
//					.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'£')]"));
//			Verification.displayOfWebElement(p);
//			Verification.displayOfWebElement(currency);
//		}
//		*********************PRE-PROD****************************
		UtilHBM.waitFixTime(2000);
		if (price.equalsIgnoreCase("Price is not available")) {
			WebElement displayedText = driver
					.findElement(By.cssSelector("span.standard-price[data-ui='regular-price']"));
			if (displayedText.getText().equals("Price is not available"))
				UtilHBM.reportOK("Expected text displayed : " + displayedText.getText());
			else
				UtilHBM.reportKO("Expected text : " + price + " , Actual Text : " + displayedText.getText());

		} else if (!price.isEmpty()) {
//			WebElement p = driver
//					.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'" + price + "')]"));
			WebElement currency = driver
					.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'\u20AC')]"));
//			Verification.displayOfWebElement(p);
			Verification.displayOfWebElement(currency);
			String p1 = driver.findElement(By.xpath("//span[@class='standard-price ']")).getText().trim()
					.replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "");
			System.out.println("p1:" + p1);
			if (p1.equalsIgnoreCase(price)) {
				UtilHBM.reportOK("Worktop Editor : Expected price: " + price + " SAME as actual price: " + p1);
			} else {
				UtilHBM.reportKO("Worktop Editor : Expected price: " + price + " NOT SAME as actual price: " + p1);
			}
			UtilHBM.waitExplicitDisplayed(driver, priceInfoIcon);
			UtilHBM.waitExplicitClickable(driver, priceInfoIcon);
			UtilHBM.waitFixTime(1500);
			new Actions(driver).moveToElement(priceInfoIcon).build().perform();
			priceInfoIcon.click();
			Price p = PageFactory.initElements(driver, Price.class);
			p.priceInfoInEditors();

		}
		return this;
	}

	public WorktopEditor verifyMemberPriceInWorktop(String price) {
		if (!price.isEmpty()) {
			UtilHBM.waitFixTime(1000);
			WebElement currency = driver
					.findElement(By.xpath("//span[@class='membership-price'][contains(text(),'\u20AC')]"));
			Verification.displayOfWebElement(currency);
			String p1 = driver.findElement(By.xpath("//span[@class='membership-price']")).getText().trim()
					.replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "");
			System.out.println("p1:" + p1);
			if (p1.equalsIgnoreCase(price)) {
				UtilHBM.reportOK("Worktop Editor : Expected price: " + price + " SAME as actual price: " + p1);
			} else {
				UtilHBM.reportKO("Worktop Editor : Expected price: " + price + " NOT SAME as actual price: " + p1);
			}
			UtilHBM.waitExplicitDisplayed(driver, priceInfoIcon);
			UtilHBM.waitExplicitClickable(driver, priceInfoIcon);
			new Actions(driver).moveToElement(priceInfoIcon).build().perform();
			priceInfoIcon.click();
			Price p = PageFactory.initElements(driver, Price.class);
			p.priceInfoInEditors();

		}
		return this;
	}

	public MakeItYours checkWortopLinear() {
		List<WebElement> linear = driver
				.findElements(By.cssSelector("#canvas-wrap-1>#bmSVG>g>g>g[id*='gSju']>path[class='st1']"));
		System.out.println("Linear " + linear.size());

		if (linear.size() > 2) {
			UtilHBM.reportKO("Worktop linear broken and number of broken linear are:" + linear.size());
		} else
			UtilHBM.reportOK("Worktop linear correct and number of linear are: " + linear.size());
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public WorktopEditor editWorktopYes() {

		String titleText = "Edit worktop";
		String message = "Please make sure you choose your preferred worktop before editing it. Your modifications will only be priced for custom worktops.";

		UtilHBM.waitExplicitDisplayed(driver, editWorktopPopUp);
		Verification.displayNAttributeCheckOfElement(editWorktopTitle, "Edit Overlay Title", "text", titleText);
		Verification.displayNAttributeCheckOfElement(editWorktopMessage, "Edit Overlay Message", "text", message);
		Verification.VerifyEquals("Learn more link not displayed", worktopLearnMoreLink.getText(),
				"Learn more about worktop types");
		editWorktopYes.click();
		UtilHBM.waitExplicitDisplayed(driver,
				driver.findElement(By.xpath("//article[@class='mod-layer-editor mod-open']/div/header")));
		UtilHBM.waitFixTime(1500);

		return PageFactory.initElements(driver, WorktopEditor.class);
	}
	public WorktopEditor editWorktopByCheckingLearnMoreAboutWorkop() {
		UtilHBM.waitExplicitDisplayed(driver, editWorktopPopUp);
		Verification.VerifyEquals("Learn more link not displayed", worktopLearnMoreLink.getText(),
				"Learn more about worktop types");
		worktopLearnMoreLink.click();
		driver.switchTo().parentFrame();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//article[@class='mod-popin-alert-types mod-open']/div/header/div/div/h3[contains(text(),'Wall Panel & Worktop types')]")));
		driver.findElement(By.xpath("//article[@class='mod-popin-alert-types mod-open']/div/header/div/div/button[@title='Close']")).click();
		List<WebElement> frames = driver.findElements(By.cssSelector("#iframeContainer>iframe"));
		driver.switchTo().frame(frames.get(0));
		UtilHBM.waitExplicitDisplayed(driver, editWorktopPopUp);
		editWorktopYes.click();
		UtilHBM.waitExplicitDisplayed(driver,
				driver.findElement(By.xpath("//article[@class='mod-layer-editor mod-open']/div/header")));
		UtilHBM.waitFixTime(1500);

		return PageFactory.initElements(driver, WorktopEditor.class);
	}
	public MakeItYours learnMoreWorktopAndWallPanel() {
		UtilHBM.waitExplicitDisplayed(driver,
				driver.findElement(By.cssSelector("article[class='mod-popin-alert-types mod-open']")));
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public WorktopEditor tooltipsWorktop() {
		Tooltips tips = PageFactory.initElements(driver, Tooltips.class);
		tips.tooltipsForWorktopEditor();
		clickBlank();
		return this;
	}

	public WorktopEditor worktopEditorPrice() {
		UtilHBM.waitExplicitClickable(driver, worktopEditorPrice);
		new Actions(driver).moveToElement(worktopEditorPrice).clickAndHold().pause(500).release().build().perform();
		driver.switchTo().parentFrame();
		UtilHBM.waitExplicitDisplayed(driver, worktopPriceTitle);
		Verification.VerifyEquals("Price information title not displayed", worktopPriceTitle.getText(),
				"Price information");
		Verification.VerifyEquals("Price information Not Displayed", worktopPriceInfo.getText(),
				"What is included in your worktop price?");
		System.out.println(worktopPriceContent.getText());
		Verification.VerifyEquals("Price information content not displayed", worktopPriceContent.getText(),
				"For precut worktops, the price only includes the boards, edges and joints.\nFor custom made worktops, the price includes all operations needed to manufactured your worktop as you designed it.");
		;
		Verification.VerifyEquals("Learn more link not displayed", worktopEditorLearnMoreLink.getText(),
				"Learn more about worktop types");
		closeWorktopPricePopUp.click();
		List<WebElement> frames = driver.findElements(By.cssSelector("#iframeContainer>iframe"));
		driver.switchTo().frame(frames.get(0));
		clickBlank();
		return this;
	}

	public WorktopEditor changeGrainDirection(int x, int y) {
		clickBlank();
		getBallon(x, y);
		changeGrainDirection.click();
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitDisplayed(driver, changeGrainDirectionNext);
		Verification.displayOfWebElement(driver.findElement(By.xpath("//button[@data-ui-action='overlay-close']")));
		Verification.displayOfWebElement(driver.findElement(By.cssSelector(
				"div[class='mod-overlay-container mod-open']>div>section[class='mod-overlay mod-open']>header>h3")));
		Verification.VerifyEquals("Change grain direction title not correct", driver.findElement(By.cssSelector(
				"div[class='mod-overlay-container mod-open']>div>section[class='mod-overlay mod-open']>header>h3"))
				.getText(), "Change grain direction");
		Verification.displayOfWebElement(changeGrainDirectionNext);
		Verification.displayOfWebElement(changeGrainDirectionPrevious);
		changeGrainDirectionNext.click();
		clickBlank();
		return this;
	}

	public WorktopEditor createCutOut(int x, int y, String cutOutType, String rectValue1, String rectValue2,
			String roundedCorners, String radius, String diameter) {
		clickBlank();
		getBallon(x, y);
		addCutOut.click();
		UtilHBM.waitExplicitDisplayed(driver, "//div[@class='mod-overlay-container mod-open']");
		WebElement cut = null;
		if(cutOutType.equalsIgnoreCase("Rectangle")) {
			cut=driver.findElement(By.xpath("//ul[@role='tablist']/li/label/span[@data-i18n='kitchen.worktop_editor.cut_out_overlay.rectangle;planner.worktop_editor.cut_out_overlay.rectangle']"));
		}else if(cutOutType.equalsIgnoreCase("Circle")){
			cut=driver.findElement(By.xpath("//ul[@role='tablist']/li/label/span[@data-i18n='kitchen.worktop_editor.cut_out_overlay.circle;planner.worktop_editor.cut_out_overlay.circle']"));
		}
//				driver.findElement(By.xpath("//ul[@role='tablist']/li/label/span[contains(text(),'" + cutOutType + "')]"));
		cut.click();
		System.out.println(driver.findElement(By.cssSelector("section>header>h3")).getText());
		if (!(rectValue1.isEmpty())) {

			UtilHBM.waitExplicitClickable(driver, rectangleValue1);
			rectangleValue1.click();
			rectangleValue1.clear();
			rectangleValue1.sendKeys(rectValue1 + Keys.ENTER);
			String minimunValue = "34 mm";
			int val = Integer
					.parseInt(minimunValue.trim().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", ""));
			int rectVal = Integer
					.parseInt(rectValue1.trim().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", ""));
			if (rectVal <= val) {
				Verification.displayOfWebElement(errorMsg);
				Verification.VerifyEquals("Error message dispalyed is not correct", errorMsg.getText(), "The minimum value is 35 mm.");
			}
		}
		if (!(rectValue2.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, rectangleValue2);
			rectangleValue2.click();
			rectangleValue2.clear();
			rectangleValue2.sendKeys(rectValue2);
			String minimunValue = "34 mm";
			int val = Integer
					.parseInt(minimunValue.trim().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", ""));
			int rectVal = Integer
					.parseInt(rectValue2.trim().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", ""));
			if (rectVal <= val) {
				Verification.displayOfWebElement(errorMsg);
				Verification.VerifyEquals("Error message dispalyed is not correct", errorMsg.getText(), "The minimum value is 35 mm.");
			}
		}

		if (roundedCorners.equalsIgnoreCase("yes") || roundedCorners.equalsIgnoreCase("نعم")) {
			UtilHBM.waitExplicitClickable(driver, cutOutMoreOptions);
			new Actions(driver).moveToElement(cutOutMoreOptions).click().pause(500).release().build().perform();
			UtilHBM.waitExplicitClickable(driver, cutOutRadius);
			if (!(radius.isEmpty())) {
				cutOutRadius.click();
				cutOutRadius.clear();
				cutOutRadius.sendKeys(radius);
				String minimunValue = "2 mm";
				int val = Integer
						.parseInt(minimunValue.trim().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", ""));
				int radiusVal = Integer
						.parseInt(rectValue2.trim().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", ""));
				if (radiusVal <= val) {
					Verification.displayOfWebElement(errorMsg);
					Verification.VerifyEquals("Error message dispalyed is not correct", errorMsg.getText(), "The minimum value is 3 mm.");
				}
			}

		} else {
			UtilHBM.reportOK("Rounded corners not checked");
		}
		if (!(diameter.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, cutOutDiameter);
			cutOutDiameter.click();
			cutOutDiameter.clear();
			UtilHBM.waitFixTime(1000);
			Verification.displayOfWebElement(errorMsg);
			Verification.VerifyEquals("Error message dispalyed is not correct", errorMsg.getText(), "Bad Input");
			cutOutDiameter.sendKeys(diameter+Keys.ENTER);
			UtilHBM.waitFixTime(1000);
			String minimunValue = "5 mm";
			int val = Integer
					.parseInt(minimunValue.trim().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", ""));
			int dia = Integer
					.parseInt(diameter.trim().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", ""));
			if (dia <= val) {
				Verification.displayOfWebElement(errorMsg);
				Verification.VerifyEquals("Error message dispalyed is not correct", errorMsg.getText(), "The minimum value is 6 mm.");
			}
		}
		clickBlank();
		return this;
	}

	public WorktopEditor verifyWorktopCutOutAbsent(int x, int y) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitFixTime(2500);
		UtilHBM.waitExplicitDisplayed(driver, "//section[@class='mod-overlay']//h3[text()='Worktop options']");
		UtilHBM.turnOffImplicitWaits(driver);
		try {
			if (driver.findElement(By.xpath("//section[@class='mod-overlay']//h3[text()='Cut-out']")).isDisplayed()) {
				UtilHBM.reportKO("Cut out present");
			}
		} catch (NoSuchElementException e) {
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}

	public WorktopEditor verifyWorktopCutOut(int x, int y, String rectValue1, String rectValue2, String radius,
			String diameter, String dim1, String dim2) {
		clickBlank();
		System.out.println("Verify Worktop editor");
		// Actions action = new Actions(driver);
		// action.moveToElement(driver.findElement(By.cssSelector("#bmHTML")))
		// .click().perform();
		// UtilHBM.waitFixTime(2500);
		getBallon(x, y);
		UtilHBM.waitFixTime(2500);
		int index = 0;
		int j = 0;
		for (WebElement image : measureInputCutOut) {
			if (dim1.equalsIgnoreCase(image.getAttribute("value"))) {
				index++;
			}
			if (dim2.equalsIgnoreCase(image.getAttribute("value"))) {
				j++;
			}
		}
		if (index > 0) {
			UtilHBM.reportOK("Number of dimensions for cut-out with value  " + dim1 + "are  " + index);

		}
		if (j > 0) {
			UtilHBM.reportOK("Number of dimensions for cut-out with value  " + dim2 + " are  " + j);
		}

		if (rectValue1.isEmpty() && rectValue2.isEmpty() && radius.isEmpty() && diameter.isEmpty()) {
			UtilHBM.reportInfo("Properties not available for verification");
		} else if (!(rectValue1.isEmpty())) {
			UtilHBM.waitExplicitDisplayed(driver, rectangleValue1);
			if (rectangleValue1.getAttribute("value").equalsIgnoreCase(rectValue1)) {
				UtilHBM.reportOK("Verification successful for rectangular value 1 and value is : "
						+ rectangleValue1.getAttribute("value"));
			} else {
				UtilHBM.reportKO("Verification failed for rectangular value 1 and value is : "
						+ rectangleValue1.getAttribute("value"));
			}
		}

		if (!(rectValue2.isEmpty())) {
			if (rectangleValue2.getAttribute("value").equalsIgnoreCase(rectValue2)) {
				UtilHBM.reportOK("Verification successful for rectangular value 2 and value is : "
						+ rectangleValue2.getAttribute("value"));
			} else {
				UtilHBM.reportKO("Verification failed for rectangular value 2 and value is : "
						+ rectangleValue2.getAttribute("value"));
			}
		}
		if (!(radius.isEmpty())) {
			if (cutOutRadius.getAttribute("value").equalsIgnoreCase(radius)) {
				UtilHBM.reportOK("Verification successful for radius value  and value is : "
						+ cutOutRadius.getAttribute("value"));
			} else {
				UtilHBM.reportKO(
						"Verification failed for radius value  and value is : " + cutOutRadius.getAttribute("value"));
			}
		}

		if (!(diameter.isEmpty())) {

			if ((diameter.equalsIgnoreCase(cutOutDiameter.getAttribute("value")))) {
				UtilHBM.reportOK("Circle cut-out Properties verification passed");
			} else {
				UtilHBM.reportKO("Circle cut-out Properties verification failed");
			}
		}
		clickBlank();
		return this;
	}

	public MakeItYours validateWorktopEditor() {
		UtilHBM.waitExplicitDisplayed(driver, validateWorktopEditor);
		UtilHBM.waitExplicitClickable(driver, validateWorktopEditor);
		validateWorktopEditor.click();
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//span[@id='project-title']")));
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//button[@data-ui-action='product-list']")));
		UtilHBM.waitExplicitClickable(driver, driver.findElement(By.xpath("//button[@data-ui-action='product-list']")));
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours validateWorktopEditor(String acceptWallEdgeStripModification) {
		UtilHBM.waitExplicitDisplayed(driver, validateWorktopEditor);
		UtilHBM.waitExplicitClickable(driver, validateWorktopEditor);
		validateWorktopEditor.click();
		if (acceptWallEdgeStripModification.equalsIgnoreCase("true")) {
			UtilHBM.waitExplicitDisplayed(driver, wallEdgeStripModificationOKBtn);
			wallEdgeStripModificationOKBtn.click();
		}
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//span[@id='project-title']")));
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//button[@data-ui-action='product-list']")));
		UtilHBM.waitExplicitClickable(driver, driver.findElement(By.xpath("//button[@data-ui-action='product-list']")));
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours cancelWorktopEditor() {
		UtilHBM.waitExplicitDisplayed(driver, cancelWorktopEditor);
		UtilHBM.waitExplicitClickable(driver, cancelWorktopEditor);
		cancelWorktopEditor.click();
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public WorktopEditor deleteCutOrCutOuts(int x, int y) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitFixTime(2000);
		deleteCuts.click();
		if (measureInputCutOut.size() > 0) {
			UtilHBM.reportKO("Cut-out not deleted");

		} else {
			UtilHBM.reportOK("Cut-out deleted successfully");
		}
		return this;
	}

	public WorktopEditor verifyDeletedCutOut(int x, int y) {
		clickBlank();
		getBallon(x, y);
		if (addCutOut.isDisplayed()) {
			UtilHBM.reportOK("Cut-out deleted successfully");

		} else {
//			if (rectangleValue1.isDisplayed()) {
			UtilHBM.reportOK("Cut-out not deleted");

		}
		return this;
	}

	public WorktopEditor createCornerCutOut(int x, int y, String cornerImg, String cutOutName, String simpleValue1,
			String simpleValue2, String doubleValue1, String doubleValue2, String doubleCutMoreOption,
			String doubleValue3, String doubleValue4, String invertValue1, String roundedValue1) {
		clickBlank();
		getBallon(x, y);
		addCornerCut.click();
		WebElement options = driver
				.findElement(By.xpath("//ul[@role='tablist']/li/label/span[contains(text(),'" + cutOutName + "')]"));
		options.click();

		if (!(simpleValue1.isEmpty())) {

			UtilHBM.waitExplicitClickable(driver, cornerCutSimpleValue1);
			cornerCutSimpleValue1.click();
			cornerCutSimpleValue1.clear();
			cornerCutSimpleValue1.sendKeys(simpleValue1);
		}
		if (!(simpleValue2.isEmpty())) {

			UtilHBM.waitExplicitClickable(driver, cornerCutSimpleValue2);
			cornerCutSimpleValue2.click();
			cornerCutSimpleValue2.clear();
			cornerCutSimpleValue2.sendKeys(simpleValue1);
		}
		if (!(doubleValue1.isEmpty())) {

			UtilHBM.waitExplicitClickable(driver, cornerCutDoubleValue1);
			cornerCutDoubleValue1.click();
			cornerCutDoubleValue1.clear();
			cornerCutDoubleValue1.sendKeys(doubleValue1);
		}
		if (!(doubleValue2.isEmpty())) {

			UtilHBM.waitExplicitClickable(driver, cornerCutDoubleValue2);
			cornerCutDoubleValue2.click();
			cornerCutDoubleValue2.clear();
			cornerCutDoubleValue2.sendKeys(doubleValue1);
		}
		if (doubleCutMoreOption.equalsIgnoreCase("yes")) {
			cornerCutDoubleMoreOption.click();
			if (!(doubleValue3.isEmpty())) {

				UtilHBM.waitExplicitClickable(driver, cornerCutDoubleValue3);
				cornerCutDoubleValue3.click();
				cornerCutDoubleValue3.clear();
				cornerCutDoubleValue3.sendKeys(doubleValue1);
			}
			if (!(doubleValue4.isEmpty())) {

				UtilHBM.waitExplicitClickable(driver, cornerCutDoubleValue4);
				cornerCutDoubleValue4.click();
				cornerCutDoubleValue4.clear();
				cornerCutDoubleValue4.sendKeys(doubleValue1);
			}
		} else {
			UtilHBM.reportOK("Non straight option not checked");
		}
		if (!(invertValue1.isEmpty())) {

			UtilHBM.waitExplicitClickable(driver, cornerCutInvertValue1);
			cornerCutInvertValue1.click();
			cornerCutInvertValue1.clear();
			cornerCutInvertValue1.sendKeys(invertValue1);
			String minimunValue = "35 mm";
			int val = Integer
					.parseInt(minimunValue.trim().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", ""));
			int rectVal = Integer
					.parseInt(invertValue1.trim().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", ""));
			if (rectVal < val) {
				Verification.displayOfWebElement(driver.findElement(By.cssSelector("b[class='error']")));
				if (driver.findElement(By.cssSelector("b[class='error']")).getText()
						.equalsIgnoreCase("The minimum value is 90.")) {
					UtilHBM.reportMsg("The minimum value is 90.Please enter value greater than 90");
					clickBlank();
				}
			}
		}
		if (!(roundedValue1.isEmpty())) {

			UtilHBM.waitExplicitClickable(driver, cornerCutRoundedValue1);
			cornerCutRoundedValue1.click();
			cornerCutRoundedValue1.clear();
			cornerCutRoundedValue1.sendKeys(roundedValue1, Keys.ENTER);
		}
		createButton.click();
		clickBlank();
		return this;
	}

	public WorktopEditor addJoint(int x, int y) {
		clickBlank();
		getBallon(x, y);
		addJointButton.click();
		UtilHBM.waitExplicitDisplayed(driver, removeJointOverlay);
		if (removeJointOverlay.isDisplayed()) {
			UtilHBM.reportOK("Joint added sucessfully");
		} else {
			UtilHBM.reportKO("Joint not added");
		}
		clickBlank();
		return this;
	}

	public WorktopEditor verifyJoint(int x, int y, String dim) {
		clickBlank();
		getBallon(x, y);
		int index = 0;
		for (WebElement image : measureInputCutOut) {
			if (dim.equalsIgnoreCase(image.getAttribute("value"))) {
				index++;
			}
		}
		if (index > 0) {
			UtilHBM.reportOK("Number of dimensions for joint with value  " + dim + " are  " + index);

		}
		return this;
	}

	public WorktopEditor removeJoint(int x, int y) {
		clickBlank();
		getBallon(x, y);
		removeJointButton.click();
		clickBlank();
//		List<WebElement> joint = driver
//				.findElements(By.cssSelector("div>svg>g[fill-rule='evenodd']>g>g>path[id^=path]"));
//		// li.get(1).click();
//		Actions action = new Actions(driver);
//		int index = Integer.parseInt(indexToRemoveJoint);
//		for (WebElement i : joint) {
//			if (i.equals(joint.get(index))) {
//				System.out.println("i" + i);
//				new Actions(driver).moveToElement(joint.get(index)).clickAndHold().pause(500).release().build()
//						.perform();
//				action.moveToElement(joint.get(index)).click().build().perform();
////				getBallon(x, y);
//				removeJointButton.click();
//				clickBlank();
//				UtilHBM.waitFixTime(5000);
//			}
//		}

		return this;
	}

	public WorktopEditor verifyRemoveJoint(int x, int y) {
		clickBlank();
		getBallon(x, y);

		if (measureInputCutOut.size() > 0) {
			UtilHBM.reportKO("Joint not deleted");

		} else {
			UtilHBM.reportOK("Joint deleted successfully");
		}
		return this;
	}

	public WorktopEditor addEdgeCut(int x, int y, String cutName, String edgeTripleValue1, String edgeTripleValue2,
			String edgeTripleValue3, String nonStraight, String edgeTripleValue4, String edgeTripleValue5,
			String edgeRoundedValue1) {
		clickBlank();
		getBallon(x, y);
		addEdgeCutButton.click();
		WebElement cut = driver
				.findElement(By.xpath("//ul[@role='tablist']/li/label/span[contains(text(),'" + cutName + "')]"));
		cut.click();
		if (!(edgeTripleValue1.isEmpty())) {

			UtilHBM.waitExplicitClickable(driver, edgeCutTripleValue1);
			edgeCutTripleValue1.click();
			edgeCutTripleValue1.clear();
			edgeCutTripleValue1.sendKeys(edgeTripleValue1 + Keys.ENTER);
		}
		if (!(edgeTripleValue2.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, edgeCutTripleValue2);
			edgeCutTripleValue2.click();
			edgeCutTripleValue2.clear();
			edgeCutTripleValue2.sendKeys(edgeTripleValue2 + Keys.ENTER);
		}
		if (!(edgeTripleValue3.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, edgeCutTripleValue3);
			edgeCutTripleValue3.click();
			edgeCutTripleValue3.clear();
			edgeCutTripleValue3.sendKeys(edgeTripleValue3 + Keys.ENTER);
		}
		if (nonStraight.equalsIgnoreCase("yes")) {
			UtilHBM.waitExplicitClickable(driver, edgeCutMoreOptions);
			edgeCutMoreOptions.click();
			if (!(edgeTripleValue4.isEmpty())) {
				UtilHBM.waitExplicitClickable(driver, edgeCutTripleValue4);
				edgeCutTripleValue4.click();
				edgeCutTripleValue4.clear();
				edgeCutTripleValue4.sendKeys(edgeTripleValue4 + Keys.ENTER);
			}
			if (!(edgeTripleValue5.isEmpty())) {
				UtilHBM.waitExplicitClickable(driver, edgeCutTripleValue5);
				edgeCutTripleValue5.click();
				edgeCutTripleValue5.clear();
				edgeCutTripleValue5.sendKeys(edgeTripleValue5 + Keys.ENTER);
			}
		} else {
			UtilHBM.reportOK("Non straight line not checked");
		}

		if (!(edgeRoundedValue1.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, edgeCutRoundedValue1);
			edgeCutRoundedValue1.click();
			edgeCutRoundedValue1.clear();
			edgeCutRoundedValue1.sendKeys(edgeRoundedValue1);
		}
		UtilHBM.waitExplicitClickable(driver, createButton);
		createButton.sendKeys(Keys.ENTER);// to click on button
//		new Actions(driver).moveToElement(createButton).click().build()
//				.perform();
		// createButton.click();
		UtilHBM.waitFixTime(2000);
		UtilHBM.reportOK("Edge cut created");
		return this;
	}

	public WorktopEditor verifyEdgeCut(int x, int y, String dim) {
		clickBlank();
		getBallon(x, y);
		int index = 0;
		for (WebElement ele : measureInput) {
			System.out.println(measureInput.size());
			System.out.println("Value " + ele.getAttribute("value"));
			if (dim.equalsIgnoreCase(ele.getAttribute("value"))) {
				index++;
			}
		}
		if (index > 0) {
			UtilHBM.reportOK("Number of dimensions for edge cut with value  " + dim + " are  " + index);

		} else {
			UtilHBM.reportKO("Number of dimensions for edge cut with value  " + dim + " are  " + index);
		}
		return this;
	}

	public WorktopEditor cornerCutForWallPanel(int x, int y, String cutType, String cornerA, String cornerB,
			String nonStraight, String cornerX, String cornerY, String radius) {
		clickBlank();
		getBallon(x, y);
		addCornerCut.click();
		UtilHBM.waitFixTime(2000);
		WebElement cut = driver
				.findElement(By.xpath("//ul[@role='tablist']/li/label/span[contains(text(),'" + cutType + "')]"));
		cut.click();
		UtilHBM.waitFixTime(1000);
		if (!(cornerA.isEmpty())) {

			UtilHBM.waitExplicitClickable(driver, cornerCutA);
			cornerCutA.click();
//			cornerCutA.clear();
			cornerCutA.sendKeys(cornerA + Keys.ENTER);
		}
		if (!(cornerB.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, cornerCutB);
			cornerCutB.click();
//			cornerCutB.clear();
			cornerCutB.sendKeys(cornerB + Keys.ENTER);
		}

		if (nonStraight.equalsIgnoreCase("yes")) {
			UtilHBM.waitExplicitClickable(driver, nonStraightCornerCut);
			new Actions(driver).moveToElement(nonStraightCornerCut).build().perform();
			new Actions(driver).moveToElement(nonStraightCornerCut).click().build().perform();

			if (!(cornerX.isEmpty())) {
				UtilHBM.waitExplicitClickable(driver, cornerCutX);
				cornerCutX.click();
				cornerCutX.clear();
				cornerCutX.sendKeys(cornerX + Keys.ENTER);
			}
			if (!(cornerY.isEmpty())) {
				UtilHBM.waitExplicitClickable(driver, cornerCutY);
				cornerCutY.click();
				cornerCutY.clear();
				cornerCutY.sendKeys(cornerY + Keys.ENTER);
			}
		} else {
			UtilHBM.reportOK("Non straight line not checked");
		}
		if (!(radius.isEmpty())) {
			if (cornerCutRadius.isDisplayed()) {
				UtilHBM.waitExplicitClickable(driver, cornerCutRadius);
				cornerCutRadius.click();
				cornerCutRadius.clear();
				cornerCutRadius.sendKeys(radius + Keys.ENTER);
			} else {
				UtilHBM.waitExplicitClickable(driver, cornerCutRoundedValue1);
				cornerCutRoundedValue1.click();
				cornerCutRoundedValue1.clear();
				cornerCutRoundedValue1.sendKeys(radius + Keys.ENTER);
			}
		}
		createButton.sendKeys(Keys.ENTER);
		UtilHBM.waitFixTime(2000);
		return this;
	}

	public WorktopEditor verifyCornerCutForWallPanel(int x, int y, String dim1) {
		clickBlank();
		getBallon(x, y);
		int index = 0;
		int j = 0;
		for (WebElement image : cornercutTags) {
			if (dim1.equalsIgnoreCase(image.getAttribute("value"))) {
				index++;
			}
		}
		if (index > 0) {
			UtilHBM.reportOK("Number of dimensions for corner cut with value  " + dim1 + "are  " + index);
		}
		clickBlank();
		return this;
	}

	public WorktopEditor addEdgeForCornerCut(int x, int y, String edgeReference) {
		clickBlank();
		getBallon(x, y);

		if (addCornerCutEdge.isDisplayed()) {
			addCornerCutEdge.click();
			Select oSelect = new Select(cornerCutEdgeProduct);
			oSelect.selectByVisibleText(edgeReference);
		}
		clickBlank();
		return this;
	}

	public WorktopEditor verifyEdgeForCornerCut(int x, int y, String edge) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver, changeCornerCutEdge);
		if (changeCornerCutEdge.isDisplayed()) {
			changeCornerCutEdge.click();
			UtilHBM.waitExplicitDisplayed(driver, selectedEdgeProduct);
			if (selectedEdgeProduct.getText().equalsIgnoreCase(edge)) {
				UtilHBM.reportOK("Corner Cut Edge product " + selectedEdgeProduct.getText() + " added successfully");
			} else {
				UtilHBM.reportKO("Corner Cut Edge product reference failed");
			}
		}

		return this;
	}

	public WorktopEditor addSplitEdge(int x, int y) {
		clickBlank();
		getBallon(x, y);
		splitEdgeButton.click();
		UtilHBM.reportOK("Split created");
		UtilHBM.waitFixTime(500);
		clickBlank();
		return this;
	}

	public WorktopEditor verifySplit(int x, int y, String dim) {
		clickBlank();
		getBallon(x, y);

		int index = 0;
		for (WebElement ele : measureInputCutOut) {
			if (dim.equalsIgnoreCase(ele.getAttribute("value"))) {
				index++;
			}

		}
		if (index > 0) {
			UtilHBM.reportOK("Number of dimensions for split with value  " + dim + " are  " + index);

		}
		clickBlank();
		return this;
	}

	public WorktopEditor moveSplit(int x, int y, int x1, int y1) {
		clickBlank();
		UtilHBM.waitFixTime(2000);
		Actions action = new Actions(driver);
//		action.moveToElement(container3D, x, y - 10).clickAndHold().pause(500).release().pause(500).build().perform();
		action.moveToElement(container3D, x, y).clickAndHold().pause(1000).dragAndDropBy(container3D, x1, y1)
				.pause(1000).release().build().perform();
		clickBlank();
		return this;
	}

	public WorktopEditor editWorktopDimension(int x, int y, String dimToChange, String dim,
			String applyAboveBelowLeftRight) {
		clickBlank();
		getBallon(x, y);
		boolean dimFound = false;
		for (WebElement index : measureInput) {
			if (dimToChange.equalsIgnoreCase(index.getAttribute("value"))) {
				System.out.println("i2 " + index.getAttribute("value"));
				WebElement inputEdit = index
						.findElement(By.xpath("following-sibling::div/input[@class='measure-edit-input']"));
				System.out.println("input-edit :" + inputEdit.getAttribute("value"));
				new Actions(driver).moveToElement(index).click().build().perform();
				UtilHBM.waitFixTime(100);
				inputEdit.sendKeys(dim);
				dimFound = true;
				break;
			}
		}
		if (!applyAboveBelowLeftRight.isEmpty()) {
			if (applyAboveBelowLeftRight.equalsIgnoreCase("apply above")) {
				applyAbove.click();
			} else if (applyAboveBelowLeftRight.equalsIgnoreCase("apply below")) {
				applyBelow.click();
			} else if (applyAboveBelowLeftRight.equalsIgnoreCase("apply left")) {
				applyLeft.click();
			} else {
				applyRight.click();
			}
		}
		if (!dimFound) {
			UtilHBM.reportKO("Worktop dimension to edit is not avaialble. Expected dim to edit: " + dimToChange
					+ ". The available dimensions are: ");
			for (WebElement index : measureInput) {
				UtilHBM.reportKO(index.getAttribute("value"));
			}
		}
		return this;
	}

	public WorktopEditor editCutOutDimension(int x, int y, String dimToChange, String dim) {
		clickBlank();
		getBallon(x, y);
		WebElement inputEdit = null;
		for (WebElement index : measureInput) {
			if (dimToChange.equalsIgnoreCase(index.getAttribute("value"))) {
				inputEdit = index.findElement(By.xpath("following-sibling::div/input[@class='measure-edit-input']"));
				new Actions(driver).moveToElement(index).click().build().perform();
				UtilHBM.waitFixTime(100);
				inputEdit.sendKeys(dim + Keys.ENTER);
				break;
			}
		}
		if (inputEdit == null) {
			UtilHBM.reportKO("Expected CutOut dimentions " + dimToChange
					+ " is not available. THe available dimensions to edit are:");
			for (WebElement index : measureInput) {
				UtilHBM.reportKO(index.getAttribute("value"));
			}
		}
		clickBlank();
		return this;
	}

	public WorktopEditor verifyWorktopDimension(int x, int y, String dim) {
		clickBlank();
		getBallon(x, y);
		int index = 0;
		for (WebElement i : measureInput) {
			if (dim.equalsIgnoreCase(i.getAttribute("value"))) {
				index++;
			}
		}
		if (!(index > 0)) {
			UtilHBM.reportKO("Worktop dimension verification failed. Expected dimension " + dim
					+ ", available dimensions are: ");
			for (WebElement i : measureInput) {
				UtilHBM.reportKO(i.getAttribute("value"));
			}
		}else {
			UtilHBM.reportOK("Worktop dimension verification passed. Expected dimension " + dim
					+ ", available dimensions are: ");
			for (WebElement i : measureInput) {
				UtilHBM.reportOK(i.getAttribute("value"));
			}
		}
		clickBlank();
		return this;
	}

	public WorktopEditor removeWaterfall(int x, int y) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver, removeWaterFallButton);
		UtilHBM.waitExplicitClickable(driver, removeWaterFallButton);
		removeWaterFallButton.click();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//div[@class='mod-overlay-container mod-open']")));
		if (addWaterfallButton.isDisplayed()) {
			UtilHBM.reportOK("WaterFall removed sucessfully");
		} else {
			UtilHBM.reportKO("WaterFall not removed");
		}
		return this;
	}

	public WorktopEditor addWaterfall(int x, int y, String price) {
		clickBlank();
		getBallon(x, y);
		addWaterfallButton.click();
		UtilHBM.waitExplicitDisplayed(driver, removeWaterFallButton);
		if (removeWaterFallButton.isDisplayed()) {
			UtilHBM.reportOK("WaterFall added sucessfully");
		} else {
			UtilHBM.reportKO("WaterFall not added");
		}
		if (!price.isEmpty())
			verifyPriceInWorktop(price);
		return this;
	}

	public WorktopEditor editWaterfall(int x, int y) {
		clickBlank();
		clickBlank();
		getBallon(x, y);
		editWaterfallButton.click();
		UtilHBM.waitExplicitDisplayed(driver, backWorktopEditorButton);
		if (backWorktopEditorButton.isDisplayed()) {
			UtilHBM.reportOK("In waterfall worktop view");
		} else {
			UtilHBM.reportKO("WaterFall worktop view not displayed");
		}
//		if(!price.isEmpty())verifyPriceInWorktop(price);
		return this;
	}
	public WorktopEditor changeWaterFallType(int x, int y, String waterFallType) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitExplicitClickable(driver, changeWaterFallTypeButton);
		changeWaterFallTypeButton.click();
		UtilHBM.waitExplicitDisplayed(driver, backBtnEdgePrd);
		UtilHBM.waitFixTime(200);
		Select oSelect = new Select(chooseWaterFallType);
		if (waterFallType.isEmpty())
			oSelect.selectByValue("default");
		else
			oSelect.selectByVisibleText(waterFallType);

		return this;
	}
	public WorktopEditor mainWorktopView(String price) {
		clickBlank();
		backWorktopEditorButton.click();
		verifyPriceInWorktop(price);
		return this;
	}

	public WorktopEditor addWaterfallEdges(int x, int y, String leftEdge, String rightEdge) {
		clickBlank();
		getBallon(x, y);
		if (addWaterFallEdge.isDisplayed()) {
			addWaterFallEdge.click();
			Select oSelect = new Select(waterFallLeftEdgeProduct);
			oSelect.selectByVisibleText(leftEdge);
			Select oSelect1 = new Select(waterFallRightEdgeProduct);
			oSelect1.selectByVisibleText(rightEdge);
		}
		return PageFactory.initElements(driver, WorktopEditor.class);
	}

	public WorktopEditor verifyWaterfallEdges(int x, int y, String leftEdge, String rightEdge) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver, addWaterFallEdge);
		if (addWaterFallEdge.isDisplayed()) {
			addWaterFallEdge.click();
			UtilHBM.waitExplicitDisplayed(driver, selectedLeftWaterFallEdgeProduct);
			if (selectedLeftWaterFallEdgeProduct.getText().equalsIgnoreCase(leftEdge)) {
				UtilHBM.reportOK(
						"Left Edge product " + selectedLeftWaterFallEdgeProduct.getText() + " added successfully");
			} else {
				UtilHBM.reportKO("Left Edge product reference failed to add");
			}
			if (selectedRightWaterFallEdgeProduct.getText().equalsIgnoreCase(rightEdge)) {
				UtilHBM.reportOK(
						"Right Edge product " + selectedRightWaterFallEdgeProduct.getText() + " added successfully");
			} else {
				UtilHBM.reportKO("Right Edge product reference failed to add");
			}

		}

		return this;
	}

	public WorktopEditor changeEdgeProduct(int x, int y, String edgeReference, String front) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitExplicitClickable(driver, changeEdgeProductButton);
		changeEdgeProductButton.click();
		UtilHBM.waitExplicitDisplayed(driver, backBtnEdgePrd);
		UtilHBM.waitFixTime(200);
		Select oSelect = new Select(edgeProduct);
		if (edgeReference.isEmpty())
			oSelect.selectByValue("default");
		else
			oSelect.selectByVisibleText(edgeReference);

		if (front.equalsIgnoreCase("yes")
				&& !frontOption.findElement(By.xpath("./preceding-sibling::input")).isSelected()) {
			UtilHBM.waitExplicitClickable(driver, frontOption);
			frontOption.click();
		} else if (front.equalsIgnoreCase("no")
				&& frontOption.findElement(By.xpath("./preceding-sibling::input")).isSelected()) {
			UtilHBM.waitExplicitClickable(driver, frontOption);
			frontOption.click();
		}

		return this;
	}

	public WorktopEditor addEdgeProduct(int x, int y, String edgeReference, String front) {
		clickBlank();
		getBallon(x, y);
		if (!edgeReference.isEmpty()) {
			UtilHBM.waitExplicitDisplayed(driver, addEdgeProductButton);
//			if (addEdgeProductButton.isDisplayed()) {
//				UtilHBM.waitExplicitClickable(driver, addEdgeProductButton);
			addEdgeProductButton.click();
			UtilHBM.waitFixTime(200);
			Select oSelect = new Select(edgeProduct);
			oSelect.selectByVisibleText(edgeReference);
//			}
			if (front.equalsIgnoreCase("yes")) {
				UtilHBM.waitExplicitClickable(driver, frontOption);
				frontOption.click();
			} else {
				UtilHBM.reportOK("Front not checked");
			}

			UtilHBM.reportOK("edge product applied on worktop edge having choose a reference/no edge product");
		}
		clickBlank();
		return this;
	}

	public WorktopEditor verifyEdgeProduct(int x, int y, String edgeReference, String front) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver, changeEdgeProductButton);
		if (changeEdgeProductButton.isDisplayed()) {
			changeEdgeProductButton.click();
			UtilHBM.waitExplicitDisplayed(driver, selectedEdgeProduct);
			if (selectedEdgeProduct.getText().equalsIgnoreCase(edgeReference)) {
				UtilHBM.reportOK("Edge product added successfully");
			} else
				UtilHBM.reportKO("Edge product reference failed to add");

			if (front.equalsIgnoreCase("yes")) {
				if (frontOption.findElement(By.xpath("./preceding-sibling::input")).isSelected())
					UtilHBM.reportOK("Worktop edge is a front");
				else
					UtilHBM.reportKO("Worktop edge is not a front");
			} else if (front.equalsIgnoreCase("no")) {
				if (frontOption.findElement(By.xpath("./preceding-sibling::input")).isSelected())
					UtilHBM.reportKO("Worktop edge is a front");
				else
					UtilHBM.reportOK("Worktop edge is not a front");
			}
		}

		return this;
	}

	public WorktopEditor checkWorktopEditorBusinessRules(String rule) {
		BusinessRules rules = PageFactory.initElements(driver, BusinessRules.class);
		rules.openCloseHelpCenter().checkBusinessRuleShowIn2DWorktop(rule,"");
		return PageFactory.initElements(driver, WorktopEditor.class);
	}

	public WorktopEditor checkWorktopEditorBusinessRules(String rule, String desc) {
		BusinessRules rules = PageFactory.initElements(driver, BusinessRules.class);
		rules.openCloseHelpCenter().checkBusinessRuleShowIn2DWorktop(rule,desc);
		return PageFactory.initElements(driver, WorktopEditor.class);
	}

	public WorktopEditor verifyBusinessRuleInWorktopEditorRemoved(String rule) {
		BusinessRules rules = PageFactory.initElements(driver, BusinessRules.class);
		rules.openCloseHelpCenter().worktopEditorBusinessRuleRemoved(rule);
		clickBlank();
		return PageFactory.initElements(driver, WorktopEditor.class);
	}

	public WorktopEditor clickBlank() {
		UtilHBM.turnOffImplicitWaits(driver);
		int j = 0;
		while (balloon.size() > 0 && j < 10) {
			Actions action = new Actions(driver);
			action.moveToElement(container3D, 347, -323).clickAndHold().pause(500).release().build().perform();
			j++;
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}

	public WorktopEditor getBallon(int x, int y) {
		UtilHBM.turnOffImplicitWaits(driver);
		// clickBlank();
		int i = 0;

		while (balloon.size() == 0 && i < 20) {
			// UtilHBM.hoverImgOffset("bryoBlankSpace.png", 0, 0);
			// UtilHBM.clickImg(img);
			Actions action = new Actions(driver);
			action.moveToElement(container3D, x, y).clickAndHold().pause(500).release().build().perform();
			i++;

			System.out.println("image clicked");
		}
		UtilHBM.turnOnImplicitWaits(driver);

		return this;
	}

	public WorktopEditor undoInWorktopEditor(WebDriver driver, int number) {
		clickBlank();
		for (int i = 0; i < number; i++) {
			undoButton.click();
		}
		clickBlank();
		return PageFactory.initElements(driver, WorktopEditor.class);
	}

	public WorktopEditor redoInWorktopEditor(WebDriver driver, int number) {
		for (int i = 0; i < number; i++) {

			redoButton.click();
		}
		return PageFactory.initElements(driver, WorktopEditor.class);
	}

	public WorktopEditor zoomIn(int zoomIncount) {
		UtilHBM.waitExplicitDisplayed(driver, zoomIn);
		for (int i = 1; i <= zoomIncount; i++) {
			zoomIn.click();
			UtilHBM.waitFixTime(500);

		}
		return this;
	}

	public WorktopEditor zoomOut(int zoomOutcount) {
		for (int i = 1; i <= zoomOutcount; i++) {
			zoomOut.click();
			UtilHBM.waitFixTime(500);

		}
		return this;
	}

	public WorktopEditor verifyEdgeSymbol(int aluminiumEdgeCount, int noEdgeCount, int badEdgeCount) {
		clickBlank();
		Verification.displayOfWebElement(edgeSymbols);
		Verification.displayOfWebElement(edgeLegendTitle);
		Verification.displayOfWebElement(edgeLegendToggle);
		edgeLegendToggle.click();
		// UtilHBM.waitFixTime(200);
		UtilHBM.turnOffImplicitWaits(driver);
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath(
				"//header[@class='mod-togglable-section-toggler active'][@aria-controls='edge-finish-legend-list']/following-sibling::div/figure[@aria-hidden='false']")));
		if (aluminiumEdgeCount == 0 && noEdgeCount == 0 && badEdgeCount == 0) {
			UtilHBM.reportKO("Edge symbols not displayed on worktop");
		}
		System.out.println("count " + aluminiumEdge.size());
		if (aluminiumEdgeCount == aluminiumEdge.size()) {
			UtilHBM.reportOK("Correct number of Aluminium edge symbols displayed and count is " + aluminiumEdge.size());
		}
		if (noEdgeCount == noEdge.size()) {
			UtilHBM.reportOK("Correct number of No edge symbols displayed and count is " + noEdge.size());
		}
		if (driver.findElement(By.xpath("//input[@name='front-displayer'][@checked]")).isDisplayed()) {
			Verification.displayOfWebElement(edgeLegendTitle);

		}
		verifyEdgeLegend(aluminiumEdgeCount, noEdgeCount, badEdgeCount);
		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}

	public WorktopEditor verifyEdgeLegend(int aluminiumEdgeCount, int noEdgeCount, int badEdgeCount) {
		clickBlank();
		if (aluminiumEdgeCount > 0) {
			Verification.displayOfWebElement(aluminiumEdge.get(0));
			Verification.displayOfWebElement(aluminiumEdgeLegend);
		}
		if (noEdgeCount > 0) {
			Verification.displayOfWebElement(noEdge.get(0));
			Verification.displayOfWebElement(noEdgeLegend);
		}
		if (badEdgeCount > 0) {
			Verification.displayOfWebElement(badEdge.get(0));
			Verification.displayOfWebElement(badEdgeLegend);
		}
		driver.findElement(By.xpath("//div[@id='canvas-tools-options']")).click();
		UtilHBM.waitFixTime(200);
		displayEdgeSymbolsToggle.click();
		 UtilHBM.waitFixTime(200);
		UtilHBM.turnOffImplicitWaits(driver);
		if (aluminiumEdge.size() == 0 && badEdge.size() == 0 && noEdge.size() == 0) {
			UtilHBM.reportOK("Display edge symbols OFF, hides edge symbols and edge legend");
		} else
			UtilHBM.reportKO("Display edge symbols OFF,does not hide edge symbols and edge legend");

		UtilHBM.waitFixTime(200);
		displayEdgeSymbolsToggle.click();
		UtilHBM.waitFixTime(200);
		if (aluminiumEdge.size() > 00 || badEdge.size() > 0 || noEdge.size() > 0 && edgeLegendTitle.isDisplayed()) {
			UtilHBM.reportOK("Display edge symbols ON, displays edge symbols and edge legend");
		} else
			UtilHBM.reportKO("Display edge symbols ON,does not display edge symbols and edge legend");
		UtilHBM.turnOnImplicitWaits(driver);
		edgeLegendToggle.click();
		clickBlank();
		return this;

	}

	public WorktopEditor verifyWorktopTypes(String customType) {
		Verification.displayOfWebElement(worktopTypeTitle);
		Verification.displayOfWebElement(worktopTypeToggle);
		Verification.displayOfWebElement(worktopTypeInfo);
		worktopTypeInfo.click();
		WallPanelAndWorktopTypes info = PageFactory.initElements(driver, WallPanelAndWorktopTypes.class);
		info.worktopTypeInfo();
		worktopTypeToggle.click();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath(
				"//header[@class='mod-togglable-section-toggler active'][@aria-controls='worktop-types-legend-list']/following-sibling::div/figure[@aria-hidden='false']")));
		if (!customType.isEmpty()) {
			WebElement type = driver.findElement(
					By.xpath("//figure[@data-ui-selector='worktop-types-legend-list']/ul/li/span[contains(text(),'"
							+ customType + "')]"));
			if (customType.equalsIgnoreCase(type.getText())) {
				Verification.displayOfWebElement(customPrecutSVG);
				Verification.displayOfWebElement(type);
			}
		} else
			UtilHBM.reportKO("Worktop type not displayed in worktop editor");

		return this;
	}

	public WorktopEditor splitWorktop(int x, int y) {
		clickBlank();
		getBallon(x, y);
		splitWorktopButton.click();
		UtilHBM.reportOK("Worktop splitted");
		UtilHBM.waitFixTime(500);
		clickBlank();
		return this;
	}
	public WorktopEditor splitEdge(int x, int y) {
		clickBlank();
		getBallon(x, y);
		splitWorktopButton.click();
		UtilHBM.reportOK("Worktop splitted");
		UtilHBM.waitFixTime(500);
		clickBlank();
		return this;
	}
	public WorktopEditor mergeWorktops(int x, int y) {
		clickBlank();
		getBallon(x, y);
		mergeWorktopsButton.click();
		UtilHBM.reportOK("Worktops merged");
		UtilHBM.waitFixTime(500);
		clickBlank();
		return this;
	}

	public WorktopEditor verifySplitInWorktop(int x, int y) {
		verifyWorktopEdgePresent(x, y);
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver, mergeWorktopsButton);
		clickBlank();
		return this;
	}

	public WorktopEditor verifyWorktopSplitNotPresent(int x, int y) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver, balloonHeader);
		Verification.VerifyNotEquals("Worktop Edge options are displayed",
				balloonHeader.getText().trim().replaceAll("\n\r", ""), "Edge options");
		UtilHBM.waitExplicitDisplayed(driver, changeGrainDirection);
		clickBlank();
		return this;
	}

	public WorktopEditor verifyWorktopEdgePresent(int x, int y) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver, balloonHeader);
		Verification.VerifyEquals("Worktop Edge options not displayed",
				balloonHeader.getText().trim().replaceAll("\n\r", ""), "Edge options");
		clickBlank();
		return this;
	}

	public WorktopEditor verifyStraightEdgePresent(int x, int y) {
		clickBlank();
		getBallon(x, y);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(balloonHeader));
			wait.until(ExpectedConditions.visibilityOf(addEdgeCutButton));
		} catch (TimeoutException | NoSuchElementException e) {
			UtilHBM.reportKO("Straight edge not visible after 10 sec of wait");
		}
		UtilHBM.turnOnImplicitWaits(driver);
		clickBlank();
		return this;
	}

	public WorktopEditor verifyRoundedEdgePresent(int x, int y) {
		clickBlank();
		getBallon(x, y);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(balloonHeader));
			wait.until(ExpectedConditions.visibilityOf(addEdgeCutButton));
			if (balloonHeader.isDisplayed())
				UtilHBM.reportKO("Straight efdge visible, following is visible :" + addEdgeCutButton.getText()
						+ ", Expected : this button not to be displayed  on a rounded edge.");
		} catch (TimeoutException | NoSuchElementException e) {
			UtilHBM.reportOK("Rounded edge is present, passed");
		}

		clickBlank();
		return this;
	}

	public WorktopEditor startAddingEdgeCut(int x, int y, String cutName) {
		clickBlank();
		getBallon(x, y);
		addEdgeCutButton.click();
		WebElement cut = driver
				.findElement(By.xpath("//ul[@role='tablist']/li/label/span[contains(text(),'" + cutName + "')]"));
		cut.click();
		return this;
	}

	public WorktopEditor setEdgeCutOptions(String edgeTripleValue1, String edgeTripleValue2, String edgeTripleValue3,
			String nonStraight, String edgeTripleValue4, String edgeTripleValue5, String edgeRoundedValue1,
			String edgeRoundedValue2) {
		if (!(edgeTripleValue1.isEmpty())) {

			UtilHBM.waitExplicitClickable(driver, edgeCutTripleValue1);
			edgeCutTripleValue1.click();
			edgeCutTripleValue1.clear();
			edgeCutTripleValue1.sendKeys(edgeTripleValue1, Keys.ENTER);
		}
		if (!(edgeTripleValue2.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, edgeCutTripleValue2);
			edgeCutTripleValue2.click();
			edgeCutTripleValue2.clear();
			edgeCutTripleValue2.sendKeys(edgeTripleValue2, Keys.ENTER);
		}
		if (!(edgeTripleValue3.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, edgeCutTripleValue3);
			edgeCutTripleValue3.click();
			edgeCutTripleValue3.clear();
			edgeCutTripleValue3.sendKeys(edgeTripleValue3, Keys.ENTER);
		}
		if (nonStraight.equalsIgnoreCase("yes")) {
			UtilHBM.waitExplicitClickable(driver, edgeCutMoreOptions);
			edgeCutMoreOptions.click();
			if (!(edgeTripleValue4.isEmpty())) {
				UtilHBM.waitExplicitClickable(driver, edgeCutTripleValue4);
				edgeCutTripleValue4.click();
				edgeCutTripleValue4.clear();
				edgeCutTripleValue4.sendKeys(edgeTripleValue4, Keys.ENTER);
			}
			if (!(edgeTripleValue5.isEmpty())) {
				UtilHBM.waitExplicitClickable(driver, edgeCutTripleValue5);
				edgeCutTripleValue5.click();
				edgeCutTripleValue5.clear();
				edgeCutTripleValue5.sendKeys(edgeTripleValue5, Keys.ENTER);
			}
		} else {
			UtilHBM.reportOK("Non straight line not checked");
		}

		if (!(edgeRoundedValue1.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, edgeCutRoundedValue1);
			edgeCutRoundedValue1.click();
			edgeCutRoundedValue1.clear();
			edgeCutRoundedValue1.sendKeys(edgeRoundedValue1, Keys.ENTER);
		}
		if (!(edgeRoundedValue2.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, edgeCutRoundedValue2);
			edgeCutRoundedValue2.click();
			edgeCutRoundedValue2.clear();
			edgeCutRoundedValue2.sendKeys(edgeRoundedValue2, Keys.ENTER);
		}

		return this;

	}

	public WorktopEditor verifyEdgeCutFieldsLinked() {
		UtilHBM.waitExplicitDisplayed(driver, "//fieldset[@id='edgecut-2']/div[@class='linked']/span[@class='link']");
		return this;
	}

	public WorktopEditor verifyEdgeCutValues(String edgeTripleValue1, String edgeTripleValue2, String edgeTripleValue3,
			String edgeRoundedValue1, String edgeRoundedValue2) {
		if (!(edgeTripleValue1.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, edgeCutTripleValue1);
			Verification.VerifyEquals("edgeCutTripleValue1 not as expected", edgeCutTripleValue1.getAttribute("value"),
					edgeTripleValue1);
		}
		if (!(edgeTripleValue2.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, edgeCutTripleValue2);
			Verification.VerifyEquals("edgeCutTripleValue2 not as expected", edgeCutTripleValue2.getAttribute("value"),
					edgeTripleValue2);
		}
		if (!(edgeTripleValue3.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, edgeCutTripleValue3);
			Verification.VerifyEquals("edgeCutTripleValue3 not as expected", edgeCutTripleValue3.getAttribute("value"),
					edgeTripleValue3);
		}

		if (!(edgeRoundedValue1.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, edgeCutRoundedValue1);
			Verification.VerifyEquals("edgeCutRoundedValue1 not as expected",
					edgeCutRoundedValue1.getAttribute("value"), edgeRoundedValue1);
		}
		if (!(edgeRoundedValue2.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, edgeCutRoundedValue2);
			Verification.VerifyEquals("edgeCutRoundedValue2 not as expected",
					edgeCutRoundedValue2.getAttribute("value"), edgeRoundedValue2);
		}

		return this;
	}

	public WorktopEditor clickToCreateEdgeCut() {
		UtilHBM.waitExplicitClickable(driver, createButton);
		createButton.sendKeys(Keys.ENTER);// to click on button
		UtilHBM.waitFixTime(2000);
		UtilHBM.reportOK("Edge cut created");
		return this;
	}

	public WorktopEditor verifyEdgeCutErrorMsg(String edgeTripleValue1, String edgeTripleValue2,
			String edgeTripleValue3, String edgeRoundedValue1, String edgeRoundedValue2) {
		if (!(edgeTripleValue1.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, edgeCutTripleValue1);
			String errMsg = edgeCutTripleValue1.findElement(By.xpath("./parent::span/b[@class='error']")).getText()
					.trim();
			Verification.VerifyEquals("edgeCutTripleValue1 not as expected", errMsg, edgeTripleValue1);
		}
		if (!(edgeTripleValue2.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, edgeCutTripleValue2);
			String errMsg = edgeCutTripleValue2.findElement(By.xpath("./parent::span/b[@class='error']")).getText()
					.trim();
			Verification.VerifyEquals("edgeCutTripleValue2 not as expected", errMsg, edgeTripleValue2);
		}
		if (!(edgeTripleValue3.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, edgeCutTripleValue3);
			String errMsg = edgeCutTripleValue3.findElement(By.xpath("./parent::span/b[@class='error']")).getText()
					.trim();
			Verification.VerifyEquals("edgeCutTripleValue3 not as expected", errMsg, edgeTripleValue3);
		}

		if (!(edgeRoundedValue1.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, edgeCutRoundedValue1);
			String errMsg = edgeCutRoundedValue1.findElement(By.xpath("./parent::span/b[@class='error']")).getText()
					.trim();
			Verification.VerifyEquals("edgeCutRoundedValue1 not as expected", errMsg, edgeRoundedValue1);
		}
		if (!(edgeRoundedValue2.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, edgeCutRoundedValue2);
			String errMsg = edgeCutRoundedValue2.findElement(By.xpath("./parent::span/b[@class='error']")).getText()
					.trim();
			Verification.VerifyEquals("edgeCutRoundedValue2 not as expected", errMsg, edgeRoundedValue2);
		}

		return this;
	}
	public WorktopEditor deleteWorktop(int x, int y) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver, deleteWorktop);
		UtilHBM.waitExplicitClickable(driver, deleteWorktop);
		deleteWorktop.click();
		clickBlank();
		return this;
	}
	public WorktopEditor verifyDeletedWorktopRestored(int x,int y) {
		clickBlank();
		getBallon(x, y);
		Verification.VerifyEquals("Deleted worktop not restored","Delete", deleteWorktop.getText());
		return this;
	}
	public WorktopEditor clickAndDrag(int xOffset, int yOffset) {
		UtilHBM.waitFixTime(2000);
		Actions action = new Actions(driver);
		action.moveToElement(container3D, 322, -319).clickAndHold().pause(500)
				.dragAndDropBy(container3D, 322+xOffset, -319+yOffset).release().build().perform();
		return this;
	}

}
