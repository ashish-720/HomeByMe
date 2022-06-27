package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Edit {
	WebDriver driver;
	
	public Edit(WebDriver driver){
		this.driver = driver;
	}
	
//	Screen s = new Screen();
	
	@FindBy(css="body>div>div[data-ui-module='properties-panel']>div>header>div>.title")
	private WebElement titleEditThisElement;
	
	@FindBy(css="body>div>div[data-ui-module='properties-panel']>div>header>div>.product-name")
	private WebElement productName;
	
	@FindBy(css="body>div>div>div>div>form>.property-container>p[data-i18n='property.dimensions']")
	private WebElement dimensionsLegend;
	
	@FindBy(css=".property-container>div>p>label[for='width']")
	private WebElement widthLabel;
	
//	@FindBy(css=".property-container>div>p>span>#width")
	@FindBy(css="#width")
	private WebElement widthInputBox;
	
	@FindBy(css=".property-container>div>p>label[for='height']")
	private WebElement heightLabel;
	
//	@FindBy(css=".property-container>div>p>span>#height")
	@FindBy(css="#height")
	private WebElement heightInputBox;
	
	@FindBy(css=".property-container>div>p>label[for='depth']")
	private WebElement depthLabel;
	
//	@FindBy(css=".property-container>div>p>span>#depth")
	@FindBy(css="#depth")
	private WebElement depthInputBox;
			
//	@FindBy(css = "body>div>div>div>div>div>form>#color-category")
	@FindBy(css = "div>div>div>div>div>form>#color-category")
	private WebElement colorCatagoryDropdown;
		
//	@FindBy(css = "body>div>div>div>div>form>div>div>p>span>#thickness")
	@FindBy(id="thickness")
	private WebElement thicknessInputBox;
	
	@FindBy(css = "body>div>div>div>div>form>div>div>p>label[for='thickness']")
	private WebElement thicknessLabel;
		
	@FindBy(css = "body>div>div>div>div>form>div>div>p>#ceiling-height[type = 'checkbox']")
	private WebElement roomHeightCheckBox;
		
	@FindBy(css = "body>div>div>div>div>form>div>div>p>label[for='ceiling-height']")
	private WebElement roomHeightLabel;
			/*
	@CacheLookup
	@FindBy(id="length")
	WebElement lengthInputBox;
		*/
	//door window properties
	
	@FindBy(css="body>div>div>div>div>form>.property-container>p[data-i18n='property.position']")
	private WebElement positionLegend;
	
//	@FindBy(css="body>div>div>div>div>form>.property-container>p[data-i18n='property.position']+div>p>span>#height-from-floor")
	@FindBy(css="#height-from-floor")
	private WebElement heightFromFloorInputBox;
	
	@FindBy(css="body>div>div>div>div>form>.property-container>p[data-i18n='property.position']+div>p>label[for='height-from-floor']")	
	private WebElement heightFromFloorLabel;
	
	@FindBy(css="body>div>div>div>div>form>.property-container>p[data-i18n='property.position']+div>p>label[data-ui-action='product-wall-side']")	
	private WebElement changeWallSideButton;
	
	@FindBy(css="body>div>div>div>div>form>.property-container>p[data-i18n='property.position']+div>p>label[for='wall-side']")	
	private WebElement changeWallSideLabel;
	
	@FindBy(css="body>div>div>div>div>form>.property-container>p[data-i18n='property.position']+div>p>label[data-ui-action='product-opening-side']")	
	private WebElement changeWallOpeningButton;
	
	@FindBy(css="body>div>div>div>div>form>.property-container>p[data-i18n='property.position']+div>p>label[for='opening-side']")	
	private WebElement changeWallOpeningLabel;
	
	//room elements
	
	@FindBy(css="body>div>div>div>div>form>.property-container>p[data-i18n='property.properties']")
	private WebElement propertiesLabel;
	
	@FindBy(css="body>div>div>div>div>form>.property-container>p[data-i18n='property.properties']+div>p>label[for='name']")
	private WebElement roomNameLabel;
	
	@FindBy(css="body>div>div>div>div>form>.property-container>p[data-i18n='property.properties']+div>p>#name")
	private WebElement roomNameInputBox;
		
	@FindBy(css="body>div>div>div>div>form>.property-container>p[data-i18n='property.properties']+div>p>label[for='type']")
	private WebElement roomTypeLabel;
	
	@FindBy(css="body>div>div>div>div>form>.property-container>p[data-i18n='property.properties']+div>p>#type")
	private WebElement roomTypeDropdown;
	
	@FindBy(css=".panel-form>.property-container>.form-group>.form-row>#roomoptions-chkb-ceiling+label")
	private WebElement ceilingOpeningLabel;
	
	@FindBy(css=".panel-form>.property-container>.form-group>.form-row>#roomoptions-chkb-ceiling")
	private WebElement ceilingOpeningCheckBox;
	
	@FindBy(css=".panel-form>.property-container>.form-group>.form-row>#roomoptions-chkb-floor+label")
	private WebElement floorOpeningLabel;
	
	@FindBy(css=".panel-form>.property-container>.form-group>.form-row>#roomoptions-chkb-floor")
	private WebElement floorOpeningCheckBox;
	
	//Generic Style
	
	@FindBy(css="body>div>div>div>div>.style-container>.legend")
	private WebElement styleLegend;
	
	@FindBy(css="body>div>div>div>div>.style-container>div>ul>li>a")
	private List<WebElement> styleListFurniture;
	
	@FindBy(css="body>div>div>div>div>.style-container .material-item.material-item-unity")
	private WebElement coveringStyle;
	
	@FindBy(css="body>div>div>div>div>.style-container>div>ul>.material-item.material-item-unity[data-type='Floor']")
	private WebElement flooringStyle;
	
	@FindBy(css="body>div>div>div>div>.style-container>div>ul>.material-item.material-item-unity[data-type='Ceiling']")
	private WebElement ceilingStyle;
	
//	@FindBy(css=".colorPicker-grid-item>img")
//	List<WebElement> colorList;
	
//	@FindBy(id="color-current")
//	WebElement currentMatrialOnWallOrFloor;
	
	//Door properties
	
	@FindBy(css=".form-toggle[data-ui-action='product-opening-side']")
	private WebElement openingSideButton;	
		
	@FindBy(css="body>div>div>#bar-property>div>.toolBar-group-infos-right>#visit-store-button")
	private WebElement visitStore;
	
	@FindBy(css="body>div>div>#bar-property>div>.toolBar-group-infos-right>.button-more-info.buttonSecondary.button--small.u-mrs")
	private WebElement infoToolbarButton;
	
	@FindBy(css="body>div>div>div>header>div>.icon.icon-close")
	private WebElement closeProperties;
	
	// Following element to be removed after confirmation for Tania for Lenght for staircase
		
	@FindBy(id="length")
	private WebElement lengthInputBox;
	
	@FindBy(css=".properties-wrapper>div>form>div>div>.legend.legend-sloped.inline-block")
	private WebElement sloppedWallLabel;
	
	@FindBy(css=".properties-wrapper>div>form>div>div>.icon.icon-infos-12.icon-infos-sloped.inline-block")
	private WebElement sloppedWallinfo;
	
	@FindBy(css=".properties-wrapper>div>form>div>div>.icon.icon-infos-12.icon-infos-sloped.inline-block+label>.toggle")
	private WebElement sloppedToggle;
	
	@FindBy(css=".properties-wrapper>div>form>div>div>.icon.icon-infos-12.icon-infos-sloped.inline-block+label>.toggle")
	private List<WebElement> sloppedToggleList; // used only for verification that toggle is not available
	
	@FindBy(css=".properties-wrapper>div>form>div>div>.icon.icon-infos-12.icon-infos-sloped.inline-block+label>input")
	private WebElement sloppedToggleInput; // this element is used for getting status only
	
	@FindBy(css=".property-container>.form-group.form-group-sloped.is-active>p>span>#sloped-height")
	private WebElement slopHtInputBox;
	
	@FindBy(css=".property-container>.form-group.form-group-sloped.is-active>p>span>#sloped-depth")
	private WebElement slopDpthInputBox;
	
	@FindBy(css=".property-container>.form-group.form-group-sloped>p>label[for='sloped-height']")
	private WebElement slopHtLabel;
	
	@FindBy(xpath = "//label[@data-i18n='property.annotation.solidFill']/following-sibling::label")
	WebElement solidCheckBox;
	
	@FindBy(xpath = "(//div[@class='color-button'])[1]")
	WebElement fillColor;
	
	@FindBy(xpath = "(//div[@class='color-button'])[2]")
	WebElement lineColor;
	
	@FindBy(xpath = "(//div[@class='color-button'])[3]")
	WebElement textColor;
	
	@FindBy(css = "#annot-fill-opacity")
	WebElement transparency;
	
	@FindBy(css = "#annot-line-thickness")
	WebElement thickness;
	
	@FindBy(css = "#annot-font")
	WebElement font;
	
	@FindBy(css = "#annot-font-size")
	WebElement fontSize;
	
	@FindBy(css = ".button-wrapper.line-property-button")
	WebElement dashLine;
	
	@FindBy(css= "div>p[data-notif-action='ceilingChange']>span")
	private WebElement ceilingSuccessMsg;
	
	@FindBy(css= "div>p[data-notif-action='ceilingChange']>button")
	private WebElement ceilingLook;
	
	@FindBy(css = "#start-arrow-type-list>.button-wrapper.line-property-button")
	WebElement beginTypeLine;
	
	@FindBy(css = "#end-arrow-type-list>.button-wrapper.line-property-button")
	WebElement endTypeLine;

	@FindBy(xpath = "//div[@class='color-list']/div[@id='annot-fill-color']/span")
	WebElement fillColorSelected;
	
	@FindBy(xpath = "//div[@class='color-list']/div[@id='annot-line-color']/span")
	WebElement lineColorSelected;
	
	@FindBy(xpath = "//div[@class='color-list']/div[@id='annot-text-color']/span")
	WebElement textColorSelected;
	
	
	public ThreeDPlanner floorProperties(String roomType, String colorCatagory, String colorId, int isBranded_1ForYes){
		UtilHBM.waitExplicitClickable(driver, flooringStyle.findElement(By.cssSelector("span[data-material-style='Flooring']")));		
		if(!roomType.isEmpty()){			
			new Select(roomTypeDropdown).selectByVisibleText(roomType);
			roomNameInputBox.sendKeys(roomNameInputBox.getText());
		}
		if(!colorCatagory.isEmpty()){
			String styleName = flooringStyle.getText();
			flooringStyle.click();
			Material material = PageFactory.initElements(driver, Material.class);
			material.selectMaterial(styleName, colorCatagory, 0, colorId, isBranded_1ForYes);			
		}
		UtilHBM.waitFixTime(1000);
		closeProperties.click();
		UtilHBM.reportOK("Floor properties edited successfilly");
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner verifyFloorProperties(String roomType, String colorCatagory, String colorId, int isBranded_1ForYes){
		UtilHBM.waitExplicitClickable(driver, flooringStyle);
		if(!roomType.isEmpty()){
			if(roomType.equalsIgnoreCase(new Select(roomTypeDropdown).getFirstSelectedOption().getText())){
				UtilHBM.reportOK("Room type verified successfully. The room name is: " + roomNameInputBox.getAttribute("value"));
			}else{
				UtilHBM.reportKO("Room type verification failed. The room name is: " + roomNameInputBox.getAttribute("value"));
			}
		}
		String color = flooringStyle.findElement(By.tagName("img")).getAttribute("src");
		String styleName = flooringStyle.getText();
		flooringStyle.click();			
		Material material = PageFactory.initElements(driver, Material.class);
		material.verifytMaterial(styleName, color, colorCatagory, colorId, isBranded_1ForYes);
		closeProperties.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner ceilingProperties(String roomType, String colorCatagory, String colorId, int isBranded_1ForYes){
		UtilHBM.waitExplicitClickable(driver, ceilingStyle.findElement(By.cssSelector("span[data-material-style='Ceiling']")));		
		if(!roomType.isEmpty()){			
			new Select(roomTypeDropdown).selectByVisibleText(roomType);
			roomNameInputBox.sendKeys(roomNameInputBox.getText());
		}
		
		if(!colorCatagory.isEmpty()){
			String styleName = ceilingStyle.getText();
			ceilingStyle.click();
			Material material = PageFactory.initElements(driver, Material.class);
			material.selectMaterial(styleName, colorCatagory, 0, colorId, isBranded_1ForYes);			
		}

		Verification.displayNAttributeCheckOfElement(ceilingSuccessMsg, "ceilingSuccessMsg", "text", "Your ceiling material has been correctly applied");
		ceilingLook.click();
		UtilHBM.waitFixTime(1000);
		UtilHBM.reportOK("Floor properties edited successfilly");
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner verifyCeilingProperties(String colorCatagory, String colorId, int isBranded_1ForYes){
		UtilHBM.waitExplicitClickable(driver, ceilingStyle);
		String color = ceilingStyle.findElement(By.tagName("img")).getAttribute("src");
		String styleName = ceilingStyle.getText();
		ceilingStyle.click();			
		Material material = PageFactory.initElements(driver, Material.class);
		material.verifytMaterial(styleName, color, colorCatagory, colorId, isBranded_1ForYes);
		closeProperties.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner floorProperties(boolean ceilingOpening, boolean floorOpening) {
			UtilHBM.waitExplicitClickable(driver, flooringStyle.findElement(By.tagName("span")));
			UtilHBM.waitExplicitDisplayed(driver, ceilingOpeningLabel);
			Verification.displayNAttributeCheckOfElement(ceilingOpeningLabel, "Ceiling opening label",	"text", "Ceiling opening");
			Verification.displayNAttributeCheckOfElement(floorOpeningLabel, "Floor Opening label", "text", "Floor opening");
			if(ceilingOpening){
				if(!ceilingOpeningCheckBox.isSelected()){
					ceilingOpeningLabel.click();				
					Verification.selectedWebElement(driver, ceilingOpeningCheckBox);
				}
			}
			if(floorOpening){
				if(!floorOpeningCheckBox.isSelected()){
					floorOpeningLabel.click();
					Verification.selectedWebElement(driver, floorOpeningCheckBox);
				}
			}
//			closeProperties.click();
			return PageFactory.initElements(driver, ThreeDPlanner.class);		
	}
	
	public ThreeDPlanner verifyFloorProperties(boolean ceilingOpening, boolean floorOpening) {
		UtilHBM.waitExplicitDisplayed(driver, ceilingOpeningLabel);
		Verification.displayNAttributeCheckOfElement(ceilingOpeningLabel, "Ceiling opening label",	"text", "Ceiling opening");
		Verification.displayNAttributeCheckOfElement(floorOpeningLabel, "Floor Opening label", "text", "Floor opening");
		if(ceilingOpening){
			Verification.selectedWebElement(driver, ceilingOpeningCheckBox);
		}else{
			if(!ceilingOpeningCheckBox.isSelected()){
				UtilHBM.reportOK("Ceiling opening check box is not selected as expected.");
			}else{
				UtilHBM.reportKO("Ceiling opening check box selected. It is not expected.");
			}
		}
		if(floorOpening){
			Verification.selectedWebElement(driver, floorOpeningCheckBox);
		}else{
			if(!floorOpeningCheckBox.isSelected()){
				UtilHBM.reportOK("Floor opening check box is not selected as expected.");
			}else{
				UtilHBM.reportKO("Floor opening check box selected. It is not expected.");
			}
		}
		closeProperties.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);		
}
	

	
//	public ThreeDPlanner twoDWallProperties(String img, int xOffset, int yOffset, String thickness, String height){
//		try {			
//			int x = s.find(UtilHBM.createPattern(img)).getCenter().x + xOffset;
//			int y = s.find(UtilHBM.createPattern(img)).getCenter().y + yOffset;			
//			Location loc = new Location(x, y);
//			loc.hover();
//			loc.click();
//			loc.click();
//		} catch (FindFailed e) {
//			System.out.println("Could not find image in twoDWallProperties");
//			e.printStackTrace();
//		}
//			thicknessInputBox.clear();
//			thicknessInputBox.sendKeys(thickness);
//			int a=0;
//			do{
//				moreProperties.click();
//				a++;
//			}while(UtilHBM.listOfWebElement(driver, ".more.dropdown.dropdown--more.is-collapse").size()==0 && a<4);		
//			if (sameAsCeilingHeightCheckbox.isSelected()){
//				sameAsCeilingHeightCheckbox.click();
//			}
//			heightInputBox.clear();
//			heightInputBox.sendKeys(height);			
//		return PageFactory.initElements(driver, ThreeDPlanner.class);		
//	}
	
	public ThreeDPlanner threeDWallProperties (String colorCatagory, int colorPickerZeroIfNotPaint, String colorId, int isBranded_1ForYes){		
		UtilHBM.waitExplicitClickable(driver, coveringStyle.findElement(By.tagName("span")));
		String styleName = coveringStyle.getText();
		coveringStyle.click();
		Material material = PageFactory.initElements(driver, Material.class);
		material.selectMaterial(styleName, colorCatagory, colorPickerZeroIfNotPaint, colorId, isBranded_1ForYes);
		if(material.getImage().equalsIgnoreCase(coveringStyle.findElement(By.tagName("img")).getAttribute("src"))){
			UtilHBM.reportOK("Wall color changed to " + colorId);
		}
//		UtilHBM.waitFixTime(1000);
		closeProperties.click();
	return PageFactory.initElements(driver, ThreeDPlanner.class);
}
	
//	public ThreeDPlanner verifyThreeDWallProperties (String dropdownCatagory, String colorPickerNumber, String colorId){
//		String color = currentMatrialOnWallOrFloor.getAttribute("src");	
//		int a=0;
//		do{
//			moreProperties.click();
//			a++;
//		}while(UtilHBM.listOfWebElement(driver, ".more.dropdown.dropdown--more.is-collapse").size()==0 && a<4);
//			new Select(colorCatagoryDropdown).selectByVisibleText(dropdownCatagory);
//			UtilHBM.waitFixTime(4000);
//			if (dropdownCatagory.contains("paint")){
//				driver.findElement(By.cssSelector(".colorPicker-item[data-id = '" + colorPickerNumber + "']")).click();	
//			}			
//			String color1 =driver.findElement(By.cssSelector("a[data-id='" + colorId + "']>img")).getAttribute("src");
//			moreProperties.click();
//			if(color.equalsIgnoreCase(color1)){
//				UtilHBM.reportOK("Wall color varification success");
//			}else{
//				UtilHBM.reportKO("Wall color varification failed");
//			}
//		return PageFactory.initElements(driver, ThreeDPlanner.class);
//	}
	
	public ThreeDPlanner verifyThreeDWallProperties (String colorCatagory, int colorPickerNumber, String colorId, int isBranded_1ForYes){	
		UtilHBM.waitExplicitClickable(driver, coveringStyle);
		String color = coveringStyle.findElement(By.tagName("img")).getAttribute("src");
		String styleName = coveringStyle.getText();
		coveringStyle.click();
		Material material = PageFactory.initElements(driver, Material.class);		
		material.verifytMaterial(styleName, color, colorCatagory, colorId, isBranded_1ForYes);		
		closeProperties.click();
	return PageFactory.initElements(driver, ThreeDPlanner.class);
}
	
	public ThreeDPlanner twoDWallProperties(String thickness, String height, String slopHt, String slopDpt){
		if(!thickness.isEmpty()){
			UtilHBM.waitExplicitClickable(driver, titleEditThisElement);
			UtilHBM.waitExplicitClickable(driver, thicknessInputBox);
			UtilHBM.waitFixTime(500);
			thicknessInputBox.click();
//			thicknessInputBox.clear();
			while (!thicknessInputBox.getAttribute("value").isEmpty()){
				thicknessInputBox.sendKeys(Keys.BACK_SPACE);			
			}
			thicknessInputBox.sendKeys(thickness, Keys.ENTER);
		}										
		if(!height.isEmpty()){			
			if(height.equalsIgnoreCase("roomHt")){
				if (!roomHeightCheckBox.isSelected()){
					roomHeightLabel.click();
				}
			}else{
				if (roomHeightCheckBox.isSelected()){
					roomHeightLabel.click();
				}
				heightInputBox.click();
//				heightInputBox.clear();
				while (!heightInputBox.getAttribute("value").isEmpty()){
					heightInputBox.sendKeys(Keys.BACK_SPACE);			
				}
				heightInputBox.sendKeys(height, Keys.ENTER);
			}
			}
		if (!slopHt.isEmpty()){
			UtilHBM.waitExplicitClickable(driver, sloppedToggle);			
			if(!slopHtLabel.isDisplayed() && !UtilHBM.isAttribtuePresent(driver, sloppedToggleInput, "checked")){				
				sloppedToggle.click();
				if(slopHtLabel.isDisplayed() && UtilHBM.isAttribtuePresent(driver, sloppedToggleInput, "checked")){
					UtilHBM.reportOK("Slopped wall toggle is activated");					
				}else{
					UtilHBM.reportKO("Slopped wall toggle is not activated");
				}
			}else{
				UtilHBM.reportWarning("Slopped wall toggle was already activated before click");
			}
			slopHtInputBox.click();
//			slopHtInputBox.clear();
			while (!slopHtInputBox.getAttribute("value").isEmpty()){
				slopHtInputBox.sendKeys(Keys.BACK_SPACE);			
			}
			slopHtInputBox.sendKeys(slopHt, Keys.ENTER);
//			slopHtInputBox.sendKeys(Keys.ENTER);	
			if(slopHtInputBox.getAttribute("value").split(" ")[0].equalsIgnoreCase(slopHt)){
				UtilHBM.reportOK("Slopped wall Height changed to "+slopHtInputBox.getAttribute("value"));
			}else {
				UtilHBM.reportKO("Slopped wall Height not changed to correct values. The current values is " + slopHtInputBox.getAttribute("value") + "& expected value is " + slopHt );
			}
		}
		if(!slopDpt.isEmpty()){
			UtilHBM.waitExplicitClickable(driver, sloppedToggle);			
			if(!slopHtLabel.isDisplayed() && !UtilHBM.isAttribtuePresent(driver, sloppedToggleInput, "checked")){				
				sloppedToggle.click();
				if(slopHtLabel.isDisplayed() && UtilHBM.isAttribtuePresent(driver, sloppedToggleInput, "checked")){
					UtilHBM.reportOK("Slopped wall toggle is activated");					
				}else{
					UtilHBM.reportKO("Slopped wall toggle is not activated");
				}
			}else{
				UtilHBM.reportWarning("Slopped wall toggle was already activated before click");
			}
//			slopDpthInputBox.clear();
			slopDpthInputBox.click();
			while (!slopDpthInputBox.getAttribute("value").isEmpty()){
				slopDpthInputBox.sendKeys(Keys.BACK_SPACE);			
			}
			slopDpthInputBox.sendKeys(slopDpt, Keys.ENTER);
//			slopDpthInputBox.sendKeys(Keys.ENTER);
			if(slopDpthInputBox.getAttribute("value").split(" ")[0].equalsIgnoreCase(slopDpt)){
				UtilHBM.reportOK("Slopped wall Depth changed to " + slopDpthInputBox.getAttribute("value"));
			}else {
				UtilHBM.reportKO("Slopped wall Depth not changed to correct values. The current values is " + slopDpthInputBox.getAttribute("value") +"& expected is "+ slopDpt);
			}
		}
		closeProperties.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);		
	}
	
	public ThreeDPlanner verifyTwoDWallProperties(String thickness, String height, int ceilingHtBox, String slopHt, String slopDth){		
		if(thickness.equalsIgnoreCase(thicknessInputBox.getAttribute("value")) && 
				height.equalsIgnoreCase(heightInputBox.getAttribute("value"))){
			UtilHBM.reportOK("Thickness & Height of wall verified successfully");
		}else{
			UtilHBM.reportKO("Thickness & Height of wall verification failed");
			UtilHBM.reportKO("Wall Thickness: expected = "+thickness +", actual= " + thicknessInputBox.getAttribute("value"));
			UtilHBM.reportKO("Height: expected= "+height + ", actual= " +heightInputBox.getAttribute("value"));
		}
		if(ceilingHtBox==1){			
			if (roomHeightCheckBox.isSelected()){
				UtilHBM.reportOK("'same as ceiling' check box selected(checked). Verification success");
			}else{
				UtilHBM.reportKO("'same as ceiling' check box is unchecked. Verification failed");
			}			
		}else{
			if (!roomHeightCheckBox.isSelected()){
				UtilHBM.reportOK("'same as ceiling' check box unchecked. Verification success");
			}else{
				UtilHBM.reportKO("'same as ceiling' check box is selected(checked). Verification failed");
			}
		}
		if(!slopHt.isEmpty()){
			if(slopHt.equalsIgnoreCase("na")){
				UtilHBM.turnOffImplicitWaits(driver);
				if(sloppedToggleList.size()!=0){
					UtilHBM.reportKO("Slopped Wall option is displyed for internal wall");
				}
				UtilHBM.turnOnImplicitWaits(driver);
			}else{
				if(slopHtLabel.isDisplayed() && 
						UtilHBM.isAttribtuePresent(driver, sloppedToggleInput, "checked") &&
						slopHtInputBox.getAttribute("value").equalsIgnoreCase(slopHt) && 
						slopDpthInputBox.getAttribute("value").equalsIgnoreCase(slopDth) &&
						sloppedWallinfo.isDisplayed() && 
						sloppedWallLabel.getText().equalsIgnoreCase("Sloped wall")){
					UtilHBM.reportOK("Slopped wall properties verified");
				}else{
					UtilHBM.reportKO("Slopped wall properties verification KO. The current values are: ");
					UtilHBM.reportKO("slopped Height =" + slopHtInputBox.getAttribute("value"));
					UtilHBM.reportKO("slopped Depth =" + slopDpthInputBox.getAttribute("value"));
				}
			}
		}
		UtilHBM.waitExplicitClickable(driver, closeProperties);
		closeProperties.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);		
	}
	
	public ThreeDPlanner doorWinProperties(String ht, String wth, String htFromFloor, int chgWalSd, int openingSd){		
		UtilHBM.waitExplicitClickable(driver, titleEditThisElement);
		if(!(ht.isEmpty())){			
			UtilHBM.waitExplicitClickable(driver, heightInputBox);			
//			heightInputBox.clear();
//			heightInputBox.click();
//			heightInputBox.sendKeys(Keys.CONTROL + "a");
			while (!heightInputBox.getAttribute("value").isEmpty()){
				heightInputBox.sendKeys(Keys.BACK_SPACE);			
			}			    
			heightInputBox.sendKeys(ht);
		}
		if(!(wth.isEmpty())){	
			UtilHBM.waitExplicitClickable(driver, widthInputBox);
//			widthInputBox.clear();
			widthInputBox.click();
//			widthInputBox.sendKeys(Keys.CONTROL + "a");?
			while (!widthInputBox.getAttribute("value").isEmpty()){
				widthInputBox.sendKeys(Keys.BACK_SPACE);			
			}
			widthInputBox.sendKeys(wth);
		}
		if(!(htFromFloor.isEmpty())){
			UtilHBM.waitExplicitClickable(driver, heightFromFloorInputBox);
//			heightFromFloorInputBox.clear();
			heightFromFloorInputBox.click();
//			heightFromFloorInputBox.sendKeys(Keys.CONTROL + "a");
			while (!heightFromFloorInputBox.getAttribute("value").isEmpty()){
				heightFromFloorInputBox.sendKeys(Keys.BACK_SPACE);			
			}
			heightFromFloorInputBox.sendKeys(htFromFloor);
		}		
		if(!(chgWalSd==0)){
			UtilHBM.waitExplicitDisplayed(driver, changeWallSideButton);
			String status= changeWallSideButton.getAttribute("class");
			changeWallSideButton.click();			
			if(status.equalsIgnoreCase(changeWallSideButton.getAttribute("class"))){
				UtilHBM.reportKO("Change wall side of door/window failed");
			}else{
				UtilHBM.reportOK("Changed wall side of door/window");
			}
		}
		if(!(openingSd==0)){
			String status= openingSideButton.getAttribute("class");
			openingSideButton.click();
			if(status.equalsIgnoreCase(openingSideButton.getAttribute("class"))){
				UtilHBM.reportKO("Change wall opening of door/window failed");
			}else{
				UtilHBM.reportOK("Changed wall opening of door/window");
			}
		}
//		if(Integer.parseInt(heightInputBox.getAttribute("value"))==ht && Integer.parseInt(widthInputBox.getAttribute("value"))==wth && Integer.parseInt(heightFromFloor.getAttribute("value"))==htFromFloor){
//			Reporter.log("<font color = 'green'> Door/Window properties modified correctly <br>");
//		}else {
//			Reporter.log("<front color = 'red'> problem in door/window properties modification <br>");
//		}
		UtilHBM.reportInfo("Door/Window properties changed");	
		UtilHBM.waitExplicitClickable(driver, closeProperties);
		closeProperties.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public void verifyDoorWinProperties(String ht, String wth, String htFromFloor){//		
		if((ht.equalsIgnoreCase(heightInputBox.getAttribute("value"))) && 
				(wth.equalsIgnoreCase(widthInputBox.getAttribute("value")))){
			UtilHBM.reportOK("Door/Window properties verified successfully");
		}else{
			UtilHBM.reportKO("Door/Window properties verification failed.");
			UtilHBM.reportKO("Expected values:<br>height = "+ht+ ", Width = "+ wth + ", height from floor = " + htFromFloor);
			UtilHBM.reportKO("Actual Values:<br>height=" +heightInputBox.getAttribute("value")+ "<br> width=" + widthInputBox.getAttribute("value"));
		}
		if(!htFromFloor.isEmpty()){
			if(htFromFloor.equalsIgnoreCase(heightFromFloorInputBox.getAttribute("value"))){
				UtilHBM.reportOK("Height From Floor of Door/Window properties verified successfully");
			}else{
				UtilHBM.reportKO("Height From Floor of Door/Window properties verification failed");
				UtilHBM.reportKO("Expected ht from floor=" + htFromFloor + ", Actual ht from floor=" + heightFromFloorInputBox.getAttribute("value"));
			}
		}
		UtilHBM.waitExplicitClickable(driver, closeProperties);		
		closeProperties.click();
	}
	
	public void genericProperties(String ht, String wth, String dpth, String materialType, int colorPickerNumber, String materialId){
		UtilHBM.waitExplicitClickable(driver, titleEditThisElement);		
		if(!(ht.isEmpty())){
			UtilHBM.waitExplicitClickable(driver, heightInputBox);			
//			heightInputBox.clear();
//			heightInputBox.click();
//			heightInputBox.sendKeys(Keys.CONTROL+"a");
			while (!heightInputBox.getAttribute("value").isEmpty()){
				heightInputBox.sendKeys(Keys.BACK_SPACE);			
			}
			heightInputBox.sendKeys(ht);
		}
		if(!(wth.isEmpty())){			
//			widthInputBox.clear();
//			widthInputBox.click();
//			widthInputBox.sendKeys(Keys.CONTROL + "a");
			while (!widthInputBox.getAttribute("value").isEmpty()){
				widthInputBox.sendKeys(Keys.BACK_SPACE);			
			}
			widthInputBox.sendKeys(wth);
		}
//		if(!(lnth.isEmpty())){
//			lengthInputBox.clear();
//			lengthInputBox.sendKeys(lnth);
//		}
		if(!(dpth.isEmpty())){			
//			depthInputBox.clear();
//			depthInputBox.click();
//			depthInputBox.sendKeys(Keys.CONTROL + "a");
			while (!depthInputBox.getAttribute("value").isEmpty()){
				depthInputBox.sendKeys(Keys.BACK_SPACE);			
			}
			depthInputBox.sendKeys(dpth);
		}
		if (!(materialId.isEmpty())){
			String styleName;			
			for(WebElement style:styleListFurniture){
				UtilHBM.waitExplicitClickable(driver, style);
				UtilHBM.waitExplicitDisplayed(driver, style.findElement(By.tagName("span")));
				styleName=style.getText();			
				style.click();
				Material material = PageFactory.initElements(driver, Material.class);
				material.selectMaterial(styleName, materialType, colorPickerNumber, materialId, 0);				
				System.out.println("paing: " + style.findElement(By.cssSelector(".listItems-thumb")).getAttribute("style"));
				String materialThumb = style.findElement(By.cssSelector(".listItems-thumb")).getAttribute("style").split("\"")[1];
				System.out.println(materialThumb);
				System.out.println("get methos: " +material.getImage());
				if(materialThumb.equalsIgnoreCase(material.getImage())){
					UtilHBM.reportOK("Material" + materialId + " applied to style " + styleName);
				}else{
					UtilHBM.reportKO("Material" + materialId + " not applied to style " + styleName);
				}
			}			
		}		
	}
	
	public void editGenericPropertiesByMaterialId(String ht, String wth, String dpth, String materialId) {
		UtilHBM.waitExplicitClickable(driver, titleEditThisElement);
		UtilHBM.turnOffImplicitWaits(driver);
		List<WebElement> htSelect = driver.findElements(By.cssSelector("select#height"));
		List<WebElement> wthSelect = driver.findElements(By.cssSelector("select#width"));
		List<WebElement> dpthSelect = driver.findElements(By.cssSelector("select#depth"));
		UtilHBM.turnOnImplicitWaits(driver);
		if (!(ht.isEmpty())) {
			if (!htSelect.isEmpty()) {
				Select select = new Select(htSelect.get(0));
				select.selectByVisibleText(ht);
			} else {
				UtilHBM.waitExplicitClickable(driver, heightInputBox);
				while (!heightInputBox.getAttribute("value").isEmpty()) {
					heightInputBox.sendKeys(Keys.BACK_SPACE);
				}
				heightInputBox.sendKeys(ht);
			}
		}
		if (!(wth.isEmpty())) {
			if (!wthSelect.isEmpty()) {
				Select select = new Select(wthSelect.get(0));
				select.selectByVisibleText(wth);
			} else {
				UtilHBM.waitExplicitClickable(driver, widthInputBox);
				while (!widthInputBox.getAttribute("value").isEmpty()) {
					widthInputBox.sendKeys(Keys.BACK_SPACE);
				}
				widthInputBox.sendKeys(wth);
			}
		}
		if (!(dpth.isEmpty())) {
			if (!dpthSelect.isEmpty()) {
				Select select = new Select(dpthSelect.get(0));
				select.selectByVisibleText(dpth);
			} else {
				UtilHBM.waitExplicitClickable(driver, depthInputBox);

				while (!depthInputBox.getAttribute("value").isEmpty()) {
					depthInputBox.sendKeys(Keys.BACK_SPACE);
				}
				depthInputBox.sendKeys(dpth);
			}
		}
		String styleName;
		for (WebElement style : styleListFurniture) {
			UtilHBM.waitExplicitClickable(driver, style);
			UtilHBM.waitExplicitDisplayed(driver, style.findElement(By.tagName("span")));
			styleName = style.getText();
			style.click();
			Material material = PageFactory.initElements(driver, Material.class);
			material.selectMaterialById(materialId);
			System.out.println("paing: " + style.findElement(By.cssSelector(".listItems-thumb")).getAttribute("style"));
			String materialThumb = style.findElement(By.cssSelector(".listItems-thumb")).getAttribute("style")
					.split("\"")[1];
			System.out.println(materialThumb);
			System.out.println("get methos: " + material.getImage());
			if (materialThumb.equalsIgnoreCase(material.getImage())) {
				UtilHBM.reportOK("Material" + materialId + " applied to style " + styleName);
			} else {
				UtilHBM.reportKO("Material" + materialId + " not applied to style " + styleName);
			}
		}
	}
	
		
	public void verifyGenericProperties(String ht, String wth, String dpth, String materialId){	
		String actualHt="";
		String actualWth="";
		String actualDpth ="";
		if(!ht.isEmpty()){
			if(heightInputBox.getTagName().equalsIgnoreCase("select")){
				actualHt= new Select(heightInputBox).getFirstSelectedOption().getText();
			}else{
				actualHt=heightInputBox.getAttribute("value");
			}
		}
		if(!wth.isEmpty()){
			if(widthInputBox.getTagName().equalsIgnoreCase("select")){
				actualWth= new Select(widthInputBox).getFirstSelectedOption().getText();
			}else{
				actualWth=widthInputBox.getAttribute("value");
			}
		}
		if(!dpth.isEmpty()){
			if(depthInputBox.getTagName().equalsIgnoreCase("select")){
				actualDpth= new Select(depthInputBox).getFirstSelectedOption().getText();
			}else{
				actualDpth=depthInputBox.getAttribute("value");
			}
		}
		if(ht.isEmpty() && wth.isEmpty() && dpth.isEmpty()){
			UtilHBM.reportInfo("Only Material property is available for verification");
		}else if(!(ht.isEmpty() || wth.isEmpty() || dpth.isEmpty())){
			if((ht.equalsIgnoreCase(actualHt))&&(wth.equalsIgnoreCase(actualWth))&& (dpth.equalsIgnoreCase(actualDpth))){
				UtilHBM.reportOK("Properties verified successfully");
			}else{				
				UtilHBM.reportKO("Properties verification failed. Expected Vs Actual Height, Width, Depth are " + ht +", " + wth + ", "+ dpth  + " Vs "+actualHt + ", "+ actualWth + ", "+ actualDpth);
			}			
		}else if(ht.isEmpty()){
			if(wth.isEmpty() || dpth.isEmpty()){
				if(wth.isEmpty()){
					if(dpth.equalsIgnoreCase(actualDpth)){
						UtilHBM.reportOK("Properties verified successfully. Only Depth property is available");
					}else{
						UtilHBM.reportKO("Properties verification failed. Only Depth property is available");
					}									
				}else {
					if(wth.equalsIgnoreCase(actualWth)){
						UtilHBM.reportOK("Properties verified successfully. Only Width property is available");
					}else{
						UtilHBM.reportKO("Properties verification failed. Only Width property is available");
					}
				}				
			}else if(dpth.equalsIgnoreCase(actualDpth)&& wth.equalsIgnoreCase(actualWth)){
				UtilHBM.reportOK("Properties verified successfully. Height is not available for this product");
			}else{
				UtilHBM.reportOK("Properties verification failed.");
			}
		}else if(wth.isEmpty()){
			if(ht.isEmpty() || dpth.isEmpty()){
				if(dpth.isEmpty()){
					if(ht.equalsIgnoreCase(actualHt)){
						UtilHBM.reportOK("Properties verified successfully. Only Height property is available");
					}else{
						UtilHBM.reportKO("Properties verification failed. Only Height property is available");
					}
				}else{
					if(dpth.equalsIgnoreCase(actualDpth)){
						UtilHBM.reportOK("Properties verified successfully. Only Depth property is available");
					}else{
						UtilHBM.reportKO("Properties verification failed.");
					}
				}
			}else if((ht.equalsIgnoreCase(actualHt))&&(dpth.equalsIgnoreCase(actualDpth))){
					UtilHBM.reportOK("Properties verified successfully. Width property not available for this furniture");
				}else{				
					UtilHBM.reportKO("Properties verification failed");				
			}			
		}else if (dpth.isEmpty()){
			if(ht.isEmpty() || wth.isEmpty()){
				if(wth.isEmpty()){
					if(ht.equalsIgnoreCase(actualHt)){
						UtilHBM.reportOK("Properties verified successfully. Only Height property is available");
					}else{
						UtilHBM.reportKO("Properties verification failed. Only Height property is available");
					}
				}else{
					if(wth.equalsIgnoreCase(actualWth)){
						UtilHBM.reportOK("Properties verified successfully. Only Width property is available");
					}else{
						UtilHBM.reportKO("Properties verification failed.");
					}
				}
			}else if((ht.equalsIgnoreCase(actualHt))&&(wth.equalsIgnoreCase(actualWth))){
				UtilHBM.reportOK("Properties verified successfully. Depth property not available for this furniture");
			}else{				
				UtilHBM.reportKO("Properties verification failed");
			}			
		}
		if(!(materialId.isEmpty())){
			String styleImg= null;
			String styleName = null;
			String materialImg=null;
			styleImg= styleListFurniture.get(0).findElement(By.cssSelector(".listItems-thumb")).getAttribute("style").split("\"")[1];
			styleName = styleListFurniture.get(0).getText();
			UtilHBM.waitExplicitClickable(driver, styleListFurniture.get(0));
			styleListFurniture.get(0).click();
			Material material = PageFactory.initElements(driver, Material.class);
			material.verifytMaterial(styleName, styleImg, "", materialId, 0);
			materialImg=material.getImage();
			if(styleListFurniture.size()>1){
				for (WebElement style:styleListFurniture){
					styleName = style.getText();
					styleImg = style.findElement(By.cssSelector(".listItems-thumb")).getAttribute("style").split("\"")[1];
					if(styleImg.equalsIgnoreCase(materialImg)){
						UtilHBM.reportOK("Material verification successful for style: " + styleName);
					}else{
						UtilHBM.reportKO("Material verification failed for style: " + styleName);
					}
//					Material material = PageFactory.initElements(driver, Material.class);
//					material.verifytMaterial(styleName, materialImg, "", materialId, 0);
				}
			}
			
		}		
	}	

	protected ThreeDPlanner addWallMtlToFavorite(String favList, String newOrExistingList ,boolean new_1_old_0){
		coveringStyle.click();
		Material mtl = PageFactory.initElements(driver, Material.class);
		mtl.addMtlToFavorite(favList, newOrExistingList, new_1_old_0);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}	
	
	public ThreeDPlanner verifyAnnotation(boolean solid, String fillColor, String lineColor, String textColor){
		Verification.displayNAttributeCheckOfElement(titleEditThisElement, "titleEditThisElement", "text", "Edit this element");
		Verification.displayNAttributeCheckOfElement(productName, "productName", "text", "Ellipse");
		System.out.println("Transperency value:" + transparency.getAttribute("value"));
		if(solid){
			if(!solidCheckBox.isSelected()){
				UtilHBM.reportKO("Solid property of annotation checkbox is not verified. Expected value: "+ solid +", actual value: "+solidCheckBox.isSelected());
			}
		}else{
			if(solidCheckBox.isSelected()){
				UtilHBM.reportKO("Solid property of annotation checkbox is not verified. Expected value: "+ solid +", actual value: "+solidCheckBox.isSelected());
			}
		}
		
		Verification.displayNAttributeCheckOfElement(fillColorSelected, "Annotation fill color", "style", fillColor);
		Verification.displayNAttributeCheckOfElement(lineColorSelected, "Annotation line color", "style", lineColor);
		Verification.displayNAttributeCheckOfElement(textColorSelected, "Annotation text color", "style", textColor); 
		
		
		System.out.println("line thickness value:" + thickness.getAttribute("value"));
		if(!driver.findElement(By.cssSelector(".active.line-property-list-content>div:nth-child(2)")).isSelected()){
			UtilHBM.reportKO("dash type not verified");
		}else{
			UtilHBM.reportOK("dash type verified");
		}
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
//	@FindBy(css = ".active.line-property-list-content>div")
//	WebElement dashTypeSelected;
	
	public ThreeDPlanner editAnnotation(boolean solid, int fillColorIndex, int xOffset, int yOffset, String lineThickness, int lineColorIndex, int dashTypeIndex, int textColorIndex, String fontValue, String fontSizeValue){
		
		titleEditThisElement.getText();
		productName.getText();
		driver.findElement(By.cssSelector("[data-i18n='property.edit_element']")).getText();
		driver.findElement(By.cssSelector(".product-name")).getText();
		UtilHBM.waitExplicitDisplayed(driver, solidCheckBox);
		WebElement solidToggleStatus = solidCheckBox.findElement(By.tagName("input"));  //findElement(By.tagName("span"));
		if(solid){
			if(solidToggleStatus.isSelected()){
				solidCheckBox.click();
			}
		}else{
			if(!solidToggleStatus.isSelected()){
				solidCheckBox.click();
			}
		}
		fillColor(fillColorIndex);
		transparency(xOffset, yOffset);
		lineThickness(lineThickness);
		lineColor(lineColorIndex);
		dashType(dashTypeIndex);
		textColor(textColorIndex);
		font(fontValue);
		fontSize(fontSizeValue);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner lineEditAnnotation(String value, int lineColorIndex, int index, String type, String endType){
		driver.findElement(By.cssSelector("[data-i18n='property.edit_element']")).getText();
		driver.findElement(By.cssSelector(".product-name")).getText();
		lineThickness(value);
		arrowColor(lineColorIndex);
		dashType(index);
		beginType(type);
		endType(endType);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	private Edit arrowColor (int colorIndex){
		fillColor.click();
		WebElement arrowColorOptions = driver.findElements(By.cssSelector("#annot-line-color>span")).get(colorIndex);
		UtilHBM.waitExplicitClickable(driver, arrowColorOptions);
		new Actions(driver).moveToElement(arrowColorOptions).build().perform();
		arrowColorOptions.click();
		return PageFactory.initElements(driver, Edit.class);
	}
	
	private Edit fillColor (int colorIndex){
		fillColor.click();
		WebElement fillColorOptions = driver.findElements(By.cssSelector("#annot-fill-color>span")).get(colorIndex);
		UtilHBM.waitExplicitClickable(driver, fillColorOptions);
		new Actions(driver).moveToElement(fillColorOptions).build().perform();
		fillColorOptions.click();
		return PageFactory.initElements(driver, Edit.class);
	}
	
	public Edit transparency(int xOffset, int yOffset) {
		UtilHBM.waitExplicitDisplayed(driver, transparency);
		transparency.click();
		new Actions(driver).moveToElement(transparency, xOffset, yOffset).click().build().perform();
		return PageFactory.initElements(driver, Edit.class);
	}
	
	private Edit lineThickness (String value){
		new Select(thickness).selectByValue(value);  
		return PageFactory.initElements(driver, Edit.class);
	}
	
	private Edit lineColor (int lineColorIndex){
		lineColor.click();
		UtilHBM.waitFixTime(1000);
		WebElement lineColorOptions = driver.findElements(By.cssSelector("#annot-line-color>span")).get(lineColorIndex);
		UtilHBM.waitExplicitClickable(driver, lineColorOptions);
		new Actions(driver).moveToElement(lineColorOptions).build().perform();
		lineColorOptions.click();
		//new Select(colorOptions).selectByIndex(colorIndex);  
		return PageFactory.initElements(driver, Edit.class);
	}
	
	private Edit beginType (String type){
		beginTypeLine.click();
		UtilHBM.waitFixTime(1000);
		WebElement beginLineOption = driver.findElement(By.cssSelector(".line-property-list-content-item>[linestartstyle='"+type+"']"));
		UtilHBM.waitExplicitClickable(driver, beginLineOption);
		new Actions(driver).moveToElement(beginLineOption).build().perform();
		beginLineOption.click();
		return PageFactory.initElements(driver, Edit.class);
	}
	
	private Edit endType (String endType){
		endTypeLine.click();
		UtilHBM.waitFixTime(1000);
		WebElement endLineOption = driver.findElement(By.cssSelector(".line-property-list-content-item>[lineendstyle='"+endType+"']"));
		UtilHBM.waitExplicitClickable(driver, endLineOption);
		new Actions(driver).moveToElement(endLineOption).build().perform();
		endLineOption.click();
		return PageFactory.initElements(driver, Edit.class);
	}
	
	private Edit dashType (int index){
		dashLine.click();
		UtilHBM.waitFixTime(1000);
		WebElement dashLineOption = driver.findElements(By.cssSelector(".active.line-property-list-content>div")).get(index);
		UtilHBM.waitExplicitClickable(driver, dashLineOption);
		new Actions(driver).moveToElement(dashLineOption).build().perform();
		dashLineOption.click();
		return PageFactory.initElements(driver, Edit.class);
	}
	
	private Edit textColor (int textIndex){
		textColor.click();
		WebElement textColorOptions = driver.findElements(By.cssSelector("#annot-text-color>span")).get(textIndex);
		UtilHBM.waitExplicitClickable(driver, textColorOptions);
		new Actions(driver).moveToElement(textColorOptions).build().perform();
		textColorOptions.click(); 
		return PageFactory.initElements(driver, Edit.class);
	}
	
	private Edit font (String fontValue){
		
		new Select(font).selectByValue(fontValue);  
		return PageFactory.initElements(driver, Edit.class);
	}
	
	private Edit fontSize (String fontSizeValue){
		
		new Select(fontSize).selectByValue(fontSizeValue);  
		return PageFactory.initElements(driver, Edit.class);
	}
	
}
