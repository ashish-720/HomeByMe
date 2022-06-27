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
import hr.web.pageObject.MyProject;

public class MyProjects {
	WebDriver driver;
	public static int i = 0;

	public MyProjects(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = ".mod-overlay-container>div")
	private WebElement userOverlay;

	@FindBy(xpath = "//li[@class='project-list-item new-project']")
	private WebElement newProject;

	@FindBy(css = "article.mod-layer-my-projects.mod-open ul.projects-list>li[class='project-list-item']")
	private List<WebElement> projectListItem;

	@FindBy(css = ".project-list-item>div>div>p>span[data-ui-selector='project-name']")
	private WebElement projectName;

	@FindBy(css = "div>span.state>button[title='Open']")
	private WebElement openProjectButton;

	@FindBy(xpath = "//article[@class='mod-layer-my-projects mod-open']")
	private WebElement projectOverlay;

	@FindBy(css = "button[data-ui-action='layer-iframe-close']")
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

	@FindBy(css = "ul>li[class='project-list-item']>div>div[class='img']>div>img[src^='https://byme']")
	private WebElement projectImg;

	@FindBy(css = "ul>li[class='project-list-item']>div>div>p[class='desc']")
	private WebElement projectDesc;

	@FindBy(css = "ul>li[class='project-list-item']>div>div>p[class='date']")
	private WebElement projectDate;

	@FindBy(xpath = "//article[@class='mod-layer-my-projects mod-open']/div/main/header/div/button[@data-ui-action='layer-close']")
	private WebElement closeProjectList;

	@FindBy(css = ".mod-pagination>ul>li>button")
	private List<WebElement> paginationList;

	private static int initialCount;

	public MyProjects myProjectPage() {
//		UtilHBM.waitExplicitDisplayed(driver, projectOverlay);
//		UtilHBM.reportOK("My Project Overlay displayed");
//		UtilHBM.waitFixTime(1500);
		if (projectListItem.isEmpty()) {
			UtilHBM.reportKO("No project available");
		} else {
			UtilHBM.waitExplicitDisplayed(driver,
					driver.findElement(By.xpath("//ul/li[@class='project-list-item new-project']")));
			Verification.displayOfWebElement(projectImg);
			Verification.displayOfWebElement(projectName);
//			Verification.displayOfWebElement(projectDesc);
			Verification.displayOfWebElement(projectDate);
			int initialCount = projectListItem.size();
			System.out.println("No of projects available " + initialCount);
			UtilHBM.reportOK("Number of projects available :" + initialCount);
			setProjectCount(initialCount);
		}
		return this;
	}

	public MyProjects verifyDuplicateDelete(String option) {

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
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		return PageFactory.initElements(driver, MyProjects.class);
	}

