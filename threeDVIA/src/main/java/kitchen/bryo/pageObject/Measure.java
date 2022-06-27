package kitchen.bryo.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class Measure {

	WebDriver driver;

	public Measure(WebDriver driver) {
		this.driver = driver;
	}

//	@FindBy(xpath="//input[starts-with(@id,'measure')]")
//	WebElement measureInput;

	@FindBy(css = "span[id='measureWidthComputationSpan']")
	private WebElement measureInput;

	@FindBy(css = "button[data-ui-action='command-validate']")
	private WebElement closeMeasure;

	@FindBy(xpath = "//h3[@class='title']")
	private WebElement measureTitle;

	@FindBy(xpath = "//b[@data-i18n='kitchen.index.measure_desc;planner.index.measure_desc'][.='Click on two elements to get the distance between them.']")
	private WebElement measureInfo;


	@FindBy(css = ".WallMeasure.Tag3D.visibility-visible.pointer-events-activated")
	private WebElement measureDimValue;

	@FindBy(id = "bmSVG")
	private WebElement container3D;

//	public MakeItYours checkMeasure(int xPoint1, int yPoint1, int xPoint2, int yPoint2) {
//		int i = 0;
//		String measure = "0 cm";
//		String measure1 = "0 cm";
//		while (measure.startsWith("0") && i < 10) {
//			hoverMeasure(xPoint1, yPoint1);
//			UtilHBM.waitFixTime(1500);
//			clickMeasure(xPoint1, yPoint1);
//			hoverMeasure(xPoint2, yPoint2);
//			UtilHBM.waitFixTime(1500);
//			measure = measureInput.getText();
//			if (!measure.startsWith("0")) {
//				clickMeasure(xPoint2, yPoint2);
//				hoverMeasure(xPoint1, yPoint1);
//				measure1 = measureInput.getText();
//				int j = 0;
//				while (!(measure1.equalsIgnoreCase(measure)) && j < 10) {
//					clickMeasure(xPoint2, yPoint2);
//					hoverMeasure(xPoint1, yPoint1);
//					measure1 = measureInput.getText();
//					j++;
//				}
//			}
//			i++;
//		}
//		UtilHBM.reportInfo("Measure Command info------------");
//		Verification.displayOfWebElement(measureInstruction);
//		UtilHBM.reportInfo("The value of measure is: " + measure);
//		closeMeasure.click();
//		UtilHBM.reportInfo("Measure Command Info Ends----------");
//		return PageFactory.initElements(driver, MakeItYours.class);
//	}

	public MakeItYours checkMeasure(int xPoint1, int yPoint1, int xPoint2, int yPoint2,String expectedMeasure){
		UtilHBM.waitExplicitDisplayed(driver, measureTitle);
		String expectedTitle = "Measure";
		String expectedInfo = "Click on two elements to get the distance between them.";
		Verification.VerifyEquals("Measure  title not correct",
				measureTitle.getText().trim(), expectedTitle);
		Verification.VerifyEquals("Measure  info not correct",
				measureInfo.getText().trim(), expectedInfo);
		Actions action = new Actions(driver);
		action.moveToElement(container3D, 0, 0).build().perform();
		int i = 0;
		String measure = "0 mm";		
		String measure1="0 mm";
		while(measure.startsWith("0") && i<10){
			
			clickMeasure(xPoint1, yPoint1).hoverMeasure(xPoint2,yPoint2);		
			UtilHBM.waitFixTime(1500);
			measure=measureDimValue.getAttribute("value");			
			if(!measure.startsWith("0")){				
				clickMeasure(xPoint1, yPoint1).hoverMeasure(xPoint2,yPoint2);	
				measure1 = measureDimValue.getAttribute("value");
				int j=0;
				while(!(measure1.equalsIgnoreCase(measure)) && j<10){
					clickMeasure(xPoint1, yPoint1).hoverMeasure(xPoint2,yPoint2);		
					measure1 = measureDimValue.getAttribute("value");					
					j++;
				}				
			}			
			i++;
		}		
		if(measure1.split(" ")[1].matches("mm")){
			UtilHBM.reportOK("Unit of measure is displayed & is " + measure1.split(" ")[1]);
		}else{
			UtilHBM.reportKO("Unit of measure is not displayed");
		}
		if(measure1.equalsIgnoreCase(expectedMeasure) && measureDimValue.getAttribute("value").equalsIgnoreCase(measure1)){
			UtilHBM.reportOK("Measure distance matched expected value: " + measure1);
		}else{
			UtilHBM.reportKO("Measure distance does not matched expected value. Measured distance: " + measure1 + " & Expected distance: " + expectedMeasure);
		}
		UtilHBM.reportInfo("The value of measure is: " + measure);
		closeMeasure.click();
		return PageFactory.initElements(driver, MakeItYours.class);
	}
	
	public Measure clickMeasure(int xOffset, int yOffset) {
		int x = xOffset;
		int y = yOffset;
		Actions action = new Actions(driver);
		action.moveToElement(container3D, x, y).clickAndHold().pause(500).release().build().perform();
		return PageFactory.initElements(driver, Measure.class);
	}

	public Measure hoverMeasure(int xOffset, int yOffset) {
		int x = xOffset;
		int y = yOffset;
		Actions action = new Actions(driver);
		action.moveToElement(container3D, x, y).clickAndHold().pause(500).release().build().perform();
		return PageFactory.initElements(driver, Measure.class);
	}

}
