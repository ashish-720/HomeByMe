package hbm.web.pageobject;

import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.UtilHBM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrialProjectPopin {
	
	WebDriver driver;
	
	public TrialProjectPopin(WebDriver driver) {
		this.driver=driver;	
	}
	
	@CacheLookup
	@FindBy(css="body>div>div>div>.modal-title")
	private WebElement title;
	
	@CacheLookup
	@FindBy(css="body>div>div>div>article>div>div>iframe[src='https://www.youtube.com/embed/2LWDDm6i8MY?rel=0&controls=0&showinfo=0&loop=1']")
	private WebElement video;
	
	@CacheLookup
	@FindBy(css="body>div>div>div>article>div>div>iframe[src='https://www.youtube.com/embed/yfcttVQl4nA?rel=0&controls=0&showinfo=0&loop=1']")
	private WebElement videoHBMFor;
	
	@CacheLookup
	@FindBy(css="body>div>div>div>article>div>div>div>p")
	private WebElement message;
	
	@CacheLookup
	@FindBy(css="body>div>div>div>article>div>div>div>h3")
	private WebElement messageHBMFor;
	
	@CacheLookup
	@FindBy(css="body>div>div>div>article>div>div>div>a[title='Create account']")
	private WebElement createAccount;
	
	@CacheLookup
	@FindBy(css="div>div>a[rel='modal:close']")
	private WebElement tryNow;
	
	@CacheLookup
	@FindBy(css="body>div>.close-modal.button-close")
	private WebElement close;
	
	private String titleText = "DISCOVER THE LATEST CHANGES TO HOMEBYME";
	private String messageText="Because we constantly want to improve your home design experience, we made a few changes to Homebyme. Discover the latest ones in the video.";
	private String titleTextHBMFor = "EXPLORE THIS PROJECT WITH HOMEBYME";
	private String messageTextHBMFor="Create your new living space in 3D with HomeByMe";
			
	public ThreeDPlanner clickTryNow(){
		UtilHBM.waitExplicitClickable(driver, video);
		if(!(title.getText().equalsIgnoreCase(titleText) || message.getText().equalsIgnoreCase(messageText))){
			UtilHBM.reportKO("Text in try now popin is not correct");			
		}
		if(!(title.isDisplayed() || message.isDisplayed() || video.isDisplayed() 
				|| createAccount.isDisplayed() || tryNow.isDisplayed() || close.isDisplayed())){
			UtilHBM.reportKO("Some elements in try now popin not displayed");			
		}
		tryNow.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	
	public ThreeDPlanner clickTryNowMDF(){
		UtilHBM.waitExplicitClickable(driver, videoHBMFor);
		if(!(title.getText().equalsIgnoreCase(titleTextHBMFor) || messageHBMFor.getText().equalsIgnoreCase(messageTextHBMFor))){
			UtilHBM.reportKO("Text in try now popin is not correct");			
		}
		if(!(title.isDisplayed() || messageHBMFor.isDisplayed() || videoHBMFor.isDisplayed() 
				|| createAccount.isDisplayed() || tryNow.isDisplayed() || close.isDisplayed())){
			UtilHBM.reportKO("Some elements in try now popin not displayed");			
		}
		tryNow.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	
	
	
	

}
