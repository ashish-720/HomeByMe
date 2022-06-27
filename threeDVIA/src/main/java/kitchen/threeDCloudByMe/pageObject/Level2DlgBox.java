package kitchen.threeDCloudByMe.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hbm.planner.utility.UtilHBM;

public class Level2DlgBox {
	WebDriver driver;

	public Level2DlgBox(WebDriver driver) {
		this.driver=driver;
	}

	@FindBy(css="input[id='nav-search-modal']")
	WebElement searchInput;
	
	@FindBy(css="body>#modalForm>div>div>#modal-aside>ul>li>div>div.col-xs-5.modal-item-name>span")
	List<WebElement> selectDataNames;	

	@FindBy(css="div[id='productTable_processing'][style$='block;']")
	List<WebElement> processingLabel;
	
	@FindBy(css="#productTable_processing")
	WebElement processingLabelElement;
	
	@FindBy(css="#productTable_length>label>select")
	WebElement selectEntries;
	
	@FindBy(css="div[id*='DataTables_Tabl']>label>select")
	WebElement selectProductEntries;
	
	@FindBy(css="#productTable_info")
	WebElement materialInfo;
	
	@FindBy(css="div[id*='DataTables'][id$='info']")
	WebElement productInfo;
	
	@FindBy(css="#productTable>tbody>tr")
	List<WebElement> materialList;

	@FindBy(css="#modal-footer>div>#validate-button")
	WebElement validateButton;
	
	@FindBy(css="select[id='tags']+div[class*='chosen-container chosen']")
	WebElement selectTags;
	
	@FindBy(css="#tags_chosen>ul>li>input")
	WebElement selectTagsSearchInput;
	
	@FindBy(css="div.div-datatable-dashboard>div>table>tbody>tr[class$='row']")
	List<WebElement> prdList;
	
	String valueToBeSelected;

