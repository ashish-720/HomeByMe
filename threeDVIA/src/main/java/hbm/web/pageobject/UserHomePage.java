package hbm.web.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import hbm.planner.dataobject.NewProjectData;
import hbm.planner.pageobject.LocalSave;
import hbm.planner.pageobject.NewProject;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;


public class UserHomePage {
	private WebDriver driver;
	
	public UserHomePage (WebDriver driver){
		this.driver = driver;
	}	
	
	@FindBy(css="div.cell>a[class='button button--l open-planner-embed']")
	WebElement createYourProjectHBMFor;
	
	@FindBy(css ="section.project-list>div.wrapper>p>a")
	private  WebElement allYourProjectsLink;
	
	@FindBy(css ="section.project-list>div.wrapper>h2")
	private  WebElement allYourProjectHeader;
	
	@FindBy(css ="section.project-list>div.wrapper>div>article img")
	private List<WebElement> featuredProjectsListOne;

	@FindBy(css ="section.featured-projects>div.wrapper>div>article")
	private List<WebElement> featuredProjectsList;
	
	@FindBy(css ="section.project-list>div.wrapper>div>article")
	private List<WebElement> yourProjectsList;
	
	@FindBy(css ="section.project-list>div.wrapper>div>article>div.media-legend>ul.media-actions>li>a")
	private List<WebElement> featuredProjectsMediaActionsListOne;
	
	@FindBy(css ="section.project-list>div.wrapper>div>article>div.media-legend>ul.projectLegend>li")
	private List<WebElement> featuredProjectsAttributesListOne;
	
	@FindBy(css ="section.project-list>div.wrapper>div>article>div.media-legend>p>a")
	private  WebElement featuredProjectNameOne;
	
	@FindBy(css ="section.project-list>div.wrapper>div>article>div.media-legend>time")
	private  WebElement featuredProjectTimeOne;
	
	@FindBy(css ="section.tutorials>div.wrapper>p>a")
	private  WebElement allOurTutorialsLink;
	
	@FindBy(css ="section.tutorials>div.wrapper>h2")
	private  WebElement tutorialsHeader;
	
	@FindBy(css ="section.featured-projects>div.wrapper>p>a")
	private  WebElement featuredProjectsLink;
	
	@FindBy(css ="section.featured-projects>div.wrapper>h2")
	private  WebElement featuredProjectsHeader;
	
	@FindBy(css ="section.magazine>div.wrapper>p>a")
	private  WebElement magazineLink;
	
	@FindBy(css ="section.magazine>div.wrapper>h2")
	private  WebElement magazineHeader;
	
	@FindBy(css ="section.hero>img")
	private  WebElement welcomeImg;
		
	@FindBy(css ="section.get-started>div.wrapper>div.grid>div.grid-2-4>p")
	private  WebElement getStartedText2;
	
	@FindBy(css ="section.get-started>div.wrapper>div.grid>div.grid-2-4>h3")
	private  WebElement getStartedText1;
	
	@FindBy(css ="section.get-started>div.wrapper>div.grid>span>figure>img")
	private  WebElement getStartedImg;
	
	@FindBy(css ="section.get-started>div.wrapper>h2")
	private  WebElement getStarted;
	
	@FindBy(css ="section.get-started>div.wrapper>p>a")
	private  WebElement tryOurTrialProject;
		
	@FindBy(xpath = "/html/body/main/section/div/a[contains(text(),'Create a project')]")
	private WebElement newProjectLink;
	
	@FindBy(css ="div.wrapper>div>h1")
	public WebElement welcomeLoginId;
	
	@CacheLookup
	@FindBy(css = ".project-title a")
	private WebElement projectTitle;
	
	@CacheLookup
	@FindBy(css = ".project-time")
	private WebElement projectTime;
	
	@FindBy(xpath="//nav[@class='header__nav']/a[@title='My projects']/span[contains(text(),'My projects')]")
	private WebElement myProjects;
	
	@FindBy(xpath="//nav[@class='header__nav']/a[@title='My Collections']/span[contains(text(),'My Collections')]")
	private WebElement myCollections;
	
