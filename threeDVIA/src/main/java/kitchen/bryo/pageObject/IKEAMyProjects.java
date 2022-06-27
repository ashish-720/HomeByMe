package kitchen.bryo.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class IKEAMyProjects {
	WebDriver driver;
	public static int i = 0;

	public IKEAMyProjects(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = ".mod-overlay-container>div")
	private WebElement userOverlay;

	@FindBy(xpath = "//ul[@class='projects-list']/li[@class='project-list-item']")
	private List<WebElement> projectListItem;

	@FindBy(css = ".project-list-item>div>div>p>span[data-ui-selector='project-name']")
	private WebElement projectName;

	@FindBy(css = "button[data-ui-action='upload-project']")
	private WebElement ikeaLoadProjectButton;

	@FindBy(xpath = "//article[@class='mod-layer-my-projects mod-open']")
	private WebElement projectOverlay;

	@FindBy(css = ".mod-layer-my-projects.mod-open>div>main>header>div>button[data-ui-action='layer-close']")
	private WebElement closeProjectOverlay;

	@FindBy(css = "input[data-ui-selector='search-input']")
	private WebElement searchInput;

	@FindBy(css = "button[data-ui-action='submit-search']")
	private WebElement submitSearch;

	@FindBy(css = "p[class='no-results']")
	private WebElement noResults;

	@FindBy(xpath = "//ul[@class='projects-list']/li[@class='project-list-item']")
	private List<WebElement> listProject;

	@FindBy(css = "#login-button")
	private WebElement user;

	@FindBy(css = "div>span.state>ul>li>button[title='Delete']")
	private WebElement deleteProjectButton;

	@FindBy(css = "ul>li[class='project-list-item']>div>div[class='img']>img[src^='https://byme']")
	private WebElement projectImg;

	@FindBy(css = "ul>li[class='project-list-item']>div>div>p[class='desc']")
	private WebElement projectDesc;

	@FindBy(css = "ul>li[class='project-list-item']>div>div>p[class='date']")
	private WebElement projectDate;

	@FindBy(xpath = "//article[@class='mod-layer-my-projects mod-open']/div/main/header/div/button[@data-ui-action='layer-close']")
	private WebElement closeProjectList;
	
	
	private static int initialCount;

	public IKEAMyProjects myProjectPage() {
		UtilHBM.waitExplicitDisplayed(driver, projectOverlay);

		if (projectOverlay.isDisplayed()) {
			UtilHBM.reportOK("My Project Overlay displayed");
			UtilHBM.waitFixTime(1500);
			if (projectListItem.isEmpty()) {
				UtilHBM.reportKO("No project available");
			} else {
				
//				Verification.displayOfWebElement(projectName);
//				Verification.displayOfWebElement(projectDesc);
//				Verification.displayOfWebElement(projectDate);
				int initialCount = projectListItem.size();
				System.out.println("No of projects available " + initialCount);
				UtilHBM.reportOK("Number of projects available :" + initialCount);
				setProjectCount(initialCount);
			}

		}

		return this;
	}
	public IKEAMyProjects verifyDuplicateDelete(String option) {

		switch (option) {
		case "Duplicate":
			if (getProjectCount() == projectListItem.size() - 1) {
				UtilHBM.reportOK(
						"Project duplicated successfully and available projects are " + projectListItem.size());
				WebElement projID = listProject.get(0);
				UtilHBM.waitExplicitClickable(driver, projID);
				if (projID.findElement(By.xpath("div/div/img")).getAttribute("src").startsWith("https://")) {
					UtilHBM.reportOK(
							"Project Thumbnail displayed for duplicated project in my projects list and project name is "
									+ listProject.get(0).findElement(By.xpath("div/div/p[@class='name']")).getText());
					Verification.displayOfWebElement(projID.findElement(By.xpath("div/div/p[@class='name']")));
					Verification.displayOfWebElement(projID.findElement(By.xpath("div/div/p[@class='desc']")));
					Verification.displayOfWebElement(projID.findElement(By.xpath("div/div/p[@class='date']")));
				} else {
					UtilHBM.reportKO(
							"Project Thumbnail not displayed for duplicated project in my projects list and project name is "
									+ listProject.get(0).findElement(By.xpath("div/div/p[@class='name']")).getText());
				}
			} else
				UtilHBM.reportKO("Project not duplicated and  available projects are " + projectListItem.size());
			break;
		case "Delete":
			System.out.println("get count " + getProjectCount());
			System.out.println("pro count " + projectListItem.size());
			if (getProjectCount() == projectListItem.size() + 1) {
				UtilHBM.reportOK("Project deleted successfully and available projects are " + projectListItem.size());
			} else
				UtilHBM.reportKO("Project not deleted and available projects are " + projectListItem.size());
			break;
		default:
			UtilHBM.reportKO("Wrong option");
			break;
		}

		return PageFactory.initElements(driver, IKEAMyProjects.class);
	}

	public StartNow closeMyProjects() {
		UtilHBM.waitExplicitClickable(driver, closeProjectOverlay);
		closeProjectOverlay.click();
		return PageFactory.initElements(driver, StartNow.class);
	}

	public IKEAMyProjects duplicateFromProjectList(String projectIndex) {
		myProjectPage();
		if (projectIndex.contains("ID")) {
			String str = projectIndex.replaceAll("ID", "");
			int index = Integer.parseInt(str);
			WebElement projID = listProject.get(index);
			UtilHBM.waitExplicitClickable(driver, projID);
			new Actions(driver).moveToElement(listProject.get(index)).build().perform();
			WebElement dup = listProject.get(index)
					.findElement(By.xpath("div/div/span/ul/li/button[@data-ui-action='duplicate-project']"));
			UtilHBM.waitExplicitDisplayed(driver, dup);
			UtilHBM.waitExplicitClickable(driver, dup);
			new Actions(driver).moveToElement(dup).build().perform();
			dup.click();

		} else {
			WebElement name = driver
					.findElement(By.xpath("//div/div/p[@class='name']/span[contains(text(),'" + projectIndex + "')]"));
			new Actions(driver).moveToElement(name).build().perform();

			WebElement duplicateProjectButton = name.findElement(
					By.xpath("parent::p/parent::div/preceding-sibling::div/span/ul/li/button[@title='Duplicate']"));
			duplicateProjectButton.click();
		}
		return this;
	}

	
//	public MyProjects deleteFromProjectList(String projectIndex) {
//		myProjectPage();
//		if (projectIndex.contains("ID")) {
//			String str = projectIndex.replaceAll("ID", "");
//			int index = Integer.parseInt(str);
//			WebElement projID = listProject.get(index);
//			UtilHBM.waitExplicitDisplayed(driver, projID);
//			UtilHBM.waitExplicitClickable(driver, projID);
//			new Actions(driver).moveToElement(listProject.get(index)).build().perform();
//			WebElement del = listProject.get(index).findElement(By.xpath("div/div/span/ul/li/button[@title='Delete']"));
//			UtilHBM.waitExplicitDisplayed(driver, del);
//			UtilHBM.waitExplicitClickable(driver, del);
//			new Actions(driver).moveToElement(del).build().perform();
//			del.click();
//
//		} else {
//			WebElement name = driver
//					.findElement(By.xpath("//div/p[@class='name']/span[contains(text(),'" + projectIndex + "')]"));
//			new Actions(driver).moveToElement(name).build().perform();
//			WebElement del = name.findElement(
//					By.xpath("parent::p/parent::div/preceding-sibling::div/span/ul/li/button[@title='Delete']"));
//			new Actions(driver).moveToElement(del).click().build().perform();
//		}
//
//		return this;
//	}

	public ProjectDetailsPage searchProject(String projectName) {

		searchInput.click();
		searchInput.sendKeys(projectName);
		submitSearch.click();
		if (noResults.isDisplayed()) {
			UtilHBM.reportMsg("Given project not found");
		} else {
			openProjectDetailsPage(projectName);
		}
		return PageFactory.initElements(driver, ProjectDetailsPage.class);
	}

	public ProjectDetailsPage openProjectDetailsPage(String projectIndex) {

		if (projectIndex.contains("ID")) {
			System.out.println("ID..." + projectIndex);
			String str = projectIndex.replaceAll("ID", "");
			int index = Integer.parseInt(str);
			System.out.println("INDEX ID..." + index);
			WebElement projID = listProject.get(index);
			UtilHBM.waitExplicitClickable(driver, projID);
			new Actions(driver).moveToElement(listProject.get(index)).click().build().perform();
			UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("html[class='project-page js']")));
			UtilHBM.waitExplicitDisplayed(driver,
					driver.findElement(By.cssSelector(".project-editable-content-container")));
		} else {
			WebElement name = driver.findElement(
					By.xpath("//div/div/p[@class='name']/span[starts-with(text(),'" + projectIndex + "')]"));
			System.out.println("name " + name.getText());
			if (name.getText().equalsIgnoreCase(projectIndex)) {
				System.out.println("name " + name.getText());
				// name.sendKeys(Keys.ENTER);
				new Actions(driver).moveToElement(name).click().build().perform();
			}
		}
		return PageFactory.initElements(driver, ProjectDetailsPage.class);
	}

	public IKEAMyProjects ikeaDeleteProjectFromMyProjects(String projectIndex) {

//		deleteFromProjectList(projectIndex);
	myProjectPage();
		if (projectIndex.contains("ID")) {
			String str = projectIndex.replaceAll("ID", "");
			int index = Integer.parseInt(str);
			WebElement projID = listProject.get(index);
			UtilHBM.waitExplicitDisplayed(driver, projID);
			UtilHBM.waitExplicitClickable(driver, projID);
			new Actions(driver).moveToElement(listProject.get(index)).build().perform();
			WebElement del = listProject.get(index)
					.findElement(By.xpath("div/button[@data-ui-action='delete-project']"));
			try {

				new Actions(driver).moveToElement(del).build().perform();
				del.sendKeys(Keys.ENTER);
			} catch (StaleElementReferenceException e) {

				del = listProject.get(index)
						.findElement(By.xpath("div/button[@data-ui-action='delete-project']"));
				UtilHBM.waitExplicitDisplayed(driver, del);
				UtilHBM.waitExplicitClickable(driver, del);
				new Actions(driver).moveToElement(del).build().perform();
				del.sendKeys(Keys.ENTER);
			}

		} else {
			WebElement name = driver
					.findElement(By.xpath("//div/p/span[contains(text(),'" + projectIndex + "')]"));
			new Actions(driver).moveToElement(name).build().perform();
			WebElement del = name.findElement(
					By.xpath("parent::p/parent::div/following-sibling::div/button[@data-ui-action='delete-project']"));
			try {
				new Actions(driver).moveToElement(del).click().build().perform();
			} catch (StaleElementReferenceException e) {
				name = driver
						.findElement(By.xpath("//div/p/span[contains(text(),'" + projectIndex + "')]"));
				new Actions(driver).moveToElement(name).build().perform();
				del = name.findElement(
						By.xpath("parent::p/parent::div/following-sibling::div/button[@data-ui-action='delete-project']"));
				new Actions(driver).moveToElement(del).click().build().perform();
			}
		}

		UtilHBM.waitFixTime(3000);

		return PageFactory.initElements(driver, IKEAMyProjects.class);
	}

	public StartNow deleteProjectFromDetailsPage(String projectIndex) {
		myProjectPage();
		openProjectDetailsPage(projectIndex);
		ProjectDetailsPage details = PageFactory.initElements(driver, ProjectDetailsPage.class);
		details.deleteProject();
		UtilHBM.waitExplicitDisplayed(driver, user);
		return PageFactory.initElements(driver, StartNow.class);
	}

	public ProjectDetailsPage duplicateProjectFromMyProjects(String projectIndex, String name, String desc) {

		duplicateFromProjectList(projectIndex);
		Duplicate duplicate = PageFactory.initElements(driver, Duplicate.class);
		duplicate.duplicateProject(name, desc);
		return PageFactory.initElements(driver, ProjectDetailsPage.class);
	}

	public ProjectDetailsPage duplicateProjectFromDetailsPage(String projectNameToOpen, String projectName,
			String desc) {
		myProjectPage();
		openProjectDetailsPage(projectNameToOpen);
		ProjectDetailsPage details = PageFactory.initElements(driver, ProjectDetailsPage.class);
		details.duplicateProject(projectName, desc);

		return PageFactory.initElements(driver, ProjectDetailsPage.class);
	}

