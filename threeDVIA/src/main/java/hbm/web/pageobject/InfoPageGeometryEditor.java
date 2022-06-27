package hbm.web.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class InfoPageGeometryEditor {
	
	WebDriver driver;

	public InfoPageGeometryEditor(WebDriver driver) {
		this.driver = driver;
	}
	

	@FindBy(css = "section.mod-sublayer-media.mod-open>header>h4.tt")
	WebElement infoText1;
	
	@FindBy(css = "section.mod-sublayer-media.mod-open>div>p")
	WebElement infoText2;
	
	@FindBy(css = "section.mod-sublayer-media.mod-open>div>img")
	WebElement infoImg;
	
	@FindBy(xpath ="//section[@class='mod-sublayer-media mod-open']/footer/button[text()='Cancel']")
	WebElement cancelButton;
	
	@FindBy(xpath = "//section[@class='mod-sublayer-media mod-open']/footer/button[text()='Get started']")
	WebElement getStartedButton;

	@FindBy(css = "section.mod-sublayer-media.mod-open>div.footnote>label>span.label")
	WebElement doNotShowAgainText;
	
	@FindBy(css = "section.mod-sublayer-media.mod-open>div.footnote>label>span:nth-child(2)")
	WebElement doNotShowAgainLabel;	
	
	@FindBy(xpath = "//html/body/div[1]/div/div/span[@class='spinner']")
	List<WebElement> loader;
	

	
	public InfoPageGeometryEditor verifyPage() {
		UtilHBM.waitExplicitDisplayed(driver, infoImg);
		Verification.VerifyEquals("Wrong infoText1", infoText1.getText(),
				"Customize your project with the 3D import of your furniture");
		Verification.VerifyEquals("Wrong infoText2", infoText2.getText(),
				"Import and edit your furniture and your most beautiful 3D creations to go further in the personalisation of your project.");
		Verification.VerifyEquals("Wrong doNotShowAgainText", doNotShowAgainText.getText(), "Don't show me again");
		Verification.displayOfWebElement(infoImg);
		Verification.displayOfWebElement(getStartedButton);
		Verification.displayOfWebElement(cancelButton);
		return this;
	}
	
	public Upload3dModel clickGetStartedPlanner() {
		UtilHBM.waitExplicitDisplayed(driver, getStartedButton);
		UtilHBM.waitExplicitClickable(driver, getStartedButton);
		getStartedButton.click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src*='https://preprod-3deditor.by.me/Editor/?unit=metrics&ln=en']")));
		UtilHBM.waitFixTime(2000);
		int i;
		boolean temp = false;
		for (i = 0; i < 10; i++) {
			UtilHBM.turnOffImplicitWaits(driver);
			boolean isLoaderDisappreared = loader.isEmpty();
			UtilHBM.turnOffImplicitWaits(driver);
			UtilHBM.waitFixTime(1000);
			if (isLoaderDisappreared) {
				UtilHBM.reportInfo("Loader displayed for " + i + " seconds while opening geometry editor");
				temp = true;
				break;
			}
		}
		if (!temp) {
			UtilHBM.reportKO("Loader displayed for more than 10 seconds");
		}
//		Upload3dModel upload3dModel=PageFactory.initElements(driver, Upload3dModel.class);
//		upload3dModel.swtichFrame(); 
		return PageFactory.initElements(driver, Upload3dModel.class);
	}

	
	public Upload3dModel clickGetStarted() {
		UtilHBM.waitExplicitDisplayed(driver, getStartedButton);
		UtilHBM.waitExplicitClickable(driver, getStartedButton);
		getStartedButton.click();
		UtilHBM.waitFixTime(2000);
		int i;
		boolean temp = false;
		for (i = 0; i < 10; i++) {
			UtilHBM.turnOffImplicitWaits(driver);
			boolean isLoaderDisappreared = loader.isEmpty();
			UtilHBM.turnOffImplicitWaits(driver);
			UtilHBM.waitFixTime(1000);
			if (isLoaderDisappreared) {
				UtilHBM.reportInfo("Loader displayed for " + i + " seconds while opening geometry editor");
				temp = true;
				break;
			}
		}
		if (!temp) {
			UtilHBM.reportKO("Loader displayed for more than 10 seconds");
		}
		Upload3dModel upload3dModel=PageFactory.initElements(driver, Upload3dModel.class);
		upload3dModel.swtichFrame(); 
		return PageFactory.initElements(driver, Upload3dModel.class);
	}

	public UserProfilePage clickCancelButton() {
		UtilHBM.waitExplicitDisplayed(driver, cancelButton);
		UtilHBM.waitExplicitClickable(driver, cancelButton);
		cancelButton.click();
		return PageFactory.initElements(driver, UserProfilePage.class);
	}
	
	public ThreeDPlanner clickCancelButtonPlanner() {
		UtilHBM.waitExplicitDisplayed(driver, cancelButton);
		UtilHBM.waitExplicitClickable(driver, cancelButton);
		cancelButton.click();
		UtilHBM.waitFixTime(1000);
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			
		}
		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
		
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public InfoPageGeometryEditor checkDoNotShowAgain() {
		UtilHBM.waitExplicitDisplayed(driver, doNotShowAgainLabel);
		UtilHBM.waitExplicitClickable(driver, doNotShowAgainLabel);
		doNotShowAgainLabel.click();
		return this;
	}
}
