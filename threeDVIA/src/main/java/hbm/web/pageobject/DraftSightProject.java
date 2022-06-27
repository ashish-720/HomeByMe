package hbm.web.pageobject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import hr.planner.pageObject.HomePlanner;

import java.util.List;

import kitchen.bryo.pageObject.FloorPlan;
import kitchen.bryo.pageObject.HomeByMeProjects;
import kitchen.bryo.pageObject.MakeItHappen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraftSightProject {
	
	WebDriver driver;
	
	public DraftSightProject(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css="#app>section>header>.user-info.flex.flex-middle>.flex.flex-column.u-mlxs>a")
	private WebElement logout;
	
	@FindBy(css="#app>section>main>div>div>section>div>.project-list>div")
	private List<WebElement> projectList;
	
	@FindBy(css="#app>section>main>div>div>section>div>.project-list>div>picture>a")
	private List<WebElement> projectListTurntable;
	
	@FindBy(css="main>div>.select-project-confirmation>.button")
	private WebElement selectProjectButton;
	
	@FindBy(css=".project-list>div>a[title='More']")
	private WebElement moreBtnKitchen;
	
	@FindBy(xpath="//div[@class='card-project']/div/a/div[@class='title'])")
	List<WebElement> projectListKitchen;
	
	@FindBy(css = "div.header__container.row > figure > img")
	private WebElement homebymeLogo;
	
	@FindBy(css = "div>.export-header>h2")
	private WebElement exportProjectHeader;

	@FindBy(css = "div>.export-header>p")
	private WebElement exportProjectHeaderInfo;
	
	@FindBy(css = ".mod-notification>.success.show")
	private WebElement notificationText; //notification for Home Retailers
	
	public DraftSightEmbed logout() {
		UtilHBM.waitExplicitClickable(driver, logout);
		logout.click();
		return PageFactory.initElements(driver, DraftSightEmbed.class);
	}
	
	public DraftSightProject verifyPage(){
		UtilHBM.waitExplicitClickable(driver, projectListTurntable.get(0));
		if(projectListTurntable.size()>0){
			UtilHBM.reportOK("List of projects displayed");
		}else{
			UtilHBM.reportKO("List of project is not displayed");
		}
		if(!(selectProjectButton.getAttribute("class").contains("is-disabled"))){
			UtilHBM.reportKO("Select Project button is enabled without selecting project");
		}
		projectList.get(0).click();
		if(projectList.get(0).getAttribute("class").contains("is-selected") && !(selectProjectButton.getAttribute("class").contains("is-disabled"))){
			UtilHBM.reportOK("Project is selected after click on it & Select Project is enabled");
		}else if (!projectList.get(0).getAttribute("class").contains("is-selected") && selectProjectButton.getAttribute("class").contains("is-disabled")){
			UtilHBM.reportKO("project is not selected after click & Select Project Button is not enabled too");
		}else if (!projectList.get(0).getAttribute("class").contains("is-selected")){
			UtilHBM.reportKO("project is not selected after click");
		}else if(selectProjectButton.getAttribute("class").contains("is-disabled")){
			UtilHBM.reportKO("Select Project Button is not enabled after selecting project");
		}
		return this;
	}
	
	public FloorPlan selectProjectForBryo(String projectName, int index){
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.cssSelector("#iframeContainer>iframe")));
		driver.switchTo().frame(driver.findElement(By.cssSelector("#embedded-app-frame")));
