package kitchen.bryo.pageObject;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StartNow {

	WebDriver driver;

	public StartNow(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "body>div>main>div>div>div>div>a[href='./home-page.html']")
	private WebElement startNowButton;

	@CacheLookup
	@FindBy(css = "button[data-ui-action='launch-app']")
	private WebElement launchButton;

	@FindBy(css = "#locale-selector")
	private WebElement localeInput;

	@FindBy(css = "button[data-launch='fromScratch']")
	private WebElement startFromScratch;

	@FindBy(css = "button[data-locale='en-GB']")
	private WebElement startGBDemo;

	@FindBy(css = "button[data-locale='es-ES']")
	private WebElement startESDemo;
	
	@FindBy(css = "button[data-locale='fr-FR']")
	private WebElement startFRDemo;
	
	@FindBy(css = "button[data-locale='ar-EG']")
	private WebElement startEGDemo;
	
	@FindBy(xpath = "//button[@id='login-button']")
	private WebElement user;

	@FindBy(css = ".mod-overlay-container.mod-open ul>li>button[data-ui-action='open-projects-from-user-menu']")
	private WebElement myProjects;

	@FindBy(css = "ul>li>button[data-ui-action='open-projects-from-user-menu']")
	private WebElement myProjectsMobile;
	
	@FindBy(css = "body>div>main>div>div>div>div>a[href='./apps/kitchen/?state=3']")
	private WebElement skipInspirationPhase;

	@FindBy(xpath = "//article[@class='mod-layer-my-projects mod-open']")
	private List<WebElement> projectOverlay;

	@FindBy(css = "input.room.Tag3D.visibility-visible")
	private WebElement roomLabel;

	@FindBy(css = "ul>li[class='project-list-item']>div>div[class='img']>img[src^='https']")
	private WebElement projectImg;

	@FindBy(css = "ul>li[class='project-list-item']>div>div>p[class='name']")
	private WebElement projectName;

	@FindBy(css = "ul>li[class='project-list-item']>div>div>p[class='desc']")
	private WebElement projectDesc;

	@FindBy(css = "ul>li[class='project-list-item']>div>div>p[class='date']")
	private WebElement projectDate;

	@FindBy(id = "projects-button")
	private WebElement ikeaMyProjectsButton;

	@FindBy(css = ".mod-overlay-container.mod-open button[data-ui-action='logout']")
	private WebElement logout;

	@FindBy(xpath="//span[@data-ui-selector='rtl-reading']/label[@for='rtl-reading']/following-sibling::span/input[@id='rtl-reading']")
	private WebElement activateRTL;

	@FindBy(css = "div#splash div.spinner")
	private WebElement spinnerOnLoadingScreen;

	@FindBy(css = "span.logo>img.hbm-logo-text")
	private WebElement hbmLogo;

	@FindBy(css = "span.logo>img.brand-logo")
	private WebElement brandLogo;

	@FindBy(css = "header>.wrapper>.mobile-menu>button[data-ui-action='open-mobile-menu']")
	private WebElement mobileMenu;
	@FindBy(css = "nav>.wrapper>ul>li>button[data-launch='fromScratch']")
	private WebElement fromScratchMobile;
	
	public FloorPlan launchApp() {
		UtilHBM.waitExplicitDisplayed(driver, launchButton);
		UtilHBM.waitExplicitClickable(driver, launchButton);
		UtilHBM.scrollToElementWithOffset(driver, launchButton, 0);
		launchButton.click();
		System.out.println("Launch App");
		UtilHBM.waitFixTime(8500);
		if(driver.getCurrentUrl().contains("bathroom")){
			switchFrameBathroom();
		}else ikeaSwitchFrame();
		return PageFactory.initElements(driver, FloorPlan.class);
	}
	
	public FloorPlan launchIKEAApp() {
		UtilHBM.waitExplicitDisplayed(driver, launchButton);
		UtilHBM.waitExplicitClickable(driver, launchButton);
		UtilHBM.scrollToElementWithOffset(driver, launchButton, 0);
		launchButton.click();
		
		System.out.println("Launch App");
		UtilHBM.waitFixTime(8500);
		if(driver.getCurrentUrl().contains("bathroom")){
			switchFrameBathroom();
		}else ikeaSwitchFrame();
		return PageFactory.initElements(driver, FloorPlan.class);
	}
	public FloorPlan launchRTLApp() {
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//span[@data-ui-selector='rtl-reading']")));
		System.out.println(driver.findElement(By.xpath("//span[@data-ui-selector='rtl-reading']")).getText());
		
//		UtilHBM.waitExplicitClickable(driver, activateRTL);
		activateRTL.click();
		UtilHBM.waitFixTime(1000);
		launchApp();
		return PageFactory.initElements(driver, FloorPlan.class);
	}
	public FloorPlan startNow() {
		UtilHBM.waitFixTime(2500);
//		UtilHBM.waitExplicitDisplayed(driver, demoForUK);
		if (!startGBDemo.isDisplayed()) {
			UtilHBM.reportKO("Start Demo for UK not displayed");
		} else {
			UtilHBM.reportOK("Start Demo for UK displayed");
		}
		startGBDemo.click();
		UtilHBM.waitTillElementDisappear(driver, ".mod-layer-welcome");
		return PageFactory.initElements(driver, FloorPlan.class);
	}
	public StartNow startDemo(String language) {
		UtilHBM.waitFixTime(2500);
		switch (language) {
		case "en-GB":
			startGBDemo.click();
			UtilHBM.waitFixTime(1000);
			break;
		case "es-ES":
			startESDemo.click();
			UtilHBM.waitFixTime(1000);
			break;
		case "fr-FR":
			startFRDemo.click();
			UtilHBM.waitFixTime(1000);
			break;
		case "ar-EG":
			startEGDemo.click();
			UtilHBM.waitFixTime(1000);
			break;
		}
		return PageFactory.initElements(driver, StartNow.class);
	}

	public FloorPlan startFromScratch() {
		UtilHBM.waitExplicitDisplayed(driver, startFromScratch);
		UtilHBM.waitExplicitClickable(driver, startFromScratch);
		startFromScratch.click();
		System.out.println("Launch App");

		//KIT-1001 : As a kitchen retailer, I have a branded screen while the solution is loading
		UtilHBM.waitExplicitDisplayed(driver,"//iframe[contains(@src,'kitchen.enterprise')]");
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src*='kitchen.enterprise']")));
		UtilHBM.waitExplicitDisplayed(driver, spinnerOnLoadingScreen);
		UtilHBM.reportOK("spinnerOnLoadingScreen displayed");

		UtilHBM.waitExplicitDisplayed(driver, hbmLogo);
		UtilHBM.reportOK("hbmLogo displayed");
		Verification.VerifyEquals("Correct hbmLogo not displayed", hbmLogo.getAttribute("src") ,"https://preprod-kitchen.enterprise-dev.by.me/Kitchen/assets/images/HBM-logo-text-black.svg");

		UtilHBM.waitExplicitDisplayed(driver, brandLogo);
		UtilHBM.reportOK("brandLogo displayed");
		if(brandLogo.getAttribute("src").startsWith("blob:https://preprod-kitchen.enterprise-dev.by.me/"))
			UtilHBM.reportOK("Correct brandLogo displayed, brandLogo src : " + brandLogo.getAttribute("src"));
		else UtilHBM.reportKO("Correct brandLogo not displayed, brandLogo src : " +brandLogo.getAttribute("src"));
		//KIT-1001 : end

		UtilHBM.waitFixTime(2000);
//		switchFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src*='kitchen.enterprise']")));		
		UtilHBM.waitExplicitDisplayed(driver, roomLabel);
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan ikeaSwitchFrame() {
		 UtilHBM.waitFixTime(8500);
		List<WebElement> frames = driver.findElements(By.cssSelector("#embedded-kitchen-app>iframe"));
		driver.switchTo().frame(frames.get(0));
		System.out.println("Frame: " + frames);
		UtilHBM.waitFixTime(8500);
		UtilHBM.waitExplicitDisplayed(driver, roomLabel);
		Verification.displayOfWebElement(roomLabel);
		Verification.displayOfWebElement(driver.findElement(By.cssSelector(".room.Tag3D>span")));
		UtilHBM.waitFixTime(2500);
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan switchFrameBathroom() {
		// UtilHBM.waitFixTime(2500);
		List<WebElement> frames = driver.findElements(By.cssSelector("#embedded-bathroom-app>iframe"));
		driver.switchTo().frame(frames.get(0));
		System.out.println("Frame: " + frames);
		UtilHBM.waitFixTime(2500);
		UtilHBM.waitExplicitDisplayed(driver, roomLabel);
		Verification.displayOfWebElement(roomLabel);
		Verification.displayOfWebElement(driver.findElement(By.cssSelector(".room.Tag3D>span")));
		UtilHBM.waitFixTime(2500);
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public FloorPlan switchFrame() {
		// UtilHBM.waitFixTime(2500);		
		driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src*='kitchen.enterprise']"));
		UtilHBM.waitFixTime(2500);
		UtilHBM.waitExplicitDisplayed(driver, roomLabel);
		Verification.displayOfWebElement(roomLabel);
		Verification.displayOfWebElement(driver.findElement(By.cssSelector(".room.Tag3D>span")));
		UtilHBM.waitFixTime(2500);
		return PageFactory.initElements(driver, FloorPlan.class);
	}

	public StartNow login(SignUpData signUpData) {
		user.click();
		KitchenLogin login = PageFactory.initElements(driver, KitchenLogin.class);
		login.loginUsingMainPage(signUpData);
		return PageFactory.initElements(driver, StartNow.class);
	}

	// Use only for IKEA test
	public StartNow ikeaLogin(SignUpData signUpData) {
		KitchenLogin login = PageFactory.initElements(driver, KitchenLogin.class);
		login.ikeaLoginUsingMainPage(signUpData);
		return PageFactory.initElements(driver, StartNow.class);
	}
	public StartNow setAppDist(String appDist, String lang) {
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//label[@for='app-distrib-dropdown']")));
		Select oSelect = new Select(driver.findElement(By.xpath("//select[@id='currency-select-test']")));
		oSelect.selectByVisibleText(appDist);
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//input[@data-ui-selector='app-distrib-custom']")));
		driver.findElement(By.xpath("//input[@data-ui-selector='app-distrib-custom']")).sendKeys(lang);
		return PageFactory.initElements(driver, StartNow.class);
	}
	public StartNow logout() {		
		UtilHBM.waitExplicitDisplayed(driver, user);
		new Actions(driver).moveToElement(user).build().perform();
		UtilHBM.waitExplicitDisplayed(driver, logout);
		UtilHBM.waitExplicitClickable(driver, logout);
		logout.click();
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "button[class='bt-icon'][id='login-button']"));
		UtilHBM.reportOK("Logout success");
		return PageFactory.initElements(driver, StartNow.class);
	}

	public StartNow reloadApplication() {
		UtilHBM.waitFixTime(2500);
		driver.switchTo().alert().dismiss();
		return PageFactory.initElements(driver, StartNow.class);
	}
	public StartNow refreshApplication() {
		try {
			driver.navigate().refresh();
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			System.out.println("Alert data: " + alertText);
			alert.accept();
			driver.switchTo().parentFrame();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		return PageFactory.initElements(driver, StartNow.class);
	}
	public IKEAMyProjects ikeaOpenMyProjectList() {
		UtilHBM.waitFixTime(2500);
		driver.switchTo().parentFrame();
		UtilHBM.waitExplicitDisplayed(driver, ikeaMyProjectsButton);
		UtilHBM.waitExplicitClickable(driver, ikeaMyProjectsButton);
		ikeaMyProjectsButton.click();

		UtilHBM.waitExplicitDisplayed(driver,
				driver.findElement(By.xpath("//article[@class='mod-layer-my-projects mod-open']")));
//		Verification.displayOfWebElement(projectImg);
//		Verification.displayOfWebElement(projectName);
//		Verification.displayOfWebElement(projectDate);
//		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("ul>li[class='project-list-item']")));
		UtilHBM.waitFixTime(2500);
		return PageFactory.initElements(driver, IKEAMyProjects.class);
	}

	public MyProjects openMyProjectList() {

//		userActions();
//		@SuppressWarnings("deprecation")
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(1000, TimeUnit.SECONDS)
//				.pollingEvery(1000, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
//		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
//			public Boolean apply(WebDriver driver) {
//				WebElement element =driver.findElement(
//						By.xpath("//article[@class='mod-layer-my-projects mod-open']/div/main/div/div/div[@class='content']"));
//				
//				if (element.isDisplayed()) {
//					Verification.displayOfWebElement(projectImg);
//					Verification.displayOfWebElement(projectName);
//					Verification.displayOfWebElement(projectDesc);
//					Verification.displayOfWebElement(projectDate);
//					return true;
//				}
//				return false;
//			}
//		};
//
//		wait.until(function);
		/*
		 * for (int i = 0; i > projectOverlay.size(); i++) {
		 * UtilHBM.waitTillElementDisappear(driver, ".mod-loader"); if
		 * (!driver.findElement(By.
		 * xpath("//article[@class='mod-layer-my-projects mod-open']/div/main/div/div/div[@class='content']"
		 * )).isDisplayed()) { UtilHBM.waitFixTime(6500); } else {
		 * UtilHBM.waitFixTime(2000); break; } }
		 */

		UtilHBM.waitExplicitDisplayed(driver, user);
		UtilHBM.waitExplicitClickable(driver, user);

		user.click();
		new Actions(driver).moveToElement(user).build().perform();
		UtilHBM.waitExplicitDisplayed(driver, myProjects);
		UtilHBM.waitExplicitClickable(driver, myProjects);
		new Actions(driver).moveToElement(myProjects).build().perform();
		myProjects.click();
		UtilHBM.reportOK("My project clicked");
//		UtilHBM.waitExplicitDisplayed(driver,
//				driver.findElement(By.xpath("//ul/li[@class='project-list-item new-project ']")));
//		Verification.displayOfWebElement(projectImg);
//		Verification.displayOfWebElement(projectName);
//		Verification.displayOfWebElement(projectDate);
//		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("ul>li[class='project-list-item']")));
		UtilHBM.waitFixTime(2500);
		driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src*='https://preprod-widgets.enterprise-dev.by.me/MyProjectsView/embed.html']"));
		return PageFactory.initElements(driver, MyProjects.class);
	}
	public MyProjects openMyProjectListStaging() {
		UtilHBM.waitExplicitDisplayed(driver, user);
		UtilHBM.waitExplicitClickable(driver, user);
		user.click();
		new Actions(driver).moveToElement(user).build().perform();
		UtilHBM.waitExplicitDisplayed(driver, myProjects);
		UtilHBM.waitExplicitClickable(driver, myProjects);
		new Actions(driver).moveToElement(myProjects).build().perform();
		myProjects.click();
		UtilHBM.reportOK("My project clicked");
		UtilHBM.waitFixTime(2500);
		driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src*='https://preprod-staging-widgets.enterprise-dev.by.me/MyProjectsView/embed.html']"));
		return PageFactory.initElements(driver, MyProjects.class);
	}
	public MyProjects userActions() {
		// UtilHBM.waitTillElementDisappear(driver, ".mod-popin-alert-login");
		UtilHBM.waitExplicitDisplayed(driver, user);
		new Actions(driver).moveToElement(user).pause(500).build().perform();
		UtilHBM.waitExplicitDisplayed(driver, myProjects);
		UtilHBM.waitExplicitClickable(driver, myProjects);
		myProjects.click();
		UtilHBM.reportOK("My project clicked");
		return PageFactory.initElements(driver, MyProjects.class);
	}

	public MyProjects user() {
		user.click();
		return PageFactory.initElements(driver, MyProjects.class);
	}

	public StartNow setBryoAccessCode(){
		WebElement accessCode = driver.findElement(By.cssSelector("#access-code"));
		UtilHBM.waitExplicitDisplayed(driver, accessCode);
		accessCode.sendKeys("Next!Gen01");
		return this;
	}