	public StartNow closeMyProjects() {
//		UtilHBM.waitExplicitClickable(driver, closeProjectOverlay);
		closeProjectOverlay.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, StartNow.class);
	}

	public MyProjects duplicateFromProjectList(String projectIndex) {
		myProjectPage();
		if (projectIndex.contains("ID")) {
			String str = projectIndex.replaceAll("ID", "");
			int index = Integer.parseInt(str);
			WebElement projID = listProject.get(index);
			UtilHBM.waitExplicitClickable(driver, projID);
			new Actions(driver).moveToElement(listProject.get(index)).build().perform();
			WebElement dup = listProject.get(index)
					.findElement(By.xpath("div/div/span/ul/li/button[@data-ui-action='duplicate-project']"));
			UtilHBM.waitExplicitDisplayed(driver,
					driver.findElement(By.cssSelector("div[class='project-main-image']>div>img[src*='https']")));
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
			UtilHBM.waitExplicitDisplayed(driver,
					driver.findElement(By.cssSelector("div[class='project-main-image']>div>img[src*='https']")));
			duplicateProjectButton.click();
		}
		return this;
	}

	public MyProjects openProjectFromProjectList(String projectIndex) {

		if (projectIndex.contains("ID")) {
			String str = projectIndex.replaceAll("ID", "");
			int index = Integer.parseInt(str);
			WebElement projID = listProject.get(index);
			UtilHBM.waitExplicitClickable(driver, projID);
			new Actions(driver).moveToElement(listProject.get(index)).build().perform();
			WebElement open = projID.findElement(By.cssSelector("span>button[title='Open']"));
			new Actions(driver).moveToElement(open).click().build().perform();

		} else {
			WebElement name = driver
					.findElement(By.xpath("//div/p[@class='name']/span[contains(text(),'" + projectIndex + "')]"));
			new Actions(driver).moveToElement(name).build().perform();
			WebElement open = name
					.findElement(By.xpath("parent::p/parent::div/preceding-sibling::div/span/button[@title='Open']"));
			new Actions(driver).moveToElement(open).click().build().perform();
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

	public MyProjects searchProject(String projectName) {

		UtilHBM.waitExplicitDisplayed(driver,
				driver.findElement(By.xpath("//ul/li[@class='project-list-item new-project']")));
		Verification.displayOfWebElement(projectImg);
		Verification.displayOfWebElement(this.projectName);
		Verification.displayOfWebElement(projectDate);
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("ul>li[class='project-list-item']")));
		searchInput.click();
		System.out.println("length:" + searchInput.getAttribute("value").length());
		if (searchInput.getAttribute("value").length() == 0) {
			searchInput.sendKeys(projectName);
		} else {
			searchInput.click();
			searchInput.clear();
			searchInput.sendKeys(projectName);
		}

		submitSearch.click();
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitTillElementDisappear(driver,
				driver.findElement(By.cssSelector("div[class='mod-loader']>div>span>svg[aria-hidden='true']")));
		UtilHBM.waitFixTime(4000);
		List<WebElement> projectList = driver.findElements(By.xpath("//div/p[@class='name']/span[starts-with(text(),'"
				+ projectName + "')]/ancestor::div[@class='inner-content']"));
		UtilHBM.waitExplicitClickable(driver, projectList.get(0));

//		if (noResults.isDisplayed()) {
//			UtilHBM.reportMsg("Given project not found");
//		} else {
//			openProjectDetailsPage(projectName);
//		}
		return PageFactory.initElements(driver, MyProjects.class);
	}

	public ProjectDetailsPage openProjectDetailsPage(String projectIndex) {

		if (projectIndex.contains("ID")) {
			System.out.println("ID..." + projectIndex);
			String str = projectIndex.replaceAll("ID", "");
			int index = Integer.parseInt(str);
			System.out.println("INDEX ID..." + index);
			WebElement projID = listProject.get(index);
			UtilHBM.waitExplicitClickable(driver, projID);
			listProject.get(index).click();
//			new Actions(driver).moveToElement(listProject.get(index)).click().build().perform();
			UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("html[class='project-page js']")));
			UtilHBM.waitExplicitDisplayed(driver,
					driver.findElement(By.cssSelector(".project-editable-content-container")));
		} else {
			WebElement name = driver.findElement(
					By.xpath("//div/div/p[@class='name']/span[starts-with(text(),'" + projectIndex + "')]"));
			System.out.println("name " + name.getText());
			if (name.getText().equalsIgnoreCase(projectIndex)) {
				System.out.println("name " + name.getText());
				name.click();
				// name.sendKeys(Keys.ENTER);
//				new Actions(driver).moveToElement(name).click().build().perform();
			}
		}
		return PageFactory.initElements(driver, ProjectDetailsPage.class);
	}

	public MyProjects deleteProjectFromMyProjects(int index, String projectTitle) {

//		deleteFromProjectList(projectIndex);
		myProjectPage();
//		if (projectIndex.contains("ID")) {
//			String str = projectIndex.replaceAll("ID", "");
//			int index = Integer.parseInt(str);
//			WebElement projID = listProject.get(index);
//			UtilHBM.waitExplicitDisplayed(driver, projID);
//			UtilHBM.waitExplicitClickable(driver, projID);
//			new Actions(driver).moveToElement(listProject.get(index)).build().perform();
//			WebElement del = listProject.get(index)
//					.findElement(By.xpath("div/div/span/ul/li/button[@data-ui-action='delete-project']"));
//			try {
//
//				new Actions(driver).moveToElement(del).build().perform();
//				del.sendKeys(Keys.ENTER);
//			} catch (StaleElementReferenceException e) {
//
//				del = listProject.get(index)
//						.findElement(By.xpath("div/div/span/ul/li/button[@data-ui-action='delete-project']"));
//				UtilHBM.waitExplicitDisplayed(driver, del);
//				UtilHBM.waitExplicitClickable(driver, del);
//				new Actions(driver).moveToElement(del).build().perform();
//				del.sendKeys(Keys.ENTER);
//			}
//
//		} else {
		Boolean projectTitleCheck = false;
		List<WebElement> name = driver
				.findElements(By.xpath("//div/p[@class='name']/span[contains(text(),'" + projectTitle + "')]"));
		if (driver.findElements(By.xpath("//div/p[@class='name']/span[contains(text(),'" + projectTitle + "')]"))
				.size() > 1) {
int beforeDelete=driver.findElements(By.xpath("//div/p[@class='name']/span[contains(text(),'" + projectTitle + "')]"))
.size();
System.out.println("Before delete :"+beforeDelete +"and project name is :" +projectTitle);
			projectTitleCheck = true;

			new Actions(driver).moveToElement(name.get(index)).build().perform();
			WebElement del = name.get(index).findElement(
					By.xpath("parent::p/parent::div/preceding-sibling::div/span/ul/li/button[@title='Delete']"));
			try {
				new Actions(driver).moveToElement(del).build().perform();
				UtilHBM.waitFixTime(500);
//				UtilHBM.waitExplicitDisplayed(driver, del);
				UtilHBM.waitExplicitClickable(driver, del);
				del.click();
//				new Actions(driver).moveToElement(del).clickAndHold().build().perform();
			} catch (StaleElementReferenceException e) {
				name = driver
						.findElements(By.xpath("//div/p[@class='name']/span[contains(text(),'" + projectTitle + "')]"));
				new Actions(driver).moveToElement(name.get(index)).build().perform();
				del = name.get(index).findElement(
						By.xpath("parent::p/parent::div/preceding-sibling::div/span/ul/li/button[@title='Delete']"));
				new Actions(driver).moveToElement(del).build().perform();
				UtilHBM.waitFixTime(500);
				UtilHBM.waitExplicitDisplayed(driver, del);
				UtilHBM.waitExplicitClickable(driver, del);
				del.click();
//				new Actions(driver).moveToElement(del).clickAndHold().build().perform();
			}

//		}
			DeleteProjectConfirmation confirmation = PageFactory.initElements(driver, DeleteProjectConfirmation.class);
			confirmation.yes();
			UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
			UtilHBM.waitFixTime(3000);
			UtilHBM.waitExplicitDisplayed(driver,
					driver.findElement(By.xpath("//li[@class='project-list-item']/div/div[@class='img']")));
			int afterDelete=driver.findElements(By.xpath("//div/p[@class='name']/span[contains(text(),'" + projectTitle + "')]"))
					.size();
			System.out.println("After Delete :" +afterDelete +"and project name is :" +projectTitle);
			if(afterDelete==beforeDelete-1) {
				UtilHBM.reportOK("Project deleted successfully");
			}else {UtilHBM.reportKO("Project not deleted");}
		}

		if (projectTitleCheck == false) {
			UtilHBM.reportMsg("Given project name: " + name + " not found in the list");
		}

		return PageFactory.initElements(driver, MyProjects.class);
	}

	public StartNow deleteProjectFromDetailsPage(String projectIndex) {
		myProjectPage();
		openProjectDetailsPage(projectIndex);
		ProjectDetailsPage details = PageFactory.initElements(driver, ProjectDetailsPage.class);
		details.deleteProject();
		UtilHBM.waitExplicitDisplayed(driver, user);
		return PageFactory.initElements(driver, StartNow.class);
	}

