package kitchen.assemblyEditor.pageObject;

import java.util.List;

import hbm.planner.utility.Verification;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;

public class AnchorPoint {
	WebDriver driver;

	public AnchorPoint(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css="#panel-floating-pane>#panel>div>div.content-inner>#position-section>#position-form>p[data-ui-selector='positionX']>span>span>span>input")
	WebElement xPositionInput;
	
	@FindBy(css="#panel-floating-pane>#panel>div>div.content-inner>#position-section>#position-form>p[data-ui-selector='positionY']>span>span>span>input")
	WebElement yPositionInput;
	
	@FindBy(css="#panel-floating-pane>#panel>div>div.content-inner>#position-section>#position-form>p[data-ui-selector='positionZ']>span>span>span>input")
	WebElement zPositionInput;
	
	@FindBy(css="#panel-floating-pane>#panel>div>div.content-inner>#orientation-section>#orientation-form>p[data-ui-selector='dirYX']>span>span>span>input")
	WebElement yxOrientationInput;
	
	@FindBy(css="#panel-floating-pane>#panel>div>div.content-inner>#orientation-section>#orientation-form>p[data-ui-selector='dirYY']>span>span>span>input")
	WebElement yyOrientationInput;
	
	@FindBy(css="#panel-floating-pane>#panel>div>div.content-inner>#orientation-section>#orientation-form>p[data-ui-selector='dirYZ']>span>span>span>input")
	WebElement yzOrientationInput;
	
	@FindBy(css="#panel-floating-pane>#panel>div>div.content-inner>#orientation-section>#orientation-form>p[data-ui-selector='dirZX']>span>span>span>input")
	WebElement zxOrientationInput;
	
	@FindBy(css="#panel-floating-pane>#panel>div>div.content-inner>#orientation-section>#orientation-form>p[data-ui-selector='dirZY']>span>span>span>input")
	WebElement zyOrientationInput;

	@FindBy(css = "#panel-floating-pane>#panel>div>div.content-inner>#orientation-section>#orientation-form>p[data-ui-selector='dirZZ']>span>span>span>input")
	WebElement zzOrientationInput;

	@FindBy(css = "#panel-floating-pane>#panel>div>div.content-inner>#available-space-section>#available-space-form>p[data-ui-selector='availableSpaceX']>span>span>span>input")
	WebElement xAvailableSpace;

	@FindBy(css = "#panel-floating-pane>#panel>div>div.content-inner>#available-space-section>#available-space-form>p[data-ui-selector='availableSpaceY']>span>span>span>input")
	WebElement yAvailableSpace;

	@FindBy(css = "#panel-floating-pane>#panel>div>div.content-inner>#available-space-section>#available-space-form>p[data-ui-selector='availableSpaceZ']>span>span>span>input")
	WebElement zAvailableSpace;

	@FindBy(css="button[title='Close']")
	WebElement closeButton;
	
	@FindBy(css="button[id=add-receive]")
	WebElement addReceiveTagButton;
	
	@FindBy(css="#input-tags")
	List<WebElement> tagInput;
	
	@FindBy(css="#position-section>span[aria-expanded='true']")
	WebElement positionExpand;
	
	@FindBy(css="#position-section>span[aria-expanded='false']")
	List<WebElement> positionCollapse;
	
	@FindBy(css="#orientation-section>span[aria-expanded='false']")
	List<WebElement> orientationCollapse;
	
	@FindBy(css="#orientation-section>span[aria-expanded='true']")
	WebElement orientationExpand;
	
	@FindBy(css="#receive-tags-section>span[aria-expanded='false']")
	List<WebElement> receiveTagCollapse;
	
	@FindBy(css="#receive-tags-section>span[aria-expanded='true']")
	WebElement receiveTagExpand;

	@FindBy(css="section#available-space-section>span[aria-controls='section']")
	WebElement availableSpaceSection;
	
	@FindBy(css="span.mod-tag-input.receive-tags-tags-container>input")
	List<WebElement> receiveTagNameInput;
	
	public AnchorPoint expandPosition()
	{
		UtilHBM.waitFixTime(1000);
		positionExpand.click();
		return PageFactory.initElements(driver, AnchorPoint.class);
	}
	
