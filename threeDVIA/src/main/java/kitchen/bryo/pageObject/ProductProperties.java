package kitchen.bryo.pageObject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductProperties {
	WebDriver driver;

	public ProductProperties(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = ".mod-product-list>li[class='item-edit']>div>p>span[class='name']")
	private List<WebElement> itemEdit;

	@FindBy(css = ".mod-product-list>li[class='item-edit']>div>p>span[class='desc']")
	private List<WebElement> itemDesc;

	@FindBy(css = "ul>li>button>svg[class='icon-action-edit']")
	private WebElement edit;

	@FindBy(css = "#design-mod-properties-window-wide>ul")
	private List<WebElement> balloon;

	@FindBy(id = "bt-configurator")
	private WebElement customizeButton;

	@FindBy(css = "ul>li>button>svg[class='icon-action-edit']")
	private WebElement customiseEdit;

	@FindBy(css = "#mod-layer-cabinet-composer>div>header>div>div>h3[class='title']")
	private WebElement customiseInfo;

	@FindBy(id = "cancel-furniture-app")
	private WebElement cancelCustomize;

	@FindBy(id = "validate-furniture-app")
	private WebElement doneCustomize;

	@FindBy(css = "button[data-ui-action='product-option-replace']")
	private List<WebElement> replace;

	@FindBy(xpath = "//article[@class='edit-mod-panel']/header/ul/li/button/span[@class='icon-view-close']")
	private WebElement closeOptionsCatalog;

	@FindBy(xpath = "//article[@id='design-position-panel']/header/ul/li/button/span[@class='icon-view-close']")
	private WebElement closePositionPanel;

	@FindBy(xpath = "//article[@class='design-edit-panel']/header/ul/li/button/span[@class='icon-view-close']")
	private WebElement closeCatalog;

	@FindBy(css = "button[data-ui-action='panel-back']")
	private WebElement panelBack;

	@FindBy(css = "#catalogbrowser-content-inner>ul>li>article>img[srcset^='https://']")
	private List<WebElement> innerCatalogContent;

	@FindBy(xpath = "//input[@id='edit-form-input-angle']")
	private WebElement angleInput;

	@FindBy(xpath = "//li[@data-ui-publicationid='leftDepth']/fieldset/p/span[@class='form-select']")
	private WebElement leftDepthInput;

	@FindBy(css = "input[id='edit-form-input-leftWidth']")
	private WebElement leftWidthInput;

	@FindBy(xpath = "//li[@data-ui-publicationid='rightDepth']/fieldset/p/span[@class='form-select']")
	private WebElement rightDepthInput;

	@FindBy(css = "input[id='edit-form-input-rightWidth']")
	private WebElement rightWidthInput;

	@FindBy(id = "bmSVG")
	private WebElement container3D;

	@FindBy(xpath = "//label[contains(text(),'Straight filler')]/following-sibling::span/input")
	private List<WebElement> straightFiller;

	private String prdName, prdId = "";
	
	public ProductProperties replace(String propertyName, String product, String allOrSelected, boolean defaultStylePrd, String acceptDelCustModifications, String... resetCustomizedLinearAppSettingIsFalse) {
		WebElement op = driver.findElement(By.xpath("//span[contains(text(),'" + propertyName
				+ "')]/../following-sibling::div/button[@data-ui-action='product-option-replace']"));
		UtilHBM.waitFixTime(4000);
		UtilHBM.waitExplicitClickable(driver, op);
		op.sendKeys(Keys.ENTER);// to click the element as click function does
								// not work
		UtilHBM.waitFixTime(500);
		UtilHBM.turnOffImplicitWaits(driver);
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader>.content>span.spinner");
		UtilHBM.turnOnImplicitWaits(driver);
		
		UtilHBM.waitExplicitDisplayed(driver, innerCatalogContent.get(0));//img path 
				Catalog catalog = PageFactory.initElements(driver, Catalog.class);
				catalog.addProductProperty(propertyName, product, allOrSelected, defaultStylePrd,acceptDelCustModifications, resetCustomizedLinearAppSettingIsFalse);
				UtilHBM.waitFixTime(1000);
//				driver.findElement(By.cssSelector("button[data-ui-action='panel-back']")).click();
//				verifyReplace(propertyName, product);
		
		return this;
	}

	public ProductProperties replaceInCompose(String propertyName, String product,boolean productInfoSheet) {
		WebElement op = driver.findElement(By.xpath("//span[contains(text(),'" + propertyName
				+ "')]/../following-sibling::div/button[@data-ui-action='product-option-replace']"));
		UtilHBM.waitFixTime(4000);
		UtilHBM.waitExplicitClickable(driver, op);
		op.click();
		UtilHBM.waitFixTime(500);
		UtilHBM.turnOffImplicitWaits(driver);
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader>.content>span.spinner");
		UtilHBM.turnOnImplicitWaits(driver);
		
		UtilHBM.waitExplicitDisplayed(driver, innerCatalogContent.get(0));//img path 
				Catalog catalog = PageFactory.initElements(driver, Catalog.class);
				catalog.replaceProductInCompose(product,productInfoSheet);
				UtilHBM.waitFixTime(1000);
			
		return this;
	}

	public ProductProperties verifyReplace(String propertyName, String product) {
		WebElement prd;
		if (product.contains("|")) {
			System.out.println("product" + product);
			prdName = product.split("\\|")[0];
			prdId = product.split("\\|")[1];
			String regex = "(.)*(\\d)(.)*";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(prdId);
			boolean isMatched = matcher.matches();
			if (isMatched) {
		prd = driver.findElement(By.xpath("//p/span[contains(text(),'" + propertyName
				+ "')]/button[@data-ui-id='"+prdId+"']/../following-sibling::span[contains(text(),'"+prdName+"')]"));
		System.out.println("op " + prd.getText());
		new Actions(driver).moveToElement(prd).build().perform();
		if (prd.getText().equalsIgnoreCase(prdName)) {
			UtilHBM.reportOK("Replace verification for " + propertyName + " passed");
		} else {
			UtilHBM.reportKO("Replace verification for " + propertyName + "failed");
		}
			}else {
				prd = driver.findElement(By.xpath("//p/span/button[@data-ui-id='"+prdId+"']/../following-sibling::span[contains(text(),'"+prdName+"')]"));
			}
			}else
				prdName = product;
				prd = driver.findElement(By.xpath("//p/span[contains(text(),'" + propertyName
						+ "')]/following-sibling::span[contains(text(),'"+prdName+"')]"));
				if (prd.getText().equalsIgnoreCase(prdName)) {
					UtilHBM.reportOK("Replace verification for " + propertyName + " passed");
				} else {
					UtilHBM.reportKO("Replace verification for " + propertyName + "failed");
				}
		UtilHBM.waitFixTime(1000);
		return this;
	}
	public ProductProperties verifyCustomMaterial(String propertyName) {
		
		WebElement op = driver.findElement(By.xpath("//p/span[@class='name'][contains(text(),'"+propertyName+"')]"));
		if (op.getText().split("\\r?\\n")[0].equalsIgnoreCase(propertyName)) {
			UtilHBM.reportOK("Replace verification for " + propertyName + " passed");
		} else {
			UtilHBM.reportKO("Replace verification for " + propertyName + " failed");
		}
		UtilHBM.waitFixTime(1000);
		return this;
	}
	public ProductProperties add(String propertyName, String product, String allOrSelected, boolean defaultStylePrd) {
		WebElement op = driver.findElement(By.xpath("//span[contains(text(),'" + propertyName
				+ "')]/../following-sibling::div/button[@data-ui-action='product-option-add']"));
		UtilHBM.waitFixTime(4000);
//		new Actions(driver).moveToElement(op).sendKeys(Keys.ENTER);
		op.sendKeys(Keys.ENTER);// to click the element as click function does
								// not work
		UtilHBM.waitFixTime(500);
		UtilHBM.turnOffImplicitWaits(driver);
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader>.content>span.spinner");
		UtilHBM.turnOnImplicitWaits(driver);
		
		UtilHBM.waitExplicitDisplayed(driver, innerCatalogContent.get(0));//img path 
				Catalog catalog = PageFactory.initElements(driver, Catalog.class);
				catalog.addProductProperty(propertyName, product, allOrSelected, defaultStylePrd, "", "");				
				UtilHBM.waitFixTime(1000);
				driver.findElement(By.cssSelector("button[data-ui-action='panel-back']")).click();
	
//		} else {
//			if (driver.findElements(By.xpath(
//					"//article[@id='design-edit-panel']/div[@class='content']/div/ul/li/div/p/span[contains(text(),'"
//							+ propertyName
//							+ "')]/../following-sibling::div/button[@data-ui-action='product-option-delete']"))
//					.size() > 0) {
//
//				UtilHBM.reportInfo(propertyName + " : property is directly added");
//
//			} else {
//				UtilHBM.reportKO("Given property " + propertyName + " not added to the cabinet");
//			}
//		}
		return this;
	}
	public ProductProperties addDirectProperty(String propertyName, String product, String allOrSelected) {
		WebElement op = driver.findElement(By.xpath("//span[contains(text(),'" + propertyName
				+ "')]/../following-sibling::div/button[@data-ui-action='product-option-add']"));
		UtilHBM.waitFixTime(4000);
//		new Actions(driver).moveToElement(op).sendKeys(Keys.ENTER);
		op.sendKeys(Keys.ENTER);// to click the element as click function does
								// not work
		UtilHBM.waitFixTime(500);
	
		UtilHBM.waitExplicitDisplayed(driver, driver.findElements(By.xpath(
					"//article[@id='design-edit-panel']/div[@class='content']/div/ul/li/div/p/span[contains(text(),'"
							+ propertyName
							+ "')]/../following-sibling::div/button[@data-ui-action='product-option-delete']")).get(0)) ;

				UtilHBM.reportInfo(propertyName + " : property is directly added");

		return this;
	}
	public ProductProperties delete(String propertyName) {

		WebElement optionBtn = driver.findElement(By
				.xpath("//article[@id='design-edit-panel']/div[@class='content']/div/ul/li/div/p/span[contains(text(),'"
						+ propertyName
						+ "')]/../following-sibling::div/button[@data-ui-action='product-option-delete']"));
		UtilHBM.waitFixTime(4000);
		UtilHBM.waitExplicitClickable(driver, optionBtn);
		optionBtn.sendKeys(Keys.ENTER);// to click the element as click function
										// does not work
		return PageFactory.initElements(driver, ProductProperties.class);
	}

	public ProductProperties verifyDelete(String propertyName) {
		WebElement optionBtn = driver.findElement(By.xpath("//span[contains(text(),'" + propertyName
				+ "')]/../following-sibling::div/button[starts-with(@data-ui-action,'product-option-add')]"));
		if (optionBtn.isDisplayed()) {
			UtilHBM.reportOK("Property " + propertyName + " deleted successfully");
		} else
			UtilHBM.reportKO("Property " + propertyName + " not deleted");
		clickBlank();
		return this;
	}

	public ProductProperties togglePropertiesON(String propertyName1, String propertyName2) {

		WebElement toggleBtn = driver.findElement(
				By.xpath("//label[contains(text(),'" + propertyName1 + "')]/following-sibling::span/input"));
		new Actions(driver).moveToElement(customizeButton).build().perform();
		toggleBtn.click();
		List<WebElement> coverPanel = driver.findElements(By.xpath("//li[starts-with(@data-ui-publicationid,'"+propertyName2+"')]"));
		if (coverPanel.size() > 0) {
			UtilHBM.reportKO(propertyName2 + " :option available for cabinet");
		} else
			UtilHBM.reportOK(propertyName2 + " :cover panel option not available as straight filler piece is active");

		UtilHBM.waitFixTime(1500);
		return this;
	}

	public ProductProperties togglePropertiesOFF(String propertyName1, String propertyName2) {

		WebElement toggleBtn = driver.findElement(
				By.xpath("//label[contains(text(),'" + propertyName1 + "')]/following-sibling::span/input"));
		new Actions(driver).moveToElement(customizeButton).build().perform();
		toggleBtn.click();
			
			WebElement optionBtn = driver.findElement(By.xpath("//span[contains(text(),'" + propertyName2
					+ "')]/../following-sibling::div/button[starts-with(@data-ui-action,'product-option-delete')]"));
			Verification.displayOfWebElement(optionBtn);
		 

		return this;
	}

	public ProductProperties fillerProperties(String angle, String leftDepth, String leftWidth, String rightDepth,
			String rightWidth, String height){

		if (!(angle.isEmpty())) {
			for (int i = 0; i < angle.length(); i++) {
				angleInput.sendKeys(Keys.BACK_SPACE);
			}
			angleInput.sendKeys(angle);
			angleInput.sendKeys(Keys.ENTER);
		}
		if (!(leftDepth.isEmpty())) {
			leftDepthInput.click();
			leftDepthInput.findElement(By.xpath("//select[@id='edit-form-select-leftDepth']")).sendKeys(leftDepth);
			leftDepthInput.findElement(By.xpath("//select[@id='edit-form-select-leftDepth']")).sendKeys(Keys.ENTER);
		}
		if (!(leftWidth.isEmpty())) {
			for (int i = 0; i < leftWidth.length(); i++) {
				leftWidthInput.sendKeys(Keys.BACK_SPACE);
			}
			leftWidthInput.sendKeys(leftWidth);
			leftWidthInput.sendKeys(Keys.ENTER);
		}
		if (!(rightDepth.isEmpty())) {
			rightDepthInput.click();
			rightDepthInput.findElement(By.xpath("//select[@id='edit-form-select-rightDepth']")).sendKeys(rightDepth);
			rightDepthInput.findElement(By.xpath("//select[@id='edit-form-select-rightDepth']")).sendKeys(Keys.ENTER);
		}
		if (!(rightWidth.isEmpty())) {
			for (int i = 0; i < rightWidth.length(); i++) {
				rightWidthInput.sendKeys(Keys.BACK_SPACE);
			}
			rightWidthInput.sendKeys(rightWidth);
			rightWidthInput.sendKeys(Keys.ENTER);
		}

		return this;
	}

	public ProductProperties verifyFillerProperties(String angle, String leftDepth, String leftWidth, String rightDepth,
			String rightWidth, String height){

		if (angle.isEmpty()) {
			UtilHBM.reportOK("Angle property not available");
		} else if (!(angle.isEmpty())) {
			if (angle.equalsIgnoreCase(angleInput.getAttribute("value"))) {
				UtilHBM.reportOK("Angle property changed");
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Angle");
		}
		if (leftDepth.isEmpty()) {
			UtilHBM.reportOK("Left Depth property not available");
		} else if (!(leftDepth.isEmpty())) {

			if (leftDepth
					.equalsIgnoreCase(leftDepthInput.findElement(By.cssSelector(".label")).getText())) {
				UtilHBM.reportOK("Left Depth property changed");
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Left Depth");
		}

		if (leftWidth.isEmpty()) {
			UtilHBM.reportOK("Left Width property not available");
		} else if (!(leftWidth.isEmpty())) {
			if (leftWidth.equalsIgnoreCase(leftWidthInput.getAttribute("value"))) {
				UtilHBM.reportOK("Left Width property changed");
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Left Width");
		}

		if (rightDepth.isEmpty()) {
			UtilHBM.reportOK("Right Depth property not available");
		} else if (!(rightDepth.isEmpty())) {

			if (rightDepth
					.equalsIgnoreCase(rightDepthInput.findElement(By.cssSelector(".label")).getText())) {

				UtilHBM.reportOK("Right Depth property changed");
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Right Depth");
		}

		if (rightWidth.isEmpty()) {
			UtilHBM.reportOK("Right Width property not available");
		} else if (!(rightWidth.isEmpty())) {
			if (rightWidth.equalsIgnoreCase(rightWidthInput.getAttribute("value"))) {
				UtilHBM.reportOK("Right Width property changed");
			}
		} else {
			UtilHBM.reportKO("Property verification failed for Right Width");
		}

		return this;
	}

	public ProductProperties clickBlank() {
		UtilHBM.turnOffImplicitWaits(driver);
		int j = 0;
		while (balloon.size() > 0 && j < 10) {
			// UtilHBM.clickBlankSpaceIkea();
			Actions action = new Actions(driver);
			action.moveToElement(container3D, 361, -346).clickAndHold().pause(500).release().build().perform();
			j++;
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}

	public ProductProperties getBallon(int x, int y) {
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

	public ProductProperties closePositionPanel() {
		UtilHBM.waitExplicitDisplayed(driver, closePositionPanel);
		closePositionPanel.click();
		UtilHBM.waitFixTime(2000);
		return this;
	}

	public int getReplacementOptionsCount(String propertyName) {
		WebElement op = driver.findElement(By.xpath("//span[contains(text(),'" + propertyName
				+ "')]/../following-sibling::div/button[@data-ui-action='product-option-replace']"));
		UtilHBM.waitFixTime(4000);
		UtilHBM.waitExplicitClickable(driver, op);
		op.sendKeys(Keys.ENTER);// to click the element as click function does
		// not work
		UtilHBM.waitFixTime(500);
		UtilHBM.turnOffImplicitWaits(driver);
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader>.content>span.spinner");
		UtilHBM.turnOnImplicitWaits(driver);

		UtilHBM.waitExplicitDisplayed(driver, innerCatalogContent.get(0));//img path
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		return catalog.getReplacementCount();
	}
}
