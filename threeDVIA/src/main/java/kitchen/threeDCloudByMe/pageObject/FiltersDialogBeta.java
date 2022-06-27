package kitchen.threeDCloudByMe.pageObject;

import hbm.planner.utility.UtilHBM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FiltersDialogBeta {
    WebDriver driver;

    public FiltersDialogBeta(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "div.MuiSnackbar-root div.MuiAlert-filledSuccess div.MuiAlert-message")
    private WebElement successNotification;

    @FindBy(xpath = "//div[@role='dialog']//h2[text()='Filters']/parent::form")
    private WebElement filterDialogBox;

    @FindBy(css = "input[name='reference']")
    private WebElement referenceInputBox;

    @FindBy(css = "input[name='id']")
    private WebElement idInputBox;

    @FindBy(css = "button[data-testid='filters-submit-button']")
    private WebElement submitBtn;


    /**
     * @param filterBy 'catalog', 'id' or 'reference'
     * @param product  text field value based on which user wants to filter
     */
    public void filterBy(String filterBy, String product) {
        WebElement filterRadioBtn = driver.findElement(By.cssSelector("input[name='controlled-radio-buttons-group'][value='" + filterBy + "']"));
        if (!filterRadioBtn.isSelected()) filterRadioBtn.click();

        switch (filterBy.toLowerCase()) {
            case "catalog":
                break;
            case "id":
                idInputBox.clear();
                idInputBox.sendKeys(product);
                break;
            case "reference":
            default:
                referenceInputBox.clear();
                referenceInputBox.sendKeys(product);
        }

		submitBtn.click();
        UtilHBM.waitFixTime(500);
    }
}
