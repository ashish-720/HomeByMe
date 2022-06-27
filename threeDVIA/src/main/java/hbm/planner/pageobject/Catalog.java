package hbm.planner.pageobject;

import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import hbm.web.pageobject.FloorplanInfoPage;
import hbm.web.pageobject.IDSInfoPage;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Catalog {

	private String tabName;	
	private String mainCatagory;
	private String typeOfProduct;
	private String filter;
	private String productPath;
	
	WebDriver driver;

	public Catalog(WebDriver driver) {
		this.driver = driver;		
	}
	
	@CacheLookup
	@FindBy(css=".panelProduct>.panelProduct-head>span")
	private WebElement addAProductTitle;
	
	@CacheLookup
	@FindBy(css=".panelProduct>.panelProduct-head>form>#catalogSearchBar-form-input")
	private WebElement searchField;
	
	@CacheLookup
	@FindBy(css=".panelProduct>.panelProduct-head>form>#catalogSearchBar-form-button")
	private WebElement searchButton;
	
	@CacheLookup
	@FindBy(css=".panelProduct>.panelProduct-head>.panelProduct-btn")
	private WebElement closeButton;
	
//	@FindBy(css=".panelProduct-inner-full .tab-list>.tab-item>a")
//	List<WebElement> tabList;
	
	@FindBy(xpath="//body/div/div/div/div/div/div/ul/li/a[@class='tab-link tab-catalog is-active']/..")
	private WebElement tab;
	
	@FindBy(css=".panelProduct>div>div>div>div>div>div .breadcrumbs-item")
	private List<WebElement> listCurrentPath;
	
	
	@FindBy(css="#catalog-content .catalog-inner.catalog-brand-old")
	private List<WebElement> catagoryBrandList;
	
	@FindBy(css="#catalog-content>div>div[class='catalog-item']>.catalog-inner")			
	private List<WebElement> catagoryList;	
	
	@FindBy(css="#catalog-content>div>div[class='catalog-item -service']>.catalog-inner")			
	private WebElement idsFpServices;
	
	@FindBy(css="#catalog-content .sidebar #catalog-filter .expander-group>ul>li>input")
	private List<WebElement> filterCheckBoxList;
	
	@FindBy(css="#catalog-content .sidebar #catalog-filter .expander-group>ul>li>label")
	private List<WebElement> filterList;
	
	@FindBy(css="#catalog-content .sidebar .sidebar-count>#count-products")
	private WebElement productCount;
	
	@FindBy(css="#totalCount-products[style='']")
	private WebElement productCountAfterFilter;
	
	@FindBy(css="#catalog-content #catalog-thumbnail .u-mbs.product.w-25")
	private List<WebElement> productList;
	
	@FindBy(css=".tabs-container>div>div>div>div>.list-item")
	private List<WebElement> favProductList;
	
	@FindBy(css="#catalog-content .w-75>.show-more>#moreResults")
	private List<WebElement> showMoreButtonList;
	
	@FindBy(css="#catalog-content>div>div>div[data-ui-action='create-list']")
	private WebElement createFavList;
	
	@FindBy(css=".modal.modal-info-services.with-footer.current>div>div>div>input")
	private WebElement favNameInputBox;
	
	@FindBy(css=".modal.modal-info-services.with-footer.current>div>div>footer>a[data-ui-action='create-new-list']")
	private WebElement favNameCreateButton;
	
	@FindBy(css=".favorite-list-item-wrapper>header>.header-list-info>div")
	private WebElement favTitle;
	
	@FindBy(css=".favorite-list-item-wrapper>header>.header-list-action>a[href='javascript:void(0);']")
	private WebElement deleteFav;
	
	@FindBy(css=".notifMsg.notif-catalog>div>div")
	private WebElement favNotification;
	
	@FindBy(css=".notifMsg.notif-catalog>div>.notifMsg-item-cta>a")
	private WebElement closeFavNotification;
	
	@FindBy(css=".tabs-container>div>div>div>div>svg+span+a")
	private WebElement exploreCatalogForFavorite;
	
	@FindBy(css = ".community-catalog-top-view>div>form>[name='the_search']")
	WebElement searchCommunityContent;
	
	@FindBy(css = ".community-catalog-top-view>div>form>[name='the_search']")
	WebElement titleCommunityContent;
	
	@FindBy(css=".modal.modal-info-services.with-footer.current>div>div>p[data-i18n='favoriteListItem.favoriteDeleteList.modal.confirmDeletion']")
	private WebElement deleteFavConfirmationMsg;
	
	@FindBy(css=".modal.modal-info-services.with-footer.current>div>div>footer>a[data-ui-action='delete-current-list'")
	private WebElement deleteFavConfirmationOKBtn;
	
	private String deleteFavListConfirmMsg = "Are you sure you want to permanently delete the selected list ?";
	
	
	protected ThreeDPlanner addProduct(String product){		
		WebElement addThisProduct = setProduct(product, 0, 1, 0).findElement(By.cssSelector(".product-thumb-action span"));
		new Actions(driver).moveToElement(locateProduct(productList, product)).build().perform();
		UtilHBM.waitExplicitDisplayed(driver, addThisProduct);
		Verification.displayNAttributeCheckOfElement(addAProductTitle, "Catalog Panel title", "text", "Add a product");
		addThisProduct.click();
		UtilHBM.waitTillElementDisappear(driver, closeButton);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	protected ThreeDPlanner addProductFromInfoPage(String product){
		WebElement addThisProduct = setProduct(product, 0, 1, 0);
		String productInfo = productDetails(addThisProduct);	
		UtilHBM.waitExplicitClickable(driver, addThisProduct.findElement(By.tagName("img")));
		new Actions(driver).moveToElement(addThisProduct.findElement(By.tagName("img")), 0, -40).click().build().perform();
//		addThisProduct.findElement(By.tagName("img")).click();		
		driver.switchTo().parentFrame();
		ProductInfo info = PageFactory.initElements(driver, ProductInfo.class);
		info.addProductFromInfo(productInfo);
		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
		UtilHBM.waitTillElementDisappear(driver, closeButton);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	protected ThreeDPlanner addProductOtherModelFromInfo(String product, int model){
		WebElement addThisProduct = setProduct(product, 0, 1, 0);
		String productInfo = productDetails(addThisProduct);
		new Actions(driver).moveToElement(addThisProduct.findElement(By.tagName("img")), 0, -20).click().build().perform();
//		addThisProduct.findElement(By.tagName("img")).click();		
		driver.switchTo().parentFrame();
		ProductInfo info = PageFactory.initElements(driver, ProductInfo.class);
		info.addProductOtherModelFromInfo(productInfo, model);	
		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
		UtilHBM.waitTillElementDisappear(driver, closeButton);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	protected ThreeDPlanner addProductSearch(String product){
		WebElement addThisProduct = setProduct(product, 0, 1, 1).findElement(By.cssSelector(".product-thumb-action span"));
		addThisProduct.click();
		UtilHBM.waitTillElementDisappear(driver, closeButton);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	protected ThreeDPlanner addProductfromBrands(String product){
		WebElement addThisProduct = setProduct(product, 1, 0, 0).findElement(By.cssSelector(".product-thumb-action span"));
		new Actions(driver).moveToElement(locateProduct(productList, product)).build().perform();
		UtilHBM.waitExplicitDisplayed(driver, addThisProduct);
		Verification.displayNAttributeCheckOfElement(addAProductTitle, "Catalog Panel title", "text", "Add a product");
		addThisProduct.click();
		UtilHBM.waitTillElementDisappear(driver, closeButton);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	protected ThreeDPlanner addProductfromFavorites(String favListName, String product){
		WebElement favCatagory=driver.findElement(By.xpath("//div[@class='tabs-container']/div/div/div/div/div/span[.='"+favListName + "']/.."));
		favCatagory.click();
		if(!(favTitle.getText().equalsIgnoreCase(favListName) || deleteFav.isDisplayed())){
			UtilHBM.reportKO("Favorite Title or DELETE button is not displayed in Favorite Tab");
		}
		WebElement addThisProduct = setFavProduct(product).findElement(By.cssSelector(".product-thumb-action span"));
		new Actions(driver).moveToElement(addThisProduct).build().perform();
		UtilHBM.waitExplicitClickable(driver, addThisProduct);
		addThisProduct.click();
		UtilHBM.waitTillElementDisappear(driver, closeButton);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	
	
	protected ThreeDPlanner addProductfromCommunityContentSearch(String searchProduct, String product, String productID){
		
		UtilHBM.waitExplicitDisplayed(driver, searchCommunityContent);
		searchCommunityContent.sendKeys(searchProduct + Keys.ENTER);
		UtilHBM.waitFixTime(500);
		new Actions(driver).moveToElement(locateProduct(productList, product)).build().perform();
		WebElement addProduct = UtilHBM.webElementXPath(driver, "//div[@class='product-thumb-action']/a[@data-id='"+productID+"']//span[@data-i18n='catalog.add_to_project']");
		UtilHBM.waitExplicitClickable(driver, addProduct);
		addProduct.click();
		UtilHBM.waitTillElementDisappear(driver, closeButton);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	protected ThreeDPlanner addProductWithoutFilter(String product){
		WebElement addThisProduct = setProduct(product, 0, 0, 0).findElement(By.cssSelector(".product-thumb-action span"));
		addThisProduct.click();
		UtilHBM.waitTillElementDisappear(driver, closeButton);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	protected ThreeDPlanner addPartnerProduct (String product){
		WebElement addThisProduct = locateProduct(productList, product).findElement(By.cssSelector(".product-thumb-action span"));
		new Actions(driver).moveToElement(addThisProduct).build().perform();
		addThisProduct.click();
		UtilHBM.waitTillElementDisappear(driver, closeButton);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	protected ThreeDPlanner replaceProduct(String product){
		new Actions(driver).moveToElement(locateProduct(productList, product)).build().perform();		
		WebElement addThisProduct = locateProduct(productList, product).findElement(By.cssSelector(".product-thumb-action span"));
		UtilHBM.waitExplicitDisplayed(driver, addThisProduct);
		Verification.displayNAttributeCheckOfElement(addAProductTitle, "Catalog Panel title", "text", "Replace product");
		addThisProduct.click();
		UtilHBM.waitTillElementDisappear(driver, closeButton);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	protected ThreeDPlanner replaceFrmPrdSheet(String product){
		
		new Actions(driver).moveToElement(locateProduct(productList, product)).build().perform();		
		WebElement openThisProduct = locateProduct(productList, product).findElement(By.cssSelector(".product-legend a"));
		UtilHBM.waitExplicitDisplayed(driver, openThisProduct);
		//Verification.displayNAttributeCheckOfElement(addAProductTitle, "Catalog Panel title", "text", "Replace product");
		openThisProduct.click();
		UtilHBM.waitFixTime(1000);
		driver.switchTo().parentFrame();
		ProductInfo info = PageFactory.initElements(driver, ProductInfo.class);
		info.replaceFrmPrdSheet(product);
		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
		UtilHBM.waitTillElementDisappear(driver, closeButton);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	protected String productDetails(WebElement product){
		String img = product.findElement(By.tagName("img")).getAttribute("src");
		String brand = product.findElement(By.tagName("h3")).getText().toUpperCase();
		String productName = product.findElement(By.cssSelector(".product-legend>a")).getText();		
		String brandProductImg = brand+">" + productName + ">" + img;		
		return brandProductImg;		
	}	

	protected ThreeDPlanner addProductDipricated(String product) {
		String productPath;
		if(driver.getCurrentUrl().contains("preprod") ||driver.getCurrentUrl().contains("rel")){
			
			productPath= UtilHBM.getKeyValue(Setting.catalogPreprodPath).get(product);
		}else{
			productPath= UtilHBM.getKeyValue(Setting.catalogPath).get(product);
		}
		
		if(!productPath.equalsIgnoreCase("Search")){
			tabName=productPath.split(">")[0];		
			mainCatagory = productPath.split(">")[1];
			typeOfProduct = productPath.split(">")[2];
			if(!(tabName.equalsIgnoreCase(UtilHBM.webElement(driver, ".tab-link.tab-catalog.u-txtCapitalize.is-active").getAttribute("innerHTML")))){
				driver.findElement(By.linkText(tabName)).click();			
			}		
			int i =0;
			while ((UtilHBM.listOfWebElement(driver, ".breadcrumbs-item").size()>1) && i<4) {			
				UtilHBM.listOfWebElement(driver, ".breadcrumbs-item").get(0).click();					
				if(tabName.equalsIgnoreCase("Brand Corner")){
					if (!(UtilHBM.listOfWebElement(driver, "a[data-id='"+ typeOfProduct.toUpperCase() + "']").size()>0)){
						driver.findElement(By.linkText(tabName)).click();
					}
					i++;						
				}else{
					if (!(driver.findElements(By.linkText(typeOfProduct)).size()>0)){
						driver.findElement(By.linkText(tabName)).click();
					}						
					i++;
				}		
			}
			if(tabName.equalsIgnoreCase("Brand Corner")){
				UtilHBM.waitExplicitClickable(driver, UtilHBM.webElement(driver, "a[data-id='" +typeOfProduct.toUpperCase() + "']"));
				UtilHBM.webElement(driver, "a[data-id='"+ typeOfProduct.toUpperCase() + "']").click();
			}else{
				UtilHBM.waitExplicitClickable(driver, driver.findElement(By.linkText(typeOfProduct)));
				driver.findElement(By.xpath("//span[.='" +mainCatagory + "']/../following-sibling::ul")).findElement(By.linkText(typeOfProduct)).click();
				System.out.println(typeOfProduct + " clicked");
			}			
			if(productPath.split(">").length>3){				
				filter=productPath.split(">")[3];
				int l=0;
				do {
					driver.findElement(By.cssSelector("label[for*='" + filter +"']")).click();
					l++;
				}while(!(driver.findElement(By.cssSelector(".filter-item.u-floatLeft[id*='" + filter+"']")).isSelected())&&l<4);
				UtilHBM.waitFixTime(1000);
				int m=Integer.parseInt(driver.findElement(By.cssSelector("label[for*='" + filter +"']")).getText().split("\\(")[1].replace(")", ""));
				int n = Integer.parseInt(UtilHBM.webElement(driver, "#count-products").getText());
				int o = UtilHBM.listOfWebElement(driver, ".product-thumb").size();
				if(m==n && n==o){
					UtilHBM.reportOK("Filter applied in catalog for adding product in project");				
				}else if(UtilHBM.listOfWebElement(driver, "#moreResults").size()>0){
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
					int j=0;
					while(UtilHBM.listOfWebElement(driver, ".buttonFavoriteMoreResults").size()>0 && 
							!(UtilHBM.listOfWebElement(driver, ".show-more[style='display: none;']").size()>0)){
						UtilHBM.webElement(driver, ".buttonFavoriteMoreResults").click();
						UtilHBM.waitFixTime(3000);
						j++;
					}
					UtilHBM.reportInfo("Number of times Show More result appear: " +j);						
					m=Integer.parseInt(driver.findElement(By.cssSelector("label[for*='" + filter +"']")).getText().split("\\(")[1].split("\\)")[0]);
					n = Integer.parseInt(UtilHBM.webElement(driver, "#count-products").getText());
					o = UtilHBM.listOfWebElement(driver, ".product-thumb").size();
					if(m==n && n==o){
						UtilHBM.reportOK("Filter applied in catalog for adding product in project");
					}else{
						UtilHBM.reportWarning("Number of filtered item (after applying filter while adding product in project) varification failed. Check filters in catalog");
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				}else{
					UtilHBM.reportWarning("Number of filtered item (after applying filter while adding product in project) varification failed. Check filters in catalog");					
				}
			}
			UtilHBM.waitFixTime(2000);
			if(driver.findElements(
					By.xpath("//a[.='"
							+ product
							+ "']/../preceding-sibling::div//span")).size()>0){
				driver.findElements(
						By.xpath("//a[.='"
								+ product
								+ "']/../preceding-sibling::div//span")).get(0)
						.click();
			}else if(driver.findElements(				
					By.cssSelector("a[data-id='"+ product +"'] span")).size()>0){			
				driver.findElement(
						By.cssSelector("a[data-id='"+ product +"'] span")).click();			
			}else if(UtilHBM.listOfWebElement(driver, "#moreResults").size()>0){
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
				int j=0;
				while(UtilHBM.listOfWebElement(driver, ".buttonFavoriteMoreResults").size()>0 && 
						!(UtilHBM.listOfWebElement(driver, ".show-more[style='display: none;']").size()>0)){
					UtilHBM.webElement(driver, ".buttonFavoriteMoreResults").click();
					UtilHBM.waitFixTime(3000);
					j++;
				}
				UtilHBM.reportInfo("Number of times Show More result appear: " +j);	
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				if(driver.findElements(
						By.xpath("//a[.='"
								+ product
								+ "']/../preceding-sibling::div//span")).size()>0){
					driver.findElements(
							By.xpath("//a[.='"
									+ product
									+ "']/../preceding-sibling::div//span")).get(0)
							.click();
				}else {				
					driver.findElement(
							By.cssSelector("a[data-id='"+ product +"'] span")).click();				
				}			
			}else{
				UtilHBM.reportKO(product + " could not be added in project");
				driver.findElements(
						By.xpath("//a[.='"
								+ product
								+ "']/../preceding-sibling::div//span")).get(0)
						.click();			
			}								
		}else{
			UtilHBM.webElement(driver, "#catalogSearchBar-form-input").clear();
			UtilHBM.webElement(driver, "#catalogSearchBar-form-input").sendKeys(product);
			UtilHBM.waitFixTime(1000);
			UtilHBM.webElement(driver, "#catalogSearchBar-form-button").click();
			UtilHBM.waitFixTime(1000);
			if(UtilHBM.listOfWebElement(driver, "#moreResults").size()>0){
				List<WebElement> prodList = driver.findElements(By.xpath("//a[.='"+ product + "']/../preceding-sibling::div//span")); 
				while(UtilHBM.listOfWebElement(driver, "#moreResults").size()>0 && prodList.size()==0){
					UtilHBM.webElement(driver, "#moreResults").click();
					UtilHBM.waitFixTime(2000);
					prodList = driver.findElements(By.xpath("//a[.='"+ product + "']/../preceding-sibling::div//span"));
				}
			}
			driver.findElements(By.xpath("//a[.='"+ product + "']/../preceding-sibling::div//span")).get(0).click();
			UtilHBM.reportOK(product + "searched successful");				
		}	
		return PageFactory.initElements(driver, ThreeDPlanner.class);		
	}
		
	private WebElement setProduct (String product, int fromBrands, int applyFilter, int search){
		WebElement productToBeAdded;
		if(search==0){
		setProductPath(product);
		setTabName();
		setMainCatagory();
		setTypeOfProduct();
		setFilter();
		
		if(fromBrands>0){
			this.tabName = "Brand corner";
		}
		if(listCurrentPath.get(0).getText().contains("Back")){
			listCurrentPath.get(0).click();
		}											
//						for(WebElement tab:tabList){
//							if(tab.getAttribute("innerHTML").equalsIgnoreCase(tabName) && !tab.getAttribute("class").contains("is-active")){						
//								tab.click();
//							}			
//							int i=0;
//							int j=0;
//							while(listCurrentPath.size()>1 && j<4){
//								listCurrentPath.get(0).click();
//								driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//								if(tabName.equalsIgnoreCase("Brand Corner")){
//									while(!(catagoryBrandList.size()>0)&& i<4){
//										tab.click();
//										i++;
//									}
//								}else{
//									while(!(catagoryList.size()>0)&& i<4){								
//										tab.click();								
//										i++;
//									}
//								}						
//								j++;
//								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//							}
//						}
			int i=0;
			int j=0;
			while(listCurrentPath.size()>1 && j<4){
				listCurrentPath.get(0).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
				if(tabName.equalsIgnoreCase("Brand Corner")){
					while(!(catagoryBrandList.size()>0)&& i<1){
						tab.click();							
						i++;
					}
				}else{
					while(!(catagoryList.size()>0)&& i<1){								
						tab.click();								
						i++;
					}
				}						
				j++;
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			}
			if(tabName.equalsIgnoreCase("Brand Corner")){
				getCatagoryFromList(catagoryBrandList).get(filter).click();
			}else{
				getCatagoryFromList(catagoryList).get(mainCatagory+typeOfProduct).click();
			}				
			if(applyFilter==1 && !tabName.equalsIgnoreCase("Brand Corner")){					
//					int l=0;
//					do {
//						driver.findElement(By.cssSelector("label[for*='" + filter +"']")).click();
//						l++;
//					}while(!(driver.findElement(By.cssSelector(".filter-item.u-floatLeft[id*='" + filter+"']")).isSelected())&&l<4);
				driver.findElement(By.cssSelector("label[for*='" + filter +"']")).click();
				UtilHBM.waitExplicitDisplayed(driver, productCountAfterFilter);
				UtilHBM.waitFixTime(500);
				int m=Integer.parseInt(driver.findElement(By.cssSelector("label[for*='" + filter +"']")).getText().split("\\(")[1].replace(")", ""));
				int n = Integer.parseInt(productCount.getText());
				int o = productList.size();
				if(m==n && n==o){
					UtilHBM.reportOK("Filter applied in catalog for adding product in project");				
				}else if(showMoreButtonList.size()>0){
					int x=1;
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));						
					while(showMoreButtonList.size()>0 &&showMoreButtonList.get(0).isDisplayed()){	
						if(!(productList.size()/x==60)){
							UtilHBM.reportKO("Number of products per page in catalog is not 60");
						}
						showMoreButtonList.get(0).click();
						UtilHBM.waitFixTime(3000);
						x++;														
					}											
					m=Integer.parseInt(driver.findElement(By.cssSelector("label[for*='" + filter +"']")).getText().split("\\(")[1].split("\\)")[0]);
					n = Integer.parseInt((productCount).getText());
					o = productList.size();
					if(m==n && n==o){
						UtilHBM.reportOK("Filter applied in catalog for adding product in project");
					}else{
						UtilHBM.reportWarning("Number of filtered item (after applying filter while adding product in project) varification failed. Check filters in catalog");
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				}else{
					UtilHBM.reportWarning("Number of filtered item (after applying filter while adding product in project) varification failed. Check filters in catalog");					
				}
			}
			UtilHBM.waitFixTime(2000);				
			productToBeAdded = locateProduct(productList, product);
	
		}else{				
			searchField.clear();
			searchField.sendKeys(product);
			UtilHBM.waitFixTime(1000);
			searchButton.click();
			UtilHBM.waitFixTime(2000);
			productToBeAdded = locateProduct(productList, product);			
		}
		try{
			UtilHBM.scrollToElementWithOffset(driver, productToBeAdded, 400);
		}catch (Exception JavascriptException){
			UtilHBM.reportWarning("Trying with direct move");
		}
		
		return productToBeAdded;
	}

	
	private WebElement setFavProduct(String product){
		WebElement productToBeAdded=null;
		Map<String, WebElement> map = new HashMap<String, WebElement>();
		for(WebElement prd:productList){
			String key1 = prd.findElement(By.cssSelector(".product-legend>.item-name")).getText();
			String key2 = prd.getAttribute("data-db-id");
			map.put(key1, prd);
			map.put(key2, prd);
		}
		productToBeAdded=map.get(product);
		return productToBeAdded;		
	}

		private void setProductPath(String product) {
			String productPath;
			if(driver.getCurrentUrl().contains("preprod") ||driver.getCurrentUrl().contains("rel")){
				
				productPath= UtilHBM.getKeyValue(Setting.catalogPreprodPath).get(product);
			}else{				
				productPath= UtilHBM.getKeyValue(Setting.catalogPath).get(product);				
			}
			this.productPath = productPath;
		}		
				
		private void setTabName() {
			String tabName=null;
			tabName =productPath.split(">")[0];				
			this.tabName = tabName;
		}

		private void setMainCatagory() {
			String mainCatagory = "";
			if(!productPath.equalsIgnoreCase("Search") && !tabName.equalsIgnoreCase("Brand Corner")){
				mainCatagory =productPath.split(">")[1];				
			}
			this.mainCatagory = mainCatagory;
		}

		private void setTypeOfProduct() {
			String typeOfProduct = null;
			if(!productPath.equalsIgnoreCase("Search")){
				typeOfProduct =productPath.split(">")[2];				
			}
			this.typeOfProduct = typeOfProduct;
		}

		private void setFilter() {
			String filter =null;
			if(!productPath.equalsIgnoreCase("Search") && productPath.split(">").length>3){
				filter =productPath.split(">")[3];				
			}
			this.filter = filter;
		}
		
		private WebElement locateProduct (List<WebElement> productList, String product){
			WebElement productToBeAdded= getProductFromList(productList).get(product);
			if(productToBeAdded==null){
				if(showMoreButtonList.size()>0){	
					int x=1;
					while(showMoreButtonList.size()>0 && showMoreButtonList.get(0).isDisplayed() && productToBeAdded==null){
						if(!(productList.size()/x==60)){
							UtilHBM.reportKO("Number of products per page in catalog is not 60");
						}						
						showMoreButtonList.get(0).click();
						UtilHBM.waitFixTime(6000);
						x++;						
						productToBeAdded= getProductFromList(productList).get(product);
					}					
				}
				productToBeAdded= getProductFromList(productList).get(product);
			}	
			return productToBeAdded;
		}
		
		private Map<String, WebElement> getProductFromList(List<WebElement> productList){
			Map<String, WebElement> map = new HashMap<String, WebElement>();
			for(WebElement product:productList){
				String key1 = product.findElement(By.cssSelector(".product-legend a")).getText();
				String key2 = product.findElement(By.cssSelector(".product-legend a")).getAttribute("data-id");
				map.put(key1, product);
				map.put(key2, product);
			}		
			
			return map;
		}
		
		private Map<String, WebElement> getCatagoryFromList(List<WebElement> catagoryList){			
			String tempMainCatagory;
			String tempTypeOfProduct;			
			WebElement catagoryToClick;
			Map<String, WebElement> map = new HashMap<String, WebElement>();
			if(!tabName.equalsIgnoreCase("Brand Corner")){
				for(WebElement catagory:catagoryList){				
					tempMainCatagory = catagory.findElement(By.cssSelector("h2>span")).getText();
					for(WebElement type: catagory.findElements(By.cssSelector("ul>li>a"))){
						tempTypeOfProduct = type.getText();						
						catagoryToClick = type;					
						map.put(tempMainCatagory+tempTypeOfProduct, catagoryToClick);
					}					
				}
			}else{				
				catagoryToClick = driver.findElement(By.cssSelector(".catalog-inner.catalog-brand-old>a[data-id='" + filter + "']"));					
				map.put(filter, catagoryToClick);
			}		
			return map;
		}
		
		protected ThreeDPlanner createFavList(String listName, String prodictList, boolean isNewProduct){
			List<WebElement> favList = driver.findElements(By.xpath("//div[@class='favorite-lists-container']/div/div/span[@class='favorite-list-name']"));
			List<WebElement> favNameList = driver.findElements(By.xpath("//div[@class='favorite-lists-container']/div/div/span[@class='favorite-list-name'][.='"+listName +"']"));
			int i= favList.size();
			int j = favNameList.size();
			if(!createFavList.getText().contains("Create a list")){
				UtilHBM.reportKO("Create a list Text is not available in create list button in Favorites Tab");
			}
			createFavList.click();
			UtilHBM.waitExplicitDisplayed(driver, favNameCreateButton);
			UtilHBM.waitExplicitClickable(driver, favNameInputBox);
			favNameInputBox.sendKeys(listName);
			favNameCreateButton.click();
			UtilHBM.waitExplicitDisplayed(driver, favNotification);
			if(!favNotification.getText().equalsIgnoreCase("Your list "+listName +" has been created")){
				UtilHBM.reportKO("Notification for 'favorite list " +listName +" has been created' is not displayed");				
			}
			closeFavNotification.click();
			List<WebElement> favList1 = driver.findElements(By.xpath("//div[@class='favorite-lists-container']/div/div/span[@class='favorite-list-name']"));
			List<WebElement> favNameList1 = driver.findElements(By.xpath("//div[@class='favorite-lists-container']/div/div/span[@class='favorite-list-name'][.='"+listName +"']"));			
			if(favList1.size()==(i+1) && favNameList1.size()==(j+1)){
				UtilHBM.reportOK("Favorite list " +listName +" has been created");
			}else{
				UtilHBM.reportKO("Favorite list " +listName +" creation failed");
				System.out.println("i & j are " + i + j + favList.size() + favNameList.size());
			}
			
			if(!prodictList.isEmpty()){
				WebElement favCatagory=driver.findElement(By.xpath("//div[@class='tabs-container']/div/div/div/div/div/span[.='"+listName + "']/.."));
				favCatagory.click();
				exploreCatalogForFavorite.click();
				for(String prd:prodictList.split(";")){
					WebElement setPrd = setProduct(prd, 0, 1, 0);
					WebElement addThisProduct = setPrd.findElement(By.cssSelector("a[data-ui-action='add-favorites']"));
					String productInfo = productDetails(setPrd);
					new Actions(driver).moveToElement(addThisProduct).build().perform();
					UtilHBM.waitExplicitDisplayed(driver, addThisProduct);
					addThisProduct.click();
					driver.switchTo().parentFrame();
					SelectFavList fav = PageFactory.initElements(driver, SelectFavList.class);
					fav.selectFavList(productInfo, listName, "existing", isNewProduct);
					driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
				}
			}
			closeButton.click();
			return PageFactory.initElements(driver, ThreeDPlanner.class);
		}	
		
		protected ThreeDPlanner deleteFavList(String listName){
			List<WebElement> favList = driver.findElements(By.xpath("//div[@class='favorite-lists-container']/div/div/span[@class='favorite-list-name']"));
			List<WebElement> favNameList = driver.findElements(By.xpath("//div[@class='favorite-lists-container']/div/div/span[@class='favorite-list-name'][.='"+listName +"']"));
			int i= favList.size();
			int j = favNameList.size();
			WebElement favCatagory=driver.findElement(By.xpath("//div[@class='tabs-container']/div/div/div/div/div/span[.='"+listName + "']/.."));
			favCatagory.click();
			deleteFav.click();
			UtilHBM.waitExplicitClickable(driver, deleteFavConfirmationMsg);			
			if(!(deleteFavConfirmationMsg.getText().equalsIgnoreCase(deleteFavListConfirmMsg) 
					&& deleteFavConfirmationMsg.isDisplayed())){
				UtilHBM.reportKO("Delete confirmation message is either not displayed or is not correct");
			}
			deleteFavConfirmationOKBtn.click();
			UtilHBM.waitExplicitDisplayed(driver, favNotification);
			if(!favNotification.getText().equalsIgnoreCase("Your list \""+ listName+ "\" has been removed")){
				UtilHBM.reportKO("Notification for 'Favorite list " + listName + "has been deleted' is not displated");
			}
			closeFavNotification.click();
			List<WebElement> favList1 = driver.findElements(By.xpath("//div[@class='favorite-lists-container']/div/div/span[@class='favorite-list-name']"));
			List<WebElement> favNameList1 = driver.findElements(By.xpath("//div[@class='favorite-lists-container']/div/div/span[@class='favorite-list-name'][.='"+listName +"']"));			
			if(favList1.size()==(i-1) && favNameList1.size()==(j-1)){
				UtilHBM.reportOK("Favorite list " +listName +" has been deleted");
			}else{
				UtilHBM.reportKO("Favorite list " +listName +" deletion failed");
			}
			closeButton.click();
			return PageFactory.initElements(driver, ThreeDPlanner.class);
		}
		
		protected ThreeDPlanner removePrdFromFav (String listName, String product){
			WebElement favCatagory=driver.findElement(By.xpath("//div[@class='tabs-container']/div/div/div/div/div/span[.='"+listName + "']/.."));
			favCatagory.click();
			UtilHBM.waitExplicitDisplayed(driver, favTitle);
			Verification.verifyText(favTitle, listName, "Favorite list title");
			Map<String, WebElement> map = new HashMap<String, WebElement>();
			for(WebElement prd:favProductList){
				String key1 = prd.findElement(By.cssSelector(".product-legend span+span")).getText();
				String key2 = prd.getAttribute("data-db-id");
				map.put(key1, prd);
				map.put(key2, prd);
			}
			int i = favProductList.size();
			WebElement productToBeRemoved = map.get(product).findElement(By.cssSelector("a[data-ui-action='item-remove']"));
			new Actions(driver).moveToElement(map.get(product)).build().perform();
			UtilHBM.waitExplicitClickable(driver, productToBeRemoved);
			productToBeRemoved.click();
			UtilHBM.waitExplicitClickable(driver, favNotification);
			if(!favNotification.getText().equalsIgnoreCase("Your product has been removed from the list "+ listName)){
				UtilHBM.reportKO("Notification for 'your product has been removed frmo favorite list' is not displayed.");				
			}
			closeFavNotification.click();
			if(favProductList.size()==(i-1)){
				UtilHBM.reportOK(product +" is removed from favorite list");
			}else{
				UtilHBM.reportKO(product +" is not removed from favorite list");				
			}
			closeButton.click();
			return PageFactory.initElements(driver, ThreeDPlanner.class);
		}
		
		protected IDSInfoPage idsServices(){
			UtilHBM.waitExplicitClickable(driver, idsFpServices);
			idsFpServices.click();
			String currentHandle = driver.getWindowHandle();
			for(String handle : driver.getWindowHandles()){
				if(!handle.equalsIgnoreCase(currentHandle)){
					driver.switchTo().window(handle);
				}
			}
			return PageFactory.initElements(driver, IDSInfoPage.class);
		}
		
		protected FloorplanInfoPage floorplanServices(){
			UtilHBM.waitExplicitClickable(driver, idsFpServices);
			idsFpServices.click();
			String currentHandle = driver.getWindowHandle();
			for(String handle : driver.getWindowHandles()){
				if(!handle.equalsIgnoreCase(currentHandle)){
					driver.switchTo().window(handle);
				}
			}
			return PageFactory.initElements(driver, FloorplanInfoPage.class);
		}
		
		// ----------------------------------- Mobile---------------------
		
		protected ThreeDPlanner addProductMobile(String product){		
			WebElement addThisProduct = setProduct(product, 0, 1, 0).findElement(By.cssSelector(".icon icon-add"));
//			new Actions(driver).moveToElement(locateProduct(productList, product)).build().perform();
			UtilHBM.waitExplicitDisplayed(driver, addThisProduct);
			Verification.displayNAttributeCheckOfElement(addAProductTitle, "Catalog Panel title", "text", "Add a product");
			addThisProduct.click();
			UtilHBM.waitTillElementDisappear(driver, closeButton);
			return PageFactory.initElements(driver, ThreeDPlanner.class);
		}
		
		protected ThreeDPlanner addProductfromBrandsMobile(String product){
			WebElement addThisProduct = setProduct(product, 1, 0, 0).findElement(By.cssSelector(".icon.icon-add"));
			addThisProduct.click();
			UtilHBM.waitTillElementDisappear(driver, closeButton);
			return PageFactory.initElements(driver, ThreeDPlanner.class);
		}

}
