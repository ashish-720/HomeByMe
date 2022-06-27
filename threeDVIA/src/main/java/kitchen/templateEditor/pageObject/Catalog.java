package kitchen.templateEditor.pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class Catalog {
	WebDriver driver;

	public Catalog(WebDriver driver) {
		this.driver=driver;	
	}

	
	@FindBy(css="button[data-ui-action='panel-close']")
	List<WebElement> closeButton;
	
	@FindBy(css="#filters>ul>li[data-ui-name='Depth']")
	WebElement depthFilter;
	
	@FindBy(css="#filters>ul>li[data-ui-name='Width']")
	WebElement widthFilter;
	
	@FindBy(css="#mod-product-list>li>article>div.text")
	List<WebElement> productList;
	
	@FindBy(css="#moreResults")
	WebElement showMoreButton;
	
	@FindBy(css="#design-catalog-browser>div.mod-loader>div.content>span.spinner")
	WebElement loader;
	
	@FindBy(css=".mod-popin-unavailable-products-small.mod-open>.content>.inner-content>.tt")
	private WebElement noDefaultStylePrdMsgHeading;
	
	@FindBy(css=".mod-popin-unavailable-products-small.mod-open>.content>.inner-content>.text")
	private WebElement noDefaultStylePrdMsgText;
	
	@FindBy(css=".mod-popin-unavailable-products-small.mod-open>.content>.popin-footer>.cta-primary-alt-xl")
	private WebElement noDefaultStylePrdMsgOKBtn;
	
	Design checkFilter(String filterType,int filterMeasure)
	{
		for(int i=0;i<productList.size();i++)
		{
			UtilHBM.waitExplicitDisplayed(driver, productList.get(i));
		}
		if(filterType.contentEquals("Depth"))
		{
			depthFilter.click();
			driver.findElement(By.xpath("//article/header/div/div[@id='nav-overlay-filters-collapse-0']/div/form/ul/li/ul/li/label/input[@data-value='"+String.valueOf(filterMeasure)+"']/parent::label/span[@class='state']")).click();
			UtilHBM.waitTillElementDisappear(driver, "div.mod-loader>div>span>svg.icon-view-loader");
			depthFilter.click();
			for(int i=0;i<productList.size();i++)
			{
				UtilHBM.waitExplicitDisplayed(driver, productList.get(i).findElement(By.cssSelector("p.secondary-desc")));
				if(productList.get(i).findElement(By.cssSelector("p.secondary-desc")).getText().contains("D"+String.valueOf(filterMeasure)))
				{
					UtilHBM.reportOK("Depth filter for "+String.valueOf(filterMeasure)+" verified sucessfully. Product found: "+productList.get(i).findElement(By.cssSelector("h3")).getAttribute("title"));
				}
				else
				{
					UtilHBM.reportKO("Invalid product included for filter measure "+filterMeasure);
				}
			}
		}
		else 
		{
			widthFilter.click();
			driver.findElement(By.xpath("//article/header/div/div[@id='nav-overlay-filters-collapse-1']/div/form/ul/li/ul/li/label/input[@data-value='"+String.valueOf(filterMeasure)+"']/parent::label/span[@class='state']")).click();
			UtilHBM.waitTillElementDisappear(driver, "div.mod-loader>div>span>svg.icon-view-loader");
			widthFilter.click();
			for(int i=0;i<productList.size();i++)
			{
				for(int j=0;j<productList.size();j++)
				{
					UtilHBM.waitExplicitDisplayed(driver, productList.get(j));

				} 
				UtilHBM.waitExplicitDisplayed(driver, productList.get(i).findElement(By.cssSelector("p.secondary-desc")));
				
				if(productList.get(i).findElement(By.cssSelector("p.secondary-desc")).getText().contains("W"+String.valueOf(filterMeasure)))
				{
					UtilHBM.reportOK("Width filter for "+String.valueOf(filterMeasure)+" verified sucessfully. Product found: "+productList.get(i).findElement(By.cssSelector("h3")).getAttribute("title"));
				}
				else
				{
					UtilHBM.reportKO("Invalid product included for filter measure "+filterMeasure);
				}
			}
		}
		if(closeButton.size()>0)
			closeButton.get(closeButton.size()-1).click();		
		return PageFactory.initElements(driver, Design.class);
	}
	
	public Design selectProduct(String productName, boolean defaultStylePrd)
	{
//		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("#design-catalog-browser>div[class*=content]")));
//		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver, "//article[@id='design-catalog-browser']"));
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "#design-catalog-browser:not([class*=loading])"));
//		for(int i=0;i<productList.size();i++)
//			UtilHBM.waitExplicitDisplayed(driver, productList.get(i));
		UtilHBM.waitExplicitDisplayed(driver, productList.get(productList.size()-1));
		List<WebElement> productToBeAdded=driver.findElements(By.xpath("//*[@id='mod-product-list']/li/article/div/h3[@title='"+productName+"']/parent::div/parent::article/parent::li"));
		int i=0;
		while(productToBeAdded.size()==0 && i<4){
			showMoreButton.click();
			UtilHBM.waitFixTime(1000);
			productToBeAdded=driver.findElements(By.xpath("//*[@id='mod-product-list']/li/article/div/h3[@title='"+productName+"']/parent::div/parent::article/parent::li"));
			UtilHBM.turnOffImplicitWaits(driver);
			if(loader.isDisplayed())
				UtilHBM.waitTillElementDisappear(driver, loader);
			
			UtilHBM.turnOnImplicitWaits(driver);
			i++;
		}
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "#design-catalog-browser:not([class*=loading])"));
		productToBeAdded.get(0).click();		
		if(!defaultStylePrd){
			UtilHBM.waitExplicitDisplayed(driver, noDefaultStylePrdMsgText);
			Verification.verifyText(noDefaultStylePrdMsgText, "The product(s) you selected are unavailable and will be inserted into your project in a different style.", "Product not availalbe in default style msg");
			Verification.verifyText(noDefaultStylePrdMsgHeading, "Unavailable products", "Unavailable product msg heading");
			noDefaultStylePrdMsgOKBtn.click();
		}
		
		if(closeButton.size()>0)
			closeButton.get(closeButton.size()-1).click();
		
		return PageFactory.initElements(driver, Design.class);
	}
	
	Design selectProduct(String productName,String uid)
	{
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("#design-catalog-browser>div.content")));
		for(int i=0;i<productList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, productList.get(i));
		List<WebElement> productToBeAdded=driver.findElements(By.xpath("//*[@id='mod-product-list']/li[@data-ui-id='"+uid+"']/article/div/h3[@title='"+productName+"']/parent::div/parent::article/parent::li"));
		UtilHBM.waitExplicitDisplayed(driver, productToBeAdded.get(0));
		UtilHBM.waitExplicitClickable(driver, productToBeAdded.get(0));		
		productToBeAdded.get(0).click();
		if(closeButton.size()>0)
			closeButton.get(closeButton.size()-1).click();
		return PageFactory.initElements(driver, Design.class);
	}
	 
	Floorplan selectCovering(String coveringName,String uid)
	{
			UtilHBM.waitExplicitDisplayed(driver, "//article[@class='catalog-browser-mod-panel mod-open']//div[@class='content-fluid']/div[@class='content-scroll']/div[@class='content-inner']");
		List<WebElement> productToBeAdded=driver.findElements(By.xpath("//*[@id='mod-product-list']/li[@data-ui-id='"+uid+"']/article/div/h3[@title='"+coveringName+"']"));
		UtilHBM.waitExplicitDisplayed(driver, productToBeAdded.get(0));
		UtilHBM.waitExplicitClickable(driver, productToBeAdded.get(0));		
		productToBeAdded.get(0).click();
		return PageFactory.initElements(driver, Floorplan.class);
	}

	static ArrayList<String> products = new ArrayList<String>();

	
	AddProducts getProductDetails()
	{
		List<WebElement> productList=driver.findElements(By.cssSelector("div.content-inner>ul[id='mod-product-list']>li"));
		for(int k=0;k<productList.size();k++)
		{						
			UtilHBM.waitExplicitDisplayed(driver, productList.get(k));
			products.add(productList.get(k).findElement(By.cssSelector("article>div>h3")).getAttribute("title"));
		}
		setProducts(products);
		if(closeButton.size()>0)
			closeButton.get(closeButton.size()-1).click();
		return PageFactory.initElements(driver, AddProducts.class);
	}

	static public ArrayList<String> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<String> products) {
		Catalog.products = products;
	}
	
}
