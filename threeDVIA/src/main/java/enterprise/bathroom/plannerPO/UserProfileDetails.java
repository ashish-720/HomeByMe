package enterprise.bathroom.plannerPO;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProfileDetails {
        WebDriver driver;

    public UserProfileDetails(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@id='footer-actions']/button[@id='login-button']")
    private WebElement userAvatar;

    @FindBy(css = "h1#user")
    private WebElement userNameLogged;

    @FindBy(css = "div.content>form>footer.popin-footer")
    private WebElement cancelButton;

    @FindBy(css = "div.content>form>div>button.bt-text")
    private WebElement logoutButton;

 public LandingPage logout(){
     UtilHBM.waitExplicitDisplayed(driver, userNameLogged);
     UtilHBM.reportInfo("logging Out User : " + userNameLogged.getText() );
     UtilHBM.waitExplicitClickable(driver, logoutButton);
     logoutButton.click();
     UtilHBM.waitTillElementDisappear(driver, logoutButton);
     return  PageFactory.initElements(driver,LandingPage.class);
 }

    public UserHomePage clickCancelButton() {
        UtilHBM.waitExplicitDisplayed(driver, cancelButton);
        UtilHBM.waitExplicitClickable(driver, cancelButton);
        cancelButton.click();
        UtilHBM.waitTillElementDisappear(driver, cancelButton);
        return PageFactory.initElements(driver, UserHomePage.class);
    }

    public UserProfileDetails verifyUserProfileDetails(SignUpData signUpData){
        UtilHBM.waitExplicitDisplayed(driver, userNameLogged);
        String userNameExpected= signUpData.getLoginId();
        Verification.VerifyEquals("wrong userNameLogged", userNameLogged.getText(), userNameExpected);
        return this;
    }
}
