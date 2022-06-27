package enterprise.bathroom.plannerPO;

import hbm.planner.utility.UtilHBM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MakeItYoursBathroom {
    WebDriver driver;

    public MakeItYoursBathroom(WebDriver driver) {this.driver=driver;}

    @FindBy(css = "button[data-state='floorplan']")
    private WebElement floorplan;

    public Floorplan clickFloorplanBathroom() {
        UtilHBM.waitFixTime(4000);
        UtilHBM.waitExplicitDisplayed(driver,floorplan);
           UtilHBM.waitExplicitClickable(driver,floorplan);
        floorplan.click();
        return PageFactory.initElements(driver,Floorplan.class);

    }

}
