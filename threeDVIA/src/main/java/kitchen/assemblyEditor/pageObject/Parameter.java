package kitchen.assemblyEditor.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class Parameter {
	WebDriver driver;

	public Parameter(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css="#panel")
	WebElement parameterPanel;
	
	@FindBy(css="div.floating-pane-parameters>div>div>section>form>p>span>#input-name")
	WebElement parameterNameInput;
	
	@FindBy(css="div.floating-pane-parameters>div>div>section>form>p>span>select[id='select-type']")
	WebElement parameterType;
	
	@FindBy(css="div.floating-pane-parameters>div>div>section>form>p>span>#input-value")
	WebElement parameterValue;
	
	@FindBy(css="div.floating-pane-parameters>p>span>button[title='Close']")
	WebElement closeButton;

	@FindBy(css="#panel>div>div>section>form>div>button.cta-primary")
	WebElement chooseRefButton;
	
	@FindBy(css="button[data-ui-action='delete-ref']")
	WebElement deleteRefProdButton;
	
	@FindBy(css="div.floating-pane-parameters>div>div>section>form>p>span>select[id='select-value']")
	WebElement selectParameterValue;
	
	@FindBy(css="#panel>p.header")
	WebElement header1;
	
	@FindBy(css="#panel>p>span>span>button[data-ui-action='duplicate']")
	WebElement duplicateButton;
	
	@FindBy(css="#panel>p>span>span>button[data-ui-action='delete']")
	WebElement deleteButton;

	@FindBy(css="section.floating-content>form>p>label[for='param-1']")
	WebElement label1;

	@FindBy(css="section.floating-content>form>p>label[for='param-2']")
	WebElement label2;
	
	@FindBy(css="section.floating-content>form>p>label[for='param-3']")
	WebElement label3;
	
	static String parameterName;
	
	
	AssemblyEditor verifyParameterDetails(String name,String type,String value)
	{
		Verification.VerifyEquals("Parameter name incorrect", parameterNameInput.getAttribute("value"), name);
		Verification.VerifyEquals("Type incorrect", UtilHBM.webElement(driver, "section.floating-content>form>p>span>span.label").getText(), type);
		if(type.contentEquals("number")||type.contentEquals("integer"))
		{
			Verification.VerifyEquals("Parameter value incorrect", UtilHBM.webElement(driver, "div>section>form>p>span.mod-measure-input>input[id='input-value']").getAttribute("value"), value);
		}
		else if(type.contentEquals("component")||type.contentEquals("material"))
		{
			Verification.VerifyEquals("Parameter component incorrect", UtilHBM.webElement(driver, "div>section>form>p>span.mod-measure-input>input[id='param-3']").getAttribute("value"), value);
//			UtilHBM.waitFixTime(1000);
			Verification.displayOfWebElement(UtilHBM.webElement(driver, "#panel-floating-pane>#panel>div>div>section>form>div>img[src*='https'][src$='jpg']"));
			Verification.displayOfWebElement(chooseRefButton);
			Verification.displayOfWebElement(deleteRefProdButton);
		}
		else if(type.contentEquals("boolean"))
		{
			Verification.VerifyEquals("Parameter value incorrect", UtilHBM.webElement(driver, "div>section>form>p:nth-child(3)>span.form-select>span.label").getText(),value);
		}
		clickClose();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	
	AssemblyEditor addParameterDetails(String parameterName,String type,String searchString,String productName)
	{
		if(parameterPanel.isDisplayed())
		{ 
			Verification.VerifyEquals("Header not displayed", header1.getText().replace("\n", " "), "Parameter Duplicate Delete Close");
			Verification.VerifyEquals("Incorrect label", label1.getText(), "Name");
			Verification.VerifyEquals("Incorrect label", label2.getText(), "Type");
			Verification.VerifyEquals("Incorrect label", label3.getText(), "Value");
			UtilHBM.waitExplicitClickable(driver, duplicateButton);
			UtilHBM.waitExplicitClickable(driver, deleteButton);
			parameterNameInput.clear();
			parameterNameInput.sendKeys(parameterName+Keys.ENTER);
			UtilHBM.waitFixTime(1000);
			parameterName=driver.findElement(By.cssSelector("#panel>div>div>section>form>p>span>input")).getAttribute("value");
			setParameterName(parameterName);
			selectParameterType(type);
			clickChooseRef()
			.selectProductForParameter(searchString,productName);
			UtilHBM.waitFixTime(2000);
		}
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	AssemblyEditor addParameterDetails(String parameterName,String type,String value)
	{
		if(parameterPanel.isDisplayed())
		{ 
			Verification.VerifyEquals("Header not displayed", header1.getText().replace("\n", " "), "Parameter Duplicate Delete Close");
			Verification.VerifyEquals("Incorrect label", label1.getText(), "Name");
			Verification.VerifyEquals("Incorrect label", label2.getText(), "Type");
			Verification.VerifyEquals("Incorrect label", label3.getText(), "Value");
			UtilHBM.waitExplicitClickable(driver, duplicateButton);
			UtilHBM.waitExplicitClickable(driver, deleteButton);
			parameterNameInput.clear();
			parameterNameInput.sendKeys(parameterName);
			parameterName=driver.findElement(By.cssSelector("#panel>div>div>section>form>p>span>input")).getAttribute("value");
			setParameterName(parameterName);
			selectParameterType(type);
			if(type.contentEquals("number"))
			{
				parameterValue.click();
				UtilHBM.waitFixTime(1000);
				parameterValue.clear();
//				parameterValue.sendKeys(Keys.CONTROL + Keys.chord("a"));
				parameterValue.sendKeys(value);
			}
			else if(type.contentEquals("integer"))
			{
				parameterValue.click();
				UtilHBM.waitFixTime(1000);
				parameterValue.clear();
//				parameterValue.sendKeys(Keys.CONTROL + Keys.chord("a"));
				parameterValue.sendKeys(value);
			}
			else if(type.contentEquals("string"))
			{
				parameterValue.click();
				UtilHBM.waitFixTime(1000);
				parameterValue.clear();
//				parameterValue.sendKeys(Keys.CONTROL + Keys.chord("a"));
				parameterValue.sendKeys(value);
			}
			else if(type.contentEquals("boolean"))
			{
				new Select(selectParameterValue).selectByValue(value);
				UtilHBM.waitFixTime(2000);
			}
			UtilHBM.waitFixTime(1000);
			parameterNameInput.click();
			UtilHBM.waitFixTime(1000);
			clickClose();
		}
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	AssemblyEditor addParameterDetails(String productName)
	{ 
		if(parameterPanel.isDisplayed())
		{ 
			Verification.VerifyEquals("Header not displayed", header1.getText().replace("\n", " "), "Parameter Duplicate Delete Close");
			Verification.VerifyEquals("Incorrect label", label1.getText(), "Name");
			Verification.VerifyEquals("Incorrect label", label2.getText(), "Type");
			Verification.VerifyEquals("Incorrect label", label3.getText(), "Value");
			UtilHBM.waitExplicitClickable(driver, duplicateButton);
			UtilHBM.waitExplicitClickable(driver, deleteButton);
			parameterNameInput.clear();
			parameterNameInput.sendKeys(productName.split(",")[0]);
			parameterName=driver.findElement(By.cssSelector("#panel>div>div>section>form>p>span>input")).getAttribute("value");
			setParameterName(parameterName);
			selectParameterType(productName.split(",")[1].split(">")[0]);
			if((productName.split(",")[1].split(">")[0]).contentEquals("component"))
			{
				clickChooseRef()
				.select(productName.split(",")[1].split(">")[1]);
				UtilHBM.waitFixTime(2000);
			}
			else if((productName.split(",")[1].split(">")[0]).contentEquals("number"))
			{
				parameterValue.click();
				UtilHBM.waitFixTime(1000);
				parameterValue.clear();
				parameterValue.sendKeys(Keys.CONTROL + Keys.chord("a"));
				parameterValue.sendKeys(productName.split(",")[1].split(">")[1]);
			}
			else if((productName.split(",")[1].split(">")[0]).contentEquals("integer"))
			{
				parameterValue.click();
				UtilHBM.waitFixTime(1000);
				parameterValue.clear();
				parameterValue.sendKeys(Keys.CONTROL + Keys.chord("a"));
				parameterValue.sendKeys(productName.split(",")[1].split(">")[1]);
			}
			else if((productName.split(",")[1].split(">")[0]).contentEquals("string"))
			{
				parameterValue.click();
				UtilHBM.waitFixTime(1000);
				parameterValue.clear();
				parameterValue.sendKeys(Keys.CONTROL + Keys.chord("a"));
				parameterValue.sendKeys(productName.split(",")[1].split(">")[1]);
			}
			else if((productName.split(",")[1].split(">")[0]).contentEquals("boolean"))
			{
				new Select(selectParameterValue).selectByValue(productName.split(",")[1].split(">")[1]);
				UtilHBM.waitFixTime(2000);
			}
			else if((productName.split(",")[1].split(">")[0]).contentEquals("material"))
			{
				clickChooseRef()
				.select(productName.split(",")[1].split(">")[1]);
			}
			parameterNameInput.click();
			UtilHBM.waitFixTime(1000);
			clickClose();
		}
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	Parameter selectParameterType(String type)
	{
		new Select(parameterType).selectByValue(type);
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, Parameter.class);
	}
	
	public static String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		Parameter.parameterName = parameterName;
	}

	public AssemblyEditor clickClose()
	{
		UtilHBM.waitExplicitDisplayed(driver, closeButton);
		UtilHBM.waitFixTime(1000);
		closeButton.click();
		UtilHBM.waitTillElementDisappear(driver, "div.floating-pane-parameters>p>span>button[title='Close']");
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	SelectProduct clickChooseRef()
	{
		UtilHBM.waitExplicitDisplayed(driver, chooseRefButton);
		chooseRefButton.click();
		return PageFactory.initElements(driver, SelectProduct.class);
	}
		 
		
}
