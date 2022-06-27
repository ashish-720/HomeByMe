package hr.planner.pageObject;

import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Measure {

	WebDriver driver;

	public Measure(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id="bmSVG")
	private WebElement container3D;
	
	@FindBy(css = "[data-ui-action='command-validate']")
	private WebElement okMeasure;
	
	@FindBy(css = ".icon-action-zoom")
	private WebElement zoomInMeasure;
	
	@FindBy(css = ".icon-action-unzoom")
	private WebElement zoomOutMeasure;
	
	@FindBy(css = ".icon-view-2d")
	private WebElement twoDMeasure;
	
	@FindBy(css = ".icon-view-3d")
	private WebElement threeDMeasure;
	
	@FindBy(css = ".icon-view-fp")
	private WebElement firstPersonViewMeasure;
	
	@FindBy(css = ".icon-tools-options")
	private WebElement viewModeOptionsMeasure;
	
	@FindBy(css = "[data-ui-action='opening']")
	private WebElement cameraHeightMeasure;
	
	public Measure measureIn3D(int xPoint1, int yPoint1, int xPoint2, int yPoint2, String expectedDist){
		
		Measure measure = PageFactory.initElements(driver, Measure.class);
		measure.verifyMeasureDev(xPoint1, yPoint1, xPoint2, yPoint2, expectedDist);
		return PageFactory.initElements(driver, Measure.class);
	}
	
	private int noOfIteration=20;
	
	@CacheLookup
	@FindBy(css = "div>span[id*='measureWidthComputationSpan']+input")
	WebElement measureInput;
	
	@CacheLookup
	@FindBy(xpath="//p[@class='overlaySnapshot-title'][.='Select two points to measure the corresponding distance.']")
	WebElement measureInstruction;
	
	@FindBy(css=".WallMeasure.Tag3D.visibility-visible.pointer-events-activated")
	WebElement measureDimValue;
	
	public ThreeDPlanner verifyMeasureDev(int xPoint1, int yPoint1, int xPoint2, int yPoint2, String expectedDist){
		int i = 0;
		String measure = "0 cm";		
		String measure1="0 cm";
		while(measure.startsWith("0") && i<noOfIteration){
			HomePlanner planner = PageFactory.initElements(driver, HomePlanner.class);
			planner.clickInPlanner(xPoint1, yPoint1).hoverInPlanner(xPoint2, yPoint2);			
			UtilHBM.waitFixTime(1500);
			measure=measureInput.getAttribute("value");        //getAttribute("value");			
			if(!measure.startsWith("0")){				
				planner.clickInPlanner(xPoint2, yPoint2).hoverInPlanner(xPoint1, yPoint1);					
				measure1 = measureInput.getAttribute("value");      //getAttribute("value");
				int j=0;
				while(!(measure1.equalsIgnoreCase(measure)) && j<noOfIteration){
					planner.clickInPlanner(xPoint2, yPoint2).hoverInPlanner(xPoint1, yPoint1);				
					measure1 = measureInput.getAttribute("value");       //getAttribute("value");					
					j++;
				}				
			}			
			i++;
		}
		UtilHBM.reportInfo("Measure Command info------------");
		System.out.println("TEst" +measure1);
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
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public Measure editMeasureDev(int xPoint1, int yPoint1, int xPoint2, int yPoint2, String newValue){
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
		return PageFactory.initElements(driver, Measure.class);
	}
	
	
	public HomePlanner okMeasure(){
		
		okMeasure.click();
		//cameraHeightMeasure.click();
		
		return PageFactory.initElements(driver, HomePlanner.class);
	}
	
	public Measure firstPerson(){
		
		firstPersonViewMeasure.click();
		//cameraHeightMeasure.click();
		
		return PageFactory.initElements(driver, Measure.class);
	}
	
	public Measure twoD(){
		
		twoDMeasure.click();
		return PageFactory.initElements(driver, Measure.class);
	}
	
	public Measure threeD(){
		
		threeDMeasure.click();
		return PageFactory.initElements(driver, Measure.class);
	}
	
	public Measure zoomIn(int noOfSteps){
		UtilHBM.waitExplicitDisplayed(driver, zoomInMeasure);
		for(int i=0; i<noOfSteps; i++){
			zoomInMeasure.click();
			UtilHBM.waitFixTime(1000);
		}
		return PageFactory.initElements(driver, Measure.class);
	}
	
	public Measure zoomOut(int noOfSteps){
		UtilHBM.waitExplicitDisplayed(driver, zoomOutMeasure);
		for(int i=0; i<noOfSteps; i++){
			zoomOutMeasure.click();
			UtilHBM.waitFixTime(1000);
		}
		return PageFactory.initElements(driver, Measure.class);
	}
}