	Level1DlgBox addPossibleProducts(String possibleValueSearchString,String possibleValues)
	{
		for(int i=0;i<prdList.size();i++)
			prdList.get(i);
		searchInput.sendKeys(possibleValueSearchString+Keys.ENTER);
		UtilHBM.reportInfo("Searching for products with type "+possibleValueSearchString);
		if(processingLabel.size()>0)
		{
			UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
			UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
		}
		List<WebElement> searchProductList=driver.findElements(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr/td[4][contains(text(),'"+possibleValueSearchString+"')]"));
		for(int i=0;i<searchProductList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, searchProductList.get(i));
		int x=Integer.parseInt(productInfo.getText().split(" ")[5]);
		if(x>searchProductList.size())
		{
			new Select(selectProductEntries).selectByValue("500");
			if(processingLabel.size()>0)
			{
				UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
				UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
			}
		}
//		if(searchProductList.size()>0)
//		{
//			for(int i=0;i<searchProductList.size();i++)
//			{
//				UtilHBM.waitFixTime(1000);
//				UtilHBM.waitExplicitDisplayed(driver, searchProductList.get(i));
//			}
//			UtilHBM.reportOK(searchProductList.size()+" products found");
//		}
//		else
//			UtilHBM.reportKO(possibleValueSearchString+" not found");
		
		if(possibleValues.contains(";"))
		{
			for(String b:possibleValues.split(";"))
			{
				driver.findElement(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr/td[3][contains(text(),'"+b+"')]")).click();
			}
			for(int i=0;i<selectDataNames.size();i++)
				UtilHBM.reportOK(selectDataNames.get(i).getText()+" selected");
			searchInput.clear();
		}
		else
		{
			driver.findElement(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr/td[3][contains(text(),'"+possibleValues+"')]")).click();
			for(int i=0;i<selectDataNames.size();i++)
				UtilHBM.reportOK(selectDataNames.get(i).getText()+" selected");
		}	
		clickValidate();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}
	
	Level1DlgBox addPossibleProducts(String possibleValuesSearchInput)
	{
		for(int i=0;i<prdList.size();i++)
			prdList.get(i);
		
		
		if(possibleValuesSearchInput.contains("!"))
		{
			for(String a:possibleValuesSearchInput.split("!"))
			{				
				searchInput.sendKeys(a.split("/")[0]+Keys.ENTER);
				UtilHBM.reportInfo("Searching for products with type "+a.split("/")[0]);
				if(processingLabel.size()>0)
				{
					UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
					UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
				}
				List<WebElement> searchProductList=driver.findElements(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr/td[4][contains(text(),'"+a.split("/")[0]+"')]"));
				for(int i=0;i<searchProductList.size();i++)
					UtilHBM.waitExplicitDisplayed(driver, searchProductList.get(i));
				int x=Integer.parseInt(productInfo.getText().split(" ")[5]);
				if(x>searchProductList.size())
				{
					new Select(selectProductEntries).selectByValue("500");
				}
				if(searchProductList.size()>0)
				{
					for(int i=0;i<searchProductList.size();i++)
					{
						UtilHBM.waitExplicitDisplayed(driver, searchProductList.get(i));
					}
					UtilHBM.reportOK(searchProductList.size()+" products found");
				}
				else
					UtilHBM.reportKO(a.split("/")[0]+" not found");
				valueToBeSelected=a.split("/")[1];
				if(valueToBeSelected.contains(">"))
				{
					for(String b:valueToBeSelected.split(">"))
					{
						driver.findElement(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr/td[3][contains(text(),'"+b+"')]")).click();
					}
					for(int i=0;i<selectDataNames.size();i++)
						UtilHBM.reportOK(selectDataNames.get(i).getText()+" selected");
					searchInput.clear();
				}
				else
				{
					driver.findElement(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr/td[3][contains(text(),'"+valueToBeSelected+"')]")).click();
					for(int i=0;i<selectDataNames.size();i++)
						UtilHBM.reportOK(selectDataNames.get(i).getText()+" selected");
				}
			}			
		}
		else
		{
			for(int i=0;i<prdList.size();i++)
				prdList.get(i);
			searchInput.sendKeys(possibleValuesSearchInput.split("/")[0]+Keys.ENTER);
			UtilHBM.reportInfo("Searching for products with type "+possibleValuesSearchInput.split("/")[0]);
			if(processingLabel.size()>0)
			{
				UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
				UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
			}
			List<WebElement> searchProductList=driver.findElements(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr/td[4][contains(text(),'"+possibleValuesSearchInput.split("/")[0]+"')]"));
			for(int i=0;i<searchProductList.size();i++)
				UtilHBM.waitExplicitDisplayed(driver, searchProductList.get(i));
			int x=Integer.parseInt(productInfo.getText().split(" ")[5]);
			if(x>searchProductList.size())
			{
				new Select(selectProductEntries).selectByValue("500");
			}
			if(processingLabel.size()>0)
			{
				UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
				UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
			}
			List<WebElement> searchProductList1=driver.findElements(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr/td[4][contains(text(),'"+possibleValuesSearchInput.split("/")[0]+"')]"));
			if(searchProductList1.size()>0)
			{
				UtilHBM.reportOK(searchProductList1.size()+" products found");
			}
			else
				UtilHBM.reportKO(possibleValuesSearchInput+" not found");
			valueToBeSelected=possibleValuesSearchInput.split("/")[1];
			if(valueToBeSelected.contains(">"))
			{
				for(String b:valueToBeSelected.split(">"))
				{
					driver.findElement(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr/td[3][contains(text(),'"+b+"')]")).click();
				}
				for(int i=0;i<selectDataNames.size();i++)
					UtilHBM.reportOK(selectDataNames.get(i).getText()+" selected");
				searchInput.clear();
			}
			else
			{
				driver.findElement(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr/td[3][contains(text(),'"+valueToBeSelected+"')]")).click();
				for(int i=0;i<selectDataNames.size();i++)
					UtilHBM.reportOK(selectDataNames.get(i).getText()+" selected");
			}
		}
		clickValidate();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}
	
	Level1DlgBox addDefaultProduct(String defaultValueSearchString,String defaultValue)
	{
		for(int i=0;i<prdList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, prdList.get(i));
		searchInput.sendKeys(defaultValueSearchString+Keys.ENTER);
		UtilHBM.reportInfo("Searching for products with type "+defaultValueSearchString);
		if(processingLabel.size()>0)
		{
			UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
			UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
		}
		int x=Integer.parseInt(productInfo.getText().split(" ")[5]);
		List<WebElement> searchList=driver.findElements(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr/td[4][contains(text(),'"+defaultValueSearchString+"')]"));
		for(int i=0;i<searchList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, searchList.get(i));
		if(x>searchList.size())
		{
			new Select(selectProductEntries).selectByValue("500");
		}
		if(processingLabel.size()>0)
		{
			UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
			UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
		}
		List<WebElement> searchList1=driver.findElements(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr/td[4][contains(text(),'"+defaultValueSearchString+"')]"));
		if(searchList1.size()>0)
		{
			for(int i=0;i<searchList1.size();i++)
			{
				UtilHBM.waitExplicitDisplayed(driver, searchList1.get(i));
			}
			UtilHBM.reportOK(searchList1.size()+" products found");
		}
			
		else
			UtilHBM.reportKO(defaultValueSearchString+" not found");
		valueToBeSelected=defaultValue.split(";")[0];
		driver.findElement(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr/td[3][contains(text(),'"+valueToBeSelected+"')]")).click();
		for(int i=0;i<selectDataNames.size();i++)
			UtilHBM.reportOK(selectDataNames.get(i).getText()+" selected");
		clickValidate();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}
	
	Level1DlgBox addDefaultMaterial(String defaultMaterialSearchString,String defaultMaterial)
	{
		searchInput.sendKeys(defaultMaterialSearchString+Keys.ENTER);
		UtilHBM.reportInfo("Searching for materials with tag "+defaultMaterialSearchString);
		UtilHBM.turnOffImplicitWaits(driver);
		UtilHBM.waitFixTime(2000);
		if(processingLabel.size()>0)
		{
			UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
			UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
		}
		UtilHBM.turnOnImplicitWaits(driver);
		int x=Integer.parseInt(materialInfo.getText().split(" ")[5]);
		List<WebElement> searchMaterialList=driver.findElements(By.xpath("//*[@id='productTable']/tbody/tr/td[4]/span[contains(text(),'"+defaultMaterialSearchString+"')]"));
		for(int i=0;i<searchMaterialList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, searchMaterialList.get(i));
		if(x>searchMaterialList.size())
		{
			new Select(selectEntries).selectByValue("500");
		}
		UtilHBM.turnOffImplicitWaits(driver);
		if(processingLabel.size()>0)
		{
			UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
			UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
		}
		UtilHBM.turnOnImplicitWaits(driver);
		if(searchMaterialList.size()>0)
		{
			UtilHBM.reportOK(x+" materials found");
		}			
		else
			UtilHBM.reportKO(defaultMaterialSearchString+" not found");
		
		driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr/td[2]/span[contains(text(),'"+defaultMaterial+"')]")).click();
		for(int i=0;i<selectDataNames.size();i++)
			UtilHBM.reportOK(selectDataNames.get(i).getText()+" selected");
		clickValidate();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}
	
	Level1DlgBox addDefaultMaterial(String defaultValueSearchInput)
	{
		searchInput.sendKeys(defaultValueSearchInput.split("/")[0]+Keys.ENTER);
		UtilHBM.reportInfo("Searching for materials with tag "+defaultValueSearchInput.split("/")[0]);
		UtilHBM.turnOffImplicitWaits(driver);
		UtilHBM.waitFixTime(2000);
		if(processingLabel.size()>0)
		{
			UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
			UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
		}
		UtilHBM.turnOnImplicitWaits(driver);
		int x=Integer.parseInt(materialInfo.getText().split(" ")[5]);
		List<WebElement> searchMaterialList=driver.findElements(By.xpath("//*[@id='productTable']/tbody/tr/td[4]/span[contains(text(),'"+defaultValueSearchInput.split("/")[0]+"')]"));
		for(int i=0;i<searchMaterialList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, searchMaterialList.get(i));
		if(x>searchMaterialList.size())
		{
			new Select(selectEntries).selectByValue("500");
		}
		UtilHBM.turnOffImplicitWaits(driver);
		if(processingLabel.size()>0)
		{
			UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
			UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
		}
		UtilHBM.turnOnImplicitWaits(driver);
		if(searchMaterialList.size()>0)
		{
			UtilHBM.reportOK(x+" materials found");
		}			
		else
			UtilHBM.reportKO(defaultValueSearchInput.split("/")[0]+" not found");
		valueToBeSelected=defaultValueSearchInput.split("/")[1];
		driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr/td[2]/span[contains(text(),'"+valueToBeSelected+"')]")).click();
		for(int i=0;i<selectDataNames.size();i++)
			UtilHBM.reportOK(selectDataNames.get(i).getText()+" selected");
		clickValidate();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}
	
	Level1DlgBox addMaterialTags(String tagName)
	{		
		if(tagName.contains("/"))
		{
			UtilHBM.reportInfo("Adding tags");
			for(String a:tagName.split("/"))
			{
				selectTags.click();
				selectTagsSearchInput.sendKeys(a);
				WebElement matTag = driver.findElement(By.xpath("//div/ul/li[.='"+a+"']"));
				matTag.click();
			}
			List<WebElement> selectedTags=driver.findElements(By.cssSelector("div>ul>li>span"));
			for(int i=0;i<selectedTags.size();i++)
				UtilHBM.reportOK(selectedTags.get(i).getText()+" tag added.");
		}
		else
		{
			UtilHBM.reportInfo("Adding tags");
			for(String a:tagName.split("!"))
			{
				selectTags.click();
				selectTagsSearchInput.sendKeys(a.split("/")[0]);
				WebElement matTag = driver.findElement(By.xpath("//div/ul/li[.='"+tagName.split("/")[0]+"']"));
				matTag.click();
			}
			List<WebElement> selectedTags=driver.findElements(By.cssSelector("div>ul>li>span"));
			for(int i=0;i<selectedTags.size();i++)
				UtilHBM.reportOK(selectedTags.get(i).getText()+" tag added.");
		}
		clickValidate();
		return PageFactory.initElements(driver, Level1DlgBox.class);		
	}
	
	Level1DlgBox addTags(String possibleValuesSearchInput)
	{
		if(possibleValuesSearchInput.contains("!"))
		{
			UtilHBM.reportInfo("Adding tags");
			for(String a:possibleValuesSearchInput.split("!"))
			{
				selectTags.click();
				selectTagsSearchInput.sendKeys(a.split("/")[0]);
				WebElement matTag = driver.findElement(By.xpath("//div/ul/li[.='"+a.split("/")[0]+"']"));
				matTag.click();
			}
			List<WebElement> selectedTags=driver.findElements(By.cssSelector("div>ul>li>span"));
			for(int i=0;i<selectedTags.size();i++)
				UtilHBM.reportOK(selectedTags.get(i).getText()+" tag added.");
		}
		else
		{
			UtilHBM.reportInfo("Adding tags");
			for(String a:possibleValuesSearchInput.split("!"))
			{
				selectTags.click();
				selectTagsSearchInput.sendKeys(a.split("/")[0]);
				WebElement matTag = driver.findElement(By.xpath("//div/ul/li[.='"+possibleValuesSearchInput.split("/")[0]+"']"));
				matTag.click();
			}
			List<WebElement> selectedTags=driver.findElements(By.cssSelector("div>ul>li>span"));
			for(int i=0;i<selectedTags.size();i++)
				UtilHBM.reportOK(selectedTags.get(i).getText()+" tag added.");
		}
		clickValidate();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}
	
	Level1DlgBox addPossibleMaterials(String possibleValuesSearchString ,String possibleMaterials)
	{
		for(int i=0;i<materialList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, materialList.get(i));
		UtilHBM.turnOffImplicitWaits(driver);
		if(processingLabel.size()>0)
		{
			UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
			UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
		}
		UtilHBM.turnOnImplicitWaits(driver);
		searchInput.sendKeys(possibleValuesSearchString+Keys.ENTER);
		UtilHBM.reportInfo("Searching for materials with tag "+possibleValuesSearchString);
		UtilHBM.turnOffImplicitWaits(driver);
		if(processingLabel.size()>0)
		{
			UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
			UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
		}
		UtilHBM.turnOnImplicitWaits(driver);
		int x=Integer.parseInt(materialInfo.getText().split(" ")[5]);
		List<WebElement> searchMaterialList=driver.findElements(By.xpath("//*[@id='productTable']/tbody/tr/td[4]/span[contains(text(),'"+possibleValuesSearchString+"')]"));
		for(int i=0;i<searchMaterialList.size();i++)
		{
			UtilHBM.waitExplicitDisplayed(driver, searchMaterialList.get(i));
		}
		if(x>searchMaterialList.size())
		{
			new Select(selectEntries).selectByValue("500");
		}
		UtilHBM.turnOffImplicitWaits(driver);
		if(processingLabel.size()>0)
		{
			UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
			UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
		}
		UtilHBM.turnOnImplicitWaits(driver);
		if(searchMaterialList.size()>0)
		{
			UtilHBM.reportOK(x+" materials found");
		}			
		else
			UtilHBM.reportKO(possibleValuesSearchString+" not found");
		if(possibleMaterials.contains(";"))
		{
			for(String b:possibleMaterials.split(";"))
			{
				UtilHBM.waitFixTime(2000);
//				UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver, "//*[@id='productTable']/tbody/tr/td[2]/span[contains(text(),'"+b+"')]"));
				driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr/td[2]/span[contains(text(),'"+b+"')]")).click();
			}
			for(int i=0;i<selectDataNames.size();i++)
				UtilHBM.reportOK(selectDataNames.get(i).getText()+" selected");
			searchInput.clear();
		}
		else
		{
			driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr/td[2]/span[contains(text(),'"+possibleMaterials+"')]")).click();
			for(int i=0;i<selectDataNames.size();i++)
				UtilHBM.reportOK(selectDataNames.get(i).getText()+" selected");
		}
		clickValidate();
		return PageFactory.initElements(driver, Level1DlgBox.class);		
	}

	Level1DlgBox addPossibleMaterials(String possibleValuesSearchInput)
	{
		for(int i=0;i<materialList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, materialList.get(i));
		if(possibleValuesSearchInput.contains("!"))
		{
			for(String a:possibleValuesSearchInput.split("!"))
			{
				UtilHBM.turnOffImplicitWaits(driver);
				if(processingLabel.size()>0)
				{
					UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
					UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
				}
				UtilHBM.turnOnImplicitWaits(driver);
				searchInput.sendKeys(a.split("/")[0]+Keys.ENTER);
				UtilHBM.reportInfo("Searching for materials with tag "+a.split("/")[0]);
				UtilHBM.turnOffImplicitWaits(driver);
				if(processingLabel.size()>0)
				{
					UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
					UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
				}
				UtilHBM.turnOnImplicitWaits(driver);
				int x=Integer.parseInt(materialInfo.getText().split(" ")[5]);
				List<WebElement> searchMaterialList=driver.findElements(By.xpath("//*[@id='productTable']/tbody/tr/td[4]/span[contains(text(),'"+a.split("/")[0]+"')]"));
				for(int i=0;i<searchMaterialList.size();i++)
				{
					UtilHBM.waitExplicitDisplayed(driver, searchMaterialList.get(i));
				}
				if(x>searchMaterialList.size())
				{
					new Select(selectEntries).selectByValue("500");
				}
				UtilHBM.turnOffImplicitWaits(driver);
				if(processingLabel.size()>0)
				{
					UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
					UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
				}
				UtilHBM.turnOnImplicitWaits(driver);
				if(searchMaterialList.size()>0)
				{
					UtilHBM.reportOK(x+" materials found");
				}			
				else
					UtilHBM.reportKO(a.split("/")[0]+" not found");
				valueToBeSelected=a.split("/")[1];
				if(valueToBeSelected.contains(">"))
				{
					for(String b:valueToBeSelected.split(">"))
					{
						driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr/td[2]/span[contains(text(),'"+b+"')]")).click();
					}
					for(int i=0;i<selectDataNames.size();i++)
						UtilHBM.reportOK(selectDataNames.get(i).getText()+" selected");
					searchInput.clear();
				}
				else
				{
					driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr/td[2]/span[contains(text(),'"+valueToBeSelected+"')]")).click();
					for(int i=0;i<selectDataNames.size();i++)
						UtilHBM.reportOK(selectDataNames.get(i).getText()+" selected");
				}
			}
			
		}
		else
		{
			UtilHBM.turnOffImplicitWaits(driver);
			if(processingLabel.size()>0)
			{
				UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
				UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
			}
			UtilHBM.turnOnImplicitWaits(driver);
			UtilHBM.reportInfo("Searching for materials with tag "+possibleValuesSearchInput.split("/")[0]);
			searchInput.sendKeys(possibleValuesSearchInput.split("/")[0]+Keys.ENTER);
			UtilHBM.turnOffImplicitWaits(driver);
			if(processingLabel.size()>0)
			{
				UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
				UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
			}
			UtilHBM.turnOnImplicitWaits(driver);
			int x=Integer.parseInt(materialInfo.getText().split(" ")[5]);
			List<WebElement> searchMaterialList=driver.findElements(By.xpath("//*[@id='productTable']/tbody/tr/td[4]/span[contains(text(),'"+possibleValuesSearchInput.split("/")[0]+"')]"));
			for(int i=0;i<searchMaterialList.size();i++)
				UtilHBM.waitExplicitDisplayed(driver, searchMaterialList.get(i));
			if(x>searchMaterialList.size())
			{
				new Select(selectEntries).selectByValue("500");
			}
			UtilHBM.turnOffImplicitWaits(driver);
			if(processingLabel.size()>0)
			{
				UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
				UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
			}
			UtilHBM.turnOnImplicitWaits(driver);
			if(searchMaterialList.size()>0)
			{
				UtilHBM.reportOK(x+" materials found");
			}
			else
				UtilHBM.reportKO(possibleValuesSearchInput+" not found");
			valueToBeSelected=possibleValuesSearchInput.split("/")[1];
			if(valueToBeSelected.contains(">"))
			{
				for(String b:valueToBeSelected.split(">"))
				{
					driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr/td[2]/span[contains(text(),'"+b+"')]")).click();
				}
				for(int i=0;i<selectDataNames.size();i++)
					UtilHBM.reportOK(selectDataNames.get(i).getText()+" selected");
				searchInput.clear();
			}
			else
			{
				driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr/td[2]/span[contains(text(),'"+valueToBeSelected+"')]")).click();
				for(int i=0;i<selectDataNames.size();i++)
					UtilHBM.reportOK(selectDataNames.get(i).getText()+" selected");
			}
		}
		clickValidate();
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}
	
	Level1DlgBox clickValidate()
	{
		validateButton.click();
		UtilHBM.waitTillElementDisappear(driver, "#validate-button");
		driver.switchTo().defaultContent();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}
	
}
