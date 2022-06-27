package hbm.planner.pageobject;

import hbm.planner.dataobject.NewProjectData;
import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewProject {
	
	private WebDriver driver;
	
	public NewProject(WebDriver driver){
		this.driver = driver;		
	}
	
	@FindBy(css=".modal-title[data-i18n='project.step1_title']")
	WebElement step1Title;
	
	@FindBy(css="span[data-i18n='project.step1_subtitle']")
	WebElement step1SubTitle;
	
	@FindBy(css="div.slider-css>div#step1>.videoWrapper.u-mbm>#iframe-tutorial[src*='https://www.youtube.com/embed']")
	WebElement step1Video;
	
	@CacheLookup
	@FindBy(id = "onboarding-projectName")
	WebElement projectNameTextBox;
	
	@CacheLookup
	@FindBy(css=".projectType-item")
	private List<WebElement> projectType;
	
	@CacheLookup
	@FindBy(css=".housingType-item")
	private List<WebElement> housingType;
	
	@CacheLookup
	@FindBy(id = "next")
	private WebElement nextButton;
	
	@CacheLookup
	@FindBy(id="starterRoom")
	private WebElement roomByRoom;
	
	@CacheLookup
	@FindBy(id="starterFromScratch")
	WebElement drawWalls;
	
	@CacheLookup
	@FindBy(css="#starterFloorPlan")
	WebElement importFloorPlan;
	
	@FindBy(css="#projectStarterTypeHelp>#step3-help-link")
	WebElement weDrawForYou;
	
	
	
//	@CacheLookup
//	@FindBy(id = "nextStep2")
//	WebElement nextStep2;
//	
//	@CacheLookup
//	@FindBy(id = "createProject")
//	WebElement nextStep3;
	
	@CacheLookup
	@FindBy(id= "createRoom")
	WebElement createRoomButton;
	
	@CacheLookup
	@FindBy(css = "a[class='close-modal button-close']")
	WebElement closeCreateRoom;
	
	@FindBy(id="withFloorPlan")
	WebElement yes2DPlan;
	
	@FindBy(id="withoutFloorPlan")
	WebElement no2DPlan;
	
	private NewProject verifyStep1(){
		UtilHBM.waitFixTime(2000);
		UtilHBM.waitExplicitDisplayed(driver, step1Video);
		if(!(step1SubTitle.isDisplayed() || 
				step1Title.isDisplayed() || 
				step1Video.isDisplayed())){
			UtilHBM.reportKO("Title / subtitle or video is not displayed for step 1 while creating project");
		}
		return this;
	}
	
	private NewProject enterProjectName(String projectName){
		projectNameTextBox.sendKeys(projectName);
		return this;		
	}
	
	private NewProject selectTypeOfProject (String typeOfProject){
		for(WebElement type:projectType){
			UtilHBM.waitExplicitDisplayed(driver, type.findElement(By.tagName("span")));
			if(type.getText().equalsIgnoreCase(typeOfProject)){
				type.click();
			}
		}
		return this;
	}
	
	private NewProject selectTypeOfHousing (String typeOfHousing){
		for(WebElement type:housingType){
			if(type.getText().equalsIgnoreCase(typeOfHousing)){
				type.click();
			}
		}
		return this;
	}
	
	private NewProject clickNext(){
		UtilHBM.waitExplicitClickable(driver, nextButton);
		UtilHBM.waitFixTime(500);
		nextButton.click();		
		UtilHBM.waitFixTime(500);
		return this;
	}
	
//	public NewProject clickNextStep2(){
//		nextStep2.click();
//		return this;
//	}
	
//	public NewProject clickNextStep3(){
//		nextStep3.click();
//		return this;	
//	}
	
	private NewProject clickNo2DPlan (){
		UtilHBM.waitExplicitClickable(driver, no2DPlan);
		no2DPlan.click();
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".projectStarterFloorPlanQuestion-item.is-selected"));
		Verification.displayOfWebElement(roomByRoom.findElement(By.cssSelector("img[src='assets/images/OnboardingRoom-illus.jpg']")));
		Verification.verifyText(roomByRoom.findElement(By.cssSelector("div>.projectStarter-label")), "Room by room (easiest)", "Room by room text");
		Verification.verifyText(roomByRoom.findElement(By.cssSelector("div>p")), "Add every room of your home, one after the other.", "Room by room legend");
		Verification.displayOfWebElement(drawWalls.findElement(By.cssSelector("img[src='assets/images/OnboardingDrawing-illus.jpg']")));
		Verification.verifyText(drawWalls.findElement(By.cssSelector("div>label")), "Draw walls", "Draw walls label");
		Verification.verifyText(drawWalls.findElement(By.cssSelector("div>p")), "Draw each wall of your floor plan.", "Draw Wall legend");		
		return this;
	}
	
	private NewProject clickYes2DPlan(){
		UtilHBM.waitExplicitClickable(driver, yes2DPlan);
		yes2DPlan.click();
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".projectStarterFloorPlanQuestion-item.is-selected"));
		Verification.displayOfWebElement(importFloorPlan.findElement(By.cssSelector("img[src='assets/images/OnboardingFloorplan-illus.jpg']")));
		Verification.verifyText(importFloorPlan.findElement(By.cssSelector("div>.projectStarter-label")), "Import your floor plan and draw over it", "Import floor plan label");
		Verification.verifyText(importFloorPlan.findElement(By.cssSelector("div>p")), "The image must be a .jpg or .png image. Click here to upload it.", "Import floor plan legend");
		Verification.displayOfWebElement(weDrawForYou.findElement(By.cssSelector("img[src='assets/images/OnboardingFloorplanServices-illus.jpg']")));
		Verification.verifyText(weDrawForYou.findElement(By.cssSelector("div>label")), "We draw for you", "We draw for you label");
		Verification.verifyText(weDrawForYou.findElement(By.cssSelector("div>p")), "Send us your floor plan and our team will convert it into a 3D HomeByMe project within 3 business days.", "We draw for you legend");
		Verification.verifyText(weDrawForYou.findElement(By.cssSelector("div.new-badge")), "Helping hand offer", "Helping hand offer label");
		return this;
	}
	
	private NewProject roomByRoom(){
		UtilHBM.waitExplicitClickable(driver, roomByRoom);		
		roomByRoom.click();
		return this;
	}
	
	public ThreeDPlanner importFloorPlan(String Floorplan){
		UtilHBM.waitExplicitClickable(driver, importFloorPlan);
//		new Actions(driver).moveToElement(iAlreadyHaveFloorPlan).sendKeys(new File(Setting.imgPath+Floorplan).getAbsolutePath()).build().perform();
		importFloorPlan.sendKeys(new File(Setting.imgPath+Floorplan).getAbsolutePath());
		EditFloorPlan fp = PageFactory.initElements(driver, EditFloorPlan.class);
		fp.validateEditPlan();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	private ThreeDPlanner iWantToBePrecise(String wallParameter){
		UtilHBM.waitExplicitClickable(driver, drawWalls);
		drawWalls.click();
		CreateWall wall = PageFactory.initElements(driver, CreateWall.class);
		wall.drawWallDev(wallParameter);
		UtilHBM.reportOK("Project Created from Scratch");
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner closeCreateRoomDialog(){
		closeCreateRoom.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner addRoomDetails(int roomNumber, String surfaceArea, String roomType){
		AddARoom room = PageFactory.initElements(driver, AddARoom.class);
		room.roomDetails(roomNumber, surfaceArea, roomType);
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner fillNewProjectDetials (NewProjectData newProjectData){
		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
		return verifyStep1().clickNext().enterProjectName(newProjectData.getProjectName()).selectTypeOfProject(newProjectData.getTypeOfProject())
		.selectTypeOfHousing(newProjectData.getTypeOfHousing()).clickNext().clickNo2DPlan().roomByRoom()
		.addRoomDetails(newProjectData.getRoomId(), newProjectData.getSurfaceArea(), newProjectData.getRoomType())
		.verifyProjectName(newProjectData.getProjectName());		
	}
	
	public ThreeDPlanner fillEmpltyProjectDetails(NewProjectData newProjectData){
		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
		return verifyStep1().clickNext().enterProjectName(newProjectData.getProjectName()).selectTypeOfProject(newProjectData.getTypeOfProject())
		.selectTypeOfHousing(newProjectData.getTypeOfHousing()).clickNext().clickNo2DPlan().roomByRoom().closeCreateRoomDialog();
	}
	
	public ThreeDPlanner fillEmpltyProjectDetailsDev(NewProjectData newProjectData){
//		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
		return verifyStep1().clickNext().enterProjectName(newProjectData.getProjectName()).selectTypeOfProject(newProjectData.getTypeOfProject())
		.selectTypeOfHousing(newProjectData.getTypeOfHousing()).clickNext().clickNo2DPlan().roomByRoom().closeCreateRoomDialog();
	}
	
	public ThreeDPlanner fillFPProjectDetails(NewProjectData newProjectData){
		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
		return verifyStep1().clickNext().enterProjectName(newProjectData.getProjectName()).selectTypeOfProject(newProjectData.getTypeOfProject())
		.selectTypeOfHousing(newProjectData.getTypeOfHousing()).clickNext().clickYes2DPlan().importFloorPlan(newProjectData.getFloorPlan());
	}
	
	public ThreeDPlanner fillProjectFromScratchDetails(NewProjectData newProjectData, String wallParameter){
		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
		return 	verifyStep1().clickNext().enterProjectName(newProjectData.getProjectName()).selectTypeOfProject(newProjectData.getTypeOfProject())
				.selectTypeOfHousing(newProjectData.getTypeOfHousing()).clickNext().clickNo2DPlan().iWantToBePrecise(wallParameter);
	}

}
