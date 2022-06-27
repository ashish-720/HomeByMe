package kitchen.bryo.pageObject;

import java.util.List;

import hbm.planner.utility.Verification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import hbm.planner.utility.UtilHBM;

public class StylePage {

    WebDriver driver;

    public StylePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".button.try-this-button")
    private WebElement tryInMyRoom;

    @FindBy(css = "li[data-class='step-style']")
    private WebElement styleTab;

    @FindBy(css = "#tab-1>label>input[data-ui-action='skip-step']")
    private WebElement skipStyleStep;

    @FindBy(css = "#tab-2>label>input[data-ui-action='skip-step']")
    private WebElement skipLayoutStep;

    @FindBy(css = "#tab-3>label>input[data-ui-action='skip-step']")
    private WebElement skipCookingStep;

    @FindBy(css = "#tab-4>label>input[data-ui-action='skip-step']")
    private WebElement skipRefrigerationStep;

    @FindBy(xpath = "//button[@data-ui-selector='update-need-mapping-settings']")
    private WebElement saveMyNeedsButton;

    @FindBy(css = "form>fieldset>label")
    private List<WebElement> noPreferenceList;

    @FindBy(xpath = "//div[@id='tab-5-update']/ul/li/p[@class='subtitle']")
    private List<WebElement> selectionSubTitle;
    ;

    @FindBy(xpath = "//div[@id='tab-5-update']/ul/li[@data-step='0']")
    private WebElement changeStyleMapping;

    @FindBy(xpath = "//div[@id='tab-5-update']/ul/li[@data-step='1']")
    private WebElement changelayoutMapping;

    @FindBy(xpath = "//div[@id='tab-5-update']/ul/li[@data-step='2']")
    private WebElement changeCookingMapping;

    @FindBy(xpath = "//div[@id='tab-5-update']/ul/li[@data-step='3']")
    private WebElement changeRefrigerationMapping;

    @FindBy(css = "fieldset[aria-hidden='false'] ul.tablist.first-level>li:nth-of-type(2) label.bt-text")
    private WebElement styleIDontHavePref;

    @FindBy(css = "fieldset[aria-hidden='false'] div.styles-catalog ul.first-level>li:nth-of-type(1) ul.inner-container>li[aria-controls='catalog-fronts']")
    private WebElement selectCabinetsStyleHdr;

    @FindBy(css = "fieldset[aria-hidden='false'] ul.second-level>li.browser ul#catalog-fronts")
    private WebElement styleCatalogFronts;

    @FindBy(css = "fieldset[aria-hidden='false'] div.styles-catalog ul.first-level>li:nth-of-type(1) ul.inner-container>li[aria-controls='catalog-worktops']")
    private WebElement selectWorktopsStyleHdr;

    @FindBy(css = "fieldset[aria-hidden='false'] ul.second-level>li.browser ul#catalog-worktops")
    private WebElement styleCatalogWorktops;

    @FindBy(css = "fieldset[aria-hidden='false'] div.styles-catalog ul.first-level>li:nth-of-type(1) ul.inner-container>li[aria-controls='catalog-handles']")
    private WebElement selectHandlesStyleHdr;

    @FindBy(css = "fieldset[aria-hidden='false'] ul.second-level>li.browser ul#catalog-handles")
    private WebElement styleCatalogHandles;

    @FindBy(css = "fieldset[aria-hidden='false'] ul.second-level span.icon-view-close")
    private WebElement styleSecondLvlCloseBtn;

    @FindBy(xpath = "//ul[contains(@class, 'first-level')]//span[text()='Update']")
    private WebElement stylesUpdateBtn;

    @FindBy(xpath = "//div[@class='actions']/label/span[text()='Update']")
    private WebElement stylesUpdateBtnMobile;
    
    @FindBy(xpath = "//ul[contains(@class, 'first-level')]//span[text()='Next >']")
    private WebElement stylesNextBtn;

    @FindBy(xpath = "//div[@class='actions']/label[@for='validate-style']/span[text()='Next >']")
    private WebElement stylesNextBtnMobile;
    
    @FindBy(css="fieldset[aria-hidden='false'] section.mod-styles-selector")
	private WebElement selectStylePopup;


    public FloorPlan tryInMyRoom() {
        tryInMyRoom.click();
        UtilHBM.waitFixTime(2000);
        driver.switchTo().frame(driver.findElement(By.id("embedded-app-frame")));
        UtilHBM.waitExplicitClickable(driver,
                UtilHBM.webElement(driver, "input.room.Tag3D.visibility-visible.text-size-bigger-one"));
        return PageFactory.initElements(driver, FloorPlan.class);
    }

     StylePage selectCabinetStyle(String style) {
        UtilHBM.waitExplicitDisplayed(driver, selectCabinetsStyleHdr);
        selectCabinetsStyleHdr.click();
        UtilHBM.waitExplicitDisplayed(driver, "//fieldset[@aria-hidden='false']//ul[@class='inner-container']/li[@aria-controls='catalog-fronts' and @class='selected']");
        UtilHBM.waitExplicitDisplayed(driver, "//ul[@class='second-level mod-open']");
        UtilHBM.waitFixTime(500);

        styleCatalogFronts.findElement(By.xpath("./li//div[@class='product-info']/span[text()='" + style + "']")).click();
        UtilHBM.waitExplicitDisplayed(driver, "//fieldset[@aria-hidden='false']//div[@class='product-info']/span[text()='" + style + "']/ancestor::li[@class='product-tile selected']");
        UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
        UtilHBM.waitFixTime(2000);
        UtilHBM.waitExplicitClickable(driver, styleSecondLvlCloseBtn); 
        styleSecondLvlCloseBtn.click();
//        UtilHBM.waitTillElementDisappear(driver, styleSecondLvlCloseBtn);
         return PageFactory.initElements(driver, StylePage.class);
    }

     StylePage selectWorktopStyle(String style) {
        UtilHBM.waitExplicitDisplayed(driver, selectWorktopsStyleHdr);
        selectWorktopsStyleHdr.click();
        UtilHBM.waitExplicitDisplayed(driver, "//fieldset[@aria-hidden='false']//ul[@class='inner-container']/li[@aria-controls='catalog-worktops' and @class='selected']");
        UtilHBM.waitExplicitDisplayed(driver, "//ul[@class='second-level mod-open']");
        UtilHBM.waitFixTime(500);
        styleCatalogWorktops.findElement(By.xpath("./li//div[@class='product-info']/span[text()='" + style + "']")).click();
        UtilHBM.waitExplicitDisplayed(driver, "//fieldset[@aria-hidden='false']//div[@class='product-info']/span[text()='" + style + "']/ancestor::li[@class='product-tile selected']");

        UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
        UtilHBM.waitFixTime(2000);
        UtilHBM.waitExplicitClickable(driver, styleSecondLvlCloseBtn); 
        styleSecondLvlCloseBtn.click();
//        UtilHBM.waitTillElementDisappear(driver, styleSecondLvlCloseBtn);
         return PageFactory.initElements(driver, StylePage.class);
    }

    StylePage selectHandleStyle(String style) {
        UtilHBM.waitExplicitDisplayed(driver, selectHandlesStyleHdr);
        selectHandlesStyleHdr.click();
        UtilHBM.waitExplicitDisplayed(driver, "//fieldset[@aria-hidden='false']//ul[@class='inner-container']/li[@aria-controls='catalog-handles' and @class='selected']");
        UtilHBM.waitExplicitDisplayed(driver, "//ul[@class='second-level mod-open']");
        UtilHBM.waitFixTime(500);
        if (style == null) {
            Verification.displayOfWebElement(styleCatalogHandles.findElement(By.xpath("./li[@data-ui-selector='product-unavailable']")));
            Verification.VerifyEquals("Error msg verification  failed...", styleCatalogHandles.findElement(By.xpath("./li[@data-ui-selector='product-unavailable']//p[@class='message']")).getText(), "The fronts you've chosen have built-in handles");
        } else if (!style.isEmpty()) {
            styleCatalogHandles.findElement(By.xpath("./li//div[@class='product-info']/span[text()='" + style + "']")).click();
            UtilHBM.waitExplicitDisplayed(driver, "//fieldset[@aria-hidden='false']//div[@class='product-info']/span[text()='" + style + "']/ancestor::li[@class='product-tile selected']");
        }

		UtilHBM.waitFixTime(1000);
		if (styleSecondLvlCloseBtn.isDisplayed()) styleSecondLvlCloseBtn.click();
//		UtilHBM.waitTillElementDisappear(driver, styleSecondLvlCloseBtn);
         return PageFactory.initElements(driver, StylePage.class);
    }

    public SelectMapping selectNoPreferenceForStyle() {
		UtilHBM.waitExplicitDisplayed(driver, selectStylePopup);
		UtilHBM.waitExplicitDisplayed(driver, styleIDontHavePref);
        System.out.println(".." + styleIDontHavePref.getText());
        styleIDontHavePref.click();
        UtilHBM.waitFixTime(1000);
//        UtilHBM.waitTillElementDisappear(driver, styleIDontHavePref);
        return PageFactory.initElements(driver, SelectMapping.class);
    }

    public SelectMapping clickNext() {
        stylesNextBtn.click();
        UtilHBM.waitTillElementDisappear(driver, stylesNextBtn);
		return PageFactory.initElements(driver, SelectMapping.class);
    }

	public SelectMapping clickUpdate() {
		stylesUpdateBtn.click();
		UtilHBM.waitTillElementDisappear(driver, stylesUpdateBtn);
		return PageFactory.initElements(driver, SelectMapping.class);
	}

    /**
     * select mapping for style
     * @param cabinetsStyle : Specify cabinet style as text. Provide blank text if nothing is to be set
     * @param worktopsStyle : Specify worktop style as text. Provide blank text if nothing is to be set
     * @param handlesStyle : Provide handle style as text. Provide blank text if nothing is to be set. Provide null if handle is built in by default i.e. if it is not possible
     *                       to set handle and instead the warning message needs to be verified
     * @return SelectMapping page object
     */
	public SelectMapping selectStyleMapping(String cabinetsStyle, String worktopsStyle, String handlesStyle) {
		UtilHBM.waitExplicitDisplayed(driver, selectStylePopup);
		if (!cabinetsStyle.isEmpty()) selectCabinetStyle(cabinetsStyle);
		if (!worktopsStyle.isEmpty()) selectWorktopStyle(worktopsStyle);
        selectHandleStyle(handlesStyle);
        clickNext();
		return PageFactory.initElements(driver, SelectMapping.class);
	}

	public SelectMapping selectStyleMapping() {
		UtilHBM.waitExplicitDisplayed(driver, selectStylePopup);
		selectNoPreferenceForStyle();
		return PageFactory.initElements(driver, SelectMapping.class);
	}

    /**
     * update mapping for style
     * @param cabinetsStyle : Specify cabinet style as text. Provide blank text if nothing is to be set
     * @param worktopsStyle : Specify worktop style as text. Provide blank text if nothing is to be set
     * @param handlesStyle : Provide handle style as text. Provide blank text if nothing is to be set. Provide null if handle is built in by default i.e. if it is not possible
     *                       to set handle and instead the warning message needs to be verified
     * @return SelectMapping page object
     */
    public SelectMapping updateStyleMapping(String cabinetsStyle, String worktopsStyle, String handlesStyle) {
        UtilHBM.waitExplicitDisplayed(driver, selectStylePopup);
        if (!cabinetsStyle.isEmpty()) selectCabinetStyle(cabinetsStyle);
        if (!worktopsStyle.isEmpty()) selectWorktopStyle(worktopsStyle);
        selectHandleStyle(handlesStyle);
        clickUpdate();
        return PageFactory.initElements(driver, SelectMapping.class);
    }

	public SelectMapping updateStyleMapping() {
		UtilHBM.waitExplicitDisplayed(driver, selectStylePopup);
		selectNoPreferenceForStyle();
		return PageFactory.initElements(driver, SelectMapping.class);
	}