	public AnchorPoint collapsePosition()
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(positionCollapse.size()>0){
			UtilHBM.waitExplicitClickable(driver, positionCollapse.get(0));
			positionCollapse.get(0).click();
		}			
		UtilHBM.turnOnImplicitWaits(driver);
		return PageFactory.initElements(driver, AnchorPoint.class);
	}
	
	public AnchorPoint expandOrientation()
	{
		orientationExpand.click();
		return PageFactory.initElements(driver, AnchorPoint.class);
	}
	public AnchorPoint collapseOrientation()
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(orientationCollapse.size()>0)
			orientationCollapse.get(orientationCollapse.size()-1).click();

		UtilHBM.turnOnImplicitWaits(driver);
		return PageFactory.initElements(driver, AnchorPoint.class);
	}
	public AnchorPoint expandReceiveTag()
	{
		receiveTagExpand.click();
		return PageFactory.initElements(driver, AnchorPoint.class);
	}
	public AnchorPoint collapseReceiveTag()
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(receiveTagCollapse.size()>0){
			UtilHBM.waitExplicitClickable(driver, receiveTagCollapse.get(0));
			receiveTagCollapse.get(receiveTagCollapse.size()-1).click();
		}
			

		UtilHBM.turnOnImplicitWaits(driver);
		return PageFactory.initElements(driver, AnchorPoint.class);
	}
	
	public AnchorPoint setXPosition(int x)
	{
			
		UtilHBM.waitFixTime(1000);
		xPositionInput.click();
		UtilHBM.waitFixTime(1000);
		xPositionInput.clear();
		xPositionInput.sendKeys(String.valueOf(x)+Keys.ENTER);
		
		return PageFactory.initElements(driver, AnchorPoint.class);
	}
	
	public AnchorPoint setYPosition(int y)
	{
		UtilHBM.waitFixTime(1000);
		yPositionInput.click();
		UtilHBM.waitFixTime(1000);
		yPositionInput.clear();
		yPositionInput.sendKeys(String.valueOf(y)+Keys.ENTER);
		return PageFactory.initElements(driver, AnchorPoint.class);
	}
	
	public AnchorPoint setZPosition(int z)
	{
		UtilHBM.waitFixTime(1000);
		zPositionInput.click();
		UtilHBM.waitFixTime(1000);
		zPositionInput.clear();
		zPositionInput.sendKeys(String.valueOf(z)+Keys.ENTER);
		return PageFactory.initElements(driver, AnchorPoint.class);
	}
	
	AnchorPoint setYXOrientation(int yx){
		yxOrientationInput.clear();
		yxOrientationInput.sendKeys(String.valueOf(yx)+Keys.ENTER);
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, AnchorPoint.class);
	}
	
	AnchorPoint setYYOrientation(int yy){
		yyOrientationInput.clear();
		yyOrientationInput.sendKeys(String.valueOf(yy)+Keys.ENTER);
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, AnchorPoint.class);
	}
	
	AnchorPoint setYZOrientation(int yz){
		yzOrientationInput.clear();
		yzOrientationInput.sendKeys(String.valueOf(yz)+Keys.ENTER);
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, AnchorPoint.class);
	}
	
	AnchorPoint setZXOrientation(int zx){
		zxOrientationInput.clear();
		zxOrientationInput.sendKeys(String.valueOf(zx)+Keys.ENTER);
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, AnchorPoint.class);
	}
	
	AnchorPoint setZYOrientation(int zy){	
		zyOrientationInput.clear();
		zyOrientationInput.sendKeys(String.valueOf(zy)+Keys.ENTER);
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, AnchorPoint.class);
	}
	
	AnchorPoint setZZOrientation(int zz){	
		zzOrientationInput.clear();
		zzOrientationInput.sendKeys(String.valueOf(zz)+Keys.ENTER);
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, AnchorPoint.class);
	}
	
	public AssemblyEditor setAnchorPointParameters(String parameters)
	{		
		UtilHBM.waitFixTime(1000);
		setXPosition(Integer.parseInt(parameters.split(",")[0].split("/")[0]));
		setYPosition(Integer.parseInt(parameters.split(",")[0].split("/")[1]));
		setZPosition(Integer.parseInt(parameters.split(",")[0].split("/")[2]));
		if(!parameters.split(",")[1].split("/")[0].equalsIgnoreCase("null"))
		{
			setYXOrientation(Integer.parseInt(parameters.split(",")[1].split("/")[0]));
		}
		else if(!parameters.split(",")[1].split("/")[1].equalsIgnoreCase("null"))
		{
			setYYOrientation(Integer.parseInt(parameters.split(",")[1].split("/")[1]));
		}
		else if(!parameters.split(",")[1].split("/")[2].equalsIgnoreCase("null"))
		{
			setYZOrientation(Integer.parseInt(parameters.split(",")[1].split("/")[2]));
		}
		else if(!parameters.split(",")[1].split("/")[3].equalsIgnoreCase("null"))
		{
			setZXOrientation(Integer.parseInt(parameters.split(",")[1].split("/")[3]));
		}
		else if(!parameters.split(",")[1].split("/")[4].equalsIgnoreCase("null"))
		{
			setZYOrientation(Integer.parseInt(parameters.split(",")[1].split("/")[4]));
		}
		else if(!parameters.split(",")[1].split("/")[5].equalsIgnoreCase("null"))
		{
			setZZOrientation(Integer.parseInt(parameters.split(",")[1].split("/")[5]));
		}
		clickClose();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	AnchorPoint addReceiveTag(String tagName)
	{
		clickAddReceiveTag();
		UtilHBM.waitExplicitDisplayed(driver, receiveTagNameInput.get(receiveTagNameInput.size()-1));
		receiveTagNameInput.get(receiveTagNameInput.size()-1).sendKeys(tagName);
		receiveTagExpand.click();
		
		return PageFactory.initElements(driver, AnchorPoint.class);
	}
	
	AnchorPoint clickAddReceiveTag()
	{
		UtilHBM.waitFixTime(1000);
		UtilHBM.scrollToElementWithOffset(driver, addReceiveTagButton, 10);
		addReceiveTagButton.click();
		UtilHBM.waitFixTime(1000);
//		while(tagInput.size()==0)
//		{
//			addReceiveTagButton.click();
//		}
		
		return PageFactory.initElements(driver, AnchorPoint.class);
	}
	
	AssemblyEditor clickClose()
	{
		closeButton.click();
		UtilHBM.waitTillElementDisappear(driver, "button[title='Close']");
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	public AnchorPoint setAvailableSpace_X(int x)
	{

		UtilHBM.waitFixTime(1000);
		expandAvailableSpaceSection();
		xAvailableSpace.click();
		UtilHBM.waitFixTime(1000);
		xAvailableSpace.clear();
		xAvailableSpace.sendKeys(String.valueOf(x)+Keys.ENTER);
		UtilHBM.waitFixTime(1000);

		return PageFactory.initElements(driver, AnchorPoint.class);
	}

	public AnchorPoint setAvailableSpace_Y(int y)
	{

		UtilHBM.waitFixTime(1000);
		expandAvailableSpaceSection();
		yAvailableSpace.click();
		UtilHBM.waitFixTime(1000);
		yAvailableSpace.clear();
		yAvailableSpace.sendKeys(String.valueOf(y)+Keys.ENTER);
		UtilHBM.waitFixTime(1000);

		return PageFactory.initElements(driver, AnchorPoint.class);
	}

	public AnchorPoint setAvailableSpace_Z(int z)
	{

		UtilHBM.waitFixTime(1000);
		expandAvailableSpaceSection();
		zAvailableSpace.click();
		UtilHBM.waitFixTime(1000);
		zAvailableSpace.clear();
		zAvailableSpace.sendKeys(String.valueOf(z)+Keys.ENTER);
		UtilHBM.waitFixTime(1000);

		return PageFactory.initElements(driver, AnchorPoint.class);
	}

	public AnchorPoint collapseAvailableSpaceSection()
	{
		UtilHBM.waitFixTime(1000);
		if(availableSpaceSection.getAttribute("aria-expanded").equalsIgnoreCase("true"))
			availableSpaceSection.click();
		Verification.VerifyEquals("Available space section couldn't be collapsed", availableSpaceSection.getAttribute("aria-expanded"), "false");
		UtilHBM.waitFixTime(1000);

		return PageFactory.initElements(driver, AnchorPoint.class);
	}

	public AnchorPoint expandAvailableSpaceSection()
	{
		UtilHBM.waitFixTime(1000);
		if(availableSpaceSection.getAttribute("aria-expanded").equalsIgnoreCase("false"))
			availableSpaceSection.click();
		Verification.VerifyEquals("Available space section couldn't be expanded", availableSpaceSection.getAttribute("aria-expanded"), "true");
		UtilHBM.waitFixTime(1000);

		return PageFactory.initElements(driver, AnchorPoint.class);
	}

	public AnchorPoint verifyAvailableSpaceValues(int xVal, int yVal, int zVal) {
		UtilHBM.waitFixTime(1000);
		Verification.VerifyEquals("Verification for Available space_X fail", xAvailableSpace.getAttribute("value"), Integer.toString(xVal));
		Verification.VerifyEquals("Verification for Available space_Y fail", yAvailableSpace.getAttribute("value"), Integer.toString(yVal));
		Verification.VerifyEquals("Verification for Available space_Z fail", zAvailableSpace.getAttribute("value"), Integer.toString(zVal));
		return PageFactory.initElements(driver, AnchorPoint.class);
	}
}
