package hbm.web.pageobject;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hbm.planner.utility.UtilHBM;

public class IDSFormSelectRoom {
	WebDriver driver;
	public IDSFormSelectRoom(WebDriver driver) {
		 this.driver = driver;
	}

	@FindBy(id ="select_room_type")
	public WebElement selectRoomType;
	
	@FindBy(css ="#form-details>div>div>div>div>div>div>p>a")
	public WebElement nextButton;
	
	public IDSFormDetails iDSFormSelectRoom(String roomName) {
		Select select1=new Select(selectRoomType);
		UtilHBM.waitExplicitDisplayed(driver,selectRoomType);
		selectRoomType.click();
		List<WebElement> options=select1.getOptions();
		String temp =null;
		for(WebElement a:options) {
			if(a.getText().contains(roomName)) {
			temp=a.getText();
			break;
			}
		}
		UtilHBM.reportInfo("Selecting Room :"+temp);
		select1.selectByVisibleText(temp);
		nextButton.click();
		return PageFactory.initElements(driver,IDSFormDetails.class);
	}
	
}

