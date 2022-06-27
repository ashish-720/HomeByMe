package kitchen.threeDCloudByMe.pageObject;

import hbm.planner.utility.UtilHBM;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductRules {
	WebDriver driver;

	public ProductRules(WebDriver driver) {
		this.driver=driver;	
	}

	@FindBy(css="#rule_name")
	WebElement ruleNameInput;

	@FindBy(xpath="//div[@class='mod-notification']/p[contains(@class, 'error') and contains(text(), 'Permission denied')]")
	private WebElement permissionDeniedErrPopup;

	@FindBy(css="#btnSubmitForm")
	WebElement saveButton;

	@FindBy(css="#btnNextForm")
	WebElement nextButton;
	
	public Content createNewProductRule(String productRule)
	{
		
		return PageFactory.initElements(driver, Content.class);
	}

	public ProductRules saveAndVerifyPermissionDenied() {
		if (nextButton.isDisplayed()) nextButton.click();
		UtilHBM.waitExplicitDisplayed(driver, saveButton);
		saveButton.click();
		UtilHBM.waitExplicitDisplayed(driver, permissionDeniedErrPopup);
		UtilHBM.reportOK("Error message verified correctly : " + permissionDeniedErrPopup.getText());
		return PageFactory.initElements(driver, ProductRules.class);
	}

	public ProductRules updateProductRuleName(String name, String operation) {
		UtilHBM.waitExplicitDisplayed(driver,ruleNameInput);
		switch (operation.toUpperCase()) {
			case "APPEND":
				String currentName = ruleNameInput.getAttribute("value");
				ruleNameInput.clear();
				ruleNameInput.sendKeys(currentName + name + Keys.ENTER);
				break;

			case "MODIFY":
			default:
				ruleNameInput.clear();
				ruleNameInput.sendKeys(name + Keys.ENTER);
		}
		return this;
	}

}
