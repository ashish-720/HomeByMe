package enterprise.bathroom.plannerPO;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyProjects {
    WebDriver driver;
    public static int i = 0;

    public MyProjects(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "article.mod-layer-my-projects.mod-open ul.projects-list>li[class='project-list-item']")
    private List<WebElement> projectListItem;

    @FindBy(css = ".project-list-item>div>p>span[class='name']")
    private WebElement projectName;

    @FindBy(css = ".project-list-item>div>p>span[class='label']")
    private WebElement projectDate;

    @FindBy(css = ".mod-layer-my-projects.mod-open>div>div>div>div>ul>li>div>button[data-ui-action='upload-project']")
    private WebElement openProjectButton;

    @FindBy(css = ".mod-layer-my-projects.mod-open>div>div>div>div>ul>li>div>button[data-ui-action='delete-project']")
    private WebElement deleteProjectButton;

    @FindBy(xpath = "//article[@class='mod-layer-my-projects mod-open']")
    private WebElement projectOverlay;

    @FindBy(css = ".wrap>div>button[data-ui-action='layer-close']")
    private WebElement closeProjectOverlay;

    @FindBy(xpath = "//button[@data-ui-action='layer-close']")
    private WebElement closeProjectList;

    @FindBy(css = "button[data-state='floorplan']")
    private WebElement floorplan;


    private static int initialCount;


    public void setProjectCount(int count) {
        UtilHBM.waitExplicitDisplayed(driver, projectName);
        System.out.println("set count " + count);
        initialCount = count;
    }
    public static Integer getProjectCount() {
        return initialCount;
    }


    public MyProjects myProjectPage() {
        if (projectListItem.isEmpty()) {
            UtilHBM.reportKO("No project available");
        } else {
            UtilHBM.waitExplicitDisplayed(driver, "//article[@id='projects-list']//li[@class='project-list-item']");
            Verification.displayOfWebElement(projectName);
            Verification.displayOfWebElement(projectDate);
            int initialCount = projectListItem.size();
            System.out.println("Number of projects available" + initialCount);
            UtilHBM.reportOK("Number of projects available :" + initialCount);
            setProjectCount(initialCount);
        }
        return this;
    }



    public Floorplan clickFloorPlan(){
        UtilHBM.waitExplicitDisplayed(driver, floorplan);
        UtilHBM.waitExplicitClickable(driver,floorplan);
        floorplan.click();
        return PageFactory.initElements(driver,Floorplan.class);
    }


    public MakeItYoursBathroom openProjectBathroom(int index, String projectName ) {
        UtilHBM.waitExplicitClickable(driver,
                UtilHBM.webElementXPath(driver,"//button[@id='projects-button']"));
        UtilHBM.waitExplicitDisplayed(driver, projectListItem.get(0));
        openProjectButton.click();
        UtilHBM.waitFixTime(1000);
        driver.switchTo().frame(
                UtilHBM.webElement(driver, "iframe#embedded-app-frame"));
        UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".loader-container"));
        UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver,
                "//button[@id='step-design']"));
        return PageFactory.initElements(driver,MakeItYoursBathroom.class);
    }
}
