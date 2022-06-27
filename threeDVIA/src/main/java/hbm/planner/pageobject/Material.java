package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Material {
	
	WebDriver driver;
	
	public Material(WebDriver driver) {
		this.driver=driver;	
	}
			
	@FindBy(css="body>div>div[data-ui-module='style-panel']>div>header>div>.title")
	private WebElement titleEditThisElement;
	
	@FindBy(css="body>div>div[data-ui-module='style-panel']>div>header>div>.product-name")
	private WebElement productName;
	
	@FindBy(css="body>div>div[data-ui-module='style-panel']>div>header>div>.icon.icon-prev")
	private WebElement backButton;
	
	@FindBy(css="body>div>div>div>div>div>div>form>#color-category")
	private WebElement materialCatagory;
	
	@FindBy(css="body>div>div>div>div>div>div>form>.colorPicker>a")
	private List<WebElement> colorPicker;
	
	@FindBy(css="body>div>div>div>div>div>div>form>.colorPicker>.colorPicker-item.is-active")
	private List<WebElement> activeColorPicker;
	
	@FindBy(css="body>div>div>div>div>div>div>form>div>.colorPicker-grid-item")
	private List<WebElement> colorList;
	
	@FindBy(css=".properties-wrapper>.content>#brand-material-section>img[src*='https']")
	private WebElement materialImgBrandInfo;
	
	@FindBy(css="body>div>div>div>.content>#brand-material-section>.brand-material-infos>#brand-material-section-brand")
	private WebElement materialInfoBrand;
	
	@FindBy(css="body>div>div>div>.content>#brand-material-section>.brand-material-infos>#brand-material-section-name")
	private WebElement materialInfoName;
	
	private String image;
	
	public Edit selectMaterial(String styleName, String colorCatagory, int colorPickerZeroIfNotPaint, String colorId, int isBranded_1ForYes){
		WebElement color;			
		UtilHBM.waitExplicitDisplayed(driver, colorList.get(1));
		UtilHBM.waitExplicitClickable(driver, colorList.get(colorList.size()-1));
		UtilHBM.waitExplicitClickable(driver, productName);
//		UtilHBM.waitExplicitDisplayed(driver, productName);
		if(!titleEditThisElement.getText().equalsIgnoreCase("Edit this element") ||
				!titleEditThisElement.isDisplayed() || !productName.isDisplayed() ||
				!productName.getText().equalsIgnoreCase(styleName)){
			UtilHBM.reportKO("edit this element text: " + titleEditThisElement.getText());
			UtilHBM.reportKO("product name/ style name: " + productName.getText());
			UtilHBM.reportKO("input style Name: " + styleName);
			UtilHBM.reportKO("\"Edit this element\" or Stytle name '" + styleName + "' is not correctly displayed");
		}
		
		if(!colorCatagory.isEmpty()|| !colorCatagory.equals(null)){
//			new Actions(driver).moveToElement(materialCatagory).build().perform();
			new Select(materialCatagory).selectByVisibleText(colorCatagory);
//			if(!new Select(materialCatagory).getFirstSelectedOption().getText().equalsIgnoreCase(colorCatagory)){
//				new Select(materialCatagory).selectByVisibleText(colorCatagory);
//			}
						
		}
		
		if(new Select(materialCatagory).getFirstSelectedOption().getText().contains("paint")){			
			UtilHBM.waitExplicitClickable(driver, colorPicker.get(colorPickerZeroIfNotPaint-1));
			UtilHBM.waitFixTime(500);
			if(!colorPicker.get(colorPickerZeroIfNotPaint-1).getAttribute("class").contains("is-active")){
//				new Actions(driver).moveToElement(colorPicker.get(colorPickerZeroIfNotPaint-1)).build().perform();
				colorPicker.get(colorPickerZeroIfNotPaint-1).click();				
			}							
		}
		color = UtilHBM.webElement(driver, "a[data-id='" + colorId + "']>img");
		UtilHBM.waitExplicitClickable(driver, color);
		color.click();
		setImage(color.getAttribute("src"));
		if(isBranded_1ForYes==1){
			UtilHBM.waitExplicitDisplayed(driver, materialImgBrandInfo);
			if(getImage().equalsIgnoreCase(materialImgBrandInfo.getAttribute("src")) &&
					materialImgBrandInfo.isDisplayed() &&
					!materialInfoBrand.getText().isEmpty() &&
					!materialInfoName.getText().isEmpty()){
				UtilHBM.reportOK("Material Image with Brand details is displayed");				
			}else{
				UtilHBM.reportOK("Material Image & / or Brand details are not displayed");
			}
		}
		backButton.click();
		UtilHBM.waitTillElementDisappear(driver, ".icon.icon-prev");
		return PageFactory.initElements(driver, Edit.class);
	}

	public Edit selectMaterialById(String materialId) {
		WebElement color;
		UtilHBM.waitExplicitDisplayed(driver, colorList.get(0));
		UtilHBM.waitExplicitClickable(driver, colorList.get(colorList.size() - 1));
		UtilHBM.waitExplicitClickable(driver, productName);
		if (!titleEditThisElement.getText().equalsIgnoreCase("Edit this element") || !titleEditThisElement.isDisplayed()
				|| !productName.isDisplayed()) {
			UtilHBM.reportKO("edit this element text: " + titleEditThisElement.getText());
			UtilHBM.reportKO("product name/ style name: " + productName.getText());
		}
		color = UtilHBM.webElement(driver, "a[data-id='" + materialId + "']>img");
		UtilHBM.waitExplicitClickable(driver, color);
		color.click();
		setImage(color.getAttribute("src"));
		UtilHBM.waitExplicitDisplayed(driver, materialImgBrandInfo);
		if (getImage().equalsIgnoreCase(materialImgBrandInfo.getAttribute("src")) && materialImgBrandInfo.isDisplayed()
				&& !materialInfoBrand.getText().isEmpty() && !materialInfoName.getText().isEmpty()) {
			UtilHBM.reportOK("Material Image with Brand details is displayed");
		} else {
			UtilHBM.reportOK("Material Image & / or Brand details are not displayed");
		}
		backButton.click();
		UtilHBM.waitTillElementDisappear(driver, ".icon.icon-prev");
		return PageFactory.initElements(driver, Edit.class);
	}
	
	public Edit verifytMaterial(String styleName, String colorImg, String colorCatagory, String colorId, int isBranded_1ForYes){						
		UtilHBM.waitExplicitClickable(driver, colorList.get(0));
		UtilHBM.waitExplicitClickable(driver, colorList.get(colorList.size()-1));
		String colorImage=UtilHBM.webElement(driver, "a[data-id='" + colorId + "']>img").getAttribute("src");
		setImage(colorImage);
		if(colorImage.equalsIgnoreCase(colorImg)){
			UtilHBM.reportOK("Material verified for "+ styleName);
			if(!colorCatagory.isEmpty()){				
				if(new Select(materialCatagory).getFirstSelectedOption().getText().equalsIgnoreCase(colorCatagory)){
					if(colorCatagory.contains("paint")){
						if(!(activeColorPicker.size()==1)){
							UtilHBM.reportKO("Color picker is not in selected state in material varification for "+ styleName);
						}
					}					
				}else{
					UtilHBM.reportWarning("Material verified for "+ styleName + "successfully but Material catagory varification failed");
				}
			}
			if(isBranded_1ForYes==1){
				if(colorImage.equalsIgnoreCase(materialImgBrandInfo.getAttribute("src")) &&
						materialImgBrandInfo.isDisplayed() &&
						!materialInfoBrand.getText().isEmpty() &&
						!materialInfoName.getText().isEmpty()){
					UtilHBM.reportOK("Material & Brand info verified for "+ styleName + "successfully");				
				}else{
					UtilHBM.reportKO("Material verified for "+ styleName + "successfully but brand info verification failed. One of following information is wrong or missing:");
					UtilHBM.reportInfo("Brand displayed: " + materialImgBrandInfo.isDisplayed());
					UtilHBM.reportInfo("Brand name: " + materialInfoBrand.getText());
					UtilHBM.reportInfo("Material name: "+ materialInfoName.getText());
				}				
			}
		}else{
			UtilHBM.reportKO("Material verification failed for "+ styleName);
			UtilHBM.reportKO("Expected image: " + colorImg +", actual image: "+colorImage);
		}		
		UtilHBM.waitExplicitDisplayed(driver, backButton);
		UtilHBM.waitExplicitClickable(driver, backButton);		
		backButton.click();
		UtilHBM.waitTillElementDisappear(driver, ".icon.icon-prev");
		return PageFactory.initElements(driver, Edit.class);
	}
	
	protected ProductInfo addMtlToFavorite(String favList, String newOrExistingList ,boolean new_1_old_0){
		UtilHBM.waitExplicitClickable(driver, colorList.get(colorList.size()-1).findElement(By.cssSelector("img[src*='https']")));
		UtilHBM.waitExplicitClickable(driver, materialImgBrandInfo);		
//		materialImgBrandInfo.click();
		String mtlBrandInfo = getMtlInfo();
		new Actions(driver).moveToElement(materialImgBrandInfo).click().build().perform();
		driver.switchTo().parentFrame();
		ProductInfo prdInfo = PageFactory.initElements(driver, ProductInfo.class);
		prdInfo.favFrmPrdSheet(mtlBrandInfo, favList, newOrExistingList ,new_1_old_0);
		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
		return PageFactory.initElements(driver, ProductInfo.class);
	}
	
	protected String getMtlInfo(){
		String mtlInfo=null;
		String brand = materialInfoBrand.getText();
		String img = materialImgBrandInfo.getAttribute("src").replace("/64.jpg", "/512.jpg");
		String productName=materialInfoName.getText();
		mtlInfo= brand+">" + productName + ">" + img;
		return mtlInfo;
		
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {		
		this.image = image;
	}	
	
}