	@FindBy(css=" div.wrapper>.header-right>div>.header-menu>li>a[title='My projects']")
	private WebElement myProjectsMDM;
	
	@FindBy(xpath ="//nav[@class='header__nav']/a[contains(@href,'/en/inspiration')]/span[.='Inspiration']")
	private WebElement galleryLink;
	
	@CacheLookup
	@FindBy(css = ".icon-floor-light")
	private WebElement noOfFloor;
	
	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown>span.dropdown__toggle")
	private WebElement userAvatar;
	
	@FindBy(css = ".header-account.header-account--logged>div>.byUser-thumb")
	private WebElement userAvatarHBM4;
	
	@CacheLookup
	@FindBy(css="body>main>section>div>div>h1")
	WebElement welcomeNote;
	
	@CacheLookup
	@FindBy(css=".header-account.header-account--logged")
	private WebElement accountHeader;
	
	@CacheLookup
	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown.is-open>.dropdown_content>div>a[title='Logout']")
	private WebElement logout;
	
	@FindBy(css = " div.header-account>ul>li>form>a>button[type='submit']")
	private WebElement logoutHBM4;
	
	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown.is-open>.dropdown_content>div>a[title='My profile']")
	private WebElement myProfile;
	
	@CacheLookup
	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown.is-open>.dropdown_content>div>a[title='Back office']")
	private WebElement backOffice;
		
	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown.is-open>.dropdown_content>div>a[title='Account']")
	private WebElement accountLink;
	
	@FindBy(css = "span.header_nav_item.header__nav__account.dropdown.is-open>.dropdown_content>div>a[title='Staff pick']")
	private WebElement staffPicks;
		
	@FindBy(xpath="//nav[@class='header__nav']/a[@title='My projects']/span[contains(text(),'My projects')]")
	private WebElement projectsLink;
	
	@CacheLookup
	@FindBy(css = "body>main>.project-list.u-pbl>div>div>article")
	private List<WebElement> latestProjectList;	
	
	@CacheLookup
	@FindBy(css = ".projectNav-item")
	private List<WebElement> tabList;
	
	@CacheLookup
	@FindBy(css = "div[class='head']")
	static private List<WebElement> attributeList;
	
	@FindBy(xpath="//nav[@class='header__nav']/a[contains(@href,'/en/offers')]/span[.='OFFERS']")
	private WebElement ourOffersLink;	
	
	@FindBy(css="a[title='Edit project']")
	private WebElement editFirstProject;	
	
	@FindBy(xpath = "//section[@class='project-list u-pbl']/div/div/article[1]/div[@class='media-thumb']/a/div[@class='media-thumb-updated']/p")
	private List<WebElement> beingUpdated;
	
	@FindBy(css="header[class='headr']>div>button>svg.icon.icon-burger")
	WebElement headerMenuMobile;
	
	@FindBy(css = " .feed-view>.header-feed.flex-middle.flex-spaceBetween>.switch-access")
	private List<WebElement> previousVersion;
	
	@FindBy(xpath = "//*[@id='explore']/div[3]/div/div[contains(@class,'tag image-related')]")
	private List<WebElement> mediaList;
	
	@FindBy(xpath="//header[@id='bar']/div/nav/span/span/span[contains(text(),'MAGAZINE')]")
	WebElement magazine;
	
	@FindBy(xpath="//header[@id='bar']/div/nav/span[1]/div/div/a[1]")
	WebElement magazineHomePage;
	
	public UserHomePage closeDiscountPopupIfAvailable() {
		UtilHBM.waitFixTime(2000);
		UtilHBM.turnOffImplicitWaits(driver);
		List<WebElement> discountPopup = driver
				.findElements(By.xpath("//div[@class='popin-content-medium']/div[@class='-close']"));
		boolean isDiscountPopupDisplayed = !discountPopup.isEmpty();
		UtilHBM.turnOnImplicitWaits(driver);
		if (isDiscountPopupDisplayed) {
			UtilHBM.waitExplicitDisplayed(driver, "//div[@class='popin-content-medium']/div[@class='-close']");
			UtilHBM.webElementXPath(driver, "//div[@class='popin-content-medium']/div[@class='-close']").click();
			UtilHBM.waitFixTime(500);
		} else {
			UtilHBM.reportInfo("Discount popup not displayed!!");
		}
		return this;
	}

