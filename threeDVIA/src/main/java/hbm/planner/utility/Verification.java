package hbm.planner.utility;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Verification {
	
	private StringBuffer verificationErrors;
	static WebDriver driver;
	public Verification(WebDriver driver) {
		Verification.driver=driver;
		verificationErrors = new StringBuffer();
	}
	
	public static void VerifyEquals(String errorMsg, String actualText, String expectedText){		
			if(actualText.equalsIgnoreCase(expectedText)){
				UtilHBM.reportOK("Verification Success for " + actualText);	
			}else{
				UtilHBM.reportKO(errorMsg + " Expected value: " + expectedText + ", Actual value: " + actualText);
			}		
	}

	public static void VerifyNotEquals(String errorMsg, String actualText, String expectedTextNotToBeEqTo){
		if(!actualText.equalsIgnoreCase(expectedTextNotToBeEqTo)){
			UtilHBM.reportOK("Verification Success for text not to be equal to : " + actualText);
		}else{
			UtilHBM.reportKO(errorMsg + " Expected value not to be equal to: " + expectedTextNotToBeEqTo + ", Actual value: " + actualText);
		}
	}
	
	public static void verifyText (WebElement element, String textToBeVarified, String webElementName){
		if(element.isDisplayed() && element.getText().trim().replaceAll("\n\r", "").replace("'", "\\'").equals(textToBeVarified)){
			UtilHBM.reportOK("Text verified on page for WebElement: " + webElementName);
		}else{
			UtilHBM.reportKO("Text varification failed for css path: " + webElementName);
			UtilHBM.reportKO("Expected text: " + textToBeVarified + ", actual text: " + element.getText());
		}
	}

	public void displayOfElementByCSS(WebDriver driver, String cssPath){
		if(UtilHBM.webElement(driver, cssPath).isDisplayed()){
			UtilHBM.reportOK("Webelement: " + UtilHBM.webElement(driver, cssPath) +"is displayed.");
		}else{
			UtilHBM.reportKO("Webelement: " + UtilHBM.webElement(driver, cssPath) +"is not displayed.");
		}		
	}	
	
	public static void displayOfWebElement( WebElement element){
		try {
			if(element.isDisplayed()){
				UtilHBM.reportOK("Webelement: " + element.toString().split(":")[2] +"is displayed");
			}else{
				UtilHBM.reportKO("Webelement: " + element.toString() +"is not displayed. the test is failed: ");
			}
		}catch (Exception e){			
			UtilHBM.reportKO("Webelement: " + element.toString() +"is not available in DOM. the test is failed");
		}		
	}
	
	public static void selectedWebElement(WebDriver driver, WebElement element){		
			if(element.isSelected()){
				UtilHBM.reportOK("Webelement: " + element.toString().split(":")[2] +"is selected. the text is: " + element.getText());
			}else{
				UtilHBM.reportKO("Webelement: " + element.toString().split(":")[2] +"is not selected. the test is failed: ");
			}			
	}
	
	public static void enabledWebElement(WebDriver driver, WebElement element){
		try {
			if(element.isEnabled()){
				UtilHBM.reportOK("Webelement: " + element.toString().split(":")[2] +"is enabled. the text is: " + element.getText());
			}
		}catch (Exception e){			
			UtilHBM.reportKO("Webelement: " + element.toString().split(":")[2] +"is not enabled. the test is failed: ");
		}		
	}
	
	public static void disabledWebElement(WebElement element){
		try {
			if(!(element.isEnabled())){
				UtilHBM.reportOK("Webelement: " + element.toString().split(":")[2] +"is disabled. the text is: " + element.getText());
			}
		}catch (Exception e){			
			UtilHBM.reportKO("Webelement: " + element.toString().split(":")[2] +"is not disabled. the test is failed: ");
		}		
	}
	
	  public static void isWebElementVisible(WebElement element) {
		  if(element.isDisplayed()){
			  	Dimension weD = element.getSize();
			    Point weP = element.getLocation();
			    Dimension d = driver.manage().window().getSize();

			    int x = d.getWidth();
			    int y = d.getHeight();
			    int x2 = weD.getWidth() + weP.getX();
			    int y2 = weD.getHeight() + weP.getY();

			    if(x2 <= x && y2 <= y){
			    	UtilHBM.reportOK(element+ ":" + element.getText() + " is displayed on screen");
			    }else{
			    	System.out.println("coordinates are: (" + weP +","+ x +","+ y + "), ("+ x2+","+ y2 +")" + "Element Location:" + weP);
			    	UtilHBM.reportKO(element+":"+ element.getText() + " is not displayed on screen");
			    }
		  }else{
			  UtilHBM.reportKO(element+":"+ element.getText() + " is not loaded in the webpage");
		  }
		   
	}
	  
	  public static void displayNAttributeCheckOfElement(WebElement element, String elementName, String attribute, String attributeValue){
		  if(attribute.equalsIgnoreCase("text")){
//			  if(element.isDisplayed() && element.getText().replaceAll("\\r?\\n", " ").equalsIgnoreCase(attributeValue)){
			  if(element.isDisplayed() && element.getText().equalsIgnoreCase(attributeValue)){
				  UtilHBM.reportOK(elementName + " is displayed & the value is correct");
			  }else{
				  System.out.println("Value from get text is: " + element.getText());
				  System.out.println("Value from variable is: " + attributeValue);
				  UtilHBM.reportKO(elementName + " is either not displayed or the value is not correct. The expected value is " + attributeValue + ". The available value is: " + element.getText() );				  
			  }
		  }else{
			  if(element.isDisplayed() && element.getAttribute(attribute).equalsIgnoreCase(attributeValue)){
				  UtilHBM.reportOK(elementName + " is displayed & the value is correct");
			  }else{
				  UtilHBM.reportKO(elementName + " is either not displayed or the value is not correct. The expected value is " + attributeValue + ". The available value is: " + element.getAttribute(attribute));				  
			  }
		  }		  
	  }
	  
	  public static void displayNAttributeCheckOfElementExcludeLineBreak(WebElement element, String elementName, String attribute, String attributeValue){
		  if(attribute.equalsIgnoreCase("text")){
			  if(element.isDisplayed() && element.getText().replaceAll("\\r?\\n", " ").equalsIgnoreCase(attributeValue)){
//			  if(element.isDisplayed() && element.getText().equalsIgnoreCase(attributeValue)){
				  UtilHBM.reportOK(elementName + " is displayed & the value is correct");
			  }else{
				  System.out.println("Value from get text is: " + element.getText());
				  System.out.println("Value from variable is: " + attributeValue);
				  UtilHBM.reportKO(elementName + " is either not displayed or the value is not correct. The value is: " + element.getText() );				  
			  }
		  }else{
			  if(element.isDisplayed() && element.getAttribute(attribute).equalsIgnoreCase(attributeValue)){
				  UtilHBM.reportOK(elementName + " is displayed & the value is correct");
			  }else{
				  UtilHBM.reportKO(elementName + " is either not displayed or the value is not correct. The expected value: " + attributeValue +"The value is: " + element.getAttribute(attribute) );				  
			  }
		  }		  
	  }
	  
	  public static void elementContainsString(WebElement element, String stringToCheck, String elementName){
		  if(element.getText().contains(stringToCheck)){
			  UtilHBM.reportOK(elementName + "verification success");
		  }else{
			  UtilHBM.reportKO(elementName + "verification failed." + "Expected Value: " + stringToCheck + "Actual value: " + element.getText());
		  }		  
	  }
	
	public void clearVerificationErrors(){
		verificationErrors = new StringBuffer();
	}	
	
	public void checkForVerificationErrors(){
		String verificationErrorString = verificationErrors.toString();
		clearVerificationErrors();
		if (!"".equals(verificationErrorString)){
			throw new AssertionError(verificationErrorString);		
		}		
	}
		

}
