package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesignYourExterior {
	
	WebDriver driver;
	
	public DesignYourExterior(WebDriver driver) {
		this.driver = driver;	
	}
	
	@CacheLookup
	@FindBy(css="body>div>div>.modal-title")
	private WebElement title;
	
	@CacheLookup
	@FindBy(css="body>div>div>div>.exterior-mat_chooser-desc")
	private WebElement exteriorDescrition;
	
	@FindBy(css="body>div>div>div>div>.w-33.exterior-mat-link.u-txtCenter")
	private List<WebElement> exteriorList;
	
	@FindBy(css="body>div>div>div>div>a>#Material1")
	private WebElement gargenImage;
	
	@FindBy(css="body>div>div>div>div>a>#Material2")
	private WebElement patioImage;
	
	@FindBy(css="body>div>div>div>div>a>#Material3")
	private WebElement driverwayImage;
	
	@CacheLookup
	@FindBy(css="body>div>div>div>div>div>form>div>div>label")
	private WebElement surfaceLabel;
	
	
	@FindBy(css="body>div>div>div>div>div>form>div>div>span>input")
	private WebElement surfaceInputBox;
	
	@FindBy(css="body>div>div>div>div>div>form>div>div>span>.ui-spinner-button.ui-spinner-up")
	private WebElement surfaceInputBoxSpinnerUp;
	
	@FindBy(css="body>div>div>div>div>div>form>div>div>span>.ui-spinner-button.ui-spinner-down")
	private WebElement surfaceInputBoxSpinnerDown;	
	
	@CacheLookup
	@FindBy(css="body>div>div>div>div>div>#createExterior")
	private WebElement createButton;
		
	@CacheLookup
	@FindBy(css="body>div>.close-modal.button-close")
	private WebElement closeButton;
		
	private String titleText = "Design your exterior";
	private String descrition = "Please, select a kind of exterior to start.";
	private String gardenImg = "https://byme.s3-eu-west-1.amazonaws.com/data/materials/B07B45D3-E75E-493C-9EF4-A8D42584C421/Thumbnails/128.jpg";
	private String patioImg = "https://byme.s3-eu-west-1.amazonaws.com/data/materials/08A476D9-A88C-438F-8BB1-23EDEDD951F5/Thumbnails/128.jpg";
	private String driverwayImg = "https://byme.s3-eu-west-1.amazonaws.com/data/materials/85f7d9cd-1abf-48f1-8a98-54f9d3216bff/Thumbnails/128.jpg";
		
	public ThreeDPlanner createExterior(int exteriorTypeNo, String surfaceArea){
		UtilHBM.waitExplicitDisplayed(driver, patioImage);
		checkExteriorPanel();
		String exteriorName = exteriorList.get(exteriorTypeNo-1).getText();
		exteriorList.get(exteriorTypeNo-1).click();
		surfaceInputBox.sendKeys(Keys.CONTROL+ "a");
		surfaceInputBox.sendKeys(surfaceArea);
		createButton.click();
		UtilHBM.reportOK(exteriorName + " exterior added in the project");
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	private void checkExteriorPanel(){
		Verification.displayNAttributeCheckOfElement(title, "Title", "text", titleText);
		Verification.displayNAttributeCheckOfElement(exteriorDescrition, "Exterior descrition", "text", descrition);
		Verification.displayNAttributeCheckOfElement(gargenImage, "Garden Image", "src", gardenImg);
		Verification.displayNAttributeCheckOfElement(patioImage, "Patio Image", "src", patioImg);
		Verification.displayNAttributeCheckOfElement(driverwayImage, "Driveway Image", "src", driverwayImg);
		Verification.displayNAttributeCheckOfElement(surfaceLabel, "Surface Label", "text", "surface");
		Verification.displayNAttributeCheckOfElement(surfaceInputBox, "Value in input box", "value", "100.0 m²");
		Verification.displayNAttributeCheckOfElement(createButton, "Create Button", "text", "CREATE");
	}
	

}
