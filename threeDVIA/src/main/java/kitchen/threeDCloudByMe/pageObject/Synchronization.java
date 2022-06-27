package kitchen.threeDCloudByMe.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class Synchronization {
	WebDriver driver;

	public Synchronization(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css="#dashboard-sync-button")
	WebElement askForSyncButton;
	
	@FindBy(css="div.success>div")
	WebElement successMsg;
	
	public Synchronization askForSync()
	{
		askForSyncButton.click();
		UtilHBM.waitExplicitDisplayed(driver, successMsg);
		driver.navigate().refresh();
		verifyStatus();
		return PageFactory.initElements(driver, Synchronization.class);
	}
	
	@FindBy(css="tbody>tr>td:nth-child(3)")
	List<WebElement> statusList;
	
	Synchronization verifyStatus()
	{
		for(int i=0;i<4;i++)
		{
			UtilHBM.waitExplicitDisplayed(driver, statusList.get(i));
			Verification.VerifyEquals("Status not updated", statusList.get(i).getText(), "To do");
		}
		return PageFactory.initElements(driver, Synchronization.class);
	}
	
}
