package kitchen.templateEditor.pageObject;




import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;


public class Group {
	WebDriver driver;
	
	public Group(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css="ul>li>button[data-step='3']")
	WebElement groupButton;

	@FindBy(css=".cta-primary-l")
	WebElement createGroupButton;
	
	@FindBy(css="#group-information>div.content")
	List<WebElement> groupInfoPopin;
	
	@FindBy(css="#form-info-name")
	WebElement groupName;
	
	@FindBy(css=".popin-form>p>label:nth-child(3)>span.state")
	WebElement optionalTypeRadioButton;
	
	@FindBy(css="input[name='water-supply']")
	WebElement waterSupplyInputButton;
	
	@FindBy(css="input[name='room-separator']")
	WebElement roomSeparatorInputButton;
	
	@FindBy(css="#group-information>div>footer>button.cta-primary-l")
	WebElement okButton;
	
	@FindBy(css=".cta-primary")
	WebElement nextButton;
	
	@FindBy(css="ul.group-list>li>p.text")
	List<WebElement> groupNameText;
	
	@FindBy(css="button[title='Close']")
	WebElement closeButton;
	
	@FindBy(css=".cta-primary-l")
	WebElement createSubGroupButton;
	
	@FindBy(css="section>ul>li>p")
	List<WebElement> subgroupText;
	
	@FindBy(css="h2")
	WebElement title1;
	
	@FindBy(css="p.intro")
	WebElement subtitle1;
	
	@FindBy(css="p>b")
	WebElement subtitle2;
	
	@FindBy(css="h2.tt")
	WebElement subtitle3;
	
	@FindBy(css="p.subtitle")
	WebElement subtitle4;
	
	@FindBy(css="h2")
	WebElement title2;
	
	@FindBy(css="label[for='form-info-name']")
	WebElement subtitle5;
	
	@FindBy(css="p.group-radio>span")
	WebElement subtitle6;

	@FindBy(css="p.group-radio>label:nth-child(2)>span.label")
	WebElement subtitle7;
	
	@FindBy(css="p.group-radio>label:nth-child(3)>span.label")
	WebElement subtitle8;
	
	@FindBy(css="p:nth-child(3)>span")
	WebElement subtitle9;
	
	@FindBy(css="label[class='water-supply']>span")
	WebElement subtitle10;
	
	@FindBy(css="label[class='room-separator']>span")
	WebElement subtitle11;
	
	@FindBy(css="form>p:nth-child(4)")
	WebElement subtitle12;
	
	@FindBy(css="form>p:nth-child(5)")
	WebElement subtitle13;
	
	@FindBy(css="#template-editor-panel>div>div>div>p")
	WebElement subtitle14;
	
	@FindBy(css="ul.group-list>li")
	List<WebElement> groupList;
	
	@FindBy(css="p.persistent.show")
	WebElement popupMsg;

	@FindBy(css="#product-boundingbox-selection-table>section>ul>li>figure>figcaption>b")
	List<WebElement> selectedProductName;
	
	@FindBy(css="ul>li>figure>figcaption>b")
	WebElement selectedFuniture;
	
	@FindBy(css="#zoom-in")
	WebElement zoomInButton;
	
	@FindBy(css="#bmSVG")
	WebElement container3D;
	
	@FindBy(css="button[data-ui-action='remove']")
	List<WebElement> removeButton;
	
	@FindBy(css="li.current>button[data-step='3']")
	List<WebElement> groupButtonAct;
	
	@FindBy(css="button[data-state='design']")
	WebElement designButton;
	
