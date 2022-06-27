package hr.web.pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import hr.planner.pageObject.HomePlanner;

public class LandingPageHR {

	WebDriver driver;

	public LandingPageHR(WebDriver driver) {
		this.driver = driver;
	}// constructor- no return type

	@FindBy(xpath = "//body[@class='homepage']/div/div/header/div//nav/div//ul/li[@class='plan']/button")
	private WebElement planMyRoom;

	@FindBy(xpath = "//body[@class='homepage']/div/div/header/div//nav/div//ul/li[@class='login']/button")
	private WebElement login;

	@FindBy(xpath = "//body[@class='homepage']/div/div/header/div//nav/div//ul/li[@class='cart']/button")
	private WebElement cart;
	
	@FindBy(xpath = "//nav/div/ul/li[@class='login overlay-user']/button")
	private WebElement myAccount;
	
	@FindBy(xpath = "//section/div/ul/li[@data-ui-action='open-projects']/button")
	private WebElement myProjects;
	
	@FindBy(xpath = "//section/div/ul/li[@data-ui-action='user-logout']/button")
	private WebElement logOut;
	
	@FindBy(xpath = "//div/div[@class='push-container-inner']/div[@class='text']/a")
	private WebElement showNow1;
	
	@FindBy(xpath = "//div/div[@class='wrap']/div[@class='text']/a")
	private WebElement showNow2;
	
	@FindBy(css = ".wrap>.logo-container>.logo")
	private WebElement logo;
	
	public void verifyLoginPage() {

		Verification.displayOfWebElement(planMyRoom);
		Verification.displayOfWebElement(login);
		Verification.displayOfWebElement(cart);
		Verification.displayOfWebElement(logo);
	}
	
	public LandingPageHR login(SignUpData signUpData) {
		
		clickLogin()//return to login page
		.login(signUpData);
		UtilHBM.waitExplicitDisplayed(driver, myAccount);;
		return PageFactory.initElements(driver, LandingPageHR.class);
		
		}
		
	public Login clickLogin() {

		login.click();
		return PageFactory.initElements(driver, Login.class);
	}
	
	public HomePlanner planMyRoomClick() {
	Verification.displayOfWebElement(logo);
	planMyRoom.click();
	UtilHBM.waitFixTime(1000);
	if (driver.getCurrentUrl().contains("staging"))
		driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src*='https://preprod-staging-home.enterprise-dev.by.me/Planner']"));
	else
	driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src*='https://preprod-home.enterprise-dev.by.me/Planner']"));
	UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".loader"));
	UtilHBM.waitTillElementDisappear(driver, ".loader");
	UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver, "//main[@role='main']/div/div/div/div/ul/li/button[@id='draw-plan']"));
	UtilHBM.waitFixTime(3000);
	return PageFactory.initElements(driver, HomePlanner.class);
	
	}
	
	public MyProject myProjects() {		
		Verification.displayOfWebElement(logo);
		new Actions(driver).moveToElement(myAccount).build().perform();
		UtilHBM.waitExplicitClickable(driver, myProjects);
		myProjects.click();
		driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src*='https://preprod-widgets.enterprise-dev.by.me/MyProjectsView/embed.html']"));
		UtilHBM.waitExplicitDisplayed(driver, "//li[@class='project-list-item new-project']");
		return PageFactory.initElements(driver, MyProject.class);
	}
	
	public LandingPageHR logOut() {		
		Verification.displayOfWebElement(logo);
		UtilHBM.waitExplicitClickable(driver, myAccount);
		myAccount.click();
		UtilHBM.waitExplicitClickable(driver, logOut);
		logOut.click();
		return PageFactory.initElements(driver, LandingPageHR.class);
	}

	public ProductPage clickShowMore1() {
		UtilHBM.waitExplicitClickable(driver, showNow1);
		showNow1.click();
		return PageFactory.initElements(driver, ProductPage.class);
	}	
	
	public ProductPage clickShowmore2()	{
		UtilHBM.waitExplicitClickable(driver, showNow2);
		showNow2.click();
		return PageFactory.initElements(driver, ProductPage.class);
	}	
}
