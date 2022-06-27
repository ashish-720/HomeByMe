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


public class Design {
	WebDriver driver;

	public Design(WebDriver driver) {
		this.driver=driver;	
	}

	@FindBy(css="li.current>button")
	WebElement title1;

	@FindBy(css="#cabinets>span")
	WebElement subtitle1;

	@FindBy(css="#appliances>span")
	WebElement subtitle2;

	@FindBy(css="#dining>span")
	WebElement subtitle3;

	@FindBy(css="#accessories>span")
	WebElement subtitle4;

	@FindBy(css="#search>span")
	WebElement subtitle5;

	@FindBy(css="#cabinets")
	WebElement cabinetsLogo;

	@FindBy(css="button[data-state='design']")
	WebElement designButton;

	@FindBy(css="button[title='Save']")
	WebElement saveButton;

	@FindBy(css="main>div>#topbar>div>div>ul>li")
	WebElement menuOptions;

	@FindBy(css="#bmSVG")
	WebElement container3D;

	@FindBy(css="#design-mod-properties-window-wide>div>h3")
	WebElement productInfoName;

	@FindBy(css="#design-mod-properties-window-wide")
	List<WebElement> productDescriptionBox;

	@FindBy(css="button[title='Position']")
	WebElement positionButton;

	@FindBy(css="div[id*='measurevalueDiv'] input")
	List<WebElement> measureInput;

	@FindBy(css=".manip-translate")
	WebElement translatePointer;

	@FindBy(css=".manip-elevate.secondary")
	WebElement elevatePointer;

	@FindBy(css="button[title='Edit']")
	WebElement editButton;

	@FindBy(css="button[title='Duplicate']")
	WebElement duplicateButton;

	@FindBy(css="#design-mod-properties-window-wide>div>h3")
	WebElement productDisplayName;

	@FindBy(css=".mod-loader>.content>span.spinner")
	List<WebElement> processingLabel;

	@FindBy(css="#header-filter>button.bt-back")
	WebElement backButton;

	@FindBy(css="button[title='Delete']")
	WebElement deleteButton;

	@FindBy(css="div>button[data-ui-action='product-replace']")
	WebElement replaceButton;

	@FindBy(css="#design-mod-properties-window-wide>ul>li>ul>li>button[title='Open']")
	WebElement openButton;

	@FindBy(css="#search")
	WebElement searchButton;

	@FindBy(css="#catalogSearchBar-form-input")
	WebElement searchProductInput;
	
	@FindBy(xpath="//button[@title='Open']/parent::li/input")
	WebElement reopenButton;

	@FindBy(css="#project-title")
	WebElement projectNameText;
	
	@FindBy(css="button[title='Close']")
	WebElement closeButton;
	
	@FindBy(css="#close-button")
	WebElement closeDescBox;

	@FindBy(css="button[data-ui-action='panel-close']")
	WebElement closePanelButton;

	@FindBy(css="article.mod-properties-window-wide.mod-open")
	List<WebElement> propertiesPanel;


	
	public Design close(){
		closeButton.click();
		driver.switchTo().defaultContent();
		return PageFactory.initElements(driver, Design.class);
	}
	
	public Design reopenProject(String projectName)
	{
		reopenButton.sendKeys(new File(Setting.screenCapturePath+"/"+projectName+".BMTPROJ").getAbsolutePath());
		UtilHBM.waitFixTime(5000);
		Verification.VerifyEquals("Incorrect project name", projectNameText.getText(), projectName);
		return PageFactory.initElements(driver, Design.class);
	}
	
