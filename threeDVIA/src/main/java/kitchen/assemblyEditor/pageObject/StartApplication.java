package kitchen.assemblyEditor.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;

public class StartApplication {
	WebDriver driver;
	
	public StartApplication(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css="#welcome-page>main>div>div>footer>#open-button")
	WebElement okButton;
	
	@FindBy(css="#welcome-page")
	WebElement welcomePage;
	
	@FindBy(css="#spinner")
	List<WebElement> processingSpinner;
	
	public AssemblyEditor startApp()
	{		
		UtilHBM.waitExplicitDisplayed(driver, welcomePage);
		okButton.click();
		UtilHBM.turnOffImplicitWaits(driver);
		if(processingSpinner.size()>0)
		{
			UtilHBM.waitTillElementDisappear(driver, "#spinner");
		}
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("#embedded-app-frame")));
		driver.switchTo().frame(driver.findElement(By.cssSelector("#embedded-app-frame")));
		UtilHBM.waitExplicitDisplayed(driver, "//li[@id='component-section']/ul/li/button");
		return PageFactory.initElements(driver, AssemblyEditor.class);
	}
	
	
}
