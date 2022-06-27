package enterprise.bathroom.plannerPO;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
    WebDriver driver;

    public UserHomePage(WebDriver driver){
        this.driver= driver;
    }

    @FindBy(xpath = "//div[@id='footer-actions']/button[@id='login-button']")
    private WebElement userAvatar;

    @FindBy(css = "h1#user")
    private WebElement userNameLogged;

   public UserHomePage verifyLoggedUser(SignUpData signUpData){
        UtilHBM.waitExplicitDisplayed(driver, userAvatar);
        String userNameExpected= signUpData.getLoginId();
        Verification.VerifyEquals("wrong username", userAvatar.getText(), userNameExpected);
        return clickUserAvatar().verifyUserProfileDetails(signUpData).clickCancelButton();
    }

    public UserProfileDetails clickUserAvatar() {
        UtilHBM.waitExplicitClickable(driver, userAvatar);
        userAvatar.click();
        return PageFactory.initElements(driver, UserProfileDetails.class);

    }


}