//	<*****************************MOBILE METHODS**********************>
	public FloorPlan startFromScratchMobile() {
		
		UtilHBM.waitExplicitDisplayed(driver, mobileMenu);
		UtilHBM.waitExplicitClickable(driver, mobileMenu);
		mobileMenu.click();
		
		UtilHBM.waitExplicitDisplayed(driver, fromScratchMobile);
		UtilHBM.waitExplicitClickable(driver, fromScratchMobile);
		fromScratchMobile.click();
		System.out.println("Launch App");

		//KIT-1001 : As a kitchen retailer, I have a branded screen while the solution is loading
		UtilHBM.waitExplicitDisplayed(driver,"//iframe[contains(@src,'kitchen.enterprise')]");
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src*='kitchen.enterprise']")));
		UtilHBM.waitExplicitDisplayed(driver, spinnerOnLoadingScreen);
		UtilHBM.reportOK("spinnerOnLoadingScreen displayed");

		UtilHBM.waitExplicitDisplayed(driver, hbmLogo);
		UtilHBM.reportOK("hbmLogo displayed");
		Verification.VerifyEquals("Correct hbmLogo not displayed", hbmLogo.getAttribute("src") ,"https://preprod-kitchen.enterprise-dev.by.me/Kitchen/assets/images/HBM-logo-text-black.svg");

		UtilHBM.waitExplicitDisplayed(driver, brandLogo);
		UtilHBM.reportOK("brandLogo displayed");
		if(brandLogo.getAttribute("src").startsWith("blob:https://preprod-kitchen.enterprise-dev.by.me/"))
			UtilHBM.reportOK("Correct brandLogo displayed, brandLogo src : " + brandLogo.getAttribute("src"));
		else UtilHBM.reportKO("Correct brandLogo not displayed, brandLogo src : " +brandLogo.getAttribute("src"));
		//KIT-1001 : end

		UtilHBM.waitFixTime(2000);
