package kitchen.assemblyEditor.pageObject;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;

public class SelectProduct {

	WebDriver driver;

	public SelectProduct(WebDriver driver) {
		this.driver=driver;	
	}

	@FindBy(css="#catalogSearchBar-form-input")
	WebElement searchComponent;


	Parameter select(String componentName)
	{
		searchComponent.sendKeys(componentName.split("=")[0]+Keys.ENTER);
		List<WebElement> searchedComponent=driver.findElements(By.xpath("//*[@id='product-browser']/li/article/div/h3[contains(text(),'"+componentName.split("=")[1]+"')]"));
		searchedComponent.get(0).click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, Parameter.class);
	}

	Parameter selectProductForParameter(String searchString,String productName)
	{
		searchComponent.sendKeys(searchString+Keys.ENTER);
		List<WebElement> searchedComponent=driver.findElements(By.xpath("//*[@id='product-browser']/li/article/div/h3[contains(text(),'"+productName+"')]"));
		searchedComponent.get(0).click();
		return PageFactory.initElements(driver, Parameter.class);
	}


}
