package kitchen.threeDCloudByMe.pageObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;

public class ApplicativeRulesCatalog {
	WebDriver driver;

	public ApplicativeRulesCatalog(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css="#catalog_name")
	WebElement catalogNameInput;
	
	@FindBy(css="input[value='Select Some Options']")
	WebElement appDistInput;
	
	@FindBy(css="#catalog_startDate")
	WebElement startDate;
	
	@FindBy(css="#catalog_endDate")
	WebElement endDate;
	
	@FindBy(css="#menu-edit-catalog")
	WebElement editApplicativeRuleButton;
	
	@FindBy(css="#btnSubmitForm")
	WebElement saveButton;
	
	@FindBy(css=".footer-fixed>.mod-notification>.success.show")
	WebElement successMsg;

	
	ApplicativeRulesCatalog createAppRuleCatalog(String catalogName,String appDistribution,String appRuleName)
	{
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		catalogNameInput.sendKeys(catalogName+"_"+s);
		appDistInput.sendKeys(appDistribution);
		WebElement appDist = driver.findElement(By.xpath("//div/ul/li[.='"+appDistribution+"']"));
		appDist.click();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		String sDate = sdf.format(c.getTime());
		c.setTime(new Date());
		c.add(Calendar.DATE, 2);
		String eDate = sdf.format(c.getTime());
		startDate.sendKeys(sDate);
		endDate.sendKeys(eDate);
		clickEditApplicativeRules()
		.addApplicativeRules(appRuleName);
		UtilHBM.waitTillElementDisappear(driver, "#modalForm");
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "#table_catalog_rules"));

		List<WebElement> appRuleList=driver.findElements(By.xpath("//div/table[contains(@id,'table_catalog_rules')]/tbody/tr/td[2]"));
		if(appRuleList.size()==0)
		{
			UtilHBM.reportKO("No applicative rules added to the catalog");
		}
		else
		{
			for(int i=0;i<appRuleList.size();i++)
			{
				UtilHBM.waitExplicitDisplayed(driver, appRuleList.get(i));
			}		
			for(int i=0;i<appRuleList.size();i++)
			{
				if(appRuleList.get(i).getText().contentEquals(Level1DlgBox.getAddedAppRules().get(i)))
				{
					UtilHBM.reportOK("Application rule added to catalog:"+appRuleList.get(i).getText());
				}
			}
			clickSave();
		}
		return this;
	}
	
	ApplicativeRulesCatalog clickSave()
	{
		saveButton.click();
		UtilHBM.waitExplicitDisplayed(driver, successMsg);
		UtilHBM.reportOK(successMsg.getText());
		return PageFactory.initElements(driver, ApplicativeRulesCatalog.class);
	}
	
	Level1DlgBox clickEditApplicativeRules()
	{
		editApplicativeRuleButton.click();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}
}
