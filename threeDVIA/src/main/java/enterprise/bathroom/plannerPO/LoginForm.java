package enterprise.bathroom.plannerPO;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.UtilHBM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginForm {
    WebDriver driver;

    public LoginForm(WebDriver driver) {
        this.driver = driver;
    }

    //Username and password
    @FindBy(xpath = "//input[@id='input-login-name']")
    private WebElement userName;

    @FindBy(xpath = "//input[@id='input-login-desc']")
    private WebElement password;

    //Login button
    @FindBy(css = "div.content>form>footer>button.cta-primary-alt-l")
    private WebElement login_Button;

    public UserHomePage login(SignUpData signUpData) {
        return enterLoginId(signUpData.getLoginId()).enterPassword(
                signUpData.getPassword()).clickLOGINButton();
    }

    public LoginForm enterLoginId(String loginId) {
        userName.sendKeys(loginId);
        return this;
    }

    public LoginForm enterPassword(String password1) {
        password.sendKeys(password1);
        return this;

    }
    public UserHomePage clickLOGINButton() {
        UtilHBM.waitExplicitClickable(driver, login_Button);
        login_Button.click();
        UtilHBM.waitTillElementDisappear(driver, login_Button);
        UtilHBM.waitFixTime(1000);
        return PageFactory.initElements(driver, UserHomePage.class);
    }

}
