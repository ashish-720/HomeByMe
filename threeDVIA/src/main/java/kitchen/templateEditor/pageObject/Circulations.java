package kitchen.templateEditor.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;


public class Circulations {
	WebDriver driver;
	
	public Circulations(WebDriver driver) {
		this.driver=driver;	
	}
	@FindBy(css="#step-circulation")
	WebElement circulationStepButton;
	
	@FindBy(css=".cta-primary-l")
	WebElement newCirculationButton;
	
	@FindBy(css="#circulation-front")
	WebElement frontValue;
	
	@FindBy(css="#circulation-right")
	WebElement rightValue;
	
	@FindBy(css="#circulation-back")
	WebElement backValue;
	
	@FindBy(css="#circulation-left")
	WebElement leftValue;
		
	@FindBy(css=".cta-primary")
	WebElement validateButton;
	
	@FindBy(css="h2.title")
	WebElement title1;
	
	@FindBy(css="p.intro")
	WebElement subtitle1;
		
	@FindBy(css="#wizard-title")
	WebElement title2;
	
	@FindBy(css="ul.group-list>li")
	List<WebElement> circulationList;
	
	@FindBy(css="button[data-state='design']")
	WebElement designButton;
	
	@FindBy(css="#bmSVG")
	WebElement container3D;
	
	String subtitle1ExpectedText="A circulation area is space that will be kept empty when placing this template into the end-user's room.Circulation areas can overlap each other in results, but no furniture or obstacle can be inside a circulation area.";
	
	public Circulations verifyCirculation(String groupName,String values)
	{
		circulationStepButton.click();
		for(int i=0;i<circulationList.size();i++)
		{
			if(circulationList.get(i).findElement(By.xpath("//p")).getText().contains(groupName.toUpperCase()))
			{
				circulationList.get(i).findElement(By.cssSelector("div>button[data-ui-action='edit']")).click();
				break;
			}
		}
		Verification.VerifyEquals("Value for front ciruclation incorrect", frontValue.getAttribute("value"), values.split(";")[0]+" mm");
		Verification.VerifyEquals("Value for right ciruclation incorrect", rightValue.getAttribute("value"), values.split(";")[1]+" mm");
		Verification.VerifyEquals("Value for back ciruclation incorrect", backValue.getAttribute("value"), values.split(";")[2]+" mm");
		Verification.VerifyEquals("Value for left ciruclation incorrect", leftValue.getAttribute("value"), values.split(";")[3]+" mm");
		validateButton.click();
		return PageFactory.initElements(driver, Circulations.class);
	}
	
	public Circulations goToCirculations()
	{
		circulationStepButton.click();
		return PageFactory.initElements(driver, Circulations.class);
	}
	
	public Circulations editCirculations(String groupName,String values)
	{
		UtilHBM.webElementXPath(driver, "//ul[@class='group-list']/li/p[contains(text(),'"+groupName+"')]/parent::li/div/button[@data-ui-action='edit']").click();
		frontValue.click();
		frontValue.clear();
		frontValue.sendKeys(Keys.CONTROL+"a");
		frontValue.sendKeys(values.split(";")[0]);
		rightValue.click();
		rightValue.clear();
		rightValue.sendKeys(Keys.CONTROL+"a");
		rightValue.sendKeys(values.split(";")[1]);
		backValue.click();
		backValue.clear();
		backValue.sendKeys(Keys.CONTROL+"a");
		backValue.sendKeys(values.split(";")[2]);
		leftValue.click();
		leftValue.clear();
		leftValue.sendKeys(Keys.CONTROL+"a");
		leftValue.sendKeys(values.split(";")[3]);
		validateButton.click();
		checkCirculation(groupName);
		return PageFactory.initElements(driver, Circulations.class);
	}
	
	public Circulations createCirculation(String groupName,String type,int xcoordinate,int ycoordinate ,String values)
	{
		UtilHBM.reportInfo("Creating new circulation");
		goToCirculations();
		Verification.VerifyEquals("Page title not displayed", title1.getText(), "Circulation list");
		newCirculationButton.click();
		CirculationType group=PageFactory.initElements(driver, CirculationType.class);
		group.selectType(type);
		Verification.VerifyEquals("Page title not displayed", title2.getText(), "Group selection");
		Actions actions=new Actions(driver);
		actions.moveToElement(container3D,321,-330).clickAndHold().pause(500).release().build().perform();
		selectProduct(xcoordinate,ycoordinate);
		UtilHBM.waitFixTime(1000);
		validateButton.click();
		Verification.VerifyEquals("Page title not displayed", title2.getText(), "Values selection");
		frontValue.click();
		frontValue.sendKeys(Keys.CONTROL+"a");
		frontValue.sendKeys(values.split(";")[0]);
		rightValue.click();
		rightValue.sendKeys(Keys.CONTROL+"a");
		rightValue.sendKeys(values.split(";")[1]);
		backValue.click();
		backValue.sendKeys(Keys.CONTROL+"a");
		backValue.sendKeys(values.split(";")[2]);
		leftValue.click();
		leftValue.sendKeys(Keys.CONTROL+"a");
		leftValue.sendKeys(values.split(";")[3]);
		validateButton.click();
		checkCirculation(groupName);
		return PageFactory.initElements(driver, Circulations.class);
	}
	Circulations checkCirculation(String groupName)
	{
		if(circulationList.get(circulationList.size()-1).getText().contains(groupName.toUpperCase()))
		{
			UtilHBM.reportOK(circulationList.get(circulationList.size()-1).getText()+" created");
		}
		return PageFactory.initElements(driver, Circulations.class);
	}
	
	Circulations selectProduct(int xcoordinate,int ycoordinate)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(container3D,xcoordinate+5,ycoordinate+5)
		.moveToElement(container3D,xcoordinate,ycoordinate).clickAndHold().pause(500).release().build().perform();
		return PageFactory.initElements(driver, Circulations.class);
	}
	public Design goToDesignPage()
	{
		designButton.click();
		UtilHBM.waitExplicitDisplayed(driver, container3D);
		UtilHBM.waitFixTime(3000);
		return PageFactory.initElements(driver, Design.class);
	}
}
