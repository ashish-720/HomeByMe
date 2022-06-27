package kitchen.assemblyEditor.pageObject;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import java.nio.file.Files;

import com.google.common.collect.Iterables;
import hbm.planner.utility.Browser;
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
import kitchen.templateEditor.pageObject.Design;
import org.testng.Assert;

public class AssemblyEditor {
	WebDriver driver;

	public AssemblyEditor(WebDriver driver) {
		this.driver=driver;	
	}

	@FindBy(css="#parameter-section>ul>li>button")
	WebElement addNewParameterButton;

	@FindBy(css="div>ul>li[id='parameter-section']>ul>li>span")
	List<WebElement> parameterList;

	@FindBy(css="div>ul>li[id='parameter-section']>ul>li>span[class='selected']")
	WebElement selectedParameter;

	@FindBy(xpath="//div/ul/li[@id='parameter-section']/ul/li/span[contains(text(),'NewParameter0')]")
	WebElement newParameter;

	@FindBy(xpath="//div/ul/li[@id='relation-section']/ul/li/span[contains(text(),'NewRelation0')]")
	WebElement newRelation;

	@FindBy(css="#application>main>div>div>#left-panel>div>div>#sections-list>#component-section>ul>li>button")
	WebElement addNewComponentButton;

	@FindBy(xpath="//*[@id='component-section']/ul/li/span")
	List<WebElement> componentList;

	@FindBy(css="#relation-section>ul>li>button")
	WebElement addNewRelationButton;

	@FindBy(css="#outputset-section>ul>li>button[data-ui-action='polyLineSetAdd']")
	WebElement addPolyLineSetButton;

	@FindBy(css="#outputset-section>ul>li>button[data-ui-action='edgeLineSetAdd']")
	WebElement addEdgeLineSetButton;

	@FindBy(xpath="//*[@id='outputset-section']/ul/li/span")
	List<WebElement> outputsetList;

	@FindBy(css="#parameter-section>span[aria-expanded='true']")
	WebElement parameterExpand;

	@FindBy(css="#component-section>span[aria-expanded='true']")
	WebElement componentExpand;
	
	@FindBy(css="#parameter-section>span[aria-expanded='false']")
	List<WebElement> parameterCollapse;
	
	@FindBy(css="#component-section>span[aria-expanded='false']")
	List<WebElement> componentCollapse;
	
	@FindBy(css="#animation-section>span[aria-expanded='false']")
	List<WebElement> translationCollapse;
	
	@FindBy(css="#outputset-section>span[aria-expanded='false']")
	List<WebElement> outputsetCollapse;
	
	@FindBy(css="#outputset-section>span[aria-expanded='true']")
	WebElement outputsetExpand;
	
	@FindBy(css="#animation-section>span[aria-expanded='true']")
	WebElement translationExpand;
	
	@FindBy(css="#relation-section>span[aria-expanded='false']")
	List<WebElement> relationCollapse;

	@FindBy(css="#relation-section>span[aria-expanded='true']")
	WebElement relationExpand;

	@FindBy(css="#relation-section>ul>li>span")
	List<WebElement> relationList;

	@FindBy(css="button[title='Save my work']")
	WebElement saveButton;

	@FindBy(css="#position-section>span[aria-expanded]")
	WebElement positionExpand;

	@FindBy(css="#orientation-section>span[aria-expanded]")
	WebElement orientationExpand;

	@FindBy(css="#bmSVG")
	WebElement container3D;

	@FindBy(css="body>#application>main>div>div>article>div>div>#sections-list>#parameter-section>span")
	WebElement header1;

	@FindBy(css="body>#application>main>div>div>article>div>div>#sections-list>#parameter-section>#relation-section>span")
	WebElement header2;

	@FindBy(css="body>#application>main>div>div>article>div>div>#sections-list>#parameter-section>#component-section>span")
	WebElement header3;

	@FindBy(css="body>#application>main>div>div>article>div>div>#sections-list>#parameter-section>#animation-section>span")
	WebElement header4;

	@FindBy(css="body>#application>main>div>div>article>div>div>#sections-list>#parameter-section>#outputset-section>span")
	WebElement header5;

	@FindBy(css="body>#application>main>div>div>article>div>div>#sections-list>#parameter-section>#anchor-section>span")
	WebElement header6;

	@FindBy(css="div.canvas-central-actions>p")
	WebElement desc1;

	@FindBy(css="button[title='Open from disk']")
	WebElement inputProject;

	@FindBy(css="button[data-ui-action='translationAdd']")
	WebElement addTranslationButton;

	@FindBy(css="button[data-ui-action='rotationAdd']")
	WebElement addRotatonButton;


	@FindBy(css="#panel")
	List<WebElement> animationPanel;

	@FindBy(css="li[data-type='outputset']>ul.nav-subitem>li>button[data-ui-action='polyLineAdd']")
	WebElement addPolyLineButton;

	@FindBy(css="li[data-type='outputset']>ul>li>ul>li>button[data-ui-action='polyLinePointAdd']")
	WebElement addPolyLinePointButton;

	@FindBy(css="li[data-type='point']")
	List<WebElement> point;

	@FindBy(css="#anchor-section>ul.nav-item>li>button[data-ui-action='add']")
	WebElement addAnchorPointButton;

	@FindBy(css="#position-section>span[aria-expanded='false']")
	List<WebElement> positionCollapse;

	@FindBy(css="#panel-floating-pane")
	WebElement componentPanel;

	@FindBy(css="section#overload-section>span")
	WebElement overloadSection;

	@FindBy(css="section#overload-section>form#overload-form")
	WebElement overloadForm;

