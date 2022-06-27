package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class ObjectProperties {
	WebDriver driver;
	
	public ObjectProperties(WebDriver driver){
		this.driver = driver;
	}
	
//	Screen s = new Screen();
	
	@CacheLookup
	@FindBy(css = ".more-button.dropdown-link")
	WebElement moreProperties;
	
	@CacheLookup
	@FindBy(id = "color-category")
	WebElement colorCatagoryDropdown;
	
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
	@FindBy(id="width")
	WebElement widthInputBox;
	
	@CacheLookup
	@FindBy(id="length")
	WebElement lengthInputBox;
	
	@CacheLookup
	@FindBy(id="depth")
	WebElement depthInputBox;
	
	@CacheLookup
	@FindBy(id="height-from-floor")
	WebElement heightFromFloor;
	
	@CacheLookup
	@FindBy(id="type")
	WebElement roomTypeDropdownProperties;
	
	@FindBy(css=".colorPicker-grid-item>img")
	List<WebElement> colorList;
	
	@FindBy(id="name")
	WebElement roomName;
	
	@FindBy(id="color-current")
	WebElement currentMatrialOnWallOrFloor;
	
	@CacheLookup
	@FindBy(css=".icon.icon-wall-side.panel-icon")
	WebElement changeWallSideButton;
	
	@CacheLookup
	@FindBy(css=".icon.icon-opening-side.panel-icon")
	WebElement openingSideButton;
	
	@CacheLookup
	@FindBy(css="a[data-i18n='catalog.go_store']")
	WebElement visitStore;	
	
	public ThreeDPlanner floorProperties(String roomType, String colorCatagory, int colorID){
//		try {
//			System.out.println("roomProperties started");			
//			int xCo = s.find(UtilHBM.createPattern(img)).getCenter().x;
//			int yCo = s.find(UtilHBM.createPattern(img)).getCenter().y;			
//			Location loc = new Location(xCo, yCo);							
//			loc.click();
//			loc.click();
//		} catch (Exception e) {
//			Reporter.log("room properties edition failed");
//			System.out.println("Problem in editing room property");
//			e.printStackTrace();
//		}				

//		roomTypeDropdownProperties.sendKeys(roomType);
		if(!roomType.isEmpty()){
			new Select(roomTypeDropdownProperties).selectByVisibleText(roomType);
		}
		if(!colorCatagory.isEmpty()){
			int a=0;
			do{
				moreProperties.click();
				a++;
			}while(UtilHBM.listOfWebElement(driver, ".more.dropdown.dropdown--more.is-collapse").size()==0 && a<4);
			UtilHBM.waitExplicitClickable(driver, colorList.get(colorList.size()-1));
			new Select(colorCatagoryDropdown).selectByVisibleText(colorCatagory);
			UtilHBM.waitFixTime(4000);		
			driver.findElement(By.cssSelector("a[data-id='" + Integer.toString(colorID) + "']>img")).click();
			moreProperties.click();
		}			
		UtilHBM.reportOK("Floor properties edited successfilly");
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner verifyFloorProperties(String roomType, String colorCatagory, int colorID){
		String color = currentMatrialOnWallOrFloor.getAttribute("src");								
			int a=0;
			do{
				moreProperties.click();
				a++;
			}while(UtilHBM.listOfWebElement(driver, ".more.dropdown.dropdown--more.is-collapse").size()==0 && a<4);
			UtilHBM.waitExplicitClickable(driver, colorList.get(colorList.size()-1));
			new Select(colorCatagoryDropdown).selectByVisibleText(colorCatagory);
			UtilHBM.waitFixTime(4000);		
			String color1 =driver.findElement(By.cssSelector("a[data-id='" + Integer.toString(colorID) + "']>img")).getAttribute("src");
			moreProperties.click();	
			if(roomName.getAttribute("value").equalsIgnoreCase(roomType) &&
					color.equalsIgnoreCase(color1)){
				UtilHBM.reportOK("Floor properties (room name & material of floor) verification success");				
			}else{
				UtilHBM.reportKO("Floor properties (room name &/ or material of floor) verification failed");
			}			
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}	
	/*
	public ThreeDPlanner twoDWallProperties(String img, int xOffset, int yOffset, String thickness, String height){
		try {			
			int x = s.find(UtilHBM.createPattern(img)).getCenter().x + xOffset;
			int y = s.find(UtilHBM.createPattern(img)).getCenter().y + yOffset;			
			Location loc = new Location(x, y);
			loc.hover();
			loc.click();
			loc.click();
		} catch (FindFailed e) {
			System.out.println("Could not find image in twoDWallProperties");
			e.printStackTrace();
		}
			thicknessInputBox.clear();
			thicknessInputBox.sendKeys(thickness);
			int a=0;
			do{
				moreProperties.click();
				a++;
			}while(UtilHBM.listOfWebElement(driver, ".more.dropdown.dropdown--more.is-collapse").size()==0 && a<4);		
			if (sameAsCeilingHeightCheckbox.isSelected()){
				sameAsCeilingHeightCheckbox.click();
			}
			heightInputBox.clear();
			heightInputBox.sendKeys(height);			
		return PageFactory.initElements(driver, ThreeDPlanner.class);		
	}
	*/
	public ThreeDPlanner threeDWallProperties (String dropdownCatagory, String colorPickerNumber, String colorId){
		int a=0;
		do{
			moreProperties.click();
			a++;
		}while(UtilHBM.listOfWebElement(driver, ".more.dropdown.dropdown--more.is-collapse").size()==0 && a<4);
			new Select(colorCatagoryDropdown).selectByVisibleText(dropdownCatagory);
			UtilHBM.waitFixTime(4000);
			if (dropdownCatagory.contains("paint")){
				driver.findElement(By.cssSelector(".colorPicker-item[data-id = '" + colorPickerNumber + "']")).click();	
			}			
			driver.findElement(By.cssSelector("a[data-id='" + colorId + "']>img")).click();
			moreProperties.click();
			Reporter.log("Wall properties edited successfilly");		
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner verifyThreeDWallProperties (String dropdownCatagory, String colorPickerNumber, String colorId){
		String color = currentMatrialOnWallOrFloor.getAttribute("src");	
		int a=0;
		do{
			moreProperties.click();
			a++;
		}while(UtilHBM.listOfWebElement(driver, ".more.dropdown.dropdown--more.is-collapse").size()==0 && a<4);
			new Select(colorCatagoryDropdown).selectByVisibleText(dropdownCatagory);
			UtilHBM.waitFixTime(4000);
			if (dropdownCatagory.contains("paint")){
				driver.findElement(By.cssSelector(".colorPicker-item[data-id = '" + colorPickerNumber + "']")).click();	
			}			
			String color1 =driver.findElement(By.cssSelector("a[data-id='" + colorId + "']>img")).getAttribute("src");
			moreProperties.click();
			if(color.equalsIgnoreCase(color1)){
				UtilHBM.reportOK("Wall color varification success");
			}else{
				UtilHBM.reportKO("Wall color varification failed");
			}
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	/*
	public ThreeDPlanner doorWinProperties(String img, String ht, String wth, String htFromFloor, int chgWalSd, int openingSd){
//		try {
//			s.find(UtilHBM.createPattern(img)).click();
//		} catch (FindFailed e) {			
//			e.printStackTrace();
//		}
//		try{
		int a=0;
		do{
			moreProperties.click();
			a++;
		}while(UtilHBM.listOfWebElement(driver, ".more.dropdown.dropdown--more.is-collapse").size()==0 && a<4);
//		}catch(Exception e){
//			try {
//				UtilHBM.clickBlankSpace();
//				s.find(UtilHBM.createPattern(img)).click();
//			} catch (FindFailed e1) {			
//				e.printStackTrace();
//			}
//		}
		
		if(!(ht.isEmpty())){
			heightInputBox.clear();
			heightInputBox.sendKeys(ht);
		}
		if(!(wth.isEmpty())){
			widthInputBox.clear();
			widthInputBox.sendKeys(wth);
		}
		if(!(htFromFloor.isEmpty())){
			heightFromFloor.clear();
			heightFromFloor.sendKeys(htFromFloor);
		}		
		if(!(chgWalSd==0)){
			changeWallSideButton.click();			
		}
		if(!(openingSd==0)){
			openingSideButton.click();
		}
//		if(Integer.parseInt(heightInputBox.getAttribute("value"))==ht && Integer.parseInt(widthInputBox.getAttribute("value"))==wth && Integer.parseInt(heightFromFloor.getAttribute("value"))==htFromFloor){
//			Reporter.log("<font color = 'green'> Door/Window properties modified correctly <br>");
//		}else {
//			Reporter.log("<front color = 'red'> problem in door/window properties modification <br>");
//		}
		UtilHBM.reportInfo("Object properties changed");
		UtilHBM.clickBlankSpace();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	*/
	
	public void verifyDoorWinProperties(String img, String ht, String wth, String htFromFloor){
//		try {
//			s.find(UtilHBM.createPattern(img)).click();
//		} catch (FindFailed e) {			
//			e.printStackTrace();
//		}
		moreProperties.click();
		if((ht.equalsIgnoreCase(heightInputBox.getAttribute("value"))) && 
				(wth.equalsIgnoreCase(widthInputBox.getAttribute("value"))) && 
				(htFromFloor.equalsIgnoreCase(heightFromFloor.getAttribute("value")))){
			UtilHBM.reportOK("Door/Window properties verified successfully");
		}else{
			UtilHBM.reportKO("Door/Window properties verification failed<br>height=" +heightInputBox.getAttribute("value")+ "<br> width=" + widthInputBox.getAttribute("value")+ "<br>ht from floor=" + heightInputBox.getAttribute("value"));
			
		}
	}
	
	public void genericProperties(String ht, String wth, String lnth, String dpth, String materialType, int materialId){
		System.out.println(UtilHBM.webElement(driver, ".toolBar-group-infos-right").getText());
		if(UtilHBM.webElement(driver, ".toolBar-group-infos-right").getText().contains("more")){
			int a=0;
			do{
				moreProperties.click();
				a++;
			}while(UtilHBM.listOfWebElement(driver, ".more.dropdown.dropdown--more.is-collapse").size()==0 && a<4);
		}
		if(!(ht.isEmpty())){
			heightInputBox.clear();
			heightInputBox.sendKeys(ht);
		}
		if(!(wth.isEmpty())){
			widthInputBox.clear();
			widthInputBox.sendKeys(wth);
		}
		if(!(lnth.isEmpty())){
			lengthInputBox.clear();
			lengthInputBox.sendKeys(lnth);
		}
		if(!(dpth.isEmpty())){
			depthInputBox.clear();
			depthInputBox.sendKeys(dpth);
		}
		if (!(materialId==0)){
			int i = UtilHBM.listOfWebElement(driver, ".listItems-link").size()-1;
			for(int x=0; x<=i; x++){
				UtilHBM.listOfWebElement(driver, ".listItems-link").get(x).click();
				new Select(UtilHBM.webElement(driver, ".select--full")).selectByVisibleText(materialType);
				String thumbnail = UtilHBM.webElement(driver, "a[data-id='" + materialId +"']>img").getAttribute("src");
				System.out.println(thumbnail);
				UtilHBM.webElement(driver, "a[data-id='" + materialId +"']").click();
				do{
					UtilHBM.webElement(driver, ".panelMore-back>span").click();
				}while(UtilHBM.listOfWebElement(driver, ".listItems-link").size()==0);
				System.out.println(UtilHBM.listOfWebElement(driver, ".listItems-link").get(x).findElement(By.cssSelector("div")).getAttribute("style"));
				if(UtilHBM.listOfWebElement(driver, ".listItems-link").get(x).findElement(By.cssSelector("div")).getAttribute("style").contains(thumbnail)){
					UtilHBM.reportOK("Material property: " + UtilHBM.listOfWebElement(driver, ".listItems-link").get(x).findElement(By.cssSelector("span")).getText() + " changed & new material data id is:" + UtilHBM.listOfWebElement(driver, ".listItems-link").get(x).findElement(By.cssSelector("div")).getAttribute("id").split("-")[2]);
				}
			}
		}		
	}
		
	public void verifyGenericProperties(String ht, String wth, String lnth, String dpth, int materialId){
		if(UtilHBM.webElement(driver, ".toolBar-group-infos-right").getText().contains("more")){
			int a=0;
			do{
				moreProperties.click();
				a++;
			}while(UtilHBM.listOfWebElement(driver, ".more.dropdown.dropdown--more.is-collapse").size()==0 && a<4);			
		}
		if(ht.isEmpty() && wth.isEmpty() && lnth.isEmpty() && dpth.isEmpty()){
			UtilHBM.reportInfo("Only Material property is available for verification");
		}else if(!(ht.isEmpty() || wth.isEmpty() || lnth.isEmpty() || dpth.isEmpty())){
			if((ht.equalsIgnoreCase(heightInputBox.getAttribute("value")))&&(wth.equalsIgnoreCase(widthInputBox.getAttribute("value")))&& (lnth.equalsIgnoreCase(lengthInputBox.getAttribute("value")))&&(dpth.equalsIgnoreCase(depthInputBox.getAttribute("value")))){
				UtilHBM.reportOK("Properties verified successfully");
			}else{				
				UtilHBM.reportKO("Properties verification failed");
			}			
		}else if(ht.isEmpty()){
			if(wth.isEmpty() || lnth.isEmpty() || dpth.isEmpty()){
				if(wth.isEmpty()){
					if(lnth.isEmpty() || dpth.isEmpty()){
						if(lnth.isEmpty()){
							if(dpth.equalsIgnoreCase(depthInputBox.getAttribute("value"))){
								UtilHBM.reportOK("Properties verified successfully. Only Depth property is available");
							}else{
								UtilHBM.reportKO("Properties verification failed. Only Depth property is available");
							}
						}else{
							if(lnth.equalsIgnoreCase(lengthInputBox.getAttribute("value"))){
								UtilHBM.reportOK("Properties verified successfully. Only Length property is available");
							}else{
								UtilHBM.reportKO("Properties verification failed. Only Length property is available");
							}
						}
					}else{
						if(lnth.equalsIgnoreCase(lengthInputBox.getAttribute("value")) && dpth.equalsIgnoreCase(depthInputBox.getAttribute("value"))){
							UtilHBM.reportOK("Properties verified successfully. Only Length & Depth property is available");							
						}else{
							UtilHBM.reportKO("Properties verification failed. Only Length & Depth property is available");
						}
					}					
				}else if(lnth.isEmpty()){
					if(dpth.isEmpty()){
						if(wth.equalsIgnoreCase(widthInputBox.getAttribute("value"))){
							UtilHBM.reportOK("Properties verified successfully. Only Width property is available");
						}else{
							UtilHBM.reportKO("Properties verification failed. Only Width property is available");
						}
					}else{
						if(wth.equalsIgnoreCase(widthInputBox.getAttribute("value")) && dpth.equalsIgnoreCase(depthInputBox.getAttribute("value"))){
							UtilHBM.reportOK("Properties verified successfully. Only Width & Depth property is available");
						}else{
							UtilHBM.reportKO("Properties verification failed. Only Width & Depth  property is available");
						}
					}
				}else if(dpth.isEmpty()){
					if(wth.equalsIgnoreCase(widthInputBox.getAttribute("value")) && lnth.equalsIgnoreCase(lengthInputBox.getAttribute("value"))){
						UtilHBM.reportOK("Properties verified successfully. Only Width & Length property is available");
					}else{
						UtilHBM.reportKO("Properties verification failed. Only Width & Length property is available");
					}
				}				
			}else{
				if((wth.equalsIgnoreCase(widthInputBox.getAttribute("value")))&& (lnth.equalsIgnoreCase(lengthInputBox.getAttribute("value")))&&(dpth.equalsIgnoreCase(depthInputBox.getAttribute("value")))){
					UtilHBM.reportOK("Properties verified successfully. Height property not available for this furniture");
				}else{
					
					UtilHBM.reportKO("Properties verification failed");
				}
			}
		}else if(wth.isEmpty()){
			if(lnth.isEmpty() || dpth.isEmpty()){
				if(lnth.isEmpty()){
					if(ht.equalsIgnoreCase(heightInputBox.getAttribute("value")) && dpth.equalsIgnoreCase(depthInputBox.getAttribute("value"))){
						UtilHBM.reportOK("Properties verified successfully. Only Height & Depth property is available");
					}else{
						UtilHBM.reportKO("Properties verification failed. Only Height & Depth property is available");
					}
				}else{
					if(ht.equalsIgnoreCase(heightInputBox.getAttribute("value")) && lnth.equalsIgnoreCase(lengthInputBox.getAttribute("value"))){
						UtilHBM.reportOK("Properties verified successfully. Only Height & Length property is available");
					}else{
						UtilHBM.reportKO("Properties verification failed. Only Height & Length property is available");
					}
				}
			}else{
				if((ht.equalsIgnoreCase(heightInputBox.getAttribute("value")))&&(lnth.equalsIgnoreCase(lengthInputBox.getAttribute("value")))&&(dpth.equalsIgnoreCase(depthInputBox.getAttribute("value")))){
					UtilHBM.reportOK("Properties verified successfully. Width property not available for this furniture");
				}else{				
					UtilHBM.reportKO("Properties verification failed");
				}
			}			
		}else if(lnth.isEmpty()){
			if (dpth.isEmpty()){
				if((ht.equalsIgnoreCase(heightInputBox.getAttribute("value")))&&(wth.equalsIgnoreCase(widthInputBox.getAttribute("value")))){
					UtilHBM.reportOK("Properties verified successfully. Length & Depth property not available for this furniture");
				}else{				
					UtilHBM.reportKO("Properties verification failed");
				}			
			}else{
				if((ht.equalsIgnoreCase(heightInputBox.getAttribute("value")))&&(wth.equalsIgnoreCase(widthInputBox.getAttribute("value")))&&(dpth.equalsIgnoreCase(depthInputBox.getAttribute("value")))){
					UtilHBM.reportOK("Properties verified successfully. Length property not available for this furniture");
				}else{
					UtilHBM.reportKO("Properties verification failed");
				}
			}								
		}else if (dpth.isEmpty()){
			if((ht.equalsIgnoreCase(heightInputBox.getAttribute("value")))&&(wth.equalsIgnoreCase(widthInputBox.getAttribute("value")))&& (lnth.equalsIgnoreCase(lengthInputBox.getAttribute("value")))){
				UtilHBM.reportOK("Properties verified successfully. Depth property not available for this furniture");
			}else{				
				UtilHBM.reportKO("Properties verification failed");
			}			
		}
		if(!(materialId==0)){
			for (WebElement material:UtilHBM.listOfWebElement(driver, ".listItems-link")){
				if(Integer.parseInt(material.findElement(By.cssSelector("div")).getAttribute("id").split("-")[2])==materialId){
					UtilHBM.reportOK(material.getText() + " :Matrial verified for this property");
				}else{
					UtilHBM.reportKO(material.getText() + " :Matrial verificationj failed for this property");
				}
			}
		}		
	}	
}
