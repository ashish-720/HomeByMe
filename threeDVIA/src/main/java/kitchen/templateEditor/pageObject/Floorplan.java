package kitchen.templateEditor.pageObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class Floorplan {
	WebDriver driver;
	
	public Floorplan(WebDriver driver) {
		this.driver=driver;	
	}
	@FindBy(css="button[data-state='design']")
	WebElement designButton;
		
	@FindBy(css="#main-app>header>div>div.inner>nav>ul>li>button[data-state='floorplan']")
	WebElement title1;
	
	@FindBy(css="#objects>span")
	WebElement roomObjectsLabel;
	
	@FindBy(css="#openings>span")
	WebElement openingLabel;
	
	@FindBy(css="#covering>span")
	WebElement coveringLabel;
	
	@FindBy(css="#sketcher-toolbox-tools>li>button>span")
	WebElement drawPlanLabel;
	
	@FindBy(css="label[for='ceiling-height']")
	WebElement ceilingHtLabel;
	
	@FindBy(css="#embedded-app-frame")
	WebElement frame1;

	@FindBy(css="button[title='Close']")
	WebElement closeButton;
	
	@FindBy(css="div[class*='room Tag3D']>input")
	WebElement roomName;
	
	@FindBy(css="#canvas-wrap-1>input:nth-child(6)")
	WebElement roomLengthInput;
	
	@FindBy(css="#canvas-wrap-1>input:nth-child(8)")
	WebElement roomWidthInput;
	
	@FindBy(css="main>div>#topbar>div>div>ul>li")
	WebElement menuOptions;
	
	@FindBy(css="#bt-icon-view-3d")
	WebElement threeDViewButton;
	
	@FindBy(css="#bmSVG")
	WebElement container3D;
	
	@FindBy(css="article#sketcher-mod-properties-window-regular")
	WebElement productDescriptionBox;
	
	@FindBy(css="div[id*='measurevalueDiv'] input")
	List<WebElement> measureInput;
	
	@FindBy(css="button[title='Position']")
	WebElement positionButton;
	
	@FindBy(css="button[title='Edit']")
	WebElement editButton;
	
	@FindBy(css="#product-width")
	WebElement widthInput;
	
	@FindBy(css="#sketcher-edit-panel")
	WebElement editPanel;
	
	@FindBy(css="#product-height")
	WebElement heightInput;
	
	@FindBy(css="#height")
	WebElement ceilingHeightInputInEditPanel;
	
	@FindBy(css="#product-depth")
	WebElement depthInput;
	
	@FindBy(css="#product-height-from-floor")
	WebElement heightFromFloorInput;
	
	@FindBy(css="button[title='Delete']")
	WebElement deleteButton;

	@FindBy(css="button[title='Duplicate']")
	WebElement duplicateButton;
	
	@FindBy(css="#ceiling-height")
	WebElement ceilingHeightInput;
	
	@FindBy(css="#draw-plan")
	WebElement drawPlanButton;
	
	@FindBy(css="#nav-overlay-draw-plan>div>ul>li>ul>li[data-ui-subsubcat='add-sloped-walls']>button")
	WebElement manageSlopedWallsButton;
	
	@FindBy(css = ".Wall2DMeasure.Tag3D")
	WebElement wall2DMeasure;

	@FindBy(css = ".Tag3DMeasure2D>input")
	WebElement wall2DMeasureInputBox;
	
	@FindBy(xpath = "//button[contains(text(),'apply above')]")
	WebElement applyAbove;

	@FindBy(xpath = "//button[contains(text(),'apply below')]")
	WebElement applyBelow;

	@FindBy(xpath = "//button[contains(text(),'apply left')]")
	WebElement applyLeft;

	@FindBy(xpath = "//button[contains(text(),'apply right')]")
	WebElement applyRight;
	
	@FindBy(css="button[data-ui-action='panel-close']")
	WebElement coveringPalletCloseButton;
	
	@FindBy(xpath="//button[@title='Open']/parent::li/input")
	WebElement reopenButton;

	@FindBy(css="#project-title")
	WebElement projectNameText;
	
	public Floorplan applyCoveringUsingWall(int xCoordinate,int yCoordinate,String coveringName,String uid,String applyType)
	{
		goToThreeDView();
		Actions actions=new Actions(driver);
		actions.moveToElement(container3D,xCoordinate,yCoordinate).clickAndHold().pause(500).release().build().perform();
		Catalog catalog=PageFactory.initElements(driver, Catalog.class);
		catalog.selectCovering(coveringName, uid);
		if(applyType.contentEquals("Apply"))
		{
			UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("li[data-ui-id='"+uid+"']>article>div>p>button.cta-primary")));
			driver.findElement(By.cssSelector("li[data-ui-id='"+uid+"']>article>div>p>button.cta-primary")).click();
			actions.moveToElement(container3D,xCoordinate,yCoordinate).clickAndHold().pause(500).release().build().perform();
		}
		else
		{
			driver.findElement(By.cssSelector("li[data-ui-id='"+uid+"']>article>div>p>button.cta-secondary")).click();
		}
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
	public Floorplan applyCovering(String coveringName,String applyType,String uid,int xCoordinate,int yCoordinate)
	{ 
		addProduct(coveringName, uid);
		if(applyType.contentEquals("Apply"))
		{
			driver.findElement(By.cssSelector("li[data-ui-id='"+uid+"']>article")).click();
			driver.findElement(By.cssSelector("li[data-ui-id='"+uid+"']>article>div>p>button.cta-primary")).click();
			Actions actions=new Actions(driver);
			actions.moveToElement(container3D,xCoordinate,yCoordinate).clickAndHold().pause(500).release().build().perform();
		}
		else
		{
			driver.findElement(By.cssSelector("li[data-ui-id='"+uid+"']>article>div>p>button.cta-secondary")).click();
		}
		coveringPalletCloseButton.click();
		clickBlank();
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
	public Floorplan verifySlopedCeiling(int xCoordinate,int yCoordinate,int height,String measureToEdit,int value)
	{
		drawPlanButton.click();
		clickManageSlopedWallButton()
		.verifySlopedCeiling(xCoordinate, yCoordinate, height, measureToEdit, value);
		
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
	
	public Floorplan sloppedCeiling(int xCoordinate,int yCoordinate,int height,String measureToEdit,int value)
	{
		drawPlanButton.click();
		clickManageSlopedWallButton()
		.addSloppedCeiling(xCoordinate,yCoordinate, height, measureToEdit, value);
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
	AddSlopedCeiling clickManageSlopedWallButton()
	{
		manageSlopedWallsButton.click();
		return PageFactory.initElements(driver, AddSlopedCeiling.class);
	}
	
	public Floorplan verifyCeilingHeight(int xCoordinate,int yCoordinate,int ceilingHeight)
	{
		selectProduct(xCoordinate, yCoordinate);
		editButton.click();
		if(ceilingHeightInputInEditPanel.getAttribute("value").contains(String.valueOf(ceilingHeight)))
		{
			UtilHBM.reportOK("Ceiling height "+ceilingHeightInputInEditPanel.getAttribute("value")+" verified");
		}
		else
		{
			UtilHBM.reportKO("Ceiling height incorrect");
		}
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
	public Floorplan changeCeilingHeight(int ceilingHeight)
	{
		ceilingHeightInput.click();
		ceilingHeightInput.sendKeys(Keys.CONTROL+"a");
		ceilingHeightInput.sendKeys(String.valueOf(ceilingHeight));
		ceilingHeightInput.sendKeys(Keys.RETURN);
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
	public Floorplan editBayPositionOpening(int xCoordinate,int yCoordinate,int initialMeasure,int finalMeasure)
	{
		for(WebElement targetElement:measureInput)
		{
			if(Integer.parseInt(targetElement.getAttribute("value").split(" ")[0])==initialMeasure)
			{
				targetElement.click();
				targetElement.sendKeys(Keys.CONTROL+"a");
				targetElement.sendKeys(String.valueOf(finalMeasure));
				targetElement.sendKeys(Keys.RETURN);
				break;
			}
			
		}
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
	public Floorplan editOpening(int xCoordinate,int yCoordinate,int width,int height)
	{
		selectProduct(xCoordinate, yCoordinate);
		editButton.click();
		UtilHBM.waitExplicitDisplayed(driver, editPanel);
		if(!widthInput.getAttribute("value").contains(String.valueOf(width)))
		{
			widthInput.sendKeys(Keys.CONTROL+"a");
			widthInput.sendKeys(String.valueOf(width));
			widthInput.sendKeys(Keys.RETURN);
		}
		if(!heightInput.getAttribute("value").contains(String.valueOf(height)))
		{
			heightInput.sendKeys(Keys.CONTROL+"a");
			heightInput.sendKeys(String.valueOf(height));
			heightInput.sendKeys(Keys.RETURN);
		}
		clickBlank();
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
	
	public Floorplan editOpening(int xCoordinate,int yCoordinate,int width,int height,int heightFromFloor)
	{
		selectProduct(xCoordinate, yCoordinate);
		editButton.click();
		UtilHBM.waitExplicitDisplayed(driver, editPanel);
		if(!widthInput.getAttribute("value").contains(String.valueOf(width)))
		{
			widthInput.sendKeys(Keys.CONTROL+"a");
			widthInput.sendKeys(String.valueOf(width));
			widthInput.sendKeys(Keys.RETURN);
		}
		if(!heightInput.getAttribute("value").contains(String.valueOf(height)))
		{
			heightInput.sendKeys(Keys.CONTROL+"a");
			heightInput.sendKeys(String.valueOf(height));
			heightInput.sendKeys(Keys.RETURN);
		}
		if(!heightFromFloorInput.getAttribute("value").contains(String.valueOf(heightFromFloor)))
		{
			heightFromFloorInput.sendKeys(Keys.CONTROL+"a");
			heightFromFloorInput.sendKeys(String.valueOf(heightFromFloor));
			heightFromFloorInput.sendKeys(Keys.RETURN);
		}
		clickBlank();
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
	public Floorplan duplicateProduct(int xCoordinate,int yCoordinate,int dupXCoordinate,int dupYCoordinate)
	{
		selectProduct(xCoordinate, yCoordinate);
		duplicateButton.click();
		clickBlank();
		selectProduct(dupXCoordinate, dupYCoordinate);
		if(productDescriptionBox.isDisplayed())
		{
			UtilHBM.reportOK("Duplicate successful");
		}
		return PageFactory.initElements(driver, Floorplan.class);
	}

	public Floorplan deleteProduct(int xCoordinate, int yCoordinate) {
		selectProduct(xCoordinate, yCoordinate);
		UtilHBM.waitExplicitDisplayed(driver, deleteButton);
		UtilHBM.waitExplicitClickable(driver, deleteButton);
		deleteButton.click();
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
	
	
	public Floorplan changeDimensions(int xCoordinate,int yCoordinate,int width,int height,int depth)
	{
		selectProduct(xCoordinate, yCoordinate);
		editButton.click();
		UtilHBM.waitExplicitDisplayed(driver, editPanel);
		if(!widthInput.getAttribute("value").contains(String.valueOf(width)))
		{
			widthInput.sendKeys(Keys.CONTROL+"a");
			widthInput.sendKeys(String.valueOf(width));
			widthInput.sendKeys(Keys.RETURN);
		}
		if(!heightInput.getAttribute("value").contains(String.valueOf(height)))
		{
			heightInput.sendKeys(Keys.CONTROL+"a");
			heightInput.sendKeys(String.valueOf(height));
			heightInput.sendKeys(Keys.RETURN);
		}
		if(!depthInput.getAttribute("value").contains(String.valueOf(depth)))
		{
			depthInput.sendKeys(Keys.CONTROL+"a");
			depthInput.sendKeys(String.valueOf(depth));
			depthInput.sendKeys(Keys.RETURN);
		}
		clickBlank();
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
	Floorplan clickBlank() 
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(container3D,321,-330).clickAndHold().pause(500).release().build().perform();
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
	Floorplan selectProduct(int xcoordinate,int ycoordinate)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(container3D,xcoordinate,ycoordinate).clickAndHold().pause(500).release().build().perform();
		UtilHBM.waitExplicitDisplayed(driver, productDescriptionBox);
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
	
	Floorplan changeMeasure(int initialMeasure,int finalMeasure)
	{		
		for(WebElement targetElement:measureInput)
		{
			if(Integer.parseInt(targetElement.getAttribute("value").split(" ")[0])==initialMeasure)
			{
				targetElement.click();
				targetElement.sendKeys(Keys.CONTROL+"a");
				targetElement.sendKeys(String.valueOf(finalMeasure));
				targetElement.sendKeys(Keys.RETURN);
				break;
			}
			
		}
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
	public Floorplan positionObject(int xCoordinate,int yCoordinate,int initialMeasure,int finalMeasure)
	{
		selectProduct(xCoordinate, yCoordinate);
		UtilHBM.waitFixTime(2000);
		positionButton.click();
		changeMeasure(initialMeasure, finalMeasure);
		clickBlank();
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
	public Design goToDesignPage()
	{
		designButton.click();
		UtilHBM.waitExplicitDisplayed(driver, container3D);
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "#cabinets"));
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, Design.class);
	}
	
	public Floorplan goToThreeDView()
	{
		threeDViewButton.click();
		UtilHBM.waitFixTime(3000);
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
	public Floorplan closeOperation()
	{
		closeButton.click();
		UtilHBM.reportOK("Close button clicked");
		return this;
	}
	
	public Floorplan addProduct(String productName)
	{
		String catagory=UtilHBM.getKeyValue(Setting.testDatapath + "templateEditorFloorplan.data").get(productName).split(",")[1].split(":")[0];
		UtilHBM.waitExplicitDisplayed(driver, menuOptions.findElement(By.xpath("//button[@id='"+catagory+"']")));
		UtilHBM.waitFixTime(3000);
		menuOptions.findElement(By.xpath("//button[@id='"+catagory+"']")).click();
		String subCatagory=UtilHBM.getKeyValue(Setting.testDatapath + "templateEditorFloorplan.data").get(productName).split(",")[1].split(":")[1].split(">")[0];		
		String productToBeAdded=UtilHBM.getKeyValue(Setting.testDatapath + "templateEditorFloorplan.data").get(productName).split(",")[1].split(":")[1].split(">")[1];
		WebElement subCat=driver.findElement(By.xpath("//ul/li/ul[@data-ui-subcat='"+subCatagory+"']/li[@data-ui-subsubcat='"+productToBeAdded+"']"));
		UtilHBM.waitExplicitDisplayed(driver, subCat);
		UtilHBM.waitExplicitClickable(driver, subCat);
		subCat.click();
		Catalog catalog=PageFactory.initElements(driver, Catalog.class);
		catalog.selectProduct(productName, true);
		UtilHBM.waitFixTime(5000);
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
	public Floorplan addProduct(String productName,String uid)
	{
		ArrayList<String> productsWithSameName = new ArrayList<String>();
		try {
			BufferedReader br = null;
			String currentLine;
			br = new BufferedReader(new FileReader(Setting.testDatapath + "templateEditorFloorplan.data"));		
			while ((currentLine = br.readLine())!= null)
			{
				if(currentLine.split(";")[0].contentEquals(productName))
				{
					productsWithSameName.add(currentLine);
				}
			}
			System.out.println(productsWithSameName);
			for(int i=0;i<productsWithSameName.size();i++)
			{
				System.out.println(productsWithSameName.get(i).split(";")[1].split(",")[0]);
				if(productsWithSameName.get(i).split(";")[1].split(",")[0].contentEquals(uid))
				{
					System.out.println(productsWithSameName.get(i).split(";")[1].split(",")[0]);
					menuOptions.findElement(By.xpath("//button[@id='"+productsWithSameName.get(i).split(",")[1].split(">")[0].split(":")[0]+"']")).click();
					WebElement subCat=driver.findElement(By.xpath("//ul/li/ul/li/button[contains(text(),'"+productsWithSameName.get(i).split(",")[1].split(">")[1]+"')]"));
					subCat.click();
					break;
				}
			}
			
			Catalog catalog=PageFactory.initElements(driver, Catalog.class);
			catalog.selectCovering(productName, uid);
			UtilHBM.waitFixTime(5000);
			br.close();
		}catch (Exception e) {			
			e.printStackTrace();
		}	
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
	public Design reopenProject(String projectName)
	{
		reopenButton.sendKeys(new File(Setting.screenCapturePath+"/"+projectName+".BMTPROJ").getAbsolutePath());
		UtilHBM.waitFixTime(5000);
		Verification.VerifyEquals("Incorrect project name", projectNameText.getText(), projectName);
		return PageFactory.initElements(driver, Design.class);
	}
	
	public Floorplan verifyFloorplan()
	{
//		UtilHBM.waitFixTime(1000);
//		driver.switchTo().frame(frame1);
		UtilHBM.waitExplicitDisplayed(driver, roomName);
		Verification.VerifyEquals("Page title not displayed", title1.getText(), "Floorplan");
		Verification.VerifyEquals("Page title not displayed", designButton.getText(), "Design");
		Verification.VerifyEquals("Page subtitle not displayed", roomObjectsLabel.getText(), "Room objects");
		Verification.VerifyEquals("Page subtitle not displayed", openingLabel.getText(), "Openings");
		Verification.VerifyEquals("Page subtitle not displayed", coveringLabel.getText(),"Paint & flooring");
		Verification.VerifyEquals("Page subtitle not displayed", drawPlanLabel.getText(), "Draw plan");
		Verification.VerifyEquals("Page subtitle not displayed", ceilingHtLabel.getText(), "Ceiling height");
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
	public Floorplan changeRoomLength(int length)
	{
		roomLengthInput.click();
		UtilHBM.waitFixTime(3000);
//		frontValue.sendKeys(Keys.CONTROL+"a");
//		frontValue.sendKeys(values.split(";")[0]);
		roomLengthInput.sendKeys(String.valueOf(length)+Keys.ENTER);
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
	public Floorplan changeRoomWidth(int width)
	{
		roomWidthInput.click();
//		roomWidthInput.clear();
		roomWidthInput.sendKeys(String.valueOf(width)+Keys.ENTER);
		return PageFactory.initElements(driver, Floorplan.class);
	}
	
}
