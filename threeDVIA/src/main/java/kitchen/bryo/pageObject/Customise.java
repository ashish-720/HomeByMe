package kitchen.bryo.pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import kitchen.templateEditor.pageObject.Design;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Customise {
	WebDriver driver;

	public Customise(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "#furniture-mod-properties-window-wide>ul")
	private List<WebElement> balloon;

	@FindBy(id = "bt-configurator")
	private WebElement customizeButton;

	@FindBy(css = "#mod-layer-cabinet-composer>div>header>div>div>h3[class='title']")
	private WebElement customiseInfo;

	@FindBy(css = "ul>li>button>svg[class='icon-action-edit']")
	private WebElement customiseEdit;

	@FindBy(id = "validate-furniture-app")
	private WebElement doneCustomize;

	@FindBy(css = "button[data-ui-action='product-option-replace']")
	private List<WebElement> replace;

	@FindBy(css = "button[data-ui-action='product-option-more']")
	private List<WebElement> frontOptions;

	@FindBy(id = "edit-form-select-side")
	private List<WebElement> doorSide;

	@FindBy(id = "edit-form-select-doorOrientation")
	private List<WebElement> doorOrientation;

	@FindBy(css = "span[data-ui='regular-price']")
	private WebElement price;

	@FindBy(id = "configurator-action-area")
	private WebElement toolList;

	@FindBy(xpath = "//article[@id='mod-layer-cabinet-composer']/div/header/div/div/div[@class='price']/span/span/span/button[@data-ui-action='priceInfo']")
	private WebElement composeFurniturePrice;

	@FindBy(xpath = "//article[@class='mod-popin-alert-price mod-open']/div/header/div/div/h3[@class='title']")
	private WebElement composeFurniturePriceTitle;

	@FindBy(css = ".mod-popin-alert-price.mod-open>div>header>div>div>b")
	private WebElement composeFurniturePriceInfo;

	@FindBy(css = ".mod-popin-alert-price.mod-open>div>div>div>div>p")
	private WebElement composeFurniturePriceContent;

	@FindBy(css = ".mod-popin-alert-price.mod-open>div>header>div>div>button[data-ui-action='popin-close']")
	private WebElement closecomposeFurniturePricePopUp;

	@FindBy(css = "button[data-ui-action='add-item']")
	private WebElement addItemButton;

	@FindBy(css = "ul>li>button>svg[class='icon-action-edit']")
	private WebElement edit;

	@FindBy(css = "#furniture-mod-properties-window-wide>ul>li>button[data-ui-action='delete']")
	private WebElement deleteComposeProduct;

	@FindBy(css = "b[data-i18n='furniture_configurator.no_space']")
	private WebElement noSpace;

	@FindBy(css = "#validate-furniture-app")
	private WebElement validateButton;

	@FindBy(xpath = "//div[@class='mod-notification']/p[@class='success show']/span[@data-ui-selector='notification-text']")
	private WebElement customizeNotification;
	
	@FindBy(css = "#cancel-furniture-app")
	private WebElement cancelButton;

	@FindBy(css = ".mod-popin-furniture-configurator-small.mod-open>div")
	private WebElement editComposePopUp;

	@FindBy(css = ".mod-popin-furniture-configurator-small.mod-open>div>div>h1")
	private WebElement editComposeTitle;

	@FindBy(css = ".mod-popin-furniture-configurator-small.mod-open>div>div>div>div>p")
	private WebElement editComposeMessage;

	@FindBy(css = ".popin-footer .cta-primary-alt-xl")
	private WebElement editComposeYes;

	@FindBy(id = "bmSVG")
	private WebElement container3D;

	@FindBy(xpath = "//li/span/span[text()='Open cabinet']/../following-sibling::span/label[@data-ui-action='front-displayer']/input[@name='front-displayer']/following-sibling::span")
	private WebElement openCabinetToggle;

	@FindBy(xpath = "//li/span/span[text()='Display fronts']/../following-sibling::span/label[@data-ui-action='front-displayer']/input[@name='front-displayer']/following-sibling::span")
	private WebElement displayFrontToggle;

	@FindBy(xpath = "//form/ul/li/button[@data-ui-action='undo']/span[@class='icon-action-undo']")
	private WebElement undoButton;

	@FindBy(xpath = "//form/ul/li/button[@data-ui-action='redo']/span[@class='icon-action-redo']")
	private WebElement redoButton;

	@FindBy(id = "zoom-in")
	private WebElement zoomIn;

	@FindBy(id = "zoom-out")
	private WebElement zoomOut;

	@FindBy(css = ".manip-elevate")
	private WebElement elevatePointer;

	@FindBy(css = "#furniture-mod-properties-window-wide>div>h3")
	private WebElement customProductName;

	@FindBy(css = "#furniture-mod-properties-window-wide>div>p[class='desc']")
	private WebElement customProductDesc;

	@FindBy(css = "button[data-ui-action='priceInfo']")
	private WebElement priceInfoIcon;

	@FindBy(css = "li[data-ui-publicationid='handleOrientation']")
	private List<WebElement> handleOrientation;

	public MakeItYours composeFurniture(String price) {

		customizeButton.sendKeys(Keys.ENTER);// to click element as click
												// function does not work
		editCabinetOverlayForCompose();
		composeProductPageDetails();
		toolTipsComposeFurniture();
		composeFurniturePrice(price);
		return PageFactory.initElements(driver, MakeItYours.class);
	}
	public MakeItYours composeCustomizedFurniture(String price) {

		customizeButton.sendKeys(Keys.ENTER);// to click element as click
												// function does not work
		composeProductPageDetails();
		toolTipsComposeFurniture();
		composeFurniturePrice(price);
		return PageFactory.initElements(driver, MakeItYours.class);
	}
	public MakeItYours editCabinetOverlayForCompose() {
			UtilHBM.waitExplicitDisplayed(driver, editComposePopUp);
			String titleText = "Edit cabinet";
			String message = "By editing this item it will become a custom cabinet.";
			UtilHBM.waitExplicitDisplayed(driver, editComposePopUp);
			Verification.displayNAttributeCheckOfElement(editComposeTitle, "Edit cabinet", "text", titleText);
			Verification.displayNAttributeCheckOfElement(editComposeMessage,
					"By editing this item it will become a custom cabinet.", "text", message);
			editComposeYes.click();
		
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public Customise composeProductPageDetails() {
		System.out.println("Click compose button");
		String titleText = "Compose your own furniture";
		Verification.displayNAttributeCheckOfElement(customiseInfo, "Compose furniture ", "text", titleText);
		return this;
	}

	public Customise toolTipsComposeFurniture() {
		Tooltips tips = PageFactory.initElements(driver, Tooltips.class);
		tips.tooltipsForComposeFurniture();
		return this;
	}

	public Customise composeFurniturePrice(String price) {
		UtilHBM.waitFixTime(3500);
		if (!price.isEmpty()) {

			WebElement currency = driver
					.findElement(By.xpath("//div/span/span/span[@class='standard-price '][contains(text(),'\u20AC')]"));
			Verification.displayOfWebElement(currency);
			String p1 = driver.findElement(By.xpath("//div/span/span/span[@class='standard-price ']")).getText().trim()
					.replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", "");

			System.out.println("p1:" + p1.replaceAll("\\n", "") + "price:" + price);
			System.out.println("equals :" + p1.equalsIgnoreCase(price));
			if (p1.equalsIgnoreCase(price)) {
				UtilHBM.reportOK("Compose editor : Expected price: " + price + " SAME as actual price: " + p1);
			} else {
				UtilHBM.reportKO("Compose editor : Expected price: " + price + " NOT SAME as actual price: " + p1);
			}
			if (composeFurniturePrice.isEnabled()) {
				UtilHBM.waitExplicitDisplayed(driver, composeFurniturePrice);
				UtilHBM.waitExplicitClickable(driver, composeFurniturePrice);
				new Actions(driver).moveToElement(composeFurniturePrice).build().perform();
				new Actions(driver).moveToElement(composeFurniturePrice).click().build().perform();

				Price p = PageFactory.initElements(driver, Price.class);
				p.priceInfoInCompose();
			}
		}

//		driver.switchTo().parentFrame();
//		UtilHBM.waitExplicitDisplayed(driver, composeFurniturePriceTitle);
//		Verification.VerifyEquals("Price information title not displayed", composeFurniturePriceTitle.getText(),
//				"Price information");
//		Verification.VerifyEquals("Price information Not Displayed", composeFurniturePriceInfo.getText(),
//				"What is included in your cabinet price?");
//		System.out.println("..." + composeFurniturePriceContent.getText());
//		Verification.displayOfWebElement(composeFurniturePriceContent);
////		Verification.VerifyEquals("Price information content Not Displayed", composeFurniturePriceContent.getText(),
////				"The price includes the frame, all inside element, fronts, handles and legs.All linear elements (plinth, worktop, cornice, deco strip, …) are not included but will be added in the kitchen total price.");
//
//		closecomposeFurniturePricePopUp.click();
//		List<WebElement> frames = driver.findElements(By.cssSelector("#iframeContainer>iframe"));
//		driver.switchTo().frame(frames.get(0));
		return this;
	}

	public Customise editComposeReplaceProperty(int x, int y, String propertyName, String product,
			boolean productInfoSheet) {
		selectProduct(x, y);
		UtilHBM.waitFixTime(200);
//		Verification.displayOfWebElement(customProductName);
//		Verification.displayOfWebElement(customProductDesc);
		edit.click();
		UtilHBM.waitFixTime(1000);
		ProductProperties property = PageFactory.initElements(driver, ProductProperties.class);
		property.replaceInCompose(propertyName, product, productInfoSheet);
		UtilHBM.waitFixTime(4000);
		return PageFactory.initElements(driver, Customise.class);
	}

	public Customise replaceAppliancesInCompose(int x, int y, String propertyName, String product,
			boolean productInfoSheet) {
		selectProduct(x, y);
//		Verification.displayOfWebElement(customProductName);
//		Verification.displayOfWebElement(customProductDesc);
		if (customProductName.getText().equalsIgnoreCase(propertyName)) {
			driver.findElement(By.cssSelector("button[data-ui-action='replace']")).click();
			UtilHBM.waitFixTime(1000);
			Catalog catalog = PageFactory.initElements(driver, Catalog.class);
			catalog.replaceProductInCompose(product, productInfoSheet);
		}
		UtilHBM.waitFixTime(4000);

		return PageFactory.initElements(driver, Customise.class);
	}

	public Customise verifyReplaceAppliancesInCompose(int x, int y, String propertyName) {
		selectProduct(x, y);
//		Verification.displayOfWebElement(customProductName);
//		Verification.displayOfWebElement(customProductDesc);
		if (customProductName.getText().equalsIgnoreCase(propertyName)) {
			UtilHBM.reportOK("Replace verification for " + propertyName + " passed");
		} else {
			UtilHBM.reportKO("Replace verification for " + propertyName + "failed");
		}
		UtilHBM.waitFixTime(4000);
		return PageFactory.initElements(driver, Customise.class);
	}

	public Customise verifyComposeReplaceProperty(int x, int y, String propertyName, String product) {
		selectProduct(x, y);
//		Verification.displayOfWebElement(customProductName);
//		Verification.displayOfWebElement(customProductDesc);
		Actions action = new Actions(driver);
		action.moveToElement(edit).click().build().perform();
		UtilHBM.waitFixTime(1000);
		ProductProperties property = PageFactory.initElements(driver, ProductProperties.class);
		property.verifyReplace(propertyName, product);
		Catalog catalog = PageFactory.initElements(driver, Catalog.class);
		catalog.closeCatalogEditPanelForCompose();
		return PageFactory.initElements(driver, Customise.class);
	}

	public MakeItYours validateComposeFurniture() {
		validateButton.click();
		UtilHBM.waitExplicitDisplayed(driver, customizeNotification);
		if (customizeNotification.getText().equalsIgnoreCase("Your cabinet has been updated in your kitchen.")) {
			UtilHBM.reportOK("Notification displayed after validating customize cabinet. ");
		} else
			UtilHBM.reportKO("Notification not displayed after validating customize cabinet. ");
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public MakeItYours cancelComposeFurniture() {
		cancelButton.click();
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public Customise displayFront() {
		UtilHBM.waitFixTime(2500);
		clickBlank();
		WebElement ele = driver.findElement(By.cssSelector(".canvas-tools-options"));
		ele.click();
		UtilHBM.waitExplicitDisplayed(driver, displayFrontToggle);
		UtilHBM.waitExplicitClickable(driver, displayFrontToggle);
		new Actions(driver).moveToElement(displayFrontToggle).click().build().perform();
		clickBlank();
		return PageFactory.initElements(driver, Customise.class);
	}

	public Customise openCabinet() {
		WebElement ele = driver.findElement(By.cssSelector(".canvas-tools-options"));
		ele.click();
		new Actions(driver).moveToElement(openCabinetToggle).click().build().perform();
		clickBlank();
		return PageFactory.initElements(driver, Customise.class);

	}

	public Customise zoomIn(int zoomIncount) {
		UtilHBM.waitFixTime(1000);
		for (int i = 1; i <= zoomIncount; i++) {
			zoomIn.click();
			UtilHBM.waitFixTime(500);

		}
		return this;
	}

	public Customise zoomOut(int zoomOutcount) {
		for (int i = 1; i <= zoomOutcount; i++) {
			zoomOut.click();
			UtilHBM.waitFixTime(500);

		}
		return this;
	}

	public MakeItYours selectProduct(int x, int y) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver,
				driver.findElement(By.cssSelector("div[class='mod-properties-window-wide mod-open']")));
		UtilHBM.waitExplicitClickable(driver,
				driver.findElement(By.cssSelector("div[class='mod-properties-window-wide mod-open']")));
		Verification.displayOfWebElement(customProductName);
		if(!customProductDesc.getText().isEmpty()) {
			Verification.displayOfWebElement(customProductDesc);
			}
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public Customise elevateProduct(int x, int y, int x1, int y1) {
		selectProduct(x, y);
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(elevatePointer, x1, y1).build().perform();
		// UtilHBM.waitFixTime(3000);
		actions.moveToElement(container3D, 321, -330).clickAndHold().pause(500).release().build().perform();
		return PageFactory.initElements(driver, Customise.class);
	}

	public Customise rotateView(int x, int y, int x_offset, int y_offset) {
		clickBlank();
		Actions actions = new Actions(driver);
		actions.moveToElement(container3D, x, y).clickAndHold().pause(500).moveByOffset(x_offset,y_offset).pause(500).release().build().perform();
		return PageFactory.initElements(driver, Customise.class);
	}

	public Customise deleteComposeProduct(int x, int y) {
		selectProduct(x, y);
		deleteComposeProduct.click();

		return PageFactory.initElements(driver, Customise.class);
	}

	public Customise addItemInCabinet(String product, boolean productInfoSheet) {
		clickBlank();
		UtilHBM.waitFixTime(500);
		UtilHBM.turnOffImplicitWaits(driver);
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader>.content>span.spinner");
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.waitExplicitClickable(driver, addItemButton);
//		if (addItemButton.isEnabled()) {
			addItemButton.click();
			Catalog catalog = PageFactory.initElements(driver, Catalog.class);
			catalog.addProductInComposeEditor(product,productInfoSheet);
//		} else {
//			if (noSpace.isDisplayed()) {
//				UtilHBM.reportMsg("Add item button is disabled");
//			}
//		}

		return PageFactory.initElements(driver, Customise.class);
	}

	public Customise verifyCabinetIsFull(){
		if(addItemButton.isEnabled())UtilHBM.reportKO("Add items button isn't disabled");
		UtilHBM.waitExplicitDisplayed(driver, "//div[@class='add-items']/b[text()='Your cabinet is already full!']");
		return PageFactory.initElements(driver, Customise.class);
	}

	public Customise verifyAddedItemInCabinet(int x, int y, String product) {
		UtilHBM.waitFixTime(1000);
		clickBlank();
		selectProduct(x, y);
//		Verification.displayOfWebElement(customProductName);
//		Verification.displayOfWebElement(customProductDesc);
		UtilHBM.waitExplicitDisplayed(driver,
				driver.findElement(By.cssSelector("#furniture-mod-properties-window-wide")));
		WebElement productName = driver
				.findElement(By.cssSelector("#furniture-mod-properties-window-wide>div>h3[class='name']"));
		if (productName.getText().trim().replaceAll("\n\r", "").equalsIgnoreCase(product)) {
			UtilHBM.reportOK("Item " + productName.getText() + " added successfully to the cabinet");
		} else
			UtilHBM.reportKO("Adding new item " + productName.getText() + " to cabinet failed");
		return PageFactory.initElements(driver, Customise.class);
	}

	public Customise handleOrientation(int x, int y, String orientation) {
		selectProduct(x, y);
		edit.click();
		if (handleOrientation.size() > 0) {

			Select oSelect = new Select(handleOrientation.get(0)
					.findElement(By.xpath("//fieldset/p/span/select[@id='edit-form-select-handleOrientation']")));
			oSelect.selectByVisibleText(orientation);
		}
		return this;
	}

	public Customise setFrontOptions(int x, int y, String side, String orientation) {
		selectProduct(x, y);
		edit.click();
		UtilHBM.waitFixTime(1000);
		if(frontOptions.size()>0)frontOptions.get(0).click();
		else UtilHBM.reportKO("front Options button not found");
		UtilHBM.waitFixTime(1000);

		if(!side.isEmpty()){
			if (doorSide.size() > 0) {
				Select oSelect = new Select(doorSide.get(0));
				oSelect.selectByVisibleText(side);
			}else UtilHBM.reportKO("Unable to set door Side");
		}
		else UtilHBM.reportOK("Door side not set.");

		if(!orientation.isEmpty()){
			if (doorOrientation.size() > 0) {
				Select oSelect = new Select(doorOrientation.get(0));
				oSelect.selectByVisibleText(orientation);
			}else UtilHBM.reportKO("Unable to set door Side");
		}
		else UtilHBM.reportOK("Door side not set.");
		return this;
	}

	public Customise verifyHandleOrientation(int x, int y, String orientation) {
		clickBlank();
		selectProduct(x, y);
		edit.click();
		if (handleOrientation.size() > 0) {

			Select oSelect = new Select(handleOrientation.get(0)
					.findElement(By.xpath("//fieldset/p/span/select[@id='edit-form-select-handleOrientation']")));
			WebElement option = oSelect.getFirstSelectedOption();
			String defaultItem = option.getText();
			System.out.println(defaultItem);
			if (defaultItem.equalsIgnoreCase(orientation)) {
				UtilHBM.reportOK("Verification for Handle orientation passed and value is : " + defaultItem);
			} else {
				UtilHBM.reportKO("Verification for Handle orientation failed and value is : " + defaultItem);
			}

		}

		return PageFactory.initElements(driver, Customise.class);
	}

	public Customise clickBlank() {
		UtilHBM.turnOffImplicitWaits(driver);
		int j = 0;
		while (balloon.size() > 0 && j < 10) {
			Actions action = new Actions(driver);
			action.moveToElement(container3D, 241, -264).clickAndHold().pause(500).release().build().perform();
			j++;
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}

	public Customise getBallon(int x, int y) {
		UtilHBM.turnOffImplicitWaits(driver);
		int i = 0;
		while (balloon.size() == 0 && i < 20) {
			Actions action = new Actions(driver);
			action.moveToElement(container3D, x, y).clickAndHold().pause(500).release().build().perform();
			i++;

			System.out.println("image clicked");
		}
		UtilHBM.turnOnImplicitWaits(driver);

		return this;
	}

	public Customise undoInCompose(int number) {
		clickBlank();
		for (int i = 0; i < number; i++) {
			undoButton.click();
		}
		return PageFactory.initElements(driver, Customise.class);
	}

	public Customise redoInCompose(int number) {
		for (int i = 0; i < number; i++) {

			redoButton.click();
		}
		return PageFactory.initElements(driver, Customise.class);
	}

	public Customise verifyProductIsSelected(int x, int y, boolean isPrdtSelected, String product) {
		clickBlank();
		UtilHBM.waitFixTime(1000);
		Actions action = new Actions(driver);
		action.moveToElement(container3D, x, y).clickAndHold().pause(500).release().build().perform();

		if (isPrdtSelected) {
			UtilHBM.waitExplicitDisplayed(driver,
					driver.findElement(By.cssSelector("#furniture-mod-properties-window-wide")));
			WebElement productName = driver
					.findElement(By.cssSelector("#furniture-mod-properties-window-wide>div>h3[class='name']"));
			if (productName.getText().trim().replaceAll("\n\r", "").equalsIgnoreCase(product)) {
				UtilHBM.reportOK("Item " + productName.getText() + " is selected");
			} else
				Assert.fail("product " + product + " is not selected");
		} else {
			UtilHBM.turnOffImplicitWaits(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			try {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#furniture-mod-properties-window-wide"))));
				Assert.fail("product " + product + " is selected");
			} catch (NoSuchElementException | TimeoutException e) {
				UtilHBM.reportOK("Item " + product + " is not selected");
			}
			UtilHBM.turnOnImplicitWaits(driver);
		}

		return PageFactory.initElements(driver, Customise.class);
	}

}
