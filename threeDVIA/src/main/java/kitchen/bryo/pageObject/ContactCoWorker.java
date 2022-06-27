package kitchen.bryo.pageObject;

import java.util.List;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactCoWorker {
	WebDriver driver;

	public ContactCoWorker(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//article[@class='mod-popin-alert-contact mod-open']/div/header/div/div/h3")
	private WebElement storeTitle;

	@FindBy(xpath = "//article[@class='mod-popin-alert-contact mod-open']/div/header/div/div/b")
	private WebElement storeInfo;

	@FindBy(xpath = "//article[@class='mod-popin-alert-contact mod-open']/div/header/div/div/button[@data-ui-action='popin-close']")
	private WebElement closeContact;

	ContactCoWorker checkContactPage() {
		driver.switchTo().parentFrame();
		Verification.VerifyEquals("Store title not displayed",
				storeTitle.getText(), "Store Name");
		
		UtilHBM.waitExplicitDisplayed(driver, storeInfo);
		UtilHBM.waitExplicitDisplayed(driver, closeContact);
		UtilHBM.waitExplicitClickable(driver, closeContact);
		closeContact.click();
		List<WebElement> frames = driver.findElements(By.cssSelector("#iframeContainer>iframe"));
		driver.switchTo().frame(frames.get(0));
		return PageFactory.initElements(driver, ContactCoWorker.class);
	}

}