//	public MyProjects duplicateProjectFromMyProjects(String projectIndex, String name, String desc) {
//
//		duplicateFromProjectList(projectIndex);
//		Duplicate duplicate = PageFactory.initElements(driver, Duplicate.class);
//		duplicate.duplicateProject(name, desc);
//		return PageFactory.initElements(driver, MyProjects.class);
//	}
	public MyProjects duplicateProject(String projectName, int index) {

		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitExplicitClickable(driver,
				UtilHBM.webElementXPath(driver, "//div[@class='text']/h2[text()='My projects']"));
		UtilHBM.waitExplicitDisplayed(driver, projectListItem.get(0));
		boolean isProjectAvailable = false;

		int a = 1;
		while (!(projectListItem.get(0).findElement(By.cssSelector("div>div>p.name")).getText()
				.equalsIgnoreCase(projectName)) && a < paginationList.size()) {
			UtilHBM.turnOffImplicitWaits(driver);
			if (!projectListItem.get(0).findElement(By.cssSelector("div>div>p.name")).getText()
					.equalsIgnoreCase(projectName)) {
				Actions action = new Actions(driver);
				action.moveToElement(paginationList.get(a)).click().build().perform();
				UtilHBM.waitFixTime(3000);
				UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
				UtilHBM.waitTillElementDisappear(driver,
						driver.findElement(By.cssSelector("div[class='mod-loader']>div>span>svg[aria-hidden='true']")));
				UtilHBM.waitFixTime(4000);
				a++;
			}
		}

//	for(WebElement a:projectListItem) {
//		UtilHBM.waitExplicitDisplayed(driver, a.findElement(By.cssSelector("div>div>p.name")));
//		int x=1;
//		if(paginationList.size()>0 &&paginationList.get(0).isDisplayed()){	
//			if(!projectListItem.get(0).findElement(By.cssSelector("div>div>p.name")).getText().equalsIgnoreCase(projectName)) {
//			Actions action=new Actions(driver);
//			action.moveToElement(paginationList.get(x)).click().build().perform();
//			UtilHBM.waitFixTime(3000);
//			UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
//			UtilHBM.waitTillElementDisappear(driver, driver.findElement(By.cssSelector("div[class='mod-loader']>div>span>svg[aria-hidden='true']")));
//			UtilHBM.waitFixTime(4000);
//			x++;	
//			}
//		}
		isProjectAvailable = true;
		WebElement projectToDuplicate = driver
				.findElements(
						By.xpath("//div//span[text()='" + projectName + "']/ancestor::div[@class='inner-content']"))
				.get(index);
		UtilHBM.waitExplicitClickable(driver, projectToDuplicate);
		new Actions(driver).moveToElement(projectToDuplicate).build().perform();
		WebElement duplicateBtn = projectToDuplicate.findElement(By.xpath("div/span/ul/li/button[@title='Duplicate']"));
		UtilHBM.waitExplicitDisplayed(driver, duplicateBtn);
		Verification.displayOfWebElement(duplicateBtn);
		duplicateBtn.click();
//		break;
//	
//	}
		UtilHBM.waitFixTime(5000);
		UtilHBM.waitExplicitDisplayed(driver,
				driver.findElement(By.xpath("//li[@class='project-list-item']/div/div[@class='img']")));
		UtilHBM.waitExplicitClickable(driver, UtilHBM.webElement(driver, "li>div>span>.icon-action-zoom"));

		return PageFactory.initElements(driver, MyProjects.class);

	}

	public ProjectDetailsPage duplicateProjectFromDetailsPage(String projectNameToOpen, String projectName,
			String desc) {
		myProjectPage();
		openProjectDetailsPage(projectNameToOpen).duplicateProject(projectName, desc);
		return PageFactory.initElements(driver, ProjectDetailsPage.class);
	}

