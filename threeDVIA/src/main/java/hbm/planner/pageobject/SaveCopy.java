package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaveCopy {
	
	WebDriver driver;
	
	public SaveCopy(WebDriver driver) {
		this.driver = driver;	
	}
	
	@FindBy(css="html>body#whole_container>#modal-cloneProject>div.modal-header>h2")
	private WebElement title;
		
	@FindBy(css="html>body#whole_container>#modal-cloneProject>div>div.modal-inner>div[data-i18n='project.cloneProjectContent']")
	private WebElement message;
		
	@FindBy(css="html>body#whole_container>#modal-cloneProject>div>div.modal-inner>form>div>#cloneProjectNameInput")
	private WebElement nameInputBox;
		
	@FindBy(css="html>body#whole_container>#modal-cloneProject>div>div.modal-footer>#cloneProjectBtn")
	private WebElement saveACopy;
	
	
	
	private String messageText="Save your own copy of this project so you can access all the features. Please, feel free to rename it if you like.";
	
	public ThreeDPlanner saveCopy(String projectName){			
		UtilHBM.waitExplicitDisplayed(driver, title);
		Verification.displayNAttributeCheckOfElement(title, "Title SaveCopy", "text", "Save your own copy");
		Verification.displayNAttributeCheckOfElement(message, "SaveCopy message", "text", messageText);
		nameInputBox.clear();
		nameInputBox.sendKeys(projectName);
//		nameInputBox.sendKeys("Trial"+ new SimpleDateFormat("MM-dd-yyyy")
//			.format(new GregorianCalendar().getTime()));
		clickSaveACopy();		
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}

	private ThreeDPlanner clickSaveACopy() {
		UtilHBM.waitExplicitClickable(driver, saveACopy);
		saveACopy.click();	
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
}
