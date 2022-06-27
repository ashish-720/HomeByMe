package kitchen.threeDCloudByMe.pageObject;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;


public class ThreeDTools {
	WebDriver driver;

	public ThreeDTools(WebDriver driver) {
		this.driver=driver;	
	}
	
	public ThreeDTools verifyTitle(String title)
	{
		Set<String> allWindows = driver.getWindowHandles();
		for(String curWindow : allWindows){
		    driver.switchTo().window(curWindow);
		}
		if(driver.getTitle().equalsIgnoreCase("Editor - 3DCloudByMe"))
		{
			UtilHBM.reportOK("3d tools title verified");
		}
		else
		{
			UtilHBM.reportKO("3d tools title verification unsuccessful");
		}
		return PageFactory.initElements(driver, ThreeDTools.class);
	}
}
