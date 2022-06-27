package kitchen.templateEditor.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;

public class AddSlopedCeiling {
WebDriver driver;
	
	public AddSlopedCeiling(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css="#bmSVG")
	WebElement container3D;
	
	@FindBy(css="div.mod-overlay-container-sloped-ceiling.mod-open")
	WebElement slopedCeilingEditPanel;
	
	@FindBy(css="#sloped-ceiling-a")
	WebElement heightInput;
	
	@FindBy(css="#sloped-ceiling-b")
	WebElement hdistInput;
	
	@FindBy(css="label[for='sloped-ceiling-radio-c']")
	WebElement angleRadioButton;
	
	@FindBy(css="#sloped-ceiling-c")
	WebElement angleInput;
	
	@FindBy(css="button[data-i18n='common.create']")
	WebElement createButton;
	
	@FindBy(css="button[title='Validate']")
	WebElement validateButton;
	
	@FindBy(css="button[data-ui-action='changeSlopedCeiling']")
	WebElement changeButton;
	
	@FindBy(css="div.mod-overlay-container.mod-open>div>section")
	WebElement slopedCeilingOptionsPanel;
	
	Floorplan verifySlopedCeiling(int xCoordinate,int yCoordinate,int height,String measureToEdit,int value)
	{
		selectProduct(xCoordinate, yCoordinate);
		UtilHBM.waitExplicitDisplayed(driver, slopedCeilingOptionsPanel);
		changeButton.click();
		UtilHBM.waitExplicitDisplayed(driver, slopedCeilingEditPanel);
		if(heightInput.getAttribute("value").contains(String.valueOf(height)))
		{
			UtilHBM.reportOK("Height of sloped ceiling verified");
		}
		else
		{
			UtilHBM.reportKO("Incorrect sloped ceiling height");
		}
		if(measureToEdit.contentEquals("hdist"))
		{
			if(hdistInput.getAttribute("value").contains(String.valueOf(value)))
			{
				UtilHBM.reportOK("Horizontal distance of sloped ceiling height verified");
			}
			else
			{
				UtilHBM.reportKO("Incorrect horizontal distance of sloped ceiling ");
			}
		}
		else
		{
			if(angleInput.getAttribute("value").contains(String.valueOf(value)))
			{
				UtilHBM.reportOK("Angle of sloped ceiling verified ");
			}
			else
			{
				UtilHBM.reportKO("Incorrect angle of sloped ceiling");
			}
		}
		
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
	Floorplan addSloppedCeiling(int xCoordinate,int yCoordinate,int height,String measureToEdit,int value)
	{
		selectProduct(xCoordinate, yCoordinate);
		UtilHBM.waitExplicitDisplayed(driver, slopedCeilingEditPanel);
		heightInput.click();
		heightInput.sendKeys(Keys.CONTROL+"a");
		heightInput.sendKeys(String.valueOf(height));
		heightInput.sendKeys(Keys.RETURN);
		if(measureToEdit.contentEquals("hdist"))
		{
			hdistInput.click();
			hdistInput.sendKeys(Keys.CONTROL+"a");
			hdistInput.sendKeys(String.valueOf(value));
			hdistInput.sendKeys(Keys.RETURN);
		}
		else
		{
			angleRadioButton.click();
			angleInput.sendKeys(Keys.CONTROL+"a");
			angleInput.sendKeys(String.valueOf(value));
			angleInput.sendKeys(Keys.RETURN);
		
		}
		createButton.click();
		validateButton.click();
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
	AddSlopedCeiling selectProduct(int xcoordinate,int ycoordinate)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(container3D,xcoordinate,ycoordinate).clickAndHold().pause(500).release().build().perform();
		return PageFactory.initElements(driver, AddSlopedCeiling.class);
	}
}