	public ThreeDPlanner createNewProject(NewProjectData newProjectData){
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		UtilHBM.waitExplicitDisplayed(driver, newProjectLink);
		UtilHBM.waitExplicitClickable(driver, newProjectLink);
		newProjectLink.click();	
		for (String winHandle: driver.getWindowHandles()){
			System.out.println(driver.getWindowHandle());
			driver.switchTo().window(winHandle);
		}				
		NewProject newProject = PageFactory.initElements(driver, NewProject.class);
		return newProject.fillNewProjectDetials(newProjectData);		
	}
	
//	public createNewProjectDrawOrFP(NewProjectData newProjectData)
	
	public ThreeDPlanner createEmptyProject(NewProjectData newProjectData){
		newProjectLink.click();						
//		String handle = driver.getWindowHandle();
//		for (String winHandle: driver.getWindowHandles()){
//			if (winHandle != handle){
//				driver.switchTo().window(winHandle);
//			}else {
//				System.out.println("current window is active");
//			}
//			System.out.println(driver.getWindowHandle());
//			driver.switchTo().window(winHandle);
//		}		
//		String url = driver.getCurrentUrl();
//		if (url.contains("preprod")){
//			String newUrl = url.split("//")[1];
//			driver.get("https://homebyme:betatest1@" + newUrl);
//		}
		NewProject newProject = PageFactory.initElements(driver, NewProject.class);
		return newProject.fillEmpltyProjectDetails(newProjectData);
	}
	
	public ThreeDPlanner createProjectFromFP(NewProjectData newProjectData){
		newProjectLink.click();	
		NewProject newProject = PageFactory.initElements(driver, NewProject.class);
		return newProject.fillFPProjectDetails(newProjectData);
	}
	
	public ThreeDPlanner createProjectFromScratch(NewProjectData newProjectData, String wallParameter){
		newProjectLink.click();
		NewProject newProject = PageFactory.initElements(driver, NewProject.class);		
		return newProject.fillProjectFromScratchDetails(newProjectData, wallParameter);
	}
	
