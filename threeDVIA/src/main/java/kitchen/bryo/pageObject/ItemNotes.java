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

public class ItemNotes {

	WebDriver driver;

	public ItemNotes(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "article[class='mod-layer-item-notes mod-open']>div>header>div>div>h3")
	private WebElement itemNotesTitle;

	@FindBy(css = "article[class='mod-layer-item-notes mod-open']>div>header>div>div>b")
	private WebElement itemNotesMessage;

	@FindBy(css = ".mod-layer-item-notes.mod-open>div>div>div>div>div>#bmSVG")
	private WebElement container3D;

	@FindBy(css = "mod-item-note.focus.selected.show")
	private List<WebElement> ballon;

	@FindBy(id = "zoom-in")
	private WebElement zoomIn;

	@FindBy(id = "zoom-out")
	private WebElement zoomOut;

	@FindBy(xpath = "//label[@data-ui-selector='item-note-container']")
	List<WebElement> itemNotesList;

	@FindBy(xpath = "//span[@data-ui-selector='item-note-counter']")
	WebElement itemNotesCount;

	@FindBy(xpath = "//span[@data-ui-selector='project-note-counter']")
	WebElement projectNotesCount;

	@FindBy(css = "button[data-ui-action='click-item-notes-tab']")
	WebElement itemNotesTab;

	@FindBy(css = "button[data-ui-action='click-project-notes-tab']")
	WebElement projectNotesTab;

	@FindBy(css = "section[id='project-notes-project']>textarea[id='manual-notes-input']")
	WebElement projectNotesTextArea;