	AssemblyEditor unzip(String zipFilePath, String destDir) throws IOException
	{
		FileInputStream fis;
		byte[] buffer = new byte[1024];
		try {
			fis = new FileInputStream(zipFilePath);
			ZipInputStream zis = new ZipInputStream(fis);
			ZipEntry ze = zis.getNextEntry();
			while(ze != null){
				String fileName = ze.getName();
				File newFile = new File(destDir + File.separator + fileName);
				new File(newFile.getParent()).mkdirs();
				FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
				zis.closeEntry();
				ze = zis.getNextEntry();
			}
			zis.closeEntry();
			zis.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	static List<String> zipFile = new ArrayList<String>();

	static List<String> projectFile = new ArrayList<String>();

	public AssemblyEditor unzipBmaProject(String projectName) throws IOException
	{
		File dir = new File(Setting.screenCapturePath);
		for (File file : dir.listFiles()) 
		{
			if(file.getName().contains((projectName+".ZIP")))
			{
				System.out.println(file.getName());
				zipFile.add(file.getName());
			}
		}
		unzip(new File(Setting.screenCapturePath+"//"+zipFile.get(zipFile.size()-1)).getAbsolutePath(),new File(Setting.screenCapturePath).getAbsolutePath());
		//		Files.delete(Paths.get(Setting.screenCapturePath+"//"+zipFile.get(zipFile.size()-1)));

		File dir1 = new File(Setting.screenCapturePath);
		for (File file : dir1.listFiles()) 
		{
			if(file.getName().contains("root.BMA"))
			{
				projectFile.add(file.getName());
			}
		}
		String a=Setting.screenCapturePath+"//"+projectFile.get(0);
		Files.move(Paths.get(a), Paths.get(a).resolveSibling(projectName+".BMA"));
		String b=Setting.screenCapturePath+projectName+".BMA";
		Path destPath=Paths.get(Setting.threeDCloudData+"//BM3//"+UtilHBM.getDate(0, "ddMMyyyy")+"_"+projectName+".BMA");
		if(destPath.toFile().exists()){
			Files.delete(destPath);
		}
		Files.move(Paths.get(b),destPath);
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}


	static List<String> existingFiles = new ArrayList<String>();

	static public List<String> getExistingFiles() {
		return existingFiles;
	}

	public void setExistingFiles(List<String> existingFiles) {
		Design.existingFiles = existingFiles;
	}


	public AssemblyEditor addNewPolyLine()
	{
		UtilHBM.waitExplicitDisplayed(driver, addPolyLineButton);
		addPolyLineButton.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	
	public AssemblyEditor addNewPolyLine(int outputSetIndex)
	{
		UtilHBM.webElement(driver, "li[data-type='outputset']:nth-child("+outputSetIndex+")>ul.nav-subitem>li>button[data-ui-action='polyLineAdd']").click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	
	public AssemblyEditor addNewEdgeLine(int outputSetIndex)
	{
		UtilHBM.webElement(driver, "li[data-type='outputset']:nth-child("+outputSetIndex+")>ul.nav-subitem>li>button[data-ui-action='polyEdgeLineAdd']").click();
		
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor setEdgeLineDetails(int outputSetIndex,int edgeLineIndex,int startPointXCoordinate,int startPointYCoordinate,int endPointXCoordinate,int endPointYCoordinate)
	{
		UtilHBM.waitFixTime(1000);
		UtilHBM.webElement(driver, "li[data-type='outputset']:nth-child("+outputSetIndex+")>ul.nav-subitem>li:nth-child("+edgeLineIndex+")").click();
		OutputSet outputSet=PageFactory.initElements(driver, OutputSet.class);
		outputSet.setEdgelinePointValues(startPointXCoordinate, startPointYCoordinate, endPointXCoordinate, endPointYCoordinate);
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	
	public AssemblyEditor addNewPoint()
	{
		UtilHBM.waitExplicitDisplayed(driver, addPolyLinePointButton);
		addPolyLinePointButton.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	public AssemblyEditor addNewPoint(int outputSetIndex,int polyLineIndex,int xCoordinate,int yCoordinate,int zCoordinate)
	{
		UtilHBM.waitFixTime(1000);
		UtilHBM.webElement(driver, "li[data-type='outputset']:nth-child("+outputSetIndex+")>ul.nav-subitem>li:nth-child("+polyLineIndex+")>ul>li>button").click();
		openPoint()
		.setXCoordinate(xCoordinate)
		.setYCoordinate(yCoordinate)
		.setZCoordinate(zCoordinate)
		.clickClose();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor addNewPoint(int xCoordinate,int yCoordinate,int zCoordinate)
	{
		UtilHBM.waitExplicitDisplayed(driver, addPolyLinePointButton);
		addPolyLinePointButton.click();
		openPoint()
		.setXCoordinate(xCoordinate)
		.setYCoordinate(yCoordinate)
		.setZCoordinate(zCoordinate);
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	
	AssemblyEditor clickAddAnchorPoint()
	{
		UtilHBM.waitFixTime(1000);
		addAnchorPointButton.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	OutputSet openPoint(int outputSetIndex,int polyLineIndex)
	{
		UtilHBM.webElement(driver, "#outputset-section>ul>li:nth-child("+outputSetIndex+")>ul>li>ul>li[class=' expandable mod-content-section']:nth-child("+polyLineIndex+")").click();
		return PageFactory.initElements(driver, OutputSet.class);
	}
	
	OutputSet openPoint()
	{
		UtilHBM.waitFixTime(2000);
		point.get(point.size()-1).click();
		return PageFactory.initElements(driver, OutputSet.class);
	}

	@FindBy(css="#anchor-section>ul>li>span")
	List<WebElement> anchorPointList;

	AnchorPoint openAnchorPoint()
	{
		anchorPointList.get(anchorPointList.size()-1).click();
		return PageFactory.initElements(driver, AnchorPoint.class);
	}
	
	AnchorPoint openAnchorPoint(int anchorPointNumber)
	{
		UtilHBM.waitExplicitDisplayed(driver, anchorPointList.get(anchorPointList.size()-1));
		anchorPointList.get(anchorPointNumber).click();
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "#panel-floating-pane"));
		return PageFactory.initElements(driver, AnchorPoint.class);
	}
	
	public AssemblyEditor deleteAnchorPoint(int anchorPointIndex)
	{
		List<WebElement> deletedAnchorPoint=driver.findElements(By.cssSelector("#anchor-section>ul>li>span"));
		
		UtilHBM.waitFixTime(1000);
	
		UtilHBM.webElement(driver, "#anchor-section>ul>li:nth-child("+anchorPointIndex+")>span").click();
		UtilHBM.webElement(driver, "#anchor-section>ul>li:nth-child("+anchorPointIndex+")>span>span>span>button[data-ui-action='delete']").click();
		UtilHBM.waitFixTime(1000);
		List<WebElement> deletedAnchorPoint1=driver.findElements(By.cssSelector("#anchor-section>ul>li>span"));
		if(deletedAnchorPoint1.size()==deletedAnchorPoint.size()-1)
		{
			UtilHBM.reportOK("AnchorPoint deleted");
		}
		else
		{
			UtilHBM.reportOK("AnchorPoint not deleted");
		}
		UtilHBM.waitTillElementDisappear(driver, "#panel-floating-pane");
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor verifyAnchorPoint(int anchorPointIndex,int xCoordinate,int yCoordinate,int zCoordinate)
	{
		Verification.VerifyEquals("Coordinate values incorrect", UtilHBM.webElementXPath(driver, "//li[@id='anchor-section']/ul/li["+anchorPointIndex+"]/span").getText(), "Anchor Point ("+xCoordinate+", "+yCoordinate+", "+zCoordinate+")");
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	
	public AssemblyEditor verifyAnchorPointCount(int count)
	{
		List<WebElement> anchorPointList=driver.findElements(By.cssSelector("#anchor-section>ul>li>span"));
		Verification.VerifyEquals("Incorrect count", String.valueOf(anchorPointList.size()), String.valueOf(count));
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor duplicateAnchorPoint(int anchorPointIndex)
	{
		UtilHBM.waitFixTime(1000);
		UtilHBM.webElement(driver, "#anchor-section>ul>li:nth-child("+anchorPointIndex+")>span").click();
		UtilHBM.webElement(driver, "#anchor-section>ul>li:nth-child("+anchorPointIndex+")>span>span>span>button[data-ui-action='duplicate']").click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor addAnchorPoint()
	{
		clickAddAnchorPoint();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor addAnchorPointReceiveTag(int anchorPointIndex,String tagName)
	{
		openAnchorPoint(anchorPointIndex).collapseReceiveTag()
		.addReceiveTag(tagName)
		.clickClose();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor addAnchorPointOrientation(int anchorpointIndex,int yx,int yy,int yz,int zx,int zy,int zz)
	{
		openAnchorPoint(anchorpointIndex).collapseOrientation()
		.setYXOrientation(yx)
		.setYYOrientation(yy)
		.setYZOrientation(yz)
		.setZXOrientation(zx)
		.setZYOrientation(zy)
		.setZZOrientation(zz)
		.expandOrientation()
		.clickClose();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor addAnchorPointPosition(int anchorPointIndex,int xPosition,int yPosition,int zPosition)
	{
		openAnchorPoint(anchorPointIndex).collapsePosition()
		.setXPosition(xPosition)
		.setYPosition(yPosition)
		.setZPosition(zPosition)
		.expandPosition()
		.clickClose();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}


	public AssemblyEditor addNewOutputSet(String type,String outputSetName)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(outputsetCollapse.size()>0)
			outputsetCollapse.get(outputsetCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		
		if(type.contentEquals("polyline"))
		{
			clickAddPolyLineSet()
			.openOutputSet()
			.fillUpName(outputSetName);
		}
		else
		{
			clickEdgePolyLineSet()
			.openOutputSet()
			.fillUpName(outputSetName);
		}
		
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor verifyPolyLine(int outputSetIndex,String outputSetName,int polyLineCount)
	{
		Verification.VerifyEquals("OutputSet name incorrect", UtilHBM.webElementXPath(driver, "//li[@id='outputset-section']/ul/li["+outputSetIndex+"]/span").getText(), outputSetName+" (Polylines)");
		List<WebElement> polylineList=driver.findElements(By.cssSelector("li[id='outputset-section']>ul>li>ul>li[class=' expandable mod-content-section']"));
		if(polylineList.size()==polyLineCount)
		{
			UtilHBM.reportOK("PolyLine count verified successfully");
		}
		else 
		{
			UtilHBM.reportKO("Incorrect polyline count");
		}
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor verifyPoint(int outputSetIndex,int polyLineIndex,int xCoordinate,int yCoordinate,int zCoordinate)
	{
		Verification.VerifyEquals("Incorrect coordinates", UtilHBM.webElement(driver, "#outputset-section>ul>li:nth-child("+outputSetIndex+")>ul>li>ul>li[class=' expandable mod-content-section']:nth-child("+polyLineIndex+")>span").getText(), "Point ("+xCoordinate+", "+yCoordinate+", "+zCoordinate+")");
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	
	public AssemblyEditor duplicateOutputSet(int outputSetIndex)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(outputsetCollapse.size()>0)
			outputsetCollapse.get(outputsetCollapse.size()-1).click();
		UtilHBM.waitFixTime(1000);
		UtilHBM.webElement(driver, "#outputset-section>ul>li:nth-child("+outputSetIndex+")>span").click();
		UtilHBM.webElement(driver, "#outputset-section>ul>li:nth-child("+outputSetIndex+")>span>span>span>button[data-ui-action='duplicate']").click();
		UtilHBM.waitFixTime(1000);
		outputsetExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor verifyOutputSetCount(int count)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(outputsetCollapse.size()>0)
			outputsetCollapse.get(outputsetCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		List<WebElement> outputSetList=driver.findElements(By.cssSelector("#outputset-section>ul>li>span"));
		Verification.VerifyEquals("Incorrect count", String.valueOf(outputSetList.size()), String.valueOf(count));
		outputsetExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor deleteOutputSet(int outputSetIndex)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(outputsetCollapse.size()>0)
			outputsetCollapse.get(outputsetCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.waitFixTime(1000);
		UtilHBM.webElement(driver, "#outputset-section>ul>li:nth-child("+outputSetIndex+")>span").click();
		UtilHBM.webElement(driver, "#outputset-section>ul>li:nth-child("+outputSetIndex+")>span>span>span>button[data-ui-action='delete']").click();
		UtilHBM.waitFixTime(1000);
		List<WebElement> deletedOutputSet=driver.findElements(By.cssSelector("#outputset-section>ul>li>span"));
		if(deletedOutputSet.size()==0)
		{
			UtilHBM.reportOK("OutputSet deleted");
		}
		else
		{
			UtilHBM.reportOK("OutputSet not deleted");
		}
		outputsetExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor addPolyLine(int outputSetIndex)
	{
		addNewPolyLine(outputSetIndex);
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	

	public AssemblyEditor clickAddPolyLineSet()
	{
		addPolyLineSetButton.click();
		UtilHBM.waitFixTime(2000);
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver, "//span[@aria-controls='nav-subitem']"));
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor clickEdgePolyLineSet()
	{
		UtilHBM.waitFixTime(1000);
		addEdgeLineSetButton.click();
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver, "//span[@aria-controls='nav-subitem']"));
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	OutputSet openOutputSet(int outputSetIndex)
	{
		List<WebElement> outputSetList=driver.findElements(By.xpath("//*[@id='outputset-section']/ul/li"));
		outputSetList.get(outputSetIndex).click();

		return PageFactory.initElements(driver, OutputSet.class);
	}

	OutputSet openOutputSet()
	{
		outputsetList.get(outputsetList.size()-1).click();
		return PageFactory.initElements(driver, OutputSet.class);
	}

	public AssemblyEditor saveAssembly()
	{
		String home = System.getProperty("user.home");
		File dir = new File(home+"\\Downloads");
		for (File file : dir.listFiles()) {
			if (file.getName().endsWith((".BMTPROJ"))) {
				existingFiles.add(file.getName());
			}
			else if(file.getName().endsWith((".ZIP")))
			{
				existingFiles.add(file.getName());
			}
		}
		setExistingFiles(existingFiles);
		saveButton.click();
		UtilHBM.waitFixTime(5000);
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	Relations openRelation()
	{
		relationList.get(relationList.size()-1).click();		
		return PageFactory.initElements(driver, Relations.class);
	}
	
	Relations openRelation(String relationName)
	{
		UtilHBM.waitFixTime(1000);
		WebElement relation=driver.findElement(By.xpath("//*[@id='left-panel']/div/div/ul/li[contains(@id,'relation-section')]/ul/li/span[contains(@title,'"+relationName+"')]"));
		relation.click();
		return PageFactory.initElements(driver, Relations.class);
	}

	AssemblyEditor clickNewRelation()
	{
		UtilHBM.waitFixTime(1000);
		addNewRelationButton.click();
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, newRelation);
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	SelectComponent clickNewComponent()
	{
		UtilHBM.waitFixTime(1000);
		addNewComponentButton.click();
		return PageFactory.initElements(driver, SelectComponent.class);
	}

	public AssemblyEditor verifyRelation(String relationName, String type, String relValue, String relationExpression, String... errorMessages)
	{
		if(relationCollapse.size()>0)
			relationCollapse.get(relationCollapse.size()-1).click();
		UtilHBM.waitFixTime(1000);
		openRelation(relationName)
		.verifyRelationDetails(relationName, type, relValue, relationExpression, errorMessages);
		relationExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor addNewRelation(String relationName,String type,String relationExpression)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(relationCollapse.size()>0)
			relationCollapse.get(relationCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		clickNewRelation()
		.openRelation()
		.fillRelationDetails(relationName, type, relationExpression);
		UtilHBM.waitFixTime(1000);
		relationExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	AssemblyEditor closePanel()
	{
		relationExpand.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	public AssemblyEditor addComponent(String productName)
	{
		clickNewComponent()
		.selectProduct(productName);
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver,"//*[@id='component-section']/ul/li/span[contains(@title,'"+productName+"')]"));
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor editComponent(String componentName,String newComponentName,String type,String searchString,String productName)
	{
		if(componentCollapse.size()>0)
			componentCollapse.get(componentCollapse.size()-1).click();
		UtilHBM.waitFixTime(1000);
		openComponentPanel(componentName)
		.setComponentName(newComponentName)
		.clickReplaceRef()
		.selectComponent(type, searchString, productName)
		.clickClose();
		UtilHBM.waitFixTime(1000);
		WebElement componentNode=driver.findElement(By.xpath("//li[@id='component-section']/ul/li/span[@title='"+newComponentName+" ("+productName+")']"));
		Verification.elementContainsString(componentNode,Components.getComponentParameter() , "Component "+Components.getComponentParameter()+" ");
		UtilHBM.waitFixTime(1000);
		componentExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor deleteComponent(String componentName)
	{
		if(componentCollapse.size()>0)
			componentCollapse.get(componentCollapse.size()-1).click();
		UtilHBM.waitFixTime(1000);
		UtilHBM.webElementXPath(driver, "//*[@id='component-section']/ul/li/span[contains(@title,'"+componentName+"')]").click();
		UtilHBM.webElementXPath(driver, "//*[@id='component-section']/ul/li/span[contains(@title,'"+componentName+"')]/span/span/button[@data-ui-action='delete']").click();
		UtilHBM.waitFixTime(1000);
		List<WebElement> deletedComponent=driver.findElements(By.xpath("//*[@id='component-section']/ul/li/span[contains(@title,'"+componentName+"')]"));
		if(deletedComponent.size()==0)
		{
			UtilHBM.reportOK("Component "+componentName+" deleted");
		}
		else
		{
			UtilHBM.reportKO("Component "+componentName+" not deleted");
		}
		UtilHBM.waitTillElementDisappear(driver, "#panel-floating-pane");
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor duplicateRelation(String relationName)
	{
		if(relationCollapse.size()>0)
			relationCollapse.get(relationCollapse.size()-1).click();
		UtilHBM.waitFixTime(1000);
		UtilHBM.webElementXPath(driver, "//*[@id='relation-section']/ul/li/span[contains(@title,'"+relationName+"')]").click();
		UtilHBM.webElementXPath(driver, "//*[@id='relation-section']/ul/li/span[contains(@title,'"+relationName+"')]/span/span/button[@data-ui-action='duplicate']").click();
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver, "//*[@id='relation-section']/ul/li/span[contains(@title,'"+relationName+"-copy"+"')]"));
		
		if(UtilHBM.webElementXPath(driver, "//*[@id='relation-section']/ul/li/span[contains(@title,'"+relationName+"-copy"+"')]").isDisplayed())
		{
			UtilHBM.reportOK("Duplicate successful");
		}
		else
		{
			UtilHBM.reportKO("Duplicate unsuccessful");
		}
		
		Relations relations=PageFactory.initElements(driver, Relations.class);
		relations.clickClose();
		relationExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor duplicateComponent(String componentName)
	{
		if(componentCollapse.size()>0)
			componentCollapse.get(componentCollapse.size()-1).click();
		UtilHBM.waitFixTime(1000);
		UtilHBM.webElementXPath(driver, "//*[@id='component-section']/ul/li/span[contains(@title,'"+componentName+"')]").click();
		UtilHBM.webElementXPath(driver, "//*[@id='component-section']/ul/li/span[contains(@title,'"+componentName+"')]/span/span/button[@data-ui-action='duplicate']").click();
		UtilHBM.waitFixTime(1000);
		if(UtilHBM.webElementXPath(driver, "//*[@id='component-section']/ul/li/span[contains(@title,'"+componentName+"-copy"+"')]").isDisplayed())
		{
			UtilHBM.reportOK("Duplicate successful");
		}
		else
		{
			UtilHBM.reportKO("Duplicate unsuccessful");
		}
		Components components=PageFactory.initElements(driver, Components.class);
		components.clickClose();
		UtilHBM.waitFixTime(1000);
		componentExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor verifyRelationCount(int count)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(relationCollapse.size()>0)
			relationCollapse.get(relationCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		
		List<WebElement> relationList=driver.findElements(By.cssSelector("#relation-section>ul>li>span"));
		Verification.VerifyEquals("Incorrect count", String.valueOf(relationList.size()), String.valueOf(count));
		relationExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor deleteRelation(String relationName)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(relationCollapse.size()>0)
			relationCollapse.get(relationCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.waitFixTime(1000);
		UtilHBM.webElementXPath(driver, "//*[@id='relation-section']/ul/li/span[contains(@title,'"+relationName+"')]").click();
		UtilHBM.webElementXPath(driver, "//*[@id='relation-section']/ul/li/span[contains(@title,'"+relationName+"')]/span/span/button[@data-ui-action='delete']").click();
		UtilHBM.waitFixTime(1000);
		List<WebElement> deletedRelation=driver.findElements(By.xpath("//*[@id='relation-section']/ul/li/span[contains(@title,'"+relationName+"')]"));
		if(deletedRelation.size()==0)
		{
			UtilHBM.reportOK("Relation "+relationName+" deleted");
		}
		else
		{
			UtilHBM.reportKO("Relation "+relationName+" not deleted");
		}
		UtilHBM.waitTillElementDisappear(driver, "#panel-floating-pane");
		UtilHBM.waitFixTime(1000);
		relationExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor verifyComponentCount(int count)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(componentCollapse.size()>0)
			componentCollapse.get(componentCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		List<WebElement> componentList=driver.findElements(By.cssSelector("#component-section>ul>li>span"));
		Verification.VerifyEquals("Incorrect count", String.valueOf(componentList.size()), String.valueOf(count));
		UtilHBM.waitFixTime(1000);
		componentExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	
	public AssemblyEditor verifyComponent(String componentName,String refProductName)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(componentCollapse.size()>0)
			componentCollapse.get(componentCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.waitFixTime(1000);
		openComponentPanel(componentName)
		.verifyComponent(componentName, refProductName);
		UtilHBM.waitFixTime(1000);
		componentExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor addNewComponent(String componentName,String type,String searchString,String productName)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(componentCollapse.size()>0)
			componentCollapse.get(componentCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		if(type.contentEquals("symbol"))
		{
			clickNewComponent()
			.selectComponent(type,productName);
			openComponentPanel(productName)
			.setComponentName(componentName).clickClose();
		}
		else
		{
			clickNewComponent()
			.selectComponent(type, searchString, productName);
			openComponentPanel(productName)
			.setComponentName(componentName).clickClose();
		}
		UtilHBM.waitFixTime(1000);
		WebElement componentNode=driver.findElement(By.xpath("//li[@id='component-section']/ul/li/span[@title='"+componentName+" ("+productName+")']"));
		Verification.elementContainsString(componentNode,Components.getComponentParameter() , "Component "+Components.getComponentParameter()+" ");
		componentExpand.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor addNewComponent(String componentName,String type,String productName)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(componentCollapse.size()>0)
			componentCollapse.get(componentCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		clickNewComponent()
		.selectComponent(type,productName);
		if(type.contentEquals("symbol"))
		{
//			WebElement element=driver.findElement(By.xpath("//*[@id='component-section']/ul/li/span[contains(@title,'"+productName+"')]"));
			String element = "//*[@id='component-section']/ul/li/span[contains(@title,'" + productName + "')]";
			UtilHBM.waitExplicitDisplayed(driver, element);
		}
		else
		{
			WebElement element=driver.findElement(By.xpath("//*[@id='component-section']/ul/li/span[contains(@title,'"+productName+"')]"));
			UtilHBM.waitExplicitDisplayed(driver, element);
		}
		openComponentPanel()
		.setComponentName(componentName);
		WebElement componentNode=driver.findElement(By.xpath("//li[@id='component-section']/ul/li/span[@title='"+componentName+" ("+productName+")']"));
		Verification.elementContainsString(componentNode,Components.getComponentParameter() , "Component "+Components.getComponentParameter()+" ");

		componentExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}


	public AssemblyEditor componentSelectActivated(String componentName,String option)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(componentCollapse.size()>0)
			componentCollapse.get(componentCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.waitFixTime(1000);
		openComponentPanel(componentName)
		.selectActivated(option);
		UtilHBM.waitFixTime(1000);
		componentExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor addXComponentPosition(String componentName,String type,String value)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(componentCollapse.size()>0)
			componentCollapse.get(componentCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.waitFixTime(1000);
		openComponentPanel(componentName)
		.fillXPositionDetails(type,value);
		UtilHBM.waitFixTime(1000);
		componentExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor addYComponentPosition(String componentName,String type,String value)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(componentCollapse.size()>0)
			componentCollapse.get(componentCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.waitFixTime(1000);
		openComponentPanel(componentName)
		.fillYPositionDetails(type,value);
		UtilHBM.waitFixTime(1000);
		componentExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor addZComponentPosition(String componentName,String type,String value)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(componentCollapse.size()>0)
			componentCollapse.get(componentCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.waitFixTime(1000);
		openComponentPanel(componentName)
		.fillZPositionDetails(type,value);
		UtilHBM.waitFixTime(1000);
		componentExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	
	public AssemblyEditor addComponentZYOrientation(String componentName,String type,String value)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(componentCollapse.size()>0)
			componentCollapse.get(componentCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.waitFixTime(1000);
		openComponentPanel(componentName)
		.fillZYOrientationDetails(componentName,type,value);
		UtilHBM.waitFixTime(1000);
		componentExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor addComponentZXOrientation(String componentName,String type,String value)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(componentCollapse.size()>0)
			componentCollapse.get(componentCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		openComponentPanel(componentName)
		.fillZXOrientationDetails(componentName,type,value);
		UtilHBM.waitFixTime(1000);
		componentExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor addComponentYZOrientation(String componentName,String type,String value)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(componentCollapse.size()>0)
			componentCollapse.get(componentCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.waitFixTime(1000);
		openComponentPanel(componentName)
		.fillYZOrientationDetails(componentName,type,value);
		UtilHBM.waitFixTime(1000);
		componentExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor addComponentYXOrientation(String componentName,String type,String value)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(componentCollapse.size()>0)
			componentCollapse.get(componentCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.waitFixTime(1000);
		openComponentPanel(componentName)
		.fillYXOrientationDetails(componentName,type,value);
		UtilHBM.waitFixTime(1000);
		componentExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor addComponentZZOrientation(String componentName,String type,String value)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(componentCollapse.size()>0)
			componentCollapse.get(componentCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.waitFixTime(1000);
		openComponentPanel(componentName)
		.fillZZOrientationDetails(componentName,type,value);
		UtilHBM.waitFixTime(1000);
		componentExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor addComponentYYOrientation(String componentName,String type,String value)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(componentCollapse.size()>0)
			componentCollapse.get(componentCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.waitFixTime(1000);
		openComponentPanel(componentName)
		.fillYYOrientationDetails(componentName,type,value);
		UtilHBM.waitFixTime(1000);
		componentExpand.click();		
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	public AssemblyEditor addTranslation(int x,int y,int z)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(translationCollapse.size()>0)
			translationCollapse.get(translationCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.waitFixTime(1000);
		addTranslationButton.sendKeys(Keys.END);
		addTranslationButton.click();
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "#animation-section>ul>li>span"));
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "#animation-section>ul>li>span>span>span>button[data-ui-action='animation']"));
		while(animationPanel.size()==0)
			UtilHBM.webElement(driver, "#animation-section>ul>li>span").click();
		Animation animation=PageFactory.initElements(driver, Animation.class);
		animation.addTranslationDetails(x, y, z);
		UtilHBM.waitFixTime(1000);
		translationExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	Animation openAnimation()
	{
		while(animationPanel.size()==0)
			UtilHBM.webElement(driver, "#animation-section>ul>li>span").click();
		return PageFactory.initElements(driver, Animation.class);
	}
	
	public AssemblyEditor verifyRotation(int x,int y,int z,int axisX,int axisY,int axisZ)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(translationCollapse.size()>0)
			translationCollapse.get(translationCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		openAnimation()
		.verifyRotationParameters(x, y, z, axisX, axisY, axisZ);
		UtilHBM.waitFixTime(1000);
		translationExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	public AssemblyEditor verifyTranslation(int x,int y,int z)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(translationCollapse.size()>0)
			translationCollapse.get(translationCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		openAnimation()
		.verifyTranslationParameters(x, y, z);
		UtilHBM.waitFixTime(1000);
		translationExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	
	public AssemblyEditor addRotation(int x,int y,int z,int axisX,int axisY,int axisZ)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(translationCollapse.size()>0)
			translationCollapse.get(translationCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		addRotatonButton.click();
		UtilHBM.waitExplicitDisplayed(driver, "//li[@id='animation-section']/ul/li/span");
//		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "#animation-section>ul>li>span>span>span>button[data-ui-action='animation']"));
		while(animationPanel.size()==0)
			UtilHBM.webElement(driver, "#animation-section>ul>li>span").click();
		Animation animation=PageFactory.initElements(driver, Animation.class);
		animation.addRotationDetails(x, y, z, axisX, axisY, axisZ);
		UtilHBM.waitFixTime(1000);
		translationExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor previewAnimation()
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(translationCollapse.size()>0)
			translationCollapse.get(translationCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		while(animationPanel.size()==0)
			UtilHBM.webElement(driver, "#animation-section>ul>li>span").click();
		Animation animation=PageFactory.initElements(driver, Animation.class);
		animation.clickPreviewAnimation();
		UtilHBM.waitFixTime(1000);
		translationExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	

	public AssemblyEditor deleteAnimation()
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(translationCollapse.size()>0)
			translationCollapse.get(translationCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.waitFixTime(1000);
		UtilHBM.webElement(driver, "#animation-section>ul>li>span").click();
		UtilHBM.webElement(driver, "#animation-section>ul>li>span>span>span>button[data-ui-action='delete']").click();
		UtilHBM.waitFixTime(1000);
		List<WebElement> deletedAnimations=driver.findElements(By.cssSelector("#animation-section>ul>li>span"));
		if(deletedAnimations.size()==0)
		{
			UtilHBM.reportOK("Animation deleted");
		}
		else
		{
			UtilHBM.reportOK("Animation not deleted");
		}
		UtilHBM.waitTillElementDisappear(driver, "#panel-floating-pane");
		UtilHBM.waitFixTime(1000);
		translationExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	

	public AssemblyEditor addComponentOverloads(String componentName,String overloadParameter,String type,String value)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(componentCollapse.size()>0)
			componentCollapse.get(componentCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.waitFixTime(1000);
		openComponentPanel(componentName)
		.fillOverloadDetails(overloadParameter,type,value);
		UtilHBM.waitFixTime(1000);
		componentExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor verifyParameterCount(int count)
	{
//		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver, "//*[@id='parameter-section']/ul/li/span[contains(@title,'"+parameterName+"-copy')]"));
		List<WebElement> parameterList=driver.findElements(By.cssSelector("#parameter-section>ul>li>span"));
		Verification.VerifyEquals("Incorrect count", String.valueOf(parameterList.size()), String.valueOf(count));
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	public AssemblyEditor duplicateParameter(String parameterName)
	{
		if(parameterCollapse.size()>0)
			parameterCollapse.get(parameterCollapse.size()-1).click();
		UtilHBM.waitFixTime(1000);
		UtilHBM.webElementXPath(driver, "//*[@id='parameter-section']/ul/li/span[contains(@title,'"+parameterName+"')]").click();
		UtilHBM.webElementXPath(driver, "//*[@id='parameter-section']/ul/li/span[contains(@title,'"+parameterName+"')]/span/span/button[@data-ui-action='duplicate']").click();
		UtilHBM.waitFixTime(1000);
		if(UtilHBM.webElementXPath(driver, "//*[@id='parameter-section']/ul/li/span[contains(@title,'"+parameterName+"-copy"+"')]").isDisplayed())
		{
			UtilHBM.reportOK("Duplicate successful");
		}
		else
		{
			UtilHBM.reportKO("Duplicate unsuccessful");
		}
		Parameter parameter=PageFactory.initElements(driver, Parameter.class);
		parameter.clickClose();
		UtilHBM.waitFixTime(1000);
		parameterExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	public AssemblyEditor verifyParameter(String name,String type,String value)
	{
		if(parameterCollapse.size()>0)
			parameterCollapse.get(parameterCollapse.size()-1).click();
		UtilHBM.waitFixTime(1000);
		openParameter(name).verifyParameterDetails(name, type, value);
		UtilHBM.waitFixTime(1000);
		parameterExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	public AssemblyEditor editParameter(String parameterName,String newParameterName,String type,String searchString,String productName)
	{
		if(parameterCollapse.size()>0)
			parameterCollapse.get(parameterCollapse.size()-1).click();
		openParameter(parameterName)
		.addParameterDetails(newParameterName, type, searchString, productName);
		UtilHBM.waitFixTime(1000);
		parameterExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor deleteParameter(String parameterName)
	{
		if(parameterCollapse.size()>0)
			parameterCollapse.get(parameterCollapse.size()-1).click();
		UtilHBM.waitFixTime(1000);
		UtilHBM.webElementXPath(driver, "//*[@id='parameter-section']/ul/li/span[contains(@title,'"+parameterName+"')]").click();
		UtilHBM.webElementXPath(driver, "//*[@id='parameter-section']/ul/li/span[contains(@title,'"+parameterName+"')]/span/span/button[@data-ui-action='delete']").click();
		UtilHBM.waitFixTime(1000);
		List<WebElement> deletedParameter=driver.findElements(By.xpath("//*[@id='parameter-section']/ul/li/span[contains(@title,'"+parameterName+"')]"));
		if(deletedParameter.size()==0)
		{
			UtilHBM.reportOK("Parameter "+parameterName+" deleted");
		}
		else
		{
			UtilHBM.reportKO("Parameter "+parameterName+" not deleted");
		}
		UtilHBM.waitTillElementDisappear(driver, "#panel-floating-pane");
		UtilHBM.waitFixTime(1000);
		parameterExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor editParameter(String parameterName,String newParameterName,String type,String value)
	{
		if(parameterCollapse.size()>0)
			parameterCollapse.get(parameterCollapse.size()-1).click();
		openParameter(parameterName)
		.addParameterDetails(newParameterName, type, value);
		UtilHBM.waitFixTime(1000);
		parameterExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	
	public AssemblyEditor addNewParameter(String parameterName,String type,String searchString,String productName)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(parameterCollapse.size()>0)
			parameterCollapse.get(parameterCollapse.size()-1).click();
		UtilHBM.turnOnImplicitWaits(driver);
		clickNewParameter()
		.openParameter()
		.addParameterDetails(parameterName,type,searchString,productName);
		UtilHBM.waitFixTime(1000);
		parameterExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	public AssemblyEditor addNewParameter(String parameterName,String type,String value)
	{
		if(parameterCollapse.size()>0)
			parameterCollapse.get(parameterCollapse.size()-1).click();
		clickNewParameter()
		.openParameter()
		.addParameterDetails(parameterName,type,value);
		UtilHBM.waitFixTime(1000);
		parameterExpand.click();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	Components openComponentPanel()
	{
		UtilHBM.waitFixTime(2000);
		componentList.get(componentList.size()-1).click();
		return PageFactory.initElements(driver, Components.class);
	}

	Components openComponentPanel(String componentName)
	{
		UtilHBM.waitExplicitDisplayed(driver, "//*[@id='left-panel']/div/div/ul/li[contains(@id,'component-section')]/ul/li/span[contains(text(),'"+componentName+"')]");
		List<WebElement> components=driver.findElements(By.xpath("//*[@id='left-panel']/div/div/ul/li[contains(@id,'component-section')]/ul/li/span[contains(text(),'"+componentName+"')]"));
		components.get(components.size()-1).click();
		return PageFactory.initElements(driver, Components.class);
	}

	Parameter openParameter(String parameterName)
	{
		UtilHBM.waitFixTime(1000);
		WebElement parameter=driver.findElement(By.xpath("//*[@id='left-panel']/div/div/ul/li[contains(@id,'parameter-section')]/ul/li/span[contains(text(),'"+parameterName+"')]"));
		parameter.click();
		return PageFactory.initElements(driver, Parameter.class);
	}


	Parameter openParameter()
	{		
		parameterList.get(parameterList.size()-1).click();	
		return PageFactory.initElements(driver, Parameter.class);
	}


	AssemblyEditor clickNewParameter()
	{
		UtilHBM.waitFixTime(3000);
		addNewParameterButton.click();
		UtilHBM.waitFixTime(3000);
		UtilHBM.waitExplicitDisplayed(driver, newParameter);
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	public Components select3DProduct(int x, int y) {
		UtilHBM.turnOffImplicitWaits(driver);

		for(int counter=0; counter<5; counter++){
			Actions action = new Actions(driver);
			action.moveToElement(container3D, x, y).clickAndHold().pause(500).release().build().perform();
			System.out.println("image clicked");
			try {
				if(componentPanel.isDisplayed())break;
			} catch (NoSuchElementException e) {
			}
		}
		UtilHBM.turnOnImplicitWaits(driver);

		return PageFactory.initElements(driver, Components.class);
	}

	public AssemblyEditor addAnchorPointAvailableSpace(int anchorPtIndex,int xAS,int yAS,int zAS)
	{
		openAnchorPoint(anchorPtIndex).expandAvailableSpaceSection().collapseAvailableSpaceSection()
				.setAvailableSpace_X(xAS)
				.setAvailableSpace_Y(yAS)
				.setAvailableSpace_Z(zAS)
				.clickClose();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	public AssemblyEditor verifyAnchorPointAvSpace(int anchorPointIndex, int xVal, int yVal, int zVal) {
		openAnchorPoint(anchorPointIndex).expandAvailableSpaceSection()
				.verifyAvailableSpaceValues(xVal, yVal, zVal)
				.clickClose();
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}


public AssemblyEditor showHideComponent(String componentName, boolean openComponentPanel, String action) {
		UtilHBM.waitFixTime(1000);
		if (componentCollapse.size() > 0) componentCollapse.get(0).click();
		UtilHBM.waitExplicitDisplayed(driver, componentExpand);

		if(openComponentPanel){
			openComponentPanel(componentName).showHideComponent(action);
		}else{
			mouseOverComponentAndShowHide(componentName,action);
		}
		return PageFactory.initElements(driver, AssemblyEditor.class);

	}

	AssemblyEditor mouseOverComponentAndShowHide(String componentName,String action)
	{
		UtilHBM.waitExplicitDisplayed(driver, "//*[@id='left-panel']/div/div/ul/li[contains(@id,'component-section')]/ul/li/span[contains(text(),'"+componentName+"')]");
		List<WebElement> components=driver.findElements(By.xpath("//*[@id='left-panel']/div/div/ul/li[contains(@id,'component-section')]/ul/li/span[contains(text(),'"+componentName+"')]"));
		Assert.assertTrue(components.size() > 0, "Component with name : '" + componentName + "' not found");
		UtilHBM.turnOffImplicitWaits(driver);
		switch(action){
			case "hide":
				List<WebElement> hideActionBtn=components.get(0).findElements(By.cssSelector("span.hover-actions span.mod-item-actions button[title='Hide']"));
				if(hideActionBtn.size()==1)
					(new Actions(driver)).moveToElement(components.get(components.size()-1)).pause(1000).click(hideActionBtn.get(0)).build().perform();;
				break;
			case "show":
			default:
				List<WebElement> showActionBtn=components.get(0).findElements(By.cssSelector("span.hover-actions span.mod-item-actions button[title='Show']"));
				if(showActionBtn.size()==1)
					(new Actions(driver)).moveToElement(components.get(components.size()-1)).pause(1000).click(showActionBtn.get(0)).build().perform();
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	public AssemblyEditor openComponent(String componentName, boolean openComponentPanel) {
		UtilHBM.waitFixTime(1000);
		if (componentCollapse.size() > 0) componentCollapse.get(0).click();
		UtilHBM.waitExplicitDisplayed(driver, componentExpand);

		if(openComponentPanel){
			openComponentPanel(componentName).openComponent();
		}else{
			mouseOverComponentAndOpen(componentName);
		}
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	AssemblyEditor mouseOverComponentAndOpen(String componentName) {
		UtilHBM.waitExplicitDisplayed(driver, "//*[@id='left-panel']/div/div/ul/li[contains(@id,'component-section')]/ul/li/span[contains(text(),'" + componentName + "')]");
		List<WebElement> components = driver.findElements(By.xpath("//*[@id='left-panel']/div/div/ul/li[contains(@id,'component-section')]/ul/li/span[contains(text(),'" + componentName + "')]"));
		Assert.assertTrue(components.size() > 0, "Component with name : '" + componentName + "' not found");
		UtilHBM.turnOffImplicitWaits(driver);
		WebElement openComponentBtn = components.get(0).findElement(By.cssSelector("span.hover-actions span.mod-item-actions button[title='Open component']"));
		(new Actions(driver)).moveToElement(components.get(components.size() - 1)).pause(1000).click(openComponentBtn).build().perform();

		UtilHBM.turnOnImplicitWaits(driver);
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	public AssemblyEditor switchToWindowWithComponent(String productID) {
		boolean componentFound = false;
		for (int i = 0; i < driver.getWindowHandles().size(); i++) {
			driver.switchTo().window(Iterables.get(driver.getWindowHandles(), i));
			if (driver.getCurrentUrl().contains("productId=" + productID)) {
				componentFound = true;
				StartApplication startApplication = PageFactory.initElements(driver, StartApplication.class);
				return startApplication.startApp();
			}
		}
		if (!componentFound) {
			driver.switchTo().window(Browser.mainWindowHandle);
			UtilHBM.reportKO("Component with productID = " + productID + " not opened");
		}
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	public AssemblyEditor returnToParentComponentWindow() {
		driver.switchTo().window(Browser.mainWindowHandle);
		driver.switchTo().frame(driver.findElement(By.cssSelector("#embedded-app-frame")));
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}

	public AssemblyEditor selectComponent(String componentName) {
		UtilHBM.waitFixTime(1000);
		if (componentCollapse.size() > 0) componentCollapse.get(0).click();
		UtilHBM.waitExplicitDisplayed(driver, componentExpand);
		openComponentPanel(componentName);
		UtilHBM.waitExplicitDisplayed(driver, componentPanel);
		return PageFactory.initElements(driver, AssemblyEditor.class);

	}

	public AssemblyEditor verifyComponentOverloads(String overloadParameter, boolean overloadSelected, String parameterType, String parameterValue) {
		UtilHBM.waitFixTime(500);
		if(overloadForm.getAttribute("aria-hidden").equalsIgnoreCase("true"))overloadSection.click();
		UtilHBM.waitExplicitDisplayed(driver, overloadForm);
		UtilHBM.scrollToElementWithOffset(driver, overloadForm.findElement(By.cssSelector("p[data-ui-name='"+overloadParameter+"']")),0);

		Assert.assertTrue(overloadSelected==overloadForm.findElement(By.cssSelector("p[data-ui-name='"+overloadParameter+"'] input[data-ui-action='overload-creation']")).isSelected());
		if(!parameterType.isEmpty()){

		}

		if(!parameterValue.isEmpty()){

		}
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
}
