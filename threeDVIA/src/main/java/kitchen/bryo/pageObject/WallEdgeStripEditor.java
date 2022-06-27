package kitchen.bryo.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class WallEdgeStripEditor {
	WebDriver driver;

	public WallEdgeStripEditor(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "button[data-ui-action='removeWES']")
	private WebElement removeWESButton;

	@FindBy(css = "button[data-ui-action='addWES']")
	private WebElement addWESButton;

	@FindBy(css = "button[data-ui-action='addEdgeProducts']")
	private WebElement addEdgeProductButton;

	@FindBy(css = "select[data-ui-action='edgeProductTop']")
	private WebElement topEdgeProduct;

	@FindBy(css = "select[data-ui-action='edgeProductLeft']")
	private WebElement leftEdgeProduct;

	@FindBy(css = "select[data-ui-action='edgeProductRight']")
	private WebElement rightEdgeProduct;

	@FindBy(css = "button[data-ui-action='command-validate']")
	private WebElement validateButton;

	@FindBy(css = ".mod-overlay-container.mod-open")
	private List<WebElement> balloon;

	@FindBy(css = "span[class='icon-action-info']")
	private WebElement wallEdgeStripEditorPrice;

	@FindBy(css = ".mod-popin-alert-price.mod-open>div>header>div>div>h3")
	private WebElement wallEdgeStripEditorPriceTitle;

	@FindBy(css = ".mod-popin-alert-price.mod-open>div>header>div>div>b")
	private WebElement wallEdgeStripEditorPriceInfo;

	@FindBy(css = ".mod-popin-alert-price.mod-open>div>div>div>div>p")
	private WebElement wallEdgeStripEditorPriceContent;

	@FindBy(css = ".mod-popin-alert-price.mod-open>div>header>div>div>button[data-ui-action='popin-close']")
	private WebElement closewallEdgeStripEditorPricePopUp;

	@FindBy(css = ".mod-popin-wall-edge-strip-editor-small.mod-open>div")
	private WebElement editWallEdgeStripPopUp;

	@FindBy(css = ".inner-content>h1")
	private WebElement editWallEdgeStripTitle;

	@FindBy(css = ".inner-content>.text>div>p")
	private WebElement editWallEdgeStripMessage;

	@FindBy(css = ".popin-footer .cta-primary-alt-xl")
	private WebElement editWallEdgeStripYes;

	@FindBy(id = "bmSVG")
	private WebElement container3D;

	@FindBy(xpath = "//form/ul/li/button[@data-ui-action='undo']/span[@class='icon-action-undo']")
	private WebElement undoButton;

	@FindBy(xpath = "//form/ul/li/button[@data-ui-action='redo']/span[@class='icon-action-redo']")
	private WebElement redoButton;

	@FindBy(xpath = "//button[@data-ui-action='priceInfo']")
	private WebElement priceInfoIcon;

	@FindBy(id = "zoom-in")
	private WebElement zoomIn;

	@FindBy(id = "zoom-out")
	private WebElement zoomOut;

	public WallEdgeStripEditor removeWallEdgeStrip(int x, int y) {
		clickBlank();
//		UtilHBM.waitTillElementDisappear(driver,
//				".mod-overlay-container.mod-open>div>.mod-overlay.mod-open");
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver, removeWESButton);
		UtilHBM.waitExplicitClickable(driver, removeWESButton);
		removeWESButton.click();

		return this;
	}

	public WallEdgeStripEditor verifyRemoveWallEdgeStrip(int x, int y) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver, addWESButton);
		if (addWESButton.isDisplayed()) {
			UtilHBM.reportOK("Wall edge strip removed successfully");
		} else {
			UtilHBM.reportKO("Wall edge strip not removed");

		}

		return this;
	}
	public MakeItYours validateWallEdgeStripEditor() {
		validateButton.click();
		UtilHBM.waitFixTime(2500);
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public WallPanelEditor verifyPriceInWallEdgeStrip(String price) {
		if (!price.isEmpty()) {
//			WebElement p = driver
//					.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'" + price + "')]"));
			WebElement currency = driver
					.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'\u20AC')]"));
//			Verification.displayOfWebElement(p);
			Verification.displayOfWebElement(currency);
			String p1 = driver.findElement(By.xpath("//span[@class='standard-price ']")).getText().trim()
					.replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", "");

			System.out.println("p1:" + p1.replaceAll("\\n", "") + "price:" + price);
			System.out.println("equals :" + p1.equalsIgnoreCase(price));
			if (p1.equalsIgnoreCase(price)) {
				UtilHBM.reportOK("Wall Edge Strip Editor : Expected price: " + p1 + " SAME as given price: " + price);
			} else {
				UtilHBM.reportKO("Wall Edge Strip Editor : Expected price: " + p1 + " NOT SAME as given price: " + price);
			}
		}
		if (priceInfoIcon.isEnabled()) {
			UtilHBM.waitExplicitDisplayed(driver, priceInfoIcon);
			UtilHBM.waitExplicitClickable(driver, priceInfoIcon);
			new Actions(driver).moveToElement(priceInfoIcon).build().perform();
			priceInfoIcon.click();
			Price p = PageFactory.initElements(driver, Price.class);
			p.priceInfoInEditors();
		}
		return PageFactory.initElements(driver, WallPanelEditor.class);
	}
	public MakeItYours editWallEdgeStripOverlay() {
		String titleText = "Edit wall edge strip";
		String message = "Please make sure you choose your preferred wall edge strip before editing it. Your modifications will only be priced for custom wall edge strips.";

		UtilHBM.waitExplicitDisplayed(driver, editWallEdgeStripPopUp);
		Verification.displayNAttributeCheckOfElement(editWallEdgeStripTitle, "Edit Overlay Title", "text", titleText);
		Verification.displayNAttributeCheckOfElement(editWallEdgeStripMessage, "Edit Overlay Message", "text", message);
		editWallEdgeStripYes.click();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public WallEdgeStripEditor wallEdgeStripEditorPrice() {
		wallEdgeStripEditorPrice.click();
		driver.switchTo().parentFrame();
		Verification.VerifyEquals("Price information title not displayed", wallEdgeStripEditorPriceTitle.getText(),
				"Price information");
		Verification.VerifyEquals("Price information Not Displayed", wallEdgeStripEditorPriceInfo.getText(),
				"What is included in your wall edge strip price?");
		Verification.VerifyEquals("Price information content Not Displayed", wallEdgeStripEditorPriceContent.getText(),
				"The price only includes wall edge strip products.");

		closewallEdgeStripEditorPricePopUp.click();
		List<WebElement> frames = driver.findElements(By.cssSelector("#iframeContainer>iframe"));
		driver.switchTo().frame(frames.get(0));
		return this;
	}

	public WallEdgeStripEditor addWallEdgeStrip(int x, int y) {
		clickBlank();
		getBallon(x, y);
		// addWESButton.click();
		Actions action = new Actions(driver);
		action.click(addWESButton).build().perform();
		return this;
	}

	public WallEdgeStripEditor verifyAddedWallEdgeStrip(int x, int y) {
		clickBlank();
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver, removeWESButton);
		if (removeWESButton.isDisplayed()) {
			UtilHBM.reportOK("Wall edge strip added successfully");
		} else {
			UtilHBM.reportKO("Wall edge strip not added");
		}
		return this;
	}

	public WallEdgeStripEditor changeEdge(int x, int y, String topEdge, String leftEdge, String rightEdge) {
		clickBlank();
		getBallon(x, y);
		addEdgeProductButton.click();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//header/h3[contains(text(),'Change edges')]")));
		if (!(topEdge.isEmpty())) {
			Select oSelect = new Select(topEdgeProduct);
			oSelect.selectByVisibleText(topEdge);
		}
		if (!(leftEdge.isEmpty())) {
			Select oSelect = new Select(leftEdgeProduct);
			oSelect.selectByVisibleText(leftEdge);
		}
		if (!(rightEdge.isEmpty())) {
			Select oSelect = new Select(rightEdgeProduct);
			oSelect.selectByVisibleText(rightEdge);
		}		
		if(!(new Select(rightEdgeProduct).getFirstSelectedOption().getText().equalsIgnoreCase(rightEdge))) {
			UtilHBM.reportKO("Right edge product not changed to "+rightEdge +". The expected value is: "+rightEdge+", actual value is: "+ new Select(rightEdgeProduct).getFirstSelectedOption().getText());
		}
		if(!(new Select(leftEdgeProduct).getFirstSelectedOption().getText().equalsIgnoreCase(leftEdge))) {
			UtilHBM.reportKO("Left edge product not changed to "+leftEdge +". The expected value is: "+leftEdge+", actual value is: "+ new Select(leftEdgeProduct).getFirstSelectedOption().getText());
		}
		
		if(!(new Select(topEdgeProduct).getFirstSelectedOption().getText().equalsIgnoreCase(topEdge))) {
			UtilHBM.reportKO("top edge product not changed to "+topEdge +". The expected value is: "+topEdge+", actual value is: "+ new Select(topEdgeProduct).getFirstSelectedOption().getText());
		}
	
		clickBlank();
		return this;
	}

	public WallEdgeStripEditor clickBlank() {
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

	public WallEdgeStripEditor getBallon(int x, int y) {
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

	public WallEdgeStripEditor undoInWallEdgeStrip(WebDriver driver, int number) {
		clickBlank();
		for (int i = 0; i < number; i++) {
			undoButton.click();
		}
		return PageFactory.initElements(driver, WallEdgeStripEditor.class);
	}

	public WallEdgeStripEditor redoInWallEdgeStrip(WebDriver driver, int number) {
		for (int i = 0; i < number; i++) {

			redoButton.click();
		}
		return PageFactory.initElements(driver, WallEdgeStripEditor.class);
	}

	public WallEdgeStripEditor clickAndDrag(int xOffset, int yOffset) {
		UtilHBM.waitFixTime(2000);
		Actions action = new Actions(driver);
		action.moveToElement(container3D, 322, -319).clickAndHold().pause(500)
				.dragAndDropBy(container3D, 322+xOffset, -319+yOffset).release().build().perform();
		return this;
	}

	public WallEdgeStripEditor zoomIn(int zoomIncount) {
		for (int i = 1; i <= zoomIncount; i++) {
			zoomIn.click();
			UtilHBM.waitFixTime(500);

		}
		return this;
	}

	public WallEdgeStripEditor zoomOut(int zoomOutcount) {
		for (int i = 1; i <= zoomOutcount; i++) {
			zoomOut.click();
			UtilHBM.waitFixTime(500);

		}
		return this;
	}
}
