package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class ChangePasswordDialog {
	
	WebDriver driver;
	
	public ChangePasswordDialog(WebDriver driver) {
		this.driver=driver;	
	}
	
@FindBy(id = "change_password_current")
	private WebElement currentPassword;

	@FindBy(id = "change_password_new_first")
	private WebElement newPassword;

	@FindBy(id = "change_password_new_second")
	private WebElement confirmNewPassword;

	@FindBy(css = "input[type='submit']")
	private WebElement savePassword;

	@FindBy(css = ".button--alt")
	private WebElement cancelChangePassword;

	
	public ChangePasswordDialog verifyChangePasswordDialog() {
		UtilHBM.waitExplicitDisplayed(driver, currentPassword);
		if (currentPassword.isEnabled() && newPassword.isEnabled() && confirmNewPassword.isEnabled()
				&& savePassword.isEnabled()) {
			UtilHBM.reportOK("Change Password fields are enabled");
		} else {
			UtilHBM.reportKO("Change Password fields are not enabled");
		}
		Verification.displayOfWebElement(savePassword);
		return this;
	}
	
	public ChangePasswordDialog enterPasswords(String currentPwd, String newPwd) {
		UtilHBM.waitExplicitDisplayed(driver, currentPassword);
		currentPassword.sendKeys(currentPwd);
		newPassword.sendKeys(newPwd);
		confirmNewPassword.sendKeys(newPwd);
		return this;
	}
	
	public MyAccount clickCancelButton() {
		UtilHBM.waitExplicitDisplayed(driver, cancelChangePassword);
		UtilHBM.waitExplicitClickable(driver, cancelChangePassword);
		cancelChangePassword.click();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		return PageFactory.initElements(driver, MyAccount.class);
	}
	
	public MyAccount saveChangePassword() {
		UtilHBM.waitExplicitDisplayed(driver, savePassword);
		UtilHBM.waitExplicitClickable(driver, savePassword);
		savePassword.click();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		return PageFactory.initElements(driver, MyAccount.class);
	}
}