	public ItemNotes addItemNotes(int x, int y, String product, String note) {

		String titleText = "Notes";
		String message = "Add notes about the entire project, or a specific furniture by selecting the item.";
		Verification.displayNAttributeCheckOfElement(itemNotesTitle, "Item Notes Title", "text", titleText);
		Verification.displayNAttributeCheckOfElement(itemNotesMessage, "Item Notes Message", "text", message);
		int beforeAdd = itemNotesList.size();
		UtilHBM.reportInfo("Item Notes count before adding : " + itemNotesList.size());
		getBallon(x, y);

		List<WebElement> itemNoteName = driver
				.findElements(By.xpath("//label/div/h3[@class='name']/span[contains(text(),'" + product + "')]"));
		WebElement itemNoteTextArea = driver.findElement(By.xpath("//label/div/h3[@class='name']/span[contains(text(),'"
				+ product + "')]/../../following-sibling::div/textarea"));

		UtilHBM.waitExplicitDisplayed(driver, itemNoteName.get(0));
		UtilHBM.waitExplicitClickable(driver, itemNoteName.get(0));
		System.out.println(
				"a... :" + driver.findElement(By.xpath("//label/div[@class='product-info']/img")).getAttribute("alt"));
		if ((driver.findElement(By.xpath("//label/div[@class='product-info']/img"))).getAttribute("src")
				.startsWith("https")
				|| (driver.findElement(By.xpath("//label/div[@class='product-info']/img"))).getAttribute("src")
						.startsWith("./asset")) {
			UtilHBM.reportInfo("Product Thumbnail displayed in item notes");
		}

		if (itemNoteName.get(0).getText().equalsIgnoreCase(product)) {
			Verification.displayOfWebElement(itemNoteName.get(0));
			Verification.displayOfWebElement(itemNoteTextArea);
			itemNoteTextArea.click();
			itemNoteTextArea.sendKeys(note);

		}
		itemNoteName.get(0).click();
		WebElement itemNoteDeleteButton = driver
				.findElement(By.xpath("//label/div/h3[@class='name']/span[contains(text(),'" + product
						+ "')]/../following-sibling::button[@data-ui-selector='item-note-delete-btn']"));
		UtilHBM.waitExplicitDisplayed(driver, itemNoteDeleteButton);
		return PageFactory.initElements(driver, ItemNotes.class);
	}
	public ItemNotes addItemNotesForLinears(int x, int y, String product, String note) {

		String titleText = "Notes";
		String message = "Add notes about the entire project, or a specific furniture by selecting the item.";
		Verification.displayNAttributeCheckOfElement(itemNotesTitle, "Item Notes Title", "text", titleText);
		Verification.displayNAttributeCheckOfElement(itemNotesMessage, "Item Notes Message", "text", message);
		int beforeAdd = itemNotesList.size();
		UtilHBM.reportInfo("Item Notes count before adding : " + itemNotesList.size());
		getBallon(x, y);

		WebElement itemNoteName = driver
				.findElement(By.xpath("//label/div/h3[@class='name']/span[contains(text(),'" + product + "')]"));
		WebElement itemNoteTextArea = driver.findElement(By.xpath("//label/div/h3[@class='name']/span[contains(text(),'"
				+ product + "')]/../../following-sibling::div/textarea"));

		UtilHBM.waitExplicitDisplayed(driver, itemNoteName);
		UtilHBM.waitExplicitClickable(driver, itemNoteName);
		
		if (itemNoteName.getText().equalsIgnoreCase(product)) {
			Verification.displayOfWebElement(itemNoteName);
			Verification.displayOfWebElement(itemNoteTextArea);
			itemNoteTextArea.click();
			itemNoteTextArea.sendKeys(note);

		}
		itemNoteName.click();
		WebElement itemNoteDeleteButton = driver
				.findElement(By.xpath("//label/div/h3[@class='name']/span[contains(text(),'" + product
						+ "')]/../following-sibling::button[@data-ui-selector='item-note-delete-btn']"));
		UtilHBM.waitExplicitDisplayed(driver, itemNoteDeleteButton);
		return PageFactory.initElements(driver, ItemNotes.class);
	}
	public MakeItYours validate() {
		driver.findElement(By.cssSelector("button[data-ui-action='layer-item-notes-validate']")).click();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public ItemNotes deleteNote(int x, int y, String product) {
//		if (itemNotesList.isEmpty())
//			UtilHBM.reportKO("Item Note list is empty!!!");
//		else if (itemNotesList.size() == 1) {
			getBallon(x, y);
//			WebElement itemNoteName = driver
//					.findElement(By.xpath("//label/div/h3[@class='name']/span[contains(text(),'" + product + "')]"));
//			WebElement itemNoteTextArea = driver
//					.findElement(By.xpath("//label/div/h3[@class='name']/span[contains(text(),'" + product
//							+ "')]/../../following-sibling::div/textarea"));
//			UtilHBM.waitExplicitDisplayed(driver, itemNoteName);
//			UtilHBM.waitExplicitClickable(driver, itemNoteName);
//			if (itemNoteName.getText().equalsIgnoreCase(product)) {
//				Verification.displayOfWebElement(itemNoteName);
//				Verification.displayOfWebElement(itemNoteTextArea);
//				itemNoteTextArea.click();
//
//			}
//			itemNoteName.click();
			WebElement itemNoteDeleteButton = driver
					.findElement(By.xpath("//label/div/h3[@class='name']/span[contains(text(),'" + product
							+ "')]/../following-sibling::button[@data-ui-selector='item-note-delete-btn']"));
			UtilHBM.waitExplicitDisplayed(driver, itemNoteDeleteButton);
			UtilHBM.waitExplicitClickable(driver, itemNoteDeleteButton);
//			UtilHBM.reportInfo("Item Note to be deleted : " + itemNoteName.getText());
			itemNoteDeleteButton.click();
			UtilHBM.waitFixTime(2000);
//			if (itemNotesList.isEmpty())
//				UtilHBM.reportOK("Item Note deleted and Item Note list is empty!!!");
//			else
//				UtilHBM.reportKO("Item Note deleteion failed and Item Note list is not empty");
//		} else {
//			itemNotesTab.click();
//			WebElement itemNoteName = driver
//					.findElement(By.xpath("//label/div/h3[@class='name']/span[contains(text(),'" + product + "')]"));
//
//			int beforeDelete = itemNotesList.size();
//			UtilHBM.reportOK("Number of notes before deleting :" + beforeDelete);
//			new Actions(driver).moveToElement(itemNoteName).build().perform();
//			UtilHBM.waitExplicitDisplayed(driver, itemNoteName);
//			itemNoteName.click();
//			WebElement itemNoteDeleteButton = driver
//					.findElement(By.xpath("//label/div/h3[@class='name']/span[contains(text(),'" + product
//							+ "')]/../following-sibling::button[@data-ui-selector='item-note-delete-btn']"));
//			UtilHBM.waitExplicitClickable(driver, itemNoteDeleteButton);
//			UtilHBM.reportInfo("Item Note to be deleted : " + itemNoteName.getText());
//			itemNoteDeleteButton.click();
//			UtilHBM.waitFixTime(2000);
//			int afterDelete = itemNotesList.size();
//			if (afterDelete == beforeDelete - 1)
//				UtilHBM.reportOK("Item Note deleted and no. of Item Note decreased and count is :" + afterDelete);
//			else
//				UtilHBM.reportKO("Item Note deletion failed and no. of Item Note not decreased");
//		}
		return this;
	}

	public ItemNotes editItemNotes(int x, int y, String product, String note) {
		getBallon(x, y);
		UtilHBM.waitExplicitDisplayed(driver, itemNotesList.get(0));
		WebElement itemNoteName = driver
				.findElement(By.xpath("//label/div/h3[@class='name']/span[contains(text(),'" + product + "')]"));
		WebElement itemNoteTextArea = driver.findElement(By.xpath("//label/div/h3[@class='name']/span[contains(text(),'"
				+ product + "')]/../../following-sibling::div/textarea"));
		UtilHBM.waitExplicitDisplayed(driver, itemNoteName);
		UtilHBM.waitExplicitClickable(driver, itemNoteName);
		if (itemNoteName.getText().equalsIgnoreCase(product)) {
			Verification.displayOfWebElement(itemNoteName);
			Verification.displayOfWebElement(itemNoteTextArea);
			itemNoteTextArea.click();
//			itemNoteTextArea.clear();
			for (int i = 0; i < note.length(); i++) {
				itemNoteTextArea.sendKeys(Keys.BACK_SPACE);
			}
			itemNoteTextArea.sendKeys(note);

		}
		itemNoteName.click();
		itemNotesList.get(0).click();
		WebElement itemNoteDeleteButton = driver
				.findElement(By.xpath("//label/div/h3[@class='name']/span[contains(text(),'" + product
						+ "')]/../following-sibling::button[@data-ui-selector='item-note-delete-btn']"));
		UtilHBM.waitExplicitDisplayed(driver, itemNoteDeleteButton);
		UtilHBM.waitFixTime(2000);
		System.out.println("note: " + itemNoteTextArea.getText());
		if (itemNoteTextArea.getAttribute("value").equalsIgnoreCase(note)) {
			UtilHBM.reportOK("Item Note for : " + product + " edited successfully");
		} else {
			UtilHBM.reportKO("Item Note for : " + product + " not edited correctly");
		}
		UtilHBM.waitExplicitDisplayed(driver, itemNoteDeleteButton);
		return PageFactory.initElements(driver, ItemNotes.class);
	}

	public ItemNotes clickBlank() {
		UtilHBM.turnOffImplicitWaits(driver);
		int j = 0;
		while (ballon.size() > 0 && j < 10) {
			Actions action = new Actions(driver);
			action.moveToElement(container3D, 347, -323).clickAndHold().pause(500).release().build().perform();
			j++;
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}

	public ItemNotes getBallon(int x, int y) {
		UtilHBM.waitFixTime(500);
		Actions actions = new Actions(driver);
		actions.moveToElement(container3D, x, y).clickAndHold().pause(500).release().build().perform();

//		UtilHBM.turnOffImplicitWaits(driver);
//		int i = 0;
//		while (ballon.size() == 0 && i < 20) {
//			Actions action = new Actions(driver);
//			action.moveToElement(container3D, x, y).clickAndHold().pause(500).release().build().perform();
//
//			i++;
//
//			System.out.println("image clicked");
//		}
//		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}

	public ItemNotes verifyItemNoteForCustomProduct(int x, int y, String product) {
		getBallon(x, y);
		WebElement itemNoteName = driver
				.findElement(By.xpath("//label/div/h3[@class='name']/span[contains(text(),'" + product + "')]"));

		UtilHBM.waitExplicitDisplayed(driver, itemNoteName);
		UtilHBM.waitExplicitClickable(driver, itemNoteName);
		if (itemNoteName.getText().equalsIgnoreCase(product)) {
			UtilHBM.reportOK("Product is customized and item note is still valid");
		} else {
			UtilHBM.reportKO("Product is not customized and item note is not valid");
		}
		return this;
	}

	public ItemNotes addProjectNotes(String addNotes) {
		UtilHBM.waitFixTime(200);

		projectNotesTextArea.clear();
		projectNotesTextArea.click();

		projectNotesTextArea.sendKeys(addNotes);
		projectNotesTab.click();
		UtilHBM.waitFixTime(200);
		String afterCount = driver
				.findElement(By.cssSelector("span[data-ui-selector='project-note-counter'][aria-hidden='false']"))
				.getText();
		int aftereProNoteCount = Integer.parseInt(afterCount);
		UtilHBM.reportInfo("Project Note Count before adding :" + afterCount);
		if (aftereProNoteCount == 1)
			UtilHBM.reportOK(
					"Project Note added and no. of project Note increased and count is :" + aftereProNoteCount);
		else
			UtilHBM.reportKO("Project Note addition failed and no. of project Note not increased");
		return this;
	}
	
	public ItemNotes verifyProjectNotes(String note) {		;
		UtilHBM.waitFixTime(200);
		String afterCount = driver
				.findElement(By.cssSelector("span[data-ui-selector='project-note-counter'][aria-hidden='false']"))
				.getText();
		int aftereProNoteCount = Integer.parseInt(afterCount);
		if (aftereProNoteCount == 1)
			UtilHBM.reportOK(
					"Project Note added and no. of project Note increased and count is :" + aftereProNoteCount);
		else
			UtilHBM.reportKO("Project Note addition failed and no. of project Note not increased");
		Verification.displayNAttributeCheckOfElement(projectNotesTextArea, "Project Note", "value", note);
		return this;
	}

	public ItemNotes zoomIn(int zoomIncount) {
		UtilHBM.waitFixTime(1000);
		for (int i = 1; i <= zoomIncount; i++) {
			zoomIn.click();
			UtilHBM.waitFixTime(500);

		}
		return this;
	}

	public ItemNotes zoomOut(int zoomOutcount) {
		for (int i = 1; i <= zoomOutcount; i++) {
			zoomOut.click();
			UtilHBM.waitFixTime(500);

		}
		return this;
	}
	public ItemNotes viewHeight(String height) {
//		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		WebElement ele = driver.findElement(By.cssSelector(".canvas-tools-options"));
		ele.click();
		WebElement element = driver.findElement(By.cssSelector(("select[data-ui-action='opening']")));
		Select oSelect = new Select(element);
		oSelect.selectByVisibleText(height);
		return this;
	}
}
