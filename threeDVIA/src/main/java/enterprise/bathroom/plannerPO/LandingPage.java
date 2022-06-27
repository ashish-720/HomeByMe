package enterprise.bathroom.plannerPO;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(css=".cta-primary-alt-l[data-ui-action='launch-app']")
    private WebElement launchBtn;
    //Log in Button
    @FindBy(id="login-button")
    private WebElement login;

    @FindBy(xpath="//div[@id='welcome-page']/main/div/div/header/h1")
    private WebElement bathroomAppAccessHeader;



     public LoginForm clickLogin(){
        UtilHBM.waitExplicitDisplayed(driver, bathroomAppAccessHeader);
        UtilHBM.waitExplicitDisplayed(driver, login);
        UtilHBM.waitExplicitClickable(driver, login);
        login.click();
        for (String handle: driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }
        return PageFactory.initElements(driver, LoginForm.class);
    }



    public LandingPage verifyLogoutSuccess(){
        UtilHBM.waitExplicitDisplayed(driver, login);
        Verification.displayOfWebElement(login);
        UtilHBM.reportOK("logout success");
        return this;
 }
    
    public Floorplan launchApp(){
    	UtilHBM.waitExplicitClickable(driver, launchBtn);
    	launchBtn.click();
    	driver.switchTo().frame(UtilHBM.webElement(driver, "#embedded-app-frame"));
    	UtilHBM.waitExplicitDisplayed(driver, "//input[@class='room Tag3D visibility-visible  text-size-bigger-one  ']");    	
    	return PageFactory.initElements(driver, Floorplan.class);
    }

}