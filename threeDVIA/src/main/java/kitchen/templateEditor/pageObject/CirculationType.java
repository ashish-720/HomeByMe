package kitchen.templateEditor.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import kitchen.templateEditor.pageObject.Circulations;

public class CirculationType {
	WebDriver driver;
	
	public CirculationType(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css="label>input[value='group']")
	WebElement groupCirRadioButton;
	
	@FindBy(css="label>input[value='product']")
	WebElement productCirRadioButton;	
	
	@FindBy(css="button[data-ui-action='popin-ok']")
	WebElement okButton;
	
	@FindBy(css="h2.tt")
	WebElement title2;
	
	@FindBy(css="ul.group-list>li")
	List<WebElement> groupList;
	
	public Circulations selectType(String type)
	{
		Verification.VerifyEquals("Page title not displayed", title2.getText(), "Circulation type");
		if(type=="product")
		{
			productCirRadioButton.click();
			okButton.click();
		}
		else
			okButton.click();
		for(int i=0;i<groupList.size();i++)
		{
			UtilHBM.waitExplicitDisplayed(driver, groupList.get(i));
			UtilHBM.reportOK(groupList.size()+" substitutions created.");
		}
		return PageFactory.initElements(driver, Circulations.class);
	}
	
}
