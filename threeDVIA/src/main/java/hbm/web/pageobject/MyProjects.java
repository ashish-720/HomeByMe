package hbm.web.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import hbm.planner.dataobject.NewProjectData;
import hbm.planner.pageobject.NewProject;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import io.appium.java_client.AppiumDriver;

public class MyProjects {
	
	WebDriver driver;
	
	public MyProjects(WebDriver driver) {
		this.driver=driver;	
	}
	
	@CacheLookup
	@FindBy(css="body>main>div>div>div>div>div>div>.link-newProject.open-planner-embed.b-lazy")
	private WebElement newProjectButton;
	
	@FindBy(css="body>main>div>div>div>div>.grid>.grid-1-3>div>.cover-thumb")
	List<WebElement> projectThumbList;
	
	@FindBy(css=".grid>.grid-4-4.u-txtCenter.u-mtm>.button--alt")
	List<WebElement> moreButton;
	
	@FindBy(css=".header-btnMenu")
	WebElement headerMenuMobile;
	
	@FindBy(xpath="//header[@class='headr']/div/nav/span/span/span[contains(text(),'MAGAZINE')]")
	WebElement magazine;
	
	@FindBy(xpath="//header[@class='headr']/div/nav/span[1]/div/div/a[1]")
	WebElement magazineHomePage;
	
	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown>span.dropdown__toggle")
	private WebElement userAvatar;
	
	@CacheLookup
	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown.is-open>.dropdown_content>div>a[title='Logout']")
	private WebElement logout;
	
	@FindBy(css = "div#my_projects>h2")
	private WebElement myProjectHeader;
	
	public MyProjects closeDiscountPopupIfAvailable() {
		UtilHBM.waitFixTime(1000);
		UtilHBM.turnOffImplicitWaits(driver);
		List<WebElement> discountPopup = driver
				.findElements(By.xpath("//div[@class='popin-content-medium']/div[@class='-close']"));
		boolean isDiscountPopupDisplayed = !discountPopup.isEmpty();
		UtilHBM.turnOnImplicitWaits(driver);
		if (isDiscountPopupDisplayed) {
			UtilHBM.waitExplicitDisplayed(driver, "//div[@class='popin-content-medium']/div[@class='-close']");
			UtilHBM.webElementXPath(driver, "//div[@class='popin-content-medium']/div[@class='-close']").click();
		} else {
			UtilHBM.reportInfo("Discount popup not displayed!!");
		}
		return this;
	}

	
	public ThreeDPlanner createNewProject(NewProjectData newProjectData){
		UtilHBM.waitExplicitDisplayed(driver,
				driver.findElement(By.cssSelector("#tuile-add-project-1>button>div>div>i")));
		UtilHBM.waitExplicitClickable(driver, newProjectButton);
		newProjectButton.click();
		for (String winHandle: driver.getWindowHandles()){
			System.out.println(driver.getWindowHandle());
			driver.switchTo().window(winHandle);
		}				
		NewProject newProject = PageFactory.initElements(driver, NewProject.class);
		return newProject.fillNewProjectDetials(newProjectData);
	}
	
