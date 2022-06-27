package kitchen.threeDCloudByMe.pageObject;

import hbm.planner.utility.UtilHBM;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPageBeta {
	WebDriver driver;
	public CatalogPageBeta(WebDriver driver) {
		this.driver=driver;	
	}

	@FindBy(css="input[name='catalogID']")
	private WebElement idInputField;

	@FindBy(css="input[name='name']")
	private WebElement nameInputField;

	@FindBy(css="button[data-testid='catalog-edit-submit-button']")
	private WebElement submitBtn;

	@FindBy(css="button[data-testid='create-add-product']")
	private WebElement addProductsBtn;

	@FindBy(css = "div.MuiSnackbar-root div.MuiAlert-filledSuccess div.MuiAlert-message")
	private WebElement successNotification;

	@FindBy(css = "div[data-testid='list-selection.products']")
	private WebElement productSelectionDialog;

	public CatalogPageBeta createNewCatalog(String catalogName, String products) {
		String timeStamp = UtilHBM.getDate(0, "_ddMMyy_HHmmss");
		(new Actions(driver)).click(idInputField).pause(500).keyDown(Keys.CONTROL).sendKeys("A").pause(2000).keyUp(Keys.CONTROL)
				.sendKeys(catalogName.substring(0,4) + timeStamp).build().perform();

		nameInputField.sendKeys("Auto_"+catalogName+timeStamp);
		submitBtn.click();
		UtilHBM.waitExplicitDisplayed(driver, successNotification);

		UtilHBM.waitExplicitDisplayed(driver, addProductsBtn);
		addProductsBtn.click();
		UtilHBM.waitExplicitDisplayed(driver, productSelectionDialog);
		PageFactory.initElements(driver, ProductSelectionDialogBeta.class).filterAndSelectProducts(products);
		UtilHBM.waitExplicitDisplayed(driver, successNotification);

		return PageFactory.initElements(driver, CatalogPageBeta.class);
	}



}
