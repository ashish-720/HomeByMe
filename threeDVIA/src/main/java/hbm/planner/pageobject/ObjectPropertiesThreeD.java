package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ObjectPropertiesThreeD {
	
	WebDriver driver;
	
	public ObjectPropertiesThreeD(WebDriver driver) {
	this.driver = driver;
	}
	
	@CacheLookup
	@FindBy(css = ".toolBar-group-infos-right span[class='icon icon-dropdown']")
	WebElement moreProperties;
	
	@FindBy(css=".colorPicker-grid-item>img")
	List<WebElement> colorList;
	
	@CacheLookup
	@FindBy(id = "color-category")
	WebElement colorCatagoryDropdown;
	
	public ThreeDPlanner threeDWallProperties (String dropdownCatagory, String colorPickerNumber, String colorId){
		int a=0;
		do{
			moreProperties.click();
			a++;
		}while(UtilHBM.listOfWebElement(driver, ".more.dropdown.dropdown--more.is-collapse").size()==0 && a<4);
		System.out.println("Waiting for 5Sec");
		UtilHBM.waitExplicitClickable(driver, colorList.get(colorList.size()-1));
		new Select(colorCatagoryDropdown).selectByVisibleText(dropdownCatagory);
		UtilHBM.waitFixTime(4000);
		if (dropdownCatagory.contains("paint")){
			driver.findElement(By.cssSelector(".colorPicker-item[data-id = '" + colorPickerNumber + "']")).click();	
		}			
		WebElement color=driver.findElement(By.cssSelector("a[data-id='" + colorId + "']>img"));
		color.click();
		moreProperties.click();
		if (UtilHBM.webElement(driver, "#color-current").getAttribute("src").equalsIgnoreCase(color.getAttribute("src"))){
		UtilHBM.reportOK("Wall properties edited successfilly");	
		}else{
			UtilHBM.reportKO("Wall properties edition failed");
		}				
	return PageFactory.initElements(driver, ThreeDPlanner.class);
}
	
	public ThreeDPlanner verifyThreeDWallProperties (String dropdownCatagory, String colorPickerNumber, String colorId){
		int a=0;
		do{
			moreProperties.click();
			a++;
		}while(UtilHBM.listOfWebElement(driver, ".more.dropdown.dropdown--more.is-collapse").size()==0 && a<4);
		System.out.println("Waiting for 5Sec");
		UtilHBM.waitExplicitClickable(driver, colorList.get(colorList.size()-1));
		new Select(colorCatagoryDropdown).selectByVisibleText(dropdownCatagory);
		UtilHBM.waitFixTime(4000);
		if (dropdownCatagory.contains("paint")){
			driver.findElement(By.cssSelector(".colorPicker-item[data-id = '" + colorPickerNumber + "']")).click();	
		}			
		WebElement color=driver.findElement(By.cssSelector("a[data-id='" + colorId + "']>img"));			
		if (UtilHBM.webElement(driver, "#color-current").getAttribute("src").equalsIgnoreCase(color.getAttribute("src"))){
		UtilHBM.reportOK("Wall color verified successfilly");	
		}else{
			UtilHBM.reportKO("Wall color verification failed");
		}	
		moreProperties.click();
	return PageFactory.initElements(driver, ThreeDPlanner.class);
}

}
