package hbm.web.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.UtilHBM;

public class HBMFor {
	WebDriver driver;
	
	public HBMFor(WebDriver driver) {
		 this.driver=driver;
	}	

	@CacheLookup
	@FindBy(css = "[title='Log in']")
	WebElement login;
	
	@FindBy(css=".grid>.grid-1-3:nth-child(1)>div>div>a")
	WebElement firstProject;
	
	@FindBy(css="article.table>div a[title='Create your project']")
	WebElement trialProject;

	@FindBy(css="div.cell>a[href='/en/partner/maisonsdumonde/my-projects']")
	WebElement myProjects;
	
	public CompleteProfile signUpMDM(SignUpData signUpData) {
		login.click();	
		Login login = PageFactory.initElements(driver, Login.class);
		login.signUpFromLogin(signUpData);
		return PageFactory.initElements(driver, CompleteProfile.class);
	}
	
	
	public ThreeDPlanner seeThisProject(){
		new Actions(driver).moveToElement(firstProject).build().perform();
		WebElement seeThisProject = firstProject.findElement(By.cssSelector(".button.media-anim-button"));
		UtilHBM.waitExplicitDisplayed(driver, seeThisProject);
		seeThisProject.click();		
		driver.switchTo().frame(UtilHBM.webElement(driver, "#planner-embed-iframe"));
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".head-title"));
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner createTrialProject(){	
		UtilHBM.waitExplicitDisplayed(driver, trialProject);
		trialProject.click();		
		driver.switchTo().frame(UtilHBM.webElement(driver, "#planner-embed-iframe"));
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".head-title"));		
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public MyProjects goToMyProjects() {
		UtilHBM.waitExplicitDisplayed(driver, myProjects);
		myProjects.click();
		return PageFactory.initElements(driver, MyProjects.class);
	}

	

}
