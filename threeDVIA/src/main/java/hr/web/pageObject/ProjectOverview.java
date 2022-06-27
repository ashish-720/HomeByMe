package hr.web.pageObject;

import java.util.List;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import hr.planner.pageObject.HomePlanner;
import hr.planner.pageObject.PopUpLayer1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectOverview {
	
	WebDriver driver;

		public ProjectOverview(WebDriver driver) {
			this.driver = driver;
		}
		
		@FindBy(css = "button[aria-controls='project-overview-tab-1']>span[class='text']")
		private WebElement projectOverview;
		
		@FindBy(css = "button[aria-controls='project-overview-tab-2']>span[class='text']")
		private WebElement priceDetail;
		
		@FindBy(css = "[aria-controls='project-overview-tab-2']>.counter")
		private WebElement allProductCount;
		
		@FindBy(css = ".bt-filter-tab>[data-i18n='project_overview.medias_title']")
		private WebElement myPicture;
		
		@FindBy(css = ".bt-filter-tab>[data-ui-id='medias-sum']")
		private WebElement myPictureCount;
		
		@FindBy(css = ".bt-prev-round")
		private WebElement previousSlide;
		
		@FindBy(css = ".bt-next-round")
		private WebElement nextSlide;
		
		@FindBy(css = ".project-actions>li>[title='Duplicate project']")
		private WebElement duplicateButton;
		
//		@FindBy(css = ".project-actions>li>[title='Delete project']")
//		private WebElement deleteButton;
		
		@FindBy(xpath = "//ul[@class='project-actions']/li/button[@data-ui-action='delete-project']")
		private WebElement deleteButton;
		
		@FindBy(css = ".project-actions>li>[title='Print project']")
		private WebElement printButton;
		
		@FindBy(css = ".project-actions>li>[data-ui-action='share-project']")
		private WebElement shareButton;
		
		@FindBy(css = ".project-planner-actions>.cta-primary-l")
		private WebElement openProjectbutton;
		
		@FindBy(css = ".project-title")
		private WebElement projectTitle;
		
		@FindBy(css = ".project-description>h2")
		private WebElement description;
		
		@FindBy(css = ".project-description>.mod-editable-content")
		private WebElement descriptionText;
		
		@FindBy(css = "button[aria-controls='project-products-tab-1']>.text")
		private WebElement globalButton;
		
		@FindBy(css = "button[aria-controls='project-products-tab-2']>.text")
		private WebElement roomByRoomButton;
		
		@FindBy(css = "[data-i18n='project_overview.view_all_products']")
		private WebElement viewAllButton;
		
		@FindBy(css = ".project-overview-section-header>h2[data-i18n='project_overview.property_feature']")
		private WebElement propertyFeaturesText;
		
		@FindBy(css = ".feature-title-wrapper>span>.icon-tags-surface>use")
		private WebElement propertyFeaturesSizeIcon;
		
		@FindBy(css = ".feature-title-wrapper>span>.icon-tags-floor>use")
		private WebElement propertyFeaturesFloorIcon;
		
		@FindBy(xpath = "//span[text()='Size']")
		private WebElement sizeText;
		
		//value will change according to project
		@FindBy(xpath = "//span[text()='10.00 m²']")
		private WebElement sizeValue;
		
		@FindBy(xpath = "//span[text()='Floors']")
		private WebElement floorsText;
		
		@FindBy(css = ".project-overview-section-header>h2[data-i18n='project_overview.medias_section']")
		private WebElement myPictures;

		@FindBy(css = ".editable-content-inner>[id='project-name-input']")
		private WebElement projectPageProjectName;
		
		@FindBy(xpath = "//button[@class='cta-primary-l']/span[text()='Yes']")
		private WebElement deleteYesbutton;
		
		@FindBy(xpath = "//button[@class='cta-secondary-l']/span[text()='No']")
		private WebElement deleteNobutton;
		
		@FindBy(xpath = "//div/p[text()='Do you really want to delete this project?']")
		private WebElement deleteProjectBoxText;
		
		@FindBy(xpath = "//nav/div/ul/li[@class='login overlay-user']/button")
		private WebElement myAccount;
		
		@FindBy(xpath = "//section/div/ul/li[@data-ui-action='open-projects']/button")
		private WebElement myProjects;
		
		public ProjectOverview projectOverview(){
			
			projectOverview.click();
			previousSlide.click();
			nextSlide.click();
			Verification.verifyText(projectOverview, "Project overview", "projectOverview");
			return PageFactory.initElements(driver, ProjectOverview.class);
		}
		
		public ProjectOverview nextSlideIcon(){
			
			nextSlide.click();
			return PageFactory.initElements(driver, ProjectOverview.class);
		}
		
		public ProjectOverview previousSlideIcon(){
			
			previousSlide.click();
			return PageFactory.initElements(driver, ProjectOverview.class);
		}

		public HomePlanner openProject(){
			
			openProjectbutton.click();
			UtilHBM.waitFixTime(1000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src*='https://preprod-home.enterprise-dev.by.me/Planner']"));
			UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".loader"));
			UtilHBM.waitTillElementDisappear(driver, ".loader");
			UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver, "//main[@role='main']/div/div/div/div/ul/li/button[@id='draw-plan']"));
			UtilHBM.waitFixTime(3000);
			return PageFactory.initElements(driver, HomePlanner.class);
		}
		
		public ProjectOverview duplicateProjectFromProjectPage(){			
			duplicateButton.click();
			UtilHBM.waitExplicitDisplayed(driver, "//div[@class='mod-loader']");
			driver.switchTo().defaultContent();
			driver.switchTo().frame(UtilHBM.webElementXPath(driver, "//iframe[@src='https://preprod-widgets.enterprise-dev.by.me/ProjectOverviewView/fullpage.html']"));
			UtilHBM.waitExplicitDisplayed(driver, projectOverview);
			return PageFactory.initElements(driver, ProjectOverview.class);
		}
		
		
		public ProjectOverview deleteProject(){
			
			deleteButton.click();
			//driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src*='https://preprod-widgets.enterprise-dev.by.me/MyProjectsView/embed.html']"));
			UtilHBM.waitFixTime(1000);
			return PageFactory.initElements(driver, ProjectOverview.class);
		}
		
		public LandingPageHR deleteYes(){			
			//UtilHBM.waitFixTime(1000);
			if(!deleteProjectBoxText.getText().equalsIgnoreCase("Do you really want to delete this project?")){
				UtilHBM.reportKO("Delete confirmation message is not displayed in confirmation dialog");
			}
			deleteYesbutton.click();			
			driver.switchTo().parentFrame();
			UtilHBM.waitExplicitDisplayed(driver, "//body[@class='homepage']");
			return PageFactory.initElements(driver, LandingPageHR.class);
		}
		
		public ProjectOverview deleteNo(){
			
			
			//UtilHBM.waitFixTime(1000);
			if(!deleteProjectBoxText.getText().equalsIgnoreCase("Do you really want to delete this project?")){
				UtilHBM.reportKO("Delete confirmation message is not displayed in confirmation dialog");
			}
			deleteNobutton.click();
			UtilHBM.waitFixTime(500);
			return PageFactory.initElements(driver, ProjectOverview.class);
		}
		
		public Print printProject(){
			
			printButton.click();
			UtilHBM.waitFixTime(1000);
//			driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src*='https://preprod-widgets.enterprise-dev.by.me/ProjectOverviewView/fullpage.html']"));
//			driver.switchTo().parentFrame();
			//driver.switchTo().frame(driver.findElement(By.cssSelector("#layer-iframe>iframe[src='https://preprod-widgets.enterprise-dev.by.me/Print/embed.html']")));
			
			//Verification.displayOfWebElement(UtilHBM.webElementXPath(driver, "//div[@class='text']/h2[text()='Print']"));
			return PageFactory.initElements(driver, Print.class);
		}
		
		public PopUpLayer1 shareProject(){
			
			shareButton.click();
//			driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src*='https://preprod-widgets.enterprise-dev.by.me/ProjectOverviewView/fullpage.html']"));
			
			return PageFactory.initElements(driver, PopUpLayer1.class);
		}
		
		public ProjectOverview global(){
			
			globalButton.click();
			return PageFactory.initElements(driver, ProjectOverview.class);
		}
		
		@FindBy(css = ".project-products-byroom-filters>button")
		List<WebElement> roomList;
		
		public ProjectOverview roomByRoom(int noOfroom){
			
			roomByRoomButton.click();
			driver.findElements(By.cssSelector(".project-products-byroom-filters>button")).size();

			UtilHBM.waitExplicitDisplayed(driver, roomList.get(0));
			int noOfRoomInList = roomList.size();
			if (noOfRoomInList == noOfroom) {
				UtilHBM.reportOK("No of rooms are same");
			} else {
				UtilHBM.reportKO("No of rooms are not same.  result of No. of rooms : "
						+ noOfRoomInList + " Expected No. Of room : " + noOfroom);
			}
			
			WebElement roomName = roomList.get(0); //findElement(By.cssSelector(".inner-container>img"));
			UtilHBM.waitExplicitDisplayed(driver, roomName);
			
			
			//UtilHBM.waitExplicitDisplayed(driver, element);
			return PageFactory.initElements(driver, ProjectOverview.class);
		}
		
		public PriceDetails viewAll(){
			
			roomByRoomButton.click();
			return PageFactory.initElements(driver, PriceDetails.class);
		}
		
		public ProjectOverview property(){
			
			Verification.displayNAttributeCheckOfElement(propertyFeaturesText, "Property features text", "text", "PROPERTY FEATURES");
			
			Verification.displayNAttributeCheckOfElement(sizeText, "Size text", "text", "Size");
			Verification.displayNAttributeCheckOfElement(propertyFeaturesSizeIcon, "Size icon", "xlink:href", "/Shared/icons/icons.svg#icon-tags-surface");
			//Verification.displayNAttributeCheckOfElement(sizeValue, "Room size value", "text", "10.00 m²");
			//room size is not fixed--- change it
			
			Verification.displayNAttributeCheckOfElement(floorsText, "Floor text", "text", "Floors");
			Verification.displayNAttributeCheckOfElement(propertyFeaturesFloorIcon, "Floor icon", "xlink:href", "/Shared/icons/icons.svg#icon-tags-floor");
			
			return PageFactory.initElements(driver, ProjectOverview.class);
		}
		
		
		
		public ProjectOverview verifyProjectPageName(String projectNameExpected) {
			
			UtilHBM.waitFixTime(1000);
			//UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "[aria-controls='project-overview-tab-1']"));
			Verification.VerifyEquals("Project Title KO", projectPageProjectName.getText(), projectNameExpected);
			return PageFactory.initElements(driver, ProjectOverview.class);
		}
		
		public ProjectOverview description(String descriptionInput){
			
			Verification.displayNAttributeCheckOfElement(description, "Description text", "text", "Description");
			Verification.displayNAttributeCheckOfElement(descriptionText, "Description Input text", "text", descriptionInput);
			
			return PageFactory.initElements(driver, ProjectOverview.class);
		}
		
		public PriceDetails priceDetails(String productCount){
			
			priceDetail.click();
			Verification.verifyText(allProductCount, productCount, "myPictureCount");
			UtilHBM.waitExplicitDisplayed(driver, allProductCount);
			String priceDetailTabProductCount = allProductCount.getText();
			if (priceDetailTabProductCount == productCount) {
				UtilHBM.reportOK("No of product in price detail tab are same");
			} else {
				UtilHBM.reportKO("No of product in price detail tab are not same. All product count : "
						+ priceDetailTabProductCount + " No Of product : " + productCount);
			}
			return PageFactory.initElements(driver, PriceDetails.class);
				
		}
		
		public MyPictureNTwoDPlan myPicture(String pictureCount){
			
			myPicture.click();
			Verification.verifyText(myPictureCount, pictureCount, "myPictureCount");
			UtilHBM.waitExplicitDisplayed(driver, myPictureCount);
			String myPictureTabCountOfImages = myPictureCount.getText();
			if (myPictureTabCountOfImages == pictureCount) {
				UtilHBM.reportOK("No of Images in My Pictures tab are same");
			} else {
				UtilHBM.reportKO("No of Images in My Pictures tab are not same. All realistic Images : "
						+ myPictureTabCountOfImages + " No Of realistic : " + pictureCount);
			}
			return PageFactory.initElements(driver, MyPictureNTwoDPlan.class);
				
		}
		
		
		public MyProject myProjectsPP() {
			
			UtilHBM.waitFixTime(1000);
			myAccount.click();
			myProjects.click();
			UtilHBM.waitFixTime(1000);
			driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src*='https://preprod-widgets.enterprise-dev.by.me/MyProjectsView/embed.html']"));
			UtilHBM.waitFixTime(1000);
			//verify
			return PageFactory.initElements(driver, MyProject.class);
		}
		
		
		
}