//		UtilHBM.waitExplicitClickable(driver, projectListKitchen.get(0));
		UtilHBM.turnOffImplicitWaits(driver);
		List<WebElement> project= driver.findElements(By.xpath("//div[@class='project-list']/div/div/a/div[normalize-space(text())='"+projectName+"']/../../.."));	
		int i=0;
		while(project.size()<(index+1)&& i<20){
			UtilHBM.scrollToElementWithOffset(driver, moreBtnKitchen, 0);
			UtilHBM.waitExplicitClickable(driver, moreBtnKitchen);
			moreBtnKitchen.click();
			UtilHBM.waitFixTime(1000);
			project= driver.findElements(By.xpath("//div[@class='project-list']/div/div/a/div[normalize-space(text())='"+projectName+"']/../../.."));
			i++;
		}
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.scrollToElementWithOffset(driver, project.get(index), 10);
		project.get(index).click();
		UtilHBM.waitExplicitClickable(driver, selectProjectButton);
		Verification.displayNAttributeCheckOfElement(project.get(index), "Selected Project", "class", "is-selected card-project");
		selectProjectButton.click();		
		driver.switchTo().parentFrame();		
		return PageFactory.initElements(driver, FloorPlan.class);
	}
	
	public HomePlanner selectProjectForBryoHR(String projectName, int index){
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.cssSelector("#iframeContainer>iframe")));
		driver.switchTo().frame(driver.findElement(By.cssSelector("#embedded-app-frame")));
//		UtilHBM.waitExplicitClickable(driver, projectListKitchen.get(0));
		UtilHBM.turnOffImplicitWaits(driver);
		List<WebElement> project= driver.findElements(By.xpath("//div[@class='project-list']/div/div/a/div[normalize-space(text())='"+projectName+"']/../../.."));	
		int i=0;
		while(project.size()<(index+1)&& i<20){
			UtilHBM.scrollToElementWithOffset(driver, moreBtnKitchen, 0);
			UtilHBM.waitExplicitClickable(driver, moreBtnKitchen);
			moreBtnKitchen.click();
			UtilHBM.waitFixTime(1000);
			project= driver.findElements(By.xpath("//div[@class='project-list']/div/div/a/div[normalize-space(text())='"+projectName+"']/../../.."));
			i++;
		}
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.scrollToElementWithOffset(driver, project.get(index), 10);
		project.get(index).click();
		UtilHBM.waitExplicitClickable(driver, selectProjectButton);
		Verification.displayNAttributeCheckOfElement(project.get(index), "Selected Project", "class", "is-selected card-project");
		selectProjectButton.click();
		driver.switchTo().parentFrame();		
		WebElement importScrn = driver.findElement(By.cssSelector(".bridge-loader-text>h3"));
		UtilHBM.waitExplicitDisplayed(driver, importScrn);
		UtilHBM.waitFixTime(10000);
		UtilHBM.waitExplicitDisplayed(driver, notificationText);
		Verification.verifyText(notificationText, "A copy of your HomeByMe project has been imported.", "HBM project import notification");
//		UtilHBM.waitTillElementDisappear(driver, importScrn);
		
		return PageFactory.initElements(driver, HomePlanner.class);
	}
	
	
	
	public MakeItHappen exportToHBM() {
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.cssSelector("#iframeContainer>iframe")));
		driver.switchTo().frame(driver.findElement(By.cssSelector("#embedded-app-frame")));
		UtilHBM.waitFixTime(1000);
		Verification.displayOfWebElement(homebymeLogo);
		Verification.VerifyEquals("Export HBM project Header not displayed", exportProjectHeader.getText(),
				"Publish on HomeByMe");
		Verification.VerifyEquals("Export HBM project  info not displayed", exportProjectHeaderInfo.getText(),
				"A copy of your project will be created in HomeByMe.");		
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("div[class='wrapper export']>section>div>div[class='is-selected card-project']")));
		UtilHBM.waitExplicitClickable(driver, selectProjectButton);
		selectProjectButton.click();
		exportLoader()
		.verifyHBMExportMsg();		
		return PageFactory.initElements(driver, MakeItHappen.class);
	}
	
	public MakeItHappen exportLoader() {	
		driver.switchTo().parentFrame();
		if (UtilHBM.webElement(driver, ".bridge-loader").isDisplayed()
				&& UtilHBM.webElement(driver, ".bridge-loader-text").isDisplayed()) {
			UtilHBM.reportInfo("Loading screen is displayed while loading project in planner");
		} else {
			UtilHBM.reportWarning("Loading screen is not displayed while loading project in planner");
		}
		UtilHBM.waitTillElementDisappear(driver, ".mod-layer");		
		return PageFactory.initElements(driver, MakeItHappen.class);
	}

}