//		switchFrame();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src*='kitchen.enterprise']")));		
		UtilHBM.waitExplicitDisplayed(driver, roomLabel);
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, FloorPlan.class);
	}
	
	public MyProjects openMyProjectListMobile() {

		UtilHBM.waitExplicitDisplayed(driver, mobileMenu);
	
		UtilHBM.waitExplicitDisplayed(driver, myProjectsMobile);
		UtilHBM.waitExplicitClickable(driver, myProjectsMobile);
		new Actions(driver).moveToElement(myProjectsMobile).build().perform();
		myProjectsMobile.click();
		UtilHBM.reportOK("My project clicked");
//		UtilHBM.waitExplicitDisplayed(driver,
//				driver.findElement(By.xpath("//ul/li[@class='project-list-item new-project ']")));
//		Verification.displayOfWebElement(projectImg);
//		Verification.displayOfWebElement(projectName);
//		Verification.displayOfWebElement(projectDate);
//		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("ul>li[class='project-list-item']")));
		UtilHBM.waitFixTime(2500);
		driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src*='https://preprod-widgets.enterprise-dev.by.me/MyProjectsView/embed.html']"));
		return PageFactory.initElements(driver, MyProjects.class);
	}

	public FloorPlan launchBaseApp(String appDistribution, String locale, boolean launchInLite, boolean launchInRTL, boolean enableDefaultProj ) {
		UtilHBM.waitExplicitDisplayed(driver, launchButton);
		UtilHBM.waitExplicitClickable(driver, launchButton);

		if(!locale.isEmpty()){
			localeInput.sendKeys(locale);
		}
		UtilHBM.scrollToElementWithOffset(driver, launchButton, 0);
		launchButton.click();
		System.out.println("Launch App");
		UtilHBM.waitFixTime(8500);
		if(driver.getCurrentUrl().contains("bathroom")){
			switchFrameBathroom();
		}else ikeaSwitchFrame();
		return PageFactory.initElements(driver, FloorPlan.class);
	}
}
