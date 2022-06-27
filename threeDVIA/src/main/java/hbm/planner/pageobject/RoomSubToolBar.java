package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomSubToolBar {
	
	WebDriver driver;
	
	public RoomSubToolBar(WebDriver driver) {
		 this.driver = driver;
	}
	
	@CacheLookup
	@FindBy(id = "wall-button")
	WebElement wallButton;
	
	@CacheLookup
	@FindBy(xpath="//div[.='Room']")
	WebElement addARoomButton;
	
	@CacheLookup
	@FindBy(id="roomSeparator-button")
	WebElement roomSeparatorButton;
	
	public ThreeDPlanner addARoom(){
		UtilHBM.waitExplicitClickable(driver, addARoomButton);
		addARoomButton.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner wall(){
		UtilHBM.waitExplicitClickable(driver, wallButton);
		wallButton.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public ThreeDPlanner roomSeparator(){
		UtilHBM.waitExplicitClickable(driver, roomSeparatorButton);
		roomSeparatorButton.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}

}
