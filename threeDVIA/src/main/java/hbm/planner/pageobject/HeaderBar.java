package hbm.planner.pageobject;

import hbm.web.pageobject.LandingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderBar {
	
	WebDriver driver;
	
	public HeaderBar(WebDriver driver) {
	this.driver = driver;
	}
	
	@CacheLookup
	@FindBy(css = "#userItem-logout")
	WebElement logoutPlanner;
	
	public LandingPage logoutPlannerApp(){	
		logoutPlanner.click();
		return PageFactory.initElements(driver, LandingPage.class);
	}
}