	String subtitle1ExpectedText="A group is an indivisible set of products that will move together when placed in the end user’s roomOnly products in groups will be part of your template and appear in results.One product can only be in one group.";
	String subtitle2ExpectedText="To start you need to create groups with all the products you want to include in your template.";
	String subtitle12ExpectedText="Groups can be mandatory or optional. If a mandatory group doesn't fit in the user's room, the template will have no results. If an optional group doesn't fit, it will not appear in results.";
	String subtitle14ExpectedText="Create sub-group of optional products by clicking on them. Products in a sub-group will be removed together from solutions if at least one of them is in collision with a room obstacle - door, window, column, etc.A product can only be in one sub-group.A product can be either an accessory or in an optional sub-group.";
	String popupMsg1ExpectedText="Select all products you want to include in this group by clicking on it. You need to select at least one product. Don't forget that one product can only be in one group and only products included in groups will appear in results.Close";
	String popupMsg2ExpectedText="Select all products you want to define as accessories by clicking on it. When a product is defined as an accessory, collision between the product and room obstacles -doors, windows, columns...- are allowed.Close";
	String popupMsg3ExpectedText="Select a reference wall by clicking on it. In results, your group will always be placed along a wall the same way as it is now along your reference wall.Close";
	
	public Design goToDesignPage()
	{
		designButton.click();
		UtilHBM.waitExplicitDisplayed(driver, container3D);
		UtilHBM.waitFixTime(3000);
		return PageFactory.initElements(driver, Design.class);
	}
	
	public Group editGroup(String grpName,String newGrpName,String type,String additionalInfo,String kitchenName)
	{
		if(groupButtonAct.size()==0)
			groupButton.click();
		driver.findElement(By.xpath("//ul[@class='group-list']/li/p[contains(text(),'"+grpName+"')]/following-sibling::div/button[@data-ui-action='edit']")).click();
		createGroup(newGrpName, type, additionalInfo, kitchenName);
		return PageFactory.initElements(driver, Group.class);
	}
	
