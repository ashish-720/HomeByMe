package kitchen.bryo.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class WallPanelAndWorktopTypes {
	WebDriver driver;

	public WallPanelAndWorktopTypes(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(xpath = "//button[@data-ui-action='worktop-types-info']")
	private WebElement worktopTypeInfo;
	
	@FindBy(xpath = "//article[@class='mod-popin-alert-types mod-open']/div/header/div/div[@class='text']/h3")
	private WebElement worktopTypeTitle;
	
	@FindBy(xpath = "//article[@class='mod-popin-alert-types mod-open']/div/header/div/div[@class='text']/b")
	private WebElement worktopTypeMsg;
	
	@FindBy(xpath = "//article[@class='mod-popin-alert-types mod-open']/div/header/div/div/button[@data-ui-action='popin-close']")
	private WebElement closeButton;
	
		public WallPanelAndWorktopTypes worktopTypeInfo() {

		UtilHBM.waitFixTime(200);
		driver.switchTo().parentFrame();
//		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//article[@class='mod-popin-alert-types mod-open']/div/header/div/div[@class='text']/h3")));
		Verification.VerifyEquals("Worktop And Wall Panel type title not correct", worktopTypeTitle.getText(), "Wall Panel & Worktop types");
		Verification.VerifyEquals("Worktop And Wall Panel type title not correct", worktopTypeMsg.getText(), "The difference beetween precut and custom made products");
		closeButton.click();
		List<WebElement> frames = driver.findElements(By.cssSelector("#iframeContainer>iframe"));
		driver.switchTo().frame(frames.get(0));
		return this;
	}
}