//	public MakeItYours ikeaOpenProjectFromMyProjects(String projectIndex) {
//		if (projectIndex.contains("ID")) {
//			String str = projectIndex.replaceAll("ID", "");
//			int index = Integer.parseInt(str);
//			WebElement projID = listProject.get(index);
//			UtilHBM.waitExplicitClickable(driver, projID);
//			new Actions(driver).moveToElement(listProject.get(index)).build().perform();
//			WebElement open = projID.findElement(By.cssSelector("button[data-ui-action='upload-project']"));
//			new Actions(driver).moveToElement(open).click().build().perform();
//
//		} else {
//			WebElement name = driver
//					.findElement(By.xpath("//div/p/span[contains(text(),'" + projectIndex + "')]"));
//			new Actions(driver).moveToElement(name).build().perform();
//			WebElement open = name
//					.findElement(By.xpath("parent::p/parent::div/following-sibling::div/button[@data-ui-action='upload-project']"));
//			new Actions(driver).moveToElement(open).click().build().perform();
//		}
//		new Actions(driver).moveToElement(ikeaLoadProjectButton).click().build().perform();
//		UtilHBM.waitFixTime(2000);
////		StartNow start=PageFactory.initElements(driver, StartNow.class);
////		start.ikeaSwitchFrame();
//		List<WebElement> frames = driver.findElements(By.cssSelector("#embedded-kitchen-app>iframe"));
//		driver.switchTo().frame(frames.get(0));
//		System.out.println("Frame: " + frames);
//		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".loader-container"));
//		UtilHBM.waitTillElementDisappear(driver, ".loader-container");
//		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver,
//				"//div[@id='main-app']/header/div/div/nav/ul/li[@class='current']/button[@id='step-design']"));
//		return PageFactory.initElements(driver, MakeItYours.class);
//	}

	
	public MakeItYours ikeaOpenProjectFromMyProjects(String projectName) {
//		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//article[@class='mod-layer-my-projects mod-open']")));
		UtilHBM.waitExplicitClickable(driver,
				UtilHBM.webElementXPath(driver, "//div[@class='text']/h3[text()='My projects']"));
		UtilHBM.waitExplicitDisplayed(driver, projectListItem.get(0));
		boolean isProjectAvailable = false;

		int a = 1;
		while (!(projectListItem.get(0).findElement(By.cssSelector("div>p>span[class='name']")).getText().equalsIgnoreCase(projectName))) {
			UtilHBM.turnOffImplicitWaits(driver);
			if (!projectListItem.get(0).findElement(By.cssSelector("div>p>span[class='name']")).getText()
					.equalsIgnoreCase(projectName)) {
				UtilHBM.waitFixTime(3000);
				UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
				UtilHBM.waitTillElementDisappear(driver,
						driver.findElement(By.cssSelector("div[class='mod-loader']>div>span>svg[aria-hidden='true']")));
				UtilHBM.waitFixTime(4000);
				a++;
			}
		}
		isProjectAvailable = true;
		WebElement proName = projectListItem.get(0).findElement(By.xpath(
				"//div/p/span[text()='" + projectName + "']/../../following-sibling::div[@class='actions']"));
		new Actions(driver).moveToElement(proName).build().perform();
		System.out.println(projectListItem.get(0)
				.findElement(By.xpath("//div/p/span[text()='" + projectName + "']")));
		WebElement openProjectBtn = proName.findElement(By.xpath("button[@data-ui-action='upload-project']"));
		openProjectBtn.click();
//		break;

//	}
		if (!isProjectAvailable) {
			UtilHBM.reportKO("Project Not Available");
		} else {

			driver.switchTo().parentFrame();
			UtilHBM.waitFixTime(1000);
			driver.switchTo().frame(
					UtilHBM.webElement(driver, "iframe[src*='https://preprod-staging-kitchen.ikea.by.me/Kitchen']"));
			UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".loader-container"));
			UtilHBM.waitTillElementDisappear(driver, ".loader-container");
			UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver,
					"//div[@id='main-app']/header/div/div/nav/ul/li[@class='current']/button[@id='step-design']"));
		}
		return PageFactory.initElements(driver, MakeItYours.class);
	}
	public void setProjectCount(int count) {
		
		System.out.println("set count" + count);
		initialCount = count;
	}

	public static Integer getProjectCount() {
		return initialCount;

	}
}