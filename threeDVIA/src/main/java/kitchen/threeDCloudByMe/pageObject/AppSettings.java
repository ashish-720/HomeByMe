package kitchen.threeDCloudByMe.pageObject;

import hbm.planner.utility.UtilHBM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class AppSettings {
    WebDriver driver;

    public AppSettings(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "div#updateApplicationDistribution_chosen")
    WebElement selectAppDist;

    @FindBy(css = "div#updateApplicationDistribution_chosen ul.chosen-results")
    WebElement selectAppDistDD;

    @FindBy(css = "textarea#applicationDistributionParam")
    WebElement appDistrParameters;

    @FindBy(css = "button#validate-applicationDistribution-button")
    WebElement validateButton;

    @FindBy(css = "a[id='logout-link']")
    private WebElement logoutButton;

    public AppSettings setAppDistrName(String appDistrName) {
        UtilHBM.waitExplicitDisplayed(driver, selectAppDist);
        selectAppDist.click();
        UtilHBM.waitExplicitDisplayed(driver, selectAppDistDD);
        selectAppDistDD.findElement(By.xpath("./li[text()='" + appDistrName + "']")).click();
        UtilHBM.waitFixTime(2000);
        return this;
    }

    public String getAppSettingsParameter(String appDistrName) {
        setAppDistrName(appDistrName);
        return appDistrParameters.getText().trim();
    }

    public AppSettings getAppSettingsBackup(String appDistrName) throws IOException {
        String currentAppDistrSettings = getAppSettingsParameter(appDistrName);
        UtilHBM.writeJSONObjectToFile(currentAppDistrSettings, new File("src/test/resources/BryoAppSettingsBackup.json"));
        return this;
    }

    public AppSettings modifyAppSettingsParameter(String appDistrName, String appSettingsToChange, String modifiedSettings) throws IOException {
        String currentAppDistrSettings = getAppSettingsParameter(appDistrName);
        if (currentAppDistrSettings.contains(appSettingsToChange)) {
            String modifiedAppDistrSetting = currentAppDistrSettings.replace(appSettingsToChange, modifiedSettings);
            appDistrParameters.clear();
            UtilHBM.waitFixTime(500);
            appDistrParameters.sendKeys(modifiedAppDistrSetting);
            UtilHBM.waitFixTime(500);
            validateButton.click();
            UtilHBM.waitFixTime(500);
        }
        return this;
    }

    public AppSettings addAppSettingsParameter(String appDistrName, String appSettingsToAdd) throws IOException {
        String currentAppDistrSettings = getAppSettingsParameter(appDistrName);
        if (!currentAppDistrSettings.contains(appSettingsToAdd)) {
            String modifiedAppDistrSetting = "{" + appSettingsToAdd + "," + currentAppDistrSettings.substring(1);
            appDistrParameters.clear();
            UtilHBM.waitFixTime(500);
            appDistrParameters.sendKeys(modifiedAppDistrSetting);
            UtilHBM.waitFixTime(500);
            validateButton.click();
            UtilHBM.waitFixTime(500);
        }
        return this;
    }

    public AppSettings resetAppSettingsParameter(String appDistrName) throws IOException {
        setAppDistrName(appDistrName);

        String backupAppDistrSettings = UtilHBM.getSavedBryoAppSettings(new File("src/test/resources/BryoAppSettingsBackup.json"));
        appDistrParameters.clear();
        UtilHBM.waitFixTime(500);
        appDistrParameters.sendKeys(backupAppDistrSettings);
        UtilHBM.waitFixTime(500);
        validateButton.click();
        UtilHBM.waitFixTime(500);
        return this;
    }


    public Login3DCloudByMe logout() {
        UtilHBM.waitFixTime(1000);
        logoutButton.click();
        Login3DCloudByMe login3dCloudByMe = PageFactory.initElements(driver, Login3DCloudByMe.class);
        login3dCloudByMe.verifyLogout();
        return PageFactory.initElements(driver, Login3DCloudByMe.class);
    }
}
