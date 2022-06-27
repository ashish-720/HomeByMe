package enterprise.bathroom.plannerPO;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import kitchen.bryo.pageObject.KitchenLogin;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BathroomLogin {
    WebDriver driver;

    public BathroomLogin(WebDriver driver) {this.driver=driver;}


    @FindBy(xpath = "//form//div[@class='inner-content']")
    private WebElement loginWindow;

    @FindBy(css = ".mod-popin-login-small.mod-open>div>form>div>h1")
    private WebElement loginHeader;

    @FindBy(css = "div.content>form>footer>button.cta-primary-alt-l")
    private WebElement loginButton;

    @FindBy(css = "div.content>form>footer>button.cta-secondary-l")
    private WebElement cancelButton;

    @FindBy(id = "input-login-name")
    private WebElement userNameTextBox;

    @FindBy(xpath = "//input[@id='input-login-desc']")
    private WebElement passwordTextBox;


    public BathroomLogin enterUserName(String userName) {
        UtilHBM.waitExplicitClickable(driver,loginButton);
        UtilHBM.waitExplicitDisplayed(driver,cancelButton);
        userNameTextBox.clear();
        userNameTextBox.sendKeys(userName);
        return this;
    }

    public BathroomLogin enterPassword(String password) {
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
        return this;
    }

    public StartNow loginButton() {
        UtilHBM.waitExplicitDisplayed(driver, loginButton);
        UtilHBM.waitExplicitClickable(driver, loginButton);
        loginButton.click();
        UtilHBM.waitTillElementDisappear(driver, ".mod-popin-login-small.mod-open");
        return PageFactory.initElements(driver, StartNow.class);
    }

    public BathroomLogin loginPopUp() {
        Verification.displayOfWebElement(loginWindow);
        String expectedTitle = "No User";
        Verification.VerifyEquals("Login title incorrect ", loginHeader.getText(), expectedTitle);
        return PageFactory.initElements(driver, BathroomLogin.class);
    }


    public StartNow loginUsingMainPageBathroom(SignUpData signUpData) {
        return loginPopUp()
                .enterUserName(signUpData.getLoginId())
                .enterPassword(signUpData.getPassword())
                .loginButton();
    }

}
