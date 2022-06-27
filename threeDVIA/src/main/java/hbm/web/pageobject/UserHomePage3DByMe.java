package hbm.web.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class UserHomePage3DByMe {

	WebDriver driver;

	public UserHomePage3DByMe(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "div#xby_projectspage>div>div>div.logo")
	private WebElement logo3DByMe;

	@FindBy(css = "div#onboarding0>div>div>div.logo")
	private WebElement logoOnBoarding3DByMe;

	@FindBy(css = "div#onboarding0>div>div.middle>h1")
	private WebElement OnBoarding3DByMeSrn0Title;

	@FindBy(css = "div#onboarding0>div>div.middle>span")
	private WebElement OnBoarding3DByMeSrn0Text;

	@FindBy(css = "div#onboarding1>div>div.top>h1")
	private WebElement OnBoarding3DByMeSrn1Title;

	@FindBy(css = "div#onboarding1>div>div.top>span")
	private WebElement OnBoarding3DByMeSrn1Text1;

	@FindBy(css = "div#onboarding1>div>div.bottom>span")
	private WebElement OnBoarding3DByMeSrn1Text2;

	@FindBy(css = "div#onboarding2>div>div.top>h1")
	private WebElement OnBoarding3DByMeSrn2Title;

	@FindBy(css = "div#onboarding2>div>div.top>span")
	private WebElement OnBoarding3DByMeSrn2Text1;

	@FindBy(css = "div#onboarding2>div>div.bottom>span")
	private WebElement OnBoarding3DByMeSrn2Text2;

	@FindBy(css = "div#onboarding3>div>div.top>h1")
	private WebElement OnBoarding3DByMeSrn3Title;

	@FindBy(css = "div#onboarding3>div>div.top>span")
	private WebElement OnBoarding3DByMeSrn3Text1;

	@FindBy(css = "div#onboarding3>div>div.bottom>span")
	private WebElement OnBoarding3DByMeSrn3Text2;

	@FindBy(css = "div#onboarding4>div>h1.title")
	private WebElement OnBoarding3DByMeSrn4Title;

	@FindBy(css = "div.bottom>div.button-container>button.bigblueskip.skipbutton")
	private WebElement OnBoardingSkipButton;

	@FindBy(css = "div.bottom>div.button-container>button.bigblue.nextbutton")
	private WebElement OnBoardingNextButton;

	@FindBy(css = "div.navigation>a.nav.close.right")
	private WebElement OnBoardingCloseButton;

	@FindBy(css = "div.navigation>a.nav.back.left")
	private WebElement OnBoardingBackButton;

	@FindBy(css = "div#projects-gallery-container>div>div>div>h1")
	private WebElement myProjectsTitle;

	@FindBy(css = "div#projects-gallery-container>div>div>div>span")
	private WebElement myProjectsText;

	@FindBy(css = "div#xby_projectspage>div>div>div.my_projects")
	private WebElement myProjectsLink;

	@FindBy(css = "div#xby_projectspage>profile>div.profile-container>div")
	private WebElement profileAvatar;

	@FindBy(css = "div#projects-gallery-container>div>div>div#createBtn")
	private WebElement createProjectButton;

	@FindBy(css = "div#project-list-container>gallery-item")
	private List<WebElement> projectList;

	@FindBy(css = "profile#profile>div.profile-flyout>div:nth-child(1)")
	private WebElement myProfile;

	@FindBy(css = "profile#profile>div.profile-flyout>div:nth-child(2)")
	private WebElement myAccount;

	@FindBy(css = "profile#profile>div.profile-flyout>div[id='logout']")
	private WebElement logout;
	
	@FindBy(xpath = "//div[@id='projectonboarding6']/div/h1")
	private WebElement projectOnboarding6Header;
	
	@FindBy(xpath = "//div[@id='projectonboarding6']/div/div/div/div/input[@id='projectname']")
	private WebElement projectOnboarding6Input;
	
	@FindBy(xpath = "//div[@id='projectonboarding6']/div/div/button[@id='projectNameButton'][@disabled]")
	private WebElement projectOnboarding6OKDisabled;
	
	@FindBy(xpath = "//div[@id='projectonboarding6']/div/div/button[@id='projectNameButton']")
	private WebElement projectOnboarding6OK;
	
	@FindBy(xpath = "//div[@class='card-container content-wrapped mainshop']/div/p[text()='Sheet']")
	private WebElement sheetProduct;

	@FindBy(xpath = "//button[@id='add-to-project'][text()='Add to project']")
	private WebElement addToProject;
	
	@FindBy(xpath = "//button[@id='okButton'][text()='OK']")
	private WebElement okButton;
	
	@FindBy(id = "show-settings")
	private WebElement showSettings;
	
	@FindBy(xpath = "//button[text()='Delete this Project']")
	private WebElement deleteThisProject;
	
	@FindBy(id = "delete-project-confirm")
	private WebElement deleteProjectConfirm;
	
	public ProjectPage3DByMe verifyOnBoardingScreens() {
		UtilHBM.waitExplicitDisplayed(driver, logoOnBoarding3DByMe);
		Verification.displayOfWebElement(logoOnBoarding3DByMe);
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitDisplayed(driver, OnBoarding3DByMeSrn0Title);
		Verification.VerifyEquals("Wrong OnBoarding3DByMeSrn0Title", OnBoarding3DByMeSrn0Title.getText(),
				"Design and make your own custom furniture");
		Verification.VerifyEquals("Wrong OnBoarding3DByMeSrn0Text", OnBoarding3DByMeSrn0Text.getText(),
				"Personalize your space using 3DByMe");
		Verification.displayOfWebElement(OnBoardingSkipButton);
		UtilHBM.waitExplicitClickable(driver, OnBoardingNextButton);
		OnBoardingNextButton.click();
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitDisplayed(driver, OnBoarding3DByMeSrn1Title);
		Verification.VerifyEquals("Wrong OnBoarding3DByMeSrn1Title", OnBoarding3DByMeSrn1Title.getText(), "Design");
		Verification.VerifyEquals("Wrong OnBoarding3DByMeSrn1Text1", OnBoarding3DByMeSrn1Text1.getText(),
				"With real life materials");
		Verification.VerifyEquals("Wrong OnBoarding3DByMeSrn1Text2", OnBoarding3DByMeSrn1Text2.getText(),
				"Quickly drag and snap materials into place. Capture plans that update as you build.");
		Verification.displayOfWebElement(OnBoardingSkipButton);
		UtilHBM.waitExplicitClickable(driver, OnBoardingNextButton);
		OnBoardingNextButton.click();
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitDisplayed(driver, OnBoarding3DByMeSrn2Title);
		Verification.VerifyEquals("Wrong OnBoarding3DByMeSrn1Title", OnBoarding3DByMeSrn2Title.getText(), "Imagine");
		Verification.VerifyEquals("Wrong OnBoarding3DByMeSrn1Text1", OnBoarding3DByMeSrn2Text1.getText(),
				"In your space");
		Verification.VerifyEquals("Wrong OnBoarding3DByMeSrn1Text2", OnBoarding3DByMeSrn2Text2.getText(),
				"Open your designs in HomeByMe for space planning and high-quality rendering.");
		Verification.displayOfWebElement(OnBoardingSkipButton);
		UtilHBM.waitExplicitClickable(driver, OnBoardingNextButton);
		OnBoardingNextButton.click();
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitDisplayed(driver, OnBoarding3DByMeSrn3Title);
		Verification.VerifyEquals("Wrong OnBoarding3DByMeSrn1Title", OnBoarding3DByMeSrn3Title.getText(), "Make");
		Verification.VerifyEquals("Wrong OnBoarding3DByMeSrn1Text1", OnBoarding3DByMeSrn3Text1.getText(),
				"Your design come to life");
		Verification.VerifyEquals("Wrong OnBoarding3DByMeSrn1Text2", OnBoarding3DByMeSrn3Text2.getText(),
				"Create plans for your finished project. Review steps, materials, and cut lists.");

		Verification.displayOfWebElement(OnBoardingSkipButton);
		Verification.displayOfWebElement(OnBoardingCloseButton);
		Verification.displayOfWebElement(OnBoardingBackButton);
		UtilHBM.waitExplicitClickable(driver, OnBoardingNextButton);
		OnBoardingNextButton.click();
		return PageFactory.initElements(driver, ProjectPage3DByMe.class);
	}

	public UserHomePage3DByMe clickCloseOnBoarding() {
		UtilHBM.waitExplicitDisplayed(driver, logoOnBoarding3DByMe);
		Verification.displayOfWebElement(logoOnBoarding3DByMe);
		UtilHBM.waitExplicitClickable(driver, OnBoardingSkipButton);
		OnBoardingSkipButton.click();
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitDisplayed(driver, OnBoardingCloseButton);
		UtilHBM.waitExplicitClickable(driver, OnBoardingCloseButton);
		OnBoardingCloseButton.click();
		return this;
	}

	public UserHomePage3DByMe verifyPage() {
		UtilHBM.waitExplicitDisplayed(driver, logo3DByMe);
		UtilHBM.waitExplicitDisplayed(driver, myProjectsTitle);
		Verification.VerifyEquals("Wrong myProjectsTitle", myProjectsTitle.getText(), "My projects");
		Verification.VerifyEquals("Wrong myProjectsText", myProjectsText.getText(),
				"Your first ten projects are free. Have fun creating!");
		Verification.VerifyEquals("Wrong myProjectsLink text", myProjectsLink.getText(), "My projects");
		Verification.VerifyEquals("Wrong createProjectButton text", createProjectButton.getText(), "Create a project");
		boolean isProjectListEmpty = true;
		UtilHBM.turnOffImplicitWaits(driver);
		isProjectListEmpty = projectList.isEmpty();
		UtilHBM.turnOnImplicitWaits(driver);
		if (!isProjectListEmpty) {
			WebElement expectedProject = projectList.get(0);
			UtilHBM.waitExplicitDisplayed(driver, expectedProject);
			String ProjectPreviewSrc = expectedProject.findElement(By.cssSelector("div>div>img")).getAttribute("src");
			String projectName = expectedProject.findElement(By.cssSelector("div>div>div>h1")).getText();
			if (ProjectPreviewSrc.contains("https://")) {
				UtilHBM.reportOK("ProjectPreview displayed");
			} else {
				UtilHBM.reportKO("ProjectPreview not displayed!!");
			}
			UtilHBM.reportInfo("Project displayed at index1 : " + projectName);
		}
		Verification.displayOfWebElement(profileAvatar);
		Actions actions = new Actions(driver);
		actions.moveToElement(profileAvatar).build().perform();
		UtilHBM.waitExplicitDisplayed(driver, logout);
		Verification.VerifyEquals("Wrong myProfile", myProfile.getText(), "My profile");
		Verification.VerifyEquals("Wrong myAccount", myAccount.getText(), "Account");
		Verification.displayOfWebElement(logout);
		return this;
	}

	public ConfirmLogout3DByMe logout() {
		Verification.displayOfWebElement(profileAvatar);
		Actions actions = new Actions(driver);
		actions.moveToElement(profileAvatar).build().perform();
		UtilHBM.waitExplicitDisplayed(driver, logout);
		logout.click();
		return PageFactory.initElements(driver, ConfirmLogout3DByMe.class);

	}
	

}
