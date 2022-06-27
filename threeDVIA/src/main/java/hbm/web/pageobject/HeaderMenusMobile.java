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

public class HeaderMenusMobile{
	WebDriver driver;
	
	public HeaderMenusMobile(WebDriver driver){
		this.driver = driver;		
	}	
	
	@FindBy(css="header[class='header is-open']>div>button>svg.icon.icon-close")
	WebElement headerMenuMobile;
	
	@FindBy(css="header[class='header is-open']>div>a.header__logo")
	WebElement hbmLogo;
	
	@FindBy(css="header[class='header is-open']>div>div.header__nav>nav>a[href*='/en/offers/']")
	WebElement offers;
	
	@FindBy(css="header[class='header is-open']>div>div.header__nav>nav>a[href*='/en/inspiration']")
	WebElement inspiration;
	
//	@FindBy(css="html>body[class*='show-nav'] .menuMobile .menuMobile-list>li>[title='News']")
//	WebElement news;
	
	@FindBy(css="header[class='header is-open']>div>div.header__nav>nav>a[href*='/en/login']")
	WebElement login;
	
	@FindBy(css="header[class='header is-open']>div>div.header__nav>nav>a[href*='/en/registration']")
	WebElement signup;
	
	@FindBy(css="header[class='headr']>div>nav>a[href='/en/my-projects']")
	WebElement myProjects;
	
	@FindBy(css="html>body[class*='show-nav'] .menuMobile-head>.menuMobile-list>li>[href='/en/my-account']")
	WebElement account;
	
	@FindBy(css="header[class='headr']>div>nav>span>div>div>a[title='Logout']")
	WebElement logout;
	
	
	public void closeHeaderMenuMobile() {
		headerMenuMobile.click();
	}
	
	public HeaderMenusMobile clickHeaderMenuMobile() {
		UtilHBM.waitExplicitClickable(driver,headerMenuMobile);
		headerMenuMobile.click();
		return PageFactory.initElements(driver, HeaderMenusMobile.class);
	}
	
	public LandingPage clickHBMLogoButton() {
		UtilHBM.waitExplicitDisplayed(driver, hbmLogo);
		UtilHBM.waitExplicitClickable(driver, hbmLogo);
		hbmLogo.click();
		return PageFactory.initElements(driver, LandingPage.class);
	}
	
	public OurOffers clickOurOffers() {
		UtilHBM.waitExplicitDisplayed(driver, offers);
		Verification.VerifyEquals("Wrong Offers header menu text", offers.findElement(By.cssSelector("span")).getText(),
				"Offers");
		UtilHBM.waitExplicitClickable(driver, offers);
		offers.click();
		return PageFactory.initElements(driver, OurOffers.class);
	}
	
	public Gallery clickInspiration() {
		UtilHBM.waitExplicitDisplayed(driver, inspiration);
		Verification.VerifyEquals("Wrong inspiration header menu text",
				inspiration.findElement(By.cssSelector("span")).getText(), "Inspiration");
		UtilHBM.waitExplicitClickable(driver, inspiration);
		inspiration.click();
		return PageFactory.initElements(driver, Gallery.class);
	}
	
	public MyAccount clickAccount() {
		UtilHBM.waitExplicitClickable(driver, account);
		account.click();
		return PageFactory.initElements(driver, MyAccount.class);
	}
	
	public MyProjects clickMyProjects() {
//		Actions actions = new Actions(driver);
//		actions.moveToElement(myProjects).build().perform();
		UtilHBM.waitExplicitDisplayed(driver, logout);
		logout.sendKeys(Keys.PAGE_DOWN);
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitDisplayed(driver, myProjects);
		Verification.VerifyEquals("Wrong my project text displayed in header menus!!", myProjects.findElement(By.cssSelector("span")).getText(),"My projects");
		UtilHBM.waitExplicitClickable(driver, myProjects);
		myProjects.click();
		return PageFactory.initElements(driver, MyProjects.class);
	}
	
	public Login clickLogin() {
		UtilHBM.waitExplicitDisplayed(driver, login);
		UtilHBM.waitExplicitClickable(driver, login);
		Verification.VerifyEquals("Wrong Log in header menu text", login.findElement(By.cssSelector("span")).getText(),
				"Log in");
		login.click();
		return PageFactory.initElements(driver, Login.class);
	}
	
	public SignUp clickSignUp() {
		UtilHBM.waitExplicitDisplayed(driver, signup);
		UtilHBM.waitExplicitClickable(driver, signup);
		Verification.VerifyEquals("Wrong signup header menu text", signup.findElement(By.cssSelector("span")).getText(),
				"SIGN UP FREE");
		signup.click();
		return PageFactory.initElements(driver, SignUp.class);
	}
	
	public LandingPage clickLogout() {
		UtilHBM.waitExplicitDisplayed(driver, logout);
		UtilHBM.waitExplicitClickable(driver, logout);
		logout.click();
	return PageFactory.initElements(driver, LandingPage.class);
}
	
	
}