	public ThreeDPlanner editLatestProject(){
		new Actions(driver).moveToElement(latestProjectList.get(0).findElement(By.cssSelector("div.media-thumb"))).build().perform();
		UtilHBM.waitExplicitClickable(driver, latestProjectList.get(0).findElement(By.cssSelector("div.media-thumb>ul>li>a[title='Edit project']")));
		latestProjectList.get(0).findElement(By.cssSelector("div.media-thumb>ul>li>a[title='Edit project']")).click();
//		UtilHBM.webElement(driver, "a[title='Try now']").click();
		UtilHBM.waitFixTime(1000);
		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
		if(UtilHBM.webElement(driver, "img[src='assets/images/logo_hbm.png']").isDisplayed() &&
				UtilHBM.webElement(driver, "#loading").isDisplayed()){
			UtilHBM.reportInfo("Loading screen is displayed while loading project in planner");
		}else{
			UtilHBM.reportWarning("Loading screen is not displayed while loading project in planner");
		}
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".head-title"));
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	//To be used when there is only one project
	public ThreeDPlanner editFirstProject(){
		UtilHBM.waitExplicitClickable(driver, editFirstProject);
		editFirstProject.click();
//		UtilHBM.webElement(driver, "a[title='Try now']").click();
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
	
	public LocalSave editLatestLocalSavedProject(){
//		new Actions(driver).moveToElement(latestProjectList.get(0)).click(latestProjectList.get(0).findElement(By.cssSelector("ul>li>a[title='Edit project']"))).build().perform();
		new Actions(driver).moveToElement(latestProjectList.get(0).findElement(By.cssSelector("div.media-thumb"))).build().perform();
		UtilHBM.waitExplicitClickable(driver, latestProjectList.get(0).findElement(By.cssSelector("div.media-thumb>ul>li>a[title='Edit project']")));
		latestProjectList.get(0).findElement(By.cssSelector("div.media-thumb>ul>li>a[title='Edit project']")).click();
//		UtilHBM.webElement(driver, "a[title='Try now']").click();
		UtilHBM.waitFixTime(1000);
		driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
		if(UtilHBM.webElement(driver, "img[src='assets/images/logo_hbm.png']").isDisplayed() &&
				UtilHBM.webElement(driver, "#loading").isDisplayed()){
			UtilHBM.reportInfo("Loading screen is displayed while loading project in planner");
		}else{
			UtilHBM.reportWarning("Loading screen is not displayed while loading project in planner");
		}		
		return PageFactory.initElements(driver, LocalSave.class);
	}
	
	public UserHomePage printProjectDetails(){
		UtilHBM.reportInfo("The details of the project are:");
		System.out.println("The details of the project are:");
		UtilHBM.reportInfo("Project Title: " + projectTitle.getText());
		System.out.println("Project Title: " + projectTitle.getText());
		UtilHBM.reportInfo("Project Creation Date: " + projectTime.getText());
		System.out.println("Project Creation Date: " + projectTime.getText());		
		for(WebElement detail:UtilHBM.listOfWebElement(driver, ".projectLegend-item")){
			System.out.println(detail.getText());
			UtilHBM.reportInfo(detail.getText());
		}
		
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
	
	public LandingPage logoutHBM4(){
		if (userAvatarHBM4.isDisplayed()){			
			Actions action = new Actions(driver);			
			action.moveToElement(userAvatarHBM4).build().perform();
			UtilHBM.waitExplicitClickable(driver, logoutHBM4);
			logoutHBM4.click();
//			action.moveToElement(logout).click().build().perform();	
			UtilHBM.reportOK("Logout success");
		}else {
			UtilHBM.reportKO("Logout failed. User Name is not displayed");
		}					
		return PageFactory.initElements(driver, LandingPage.class);
	}
	
	public MyAccount goToAccountPage(){		
		UtilHBM.waitFixTime(1000);
		Actions action = new Actions(driver);
		action.moveToElement(userAvatar).build().perform();
		UtilHBM.waitExplicitClickable(driver, accountLink);		
		accountLink.click();		
		return PageFactory.initElements(driver, MyAccount.class);
	}
	
	public StaffPicks goToStaffPick() {
		UtilHBM.waitFixTime(1000);
		Actions action = new Actions(driver);
		action.moveToElement(userAvatar).build().perform();
		UtilHBM.waitExplicitClickable(driver, staffPicks);
		staffPicks.click();
		return PageFactory.initElements(driver, StaffPicks.class);
	}
	
	public BackOffice goToBackOffice() {
		new Actions(driver).moveToElement(userAvatar).build().perform();
		UtilHBM.waitExplicitClickable(driver, backOffice);
		backOffice.click();
		UtilHBM.reportOK("Logged In with Backoffice");
		return PageFactory.initElements(driver, BackOffice.class);
	}
	
	public MyProjects clickProjects(){
		projectsLink.click();
		return PageFactory.initElements(driver, MyProjects.class);		
	}
	
	public UserHomePage clickHomeTab(){
		UtilHBM.waitExplicitClickable(driver, tabList.get(0));
		tabList.get(0).click();
		return this;		
	}
	
	public UserHomePage projectDetails(int projectNumber){
		driver.findElements(By.cssSelector(".media-legend")).get(projectNumber-1).click();
//		GalleryProjectPage projectPage = PageFactory.initElements(driver, GalleryProjectPage.class);
//		projectPage.projectDetails();
//		return PageFactory.initElements(driver, GalleryProjectPage.class);
		printProjectDetails();
		return this;
	}
		
	public OurOffers goToOffers() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitExplicitClickable(driver, ourOffersLink);
		ourOffersLink.click();
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "div.page.page--pricing"));
		UtilHBM.waitFixTime(1000);
		UtilHBM.turnOffImplicitWaits(driver);
		boolean isDiscountPopUp2Displayed = !driver.findElements(By.cssSelector("#kmab-container-7704-close"))
				.isEmpty();
		UtilHBM.turnOnImplicitWaits(driver);
		if (isDiscountPopUp2Displayed) {
			UtilHBM.waitExplicitClickable(driver, driver.findElement(By.cssSelector("#kmab-container-7704-close")));
			WebElement notInterested2 = driver.findElement(By.cssSelector("#kmab-container-7704-close"));
			notInterested2.click();
		}
		return PageFactory.initElements(driver, OurOffers.class);
	}
	
	public MyProjects goToMyProjects() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitExplicitDisplayed(driver, myProjects);
		UtilHBM.waitExplicitClickable(driver, myProjects);
		myProjects.click();
		return PageFactory.initElements(driver, MyProjects.class);
	}
	
	public MyFavorites goToMyCollections() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitExplicitClickable(driver, myCollections);
		myCollections.click();
		return PageFactory.initElements(driver, MyFavorites.class);
	}

	
	public MyProjects goToMyProjectsMDM() {
		UtilHBM.waitExplicitClickable(driver, myProjectsMDM);
		myProjectsMDM.click();
		return PageFactory.initElements(driver, MyProjects.class);
	}
	
	public UserHomePage acceptDataSharingHBM4() {
		UtilHBM.waitExplicitDisplayed(driver, myProjectsMDM);
		UtilHBM.waitFixTime(1000);
		String handle1 = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!handle1.equals(handle)) {
				driver.switchTo().window(handle);
			}
		}
		ShareDataMDM shareDataMDM = PageFactory.initElements(driver, ShareDataMDM.class);
		shareDataMDM.acceptShareDataOffer();
		driver.switchTo().window(handle1);
		return this;
	}
	
	public DecorationInspiration goToInspiration() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitExplicitClickable(driver, galleryLink);
		galleryLink.click();
		UtilHBM.waitExplicitDisplayed(driver, driver
				.findElement(By.xpath("//*[@id='explore']/div[3]/div/div[4]/div/a/img[contains(@src,'https://')]")));
		return PageFactory.initElements(driver, DecorationInspiration.class);
	}
	
	public Payment buyAdditionalProjectsWhenExhausted(int packOf2or10or50) {
		String handle = driver.getWindowHandle();
		newProjectLink.click();
		for (String handle1 : driver.getWindowHandles()) {
			if (!handle1.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle1);
			}
		}
		BuyAdditionalProjectsWhenExhausted1 buyAdditionalProjectsWhenExhausted1 = PageFactory.initElements(driver,
				BuyAdditionalProjectsWhenExhausted1.class);
		buyAdditionalProjectsWhenExhausted1.buyAdditionalProjectsWhenExhausted1(packOf2or10or50);
		return PageFactory.initElements(driver, Payment.class);
	}
	
	public Payment buySubscriptionWhenProjectExhausted(String expectedSubscriptionType) {
		String handle = driver.getWindowHandle();
		newProjectLink.click();
		for (String handle1 : driver.getWindowHandles()) {
			if (!handle1.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle1);
			}
		}
		BuyAdditionalProjectsWhenExhausted1 buyAdditionalProjectsWhenExhausted1 = PageFactory.initElements(driver,
				BuyAdditionalProjectsWhenExhausted1.class);
		buyAdditionalProjectsWhenExhausted1.buySubscription(expectedSubscriptionType);
		return PageFactory.initElements(driver, Payment.class);
	}

	public UserHomePage checkLoginStatus(String userName) {
		if (!driver.getCurrentUrl().contains("partner")) {
			Verification.elementContainsString(welcomeLoginId, "Welcome", "Welcome text");
			UtilHBM.reportInfo("WElcome message displayed after logging in : " + welcomeLoginId.getText());
		}
		return this;
	}
	
	public UserHomePage verifyUserHomePage(int noOfProjectsOnHome) {
//		MyAccount myAccount=PageFactory.initElements(driver, MyAccount.class);
//		int projectCredits = myAccount.getAvailableCreditsValues("Projects");
//		myAccount.goToUserHomePage();		
		if(noOfProjectsOnHome==0) {
			Verification.VerifyEquals("Get Started Header text is incorrect", getStarted.getText(), "Get started");
			if (getStartedImg.getAttribute("src").contains("getstarted_video_thumbnail")
					&& getStartedImg.getAttribute("src").contains(".png")) {
				UtilHBM.reportOK("getStartedImg displayed");
			} else {
				UtilHBM.reportKO("getStartedImg not displayed");
			}
			Verification.VerifyEquals("Get Started text1 is incorrect",getStartedText1.getText(),"You're about to start your first project!");
			Verification.VerifyEquals("Get Started text2 is incorrect",getStartedText2.getText(),"Watch this short video, showing you how to get started on Homebyme. As soon as you've finished creating your first project, you'll be able to see it directly on this page.\nThen, share it with your friends to get new ideas.");
			Verification.VerifyEquals("TryOurTrialProject text2 is incorrect",tryOurTrialProject.getText(),"Try our trial project");
		}
		else if (noOfProjectsOnHome == 1) {
			if(featuredProjectsListOne.size()==1) {
				Verification.VerifyEquals("allYourProjectHeader not displayed",allYourProjectHeader.getText(),"Your project");
				if (!featuredProjectsListOne.isEmpty()) {
					if (featuredProjectsListOne.get(0).isDisplayed()) {
						UtilHBM.reportOK("Project Turntable displayed");
					}
				} else {
					UtilHBM.reportKO("Project Turntable not generated or displayed");
				}
				Verification.displayOfWebElement(featuredProjectNameOne);
				Verification.displayOfWebElement(featuredProjectTimeOne);
				for(WebElement l:featuredProjectsAttributesListOne) {
					Verification.displayOfWebElement(l);
				}
				for(WebElement l:featuredProjectsMediaActionsListOne) {
					Verification.displayOfWebElement(l);
				}
			}
			else {
				UtilHBM.reportKO("No of projects created are incorrect");
			}
		}
		else if(noOfProjectsOnHome>=2) {
			if(noOfProjectsOnHome>3) {
				noOfProjectsOnHome=3;
				Verification.VerifyEquals("allYourProjectsLink not displayed",allYourProjectsLink.getText(),"All your projects");
			}
			Verification.VerifyEquals("allYourProjectHeader not displayed",allYourProjectHeader.getText(),"Your latest projects");
			if (noOfProjectsOnHome == yourProjectsList.size()) {
				for (WebElement a : yourProjectsList) {
					if (a.findElement(By.tagName("img")).isDisplayed()) {
						UtilHBM.reportOK("Project Turntable Displayed");
					} else {
						UtilHBM.reportKO("Project Turntable not Displayed or Generated");
					}
					Verification.displayOfWebElement(a.findElement(By.cssSelector("div.media-legend>p>a")));
					Verification.displayOfWebElement(a.findElement(By.cssSelector("div.media-legend>time")));
				}
			}
			else {
				UtilHBM.reportKO("No of projects expected=" + noOfProjectsOnHome + ", No of projects available=" + yourProjectsList.size() );
			}
		}

		if (welcomeLoginId.getText().contains("Welcome ")) {
			UtilHBM.reportOK("welcomeLoginId displayed");
		} else {
			UtilHBM.reportKO("welcomeLoginId not displayed");
		}
		Verification.disabledWebElement(welcomeImg);		
		Verification.disabledWebElement(newProjectLink);
//		Verification.VerifyEquals("tutorialsHeader not displayed",tutorialsHeader.getText(),"Tutorials");
//		if(allOurTutorialsLink.isDisplayed()) {
//			Verification.VerifyEquals("allOurTutorialsLinkText is incorrect", allOurTutorialsLink.getText(), "All our tutorials");
//			if (allOurTutorialsLink.getAttribute("href").contains("/en/academy/tutorials")) {
//				UtilHBM.reportOK("allOurTutorialsLink is correct");
//			} else {
//				UtilHBM.reportKO("allOurTutorialsLink is incorrect");
//			}
//		}
//		else {
//			UtilHBM.reportKO("allOurTutorialsLink not displayed");
//		}
		Verification.VerifyEquals("featuredProjectsHeader not displayed",featuredProjectsHeader.getText(),"Featured projects");
		if(featuredProjectsLink.isDisplayed()) {
			Verification.VerifyEquals("featuredProjectsLinkText is incorrect", featuredProjectsLink.getText(), "Our best user projects");
			if (featuredProjectsLink.getAttribute("href").contains("/en/gallery")) {
				UtilHBM.reportOK("featuredProjectsLink is correct");
			} else {
				UtilHBM.reportKO("featuredProjectsLink is incorrect");
			}
		}
		else {
			UtilHBM.reportKO("featuredProjectsLink not displayed");
		}
		Verification.VerifyEquals("magazineHeader not displayed",magazineHeader.getText(),"Magazine");
		if(magazineLink.isDisplayed()) {
			Verification.VerifyEquals("magazineLinkText is incorrect", magazineLink.getText(), "All our articles");
			if (magazineLink.getAttribute("href").contains("/en/decor-magazine")) {
				UtilHBM.reportOK("magazineLink is correct");
			} else {
				UtilHBM.reportKO("magazineLink is incorrect");
			}
		}
		else {
			UtilHBM.reportKO("magazineLink not displayed");
		}
		for(WebElement a:featuredProjectsList) {
			if (a.findElement(By.tagName("img")).getAttribute("src").startsWith("https:")) {
				UtilHBM.reportOK("Project Preview Displayed");
			} else {
				UtilHBM.reportKO("Project Preview not Displayed");
			}
	
			Verification.displayOfWebElement(a.findElement(By.cssSelector("div.media-legend>p>a")));
			Verification.displayOfWebElement(a.findElement(By.cssSelector("div.media-legend>span")));
			
			List<WebElement> projectDetails=a.findElements(By.cssSelector("div.media-legend>ul>li"));
			for(WebElement l:projectDetails) {
				Verification.displayOfWebElement(l);
			}
		}
		return PageFactory.initElements(driver, UserHomePage.class);
		
		
	}
	
	public ThreeDPlanner createHBMForProject(NewProjectData newProjectData) {
		UtilHBM.waitExplicitClickable(driver, myProjectsMDM);
		UtilHBM.waitExplicitClickable(driver, createYourProjectHBMFor);
		createYourProjectHBMFor.click();
		for (String winHandle: driver.getWindowHandles()){
			System.out.println(driver.getWindowHandle());
			driver.switchTo().window(winHandle);
		}				
		NewProject newProject = PageFactory.initElements(driver, NewProject.class);
		return newProject.fillNewProjectDetials(newProjectData);
		
		
	}

	
	public UserHomePage verifyBeingUpdated() {
		if (beingUpdated.isEmpty()) {
			UtilHBM.reportKO("Being Updated Text not displayed!!!");
		} else {
			Verification.VerifyEquals("Incorrect Being Updated Text!!!", beingUpdated.get(0).getText(),"Being updated...");
		}
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public ProjectPage duplicateProject(String projectTitle) {
		WebElement projectThumbnail = driver
				.findElement(By.xpath("//article/div[@class='media-legend']/p/a[normalize-space()='" + projectTitle
						+ "']/../../preceding-sibling::div[@class='media-thumb']"));
		new Actions(driver).moveToElement(projectThumbnail).build().perform();
		clickDuplicateButton(projectTitle).verifyDuplicateDialogBox().clickDuplicateOK().verifyDuplicated("Copy of "+projectTitle);
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	private DuplicateConfirmation clickDuplicateButton(String projectTitle) {
		WebElement duplicateProjectButton = driver
				.findElement(By.xpath("//article/div[@class='media-legend']/p/a[normalize-space()='" + projectTitle
						+ "']/../../preceding-sibling::div[@class='media-thumb']/ul/li/span[@title='Duplicate this project']"));
		UtilHBM.waitExplicitDisplayed(driver, duplicateProjectButton);
		UtilHBM.waitExplicitClickable(driver, duplicateProjectButton);
		duplicateProjectButton.click();
		return PageFactory.initElements(driver, DuplicateConfirmation.class);
	}
	
	
	public Payment purchase360Images() {
		WebElement projectYourselfINNewInterior = driver
				.findElement(By.cssSelector(" [href='/en/immerse-yourself']"));
		UtilHBM.waitExplicitClickable(driver, projectYourselfINNewInterior);
		projectYourselfINNewInterior.click();
		WebElement see360View = driver
				.findElement(By.cssSelector(" .link-more[title='See the 360° view']"));
		UtilHBM.waitExplicitClickable(driver, see360View);
		see360View.click();
		WebElement price360 = driver.findElement(By.cssSelector(" .header-content>.u-fs18>strong>span"));
		UtilHBM.waitExplicitDisplayed(driver, price360);
		UtilHBM.setProperty("testData", "LaCartePrice", price360.getText().substring(1));
		WebElement buy360Images = driver
				.findElement(By.cssSelector(" .button.button--l.u-mtm.flex-self-left"));
		buy360Images.click();
		return PageFactory.initElements(driver, Payment.class);
	}

	public UserProfilePage goToMyProfile() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitExplicitClickable(driver, userAvatar);
		Actions action = new Actions(driver);
		action.moveToElement(userAvatar).build().perform();
		UtilHBM.waitExplicitClickable(driver, myProfile);
		myProfile.click();
		return PageFactory.initElements(driver, UserProfilePage.class);
	}
	
	
	public void openFirstTab(){	
		driver.close();
		for(String handle:driver.getWindowHandles()) {			
			driver.switchTo().window(handle);
		}
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
	
	public UserHomePage verifyPageTitle() {
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//section/div/div/h1[contains(text(),'Welcome')]")));
		String pageTitle = driver.getTitle();
		if (pageTitle.equals("HomeByMe - Home")) {
			UtilHBM.reportOK("Userhome page page displayed!!");
		} else {
			UtilHBM.reportKO("userhome page page not displayed!!");
			Assert.assertFalse(pageTitle.contains("Error"));
		}
		return this;
	}
	
	public UserHomePage verifyFirstProject(String expectedProjectName, boolean isTurntableExpected) {
		UtilHBM.waitExplicitDisplayed(driver, latestProjectList.get(0));
		WebElement firstProject = latestProjectList.get(0);
		UtilHBM.turnOffImplicitWaits(driver);
		List<WebElement> placeholder = firstProject
				.findElements(By.cssSelector("div.media-thumb>a>div[class='media-placeholder']>img[src*='placeholder']"));
		List<WebElement> turntable = firstProject.findElements(By.cssSelector("div.media-thumb>a>img[src*='turntable']"));
		UtilHBM.turnOnImplicitWaits(driver);
		if (!turntable.isEmpty() && isTurntableExpected) {
			UtilHBM.reportOK("Turntable displayed for first project in userhome page!! isTurntableExpected : " + isTurntableExpected);
		} else if (!placeholder.isEmpty() && !isTurntableExpected) {
			UtilHBM.reportOK("Palceholder displayed for first project in userhome page!! isTurntableExpected : " + isTurntableExpected);
		} else {
			UtilHBM.reportKO("Turntable and placeholder not displayed for first project in userhome page!! isTurntableExpected : "
					+ isTurntableExpected);
		}
		String projectName = firstProject.findElement(By.cssSelector("div.media-legend>p>a")).getText().trim();
		Verification.VerifyEquals("Wrong project name displayed for first project!!", projectName, expectedProjectName);
		Verification.displayOfWebElement(firstProject.findElement(By.cssSelector("div.media-legend>time")));
		return this;
	}
	
	
	/*---------------------Following methods are used for mobile automation---------------------*/

	public HeaderMenusMobile clickHeaderMenuMobile() {
		UtilHBM.waitExplicitDisplayed(driver, headerMenuMobile);
		UtilHBM.waitExplicitClickable(driver, headerMenuMobile);
		headerMenuMobile.click();
		return PageFactory.initElements(driver, HeaderMenusMobile.class);
	}
	

	public UserHomePage closePlayStoreBanner() {
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector(".smartbanner-close")));
		UtilHBM.waitExplicitClickable(driver, driver.findElement(By.cssSelector(".smartbanner-close")));
		driver.findElement(By.cssSelector(".smartbanner-close")).click();
		return this;
	}
	
}