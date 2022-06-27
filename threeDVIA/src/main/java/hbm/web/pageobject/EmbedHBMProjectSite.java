package hbm.web.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class EmbedHBMProjectSite extends Browser {
	WebDriver driver;

	public EmbedHBMProjectSite(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "h1.subHeader-title>a[title='HomeByMe']")
	WebElement homebymeLogo;

	@FindBy(css = "#turntableContainer>div.reel.reel-overlay>img")
	private WebElement embededProjectTurnableImg;

	@FindBy(css = "a[class='button embed-buttonHBM']")
	private WebElement viewThisProject;

	@FindBy(css = "a[class='button embed-buttonHBM']")
	private WebElement openProject;

	@FindBy(css = ".subHeader-title>a>img")
	private WebElement subHeaderLogoEmbed;

	@FindBy(css = ".subHeader-title>span")
	private WebElement subHeaderTextEmbed;

	public EmbedHBMProjectSite verifyEmbedProject(String iframeId) {
		WebElement currentIframe = null;
		int temp = 10;
		for (int i = 0; i < temp; i++) {
			UtilHBM.turnOffImplicitWaits(driver);
			List<WebElement> currentIframeList = driver.findElements(By.xpath("//iframe[@id='" + iframeId + "']"));
			UtilHBM.turnOnImplicitWaits(driver);
			UtilHBM.waitFixTime(1000);
			if (!currentIframeList.isEmpty()) {
				currentIframe = currentIframeList.get(0);
				break;
			} else if (i == temp - 1) {
				UtilHBM.reportKO("Iframe with id " + iframeId + " not displayed for " + (i + 1) + " seconds");
			}
		}
		currentIframe.click();
		driver.switchTo().frame(currentIframe);
		UtilHBM.waitExplicitDisplayed(driver, embededProjectTurnableImg);
		Verification.displayOfWebElement(embededProjectTurnableImg);
		Verification.displayOfWebElement(subHeaderLogoEmbed);
		Verification.VerifyEquals("Sub Header text is not correct in Embed Link", subHeaderTextEmbed.getText(),
				"Visit the real property with");
		acceptCookies();
		return this;
	}

	public EmbedHBMProjectSite switchToParentIframe() {
		driver.switchTo().parentFrame();
		return this;
	}

	public ThreeDPlanner verifyOpenProject() {
		clickOpenProject();
		UtilHBM.waitFixTime(1000);
		for (String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}
		UtilHBM.webElement(driver, ".close-modal.button-close").click();
		UtilHBM.waitFixTime(40000);
		Baner baner = PageFactory.initElements(driver, Baner.class);
		baner.verifyEmbeddedProjectPopin();
		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}

	public EmbedHBMProjectSite verifyViewThisProject(String projectName) {
		clickViewThisProject();
		UtilHBM.waitFixTime(1000);
		String winHandle = driver.getWindowHandle();
		for (String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}
		ProjectPage projectPage = PageFactory.initElements(driver, ProjectPage.class);
		projectPage.verifyProjectName(projectName);
		driver.close();
		driver.switchTo().window(winHandle);
		return this;
	}

	public ProjectPage clickViewThisProject() {
		UtilHBM.waitExplicitClickable(driver, viewThisProject);
		Verification.VerifyEquals("View this project button Text test failed", viewThisProject.getText(),
				"VIEW THIS PROJECT");
		viewThisProject.click();
		return PageFactory.initElements(driver, ProjectPage.class);
	}

	private ThreeDPlanner clickOpenProject() {
		UtilHBM.waitExplicitClickable(driver, openProject);
		Verification.VerifyEquals("open Project button text test failed", openProject.getText(), "Open project");
		openProject.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}

	public EmbedHBMProjectSite acceptCookies() {
//		String winHandle = driver.getWindowHandle();
//		for (String handle1 : driver.getWindowHandles()) {
//			driver.switchTo().window(handle1);
//		}
		List<WebElement> acceptCookies = null;
		UtilHBM.waitFixTime(1000);
		int temp = 15;
		for (int i = 0; i < temp; i++) {
			UtilHBM.turnOffImplicitWaits(driver);
			acceptCookies = driver.findElements(By.cssSelector(
					"html>body>#tc-privacy-wrapper>#footer_tc_privacy>#footer_tc_privacy_container_button>#footer_tc_privacy_button_3"));
			boolean isAcceptCookiesDisplayed = !acceptCookies.isEmpty();
			UtilHBM.turnOnImplicitWaits(driver);
			UtilHBM.waitFixTime(1000);
			if (isAcceptCookiesDisplayed) {
				UtilHBM.reportInfo("Accept cookies popup displayed after " + (i + 1) + " seconds");
				UtilHBM.waitExplicitClickable(driver, acceptCookies.get(0));
				UtilHBM.waitExplicitDisplayed(driver, acceptCookies.get(0));
				acceptCookies.get(0).click();
				UtilHBM.waitTillElementDisappear(driver, acceptCookies.get(0));
				break;
			} else if (i == temp - 1) {
				UtilHBM.reportKO("Accept cookies popup not displayed for " + (i + 1) + " seconds");
			}
		}
		UtilHBM.waitFixTime(1000);
		/*
		 * try { acceptCookies.click(); // driver.switchTo().window(winHandle); } catch
		 * (Exception e) {
		 * UtilHBM.reportWarning("Accept cookies message not displayed"); }
		 */
		return this;
	}

}
