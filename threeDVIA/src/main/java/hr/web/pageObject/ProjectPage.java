package hr.web.pageObject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import hr.planner.pageObject.HomePlanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage {
	
	WebDriver driver;

		public ProjectPage(WebDriver driver) {
			this.driver = driver;
		}
		
		@FindBy(css = "button[aria-controls='project-overview-tab-1']>span[class='text']")
		private WebElement projectOverview;
		
		@FindBy(css = "button[aria-controls='project-overview-tab-2']>span[class='text']")
		private WebElement priceDetail;
		
		@FindBy(css = "button[aria-controls='project-overview-tab-3']>span[class='text']")
		private WebElement myPictureAnd2sPlan;
		
		@FindBy(css = ".bt-prev-round")
		private WebElement previousSlide;
		
		@FindBy(css = ".bt-next-round")
		private WebElement nextSlide;
		
		@FindBy(css = ".bt-icon>.icon-action-duplicate")
		private WebElement duplicateButton;
		
		@FindBy(css = ".bt-icon>.icon-action-delete")
		private WebElement deleteButton;
		
		@FindBy(css = ".bt-icon>.icon-action-print")
		private WebElement printButton;
		
		@FindBy(css = ".project-planner-actions>.cta-primary-l")
		private WebElement openProjectbutton;
		
		@FindBy(css = ".project-title")
		private WebElement projectTitle;
		
		@FindBy(css = ".project-description")
		private WebElement description;
		
		@FindBy(css = ".project-description>.mod-editable-content")
		private WebElement descriptionText;
		
		@FindBy(css = "button[aria-controls='project-products-tab-1']>.text")
		private WebElement globalButton;
		
		@FindBy(css = "button[aria-controls='project-products-tab-2']>.text")
		private WebElement roomByRoomButton;
		
		@FindBy(css = ".project-overview-section-header>h2[data-i18n='project_overview.property_feature']")
		private WebElement propertyFeaturesText;
		
		@FindBy(css = ".project-features")
		private WebElement propertyFeatures;
		
		@FindBy(css = ".project-overview-section-header>h2[data-i18n='project_overview.medias_section']")
		private WebElement myPictures;
		
		@FindBy(xpath = "//div/textarea[@name='project-name-input']")
		private WebElement projectPageProjectName;
		
		
		public ProjectPage projectOverview(){
			
			projectOverview.click();
			previousSlide.click();
			nextSlide.click();
			
			Verification.verifyText(projectTitle, "project name", "projectTitle");
			
			return PageFactory.initElements(driver, ProjectPage.class);
		}
		
		public HomePlanner openProject(){
			
			openProjectbutton.click();
			return PageFactory.initElements(driver, HomePlanner.class);
		}
		
		public ProjectPage global(){
			
			globalButton.click();
			return PageFactory.initElements(driver, ProjectPage.class);
		}
		
		public ProjectPage roomByRoom(){
			
			roomByRoomButton.click();
			return PageFactory.initElements(driver, ProjectPage.class);
		}
		
		public ProjectPage verifyProjectPageName(String projectNameExpected) {
			
			UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver, "//button[@aria-controls='project-overview-tab-1']/span[text()='Project overview']"));
			Verification.VerifyEquals("Project Title KO", projectPageProjectName.getText(), projectNameExpected);
			return PageFactory.initElements(driver, ProjectPage.class);
		}
		
		
		
		
		
		
		
}
