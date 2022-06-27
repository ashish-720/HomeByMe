package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Measure {
	
	WebDriver driver;
	
	public Measure(WebDriver driver){
		this.driver=driver;
	}
	
	@CacheLookup
	@FindBy(id="measure_input")
	WebElement measureInput;
	
	@CacheLookup
	@FindBy(css=".button-close.button-close-background")
	WebElement closeMeasure;
	
	@CacheLookup
	@FindBy(xpath="//p[@class='overlaySnapshot-title'][.='Select two points to measure the corresponding distance.']")
	WebElement measureInstruction;
	
	@FindBy(css=".WallMeasure.Tag3D.visibility-visible.pointer-events-activated")
	WebElement measureDimValue;
	
//	@CacheLookup
//	@FindBy(xpath="//div[@class='overlaySnapshot-item']//span[.='cm']")
//	WebElement unitOfMeasure;
	
	private int noOfIteration=20;
	/*
	public ThreeDPlanner editMeasure(String img, int xPoint1, int yPoint1, int xPoint2, int yPoint2, String newValue){
		int i = 0;
		String measure = "0 cm";		
		String measure1="0 cm";
		while(measure.startsWith("0") && i<10){
			UtilHBM.hoverImgOffset(img, xPoint1, yPoint1);
			UtilHBM.waitFixTime(1500);
			UtilHBM.clickImgOffset(img, xPoint1, yPoint1);						
			UtilHBM.hoverImgOffset(img, xPoint2, yPoint2);
			UtilHBM.waitFixTime(1500);
			measure=measureInput.getAttribute("value");			
			if(!measure.startsWith("0")){				
				UtilHBM.clickImgOffset(img,xPoint2, yPoint2);				
				UtilHBM.hoverImgOffset(img, xPoint1, yPoint1);				
				measure1 = measureInput.getAttribute("value");
				int j=0;
				while(!(measure1.equalsIgnoreCase(measure)) && j<10){
					UtilHBM.clickImgOffset(img,xPoint2, yPoint2);				
					UtilHBM.hoverImgOffset(img, xPoint1, yPoint1);				
					measure1 = measureInput.getAttribute("value");					
					j++;
				}				
			}			
			i++;
		}				
		
		if(!measureInput.getAttribute("class").equalsIgnoreCase("input--disabled")){
//			measureInput.clear();
			measureInput.sendKeys(newValue + Keys.ENTER);
			String measureNew = measureInput.getAttribute("value");			
			if(measureNew.equalsIgnoreCase(newValue) && measureDimValue.getAttribute("value").equalsIgnoreCase(newValue)){
				UtilHBM.reportOK("Measure value changed from " + measure + "to" + newValue);				
			}else{
				UtilHBM.reportKO("Measure value not changed from " + measure + "to" + newValue + ". The new value is: " + measureNew);
			}			
		}else{
			UtilHBM.reportKO("The value of measure is not editable & is equal to: " + measure);
		}
		closeMeasure.click();		
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner checkMeasure(String img, int xPoint1, int yPoint1, int xPoint2, int yPoint2){
		int i = 0;
		String measure = "0 cm";		
		String measure1="0 cm";
		while(measure.startsWith("0") && i<10){
			UtilHBM.hoverImgOffset(img, xPoint1, yPoint1);
			UtilHBM.waitFixTime(1500);
			UtilHBM.clickImgOffset(img, xPoint1, yPoint1);						
			UtilHBM.hoverImgOffset(img, xPoint2, yPoint2);
			UtilHBM.waitFixTime(1500);
			measure=measureInput.getAttribute("value");			
			if(!measure.startsWith("0")){				
				UtilHBM.clickImgOffset(img,xPoint2, yPoint2);				
				UtilHBM.hoverImgOffset(img, xPoint1, yPoint1);				
				measure1 = measureInput.getAttribute("value");
				int j=0;
				while(!(measure1.equalsIgnoreCase(measure)) && j<10){
					UtilHBM.clickImgOffset(img,xPoint2, yPoint2);				
					UtilHBM.hoverImgOffset(img, xPoint1, yPoint1);				
					measure1 = measureInput.getAttribute("value");					
					j++;
				}				
			}			
			i++;
		}		
		UtilHBM.reportInfo("Measure Command info------------");
		Verification.displayOfWebElement(measureInstruction);
		UtilHBM.reportInfo("The value of measure is: " + measure);
		closeMeasure.click();
		UtilHBM.reportInfo("Measure Command Info Ends----------");
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner verifyMeasure(String img, int xPoint1, int yPoint1, int xPoint2, int yPoint2, String expectedDist){
		int i = 0;
		String measure = "0 cm";		
		String measure1="0 cm";
		while(measure.startsWith("0") && i<10){
			UtilHBM.hoverImgOffset(img, xPoint1, yPoint1);
			UtilHBM.waitFixTime(1500);
			UtilHBM.clickImgOffset(img, xPoint1, yPoint1);						
			UtilHBM.hoverImgOffset(img, xPoint2, yPoint2);
			UtilHBM.waitFixTime(1500);
			measure=measureInput.getAttribute("value");			
			if(!measure.startsWith("0")){				
				UtilHBM.clickImgOffset(img,xPoint2, yPoint2);				
				UtilHBM.hoverImgOffset(img, xPoint1, yPoint1);				
				measure1 = measureInput.getAttribute("value");
				int j=0;
				while(!(measure1.equalsIgnoreCase(measure)) && j<10){
					UtilHBM.clickImgOffset(img,xPoint2, yPoint2);				
					UtilHBM.hoverImgOffset(img, xPoint1, yPoint1);				
					measure1 = measureInput.getAttribute("value");					
					j++;
				}				
			}			
			i++;
		}
		UtilHBM.reportInfo("Measure Command info------------");
		
		if(measure1.split(" ")[1].matches("cm|ft")){
			UtilHBM.reportOK("Unit of measure is displayed & is " + measure1.split(" ")[1]);
		}else{
			UtilHBM.reportKO("Unit of measure is not displayed");
		}
//		verify.displayOfWebElement(driver, unitOfMeasure);
		Verification.displayOfWebElement(measureInstruction);
		if(measure1.equalsIgnoreCase(expectedDist) && measureDimValue.getAttribute("value").equalsIgnoreCase(measure1)){
			UtilHBM.reportOK("Measure distance matched expected value: " + measure1);
		}else{
			UtilHBM.reportKO("Measure distance does not matched expected value. Measured distance: " + measure1 + " & Expected distance: " + expectedDist);
		}
		closeMeasure.click();	
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	*/
//	---------------------------------------------------------------Dev---------------------
	
	public ThreeDPlanner editMeasureDev(int xPoint1, int yPoint1, int xPoint2, int yPoint2, String newValue){
		int i = 0;
		String measure = "0 cm";		
		String measure1="0 cm";
		while(measure.startsWith("0") && i<noOfIteration){
			ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
			planner.clickInPlanner(xPoint1, yPoint1).hoverInPlanner(xPoint2, yPoint2);			
			UtilHBM.waitFixTime(1500);
			measure=measureInput.getAttribute("value");			
			if(!measure.startsWith("0")){				
				planner.clickInPlanner(xPoint2, yPoint2).hoverInPlanner(xPoint1, yPoint1);				
				measure1 = measureInput.getAttribute("value");
				int j=0;
				while(!(measure1.equalsIgnoreCase(measure)) && j<noOfIteration){
					planner.clickInPlanner(xPoint2, yPoint2).hoverInPlanner(xPoint1, yPoint1);				
					measure1 = measureInput.getAttribute("value");					
					j++;
				}				
			}			
			i++;
		}				
		
		if(!measureInput.getAttribute("class").equalsIgnoreCase("input--disabled")){
//			measureInput.clear();
			measureInput.sendKeys(newValue + Keys.ENTER);
			String measureNew = measureInput.getAttribute("value");			
			if(measureNew.equalsIgnoreCase(newValue) && measureDimValue.getAttribute("value").equalsIgnoreCase(newValue)){
				UtilHBM.reportOK("Measure value changed from " + measure + "to" + newValue);				
			}else{
				UtilHBM.reportKO("Measure value not changed from " + measure + "to" + newValue + ". The new value is: " + measureNew);
			}			
		}else{
			UtilHBM.reportKO("The value of measure is not editable & is equal to: " + measure);
		}
		closeMeasure.click();		
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner checkMeasureDev(int xPoint1, int yPoint1, int xPoint2, int yPoint2){
		int i = 0;
		String measure = "0 cm";		
		String measure1="0 cm";
		while(measure.startsWith("0") && i<noOfIteration){
			ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
			planner.clickInPlanner(xPoint1, yPoint1).hoverInPlanner(xPoint2, yPoint2);			
			UtilHBM.waitFixTime(1500);
			measure=measureInput.getAttribute("value");			
			if(!measure.startsWith("0")){				
				planner.clickInPlanner(xPoint2, yPoint2).hoverInPlanner(xPoint1, yPoint1);			
				measure1 = measureInput.getAttribute("value");
				int j=0;
				while(!(measure1.equalsIgnoreCase(measure)) && j<noOfIteration){
					planner.clickInPlanner(xPoint2, yPoint2).hoverInPlanner(xPoint1, yPoint1);			
					measure1 = measureInput.getAttribute("value");					
					j++;
				}				
			}			
			i++;
		}		
		UtilHBM.reportInfo("Measure Command info------------");
		Verification.displayOfWebElement(measureInstruction);
		UtilHBM.reportInfo("The value of measure is: " + measure);
		closeMeasure.click();
		UtilHBM.reportInfo("Measure Command Info Ends----------");
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner verifyMeasureDev(int xPoint1, int yPoint1, int xPoint2, int yPoint2, String expectedDist){
		int i = 0;
		String measure = "0 cm";		
		String measure1="0 cm";
		while(measure.startsWith("0") && i<noOfIteration){
			ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
			planner.clickInPlanner(xPoint1, yPoint1).hoverInPlanner(xPoint2, yPoint2);			
			UtilHBM.waitFixTime(1500);
			measure=measureInput.getAttribute("value");			
			if(!measure.startsWith("0")){				
				planner.clickInPlanner(xPoint2, yPoint2).hoverInPlanner(xPoint1, yPoint1);					
				measure1 = measureInput.getAttribute("value");
				int j=0;
				while(!(measure1.equalsIgnoreCase(measure)) && j<noOfIteration){
					planner.clickInPlanner(xPoint2, yPoint2).hoverInPlanner(xPoint1, yPoint1);				
					measure1 = measureInput.getAttribute("value");					
					j++;
				}				
			}			
			i++;
		}
		UtilHBM.reportInfo("Measure Command info------------");
		
		if(measure1.split(" ")[1].matches("cm|ft")){
			UtilHBM.reportOK("Unit of measure is displayed & is " + measure1.split(" ")[1]);
		}else{
			UtilHBM.reportKO("Unit of measure is not displayed");
		}
//		verify.displayOfWebElement(driver, unitOfMeasure);
		Verification.displayOfWebElement(measureInstruction);
		if(measure1.equalsIgnoreCase(expectedDist) && measureDimValue.getAttribute("value").equalsIgnoreCase(measure1)){
			UtilHBM.reportOK("Measure distance matched expected value: " + measure1);
		}else{
			UtilHBM.reportKO("Measure distance does not matched expected value. Measured distance: " + measure1 + " & Expected distance: " + expectedDist);
		}
		closeMeasure.click();	
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
}
