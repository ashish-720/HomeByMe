package hr.planner.pageObject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Catalog {
	
	WebDriver driver;

	public Catalog(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css="article[class='mod-panel-catalog-browser-tabs-material mod-open']")
	private WebElement openCatalogPanel;
	
//	@FindBy(xpath="//div[@id='filters']/ul/li[@data-ui-name='materials']/button")
//	private WebElement materialFilter;
	
	@FindBy(xpath="//div[@id='filters']/ul/li[1]/button")
	private WebElement materialFilter;
	
//	@FindBy(xpath="//div[@id='filters']/ul/li[@data-ui-name='types']/button")
//	private WebElement typesFilter;
	@FindBy(xpath="//div[@id='filters']/ul/li[2]/button")
	private WebElement typesFilter;
	
	@FindBy(xpath="//div[@id='filters']/ul/li[@data-ui-name='Colors']/button")
	private WebElement colorsFilter;
	

//	@FindBy(css = "header>ul>li>.bt-icon-alt>.icon-view-maximize")
//	private WebElement maximizeCatalog;
//	Not used
//	@FindBy(css = "header>ul>li>.bt-icon-alt>.icon-view-maximize")
//	private WebElement minimizeCatalog;
	
	@FindBy(css="#catalog-browser>#header-filter>.actions>.close>button")
	private WebElement closeCatalogButton;
	
	@FindBy(xpath = "//div/div/button[@data-ui-action='catalog-search']/span")
	private WebElement searchProd;
	
	@FindBy(xpath = "//div/article/header/div/form/input")
	private WebElement search;
	
	@FindBy(xpath = "//div/form/button/span/span[@class='icon-action-search']")
	private WebElement searchIcon;
	
	@FindBy(xpath = "//div/p/b[.='Search to find the product you want!']")
	private WebElement searchMsg;
	
	@FindBy(xpath = "//article[@class='mod-popin-no-space mod-open']/div/div/h1")
	private List<WebElement> noSpaceAvailableText;
	
	@FindBy(xpath = "//article/div/footer/button[@data-ui-action='primary-button-action']/span")
	private WebElement noSpaceAvailableTextOK;
	
	@FindBy(xpath =  "//span[@data-ui-selector='notification-text']")
	private WebElement favoriteSuccessMsg;
	
	@FindBy(id="bmSVG")
	private WebElement container3D;

	public Catalog addProduct(String productName, String dataId) {		
		
		WebElement product = UtilHBM.webElementXPath(driver, "//span[.='"+productName+"']/../../preceding-sibling::img[@data-ui-id='"+dataId+"'][starts-with(@srcset, 'https')][contains(@srcset, '256.jpg')]/..");
		UtilHBM.waitExplicitClickable(driver, product);
//		product.click();
		new Actions(driver).moveToElement(product).click().build().perform();
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, Catalog.class);		
	}
	
	public Catalog subCategory(String subCategoryName) {		
		
		WebElement category1 = UtilHBM.webElement(driver, "[data-ui-current='"+subCategoryName+"']");
		UtilHBM.waitExplicitClickable(driver, category1);
		category1.click();
		return PageFactory.initElements(driver, Catalog.class);		
	}
	
	public Catalog subSubCategory(String subSubcategoryName) {		
		
		WebElement category2 = UtilHBM.webElement(driver, "[data-ui-subcat='"+subSubcategoryName+"']>button");
		UtilHBM.waitExplicitClickable(driver, category2);
		category2.click();
		return PageFactory.initElements(driver, Catalog.class);		
	}
	
	public Catalog lastUsed(int index) {		
		
		List<WebElement> lastUsed = driver.findElements(By.cssSelector("[data-ui-selector='last-used-list']>div"));
		lastUsed.get(index).click();
		
		return PageFactory.initElements(driver, Catalog.class);		
	}
	
	public HomePlanner closeCatalog(){
		
		closeCatalogButton.click();
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, HomePlanner.class);
	}
	
