package enterprise.bathroom.plannerPO;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.StartNow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartNowBathroom {
    WebDriver driver;

    public StartNowBathroom(WebDriver driver) {this.driver=driver;}

    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement user;

    @FindBy(css = ".footer-actions>button[data-ui-action='layer-my-projects']")
    private WebElement myProjects;


    public StartNowBathroom loginBathroom(SignUpData signUpData) {
        user.click();
        BathroomLogin loginBathroom = PageFactory.initElements(driver, BathroomLogin.class);
        loginBathroom.loginUsingMainPageBathroom(signUpData);
        return PageFactory.initElements(driver, StartNowBathroom.class);

    }

    public MyProjects user() {
        user.click();
        return PageFactory.initElements(driver, MyProjects.class);
    }

    public MyProjects openMyProjectList(){
//        UtilHBM.waitExplicitDisplayed(driver,user);
//        UtilHBM.waitExplicitClickable(driver,user);
////        user.click();
//        new Actions(driver).moveToElement(user).build().perform();
        UtilHBM.waitExplicitDisplayed(driver,myProjects);
        UtilHBM.waitExplicitClickable(driver,myProjects);
        new Actions(driver).moveToElement(myProjects).build().perform();
        myProjects.click();
        UtilHBM.reportOK("My projects clicked");
        UtilHBM.waitFixTime(2500);
        return PageFactory.initElements(driver,MyProjects.class);


    }

}
