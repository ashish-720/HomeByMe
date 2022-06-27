package hbm.web.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class AddToFavorites {

	WebDriver driver;

	public AddToFavorites(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "body[class='ReactModal__Body--open'] div.sheet-header>h2")
	private WebElement addToFavHeader;
	
	@FindBy(css = "body[class='ReactModal__Body--open'] div.sheet-header>button>span.icon-view-close")
	private WebElement closeAddToFavDialogBox;

	@FindBy(css = "body[class='ReactModal__Body--open'] a.close-modal.button-close")
	private WebElement closeButton;

	@FindBy(css = "body[class='ReactModal__Body--open'] div.modal-inner>div.right-inner-favorites>div.right-inner-footer-favorites>button")
	private WebElement addToNewList;
	
	@FindBy(id = "collection-name")
	private WebElement collectionNameInputBox;
	
	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open']/div/div/div[@class='sheet-header']/h2")
	private WebElement addToCollectionHeader;
	
	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open']/div/div/div[@class='sheet-footer']/div/span[@data-testid='favorite-add-new-list']")
	private WebElement addToNewCollection;
	
	@FindBy(xpath = "//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open']/div/div/div[@class='sheet-footer']/button[@class='sheet-button button']")
	private WebElement createNewCollection;

	public MyFavorites clickAddToNewList() {
		UtilHBM.waitExplicitDisplayed(driver, addToNewList);
		UtilHBM.waitExplicitClickable(driver, addToNewList);
		addToNewList.click();
		return PageFactory.initElements(driver, MyFavorites.class);
	}
	
	public DecorationInspiration closeAddToCollectionInInspiration() {
		UtilHBM.waitExplicitDisplayed(driver, closeAddToFavDialogBox);
		UtilHBM.waitExplicitClickable(driver, closeAddToFavDialogBox);
		closeAddToFavDialogBox.click();
		return PageFactory.initElements(driver, DecorationInspiration.class);
	}
	
	public FeaturedMediaPage closeAddToCollectionInImagePage() {
		UtilHBM.waitExplicitDisplayed(driver, closeAddToFavDialogBox);
		UtilHBM.waitExplicitClickable(driver, closeAddToFavDialogBox);
		closeAddToFavDialogBox.click();
		return PageFactory.initElements(driver, FeaturedMediaPage.class);
	}
	
	public ProjectPage closeAddToCollectionInProjectPage() {
		UtilHBM.waitExplicitDisplayed(driver, closeAddToFavDialogBox);
		UtilHBM.waitExplicitClickable(driver, closeAddToFavDialogBox);
		closeAddToFavDialogBox.click();
		return PageFactory.initElements(driver, ProjectPage.class);
	}

	public FeaturedMediaPage addToCollection(boolean newFavList, String favListName) {
		UtilHBM.waitExplicitDisplayed(driver, addToCollectionHeader);
		if (newFavList) {
			clickAddToNewCollection();
			for (String handle : driver.getWindowHandles()) {
				driver.switchTo().window(handle);
			}
			collectionNameInputBox.sendKeys(favListName);
			UtilHBM.waitExplicitClickable(driver, createNewCollection);
			createNewCollection.click();
			UtilHBM.reportInfo("New favorites list created : " + favListName);
		} else {
			UtilHBM.waitExplicitDisplayed(driver, driver.findElements(By.xpath(
					"//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open']/div/div/div[@class='sheet-body']/div"))
					.get(0));
			List<WebElement> expectedFavLists = driver.findElements(By.xpath(
					"//div[@class='ReactModal__Overlay ReactModal__Overlay--after-open']/div/div/div[@class='sheet-body']/div/span[contains(text(),'"
							+ favListName + "')]/.."));
			int noOfResults = expectedFavLists.size();
			if (noOfResults == 0) {
				UtilHBM.reportKO("Favorites list not available");
			} else {
				WebElement expectedFavList = expectedFavLists.get(0);
				String resultName = expectedFavList.findElement(By.xpath("span")).getText();
				UtilHBM.reportInfo("Adding item in fav list : "+resultName);
				Actions actions = PageFactory.initElements(driver, Actions.class);
				actions.moveToElement(expectedFavList).build().perform();
				WebElement addToFavButton = expectedFavList.findElement(By.xpath("div/button"));
				UtilHBM.waitExplicitClickable(driver, addToFavButton);
				addToFavButton.click();
			}
		}
		return PageFactory.initElements(driver, FeaturedMediaPage.class);
	}
	
	public MyFavorites clickAddToNewCollection() {
		UtilHBM.waitExplicitDisplayed(driver, addToNewCollection);
		UtilHBM.waitExplicitClickable(driver, addToNewCollection);
		addToNewCollection.click();
		return PageFactory.initElements(driver, MyFavorites.class);
	}
	
	public void addToCollection(boolean newCollection, String collectionName, String itemType) {
		String handle = driver.getWindowHandle();
		for (String handle1 : driver.getWindowHandles()) {
			if (!handle1.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle1);
			}
		}
		AddToFavorites addToFavorites = PageFactory.initElements(driver, AddToFavorites.class);
		addToFavorites.addToCollection(newCollection, collectionName);
		driver.switchTo().window(handle);
	}

}
