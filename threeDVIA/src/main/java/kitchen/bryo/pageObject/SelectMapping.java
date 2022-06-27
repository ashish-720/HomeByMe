package kitchen.bryo.pageObject;

import hbm.planner.utility.UtilHBM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class SelectMapping {
    WebDriver driver;

    public SelectMapping(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "#tab-5>button>span")
    private WebElement startPlanning;

    @FindBy(xpath = "//div[@id='tab-5-update']/ul/li[@data-step='0']")
    private WebElement changeStyleMapping;

    @FindBy(xpath = "//div[@id='tab-5-update']/ul/li[@data-step='1']")
    private WebElement changelayoutMapping;

    @FindBy(xpath = "//div[@id='tab-5-update']/ul/li[@data-step='2']")
    private WebElement changeCookingMapping;

    @FindBy(xpath = "//div[@id='tab-5-update']/ul/li[@data-step='3']")
    private WebElement changeRefrigerationMapping;

    @FindBy(xpath = "//button[@data-ui-selector='update-need-mapping-settings']")
    private WebElement updateNeedsButton;

    public StylePage goToSelectStyle(){
    	UtilHBM.turnOffImplicitWaits(driver);
        if (changeStyleMapping.findElements(By.xpath("//div[@class='img']/div[@class='no-pref-image']")).size() > 0) {
            UtilHBM.reportInfo(
                    "No preference selected for " + changeStyleMapping.findElement(By.cssSelector("p[class='subtitle']")).getText());
        } else if (changeStyleMapping.findElement(By.xpath("//div[@class='img']/img")).getAttribute("src").startsWith("https://")
                && changeStyleMapping.findElement(By.xpath("//div[@class='img']/img")).getAttribute("src").endsWith(".jpg")) {
            UtilHBM.reportInfo("Preference already selected and preference is "
                    + changeStyleMapping.findElement(By.cssSelector("div[class='title']>h3")).getText());
        }
        UtilHBM.turnOnImplicitWaits(driver);
        UtilHBM.waitExplicitDisplayed(driver, changeStyleMapping);
        new Actions(driver).moveToElement(changeStyleMapping).clickAndHold().pause(500).release().build().perform();

        return PageFactory.initElements(driver, StylePage.class);
    }

    public SelectMapping selectStyleMapping(String cabinetsStyle, String worktopsStyle, String handlesStyle) {
        goToSelectStyle().selectStyleMapping(cabinetsStyle, worktopsStyle , handlesStyle);
        return PageFactory.initElements(driver, SelectMapping.class);
    }

    public SelectMapping selectStyleMapping() {
        goToSelectStyle().selectStyleMapping();
        return PageFactory.initElements(driver, SelectMapping.class);
    }

    public SelectMapping updateStyleMapping(String cabinetsStyle, String worktopsStyle, String handlesStyle) {
        goToSelectStyle().updateStyleMapping(cabinetsStyle, worktopsStyle, handlesStyle);
        return PageFactory.initElements(driver, SelectMapping.class);
    }

    public SelectMapping updateStyleMapping() {
        goToSelectStyle().updateStyleMapping();
        return PageFactory.initElements(driver, SelectMapping.class);
    }

    public SelectMapping layoutMapping(String layout) {

        List<WebElement> layoutList = driver.findElements(By.xpath("//fieldset[@id='tab-2']/ul/li/label/figure"));
        List<WebElement> layoutImageList = driver
                .findElements(By.xpath("//fieldset[@id='tab-2']/ul/li/label/figure/span/img"));
        if (layoutImageList.size() == layoutList.size() && layoutList.size() > 0) {
            UtilHBM.reportOK("All images are displayed in Layout Mapping.");
            UtilHBM.reportOK("Number of images in Layout Mapping = " + layoutList.size());
            for (WebElement a : layoutList) {
                UtilHBM.reportOK("layouts available :" + a.getText());
            }
        } else if (!(layoutList.size() > 0)) {
            UtilHBM.reportKO("No layouts in Layout mapping");
        } else {
        	UtilHBM.reportKO("All  images not displayed in layout mapping.");
            UtilHBM.reportKO("Number of layouts in layout mapping = " + layoutList.size());
        }
        if ((layout.isEmpty())) {
            WebElement noStyle = driver.findElement(By.xpath("//fieldset[@id='tab-2']/label"));
            System.out.println(".." + noStyle.getText());
            noStyle.click();

        } else {
            for (WebElement a : layoutList) {
                if (a.findElement(By.cssSelector("figcaption>b")).getText().trim().equalsIgnoreCase(layout)) {
                    a.click();
                }
            }
        }
        return PageFactory.initElements(driver, SelectMapping.class);
    }

    public SelectMapping cookingMapping(String cooking) {
        List<WebElement> cookingList = driver.findElements(By.xpath("//fieldset[@id='tab-3']/ul/li/label/figure"));
        List<WebElement> cookingImageList = driver
                .findElements(By.xpath("//fieldset[@id='tab-3']/ul/li/label/figure/span/img"));

        if (cookingImageList.size() == cookingList.size() && cookingList.size() > 0) {
            UtilHBM.reportOK("All images are displayed in Cooking Mapping.");
            UtilHBM.reportOK("Number of images in Cooking Mapping = " + cookingList.size());
            for (WebElement a : cookingList) {
                UtilHBM.reportOK("Cookings available :" + a.getText());
            }
        } else if (!(cookingList.size() > 0)) {
            UtilHBM.reportKO("No cookings in Cooking mapping");
        } else {
            Reporter.log("<font color='red'>" + "All  images not displayed in Cooking mapping." + "<br>");
            Reporter.log("Number of cookings in cooking mapping = " + cookingList.size() + "<br>");
        }
        if ((cooking.isEmpty())) {
            System.out.println("In else");
            WebElement noStyle = driver.findElement(By.xpath("//fieldset[@id='tab-3']/label"));
            System.out.println(".." + noStyle.getText());
            noStyle.click();

        } else {
            for (WebElement a : cookingList) {
                if (a.findElement(By.cssSelector("figcaption>b")).getText().trim().equalsIgnoreCase(cooking)) {
                    new Actions(driver).moveToElement(a).click().build().perform();
                }
            }
        }
        return PageFactory.initElements(driver, SelectMapping.class);
    }

    public SelectMapping refrigerationMapping(String refrigeration) {
        List<WebElement> refrigerationList = driver
                .findElements(By.xpath("//fieldset[@id='tab-4']/ul/li/label/figure"));
        List<WebElement> refrigerationImageList = driver
                .findElements(By.xpath("//fieldset[@id='tab-4']/ul/li/label/figure/span/img"));

        if (refrigerationImageList.size() == refrigerationList.size() && refrigerationList.size() > 0) {
            UtilHBM.reportOK("All images are displayed in Refrigeration Mapping.");
            UtilHBM.reportOK("Number of images in Refrigeration Mapping = " + refrigerationList.size());
            for (WebElement a : refrigerationList) {
                UtilHBM.reportOK("Refrigeration available :" + a.getText());
            }
        } else if (!(refrigerationList.size() > 0)) {
            UtilHBM.reportKO("No Refrigerations in Refrigeration mapping");
        } else {
            Reporter.log("<font color='red'>" + "All  images not displayed in Refrigeration mapping." + "<br>");
            Reporter.log("Number of Refrigerations in Refrigeration mapping = " + refrigerationList.size() + "<br>");
        }
        if ((refrigeration.isEmpty())) {
            System.out.println("In else");
            WebElement noStyle = driver.findElement(By.xpath("//fieldset[@id='tab-4']/label"));
            System.out.println(".." + noStyle.getText());
            noStyle.click();

        } else {
            for (WebElement a : refrigerationList) {
                if (a.getText().trim().equalsIgnoreCase(refrigeration)) {
                    a.click();
                    break;
                }
            }
        }
        return PageFactory.initElements(driver, SelectMapping.class);
    }

    public FloorPlan startPlanning() {
        UtilHBM.waitFixTime(1000);
        startPlanning.click();
        UtilHBM.waitFixTime(3500);
        StartNow start = PageFactory.initElements(driver, StartNow.class);
        start.switchFrame();
        return PageFactory.initElements(driver, FloorPlan.class);
    }

    public PickALayout generateNewLayouts(){
        new Actions(driver).moveToElement(updateNeedsButton).click().build().perform();
        UtilHBM.waitFixTime(3500);
        List<WebElement> frames = driver.findElements(By.cssSelector("#iframeContainer>iframe"));
        driver.switchTo().frame(frames.get(0));

        return PageFactory.initElements(driver, PickALayout.class);
    }

    public SelectMapping updateLayoutMapping(String layout) {
        WebElement e1 = driver.findElement(By.xpath("//div[@id='tab-5-update']/ul/li[@data-step='1']"));
        if (e1.findElements(By.xpath("//div[@class='img']/div[@class='no-pref-image']")).size() > 0) {

            UtilHBM.reportInfo(
                    "No preference selected for " + e1.findElement(By.cssSelector("p[class='subtitle']")).getText());
        } else if (e1.findElement(By.xpath("//div[@class='img']/img")).getAttribute("src").startsWith("https://")
                && e1.findElement(By.xpath("//div[@class='img']/img")).getAttribute("src").endsWith("svg")) {
            UtilHBM.reportInfo("Preference already selected and preference is "
                    + e1.findElement(By.cssSelector("div[class='title']>h3")).getText());
        }
        UtilHBM.waitExplicitDisplayed(driver, changelayoutMapping);
        new Actions(driver).moveToElement(changelayoutMapping).clickAndHold().pause(500).release().build().perform();
        List<WebElement> layoutList = driver
                .findElements(By.xpath("//fieldset[@id='tab-2-update']/ul/li/label/figure"));
        List<WebElement> layoutImageList = driver
                .findElements(By.xpath("//fieldset[@id='tab-2-update']/ul/li/label/figure/span/img"));
        if (layoutImageList.size() == layoutList.size() && layoutList.size() > 0) {
            UtilHBM.reportOK("All images are displayed in Layout Mapping.");
            UtilHBM.reportOK("Number of images in Layout Mapping = " + layoutList.size());
            for (WebElement a : layoutList) {
                UtilHBM.reportOK("layouts available :" + a.getText());
            }
        } else if (!(layoutList.size() > 0)) {
            UtilHBM.reportKO("No layouts in Layout mapping");
        } else {
            Reporter.log("<font color='red'>" + "All  images not displayed in layout mapping." + "<br>");
            Reporter.log("Number of layouts in layout mapping = " + layoutList.size() + "<br>");
        }
        if ((layout.isEmpty())) {
            System.out.println("In else");
            WebElement noLayout = driver.findElement(By.xpath("//fieldset[@id='tab-2-update']/label"));
            System.out.println(".." + noLayout.getText());
            noLayout.click();

        } else {
            for (WebElement a : layoutList) {

                WebElement layoutName = a.findElement(By.cssSelector("figure>figcaption>b"));
                if (layoutName.getText().trim().equalsIgnoreCase(layout)) {
                    new Actions(driver).moveToElement(layoutName).click().perform();
                }
            }
        }

        return PageFactory.initElements(driver, SelectMapping.class);
    }

    public SelectMapping updateCookingMapping(String cooking) {
        WebElement e2 = driver.findElement(By.xpath("//div[@id='tab-5-update']/ul/li[@data-step='2']"));
        if (e2.findElements(By.xpath("//div[@class='img']/div[@class='no-pref-image']")).size() > 0) {
            UtilHBM.reportInfo(
                    "No preference selected for " + e2.findElement(By.cssSelector("p[class='subtitle']")).getText());
        } else if (e2.findElement(By.xpath("//div[@class='img']/img")).getAttribute("src").startsWith("https://")
                && e2.findElement(By.xpath("//div[@class='img']/img")).getAttribute("src").endsWith(".png")) {
            UtilHBM.reportInfo("Preference already selected and preference is "
                    + e2.findElement(By.cssSelector("div[class='title']>h3")).getText());
        }
        UtilHBM.waitExplicitDisplayed(driver, changeCookingMapping);
        new Actions(driver).moveToElement(changeCookingMapping).clickAndHold().pause(500).release().build().perform();
        List<WebElement> cookingList = driver
                .findElements(By.xpath("//fieldset[@id='tab-3-update']/ul/li/label/figure"));
        List<WebElement> cookingImageList = driver
                .findElements(By.xpath("//fieldset[@id='tab-3-update']/ul/li/label/figure/span/img"));
        if (cookingImageList.size() == cookingList.size() && cookingList.size() > 0) {
            UtilHBM.reportOK("All images are displayed in Cooking Mapping.");
            UtilHBM.reportOK("Number of images in Cooking Mapping = " + cookingList.size());
            for (WebElement a : cookingList) {
                UtilHBM.reportOK("Cookings available :" + a.getText());
            }
        } else if (!(cookingList.size() > 0)) {
            UtilHBM.reportKO("No cookings in Cooking mapping");
        } else {
            Reporter.log("<font color='red'>" + "All  images not displayed in Cooking mapping." + "<br>");
            Reporter.log("Number of cookings in cooking mapping = " + cookingList.size() + "<br>");
        }
        if ((cooking.isEmpty())) {
            System.out.println("In else");
            WebElement noCooking = driver.findElement(By.xpath("//fieldset[@id='tab-3-update']/label"));
            System.out.println(".." + noCooking.getText());
            noCooking.click();

        } else {
            for (WebElement a : cookingList) {

                WebElement cookingName = a.findElement(By.cssSelector("figure>figcaption>b"));
                if (cookingName.getText().trim().equalsIgnoreCase(cooking)) {
                    new Actions(driver).moveToElement(cookingName).click().perform();
                }
            }
        }
        return PageFactory.initElements(driver, SelectMapping.class);
    }

    public SelectMapping updateRefrigerationMapping(String refrigeration) {
        WebElement e3 = driver.findElement(By.xpath("//div[@id='tab-5-update']/ul/li[@data-step='3']"));
        if (e3.findElements(By.xpath("//div[@class='img']/div[@class='no-pref-image']")).size() > 0) {
            UtilHBM.reportInfo(
                    "No preference selected for " + e3.findElement(By.cssSelector("p[class='subtitle']")).getText());
        } else if (e3.findElement(By.xpath("//div[@class='img']/img")).getAttribute("src").startsWith("https://")
                && e3.findElement(By.xpath("//div[@class='img']/img")).getAttribute("src").endsWith(".jpg")) {
            UtilHBM.reportInfo("Preference already selected and preference is "
                    + e3.findElement(By.cssSelector("div[class='title']>h3")).getText());
        }
        UtilHBM.waitExplicitDisplayed(driver, changeRefrigerationMapping);
        new Actions(driver).moveToElement(changeRefrigerationMapping).clickAndHold().pause(500).release().build()
                .perform();
        List<WebElement> refrigerationList = driver
                .findElements(By.xpath("//fieldset[@id='tab-4-update']/ul/li/label/figure"));
        List<WebElement> refrigerationImageList = driver
                .findElements(By.xpath("//fieldset[@id='tab-4-update']/ul/li/label/figure/span/img"));
        if (refrigerationImageList.size() == refrigerationList.size() && refrigerationList.size() > 0) {
            UtilHBM.reportOK("All images are displayed in Refrigeration Mapping.");
            UtilHBM.reportOK("Number of images in Refrigeration Mapping = " + refrigerationList.size());
            for (WebElement a : refrigerationList) {
                UtilHBM.reportOK("Refrigeration available :" + a.getText());
            }
        } else if (!(refrigerationList.size() > 0)) {
            UtilHBM.reportKO("No Refrigerations in Refrigeration mapping");
        } else {
            Reporter.log("<font color='red'>" + "All  images not displayed in Refrigeration mapping." + "<br>");
            Reporter.log("Number of Refrigerations in Refrigeration mapping = " + refrigerationList.size() + "<br>");
        }
        if ((refrigeration.isEmpty())) {
            System.out.println("In else");
            WebElement noRefrigeration = driver.findElement(By.xpath("//fieldset[@id='tab-4-update']/label"));
            System.out.println(".." + noRefrigeration.getText());
            noRefrigeration.click();

        } else {
            for (WebElement a : refrigerationList) {

                WebElement refrigerationName = a.findElement(By.cssSelector("figure>figcaption>b"));
                if (refrigerationName.getText().trim().equalsIgnoreCase(refrigeration)) {
                    new Actions(driver).moveToElement(refrigerationName).click().perform();
                }
            }
        }
        return PageFactory.initElements(driver, SelectMapping.class);
    }
    
//    <****************************MOBILE METHODS**********************>
    public SelectMapping updateStyleMappingMobile(String cabinetsStyle, String worktopsStyle, String handlesStyle) {
        goToSelectStyle().updateStyleMappingMobile(cabinetsStyle, worktopsStyle, handlesStyle);
        return PageFactory.initElements(driver, SelectMapping.class);
    }
}
