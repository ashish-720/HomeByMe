package kitchen.bryo.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import hbm.web.pageobject.ProjectPage;
import hr.planner.pageObject.HomePlanner;

public class ProjectDetailsPage {
	WebDriver driver;
	public static int renderingImagesInfo;
	public static int twoDPlanImagesInfo;

	public ProjectDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//div[@class='project-infos']/div/div/textarea[@class='title editable-content']")
	private WebElement projectName;

	@FindBy(xpath = "//div[@class='project-infos']/div/div/textarea[@data-ui-action='modify-description']")
	private WebElement projectDesc;

//	@FindBy(xpath = "//section[@class='right-content']/div/div/button[@data-ui-action='open-project']/span[text()='Open project']")
//	private WebElement openProjectButton;

	@FindBy(xpath = "//button[@data-ui-action='upload-project']")
	private WebElement openProjectButton;
	
	@FindBy(xpath = "//section[@class='right-content']/div/div/button[@data-ui-action='duplicate-project']/span[text()='Duplicate']")
	private WebElement duplicateProjectButton;

	@FindBy(xpath = "//section[@class='right-content']/div/div/button[@data-ui-action='delete-project']/span[text()='Delete']")
	private WebElement deleteProjectButton;

	@FindBy(css = ".project-images")
	private List<WebElement> projectImages;

	@FindBy(xpath = "//div[@class='project-images']/div/div[@class='img-container']")
	private List<WebElement> renderingImages;

	@FindBy(xpath = "//div[@class='project-images']/div/div[@class='img-container']/img[contains(@src,'hqrenders.jpg')]")
	private List<WebElement> inProgressImages;

	@FindBy(xpath = "//div[@class='project-images']/div/div[@class='img-container']/img[starts-with(@src,'https')]")
	private List<WebElement> generatedImages;

	@FindBy(id = "plan2D-container")
	private List<WebElement> plan2DContainer;

	@FindBy(xpath = "//div[@id='plan2D-container']/div/div[@class='img-container']/img[starts-with(@src, 'https')]")
	private List<WebElement> plan2DImages;

	@FindBy(xpath = "//div[@class='project-notes']/div/div[@class='project-editable-content']/textarea")
	private List<WebElement> addNote;

	@FindBy(xpath = "//div[@class='project-notes']/div/div/textarea[@data-ui-action='modify-notes']")
	private WebElement note;

	@FindBy(xpath = "//div[@class='project-notes']/div/div/button[@data-ui-action='save']")
	private WebElement saveNote;

	@FindBy(xpath = "//b[@data-ui-error='error-message']")
	private List<WebElement> notesError;

	@FindBy(xpath = "//article[@class='mod-layer-my-projects mod-open']")
	private WebElement projectOverlay;

	@FindBy(css = ".mod-layer-my-projects.mod-open>div>main>header>div>button[data-ui-action='layer-close']")
	private WebElement closeProjectOverlay;

	@FindBy(xpath = "//div[@class='project-infos']/div/div/textarea[@class='editable-content']/following-sibling::button[@class='bt-icon-valid']")
	private WebElement cancelDesc;

	@FindBy(xpath = "//div[@class='project-infos']/div/div/textarea[@class='editable-content']/following-sibling::button[@class='bt-icon-valid']")
	private WebElement validDesc;

	@FindBy(xpath = "//div[@class='plan-info']/span/following-sibling::span[contains(text(),'TopPlan')]")
	private List<WebElement> topPlanImages;

	@FindBy(xpath = "//div[@class='plan-info']/span/following-sibling::span[contains(text(),'FacePlan')]")
	private List<WebElement> facePlanImages;

	@FindBy(xpath = "//div[@class='plan-info']/span/following-sibling::span[contains(text(),'Worktop')]")
	private List<WebElement> worktopPlanImages;

	@FindBy(xpath = "//div[@class='plan-info']/span/following-sibling::span[contains(text(),'Wall Panel')]")
	private List<WebElement> wallPanelPlanImages;

	@FindBy(xpath = "//main/article[@class='mod-layer-image-zoom mod-open']/div/main/footer/div/a")
	private WebElement downloadButton;

	@FindBy(xpath = "//main/article[@class='mod-layer-image-zoom mod-open']/div/main/footer/div/button")
	private WebElement printButton;