//here add string of productName and dataId and favListName and favListId when xpath is generic
	
	public Catalog favIconInCatalogList(String dataId, String name, int index) {	
		
		WebElement favIcon = UtilHBM.webElementXPath(driver, "//li[@data-ui-id='"+dataId+"']//div[@class='favorite-button-container']/button");
		UtilHBM.waitExplicitClickable(driver, favIcon);
		favIcon.click();
		UtilHBM.waitFixTime(1000);
		List<WebElement>favList = driver.findElements(By.xpath("//li/article/h3[text()='"+name+"']//following-sibling::button[@class='cta-primary-alt-sm']"));
		favList.get(index).click();
		UtilHBM.waitExplicitDisplayed(driver, favoriteSuccessMsg);
		Verification.displayNAttributeCheckOfElement(favoriteSuccessMsg, "favorite msg", "text", "Product has been added to the list: Retailer Fav List");
		
		return PageFactory.initElements(driver, Catalog.class);		
	}

	public Catalog filter(String material, String types, String colors) {
		UtilHBM.waitFixTime(4000);
		UtilHBM.waitExplicitDisplayed(driver, typesFilter);
		if(!material.isEmpty()) {						
			materialFilter.click();
			WebElement filterCheckBox=driver.findElement(By.xpath("//div[@class='mod-nav-overlay'][@aria-hidden='false']/div/form/ul/li//label/span[normalize-space(.)='"+material+"']/preceding-sibling::input[@data-value='"+material+"']/.."));
			UtilHBM.waitExplicitClickable(driver, filterCheckBox);
			if(!filterCheckBox.findElement(By.tagName("input")).isSelected()){
				filterCheckBox.click();
			}
			Verification.selectedWebElement(driver, filterCheckBox.findElement(By.tagName("input")));
			UtilHBM.waitFixTime(500);
			materialFilter.click();
			//UtilHBM.waitExplicitDisplayed(driver, openCatalogPanel);			
		}
		if(!types.isEmpty()) {			
			typesFilter.click();
			WebElement filterCheckBox=driver.findElement(By.xpath("//div[@class='mod-nav-overlay'][@aria-hidden='false']/div/form/ul/li//label/span[normalize-space(.)='"+types+"']/preceding-sibling::input[@data-value='"+types+"']/.."));
			UtilHBM.waitExplicitClickable(driver, filterCheckBox);
			if(!filterCheckBox.findElement(By.tagName("input")).isSelected()){
				filterCheckBox.click();
			}
			UtilHBM.waitFixTime(500);
			Verification.selectedWebElement(driver, filterCheckBox.findElement(By.tagName("input")));
			UtilHBM.waitFixTime(500);
			typesFilter.click();
			//UtilHBM.waitExplicitDisplayed(driver, openCatalogPanel);
		}		
		if(!colors.isEmpty()) {	
			colorsFilter.click();
			WebElement filterCheckBox=driver.findElement(By.xpath("//div[@class='mod-nav-overlay'][@aria-hidden='false']/div/form/ul/li//label/span[normalize-space(.)='"+colors+"']/preceding-sibling::input[@data-value='"+colors+"']/.."));
			UtilHBM.waitExplicitClickable(driver, filterCheckBox);
			if(!filterCheckBox.findElement(By.tagName("input")).isSelected()){
				filterCheckBox.click();
			}
			Verification.selectedWebElement(driver, filterCheckBox.findElement(By.tagName("input")));
			UtilHBM.waitFixTime(500);
			colorsFilter.click();
			//UtilHBM.waitExplicitDisplayed(driver, openCatalogPanel);
		}		
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, Catalog.class);
	}
	
	protected Catalog searchProduct(String searchProduct) {
		
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, searchMsg);
		search.sendKeys(searchProduct);
		UtilHBM.waitExplicitClickable(driver, searchIcon);
		searchIcon.click();
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, Catalog.class);
	}
	
	public Catalog clickOnWall(int xOffset, int yOffset) {
		Actions action = new Actions(driver);
		action.moveToElement(container3D, xOffset, yOffset).clickAndHold()
				.pause(500).release().build().perform();
		return PageFactory.initElements(driver, Catalog.class);
	}
	
	public Catalog moveWall(int x, int y, int x1, int y1) {
		//clickBlank();
		clickBlankSpace();
		UtilHBM.waitFixTime(2000);
		Actions action = new Actions(driver);
//		action.moveToElement(container3D, x, y - 10).clickAndHold().pause(500).release().pause(500).build().perform();
		action.moveToElement(container3D, x, y).clickAndHold().pause(1000).dragAndDropBy(container3D, x1, y1)
				.pause(1000).release().build().perform();
		//clickBlank();
		clickBlankSpace();
		return this;
	}
	
	private Catalog clickBlankSpace(){
//		new Actions(driver).moveToElement(container3D, 10, 10).pause(1000).click().build().perform();
		new Actions(driver).moveToElement(container3D, 20-container3D.getRect().getWidth()/2, 10-container3D.getRect().getHeight()/2).clickAndHold().pause(500).release().build().perform();
//		new Actions(driver).moveToElement(container3D, 10, 10).click().build().perform();
//		UtilHBM.waitFixTime(500);
		return PageFactory.initElements(driver, Catalog.class);
	}
	
	public HomePlanner clickInPlanner(int xOffset, int yOffset) {
		Actions action = new Actions(driver);
		action.moveToElement(container3D, xOffset, yOffset).clickAndHold()
				.pause(500).release().build().perform();
		return PageFactory.initElements(driver, HomePlanner.class);
	}


	public Catalog addProductUsingDragDrop(String productName, String dataId, int finalxcoordinate, int finalycoordinate) {
		WebElement product = UtilHBM.webElementXPath(driver, "//span[.='"+productName+"']/../../preceding-sibling::img[@data-ui-id='"+dataId+"'][starts-with(@srcset, 'https')][contains(@srcset, '256.jpg')]/..");
		UtilHBM.waitExplicitClickable(driver, product);
		Actions actions = new Actions(driver);
		UtilHBM.scrollToElementWithOffset(driver, product,0);
		UtilHBM.waitFixTime(1000);
		actions.clickAndHold(product).pause(500).moveToElement(container3D, finalxcoordinate, finalycoordinate).pause(500).release().build().perform();
		return PageFactory.initElements(driver, Catalog.class);
	}

}
