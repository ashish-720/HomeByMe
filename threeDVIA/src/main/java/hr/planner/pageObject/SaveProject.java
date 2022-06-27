package hr.planner.pageObject;

import hbm.planner.utility.UtilHBM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SaveProject {
	
	WebDriver driver;

	public SaveProject(WebDriver driver) {
		this.driver = driver;
	}
	
	
		@FindBy(xpath = "//div/form/div/fieldset/p/input")
		private WebElement projectName;
		

		@FindBy(xpath = "//div/form/div/fieldset/p/textarea")
		private WebElement projectDescription;
		
		@FindBy(xpath = "//form/footer/button[@class='cta-secondary-xl']/span")
		private WebElement cancelButton;
		
		@FindBy(xpath = "//form/footer/button[@class='cta-primary-alt-xl']/span")
		private WebElement saveButton;
		
		public HomePlanner saveProject(String projectName, String projectDescription) {
			projectName(projectName);
			projectDescription(projectDescription);
			SaveButton();			
			return PageFactory.initElements(driver, HomePlanner.class);
			}
			
		private SaveProject projectName(String prjName) {
			projectName.clear();
			projectName.click();
			projectName.sendKeys(prjName);
			UtilHBM.waitFixTime(500);
			return PageFactory.initElements(driver, SaveProject.class);
		}
		
		private SaveProject projectDescription(String projectDesc) {

			projectDescription.click();
			projectDescription.sendKeys(projectDesc);
			UtilHBM.waitFixTime(500);
			return PageFactory.initElements(driver, SaveProject.class);
		}
		
//		private HomePlanner cancelButton() {
//
//			cancelButton.click();
//			
//			return PageFactory.initElements(driver, HomePlanner.class);
//		}
		
		private HomePlanner SaveButton() {

			saveButton.click();
			
			return PageFactory.initElements(driver, HomePlanner.class);
		}
		
}