	@FindBy(css=".mod-layer-image-zoom.mod-open .bt-icon-light>.icon-view-close")
	private WebElement closeZoomInImage;
	
	@FindBy(css=".bt-icon.logged")
	private WebElement user;

	@FindBy(css = ".mod-overlay-container.mod-open ul>li>button[data-ui-action='open-projects-from-user-menu']")
	private WebElement myProjects;

	public ProjectDetailsPage duplicateProject(String name, String desc) {
		UtilHBM.waitExplicitDisplayed(driver, projectName);	
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("div[class='project-main-image']>div>img[src*='https']")));
		UtilHBM.waitExplicitDisplayed(driver, duplicateProjectButton);
		UtilHBM.waitExplicitClickable(driver, duplicateProjectButton);
		UtilHBM.waitFixTime(1000);
		duplicateProjectButton.click();
		Duplicate duplicate = PageFactory.initElements(driver, Duplicate.class);
		duplicate.duplicateProject(name, desc);
		return PageFactory.initElements(driver, ProjectDetailsPage.class);

	}

	public DeleteProjectConfirmation deleteProject() {
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, projectName);
		System.out.println("proj name " + projectName.getText());
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, deleteProjectButton);
		UtilHBM.waitExplicitClickable(driver, deleteProjectButton);
		new Actions(driver).moveToElement(deleteProjectButton).build().perform();
		deleteProjectButton.click();
		DeleteProjectConfirmation confirm=PageFactory.initElements(driver, DeleteProjectConfirmation.class);
		confirm.yes();
		return PageFactory.initElements(driver, DeleteProjectConfirmation.class);
	}

