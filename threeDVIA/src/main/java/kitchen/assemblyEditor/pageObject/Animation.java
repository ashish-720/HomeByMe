package kitchen.assemblyEditor.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class Animation {

	WebDriver driver;

	public Animation(WebDriver driver) {
		this.driver=driver;	
	}
	
	
	@FindBy(css="#position-compo-1")
	WebElement xTranslationInput;
	
	@FindBy(css="#position-compo-2")
	WebElement yTranslationInput;
	
	@FindBy(css="#position-compo-3")
	WebElement zTranslationInput;
	
	@FindBy(css="#position-compo-4")
	WebElement xAxisInput;
	
	@FindBy(css="#position-compo-5")
	WebElement yAxisInput;
	
	@FindBy(css="#position-compo-6")
	WebElement zAxisInput;
	
	
	@FindBy(css="button[title='Close']")
	WebElement closeButton;
	
	@FindBy(css="#panel>p>span>span>button[title='Preview']")
	WebElement previewAnimationButton;
	
	AssemblyEditor verifyRotationParameters(int x,int y,int z,int xAxis,int yAxis,int zAxis)
	{
		Verification.VerifyEquals("Incorrect Rotation value", xTranslationInput.getAttribute("value"), String.valueOf(x));
		Verification.VerifyEquals("Incorrect Rotation value", yTranslationInput.getAttribute("value"), String.valueOf(y));
		Verification.VerifyEquals("Incorrect Rotation value", zTranslationInput.getAttribute("value"), String.valueOf(z));
		Verification.VerifyEquals("Incorrect Rotation value", xAxisInput.getAttribute("value"), String.valueOf(xAxis));
		Verification.VerifyEquals("Incorrect Rotation value", yAxisInput.getAttribute("value"), String.valueOf(yAxis));
		Verification.VerifyEquals("Incorrect Rotation value", zAxisInput.getAttribute("value"), String.valueOf(zAxis));
		
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	AssemblyEditor verifyTranslationParameters(int x,int y,int z)
	{
		Verification.VerifyEquals("Incorrect Rotation value", xTranslationInput.getAttribute("value"), String.valueOf(x));
		Verification.VerifyEquals("Incorrect Rotation value", yTranslationInput.getAttribute("value"), String.valueOf(y));
		Verification.VerifyEquals("Incorrect Rotation value", zTranslationInput.getAttribute("value"), String.valueOf(z));
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	AssemblyEditor clickClose()
	{
		UtilHBM.waitExplicitDisplayed(driver, closeButton);
		UtilHBM.waitFixTime(1000);
		closeButton.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	Animation setXTranslationValue(int x)
	{ 
		UtilHBM.waitFixTime(1000);
		xTranslationInput.click();
		UtilHBM.waitFixTime(1000);
		xTranslationInput.clear();
		xTranslationInput.sendKeys(String.valueOf(x)+Keys.ENTER);
		return PageFactory.initElements(driver, Animation.class);
	}
	
	Animation setYTranslationValue(int y)
	{
		UtilHBM.waitFixTime(1000);
		yTranslationInput.click();
		UtilHBM.waitFixTime(1000);
		yTranslationInput.clear();
		yTranslationInput.sendKeys(String.valueOf(y)+Keys.ENTER);
		return PageFactory.initElements(driver, Animation.class);
	}
	
	Animation setZTranslationValue(int z)
	{
		UtilHBM.waitFixTime(1000);
		zTranslationInput.click();
		UtilHBM.waitFixTime(1000);
		zTranslationInput.clear();
		zTranslationInput.sendKeys(String.valueOf(z)+Keys.ENTER);
		return PageFactory.initElements(driver, Animation.class);
	}
	
	Animation setXAxisRotationValue(int xAxis)
	{
		UtilHBM.waitFixTime(1000);
		xAxisInput.click();
		UtilHBM.waitFixTime(1000);
		xAxisInput.clear();
		xAxisInput.sendKeys(String.valueOf(xAxis)+Keys.ENTER);
		return PageFactory.initElements(driver, Animation.class);
	}
	
	Animation setYAxisRotationValue(int yAxis)
	{
		UtilHBM.waitFixTime(1000);
		yAxisInput.click();
		UtilHBM.waitFixTime(1000);
		yAxisInput.clear();
		yAxisInput.sendKeys(String.valueOf(yAxis)+Keys.ENTER);
		return PageFactory.initElements(driver, Animation.class);
	}
	
	Animation setZAxisRotationValue(int zAxis)
	{
		UtilHBM.waitFixTime(1000);
		zAxisInput.click();
		UtilHBM.waitFixTime(1000);
		zAxisInput.clear();
		zAxisInput.sendKeys(String.valueOf(zAxis)+Keys.ENTER);
		return PageFactory.initElements(driver, Animation.class);
	}
	
	public AssemblyEditor addTranslationDetails(int x,int y,int z)
	{
//		UtilHBM.waitExplicitDisplayed(driver, xTranslationInput);
		UtilHBM.waitFixTime(1000);
		setXTranslationValue(x);
		setYTranslationValue(y);
		setZTranslationValue(z);	
		UtilHBM.waitFixTime(1000);
		clickClose();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor clickPreviewAnimation()
	{
		if(previewAnimationButton.isDisplayed())
		{
			UtilHBM.waitFixTime(1000);
			previewAnimationButton.click();
		}
			
		clickClose();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor addRotationDetails(int x,int y,int z,int axisX,int axisY,int axisZ)
	{
		UtilHBM.waitFixTime(1000);
		setXTranslationValue(x);
		setYTranslationValue(y);
		setZTranslationValue(z);	
		setXAxisRotationValue(axisX);
		setYAxisRotationValue(axisY);
		setZAxisRotationValue(axisZ);
		UtilHBM.waitFixTime(1000);
		clickClose();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
}
