package kitchen.bryo.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class HomeByMeProjects {

	WebDriver driver;

	public HomeByMeProjects(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "div.wrapper > figure > img")
	private WebElement homebymeLogo;

	@FindBy(css = "#connect-header>main>div>div>section>div>h2")
	private WebElement selectProjectHeader;

	@FindBy(css = "#connect-header>main>div>div>section>div>p")
	private WebElement selectProjectHeaderInfo;
	
	@FindBy(css = "div>.export-header>h2")
	private WebElement exportProjectHeader;

	@FindBy(css = "div>.export-header>p")
	private WebElement exportProjectHeaderInfo;
		
	@FindBy(xpath = "//section[@id='connect-header']/main/div/div/section/div/div[@class='project-list']/div")
	private List<WebElement> projectsList;

	@FindBy(css = "#splash>figure>.loader")
	private WebElement loader;

	@FindBy(css = ".is-selected")
	private WebElement projectIsSelected;

	@FindBy(css = ".select-project-confirmation>button")
	private WebElement selectConfirmation;

	@FindBy(css = "#room-selector-layer>div>header>div>.text>h3")
	private WebElement roomSelectorTitle;

	@FindBy(id = "canvas-level-selector")
	private List<WebElement> floorOptionSize;

	@FindBy(css = "#canvas-level-selector>span>select")
	private WebElement floorOptionFilter;

	@FindBy(css = "div[class='close-embed']")
	private WebElement closeHBMWindow;

	@FindBy(xpath = "//div[@class='wrapper']/section/div/div/div[@class='grid-4-4 u-txtCenter u-mts u-mbm']/a")
	private List<WebElement> showMoreButton;

	@FindBy(css = ".mod-onboarding.mod-ui-tip .label")
	private WebElement hbmToolTipTitle;
	
	@FindBy(css = ".mod-onboarding.mod-ui-tip .label+p")
	private WebElement hbmToolTipInfo;
	
	@FindBy(css="button[data-ui-action='tip-hide']")
	private WebElement hideHBMToolTip;
	
	@FindBy(css = "div>p[data-notif-action='hbm_export']")
	private WebElement hbmExportRibbon;
	
	public HomeByMeProjects verifyHomeByMeProjects() {

		Verification.displayOfWebElement(homebymeLogo);
		Verification.VerifyEquals("Select project Header not displayed", selectProjectHeader.getText(),
				"Select a project");
		Verification.VerifyEquals("Select project Header info not displayed", selectProjectHeaderInfo.getText(),
				"No change will be made on your original project in HomeByMe.");
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitClickable(driver, selectConfirmation);
		if (projectsList.size() > 0) {
			UtilHBM.reportInfo("Number of projects displayed are " + projectsList.size());
		}
		return PageFactory.initElements(driver, HomeByMeProjects.class);
	}
/*
	public MakeItHappen exportToHBM() {
		Verification.displayOfWebElement(homebymeLogo);
		Verification.VerifyEquals("Export HBM project Header not displayed", exportProjectHeader.getText(),
				"Export to HomeByMe");
		Verification.VerifyEquals("Export HBM project  info not displayed", exportProjectHeaderInfo.getText(),
				"A copy of your project will be created in HomeByMe.");
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("div[class='wrapper export']>section>div>div[class='is-selected card-project']")));
		UtilHBM.waitExplicitClickable(driver, selectConfirmation);
		selectConfirmation.click();
		exportLoader();
		UtilHBM.waitExplicitDisplayed(driver, hbmExportRibbon);
		if (hbmExportRibbon.getText().equalsIgnoreCase("A copy of your project was sent to HomeByMe.")) {
			UtilHBM.reportOK("HBM project export notification message displayed is correct and message is : "
					+ hbmExportRibbon.getText());
		} else {
			UtilHBM.reportKO("HBM project export notification message displayed is in-correct and message is : "
					+ hbmExportRibbon.getText());
		}
		return PageFactory.initElements(driver, MakeItHappen.class);
	}
	*/
	public FloorPlan selectHomeByMeProject(String projectTitle) {
		verifyHomeByMeProjects();
		List<WebElement> projectList = null;
		int i = 0;
		int success = 0;
		do {
			projectList = driver.findElements(By.xpath(
					"//section[@id='connect-header']/main/div/div/section/div/div[@class='project-list']/div/div/a/div[normalize-space() = '"+ projectTitle + "']/../preceding-sibling::div/../preceding-sibling::picture"));
			if (projectList.size() > 0) {
				success = 1;
				break;
			}
			showMoreButton.get(0).sendKeys(Keys.ENTER);
			UtilHBM.waitFixTime(1000);
			i++;
		} while (i < 10 && !(showMoreButton.isEmpty()));

		if (success == 0) {
			UtilHBM.reportKO("Project not found!!");
		}
		UtilHBM.waitFixTime(1500);
//		System.out.println("name: "+projectList.get(i));
		new Actions(driver).moveToElement(projectList.get(0).findElement(By.xpath("div[@class='cover-thumb-container']/following-sibling::a"))).build().perform();
		projectList.get(0).click();
		UtilHBM.waitExplicitDisplayed(driver, projectIsSelected);
		if (projectIsSelected.isDisplayed()) {
			UtilHBM.reportOK("HomeByMe Project selected and project name is " + projectList.get(0).getText());
			new Actions(driver).moveToElement(selectConfirmation).click().build().perform();
			loader();
		}
		
//		List<WebElement> projectList = null;
//		int i = 0;
//		boolean success = false;
//		do {
//			projectList = driver.findElements(By
//					.xpath("//section[@id='connect-header']/main/div/div/section/div/div[@class='project-list']/div/div/a/div[normalize-space() = '"+ projectTitle + "']"));
//			showMoreButton.get(0).sendKeys(Keys.ENTER);
//			UtilHBM.waitFixTime(1500);
//			if (projectList.size() > 0 ) {
//				new Actions(driver).moveToElement(projectList.get(0)).build().perform();
//				UtilHBM.waitExplicitDisplayed(driver, projectList.get(0));
//				UtilHBM.waitExplicitClickable(driver, projectList.get(0));
//				UtilHBM.reportOK("Before Selection project name is : "+projectList.get(0).getText());
//				new Actions(driver).moveToElement(projectList.get(0)).build().perform();
//				new Actions(driver).moveToElement(projectList.get(0)).clickAndHold().pause(500).release().build().perform();
//				UtilHBM.reportOK("Selected project name is : "+projectList.get(0).getText());
//				UtilHBM.waitExplicitDisplayed(driver, projectIsSelected);
//				if (projectIsSelected.isDisplayed()) {
//					UtilHBM.reportOK("HomeByMe Project selected and project name is " + projectList.get(0).getText());
//					new Actions(driver).moveToElement(selectConfirmation).click().build().perform();
//					loader();
//				}
//				success = true;
//				break;
//			}
//		
//			i++;
//		} while (i < 10 && !(showMoreButton.isEmpty()));
//
//		if (success == false) {
//			UtilHBM.reportKO("Given project not found!!");
//		}
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public HomeByMeProjects selectFloorOptions(String floor) {
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector(".room.Tag3D")));
		UtilHBM.turnOffImplicitWaits(driver);
		if (floorOptionSize.size() > 0) {
			if (floorOptionSize.get(0).isDisplayed()) {
				String expectedToolTipTitle = "Choose a floor";
				String expectedToolTipInfo = "Your project has several floors. Choose the correct floor and select your kitchen.";
				UtilHBM.waitExplicitDisplayed(driver, hbmToolTipTitle);
				Verification.VerifyEquals("HBM tool tip title not correct", hbmToolTipTitle.getText(), expectedToolTipTitle);
				Verification.VerifyEquals("HBM tool tip info not correct ", hbmToolTipInfo.getText(), expectedToolTipInfo);
				hideHBMToolTip.click();
				UtilHBM.reportOK("Canvas tools options dropdown displayed for HBM project containing floors");
				Select select = new Select(floorOptionFilter);
				List<WebElement> options = select.getOptions();
				for (WebElement b : options) {
					select.selectByVisibleText(floor);

					UtilHBM.reportInfo("Number of floors available for given HBM project are " + b.getText() + "\n");

				}
			}
		} else {
			UtilHBM.reportMsg("Canvas tools options dropdown NOT displayed for HBM project containing floors");
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return PageFactory.initElements(driver, HomeByMeProjects.class);
	}

	public FloorPlan closeHBMBridge() {
		closeHBMWindow.click();
		driver.switchTo().parentFrame();
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public HomeByMeProjects loader() {
		driver.switchTo().parentFrame();
		if (UtilHBM.webElement(driver, ".bridge-loader").isDisplayed()
				&& UtilHBM.webElement(driver, ".bridge-loader-text").isDisplayed()) {
			UtilHBM.reportInfo("Loading screen is displayed while loading project in planner");
		} else {
			UtilHBM.reportWarning("Loading screen is not displayed while loading project in planner");
		}
		UtilHBM.waitTillElementDisappear(driver, ".mod-layer");

		return PageFactory.initElements(driver, HomeByMeProjects.class);
	}
}