	public Group createGroup(String grpName,String type,String additionalInfo,String kitchenName)
	{
		UtilHBM.reportInfo("Creating new group");
		UtilHBM.turnOffImplicitWaits(driver);
		if(groupButtonAct.size()==0)
			groupButton.click();
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.turnOffImplicitWaits(driver);
		if(groupList.size()==0)
		{
			Verification.VerifyEquals("Page title not displayed", title1.getText(), "Group list");
			Verification.VerifyEquals("Page subtitle not displayed",subtitle1.getText().replaceAll("\n", ""), subtitle1ExpectedText);
			Verification.VerifyEquals("Page subtitle not displayed", subtitle2.getText(), subtitle2ExpectedText);
		}
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.waitExplicitDisplayed(driver, createGroupButton);
		UtilHBM.waitExplicitClickable(driver, createGroupButton);
		if(groupInfoPopin.size()==0)
			createGroupButton.click();
		UtilHBM.waitExplicitDisplayed(driver, groupInfoPopin.get(0));
		Verification.VerifyEquals("Page subtitle not displayed", subtitle3.getText(), "Group information");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle4.getText(), "Fill in the information of this group.");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle5.getText(), "Name *");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle6.getText(), "Type");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle7.getText(), "Mandatory");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle8.getText(), "Optional");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle9.getText(), "Additional information");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle10.getText(), "Need water supply");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle11.getText(), "Can be placed along a room separator");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle12.getText(), subtitle12ExpectedText);
		Verification.VerifyEquals("Page subtitle not displayed", subtitle13.getText(), "* Mandatory fields");
		UtilHBM.waitExplicitDisplayed(driver, groupName);
		groupName.clear();
		groupName.sendKeys(grpName);
		if(type.contentEquals("Optional"))
		{
			optionalTypeRadioButton.click();
		}
		if(additionalInfo.contains("/"))
		{
			if(additionalInfo.split("/")[0].contentEquals("Water"))
				waterSupplyInputButton.click();
			if(additionalInfo.split("/")[1].contentEquals("RoomSeperator"))
				roomSeparatorInputButton.click();					
		}
		else if(!additionalInfo.equalsIgnoreCase("null"))
		{
			if(additionalInfo.contentEquals("Water"))
				waterSupplyInputButton.click();
			if(additionalInfo.contentEquals("RoomSeparator"))
				roomSeparatorInputButton.click();
		}
		okButton.click();
		String groupCoords=UtilHBM.getProperty("TemplateEditor", kitchenName).split("/")[0];
		if(groupCoords.contains(">"))
		{
			for(String a:groupCoords.split(">"))
			{
				selectProduct(Integer.parseInt(a.split(",")[0]), Integer.parseInt(a.split(",")[1]));
			}
			nextButton.click();
		}
		else
		{
			selectProduct(Integer.parseInt(groupCoords.split(",")[0]), Integer.parseInt(groupCoords.split(",")[1]));
			UtilHBM.waitFixTime(2000);
			nextButton.click();
		}
		String accessoriesCoords=UtilHBM.getProperty("TemplateEditor", kitchenName).split("/")[1];
		if(!accessoriesCoords.equalsIgnoreCase("null"))
		{
			if(accessoriesCoords.contains(">"))
			{
				for(String a:accessoriesCoords.split(">"))
				{
					Actions actions=new Actions(driver);
					actions.moveToElement(container3D,321,-330).clickAndHold().pause(500).release().build().perform();
					selectProduct(Integer.parseInt(a.split(",")[0]),Integer.parseInt(a.split(",")[1]));
				}
				nextButton.click();
			}
			else
			{
				Actions actions=new Actions(driver);
				actions.moveToElement(container3D,321,-330).clickAndHold().pause(500).release().build().perform();
				selectProduct(Integer.parseInt(accessoriesCoords.split(",")[0]),Integer.parseInt(accessoriesCoords.split(",")[1]));
				nextButton.click();
			}
		}
		else
		{
			nextButton.click();
			UtilHBM.waitFixTime(2000);
		}
		String optionalFurnitureCoords=UtilHBM.getProperty("TemplateEditor", kitchenName).split("/")[2];
		if(!optionalFurnitureCoords.equalsIgnoreCase("null"))
		{		
			if(optionalFurnitureCoords.contains(";"))
			{
				for(String a:optionalFurnitureCoords.split(";"))
				{
					if(a.contains(">"))
					{
						for(String b:a.split(">"))
						{
							Actions actions=new Actions(driver);
							actions.moveToElement(container3D,321,-330).clickAndHold().pause(500).release().build().perform();
							selectProduct(Integer.parseInt(b.split(",")[0]),Integer.parseInt(b.split(",")[1]));	
						}
					}
					else
					{
						Actions actions=new Actions(driver);
						actions.moveToElement(container3D,321,-330).clickAndHold().pause(500).release().build().perform();
						selectProduct(Integer.parseInt(a.split(",")[0]),Integer.parseInt(a.split(",")[1]));
					}
					createSubGroupButton.click();
			
				}
				for(int i=0;i<optionalFurnitureCoords.split(";").length;i++)
				{
					UtilHBM.waitExplicitDisplayed(driver, subgroupText.get(i));
				}
			}
			else
			{
				if(optionalFurnitureCoords.contains(">"))
				{
					for(String c:optionalFurnitureCoords.split(">"))
					{
						Actions actions=new Actions(driver);
						actions.moveToElement(container3D,321,-330).clickAndHold().pause(500).release().build().perform();
						selectProduct(Integer.parseInt(c.split(",")[0]),Integer.parseInt(c.split(",")[1]));		
					}
					createSubGroupButton.click();
					UtilHBM.waitExplicitDisplayed(driver, subgroupText.get(subgroupText.size()-1));
				}
				else
				{
					Actions actions=new Actions(driver);
					actions.moveToElement(container3D,321,-330).clickAndHold().pause(500).release().build().perform();
					selectProduct(Integer.parseInt(optionalFurnitureCoords.split(",")[0]),Integer.parseInt(optionalFurnitureCoords.split(",")[1]));
					createSubGroupButton.click();
					UtilHBM.waitExplicitDisplayed(driver, subgroupText.get(subgroupText.size()-1));
				}
			}
			nextButton.click();
		}
		else
		{
			nextButton.click();
		}
		nextButton.click();
		if(groupNameText.get(groupNameText.size()-1).getText().contains(grpName.toUpperCase()))
		{
			UtilHBM.reportOK("Group "+groupNameText.get(groupNameText.size()-1).getText()+" created");
		}
		return PageFactory.initElements(driver, Group.class);
	}
	
	
	
	Group selectProduct(int xcoordinate,int ycoordinate)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(container3D,xcoordinate,ycoordinate).clickAndHold().pause(500).release().build().perform();
		return PageFactory.initElements(driver, Group.class);
	}
	
	
}
