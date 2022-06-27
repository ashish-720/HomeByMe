package kitchen.bryo.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import hr.planner.pageObject.HomePlanner;
import hr.planner.pageObject.ProductSheet;

public class FavoritesList {

	WebDriver driver;

	public FavoritesList(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//div/ul/li/article[@data-ui-selector='create-list']/h3")
	private WebElement createNewListButton;

	@FindBy(xpath = "//article/div/button/span[@class='icon-action-zoom']")
	private WebElement createNewListIcon;

	@FindBy(xpath = "//div/fieldset/p/input")
	private WebElement nameInput;

	@FindBy(xpath = "//footer/button[@class='cta-secondary-xl']/span")
	private WebElement cancelbutton;

	@FindBy(xpath = "//footer/button[@class='cta-primary-alt-xl']/span")
	private WebElement createbutton;

	@FindBy(xpath = "//div/ul/li[@data-db-id='194']/article/button/span") // should be generic
	private WebElement deleteFavoriteList;

	@FindBy(css = "button[data-ui-action='catalog-search']")
	private WebElement searchProductInFav;

	public FavoritesList createNewFavoritesList(String nameInput) {
		UtilHBM.waitFixTime(1000);
		nameInput(nameInput);
		createbutton.click();
		UtilHBM.waitFixTime(1000);
		// wait> verify
		// Verification.displayNAttributeCheckOfElement(, elementName, attribute,
		// attributeValue);
		return PageFactory.initElements(driver, FavoritesList.class);
	}

	public FavoritesList deleteFavoritesList(String name, int index, boolean deleteConfirm) {

		UtilHBM.waitFixTime(1000);
		List<WebElement> favList = driver
				.findElements(By.xpath("//li/article/h3[text()='" + name + "']/parent::article"));
		int noOfList = favList.size();
		WebElement favoriteToDelete = favList.get(index);
		UtilHBM.waitExplicitClickable(driver, favoriteToDelete);
		new Actions(driver).moveToElement(favoriteToDelete).build().perform();
		WebElement deleteBtn = favoriteToDelete.findElement(By.xpath("button[@data-ui-selector='delete-list']/span"));
		new Actions(driver).moveToElement(deleteBtn).build().perform();
		deleteBtn.click();
		if (deleteConfirm) {
			deleteYes.click();
			UtilHBM.waitFixTime(1000);
			List<WebElement> favList1 = driver
					.findElements(By.xpath("//li/article/h3[text()='" + name + "']/parent::article"));
			if (favList1.size() != noOfList - 1) {
				UtilHBM.reportKO("Favorite list not delete. No of list before delete= " + noOfList
						+ ", No of list after delete = " + favList1.size());
			}
		} else {
			deleteNo.click();
			UtilHBM.waitFixTime(1000);
			List<WebElement> favList1 = driver
					.findElements(By.xpath("//li/article/h3[text()='" + name + "']/parent::article"));
			if (favList1.size() != noOfList) {
				UtilHBM.reportKO("Favorite list deleted even after NO click. No of list before delete= " + noOfList
						+ ", No of list after delete = " + favList1.size());
			}
		}
		return PageFactory.initElements(driver, FavoritesList.class);
	}

	public FavoritesList removeProductFromFavoritesList(String favListName, String productName, int index,
			boolean deleteConfirm) {
		List<WebElement> favList = driver
				.findElements(By.xpath("//li/article/h3[text()='" + favListName + "']/parent::article"));
		WebElement favoriteToOpen = favList.get(index);
		UtilHBM.waitExplicitClickable(driver, favoriteToOpen);

		favoriteToOpen.click();
		UtilHBM.waitFixTime(1000);
		List<WebElement> productList = driver
				.findElements(By.xpath("//div[@class='text']/h3/span[contains(text(),'" + productName + "')]"));
		int noOfList = productList.size();
		System.out.println("nolist:" + noOfList);
		WebElement productToDelete = productList.get(index);
		UtilHBM.waitExplicitClickable(driver, productToDelete);
		new Actions(driver).moveToElement(productToDelete).build().perform();
		WebElement deleteBtn = productToDelete.findElement(By
				.xpath("ancestor::article/div[@class='favorite-button-container']/button[@class='bt-icon-favorite']"));
		deleteBtn.click();
		UtilHBM.waitExplicitDisplayed(driver, productToDelete.findElement(By.xpath(
				"ancestor::li/article/div[@data-ui-id='from-favorite']/p/span[contains(text(),'Remove from this list ?')]")));
		if (deleteConfirm) {
			productToDelete.findElement(By.xpath("ancestor::li/article/div/p/button[@class='cta-primary']")).click();
			UtilHBM.waitFixTime(1000);
			List<WebElement> productList1 = driver
					.findElements(By.xpath("//div[@class='text']/h3/span[contains(text(),'\"+productName+\"')]"));
			System.out.println("nolist:" + noOfList);
			if (productList1.size() != noOfList - 1) {
				UtilHBM.reportKO("Favorite list not delete. No of list before delete= " + noOfList
						+ ", No of list after delete = " + productList1.size());
			}
		} else {
			productToDelete.findElement(By.xpath("ancestor::li/article/div/p/button[@class='cta-secondary']")).click();
			UtilHBM.waitFixTime(1000);
			List<WebElement> productList1 = driver
					.findElements(By.xpath("//div[@class='text']/h3/span[contains(text(),'\"+productName+\"')]"));
			if (productList1.size() != noOfList) {
				UtilHBM.reportKO("Favorite list deleted even after NO click. No of list before delete= " + noOfList
						+ ", No of list after delete = " + productList1.size());
			}
		}
		backButton();
		return PageFactory.initElements(driver, FavoritesList.class);
	}

	@FindBy(css = ".cta-primary-alt-xl")
	private WebElement deleteYes;

	@FindBy(css = ".cta-secondary-xl")
	private WebElement deleteNo;

	FavoritesList nameInput(String favoriteName) {
		createNewListButton.click();
		// nameInput.click();
		nameInput.sendKeys(favoriteName);
		return PageFactory.initElements(driver, FavoritesList.class);
	}

	public MakeItYours searchProductInFav() {
		UtilHBM.waitExplicitDisplayed(driver, searchProductInFav);
		UtilHBM.waitExplicitClickable(driver, searchProductInFav);
		searchProductInFav.click();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	@FindBy(xpath = "//span[@data-ui-selector='notification-text']")
	private WebElement favoriteSuccessMsg;

	@FindBy(css = ".create-new-list-cta>button>.icon-action-zoom")
	private WebElement zoomIcon;

	@FindBy(css = "[data-ui-selector='add-to-new-favorite']>span")
	private WebElement addToNewFavList;

	public ProductSheet clickOnNewFavList(String name) {

		zoomIcon.click();
		driver.findElement(By.cssSelector("[id='input-create-new-list']")).sendKeys(name);
		addToNewFavList.click();
		UtilHBM.waitExplicitDisplayed(driver, favoriteSuccessMsg);
		Verification.displayNAttributeCheckOfElement(favoriteSuccessMsg, "favorite msg", "text",
				"Product has been added to the list: " + name);
		driver.switchTo().frame(UtilHBM.webElement(driver,
				"iframe[src*='https://preprod-widgets.enterprise-dev.by.me/ProductSheetView/embed.html']"));

		return PageFactory.initElements(driver, ProductSheet.class);
	}

	public ProductSheet clickOnFavList(String name, int index) {

		UtilHBM.waitFixTime(1000);
		List<WebElement> favList = driver.findElements(By.xpath(
				"//li/article/h3[text()='" + name + "']/ancestor::article//button[@class='cta-primary-alt-sm']"));
		favList.get(index).click();
		driver.switchTo().frame(UtilHBM.webElement(driver,
				"iframe[src*='https://preprod-widgets.enterprise-dev.by.me/ProductSheetView/embed.html']"));

		return PageFactory.initElements(driver, ProductSheet.class);
	}

	public FavoritesList clickOnFavList1(String name, int index) {

		UtilHBM.waitFixTime(1000);
		List<WebElement> favList = driver.findElements(By.xpath("//li/article/h3[text()='" + name + "']"));
		favList.get(index).click();
		return PageFactory.initElements(driver, FavoritesList.class);
	}

	public FavoritesList favIconInFavoriteList(String dataId, int index, int yesOrNo) {

		UtilHBM.waitExplicitDisplayed(driver, "//li[@data-ui-id='" + dataId + "']/article/img");
		List<WebElement> productFavIconList = driver
				.findElements(By.xpath("//li[@data-ui-id='" + dataId + "']/article/div/button"));
		productFavIconList.get(index).click();
		driver.findElement(By.xpath("//li[@data-ui-id='" + dataId
				+ "']/article/div[@data-ui-id='from-favorite']/p/button[@data-ui-option='" + yesOrNo + "']")).click();
		return PageFactory.initElements(driver, FavoritesList.class);
	}

	@FindBy(css = "#input-create-new-list")
	private WebElement changeFavName;

	@FindBy(css = "#favorite-browser>header>button>.icon-action-arrow")
	private WebElement backButton;

	public FavoritesList editFavListName(String changName) {

		UtilHBM.waitExplicitDisplayed(driver, changeFavName);
		UtilHBM.clearInputBox(changeFavName);
		changeFavName.sendKeys(changName + Keys.ENTER);
		return PageFactory.initElements(driver, FavoritesList.class);
	}

	public FavoritesList backButton() {

		backButton.click();
		return PageFactory.initElements(driver, FavoritesList.class);
	}

	@FindBy(css = "header>ul>li>.bt-icon-alt>.icon-view-maximize")
	private WebElement maximizeCatalog;

	@FindBy(css = "header>ul>li>.bt-icon-alt>.icon-view-minimize")
	private WebElement minimizeCatalog;

	@FindBy(css = ".actions>.close>button")
	private WebElement closeCatalogButton;

	public FavoritesList maximizePanel() {
		// UtilHBM.waitFixTime(1000);
		maximizeCatalog.click();
		return PageFactory.initElements(driver, FavoritesList.class);
	}

	public FavoritesList minimizePanel() {
		minimizeCatalog.click();
		return PageFactory.initElements(driver, FavoritesList.class);
	}

	public HomePlanner closeFavPanel() {
		closeCatalogButton.click();
		return PageFactory.initElements(driver, HomePlanner.class);
	}
}
