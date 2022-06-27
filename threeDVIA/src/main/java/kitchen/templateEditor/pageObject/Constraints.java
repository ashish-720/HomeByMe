package kitchen.templateEditor.pageObject;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import org.testng.Assert;

public class Constraints {
	WebDriver driver;
	
	public Constraints(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css="#step-constraint")
	WebElement constraintStep;
	
	@FindBy(css="button[data-ui-action='add-constraint']")
	WebElement createConstraintButton;
	
	@FindBy(css="button[data-ui-action='popin-ok']")
	WebElement oKbutton;
	
	@FindBy(css=".cta-primary")
	WebElement nextButton;
	
	@FindBy(xpath="//button[@class='cta-primary'][.='Validate']")
	WebElement validateButton;
	
	@FindBy(css="#min-angle-value")
	WebElement miniAngleInput;
	
	@FindBy(css="#max-angle-value")
	WebElement maxAngleInput;
	
	@FindBy(css="#min-left-value")
	WebElement miniLeftLengthInput;
	
	@FindBy(css="#max-left-value")
	WebElement maxLeftLengthInput;
	
	@FindBy(css="#min-right-value")
	WebElement miniRightLengthInput;
	
	@FindBy(css="#max-right-value")
	WebElement maxRightLengthInput;
	
	@FindBy(css="#side>p.form-row:nth-child(1)>label>span.label")
	WebElement leftButton;
	
	@FindBy(css="#side>p.form-row:nth-child(2)>label>span.label")
	WebElement rightButton;
	
	@FindBy(css="#corner-type>p:nth-child(1)>label>span.state")
	WebElement openCorner;
	
	@FindBy(css="#corner-type>p:nth-child(2)>label>span.state")
	WebElement closedCorner;
	
	@FindBy(css="ul.group-list>li")
	List<WebElement> groupList;
	
	@FindBy(css="#constraint-type>div>div>form>ul>li:nth-child(2)>p>label>span.state")
	WebElement distToWallConstraintRadioButton;
	
	@FindBy(css="#side>p:nth-child(1)>label>span.state")
	WebElement leftRadioButton;
	
	@FindBy(css="#side>p:nth-child(2)>label>span.state")
	WebElement rightRadioButton;
	
	@FindBy(css="#side>p:nth-child(3)>label>span.state")
	WebElement centerRadioButton;
	
	@FindBy(css="#side>p:nth-child(4)>label>span.state")
	WebElement noPrefRadioButton;
	
	@FindBy(css="#min-value")
	WebElement minDistance;
	
	@FindBy(css="h2.title")
	WebElement title1;
	
	@FindBy(css="p.intro")
	WebElement subtitle1;
	
	@FindBy(css="#bmSVG")
	WebElement container3D;
	
	@FindBy(xpath="//*[@id='placement-type']/div/div/header/h2[.='Relative placement']")
	WebElement title2;
	
	@FindBy(css="#wizard-title")
	WebElement title3;
	
	@FindBy(css="p.persistent.show>span[data-ui-selector='notification-text']")
	WebElement popupMsg1;

	@FindBy(xpath = "//span[@data-ui-selector='notification-text' and starts-with(text(), 'Select the two products you want to constrain. You will be able to preserve a distance between them')]")
	WebElement distanceConstrainPopupMsg;

	@FindBy(xpath = "//span[@data-ui-selector='notification-text' and starts-with(text(), 'Select the product you want to constrain to stay in a corner')]")
	WebElement cornerConstrainPopupMsg;

	@FindBy(xpath = "//span[@data-ui-selector='notification-text' and starts-with(text(), 'Select the two products you want to align')]")
	WebElement selectProductsToAlignPopupMsg;

	@FindBy(xpath = "//span[@data-ui-selector='notification-text' and starts-with(text(), 'Select the corner filler in the 3D scene')]")
	WebElement selectCornerFillerPopupMsg;

	@FindBy(xpath = "//span[@data-ui-selector='notification-text' and starts-with(text(), 'Select the furniture that is on the left of the corner filler')]")
	WebElement selectFurnitureLeftOfCornerFillerPopupMsg;

	@FindBy(xpath = "//span[@data-ui-selector='notification-text' and starts-with(text(), 'Select the furniture that is on the right of the corner filler')]")
	WebElement selectFurnitureRightOfCornerFillerPopupMsg;

	@FindBy(xpath = "//span[@data-ui-selector='notification-text' and starts-with(text(), 'Select the group you want to position')]")
	WebElement selectGrpToPositionPopupMsg;

	@FindBy(xpath = "//span[@data-ui-selector='notification-text' and starts-with(text(), 'Select the furniture that is the closest to the left wall')]")
	WebElement selectFurniturePopupMsg1;

	@FindBy(xpath = "//span[@data-ui-selector='notification-text' and starts-with(text(), 'Select the furniture that is the closest to the right wall')]")
	WebElement selectFurniturePopupMsg2;

	@FindBy(xpath="//span[@data-ui-selector='notification-text' and starts-with(text(), 'Select the first group you want to constrain')]")
	WebElement selectFirstGrpPopupMsg;

	@FindBy(xpath="//span[@data-ui-selector='notification-text' and starts-with(text(), 'Select the second group you want to constrain')]")
	WebElement selectSecondGrpPopupMsg;

	@FindBy(css="p.header")
	WebElement subtitle2;
	
	@FindBy(css="form:nth-child(1)>h3.title")
	WebElement subtitle3;
	
	@FindBy(css="form:nth-child(1)>p.intro")
	WebElement subtitle4;
		
	@FindBy(css="form:nth-child(2)>h3.title")
	WebElement subtitle5;
	
	@FindBy(css="form:nth-child(2)>p.intro")
	WebElement subtitle6;
	
	@FindBy(css="p.form-row>label")
	WebElement subtitle7;
	
	@FindBy(css="p.subtitle")
	WebElement subtitle8;
	
	@FindBy(css="#distance-values-panel>div>p.header")
	WebElement subtitle9;
	
	@FindBy(css="li:nth-child(3)>p>label>span.state")
	WebElement rpcRadioButton;
	
	@FindBy(css="li:nth-child(4)>p>label>span.state")
	WebElement alignmentRadioButton;
	
	@FindBy(css="li:nth-child(5)>p>label>span.state")
	WebElement distanceRadioButton;
	
	@FindBy(css="li:nth-child(6)>p>label>span.state")
	WebElement cornerFillerRadioButton;
	
	@FindBy(css="#goal-value")
	WebElement goalInput;
	
	@FindBy(css="#min-value")
	WebElement minInput;
	
