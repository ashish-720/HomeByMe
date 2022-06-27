package kitchen.bryo.pageObject;

import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceWithMultipleCabinets {

    WebDriver driver;

    public ReplaceWithMultipleCabinets(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "article.mod-layer-tabs-replace-by-combination.mod-open")
    private WebElement replaceByCombinationLayout;

    @FindBy(css = "article.mod-layer-tabs-replace-by-combination div.content div.illustration img")
    private WebElement headerCabinetIcon;

    @FindBy(css = "article.mod-layer-tabs-replace-by-combination div.content div.text h3.title")
    private WebElement headerTextTitle;

    @FindBy(css = "article.mod-layer-tabs-replace-by-combination div.content div.text b.info")
    private WebElement headerTextInfo;

    @FindBy(css = "article.mod-layer-tabs-replace-by-combination button[data-ui-action='layer-close']")
    private WebElement cancelButton;

    @FindBy(css = "article.mod-layer-tabs-replace-by-combination button[data-ui-action='layer-validate']")
    private WebElement validateButton;

    @FindBy(css = "#canvas")
    private WebElement canvas3D;

    @FindBy(css = "button#zoom-in")
    private WebElement zoomInButton;

    @FindBy(css = "button#zoom-out")
    private WebElement zoomOutButton;

    @FindBy(css = "button.bt-icon span.icon-tools-options")
    private WebElement viewOptionsButton;

    @FindBy(xpath = "//div[@class='mod-overlay-container mod-open']//ul[@class='actions']//span[text()='View height']/..//select")
    private WebElement viewHeightSelect;

    @FindBy(xpath = "//div[@class='mod-overlay-container mod-open']//ul[@class='actions']//span[text()='Display fronts']/..//span[@class='toggle']")
    private WebElement displayFrontToggle;

    @FindBy(xpath = "//div[@class='mod-filters-tab-sm layer-tabs']/ul/li/button/span[text()='Combination']")
    private WebElement combinationTab;

    @FindBy(xpath = "//div[@class='mod-filters-tab-sm layer-tabs']/ul/li/button/span[text()='1st cabinet']")
    private WebElement firstCabinetTab;

    @FindBy(xpath = "//div[@class='mod-filters-tab-sm layer-tabs']/ul/li/button/span[text()='2nd cabinet']")
    private WebElement secondCabinetTab;

    @FindBy(xpath = "//div[@class='mod-filters-tab-sm layer-tabs']/ul/li/button/span[text()='3rd cabinet']")
    private WebElement thirdCabinetTab;

    @FindBy(css = "article.mod-panel-replace-by-combination.mod-open section#tab-1")
    private WebElement combinationPanel;

    @FindBy(css = "article.mod-panel-replace-by-combination.mod-open section#tab-2")
    private WebElement firstCabinetPanel;

    @FindBy(css = "article.mod-panel-replace-by-combination.mod-open section#tab-3")
    private WebElement secondCabinetPanel;

    @FindBy(css = "article.mod-panel-replace-by-combination.mod-open section#tab-4")
    private WebElement thirdCabinetPanel;

    @FindBy(css = "article.mod-panel-replace-by-combination.mod-open section#tab-1 ul>li")
    private List<WebElement> availableCombinations;

    @FindBy(css = "#mod-product-list>li")
    private List<WebElement> productList;

    public ReplaceWithMultipleCabinets verifyHeader(String headerTitle, String headerInfo, boolean cancelButtonDisabled, boolean validateButtonDisabled) {
        Verification.VerifyEquals("", headerTextTitle.getText().trim(), headerTitle);
        Verification.VerifyEquals("", headerTextInfo.getText().trim(), headerInfo);

        if (cancelButtonDisabled) {
            if (cancelButton.isEnabled()) UtilHBM.reportKO("Cancel button is enabled");
            else UtilHBM.reportOK("Cancel button is disabled");
        } else {
            if (cancelButton.isEnabled()) UtilHBM.reportOK("Cancel button is enabled");
            else UtilHBM.reportKO("Cancel button is disabled");
        }

        if (validateButtonDisabled) {
            if (validateButton.isEnabled()) UtilHBM.reportKO("Validate button is enabled");
            else UtilHBM.reportOK("Validate button is disabled");
        } else {
            if (validateButton.isEnabled()) UtilHBM.reportOK("Validate button is enabled");
            else UtilHBM.reportKO("Validate button is disabled");
        }

        return this;
    }

    public ReplaceWithMultipleCabinets verifyMultiReplacePopup() {
        Verification.displayOfWebElement(combinationTab);
        Verification.displayOfWebElement(combinationPanel);
        Verification.displayOfWebElement(firstCabinetTab);
        Verification.displayOfWebElement(secondCabinetTab);
        Verification.displayOfWebElement(thirdCabinetTab);
        verifyTabsEnabled(true, false, false, false);

        Verification.displayOfWebElement(canvas3D);
        Verification.displayOfWebElement(zoomInButton);
        Verification.displayOfWebElement(zoomOutButton);
        Verification.displayOfWebElement(viewOptionsButton);
        viewOptionsButton.click();
        UtilHBM.waitExplicitDisplayed(driver, "//h3[text()='View mode options']");
        Verification.displayOfWebElement(viewHeightSelect.findElement(By.xpath("./parent::span")));
        Verification.enabledWebElement(driver, viewHeightSelect.findElement(By.xpath("./parent::span")));
        Verification.displayOfWebElement(displayFrontToggle);
        Verification.enabledWebElement(driver, displayFrontToggle);
        viewOptionsButton.click();

        return this;
    }

    private boolean isTabEnabled(WebElement tab) {
        UtilHBM.waitExplicitDisplayed(driver, tab);
        return !"true".equals(tab.findElement(By.xpath("./parent::button")).getAttribute("disabled"));
    }

    public ReplaceWithMultipleCabinets verifyTabsEnabled(boolean iscombinationTabEnabled, boolean isfirstCabinetTabEnabled, boolean issecondCabinetTabEnabled, boolean isthirdCabinetTabEnabled) {
        if (iscombinationTabEnabled == isTabEnabled(combinationTab)) {
            UtilHBM.reportOK("Verify iscombinationTabEnabled , Expected : " + iscombinationTabEnabled + " ,  Actual : " + isTabEnabled(combinationTab));
        } else {
            UtilHBM.reportKO("Verify iscombinationTabEnabled , Expected : " + iscombinationTabEnabled + " ,  Actual : " + isTabEnabled(combinationTab));
        }

        if (isfirstCabinetTabEnabled == isTabEnabled(firstCabinetTab)) {
            UtilHBM.reportOK("Verify isfirstCabinetTabEnabled , Expected : " + isfirstCabinetTabEnabled + " ,  Actual : " + isTabEnabled(firstCabinetTab));
        } else {
            UtilHBM.reportKO("Verify isfirstCabinetTabEnabled , Expected : " + isfirstCabinetTabEnabled + " ,  Actual : " + isTabEnabled(firstCabinetTab));
        }

        if (issecondCabinetTabEnabled == isTabEnabled(secondCabinetTab)) {
            UtilHBM.reportOK("Verify issecondCabinetTabEnabled , Expected : " + issecondCabinetTabEnabled + " ,  Actual : " + isTabEnabled(secondCabinetTab));
        } else {
            UtilHBM.reportKO("Verify issecondCabinetTabEnabled , Expected : " + issecondCabinetTabEnabled + " ,  Actual : " + isTabEnabled(secondCabinetTab));
        }

        if (isthirdCabinetTabEnabled == isTabEnabled(thirdCabinetTab)) {
            UtilHBM.reportOK("Verify isthirdCabinetTabEnabled , Expected : " + isthirdCabinetTabEnabled + " ,  Actual : " + isTabEnabled(thirdCabinetTab));
        } else {
            UtilHBM.reportKO("Verify isthirdCabinetTabEnabled , Expected : " + isthirdCabinetTabEnabled + " ,  Actual : " + isTabEnabled(thirdCabinetTab));
        }

        return this;
    }

    public ReplaceWithMultipleCabinets verifyActivePanel(String panel) {
        switch (panel.toLowerCase()) {
            case "combination":
                if (combinationPanel.getAttribute("aria-hidden").equalsIgnoreCase("false"))
                    UtilHBM.reportOK(panel + " tab is active");
                else
                    UtilHBM.reportKO(panel + " tab is not active");
                break;

            case "1st cabinet":
                if (firstCabinetPanel.getAttribute("aria-hidden").equalsIgnoreCase("false"))
                    UtilHBM.reportOK(panel + " tab is active");
                else
                    UtilHBM.reportKO(panel + " tab is not active");
                break;

            case "2nd cabinet":
                if (secondCabinetPanel.getAttribute("aria-hidden").equalsIgnoreCase("false"))
                    UtilHBM.reportOK(panel + " tab is active");
                else
                    UtilHBM.reportKO(panel + " tab is not active");
                break;

            case "3rd cabinet":
                if (thirdCabinetPanel.getAttribute("aria-hidden").equalsIgnoreCase("false"))
                    UtilHBM.reportOK(panel + " tab is active");
                else
                    UtilHBM.reportKO(panel + " tab is not active");
                break;

            default:
                UtilHBM.reportKO("Wrong input for panel : " + panel);
        }

        return this;
    }

    public ReplaceWithMultipleCabinets verifyAvailableCombinations(String combinations) {
        List<String> expectedCombinations = new ArrayList<>(Arrays.asList(combinations.split("\\s*>\\s*")));
        for (WebElement combn : availableCombinations) {
            String combinationFound = combn.findElement(By.cssSelector("h3>span")).getText().trim();
            boolean matchFound = expectedCombinations.remove(combinationFound);
            if (!matchFound)
                UtilHBM.reportWarning("Combination found :" + combinationFound + ", is not among list of Expected combinations");
        }

        if (expectedCombinations.isEmpty())
            UtilHBM.reportOK("All expected combinations found");
        else
            UtilHBM.reportKO("Some Combination were not found :" + expectedCombinations.toString());

        return this;
    }

    public ReplaceWithMultipleCabinets selectCombination(String combination) {
        UtilHBM.waitExplicitDisplayed(driver, combinationPanel);
        boolean matchFound = false;
        for (WebElement combn : availableCombinations) {
            if (combn.findElement(By.cssSelector("h3>span")).getText().trim().equalsIgnoreCase(combination)) {
                combn.click();
                matchFound = true;
                break;
            }
        }

        if (!matchFound)
            UtilHBM.reportKO("Expected combination : " + combination + " not found amoong list of available combinations");
        UtilHBM.waitTillElementDisappear(driver, combinationPanel);

        return this;
    }

    public ReplaceWithMultipleCabinets selectCabinet(String prdName) {
        UtilHBM.waitFixTime(1000);
        Catalog catalog = PageFactory.initElements(driver, Catalog.class);
        WebElement productToBeclicked = catalog.getProduct(productList).get(prdName);
        new Actions(driver).moveToElement(productToBeclicked).build().perform();
        productToBeclicked.click();
        UtilHBM.waitFixTime(1000);
        return this;
    }

    public MakeItYours validateCombination() {
        UtilHBM.waitExplicitClickable(driver, validateButton);
        validateButton.click();
        try {
            UtilHBM.turnOffImplicitWaits(driver);
            WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));
            wt.until(ExpectedConditions.invisibilityOf(replaceByCombinationLayout));
        } catch (NoSuchElementException | TimeoutException ex) {
        }
        UtilHBM.turnOnImplicitWaits(driver);

        return PageFactory.initElements(driver, MakeItYours.class);
    }

    public ReplaceWithMultipleCabinets waitForActivePanel(String panel) {
        sw:
        switch (panel.toLowerCase()) {
            case "combination":
                for (int tryCount = 0; tryCount < 5; tryCount++) {
                    if (combinationPanel.getAttribute("aria-hidden").equalsIgnoreCase("false")) break sw;
                    UtilHBM.waitFixTime(500);
                }
                UtilHBM.reportKO("combinationPanel is not active.. ");
                break;

            case "1st cabinet":
                for (int tryCount = 0; tryCount < 5; tryCount++) {
                    if (firstCabinetPanel.getAttribute("aria-hidden").equalsIgnoreCase("false")) break sw;
                    UtilHBM.waitFixTime(500);
                }
                UtilHBM.reportKO("firstCabinetPanel is not active.. ");
                break;

            case "2nd cabinet":
                for (int tryCount = 0; tryCount < 5; tryCount++) {
                    if (secondCabinetPanel.getAttribute("aria-hidden").equalsIgnoreCase("false")) break sw;
                    UtilHBM.waitFixTime(500);
                }
                UtilHBM.reportKO("secondCabinetPanel is not active.. ");
                break;

            case "3rd cabinet":
                for (int tryCount = 0; tryCount < 5; tryCount++) {
                    if (thirdCabinetPanel.getAttribute("aria-hidden").equalsIgnoreCase("false")) break sw;
                    UtilHBM.waitFixTime(500);
                }
                UtilHBM.reportKO("thirdCabinetPanel is not active.. ");
                break;

            default:
                UtilHBM.reportKO("Wrong input for panel : " + panel);
        }
        return this;
    }

    public MakeItYours cancelCombination() {
        UtilHBM.waitExplicitClickable(driver, cancelButton);
        cancelButton.click();
        try {
            UtilHBM.turnOffImplicitWaits(driver);
            WebDriverWait wt = new WebDriverWait(driver, 5);
            wt.until(ExpectedConditions.invisibilityOf(replaceByCombinationLayout));
        } catch (NoSuchElementException | TimeoutException ex) {
        }
        UtilHBM.turnOnImplicitWaits(driver);

        return PageFactory.initElements(driver, MakeItYours.class);
    }

    public ReplaceWithMultipleCabinets selectTab(String tab) {
        sw:
        switch (tab.toLowerCase()) {
            case "combination":
                UtilHBM.waitExplicitClickable(driver, combinationTab);
                combinationTab.click();
                for (int tryCount = 0; tryCount < 5; tryCount++) {
                    if (combinationPanel.getAttribute("aria-hidden").equalsIgnoreCase("false")) break sw;
                    UtilHBM.waitFixTime(500);
                }
                Assert.fail("Couldn't switch to combinationTab");
                break;

            case "1st cabinet":
                UtilHBM.waitExplicitClickable(driver, firstCabinetTab);
                firstCabinetTab.click();
                for (int tryCount = 0; tryCount < 5; tryCount++) {
                    if (firstCabinetPanel.getAttribute("aria-hidden").equalsIgnoreCase("false")) break sw;
                    UtilHBM.waitFixTime(500);
                }
                Assert.fail("Couldn't switch to firstCabinetTab");
                break;

            case "2nd cabinet":
                UtilHBM.waitExplicitClickable(driver, secondCabinetTab);
                secondCabinetTab.click();
                for (int tryCount = 0; tryCount < 5; tryCount++) {
                    if (secondCabinetPanel.getAttribute("aria-hidden").equalsIgnoreCase("false")) break sw;
                    UtilHBM.waitFixTime(500);
                }
                Assert.fail("Couldn't switch to secondCabinetTab");
                break;

            case "3rd cabinet":
                UtilHBM.waitExplicitClickable(driver, thirdCabinetTab);
                thirdCabinetTab.click();
                for (int tryCount = 0; tryCount < 5; tryCount++) {
                    if (thirdCabinetPanel.getAttribute("aria-hidden").equalsIgnoreCase("false")) break sw;
                    UtilHBM.waitFixTime(500);
                }
                Assert.fail("Couldn't switch to thirdCabinetTab");
                break;

            default:
                UtilHBM.reportKO("Wrong input for tab : " + tab);
        }
        return this;
    }

}
