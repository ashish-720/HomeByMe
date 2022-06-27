package kitchen.templateEditor.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;

public class SubstitutionLinkDefCatalog {
	WebDriver driver;

	public SubstitutionLinkDefCatalog(WebDriver driver) {
		this.driver=driver;	
	}

	@FindBy(css="li[data-ui-action='product-add']")
	List<WebElement> productList;
	
	@FindBy(css="#catalogSearchBar-form-input")
	WebElement searchKeyInput;

	@FindBy(css=".bt-icon-search")
	WebElement searchButton;
	
	@FindBy(css="#catalogbrowser-content-inner")
	WebElement catalogWindow;
	
	SubstitutionLinkDefCatalog selectProduct(String productName)
	{
		UtilHBM.waitExplicitDisplayed(driver, catalogWindow);
		for(int k=0;k<productList.size()-1;k++)
			UtilHBM.waitExplicitDisplayed(driver, productList.get(k));
		UtilHBM.waitTillElementDisappear(driver, "div.content>span.spinner");
		searchKeyInput.sendKeys(productName);
		searchButton.click();
//		UtilHBM.waitTillElementDisappear(driver, "div.content>span.spinner");
		UtilHBM.waitExplicitDisplayed(driver, "//article[@class='mod-layer-catalog-browser mod-expanded mod-open']");
		WebElement productToBeAdded=driver.findElement(By.xpath("//*[@id='mod-product-list']/li/article/div/h3[@title='"+productName+"']/parent::div/parent::article/parent::li"));
		UtilHBM.waitExplicitDisplayed(driver, productToBeAdded);
		UtilHBM.waitExplicitClickable(driver, productToBeAdded);		
		productToBeAdded.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, SubstitutionLinkDefCatalog.class);
	}
	SubstitutionLinkDefCatalog selectProduct(String productName,String uid)
	{
		UtilHBM.waitExplicitDisplayed(driver, catalogWindow);
		for(int k=0;k<productList.size()-1;k++)
			UtilHBM.waitExplicitDisplayed(driver, productList.get(k));
		UtilHBM.waitTillElementDisappear(driver, "div.content>span.spinner");
		searchKeyInput.sendKeys(productName);
		searchButton.click();
		UtilHBM.waitTillElementDisappear(driver, "div.content>span.spinner");
		WebElement productToBeAdded=driver.findElement(By.xpath("//*[@id='mod-product-list']/li/article/div/h3[@title='"+productName+"']/parent::div/parent::article/parent::li[@data-ui-id='"+uid+"']"));
		UtilHBM.waitExplicitDisplayed(driver, productToBeAdded);
		UtilHBM.waitExplicitClickable(driver, productToBeAdded);		
		productToBeAdded.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, SubstitutionLinkDefCatalog.class);
	}
}