	@FindBy(css="#max-value")
	WebElement maxInput;
	
	@FindBy(id="margin-value")
	WebElement marginOfError;
	
	@FindBy(id="zoom-in")
	WebElement zoomInButton;
	
	@FindBy(css="ul>li:nth-child(1)>p>label>span.state")
	WebElement faceToFaceRadioButton;
	
	@FindBy(css="ul>li:nth-child(2)>p>label>span.state")
	WebElement faceSameDircRadioButton;
	
	@FindBy(css="ul>li:nth-child(3)>p>label>span.state")
	WebElement perpendicularRadioButton;
	
	@FindBy(css="ul>li:nth-child(4)>p>label>span.state")
	WebElement perpendicularSideRadioButton;
	
	@FindBy(css="ul>li:nth-child(5)>p>label>span.state")
	WebElement sameWallRadioButton;
	
	@FindBy(css="button[title='Save']")
	WebElement saveButton;
	
	@FindBy(css="button[data-state='design']")
	WebElement designButton;

	@FindBy(xpath="//*[text()='Constraint list']/parent::header/following-sibling::div[@class='content']//ul[@class='group-list']")
	WebElement constraintList;

	String subtitle1ExpectedText="A constraint is a rule that will be followed when placing this template into the end-user's room.Constraints must be fulfilled. If the user's room doesn't allow for a solution that fulfills every constraints, then there will be no solutions.";
	String popupMsg1ExpectedText="Select the product you want to constrain to stay in a corner.";
	String subtitle4ExpectedText="Select the position according to the reference wall";
	String subtitle6ExpectedText="Select the corner type(s) to position the group";
	String subtitle7ExpectedText="Select on which side the group should be positioned";
	String popupMsg2ExpectedText="Select the group you want to position";
	String popupMsg3ExpectedText="Select the first group you want to constraint. The selected group will be placed on a wall perpendicular to the second group.";
	String popupMsg4ExpectedText="Select the second group you want to constraint. The selected group will be placed on a wall perpendicular to the previous group.";
	String subtitle8ExpectedText="Fill the minimum distance between the left wall and the group";
	String subtitle9ExpectedText="Fill the minimum distance between the right wall and the group";
	String subtitle10ExpectedText="Select the direction along which you want to preserve the distance between the products by clicking on an axis. We automatically suggest the current distance value as a goal distance to preserve. Feel free to modify the goal, minimum and maximum distance. We advise to at least leave 1cm of margin between the goal and the minimum and maximum.";
	
	
	public Constraints editCornerConstraint(String position,String cornerType)
	{
		goToConstraints();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		UtilHBM.turnOffImplicitWaits(driver);
		int count=groupList.size();
		UtilHBM.turnOnImplicitWaits(driver);
		driver.findElement(By.xpath("//ul[@class='group-list']/li/p[contains(text(),'Corner')]/following-sibling::div/button[@data-ui-action='edit']")).click();
		Verification.VerifyEquals("Page title not displayed", title3.getText(), "Values selection");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle2.getText(), "Position definition");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle3.getText(), "Position");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle4.getText(), subtitle4ExpectedText);
		Verification.VerifyEquals("Page subtitle not displayed", subtitle5.getText(), "Corner type");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle6.getText(), subtitle6ExpectedText);
		if(position.contentEquals("left"))
		{
			leftButton.click();
		}
		else 
		{
			rightButton.click();
		}
		if(cornerType.contentEquals("open"))
		{
			openCorner.click();
		}
		else
		{
			closedCorner.click();
		}
		UtilHBM.waitExplicitClickable(driver, validateButton);
		validateButton.click();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		if(!(groupList.size()==count)){
					UtilHBM.reportKO("Number of Corner constrains is not same after edit. Number of Constraints before this step: "+count +", Number of constraints after this step: " + groupList.size());
				}
		checkConstraint("Corner");
		return PageFactory.initElements(driver, Constraints.class);
	}
	
	public Design goToDesignPage()
	{
		designButton.click();
		UtilHBM.waitExplicitDisplayed(driver, container3D);
		UtilHBM.waitFixTime(3000);
		return PageFactory.initElements(driver, Design.class);
	}
	
	public Constraints saveProject()
	{
		saveButton.click();
		UtilHBM.waitFixTime(3000);
		return PageFactory.initElements(driver, Constraints.class);
	}
	
	public Constraints verification()
	{
		Verification.VerifyEquals("Page title not displayed", title1.getText(), "Constraint list");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle1.getText().replaceAll("\n", ""), subtitle1ExpectedText);
		return PageFactory.initElements(driver, Constraints.class);
	}
	
	Constraints selectProduct(int xcoordinate,int ycoordinate)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(container3D,xcoordinate+5,ycoordinate+5)
		.moveToElement(container3D,xcoordinate,ycoordinate).clickAndHold().pause(500).release().build().perform();
		return PageFactory.initElements(driver, Constraints.class);
	}
	
	Constraints checkConstraint(String constraintType)
	{
		List<WebElement> constraint=driver.findElements(By.cssSelector("ul.group-list>li>p"));
		if(constraint.get(constraint.size()-1).getText().contains(constraintType.toUpperCase()))
		{
			UtilHBM.reportOK(constraint.get(constraint.size()-1).getText()+" created");
		}
		return PageFactory.initElements(driver, Constraints.class);
	}
	
	public Constraints createCornerFillerConstraint(String kitchenName)
	{
		UtilHBM.reportInfo("Creating CornerFiller constraint");
		constraintStep.click();
		if(groupList.size()==0)
			verification();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		UtilHBM.waitExplicitClickable(driver, createConstraintButton);
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		UtilHBM.turnOffImplicitWaits(driver);
		int count=groupList.size();
		UtilHBM.turnOnImplicitWaits(driver);
		createConstraintButton.click();	
		cornerFillerRadioButton.click();
		UtilHBM.waitExplicitDisplayed(driver, oKbutton);
		UtilHBM.waitExplicitClickable(driver, oKbutton);
		oKbutton.click();
		
		String cornerFillerXCoordinates=UtilHBM.getProperty("TemplateEditor", kitchenName+"CornerFillerConstraint").split("/")[0].split(",")[0];        
		String cornerFillerYCoordinates=UtilHBM.getProperty("TemplateEditor", kitchenName+"CornerFillerConstraint").split("/")[0].split(",")[1];
		Actions actions=new Actions(driver);
		UtilHBM.waitExplicitDisplayed(driver, selectCornerFillerPopupMsg);
		actions.moveToElement(container3D,321,-330).clickAndHold().pause(500).release().build().perform();
		selectProduct(Integer.parseInt(cornerFillerXCoordinates), Integer.parseInt(cornerFillerYCoordinates));
		if(!UtilHBM.getProperty("TemplateEditor", kitchenName+"CornerFillerConstraint").split("/")[1].split(",")[0].equalsIgnoreCase("null"))
		{
			miniAngleInput.sendKeys(UtilHBM.getProperty("TemplateEditor", kitchenName+"CornerFillerConstraint").split("/")[1].split(",")[0]);
		}
		if(!UtilHBM.getProperty("TemplateEditor", kitchenName+"CornerFillerConstraint").split("/")[1].split(",")[1].equalsIgnoreCase("null"))
		{
			maxAngleInput.sendKeys(UtilHBM.getProperty("TemplateEditor", kitchenName+"CornerFillerConstraint").split("/")[1].split(",")[1]);
		}
		if(!UtilHBM.getProperty("TemplateEditor", kitchenName+"CornerFillerConstraint").split("/")[1].split(",")[2].equalsIgnoreCase("null"))
		{
			miniLeftLengthInput.sendKeys(UtilHBM.getProperty("TemplateEditor", kitchenName+"CornerFillerConstraint").split("/")[1].split(",")[2]);
		}
		if(!UtilHBM.getProperty("TemplateEditor", kitchenName+"CornerFillerConstraint").split("/")[1].split(",")[3].equalsIgnoreCase("null"))
		{
			maxLeftLengthInput.sendKeys(UtilHBM.getProperty("TemplateEditor", kitchenName+"CornerFillerConstraint").split("/")[1].split(",")[3]);
		}
		if(!UtilHBM.getProperty("TemplateEditor", kitchenName+"CornerFillerConstraint").split("/")[1].split(",")[4].equalsIgnoreCase("null"))
		{
			miniRightLengthInput.sendKeys(UtilHBM.getProperty("TemplateEditor", kitchenName+"CornerFillerConstraint").split("/")[1].split(",")[4]);
		}
		if(!UtilHBM.getProperty("TemplateEditor", kitchenName+"CornerFillerConstraint").split("/")[1].split(",")[5].equalsIgnoreCase("null"))
		{
			maxRightLengthInput.sendKeys(UtilHBM.getProperty("TemplateEditor", kitchenName+"CornerFillerConstraint").split("/")[1].split(",")[5]);
		}
		UtilHBM.waitFixTime(1000);
		nextButton.click();
		UtilHBM.waitExplicitDisplayed(driver, selectFurnitureLeftOfCornerFillerPopupMsg);
		actions.moveToElement(container3D,321,-330).clickAndHold().pause(500).release().build().perform();
		String leftFurnitureXCoordinate=UtilHBM.getProperty("TemplateEditor", kitchenName+"CornerFillerConstraint").split("/")[2].split(",")[0];
		String leftFurnitureYCoordinate=UtilHBM.getProperty("TemplateEditor", kitchenName+"CornerFillerConstraint").split("/")[2].split(",")[1];
		selectProduct(Integer.parseInt(leftFurnitureXCoordinate), Integer.parseInt(leftFurnitureYCoordinate));
		UtilHBM.waitFixTime(1000);
		nextButton.click();
		UtilHBM.waitExplicitDisplayed(driver, selectFurnitureRightOfCornerFillerPopupMsg);
		String rightFurnitureXCoordinate=UtilHBM.getProperty("TemplateEditor", kitchenName+"CornerFillerConstraint").split("/")[3].split(",")[0];
		String rightFurnitureYCoordinate=UtilHBM.getProperty("TemplateEditor", kitchenName+"CornerFillerConstraint").split("/")[3].split(",")[1];
		actions.moveToElement(container3D,321,-330).clickAndHold().pause(500).release().build().perform();
		selectProduct(Integer.parseInt(rightFurnitureXCoordinate), Integer.parseInt(rightFurnitureYCoordinate));
		UtilHBM.waitExplicitClickable(driver, validateButton);
		validateButton.click();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		if(!(groupList.size()>count)){
					UtilHBM.reportKO("CornerFiller constraints is not created. Number of Constraints before this step: "+count +", Number of constraints after this step: " + groupList.size());
				}
		checkConstraint("CornerFiller");
		return PageFactory.initElements(driver, Constraints.class);
	}
	
	public Constraints createCornerConstraint(int xcoordinate,int ycoordinate,String position,String cornerType)
	{
		UtilHBM.reportInfo("Creating corner constraint");
		constraintStep.click();
		if(groupList.size()==0)
			verification();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		UtilHBM.waitExplicitClickable(driver, createConstraintButton);
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		UtilHBM.turnOffImplicitWaits(driver);
		int count=groupList.size();
		UtilHBM.turnOnImplicitWaits(driver);
		createConstraintButton.click();	
		UtilHBM.waitExplicitDisplayed(driver, oKbutton);
		UtilHBM.waitExplicitClickable(driver, oKbutton);
		oKbutton.click();
		Verification.VerifyEquals("Page title not displayed", title3.getText(), "Product selection");
		UtilHBM.waitExplicitDisplayed(driver, cornerConstrainPopupMsg);
		Verification.VerifyEquals("Popup message not displayed", popupMsg1.getText(), popupMsg1ExpectedText);
		selectProduct(xcoordinate,ycoordinate);
		UtilHBM.waitFixTime(1000);
		nextButton.click();
		Verification.VerifyEquals("Page title not displayed", title3.getText(), "Values selection");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle2.getText(), "Position definition");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle3.getText(), "Position");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle4.getText(), subtitle4ExpectedText);
		Verification.VerifyEquals("Page subtitle not displayed", subtitle5.getText(), "Corner type");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle6.getText(), subtitle6ExpectedText);
		if(position.contentEquals("left"))
		{
			leftButton.click();
		}
		else 
		{
			rightButton.click();
		}
		if(cornerType.contentEquals("open"))
		{
			openCorner.click();
		}
		else
		{
			closedCorner.click();
		}
		UtilHBM.waitExplicitClickable(driver, validateButton);
		validateButton.click();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		if(!(groupList.size()>count)){
					UtilHBM.reportKO("Corner constraints is not created. Number of Constraints before this step: "+count +", Number of constraints after this step: " + groupList.size());
				}
		checkConstraint("Corner");
		return PageFactory.initElements(driver, Constraints.class); 
	}

	Constraints goToConstraints()
	{
		constraintStep.click();
		return PageFactory.initElements(driver, Constraints.class);
	}
	
	public Constraints editDistanceToWallConstraint(String kitchenType)
	{
		goToConstraints();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		UtilHBM.turnOffImplicitWaits(driver);
		int count=groupList.size();
		UtilHBM.turnOnImplicitWaits(driver);
		driver.findElement(By.xpath("//ul[@class='group-list']/li/p[contains(text(),'DistanceToWall')]/following-sibling::div/button[@data-ui-action='edit']")).click();
		String groupSide=UtilHBM.getProperty("TemplateEditor", kitchenType+"DistToWall").split("/")[0];
		switch(groupSide.toLowerCase())
		{
		case "left":
			leftRadioButton.click();
			break;
		case "right":
			rightRadioButton.click();
			break;
		case "center":
			centerRadioButton.click();
			break;
		case "no preference":
			noPrefRadioButton.click();
			break;			
		}
		clickBlank();	
		String groupCoordinates=UtilHBM.getProperty("TemplateEditor", kitchenType+"DistToWall").split("/")[1];
		if(!groupCoordinates.equalsIgnoreCase("null"))
		{
			selectProduct(Integer.parseInt(groupCoordinates.split(",")[0]),Integer.parseInt(groupCoordinates.split(",")[1]));
			nextButton.click();
		}
		else
		{
			nextButton.click();
		}
		String leftMinDist=UtilHBM.getProperty("TemplateEditor", kitchenType+"DistToWall").split("/")[2];
		minDistance.clear();
		minDistance.sendKeys(leftMinDist);
		String leftFurnitureCoordinates=UtilHBM.getProperty("TemplateEditor", kitchenType+"DistToWall").split("/")[3];
		if(!leftFurnitureCoordinates.equalsIgnoreCase("null"))
		{
			selectProduct(Integer.parseInt(leftFurnitureCoordinates.split(",")[0]),Integer.parseInt(leftFurnitureCoordinates.split(",")[1]));
			nextButton.click();
		}
		else
		{
			nextButton.click();
		}
		String rightMinDist=UtilHBM.getProperty("TemplateEditor", kitchenType+"DistToWall").split("/")[4];
		minDistance.clear();
		minDistance.sendKeys(rightMinDist);
		String rightFurnitureCoordinates=UtilHBM.getProperty("TemplateEditor", kitchenType+"DistToWall").split("/")[5];
		if(!rightFurnitureCoordinates.equalsIgnoreCase("null"))
		{
			selectProduct(Integer.parseInt(rightFurnitureCoordinates.split(",")[0]),Integer.parseInt(rightFurnitureCoordinates.split(",")[1]));
			UtilHBM.waitExplicitClickable(driver, validateButton);
			validateButton.click();
		}
		else
		{
			UtilHBM.waitExplicitClickable(driver, validateButton);
			validateButton.click();
		}
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		if(!(groupList.size()==count)){
					UtilHBM.reportKO("Number of DistanceToWallConstraint constrains is not same after edit. Number of Constraints before this step: "+count +", Number of constraints after this step: " + groupList.size());
				}
		checkConstraint("DistanceToWall");
		return PageFactory.initElements(driver, Constraints.class);
	}
	
	
	
	Constraints clickBlank() 
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(container3D,321,-330).clickAndHold().pause(500).release().build().perform();
		return PageFactory.initElements(driver, Constraints.class);
	}
	
	public Constraints createDistanceToWallConstraint(String kitchenType) 
	{
		goToConstraints();
		UtilHBM.reportInfo("Creating Distance to wall constraint");
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		UtilHBM.waitExplicitClickable(driver, createConstraintButton);
		UtilHBM.turnOffImplicitWaits(driver);
		int count=groupList.size();
		UtilHBM.turnOnImplicitWaits(driver);
		createConstraintButton.click();
		UtilHBM.waitExplicitDisplayed(driver, distToWallConstraintRadioButton);
		UtilHBM.waitExplicitClickable(driver, distToWallConstraintRadioButton);
		distToWallConstraintRadioButton.click();
		oKbutton.click();
		UtilHBM.waitExplicitDisplayed(driver, selectGrpToPositionPopupMsg);
		Verification.VerifyEquals("Page title not displayed", title3.getText(), "Group selection");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle2.getText(),subtitle7ExpectedText);
		Verification.VerifyEquals("Popup message not displayed", popupMsg1.getText(), popupMsg2ExpectedText);
		String groupSide=UtilHBM.getProperty("TemplateEditor", kitchenType+"DistToWall").split("/")[0];
		switch(groupSide.toLowerCase())
		{
		case "left":
			leftRadioButton.click();
			break;
		case "right":
			rightRadioButton.click();
			break;
		case "center":
			centerRadioButton.click();
			break;
		case "no preference":
			noPrefRadioButton.click();
			break;			
		}
		clickBlank();
		String groupCoordinates=UtilHBM.getProperty("TemplateEditor", kitchenType+"DistToWall").split("/")[1];
		selectProduct(Integer.parseInt(groupCoordinates.split(",")[0]),Integer.parseInt(groupCoordinates.split(",")[1]));
		UtilHBM.waitFixTime(1000);
		nextButton.click();
		UtilHBM.waitExplicitDisplayed(driver, selectFurniturePopupMsg1);
		Verification.VerifyEquals("Page title not displayed", title3.getText(), "Left side parameters");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle2.getText(),subtitle8ExpectedText);
		Verification.VerifyEquals("Page subtitle not displayed", subtitle7.getText(), "Left minimum distance");
		Verification.VerifyEquals("Popup message not displayed", popupMsg1.getText(), "Select the furniture that is the closest to the left wall");
		clickBlank();
		String leftMinDist=UtilHBM.getProperty("TemplateEditor", kitchenType+"DistToWall").split("/")[2];
		minDistance.clear();
		UtilHBM.waitFixTime(500);
		minDistance.sendKeys(leftMinDist);
		UtilHBM.waitFixTime(500);
		String leftFurnitureCoordinates=UtilHBM.getProperty("TemplateEditor", kitchenType+"DistToWall").split("/")[3];
		selectProduct(Integer.parseInt(leftFurnitureCoordinates.split(",")[0]),Integer.parseInt(leftFurnitureCoordinates.split(",")[1]));
		UtilHBM.waitFixTime(1000);
		nextButton.click();
		UtilHBM.waitExplicitDisplayed(driver, selectFurniturePopupMsg2);
		Verification.VerifyEquals("Page title not displayed", title3.getText(), "Right side parameters");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle2.getText(),subtitle9ExpectedText);
		Verification.VerifyEquals("Page subtitle not displayed", subtitle7.getText(), "Right minimum distance");
		Verification.VerifyEquals("Popup message not displayed", popupMsg1.getText(), "Select the furniture that is the closest to the right wall");
		clickBlank();
		String rightMinDist=UtilHBM.getProperty("TemplateEditor", kitchenType+"DistToWall").split("/")[4];
		minDistance.clear();
		UtilHBM.waitFixTime(500);
		minDistance.sendKeys(rightMinDist);
		UtilHBM.waitFixTime(500);
		String rightFurnitureCoordinates=UtilHBM.getProperty("TemplateEditor", kitchenType+"DistToWall").split("/")[5];
		selectProduct(Integer.parseInt(rightFurnitureCoordinates.split(",")[0]),Integer.parseInt(rightFurnitureCoordinates.split(",")[1]));
		UtilHBM.waitExplicitClickable(driver, validateButton);
		validateButton.click();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		if(!(groupList.size()>count)){
			UtilHBM.reportKO("Distance To Wall constraints is not created. Number of Constraints before this step: "+count +", Number of constraints after this step: " + groupList.size());
		}
		UtilHBM.waitExplicitDisplayed(driver, groupList.get(count));
		checkConstraint("DistanceToWall");
		return PageFactory.initElements(driver, Constraints.class);
	}
	
	public Constraints editFaceToFaceRpC(int grpOneXCoordinate,int grpOneYCoordinate,int grpTwoXCoordinate,int grpTwoYCoordinate)
	{
		goToConstraints();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		UtilHBM.turnOffImplicitWaits(driver);
		int count=groupList.size();
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.waitExplicitDisplayed(driver, "//ul[@class='group-list']/li/p[contains(text(),'RelativePlacement')]/following-sibling::div/button[@data-ui-action='edit']");
		driver.findElement(By.xpath("//ul[@class='group-list']/li/p[contains(text(),'RelativePlacement')]/following-sibling::div/button[@data-ui-action='edit']")).click();
		clickBlank();
		selectProduct(grpOneXCoordinate,grpOneYCoordinate);
		nextButton.click();
		UtilHBM.waitFixTime(3000);
		clickBlank();
		selectProduct(grpTwoXCoordinate,grpTwoYCoordinate);
		UtilHBM.waitExplicitClickable(driver, validateButton);
		validateButton.click();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		if(!(groupList.size()==count)){
					UtilHBM.reportKO("Number of FaceToFace constrains is not same after edit. Number of Constraints before this step: "+count +", Number of constraints after this step: " + groupList.size());
				}
		return PageFactory.initElements(driver, Constraints.class);
	}
	
	public Constraints faceToFaceRpC(int grpOneXCoordinate,int grpOneYCoordinate,int grpTwoXCoordinate,int grpTwoYCoordinate){
		goToConstraints();
		UtilHBM.reportInfo("Creating Relative placement (Face to face) constraint");
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		UtilHBM.waitExplicitClickable(driver, createConstraintButton);
		UtilHBM.turnOffImplicitWaits(driver);
		int count=groupList.size();
		UtilHBM.turnOnImplicitWaits(driver);
		createConstraintButton.click();
		UtilHBM.waitExplicitDisplayed(driver, rpcRadioButton);
		UtilHBM.waitExplicitClickable(driver, rpcRadioButton);
		rpcRadioButton.click();
		UtilHBM.waitFixTime(500);
		oKbutton.click();
		UtilHBM.waitExplicitDisplayed(driver, title2);
		Verification.VerifyEquals("Page title not displayed", title2.getText(), "Relative placement");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle8.getText(), "Select the given-configuration to place groups");
		faceToFaceRadioButton.click();
		UtilHBM.waitFixTime(500);
		oKbutton.click();
		clickBlank();
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, selectFirstGrpPopupMsg);
		selectProduct(grpOneXCoordinate,grpOneYCoordinate);
		UtilHBM.waitFixTime(1000);
		nextButton.click();
		UtilHBM.waitFixTime(3000);
		clickBlank();
		UtilHBM.waitExplicitDisplayed(driver, selectSecondGrpPopupMsg);
		selectProduct(grpTwoXCoordinate,grpTwoYCoordinate);
		UtilHBM.waitExplicitClickable(driver, validateButton);
		validateButton.click();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		if(!(groupList.size()>count)){
			UtilHBM.reportKO("Face to face constraints is not created. Number of Constraints before this step: "+count +", Number of constraints after this step: " + groupList.size());
		}
		UtilHBM.waitExplicitDisplayed(driver, groupList.get(count));
		checkConstraint("RelativePlacement");
		return PageFactory.initElements(driver, Constraints.class);
	}
	
	public Constraints editFaceSameDircRpc(int groupOneXCoordinate,int groupOneYCoordinate,int groupTwoXCoordinate,int groupTwoYCoordinate)
	{
		goToConstraints();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		UtilHBM.turnOffImplicitWaits(driver);
		int count=groupList.size();
		UtilHBM.turnOnImplicitWaits(driver);
		driver.findElement(By.xpath("//ul[@class='group-list']/li/p[contains(text(),'RelativePlacement')]/following-sibling::div/button[@data-ui-action='edit']")).click();
		clickBlank();
		selectProduct(groupOneXCoordinate,groupOneYCoordinate);
		nextButton.click();
		UtilHBM.waitFixTime(2000);
		clickBlank();
		selectProduct(groupTwoXCoordinate,groupTwoYCoordinate);
		UtilHBM.waitExplicitClickable(driver, validateButton);
		validateButton.click();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		if(!(groupList.size()==count)){
					UtilHBM.reportKO("Number of FaceSameDirc constrains is not same after edit. Number of Constraints before this step: "+count +", Number of constraints after this step: " + groupList.size());
				}
		return PageFactory.initElements(driver, Constraints.class);
	}
	
	public Constraints faceSameDircRpC(int groupOneXCoordinate,int groupOneYCoordinate,int groupTwoXCoordinate,int groupTwoYCoordinate)
	{
		goToConstraints();
		UtilHBM.reportInfo("Creating Relative placement (Facing same direction) constraint");
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		UtilHBM.waitExplicitClickable(driver, createConstraintButton);
		UtilHBM.turnOffImplicitWaits(driver);
		int count=groupList.size();
		UtilHBM.turnOnImplicitWaits(driver);
		createConstraintButton.click();
		UtilHBM.waitExplicitDisplayed(driver, rpcRadioButton);
		UtilHBM.waitExplicitClickable(driver, rpcRadioButton);
		rpcRadioButton.click();
		UtilHBM.waitFixTime(500);
		oKbutton.click();
		UtilHBM.waitExplicitDisplayed(driver, title2);
		Verification.VerifyEquals("Page title not displayed", title2.getText(), "Relative placement");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle8.getText(), "Select the given-configuration to place groups");
		faceSameDircRadioButton.click();
		UtilHBM.waitFixTime(500);
		oKbutton.click();
		clickBlank();
		selectProduct(groupOneXCoordinate,groupOneYCoordinate);
		nextButton.click();
		UtilHBM.waitFixTime(2000);
		clickBlank();
		selectProduct(groupTwoXCoordinate,groupTwoYCoordinate);
		UtilHBM.waitExplicitClickable(driver, validateButton);
		validateButton.click();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		if(!(groupList.size()>count)){
			UtilHBM.reportKO("Face Same Direction constraints is not created. Number of Constraints before this step: "+count +", Number of constraints after this step: " + groupList.size());
		}
		UtilHBM.waitExplicitDisplayed(driver, groupList.get(count));
		checkConstraint("RelativePlacement");
		return PageFactory.initElements(driver, Constraints.class);
	}
	
	public Constraints editPerpToSpecificSideRpc(int groupOneXCoordinate,int groupOneYCoordinate,int groupTwoXCoordinate,int groupTwoYCoordinate)
	{
		goToConstraints();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		UtilHBM.turnOffImplicitWaits(driver);
		int count=groupList.size();
		UtilHBM.turnOnImplicitWaits(driver);
		driver.findElement(By.xpath("//ul[@class='group-list']/li/p[contains(text(),'RelativePlacement')]/following-sibling::div/button[@data-ui-action='edit']")).click();
		UtilHBM.waitFixTime(2000);
		clickBlank();
		selectProduct(groupOneXCoordinate,groupOneYCoordinate);
		nextButton.click();
		UtilHBM.waitFixTime(2000);
		clickBlank();
		selectProduct(groupTwoXCoordinate,groupTwoYCoordinate);
		UtilHBM.waitExplicitClickable(driver, validateButton);
		validateButton.click();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		if(!(groupList.size()==count)){
					UtilHBM.reportKO("Number of distance constrains is not same after edit. Number of Constraints before this step: "+count +", Number of constraints after this step: " + groupList.size());
				}
		return PageFactory.initElements(driver, Constraints.class);
	}
	
	public Constraints editPerpToEachOtherRpc(int groupOneXCoordinate,int groupOneYCoordinate,int groupTwoXCoordinate,int groupTwoYCoordinate)
	{
		goToConstraints();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		UtilHBM.turnOffImplicitWaits(driver);
		int count=groupList.size();
		UtilHBM.turnOnImplicitWaits(driver);
		driver.findElement(By.xpath("//ul[@class='group-list']/li/p[contains(text(),'RelativePlacement')]/following-sibling::div/button[@data-ui-action='edit']")).click();
		clickBlank();
		selectProduct(groupOneXCoordinate,groupOneYCoordinate);
		nextButton.click();
		UtilHBM.waitFixTime(2000);
		clickBlank();
		selectProduct(groupTwoXCoordinate,groupTwoYCoordinate);
		UtilHBM.waitExplicitClickable(driver, validateButton);
		validateButton.click();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		if(!(groupList.size()==count)){
					UtilHBM.reportKO("Number of PerpToEachOther constrains is not same after edit. Number of Constraints before this step: "+count +", Number of constraints after this step: " + groupList.size());
				}
		return PageFactory.initElements(driver, Constraints.class);
	}

	public Constraints editOnSameWallRpc(String groupOneCoordinate, String groupTwoCoordinate) {
		goToConstraints();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		UtilHBM.turnOffImplicitWaits(driver);
		int count=groupList.size();
		UtilHBM.turnOnImplicitWaits(driver);
		driver.findElement(By.xpath("//ul[@class='group-list']/li/p[contains(text(),'SameWall')]/following-sibling::div/button[@data-ui-action='edit']")).click();
		UtilHBM.waitExplicitDisplayed(driver, selectFirstGrpPopupMsg);
		if (!groupOneCoordinate.isEmpty()) {
			int groupOneXCoordinate=Integer.parseInt(groupOneCoordinate.split(",")[0].trim());
			int groupOneYCoordinate=Integer.parseInt(groupOneCoordinate.split(",")[1].trim());
			clickBlank();
			selectProduct(groupOneXCoordinate, groupOneYCoordinate);
		}
		nextButton.click();
		UtilHBM.waitExplicitDisplayed(driver, selectSecondGrpPopupMsg);
		if (!groupTwoCoordinate.isEmpty()) {
			int groupTwoXCoordinate=Integer.parseInt(groupTwoCoordinate.split(",")[0].trim());
			int groupTwoYCoordinate=Integer.parseInt(groupTwoCoordinate.split(",")[1].trim());
			clickBlank();
			selectProduct(groupTwoXCoordinate, groupTwoYCoordinate);
		}
		UtilHBM.waitExplicitClickable(driver, validateButton);
		validateButton.click();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		if(!(groupList.size()==count)){
			UtilHBM.reportKO("Number of OnSameWall constrains is not same after edit. Number of Constraints before this step: "+count +", Number of constraints after this step: " + groupList.size());
		}
		return PageFactory.initElements(driver, Constraints.class);
	}
	
	public Constraints perpendicularToEachOtherRpC(int groupOneXCoordinate,int groupOneYCoordinate,int groupTwoXCoordinate,int groupTwoYCoordinate)
	{
		goToConstraints();
		UtilHBM.reportInfo("Creating Relative placement (Perpendicular to each other) constraint");
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		UtilHBM.waitExplicitClickable(driver, createConstraintButton);
		UtilHBM.turnOffImplicitWaits(driver);
		int count=groupList.size();
		UtilHBM.turnOnImplicitWaits(driver);
		createConstraintButton.click();
		UtilHBM.waitExplicitDisplayed(driver, rpcRadioButton);
		UtilHBM.waitExplicitClickable(driver, rpcRadioButton);
		rpcRadioButton.click();
		UtilHBM.waitFixTime(500);
		oKbutton.click();
		UtilHBM.waitExplicitDisplayed(driver, title2);
		Verification.VerifyEquals("Page title not displayed", title2.getText(), "Relative placement");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle8.getText(), "Select the given-configuration to place groups");
		perpendicularRadioButton.click();
		UtilHBM.waitFixTime(500);
		oKbutton.click();
		UtilHBM.waitExplicitDisplayed(driver, selectFirstGrpPopupMsg);
		UtilHBM.waitExplicitDisplayed(driver, popupMsg1);
		Verification.VerifyEquals("Popup message incorrect", popupMsg1.getText(), popupMsg3ExpectedText);
		UtilHBM.waitFixTime(2000);
		clickBlank();
		selectProduct(groupOneXCoordinate,groupOneYCoordinate);
		nextButton.click();
		UtilHBM.waitExplicitDisplayed(driver, popupMsg1);
		Verification.VerifyEquals("Popup message incorrect", popupMsg1.getText(), popupMsg4ExpectedText);
		UtilHBM.waitFixTime(2000);
		clickBlank();
		selectProduct(groupTwoXCoordinate,groupTwoYCoordinate);
		UtilHBM.waitExplicitClickable(driver, validateButton);
		validateButton.click();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		if(!(groupList.size()>count)){
			UtilHBM.reportKO("Perpendicular To Each Other constraints is not created. Number of Constraints before this step: "+count +", Number of constraints after this step: " + groupList.size());
		}
		UtilHBM.waitExplicitDisplayed(driver, groupList.get(count));
		checkConstraint("RelativePlacement");
		return PageFactory.initElements(driver, Constraints.class);
	}
	
	public Constraints perpendicularToASpecificSideRpC(int groupOneXCoordinate,int groupOneYCoordinate,int groupTwoXCoordinate,int groupTwoYCoordinate)
	{
		UtilHBM.reportInfo("Creating Relative placement constraint (Perpendicular to a specific side)");
		constraintStep.click();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		UtilHBM.waitExplicitClickable(driver, createConstraintButton);
		UtilHBM.turnOffImplicitWaits(driver);
		int count=groupList.size();
		UtilHBM.turnOnImplicitWaits(driver);
		createConstraintButton.click();
		UtilHBM.waitExplicitDisplayed(driver, rpcRadioButton);
		UtilHBM.waitExplicitClickable(driver, rpcRadioButton);
		rpcRadioButton.click();
		UtilHBM.waitFixTime(500);
		oKbutton.click();
		UtilHBM.waitExplicitDisplayed(driver, title2);
		Verification.VerifyEquals("Page title not displayed", title2.getText(), "Relative placement");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle8.getText(), "Select the given-configuration to place groups");
		perpendicularSideRadioButton.click();
		UtilHBM.waitFixTime(500);
		oKbutton.click();
		clickBlank();
		UtilHBM.waitExplicitDisplayed(driver, selectFirstGrpPopupMsg);
		selectProduct(groupOneXCoordinate,groupOneYCoordinate);
		UtilHBM.waitFixTime(1000);
		nextButton.click();
		clickBlank();
		UtilHBM.waitExplicitDisplayed(driver, selectSecondGrpPopupMsg);
		selectProduct(groupTwoXCoordinate,groupTwoYCoordinate);
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitClickable(driver, validateButton);
		validateButton.click();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		if(!(groupList.size()>count)){
			UtilHBM.reportKO("Perpendicular To A Specific Side constraints is not created. Number of Constraints before this step: "+count +", Number of constraints after this step: " + groupList.size());
		}
		UtilHBM.waitExplicitDisplayed(driver, groupList.get(count));
		checkConstraint("RelativePlacement");
		return PageFactory.initElements(driver, Constraints.class);
	}
	
	public Constraints onSameWallRpC(int groupOneXCoordinate,int groupOneYCoordinate,int groupTwoXCoordinate,int groupTwoYCoordinate)
	{
		UtilHBM.reportInfo("Creating Relative placement (Same Wall) constraint");
		constraintStep.click();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		UtilHBM.waitExplicitClickable(driver, createConstraintButton);
		UtilHBM.turnOffImplicitWaits(driver);
		int count=groupList.size();
		UtilHBM.turnOnImplicitWaits(driver);
		createConstraintButton.click();
		UtilHBM.waitExplicitDisplayed(driver, rpcRadioButton);
		UtilHBM.waitExplicitClickable(driver, rpcRadioButton);
		rpcRadioButton.click();
		UtilHBM.waitFixTime(500);
		oKbutton.click();
		UtilHBM.waitExplicitDisplayed(driver, title2);
		Verification.VerifyEquals("Page title not displayed", title2.getText(), "Relative placement");
		Verification.VerifyEquals("Page subtitle not displayed", subtitle8.getText(), "Select the given-configuration to place groups");
		sameWallRadioButton.click();
		UtilHBM.waitFixTime(500);
		oKbutton.click();
		UtilHBM.waitExplicitDisplayed(driver, selectFirstGrpPopupMsg);
		Actions actions=new Actions(driver);
		actions.moveToElement(container3D,321,-330).clickAndHold().pause(500).release().build().perform();
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, selectFirstGrpPopupMsg);
		selectProduct(groupOneXCoordinate,groupOneYCoordinate);
		nextButton.click();
		actions.moveToElement(container3D,321,-330).clickAndHold().pause(500).release().build().perform();
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, selectSecondGrpPopupMsg);
		selectProduct(groupTwoXCoordinate,groupTwoYCoordinate);
		UtilHBM.waitExplicitClickable(driver, validateButton);
		validateButton.click();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		if(!(groupList.size()>count)){
			UtilHBM.reportKO("On Same Wall constraints is not created. Number of Constraints before this step: "+count +", Number of constraints after this step: " + groupList.size());
		}
		UtilHBM.waitExplicitDisplayed(driver, groupList.get(count));
		checkConstraint("RelativePlacement");
		return PageFactory.initElements(driver, Constraints.class);
	}
	
	public Constraints editAlignmentConstraint(int axisXCoordinate,int axisYCoordinate,int margin)
	{
		goToConstraints();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		UtilHBM.turnOffImplicitWaits(driver);
		int count=groupList.size();
		UtilHBM.turnOnImplicitWaits(driver);
		driver.findElement(By.xpath("//ul[@class='group-list']/li/p[contains(text(),'Alignment')]/following-sibling::div/button[@data-ui-action='edit']")).click();
		clickBlank();
		selectProduct(axisXCoordinate,axisYCoordinate);
		clickBlank();
		marginOfError.clear();
		marginOfError.sendKeys(String.valueOf(margin));
		UtilHBM.waitExplicitClickable(driver, validateButton);
		validateButton.click();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		for(int i=0;i<groupList.size();i++)
			if(!(groupList.size()==count)){
				UtilHBM.reportKO("Number of Alignment constrains is not same after edit. Number of Constraints before this step: "+count +", Number of constraints after this step: " + groupList.size());
			}
		checkConstraint("Alignment");
		return PageFactory.initElements(driver, Constraints.class);
	}

	public Constraints alignmentConstraint(int productOneXCoordinate,int productOneYCoordinate,int productTwoXCoordinate,int productTwoYCoordinate, int axisXCoordinate,int axisYCoordinate,int margin)
	{
		UtilHBM.reportInfo("Creating Alignment constraint");
		constraintStep.click();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		UtilHBM.waitExplicitClickable(driver, createConstraintButton);
		UtilHBM.turnOffImplicitWaits(driver);
		int count=groupList.size();
		UtilHBM.turnOnImplicitWaits(driver);
		createConstraintButton.click();
		UtilHBM.waitExplicitDisplayed(driver, alignmentRadioButton);
		UtilHBM.waitExplicitClickable(driver, alignmentRadioButton);
		alignmentRadioButton.click();
		oKbutton.click();
		UtilHBM.waitExplicitDisplayed(driver, selectProductsToAlignPopupMsg);
		Verification.VerifyEquals("Popup message not displayed", popupMsg1.getText(), "Select the two products you want to align. Don't forget the two products must be in two different groups.");
		clickBlank();
		selectProduct(productOneXCoordinate,productOneYCoordinate);
		UtilHBM.waitFixTime(2000);
		clickBlank();
		selectProduct(productTwoXCoordinate,productTwoYCoordinate);
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, nextButton);
		UtilHBM.waitExplicitClickable(driver, nextButton);
		nextButton.click();
		UtilHBM.waitExplicitDisplayed(driver, subtitle2);
		clickBlank();
		selectProduct(axisXCoordinate,axisYCoordinate);
		clickBlank();
		marginOfError.sendKeys(String.valueOf(margin));
		UtilHBM.waitExplicitClickable(driver, validateButton);
		validateButton.click();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		if(!(groupList.size()>count)){
			UtilHBM.reportKO("Alignment constraints is not created. Number of Constraints before this step: "+count +", Number of constraints after this step: " + groupList.size());
		}
		UtilHBM.waitExplicitDisplayed(driver, groupList.get(count));
		checkConstraint("Alignment");
		return PageFactory.initElements(driver, Constraints.class);
	}
	
	public Constraints editDistanceConstraint(int axisXCoordinate,int axisYCoordinate,String dimensions)
	{
		goToConstraints();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		UtilHBM.turnOffImplicitWaits(driver);
		int count=groupList.size();
		UtilHBM.turnOnImplicitWaits(driver);
		driver.findElement(By.xpath("//ul[@class='group-list']/li/p[contains(text(),'Distance')]/following-sibling::div/button[@data-ui-action='edit']")).click();
		selectProduct(axisXCoordinate,axisYCoordinate);
		String a=dimensions;
		if(a.length()!=0)
		{
			goalInput.clear();
			goalInput.sendKeys(dimensions.split("/")[0]);
			minInput.clear();
			minInput.sendKeys(dimensions.split("/")[1]);
			maxInput.clear();
			maxInput.sendKeys(dimensions.split("/")[2]);
		}
		UtilHBM.waitExplicitClickable(driver, validateButton);
		validateButton.click();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		if(!(groupList.size()==count)){
			UtilHBM.reportKO("Number of distance constrains is not same after edit. Number of Constraints before this step: "+count +", Number of constraints after this step: " + groupList.size());
		}
		checkConstraint("Distance");
		return PageFactory.initElements(driver, Constraints.class);
	}
	
	public Constraints distanceConstraint(int productOneXCoordinate,int productOneYCoordinate,int productTwoXCoordinate,int productTwoYCoordinate, int axisXCoordinate,int axisYCoordinate,String dimensions)
	{
		UtilHBM.reportInfo("Creating distance constraint");
		constraintStep.click();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		UtilHBM.waitExplicitClickable(driver, createConstraintButton);
		UtilHBM.turnOffImplicitWaits(driver);
		int count=groupList.size();
		UtilHBM.turnOnImplicitWaits(driver);
		createConstraintButton.click();
		UtilHBM.waitExplicitDisplayed(driver, distanceRadioButton);
		UtilHBM.waitExplicitClickable(driver, distanceRadioButton);
		distanceRadioButton.click();
		oKbutton.click();
		UtilHBM.waitExplicitDisplayed(driver, distanceConstrainPopupMsg);
		clickBlank();
		Verification.VerifyEquals("Popup message not displayed", popupMsg1.getText(), "Select the two products you want to constrain. You will be able to preserve a distance between them. Don't forget the two products must be in two different groups.");
		selectProduct(productOneXCoordinate,productOneYCoordinate);
		UtilHBM.waitFixTime(1000);
		clickBlank();
		selectProduct(productTwoXCoordinate, productTwoYCoordinate);
		UtilHBM.waitFixTime(1000);
		nextButton.click();
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver,subtitle9);
		Verification.VerifyEquals("Distance constraint information not displayed", subtitle9.getText(), subtitle10ExpectedText);
		selectProduct(axisXCoordinate,axisYCoordinate);
		UtilHBM.waitFixTime(1000);
		String a=dimensions;
		if(a.length()!=0)
		{
			goalInput.clear();
			goalInput.sendKeys(dimensions.split("/")[0]);
			minInput.clear();
			minInput.sendKeys(dimensions.split("/")[1]);
			maxInput.clear();
			maxInput.sendKeys(dimensions.split("/")[2]);
		}
		UtilHBM.waitExplicitClickable(driver, validateButton);
		validateButton.click();
		UtilHBM.waitExplicitDisplayed(driver, createConstraintButton);
		if(!(groupList.size()>count)){
			UtilHBM.reportKO("Distance constraints is not created. Number of Constraints before this step: "+count +", Number of constraints after this step: " + groupList.size());
		}
		UtilHBM.waitExplicitDisplayed(driver, groupList.get(count));
		checkConstraint("Distance");
		return PageFactory.initElements(driver, Constraints.class);
	}


	public Constraints deleteConstraint(String constraintName){
		goToConstraints();
		UtilHBM.waitExplicitDisplayed(driver, constraintList);
		int constraintsPresent=constraintList.findElements(By.cssSelector("li")).size();
		UtilHBM.waitExplicitDisplayed(driver, constraintList.findElement(By.xpath(".//p[contains(text(),'" + constraintName + "')]")));

		constraintList.findElement(By.xpath(".//p[contains(text(),'" + constraintName + "')]/parent::li//button[@data-ui-action='delete']")).click();
		Assert.assertEquals( constraintList.findElements(By.cssSelector("li")).size(),constraintsPresent-1);
		return PageFactory.initElements(driver, Constraints.class);
	}


}