	public ProjectPage openOwnProjectMDM(String projectTitle) {
		WebElement project=driver.findElement(By.xpath("//div[@class='grid']/div[@class='grid-1-3']/div/div[@class='media-legend']/p/a[normalize-space() = '"
						+ projectTitle + "']"));
		UtilHBM.waitExplicitClickable(driver, project);
		project.click();
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	public ProjectPage openOwnProject(int index, String projectTitle) {
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, myProjectHeader);
		UtilHBM.waitExplicitDisplayed(driver, newProjectButton);
		List<WebElement> projectList = null;
		int i = 0;
		boolean success = false;
		do {
			projectList = driver.findElements(By.xpath(
					"//div[@class='grid-1-3 u-mbs']/div[starts-with(@class,'b-lazy card-project')]/div[@class='content']/a/div[normalize-space() = '"
							+ projectTitle + "']"));
			if (projectList.size() > index) {
				success = true;
				break;
			}
			clickMoreButton();
			i++;
		} while (i < 10 && !(moreButton.isEmpty()));

		if (!success) {
			UtilHBM.reportKO("Project not found!! Project Title : " + projectTitle + " , Index : " + index);
		}
		UtilHBM.waitExplicitDisplayed(driver, projectThumbList.get(index));
		projectList.get(index).click();
		UtilHBM.reportInfo("Opening project page of project : " + projectTitle + " , Index : " + index);
//		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".subHeader-title"));
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	public ProjectPage openOwnProject(int projectIndex) {
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, myProjectHeader);
//		UtilHBM.waitExplicitDisplayed(driver, newProjectButton);
		int temp = 10;
		int i = 0;
		while (projectThumbList.size() < (projectIndex - 1) && !(moreButton.isEmpty()) && i < temp) {
			clickMoreButton();
			i++;
		}
		UtilHBM.waitExplicitClickable(driver, projectThumbList.get(projectIndex - 1));
		projectThumbList.get(projectIndex - 1).click();
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".subHeader-title"));
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	
	public ProjectPage duplicateProject(String projectTitle) {
		WebElement projectThumbnail = driver.findElement(By.xpath(
				"//div[@class='grid-1-3 u-mbs']/div[starts-with(@class,'b-lazy card-project')]/div[@class='content']/a/div[normalize-space() = '"
						+ projectTitle + "']/../../preceding-sibling::picture"));
		new Actions(driver).moveToElement(projectThumbnail).build().perform();
		clickDuplicateButton(projectTitle).verifyDuplicateDialogBox().clickDuplicateOK().verifyDuplicated("Copy of " + projectTitle);
		return PageFactory.initElements(driver, ProjectPage.class);
	}

	private DuplicateConfirmation clickDuplicateButton(String projectTitle) {
		WebElement duplicateProjectButton = driver.findElement(By.xpath(
				"//div[@class='grid-1-3 u-mbs']/div[starts-with(@class,'b-lazy card-project')]/div[@class='content']/a/div[normalize-space() = '"
						+ projectTitle + "']/../../preceding-sibling::picture/div/ul/li/a[@title='Duplicate this project']"));
		UtilHBM.waitExplicitDisplayed(driver, duplicateProjectButton);
		UtilHBM.waitExplicitClickable(driver, duplicateProjectButton);
		duplicateProjectButton.click();
		return PageFactory.initElements(driver, DuplicateConfirmation.class);
	}
	
	public ThreeDPlanner editProject(int serialNumber){
		new Actions(driver).moveToElement(projectThumbList.get(serialNumber-1)).build().perform();
		WebElement edit = projectThumbList.get(serialNumber-1).findElement(By.cssSelector("ul>li>a.button.button--icon.open-planner-embed"));
		UtilHBM.waitExplicitClickable(driver, edit);
		edit.click();
//		UtilHBM.webElement(driver, ".close-modal.button-close").click();
		UtilHBM.waitFixTime(1000);
		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
		if(UtilHBM.webElement(driver, "img[src='assets/images/logo_hbm.png']").isDisplayed() &&
				UtilHBM.webElement(driver, "#loading").isDisplayed()){
			UtilHBM.reportInfo("Loading screen is displayed while loading project in planner");
		}else{
			UtilHBM.reportWarning("Loading screen is not displayed while loading project in planner");
		}
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".head-title"));
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.twoDView();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}

	public MyProjects verifyMyProjects(String service, int expectedNoOfProjects) {
		String d1 = UtilHBM.getDate(0, "MMMMM d, yyyy");
		switch (service.toUpperCase()) {
		case "IDS":
				UtilHBM.turnOffImplicitWaits(driver);
				List<WebElement> idsProjects = driver.findElements(By.xpath("//div[@class='grid-1-3 u-mbs']/div/div[@class='content']/div[@class='date'][contains(text(),'"+d1+"')]/../preceding-sibling::picture[@class='thumb']/a/div[@class='media-thumb-inProgress']/p"));
				if(idsProjects.size()==expectedNoOfProjects) {
					UtilHBM.reportOK("No. of projects delivered by IDS service are correct!!");	
					for(WebElement proj:idsProjects) {
						Verification.VerifyEquals("Wrong Service tag for IDS delivered projects!!!", proj.getText(), "Interior design service");
						Verification.displayOfWebElement(proj.findElement(By.xpath("../preceding-sibling::img[starts-with(@src,'https:')]")));
					}		
				} else {
					UtilHBM.reportKO("No. of projects delivered by IDS service are incorrect!!ExpectedNoOfProjects: "+expectedNoOfProjects+",Projects displayed: "+idsProjects.size()+"!!! Only following projects displayed :");
					for(WebElement proj:idsProjects) {
						UtilHBM.reportKO(proj.findElement(By.xpath("../../../following-sibling::div/a/div[@class='title']")).getText());				
					}
				}
			break;

		case "HMS":

			break;

		case "FP":
				UtilHBM.turnOffImplicitWaits(driver);
				List<WebElement> fpProjects = driver.findElements(By.xpath("//div[@class='grid-1-3 u-mbs']/div/div[@class='content']/div[@class='date'][contains(text(),'"+d1+"')]/../preceding-sibling::picture[@class='thumb']/a/div[@class='media-thumb-purchased']/p"));
				if(fpProjects.size()==expectedNoOfProjects) {
					UtilHBM.reportOK("No. of projects delivered by FP service are correct!!");	
					for(WebElement proj:fpProjects) {
						Verification.VerifyEquals("Wrong Service tag for IDS delivered projects!!!", proj.getText(), "Purchased floor plan");
						Verification.displayOfWebElement(proj.findElement(By.xpath("../preceding-sibling::img[starts-with(@src,'https:')]")));
					}
				} else {
					UtilHBM.reportKO("No. of projects delivered by FP service are incorrect!!ExpectedNoOfProjects: "+expectedNoOfProjects+",Projects displayed: "+fpProjects.size()+"!!! Only following projects displayed :");
					for(WebElement proj:fpProjects) {
						UtilHBM.reportKO(proj.findElement(By.xpath("../../../following-sibling::div/a/div[@class='title']")).getText());				
					}
				}		
			break;

		case "NP":

			break;
			
		default:
			UtilHBM.reportKO("Incorrect Service type!!!");
		}
		return PageFactory.initElements(driver, MyProjects.class);
	}
	
	public UserHomePage clickMoreButton(){
		UtilHBM.waitExplicitClickable(driver, moreButton.get(0));
		moreButton.get(0).click();
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, projectThumbList.get(projectThumbList.size()-1));
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public Magazine goToMagazine() {
		UtilHBM.waitExplicitDisplayed(driver, magazine);
		Actions actions=new Actions(driver);
		actions.moveToElement(magazine).build().perform();
		UtilHBM.waitExplicitDisplayed(driver, magazineHomePage);
		UtilHBM.waitExplicitClickable(driver, magazineHomePage);
		magazineHomePage.click();
		return PageFactory.initElements(driver, Magazine.class);
	}
	
	public MyProjects verifyPageTitle() {
		String pageTitle = driver.getTitle();
		if (pageTitle.equals("All your projects on HomeByMe")) {
			UtilHBM.reportOK("My project page displayed from RS4 page!!");
		} else {
			UtilHBM.reportKO("My projects page not displayed from RS4 page!!");
			Assert.assertFalse(pageTitle.contains("Error"));
		}
		return this;
	}
	
	public MyProjects verifyFirstProject(String expectedProjectName, boolean isTurntableExpected) {
		UtilHBM.waitExplicitDisplayed(driver, projectThumbList.get(0));
		UtilHBM.turnOffImplicitWaits(driver);
		List<WebElement> projectList = driver
				.findElements(By.cssSelector("body>main>div>div>div>div>.grid>.grid-1-3>div"));
		WebElement firstProject = projectList.get(0);
		List<WebElement> placeholder = firstProject.findElements(By.cssSelector("picture>div>img[src*='placeholder']"));
		List<WebElement> turntable = firstProject.findElements(By.cssSelector("picture>div>img[src*='turntable']"));
		UtilHBM.turnOnImplicitWaits(driver);
		if (!turntable.isEmpty() && isTurntableExpected) {
			UtilHBM.reportOK("Turntable displayed for first project in my projects page!! isTurntableExpected : "
					+ isTurntableExpected);
		} else if (!placeholder.isEmpty() && !isTurntableExpected) {
			UtilHBM.reportOK("Palceholder displayed for first project in my projects page!! isTurntableExpected : "
					+ isTurntableExpected);
		} else {
			UtilHBM.reportKO(
					"Turntable and placeholder not displayed for first project in my projects page!! isTurntableExpected : "
							+ isTurntableExpected);
		}
		String projectName = firstProject.findElement(By.cssSelector("div.content>a>div")).getText().trim();
		Verification.VerifyEquals("Wrong project name displayed for first project in my projects page!!", projectName,
				expectedProjectName);
		Verification.displayOfWebElement(firstProject.findElement(By.cssSelector("div.content>div.date")));
		return this;
	}
	
	public LandingPage logout(){
		if (userAvatar.isDisplayed()){			
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
			UtilHBM.waitFixTime(2000);
			UtilHBM.waitExplicitDisplayed(driver,userAvatar);
			Actions action = new Actions(driver);			
			action.moveToElement(userAvatar).build().perform();
			UtilHBM.waitExplicitClickable(driver, logout);
			logout.click();
//			action.moveToElement(logout).click().build().perform();	
			UtilHBM.reportOK("Logout success");					
			return PageFactory.initElements(driver, LandingPage.class);
		}else {
			UtilHBM.reportKO("Logout failed. User Name is not displayed");
		}					
		return PageFactory.initElements(driver, LandingPage.class);
	}
	
