package hbm.web.pageobject;

import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Baner {
	
	WebDriver driver;
	
	public Baner(WebDriver driver) {
		this.driver=driver;				
	}
	
//	@FindBy(css="body>div>div>div>div>div>div>div>img[src$='home.by.me/dist/images/banners/acquisition/illustration_project.60836763bf464a49a101a2b884803d81.png'")
//	@FindBy(css="body>div>div>div>div>div>div>div>img[src$='https://d31ax5swi3lxrl.cloudfront.net/dist/images/banners/acquisition/illustration_project.db632a96c4d149e01436.png']")
//	private WebElement banerImg;
	
	@FindBy(css="body>div>div>div>div>div>div>div.banner-img>img")
	private WebElement banerImg;
	
	@FindBy(css="body>div>div>div>div>div>div>div>div>.textM.title.u-mbn")
	private WebElement banerTitle;
	
	@FindBy(css="body>div>div>div>div>div>div>div>div>.description.u-man.u-mb0")
	private WebElement banerDescription;
	
	@FindBy(css="body>div>div>div>div>div>div>div>div>div>p>a[href='#signup']")
	private WebElement banerSignUpButton;
	
	@FindBy(css="body>div>div>div>div>div>div>div>div>div>.close-banner.close")
	private WebElement banerNotNowThanksLink;
	
	private String banerTitleText = "Want to create your own 3D project?";
	private String banerDescritionText= "Access to all our features and share your work with the community, it's free!";
		
	public ThreeDPlanner verifyBannerContents(){
		
		UtilHBM.waitFixTime(2000);
		driver.switchTo().parentFrame();
//		driver.switchTo().frame(driver.findElement(By.cssSelector("#planner-iframe")));
		UtilHBM.waitExplicitDisplayed(driver, banerImg);
		Verification.displayNAttributeCheckOfElement(banerImg, "bannerImg", "src", "https://d31ax5swi3lxrl.cloudfront.net/dist/images/banners/acquisition/illustration_project.db632a96c4d149e01436.png");
		if(!(banerImg.isDisplayed() || banerTitle.getText().equalsIgnoreCase(banerTitleText)
				|| banerDescription.getText().equalsIgnoreCase(banerDescritionText)
				|| banerSignUpButton.isDisplayed() || banerNotNowThanksLink.isDisplayed())){
			UtilHBM.reportKO("Something is missing/ not displayed in baner of trial project in planner");
		}
		banerNotNowThanksLink.click();		
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner bannerSignUp(){
		
		UtilHBM.waitFixTime(2000);
		driver.switchTo().parentFrame();
//		driver.switchTo().frame(driver.findElement(By.cssSelector("#planner-iframe")));
		UtilHBM.waitExplicitDisplayed(driver, banerImg);
		Verification.displayNAttributeCheckOfElement(banerImg, "bannerImg", "src", "https://d31ax5swi3lxrl.cloudfront.net/dist/images/banners/acquisition/illustration_project.db632a96c4d149e01436.png");
		if(!(banerImg.isDisplayed() || banerTitle.getText().equalsIgnoreCase(banerTitleText)
				|| banerDescription.getText().equalsIgnoreCase(banerDescritionText)
				|| banerSignUpButton.isDisplayed() || banerNotNowThanksLink.isDisplayed())){
			UtilHBM.reportKO("Something is missing/ not displayed in baner of trial project in planner");
		}
		banerSignUpButton.click();		
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner verifyEmbeddedProjectPopin() {
		UtilHBM.waitFixTime(2000);
		driver.switchTo().parentFrame();
		UtilHBM.waitExplicitDisplayed(driver, banerImg);
		Verification.displayNAttributeCheckOfElement(banerImg, "bannerImg", "src", "https://d31ax5swi3lxrl.cloudfront.net/dist/images/banners/acquisition/illustration_project.db632a96c4d149e01436.png");
		if (!(banerImg.isDisplayed() || banerTitle.getText().equalsIgnoreCase(banerTitleText)
				|| banerDescription.getText().equalsIgnoreCase(banerDescritionText) || banerSignUpButton.isDisplayed()
				|| banerNotNowThanksLink.isDisplayed())) {
			UtilHBM.reportKO("Something is missing/ not displayed in baner of trial project in planner");
		}
		banerNotNowThanksLink.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	

}
