package kitchen.bryo.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class Duplicate {

	WebDriver driver;

	public Duplicate(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//article[@class='mod-popin-alert-duplicate mod-open']")
	private WebElement duplicatePopIn;

	@FindBy(xpath = "//article[@class='mod-popin-alert-duplicate mod-open']/div/header/div/div/h3")
	private WebElement duplicateTitle;

	@FindBy(xpath = "//article[@class='mod-popin-alert-duplicate mod-open']/div/header/div/div/b")
	private WebElement duplicateInfo;

	@FindBy(css = "input[name='duplicate-project-name']")
	private WebElement duplicateProjectName;

	@FindBy(css = "textarea[name='duplicate-project-desc']")
	private WebElement duplicateProjectDesc;

	@FindBy(css = ".mod-popin-alert-duplicate.mod-open>div>div>footer>button[data-ui-action='popin-validate']")
	private WebElement duplicateOKbutton;

	@FindBy(xpath = "//div[@class='project-images']/div/div[@class='img-container']/img[starts-with(@src, 'https')]")
	private List<WebElement> renderingImages;

	@FindBy(xpath = "//div[@id='plan2D-container']/div/div[@class='img-container']/img[starts-with(@src, 'https')]")
	private List<WebElement> plan2DImages;
	
	public ProjectDetailsPage duplicateProject(String name, String desc) {
		String handle = driver.getWindowHandle();
		for (String winHandle: driver.getWindowHandles()){
			if (winHandle != handle){
				driver.switchTo().window(winHandle);
			}else {
				System.out.println("current window is active");
			}
			System.out.println(driver.getWindowHandle());
			driver.switchTo().window(winHandle);
		}
//		driver.switchTo().parentFrame();
		UtilHBM.waitExplicitDisplayed(driver, duplicatePopIn);
		Verification.VerifyEquals("Duplicate pop-in title not correct",
				"Duplicate", duplicateTitle.getText());
		Verification.VerifyEquals("Duplicate pop-in info not correct",
				"Choose a name for your duplicate project",
				duplicateInfo.getText());
//		duplicateProjectName.sendKeys("invalid>data");
//		WebElement ele = driver.findElement(By.cssSelector("#project-name-error"));
//		UtilHBM.waitExplicitDisplayed(driver, ele);
//		if (duplicateOKbutton.isEnabled()) {
//			UtilHBM.reportKO("Save is not disabled and the text is: " + duplicateOKbutton.getText());
//		} else {
//			UtilHBM.reportOK(duplicateOKbutton.getText() + " is  disabled.");
//		}
//		Verification.VerifyEquals("Wrong error message", ele.getText(),
//				"The following symbols are not valid <, >, \", /, &.");
//		UtilHBM.waitFixTime(1000);
		if (!(name.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, duplicateProjectName);
			duplicateProjectName.click();
			duplicateProjectName.clear();
			duplicateProjectName.sendKeys(name);
		}

		if (!(desc.isEmpty())) {
			UtilHBM.waitExplicitClickable(driver, duplicateProjectDesc);
			duplicateProjectDesc.click();
			duplicateProjectDesc.clear();
			duplicateProjectDesc.sendKeys(desc);
		}

		UtilHBM.waitFixTime(1500);
		duplicateOKbutton.click();
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".project-actions>button.cta-primary"));
		String handle1 = driver.getWindowHandle();
		for (String winHandle: driver.getWindowHandles()){
			if (winHandle != handle){
				driver.switchTo().window(winHandle);
			}else {
				System.out.println("current window is active");
			}
			System.out.println(driver.getWindowHandle());
			driver.switchTo().window(winHandle);
		}
		return PageFactory.initElements(driver, ProjectDetailsPage.class);
	}
	
}
