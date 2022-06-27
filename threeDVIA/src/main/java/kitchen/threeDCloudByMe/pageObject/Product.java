package kitchen.threeDCloudByMe.pageObject;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class Product {

	WebDriver driver;

	public Product(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(css="div>label[for='product_reference']")
	WebElement productLabel1;

	@FindBy(css="div>label[for='product_type']")
	WebElement productLabel2;

	@FindBy(css="a>span.text-XS")
	WebElement productTypeNote;

	@FindBy(css="div>label[for='product_brand']")
	WebElement brandLabel;

	@FindBy(css="div.steps>div[data-step='information']>label")
	WebElement pageSubtitle1;

	@FindBy(css="div.steps>div[data-step='representation']>label")
	WebElement pageSubtitle2;

	@FindBy(css="div.steps>div[data-step='pricing']>label")
	WebElement pageSubtitle3;

	@FindBy(css="#form-commercial-container>div:nth-child(1)>span")
	WebElement pageSubtitle4;

	@FindBy(css="#form-commercial-container>div.col-xs-12.u-mtxs.u-mbs>span")
	WebElement pageSubtitle5;

	@FindBy(css="#form-classification-container>div.u-mbs>span")
	WebElement pageSubtitle6;

	@FindBy(css="label[for='product_startDate']")
	WebElement label1;

	@FindBy(css="label[for='product_endDate']")
	WebElement label2;

	@FindBy(css="label[for='product_basicInfo_language']")
	WebElement label3;

	@FindBy(css="#form-commercial-container>div:nth-child(5)>label")
	WebElement label4;

	@FindBy(css="#form-commercial-container>div:nth-child(6)>label")
	WebElement label5;

	@FindBy(css="#form-commercial-container>div:nth-child(7)>label")
	WebElement label6;

	@FindBy(css="#form-commercial-container>div:nth-child(8)>label")
	WebElement label7;

	@FindBy(css="label[for='product_classificationInfo_materials']")
	WebElement label8;

	@FindBy(css="label[for='product_classificationInfo_color']")
	WebElement label9;

	@FindBy(css="label[for='product_classificationInfo_styles']")
	WebElement label10;

	@FindBy(css="label[for='product_classificationInfo_places']")
	WebElement label11;

	@FindBy(css="label[for='product_classificationInfo_openTags']")
	WebElement label12;

	@FindBy(css=".upload-model>div>span")
	WebElement label13;
	
	@FindBy(css="div.upload-model>dropdown>label")
	WebElement label14;
	
	@FindBy(css="div.upload-model>label[for='model3DFileLow']")
	WebElement label15;
	
	@FindBy(css="#thumbnail-content>div.upload-thumbnail>div.u-mbs>span")
	WebElement label16;
	
	@FindBy(css="#thumbnail-content>div.upload-thumbnail>label")
	WebElement label17;
	
	@FindBy(css="#thumbnail-content>div.upload-thumbnail>div:nth-child(4)>span")
	WebElement label18;
	
	@FindBy(css="#thumbnail-content>div.upload-thumbnail-accept>span")
	WebElement label19;
	
	@FindBy(css="div.upload-model>label[for='model3DFileHigh']")
	WebElement label20;
	
	@FindBy(id="product_names_values_en")
	WebElement productNameInput;

	@FindBy(id="product_reference")
	WebElement productRefInput;

	@FindBy(css="div[id='product_type_chosen']>a")
	WebElement type;

	@FindBy(css="div[id='product_type_chosen']>div>div>input")
	WebElement typeSearchInput;
	
	@FindBy(css="#product_brand")
	WebElement brandSelect;

	@FindBy(css="div[id='product_classificationInfo_materials_chosen']")
	WebElement materialsTag;

	@FindBy(css="div[id='product_classificationInfo_materials_chosen']>ul>li>input")
	WebElement materialsTagInput;

	@FindBy(css="#product_classificationInfo_color_chosen")
	WebElement colorsTag;
	
	@FindBy(xpath="//div[@id='product_classificationInfo_styles_chosen']/ul/li/span")
	List<WebElement> stylesTagList;	
	
	@FindBy(css="#product_classificationInfo_styles_chosen")
	WebElement stylesTag;
	
	@FindBy(css="#product_classificationInfo_styles_chosen>ul>li>input")
	WebElement stylesTagInput;

	@FindBy(css="#product_classificationInfo_places_chosen")
	WebElement roomTag;
	
	@FindBy(xpath="//div[@id='product_classificationInfo_places_chosen']/ul/li/span")
	List<WebElement> roomTagList;
	
	@FindBy(css="#product_classificationInfo_places_chosen>ul>li>input")
	WebElement roomTagInput;
	
	@FindBy(css="#product_descriptions_values_en")
	WebElement commDescInput;
	
	@FindBy(css="#product_classificationInfo_color_chosen>div>div>input")
	WebElement colorTagInput;

	@FindBy(css="div.col-xs-12.steps-container>div>div[data-step='representation']")
	WebElement productRepresentationButton;

	@FindBy(css="#product_startDate")
	WebElement sDate;

	@FindBy(css="#product_endDate")
	WebElement eDate;	
	
	@FindBy(css="label[for='product_technicalInfo_openingShape']")
	WebElement prdLabel6;

	@FindBy(css="label[for='product_technicalInfo_targetPosition']")
	WebElement prdLabel7;

	@FindBy(css="label[for='product_technicalInfo_defaultAltitude']")
	WebElement prdLabel8;

	@FindBy(css="label[for='product_technicalInfo_manipMode']")
	WebElement prdLabel9;

	@FindBy(css="label[for='product_technicalInfo_ungroupable']")
	WebElement prdLabel10;

	@FindBy(css="#technical-ungroupable>div.col-xs-6>div:nth-child(2)>span.text-breadcrumb")
	WebElement prdLabel11;

	@FindBy(css="label[for='product_technicalInfo_collide']")
	WebElement prdLabel12;

	@FindBy(css="#technical-collide>div>div:nth-child(2)>span")
	WebElement prdLabel13;
	
	@FindBy(css="dropdown[class='dd-init-upload en']")
	WebElement uploadDropdownButton;
	
	@FindBy(css="input[id='model3DFile']")
	WebElement uploadBM3;
	
	@FindBy(css="div[class='upload-model']>dropdown>ul>li>label[class='upload-once-model ']")
	WebElement singleSourceButton;

	@FindBy(css="div[class='upload-model']>dropdown>ul>li>label[class='upload-model-label-qa'][for='model3DFileHigh']")
	WebElement highQualityButton;
	
	@FindBy(css="input[id='model3DFileHigh']")
	WebElement highQualityInput;
	
	@FindBy(css="div[class='upload-model']>dropdown>ul>li>label[class='upload-model-label-qa'][for='model3DFile']")
	WebElement mediumQualityButton;
	
	@FindBy(css="input[id='model3DFileLow']")
	WebElement lowQualityInput;	
	
	@FindBy(css="div[class='upload-model']>dropdown>ul>li>label[class='upload-model-label-qa'][for='model3DFileLow']")
	WebElement lowQualityButton;
	
	@FindBy(css="dropdown[class='reupload-dd en']")
	WebElement reupload3DModel;

	@FindBy(css="#thumbnailFile")
	WebElement uploadImg;

	@FindBy(css="#addDimensionVariation")
	WebElement addDimensionButton;

	@FindBy(css="#parameterDimensions>div>div>div>div>div[class='col-xs-6 align-left']")
	List<WebElement> addedDimsnVariation;

	@FindBy(css="#addOption")
	WebElement addOptionButton;

	@FindBy(css="#parameterOptions>div>div>div>div>div[class='col-xs-6 align-left']")
	List<WebElement> addedOptions;

	@FindBy(css="#addMaterialVariation")
	WebElement addMaterialVariationButton;

	@FindBy(css="#parameterMaterials>div>div>div>div>div[class='col-xs-6 align-left']")
	List<WebElement> addedMaterials;

	@FindBy(css="#addProductVariation")
	WebElement addPrdRepButton;

	@FindBy(css="#parameterProducts>div>div>div>div>div[class='col-xs-6 align-left']")
	List<WebElement> addedProductReplacements; 

	@FindBy(css="div.steps>div[data-step='pricing']")
	WebElement pricingButton;

	@FindBy(css="div>table>tbody>tr>td.table-checkbox")
	List<WebElement> priceList;

	@FindBy(css="#button-delete-price")
	WebElement deletePriceButton;

	@FindBy(css="#button-add-price>span")
	WebElement addPriceButton;

	@FindBy(css="button[title='Add parameters']>span")
	WebElement addParametersButton;

	@FindBy(css="input[id*='product_prices_'][id$='type']")
	WebElement priceTypeInput;

	@FindBy(css="input[id*='product_prices_'][id$='value']")
	WebElement priceInput;

	@FindBy(css="select[id*='product_prices_'][id$='currency']")
	WebElement currencyInput;

	@FindBy(css="input[id*='product_prices_'][id$='_startDate']")
	WebElement priceStartDate;

	@FindBy(css="input[id*='product_prices_'][id$='_endDate']")
	WebElement priceEndPrice;

	@FindBy(css="#btnSubmitForm")
	WebElement saveButton;

	@FindBy(css=".footer-fixed>.mod-notification>.success.show")
	WebElement prdCreatedAlert;

	@FindBy(css="#js-breadcrumb-back-btn")
	WebElement backButton;
	
	@FindBy(css=".dataTables_processing")
	List<WebElement> processingLabel;

	@FindBy(css="div[class='row parameter-item u-mbxs']")
	List<WebElement> parameters;

	@FindBy(css="#parameterDimensions>div>div>button[title='Delete']")
	List<WebElement> deleteDimensionParametersButton;

	@FindBy(css="#parameterMaterials>div>div>button[title='Delete']")
	List<WebElement> deleteMaterialParametersButton;

	@FindBy(css="#parameterOptions>div>div>button[title='Delete']")
	List<WebElement> deleteOptionParametersButton;

	@FindBy(css="#parameterProducts>div>div>button[title='Delete']")
	List<WebElement> deleteProductParametersButton;

	@FindBy(xpath="//*[@id='addDimensionVariation']")
	WebElement addDimsn;
	
	@FindBy(css="body>main>article>div>div>div>span.text-XL")
	private WebElement accessDeniedMsg;
	
	@FindBy(css="body>main>article>div>div>div>span.text-L.bold")
	WebElement permissionMsg;
	
	@FindBy(css="#product_type_chosen>a>span")
	WebElement productNameVerify;
	
	@FindBy(css="div.col-xs-5>div>ul>li>span")
	WebElement materialTagVerify;
	
	@FindBy(css="div.col-xs-5>div>a>span")
	WebElement colorTagVerify;
	
	@FindBy(xpath="//div[@id='product_classificationInfo_materials_chosen']/ul/li/span")
	List<WebElement> materialTagList;
	
	@FindBy(css="a[id='logout-link']")
	private WebElement logoutButton;

	@FindBy(xpath="//div[@class='mod-notification']/p[contains(@class, 'error') and contains(text(), 'Permission denied')]")
	private WebElement permissionDeniedErrPopup;

	@FindBy(css="div#parameterProducts div.row.parameter-item")
	private List<WebElement> productReplacements;

	@FindBy(css="#technical-replaceable div.toggle")
	private WebElement isProductReplaceableOption;



	private static boolean flag=true;

	
	public Product setProductName(String productName,String role)
	{
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		productNameInput.clear();
		productNameInput.sendKeys(productName+"_"+role+"_"+s);
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product productNameVerify(String productName,String role)
	{
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		Verification.VerifyEquals("Product Name incorrect", productNameInput.getAttribute("value"), productName+"_"+role+"_"+s);
		return PageFactory.initElements(driver, Product.class);
	}

	public Product productNameVerify(String productName)
	{
		Verification.VerifyEquals("Product Name incorrect", productNameInput.getAttribute("value"), productName);
		return PageFactory.initElements(driver, Product.class);
	}

	public Product productNameReviewerVerify(String productName,String role)
	{
		
		Verification.disabledWebElement(productNameInput);
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		Verification.VerifyEquals("Product Name incorrect", productNameInput.getAttribute("value"), productName+"_"+role+"_"+s);
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product setProductRef(String productReference,String role)
	{
		DateFormat dateFormat1=new SimpleDateFormat("dd_MM_yyyy_HH_mm");
		Date date1=new Date();
		String s1=dateFormat1.format(date1);
		productRefInput.clear();
		productRefInput.sendKeys(productReference+"_"+role+"_ref_"+s1);
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product productRefVerify(String productName,String role)
	{
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		if(productRefInput.getAttribute("value").contains(productName+"_"+role+"_ref_"+s))
		{
			UtilHBM.reportOK("Product reference verified");
		}
		else
		{
			UtilHBM.reportKO("Product reference incorrect");
		}
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product productRefReviewerVerify(String productName,String role)
	{
		Verification.disabledWebElement(productRefInput);
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		if(productRefInput.getAttribute("value").contains(productName+"_"+role+"_ref_"+s))
		{
			UtilHBM.reportOK("Product reference verified");
		}
		else
		{
			UtilHBM.reportKO("Product reference incorrect");
		}
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product setProductType(String productType)
	{
		type.click();
		typeSearchInput.sendKeys(productType);
		WebElement typeInput = driver.findElement(By.xpath("//div/ul/li[.='"+productType+"']"));
		typeInput.click();
		return PageFactory.initElements(driver, Product.class);
	}
	 
	public Product productTypeVerify(String productType)
	{
		Verification.VerifyEquals("Product type incorrect", type.findElement(By.cssSelector("span")).getText(),productType);
		return PageFactory.initElements(driver, Product.class);
				
	}
	
	public Product setBrand(String brandName)
	{
		new Select(brandSelect).selectByVisibleText(brandName);
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product productTypeReviewerVerify(String productType)
	{
		Verification.disabledWebElement(type);
		Verification.VerifyEquals("Product type incorrect", type.findElement(By.cssSelector("span")).getText(),productType);
		return PageFactory.initElements(driver, Product.class);
				
	}
	
	public Product setProductDate()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		String startDate = sdf.format(c.getTime());
		c.setTime(new Date());
		c.add(Calendar.DATE, 2);
		String endDate = sdf.format(c.getTime());
		sDate.clear();
		sDate.sendKeys(startDate);
		eDate.clear();
		eDate.sendKeys(endDate);
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product setCommercialDesc(String commDesc)
	{
		commDescInput.clear();
		commDescInput.sendKeys(commDesc);
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product commercialDescVerify(String commDesc)
	{
		Verification.VerifyEquals("Commercial desc incorrect",commDescInput.getAttribute("value"),commDesc);	
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product commercialDescReviewerVerify(String commDesc)
	{
		Verification.disabledWebElement(commDescInput);
		Verification.VerifyEquals("Commercial desc incorrect",commDescInput.getAttribute("value"),commDesc);	
		return PageFactory.initElements(driver, Product.class);
	}
	public Product setMaterialsTag(String materialTagName)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(materialTagList.size()>0)
		{
			for(int i=0;i<materialTagList.size();i++)
			{
				materialTagList.get(i).findElement(By.xpath("parent::li/a")).click();
			}
		}
		UtilHBM.turnOnImplicitWaits(driver);
		materialsTagInput.click();
		materialsTagInput.sendKeys(materialTagName);
		WebElement matTag = driver.findElement(By.xpath("//div/ul/li[.='"+materialTagName+"']"));
		matTag.click();
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product materialTagVerify(String materialTagName)
	{
		if(materialTagName.contains(";"))
		{
			for(String a:materialTagName.split(";"))
			{
				for(int i=0;i<materialTagList.size();i++)
				{
					Verification.VerifyEquals("Incorrect material tag name", materialTagList.get(i).getText(), a);
				}
			}
		}
		else
		{
			Verification.VerifyEquals("Incorrect material tag name", materialTagList.get(0).getText(), materialTagName);
		}
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product materialTagReviewerVerify(String materialTagName)
	{
		if(materialTagName.contains(";"))
		{
			for(String a:materialTagName.split(";"))
			{
				for(int i=0;i<materialTagList.size();i++)
				{
					Verification.disabledWebElement(materialTagList.get(i));
					Verification.VerifyEquals("Incorrect material tag name", materialTagList.get(i).getText(), a);
				}
			}
		}
		else
		{
			Verification.disabledWebElement(materialTagList.get(0));
			Verification.VerifyEquals("Incorrect material tag name", materialTagList.get(0).getText(), materialTagName);
		}
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product setColorTag(String colorTagName)
	{
		colorsTag.click();
		colorTagInput.sendKeys(colorTagName);
		WebElement colorTag = driver.findElement(By.xpath("//div/ul/li[.='"+colorTagName+"']"));
		colorTag.click();
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product colorTagVerify(String colorTagName)
	{
		Verification.VerifyEquals("Incorrect color tag name", colorsTag.findElement(By.cssSelector("span")).getText(), colorTagName);
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product colorTagReviewerVerify(String colorTagName)
	{
		Verification.disabledWebElement(colorsTag);
		Verification.VerifyEquals("Incorrect color tag name", colorsTag.findElement(By.cssSelector("span")).getText(), colorTagName);
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product setStylesTag(String stylesTagName)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(stylesTagList.size()>0)
		{
			for(int i=0;i<stylesTagList.size();i++)
			{
				stylesTagList.get(i).findElement(By.xpath("parent::li/a")).click();
			}
		}
		UtilHBM.turnOnImplicitWaits(driver);
		stylesTag.click();
		stylesTagInput.sendKeys(stylesTagName);
		WebElement reqStylesTag = driver.findElement(By.xpath("//div/ul/li[.='"+stylesTagName+"']"));
		reqStylesTag.click();
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product stylesTagVerify(String stylesTagName)
	{
		if(stylesTagName.contains(";"))
		{
			for(String a:stylesTagName.split(";"))
			{
				for(int i=0;i<stylesTagList.size();i++)
				{
					Verification.VerifyEquals("Incorrect material tag name", stylesTagList.get(i).getText(), a);
				}
			}
		}
		else
		{
			Verification.VerifyEquals("Incorrect material tag name", stylesTagList.get(0).getText(), stylesTagName);
		}
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product stylesTagReviewerVerify(String stylesTagName)
	{
		if(stylesTagName.contains(";"))
		{
			for(String a:stylesTagName.split(";"))
			{
				for(int i=0;i<stylesTagList.size();i++)
				{
					Verification.disabledWebElement(stylesTagList.get(i));
					Verification.VerifyEquals("Incorrect material tag name", stylesTagList.get(i).getText(), a);
				}
			}
		}
		else
		{
			Verification.disabledWebElement(stylesTagList.get(0));
			Verification.VerifyEquals("Incorrect material tag name", stylesTagList.get(0).getText(), stylesTagName);
		}
		return PageFactory.initElements(driver, Product.class);
	}
	
	
	public Product setRoomTag(String roomTagName)
	{
		UtilHBM.turnOffImplicitWaits(driver);
		if(roomTagList.size()>0)
		{
			for(int i=0;i<roomTagList.size();i++)
			{
				roomTagList.get(i).findElement(By.xpath("parent::li/a")).click();
			}
		}
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.scrollToElementWithOffset(driver, roomTag, -150);
		roomTag.click();
		roomTagInput.sendKeys(roomTagName);
		WebElement reqRoomTag = driver.findElement(By.xpath("//div/ul/li[.='"+roomTagName+"']"));
		reqRoomTag.click();
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product roomTagVerify(String roomTagName)
	{
		if(roomTagName.contains(";"))
		{
			for(String a:roomTagName.split(";"))
			{
				for(int i=0;i<roomTagList.size();i++)
				{
					Verification.VerifyEquals("Incorrect material tag name", roomTagList.get(i).getText(), a);
				}
			}
		}
		else
		{
			Verification.VerifyEquals("Incorrect material tag name", roomTagList.get(0).getText(), roomTagName);
		}
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product roomTagReviewerVerify(String roomTagName)
	{
		if(roomTagName.contains(";"))
		{
			for(String a:roomTagName.split(";"))
			{
				for(int i=0;i<roomTagList.size();i++)
				{
					Verification.disabledWebElement(roomTagList.get(i));
					Verification.VerifyEquals("Incorrect material tag name", roomTagList.get(i).getText(), a);
				}
			}
		}
		else
		{
			Verification.disabledWebElement(roomTagList.get(0));
			Verification.VerifyEquals("Incorrect material tag name", roomTagList.get(0).getText(), roomTagName);
		}
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product goToProductRepresentation()
	{
		productRepresentationButton.click();
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product editPicture(String productName)
	{
		
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product uploadPicture(String productName)
	{
		File file=new File(Setting.threeDCloudData+"Thumbnail/");
		File[] files=file.listFiles();
		for(File f:files)
		{
			if(f.getName().contains(productName))
			{
				if(f.getName().equalsIgnoreCase(productName+".png"))
				{
					uploadImg.sendKeys(new File(Setting.threeDCloudData+ "Thumbnail/" + productName+".png").getAbsolutePath());
					UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "#thumbnail-image"));
					UtilHBM.reportOK("BM3 image " +productName+" uploaded");
				}
				else if(f.getName().contains(productName+".jpg"))
				{
					uploadImg.sendKeys(new File(Setting.threeDCloudData+ "Thumbnail/" + productName+".jpg").getAbsolutePath());
					UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "#thumbnail-image"));
					UtilHBM.reportOK("BM3 image " +productName+" uploaded");
				}
			}
		}
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product edit3DModel(String productName,String modelType)
	{
		reupload3DModel.click();
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product upload3DModel(String productName,String quality,String modelType)
	{
		Verification.VerifyEquals("Label not displayed", label13.getText(),"Add a 3d model with the explore file bar");
		Verification.VerifyEquals("Label not displayed", "UPLOAD 3D MODELS", label14.getText());
		Verification.VerifyEquals("Label not displayed", "Add at least one picture by drag and drop or with the explore file bar", label16.getText());
		Verification.VerifyEquals("Label not displayed", "UPLOAD A PICTURE", label17.getText());
		Verification.VerifyEquals("Label not displayed", "(expected dimensions: 512x512)", label18.getText());
		Verification.VerifyEquals("Label not displayed", "Accepted format: .jpg, .png", label19.getText());
		uploadDropdownButton.click();
		UtilHBM.waitExplicitDisplayed(driver, singleSourceButton);
		UtilHBM.waitExplicitDisplayed(driver, highQualityButton);
		UtilHBM.waitExplicitDisplayed(driver, mediumQualityButton);
		UtilHBM.waitExplicitDisplayed(driver, lowQualityButton);
		Verification.VerifyEquals("Label not displayed", "SINGLE SOURCE", singleSourceButton.getText());
		Verification.VerifyEquals("Label not displayed", "HIGH-QUALITY",highQualityButton.getText());
		Verification.VerifyEquals("Label not displayed", "MEDIUM-QUALITY", mediumQualityButton.getText());
		Verification.VerifyEquals("Label not displayed", "LOW-QUALITY", lowQualityButton.getText());
		if(modelType.contentEquals("BM3MAT"))
		{	
			System.out.println(Setting.threeDCloudData+"BM3/"+productName+".BM3MAT");
			if(quality.contentEquals("Single"))
			{
				uploadBM3.sendKeys(new File(Setting.threeDCloudData+"BM3/"+productName+".BM3MAT").getAbsolutePath());
				UtilHBM.waitExplicitDisplayed(driver, reupload3DModel);
			}
			else if(quality.contentEquals("High"))
			{
				highQualityInput.sendKeys(new File(Setting.threeDCloudData+"BM3/"+productName+".BM3MAT").getAbsolutePath());
				UtilHBM.waitExplicitDisplayed(driver, reupload3DModel);
			}
			else if(quality.contentEquals("Low"))
			{
				lowQualityInput.sendKeys(new File(Setting.threeDCloudData+"BM3/"+productName+".BM3MAT").getAbsolutePath());
				UtilHBM.waitExplicitDisplayed(driver, reupload3DModel);
			}	
			
			UtilHBM.waitFixTime(3000);
		}
		else if(modelType.contentEquals("bm3"))
		{
			System.out.println(Setting.threeDCloudData+"BM3/"+productName+".BM3");
			if(quality.contentEquals("Single"))
			{
				uploadBM3.sendKeys(new File(Setting.threeDCloudData+"BM3/"+productName+".BM3").getAbsolutePath());
				UtilHBM.waitExplicitDisplayed(driver, reupload3DModel);
			}
			else if(quality.contentEquals("High"))
			{
				highQualityInput.sendKeys(new File(Setting.threeDCloudData+"BM3/"+productName+".BM3").getAbsolutePath());
				UtilHBM.waitExplicitDisplayed(driver, reupload3DModel);
			}
			else if(quality.contentEquals("Low"))
			{
				lowQualityInput.sendKeys(new File(Setting.threeDCloudData+"BM3/"+productName+".BM3").getAbsolutePath());
				UtilHBM.waitExplicitDisplayed(driver, reupload3DModel);
			}			
			Verification.VerifyEquals("Label not displayed", "Opening shape", prdLabel6.getText());
			Verification.VerifyEquals("Label not displayed", "Target position", prdLabel7.getText());
			Verification.VerifyEquals("Label not displayed", "Height from floor", prdLabel8.getText());
			Verification.VerifyEquals("Label not displayed", "Manip mode", prdLabel9.getText());
			Verification.VerifyEquals("Label not displayed", "Ungroupable", prdLabel10.getText());
			Verification.VerifyEquals("Label not displayed", "Indicates if the product can be ungrouped (relevant only if product contains sub products)", prdLabel11.getText());
			Verification.VerifyEquals("Label not displayed", "Allow collision", prdLabel12.getText());
			Verification.VerifyEquals("Label not displayed", "Indicates if the product can be collided by other elements during manipulation", prdLabel13.getText());

		}
		else if(modelType.contentEquals("bma"))
		{
			UtilHBM.waitFixTime(1500);
			System.out.println(Setting.threeDCloudData+"BM3/"+UtilHBM.getDate(0, "ddMMyyyy")+"_"+productName+".BMA");
			if(quality.contentEquals("Single"))
			{
				uploadBM3.sendKeys(new File(Setting.threeDCloudData+"BM3/"+UtilHBM.getDate(0, "ddMMyyyy")+"_"+productName+".BMA").getAbsolutePath());
				UtilHBM.waitExplicitDisplayed(driver, reupload3DModel);
			}
			else if(quality.contentEquals("High"))
			{
				highQualityInput.sendKeys(new File(Setting.threeDCloudData+"BM3/"+UtilHBM.getDate(0, "ddMMyyyy")+"_"+productName+".BMA").getAbsolutePath());
				UtilHBM.waitExplicitDisplayed(driver, reupload3DModel);
			}
			else if(quality.contentEquals("Low"))
			{
				lowQualityInput.sendKeys(new File(Setting.threeDCloudData+"BM3/"+UtilHBM.getDate(0, "ddMMyyyy")+"_"+productName+".BMA").getAbsolutePath());
				UtilHBM.waitExplicitDisplayed(driver, reupload3DModel);
			}
			UtilHBM.waitFixTime(3000);
			UtilHBM.waitExplicitDisplayed(driver, reupload3DModel);
		}
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product verifyUploadBm3()
	{
		UtilHBM.waitExplicitDisplayed(driver, reupload3DModel);
		Verification.VerifyEquals("Bm3 model not uploaded", reupload3DModel.getText(),"CHANGE MODELS");
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product deleteExistingVariations()
	{
		if(parameters.size()>0)
		{
			UtilHBM.reportInfo("Deleting old parameters");
			while(parameters.size()!=0)
			{
				addDimsn.sendKeys(Keys.END);
				for(int i=0;i<deleteDimensionParametersButton.size();i++)
					deleteDimsnParameters().clickYesButton();
				for(int i=0;i<deleteMaterialParametersButton.size();i++)
					deleteMatParameters().clickYesButton();
				for(int i=0;i<deleteOptionParametersButton.size();i++)
					deleteOptionParameters().clickYesButton();
				for(int i=0;i<deleteProductParametersButton.size();i++)
					deleteProductParameters().clickYesButton();
				if(parameters.size()==0)
				{
					UtilHBM.reportOK("All old parameters deleted successfully");
				}

			}
		}
		return PageFactory.initElements(driver, Product.class);
	}
		
	public Product addDimensionVariationContinuous(boolean visibleToggle,boolean editableToggle,String dimensionId,String idType,int min,int defaultVal,int max)
	{
		clickDimsnVariation()
		.addDimsnVariationContiuous(visibleToggle,editableToggle,dimensionId,idType,min,defaultVal,max);
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product dimensionVariationVerify(String variationId,String displayName,String defaultVal)
	{
		Verification.VerifyEquals("Variation id incorrect", UtilHBM.webElementXPath(driver, "//div[@id='parameterDimensions']/div/div/div/div/div[@class='col-xs-8 parameter-item-id align-left'][contains(text(),'"+variationId+"')]").getText(), variationId);
		Verification.VerifyEquals("Display name incorrect", UtilHBM.webElementXPath(driver, "//div[@id='parameterDimensions']/div/div/div/div/div[@class='col-xs-8 parameter-item-id align-left'][contains(text(),'"+variationId+"')]/parent::div/parent::div/parent::div/parent::div/div/div/div/div[@class='col-xs-6 align-left']").getText(), displayName);
		Verification.VerifyEquals("Default value incorrect", UtilHBM.webElementXPath(driver, "//div[@id='parameterDimensions']/div/div/div/div/div[@class='col-xs-8 parameter-item-id align-left'][contains(text(),'"+variationId+"')]/parent::div/parent::div/parent::div/parent::div/div[@class='col-xs-1 align-left']").getText(), defaultVal);
		return PageFactory.initElements(driver, Product.class);
	}
	
	@FindBy(css="div.row.parameter-item.u-mbxs")
	List<WebElement> parameterList;
	
	public Product addDimensionVariationDiscrete(boolean visibleToggle,boolean editableToggle,String dimensionId,String idType,String possibleValues,String defaultVal)
	{
		clickDimsnVariation()
		.addDimsnVariationDiscrete(visibleToggle,editableToggle,dimensionId, idType, possibleValues, defaultVal);
		for(int i=0;i<parameterList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, parameterList.get(i));
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product addOptionContinous(boolean visibleToggle,boolean editableToggle,String optionId,String optionType,int min,int defaultVal,int max)
	{
		clickOption()
		.addOptionContinuous(visibleToggle,editableToggle,optionId, optionType, min, defaultVal, max);
		for(int i=0;i<parameterList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, parameterList.get(i));
		return PageFactory.initElements(driver, Product.class);

	}
	
	public Product optionVerify(String optionId,String optionDisplayName,String optionDefaultVal)
	{
		Verification.VerifyEquals("Option id incorrect", UtilHBM.webElementXPath(driver, "//div[@id='parameterOptions']/div/div/div/div/div[@class='col-xs-8 parameter-item-id align-left'][contains(text(),'"+optionId+"')]").getText(), optionId);
		Verification.VerifyEquals("Option Display name incorrect", UtilHBM.webElementXPath(driver, "//div[@id='parameterOptions']/div/div/div/div/div[@class='col-xs-8 parameter-item-id align-left'][contains(text(),'"+optionId+"')]/parent::div/parent::div/parent::div/parent::div/div/div/div/div[@class='col-xs-6 align-left']").getText(), optionDisplayName);
		Verification.VerifyEquals("Option Default value incorrect", UtilHBM.webElementXPath(driver, "//div[@id='parameterOptions']/div/div/div/div/div[@class='col-xs-8 parameter-item-id align-left'][contains(text(),'"+optionId+"')]/parent::div/parent::div/parent::div/parent::div/div[@class='col-xs-1 align-left']").getText(), optionDefaultVal);
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product addOptionDiscrete(boolean visibleToggle,boolean editableToggle,String optionId,String optionType,String possibleValues,String defaultVal)
	{
		clickOption()
		.addOptionDiscrete(visibleToggle,editableToggle,optionId, optionType, possibleValues, defaultVal);
		for(int i=0;i<parameterList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, parameterList.get(i));
		return PageFactory.initElements(driver, Product.class);
	}
	public Product editOptionDiscrete(boolean visibleToggle,boolean editableToggle,String optionId,String optionType,String possibleValues,String defaultVal)
	{
		editOption(optionId)
		.editOptionDiscrete(visibleToggle, editableToggle, optionId, optionType, possibleValues, defaultVal);
		for(int i=0;i<parameterList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, parameterList.get(i));
		return PageFactory.initElements(driver, Product.class);
	}
	public Product addOptionBoolean(boolean visibleToggle,boolean editableToggle,String optionId,String optionType,String defaultVal)
	{
		clickOption()
		.addOptionBoolean(visibleToggle,editableToggle,optionId, optionType, defaultVal);
		for(int i=0;i<parameterList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, parameterList.get(i));
		return PageFactory.initElements(driver, Product.class);
	}
	public Product deleteVariableDimensions(String variationName)
	{
		            deleteVariationDimension(variationName).clickYesButton();                 
		for(int i=0;i<parameterList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, parameterList.get(i));
		return PageFactory.initElements(driver, Product.class);
	}
	
	
	public Product addMaterialReplacement(boolean visibleToggle,boolean editableToggle,String materialId,String materialType,String possibleMaterialsSearchString,String possibleMaterials)
	{
		clickAddMatVarButton()
		.addMaterialVariation(visibleToggle,editableToggle,materialId, materialType, possibleMaterialsSearchString, possibleMaterials);
		for(int i=0;i<parameterList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, parameterList.get(i));
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product materialVerify(String materialId,String materialDisplayName,String materialDefaultVal)
	{
		Verification.VerifyEquals("Material id incorrect", UtilHBM.webElementXPath(driver, "//div[@id='parameterMaterials']/div/div/div/div/div[@class='col-xs-8 parameter-item-id align-left'][contains(text(),'"+materialId+"')]").getText(), materialId);
		Verification.VerifyEquals("Material Display name incorrect", UtilHBM.webElementXPath(driver, "//div[@id='parameterMaterials']/div/div/div/div/div[@class='col-xs-8 parameter-item-id align-left'][contains(text(),'"+materialId+"')]/parent::div/parent::div/parent::div/parent::div/div/div/div/div[@class='col-xs-6 align-left']").getText(), materialDisplayName);
		Verification.VerifyEquals("Material Default value incorrect", UtilHBM.webElementXPath(driver, "//div[@id='parameterMaterials']/div/div/div/div/div[@class='col-xs-8 parameter-item-id align-left'][contains(text(),'"+materialId+"')]/parent::div/parent::div/parent::div/parent::div/div[@class='col-xs-1 align-left']").getText(), materialDefaultVal);
		return PageFactory.initElements(driver, Product.class);
	}
	
	
	public Product addProductReplacement(boolean visibleFlag, boolean editableFlag, String replacementId, String replacementType, String possibleValueSearchString, String possibleValues, String tags)
	{
		clickAddPrdRepButton()
		.addProductReplacement(visibleFlag, editableFlag, replacementId, replacementType, possibleValueSearchString, possibleValues, tags);
		for(int i=0;i<parameterList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, parameterList.get(i));
		return PageFactory.initElements(driver, Product.class);
	}

	public Product editProductReplacement(String id, boolean visibleFlag, boolean editableFlag, String replacementId, String replacementType, String possibleValueSearchString, String possibleValues, String tags)
	{
		clickEditPrdRepButton(id)
				.addProductReplacement(visibleFlag, editableFlag, replacementId, replacementType, possibleValueSearchString, possibleValues, tags);
		for(int i=0;i<parameterList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, parameterList.get(i));
		return PageFactory.initElements(driver, Product.class);
	}


	Level1DlgBox deleteDimsnParameters()
	{
		deleteDimensionParametersButton.get(0).sendKeys(Keys.ENTER);
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}

	Level1DlgBox deleteMatParameters()
	{
		deleteMaterialParametersButton.get(0).sendKeys(Keys.ENTER);
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}

	public static boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		Product.flag = flag;
	}

	Level1DlgBox deleteOptionParameters()
	{
		deleteOptionParametersButton.get(0).sendKeys(Keys.ENTER);
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}

	Level1DlgBox deleteProductParameters()
	{
		deleteProductParametersButton.get(0).sendKeys(Keys.ENTER);
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}
	
	public Product verifyProductBrand(String brandName)
	{
		String selectedBrand = new Select(brandSelect).getFirstSelectedOption().getText();
		if(selectedBrand.equalsIgnoreCase(brandName))
		{
			UtilHBM.reportOK("Product brand verified :"+brandName);
		}
		else
			UtilHBM.reportKO("Incorrect product brand. Expected Brand: " + brandName + "Available brand: "+ selectedBrand);
		return PageFactory.initElements(driver, Product.class);
	}
 	
	Product pageVerification()
	{
		Verification.VerifyEquals("Label not displayed!", "Reference", productLabel1.getText());
		Verification.VerifyEquals("Label not displayed!! ", "Product type", productLabel2.getText());
		Verification.VerifyEquals("Label not displayed!", "I don't find the product type i need", productTypeNote.getText());
		Verification.VerifyEquals("Label not displayed!", "Brand", brandLabel.getText());
		Verification.VerifyEquals("Page subtitle not displayed!", "Product information", pageSubtitle1.getText());
		Verification.VerifyEquals("Page subtitle not displayed!", "Product representation", pageSubtitle2.getText());
		Verification.VerifyEquals("Page subtitle not displayed!", "Pricing", pageSubtitle3.getText());
		Verification.VerifyEquals("Page subtitle not displayed!", "DATE PRODUCT", pageSubtitle4.getText());
		Verification.VerifyEquals("Label not displayed!", "Start date", label1.getText());
		Verification.VerifyEquals("Label not displayed!", "End date", label2.getText());
		Verification.VerifyEquals("Page subtitle not displayed!", "COMMERCIAL INFORMATION", pageSubtitle5.getText());
		Verification.VerifyEquals("Label not displayed!", "Language", label3.getText());
		Verification.VerifyEquals("Label not displayed!", "Commercial description", label4.getText());
		Verification.VerifyEquals("Label not displayed!", "Short description", label5.getText());
		Verification.VerifyEquals("Label not displayed!", "Product page link", label6.getText());
		Verification.VerifyEquals("Label not displayed!", "Manufacturer", label7.getText());
		Verification.VerifyEquals("Page subtitle not displayed!", "TAGS CLASSIFICATION", pageSubtitle6.getText());
		Verification.VerifyEquals("Label not displayed!", "Materials", label8.getText());
		Verification.VerifyEquals("Label not displayed!", "Color", label9.getText());
		Verification.VerifyEquals("Label not displayed!", "Styles", label10.getText());
		Verification.VerifyEquals("Label not displayed!", "Room", label11.getText());
		Verification.VerifyEquals("Label not displayed!", "Free tags", label12.getText());
		return this;
	}

	public Content clickBack()
	{
		backButton.click();
		UtilHBM.waitFixTime(2000);
//		UtilHBM.waitExplicitDisplayed(driver, processingLabel.get(processingLabel.size()-1));
		UtilHBM.waitTillElementDisappear(driver, ".dataTables_processing");
		return PageFactory.initElements(driver, Content.class);
	}

	public Product clickSave()
	{
		saveButton.click();
		UtilHBM.waitExplicitDisplayed(driver, prdCreatedAlert);
		UtilHBM.reportOK(prdCreatedAlert.getText());
		return PageFactory.initElements(driver, Product.class);
	}
	
	public Product deletePrice()
	{
		UtilHBM.webElement(driver, "#checkboxCheckAll-header").click();
		UtilHBM.webElement(driver, "#button-delete-price").click();
		
		return PageFactory.initElements(driver, Product.class);
	}

	
	public Product addPricing()
	{
		if(priceList.size()>0)
		{
			for(int i=0;i<priceList.size();i++)
				priceList.get(i).click();
			deletePriceButton.click();
		}
		Verification.VerifyEquals("Text not displayed", addPriceButton.getText(), "ADD PRICE");
		clickAddPrice();
		Verification.VerifyEquals("Text not displayed", addParametersButton.getText(), "Add parameters");
		priceTypeInput.sendKeys("regular");
		priceInput.sendKeys("100");
		new Select(currencyInput).selectByVisibleText("Euros");
		priceStartDate.sendKeys(UtilHBM.getDate(-1, "MM/dd/YYYY"));
		priceEndPrice.sendKeys(UtilHBM.getDate(1, "MM/dd/YYYY"));
		clickAddPricingParametersButton().addParameters("null");		
		UtilHBM.reportOK("Pricing added to the product");
		return PageFactory.initElements(driver, Product.class);
	}

	Level1DlgBox clickAddPricingParametersButton()
	{
		addParametersButton.click();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}

	Product clickAddPrice()
	{
		addPriceButton.click();
		return PageFactory.initElements(driver, Product.class);
	}

	public Product goToPricing()
	{
		pricingButton.click();
		return PageFactory.initElements(driver, Product.class);
	}

	Level1DlgBox clickAddPrdRepButton()
	{
		addPrdRepButton.sendKeys(Keys.ENTER);
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}

	Level1DlgBox clickEditPrdRepButton(String id)
	{
		if(productReplacements.size()==0)UtilHBM.reportKO("No Product replacements are available");
		else{
			boolean replacementFound=false;
			for(WebElement productReplacement:productReplacements){
				if(productReplacement.findElement(By.xpath(".//label[contains(text(),'ID :')]/following-sibling::div")).getText().equalsIgnoreCase(id)){
					WebElement editBtn=productReplacement.findElement(By.cssSelector("button.edit-parameter"));
					UtilHBM.scrollToElementWithOffset(driver, editBtn, -100);
					editBtn.click();
					replacementFound=true;
					break;
				}
			}
			if(!replacementFound)UtilHBM.reportKO("Required Product replacements not available");
		}

		return PageFactory.initElements(driver, Level1DlgBox.class);
	}

	Level1DlgBox clickAddMatVarButton()
	{
//		UtilHBM.scrollToElementWithOffset(driver, addMaterialVariationButton, 100);
		Actions actions=new Actions(driver);
		actions.moveToElement(addMaterialVariationButton).build().perform();
		UtilHBM.waitExplicitDisplayed(driver, addMaterialVariationButton);
		addMaterialVariationButton.click();;
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}

	Level1DlgBox clickOption()
	{
		UtilHBM.scrollToElementWithOffset(driver, addOptionButton, -200);
		UtilHBM.waitExplicitClickable(driver, addOptionButton);
		addOptionButton.click();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}
	Level1DlgBox editOption(String optionId)
	{
		UtilHBM.scrollToElementWithOffset(driver, addOptionButton, -200);
		UtilHBM.waitExplicitClickable(driver, addOptionButton);
		driver.findElement(By.xpath("//div[@class='col-xs-8 parameter-item-id align-left'][contains(text(),'"+optionId+"')]/../../../following-sibling::div[@class='col-xs-2 align-right u-mrxs']/button[@title='Edit']")).click();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}
	Level1DlgBox deleteVariationDimension(String variationName)
	{
		UtilHBM.scrollToElementWithOffset(driver, addDimensionButton, -200);
		UtilHBM.waitExplicitClickable(driver, addDimensionButton);
		driver.findElement(By.xpath("//div[@class='col-xs-8 parameter-item-id align-left'][contains(text(),'"+variationName+"')]/../../../following-sibling::div[@class='col-xs-2 align-right u-mrxs']/button[@title='Delete']")).click();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}
	Level1DlgBox clickDimsnVariation()
	{
//		addDimensionButton.sendKeys(Keys.END);
		UtilHBM.scrollToElementWithOffset(driver, addDimensionButton, -200);
		UtilHBM.waitFixTime(1000);
//		addDimensionButton.sendKeys(Keys.ENTER);
		
//		scrollDownPage();		
		UtilHBM.waitExplicitDisplayed(driver, addDimensionButton);
		UtilHBM.waitExplicitClickable(driver, addDimensionButton);		
		addDimensionButton.click();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}
	Level1DlgBox editDimsnVariation(String variationName)
	{
		UtilHBM.scrollToElementWithOffset(driver, addDimensionButton, -200);
		UtilHBM.waitExplicitClickable(driver, addDimensionButton);
		driver.findElement(By.xpath("//div[@class='col-xs-8 parameter-item-id align-left'][contains(text(),'"+variationName+"')]/../../../following-sibling::div[@class='col-xs-2 align-right u-mrxs']/button[@title='Edit']")).click();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}
	Product clickPrdRepresentation()
	{
		productRepresentationButton.click();
		return PageFactory.initElements(driver, Product.class);
	}
	public Login3DCloudByMe logout()
	{		
		UtilHBM.waitFixTime(1000);
		logoutButton.click();
		Login3DCloudByMe login3dCloudByMe=PageFactory.initElements(driver, Login3DCloudByMe.class);
		login3dCloudByMe.verifyLogout();
		return PageFactory.initElements(driver, Login3DCloudByMe.class);
	}
	
	public Product scrollDownPage(){
		UtilHBM.webElement(driver, "body").sendKeys(Keys.END);
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, Product.class);
	}

	public Product updateProductName(String name, String operation) {
		UtilHBM.waitExplicitDisplayed(driver,productNameInput);
		switch (operation.toUpperCase()) {
			case "APPEND":
				String currentName = productNameInput.getAttribute("value");
				productNameInput.clear();
				productNameInput.sendKeys(currentName + name + Keys.ENTER);
				break;

			case "MODIFY":
			default:
				productNameInput.clear();
				productNameInput.sendKeys(name + Keys.ENTER);
		}
		return this;
	}

	public Product clickSaveAndVerifyPermissionDenied() {
		saveButton.click();
		UtilHBM.waitExplicitDisplayed(driver, permissionDeniedErrPopup);
		UtilHBM.reportOK("Verified error Message : " + permissionDeniedErrPopup.getText());
		return PageFactory.initElements(driver, Product.class);
	}

	public Product setProductReplaceable(String yes_no) {
		UtilHBM.scrollToElementWithOffset(driver, isProductReplaceableOption, -150);
		switch (yes_no.toLowerCase()) {
			case "no":
				if (isProductReplaceableOption.getAttribute("class").contains("is-checked"))
					isProductReplaceableOption.click();
				break;
			case "yes":
			default:
				if (!isProductReplaceableOption.getAttribute("class").contains("is-checked"))
					isProductReplaceableOption.click();

		}
		return PageFactory.initElements(driver, Product.class);

	}
}