//	<*********************************************MOBILE METHODS*********************>
	  public SelectMapping updateStyleMappingMobile(String cabinetsStyle, String worktopsStyle, String handlesStyle) {
	        UtilHBM.waitExplicitDisplayed(driver, selectStylePopup);
	        if (!cabinetsStyle.isEmpty()) selectCabinetStyle(cabinetsStyle);
	        if (!worktopsStyle.isEmpty()) selectWorktopStyle(worktopsStyle);
	        selectHandleStyle(handlesStyle);
	        clickUpdateMobile();
	        return PageFactory.initElements(driver, SelectMapping.class);
	    }
	public SelectMapping selectStyleMappingMobile(String cabinetsStyle, String worktopsStyle, String handlesStyle) {
		UtilHBM.waitExplicitDisplayed(driver, selectStylePopup);
		if (!cabinetsStyle.isEmpty()) selectCabinetStyle(cabinetsStyle);
		if (!worktopsStyle.isEmpty()) selectWorktopStyle(worktopsStyle);
        selectHandleStyle(handlesStyle);
        clickNextMobile();
		return PageFactory.initElements(driver, SelectMapping.class);
	}
	
	public SelectMapping clickNextMobile() {
        stylesNextBtnMobile.click();
        UtilHBM.waitTillElementDisappear(driver, stylesNextBtnMobile);
		return PageFactory.initElements(driver, SelectMapping.class);
    }
	public SelectMapping clickUpdateMobile() {
		stylesUpdateBtnMobile.click();
		UtilHBM.waitTillElementDisappear(driver, stylesUpdateBtn);
		return PageFactory.initElements(driver, SelectMapping.class);
	}
}
