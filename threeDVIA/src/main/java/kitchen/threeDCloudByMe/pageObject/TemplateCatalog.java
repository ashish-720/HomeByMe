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

public class TemplateCatalog {
	WebDriver driver;

	public TemplateCatalog(WebDriver driver) {
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
	
	@FindBy(css="#table_catalog_templates_processing")
	List<WebElement> processingLabel;
	
	@FindBy(css="#menu-edit-catalog")
	WebElement editTemplatesButton;
	
	@FindBy(css="#btnSubmitForm")
	WebElement saveButton;
	
	@FindBy(css=".footer-fixed>.mod-notification>.success.show")
	WebElement successMsg;
	
	public TemplateCatalog createCatalog(String catalogName,String appDist,String templateName)
	{
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy_hh_mm");
		Date date=new Date();
		String s=dateFormat.format(date);
		catalogNameInput.sendKeys(catalogName+"_"+s);
		appDistInput.sendKeys(appDist);
		WebElement appDistribution = driver.findElement(By.xpath("//div/ul/li[.='"+appDist+"']"));
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		String sDate = sdf.format(c.getTime());
		c.setTime(new Date());
		c.add(Calendar.DATE, 2);
		String eDate = sdf.format(c.getTime());
		appDistribution.click();
		startDate.sendKeys(sDate);
		endDate.sendKeys(eDate);
		clickEditTemplates()
		.addTemplates(templateName);
		UtilHBM.waitTillElementDisappear(driver, "#modalForm");
		if(processingLabel.size()>0)
		{
			UtilHBM.waitExplicitDisplayed(driver, processingLabel.get(processingLabel.size()-1));
			UtilHBM.waitTillElementDisappear(driver, ".dataTables_processing");
		}
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "#table_catalog_templates"));
		List<WebElement> addedTemplateList=driver.findElements(By.xpath("//*[@id='table_catalog_templates']/tbody/tr/td[2]"));
		if(addedTemplateList.size()==0)
		{
			UtilHBM.reportKO("No templates added to the catalog");
		}
		else
		{
			for(int i=0;i<addedTemplateList.size();i++)
			{
				if(addedTemplateList.get(i).getText().contentEquals(Level1DlgBox.getAddedTemplates().get(i)))
				{
					UtilHBM.reportOK("Template added to the catalog:"+addedTemplateList.get(i).getText());
				}
			}
			clickSave();
		}
		return this;
	}
	
	TemplateCatalog clickSave()
	{
		saveButton.click();
		UtilHBM.waitExplicitDisplayed(driver, successMsg);
		UtilHBM.reportOK(successMsg.getText());
		return this;
	}
	
	Level1DlgBox clickEditTemplates()
	{
		editTemplatesButton.click();
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}
}
