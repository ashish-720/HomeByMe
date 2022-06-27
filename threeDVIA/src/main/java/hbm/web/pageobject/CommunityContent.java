package hbm.web.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class CommunityContent {
	WebDriver driver;

	public CommunityContent(WebDriver driver) {
		this.driver = driver;
	}

	@CacheLookup
	@FindBy(css = ".header__container.row>.header__logo>.icon.icon-logo")
	WebElement homebymeLink;

	@FindBy(css = "div.feed-view>div>div#header-text>h1")
	WebElement headerTitle;

	@FindBy(css = "div.feed-view>div>div#header-text>div.under-title>div:nth-child(1)")
	WebElement headerText1;

	@FindBy(css = "div.feed-view>div>div#header-text>div.under-title>a.button-show-more.link-soft")
	WebElement showMoreInfoIcon;

	@FindBy(css = "div.feed-view>div>div#header-text>div.under-title>div[class='part2']")
	WebElement headerText2;

	@FindBy(css = "div#community-content>div>div>div[class='tag image-related']")
	List<WebElement> productList;

	@FindBy(css = "#community-content>div>div>div>div.filter-item>select")
	WebElement filterSelect;

	@FindBy(css = "#community-content>div>div>div>div.filter-item>p.label")
	WebElement filterLabel;

	@FindBy(css = "#community-content>div>div>div>div.filter-item>p.title")
	WebElement filterTitle;

	@FindBy(css = "#community-content>div>div>div>span[class='ato-panel-header-option ']")
	List<WebElement> clearAll;

	static String listItems;

	public CommunityContent verifyCommunityContentPage() {
		UtilHBM.waitExplicitDisplayed(driver, headerTitle);
		String productsInList = null;
		Verification.VerifyEquals("Wrong header title displayed for community content page!!", headerTitle.getText(),
				"Check out the exclusive content created by our community");
		Verification.VerifyEquals("Wrong header text 1 displayed at first!!", headerText1.getText(),
				"Find all the 3D interior design models created by the community and get inspired for your home interior.");
		UtilHBM.waitExplicitClickable(driver, showMoreInfoIcon);
		showMoreInfoIcon.click();
		Verification.VerifyEquals("Wrong header text 1 displayed after clicking showMoreInfo icon!!",
				headerText1.getText(),
				"Find all the 3D interior design models created by the community and get inspired for your home interior.");
		Verification.VerifyEquals("Wrong header text 2 displayed !!", headerText2.getText(),
				"A real goldmine for decoration lovers in need of inspiration and those who wish to add exclusive 3D furniture to their HomeByMe projects. Adding unique and innovative design furniture will give you an idea for your future interior!\n\nFeel free to browse through the different pages, using the products filters by availability. Accessories, furniture, household appliances or bedding... Wherever there is a need, there is an idea. You can explore the infinite possibilities of design and discover thousands of exclusive creations.\n\nAnd if you like a product, add it to your project with a single click. You'll then be able to view it in HD in your renderings, as if you were there.\n\nWith HomeByMe, combining trendy brands and exceptional furniture in your home décor projects has never been easier!");
		UtilHBM.turnOffImplicitWaits(driver);
		if (!clearAll.isEmpty()) {
			UtilHBM.reportKO("Clear all option displayed even if filters are not applied!!!");
		}
		UtilHBM.turnOnImplicitWaits(driver);
		Verification.VerifyEquals("Wrong filter label displayed!!", filterLabel.getText(), "Category");
		Verification.VerifyEquals("Wrong applied filter title displayed!!", filterTitle.getText(), "All");
		UtilHBM.waitExplicitDisplayed(driver, productList.get(0));
		int limit = 2;
		if (productList.size() <= limit) {
			limit = productList.size();
		} else {
			UtilHBM.reportInfo("More than 2 products displayed in community content!!Verifying first " + limit
					+ " from the list : ");
		}
		UtilHBM.waitExplicitDisplayed(driver, productList.get(0));
		for (int i = 0; i < limit; i++) {
			UtilHBM.waitExplicitDisplayed(driver, productList.get(i));
			WebElement currentProduct = productList.get(i);
			String imgSrc = currentProduct.findElement(By.cssSelector("div>article>img")).getAttribute("src");
			String prdName = currentProduct.findElement(By.cssSelector("p.product-cartel>span.product-name")).getText();
			String userName = currentProduct.findElement(By.cssSelector("div>a>div.name")).getText();
			String productSrc = currentProduct.findElement(By.cssSelector("p.product-cartel>span.product-mention"))
					.getText();
			productsInList = productsInList + prdName + ";";
			UtilHBM.reportInfo("Verifying product : " + prdName + " , " + productSrc + " , By User : " + userName);
			if (imgSrc.contains("/Thumbnails/") && imgSrc.contains("https://")) {
				UtilHBM.reportOK("Product thumbnail displayed");
			} else {
				UtilHBM.reportKO("Product thumbnail not displayed for product : " + prdName + " , " + productSrc);
			}
			if (!prdName.equals("")) {
				UtilHBM.reportOK("Product name displayed !! Product name : " + prdName);
			} else {
				UtilHBM.reportKO("Product name not displayed!!");
			}
			if (!userName.equals("")) {
				UtilHBM.reportOK("userName displayed !! userName : " + userName);
			} else {
				UtilHBM.reportKO("userName not displayed!!");
			}
			if (productSrc.contains("Created on")) {
				UtilHBM.reportOK("Product source text displayed correctly!!" + productSrc);
			} else {
				UtilHBM.reportKO("Incorrect product source text displayed!! " + productSrc);
			}
		}
		String productsInList1=productsInList.substring(4, productsInList.lastIndexOf(";"));
		setCommunityListItems(productsInList1);
		return this;
	}

	public void setCommunityListItems(String value) {
		listItems = value;
	}
	
	static public String getCommunityListItems() {
		return listItems;
	}

	public CommunityContent applyFilter(String filterApplied) {
		UtilHBM.waitExplicitDisplayed(driver, filterLabel);
		Select select = new Select(filterSelect);
		select.selectByVisibleText(filterApplied);
		return this;
	}

	public CommunityContent verifyFilterApplied(String filterApplied) {
		UtilHBM.waitExplicitDisplayed(driver, filterLabel);
		UtilHBM.waitExplicitDisplayed(driver, productList.get(0).findElement(By.cssSelector("div>article>img[src^='https://']")));
		String[] beforeFilter = getCommunityListItems().split(";");
		if (filterApplied.equalsIgnoreCase("All")) {
			UtilHBM.turnOffImplicitWaits(driver);
			if (!clearAll.isEmpty()) {
				UtilHBM.reportKO("Clear all option displayed even if filters are not applied!!!");
			}
			UtilHBM.turnOnImplicitWaits(driver);
		} else {
			UtilHBM.waitExplicitDisplayed(driver, clearAll.get(0));
			Verification.disabledWebElement(clearAll.get(0));
		}
		UtilHBM.waitExplicitDisplayed(driver, clearAll.get(0));
		Verification.VerifyEquals("Wrong filter label displayed!!", filterLabel.getText(), "Category");
		Verification.VerifyEquals("Wrong applied filter title displayed!!", filterTitle.getText(), filterApplied);
		boolean isListUpdated = false;
		int prdListSize = productList.size();
		if (prdListSize == 0) {
			UtilHBM.reportKO("No results displayed after appling filters!! Filter : " + filterApplied);
		} else {
			int limit = 2;
			if (prdListSize <= limit) {
				limit = prdListSize;
			} else {
				UtilHBM.reportInfo("More than 2 products displayed in community content!!");
			}
			UtilHBM.reportInfo("Verifying first " + limit
					+ " filter results displayed in community content when filters are applied!!");
			UtilHBM.waitExplicitDisplayed(driver, productList.get(0));
			for (int i = 0; i < limit; i++) {
				UtilHBM.waitExplicitDisplayed(driver, productList.get(i));
				WebElement currentProduct = productList.get(i);
				String imgSrc = currentProduct.findElement(By.cssSelector("div>article>img")).getAttribute("src");
				String prdName = currentProduct.findElement(By.cssSelector("p.product-cartel>span.product-name"))
						.getText();
				String userName = currentProduct.findElement(By.cssSelector("div>a>div.name")).getText();
				String productSrc = currentProduct.findElement(By.cssSelector("p.product-cartel>span.product-mention"))
						.getText();
				if (!beforeFilter[i].equals(prdName)) {
					isListUpdated = true;
				}
				UtilHBM.reportInfo("Verifying product : " + prdName + " , " + productSrc + " , By User : " + userName);
				if (imgSrc.contains("/Thumbnails/") && imgSrc.contains("https://")) {
					UtilHBM.reportOK("Product thumbnail displayed");
				} else {
					UtilHBM.reportKO("Product thumbnail not displayed for product : " + prdName + " , " + productSrc);
				}
				if (!prdName.equals("")) {
					UtilHBM.reportOK("Product name displayed !! Product name : " + prdName);
				} else {
					UtilHBM.reportKO("Product name not displayed!!");
				}
				if (!userName.equals("")) {
					UtilHBM.reportOK("userName displayed !! userName : " + userName);
				} else {
					UtilHBM.reportKO("userName not displayed!!");
				}
				if (productSrc.contains("Created on")) {
					UtilHBM.reportOK("Product source text displayed correctly!!" + productSrc);
				} else {
					UtilHBM.reportKO("Incorrect product source text displayed!! " + productSrc);
				}
			}
			if (!isListUpdated) {
				UtilHBM.reportKO("Product list not updated after applying filter : " + filterApplied);
			} else {
				UtilHBM.reportOK("Product list updated after applying filter : " + filterApplied);
			}
		}
		return this;
	}

	public CommunityContent verifyProductSheet(int index) {
		UtilHBM.reportInfo("Verifying product sheet of first product displayed in community content!!");
		UtilHBM.waitExplicitDisplayed(driver, productList.get(0));
		UtilHBM.waitExplicitDisplayed(driver, productList.get(index));
		WebElement productExpected = productList.get(index);
		String imgSrc = productExpected.findElement(By.cssSelector("div>article>img")).getAttribute("src");
		String prdSrc1 = imgSrc.substring(0, imgSrc.indexOf("/Thumbnails/"));
		String productSrc = prdSrc1.substring(prdSrc1.lastIndexOf("/")+1);
		String prdName = productExpected.findElement(By.cssSelector("p.product-cartel>span.product-name")).getText();
		String userName = productExpected.findElement(By.cssSelector("div>a>div.name")).getText();
		openProductSheet(index).verifyProductSheetUserProducts(prdName, userName, productSrc, "")
				.clickUserPrdInfoCloseButton();
		return this;
	}
	
	public ProductInfo openProductSheet(int index) {
		UtilHBM.waitExplicitDisplayed(driver, productList.get(index));
		WebElement productExpected = productList.get(index);
		String prdName = productExpected.findElement(By.cssSelector("p.product-cartel>span.product-name")).getText();
		UtilHBM.reportInfo("Opening product sheet for product : " + prdName);
		UtilHBM.waitExplicitClickable(driver, productExpected);
		productExpected.click();
		return PageFactory.initElements(driver, ProductInfo.class);
	}

	public UserProfilePage checkUserProfilePage(int index) {
		UtilHBM.waitExplicitDisplayed(driver, productList.get(index));
		WebElement productExpected = productList.get(index);
		String userName = productList.get(index).findElement(By.cssSelector("div>a>div.name")).getText();
		String prdName = productExpected.findElement(By.cssSelector("p.product-cartel>span.product-name")).getText();
		UtilHBM.reportInfo("Opening profile page for product : " + prdName);
		UtilHBM.reportInfo("Opening profile page for user : " + userName);
		openProfilePage(index)
			.verifyUserDetails("other", userName)
			.verifyUserProfilePage("others", userName);
		return PageFactory.initElements(driver, UserProfilePage.class);
	}

	public UserProfilePage openProfilePage(int index) {
		UtilHBM.waitExplicitClickable(driver, productList.get(index));
		WebElement profilePageLink = productList.get(index).findElement(By.cssSelector("div>a"));
		profilePageLink.click();
		return PageFactory.initElements(driver, UserProfilePage.class);
	}

	public UserHomePage clickHbmLogo() {
		UtilHBM.waitExplicitClickable(driver, homebymeLink);
		homebymeLink.click();
		return PageFactory.initElements(driver, UserHomePage.class);
	}
}