//	public MakeItYours openProject() {
////		UtilHBM.waitTillElementDisappear(driver, ".mod-layer-my-projects");
//		UtilHBM.waitExplicitDisplayed(driver, openProjectButton);
//		UtilHBM.waitExplicitClickable(driver, openProjectButton);
//		UtilHBM.waitFixTime(1000);
//		new Actions(driver).moveToElement(openProjectButton).build().perform();
//		openProjectButton.click();
////		new Actions(driver).moveToElement(openProjectButton).build().perform();
////		openProjectButton.sendKeys(Keys.ENTER);
//		FloorPlan plan = PageFactory.initElements(driver, FloorPlan.class);
//		plan.switchFrameAfterReOpeningProject();
//		return PageFactory.initElements(driver, MakeItYours.class);
//	}
public MakeItYours openProject(String projectName, int index) {
		
		UtilHBM.waitExplicitClickable(driver, UtilHBM.webElementXPath(driver, "//div[@class='text']/h2[text()='My projects']"));
		List<WebElement> projectToOpen = driver.findElements(By.xpath("//div/p/span[contains(text(),'"+projectName+"')]/ancestor::div[@class='inner-content']"));
		System.out.println("pro index:" +projectToOpen.get(index).getText());
		UtilHBM.waitExplicitClickable(driver, projectToOpen.get(index));
		new Actions(driver).moveToElement(projectToOpen.get(index)).build().perform();
		WebElement openProjectBtn = projectToOpen.get(index).findElement(By.xpath("div/span/button[@title='Open']"));
//		UtilHBM.waitExplicitDisplayed(driver, openProjectBtn);
//		new Actions(driver).moveToElement(openProjectBtn).build().perform();
		openProjectBtn.click();
		UtilHBM.waitFixTime(1000);
		driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src*='https://preprod-kitchen.enterprise-dev.by.me/Kitchen']"));
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".loader-container"));
		UtilHBM.waitTillElementDisappear(driver, ".loader-container");
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver, "//div[@id='main-app']/header/div/div/nav/ul/li/button[@id='step-floorplan']"));
		
		return PageFactory.initElements(driver, MakeItYours.class);
	}
	public ProjectDetailsPage verifyDuplicatedProOnDetailsPage(int noOfHQRenderImages,int noOf2DPlanImages) {
//		UtilHBM.waitFixTime(3500);
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector(".title.editable-content")));
		UtilHBM.waitExplicitClickable(driver, driver.findElement(By.cssSelector(".title.editable-content")));
		if ((driver.findElement(By.xpath("//section[@class='left-content']/div[@class='project-main-image']/div/img")))
				.getAttribute("src").startsWith("https://byme")) {
			UtilHBM.reportInfo("Project Thumbnail displayed for duplicated project");
		}
		verifyMediaOnProjectPage(noOfHQRenderImages, noOf2DPlanImages);
		UtilHBM.reportOK(
				"Duplicated project name : " + driver.findElement(By.cssSelector(".title.editable-content")).getText());
		return PageFactory.initElements(driver, ProjectDetailsPage.class);
	}

	public ProjectDetailsPage verifyProjectDetails() {
		Verification.displayOfWebElement(projectName);
		Verification.displayOfWebElement(projectDesc);
		Verification
				.displayOfWebElement(driver.findElement(By.xpath("//div[@class='project-infos']/h4[@class='tt-4']")));
		Verification
				.displayOfWebElement(driver.findElement(By.xpath("//div[@class='project-infos']/h4[@class='tt-4']")));
		Verification.displayOfWebElement(
				driver.findElement(By.xpath("//div[@class='project-infos']/div[@class='project-actions']")));
//		verifyRealisticImages();
//		verify2DPlanImages();
		return PageFactory.initElements(driver, ProjectDetailsPage.class);
	}

	public ProjectDetailsPage modificationsOnProjectPage(String desc, String noteText) {
		verifyProjectDetails();
		projectNameAndDesc(desc);
		notes(noteText);
		return PageFactory.initElements(driver, ProjectDetailsPage.class);
	}

	public ProjectDetailsPage verifyAddNotes(String addNotes) {

		UtilHBM.waitFixTime(500);
		if (note.getAttribute("value").equalsIgnoreCase(addNotes)) {
			UtilHBM.reportOK("Verification for add notes passed and note is : "+note.getText());
		} else {
			UtilHBM.reportKO("Verification for add notes failed and note is :"+note.getText() +".."+note.getAttribute("value"));
		}
		return PageFactory.initElements(driver, ProjectDetailsPage.class);
	}
	
	public ProjectDetailsPage projectNameAndDesc(String desc) {
		UtilHBM.waitExplicitDisplayed(driver, projectDesc);
		UtilHBM.waitExplicitClickable(driver, projectDesc);
		if (projectDesc.getText().isEmpty()) {
			new Actions(driver).moveToElement(projectDesc).click().build().perform();
			projectDesc.sendKeys(desc);
		} else {
			System.out.println("dec " + projectDesc.getText());
			UtilHBM.waitFixTime(1000);
			projectDesc.click();
			UtilHBM.waitFixTime(1000);
			for (int i = 0; i <= desc.length(); i++) {
				projectDesc.sendKeys(Keys.BACK_SPACE);
			}
			projectDesc.sendKeys(desc);
		}
//		new Actions(driver).moveToElement(projectDesc).click().build().perform();
		UtilHBM.waitExplicitDisplayed(driver, validDesc);
		UtilHBM.waitExplicitClickable(driver, validDesc);
		new Actions(driver).moveToElement(validDesc).click().build().perform();
		UtilHBM.waitFixTime(1500);
		System.out.println("after " + projectDesc.getText());
		return PageFactory.initElements(driver, ProjectDetailsPage.class);
	}

	public ProjectDetailsPage notes(String noteText) {
		UtilHBM.waitExplicitClickable(driver, note);
		if (note.getText().isEmpty()) {
			new Actions(driver).moveToElement(note).click().build().perform();
			new Actions(driver).moveToElement(note).sendKeys(noteText).build().perform();
		} else if (addNote.size() > 1) {
			new Actions(driver).moveToElement(note).click().perform();
			Actions builder = new Actions(driver);
			builder.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
			builder.keyDown(Keys.CONTROL).sendKeys(Keys.DELETE).keyUp(Keys.CONTROL).build().perform();
			new Actions(driver).moveToElement(note).sendKeys(noteText).build().perform();
			UtilHBM.waitFixTime(1000);
		}
		new Actions(driver).moveToElement(saveNote).click().build().perform();
		new Actions(driver).moveToElement(driver.findElement(By.cssSelector(".tt-3.notes"))).click().build().perform();
		
		return this;

	}

	public ProjectDetailsPage verifyMediaOnProjectPage(int noOfHQRenderImages, int noOf2DPlanImages) {
		verifyRenderingImages(noOfHQRenderImages);
		verify2DPlanImages(noOf2DPlanImages);
		return PageFactory.initElements(driver, ProjectDetailsPage.class);
	}

	public ProjectDetailsPage verifyRenderingImages(int noOfHQRenderImages) {
		if (noOfHQRenderImages == 0 && projectImages.size() < 0) {
			UtilHBM.reportInfo("No realistic Images to display.");
		}

		int hqImagesCount = inProgressImages.size() + generatedImages.size();

		if (hqImagesCount == noOfHQRenderImages) {
			UtilHBM.reportOK("Correct number of medias displayed and number of HQ images are " + hqImagesCount);
			if (inProgressImages.size() > 0) {
				UtilHBM.reportInfo("HQ rendering image is in progress and number of images in progress are :"
						+ inProgressImages.size());
			}
			if (generatedImages.size() > 0) {
				if ((driver.findElement(By.xpath("//div[@class='project-images']/div/div[@class='img-container']/img")))
						.getAttribute("src").contains(".jpg")) {
					UtilHBM.reportInfo("HQ rendering image generated and number of images generated are : "
							+ generatedImages.size());
				}
			}
			List<WebElement> img = driver.findElements(By.xpath("//div[@id='realistic-images-container']/div/img"));
			for (WebElement a : img) {
				
				new Actions(driver).moveToElement(a).click().build().perform();
				if (driver.findElements(By.xpath("//article[@class='mod-layer-image-zoom mod-open']")).size() > 0) {
					UtilHBM.waitExplicitDisplayed(driver, printButton);
					Verification.displayOfWebElement(downloadButton);
					Verification.displayOfWebElement(printButton);
					closeZoomInImage.click();
					UtilHBM.waitFixTime(1000);
				}
			}
		} else {
			UtilHBM.reportKO("Incorrect number of HQ images displayed and number of images are : " + hqImagesCount);
		}

		return this;
	}

	public ProjectDetailsPage verify2DPlanImages(int noOf2DPlanImages) {
		if (noOf2DPlanImages == 0 && plan2DContainer.size() < 0) {
			UtilHBM.reportInfo("No 2D plan Images to display.");
		} else if (topPlanImages.size() > 0) {
			UtilHBM.reportInfo("Number of top plans displayed are :" + topPlanImages.size());
		}
		if (facePlanImages.size() > 0) {
			UtilHBM.reportInfo("Number of face plans displayed are :" + facePlanImages.size());
		}

		if (worktopPlanImages.size() > 0) {
			UtilHBM.reportInfo("Number of worktop plans displayed are :" + worktopPlanImages.size());
		}
		if (wallPanelPlanImages.size() > 0) {
			UtilHBM.reportInfo("Number of wallpanel plans displayed are :" + wallPanelPlanImages.size());
		}
		int twoDPlanImagesCount = topPlanImages.size() + facePlanImages.size() + worktopPlanImages.size()
				+ wallPanelPlanImages.size();
		if (twoDPlanImagesCount == noOf2DPlanImages) {
			UtilHBM.reportOK("Correct number of 2D plan images displayed and number of 2D plan images are "
					+ twoDPlanImagesCount);
			List<WebElement> img = driver.findElements(By.xpath("//div[@id='plan2D-container']/div/div[@class='img-container']"));
			for (WebElement a : img) {
				a.click();
				UtilHBM.waitExplicitDisplayed(driver, printButton);
				Verification.displayOfWebElement(downloadButton);
				Verification.displayOfWebElement(printButton);				
				closeZoomInImage.click();
				UtilHBM.waitFixTime(1000);
			}
		} else {
			UtilHBM.reportKO("Incorrect number of 2D plans displayed and number of plans are  " + twoDPlanImagesCount);
		}

		return this;
	}
	
	public MyProjects goToMyProjects(){
		new Actions(driver).moveToElement(user).build().perform();
		UtilHBM.waitExplicitDisplayed(driver, myProjects);
		UtilHBM.waitExplicitClickable(driver, myProjects);
		myProjects.click();
		UtilHBM.waitFixTime(2500);
		return PageFactory.initElements(driver, MyProjects.class);
	}

}
