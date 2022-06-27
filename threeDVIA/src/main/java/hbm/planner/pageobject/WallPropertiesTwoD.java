package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WallPropertiesTwoD {
	WebDriver driver;
	
	public WallPropertiesTwoD(WebDriver driver) {
		this.driver = driver;
	}
	
	@CacheLookup
	@FindBy(css = ".toolBar-group-infos-right span[class='icon icon-dropdown']")
	WebElement moreProperties;
	
	@CacheLookup
	@FindBy(id = "thickness")
	WebElement thicknessInputBox;
	
	@CacheLookup
	@FindBy(css = "#ceiling-height[type = 'checkbox']")
	WebElement sameAsCeilingHeightCheckbox;
	
	@CacheLookup
	@FindBy(id = "height")
	WebElement heightInputBox;
	
	@CacheLookup
	@FindBy(xpath = "//label[.='same as ceiling height']")
	WebElement sameAsCeilingHeightText;
	
	@CacheLookup
	@FindBy(css=".Wall2DMeasure.Tag3D.visibility-visible.pointer-events-activated")
	List<WebElement> dimensionList;	
	
	@CacheLookup
	@FindBy(xpath="//input[contains(@style, 'rotate')]")
	List<WebElement> vDimensionList;
	
	@FindBy(css=".Wall2DMeasure.Tag3DMeasure2D.visibility-visible.direction-column>.order-first")
	WebElement applyAboveButton;	
	
	@FindBy(css=".Wall2DMeasure.Tag3DMeasure2D.visibility-visible.direction-column>.order-second")
	WebElement applyBelowButton;	
	
	@FindBy(css=".Wall2DMeasure.Tag3DMeasure2D.visibility-visible.direction-row>.order-first")
	WebElement applyLeftButton;	
	
	@FindBy(css=".Wall2DMeasure.Tag3DMeasure2D.visibility-visible.direction-row>.order-second")
	WebElement applyRightbutton;
	
	@FindBy(css=".Wall2DMeasure.Tag3DMeasure2D.visibility-visible.direction-column>input")
	WebElement dimensionInputVerticle;
	
	@FindBy(css=".Wall2DMeasure.Tag3DMeasure2D.visibility-visible.direction-row>input")
	WebElement dimensionInputHorizontal;

//	public ThreeDPlanner twoDWallProperties(String thickness, String height){
//		if(!thickness.isEmpty()){
//			thicknessInputBox.clear();
//			thicknessInputBox.sendKeys(thickness);
//		}										
//		if(!height.isEmpty()){
//			int a=0;
//			do{
//				moreProperties.click();
//				a++;
//			}while(UtilHBM.listOfWebElement(driver, ".more.dropdown.dropdown--more.is-collapse").size()==0 && a<4);
//			if (sameAsCeilingHeightCheckbox.isSelected()){
//				sameAsCeilingHeightText.click();
//			}
//			heightInputBox.clear();
//			heightInputBox.sendKeys(height);
//		}						
//		return PageFactory.initElements(driver, ThreeDPlanner.class);		
//	}
	
	public ThreeDPlanner twoWallDimensions(String oldValue, String newvalue, String applyToLeftRightAboveBelow){
//		for(WebElement dim:dimensionList){			
//			try{
//				UtilHBM.waitExplicitClickable(driver, dim);
				if(oldValue.equalsIgnoreCase(dimensionList.get(0).getAttribute("value"))){					
					new Actions(driver).moveToElement(dimensionList.get(0)).click().build().perform();
//					dimensionList.get(0).click();					
					if(applyToLeftRightAboveBelow.equalsIgnoreCase("left") || applyToLeftRightAboveBelow.equalsIgnoreCase("right")){
//						dimensionInputHorizontal.clear();
						dimensionInputHorizontal.sendKeys(newvalue);
					}else{
//						dimensionInputVerticle.clear();
						dimensionInputVerticle.sendKeys(newvalue);
					}
					if(applyToLeftRightAboveBelow.equalsIgnoreCase("above")){
						applyAboveButton.click();
					}else if(applyToLeftRightAboveBelow.equalsIgnoreCase("below")){
						applyBelowButton.click();
					}else if(applyToLeftRightAboveBelow.equalsIgnoreCase("left")){
						applyLeftButton.click();
					}else if(applyToLeftRightAboveBelow.equalsIgnoreCase("right")){
						applyRightbutton.click();
					}
					UtilHBM.reportOK("Dimension of wall changed from " + oldValue + " to " + newvalue);
				}else if(oldValue.equalsIgnoreCase(dimensionList.get(6).getAttribute("value"))){
					new Actions(driver).moveToElement(dimensionList.get(6)).click().build().perform();
//					dimensionList.get(6).click();
					System.out.println("Done 6");
					if(applyToLeftRightAboveBelow.equalsIgnoreCase("left") || applyToLeftRightAboveBelow.equalsIgnoreCase("right")){
//						dimensionInputHorizontal.clear();
						dimensionInputHorizontal.sendKeys(newvalue);
					}else{
//						dimensionInputVerticle.clear();
						dimensionInputVerticle.sendKeys(newvalue);
					}
					if(applyToLeftRightAboveBelow.equalsIgnoreCase("above")){
						applyAboveButton.click();
					}else if(applyToLeftRightAboveBelow.equalsIgnoreCase("below")){
						applyBelowButton.click();
					}else if(applyToLeftRightAboveBelow.equalsIgnoreCase("left")){
						applyLeftButton.click();
					}else if(applyToLeftRightAboveBelow.equalsIgnoreCase("right")){
						applyRightbutton.click();
					}
					UtilHBM.reportOK("Dimension of wall changed from " + oldValue + " to " + newvalue);
				}else{
					UtilHBM.reportKO("Dimension value (to be changed) not found");
				}
//			}catch(Exception e){
//				
//			}
//		}		
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner verifyTwoDWallProperties(String dimension){
//		int a=0;
//		do{
//			moreProperties.click();
//			a++;
//		}while(UtilHBM.listOfWebElement(driver, ".more.dropdown.dropdown--more.is-collapse").size()==0 && a<4);
//		if(thickness.equalsIgnoreCase(thicknessInputBox.getAttribute("value")) && 
//				height.equalsIgnoreCase(heightInputBox.getAttribute("value"))){
//			UtilHBM.reportOK("Thickness & Height of wall verified successfully");
//		}else{
//			UtilHBM.reportKO("Thickness & Height of wall verification failed");
//		}
//		if(ceilingHtBox==1){			
//			if (sameAsCeilingHeightCheckbox.isSelected()){
//				UtilHBM.reportOK("'same as ceiling' check box selected(checked). Verification success");
//			}else{
//				UtilHBM.reportKO("'same as ceiling' check box is unchecked. Verification failed");
//			}			
//		}else{
//			if (!sameAsCeilingHeightCheckbox.isSelected()){
//				UtilHBM.reportOK("'same as ceiling' check box unchecked. Verification success");
//			}else{
//				UtilHBM.reportKO("'same as ceiling' check box is selected(checked). Verification failed");
//			}
//		}
		if(!dimension.isEmpty()){
			int b =0;
			int c = dimensionList.size();
			for (WebElement dim: dimensionList){
				if(dimension.equalsIgnoreCase(dim.getAttribute("value"))){
					UtilHBM.reportOK("Dimension value " + dim.getAttribute("value") + " verification success" );
				}else{
					b++;
				}
			}
			if (b==c){
				UtilHBM.reportKO("Dimension value verification failed for wall. Expected dimention value " + dimension + " is not available in displayed dimensions. The available wall dimensions are:" );
				for (WebElement dim: dimensionList){
					UtilHBM.reportKO(dim.getAttribute("value"));
				}
			}
		}
		return PageFactory.initElements(driver, ThreeDPlanner.class);		
	}		
}