/*---------------------Following methods are used for mobile automation---------------------*/
	
	public ProjectPage openOwnProjectMobile(int index, String projectTitle) {
		List<WebElement> projectList = null;
		int i = 0;
		int success = 0;
		while (i < 5) {
			UtilHBM.waitFixTime(1000);
			UtilHBM.turnOffImplicitWaits(driver);
			projectList = driver.findElements(By.xpath(
					"//div[@class='grid-1-3 u-mbs']/div[starts-with(@class,'b-lazy card-project')]/div[@class='content']/a/div[normalize-space() = '"
							+ projectTitle + "']"));
			UtilHBM.turnOffImplicitWaits(driver);
			if (!projectList.isEmpty()) {
				success = 1;
				break;
			}
			UtilHBM.turnOffImplicitWaits(driver);
			boolean isMoreButtonAvailable = !moreButton.isEmpty();
			UtilHBM.turnOffImplicitWaits(driver);
			if (!isMoreButtonAvailable) {
				UtilHBM.reportInfo("More button not available!!");
				break;
			}
			clickMoreButtonMobile();
			i++;
		}
		if (success == 0) {
			UtilHBM.reportKO("Project not found!!");
		}
		projectList.get(index).click();
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".subHeader-title"));
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	public MyProjects clickMoreButtonMobile() {
		Actions actions = new Actions(driver);
		actions.moveToElement(moreButton.get(0)).build().perform();
		UtilHBM.waitExplicitClickable(driver, moreButton.get(0));
		moreButton.get(0).click();
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, projectThumbList.get(projectThumbList.size() - 1));
		return this;
	}
	
	public HeaderMenusMobile clickHeaderMenuMobile() {
	//			UtilHBM.waitFixTime(5000);
	//			UtilHBM.webElement(driver,".header-logo>img").click();
		UtilHBM.waitExplicitClickable(driver, headerMenuMobile);
	//			headerMenuMobile.click();
		new Actions(driver).moveToElement(headerMenuMobile, 0, 10).click().build().perform();
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, HeaderMenusMobile.class);
	}
	}
