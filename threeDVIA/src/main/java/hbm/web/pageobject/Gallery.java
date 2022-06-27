package hbm.web.pageobject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Gallery {
	WebDriver driver;

	public Gallery(WebDriver driver) {
		this.driver = driver;
	}

	
	
	@CacheLookup
	@FindBy(css = ".header-logo")
	WebElement homebymeLink;

	@CacheLookup
	@FindBy(linkText = "Top projects")
	WebElement gallery;

	@FindBy(css="main>section>div>div>div>article>section>div>div.gallery-grid>div:nth-child(1)>div>a")
	private WebElement firstProjectLink;
	
	@FindBy(xpath="//div[@class='u-txtCenter u-mtm']/span[@title='More']")
	private WebElement moreButton;

	@FindBy(css="div#explore>div>div>div.filters.flex-inline>div:nth-child(2)")
	private WebElement filter1;
	
	@FindBy(css="div#explore>div>div>div.filters.flex-inline>div:nth-child(3)")
	private WebElement filter2;
	
	@FindBy(css="div#explore>div>div>div.filters.flex-inline>div:nth-child(4)")
	private WebElement filter3;
	
	@FindBy(css="div#explore>div>div>div.filters.flex-inline>div:nth-child(2)>select")
	private WebElement filter1Select;
	
	@FindBy(css="div#explore>div>div>div.filters.flex-inline>div:nth-child(3)>select")
	private WebElement filter2Select;
	
	@FindBy(css="div#explore>div>div>div.filters.flex-inline>div:nth-child(4)>select")
	private WebElement filter3Select;
	
	@FindBy(css="div#explore>div>div>div.filters.flex-inline>span")
	private WebElement clearFilters;
	
	@FindBy(css=".search-container.flex.flex-spaceBetween.u-mbm>.category-bar-mobile.flex-item-1")
	private WebElement categoryMobile;
	
	@FindBy(css ="html[class=''] #gallery_content>.wrapper>div>.flex.flex-middle.flex-spaceBetween>.switch-access.to-early-access")
	private List<WebElement> earlyAccess;

	@FindBy(css ="html[class=''] .feed-view>.header-feed>h1")
	private WebElement earlyAccessText;

	@FindBy(xpath = "//html[@class='']//*[@id='explore']/div[2]/div/div[contains(@class,'tag image-related')]")
	private List<WebElement> mediaList;
	
	@FindBy(xpath = "//html[@class='']//*[@id='explore']/div[4]/div/div[contains(@class,'tag image-related')]")
	private List<WebElement> mediaListWhenNoResults;
	
	@FindBy(xpath = "//html[@class='']//*[@id='explore']/div[2][@class='no-result']")
	private WebElement noResults;
	
	@FindBy(xpath = "//html[@class='']//*[@id='explore']/div[@class='take-chance']")
	private WebElement DiscoverMore;
	
	public Gallery checkFeaturedProject() {
		gallery.click();
		List<WebElement> projectList = driver.findElements(By.cssSelector(".grid-1-4"));
		List<WebElement> projectImageList = driver.findElements(By.xpath("//div[@class='media-legend']/preceding-sibling::div/a/img[starts-with(@src, 'https')]"));
		System.out.println("Numberof project images: " + projectImageList.size());

		if (projectImageList.size()==projectList.size()-2) {
			UtilHBM.reportOK("All project images are displayed in Gallery Page.<br>Number of Project in Gallery page = " + (projectList.size() - 2) + "<br>Number of Project with image in Gallery page = " + projectImageList.size());
//				Reporter.log("<font color='green'>" + "All project images are displayed in Gallery Page." + "<br>" );
//				Reporter.log("Number of Project in Gallery page = " + (projectList.size()-2) + "<br>");
//				Reporter.log("Number of Project with image in Gallery page = " + projectImageList.size() + "<font color='black'>" + "<br>");
		}else {
			UtilHBM.reportKO("All project images are not displayed in Gallery Page.<br>Number of Project in Gallery page = "+ (projectList.size() - 2) + "<br>Number of Project with image in Gallery page = "+ projectImageList.size());
//				Reporter.log("<font color='red'>" + "All project images are not displayed in Gallery Page." + "<br>" );
//				Reporter.log("Number of Project in Gallery page = " + (projectList.size()-2) + "<br>");
//				Reporter.log("Number of Project with Images in Gallery page = " + projectImageList.size() + "<font color='black'>" + "<br>");
		}

		List<String> projectLink = new ArrayList<String>();
		for (WebElement temp : UtilHBM.listOfWebElement(driver, ".grid-1-4>div")) {
			projectLink.add(temp.getText());
		}
		GalleryProjectPage projectPage = PageFactory.initElements(driver, GalleryProjectPage.class);
		driver.findElement(By.linkText(projectLink.get(1))).click();
//		String projectNameOnProjectPage = driver.findElement(By.cssSelector(".subHeader-title")).getText().toUpperCase();
//		Assert.assertEquals(projectName, projectNameOnProjectPage);
		Assert.assertEquals(projectLink.get(1).toUpperCase(), projectPage.projectName());
		Assert.assertFalse(projectLink.get(1).equalsIgnoreCase(null));
		String userName = driver.findElement(By.cssSelector(".subHeader-thumb-txt>a>span")).getText();
		System.out.println(userName);
		projectPage.projectDetails();
		driver.findElement(By.linkText("GALLERY")).click();
		return PageFactory.initElements(driver, Gallery.class);
	}
	
//	public Gallery verifyProjectDetails(String projectTitle, String username, String area, String noOfrooms,String noOffloors) {
//		WebElement project = driver.findElement(By.xpath("//div[@class='gallery-grid']//a/div[normalize-space() = \"" + projectTitle + "\"]/../../.."));
//		UtilHBM.waitExplicitDisplayed(driver, project.findElement(By.xpath("picture//img")));
//		Verification.displayOfWebElement(project.findElement(By.xpath("picture//img")));
//		Verification.displayOfWebElement(project.findElement(By.xpath("picture//img")));
//		Verification.VerifyEquals("Wrong username displayed",project.findElement(By.xpath("div/div/div[@class='username']")).getText(), username);
//		Verification.displayOfWebElement(project.findElement(By.xpath("div/div[@class='project-legend']/ul/li[1]/span[1]")));
//		Verification.VerifyEquals("Wrong area displayed",project.findElement(By.xpath("div/div[@class='project-legend']/ul/li[1]/span[2]")).getText(), area);
//		Verification.displayOfWebElement(project.findElement(By.xpath("div/div[@class='project-legend']/ul/li[2]/span[1]")));
//		Verification.VerifyEquals("Wrong noOfrooms displayed",project.findElement(By.xpath("div/div[@class='project-legend']/ul/li[2]/span[2]")).getText(),noOfrooms);
//		Verification.displayOfWebElement(project.findElement(By.xpath("div/div[@class='project-legend']/ul/li[3]/span[1]")));
//		Verification.VerifyEquals("Wrong noOffloors displayed",project.findElement(By.xpath("div/div[@class='project-legend']/ul/li[3]/span[2]")).getText(),noOffloors);
//		Verification.displayOfWebElement(project.findElement(By.xpath("div/div[@class='project-like']/div/i")));
//		Verification.displayOfWebElement(project.findElement(By.xpath("div/div[@class='project-like']/div/span")));
//		Verification.displayOfWebElement(project.findElement(By.xpath("div/div[@class='current-rating u-mtxs u-ptxs']/ul/li[1]/a/span[@class='icon icon-message'][1]")));
//		Verification.displayOfWebElement(project.findElement(By.xpath("//div/div[@class='current-rating u-mtxs u-ptxs']/ul/li[2]/div/span[@class='icon icon-view u-mls'][1]")));
//		Verification.elementContainsString(project.findElement(By.xpath("div/div[@class='current-rating u-mtxs u-ptxs']/ul/li[1]/a/span[2]")), "comment","Comment text");
//		Verification.elementContainsString(project.findElement(By.xpath("div/div[@class='current-rating u-mtxs u-ptxs']/ul/li[2]/div/span[2]")), "view","Views text");
//		return this;
//	}

//	public ProjectPage openOthersProject(String projectTitle) {
//		Actions actions =PageFactory.initElements(driver, Actions.class);
//		actions.moveToElement(driver.findElement(By.xpath("html[@class='']//div[@class='gallery-grid']//a/div[normalize-space() = '" + projectTitle + "']"))).build().perform();
//		driver.findElement(By.xpath("//div[@class='gallery-grid']//a/div[normalize-space() = \"" + projectTitle + "\"]")).click();
//		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "html[class=''] .subHeader-title"));
//		ProjectPage projectPage=PageFactory.initElements(driver, ProjectPage.class);
//		projectPage.verifyProjectName(projectTitle);
//		return PageFactory.initElements(driver, ProjectPage.class);
//	}

//	public UserProfilePage openUserProfilePage(String projectTitle, String userName) {
//		UtilHBM.waitExplicitClickable(driver, driver.findElement(By.xpath("//div[@class='gallery-grid']//a/div[normalize-space() = '"+projectTitle+"']/../following-sibling::div[@class='source-user flex flex-middle flex-right']/a")));
//		driver.findElement(By.xpath("//div[@class='gallery-grid']//a/div[normalize-space() = '"+projectTitle+"']/../following-sibling::div[@class='source-user flex flex-middle flex-right']/a")).click();
//		UserProfilePage userProfilePage = PageFactory.initElements(driver, UserProfilePage.class);
//		userProfilePage.verifyUserDetails("others",userName);
//		return PageFactory.initElements(driver, UserProfilePage.class);
//	}
	
//	public ProjectPage openFirstProject() {
//		UtilHBM.waitExplicitDisplayed(driver, firstProjectLink);
//		UtilHBM.waitExplicitClickable(driver, firstProjectLink);
//		firstProjectLink.click();
//		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "html[class=''] .subHeader-title"));
//		return PageFactory.initElements(driver, ProjectPage.class);
//	}

//	public Gallery filterProjects (String byType) {
//		WebElement filter = driver.findElement(By.xpath("//span[.='"+byType+"']/preceding-sibling::i[starts-with(@class, 'icon icon')]"));
//		filter.click();
//		UtilHBM.waitFixTime(1000);
//		return this;
//	}
//	
//	public Gallery verifyProjectPreviews(int expectedProjectCount) {
//		List<WebElement> projectImgList=driver.findElements(By.xpath("//div[@class='gallery-grid']/div/picture//img[contains(@src,'https:')]/../../.."));
//		List<WebElement> projectList = driver.findElements(By.xpath("//div[@class='gallery-grid']/div"));
//		UtilHBM.waitExplicitDisplayed(driver, projectImgList.get(projectImgList.size() - 1));
//		int currentProjectCount = projectList.size();
//		int currentProjectPreviewCount =  projectImgList.size();
//		if ((currentProjectPreviewCount == expectedProjectCount) && (currentProjectCount == expectedProjectCount)) {
//			UtilHBM.reportOK("Expected Project Count is equal to Actual Project Count is equal to Project Preview Count ="+currentProjectCount);
//		} else {
//			UtilHBM.reportKO("ExpectedProjectCount is not equal to ActualProjectCount or ProjectPreviewCount !!! "
//					+ "Expected Project Count "+ expectedProjectCount + ", Actual Project Count : " 
//					+ currentProjectCount + ", Project Preview Count : " + currentProjectPreviewCount);
//		}
//		return this;
//	}

//	public Gallery verifyPagination() {
//		verifyProjectPreviews(15).clickMoreButton().verifyProjectPreviews(30).clickHbmLogo();
//		return this;
//	}

//	public Gallery clickMoreButton() {
//		UtilHBM.waitExplicitDisplayed(driver, moreButton);
//		UtilHBM.waitExplicitClickable(driver, moreButton);
//		moreButton.click();
//		UtilHBM.waitFixTime(1000);
//		return this;
//	}

	
	
	public LandingPage clickHbmLogo() {
		homebymeLink.click();
		return PageFactory.initElements(driver, LandingPage.class);
	}
	
	public Gallery applyFilter(String filterByRoom, String filterByColor, String filterByBrand) {
		UtilHBM.waitExplicitDisplayed(driver, clearFilters);
		UtilHBM.waitExplicitClickable(driver, clearFilters);
		UtilHBM.reportInfo("Checking default filters displayed:");
		verifyFilters("All rooms", "All colors", "All brands");
		filter1.click();
		Select select1 = new Select(filter1Select);
		select1.selectByVisibleText(filterByRoom);
		filter2.click();
		Select select2 = new Select(filter2Select);
		select2.selectByVisibleText(filterByColor);
		filter3.click();
		Select select3 = new Select(filter3Select);
		select3.selectByVisibleText(filterByBrand);
		UtilHBM.waitFixTime(1000);
		verifyFilters(filterByRoom, filterByColor, filterByBrand).checkFilterResults();
		return this;
	}
	
	public Gallery checkFilterResults() {
		UtilHBM.waitExplicitDisplayed(driver, clearFilters);
		UtilHBM.waitExplicitClickable(driver, clearFilters);
		int filterResults = mediaList.size();
		UtilHBM.reportInfo("Filter results displayed: " + filterResults);
		if (filterResults == 0) {
			Verification.displayNAttributeCheckOfElement(noResults.findElement(By.tagName("img")), "No results image",
					"src", "https://preprod-home.by.me/dist/dist/images/no-image.11f89af488e49cefed70858438b7eb25.svg");
			Verification.VerifyEquals("Wrong no results text", noResults.getText(),
					"We don't have any results to display according to the filters you have chosen");
			Verification.VerifyEquals("Wrong discover more text", DiscoverMore.getText(),
					"Discover also different kinds of inspiration thanks to HomeByMe users");
			int mediaListWhenNoResults1 = mediaListWhenNoResults.size();
			if (mediaListWhenNoResults1 >= 10) {
				UtilHBM.reportOK("Discover more media list displayed when no filter results available");
			} else if (mediaListWhenNoResults1 == 0) {
				UtilHBM.reportKO(
						"Discover more media list not displayed when no filter results!!! Number of media displayed : "
								+ mediaListWhenNoResults1);
			}

		} else if (filterResults > 9) {
			UtilHBM.reportOK("More than 10 results displayed for applied filters");
		} else {
			UtilHBM.reportOK("Number of results displayed for applied filters : " + filterResults);
		}
		return this;}

	public Gallery verifyTags(String tagToCheck) {
		UtilHBM.reportInfo("Verifying tag on inspiration page :"+tagToCheck);
		List<String> roomOptions = Arrays.asList("All rooms", "Living Room", "Kitchen", "Bedroom", "Dining room",
				"Bathroom", "Office", "Baby & Kids", "Laundry Room", "Entertainment Room");
		List<String> colorOptions = Arrays.asList("All colors", "Beige", "Black", "Blue", "Brown", "Green", "Grey",
				"Orange", "Pink", "Red", "White", "Yellow", "Purple");
		List<String> brandOptions = Arrays.asList("All brands", "All Modern", "Castorama", "CB2", "Cole & Son",
				"Crate & Barrel", "Farrow & Ball", "Fermob", "Flos", "Gautier", "Habitat", "Isidore Leroy", "Juniqe",
				"Lampatron", "La Redoute Interieurs", "Le French Design", "Ligne Roset", "Made", "Magnolia",
				"Maisons du monde", "Neology", "Open Desk", "Overstock", "Pottery Barn", "Ralph Lauren Home",
				"Restoration Hardware", "Smeg", "Vitra", "Wayfair", "West Elm", "Williams Sonoma");

		if (roomOptions.contains(tagToCheck)) {
			verifyFilters(tagToCheck, "All colors", "All brands");
		} else if (colorOptions.contains(tagToCheck)) {
			verifyFilters("All rooms", tagToCheck, "All brands");
		} else if (brandOptions.contains(tagToCheck)) {
			verifyFilters("All rooms", "All colors",tagToCheck);
		} else {
			UtilHBM.reportKO("Tag not available in inspiration filter lists!! Tag name : " + tagToCheck);
		}

		return this;
	}

	public Gallery verifyFilters(String filterByRoom, String filterByColor, String filterByBrand) {
		UtilHBM.waitExplicitDisplayed(driver, clearFilters);
		UtilHBM.waitExplicitClickable(driver, clearFilters);
		Verification.VerifyEquals("Wrong filter1 name!!", filter1.findElement(By.cssSelector("p.label")).getText(),
				"Room");
		Verification.VerifyEquals("Wrong filter1 option selected!!",
				filter1.findElement(By.cssSelector("p.title")).getText(), filterByRoom);
		Verification.VerifyEquals("Wrong filter2 name!!", filter2.findElement(By.cssSelector("p.label")).getText(),
				"Color");
		Verification.VerifyEquals("Wrong filter2 option selected!!",
				filter2.findElement(By.cssSelector("p.title")).getText(), filterByColor);
		Verification.VerifyEquals("Wrong filter3 name!!", filter3.findElement(By.cssSelector("p.label")).getText(),
				"Brand");
		Verification.VerifyEquals("Wrong filter3 option selected!!",
				filter3.findElement(By.cssSelector("p.title")).getText(), filterByBrand);
		return this;
	}

	public Gallery clearFilters() {
		UtilHBM.waitExplicitDisplayed(driver, clearFilters);
		UtilHBM.waitExplicitClickable(driver, clearFilters);
		clearFilters.click();
		Verification.VerifyEquals("Wrong filter1 name!!", filter1.findElement(By.cssSelector("p.title")).getText(),
				"All rooms");
		Verification.VerifyEquals("Wrong filter2 name!!", filter2.findElement(By.cssSelector("p.title")).getText(),
				"All colors");
		Verification.VerifyEquals("Wrong filter3 name!!", filter3.findElement(By.cssSelector("p.title")).getText(),
				"All brands");
		return this;
	}
	

	public Gallery clickCAtegory() {
		UtilHBM.waitExplicitDisplayed(driver, categoryMobile);
		UtilHBM.waitExplicitClickable(driver, categoryMobile);
		categoryMobile.click();
		UtilHBM.waitFixTime(1000);
		return this;
	}
	
	

}
