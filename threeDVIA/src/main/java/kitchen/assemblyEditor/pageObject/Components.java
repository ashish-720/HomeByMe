package kitchen.assemblyEditor.pageObject;


import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class Components {
	WebDriver driver;

	public Components(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css="section.floating-content>form>p>label[for='compo-1']")
	WebElement label1;
	
	@FindBy(css="section.floating-content>form>p>label[for='compo-2']")
	WebElement label2;
	
	@FindBy(css="section.floating-content>form>p>label[for='compo-3']")
	WebElement label3;

	@FindBy(css="#panel-floating-pane")
	WebElement componentPanel;

	@FindBy(css="#position-section>span")
	WebElement label4;
	
	@FindBy(css="#orientation-section>span")
	WebElement label5;
	
	@FindBy(css="#overload-section>span")
	WebElement label6;
	
	@FindBy(css="#position-section>span[aria-expanded='false']>img")
	List<WebElement> componentPositionExpand;
	
	@FindBy(css="#orientation-section>span[aria-expanded='false']>img")
	List<WebElement> componentOrientationExpand;
	
	@FindBy(css="#position-section")
	WebElement componentPositionPanel;

	@FindBy(css="#panel-floating-pane>div>div>div>section>form>p>span>input")
	WebElement componentNameInput;

	@FindBy(css="#position-form")
	WebElement positionElements;

	@FindBy(css="#orientation-form")
	WebElement orientationElements;

	@FindBy(css="button[title='Close']")
	WebElement closeButton;

	@FindBy(css="#panel>div>div>section>form>p>span>select[name='compo-3'][data-ui-action='opening']")
	WebElement activatedSelect;
	
	@FindBy(css="#position-section>span[aria-expanded]")
	WebElement positionExpand;
	
	@FindBy(css="#orientation-section>span[aria-expanded]")
	WebElement orientationExpand;
	
	@FindBy(css="button[data-ui-action='replace-reference']")
	WebElement replaceRefButton;
	
	@FindBy(css="#panel>div>div>section.floating-content>form>p>span>span>input")
	WebElement refInput;

	@FindBy(css="#panel>p.header")
	WebElement pageHeader1;
	
	@FindBy(css="p>span>span>input[id='compo-2']")
	WebElement refProductNameInput;
	
	@FindBy(css="div.floating-pane-components span.mod-item-actions button[title='Hide']")
	List<WebElement> hideComponentBtn;

	@FindBy(css="div.floating-pane-components span.mod-item-actions button[title='Show']")
	List<WebElement> showComponentBtn;

	@FindBy(css = "div.floating-pane-components span.mod-item-actions button[title='Open component']")
	WebElement openComponentBtn;

	static String componentParameter;
	
	public AssemblyEditor clickClose(){
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, closeButton);
		closeButton.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
 
	public AssemblyEditor verifyComponent(String componentName,String refProductName)
	{
		Verification.VerifyEquals("Incorrect component name", componentNameInput.getAttribute("value"), componentName);
		Verification.VerifyEquals("Ref product incorrect", refProductNameInput.getAttribute("value"), refProductName);
		
		UtilHBM.waitFixTime(1000);
		clickClose();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public Components setComponentName(String componentName){
		UtilHBM.waitExplicitDisplayed(driver, componentPanel);
		Verification.VerifyEquals("Header not displayed", pageHeader1.getText().replace("\n", " "), "Component Hide Open component Duplicate Delete Close");
		Verification.VerifyEquals("Label not displayed", label1.getText(), "Name");
		Verification.VerifyEquals("Label not displayed", label2.getText(), "Ref.");
		Verification.VerifyEquals("Label not displayed", label3.getText(), "Activated");
		UtilHBM.waitExplicitDisplayed(driver, componentNameInput);
		componentNameInput.click();
		UtilHBM.waitFixTime(500);
		componentNameInput.clear();
		componentNameInput.sendKeys(componentName+Keys.ENTER);		
		UtilHBM.waitExplicitDisplayed(driver,"//*[@id='panel']/div/div/section/form/p/span/input");
		UtilHBM.waitFixTime(500);
		componentParameter=driver.findElement(By.cssSelector("#panel>div>div>section>form>p>span>input")).getAttribute("value");
		setComponentParameter(componentParameter);
		UtilHBM.waitFixTime(500);
		return PageFactory.initElements(driver, Components.class);
	}
	
	SelectComponent clickReplaceRef()
	{
		replaceRefButton.click();
		return PageFactory.initElements(driver, SelectComponent.class);
	}
	
	public static String getComponentParameter() {
		return componentParameter;
	}

	public static void setComponentParameter(String componentParameter) {
		Components.componentParameter = componentParameter;
	}

	Components selectActivateOption(String option)
	{
		driver.findElement(By.xpath("//p/span/select/optgroup/option[contains(@value,'"+option+"')]")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components clickActivateSelect()
	{
//		UtilHBM.waitExplicitDisplayed(driver, activatedSelect);
		activatedSelect.click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	public Components selectActivated(String option)
	{
		UtilHBM.waitFixTime(1000);
		clickActivateSelect();
		UtilHBM.waitFixTime(1000);
		selectActivateOption(option);
		UtilHBM.waitFixTime(1000);
		clickClose();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components changeOverloadToggle(String overloadLabel)
	{
		UtilHBM.waitFixTime(3000);
		driver.findElement(By.cssSelector("#overload-form>p[data-ui-name='"+overloadLabel+"']>span>span>label>span[class$='right']")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components clickOverloadSelect(String overloadLabel)
	{
		driver.findElement(By.cssSelector("#overload-form>p[data-ui-name='"+overloadLabel+"']>span>span>select")).click();
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components selectOverloadValue(String overloadLabel,String value)
	{
		driver.findElement(By.cssSelector("#overload-form>p[data-ui-name='"+overloadLabel+"']>span>span>select>optgroup>option[value='"+value+"']")).click();
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components fillOverloadValue(String overloadLabel,String value)
	{
		driver.findElement(By.cssSelector("#overload-form>p[data-ui-name='"+overloadLabel+"']>span>span>span>input")).clear();
		driver.findElement(By.cssSelector("#overload-form>p[data-ui-name='"+overloadLabel+"']>span>span>span>input")).sendKeys(value+Keys.ENTER);
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components activateElementToBeOverloaded(String overloadLabel)
	{
		replaceRefButton.sendKeys(Keys.HOME);
		for (int tryCount=0; tryCount<10; tryCount++) {
			try {
				WebElement overloadElement=driver.findElement(By.cssSelector("#overload-form>p[data-ui-selector='overload'][data-ui-name='"+overloadLabel+"'][class='disabled']>label.form-checkbox>span.state"));
				UtilHBM.waitExplicitDisplayed(driver, overloadElement);
				UtilHBM.waitExplicitClickable(driver, overloadElement);
				UtilHBM.waitFixTime(3000);
				overloadElement.click();
				break;
			} catch (ElementClickInterceptedException e) {
				new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
			}
		}
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components fillOverloadDetails(String overloadParameter,String type,String value)
	{
		if(componentPositionExpand.size()==0 && componentOrientationExpand.size()==0)
		{
			UtilHBM.waitFixTime(1000);
			positionExpand.click();			
			orientationExpand.click();
		}
		activateElementToBeOverloaded(overloadParameter);
		if(type.contentEquals("symbol"))
		{
			UtilHBM.waitFixTime(1000);
			changeOverloadToggle(overloadParameter)
			.clickOverloadSelect(overloadParameter)
			.selectOverloadValue(overloadParameter, value);
		}
		else
		{
			fillOverloadValue(overloadParameter, value);
		}
		clickClose();
		return PageFactory.initElements(driver, Components.class);
	}
	
	public Components fillOverloadDetails(String productName,String overloadParameters)
	{
		if(componentOrientationExpand.size()==0)
		{
			UtilHBM.waitFixTime(1000);
			positionExpand.click();			
			orientationExpand.click();
		}
		if(!overloadParameters.equalsIgnoreCase("null"))
		{
			activateElementToBeOverloaded(overloadParameters.split(":")[0]);
//			Verification.VerifyEquals("Label not displayed", label6.getText(), "Overloads");
			if(overloadParameters.split(":")[1].split(">")[0].contentEquals("symbol"))
			{
				UtilHBM.waitFixTime(1000);
				changeOverloadToggle(overloadParameters.split(":")[0])
				.clickOverloadSelect(overloadParameters.split(":")[0])
				.selectOverloadValue(overloadParameters.split(":")[0], overloadParameters.split(":")[1].split(">")[1]);
			}
			else
			{
				fillOverloadValue(overloadParameters.split(":")[1].split(">")[0], overloadParameters.split(":")[1].split(">")[1]);
			}
		}
		clickClose();
		return PageFactory.initElements(driver, Components.class);
	}

	public Components fillYXOrientationDetails(String componentName,String type,String value)
	{
		if(componentPositionExpand.size()==0)
		{
			positionExpand.click();
		}
		if(componentPanel.isDisplayed())
		{
			UtilHBM.waitFixTime(1000);
			Verification.VerifyEquals("Label not displayed", label5.getText(), "Orientation");
			UtilHBM.turnOffImplicitWaits(driver);
			if(componentOrientationExpand.size()>0)
				orientationExpand.click();
			UtilHBM.turnOnImplicitWaits(driver);

			if(type.contentEquals("symbol"))
			{
				changeYXOrientationToggle()
				.clickYXOrientationSelect()
				.selectYXOrientationValue(value);
			}
			else
			{
				fillYXOrientationValue(value);
			}
		}
		UtilHBM.waitFixTime(1000);
		componentNameInput.click();
		UtilHBM.waitFixTime(1000);
		orientationExpand.click();
		UtilHBM.waitFixTime(1000);
		clickClose();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components fillYXOrientationValue(String value)
	{
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'YX')]/span/span/span/input")).click();
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'YX')]/span/span/span/input")).clear();
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'YX')]/span/span/span/input")).sendKeys(Keys.CONTROL + Keys.chord("a"));
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'YX')]/span/span/span/input")).sendKeys(value+Keys.ENTER);
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'YX')]/span/span/span/input")).click();
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components selectYXOrientationValue(String value)
	{
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'YX')]/span/span/select/optgroup/option[@value='"+value+"']")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components clickYXOrientationSelect()
	{
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'YX')]/span/span/select")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components changeYXOrientationToggle()
	{
		orientationElements.findElement(By.xpath("//p[contains(@data-ui-selector='YX')]/span/span/label[contains(@for,'symbol')]")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	public Components fillYYOrientationDetails(String componentName,String type,String value)
	{
		if(componentPositionExpand.size()==0)
		{
			positionExpand.click();
		}
		if(componentPanel.isDisplayed())
		{
			UtilHBM.waitFixTime(1000);
			Verification.VerifyEquals("Label not displayed", label5.getText(), "Orientation");
			UtilHBM.turnOffImplicitWaits(driver);
			if(componentOrientationExpand.size()>0)
				orientationExpand.click();
			UtilHBM.turnOnImplicitWaits(driver);

			if(type.contentEquals("symbol"))
			{
				changeYYOrientationToggle()
				.clickYYOrientationSelect()
				.selectYYOrientationValue(value);
			}
			else
			{
				fillYYOrientationValue(value);
			}
		}
		UtilHBM.waitFixTime(1000);
		componentNameInput.click();
		UtilHBM.waitFixTime(1000);
		orientationExpand.click();
		UtilHBM.waitFixTime(1000);
		clickClose();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components fillYYOrientationValue(String value)
	{
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'YY')]/span/span/span/input")).click();
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'YY')]/span/span/span/input")).clear();
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'YY')]/span/span/span/input")).sendKeys(Keys.CONTROL + Keys.chord("a"));
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'YY')]/span/span/span/input")).sendKeys(value+Keys.ENTER);
		UtilHBM.waitFixTime(1000);
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'YY')]/span/span/span/input")).click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components selectYYOrientationValue(String value)
	{
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'YY')]/span/span/select/optgroup/option[@value='"+value+"']")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components clickYYOrientationSelect()
	{
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'YY')]/span/span/select")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components changeYYOrientationToggle()
	{
		orientationElements.findElement(By.xpath("//p[contains(@data-ui-selector='YY')]/span/span/label[contains(@for,'symbol')]")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	public Components fillYZOrientationDetails(String componentName,String type,String value)
	{
		if(componentPositionExpand.size()==0)
		{
			positionExpand.click();
		}
		if(componentPanel.isDisplayed())
		{
			UtilHBM.waitFixTime(1000);
			Verification.VerifyEquals("Label not displayed", label5.getText(), "Orientation");
			UtilHBM.turnOffImplicitWaits(driver);
			if(componentOrientationExpand.size()>0)
				orientationExpand.click();
			UtilHBM.turnOnImplicitWaits(driver);

			if(type.contentEquals("symbol"))
			{
				changeYZOrientationToggle()
				.clickYZOrientationSelect()
				.selectYZOrientationValue(value);
			}
			else
			{
				fillYZOrientationValue(value);
			}
		}
		UtilHBM.waitFixTime(1000);
		componentNameInput.click();
		UtilHBM.waitFixTime(1000);
		orientationExpand.click();
		UtilHBM.waitFixTime(1000);
		clickClose();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components fillYZOrientationValue(String value)
	{
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'YZ')]/span/span/span/input")).click();
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'YZ')]/span/span/span/input")).clear();
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'YZ')]/span/span/span/input")).sendKeys(Keys.CONTROL + Keys.chord("a"));
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'YZ')]/span/span/span/input")).sendKeys(value+Keys.ENTER);
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'YZ')]/span/span/span/input")).click();
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components selectYZOrientationValue(String value)
	{
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'YZ')]/span/span/select/optgroup/option[@value='"+value+"']")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components clickYZOrientationSelect()
	{
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'YZ')]/span/span/select")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components changeYZOrientationToggle()
	{
		orientationElements.findElement(By.xpath("//p[contains(@data-ui-selector='YZ')]/span/span/label[contains(@for,'symbol')]")).click();
		return PageFactory.initElements(driver, Components.class);
	}

	public Components fillZXOrientationDetails(String componentName,String type,String value)
	{
		if(componentPositionExpand.size()==0)
		{
			positionExpand.click();
		}
		if(componentPanel.isDisplayed())
		{
			UtilHBM.waitFixTime(1000);
			Verification.VerifyEquals("Label not displayed", label5.getText(), "Orientation");
			UtilHBM.turnOffImplicitWaits(driver);
			if(componentOrientationExpand.size()>0)
				orientationExpand.click();
			UtilHBM.turnOnImplicitWaits(driver);

			if(type.contentEquals("symbol"))
			{
				changeZXOrientationToggle()
				.clickZXOrientationSelect()
				.selectZXOrientationValue(value);
			}
			else
			{
				fillZXOrientationValue(value);
			}
		}
		UtilHBM.waitFixTime(1000);
		componentNameInput.click();
		UtilHBM.waitFixTime(1000);
		orientationExpand.click();
		UtilHBM.waitFixTime(1000);
		clickClose();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components fillZXOrientationValue(String value)
	{
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'ZX')]/span/span/span/input")).click();
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'ZX')]/span/span/span/input")).clear();
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'ZX')]/span/span/span/input")).sendKeys(Keys.CONTROL + Keys.chord("a"));
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'ZX')]/span/span/span/input")).sendKeys(value+Keys.ENTER);
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'ZX')]/span/span/span/input")).click();
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components selectZXOrientationValue(String value)
	{
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'ZX')]/span/span/select/optgroup/option[@value='"+value+"']")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components clickZXOrientationSelect()
	{
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'ZX')]/span/span/select")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components changeZXOrientationToggle()
	{
		orientationElements.findElement(By.xpath("//p[contains(@data-ui-selector='ZX')]/span/span/label[contains(@for,'symbol')]")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	public Components fillZYOrientationDetails(String componentName,String type,String value)
	{
		if(componentPositionExpand.size()==0)
		{
			positionExpand.click();
		}
		if(componentPanel.isDisplayed())
		{
			UtilHBM.waitFixTime(1000);
			Verification.VerifyEquals("Label not displayed", label5.getText(), "Orientation");
			UtilHBM.turnOffImplicitWaits(driver);
			if(componentOrientationExpand.size()>0)
				orientationExpand.click();
			UtilHBM.turnOnImplicitWaits(driver);

			if(type.contentEquals("symbol"))
			{
				changeZYOrientationToggle()
				.clickZYOrientationSelect()
				.selectZYOrientationValue(value);
			}
			else
			{
				fillZYOrientationValue(value);
			}
		}
		UtilHBM.waitFixTime(1000);
		componentNameInput.click();
		UtilHBM.waitFixTime(1000);
		orientationExpand.click();
		UtilHBM.waitFixTime(1000);
		clickClose();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components fillZYOrientationValue(String value)
	{
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'ZY')]/span/span/span/input")).click();
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'ZY')]/span/span/span/input")).clear();
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'ZY')]/span/span/span/input")).sendKeys(Keys.CONTROL + Keys.chord("a"));
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'ZY')]/span/span/span/input")).sendKeys(value+Keys.ENTER);
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'ZY')]/span/span/span/input")).click();
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components selectZYOrientationValue(String value)
	{
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'ZY')]/span/span/select/optgroup/option[@value='"+value+"']")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components clickZYOrientationSelect()
	{
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'ZY')]/span/span/select")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components changeZYOrientationToggle()
	{
		orientationElements.findElement(By.xpath("//p[contains(@data-ui-selector='ZY')]/span/span/label[contains(@for,'symbol')]")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	public Components fillZZOrientationDetails(String componentName,String type,String value)
	{
		if(componentPositionExpand.size()==0)
		{
			positionExpand.click();
		}
		if(componentPanel.isDisplayed())
		{
			UtilHBM.waitFixTime(1000);
			Verification.VerifyEquals("Label not displayed", label5.getText(), "Orientation");
			UtilHBM.turnOffImplicitWaits(driver);
			if(componentOrientationExpand.size()>0)
				orientationExpand.click();
			UtilHBM.turnOnImplicitWaits(driver);

			if(type.contentEquals("symbol"))
			{
				changeZZOrientationToggle()
				.clickZZOrientationSelect()
				.selectZZOrientationValue(value);
			}
			else
			{
				fillZZOrientationValue(value);
			}
		}
		UtilHBM.waitFixTime(1000);
		componentNameInput.click();
		UtilHBM.waitFixTime(1000);
		orientationExpand.click();
		UtilHBM.waitFixTime(1000);
		clickClose();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components fillZZOrientationValue(String value)
	{
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'ZZ')]/span/span/span/input")).click();
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'ZZ')]/span/span/span/input")).clear();
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'ZZ')]/span/span/span/input")).sendKeys(Keys.CONTROL + Keys.chord("a"));
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'ZZ')]/span/span/span/input")).sendKeys(value+Keys.ENTER);
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'ZZ')]/span/span/span/input")).click();
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components selectZZOrientationValue(String value)
	{
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'ZZ')]/span/span/select/optgroup/option[@value='"+value+"']")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components clickZZOrientationSelect()
	{
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'ZZ')]/span/span/select")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components changeZZOrientationToggle()
	{
		orientationElements.findElement(By.xpath("//p[contains(@data-ui-selector='ZZ')]/span/span/label[contains(@for,'symbol')]")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	
	public Components fillOrientationDetails(String productName,String orientationParameters)
	{
		if(componentPositionExpand.size()==0)
		{
			positionExpand.click();
		}
		if(componentPanel.isDisplayed())
		{
			UtilHBM.waitFixTime(1000);
			Verification.VerifyEquals("Label not displayed", label5.getText(), "Orientation");
			UtilHBM.turnOffImplicitWaits(driver);
			if(componentOrientationExpand.size()>0)
				orientationExpand.click();
			UtilHBM.turnOnImplicitWaits(driver);
			if(orientationParameters.contains("!"))
			{
				for(String a:orientationParameters.split("!"))
				{
					switch(a.split(":")[0])
					{
					case "yx":
						if(a.split(":")[1].contentEquals("symbol"))
						{
							changeOrientationToggle(a.split(":")[0]);
							clickOrientationSelect(a.split(":")[0]);
							selectOrientationValue(a.split(":")[0],a.split(":")[1].split(">")[1]);
						}
						else
						{
							fillOrientationValue(a.split(":")[0],a.split(":")[1].split(">")[1]);
						}
						break;
					case "yy":
						if(a.split(":")[1].contentEquals("symbol"))
						{
							changeOrientationToggle(a.split(":")[0]);
							clickOrientationSelect(a.split(":")[0]);
							selectOrientationValue(a.split(":")[0],a.split(":")[1].split(">")[1]);
						}
						else
						{
							fillOrientationValue(a.split(":")[0],a.split(":")[1].split(">")[1]);				
						}
						break;
					case "yz":
						if(a.split(":")[1].contentEquals("symbol"))
						{
							changeOrientationToggle(a.split(":")[0]);
							clickOrientationSelect(a.split(":")[0]);
							selectOrientationValue(a.split(":")[0],a.split(":")[1].split(">")[1]);
						}
						else
						{
							fillOrientationValue(a.split(":")[0],a.split(":")[1].split(">")[1]);						
						}
						break;

					case "zx":
						if(a.split(":")[1].contentEquals("symbol"))
						{
							changeOrientationToggle(a.split(":")[0]);
							clickOrientationSelect(a.split(":")[0]);
							selectOrientationValue(a.split(":")[0],a.split(":")[1].split(">")[1]);
						}
						else
						{
							fillOrientationValue(a.split(":")[0],a.split(":")[1].split(">")[1]);
						}
						break;
					case "zy":
						if(a.split(":")[1].contentEquals("symbol"))
						{
							changeOrientationToggle(a.split(":")[0]);
							clickOrientationSelect(a.split(":")[0]);
							selectOrientationValue(a.split(":")[0],a.split(":")[1].split(">")[1]);
						}
						else
						{
							fillOrientationValue(a.split(":")[0],a.split(":")[1].split(">")[1]);
						}
						break;
					case "zz":
						if(a.split(":")[1].contentEquals("symbol"))
						{
							changeOrientationToggle(a.split(":")[0]);
							clickOrientationSelect(a.split(":")[0]);
							selectOrientationValue(a.split(":")[0],a.split(":")[1].split(">")[1]);
						}
						else
						{
							fillOrientationValue(a.split(":")[0],a.split(":")[1].split(">")[1]);
						}
						break;
					}
				}
			}
			else
			{
				switch(orientationParameters.split(":")[0])
				{
				case "yx":
				{
					if(orientationParameters.split(":")[1].contentEquals("symbol"))
					{
						changeOrientationToggle(orientationParameters.split(":")[0]);
						clickOrientationSelect(orientationParameters.split(":")[0]);
						selectOrientationValue(orientationParameters.split(":")[0],orientationParameters.split(",")[1].split(":")[1].split(">")[1]);			
					}
					else
					{
						fillOrientationValue(orientationParameters.split(":")[0],orientationParameters.split(",")[1].split(":")[1].split(">")[1]);
					}
					break;
				}
				case "yy":
				{
					if(orientationParameters.split(":")[1].contentEquals("symbol"))
					{
						changeOrientationToggle(orientationParameters.split(":")[0]);
						clickOrientationSelect(orientationParameters.split(":")[0]);
						selectOrientationValue(orientationParameters.split(":")[0],orientationParameters.split(":")[1].split(">")[1]);
					}					
					else
					{
						fillOrientationValue(orientationParameters.split(":")[0],orientationParameters.split(":")[1].split(">")[1]);
					}
					break;
				}
				case "yz":
				{
					if(orientationParameters.split(":")[1].contentEquals("symbol"))
					{
						changeOrientationToggle(orientationParameters.split(":")[0]);
						clickOrientationSelect(orientationParameters.split(":")[0]);
						selectOrientationValue(orientationParameters.split(":")[0],orientationParameters.split(":")[1].split(">")[1]);
					}
					else
					{
						fillOrientationValue(orientationParameters.split(":")[0],orientationParameters.split(":")[1].split(">")[1]);
					}
					break;
				}

				case "zx":
				{
					if(orientationParameters.split(":")[1].contentEquals("symbol"))
					{
						changeOrientationToggle(orientationParameters.split(":")[0]);
						clickOrientationSelect(orientationParameters.split(":")[0]);
						selectOrientationValue(orientationParameters.split(":")[0],orientationParameters.split(":")[1].split(">")[1]);
					}
					else
					{
						fillOrientationValue(orientationParameters.split(":")[0],orientationParameters.split(":")[1].split(">")[1]);
					}
					break;
				}

				case "zy":
				{
					if(orientationParameters.split(":")[1].contentEquals("symbol"))
					{
						changeOrientationToggle(orientationParameters.split(":")[0]);
						clickOrientationSelect(orientationParameters.split(":")[0]);
						selectOrientationValue(orientationParameters.split(":")[0],orientationParameters.split(":")[1].split(">")[1]);
					}
					else
					{
						fillOrientationValue(orientationParameters.split(":")[0],orientationParameters.split(":")[1].split(">")[1]);
					}
					break;
				}	
				case "zz":
				{
					if(orientationParameters.split(":")[1].contentEquals("symbol"))
					{
						changeOrientationToggle(orientationParameters.split(":")[0]);
						clickOrientationSelect(orientationParameters.split(":")[0]);
						selectOrientationValue(orientationParameters.split(":")[0],orientationParameters.split(",")[1].split(":")[1].split(">")[1]);
					}
					else
					{
						fillOrientationValue(orientationParameters.split(":")[0],orientationParameters.split(",")[1].split(":")[1].split(">")[1]);
					}
					break;
				}
				}
			}
			UtilHBM.waitFixTime(1000);
			componentNameInput.click();
			UtilHBM.waitFixTime(1000);
			orientationExpand.click();
			UtilHBM.waitFixTime(1000);
			clickClose();
		}
		return PageFactory.initElements(driver, Components.class);
	}

	Components changeOrientationToggle(String positionNumber)
	{
		orientationElements.findElement(By.xpath("//p[contains(@data-ui-selector='"+positionNumber.toUpperCase()+"')]/span/span/label[contains(@for,'symbol')]")).click();
		return PageFactory.initElements(driver, Components.class);
	}

	Components clickOrientationSelect(String positionNumber)
	{
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'"+positionNumber.toUpperCase()+"')]/span/span/select")).click();
		return PageFactory.initElements(driver, Components.class);
	}

	Components selectOrientationValue(String positionNumber,String value)
	{
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'"+positionNumber.toUpperCase()+"')]/span/span/select/optgroup/option[@value='"+value+"']")).click();
		return PageFactory.initElements(driver, Components.class);
	}

	Components fillOrientationValue(String positionNumber,String value)
	{
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'"+positionNumber.toUpperCase()+"')]/span/span/span/input")).click();
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'"+positionNumber.toUpperCase()+"')]/span/span/span/input")).clear();
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'"+positionNumber.toUpperCase()+"')]/span/span/span/input")).sendKeys(Keys.CONTROL + Keys.chord("a"));
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'"+positionNumber.toUpperCase()+"')]/span/span/span/input")).sendKeys(value+Keys.ENTER);
		driver.findElement(By.xpath("//form[@id='orientation-form']/p[contains(@data-ui-selector,'"+positionNumber.toUpperCase()+"')]/span/span/span/input")).click();
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, Components.class);
	}

	Components changeXPositionToggle()
	{
		driver.findElement(By.xpath("//*[@id='position-form']/p[contains(@data-ui-selector,'X')]/span/span/label/span[contains(@class,'right')]")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components clickXPositionSelect()
	{
		driver.findElement(By.xpath("//form[@id='position-form']/p[contains(@data-ui-selector,'X')]/span/span/select")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components selectXPositionValue(String value)
	{
		driver.findElement(By.xpath("//form[@id='position-form']/p[contains(@data-ui-selector,'X')]/span/span/select/optgroup/option[contains(@value,'"+value+"')]")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components fillXPositionValue(String value)
	{
		driver.findElement(By.xpath("form[@id='position-form']/p[contains(@data-ui-selector,'X')]/span/span/span/input")).sendKeys(value+Keys.ENTER);
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components changeYPositionToggle()
	{
		driver.findElement(By.xpath("//*[@id='position-form']/p[contains(@data-ui-selector,'Y')]/span/span/label/span[contains(@class,'right')]")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components clickYPositionSelect()
	{
		driver.findElement(By.xpath("//form[@id='position-form']/p[contains(@data-ui-selector,'Y')]/span/span/select")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components selectYPositionValue(String value)
	{
		driver.findElement(By.xpath("//form[@id='position-form']/p[contains(@data-ui-selector,'Y')]/span/span/select/optgroup/option[contains(@value,'"+value+"')]")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components fillYPositionValue(String value)
	{
		driver.findElement(By.xpath("form[@id='position-form']/p[contains(@data-ui-selector,'Y')]/span/span/span/input")).sendKeys(value+Keys.ENTER);
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components changeZPositionToggle()
	{
		driver.findElement(By.xpath("//*[@id='position-form']/p[contains(@data-ui-selector,'Z')]/span/span/label/span[contains(@class,'right')]")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components clickZPositionSelect()
	{
		driver.findElement(By.xpath("//form[@id='position-form']/p[contains(@data-ui-selector,'Z')]/span/span/select")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components selectZPositionValue(String value)
	{
		driver.findElement(By.xpath("//form[@id='position-form']/p[contains(@data-ui-selector,'Z')]/span/span/select/optgroup/option[contains(@value,'"+value+"')]")).click();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components fillZPositionValue(String value)
	{
		driver.findElement(By.xpath("form[@id='position-form']/p[contains(@data-ui-selector,'Z')]/span/span/span/input")).sendKeys(value+Keys.ENTER);
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components changePositionToggle(String positionNumber)
	{
		driver.findElement(By.xpath("//*[@id='position-form']/p[contains(@data-ui-selector,'"+positionNumber.toUpperCase()+"')]/span/span/label/span[contains(@class,'right')]")).click();
		return PageFactory.initElements(driver, Components.class);
	}

	Components clickPositionSelect(String positionNumber)
	{
		driver.findElement(By.xpath("//form[@id='position-form']/p[contains(@data-ui-selector,'"+positionNumber.toUpperCase()+"')]/span/span/select")).click();
		return PageFactory.initElements(driver, Components.class);
	}

	Components selectPositionValue(String positionNumber,String value)
	{
		driver.findElement(By.xpath("//form[@id='position-form']/p[contains(@data-ui-selector,'"+positionNumber.toUpperCase()+"')]/span/span/select/optgroup/option[contains(@value,'"+value+"')]")).click();
		return PageFactory.initElements(driver, Components.class);
	}

	Components fillPositionValue(String positionNumber,String value)
	{
		driver.findElement(By.xpath("form[@id='position-form']/p[contains(@data-ui-selector,'"+positionNumber.toUpperCase()+"')]/span/span/span/input")).sendKeys(value+Keys.ENTER);
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components fillXPositionDetails(String type,String value)
	{
		if(componentPanel.isDisplayed()||componentPositionPanel.isDisplayed())
		{
			UtilHBM.waitFixTime(1000);
			Verification.VerifyEquals("Label not displayed", label4.getText(),"Position");
			UtilHBM.turnOffImplicitWaits(driver);
			if(componentPositionExpand.size()>0)
				positionExpand.click();
			UtilHBM.turnOnImplicitWaits(driver);
			if(type.contentEquals("symbol"))
			{
				UtilHBM.waitFixTime(1000);
				changeXPositionToggle();
				clickXPositionSelect();
				selectXPositionValue(value);
			}
			else
			{
				fillXPositionValue(value);
			}
		}
		UtilHBM.waitFixTime(1000);

		clickClose();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components fillYPositionDetails(String type,String value)
	{
		if(componentPanel.isDisplayed()||componentPositionPanel.isDisplayed())
		{
			UtilHBM.waitFixTime(1000);
			Verification.VerifyEquals("Label not displayed", label4.getText(),"Position");
			UtilHBM.turnOffImplicitWaits(driver);
			if(componentPositionExpand.size()>0)
				positionExpand.click();
			UtilHBM.turnOnImplicitWaits(driver);
			if(type.contentEquals("symbol"))
			{
				UtilHBM.waitFixTime(1000);
				changeYPositionToggle();
				clickYPositionSelect();
				selectYPositionValue(value);
			}
			else
			{
				fillYPositionValue(value);
			}
		}
		UtilHBM.waitFixTime(1000);

		clickClose();
		return PageFactory.initElements(driver, Components.class);
	}
	
	Components fillZPositionDetails(String type,String value)
	{
		if(componentPanel.isDisplayed()||componentPositionPanel.isDisplayed())
		{
			UtilHBM.waitFixTime(1000);
			Verification.VerifyEquals("Label not displayed", label4.getText(),"Position");
			UtilHBM.turnOffImplicitWaits(driver);
			if(componentPositionExpand.size()>0)
				positionExpand.click();
			UtilHBM.turnOnImplicitWaits(driver);
			if(type.contentEquals("symbol"))
			{
				UtilHBM.waitFixTime(1000);
				changeZPositionToggle();
				clickZPositionSelect();
				selectZPositionValue(value);
			}
			else
			{
				fillZPositionValue(value);
			}
		}
		UtilHBM.waitFixTime(1000);
		clickClose();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, Components.class);
	}
	
	public Components fillPositionDetails(String positionParameters)
	{
		
		if(componentPanel.isDisplayed()||componentPositionPanel.isDisplayed())
		{
			UtilHBM.waitFixTime(1000);
			Verification.VerifyEquals("Label not displayed", label4.getText(),"Position");
			UtilHBM.turnOffImplicitWaits(driver);
			if(componentPositionExpand.size()>0)
				positionExpand.click();
			UtilHBM.turnOnImplicitWaits(driver);
			if(positionParameters.contains("!"))
			{
				for(String a:positionParameters.split("!"))
				{
					switch(a.split(":")[0])
					{
					case "x":
						if(a.split(":")[1].split(">")[0].contentEquals("symbol"))
						{
							UtilHBM.waitFixTime(1000);
							changePositionToggle(a.split(":")[0]);
							clickPositionSelect(a.split(":")[0]);
							selectPositionValue(a.split(":")[0], a.split(":")[1].split(">")[1]);
						}
						else
						{
							fillPositionValue(a.split(":")[1].split(">")[0],a.split(":")[1].split(">")[1]);
						}
						break;
					case "y":
						if(a.split(":")[1].split(">")[0].contentEquals("symbol"))
						{
							UtilHBM.waitFixTime(1000);
							changePositionToggle(a.split(":")[0]);
							clickPositionSelect(a.split(":")[0]);
							selectPositionValue(a.split(":")[0], a.split(":")[1].split(">")[1]);
						}
						else						
						{
							fillPositionValue(a.split(":")[1].split(">")[0],a.split(":")[1].split(">")[1]);
						}
						break;
					case "z":
						if(a.split(":")[1].split(">")[0].contentEquals("symbol"))
						{
							UtilHBM.waitFixTime(1000);
							changePositionToggle(a.split(":")[0]);
							clickPositionSelect(a.split(":")[0]);
							selectPositionValue(a.split(":")[0], a.split(":")[1].split(">")[1]);
						}
						else
						{
							fillPositionValue(a.split(":")[1].split(">")[0],a.split(":")[1].split(">")[1]);
						}
						break;
					}

				}
			}
			else
			{
				switch(positionParameters.split(":")[0])
				{
				case "x":
					if(positionParameters.split(":")[1].split(">")[0].contentEquals("symbol"))
					{
						UtilHBM.waitFixTime(1000);
						changePositionToggle(positionParameters.split(":")[0]);
						clickPositionSelect(positionParameters.split(":")[0]);
						selectPositionValue(positionParameters.split(":")[0], positionParameters.split(":")[1].split(">")[1]);
					}
					else
					{
						fillPositionValue(positionParameters.split(":")[1].split(">")[0],positionParameters.split(":")[1].split(">")[1]);
					}
					break;
				case "y":
					if(positionParameters.split(":")[1].split(">")[0].contentEquals("symbol"))
					{
						UtilHBM.waitFixTime(1000);
						changePositionToggle(positionParameters.split(":")[0]);
						clickPositionSelect(positionParameters.split(":")[0]);
						selectPositionValue(positionParameters.split(":")[0], positionParameters.split(":")[1].split(">")[1]);
					}
					else
					{
						fillPositionValue(positionParameters.split(":")[1].split(">")[0],positionParameters.split(":")[1].split(">")[1]);
					}
					break;
				case "z":
					if(positionParameters.split(":")[1].split(">")[0].contentEquals("symbol"))
					{
						UtilHBM.waitFixTime(1000);
						changePositionToggle(positionParameters.split(":")[0]);
						clickPositionSelect(positionParameters.split(":")[0]);
						selectPositionValue(positionParameters.split(":")[0], positionParameters.split(":")[1].split(">")[1]);
					}
					else
					{
						fillPositionValue(positionParameters.split(":")[1].split(">")[0],positionParameters.split(":")[1].split(">")[1]);
					}
					break;
				}
			}
			UtilHBM.waitFixTime(1000);
			positionExpand.click();
			clickClose();
		}
		
		return PageFactory.initElements(driver, Components.class);
	}

    public Components showHideComponent(String action) {
		UtilHBM.waitFixTime(500);
		UtilHBM.turnOffImplicitWaits(driver);
		switch(action.toLowerCase()){
			case "hide":
				if(hideComponentBtn.size()==1)hideComponentBtn.get(0).click();
				break;
			case "show":
			default:
				if(showComponentBtn.size()==1)showComponentBtn.get(0).click();
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return PageFactory.initElements(driver, Components.class);
	}

	public Components openComponent() {
		UtilHBM.waitFixTime(1000);
		UtilHBM.turnOffImplicitWaits(driver);
		UtilHBM.waitExplicitDisplayed(driver, openComponentBtn);
		openComponentBtn.click();
		UtilHBM.turnOnImplicitWaits(driver);
		return PageFactory.initElements(driver, Components.class);
	}
}