	public Design addProperty(String productName,String property,int xCoordinate,int yCoordinate,String propertyMaterial)
	{
		selectProduct(xCoordinate, yCoordinate);
		UtilHBM.waitExplicitDisplayed(driver, productDescriptionBox.get(0));
		editButton.click();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("li[data-ui-publicationid='"+property+"']>div>div>button[data-ui-action='product-option-add']")));
		if(driver.findElement(By.cssSelector("li[data-ui-publicationid='"+property+"']>div>div>button[data-ui-action='product-option-add']")).isDisplayed())
		{
			driver.findElement(By.cssSelector("li[data-ui-publicationid='"+property+"']>div>div>button[data-ui-action='product-option-add']")).sendKeys(Keys.END);
			UtilHBM.waitFixTime(3000);
			driver.findElement(By.cssSelector("li[data-ui-publicationid='"+property+"']>div>div>button[data-ui-action='product-option-add']")).click();
		}

		UtilHBM.turnOffImplicitWaits(driver);
		if(processingLabel.size()>0)
			UtilHBM.waitTillElementDisappear(driver, ".mod-loader>.content>span.spinner");
		UtilHBM.turnOnImplicitWaits(driver);
		if(propertyMaterial.contains("/"))
		{
			if(propertyMaterial.split("/").length==2)
			{
				UtilHBM.waitFixTime(3000);
				WebElement replacementOption=driver.findElement(By.cssSelector("#mod-product-list>li>article>div>h3[title='"+propertyMaterial.split("/")[0]+"']"));
//				UtilHBM.scrollToElementWithOffset(driver,replacementOption,0 );
				replacementOption.click();
				if(propertyMaterial.split("/")[1].contentEquals("Apply"))
				{
					driver.findElement(By.xpath("//ul[@id='mod-product-list']/li/article/div/h3[@title='"+propertyMaterial.split("/")[0]+"']/parent::div/parent::article/div/p/button[@class='cta-primary']")).click();
				}
				else
				{
					driver.findElement(By.xpath("//ul[@id='mod-product-list']/li/article/div/h3[@title='"+propertyMaterial.split("/")[0]+"']/parent::div/parent::article/div/p/button[@class='cta-secondary']")).click();
				}
			}
			else
			{
				UtilHBM.waitFixTime(3000);
				WebElement replacementOption1=driver.findElement(By.cssSelector("#mod-product-list>li[data-ui-id='"+propertyMaterial.split("/")[1]+"']>article>div>h3[title='"+propertyMaterial.split("/")[0]+"']"));
				replacementOption1.click();
				if(propertyMaterial.split("/")[2].contentEquals("Apply"))
				{
					driver.findElement(By.xpath("//ul[@id='mod-product-list']/li[@data-ui-id='"+propertyMaterial.split("/")[1]+"']/article/div/h3[@title='"+propertyMaterial.split("/")[0]+"']/parent::div/parent::article/div/p/button[@class='cta-primary']")).click();
				}
				else
				{
					driver.findElement(By.xpath("//ul[@id='mod-product-list']/li[@data-ui-id='"+propertyMaterial.split("/")[1]+"']/article/div/h3[@title='"+propertyMaterial.split("/")[0]+"']/parent::div/parent::article/div/p/button[@class='cta-secondary']")).click();
				}
			}
		}
		else
		{
			WebElement replacementOption=driver.findElement(By.cssSelector("#mod-product-list>li>article>div>h3[title='"+propertyMaterial+"']"));
//			UtilHBM.scrollToElementWithOffset(driver,replacementOption,0 );
			replacementOption.click();
		}
		backButton.click();
		if(driver.findElement(By.cssSelector("li[data-ui-publicationid='"+property+"']")).isDisplayed() && driver.findElement(By.cssSelector("li[data-ui-publicationid='"+property+"']>div>p>span.desc")).getText().contains(propertyMaterial.split("/")[0]))
		{
			UtilHBM.reportOK(property +" property added to "+productName+ ". "+ propertyMaterial.split("/")[0]+" material added to the "+property);
		}
		return PageFactory.initElements(driver, Design.class);
	}

	public Design openClose(int xCoordinate,int yCoordinate)
	{
		selectProduct(xCoordinate, yCoordinate);
		UtilHBM.waitExplicitDisplayed(driver, productDescriptionBox.get(0));
		openButton.click();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//article[@id='design-mod-properties-window-wide']/ul/li/ul/li/button[@title='Open']/span[contains(text(),'Close')]")));
		UtilHBM.reportOK("Open successful");
		openButton.click();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//article[@id='design-mod-properties-window-wide']/ul/li/ul/li/button[@title='Open']/span[contains(text(),'Close')]")));
		UtilHBM.reportOK("Close successful");
		return PageFactory.initElements(driver, Design.class);
	}

	public Design replaceProduct(String productName,int xCoordinate,int yCoordinate,String replacementProduct)
	{
		selectProduct(xCoordinate, yCoordinate);
		UtilHBM.waitExplicitDisplayed(driver, productDescriptionBox.get(0));
		editButton.click();
		UtilHBM.waitExplicitDisplayed(driver, replaceButton);
		replaceBtnClick()
		.selectProduct(replacementProduct, true);
		UtilHBM.waitExplicitDisplayed(driver, productDescriptionBox.get(0));
		UtilHBM.waitFixTime(1000);
		if(productDescriptionBox.get(0).findElement(By.cssSelector("div>h3")).getText().contains(replacementProduct))
		{
			UtilHBM.reportOK(productName+" replaced with " +replacementProduct);
		}
		else
		{
			UtilHBM.reportKO("Replacement unsuccessful");
		}
		clickBlank();
		return PageFactory.initElements(driver, Design.class);
	}
	
	public Catalog replaceBtnClick(){
		replaceButton.click();
		return PageFactory.initElements(driver, Catalog.class);
	}

	public Design deleteProduct(String productName,int xCoordinate,int yCoordinate)
	{
		selectProduct(xCoordinate, yCoordinate);
		UtilHBM.waitExplicitDisplayed(driver, productDescriptionBox.get(0));
		deleteButton.click();		
		UtilHBM.waitTillElementDisappear(driver, "#design-mod-properties-window-wide");
		UtilHBM.turnOffImplicitWaits(driver);
		UtilHBM.reportWarning("Ignore following warning about number of click to select product. This is just to confirm that the product is deleted");
		selectProduct(xCoordinate, yCoordinate);
		List<WebElement> prdDescBox=driver.findElements(By.xpath("//article[@id='design-mod-properties-window-wide']/div/h3[contains(text(),'"+productName+"')]"));
		
		if(prdDescBox.size()==0)
		{
			UtilHBM.reportOK(productName+" deleted");
		}
		else
		{
			UtilHBM.reportKO("Product not deleted");
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return PageFactory.initElements(driver, Design.class);
	}

	public Design replacementProperty(int xCoordinate,int yCoordinate,String property,String replacement, int applyAll){
		selectProduct(xCoordinate, yCoordinate);
		UtilHBM.waitExplicitDisplayed(driver, productDescriptionBox.get(0));
		editButton.click();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("li[data-ui-publicationid='"+property+"']>div>div>button[data-ui-action$='replace']")));
		driver.findElement(By.cssSelector("li[data-ui-publicationid='"+property+"']>div>div>button[data-ui-action$='replace']")).click();
		UtilHBM.turnOffImplicitWaits(driver);
		if(processingLabel.size()>0)
			UtilHBM.waitTillElementDisappear(driver, ".mod-loader>.content>span.spinner");
		UtilHBM.turnOnImplicitWaits(driver);
		WebElement newProperty;
		if(replacement.contains("/")){
			int indexOfPrd = Integer.parseInt(replacement.split("/")[1]);
			List<WebElement> newPrtyList = driver.findElements(By.xpath("//ul[@id='mod-product-list']/li/article/div/h3[@title='"+replacement.split("/")[0]+"']/../.."));
			newProperty = newPrtyList.get(indexOfPrd);
		}else{
			newProperty = driver.findElement(By.xpath("//ul[@id='mod-product-list']/li/article/div/h3[@title='"+replacement+"']/../.."));
		}
		newProperty.click();
		if (applyAll==0){
			newProperty.findElement(By.xpath("div/p/button[@class='cta-primary']")).click();
		}else if(applyAll==1){			
			newProperty.findElement(By.xpath("div/p/button[@class='cta-secondary']")).click();
		}
		UtilHBM.waitFixTime(1000);		
		backButton.click();
		UtilHBM.waitFixTime(3000);
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("li[data-ui-publicationid='"+property+"']>div>p>span.desc")));
		if(driver.findElement(By.cssSelector("li[data-ui-publicationid='"+property+"']>div>p>span.desc")).getText().contentEquals(replacement.split("/")[0]))
		{
			UtilHBM.reportOK("Property "+property+" successfully replaced by "+driver.findElement(By.cssSelector("li[data-ui-publicationid='"+property+"']>div>p>span.desc")).getText());
		}
		else
		{
			UtilHBM.reportKO("Property replacement not successful");
		}
		clickBlank();
		return PageFactory.initElements(driver, Design.class);
	}

	public Design duplicateFurniture(String productName,int xCoordinate,int yCoordinate,int dupXCoordinate,int dupYCoordinate)
	{
		selectProduct(xCoordinate, yCoordinate);
		String prdName=productDisplayName.getText().split("\n")[0];
		duplicateButton.click();
		clickBlank();
		selectProduct(dupXCoordinate, dupYCoordinate);
		if(productDescriptionBox.get(productDescriptionBox.size()-1).isDisplayed() && productDisplayName.getText().contains(prdName))
		{
			UtilHBM.reportOK("Product duplication of "+prdName+" successfully.");
		}
		else
		{
			UtilHBM.reportKO("Product duplication not successful");
		}
		clickBlank();
		UtilHBM.waitFixTime(3000);
		return PageFactory.initElements(driver, Design.class);
	}

	public Design checkCatalogFilter(String product,String filterType,int filterMeasure)
	{
		UtilHBM.waitExplicitDisplayed(driver, menuOptions.findElement(By.xpath("//button[@id='"+product.split(">")[0]+"']")));
		UtilHBM.waitFixTime(3000);
		menuOptions.findElement(By.xpath("//button[@id='"+product.split(">")[0]+"']")).click();		
		WebElement subCat=driver.findElement(By.xpath("//ul/li/ul[@data-ui-subcat='"+product.split(">")[0]+"']/li/button[contains(text(),'"+product.split(">")[1]+"')]"));
		UtilHBM.waitExplicitDisplayed(driver, subCat);
		UtilHBM.waitExplicitClickable(driver, subCat);
		subCat.click();

		Catalog catalog=PageFactory.initElements(driver, Catalog.class);
		catalog.checkFilter(filterType, filterMeasure);
		return PageFactory.initElements(driver, Design.class);
	}

	public Design positionProduct(int xcoordinate,int ycoordinate,int initialMeasure,int finalMeasure)
	{
		selectProduct(xcoordinate,ycoordinate);
		positionProduct(initialMeasure,finalMeasure);
		return PageFactory.initElements(driver, Design.class);
	}

	public Design positionProduct(int initialMeasure,int finalMeasure)
	{
		UtilHBM.waitExplicitDisplayed(driver, positionButton);
		positionButton.click();
		changeMeasure(initialMeasure, finalMeasure);
		clickBlank();
		return PageFactory.initElements(driver, Design.class);
	}

	Design clickBlank() 
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(container3D,321,-330).clickAndHold().pause(500).release().build().perform();
		return PageFactory.initElements(driver, Design.class);
	}

	public Design translateProduct(int initialxcoordinate, int intialycoordinate, int finalxcoordinate, int finalycoordinate) {
		selectProduct(initialxcoordinate, intialycoordinate);
		translateProduct(finalxcoordinate, finalycoordinate);
		return PageFactory.initElements(driver, Design.class);
	}

	public Design translateProduct(int finalxcoordinate, int finalycoordinate) {
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(translatePointer, finalxcoordinate, finalycoordinate).build().perform();
		UtilHBM.waitFixTime(3000);
		actions.moveToElement(container3D, 321, -330).clickAndHold().pause(500).release().build().perform();
		return PageFactory.initElements(driver, Design.class);
	}

	public Design elevateProduct(int xcoordinate,int ycoordinate,String positionCoordinates)
	{
		selectProduct(xcoordinate,ycoordinate);
		Actions actions=new Actions(driver);
		actions.dragAndDropBy(elevatePointer, xcoordinate, ycoordinate).build().perform();
		//		UtilHBM.waitFixTime(3000);
		actions.moveToElement(container3D,321,-330).clickAndHold().pause(500).release().build().perform();
		return PageFactory.initElements(driver, Design.class);
	}

	Design changeMeasure(int initialMeasure,int finalMeasure)
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
		return PageFactory.initElements(driver, Design.class);
	}

	Design selectProduct(int xcoordinate,int ycoordinate){	
		int i=0;
		do{
			Actions actions=new Actions(driver);
			actions.moveToElement(container3D,xcoordinate,ycoordinate).clickAndHold().pause(500).release().build().perform();
			i++;
			UtilHBM.waitFixTime(500);
		}while(!(propertiesPanel.size()>0) && i<3);
		if(i>1){
			UtilHBM.reportWarning("No. of clicks req. to select product = "+ i);
		}
		return PageFactory.initElements(driver, Design.class);
	}

	public Design verifyProduct(String productName){
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "#design-mod-properties-window-wide"));
		Verification.VerifyEquals("Product name incorrect", productInfoName.getText().replaceAll("\n", ""), productName+"More info");
		return PageFactory.initElements(driver, Design.class);
	}

	public Design closeSearchPanel() {
		UtilHBM.waitExplicitDisplayed(driver, closePanelButton);
		closePanelButton.click();
		return PageFactory.initElements(driver, Design.class);
	}


	public Design verifyProduct(int xcoordinate,int ycoordinate,String productName)
	{
		selectProduct(xcoordinate,ycoordinate);
		verifyProduct(productName);
		return PageFactory.initElements(driver, Design.class);
	}

	public Design addProduct(String productName, boolean defaultStypePrd)
	{
		String catagory=UtilHBM.getKeyValue(Setting.testDatapath + "templateEditorCatalog.data").get(productName).split(",")[1].split(">")[0];
		UtilHBM.waitExplicitDisplayed(driver, menuOptions.findElement(By.xpath("//button[@id='"+catagory+"']")));
		UtilHBM.waitFixTime(3000);
		menuOptions.findElement(By.xpath("//button[@id='"+catagory+"']")).click();
		String subCatagory=UtilHBM.getKeyValue(Setting.testDatapath + "templateEditorCatalog.data").get(productName).split(",")[1].split(">")[1];		
		WebElement subCat=driver.findElement(By.xpath("//ul/li/ul[@data-ui-subcat='"+catagory+"']/li/button[contains(text(),'"+subCatagory+"')]"));
		UtilHBM.waitExplicitDisplayed(driver, subCat);
		UtilHBM.waitExplicitClickable(driver, subCat);
		subCat.click();
		Catalog catalog=PageFactory.initElements(driver, Catalog.class);
		catalog.selectProduct(productName, defaultStypePrd);
		UtilHBM.waitFixTime(8000);
		return PageFactory.initElements(driver, Design.class);
	} 

	public Design addProductUsingSearch(String searchInput)
	{
		searchButton.click();
		searchProductInput.sendKeys(searchInput+Keys.ENTER);
		WebElement searchedProduct=driver.findElement(By.xpath("//*[@id='mod-product-list']/li/article/div/h3[contains(@title,'"+searchInput+"')]"));
		if(searchedProduct.isDisplayed())
		{
			UtilHBM.reportOK("Search for "+searchInput+" successful");
		}
		searchedProduct.click();
		return PageFactory.initElements(driver, Design.class);
	}

	public Design addProductUsingSearch(String searchInput,String uid)
	{
		searchButton.click();
		searchProductInput.sendKeys(searchInput+Keys.ENTER);
		WebElement searchedProduct=driver.findElement(By.xpath("//*[@id='mod-product-list']/li[@data-ui-id='"+uid+"']/article/div/h3[contains(@title,'"+searchInput+"')]"));
		if(searchedProduct.isDisplayed())
		{
			UtilHBM.reportOK("Search for "+searchInput+" successful");
		}
		searchedProduct.click();
		return PageFactory.initElements(driver, Design.class);
	}

	public Design addProduct(String productName,String uid)
	{
		String catagory=UtilHBM.getKeyValue(Setting.testDatapath + "templateEditorCatalog.data").get(productName).split(",")[1].split(">")[0];
		UtilHBM.waitExplicitDisplayed(driver, menuOptions.findElement(By.xpath("//button[@id='"+catagory+"']")));
		UtilHBM.waitFixTime(3000);
		menuOptions.findElement(By.xpath("//button[@id='"+catagory+"']")).click();
		String subCatagory=UtilHBM.getKeyValue(Setting.testDatapath + "templateEditorCatalog.data").get(productName).split(",")[1].split(">")[1];		
		WebElement subCat=driver.findElement(By.xpath("//ul/li/ul[@data-ui-subcat='"+catagory+"']/li/button[contains(text(),'"+subCatagory+"')]"));
		UtilHBM.waitExplicitDisplayed(driver, subCat);
		UtilHBM.waitExplicitClickable(driver, subCat);
		subCat.click();
		Catalog catalog=PageFactory.initElements(driver, Catalog.class);
		catalog.selectProduct(productName,uid);
		UtilHBM.waitFixTime(5000);
		return PageFactory.initElements(driver, Design.class);
	}

	public Design verifyDesign()
	{
		UtilHBM.waitExplicitDisplayed(driver, cabinetsLogo);
		UtilHBM.waitExplicitDisplayed(driver, title1);
		Verification.VerifyEquals("Page title not displayed", title1.getText(), "Design");
		UtilHBM.waitExplicitDisplayed(driver, subtitle1);
		Verification.VerifyEquals("Page subtitle not displayed", subtitle1.getText(), "Cabinets");
		UtilHBM.waitExplicitDisplayed(driver, subtitle2);
		Verification.VerifyEquals("Page subtitle not displayed", subtitle2.getText(), "Appliances");
		UtilHBM.waitExplicitDisplayed(driver, subtitle3);
		Verification.VerifyEquals("Page subtitle not displayed", subtitle3.getText(), "Dining");
		UtilHBM.waitExplicitDisplayed(driver, subtitle4);
		Verification.VerifyEquals("Page subtitle not displayed", subtitle4.getText(), "Kitchen extras");
		UtilHBM.waitExplicitDisplayed(driver, subtitle5);
		Verification.VerifyEquals("Page subtitle not displayed", subtitle5.getText(), "Search");
		return PageFactory.initElements(driver, Design.class);
	}
	
	static public List<String> getExistingFiles() {
		return existingFiles;
	}

	public void setExistingFiles(List<String> existingFiles) {
		Design.existingFiles = existingFiles;
	}

	public static List<String> existingFiles = new ArrayList<String>();
	
	public Design saveProject()
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
			}else if(file.getName().endsWith(".DSHBM")){
				existingFiles.add(file.getName());
			}
		}
		setExistingFiles(existingFiles);
		saveButton.click();
		UtilHBM.waitFixTime(5000);
		return PageFactory.initElements(driver, Design.class);
	}

	public Design verifyPrice(String price) {
		if (!price.isEmpty()) {
			UtilHBM.waitFixTime(4000);
			WebElement currency = driver
					.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'\u20AC')]"));
			Verification.displayOfWebElement(currency);

			String p1 = driver.findElement(By.xpath("//span[@class='standard-price ']")).getText().trim()
					.replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", "");

			System.out.println("p1:" + p1.replaceAll("\\n", "") + "price:" + price);
			System.out.println("equals :" + p1.equalsIgnoreCase(price));
			if (p1.equalsIgnoreCase(price)) {
				UtilHBM.reportOK("Design : Expected price: " + price + " SAME as actual price: " + p1);
			} else {
				UtilHBM.reportKO("Design : Expected price: " + price + " NOT SAME as actual price: " + p1);
			}

		}
		return this;
	}

}