package kitchen.threeDCloudByMe.pageObject;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class Level1DlgBox 
{
	WebDriver driver;

	public Level1DlgBox(WebDriver driver) {
		this.driver=driver;
	}

	@FindBy(css="div.col-xs-12.parameter-content>div>div:nth-child(2)>div>div:nth-child(2)>label[class='btn btn-default btn-xs active toggle-off']")
	WebElement visibleToggleDimsn;

	@FindBy(css="div.col-xs-12.parameter-content>div>div:nth-child(3)>div>div:nth-child(2)>label[class='btn btn-default btn-xs active toggle-off']")
	WebElement editableToggleDimsn;

	@FindBy(css="div.col-xs-12.parameter-content>div>div:nth-child(4)>div>div:nth-child(2)>label[class='btn btn-default btn-xs active toggle-off']")
	WebElement translationKeyToggle;

	@FindBy(css="div.col-xs-12.parameter-content>div>div>.select--full.parameter-id")
	WebElement selectID;
	
	@FindBy(css="#new-id-button")
	List<WebElement> createNewButton;
	
	@FindBy(css="#new-id-input")
	List<WebElement> newCreatedId;
	
	@FindBy(css="div.col-xs-12.parameter-content>div>div.col-xs-1>.btn.btn-default.add-dimension-id")
	WebElement addNewDimsnIdButton;

	@FindBy(css="div.col-xs-12.parameter-content>div>div.col-xs-1>.btn.btn-default.add-publication-id")
	WebElement addNewOptionIdButton;
	
	@FindBy(css="div.col-xs-12.parameter-content>div>div>div>div>div>div.col-xs-9.parameter-translations>input[id*='product_dimensions'][id$='labels_values_en']")
	WebElement displayNameInput;
	
	@FindBy(css=".col-xs-12.parameter-content>div:nth-child(4)>div>.select--full.option-type")
	WebElement selectType;

	@FindBy(css="body>div.modal.current>div>div>form>div>div>div>button[id='validate-button'][class='btn btn-primary btn-large']")
	WebElement validateButton;
	
	@FindBy(css="body>div.modal.current>div>div>form>div>div.col-xs-12.parameter-content>div>div>div>div>div>input[id$='value']")
	List<WebElement> possibleValueInput;
	
	@FindBy(css="body>div.modal.current>div>div>form>div>div.col-xs-12.parameter-content>div>div>div>div>div>div[class='col-xs-3 form-group item-translation-value item-labels-value']>input[id$='en']")
	List<WebElement> possibleValueNameInput;
	
	@FindBy(css="body>div.modal.current>div>div>form>div>div.col-xs-12.parameter-content>div>div>div>div>div>div[class='col-xs-2']>button")
	List<WebElement> addPossibleValuesButton;
	
	@FindBy(css="body>div.modal.current>div>div>form>div>div.col-xs-12.parameter-content>div>div>input[id$='value_collection_defaultValue']")
	WebElement defaultValueInput;
	
	@FindBy(css="body>div.modal.current>div>div>form>div>div.col-xs-12.parameter-content>div>div>input[id$='value_range_min']")
	WebElement possibleMinValueInput;
	
	@FindBy(css="body>div.modal.current>div>div>form>div>div.col-xs-12.parameter-content>div>div>input[id$='range_defaultValue']")
	WebElement possibleDefaultValueInput;
	
	@FindBy(css="body>div.modal.current>div>div>form>div>div.col-xs-12.parameter-content>div>div>input[id$='value_range_max']")
	WebElement possibleMaxValueInput;
	
	@FindBy(css=".modal-new-dimension.modal-parameter input[id*='value_range_step']")
	private WebElement stepDimVariInputBox;
	
	@FindBy(css=".modal-new-option.modal-parameter input[id*='value_range_step']")
	private WebElement stepAddOptionInputBox;
	
	@FindBy(css="body>div.modal.current>div>div>form>div>div.col-xs-12.parameter-content>div>div>input[id$='value_range_defaultValue']")
	WebElement possibleDimDefaultValueInput;

	@FindBy(css="div.col-xs-12.parameter-content>div.translation-group>div.form-group.row.translation-value.labels-value>div>div>div>div.col-xs-9>input[id$='values_en']")
	WebElement optionDisplayNameInput;
	
	@FindBy(css="body>div.modal.current>div>div>form>div>div.col-xs-12.parameter-content>div.form-group.row.option-value.boolean-value>div>select[id*='product_options_'][id$='boolean_defaultValue']")
	WebElement booleanOptionDefaultValue;
	
	@FindBy(css="body>div.modal.current>div>div>form>div>div.col-xs-12.parameter-content>div.translation-group > div.form-group.translation-value.labels-value.row>div>div>div>div.col-xs-9>input[id$='labels_values_en']")
	WebElement valueDisplayNameInput;
	
	@FindBy(css="body>div.modal.current>div>div>form>div>div.col-xs-12.parameter-content>div>div>div>div>div.col-xs-10>#product_variation_buttonIds")
	WebElement addProductsButton;
	
	@FindBy(css="body>div.modal.current>div>div>form>div>div.col-xs-12.parameter-content>div>div>div>div>div.col-xs-10>#product_variation_buttonTags")
	WebElement addTagsButton;
	
	@FindBy(css="body>div.modal.current>div>div>form>div>div.col-xs-12.parameter-content>div>div.col-xs-5>div>div>div.col-xs-1.parameter-dropbox-big")
	WebElement addDefaultMaterialButton;
	
	@FindBy(css="body>div.modal.current>div>div>div:nth-child(1)>div.col-xs-12.parameter-header>span")
	WebElement pageHeader1;
	
	@FindBy(css="body>div.modal.current>div>div>div>div>div>#cancel-button>span")
	WebElement cancelButtonText;
	
	@FindBy(css="body>div.modal.current>div>div>div>div>div>#validate-button>span")
	WebElement validateButtonText;
	
	@FindBy(css="body>div.modal.current>div>div>div>div>div>#validate-button")
	WebElement okButton;
	
	@FindBy(css="div.modal.current>div>div>div>div.col-xs-12.parameter-content>#textarea-price-parameters")
	WebElement parameterInput;
	
	@FindBy(css="#table_rules>tbody>tr")
	List<WebElement> applicativeRuleList;
	
	@FindBy(css="body>form>div>div>div>div>div>div>input[id='nav-search-modal']")
	WebElement searchInput;
	
	@FindBy(css="body>#modalForm>div>div>#modal-footer>div>#validate-button")
	WebElement catalogValidateButton;
	
	@FindBy(css="div.div-datatable-dashboard>div>table>tbody>tr[class$='row']")
	List<WebElement> prdList;
	
	@FindBy(css=".dataTables_processing[style='display: block;']")
	List<WebElement> processingLabel;	
	
	@FindBy(css="body>#modalForm>div>div>#modal-aside>ul>li>div>div.col-xs-5.modal-item-name>span")
	List<WebElement> selectedPrdList;	
	
	@FindBy(css="#first-action-btn")
	WebElement confirmDelete;
	
	@FindBy(css="#menu-delete-product>div>footer>#first-action-btn")
	WebElement confirmProductDelete;
	
	@FindBy(css="#menu-delete-material>div>footer>#first-action-btn")
	WebElement confirmMaterialDelete;
	
	@FindBy(css="div.modal-delete>div>div>div>div>button[id='yes-button']")
	List<WebElement> yesButton;
	
	@FindBy(css="body>form>div>div>div>div>#validate-button")
	WebElement validateTemplateButton;
	
	
	String visibleFlag;
	String editableFlag;
	String translationKeyFlag;
	String idType;
	String variationId;
	String displayName;
	String type;
	String addedDimsnType;
	String possibleValues;
	String defaultValue;
	String possibleValueName;
	String possibleMinValue;
	String possibleDimDefaultValue;
	String possibleMaxValue;
	String possibleDefaultValue;
	String possibleValuesSearchInput;	
	String defaultValueSearchInput;


	private String embedLink="";

	public static ArrayList<String> addedTemplates=new ArrayList<String>();

	public static ArrayList<String> getAddedTemplates() {
		return addedTemplates;
	}

	public void setAddedTemplates(ArrayList<String> addedTemplates) {
		Level1DlgBox.addedTemplates = addedTemplates;
	}
	
	public static ArrayList<String> addedAppRules=new ArrayList<String>();
	
	public static ArrayList<String> getAddedAppRules() {
		return addedAppRules;
	}

	public void setAddedAppRules(ArrayList<String> addedAppRules) {
		Level1DlgBox.addedAppRules = addedAppRules;
	}

	@FindBy(css="div>#embed-link-tt")
	WebElement emdbedText;
	
	@FindBy(css="#product-embed>div>div.inner-content>h1.tt")
	WebElement label1;
	
	@FindBy(css="div>p>span.js-product-name")
	WebElement productNameText;


	public  String getEmbedLink() {
		return embedLink;
	}


	Content verifyShareLink(String productName){
		String embedPrdLink;
		UtilHBM.waitExplicitDisplayed(driver, label1);
		Verification.VerifyEquals("Label incorrect", label1.getText(), "Share your 3D Model");
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		Verification.VerifyEquals("Product name incorrect", productNameText.getText(), productName+"_"+s);
		Verification.elementContainsString(emdbedText, "embed", "Verify embed link ");
		embedPrdLink = emdbedText.getText().split("\"")[1];
		embedLink=embedPrdLink;
		driver.get(embedPrdLink);		
		driver.switchTo().frame(UtilHBM.webElement(driver, "#product-viewer-iframe"));
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".canvas-tools-help-tooltip"));		
		Verification.displayNAttributeCheckOfElementExcludeLineBreak(UtilHBM.webElement(driver, ".canvas-tools-help-tooltip"), "Tool tip msg", "text", "Click and drag to move the viewpoint");
		driver.navigate().back();
		return PageFactory.initElements(driver, Content.class);
	}

	
	Content clickDeleteButton()
	{
		confirmDelete.click();
		return PageFactory.initElements(driver, Content.class);
	}
	
	ApplicativeRulesCatalog addApplicativeRules(String applicativeRuleName)
	{
		for(int i=0;i<applicativeRuleList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, applicativeRuleList.get(i));
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		driver.switchTo().frame(driver.findElement(By.cssSelector(".fancybox-iframe")));
		searchInput.sendKeys(applicativeRuleName+"_"+s+Keys.ENTER);
		List<WebElement> searchedAppRules=driver.findElements(By.xpath("//div/table/tbody/tr[contains(@data-name,'"+applicativeRuleName+"_"+s+"')]"));
		for(int i=0;i<searchedAppRules.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, searchedAppRules.get(i));
		List<WebElement> selectedAppRule=driver.findElements(By.xpath("//div/table/tbody/tr[contains(@data-name,'"+applicativeRuleName+"_"+s+"')]/td[2]"));
		for(int i=0;i<selectedAppRule.size();i++)
		{
			selectedAppRule.get(i).click();
			addedAppRules.add(i, selectedAppRule.get(i).getText());
		}
		setAddedAppRules(addedAppRules);
		clickAppRuleValidate();
		return PageFactory.initElements(driver, ApplicativeRulesCatalog.class);
	}
	
	ApplicativeRulesCatalog clickAppRuleValidate()
	{
		validateTemplateButton.click();
		return PageFactory.initElements(driver, ApplicativeRulesCatalog.class);
	}
	
	TemplateCatalog addTemplates(String templateName)
	{
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		UtilHBM.waitFixTime(3000);
		driver.switchTo().frame(driver.findElement(By.cssSelector(".fancybox-iframe")));
		
		searchInput.sendKeys(templateName+"_"+s+Keys.ENTER);
		List<WebElement> searchedTemplate=driver.findElements(By.xpath("//div/table/tbody/tr[contains(@data-name,'"+templateName+"_"+s+"')]"));
		for(int i=0;i<searchedTemplate.size();i++)
		{
			UtilHBM.waitExplicitDisplayed(driver, searchedTemplate.get(i));
		}
		List<WebElement> templateList=driver.findElements(By.xpath("//div/table/tbody/tr[contains(@data-name,'"+templateName+"_"+s+"')]/td[2]"));
		for(int i=0;i<templateList.size();i++)
		{
			templateList.get(i).click();
		}
		for(int i=0;i<templateList.size();i++)
		{		
			addedTemplates.add(i, templateList.get(i).getText());
		}
		setAddedTemplates(addedTemplates);
		clickTemplateValidate();
		return PageFactory.initElements(driver, TemplateCatalog.class);
	}
	
	TemplateCatalog clickTemplateValidate()
	{
		validateTemplateButton.click();
		return PageFactory.initElements(driver, TemplateCatalog.class);
	}
	
	Product clickYesButton()
	{
		UtilHBM.waitExplicitDisplayed(driver, yesButton.get(yesButton.size()-1));
		yesButton.get(yesButton.size()-1).click();
		return PageFactory.initElements(driver, Product.class);
	}
	
	Content clickConfirmMaterialDelete()
	{
		confirmMaterialDelete.sendKeys(Keys.ENTER);
		return PageFactory.initElements(driver, Content.class);
	}
	
	Content clickConfirmProductDelete()
	{
		confirmProductDelete.click();
		return PageFactory.initElements(driver, Content.class);
	}
	
	Content clickConfirmDelete()
	{
		confirmDelete.click();	
		return PageFactory.initElements(driver, Content.class);
	}
	
	Family addFamilyProducts(String productName)
	{
		for(int i=0;i<prdList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, prdList.get(i));
	
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		ArrayList<String> selectedProductCheckList=new ArrayList<String>();
		if(productName.contains(";"))
		{
			for(String a:productName.split(";"))
				{
					UtilHBM.reportInfo("Searching for "+a+"_"+s);
					searchInput.clear();				
					searchInput.sendKeys(a+"_"+s+"*"+Keys.ENTER);
					if(processingLabel.size()>0)
					{
						UtilHBM.waitExplicitDisplayed(driver, processingLabel.get(processingLabel.size()-1));
						UtilHBM.waitTillElementDisappear(driver, ".dataTables_processing[style='display: block;']");
					}
					List<WebElement> l=driver.findElements(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr/td[2]/span[contains(text(),'"+a+"')]"));
					if(l.size()>0)
					{
						UtilHBM.reportOK(l.size()+" products found");
						for(int i=0;i<l.size();i++)
						{
							UtilHBM.waitExplicitDisplayed(driver, l.get(i));
							l.get(i).click();
							selectedProductCheckList.add(i, l.get(i).getText());
						}
						
					}
					else
					{
						UtilHBM.reportKO("No products named "+a+"_"+s+" found");
					}
						
					searchInput.clear();
				}
		}
		else
		{
			UtilHBM.reportInfo("Searching for "+productName+"_"+s);
			searchInput.sendKeys(productName+"_"+s+"*"+Keys.ENTER);
			if(processingLabel.size()>0)
			{
				UtilHBM.waitExplicitDisplayed(driver, processingLabel.get(processingLabel.size()-1));
				UtilHBM.waitTillElementDisappear(driver, ".dataTables_processing");
			}
			List<WebElement> l=driver.findElements(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr/td[2]/span[contains(text(),'"+productName+"')]"));
			if(l.size()>0)
			{
				UtilHBM.reportOK(l.size()+" products found");
				for(int i=0;i<l.size();i++)
				{
					UtilHBM.waitExplicitDisplayed(driver, l.get(i));
					l.get(i).click();
					selectedProductCheckList.add(i, l.get(i).getText());
				}
				
			}
			else
			{
				UtilHBM.reportKO("No products named "+productName+"_"+s+" found");
			}
				
			searchInput.clear();
		}
		for(int i=0;i<selectedPrdList.size();i++)
		{
			if(selectedPrdList.get(i).getText().contentEquals(selectedProductCheckList.get(selectedProductCheckList.size()-i-1)))
			{
				UtilHBM.reportOK(selectedPrdList.get(i).getText()+" selected");
			}
			else
			{
				UtilHBM.reportKO("Product name not matched");
			}
		}
		for(int i=0;i<selectedPrdList.size();i++)
		{
			selectedPrd.add(i, selectedPrdList.get(i).getText());
		}
		
		setSelectedPrd(selectedPrd);
		clickFamilyValidateButton();
		return PageFactory.initElements(driver, Family.class);
	}
	
	Family clickFamilyValidateButton()
	{
		catalogValidateButton.click();
		UtilHBM.waitTillElementDisappear(driver, "body>#modalForm>div>div>#modal-footer>div>#validate-button");
		return PageFactory.initElements(driver, Family.class);
	}
	
	public static ArrayList<String> selectedPrd=new ArrayList<String>();
	
	
	Catalog addCatalogProducts(String productName,String role)
	{
		 
		for(int i=0;i<prdList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, prdList.get(i));		
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		ArrayList<String> selectedProductCheckList=new ArrayList<String>();
		if(productName.contains(";"))
		{
			for(String a:productName.split(";"))
				{
					UtilHBM.reportInfo("Searching for "+a+"_"+s);
					searchInput.sendKeys(a+"_"+s+"*"+Keys.ENTER);
					if(processingLabel.size()>0)
					{
						UtilHBM.waitExplicitDisplayed(driver, processingLabel.get(processingLabel.size()-1));
						UtilHBM.waitTillElementDisappear(driver, ".dataTables_processing");
					}
					List<WebElement> l=driver.findElements(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr/td[2]/span[contains(text(),'"+a+"')]"));
					if(l.size()>0)
					{
						UtilHBM.reportOK(l.size()+" products found");
						for(int i=0;i<l.size();i++)
						{
							UtilHBM.waitExplicitDisplayed(driver, l.get(i));
							l.get(i).click();
							selectedProductCheckList.add(i, l.get(i).getText());
						}
					}
					else
					{
						UtilHBM.reportKO("No products named "+a+"_"+s+" found");
					}
					searchInput.clear();
				}
		}
		else
		{
			for(int i=0;i<prdList.size();i++)
				UtilHBM.waitExplicitDisplayed(driver, prdList.get(i));
			UtilHBM.reportInfo("Searching for "+productName+"_"+s);
			searchInput.sendKeys(productName+"_"+s+"*"+Keys.ENTER);
			if(processingLabel.size()>0)
			{
				UtilHBM.waitExplicitDisplayed(driver, processingLabel.get(processingLabel.size()-1));
				UtilHBM.waitTillElementDisappear(driver, ".dataTables_processing");
			}
			List<WebElement> l=driver.findElements(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr/td[2]/span[contains(text(),'"+productName+"')]"));
			if(l.size()>0)
			{
				UtilHBM.reportOK(l.size()+" products found");
				for(int i=0;i<l.size();i++)
				{
					UtilHBM.waitExplicitDisplayed(driver, l.get(i));
					l.get(i).click();
					selectedProductCheckList.add(i, l.get(i).getText());
				}
			}
			else
			{
				UtilHBM.reportKO("No products named "+productName+"_"+s+" found");
			}
			searchInput.clear();
		}
		for(int i=0;i<selectedPrdList.size();i++)
		{
			if(selectedPrdList.get(i).getText().contentEquals(selectedProductCheckList.get(selectedProductCheckList.size()-i-1)))
			{
				UtilHBM.reportOK(selectedPrdList.get(i).getText()+" selected");
			}
			else
			{
				UtilHBM.reportKO("Product name not matched");
			}
		}		
		for(int i=0;i<selectedPrdList.size();i++)
		{
			selectedPrd.add(i, selectedPrdList.get(i).getText());
		}
		setSelectedPrd(selectedPrd);
		clickCatalogValidateButton();
		return PageFactory.initElements(driver, Catalog.class);
	}
	
	

	public static ArrayList<String> getSelectedPrd() {
		return selectedPrd;
	}

	public static void setSelectedPrd(ArrayList<String> selectedPrd) {
		Level1DlgBox.selectedPrd = selectedPrd;
	}

	Catalog clickCatalogValidateButton()
	{
		catalogValidateButton.click();
		UtilHBM.waitTillElementDisappear(driver, "body>#modalForm>div>div>#modal-footer>div>#validate-button");
		return PageFactory.initElements(driver, Catalog.class);
	}
	
	Product addParameters(String parameter)
	{
		Verification.VerifyEquals("Text not displayed", pageHeader1.getText(), "Add your parameters");
		Verification.VerifyEquals("Text not displayed", cancelButtonText.getText(), "CANCEL");
		Verification.VerifyEquals("Text not displayed", validateButtonText.getText(), "OK");
		parameterInput.sendKeys(parameter);
		clickOkButton();
		return PageFactory.initElements(driver, Product.class);
	}
	
	Product clickOkButton()
	{
		okButton.click();
		return PageFactory.initElements(driver, Product.class);
	}
	
	Product addProductReplacement(boolean visibleFlag, boolean editableFlag, String replacementId, String replacementType, String possibleValueSearchString, String possibleValues, String tags)
	{
		if(visibleFlag==true)
		{
			visibleToggleDimsn.click();
		}
		if(editableFlag==true)
		{
			editableToggleDimsn.click();
		}
		if(replacementType.contentEquals("Default"))
		{
			new Select(selectID).selectByVisibleText(replacementId);
		}
		else if(replacementType.contentEquals("New"))
		{
			createNewButton.get(createNewButton.size()-1).click();
			newCreatedId.get(newCreatedId.size()-1).sendKeys(replacementId);	
			addNewOptionIdButton.click();
			UtilHBM.waitTillElementDisappear(driver, "#new-id-input");
		}
		if(!replacementId.isEmpty())
			valueDisplayNameInput.sendKeys(replacementId);

		if (!possibleValueSearchString.isEmpty()) {
			UtilHBM.reportInfo("Adding possible products");
			clickAddProducts().addPossibleProducts(possibleValueSearchString, possibleValues);
		}

		if (!tags.isEmpty()) {
			clickAddTagsButton().addTags(tags);
		}

		if (!possibleValueSearchString.isEmpty()) {
			UtilHBM.reportInfo("Adding default product");
			clickDefaultMaterial().addDefaultProduct(possibleValueSearchString, possibleValues);
		}

		clickValidateButton();
		return PageFactory.initElements(driver, Product.class);
	}
	
	
	Product addMaterialVariation(boolean visibleToggle,boolean editableToggle,String materialId,String materialType,String possibleMaterialsSearchString,String possibleMaterials)
	{
		if(visibleToggle==true)
		{
			visibleToggleDimsn.click();
		}
		if(editableToggle==true)
		{
			editableToggleDimsn.click();
		}
		if(materialType.contentEquals("Default"))
		{
			new Select(selectID).selectByVisibleText(materialId);
		}
		else if(materialType.contentEquals("New"))
		{
			createNewButton.get(createNewButton.size()-1).click();
			newCreatedId.get(newCreatedId.size()-1).sendKeys(materialId);	
			addNewOptionIdButton.click();
		}
		valueDisplayNameInput.sendKeys(materialId);
		clickAddProducts()
		.addPossibleMaterials(possibleMaterialsSearchString,possibleMaterials)
		.clickAddTagsButton()		
		.addMaterialTags(possibleMaterialsSearchString);
		UtilHBM.reportInfo("Adding default Material");
		clickDefaultMaterial()
		.addDefaultMaterial(possibleMaterialsSearchString,possibleMaterials.split(";")[0])
		.clickValidateButton();	
		return PageFactory.initElements(driver, Product.class);
				
	}
	
	Level2DlgBox clickDefaultMaterial()
	{
		addDefaultMaterialButton.click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("body>div.fancybox-wrap.fancybox-desktop.fancybox-type-iframe.fancybox-opened>div>div>div>iframe")));
		return PageFactory.initElements(driver, Level2DlgBox.class);
	}
	
	
	Level2DlgBox clickAddTagsButton()
	{
		UtilHBM.waitExplicitDisplayed(driver, addTagsButton);
		addTagsButton.click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("body>div.fancybox-wrap.fancybox-desktop.fancybox-type-iframe.fancybox-opened>div>div>div>iframe")));
		return PageFactory.initElements(driver, Level2DlgBox.class);
	}
	
	
	Level2DlgBox clickAddProducts()
	{
		addProductsButton.click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("body>div.fancybox-wrap.fancybox-desktop.fancybox-type-iframe.fancybox-opened>div>div>div>iframe")));
		return PageFactory.initElements(driver, Level2DlgBox.class);
	}
	
	
	Product addOptionContinuous(boolean visibleToggle,boolean editableToggle,String optionId,String optionType,int min,int defaultVal,int max)
	{
		if(visibleToggle==true)
		{
			visibleToggleDimsn.click();
		}
		if(editableToggle==true)
		{
			editableToggleDimsn.click();
		}
		if(optionType.contentEquals("Default"))
		{
			new Select(selectID).selectByVisibleText(optionId);
		}
		else if(optionType.contentEquals("New"))
		{
			createNewButton.get(createNewButton.size()-1).click();
			newCreatedId.get(newCreatedId.size()-1).sendKeys(optionId);	
			addNewOptionIdButton.click();
		}
		optionDisplayNameInput.sendKeys(optionId);
		new Select(selectType).selectByValue("range");
		possibleMinValueInput.sendKeys(String.valueOf(min));
		possibleDefaultValueInput.sendKeys(String.valueOf(defaultVal));
		possibleMaxValueInput.sendKeys(String.valueOf(max));
		stepAddOptionInputBox.clear();
		stepAddOptionInputBox.sendKeys("1");
		clickValidateButton();
		return PageFactory.initElements(driver, Product.class);
	}
	Product addOptionDiscrete(boolean visibleToggle,boolean editableToggle,String optionId,String optionType,String possibleValues,String defaultVal)
	{
		if(visibleToggle==true)
		{
			visibleToggleDimsn.click();
		}
		if(editableToggle==true)
		{
			editableToggleDimsn.click();
		}
		if(optionType.contentEquals("Default"))
		{
			new Select(selectID).selectByVisibleText(optionId);
		}
		else if(optionType.contentEquals("New"))
		{
			createNewButton.get(createNewButton.size()-1).click();
			newCreatedId.get(newCreatedId.size()-1).sendKeys(optionId);	
			addNewOptionIdButton.click();
		}
		optionDisplayNameInput.sendKeys(optionId);
		new Select(selectType).selectByValue("collection");
		if(possibleValues.contains(";"))
		{
			for(String a:possibleValues.split(";"))
			{
				possibleValueInput.get(possibleValueInput.size()-1).sendKeys(a.split(">")[0]);
				possibleValueNameInput.get(possibleValueInput.size()-1).sendKeys(a.split(">")[1]);
				if(possibleValueNameInput.size()==possibleValues.split(";").length)
					break;
				addPossibleValuesButton.get(addPossibleValuesButton.size()-1).click();
			}
		}
		else
		{
			possibleValueInput.get(possibleValueInput.size()-1).sendKeys(possibleValues.split(">")[0]);
			possibleValueNameInput.get(possibleValueNameInput.size()-1).sendKeys(possibleValues.split(">")[1]);
		}
		defaultValueInput.sendKeys(defaultVal);
		clickValidateButton();
		return PageFactory.initElements(driver, Product.class);
	}
	Product editOptionDiscrete(boolean visibleToggle,boolean editableToggle,String optionId,String optionType,String possibleValues,String defaultVal)
	{
		if(visibleToggle==true)
		{
			visibleToggleDimsn.click();
		}
		if(editableToggle==true)
		{
			editableToggleDimsn.click();
		}
		if(optionType.contentEquals("Default"))
		{
			new Select(selectID).selectByVisibleText(optionId);
		}
		else if(optionType.contentEquals("New"))
		{
			createNewButton.get(createNewButton.size()-1).click();
			newCreatedId.get(newCreatedId.size()-1).sendKeys(optionId);	
			addNewOptionIdButton.click();
		}
//		optionDisplayNameInput.sendKeys(optionId);
		new Select(selectType).selectByValue("collection");
		if(possibleValues.contains(";"))
		{
			for(String a:possibleValues.split(";"))
			{
				possibleValueInput.get(possibleValueInput.size()).clear();
				possibleValueInput.get(possibleValueInput.size()-1).sendKeys(a.split(">")[0]);
				possibleValueNameInput.get(possibleValueInput.size()-1).sendKeys(a.split(">")[1]);
				if(possibleValueNameInput.size()==possibleValues.split(";").length)
					break;
				addPossibleValuesButton.get(addPossibleValuesButton.size()-1).click();
			}
		}
		else
		{
			possibleValueInput.get(possibleValueInput.size()-1).clear();
			possibleValueInput.get(possibleValueInput.size()-1).sendKeys(possibleValues.split(">")[0]);
			possibleValueNameInput.get(possibleValueNameInput.size()-1).sendKeys(possibleValues.split(">")[1]);
		}
		defaultValueInput.clear();
		defaultValueInput.sendKeys(defaultVal);
		clickValidateButton();
		return PageFactory.initElements(driver, Product.class);
	}
	Product addOptionBoolean(boolean visibleToggle,boolean editableToggle,String optionId,String optionType,String defaultVal)
	{
		if(visibleToggle==true)
		{
			visibleToggleDimsn.click();
		}
		if(editableToggle==true)
		{
			editableToggleDimsn.click();
		}
		if(optionType.contentEquals("Default"))
		{
			new Select(selectID).selectByVisibleText(optionId);
		}
		else if(optionType.contentEquals("New"))
		{
			createNewButton.get(createNewButton.size()-1).click();
			newCreatedId.get(newCreatedId.size()-1).sendKeys(optionId);	
			addNewOptionIdButton.click();
		}
		optionDisplayNameInput.sendKeys(optionId);
		new Select(selectType).selectByValue("boolean");
		if(defaultVal.contentEquals("True"))
			new Select(booleanOptionDefaultValue).selectByValue("1");
		else
			new Select(booleanOptionDefaultValue).selectByValue("0");
		clickValidateButton();	
		return PageFactory.initElements(driver, Product.class);
	}
	
	Product addDimsnVariationDiscrete(boolean visibleToggle,boolean editableToggle,String variationId,String idType,String possibleValues,String defaultVal)
	{
//		UtilHBM.waitFixTime(3000);
		if(visibleToggle==true)
		{
			visibleToggleDimsn.click();
		}
		if(editableToggle==true)
		{
			editableToggleDimsn.click();
		}
		if(idType.contentEquals("Default"))
		{
			new Select(selectID).selectByVisibleText(variationId);
		}
		else if (idType.contentEquals("New")) {
			createNewButton.get(createNewButton.size() - 1).click();
			newCreatedId.get(newCreatedId.size() - 1).sendKeys(variationId);
			addNewDimsnIdButton.click();
			UtilHBM.waitTillElementDisappear(driver, "#new-id-input");
			displayNameInput.sendKeys(variationId);
		}
		new Select(selectType).selectByValue("collection");	
		if(possibleValues.contains(";"))
		{
			for(String a:possibleValues.split(";"))
			{
				possibleValueInput.get(possibleValueInput.size()-1).sendKeys(a.split(">")[0]);
				possibleValueNameInput.get(possibleValueInput.size()-1).sendKeys(a.split(">")[1]);
				if(possibleValueNameInput.size()==possibleValues.split(";").length)
					break;
				addPossibleValuesButton.get(addPossibleValuesButton.size()-1).click();
			}
		}
		else
		{
			possibleValueInput.get(possibleValueInput.size()-1).sendKeys(possibleValues.split(">")[0]);
			possibleValueNameInput.get(possibleValueNameInput.size()-1).sendKeys(possibleValues.split(">")[1]);
		}
		defaultValueInput.sendKeys(defaultVal);
		clickValidateButton();
		return PageFactory.initElements(driver, Product.class);
	}
	
	Product addDimsnVariationContiuous(boolean visibleToggle,boolean editableToggle,String variationId,String idType,int min,int defaultVal,int max)
	{
		if(visibleToggle==true)
		{
			visibleToggleDimsn.click();
		}
		if(editableToggle==true)
		{
			editableToggleDimsn.click();
		}
		if(idType.contentEquals("Default"))
		{
			new Select(selectID).selectByVisibleText(variationId);
			new Select(selectType).selectByValue("range");
		}
		else if(idType.contentEquals("New"))
		{
			createNewButton.get(createNewButton.size()-1).click();
			newCreatedId.get(newCreatedId.size()-1).sendKeys(variationId);
			addNewDimsnIdButton.click();
			UtilHBM.waitTillElementDisappear(driver, "#new-id-input");
			new Select(selectType).selectByValue("range");
			displayNameInput.sendKeys(variationId);
		}
		possibleMinValueInput.sendKeys(String.valueOf(min));
		possibleDimDefaultValueInput.sendKeys(Keys.CONTROL + Keys.chord("a"));
		possibleDimDefaultValueInput.sendKeys(String.valueOf(defaultVal));
		possibleMaxValueInput.sendKeys(String.valueOf(max));
		stepDimVariInputBox.clear();
		stepDimVariInputBox.sendKeys("1");
		clickValidateButton();
		return PageFactory.initElements(driver, Product.class);
	}
	
	
	Product clickValidateButton()
	{
		validateButton.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, Product.class);
	}
}
