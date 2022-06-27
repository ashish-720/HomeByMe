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

public class ProjectDetails {
	
	WebDriver driver;
	
	public ProjectDetails(WebDriver driver){
		this.driver = driver;
	}
	
	@CacheLookup
	@FindBy(css = ".modal-header")
	private WebElement dialogHeader;
	
	@CacheLookup
	@FindBy(css=".close-modal.button-close")
	WebElement closeProjectDetails;
	
	@CacheLookup
	@FindBy(css="#projectdetails-name")
	WebElement projectName;
	
	@CacheLookup
	@FindBy(xpath="//label[.='Project details']")
	WebElement labelProjectName;
	
	@CacheLookup
	@FindBy(xpath="//p[.='Your project']")
	WebElement labelYourProject;
	
	@CacheLookup
	@FindBy(xpath="//span[.='Type of housing']")
	WebElement labelTypeOfHousing;
	
	@CacheLookup
	@FindBy(id = "housingType")
	WebElement typeOfHousing;	
	
	@CacheLookup
	@FindBy(xpath="//span[.='Type of project']")
	WebElement labelTypeOfProject;
	
	@CacheLookup
	@FindBy(id="projectType")
	WebElement typeOfProject;
	
	@CacheLookup
	@FindBy(css="#project-infos>.form-item>span")
	List<WebElement> yourProjectList;	
	
	@FindBy(css="#modal-projectDetails>div>form>div>div>.form-item>div>#dropdown-surfaces")
	WebElement areasMenu;
	
	@FindBy(css="#modal-projectDetails>div>form>div>div>.form-item>#project-surfaces")
	WebElement projectSurfaceDetails;	
	
	@CacheLookup
	@FindBy(css="#projectDetailsTable>tbody tr")
	List<WebElement> roomDetailList;
	
	@CacheLookup
	@FindBy(id="projectdetails-button-ok")
	WebElement okButton;
	
	@FindBy(id="dropdown-project-infos")
	private WebElement infoMenu;
	
	@FindBy(id="dropdown-project-surfaces")
	private WebElement areaMenu;
	
	public ThreeDPlanner changeProjectDetails(String prjName, String typeOfHouse, String typeOfPrj){		
		if(infoMenu.getAttribute("class").contains("is-collapse")){
			infoMenu.findElement(By.tagName("a")).click();
		}
		UtilHBM.waitExplicitDisplayed(driver, projectName);
		if(areaMenu.getAttribute("class").contains("is-collapse")){
			areaMenu.findElement(By.tagName("a")).click();
		}		
		projectName.clear();
		projectName.sendKeys(prjName);
		new Select(typeOfHousing).selectByVisibleText(typeOfHouse);
		new Select(typeOfProject).selectByVisibleText(typeOfPrj);
		okButton.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner verifyProjectDetails(String prjName, String typeOfHouse, String typeOfPrj, int noOfFloor, int noOfRooms, double totalArea){
		if(infoMenu.getAttribute("class").contains("is-collapse")){
			infoMenu.findElement(By.tagName("a")).click();
		}
		UtilHBM.waitExplicitDisplayed(driver, projectName);
		if(areaMenu.getAttribute("class").contains("is-collapse")){
			areaMenu.findElement(By.tagName("a")).click();
		}	
		double projArea = Double.parseDouble(yourProjectList.get(9).getText().split(" ")[0]);		
		int projFloors = Integer.parseInt(yourProjectList.get(3).getText().split(" ")[0]);
		int projRooms = Integer.parseInt(yourProjectList.get(6).getText().split(" ")[0]);
		String houseType = new Select(typeOfHousing).getFirstSelectedOption().getText();
		String projectType = new Select(typeOfProject).getFirstSelectedOption().getText();
		double areaSum=0;		
		if(projectName.getAttribute("value").equalsIgnoreCase(prjName) && 
				projFloors==noOfFloor && projRooms == noOfRooms && projArea==totalArea &&
				houseType.equalsIgnoreCase(typeOfHouse) &&
				projectType.equalsIgnoreCase(typeOfPrj)){
			UtilHBM.reportOK("Project name, floors, rooms, area, type of housing & type of project verified successfully");
		}else{
			UtilHBM.reportKO(" Either of Project name,floors, rooms, area, type of housing & type of project verification failed");
			UtilHBM.reportKO("Project Name (Actual Vs Expected): " + projectName.getAttribute("value") + " Vs " + prjName);
			UtilHBM.reportKO("Project floor (Actual Vs Expected): " + projFloors + " Vs "+ noOfFloor);
			UtilHBM.reportKO("Project rooms (Actual Vs Expected): " + projRooms + " Vs "+ noOfRooms);
			UtilHBM.reportKO("Project area (Actual Vs Expected): " + projArea + " Vs "+ totalArea);
			UtilHBM.reportKO("Project type of housing (Actual Vs Expected): " + houseType + " Vs "+ typeOfHouse);
			UtilHBM.reportKO("Project type of project (Actual Vs Expected): " + projectType + " Vs "+ typeOfPrj);
		}
		if(projectSurfaceDetails.getAttribute("style").equalsIgnoreCase("display: none;")){
			areasMenu.click();
		}		
		for(WebElement room:roomDetailList){			
			double area = Double.parseDouble(room.findElements(By.tagName("span")).get(0).getText().split(" ")[0]);
			areaSum = areaSum+area;					
		}
		if (areaSum+0.1>=projArea && projArea>=areaSum-0.1){
			UtilHBM.reportOK("sum of area of all rooms is equal to total area in project details");
		}else{
			UtilHBM.reportKO("sum of area of all rooms is not equal to total area in project details");
			UtilHBM.reportKO("Area (Sum Vs  in project details: )" + areaSum + " Vs " + projArea);
		}		
		okButton.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	

}
