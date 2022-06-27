package kitchen.assemblyEditor.pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Relations {
	WebDriver driver;

	public Relations(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css="#panel-floating-pane")
	WebElement relationPanel;
	
	@FindBy(css="#input-name")
	WebElement relationNameInput;

	@FindBy(css = "#input-value")
	WebElement relationValue;

	@FindBy(css = "ul#errors-list>li")
	List<WebElement> errMsgList;

	@FindBy(css=".form-select>select[data-ui-id='select-type']")
	WebElement relationType;
	
	@FindBy(css=".editable-content")
	WebElement expressionInput;
	
	@FindBy(css="button[title='Close']")
	WebElement closeButton;
	
	@FindBy(xpath="//article[@class='mod-panel-container-wide mod-open']/div[@id='panel']/p[@class='header'][contains(text(), 'Relation')]")
	WebElement header1;
	
	@FindBy(css="label[for='input-name']")
	WebElement label1;
	
	@FindBy(css="label[for='compo-3']")
	WebElement label2;
	
	@FindBy(css="label[for='input-value']")
	WebElement label3;
	
	@FindBy(css="#expression-section>p.title")
	WebElement label4;
	
	static String relationNameParameter;
	
	AssemblyEditor fillRelationDetails(String relationName,String type,String relationExpression){
		UtilHBM.waitExplicitClickable(driver, header1);	
		UtilHBM.waitExplicitDisplayed(driver, header1);
		Verification.VerifyEquals("Header not displayed", header1.getText().replace("\n", " "), "Relation Duplicate Delete Close");
		Verification.VerifyEquals("Label not displayed", label1.getText(), "Name");
		Verification.VerifyEquals("Label not displayed", label2.getText(), "Type");
		Verification.VerifyEquals("Label not displayed", label3.getText(), "Value");
		Verification.VerifyEquals("Label not displayed", label4.getText(), "Expression");
		relationNameInput.clear();
		relationNameInput.sendKeys(relationName, Keys.ENTER);
		UtilHBM.waitFixTime(1000);
		for (int counter =0; counter<5; counter ++) {
			try {
				UtilHBM.waitExplicitDisplayed(driver,relationNameInput);
				relationNameParameter=relationNameInput.getAttribute("value");
				break;
			} catch (StaleElementReferenceException e) {
				UtilHBM.waitFixTime(333);
			}
		}
		setRelationNameParameter(relationNameParameter);
//		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver, "//li[@id='relation-section']/ul/li/span[@class='selected'][starts-with(@title, '"+relationName+"')]"));
//		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver, "//input[@id='input-name'][@value='"+relationName+"']"));
		UtilHBM.waitFixTime(2000);
		selectType(type);
		expressionInput.sendKeys(relationExpression+Keys.ENTER);
		UtilHBM.waitFixTime(1000);
		expressionInput.click();
		UtilHBM.waitFixTime(1000);
		clickClose();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	AssemblyEditor verifyRelationDetails(String name, String type, String relValue, String expression , String[] errorMessages)
	{
		Verification.VerifyEquals("Relation name incorrect", relationNameInput.getAttribute("value"), name);
		Verification.VerifyEquals("Type incorrect", UtilHBM.webElement(driver, "section.floating-content>form>p>span>span.label").getText(), type);
		if(!relValue.isEmpty()){
			Verification.VerifyEquals("Relation value incorrect", relationValue.getAttribute("value"), relValue);
		}
		Verification.VerifyEquals("Relation expression incorrect", expressionInput.getText(), expression);

		List<String> expectedErrMessages= new ArrayList<>(Arrays.asList(errorMessages));
		List<String> displayedErrMessages = new ArrayList<>();
		for(WebElement e : errMsgList)displayedErrMessages.add(e.getText().trim());
		List<String> expectedErrMessagesDisplayed= new ArrayList<>(Arrays.asList(errorMessages));
		expectedErrMessagesDisplayed.retainAll(displayedErrMessages);

		displayedErrMessages.removeAll(expectedErrMessagesDisplayed);
		if(displayedErrMessages.size()>0)UtilHBM.reportKO("Unexpected error messages displayed : "+displayedErrMessages.toString());
		expectedErrMessages.removeAll(expectedErrMessagesDisplayed);
		if(expectedErrMessages.size()>0)UtilHBM.reportKO("Expected error messages not displayed : "+expectedErrMessages.toString());

		clickClose();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	AssemblyEditor fillRelationDetails(String relation)
	{ 
		if(relationPanel.isDisplayed())
		{
			Verification.VerifyEquals("Header not displayed", header1.getText().replace("\n", " "), "Relation Duplicate Delete Close");
			Verification.VerifyEquals("Label not displayed", label1.getText(), "Name");
			Verification.VerifyEquals("Label not displayed", label2.getText(), "Type");
			Verification.VerifyEquals("Label not displayed", label3.getText(), "Value");
			Verification.VerifyEquals("Label not displayed", label4.getText(), "Expression");
			relationNameInput.clear();
			relationNameInput.sendKeys(relation.split(",")[0]);
			relationNameParameter=driver.findElement(By.cssSelector("#panel>div>div>section>form>p>span>input")).getAttribute("value");
			setRelationNameParameter(relationNameParameter);
			selectType(relation.split(",")[1]);
			expressionInput.sendKeys(relation.split(",")[2]);
			UtilHBM.waitFixTime(1000);
			expressionInput.click();
			UtilHBM.waitFixTime(1000);
			clickClose();
		}
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public static String getRelationNameParameter() {
		return relationNameParameter;
	}

	public static void setRelationNameParameter(String relationNameParameter) {
		Relations.relationNameParameter = relationNameParameter;
	}

	Relations selectType(String type)
	{
		UtilHBM.waitFixTime(2000);
		for (int i=0; i<5; i++) {
			try {
				new Select(relationType).selectByValue(type);
				break;
			} catch (StaleElementReferenceException e) {
				UtilHBM.waitFixTime(500);
			}
		}
		return PageFactory.initElements(driver, Relations.class);
	}
	
	AssemblyEditor clickClose()
	{
		UtilHBM.waitExplicitDisplayed(driver, closeButton);
		UtilHBM.waitFixTime(1000);
		closeButton.click();
		UtilHBM.waitTillElementDisappear(driver, "div.floating-pane-relations>p>span>button[title='Close']");
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
}