//	public MakeItYours openProjectFromMyProjects(String projectIndex) {
//		driver.switchTo().frame(0);
//		openProjectFromProjectList(projectIndex);
//		UtilHBM.waitFixTime(1000);
////		new Actions(driver).moveToElement(openProjectButton).click().build().perform();
//		FloorPlan plan = PageFactory.initElements(driver, FloorPlan.class);
//		plan.switchFrameAfterReOpeningProject();
//		return PageFactory.initElements(driver, MakeItYours.class);
//	}

	public FloorPlan createNewProjectFromMyProjectsList() {
		UtilHBM.waitExplicitDisplayed(driver, newProject);
		UtilHBM.waitExplicitClickable(driver, newProject);
		newProject.click();
		driver.switchTo().parentFrame();
		UtilHBM.waitFixTime(1000);
		driver.switchTo().frame(
				UtilHBM.webElement(driver, "iframe[src*='https://preprod-kitchen.enterprise-dev.by.me/Kitchen']"));
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".loader-container"));
		UtilHBM.waitTillElementDisappear(driver, ".loader-container");
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver,
				"//div[@id='main-app']/header/div/div/nav/ul/li/button[@id='step-floorplan']"));
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public MakeItYours openProject(int index, String projectName) {
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitExplicitClickable(driver,
				UtilHBM.webElementXPath(driver, "//div[@class='text']/h2[text()='My projects']"));
		UtilHBM.waitExplicitDisplayed(driver, newProject);
		Verification.VerifyEquals("New Project plus icon not distinguishable...", newProject
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"../Shared/icons/icons.svg#icon-action-zoom");
		Verification.VerifyEquals("New Project Text not correct", newProject.getText(), "New Project");
		UtilHBM.waitExplicitDisplayed(driver, projectListItem.get(0));
		boolean isProjectAvailable = false;

		int a = 1;
		while (!(projectListItem.get(0).findElement(By.cssSelector("div>div>p.name")).getText()
				.equalsIgnoreCase(projectName)) && a < paginationList.size()) {
			UtilHBM.turnOffImplicitWaits(driver);
			if (!projectListItem.get(0).findElement(By.cssSelector("div>div>p.name")).getText()
					.equalsIgnoreCase(projectName)) {
				Actions action = new Actions(driver);
				action.moveToElement(paginationList.get(a)).click().build().perform();
				UtilHBM.waitFixTime(3000);
				UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
				UtilHBM.waitTillElementDisappear(driver,
						driver.findElement(By.cssSelector("div[class='mod-loader']>div>span>svg[aria-hidden='true']")));
				UtilHBM.waitFixTime(4000);
				a++;
			}
		}

//	for(WebElement a:projectListItem) {
//		UtilHBM.waitExplicitDisplayed(driver, a.findElement(By.cssSelector("div>div>p.name")));
//		int x=1;
//		if(paginationList.size()>0 &&paginationList.get(0).isDisplayed()){	
//			if(!projectListItem.get(0).findElement(By.cssSelector("div>div>p.name")).getText().equalsIgnoreCase(projectName)) {
//			Actions action=new Actions(driver);
//			action.moveToElement(paginationList.get(x)).click().build().perform();
//			UtilHBM.waitFixTime(3000);
//			UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
//			UtilHBM.waitTillElementDisappear(driver, driver.findElement(By.cssSelector("div[class='mod-loader']>div>span>svg[aria-hidden='true']")));
//			UtilHBM.waitFixTime(4000);
//			x++;	
//			}
//		}
		isProjectAvailable = true;
		WebElement proName = projectListItem.get(0).findElement(By.xpath(
				"//div/div/p[@class='name']/span[text()='" + projectName + "']/ancestor::div[@class='inner-content']"));
		new Actions(driver).moveToElement(proName).build().perform();
		System.out.println(projectListItem.get(0)
				.findElement(By.xpath("//div/div/p[@class='name']/span[text()='" + projectName + "']")));
		WebElement openProjectBtn = proName.findElement(By.xpath("div/span/button[@title='Open']"));
		openProjectBtn.click();
//		break;

//	}
		if (!isProjectAvailable) {
			UtilHBM.reportKO("Project Not Available");
		} else {

			driver.switchTo().parentFrame();
			UtilHBM.waitFixTime(1000);
			driver.switchTo().frame(
					UtilHBM.webElement(driver, "iframe[src*='https://preprod-kitchen.enterprise-dev.by.me/Kitchen']"));
			UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".loader-container"));
			UtilHBM.waitTillElementDisappear(driver, ".loader-container");
			UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver,
					"//div[@id='main-app']/header/div/div/nav/ul/li[@class='current']/button[@id='step-design']"));
		}
		return PageFactory.initElements(driver, MakeItYours.class);
	}
	public MakeItYours openProjectStaging(int index, String projectName) {
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitExplicitClickable(driver,
				UtilHBM.webElementXPath(driver, "//div[@class='text']/h2[text()='My projects']"));
		UtilHBM.waitExplicitDisplayed(driver, newProject);
		Verification.VerifyEquals("New Project plus icon not distinguishable...", newProject
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"../Shared/icons/icons.svg#icon-action-zoom");
		Verification.VerifyEquals("New Project Text not correct", newProject.getText(), "New Project");
		UtilHBM.waitExplicitDisplayed(driver, projectListItem.get(0));
		boolean isProjectAvailable = false;

		int a = 1;
		while (!(projectListItem.get(0).findElement(By.cssSelector("div>div>p.name")).getText()
				.equalsIgnoreCase(projectName)) && a < paginationList.size()) {
			UtilHBM.turnOffImplicitWaits(driver);
			if (!projectListItem.get(0).findElement(By.cssSelector("div>div>p.name")).getText()
					.equalsIgnoreCase(projectName)) {
				Actions action = new Actions(driver);
				action.moveToElement(paginationList.get(a)).click().build().perform();
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
				"//div/div/p[@class='name']/span[text()='" + projectName + "']/ancestor::div[@class='inner-content']"));
		new Actions(driver).moveToElement(proName).build().perform();
		System.out.println(projectListItem.get(0)
				.findElement(By.xpath("//div/div/p[@class='name']/span[text()='" + projectName + "']")));
		WebElement openProjectBtn = proName.findElement(By.xpath("div/span/button[@title='Open']"));
		openProjectBtn.click();
		if (!isProjectAvailable) {
			UtilHBM.reportKO("Project Not Available");
		} else {
			driver.switchTo().parentFrame();
			UtilHBM.waitFixTime(1000);
			driver.switchTo().frame(
					UtilHBM.webElement(driver, "iframe[src*='https://preprod-staging-kitchen.enterprise-dev.by.me/Kitchen']"));
			UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".loader-container"));
			UtilHBM.waitTillElementDisappear(driver, ".loader-container");
			UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver,
					"//div[@id='main-app']/header/div/div/nav/ul/li[@class='current']/button[@id='step-design']"));
		}
		return PageFactory.initElements(driver, MakeItYours.class);
	}
	public void setProjectCount(int count) {
//		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitExplicitDisplayed(driver, projectName);
		System.out.println("set count" + count);
		initialCount = count;
	}

	public static Integer getProjectCount() {
		return initialCount;

	}
	public MakeItYours openProjectMobile(int index, String projectName) {
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitExplicitClickable(driver,
				UtilHBM.webElementXPath(driver, "//div[@class='text']/h2[text()='My projects']"));
		UtilHBM.waitExplicitDisplayed(driver, newProject);
		Verification.VerifyEquals("New Project plus icon not distinguishable...", newProject
				.findElement(By.xpath(".//*[local-name()='svg']/*[local-name()='use']")).getAttribute("xlink:href"),
				"../Shared/icons/icons.svg#icon-action-zoom");
		Verification.VerifyEquals("New Project Text not correct", newProject.getText(), "New Project");
		UtilHBM.waitExplicitDisplayed(driver, projectListItem.get(0));
		boolean isProjectAvailable = false;
		int a = 1;
		while (!(projectListItem.get(0).findElement(By.cssSelector("div>div>p.name")).getText()
				.equalsIgnoreCase(projectName)) && a < paginationList.size()) {
			UtilHBM.turnOffImplicitWaits(driver);
			if (!projectListItem.get(0).findElement(By.cssSelector("div>div>p.name")).getText()
					.equalsIgnoreCase(projectName)) {
				Actions action = new Actions(driver);
				action.moveToElement(paginationList.get(a)).click().build().perform();
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
				"//div/div/p[@class='name']/span[text()='" + projectName + "']/ancestor::div[@class='inner-content']"));
		new Actions(driver).moveToElement(proName).build().perform();
		System.out.println(projectListItem.get(0)
				.findElement(By.xpath("//div/div/p[@class='name']/span[text()='" + projectName + "']")));
		WebElement openProjectBtn = proName.findElement(By.xpath("div/span/button[@title='Open']"));
		openProjectBtn.click();
		if (!isProjectAvailable) {
			UtilHBM.reportKO("Project Not Available");
		} else {

			driver.switchTo().parentFrame();
			UtilHBM.waitFixTime(1000);
			driver.switchTo().frame(
					UtilHBM.webElement(driver, "iframe[src*='https://preprod-kitchen.enterprise-dev.by.me/Kitchen']"));
			UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".loader-container"));
			UtilHBM.waitTillElementDisappear(driver, ".loader-container");
			UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver,
					"//div[@class='step-3']/h2[contains(text(),'Design your kitchen')]"));
		}
		return PageFactory.initElements(driver, MakeItYours.class);
	}
}