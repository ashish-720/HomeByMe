package kitchen.bryo.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class KitchenLogin {
	WebDriver driver;

	public KitchenLogin(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "button[data-ui-action='save']")
	private WebElement clickSaveIcon;

	@FindBy(css = "article[data-ui-selector='login-popin']")
	private WebElement loginWindow;

	@FindBy(css = ".mod-popin-alert-login.mod-open>div>header>div>div>h3")
	private WebElement loginHeader;

	@FindBy(css = ".mod-popin-alert-login.mod-open>div>header>div>div>b")
	private WebElement loginInfo;

	@FindBy(id = "input-login-name")
	private WebElement userNameTextBox;

	@FindBy(id = "input-login-password")
	private WebElement passwordTextBox;

	@FindBy(id = "input-login-desc")
	private WebElement ikeaPasswordTextBox;

	@FindBy(css = "button[data-ui-action='popin-validate']")
	private WebElement loginButton;

	@FindBy(css = "article[class='mod-popin-login-small mod-open']>div>form>.popin-footer>button[data-ui-action='validate']")
	private WebElement ikeaLoginButton;

	@FindBy(css = ".mod-popin-alert-login.mod-open>div>header>div>div>button[data-ui-action='popin-close']")
	private WebElement closeLoginPopUp;

	@FindBy(css = "b[data-ui-error='error-message']")
	private WebElement invalidCredentialsAlert;

	@FindBy(id = "login-button")
	private WebElement user;

	@FindBy(css = "button[data-ui-action='logout']")
	private WebElement logout;

	@FindBy(css = "a[class='link-soft flex-self-left']")
	private WebElement hbmLogout;

	public KitchenLogin enterUserName(String userName) {
		UtilHBM.waitExplicitClickable(driver, loginButton);
		userNameTextBox.clear();
		userNameTextBox.sendKeys(userName);
		return this;
	}

	public KitchenLogin enterPassword(String password) {
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
		return this;
	}

	// Use only for IKEA test
	public KitchenLogin ikeaEnterUserName(String userName) {
		UtilHBM.waitExplicitClickable(driver, ikeaLoginButton);
		userNameTextBox.clear();
		userNameTextBox.sendKeys(userName);
		return this;
	}
	
	public KitchenLogin ikeaEnterPassword(String password) {
		ikeaPasswordTextBox.sendKeys(password);
		return this;
	}

	public StartNow loginButton() {
		UtilHBM.waitExplicitDisplayed(driver, loginButton);
		UtilHBM.waitExplicitClickable(driver, loginButton);
		loginButton.click();
		UtilHBM.waitTillElementDisappear(driver, ".mod-popin-alert-login.mod-open");
		return PageFactory.initElements(driver, StartNow.class);
	}

	public KitchenLogin loginPopUp() {
		Verification.displayOfWebElement(loginWindow);
		String expectedTitle = "Welcome";
		String expectedInfo = "Please login to your account";
		Verification.VerifyEquals("Login title incorrect ", loginHeader.getText(), expectedTitle);
		Verification.VerifyEquals("Login info incorrect ", loginInfo.getText(), expectedInfo);
		return PageFactory.initElements(driver, KitchenLogin.class);
	}

	public MyProjects login(SignUpData signUpData) {
//		loginPopUp();
		enterUserName(signUpData.getLoginId()).enterPassword(signUpData.getPassword()).loginButton();
		return PageFactory.initElements(driver, MyProjects.class);
	}

	public StartNow loginUsingMainPage(SignUpData signUpData) {		
		return loginPopUp()
				.enterUserName(signUpData.getLoginId())
				.enterPassword(signUpData.getPassword())
				.loginButton();
	}

	public MyProjects ikeaLoginUsingMainPage(SignUpData signUpData) {
		if (user.isDisplayed()) {
			user.click();
			ikeaEnterUserName(signUpData.getLoginId()).ikeaEnterPassword(signUpData.getPassword());
			UtilHBM.waitExplicitDisplayed(driver, ikeaLoginButton);
			UtilHBM.waitExplicitClickable(driver, ikeaLoginButton);
			System.out.println("login: "+ikeaLoginButton.getText());
			new Actions(driver).moveToElement(ikeaLoginButton).build().perform();
			ikeaLoginButton.click();
			
			UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.xpath("//article[@class='mod-popin-login-small']")));
		}

		return PageFactory.initElements(driver, MyProjects.class);
	}

	// Use only for IKEA test
	public MyProjects ikeaLogin(SignUpData signUpData) {

		enterUserName(signUpData.getLoginId()).ikeaEnterPassword(signUpData.getPassword()).ikeaLoginButton.click();

		return PageFactory.initElements(driver, MyProjects.class);
	}

	public KitchenLogin checkLoginForInvalidUser(SignUpData signUpData) {
		enterUserName(signUpData.getLoginId()).enterPassword(signUpData.getPassword());
		loginButton.click();
		if (invalidCredentialsAlert.getText().contains("Invalid credentials."))
			UtilHBM.reportOK("Invalid Login test Successful and account deleted for " + signUpData.getLoginId());
		else
			UtilHBM.reportKO("Login Successful and account not deleted for " + signUpData.getLoginId());
		closeLoginPopUp.click();
		return PageFactory.initElements(driver, KitchenLogin.class);
	}

	public KitchenLogin loginForKitchenHomeByMe(SignUpData signUpData) {
		enterUserName(signUpData.getLoginId()).enterPassword(signUpData.getPassword());
		loginButton.click();
		return PageFactory.initElements(driver, KitchenLogin.class);
	}

	public KitchenLogin hbmLogout() {
		UtilHBM.waitExplicitDisplayed(driver, hbmLogout);
		UtilHBM.waitExplicitClickable(driver, hbmLogout);
		if (hbmLogout.isDisplayed()) {

			UtilHBM.waitExplicitClickable(driver, hbmLogout);
			hbmLogout.click();
			UtilHBM.reportOK("Logout success");
		} else {
			UtilHBM.reportKO("Logout failed");
		}
		return PageFactory.initElements(driver, KitchenLogin.class);
	}
}
