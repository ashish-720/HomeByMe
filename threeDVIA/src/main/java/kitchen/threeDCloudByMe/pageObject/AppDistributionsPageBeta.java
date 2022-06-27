package kitchen.threeDCloudByMe.pageObject;

import hbm.planner.utility.UtilHBM;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AppDistributionsPageBeta {
    WebDriver driver;

    public AppDistributionsPageBeta(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "div[data-testid='id-text-input']")
    private WebElement idInputField;

    @FindBy(css = "div[data-testid='myCatalogs']")
    private WebElement myCatalogsSection;

    @FindBy(css = "div[data-testid='sharedCatalogs']")
    private WebElement sharedCatalogsSection;

    @FindBy(css = "div[data-testid='applicativeRuleCatalogs']")
    private WebElement applicativeRulesSection;

    @FindBy(css = "div[data-testid='templateCatalogs']")
    private WebElement templateCatalogsSection;

    @FindBy(css = "div[data-testid='rules']")
    private WebElement productRulesSection;

    @FindBy(css = "table.MuiTable-root tr.MuiTableRow-hover")
    private List<WebElement> tableRows;

    @FindBy(css = "ul.MuiList-root[role='listbox']")
    private WebElement paginationList;




    public AppDistributionsPageBeta waitForAppDistributionPage(){
        UtilHBM.waitExplicitDisplayed(driver, idInputField);
        return this;
    }

    public AppDistributionsPageBeta selectCatalog(String table, String columnID, String columnVal) {
        WebElement reqRow = searchForRow(table,columnID, columnVal);
        if (reqRow != null)
            reqRow.findElement(By.cssSelector("td:nth-of-type(1) button[data-testid$='-actions-edit']")).click();
        else UtilHBM.reportKO("App Distribution with name : '" + appDistributionName + "' not found");

        AppDistributionsPageBeta appDist= PageFactory.initElements(driver, AppDistributionsPageBeta.class);
        return appDist.waitForAppDistributionPage();
    }


    private WebElement searchForRow(String table, String columnID, String columnVal) {
        UtilHBM.turnOffImplicitWaits(driver);
        WebElement section,gridTable;
        switch(table){
                case "Shared Catalogs":
                    section=sharedCatalogsSection;
                    gridTable=sharedCatalogsSection.findElement(By.cssSelector("table.MuiTable-root"));
                break;
                case "Applicative Rule Catalogs":
                    section=sharedCatalogsSection;
                    gridTable=applicativeRulesSection.findElement(By.cssSelector("table.MuiTable-root"));
                    break;
                case "Template Catalogs":
                    section=sharedCatalogsSection;
                    gridTable=templateCatalogsSection.findElement(By.cssSelector("table.MuiTable-root"));
                    break;
                case "Product Rules":
                    section=sharedCatalogsSection;
                    gridTable=productRulesSection.findElement(By.cssSelector("table.MuiTable-root"));
                    break;
            case "My Catalogs":
            default:
                section=sharedCatalogsSection;
                gridTable=myCatalogsSection.findElement(By.cssSelector("table.MuiTable-root"));
        }
        int headerIndex = getTableHeaderIndex(gridTable,columnID);
        List<WebElement> matches = gridTable.findElements(By.xpath("td[" + headerIndex + "]/p[text()='" + columnVal + "']//ancestor::tr"));
        if (matches.size() > 0) {
            return matches.get(0);
        } else {
            setPagination(section,100);
            int maxRows, currentMax;
            do {
                String rowsDisplayed = section.findElement(By.cssSelector("div.MuiTablePagination-toolbar p.MuiTablePagination-displayedRows")).getText().trim();
                maxRows = Integer.parseInt(rowsDisplayed.split("of")[1].trim());
                currentMax = Integer.parseInt(rowsDisplayed.split("of")[0].split("–")[1].trim());

                matches = gridTable.findElements(By.xpath("//td[" + headerIndex + "]/p[text()='" + columnVal + "']//ancestor::tr"));
                if (matches.size() > 0) {
                    return matches.get(0);
                } else {
                    clickPaginationNext(section);
                }
            } while (currentMax < maxRows);
        }
        return null;
    }

    private int getTableHeaderIndex(WebElement gridTable,String tableHeaderName) {
        List<WebElement> tableHeaders=gridTable.findElements(By.cssSelector("tr.MuiTableRow-head>th"));
        List<String> tableHeaderNames = getTableHeaders(tableHeaders);
        return tableHeaderNames.indexOf(tableHeaderName) + 1;
    }

    private List<String> getTableHeaders(List<WebElement> tableHeaders) {
        List<String> tableHeaderNames = new ArrayList<>();
        for (WebElement tableHeader : tableHeaders) tableHeaderNames.add(tableHeader.getText().trim());
        return tableHeaderNames;
    }

    private AppDistributionsPageBeta setPagination(WebElement section, int rowsPerPage) {
        WebElement paginationSelect=section.findElement(By.cssSelector("div.MuiTablePagination-toolbar div.MuiTablePagination-select"));
        UtilHBM.waitExplicitDisplayed(driver, paginationSelect);
        if (paginationSelect.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            paginationSelect.click();
        }
        UtilHBM.waitExplicitDisplayed(driver, paginationList);
        paginationList.findElement(By.cssSelector("li[data-value='" + rowsPerPage + "']")).click();

        UtilHBM.waitExplicitDisplayed(driver, section.findElement(By.cssSelector("div.MuiTablePagination-toolbar p.MuiTablePagination-displayedRows")));
        UtilHBM.reportInfo("Pages displayed : " + section.findElement(By.cssSelector("div.MuiTablePagination-toolbar p.MuiTablePagination-displayedRows")).getText());
        return this;
    }

    private AppDistributionsPageBeta clickPaginationNext(WebElement section) {
        UtilHBM.turnOnImplicitWaits(driver);
        try {
            section.findElement(By.cssSelector("div.MuiTablePagination-toolbar div.MuiTablePagination-actions button[data-testid='next-page']")).click();
        } catch (ElementClickInterceptedException ex) {
            UtilHBM.reportWarning("Unable to click, Pagination Next was disabled");
        }
        UtilHBM.turnOffImplicitWaits(driver);

        UtilHBM.waitExplicitDisplayed(driver, section.findElement(By.cssSelector("div.MuiTablePagination-toolbar p.MuiTablePagination-displayedRows")));
        UtilHBM.reportInfo("Pages displayed : " + section.findElement(By.cssSelector("div.MuiTablePagination-toolbar p.MuiTablePagination-displayedRows")).getText());
        return this;
    }

}
