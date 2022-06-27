package kitchen.threeDCloudByMe.pageObject;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class Material {
	WebDriver driver;

	public Material(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css="#material_name")
	private WebElement materialNameInput;

	@FindBy(css=".content>form>div>div>div>div>div>#material_brand")
	private WebElement brandSelectionDropDown;	
	
	@FindBy(css="div>div.steps>div[data-step='representation']")
	private WebElement materialRepresentationTab;
	
	@FindBy(css="div.steps>div[data-step='information']")
	private WebElement materialInformationTab;
	
	@FindBy(css="#material_classificationInfo_materials_chosen>ul>li>a")
	private List<WebElement> closeExistingMaterials;
	
	@FindBy(css="#material_classificationInfo_materials_chosen>ul>li>input")
	private WebElement materialsChoice;
	
	@FindBy(css="#material_classificationInfo_color_chosen>a")
	private WebElement colorChoice;
	
	@FindBy(css="#material_classificationInfo_color_chosen>div>div>input[type='text']")
	private WebElement colorChoiceInput;
			
	@FindBy(css="#material_classificationInfo_styles_chosen>ul>li>a")
	private List<WebElement> closeExistingStyles;
	
	@FindBy(css="#material_classificationInfo_styles_chosen>ul>li>input")
	private WebElement stylesChoice;
	
	@FindBy(css="dropdown[class='dd-init-upload en']")
	private WebElement upload3DModelLable;

	@FindBy(css="dropdown[class='reupload-dd en']")
	private WebElement reupload3DModelLable;
	
	@FindBy(css="input[id='model3DFile']")
	private WebElement upload3DModel;
	
	@FindBy(css="div[class='upload-model']>dropdown>ul>li>label[class='upload-once-model ']")
	WebElement singleSourceButton;

	@FindBy(css="div[class='u-mbs']>dropdown>ul>li>label[class='upload-once-model ']")
	WebElement singleSourceButtonReupload;

	@FindBy(css="div[class='upload-model']>dropdown>ul>li>label[class='upload-model-label-qa'][for='model3DFileHigh']")
	WebElement highQualityButton;

	@FindBy(css="div[class='u-mbs']>dropdown>ul>li>label[class='upload-model-label-qa'][for='model3DFileHigh']")
	WebElement highQualityButtonReupload;

	@FindBy(css="input[id='model3DFileHigh']")
	WebElement highQualityInput;
	
	@FindBy(css="div[class='upload-model']>dropdown>ul>li>label[class='upload-model-label-qa'][for='model3DFile']")
	WebElement mediumQualityButton;

	@FindBy(css="div[class='u-mbs']>dropdown>ul>li>label[class='upload-model-label-qa'][for='model3DFile']")
	WebElement mediumQualityButtonReupload;

	@FindBy(css="input[id='model3DFileLow']")
	WebElement lowQualityInput;	
	
	@FindBy(css="div[class='upload-model']>dropdown>ul>li>label[class='upload-model-label-qa'][for='model3DFileLow']")
	WebElement lowQualityButton;

	@FindBy(css="div[class='u-mbs']>dropdown>ul>li>label[class='upload-model-label-qa'][for='model3DFileLow']")
	WebElement lowQualityButtonReupload;

	@FindBy(css="#thumbnailFile")
	WebElement uploadThumbnail;	
	
	@FindBy(css="#btnSubmitForm")
	private WebElement saveButton;
	
	@FindBy(css="li>span")
	private WebElement pageHeader1;
	
	@FindBy(css="div>label[for='material_brand']")
	private WebElement pageHeader2;

	@FindBy(css="div[data-step='information']>label")
	private WebElement pageHeader3;
	
	@FindBy(css="div[data-step='representation']>label")
	private WebElement pageHeader4;
	
	@FindBy(css="div.u-mbm>span")
	private WebElement pageHeader5;
	
	@FindBy(css="div>label[for='material_classificationInfo_materials']")
	private WebElement pageHeader6;
	
	@FindBy(css="div>label[for='material_classificationInfo_color']")
	private WebElement pageHeader7;
	
	@FindBy(css="div>label[for='material_classificationInfo_styles']")
	private WebElement pageHeader8;
	
	@FindBy(css="div.col-xs-8.u-prm>div.u-mbs>span")
	private WebElement pageHeader9;
	
	@FindBy(css="div.col-xs-4>div.u-mbs>span")
	private WebElement pageHeader10;
	
	@FindBy(css="div.upload-model>div>span")
	private WebElement pageHeader11;
	
	@FindBy(css="div.upload-model-accept>span")
	private WebElement pageHeader13;
	
	@FindBy(css="div.upload-thumbnail>div.u-mbs>span")
	private WebElement pageHeader14;
	
	@FindBy(css="div.upload-thumbnail>label")
	private WebElement uploadPicButtonText;
	
	@FindBy(css="div.upload-thumbnail>div:nth-child(4)>span")
	private WebElement pageHeader15;
	
	@FindBy(css="#btnCancelForm>span")
	private WebElement cancelButtonText;
	
	@FindBy(css="#btnSubmitForm>span")
	private WebElement saveButtonText;
	
	@FindBy(css="dropdown[class^='reupload-dd en']")
	private WebElement reupload3DModel;
	
	@FindBy(css="body>main>article>div>div>div>span.text-XL")
	private WebElement accessDeniedMsg;
	
	@FindBy(css="body>main>article>div>div>div>span.text-L.bold")
	private WebElement permissionMsg;

	@FindBy(css=".footer-fixed>.mod-notification>.success.show")
	WebElement matCreatedAlert;

	static boolean flag=true;

	public static boolean isFlag() {
		return flag;
	}

	public static void setFlag(boolean flag) {
		Material.flag = flag;
	}
	
	public Material setMaterialName(String materialName,String role)
	{
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date date=new Date();
		String s=dateFormat.format(date);
		materialNameInput.clear();
		materialNameInput.sendKeys(materialName+"_"+role+"_"+s);
		Verification.VerifyEquals("Text not displayed", pageHeader1.getText(), "Create your material");
		Verification.VerifyEquals("Text not displayed", pageHeader2.getText(), "Brand");
		Verification.VerifyEquals("Text not displayed", pageHeader3.getText(), "Material information");
		Verification.VerifyEquals("Text not displayed", pageHeader4.getText(), "Material representation");
		Verification.VerifyEquals("Text not displayed", pageHeader5.getText(), "TAGS CLASSIFICATION");
		Verification.VerifyEquals("Text not displayed", pageHeader6.getText(), "Materials");
		Verification.VerifyEquals("Text not displayed", pageHeader7.getText(), "Color");
		Verification.VerifyEquals("Text not displayed", pageHeader8.getText(), "Styles");
		return PageFactory.initElements(driver, Material.class);
	}
	
	public Material setBrand(String brandName){
		UtilHBM.waitExplicitDisplayed(driver, brandSelectionDropDown);
		new Select(brandSelectionDropDown).selectByVisibleText(brandName);
		return PageFactory.initElements(driver, Material.class);
	}


	public Material setMaterialTag(String materialTagName)
	{
		materialsChoice.click();
		materialsChoice.sendKeys(materialTagName);
		WebElement materialsInput = driver.findElement(By.xpath("//div/ul/li[.='"+materialTagName+"']"));
		materialsInput.click();	
		return PageFactory.initElements(driver, Material.class);
	}
	
	public Material setMaterialColorTag(String colorTagName)
	{
		colorChoice.click();
		colorChoiceInput.sendKeys(colorTagName);
		WebElement colorsInput = driver.findElement(By.xpath("//div/ul/li[.='"+colorTagName+"']"));
		colorsInput.click();
		return PageFactory.initElements(driver, Material.class);
	}
	
	@FindBy(css="#material_classificationInfo_styles_chosen>ul>li.search-choice")
	List<WebElement> stylesTagList;
	
	public Material setMaterialStylesTag(String stylesTagName){
		UtilHBM.turnOffImplicitWaits(driver);
		if(stylesTagList.size()>0)
		{
			for(int i=0;i<stylesTagList.size();i++)
			{
				stylesTagList.get(i).findElement(By.xpath("a")).click();
			}
		}
		UtilHBM.turnOnImplicitWaits(driver);
		stylesChoice.click();
		stylesChoice.sendKeys(stylesTagName);
		WebElement stylesInput = driver.findElement(By.xpath("//div/ul/li[.='"+stylesTagName+"']"));
		stylesInput.click();
		return PageFactory.initElements(driver, Material.class);
	}
	
	
	
	public Content clickSaveButton(){
		UtilHBM.waitFixTime(1000);
		saveButton.click();	
		return PageFactory.initElements(driver, Content.class);
	}
	
	Material materialRepresentation(String type,String materialName){
		Verification.VerifyEquals("Text not displayed", pageHeader9.getText(), "3D Model");
		Verification.VerifyEquals("Text not displayed", pageHeader10.getText(), "Pictures");
		Verification.VerifyEquals("Text not displayed", pageHeader11.getText(), "Add a 3d model with the explore file bar");
		Verification.VerifyEquals("Text not displayed", upload3DModel.getText(), "UPLOAD 3D MODELS");
		Verification.VerifyEquals("Text not displayed", pageHeader13.getText(), "Accepted format: .bm3, .bma, .dae");
		if(type.contentEquals("new"))
		{
			Verification.VerifyEquals("Text not displayed", pageHeader14.getText(), "Add at least one picture by drag and drop or with the explore file bar");
			Verification.VerifyEquals("Text not displayed", uploadPicButtonText.getText(), "UPLOAD A PICTURE");
			Verification.VerifyEquals("Text not displayed", pageHeader15.getText(), "(expected dimensions: 512x512)");
		}
		Verification.VerifyEquals("Text not displayed", cancelButtonText.getText(), "CANCEL");
		Verification.VerifyEquals("Text not displayed", saveButtonText.getText(), "SAVE");
		if(type.contentEquals("edit"))
			UtilHBM.waitExplicitDisplayed(driver, reupload3DModel);
		upload3DModel.sendKeys(new File(Setting.threeDCloudData+"BM3/"+materialName+".BM3MAT").getAbsolutePath());
		UtilHBM.waitExplicitDisplayed(driver, reupload3DModel);
		uploadThumbnail.sendKeys(new File(Setting.threeDCloudData+"Thumbnail/"+materialName+".jpg").getAbsolutePath());
		UtilHBM.waitFixTime(5000);
		return this;
	}
	
	public Material uploadPicture(String materialName){
		uploadThumbnail.sendKeys(new File(Setting.threeDCloudData+"Thumbnail/"+materialName+".jpg").getAbsolutePath());
		UtilHBM.waitFixTime(10000);
		return PageFactory.initElements(driver, Material.class);
	}
	
	public Material uploadModel(String modelName){
		UtilHBM.waitFixTime(2000);
		Verification.VerifyEquals("Text not displayed", pageHeader9.getText(), "3D Model");
		Verification.VerifyEquals("Text not displayed", pageHeader10.getText(), "Pictures");
		Verification.VerifyEquals("Text not displayed", pageHeader11.getText(), "Add a 3d model with the explore file bar");
		Verification.VerifyEquals("Text not displayed", upload3DModelLable.getText(), "UPLOAD 3D MODELS");
		Verification.VerifyEquals("Text not displayed", pageHeader13.getText(), "Accepted format: .bm3, .bma, .dae");
		Verification.VerifyEquals("Text not displayed", cancelButtonText.getText(), "CANCEL");
		Verification.VerifyEquals("Text not displayed", saveButtonText.getText(), "SAVE");
		if (upload3DModelLable.isDisplayed()) {
			upload3DModelLable.click();
			UtilHBM.waitExplicitDisplayed(driver, singleSourceButton);
			UtilHBM.waitExplicitDisplayed(driver, highQualityButton);
			UtilHBM.waitExplicitDisplayed(driver, mediumQualityButton);
			UtilHBM.waitExplicitDisplayed(driver, lowQualityButton);
			Verification.VerifyEquals("Label not displayed", "SINGLE SOURCE", singleSourceButton.getText());
			Verification.VerifyEquals("Label not displayed", "HIGH-QUALITY",highQualityButton.getText());
			Verification.VerifyEquals("Label not displayed", "MEDIUM-QUALITY", mediumQualityButton.getText());
			Verification.VerifyEquals("Label not displayed", "LOW-QUALITY", lowQualityButton.getText());
		}else{
			reupload3DModelLable.click();
			UtilHBM.waitFixTime(1000);
			UtilHBM.waitExplicitDisplayed(driver, singleSourceButtonReupload);
			UtilHBM.waitExplicitDisplayed(driver, highQualityButtonReupload);
			UtilHBM.waitExplicitDisplayed(driver, mediumQualityButtonReupload);
			UtilHBM.waitExplicitDisplayed(driver, lowQualityButtonReupload);
			Verification.VerifyEquals("Label not displayed", "SINGLE SOURCE", singleSourceButtonReupload.getText());
			Verification.VerifyEquals("Label not displayed", "HIGH-QUALITY",highQualityButtonReupload.getText());
			Verification.VerifyEquals("Label not displayed", "MEDIUM-QUALITY", mediumQualityButtonReupload.getText());
			Verification.VerifyEquals("Label not displayed", "LOW-QUALITY", lowQualityButtonReupload.getText());
		}

		upload3DModel.sendKeys(new File(Setting.threeDCloudData+"BM3/"+modelName+".BM3MAT").getAbsolutePath());
		UtilHBM.waitExplicitDisplayed(driver, reupload3DModel);
		UtilHBM.waitFixTime(4000);
		return PageFactory.initElements(driver, Material.class);
	}
	
	public Material goToMaterialRepresentationTab(){
		materialRepresentationTab.click();
		return PageFactory.initElements(driver, Material.class);
	}
	
	public Material goToMaterialInformationTab(){
		materialInformationTab.click();
		return PageFactory.initElements(driver, Material.class);
	}

	public Material updateMaterialName(String name, String operation) {
		UtilHBM.waitExplicitDisplayed(driver,materialNameInput);
		switch (operation.toUpperCase()) {
			case "APPEND":
				String currentName = materialNameInput.getAttribute("value");
				materialNameInput.clear();
				materialNameInput.sendKeys(currentName + name + Keys.ENTER);
				break;

			case "MODIFY":
			default:
				materialNameInput.clear();
				materialNameInput.sendKeys(name + Keys.ENTER);
		}
		return this;
	}

	public Material materialNameVerify(String materialName)
	{
		Verification.VerifyEquals("Product Name incorrect", materialNameInput.getAttribute("value"), materialName);
		return PageFactory.initElements(driver, Material.class);
	}

	public Material clickSave()
	{
		UtilHBM.waitFixTime(1000);
		saveButton.click();
		UtilHBM.waitExplicitDisplayed(driver, matCreatedAlert);
		UtilHBM.reportOK(matCreatedAlert.getText());
		return PageFactory.initElements(driver, Material.class);
	}
}
