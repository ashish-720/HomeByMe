package kitchen.threeDCloudByMe.pageObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hbm.planner.utility.UtilHBM;

public class ApplicativeRule {
	WebDriver driver;

	public ApplicativeRule(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css="#applicative_rule_name")
	WebElement appRuleNameInput;
	
	@FindBy(css="#applicative_rule_ruleKey")
	WebElement ruleNameInput;
	
	@FindBy(css="select[id='applicative_rule_criticityLevel']")
	WebElement selectCriticity;
	
	@FindBy(css="#applicative_rule_overloads")
	WebElement parametersInput;
	
	@FindBy(css="#btnSubmitForm")
	WebElement saveButton;
	
	@FindBy(css=".footer-fixed>.mod-notification>.success.show")
	WebElement successMsg;
	
	@FindBy(css=".footer-fixed>.mod-notification>.success.show")
	List<WebElement> successMsgList;
	
	@FindBy(css="a[href='/en/dashboard/applicativerule']")
	WebElement backButton;

	@FindBy(xpath="//div[@class='mod-notification']/p[contains(@class, 'error') and contains(text(), 'Permission denied')]")
	private WebElement permissionDeniedErrPopup;


	Content createApplicativeRule(String appRuleName,String ruleName,String criticity,String parameter)
	{
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		appRuleNameInput.sendKeys(appRuleName+"_"+s);
		ruleNameInput.sendKeys(ruleName+"_"+s);
		new Select(selectCriticity).selectByValue(criticity);
		parametersInput.sendKeys(parameter);
		UtilHBM.waitFixTime(1000);
		clickSave()
		.clickBack();
		return PageFactory.initElements(driver, Content.class);
	}
	
	Content clickBack()
	{
		backButton.click();
		return PageFactory.initElements(driver, Content.class);
	}
	
	ApplicativeRule clickSave()
	{
		do {
			saveButton.click();
			UtilHBM.waitExplicitDisplayed(driver, successMsg);
		}while(successMsgList.size()==0);
		UtilHBM.reportOK(successMsg.getText());
		return this;
	}

	public ApplicativeRule updateapplicativeRuleName(String name, String operation) {
		UtilHBM.waitExplicitDisplayed(driver,appRuleNameInput);
		switch (operation.toUpperCase()) {
			case "APPEND":
				String currentName = appRuleNameInput.getAttribute("value");
				appRuleNameInput.clear();
				appRuleNameInput.sendKeys(currentName + name + Keys.ENTER);
				break;

			case "MODIFY":
			default:
				appRuleNameInput.clear();
				appRuleNameInput.sendKeys(name + Keys.ENTER);
		}
		return this;
	}

	public ApplicativeRule saveAndVerifyPermissionDenied()
	{
		saveButton.click();
		UtilHBM.waitExplicitDisplayed(driver, permissionDeniedErrPopup);
		UtilHBM.reportOK("Verified error message : " + permissionDeniedErrPopup.getText());
		return this;
	}
}
