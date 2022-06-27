package kitchen.threeDCloudByMe.pageObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class Content {
	WebDriver driver;

	public Content(WebDriver driver) {
		this.driver=driver;	
	}

	@FindBy(css="div.div-datatable-dashboard>div>table>tbody>tr[class$='row']")
	private List<WebElement> prdList;

	@FindBy(css="a[id='logout-link']")
	private WebElement logoutButton;

	@FindBy(css="a[href='/en/product/add']")
	private WebElement newProduct;
	
	@FindBy(css="a[href='/en/product/add']")
	private List<WebElement> newProductButtonList;

	@FindBy(css="a[href='/en/dashboard/catalog']")
	private WebElement productCatalogs;

	@FindBy(css="a[href='/en/dashboard/catalog/add']")
	private WebElement newCatalogButton;

	@FindBy(css="div.content-header>div>div>a[href='/en/dashboard']")
	private WebElement productsTab;

	@FindBy(css="a[class*='btn btn-primary']")
	private WebElement createNewFamily;

	@FindBy(css="a[href='/en/dashboard/family']")
	private WebElement families;

	@FindBy(css="#nav-search")
	private WebElement searchInput;
	
	@FindBy (css="button[data-selector='search-reset-btn']")
	private WebElement resetSearchButton;

	@FindBy (css = "button.search-btn[data-selector='search-validate-btn']")
	WebElement searchBtn;

	@FindBy(css="#button-delete-rule")
	private WebElement deleteAppRuleButton;

	@FindBy(css="#table_catalogs>tbody>tr")
	private List<WebElement> catalogList;

	@FindBy(css="#button-delete-catalog")
	private WebElement deleteCatalogButton;

	@FindBy(css="#button-delete-family")
	private WebElement deleteFamilyButton;

	@FindBy(css="#table_catalogs_info")
	private WebElement all_Catalog_count;

	@FindBy(css="#table_families_info")
	private WebElement all_Family_count;

	@FindBy(css="table[class='datatable datatable-dashboard hover dataTable no-footer']>tbody>tr")
	private List<WebElement> list;

	@FindBy(css="div.div-datatable-dashboard>div>table>tbody>tr")
	private List<WebElement> productList;

	@FindBy(css="div.div-datatable-dashboard>div>div>div[id*='DataTables_Table_'][id$='_info']")
	private WebElement allPrdInfo;

	@FindBy(css="#button-delete-product")
	private WebElement deleteProductButton;

	@FindBy(css = "#product-options-dropdown")
	private WebElement moreOptionsButton;

	@FindBy(xpath = "//*[@id='product-options-dropdown']/ul[@data-ui-id='options-dropdown' and @aria-hidden='false']/li/span[text()='Share your 3D by link']")
	private WebElement share3DByLinkOption;

	@FindBy(css="a[href='/en/dashboard/material']")
	private WebElement materialsPage;

	@FindBy(css="a[href='/en/admin/dashboards']")
	private WebElement dashboardButton;

	@FindBy(css="div>a[href='/en/admin/users']")
	private WebElement statsButton;

	@FindBy(css="a[href='/en/material/add']")
	private WebElement newMaterialButton;

	@FindBy(css=".mod-notification>.success.show")
	private WebElement successMsg;

	@FindBy(css="#button-delete-material")
	private WebElement deleteMaterialButton;

	@FindBy(css="#table_materials_info")
	private WebElement allMatInfo;

	@FindBy(css="select[name='table_materials_length']")
	private WebElement selectEntries;

	@FindBy(id="table_materials_next")
	private WebElement paginateNextBtn;

	@FindBy(css="div>div>table>tbody>tr")
	private List<WebElement> materialList;

	@FindBy(css="div[id='productTable_processing'][style$='block;']")
	private List<WebElement> processingLabel;

	@FindBy(css="div.dataTables_processing")
	private WebElement processing;

	@FindBy(css="#button-generate-viewer")
	private WebElement optionsButton;
	
	@FindBy(css="ul[data-ui-id='options-dropdown']>li.open-embed")
	private WebElement embedLinkButton;
	
	@FindBy(css="#productTable_processing")
	private WebElement processingLabelElement;

	@FindBy(css="div.side-nav-items.expander-group-body>div>a[href='/en/dashboard/template']")
	private WebElement templatePage;

	@FindBy(css="a[href='/en/template/add']")
	private WebElement newTemplateButton;

	@FindBy(css="a[href='/en/dashboard/templates_catalog']")
	private WebElement templateCatalogButton;

	@FindBy(css="a[href='/en/dashboard/templates_catalog/add']")
	private WebElement newTemplateCatalogButton;

	@FindBy(css="a[href='/en/dashboard/templates_catalog']")
	private WebElement templatesCatalogs;

	@FindBy(css="a[href='/en/dashboard/applicativerule']")
	private WebElement applicativeRules;

	@FindBy(css = "a[href='/en/admin/applicationDistributions")
	private WebElement appSettings;

	@FindBy(css="div>#table_rules>tbody>tr")
	private List<WebElement> applicativeRuleList;

	@FindBy(css="a[href='/en/applicative-rule/add']")
	private WebElement newApplicativeRuleButton;

	@FindBy(css="a[href='/en/dashboard/applicative_rules_catalog']")
	private WebElement applicativeRulesCatalogs;

	@FindBy(css="a[href='/en/dashboard/applicative_rules_catalog/add']")
	private WebElement newAppRuleCatalogButton;

	@FindBy(css="#button-delete-template")
	private WebElement deleteButton;

	@FindBy(css="#table_templates_info")
	private WebElement templateInfo;

	@FindBy(xpath="//div/table/tbody/tr")
	private List<WebElement> templateList;

	@FindBy(css="#table_catalogs_info")
	private WebElement appRuleCatalogInfo;

	@FindBy(css="#table_catalogs_info")
	private WebElement templateCatalogList;

	@FindBy(css="#button-delete-catalog")
	private WebElement templateCatalogDeleteButton;

	@FindBy(css="a[href='/en/dashboard/rule']")
	private WebElement productRules;

	@FindBy(css="a[href='/en/rule/add']")
	private WebElement newRuleButton;

	@FindBy(css="a[href='/en/admin/tags']")
	private WebElement tags;

	@FindBy(css="#table_catalogs>tbody>tr")
	private List<WebElement> appRuleCatalogList;

	@FindBy(css="a[href='/en/admin/types']")
	private WebElement types;

	@FindBy(css="a[href='/en/admin/legalEntities']")
	private WebElement legalEntities;

	@FindBy(css="a[href='/en/admin/brands']")
	private WebElement brands;

	@FindBy(css="a[href='/en/editor']")
	private WebElement threeDToolsButton;
	
	@FindBy(css="#table_rules_info")
	private WebElement appRuleInfo;

	@FindBy(xpath="//div/table/tbody/tr")
	private List<WebElement> appRuleList;

	@FindBy(css="aside>div>div>div>a>label")
	private List<WebElement> sidePanel;

	@FindBy(css="label[class='side-nav-category-label']")
	private List<WebElement> sidePanelMain;

	@FindBy(css="div.content-header>div>div>a[href='/en/dashboard']>label")
	private WebElement pageSubHeader12;

	@FindBy(css="div.content-header>div>div>a[href='/en/dashboard/catalog']>label")
	private WebElement pageSubHeader13;

	@FindBy(css="div.content-header>div>div>a[href='/en/dashboard/family']>label")
	private WebElement pageSubHeader14;

	@FindBy(css="div.div-datatable-dashboard>div>table>thead>tr>th[aria-label*='Name']")
	private WebElement colomnHeader1;

	@FindBy(css="div.div-datatable-dashboard>div>table>thead>tr>th[aria-label*='Reference']")
	private WebElement colomnHeader2;

	@FindBy(css="div.div-datatable-dashboard>div>table>thead>tr>th[aria-label*='Type']")
	private WebElement colomnHeader3;

	@FindBy(css="div.div-datatable-dashboard>div>table>thead>tr>th[aria-label*='Catalogs']")
	private WebElement colomnHeader4;

	@FindBy(css="div.div-datatable-dashboard>div>table>thead>tr>th[aria-label*='Start date']")
	private WebElement colomnHeader5;

	@FindBy(css="div.div-datatable-dashboard>div>table>thead>tr>th[aria-label*='End date']")
	private WebElement colomnHeader6;

	@FindBy(css="div.div-datatable-dashboard>div>table>thead>tr>th[aria-label*='3d model']")
	private WebElement colomnHeader7;

	@FindBy(css="div.div-datatable-dashboard>div>table>thead>tr>th[aria-label*='Override']")
	private WebElement colomnHeader8;

	@FindBy(css="div.div-datatable-dashboard>div>table>thead>tr>th[aria-label*='Last update']")
	private WebElement colomnHeader9;

	@FindBy(css="div.div-datatable-dashboard>div>table>thead>tr>th[aria-label*='Products']")
	private WebElement colomnHeader10;

	@FindBy(css="a>span")
	private WebElement button1;

	@FindBy(css="aside.side-nav>div>div>div>a[href='/en/admin/sandbox']")
	private WebElement stagingButton;

	@FindBy(css="aside.side-nav div.side-nav-category a[href='/beta/#1']")
	private WebElement threeDCloudBeta;
	
	public Content verifyFamily(String familyName,String role,int noOfPrd)
	{
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		searchInput.sendKeys(familyName+"_family_"+role+"_"+s+Keys.ENTER);
		Verification.elementContainsString(UtilHBM.webElement(driver, "#table_families>tbody>tr>td:nth-child(2)"), familyName+"_family_"+role+"_"+s, "Family name ");
		Verification.VerifyEquals("No of products incorrect",UtilHBM.webElementXPath(driver, "//*[@id='table_families']/tbody/tr[contains(@data-name,'"+familyName+"_family_"+role+"_"+s+"')]/td[3]").getText() , String.valueOf(noOfPrd));
		return PageFactory.initElements(driver, Content.class);
	}
	
	public Synchronization goToSandboxPage()
	{
		stagingButton.click();
		return PageFactory.initElements(driver, Synchronization.class);
	}
	
	public Material openMaterial(String tagName,String materialName,String role)
	{
		for(int i=0;i<materialList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, materialList.get(i));
		searchInput.sendKeys(tagName+Keys.ENTER);
		UtilHBM.turnOffImplicitWaits(driver);
		if(processingLabel.size()>0)
		{
			UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
			UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
		}
		UtilHBM.turnOnImplicitWaits(driver);
		List<WebElement> searchedMaterials=driver.findElements(By.xpath("//div/div/table/tbody/tr/td[4]/span[contains(text(),'"+tagName+"')]"));
		for(int i=0;i<searchedMaterials.size();i++)
		{
			UtilHBM.waitExplicitDisplayed(driver, searchedMaterials.get(i));
		}
		int x=Integer.parseInt(allMatInfo.getText().split(" ")[5].replace(",", ""));
		if(x>100)
		{
			new Select(selectEntries).selectByValue("500");
		}
		openSearchedMaterial(materialName,role);
		return PageFactory.initElements(driver, Material.class);
	}
	
	public Content verifyDeletedDate(String catalogName,String role)
	{
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		searchInput.sendKeys(catalogName+"_"+role+"_"+s+Keys.ENTER);
		WebElement searchedCatalog= driver.findElement(By.xpath("//*[@id='table_catalogs']/tbody/tr[contains(@data-name,'"+catalogName+"_"+role+"_"+s+"')]"));
		UtilHBM.waitExplicitDisplayed(driver,searchedCatalog);
		Verification.VerifyEquals("Date not deleted", searchedCatalog.findElement(By.xpath("td[4]")).getText(), "");
		Verification.VerifyEquals("Date not deleted", searchedCatalog.findElement(By.xpath("td[5]")).getText(), "");
		return PageFactory.initElements(driver, Content.class);
	}
	
	public Content verifySuccess()
	{
		UtilHBM.waitExplicitDisplayed(driver, successMsg);
		UtilHBM.reportOK(successMsg.getText());
		return PageFactory.initElements(driver, Content.class);
	}
	
	public Content verifyShareLink(String productName)
	{
		optionsButton.click();
		embedLinkButton.click();
		Level1DlgBox level1DlgBox=PageFactory.initElements(driver, Level1DlgBox.class);
		level1DlgBox.verifyShareLink(productName);
		UtilHBM.waitFixTime(1000);
		logout();
		verifyShareLinkWhenUserLoggedOut(level1DlgBox.getEmbedLink());
		return PageFactory.initElements(driver, Content.class);
	}

	Content verifyShareLinkWhenUserLoggedOut(String embedLink){
		driver.get(embedLink);
		driver.switchTo().frame(UtilHBM.webElement(driver, "#product-viewer-iframe"));
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".canvas-tools-help-tooltip"));
		Verification.displayNAttributeCheckOfElementExcludeLineBreak(UtilHBM.webElement(driver, ".canvas-tools-help-tooltip"), "Tool tip msg", "text", "Click and drag to move the viewpoint");
		driver.navigate().back();
		return PageFactory.initElements(driver, Content.class);
	}
	
	public Content selectProduct(String productName,String role)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(processingLabel.size()>0)
		{
			UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
			UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
		}
		UtilHBM.turnOnImplicitWaits(driver);
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		searchInput.sendKeys(productName+"_"+role+"_"+s+"*"+Keys.ENTER);
		if(processingLabel.size()>0)
		{
			UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
			UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
		}
		List<WebElement> searchedProducts=driver.findElements(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr[contains(@data-name,'"+productName+"_"+role+"')]/td[2]/parent::tr/td[1]"));
		searchedProducts.get(0).click();
		return PageFactory.initElements(driver, Content.class);
	}
	
	public Content pageVerification(String role,String cloudType)
	{
		ArrayList<String> sidePanelList=new ArrayList<String>();
		ArrayList<String> sidePanelMainList=new ArrayList<String>();
		ArrayList<String> verifyList=new ArrayList<String>();
		for(String a:UtilHBM.getProperty(cloudType+"Cloud", role+"Sub").split(","))
		{
			verifyList.add(a);
		}
		for(String a:UtilHBM.getProperty(cloudType+"Cloud", role+"Main").split(","))
		{
			verifyList.add(a);
		}
		for(int i=0;i<sidePanel.size();i++)
		{
			sidePanelList.add(sidePanel.get(i).getText());
		}
		for(int i=0;i<sidePanelList.size();i++)
		{
			for(int j=0;j<verifyList.size();j++)
			{
				if(sidePanelList.get(i).contentEquals(verifyList.get(j)))
				{
					Verification.VerifyEquals("Text not displayed", sidePanelList.get(i), verifyList.get(j));
					break;
				}
				else
				{
					if(j==verifyList.size()-1)
					{
						UtilHBM.reportKO(sidePanelList.get(i)+" invalid menu in side panel");
					}
				}
			}
		}

		for(int i=0;i<sidePanelMain.size();i++)
		{
			sidePanelMainList.add(sidePanelMain.get(i).getText());
		}
		for(int i=0;i<sidePanelMainList.size();i++)
		{
			for(int j=0;j<verifyList.size();j++)
			{
				if(sidePanelMainList.get(i).contentEquals(verifyList.get(j)))
				{
					Verification.VerifyEquals("Text not displayed", sidePanelMainList.get(i), verifyList.get(j));
					break;
				}
				else
				{
					if(j==verifyList.size()-1)
					{
						UtilHBM.reportKO(sidePanelMainList.get(i)+" invalid menu in side panel");
					}
				}
			}
		}
		Verification.VerifyEquals("Page sub-header not displayed", "Products", pageSubHeader12.getText());
		Verification.VerifyEquals("Page sub-header not displayed", "Products catalogs", pageSubHeader13.getText());
		Verification.VerifyEquals("Page sub-header not displayed", "Families", pageSubHeader14.getText());
//		Verification.VerifyEquals("Button name not displayed", "NEW PRODUCT", button1.getText());
		Verification.VerifyEquals("Page Colomn header not displayed", "Name", colomnHeader1.getText());
		Verification.VerifyEquals("Page Colomn header not displayed", "Reference", colomnHeader2.getText());
		Verification.VerifyEquals("Page Colomn header not displayed", "Type", colomnHeader3.getText());
		Verification.VerifyEquals("Page Colomn header not displayed", "Catalogs", colomnHeader4.getText());
		Verification.VerifyEquals("Page Colomn header not displayed", "Start date", colomnHeader5.getText());
		Verification.VerifyEquals("Page Colomn header not displayed", "End date", colomnHeader6.getText());
		Verification.VerifyEquals("Page Colomn header not displayed", "3d model", colomnHeader7.getText());
		Verification.VerifyEquals("Page Colomn header not displayed", "Override", colomnHeader8.getText());
		Verification.VerifyEquals("Page Colomn header not displayed", "Last update", colomnHeader9.getText());

		return PageFactory.initElements(driver, Content.class);
	}
	
	public Content productVerification(String productName,String cloudType,String productType,String role)
	{
		for(int i=0;i<productList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, productList.get(i));
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		String prdName = productName+"_"+role+"_"+s;
//		searchInput.sendKeys(productName+"_"+role+"_"+s+"*"+Keys.ENTER);
		if(processingLabel.size()>0)
		{
			UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
			UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
		}
		List<WebElement> we;
		if(UtilHBM.webElement(driver, ".div-datatable-search").getAttribute("class").contains("hide")){
			we=driver.findElements(By.xpath("//div[@class='div-datatable-dashboard']/div/table/tbody/tr[contains(@data-name,'"+prdName+"')]"));
		}else{
			we=driver.findElements(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr[contains(@data-name,'"+prdName+"')]"));
		}
//		List<WebElement> we=driver.findElements(By.xpath("//div/table/tbody/tr[contains(@data-name,'"+productName+"_"+role+"_"+s+"')]"));
		System.out.println("1");
		System.out.println(we.size());
		for(int i=0;i<we.size();i++)
		{
			System.out.println("2");
			WebElement threeDModelLabel=we.get(i).findElement(By.xpath("//td/div[@class='model_3d_available']"));
			UtilHBM.waitExplicitDisplayed(driver, threeDModelLabel);
			Verification.VerifyEquals("3D model not available", threeDModelLabel.getText(), "Yes");
//			UtilHBM.reportOK("3dModel for "+we.get(i).getAttribute("data-ref")+" present");
			Verification.VerifyEquals("Product Name incorrect", we.get(i).getAttribute("data-name"), productName+"_"+role+"_"+s);
			if(we.get(i).findElement(By.xpath("td[3]")).getText().contains(productName+"_"+role+"_ref_"+s))
			{
				UtilHBM.reportOK("Product reference verified");
			}
			else
			{
				UtilHBM.reportKO("Product reference incorrect");
			}
//			Verification.elementContainsString(we.get(i).findElement(By.xpath("td[3]")), productName+"_ref_"+role+"_"+s, "Product reference ");
//			Verification.VerifyEquals("Product Reference incorrect", we.get(i).getAttribute("data-ref"), productName+"_ref_"+role+"_"+s1);
			Verification.VerifyEquals("Product type incorrect", we.get(i).findElement(By.xpath("td[4]")).getText(), productType);
		}
		System.out.println("3");
//		searchInput.clear();
//		searchInput.sendKeys(Keys.ENTER);
		return PageFactory.initElements(driver, Content.class);
	}

	

	public Login3DCloudByMe logout()
	{		
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver,logoutButton);
		logoutButton.click();
		Login3DCloudByMe login3dCloudByMe=PageFactory.initElements(driver, Login3DCloudByMe.class);
		login3dCloudByMe.verifyLogout();
		return PageFactory.initElements(driver, Login3DCloudByMe.class);
	}

	public Content deleteAppRule(String ruleName)
	{
		for(int i=0;i<appRuleList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, appRuleList.get(i));
		int x=Integer.parseInt(appRuleInfo.getText().split(" ")[5]);
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		searchInput.sendKeys(ruleName+"_"+s+Keys.ENTER);
		List<WebElement> searchedAppRule=driver.findElements(By.xpath("//div/table/tbody/tr[contains(@data-name,'"+ruleName+"_"+s+"')]"));
		if(searchedAppRule.size()>0)
		{
			for(int i=0;i<searchedAppRule.size();i++)
			{
				UtilHBM.waitExplicitDisplayed(driver, searchedAppRule.get(i));
				UtilHBM.reportOK("Applicative rules to be deleted:"+driver.findElements(By.xpath("//div/table/tbody/tr[contains(@data-name,'"+ruleName+"_"+s+"')]/td[2]")).get(i).getText());			
			}
		}
		else
		{
			UtilHBM.reportKO("No applicative rule found");
			return this;
		}
		List<WebElement> selectedElements=driver.findElements(By.xpath("//div/table/tbody/tr[contains(@data-name,'"+ruleName+"_"+s+"')]/td/label"));
		for(int i=0;i<selectedElements.size();i++)
			selectedElements.get(i).click();
		clickAppRuleDeleteButton()
		.clickConfirmDelete();
		UtilHBM.waitFixTime(3000);
		int y=Integer.parseInt(appRuleInfo.getText().split(" ")[5]);
		if(x-searchedAppRule.size()==y)
		{
			UtilHBM.reportOK(searchedAppRule.size()+" Applicative rules deleted");
		}
		else
		{
			UtilHBM.reportKO("Applicative rules not deleted");
		}
		return PageFactory.initElements(driver, Content.class);
	}

	Level1DlgBox clickAppRuleDeleteButton()
	{
		deleteAppRuleButton.click();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}
	public Brands goToBrands()
	{
		brands.click();
		return PageFactory.initElements(driver, Brands.class);
	}
	
	public ThreeDTools goTo3dTools()
	{
		threeDToolsButton.sendKeys(Keys.ENTER);
		return PageFactory.initElements(driver, ThreeDTools.class);
	}

	public LegalEntities goToLegalEntities()
	{
		legalEntities.click();
		return PageFactory.initElements(driver, LegalEntities.class);
	}

	public Types goToTypes()
	{
		types.click();
		return PageFactory.initElements(driver, Types.class);
	}

	public Tags goToTags()
	{
		tags.click();
		return PageFactory.initElements(driver, Tags.class);
	}


	public Content deleteApplicativeRuleCatalog(String catalogName)
	{
		clickApplicativeRuleCatalog();
		for(int i=0;i<appRuleCatalogList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, appRuleCatalogList.get(i));
		int x=Integer.parseInt(appRuleCatalogInfo.getText().split(" ")[5]);
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		searchInput.sendKeys(catalogName+"_"+s+Keys.ENTER);
		List<WebElement> searchedCatalog=driver.findElements(By.xpath("//table/tbody/tr[contains(@data-name,'"+catalogName+"_"+s+"')]"));
		if(searchedCatalog.size()>0)
		{
			for(int i=0;i<searchedCatalog.size();i++)
			{
				UtilHBM.waitExplicitDisplayed(driver, searchedCatalog.get(i));
				UtilHBM.reportOK("Catalogs to be deleted:"+searchedCatalog.get(i).findElement(By.xpath("td[2]")).getText());
				searchedCatalog.get(i).findElement(By.xpath("td/label")).click();
			}
		}
		else
		{
			UtilHBM.reportKO("No catalogs found");
			return PageFactory.initElements(driver, Content.class);
		}
		clickDeleteCatalogButton()
		.clickConfirmDelete();
		UtilHBM.waitFixTime(3000);
		int y=Integer.parseInt(appRuleCatalogInfo.getText().split(" ")[5]);
		if(x-searchedCatalog.size()==y)
		{
			UtilHBM.reportOK(searchedCatalog.size()+" catalogs deleted");
		}
		else
			UtilHBM.reportKO("Catalogs not deleted");
		return PageFactory.initElements(driver, Content.class);
	}



	public Content createProductRule(String productRule)
	{
		clickNewProductRule()
		.createNewProductRule(productRule);
		return PageFactory.initElements(driver, Content.class);
	}

	public  Product verifyProductBrand(String brandName)
	{
		if(driver.findElement(By.cssSelector("#product_brand>option")).getText().equalsIgnoreCase(brandName))
		{
			UtilHBM.reportOK("Product brand verified :"+brandName);
		}
		else
			UtilHBM.reportKO("Incorrect product brand");
		return PageFactory.initElements(driver, Product.class);
	}

	public Product openProduct()
	{
		productList.get(0).click();
		return PageFactory.initElements(driver, Product.class);
	}

	ProductRules clickNewProductRule()
	{
		newRuleButton.click();
		return PageFactory.initElements(driver, ProductRules.class);
	}
	public Content goToProductRules()
	{
		productRules.click();
		return PageFactory.initElements(driver, Content.class);
	}
	public Content deleteTemplateCatalog(String catalogName)
	{
		gotoTemplateCatalog();
		for(int i=0;i<templateList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, templateList.get(i));
		int x=Integer.parseInt(templateCatalogList.getText().split(" ")[5]);
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		searchInput.sendKeys(catalogName+"_"+s+Keys.ENTER);
		List<WebElement> searchedCatalog=driver.findElements(By.xpath("//div/table/tbody/tr/td[2][starts-with(text(),'"+catalogName+"_"+s+"')]"));
		int y=searchedCatalog.size();
		for(int i=0;i<searchedCatalog.size();i++)
		{
			UtilHBM.waitExplicitDisplayed(driver, searchedCatalog.get(i));
			UtilHBM.reportOK("Template catalogs to be deleted:"+searchedCatalog.get(i).getText());
		}

		List<WebElement> selectList=driver.findElements(By.xpath("//div/table/tbody/tr[contains(@data-name,'"+catalogName+"_"+s+"')]/td/label"));
		for(int i=0;i<selectList.size();i++)
			selectList.get(i).click();

		clickDeleteTemplateCatalogButton()
		.clickDeleteButton();
		UtilHBM.waitFixTime(3000);
		int z=Integer.parseInt(templateCatalogList.getText().split(" ")[5]);
		if(z==(x-y))
		{
			UtilHBM.reportOK(y+" template catalogs deleted");
		}
		else
			UtilHBM.reportKO("Template catalogs not deleted");
		return PageFactory.initElements(driver, Content.class);
	}

	Level1DlgBox clickDeleteTemplateCatalogButton()
	{
		templateCatalogDeleteButton.click();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}

	public Stats goToStatsPage()
	{
		statsButton.click();
		return PageFactory.initElements(driver, Stats.class);
	}

	public Content deleteTemplate(String templateName)
	{
		for(int i=0;i<templateList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, templateList.get(i));
		int x=Integer.parseInt(templateInfo.getText().split(" ")[5]);
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		searchInput.sendKeys(templateName+"_"+s+Keys.ENTER);
		List<WebElement> searchedTemplates=driver.findElements(By.xpath("//div/table/tbody/tr/td[2][starts-with(text(),'"+templateName+"_"+s+"')]"));
		int z=searchedTemplates.size();
		for(int i=0;i<searchedTemplates.size();i++)
		{
			UtilHBM.waitExplicitDisplayed(driver, searchedTemplates.get(i));
			UtilHBM.reportOK("Templates to be deleted:"+searchedTemplates.get(i).getText());
		}
		List<WebElement> selectList=driver.findElements(By.xpath("//div/table/tbody/tr[contains(@data-name,'"+templateName+"_"+s+"')]/td/label"));
		for(int i=0;i<selectList.size();i++)
			selectList.get(i).click();
		clickDeleteTemplateButton()
		.clickDeleteButton();
		UtilHBM.waitFixTime(3000);
		int y=Integer.parseInt(templateInfo.getText().split(" ")[5]);
		if(y==(x-z))
			for(int i=0;i<searchedTemplates.size();i++)
				UtilHBM.reportOK(z+" templates deleted");
		else
			UtilHBM.reportKO("Templates not deleted");
		return this;
	}

	Level1DlgBox clickDeleteTemplateButton()
	{
		deleteButton.click();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}

	public Content createAppRuleCatalog(String catalogName,String appDistribution,String appRuleName)
	{
		clickApplicativeRuleCatalog()
		.clickAppRuleNewCatalog()
		.createAppRuleCatalog(catalogName, appDistribution, appRuleName);
		return this;
	}

	ApplicativeRulesCatalog clickAppRuleNewCatalog()
	{
		newAppRuleCatalogButton.click();
		return PageFactory.initElements(driver, ApplicativeRulesCatalog.class);
	}

	Content  clickApplicativeRuleCatalog()
	{
		applicativeRulesCatalogs.click();
		return this;
	}

	public Content createNewApplicativeRule(String appRuleName,String ruleName,String criticity,String parameters)
	{
		for(int i=0;i<applicativeRuleList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, applicativeRuleList.get(i));
		clickNewApplicativeRule()
		.createApplicativeRule(appRuleName, ruleName, criticity, parameters);
		for(int i=0;i<applicativeRuleList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, applicativeRuleList.get(i));
		return PageFactory.initElements(driver, Content.class);
	}

	ApplicativeRule clickNewApplicativeRule()
	{
		newApplicativeRuleButton.click();
		return PageFactory.initElements(driver, ApplicativeRule.class);
	}

	public Content goToApplicativeRulesPage()
	{
		applicativeRules.click();
		return this;
	}

	public AppSettings goToAppSettings() {
		appSettings.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, AppSettings.class);
	}

	Content goToTemplateCatalogPage()
	{
		templateCatalogButton.click();
		return this;
	}

	TemplateCatalog clickNewCatalog()
	{
		newTemplateCatalogButton.click();
		return PageFactory.initElements(driver, TemplateCatalog.class);
	}

	public Content createTemplateCatalog(String catalogName,String appDist,String templateName)
	{
		gotoTemplateCatalog()
		.clickNewCatalog()
		.createCatalog(catalogName, appDist, templateName);		
		return PageFactory.initElements(driver, Content.class);
	}

	Content gotoTemplateCatalog()
	{
		templatesCatalogs.click();
		return PageFactory.initElements(driver, Content.class);
	}

	public Content createTemplate(String templateName, String brand)
	{
		clickNewTemplate()
		.createTemplate(templateName, brand);
		return PageFactory.initElements(driver, Content.class);
	}

	Templates clickNewTemplate()
	{
		newTemplateButton.click();
		return PageFactory.initElements(driver, Templates.class);
	}

	public Content goToTemplatesPage()
	{
		templatePage.click();
		return PageFactory.initElements(driver, Content.class);
	}


	Material openSearchedMaterial(String materialName,String role)
	{
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		driver.findElement(By.xpath("//div[@id='table_materials_wrapper']/table/tbody/tr[contains(@data-name,'"+materialName+"_"+role+"_"+s+"')]")).click();
		return PageFactory.initElements(driver, Material.class);
	}
	
	public Content searchProduct(String productName,String role)
	{
		for(int i=0;i<productList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, productList.get(i));
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		searchInput.sendKeys(productName+"_"+role+"_"+s+"*"+Keys.ENTER);
		if(processingLabel.size()>0)
		{
			UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
			UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
		}
		List<WebElement> we=driver.findElements(By.xpath("//div/table/tbody/tr[contains(@data-name,'"+productName+"_"+role+"')]"));
		if(we.size()>0)
		{
			for(int i=0;i<we.size();i++)
			{
				UtilHBM.waitExplicitDisplayed(driver, we.get(i));
			}	
			UtilHBM.reportOK(we.get(0).getAttribute("data-ref")+" found");			
		}
		else
		{
			UtilHBM.reportKO("Product not found");
		}
		return PageFactory.initElements(driver, Content.class);
	}
	public Content searchProductWithoutDate(String productName,String role)
	{
		for(int i=0;i<productList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, productList.get(i));
		searchInput.sendKeys(productName+Keys.ENTER);
		if(processingLabel.size()>0)
		{
			UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
			UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
		}
		List<WebElement> we=driver.findElements(By.xpath("//div/table/tbody/tr[contains(@data-name,'"+productName+"')]"));
		if(we.size()>0)
		{
			for(int i=0;i<we.size();i++)
			{
				UtilHBM.waitExplicitDisplayed(driver, we.get(i));
			}	
			UtilHBM.reportOK(we.get(0).getAttribute("data-ref")+" found");			
		}
		else
		{
			UtilHBM.reportKO("Product not found");
		}
		return PageFactory.initElements(driver, Content.class);
	}
	public Content resetSearchResult(){
		resetSearchButton.click();
		UtilHBM.turnOffImplicitWaits(driver);
		if(processingLabel.size()>0)
		{
			UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
			UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return PageFactory.initElements(driver, Content.class);
	}


	public Product openProduct(String productName,String role)
	{
		for(int i=0;i<productList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, productList.get(i));
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		String prdName = productName+"_"+role+"_"+s;
		UtilHBM.turnOffImplicitWaits(driver);
		if(processingLabel.size()>0)
		{
			UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
			UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
		}
		UtilHBM.turnOnImplicitWaits(driver);
		List<WebElement> we;
		if(UtilHBM.webElement(driver, ".div-datatable-search").getAttribute("class").contains("hide")){
			we=driver.findElements(By.xpath("//div[@class='div-datatable-dashboard']/div/table/tbody/tr[contains(@data-name,'"+prdName+"')]"));
		}else{
			we=driver.findElements(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr[contains(@data-name,'"+prdName+"')]"));
		}
		if(we.size()>0)
		{
			for(int i=0;i<we.size();i++)
			{
				UtilHBM.waitExplicitDisplayed(driver, we.get(i));
			}	
			UtilHBM.reportOK(we.get(0).getAttribute("data-ref")+" found");
			we.get(0).click();
			UtilHBM.waitExplicitDisplayed(driver, new Select(UtilHBM.webElement(driver, "#product_brand")).getFirstSelectedOption());
			UtilHBM.waitFixTime(1000);
		}
		else
		{
			UtilHBM.reportKO("Product not found");
		}
		return PageFactory.initElements(driver, Product.class);
	}
	public Product openProductWithoutDate(String productName,String role)
	{
		for(int i=0;i<productList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, productList.get(i));
		
		String prdName = productName+role;
		UtilHBM.turnOffImplicitWaits(driver);
		if(processingLabel.size()>0)
		{
			UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
			UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
		}
		UtilHBM.turnOnImplicitWaits(driver);
		List<WebElement> we;
		if(UtilHBM.webElement(driver, ".div-datatable-search").getAttribute("class").contains("hide")){
			we=driver.findElements(By.xpath("//div[@class='div-datatable-dashboard']/div/table/tbody/tr[contains(@data-name,'"+prdName+"')]"));
		}else{
			we=driver.findElements(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr[contains(@data-name,'"+prdName+"')]"));
		}
		if(we.size()>0)
		{
			for(int i=0;i<we.size();i++)
			{
				UtilHBM.waitExplicitDisplayed(driver, we.get(i));
			}	
			UtilHBM.reportOK(we.get(0).getAttribute("data-ref")+" found");
			we.get(0).click();
			UtilHBM.waitExplicitDisplayed(driver, new Select(UtilHBM.webElement(driver, "#product_brand")).getFirstSelectedOption());
			UtilHBM.waitFixTime(1000);
		}
		else
		{
			UtilHBM.reportKO("Product not found");
		}
		return PageFactory.initElements(driver, Product.class);
	}

	public Content deleteMaterial(String tagName,String materialName,String role)
	{ 
		for(int i=0;i<materialList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, materialList.get(i));
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		int x=Integer.parseInt(allMatInfo.getText().split(" ")[5].replace(",", ""));
		searchInput.sendKeys(tagName+Keys.ENTER);
		List<WebElement> searchedMaterials=driver.findElements(By.xpath("//div/div/table/tbody/tr/td[4]/span[contains(text(),'"+tagName+"')]"));
		for(int i=0;i<searchedMaterials.size();i++)
		{
			UtilHBM.waitExplicitDisplayed(driver, searchedMaterials.get(i));
		}
		List<WebElement> materialToBeDeleted=driver.findElements(By.xpath("//div/div/table/tbody/tr[contains(@data-name,'"+materialName+"_"+role+"_"+s+"')]/td/label"));
		for(int i=0;i<materialToBeDeleted.size();i++)
			materialToBeDeleted.get(i).click();
		clickMaterialDeleteButton()
		.clickConfirmMaterialDelete();
		UtilHBM.waitFixTime(3000);
		for(int i=0;i<materialList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, materialList.get(i));
		int y=Integer.parseInt(allMatInfo.getText().split(" ")[5].replace(",", ""));
		if(y==(x-materialToBeDeleted.size()))
		{
			UtilHBM.reportOK(materialToBeDeleted.size()+" Materials Deleted");
		}
		else
			UtilHBM.reportKO("Material not Deleted");
		return PageFactory.initElements(driver, Content.class);
	}

	Level1DlgBox clickMaterialDeleteButton()
	{
		deleteMaterialButton.click();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}

	public Material createNewMaterial()
	{
		
		newMaterialButton.click();
		return PageFactory.initElements(driver, Material.class);
	}
	
	public Content goToMaterialsPage()
	{
		materialsPage.click();
		return PageFactory.initElements(driver, Content.class);
	}

	public Dashboard goToDashboardPage()
	{
		dashboardButton.click();
		return PageFactory.initElements(driver, Dashboard.class);
	}

	public Content deleteProduct(String productName,String role)
	{
		for(int i=0;i<list.size();i++)
		{
			WebElement w=list.get(i);
			UtilHBM.waitExplicitDisplayed(driver, w);
		}
		int x=Integer.parseInt(allPrdInfo.getText().split(" ")[5].replace(",", ""));
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		searchInput.sendKeys(productName+"_"+role+"_"+s+"*"+Keys.ENTER);
		if(processingLabel.size()>0)
		{
			UtilHBM.waitExplicitDisplayed(driver, processingLabelElement);
			UtilHBM.waitTillElementDisappear(driver, "#productTable_processing");
		}
		List<WebElement> deletedProducts=driver.findElements(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr[contains(@data-name,'"+productName+"_"+role+"')]/td[2]"));
		List<WebElement> prdToBeDeleted=driver.findElements(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr[contains(@data-name,'"+productName+"_"+role+"')]/td/label"));
		UtilHBM.reportOK("Products to be Deleted:");
		for(int i=0;i<prdToBeDeleted.size();i++)
		{
			prdToBeDeleted.get(i).click();
			UtilHBM.reportOK(deletedProducts.get(i).getText());
		}
		clickDeleteButton()
		.clickConfirmProductDelete();
		UtilHBM.waitFixTime(2000);
		for(int i=0;i<productList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, productList.get(i));
		int y=Integer.parseInt(allPrdInfo.getText().split(" ")[5].replace(",", ""));
		if(y==(x-prdToBeDeleted.size()))
		{
			UtilHBM.reportOK(prdToBeDeleted.size()+" Products Deleted");
		}
		else
			UtilHBM.reportKO("Product not Deleted");
		return this;
	}

	Level1DlgBox clickDeleteButton()
	{
		deleteProductButton.click();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}

	Content clickMoreOptionsButton()
	{
		moreOptionsButton.click();
		return PageFactory.initElements(driver, Content.class);
	}

	Level1DlgBox clickShare3DByLinkOption()
	{
		UtilHBM.waitExplicitDisplayed(driver,share3DByLinkOption);
		share3DByLinkOption.click();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}



	public Content deletePrdFromFamily(String familyName,String productName,String role)
	{
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		searchInput.sendKeys(familyName+"_"+role+"_"+s+Keys.ENTER);
		WebElement we=driver.findElement(By.xpath("//*[@id='table_families']/tbody/tr/td[contains(text(), '"+familyName+"_"+role+"_"+s+"')]"));
		UtilHBM.waitExplicitDisplayed(driver, we);
		we.click();
		Family family=PageFactory.initElements(driver, Family.class);
		family.deletePrdFromFamily(productName,role);
		return this;
	}
	public Content deleteFamily(String familyName,String role)
	{
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		int x=Integer.parseInt(all_Family_count.getText().split(" ")[5]);
		searchInput.sendKeys(familyName+"_"+role+"_"+s+Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='table_families']/tbody/tr[contains(@data-name,'"+familyName+"_"+role+"_"+s+"')]/td[@class='table-checkbox']")).click();
		clickDeleteFamilyButton()
		.clickConfirmDelete();
		UtilHBM.waitFixTime(2000);
		int y=Integer.parseInt(all_Family_count.getText().split(" ")[5]);
		if(y==(x-1))
		{
			UtilHBM.reportOK("Family "+familyName+"_"+role+"_"+s+" deleted");
		}
		else
			UtilHBM.reportKO("Family not Deleted");
		return this;
	}

	Level1DlgBox clickDeleteFamilyButton()
	{
		deleteFamilyButton.click();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}
	
	public Content deleteAllPrdFromCatalog(String catalogName,String role)
	{
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		for(int i=0;i<catalogList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, catalogList.get(i));
		searchInput.sendKeys("Auto_"+catalogName+"_"+role+"_"+s+Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='table_catalogs']/tbody/tr[contains(@data-name,'"+catalogName+"_"+role+"_"+s+"')]")).click();
		Catalog catalog=PageFactory.initElements(driver, Catalog.class);
		catalog.deleteAllPrdFromCatalog(role);
		return PageFactory.initElements(driver, Content.class);
	}

	public Content deletePrdFromCatalog(String catalogName,String productName,String role)
	{
		
		openCatalog(catalogName, role).deletePrdFromCatalog(productName,role);
		return PageFactory.initElements(driver, Content.class);
	}
	
	public Content verifyCatalog(String catalogName,String role,int noOfPrd,String appDist)
	{
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		searchInput.sendKeys("Auto_"+catalogName+"_"+role+"_"+s+Keys.ENTER);
		String sdate=UtilHBM.getDate(0, "yyyy.MM.dd");
		String edate=UtilHBM.getDate(2, "yyyy.MM.dd");
		Verification.elementContainsString(UtilHBM.webElement(driver, "#table_catalogs>tbody>tr>td:nth-child(2)"), "Auto_"+catalogName+"_"+role+"_"+s, "Catalog name ");
		Verification.VerifyEquals("No of products incorrect",UtilHBM.webElementXPath(driver, "//*[@id='table_catalogs']/tbody/tr[contains(@data-name,'Auto_"+catalogName+"_"+role+"_"+s+"')]/td[3]").getText() , String.valueOf(noOfPrd));
		Verification.VerifyEquals("Start date incorrect", UtilHBM.webElementXPath(driver, "//*[@id='table_catalogs']/tbody/tr[contains(@data-name,'Auto_"+catalogName+"_"+role+"_"+s+"')]/td[4]").getText(), sdate);
		Verification.VerifyEquals("End date incorrect", UtilHBM.webElementXPath(driver, "//*[@id='table_catalogs']/tbody/tr[contains(@data-name,'Auto_"+catalogName+"_"+role+"_"+s+"')]/td[5]").getText(), edate);
		Verification.VerifyEquals("Application distribution incorrect", UtilHBM.webElementXPath(driver, "//*[@id='table_catalogs']/tbody/tr[contains(@data-name,'Auto_"+catalogName+"_"+role+"_"+s+"')]/td[7]").getText(),appDist);
		return PageFactory.initElements(driver, Content.class);
	}
	
	public Catalog openCatalog(String catalogName,String role)
	{
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		for(int i=0;i<catalogList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, catalogList.get(i));
		searchInput.clear();
		searchInput.sendKeys("Auto_"+catalogName+"_"+role+"_"+s+Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='table_catalogs']/tbody/tr[contains(@data-name,'"+catalogName+"_"+role+"_"+s+"')]")).click();
		return PageFactory.initElements(driver, Catalog.class);
	}
	
	
	public Content deleteCatalog(String catalogName,String role)
	{
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		int x=Integer.parseInt(all_Catalog_count.getText().split(" ")[5]);
		searchInput.sendKeys(catalogName+"_"+role+"_"+s+Keys.ENTER);
		driver.findElement(By.xpath("//*[@id='table_catalogs']/tbody/tr[contains(@data-name,'"+catalogName+"_"+role+"_"+s+"')]/td[@class='table-checkbox']")).click();
		clickDeleteCatalogButton()
		.clickConfirmDelete();
		UtilHBM.waitFixTime(2000);
		int y=Integer.parseInt(all_Catalog_count.getText().split(" ")[5]);
		if(y==(x-1))
		{
			UtilHBM.reportOK("Catalog "+catalogName+"_"+role+"_"+s+" deleted");
		}
		else
			UtilHBM.reportKO("Catalog not Deleted");
		return this;
	}

	Level1DlgBox clickDeleteCatalogButton()
	{
		deleteCatalogButton.click();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}
	
	public Content deleteDataFromDirc(String productName) throws IOException
	{
		Files.delete(Paths.get(Setting.threeDCloudData+"//BM3//"+UtilHBM.getDate(0, "ddMMyyyy")+"_"+productName+".BMA"));
		return PageFactory.initElements(driver, Content.class);
	}
	
	public Product createNewProduct()
	{
		clickNewProductButton();
		return PageFactory.initElements(driver, Product.class);
	}


	public Content goToFamilyPage()
	{
		families.click();
		return PageFactory.initElements(driver, Content.class);
	}

	public Content goToProductCatalogs()
	{
		productCatalogs.click();
		return PageFactory.initElements(driver, Content.class);
	}

	public Content goToProductPage()
	{
		productsTab.click();
		return PageFactory.initElements(driver, Content.class);
	}

	Family clickNewFamily()
	{
		createNewFamily.click();
		return PageFactory.initElements(driver, Family.class);
	}

	public Content createNewFamily(String familyName,String productName,String role)
	{
		clickNewFamily()
		.createNewFamily(familyName, productName,role);
		return PageFactory.initElements(driver, Content.class);
	}

	public Content searchContent(String contentSearchString){
		UtilHBM.turnOffImplicitWaits(driver);
		try {
			UtilHBM.waitExplicitDisplayed(driver,"//table[contains(@class, 'datatable')]");
		} catch (TimeoutException e) {
		}
		UtilHBM.waitExplicitDisplayed(driver, searchInput);
		try {
			resetSearchResult();
		} catch (ElementNotInteractableException e) {
		}
		searchInput.sendKeys(contentSearchString + Keys.ENTER);
		try {
			if(processing.getAttribute("style").equals("display: block;"))UtilHBM.waitTillElementDisappear(driver,"div.dataTables_processing[style$='block;']");
		} catch (NoSuchElementException e) {
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}

	public <T extends Object> T searchAndOpen(String contentName, Class<T> contentType) {
			searchContent(contentName);

		WebElement we = null;
		UtilHBM.turnOffImplicitWaits(driver);
		outerFor:
		for (int tryCount = 0; tryCount < 5; tryCount++) {
			try {
				switch (contentType.getSimpleName()) {
					case "ApplicativeRule":
						we = driver.findElement(By.xpath("//*[@id='table_rules']/tbody/tr/td[contains(text(), '" + contentName + "')]"));
						break;
					case "ProductRules":
						we = driver.findElement(By.xpath("//*[@id='table_rules']/tbody/tr/td[contains(text(), '" + contentName + "')]"));
						break;
					case "Product":
						we = driver.findElement(By.xpath("//table[@id='DataTables_Table_1']/tbody/tr[@data-name='" + contentName + "']"));
						break;
					case "Material":
						//TODO : remove workaround after search is fixed
						UtilHBM.turnOffImplicitWaits(driver);
						resetSearchResult();
						UtilHBM.waitFixTime(5000);
						new Select(selectEntries).selectByValue("500");
						UtilHBM.waitFixTime(5000);
						for(int counter=0; counter<5; counter++){
							try{
								we = driver.findElement(By.xpath("//*[@id='table_materials']/tbody/tr/td/span[contains(text(), '" + contentName + "')]"));
								break;
							} catch (NoSuchElementException ex) {
								if (paginateNextBtn.isEnabled()) {
									paginateNextBtn.click();
									UtilHBM.waitFixTime(5000);
								} else {
									UtilHBM.reportKO("Searched material not found");
								}
							}
						}
						UtilHBM.turnOnImplicitWaits(driver);
						break outerFor;
						//End of workaround

//						we = driver.findElement(By.xpath("//*[@id='table_materials']/tbody/tr/td[contains(text(), '" + contentName + "')]"));
//						break;
					case "Templates":
						we = driver.findElement(By.xpath("//*[@id='table_templates']/tbody/tr/td[contains(text(), '" + contentName + "')]"));
						break;
					case "Family":
					default:
						we = driver.findElement(By.xpath("//*[@id='table_families']/tbody/tr/td[contains(text(), '" + contentName + "')]"));

				}
			} catch (NoSuchElementException e) {
				if (tryCount < 4)searchContent(contentName);
				else throw e;
			}
		}
		UtilHBM.turnOnImplicitWaits(driver);

		UtilHBM.waitExplicitDisplayed(driver, we);
		we.click();
		return PageFactory.initElements(driver, contentType);
	}

	public Content createNewCatalog(String catalogName,String applicationDist,String productName,String role)
	{
		clickNewCatalogButton()
		.newCatalog(catalogName, applicationDist, productName,role);
		return this;
	}

	Catalog clickNewCatalogButton()
	{
		newCatalogButton.click();
		return PageFactory.initElements(driver, Catalog.class);
	}

	Product clickNewProductButton()
	{
		newProduct.click();
		return PageFactory.initElements(driver,Product.class);
	}
	
	public Content changeLE(String legalEntity) {
		UtilHBM.waitExplicitClickable(driver, driver.findElement(By.cssSelector("a.chosen-single")));
		driver.findElement(By.cssSelector("a.chosen-single")).click();
		UtilHBM.waitFixTime(1000);
		driver.findElement(By.xpath("//ul[@class='chosen-results']/li[text()='"+legalEntity+"']")).click();
		UtilHBM.waitFixTime(1000);
		return this;
	}

	public ContentPageBeta switchTo3DCloudBeta(){
		UtilHBM.waitExplicitDisplayed(driver, threeDCloudBeta);
		UtilHBM.scrollToElementWithOffset(driver,threeDCloudBeta,0);
		threeDCloudBeta.click();
		ContentPageBeta cont=PageFactory.initElements(driver, ContentPageBeta.class);
		return cont.waitForSigninProgress();
	}
}
