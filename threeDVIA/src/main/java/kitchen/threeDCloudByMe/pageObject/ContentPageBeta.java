package kitchen.threeDCloudByMe.pageObject;

import hbm.planner.utility.UtilHBM;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContentPageBeta {
    WebDriver driver;

    public ContentPageBeta(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "span.MuiCircularProgress-root")
    private WebElement signinProgress;

    @FindBy(css = "header.MuiPaper-root img[alt='logo'][src='/beta/static/media/logo-3dcloudbyme.da391d994f13c68e79e6ab5bdedb34b5.svg']")
    private WebElement logo;

    @FindBy(css = "div.MuiDrawer-root a[href='/beta/products']")
    private WebElement productsButton;

    @FindBy(css = "div.MuiDrawer-root a[href='/beta/app-distributions']")
    private WebElement appDistributionsButton;

    @FindBy(css = "div.MuiTabs-fixed a[href='/beta/products/catalogs']")
    private WebElement catalogsTab;

    @FindBy(css = "div.MuiGrid-container button[data-testid='create-catalog-new']")
    private WebElement createNewCatalogBtn;

    @FindBy(css = "button[data-testid='profile-menu']")
    private WebElement openCloseProfileMenu;

    @FindBy(css = "ul>li[data-testid='logout-selector']")
    private WebElement logoutBtn;

    @FindBy(css = "table.MuiTable-root")
    private WebElement gridTable;

    @FindBy(css = "table.MuiTable-root tr.MuiTableRow-head>th")
    private List<WebElement> tableHeaders;

    @FindBy(css = "table.MuiTable-root tr.MuiTableRow-hover")
    private List<WebElement> tableRows;

    @FindBy(css = "div.MuiTablePagination-toolbar div.MuiTablePagination-select")
    private WebElement paginationSelect;

    @FindBy(css = "ul.MuiList-root[role='listbox']")
    private WebElement paginationList;

    @FindBy(css = "div.MuiTablePagination-toolbar p.MuiTablePagination-displayedRows")
    private WebElement paginationDisplayedRows;

    @FindBy(css = "div.MuiTablePagination-toolbar div.MuiTablePagination-actions button[data-testid='previous-page']")
    private WebElement paginationPrevious;

    @FindBy(css = "div.MuiTablePagination-toolbar div.MuiTablePagination-actions button[data-testid='next-page']")
    private WebElement paginationNext;


    public ContentPageBeta createNewCatalog(String catalogName, String products) {
        UtilHBM.waitExplicitDisplayed(driver, createNewCatalogBtn);
        createNewCatalogBtn.click();
        PageFactory.initElements(driver, CatalogPageBeta.class).createNewCatalog(catalogName, products);

        return this;
    }

    public ContentPageBeta waitForSigninProgress() {
        UtilHBM.waitExplicitDisplayed(driver, signinProgress);
//		UtilHBM.waitTillElementDisappear(driver, signinProgress);
        UtilHBM.waitExplicitDisplayed(driver, logo);
        Assert.assertTrue(productsButton.getAttribute("class").contains("Mui-selected"));
        Assert.assertTrue(catalogsTab.getAttribute("class").contains("Mui-selected"));

        return this;
    }

    public Content logoutfrom3DCloudBeta() {
        UtilHBM.waitExplicitDisplayed(driver, openCloseProfileMenu);
        openCloseProfileMenu.click();
        UtilHBM.waitExplicitDisplayed(driver, logoutBtn);
        logoutBtn.click();

        return PageFactory.initElements(driver, Content.class);
    }

    public ContentPageBeta gotoAppDistributions() {
        UtilHBM.waitExplicitDisplayed(driver, appDistributionsButton);
        appDistributionsButton.click();
        UtilHBM.waitFixTime(500);

        Assert.assertTrue(appDistributionsButton.getAttribute("class").contains("Mui-selected"));
        return this;
    }

    public AppDistributionsPageBeta editAppDistribution(String appDistributionName) {
        int headerIndex = getTableHeaderIndex("Actions");
        WebElement reqRow = searchForRow("Name", appDistributionName);
        if (reqRow != null)
            reqRow.findElement(By.cssSelector("td:nth-of-type(" + headerIndex + ") button[data-testid$='-actions-edit']")).click();
        else UtilHBM.reportKO("App Distribution with name : '" + appDistributionName + "' not found");

        AppDistributionsPageBeta appDist=PageFactory.initElements(driver, AppDistributionsPageBeta.class);
        return appDist.waitForAppDistributionPage();
    }

//    private WebElement searchForRow(String columnID, String columnVal,boolean s) {
//
//	}

    private WebElement searchForRow(String columnID, String columnVal) {
        UtilHBM.turnOffImplicitWaits(driver);
        int headerIndex = getTableHeaderIndex(columnID);

        List<WebElement> matches = gridTable.findElements(By.xpath("td[" + headerIndex + "]/p[text()='" + columnVal + "']//ancestor::tr"));
        if (matches.size() > 0) {
            return matches.get(0);
        } else {
            setPagination(100);
            int maxRows, currentMax;
            do {
                String rowsDisplayed = paginationDisplayedRows.getText().trim();
                maxRows = Integer.parseInt(rowsDisplayed.split("of")[1].trim());
                currentMax = Integer.parseInt(rowsDisplayed.split("of")[0].split("–")[1].trim());

                matches = gridTable.findElements(By.xpath("//td[" + headerIndex + "]/p[text()='" + columnVal + "']//ancestor::tr"));
                if (matches.size() > 0) {
                    return matches.get(0);
                } else {
                    clickPaginationNext();
                }
            } while (currentMax < maxRows);
        }
        return null;
    }

    private int getTableHeaderIndex(String tableHeaderName) {
        List<String> tableHeaderNames = getTableHeaders(tableHeaders);
        return tableHeaderNames.indexOf(tableHeaderName) + 1;
    }

    private List<String> getTableHeaders(List<WebElement> tableHeaders) {
        List<String> tableHeaderNames = new ArrayList<>();
        for (WebElement tableHeader : tableHeaders) tableHeaderNames.add(tableHeader.getText().trim());
        return tableHeaderNames;
    }

    public ContentPageBeta setPagination(int rowsPerPage) {
        UtilHBM.waitExplicitDisplayed(driver, paginationSelect);
        if (paginationSelect.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            paginationSelect.click();
        }
        UtilHBM.waitExplicitDisplayed(driver, paginationList);
        paginationList.findElement(By.cssSelector("li[data-value='" + rowsPerPage + "']")).click();

        UtilHBM.waitExplicitDisplayed(driver, paginationDisplayedRows);
        UtilHBM.reportInfo("Pages displayed : " + paginationDisplayedRows.getText());
        return this;
    }

    public ContentPageBeta clickPaginationNext() {
        UtilHBM.turnOffImplicitWaits(driver);
        try {
            paginationNext.click();
        } catch (ElementClickInterceptedException ex) {
            UtilHBM.reportWarning("Unable to click, Pagination Next was disabled");
        }
        UtilHBM.turnOnImplicitWaits(driver);

        UtilHBM.waitExplicitDisplayed(driver, paginationDisplayedRows);
        UtilHBM.reportInfo("Pages displayed : " + paginationDisplayedRows.getText());
        return this;
    }

    public ContentPageBeta clickPaginationPrevious() {
        UtilHBM.turnOffImplicitWaits(driver);
        try {
            paginationPrevious.click();
        } catch (ElementClickInterceptedException ex) {
            UtilHBM.reportWarning("Unable to click, Pagination Previous was disabled");
        }
        UtilHBM.turnOnImplicitWaits(driver);

        UtilHBM.waitExplicitDisplayed(driver, paginationDisplayedRows);
        UtilHBM.reportInfo("Pages displayed : " + paginationDisplayedRows.getText());
        return this;
    }
}
