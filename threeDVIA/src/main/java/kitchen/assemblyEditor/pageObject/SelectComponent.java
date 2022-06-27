package kitchen.assemblyEditor.pageObject;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class SelectComponent {
	WebDriver driver;

	public SelectComponent(WebDriver driver) {
		this.driver=driver;	
	}

	@FindBy(css="#component-layer>div>div>div>div>div.tabs-container>ul>li>button[aria-controls='add-component-2']")
	WebElement fromSymbol;

	@FindBy(css="#catalogSearchBar-form-input")
	WebElement catalogProdSearchInput;

	@FindBy(css="div.text>h3.title")
	WebElement header1;

	@FindBy(css="ul.tablist>li>button[aria-controls='add-component-1']")
	WebElement header2;

	@FindBy(css="ul.tablist>li>button[aria-controls='add-component-2']")
	WebElement header3;

	public AssemblyEditor selectProduct(String productName)
	{
		catalogProdSearchInput.sendKeys(productName+Keys.ENTER);
		List<WebElement> product=driver.findElements(By.xpath("//div/div/div[@id='product-browser']/ul[@id='product-browser']/li/article/div/h3[contains(text(),'"+productName+"')]"));
		product.get(0).click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}  
	
	public Components selectComponent(String type,String searchString,String productName)
	{
		UtilHBM.waitExplicitDisplayed(driver, header1);
		Verification.VerifyEquals("Header not displayed", header1.getText(), "Pick a component");
		Verification.VerifyEquals("Header not displayed", header2.getText(), "From catalog");
		Verification.VerifyEquals("Header not displayed", header3.getText(), "From symbol");
		catalogProdSearchInput.sendKeys(searchString+Keys.ENTER);
		List<WebElement> product=driver.findElements(By.xpath("//div/div/div[@id='product-browser']/ul[@id='product-browser']/li/article/div/h3[contains(text(),'"+productName+"')]"));
		product.get(0).click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, Components.class);
	}
	
	public AssemblyEditor selectComponent(String type,String productName)
	{
		UtilHBM.waitExplicitDisplayed(driver, header1);
		Verification.VerifyEquals("Header not displayed", header1.getText(), "Pick a component");
		Verification.VerifyEquals("Header not displayed", header2.getText(), "From catalog");
		Verification.VerifyEquals("Header not displayed", header3.getText(), "From symbol");
		if(type.contentEquals("symbol"))
		{
			fromSymbol.click();
			List<WebElement> product=driver.findElements(By.xpath("//*[@id='product-browser']/li/article/div/h3[contains(text(),'"+productName+"')]"));
			product.get(0).click();
		}
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor selectComponent(String componentName)
	{
		UtilHBM.waitExplicitDisplayed(driver, header1);
		Verification.VerifyEquals("Header not displayed", header1.getText(), "Pick a component");
		Verification.VerifyEquals("Header not displayed", header2.getText(), "From catalog");
		Verification.VerifyEquals("Header not displayed", header3.getText(), "From symbol");
		if(componentName.split(",")[0].contentEquals("symbol"))
		{
			fromSymbol.click();
			List<WebElement> product=driver.findElements(By.xpath("//*[@id='product-browser']/li/article/div/h3[contains(text(),'"+componentName.split(",")[1].split(">")[1]+"')]"));
			product.get(0).click();
		}
		else
		{
			
			catalogProdSearchInput.sendKeys(componentName.split(",")[1].split(":")[1].split(">")[0]+Keys.ENTER);
			List<WebElement> product=driver.findElements(By.xpath("//div/div/div[@id='product-browser']/ul[@id='product-browser']/li/article/div/h3[contains(text(),'"+componentName.split(",")[1].split(":")[1].split(">")[1]+"')]"));
			product.get(0).click();
		}
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
}
