package kitchen.assemblyEditor.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;

public class OutputSet {
	WebDriver driver;

	public OutputSet(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css="#input-type")
	WebElement outputSetNameInput;
	
	@FindBy(css="button[title='Close']")
	WebElement closeButton;
	
	@FindBy(css="#position-compo-1")
	WebElement xCoordinateInput;
	
	@FindBy(css="#position-compo-2")
	WebElement yCoordinateInput;
	
	@FindBy(css="#position-compo-3")
	WebElement zCoordinateInput;
	
	public AssemblyEditor addPointCoordinates(int xCoordinate,int yCoordinate,int zCoordinate)
	{
//		UtilHBM.waitExplicitDisplayed(driver, xCoordinateInput);
		UtilHBM.waitFixTime(1000);
		setXCoordinate(xCoordinate);
		setYCoordinate(yCoordinate);
		setZCoordinate(zCoordinate);
		clickClose();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	OutputSet setXCoordinate(int xCoordinate)
	{
		UtilHBM.waitFixTime(1000);
		xCoordinateInput.click();
		UtilHBM.waitFixTime(1000);
		xCoordinateInput.clear();
		xCoordinateInput.sendKeys(String.valueOf(xCoordinate)+Keys.ENTER);
		return PageFactory.initElements(driver, OutputSet.class);
	}
	
	OutputSet setYCoordinate(int yCoordinate)
	{
		UtilHBM.waitFixTime(1000);
		yCoordinateInput.click();
		UtilHBM.waitFixTime(1000);
		yCoordinateInput.clear();
		yCoordinateInput.sendKeys(String.valueOf(yCoordinate)+Keys.ENTER);
		return PageFactory.initElements(driver, OutputSet.class);
	}
	
	OutputSet setZCoordinate(int zCoordinate)
	{
		UtilHBM.waitFixTime(1000);
		zCoordinateInput.click();
		UtilHBM.waitFixTime(1000);
		zCoordinateInput.clear();
		zCoordinateInput.sendKeys(String.valueOf(zCoordinate)+Keys.ENTER);
		return PageFactory.initElements(driver, OutputSet.class);
	}
	
	
	
	public AssemblyEditor clickClose()
	{
		UtilHBM.waitFixTime(1000);
		closeButton.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	OutputSet setOutputSetName(String outputSetName)
	{
		outputSetNameInput.click();
		outputSetNameInput.clear();
		outputSetNameInput.sendKeys(outputSetName);
		return PageFactory.initElements(driver, OutputSet.class);
	}
	 
	public AssemblyEditor fillUpName(String outputSetName)
	{
		UtilHBM.waitExplicitDisplayed(driver, outputSetNameInput);
		UtilHBM.waitFixTime(1000);
		setOutputSetName(outputSetName);
		clickClose();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	@FindBy(css="#position-form-start-compo-1")
	WebElement startPointXCoordinateInput;
	
	OutputSet setStartPointXCoordinate(int startPointXCoordinate)
	{
		UtilHBM.waitFixTime(1000);
		startPointXCoordinateInput.click();
		startPointXCoordinateInput.clear();
		startPointXCoordinateInput.sendKeys(String.valueOf(startPointXCoordinate)+Keys.ENTER);
		return PageFactory.initElements(driver, OutputSet.class);
	}
	
	@FindBy(css="#position-form-start-compo-2")
	WebElement startPointYCoordinateInput;
	
	OutputSet setStartPointYCoordinate(int startPointYCoordinate)
	{
		UtilHBM.waitFixTime(1000);
		startPointYCoordinateInput.click();
		startPointYCoordinateInput.clear();
		startPointYCoordinateInput.sendKeys(String.valueOf(startPointYCoordinate)+Keys.ENTER);
		return PageFactory.initElements(driver, OutputSet.class);
	}
	
	@FindBy(css="#position-form-end-compo-1")
	WebElement endPointXCoordinateInput;
	
	OutputSet setEndPointXCoordinate(int endPointXCoordinate)
	{
		UtilHBM.waitFixTime(1000);
		endPointXCoordinateInput.click();
		endPointXCoordinateInput.clear();
		endPointXCoordinateInput.sendKeys(String.valueOf(endPointXCoordinate)+Keys.ENTER);
		return PageFactory.initElements(driver, OutputSet.class);
	}
	
	@FindBy(css="#position-form-end-compo-2")
	WebElement endPointYCoordinateInput;
	
	OutputSet setEndPointYCoordinate(int endPointYCoordinate)
	{
		UtilHBM.waitFixTime(1000);
		endPointYCoordinateInput.click();
		endPointYCoordinateInput.clear();
		endPointYCoordinateInput.sendKeys(String.valueOf(endPointYCoordinate)+Keys.ENTER);
		return PageFactory.initElements(driver, OutputSet.class);
	}
	
	public AssemblyEditor setEdgelinePointValues(int startPointXCoordinate,int startPointYCoordinate,int endPointXCoordinate,int endPointYCoordinate)
	{
		UtilHBM.waitFixTime(1000);
		setStartPointXCoordinate(startPointXCoordinate)
		.setStartPointYCoordinate(startPointYCoordinate)
		.setEndPointXCoordinate(endPointXCoordinate)
		.setEndPointYCoordinate(endPointYCoordinate)
		.clickClose();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
}
