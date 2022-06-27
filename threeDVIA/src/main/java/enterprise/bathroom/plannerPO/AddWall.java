package enterprise.bathroom.plannerPO;

import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import kitchen.bryo.pageObject.FloorPlan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddWall{

    WebDriver driver;


    @FindBy(xpath = "//div[@class='wrap']/div/h3[@data-i18n='kitchen.design_own_wall.title;planner.design_own_wall.title']")
    private WebElement addWallTitle;

    @FindBy(xpath = "//div[@class='wrap']/div/b[@data-i18n='kitchen.design_own_wall.info;planner.design_own_wall.info']")
    private WebElement addWallInfo;

    @FindBy(xpath = "//div[@class='header-actions']/button[@data-ui-action='command-cancel']")
    private WebElement cancelAddWall;

    @FindBy(css = "button[data-ui-action='command-validate']")
    private WebElement okAddWall;

    @FindBy(css = "input[placeholder='Room']")
    private List<WebElement> room;

    @FindBy(css = "h3[data-i18n='kitchen.design_own_room_separator.title;planner.design_own_room_separator.title']")
    private WebElement addRoomSeparatorTitle;

    @FindBy(css = "b[data-i18n='kitchen.design_own_room_separator.info;planner.design_own_room_separator.info']")
    private WebElement addRoomSeparatorInfo;

    @FindBy(id = "bmSVG")
    private WebElement container3D;

    @FindBy(xpath = "//button[@data-ui-action='undo']/span[@class='icon-action-undo']")
    private WebElement undoButton;

    public AddWall addWallInfo() {
        UtilHBM.waitExplicitClickable(driver, okAddWall);
        String expectedTitle = "Add wall";
        String expectedInfo = "Click to draw walls, close your shape to create a room. Then, validate to save your floorplan.";
        Verification.VerifyEquals("Add Wall title not correct", addWallTitle.getText(), expectedTitle);
        Verification.VerifyEquals("Add Wall  info not correct", addWallInfo.getText(), expectedInfo);
        Verification.displayOfWebElement(cancelAddWall);
        Verification.displayOfWebElement(okAddWall);
        return PageFactory.initElements(driver, AddWall.class);
    }

    private void drawPlan() {
    }

    public FloorPlan addRoomSeparators(String wallParameterName) {
        drawPlan();
        String subcatagory = "Add a room separation";
        WebElement subCatagoryEle = driver
                .findElement(By.xpath("//div/div/ul/li/ul/li/button[normalize-space(.)='" + subcatagory + "']"));
        new Actions(driver).moveToElement(subCatagoryEle).click().build().perform();
        kitchen.bryo.pageObject.AddWall wall = PageFactory.initElements(driver, kitchen.bryo.pageObject.AddWall.class);
        wall.addRoomSeparatorInfo().createWall(wallParameterName);
        return PageFactory.initElements(driver, FloorPlan.class);
    }



    public AddWall addRoomSeparatorInfo() {
        UtilHBM.waitExplicitClickable(driver, okAddWall);
        String expectedTitle = "Add room separation";
        String expectedInfo = "Click directly where you want to draw a room separation. Then, validate to save your floorplan.";
        Verification.VerifyEquals("Add Room Separator title not correct", addRoomSeparatorTitle.getText(), expectedTitle);
        Verification.VerifyEquals("Add Room Separator info not correct", addRoomSeparatorInfo.getText(), expectedInfo);
        Verification.displayOfWebElement(cancelAddWall);
        Verification.displayOfWebElement(okAddWall);
        return PageFactory.initElements(driver, AddWall.class);
    }

    public FloorPlan clickInPlanner(int xOffset, int yOffset) {
        Actions action = new Actions(driver);
        action.moveToElement(container3D, xOffset, yOffset).clickAndHold().pause(1000).release().perform();
        return PageFactory.initElements(driver, FloorPlan.class);
    }

    public FloorPlan hoverWall(int xOffset, int yOffset) {
        Actions action = new Actions(driver);
        action.moveToElement(container3D, xOffset, yOffset).pause(1000).perform();
        return PageFactory.initElements(driver, FloorPlan.class);
    }

}
