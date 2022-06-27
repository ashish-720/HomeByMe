package hr.planner.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class EditProperties {

	WebDriver driver;

	public EditProperties(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//div/ul/li[@data-ui-publicationid='depth']")
	private WebElement depthLebel;

	@FindBy(xpath = "//div/ul/li[@data-ui-publicationid='width']")
	private WebElement widthLebel;

	@FindBy(xpath = "//div/ul/li[@data-ui-publicationid='height']")
	private WebElement heightLebel;

	@FindBy(css = "fieldset>p>span>#edit-form-input-depth")
	private WebElement depthInputBoxFurniture;

	@FindBy(css = "fieldset>p>span>#edit-form-input-width")
	private WebElement widthInputBoxFurniture;

	@FindBy(css = "fieldset>p>span>#product-width")
	private WebElement widthInputBoxBuild;

	@FindBy(css = "fieldset>p>span>#edit-form-input-height")
	private WebElement heightInputBoxFurniture;

	@FindBy(css = "fieldset>p>span>[data-ui-item='product-height']")
	private WebElement heightInputBoxBuild;

	@FindBy(css = ".mod-measure-input>[id='thickness']")
	private WebElement thicknessInputBoxWall;

	@FindBy(css = ".ceiling-height-row>[id='ceiling-height-CB']")
	private WebElement wallHeightCheckBox;

	@FindBy(css = ".mod-measure-input>[id='height']")
	private WebElement heightInputBoxWall;
	
	@FindBy(css=".mod-panel-properties-wide.mod-open>div>div>ul>li>div>p.text>span[data-i18n='product_property_panel.properties.configure_question']")
	private WebElement configureQuestion;
	
	@FindBy(css=".mod-panel-properties-wide.mod-open>div>div>ul>li>div>div>button[data-ui-action='configure']")
	private WebElement confiureBtn;	

	public HomePlanner editFurniture(String depth, String width, String height) {

		UtilHBM.waitFixTime(500);
		if (!depth.isEmpty()) {
			// depthInput.clear();
			depthInputBoxFurniture.sendKeys(Keys.CONTROL + "a");
			depthInputBoxFurniture.sendKeys(depth);
		}

		if (!width.isEmpty()) {
			// widthInput.clear();
			widthInputBoxFurniture.sendKeys(Keys.CONTROL + "a");
			widthInputBoxFurniture.sendKeys(width);
		}

		if (!height.isEmpty()) {
			// heightInputBox.clear();
			heightInputBoxFurniture.sendKeys(Keys.CONTROL + "a");
			heightInputBoxFurniture.sendKeys(height);
		}

		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public HomePlanner editBuild(String depth, String width, String height) {

		UtilHBM.waitFixTime(500);
		if (!depth.isEmpty()) {
			// kept for now
			depthInputBoxFurniture.sendKeys(Keys.CONTROL + "a");
			depthInputBoxFurniture.sendKeys(depth);
		}

		if (!width.isEmpty()) {
			widthInputBoxBuild.sendKeys(Keys.CONTROL + "a");
			widthInputBoxBuild.sendKeys(width);
		}

		if (!height.isEmpty()) {
			heightInputBoxBuild.sendKeys(Keys.CONTROL + "a");// failing here.
																// error;
																// element not
																// interactable
			heightInputBoxBuild.sendKeys(height);
		}

		return PageFactory.initElements(driver, HomePlanner.class);
	}

	public HomePlanner editWall(String thickness, String height) {
		UtilHBM.waitFixTime(500);
		if (!thickness.isEmpty()) {
			// kept for now
			thicknessInputBoxWall.sendKeys(Keys.CONTROL + "a");
			thicknessInputBoxWall.sendKeys(thickness);
			Verification.displayNAttributeCheckOfElement(thicknessInputBoxWall,
					"thickness", "value", "" + thickness + "");
		}

		if (!height.isEmpty()) {
			wallHeightCheckBox.click();
			heightInputBoxWall.sendKeys(Keys.CONTROL + "a");
			heightInputBoxWall.sendKeys(height);
			Verification.displayNAttributeCheckOfElement(heightInputBoxWall,
					"height", "value", "" + height + "");
		}		

		return PageFactory.initElements(driver, HomePlanner.class);
	}
	
	public ConfigureProduct configure(){
		UtilHBM.waitExplicitDisplayed(driver, confiureBtn);
		Verification.displayNAttributeCheckOfElement(configureQuestion, "Configure Question", "text", "You want to modify your product with configurator ?");
		confiureBtn.click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src='https://d2iury6ergb1tc.cloudfront.net']")));
		driver.switchTo().frame(driver.findElement(By.cssSelector("#configurator")));
		return PageFactory.initElements(driver, ConfigureProduct.class);
	}


}
