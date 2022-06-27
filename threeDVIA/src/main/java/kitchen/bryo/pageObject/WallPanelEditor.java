package kitchen.bryo.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class WallPanelEditor {
	WebDriver driver;

	public WallPanelEditor(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "button[data-ui-action='addCutOut']")
	private WebElement addCutOut;

	@FindBy(css = "button[data-ui-action='deleteWallpanel']")
	private WebElement deleteWallpanel;
	
	@FindBy(id = "cutout-cutout-rectangle-val-1")
	private WebElement rectangleValue1;

	@FindBy(id = "cutout-cutout-rectangle-val-2")
	private WebElement rectangleValue2;

	@FindBy(css = ".mod-overlay-container.mod-open")
	private List<WebElement> balloon;

	@FindBy(css = "button[data-ui-action='removeJoint']")
	private WebElement removeJointButton;

	@FindBy(css = "button[data-ui-action='command-validate']")
	private WebElement validateWallPanelEditor;

	@FindBy(css = "button[data-ui-action='command-cancel']")
	private WebElement cancelWallPanelEditor;

	@FindBy(css = "button[data-ui-action='addJoint']")
	private WebElement addJointButton;

	@FindBy(css = "footer>button[class='cta-secondary-icon']")
	private WebElement deleteCuts;

	@FindBy(css = "input[class^='measure-input']")
	private List<WebElement> measureInputList;

	@FindBy(css = "input[class='measure-input']")
	private WebElement measureInput;

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

	@FindBy(css = "input[class='measure-input']")
	private List<WebElement> measureInputCutOut;

	@FindBy(css = "input[placeholder='Measure2D']")
	private List<WebElement> measure2D;

	@FindBy(css = "button[data-i18n='common.create']")
	private WebElement createButton;

	@FindBy(css = "button[data-ui-action='addTripleCut']")
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

	@FindBy(css = "span[class='icon-action-info']")
	private WebElement worktopEditorPrice;

	@FindBy(css = ".mod-popin-alert-price.mod-open>div>header>div>div>h3")
	private WebElement wallPanelPriceTitle;

	@FindBy(css = ".mod-popin-alert-price.mod-open>div>header>div>div>b")
	private WebElement wallPanelPriceInfo;

	@FindBy(css = ".mod-popin-alert-price.mod-open>div>div>div>div>p")
	private WebElement wallPanelPriceContent;

	@FindBy(xpath = "//article[@class='mod-popin-wall-panel-editor-small mod-open']/div/footer/div[@class='link']/button")
	private WebElement wallPanelLearnMoreLink;

	@FindBy(css = ".mod-popin-alert-price.mod-open>div>header>div>div>button[data-ui-action='popin-close']")
	private WebElement closeWallPanelPricePopUp;

	@FindBy(id = "btn-next-wall")
	private List<WebElement> nextWall;

	@FindBy(css = "h3[data-i18n='product_property_panel.wall_panel_options.compose_question']")
	private WebElement wallPanelEditorWindow;

	@FindBy(css = ".mod-popin-wall-panel-editor-small.mod-open>div")
	private List<WebElement> editWallPanelPopUp;

	@FindBy(css = ".inner-content>h1")
	private WebElement editWallPanelTitle;

	@FindBy(css = ".inner-content>.text>div>p")
	private WebElement editWallPanelMessage;

	@FindBy(css = ".popin-footer .cta-primary-alt-xl")
	private WebElement editWallPanelYes;

	@FindBy(id = "bmSVG")
	private WebElement container3D;

	@FindBy(css = "p[class='more-options']>label>input+span[class='state']")
	private WebElement cutOutMoreOptions;

	@FindBy(xpath = "//input[@id='cutout-cutout-rectangle-val-3']")
	private WebElement cutOutRadius;

	@FindBy(xpath = "//input[@id='cutout-cutout-circle-val-1']")
	private WebElement cutOutDiameter;

	@FindBy(xpath = "//form/ul/li/button[@data-ui-action='undo']/span[@class='icon-action-undo']")
	private WebElement undoButton;

	@FindBy(xpath = "//form/ul/li/button[@data-ui-action='redo']/span[@class='icon-action-redo']")
	private WebElement redoButton;

	@FindBy(id = "cornercut-simple-val-1")
	private WebElement cornerSimpleCutA;

	@FindBy(id = "cornercut-simple-val-2")
	private WebElement cornerSimpleCutB;

	@FindBy(id = "cornercut-double-val-1")
	private WebElement cornerDoubleCutA;

	@FindBy(id = "cornercut-double-val-2")
	private WebElement cornerDoubleCutB;
	
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

	@FindBy(xpath = "//button[@data-ui-action='priceInfo']")
	private WebElement priceInfoIcon;

	@FindBy(css = "button[data-ui-action='changeGrainDirection']")
	private WebElement changeGrainDirection;

	@FindBy(xpath = "//section[@class='mod-overlay mod-open']/div/ul/li/span/button[@data-ui-action='rotateFiberNext']")
	private WebElement changeGrainDirectionNext;

	@FindBy(xpath = "//section[@class='mod-overlay mod-open']/div/ul/li/span/button[@data-ui-action='rotateFiberPrevious']")
	private WebElement changeGrainDirectionPrevious;

	@FindBy(css = "button[data-ui-action='splitEdge']")
	private WebElement splitEdgeButton;

	@FindBy(css = "button[data-ui-action='changeEdgeProduct']")
	private WebElement changeEdgeProductButton;
	
	@FindBy(css = "button[data-ui-action='addEdgeProduct']")
	private WebElement addEdgeProductButton;

	@FindBy(css = "select[data-ui-action='edgeProduct']")
	private WebElement edgeProduct;
	 
	@FindBy (css =".bt-back .icon-action-arrow")
	private WebElement backBtnEdgePrd;
	
	@FindBy(xpath = "//span[@class='illustration']/img[starts-with(@src,'data:image/svg+xml;base64')]")
	private WebElement edgeSymbols;

	@FindBy(xpath = "//header/h3/span[contains(text(),'Edge Legend')]")
	private WebElement edgeLegendTitle;

	@FindBy(xpath = "//section[@data-ui-selector='edge-finish-section']/header/button[@data-ui-selector='toggler-btn']")
	private WebElement edgeLegendToggle;

	@FindBy(xpath = "//span[@class='illustration']/img[starts-with(@src,'data:image/svg+xml;base64, PHN2ZyBpZD0iTGF5ZXJfMSIgZGF0YS1uYW1lPSJMYXllciAxIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCA1OTUuMjggNTk1LjI4Ij48ZGVmcz48c3R5bGU+LmNscy0xe2ZpbGw6bm9uZTtzdHJva2U6IzAwMDtzdHJva2UtbGluZWNhcDpyb3VuZDtzdHJva2UtbGluZWpvaW46cm91bmQ7c3Ryb2tlLXdpZHRoOjEwcHg7fTwvc3R5bGU+PC9kZWZzPjx0aXRsZT5TeW1ib2xzPC90aXRsZT48bGluZSBjbGFzcz0iY2xzLTEiIHgxPSI1ODIuNyIgeTE9IjEzLjU0IiB4Mj0iMTUuNzciIHkyPSI1ODAuNDciLz48L3N2Zz4=')]")
	private List<WebElement> polishEdge;

	@FindBy(xpath = "//span[@class='illustration']/img[starts-with(@src,'data:image/svg+xml;base64, PHN2ZyBpZD0iTGF5ZXJfMSIgZGF0YS1uYW1lPSJMYXllciAxIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCA1OTUuMjggNTk1LjI4Ij48ZGVmcz48c3R5bGU+LmNscy0xe2ZpbGw6bm9uZTtzdHJva2U6IzAwMDtzdHJva2UtbGluZWNhcDpyb3VuZDtzdHJva2UtbGluZWpvaW46cm91bmQ7c3Ryb2tlLXdpZHRoOjEwcHg7fTwvc3R5bGU+PC9kZWZzPjx0aXRsZT5TeW1ib2xzPC90aXRsZT48bGluZSBjbGFzcz0iY2xzLTEiIHgxPSIxNC4xOCIgeTE9IjEzLjU0IiB4Mj0iNTgxLjEiIHkyPSI1ODAuNDciLz48bGluZSBjbGFzcz0iY2xzLTEiIHgxPSI1ODEuMSIgeTE9IjEzLjU0IiB4Mj0iNTgxLjEiIHkyPSI1ODAuNDciLz48bGluZSBjbGFzcz0iY2xzLTEiIHgxPSIxNC4xOCIgeTE9IjU4MC40NyIgeDI9IjE0LjE4IiB5Mj0iMTMuNTQiLz48L3N2Zz4=')]")
	private List<WebElement> unPolishEdge;

	@FindBy(xpath = "//figure[@id='edge-finish-content']/ul/li/span[contains(text(),'Polished')]")
	private WebElement polishEdgeLegend;

	@FindBy(xpath = "//figure[@id='edge-finish-content']/ul/li/span[contains(text(),'Unpolished')]")
	private WebElement unPolishEdgeLegend;

	@FindBy(css = "div[class='mod-overlay-container-legend mod-open']>div>section[data-ui-selector='wall-panel-types-section']>header>h3")
	private WebElement wallPanelTypeTitle;

	@FindBy(xpath = "//section[@data-ui-selector='wall-panel-types-section']/header/button[@data-ui-selector='toggler-btn']")
	private WebElement wallPanelTypeToggle;

	@FindBy(xpath = "//button[@data-ui-action='wall-panel-types-info']")
	private WebElement wallPanelTypeInfo;

	@FindBy(css = "figure[data-ui-selector='wall-panel-types-legend-list']>ul>li>span>svg[class='icon-worktop-custom']")
	private WebElement customPrecutSVG;

	@FindBy(css = "figure[data-ui-selector='wall-panel-types-legend-list']>ul>li>span>svg[class='icon-worktop-illustration']")
	private WebElement illustrationSVG;

	@FindBy(xpath = "//li/span/span[contains(text(),'Display edge symbols')]/../following-sibling::span/label/input[@name='front-displayer']")
	private WebElement displayEdgeSymbolsToggle;

	@FindBy(id = "zoom-in")
	private WebElement zoomIn;

	@FindBy(id = "zoom-out")
	private WebElement zoomOut;
	
	public WallPanelEditor toolTipsWallPanel() {
		Tooltips tips = PageFactory.initElements(driver, Tooltips.class);
		tips.tooltipsForWallPanelEditor();
		clickBlank();
		return this;
	}

	public WallPanelEditor wallPanelEditorPrice() {
		clickBlank();
		worktopEditorPrice.click();
		driver.switchTo().parentFrame();

		Verification.VerifyEquals("Price information title not displayed", wallPanelPriceTitle.getText(),
				"Price information");

		Verification.VerifyEquals("Price information not Displayed", wallPanelPriceInfo.getText(),
				"What is included in your wall panel price?");
		Verification.VerifyEquals("Price information content Not Displayed", wallPanelPriceContent.getText(),
				"For precut wall panels, the price only includes the boards and joints.\nFor custom made wall panels, the price includes all operations needed to manufactured your wall panel as you designed it.");
		;
//		Verification.VerifyEquals("Learn more link Not Displayed", wallPanelLearnMoreLink.getText(),
//				"Learn more about wall panel types");
		closeWallPanelPricePopUp.click();
		List<WebElement> frames = driver.findElements(By.cssSelector("#iframeContainer>iframe"));
		driver.switchTo().frame(frames.get(0));
		return this;
	}

	public WallPanelEditor createCutOutForWallPanel(int x, int y, String cutOutType, String rectValue1,
			String rectValue2, String roundedCorners, String radius, String diameter) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver, addCutOut);
		UtilHBM.waitExplicitClickable(driver, addCutOut);
		addCutOut.click();
		WebElement cut = null;
		if(cutOutType.equalsIgnoreCase("Rectangle")) {
			cut=driver.findElement(By.xpath("//ul[@role='tablist']/li/label/span[@data-i18n='kitchen.worktop_editor.cut_out_overlay.rectangle;planner.worktop_editor.cut_out_overlay.rectangle']"));
		}else if(cutOutType.equalsIgnoreCase("Circle")){
			cut=driver.findElement(By.xpath("//ul[@role='tablist']/li/label/span[@data-i18n='kitchen.worktop_editor.cut_out_overlay.circle;planner.worktop_editor.cut_out_overlay.circle']"));
		}
		cut.click();
		
		if (!(rectValue1.isEmpty())) {

			UtilHBM.waitExplicitClickable(driver, rectangleValue1);
			rectangleValue1.click();
			rectangleValue1.clear();
			rectangleValue1.sendKeys(rectValue1);
		}
		if (!(rectValue2.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, rectangleValue2);
			rectangleValue2.click();
			rectangleValue2.clear();
			rectangleValue2.sendKeys(rectValue2);
		}
		if (roundedCorners.equalsIgnoreCase("yes")) {
			UtilHBM.waitFixTime(500);
			UtilHBM.waitExplicitClickable(driver, cutOutMoreOptions);
			new Actions(driver).moveToElement(cutOutMoreOptions).click().perform();
			if (!(radius.isEmpty())) {
				UtilHBM.waitExplicitClickable(driver, cutOutRadius);
				cutOutRadius.click();
				cutOutRadius.clear();
				cutOutRadius.sendKeys(radius);
			}

		}
		if (!(diameter.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, cutOutDiameter);
			cutOutDiameter.click();
			cutOutDiameter.clear();
			cutOutDiameter.sendKeys(diameter);
		}
		clickBlank();
		return this;
	}

	public WallPanelEditor cornerCutForWallPanel(int x, int y, String cutType, String cornerSimpleA, String cornerSimpleB,
			String cornerDoubleA, String cornerDoubleB, String nonStraight, String cornerX, String cornerY) {
		clickBlank();
//		new Actions(driver).moveByOffset(x, y).build().perform();
		getBallon(x, y);

		addCornerCut.click();
		WebElement cut = driver
				.findElement(By.xpath("//ul[@role='tablist']/li/label/span[contains(text(),'" + cutType + "')]"));
		cut.click();
		if (!(cornerSimpleA.isEmpty())) {

			UtilHBM.waitExplicitClickable(driver, cornerSimpleCutA);
			cornerSimpleCutA.click();
			cornerSimpleCutA.clear();
			cornerSimpleCutA.sendKeys(cornerSimpleA);
		}
		if (!(cornerSimpleB.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, cornerSimpleCutB);
			cornerSimpleCutB.click();
			cornerSimpleCutB.clear();
			cornerSimpleCutB.sendKeys(cornerSimpleB);
		}
		if (!(cornerDoubleA.isEmpty())) {

			UtilHBM.waitExplicitClickable(driver, cornerDoubleCutA);
			cornerDoubleCutA.click();
			cornerDoubleCutA.clear();
			cornerDoubleCutA.sendKeys(cornerDoubleA);
		}
		if (!(cornerDoubleB.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, cornerDoubleCutB);
			cornerDoubleCutB.click();
			cornerDoubleCutB.clear();
			cornerDoubleCutB.sendKeys(cornerDoubleB);
		}
		if (nonStraight.equalsIgnoreCase("yes")) {
			UtilHBM.waitExplicitClickable(driver, nonStraightCornerCut);
			new Actions(driver).moveToElement(nonStraightCornerCut).build().perform();
			new Actions(driver).moveToElement(nonStraightCornerCut).clickAndHold().pause(500).release().build()
					.perform();

			if (!(cornerX.isEmpty())) {
				UtilHBM.waitExplicitClickable(driver, cornerCutX);
				cornerCutX.click();
				cornerCutX.clear();
				cornerCutX.sendKeys(cornerX);
			}
			if (!(cornerY.isEmpty())) {
				UtilHBM.waitExplicitClickable(driver, cornerCutY);
				cornerCutY.click();
				cornerCutY.clear();
				cornerCutY.sendKeys(cornerY);
			}
		} else {
			UtilHBM.reportOK("Non straight line not checked");
		}

		createButton.sendKeys(Keys.ENTER);
		UtilHBM.waitFixTime(2000);
		return this;
	}

	public WallPanelEditor verifyCornerCutForWallPanel(int x, int y, String dim1) {
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
		return this;
	}

	public WallPanelEditor verifyCutOutForWallPanel(int x, int y, String rectValue1, String rectValue2, String radius,
			String diameter, String dim1, String dim2) {

		clickBlank();
		getBallon(x, y);
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

		System.out.println("In verification step");
		if (rectValue1.isEmpty() && rectValue2.isEmpty() && radius.isEmpty() && diameter.isEmpty()) {
			UtilHBM.reportInfo("Properties not available for verification");
		} else if (!(rectValue1.isEmpty() || rectValue2.isEmpty() || radius.isEmpty())) {

			if ((rectValue1.equalsIgnoreCase(rectangleValue1.getAttribute("value")))
					&& (rectValue2.equalsIgnoreCase(rectangleValue2.getAttribute("value"))
							&& radius.equalsIgnoreCase(cutOutRadius.getAttribute("value")))) {
				UtilHBM.reportOK("Rectangle cut-out Properties verification passed");
			} else {
				UtilHBM.reportKO("Rectangle cut-out Properties verification failed");
			}
		}
		if (!(diameter.isEmpty())) {

			if ((diameter.equalsIgnoreCase(cutOutDiameter.getAttribute("value")))) {
				UtilHBM.reportOK("Circle cut-out Properties verification passed");
			} else {
				UtilHBM.reportKO("Circle cut-out Properties verification failed");
			}
		}
		return this;
	}

	public WallPanelEditor deleteCutOrCutOuts(int x, int y) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitFixTime(2000);
		deleteCuts.click();
		return this;
	}

	public WallPanelEditor verifyDeletedCutOrCutOut(int x, int y) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//div[@class='mod-overlay-container mod-open']")));
		if (!addCutOut.isDisplayed()) {
			UtilHBM.reportKO("Verification for delete cut-out failed");
		} else {
			UtilHBM.reportOK("Verification for delete cut-out passed");
		}

		return this;
	}

	public WallPanelEditor verifyPriceInWallPanel(String price) {
		if(price.equalsIgnoreCase("Price is not available")){
			WebElement displayedText = driver.findElement(By.cssSelector("span.standard-price[data-ui='regular-price']"));
			if(displayedText.getText().equals("Price is not available"))
				UtilHBM.reportOK("Expected text displayed : "+displayedText.getText());
			else UtilHBM.reportKO("Expected text : " + price + " , Actual Text : " + displayedText.getText());

		}else if (!price.isEmpty()) {
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
				UtilHBM.reportOK("Price same as displayed price:" + p1);
			} else {
				UtilHBM.reportKO("Expected price" + price + " not same as actual price:" + p1);
			}

		}
		if (priceInfoIcon.isEnabled()) {
			if (!(price.equalsIgnoreCase("Price is not available") || price.isEmpty())) {
				UtilHBM.waitExplicitDisplayed(driver, priceInfoIcon);
				UtilHBM.waitExplicitClickable(driver, priceInfoIcon);
				new Actions(driver).moveToElement(priceInfoIcon).build().perform();
				priceInfoIcon.click();
				Price p = PageFactory.initElements(driver, Price.class);
				p.priceInfoInEditors();
			}
		}
		return PageFactory.initElements(driver, WallPanelEditor.class);
	}

	public WallPanelEditor editWallPanelYes() {
		
			String titleText = "Edit wall panel";
			String message = "Please make sure you choose your preferred wall panel before editing it. Your modifications will only be priced for custom wall panels.";
			UtilHBM.waitExplicitDisplayed(driver, editWallPanelPopUp.get(0));
			Verification.displayNAttributeCheckOfElement(editWallPanelTitle, "Edit Overlay Title", "text", titleText);
			Verification.displayNAttributeCheckOfElement(editWallPanelMessage, "Edit Overlay Message", "text", message);
//			Verification.VerifyEquals("Learn more link Not Displayed", wallPanelLearnMoreLink.getText(),
//					"Learn more about wall panel types");
			editWallPanelYes.click();
	
		return PageFactory.initElements(driver, WallPanelEditor.class);
	}

	public WallPanelEditor verifyWallPanelHeight(int x, int y, String dim) {
		clickBlank();
		getBallon(x, y);
		int index = 0;
		for (WebElement image : measure2D) {
			System.out.println("value " + image.getAttribute("value"));
			if (dim.equalsIgnoreCase(image.getAttribute("value"))) {
				index++;
				System.out.println("index");
			}
		}
		if (index != 0) {
			UtilHBM.reportOK(
					"Wall panel height changed and number of dimensions with value  " + dim + " are  " + index);
		} else {
			UtilHBM.reportKO(
					"Wall panel height not changed and number of dimensions with value  " + dim + " are  " + index);
		}
		return PageFactory.initElements(driver, WallPanelEditor.class);
	}

	public WallPanelEditor addWallPanelJoint(int x, int y, String dim) {
		clickBlank();
		getBallon(x, y);
		addJointButton.click();
		UtilHBM.waitExplicitDisplayed(driver, measureInputCutOut.get(0));
		int index = 0;
		for (WebElement ele : measureInputCutOut) {
			if (dim.equalsIgnoreCase(ele.getAttribute("value"))) {
				index++;
			}

		}
		if (index > 0) {
			UtilHBM.reportOK("Number of dimensions for split wall panel joint with value  " + dim + " are  " + index);
			if (index == 2) {
				UtilHBM.reportOK("Joint added succesfully");
			}
		}
		return this;
	}

	public WallPanelEditor verifyWallPanelJoint(int x, int y, String dim) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver, measure2D.get(0));
		int i = 0;
		for (WebElement ele : measure2D) {
			if (ele.getAttribute("value").equalsIgnoreCase(dim)) {
				i++;
			}
		}
		if (i > 0) {
			UtilHBM.reportOK("Number of dimensions for joint with value  " + dim + "are  " + i);
		}
		return this;
	}

	public WallPanelEditor removeJointForWallPanel(int x, int y) {
		getBallon(x, y);
		removeJointButton.click();
		return this;
	}

	public WallPanelEditor verifyWallPanelRemoveJoint(int x, int y, String dim) {
		clickBlank();
		getBallon(x, y);
		int i = 0;
		if (measureInput.getAttribute("value").equalsIgnoreCase(dim)) {
			i++;
		}
		if (i == 0) {
			UtilHBM.reportOK("Joint removed successfully and number of dimension with value  " + dim + "are  " + i);
		}
		return this;
	}

	public MakeItYours validateWallPanelEditor() {
		UtilHBM.waitExplicitDisplayed(driver, validateWallPanelEditor);
		UtilHBM.waitExplicitClickable(driver, validateWallPanelEditor);
		validateWallPanelEditor.click();
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public WallPanelEditor addSplit(int x, int y) {
		clickBlank();
		getBallon(x, y);
		splitEdgeButton.click();
		UtilHBM.reportOK("Split created");
		UtilHBM.waitFixTime(500);
		clickBlank();
		return this;
	}

	public MakeItYours cancelWallPanelEditor() {
		cancelWallPanelEditor.click();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public WallPanelEditor addWallPanelEdgeCut(int x, int y, String edgeTripleValue1, String edgeTripleValue2,
			String edgeTripleValue3, String nonStraight, String edgeTripleValue4, String edgeTripleValue5) {
		clickBlank();
		getBallon(x, y);

		addEdgeCutButton.click();
		if (!(edgeTripleValue1.isEmpty())) {

			UtilHBM.waitExplicitClickable(driver, edgeCutTripleValue1);
			edgeCutTripleValue1.click();
			edgeCutTripleValue1.clear();
			edgeCutTripleValue1.sendKeys(edgeTripleValue1);
		}
		if (!(edgeTripleValue2.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, edgeCutTripleValue2);
			edgeCutTripleValue2.click();
			edgeCutTripleValue2.clear();
			edgeCutTripleValue2.sendKeys(edgeTripleValue2);
		}
		if (!(edgeTripleValue3.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, edgeCutTripleValue3);
			edgeCutTripleValue3.click();
			edgeCutTripleValue3.clear();
			edgeCutTripleValue3.sendKeys(edgeTripleValue3);
		}
		if (nonStraight.equalsIgnoreCase("yes")) {
			UtilHBM.waitExplicitClickable(driver, edgeCutMoreOptions);
			edgeCutMoreOptions.click();

			if (!(edgeTripleValue4.isEmpty())) {
				UtilHBM.waitExplicitClickable(driver, edgeCutTripleValue4);
				edgeCutTripleValue4.click();
				edgeCutTripleValue4.clear();
				edgeCutTripleValue4.sendKeys(edgeTripleValue4);
			}
			if (!(edgeTripleValue5.isEmpty())) {
				UtilHBM.waitExplicitClickable(driver, edgeCutTripleValue5);
				edgeCutTripleValue5.click();
				edgeCutTripleValue5.clear();
				edgeCutTripleValue5.sendKeys(edgeTripleValue5);
			}
		} else {
			UtilHBM.reportOK("Non straight line not checked");
		}

		createButton.sendKeys(Keys.ENTER);
		UtilHBM.waitFixTime(2000);
		UtilHBM.reportOK("Edge cut created");
		return this;
	}

	public WallPanelEditor verifyWallPanelEdgeCut(int x, int y, String dim) {
		clickBlank();
		getBallon(x, y);
		int index = 0;
		for (WebElement image : measure2D) {
			if (dim.equalsIgnoreCase(image.getAttribute("value"))) {
				index++;
			}

		}
		if (index > 0) {
			UtilHBM.reportOK("Number of dimensions for edge cut with value  " + dim + " are  " + index);

		}
		return this;
	}

	public WallPanelEditor editWallPanelDimension(int x, int y, String dimToChange, String dim,
			String applyAboveBelowLeftRight) {
		clickBlank();
		getBallon(x, y);
		for (WebElement index : measureInputList) {
			if (dimToChange.equalsIgnoreCase(index.getAttribute("value"))) {
				System.out.println("i2 " + index.getAttribute("value"));
				WebElement inputEdit = index
						.findElement(By.xpath("following-sibling::div/input[@class='measure-edit-input']"));
				System.out.println("input-edit :" + inputEdit.getAttribute("value"));
				new Actions(driver).moveToElement(index).click().build().perform();
				UtilHBM.waitFixTime(100);
				System.out.println("value :" + measureInputEdit.getAttribute("value").length());
				Actions builder = new Actions(driver);
				builder.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
				builder.sendKeys(Keys.DELETE);
				new Actions(driver).moveToElement(measureInputEdit).sendKeys(dim).build().perform();

				break;
			}
		}

		if (applyAboveBelowLeftRight.contains("above")) {
			applyAbove.click();
		} else if (applyAboveBelowLeftRight.contains("below")) {
			applyBelow.click();
		} else if (applyAboveBelowLeftRight.contains("left")) {
			applyLeft.click();
		} else {
			applyRight.click();
		}
		return PageFactory.initElements(driver, WallPanelEditor.class);
	}

	public WallPanelEditor verifyWallPanelDimension(int x, int y, String dim) {
		clickBlank();

		getBallon(x, y);
		measureInput.click();
		if (dim.isEmpty()) {
			UtilHBM.reportOK("Wall panel Dimension not available");
		} else if (!(dim.isEmpty())) {
			if (dim.equalsIgnoreCase(measureInputEdit.getAttribute("value"))) {
				UtilHBM.reportOK("Wall panel Dimension changed");
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Wall panel Dimension");
		}

		return this;
	}
	public WallPanelEditor editWallPanelCutOutDimension(int x, int y, String dimToChange, String dim) {
		clickBlank();
		getBallon(x, y);
		for (WebElement index : measureInputList) {
			if (dimToChange.equalsIgnoreCase(index.getAttribute("value"))) {
				System.out.println("i2 " + index.getAttribute("value"));
				WebElement inputEdit = index
						.findElement(By.xpath("following-sibling::div/input[@class='measure-edit-input']"));
				System.out.println("input-edit :" + inputEdit.getAttribute("value"));
				new Actions(driver).moveToElement(index).click().build().perform();
				UtilHBM.waitFixTime(100);
				inputEdit.sendKeys(dim+Keys.ENTER);
				break;
			}
		}

		return PageFactory.initElements(driver, WallPanelEditor.class);
	}
	public WallPanelEditor switchWallPanelLayer(int x, int y, String wallPanelLength) {
		if (nextWall.size() > 0) {
			if (nextWall.get(0).isDisplayed() && nextWall.get(0).isEnabled()) {
				nextWall.get(0).click();
				clickBlank();
				getBallon(x, y);
				if (wallPanelLength.equalsIgnoreCase(measureInput.getAttribute("value"))) {
					UtilHBM.reportOK(
							"Wall panel layer switched and wall panel length is " + measureInput.getAttribute("value"));
				}
				else UtilHBM.reportKO(
						"Wall panel layer switched and wall panel length is " + measureInput.getAttribute("value") + " , Expected : "+wallPanelLength);
			}
		}

		return this;
	}

	public WallPanelEditor checkBusinessRuleInWallPanel(String rule) {
		BusinessRules rules = PageFactory.initElements(driver, BusinessRules.class);
		rules.openCloseHelpCenter().checkBusinessRuleShowIn2DWallPanel(rule, "");
		return PageFactory.initElements(driver, WallPanelEditor.class);
	}

	public WallPanelEditor checkBusinessRuleInWallPanel(String rule, String desc) {
		BusinessRules rules = PageFactory.initElements(driver, BusinessRules.class);
		rules.openCloseHelpCenter().checkBusinessRuleShowIn2DWallPanel(rule, desc);
		return PageFactory.initElements(driver, WallPanelEditor.class);
	}

	public WallPanelEditor verifyBusinessRuleInWallPanelRemoved(String rule) {
		BusinessRules rules = PageFactory.initElements(driver, BusinessRules.class);
		rules.openCloseHelpCenter().wallPanelEditorBusinessRuleRemoved(rule);
		return PageFactory.initElements(driver, WallPanelEditor.class);
	}

	public WallPanelEditor clickBlank() {
		UtilHBM.turnOffImplicitWaits(driver);
		int j = 0;
		while (balloon.size() > 0 && j < 10) {
			Actions action = new Actions(driver);
			action.moveToElement(container3D, 322, -319).clickAndHold().pause(500).release().build().perform();
			j++;
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}

	WallPanelEditor selectProduct(int xcoordinate, int ycoordinate) {
		Actions actions = new Actions(driver);
		actions.moveToElement(container3D, xcoordinate, ycoordinate).clickAndHold().pause(500).release().build()
				.perform();
		return PageFactory.initElements(driver, WallPanelEditor.class);
	}

	public WallPanelEditor moveCutOut(int initialxcoordinate, int intialycoordinate, int finalxcoordinate,
			int finalycoordinate) {
		clickBlank();
		UtilHBM.waitFixTime(2000);
		Actions action = new Actions(driver);
		action.moveToElement(container3D, initialxcoordinate, intialycoordinate).clickAndHold().pause(1000)
		.moveToElement(container3D, finalxcoordinate, finalycoordinate).pause(1000).release().build().perform();
//		action.moveToElement(container3D, initialxcoordinate, intialycoordinate).clickAndHold().pause(1000)
//				.dragAndDropBy(container3D, finalxcoordinate, finalycoordinate).pause(1000).release().build().perform();
		clickBlank();
		return PageFactory.initElements(driver, WallPanelEditor.class);
	}
	public WallPanelEditor dragWallPanel(int initialxcoordinate, int intialycoordinate, int finalxcoordinate,
			int finalycoordinate) {
		clickBlank();
		UtilHBM.waitFixTime(2000);
		Actions action = new Actions(driver);
		action.moveToElement(container3D, initialxcoordinate, intialycoordinate).clickAndHold().pause(1000)
		.dragAndDropBy(container3D, finalxcoordinate, finalycoordinate).pause(1000).release().build().perform();
		clickBlank();
		return PageFactory.initElements(driver, WallPanelEditor.class);
	}
	public WallPanelEditor dragJoint(int initialxcoordinate, int intialycoordinate, int finalxcoordinate,
			int finalycoordinate) {
		clickBlank();
		UtilHBM.waitFixTime(2000);
		Actions action = new Actions(driver);
		action.moveToElement(container3D, initialxcoordinate, intialycoordinate).clickAndHold().pause(1000)
		.dragAndDropBy(container3D, finalxcoordinate, finalycoordinate).pause(1000).release().build().perform();
		clickBlank();
		return PageFactory.initElements(driver, WallPanelEditor.class);
	}
	public WallPanelEditor getBallon(int x, int y) {
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

	public WallPanelEditor undoInWallPanelEditor(WebDriver driver, int number) {
		clickBlank();
		for (int i = 0; i < number; i++) {
			undoButton.click();
		}
		return PageFactory.initElements(driver, WallPanelEditor.class);
	}

	public WallPanelEditor redoInWallPanelEditor(WebDriver driver, int number) {
		for (int i = 0; i < number; i++) {

			redoButton.click();
		}
		return PageFactory.initElements(driver, WallPanelEditor.class);
	}

	public WallPanelEditor changeGrainDirection(int x, int y) {
		clickBlank();
		getBallon(x, y);
		changeGrainDirection.click();
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitDisplayed(driver, changeGrainDirectionNext);
		Verification.displayOfWebElement(driver.findElement(By.xpath("//button[@data-ui-action='overlay-close']")));
		Verification.displayOfWebElement(
				driver.findElement(By.cssSelector("div[class='mod-overlay-container mod-open']>div>section[class='mod-overlay mod-open']>header>h3")));
		Verification.VerifyEquals("Change grain direction title not correct",
				driver.findElement(By.cssSelector("div[class='mod-overlay-container mod-open']>div>section[class='mod-overlay mod-open']>header>h3")).getText(),
				"Change grain direction");
		Verification.displayOfWebElement(changeGrainDirectionNext);
		Verification.displayOfWebElement(changeGrainDirectionPrevious);
		changeGrainDirectionNext.click();
		clickBlank();
		return this;
	}
	
	public WallPanelEditor changeEdgeProduct(int x, int y, String edgeReference) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitExplicitClickable(driver, changeEdgeProductButton);
		changeEdgeProductButton.click();
		UtilHBM.waitExplicitDisplayed(driver, backBtnEdgePrd);
		UtilHBM.waitFixTime(200);
		Select oSelect = new Select(edgeProduct);
		oSelect.selectByVisibleText(edgeReference);	
		return this;
		
	}
	
	public WallPanelEditor addEdgeProduct(int x, int y, String edgeReference) {
		UtilHBM.waitFixTime(20);
		clickBlank();
		getBallon(x, y);
		if (!edgeReference.isEmpty()) {
			if (addEdgeProductButton.isDisplayed()) {
				UtilHBM.waitExplicitClickable(driver, addEdgeProductButton);
				addEdgeProductButton.click();
				UtilHBM.waitFixTime(500);
				UtilHBM.waitExplicitDisplayed(driver, "//h3[text()='Edge material reference']");
				Select oSelect = new Select(edgeProduct);
				oSelect.selectByVisibleText(edgeReference);
			}
		UtilHBM.reportOK(" edge product added for edge having choose a reference/no edge edge product is "+edgeReference+"");
		}
		return this;
		
		
	}

	public WallPanelEditor verifyEdgeSymbol(int polishCount, int unPolishCount) {
		Verification.displayOfWebElement(edgeSymbols);
		Verification.displayOfWebElement(edgeLegendTitle);
		Verification.displayOfWebElement(edgeLegendToggle);
		edgeLegendToggle.click();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath(
				"//header[@class='mod-togglable-section-toggler active'][@aria-controls='edge-finish-legend-list']/following-sibling::div/figure[@aria-hidden='false']")));
		UtilHBM.turnOffImplicitWaits(driver);
		if (polishCount == 0 && unPolishCount == 0) {
			UtilHBM.reportKO("Edge symbols not displayed on wall panel");
		}
		if (polishCount == polishEdge.size()) {
			UtilHBM.reportOK("Correct number of polish edge symbols displayed and count is " + polishEdge.size());
		}
		if (unPolishCount == unPolishEdge.size()) {
			UtilHBM.reportOK("Correct number of unpolish symbols displayed and count is " + unPolishEdge.size());
		}
		if (driver.findElement(By.xpath("//input[@name='front-displayer'][@checked]")).isDisplayed()) {
			Verification.displayOfWebElement(edgeLegendTitle);

		}

		verifyEdgeLegend(polishCount, unPolishCount);
		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}

	public WallPanelEditor verifyEdgeLegend(int polishCount, int unPolishCount) {

		if (polishCount > 0) {
			Verification.displayOfWebElement(polishEdge.get(0));
			Verification.displayOfWebElement(polishEdgeLegend);
		}
		if (unPolishCount > 0) {
			Verification.displayOfWebElement(unPolishEdge.get(0));
			Verification.displayOfWebElement(unPolishEdgeLegend);
		}

		driver.findElement(By.xpath("//div[@id='canvas-tools-options']")).click();
		UtilHBM.waitFixTime(200);
		displayEdgeSymbolsToggle.click();
		UtilHBM.waitFixTime(200);
		UtilHBM.turnOffImplicitWaits(driver);
		if (polishEdge.size() == 0 && unPolishEdge.size() == 0) {
			UtilHBM.reportOK("Display edge symbols OFF, hides edge symbols and edge legend");
		} else
			UtilHBM.reportKO("Display edge symbols OFF,does not hide edge symbols and edge legend");

		UtilHBM.waitFixTime(200);
		displayEdgeSymbolsToggle.click();
		UtilHBM.waitFixTime(200);
		if (polishEdge.size() > 00 || unPolishEdge.size() > 0 && edgeLegendTitle.isDisplayed()) {
			UtilHBM.reportOK("Display edge symbols ON, displays edge symbols and edge legend");
		} else
			UtilHBM.reportKO("Display edge symbols ON,does not display edge symbols and edge legend");
		UtilHBM.turnOnImplicitWaits(driver);
		edgeLegendToggle.click();
		
		return this;

	}

	public WallPanelEditor verifyWallPanelTypes(String customType, String illustrationType) {
		Verification.displayOfWebElement(wallPanelTypeTitle);
		Verification.displayOfWebElement(wallPanelTypeToggle);
		Verification.displayOfWebElement(wallPanelTypeInfo);
		wallPanelTypeInfo.click();
		WallPanelAndWorktopTypes info = PageFactory.initElements(driver, WallPanelAndWorktopTypes.class);
		info.worktopTypeInfo();
		wallPanelTypeToggle.click();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath(
				"//header[@class='mod-togglable-section-toggler active'][@aria-controls='wall-panel-types-legend-list']/following-sibling::div/figure[@aria-hidden='false']")));
		if (!customType.isEmpty()) {
			WebElement type=driver.findElement(By.xpath("//figure[@data-ui-selector='wall-panel-types-legend-list']/ul/li/span[contains(text(),'"+customType+"')]"));
			if (customType.equalsIgnoreCase(type.getText())) {
				Verification.displayOfWebElement(customPrecutSVG);
				Verification.displayOfWebElement(type);
			}
		}
		if (!illustrationType.isEmpty()) {
			WebElement type=driver.findElement(By.xpath("//figure[@data-ui-selector='wall-panel-types-legend-list']/ul/li/span[contains(text(),'"+illustrationType+"')]"));
			if (illustrationType.equalsIgnoreCase(type.getText())) {
				Verification.displayOfWebElement(illustrationSVG);
				Verification.displayOfWebElement(type);
			}

		} else
			UtilHBM.reportKO("Wall Panel type not displayed in wall panel editor");

		return this;
	}
	public WallPanelEditor zoomIn(int zoomIncount) {
		for (int i = 1; i <= zoomIncount; i++) {
			zoomIn.click();
			UtilHBM.waitFixTime(500);

		}
		return this;
	}

	public WallPanelEditor zoomOut(int zoomOutcount) {
		for (int i = 1; i <= zoomOutcount; i++) {
			zoomOut.click();
			UtilHBM.waitFixTime(500);

		}
		return this;
	}
	public WallPanelEditor deleteWallpanel(int x, int y) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver, deleteWallpanel);
		UtilHBM.waitExplicitClickable(driver, deleteWallpanel);
		Verification.displayOfWebElement(driver.findElement(By.xpath("//li/span[contains(text(),'Delete wall panel')]")));
		deleteWallpanel.click();
		clickBlank();
		return this;
	}
	public WallPanelEditor verifyDeletedWallpanelRestored(int x,int y) {
		clickBlank();
		getBallon(x, y);
		Verification.VerifyEquals("Deleted wall panel not restored","Delete", deleteWallpanel.getText());
		return this;
	}
	public WallPanelEditor clickAndDrag(int xOffset, int yOffset) {
		UtilHBM.waitFixTime(2000);
		try {
			Actions action = new Actions(driver);
			action.moveToElement(container3D, 322, -319).clickAndHold().pause(500)
					.dragAndDropBy(container3D, 322+xOffset, -319+yOffset).release().build().perform();
		} catch (MoveTargetOutOfBoundsException e) {
			if (xOffset < 50 && yOffset < 50) return this;
			clickAndDrag(xOffset / 2, yOffset / 2);
			clickAndDrag(xOffset / 2, yOffset / 2);
		}
		return this;
	}

}
