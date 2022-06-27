package hbm.web.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class Magazine {
	WebDriver driver;

	public Magazine(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//header[@id='bar']/div/nav[@class='header__nav']/a[contains(@href,'/en/inspiration')]")
	public WebElement inspirationLink;

	@FindBy(css = "header[id='bar']>div.header__container.row>nav.header__nav>a[href$='/en/offers/']")
	public WebElement offersLink;

	@FindBy(xpath = "//header[@id='bar']/div/nav[@class='header__nav']/a/span[contains(text(),'My projects')]")
	private WebElement myProjects;

	@FindBy(xpath = "//header[@id='bar']/div/nav[@class='header__nav']/a/span[contains(text(),'My Collections')]")
	private WebElement myCollections;

	@FindBy(xpath = "//header[@id='bar']/div/nav[@class='header__nav']/span[@class='header_nav_item header__nav__account dropdown is-open']/div/div/a[contains(text(),'My profile')]")
	private WebElement myProfile;

	@FindBy(xpath = "//header[@id='bar']/div/nav[@class='header__nav']/span[@class='header_nav_item header__nav__account dropdown is-open']/div/div/a[contains(text(),'Back office')]")
	private WebElement backOffice;

	@FindBy(xpath = "//header[@id='bar']/div/nav[@class='header__nav']/span[@class='header_nav_item header__nav__account dropdown is-open']/div/div/a[contains(text(),'Account')]")
	private WebElement accountLink;

	@FindBy(xpath = "//header[@id='bar']/div/nav[@class='header__nav']/span[@class='header_nav_item header__nav__account dropdown is-open']/div/div/a[contains(text(),'Staff pick')]")
	private WebElement staffPicks;
	
	@FindBy(xpath = "//header[@id='bar']/div/nav[@class='header__nav']/span[@class='header_nav_item header__nav__account dropdown']")
	private WebElement userAvatar;
	
	@FindBy(xpath = "//header[@id='bar']/div/nav[@class='header__nav']/span[@class='header_nav_item header__nav__account dropdown is-open']/div/div/a[contains(text(),'Logout')]")
	private WebElement logout;
	
	@FindBy(xpath = "//header[@id='bar']/div/a[@class='header__logo']")
	private WebElement hbmLogo;

	public DecorationInspiration goToInspiration() {
		UtilHBM.waitExplicitDisplayed(driver, inspirationLink);
		UtilHBM.waitExplicitClickable(driver, inspirationLink);
		Verification.VerifyEquals("Wrong inspiration link text displayed!!",
				inspirationLink.findElement(By.tagName("span")).getText(), "Inspiration");
		UtilHBM.reportInfo("Clicking on inspiration page link!!");
		inspirationLink.click();
		return PageFactory.initElements(driver, DecorationInspiration.class);
	}

	public OurOffers goToOffers() {
		offersLink.click();
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "div.page.page--pricing"));
		return PageFactory.initElements(driver, OurOffers.class);
	}

	public MyProjects goToMyProjects() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
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
	
	public UserHomePage clickHBMLogo() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitExplicitClickable(driver, hbmLogo);
		hbmLogo.click();
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public LandingPage goToLandingPage() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitExplicitClickable(driver, hbmLogo);
		hbmLogo.click();
		return PageFactory.initElements(driver, LandingPage.class);
	}

	public MyAccount goToAccountPage() {
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

	public UserProfilePage goToMyProfile() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitExplicitClickable(driver, userAvatar);
		Actions action = new Actions(driver);
		action.moveToElement(userAvatar).build().perform();
		UtilHBM.waitExplicitClickable(driver, myProfile);
		myProfile.click();
		return PageFactory.initElements(driver, UserProfilePage.class);
	}
	
	public LandingPage logout(){
		UtilHBM.reportInfo("Logging out from RS4 page!!");
			Actions action = new Actions(driver);			
			action.moveToElement(userAvatar).build().perform();
			UtilHBM.waitExplicitClickable(driver, logout);
			logout.click();					
			return PageFactory.initElements(driver, LandingPage.class);
	}

}
