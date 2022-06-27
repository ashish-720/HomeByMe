package kitchen.threeDCloudByMe.pageObject;

import hbm.planner.utility.UtilHBM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class ProductSelectionDialogBeta {
    WebDriver driver;

    public ProductSelectionDialogBeta(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "div.MuiSnackbar-root div.MuiAlert-filledSuccess div.MuiAlert-message")
    private WebElement successNotification;

    @FindBy(css = "div[data-testid='list-selection.products']")
    private WebElement productSelectionDialog;

    @FindBy(css = "button[data-testid='button-filter-dialog']")
    private WebElement filtersBtn;

    @FindBy(xpath = "//div[@role='dialog']//h2[text()='Filters']/parent::form")
    private WebElement filterDialogBox;

    @FindBy(css = "table.MuiTable-root tr.MuiTableRow-hover")
    private List<WebElement> tableRows;

    @FindBy(css = "button[data-testid='add-selected-product-submit-button']")
    private WebElement submitBtn;


    public void filterAndSelectProducts(String products) {
        List<String> productsToAdd = Arrays.asList(products.split("\\s*>\\s*"));
        for (String prdt : productsToAdd) {
			filtersBtn.click();
			UtilHBM.waitExplicitDisplayed(driver, filterDialogBox);
			PageFactory.initElements(driver, FiltersDialogBeta.class).filterBy("reference", prdt);

			if (tableRows.size() == 0) {
				UtilHBM.reportKO("Product with ref. '" + prdt + "' not found");
			} else {
				tableRows.get(0).findElement(By.cssSelector("td.MuiTableCell-paddingCheckbox span.MuiCheckbox-root")).click();
				UtilHBM.waitFixTime(500);
			}
		}
            submitBtn.click();
            UtilHBM.waitFixTime(1000);
    }
}
