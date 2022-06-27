package enterprise.bathroom.plannerPO;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Floorplan {
    WebDriver driver;

    public Floorplan (WebDriver driver) {this.driver=driver;}


    @FindBy(css = "button[data-state='floorplan']")
    private WebElement floorplan;

    public Floorplan clickFloorPlan(){
        UtilHBM.waitExplicitDisplayed(driver, floorplan);
        UtilHBM.waitExplicitClickable(driver,floorplan);
        floorplan.click();
        return this;
    }

    public Floorplan initiatePlan(){
        String catagory = "Initiate plan";
        WebElement catagoryEle = driver.findElement(By.xpath("//div/div/ul/li/button[normalize-space(.)='" + catagory + "']"));
        Verification.displayOfWebElement(catagoryEle);
        catagoryEle.click();
        return this;
    }

    public Upload2DPlanBathroom uploadTwoPlan(){
        initiatePlan();
        String subcatagory = "Upload a 2D floorplan";
        WebElement subCatagoryEle = driver
                .findElement(By.xpath("//div/div/ul/li/ul/li/button[normalize-space(.)='" + subcatagory + "']"));
        new Actions(driver).moveToElement(subCatagoryEle).click().build().perform();
        return PageFactory.initElements(driver, Upload2DPlanBathroom.class);
    }



}
