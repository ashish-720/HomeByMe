package hbm.web.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;


public class CheckActivityStatus {
	private WebDriver driver;
	
	public CheckActivityStatus (WebDriver driver){
		this.driver = driver;
	}
	
	@FindBy(css ="a.close-modal.button-close")
	private static WebElement allYourActivityClose;
	
	@CacheLookup
	@FindBy(css ="a[title='All your activity']")
	private static WebElement allYourActivity;
	
	@CacheLookup
	@FindBy(xpath ="//div[@class='head']/span/strong[contains(text(),'Projects')]/../../following-sibling::div[1]")
	private static WebElement projectsUsed1;
	
	@CacheLookup
	@FindBy(xpath ="//div[@class='head']/span/strong[contains(text(),'Projects')]/../../following-sibling::div[2]")
	private static WebElement projectsAvailable1;
	
	@CacheLookup
	@FindBy(xpath ="//div[@class='head']/span/strong[contains(text(),'Realistic')]/../../following-sibling::div[1]")
	private static WebElement realisticUsed1;
	
	@CacheLookup
	@FindBy(xpath ="//div[@class='head']/span/strong[contains(text(),'Realistic')]/../../following-sibling::div[2]")
	private static WebElement realisticAvailable1;
	
	@CacheLookup
	@FindBy(xpath ="//div[@class='head']/span/strong[contains(text(),'360')]/../../following-sibling::div[1]")
	private static WebElement a360Used1;
	
	@CacheLookup
	@FindBy(xpath ="//div[@class='head']/span/strong[contains(text(),'360')]/../../following-sibling::div[2]")
	private static WebElement a360Available1;
	
	@FindBy(css ="div.modal-header>h2")
	private static WebElement yourActivityHeader;
	
	public UserHomePage checkActivityStatus(String attibute, int used,int available) {
		UtilHBM.waitExplicitDisplayed(driver, yourActivityHeader);
		if(attibute.contains("360")) {
			if(Integer.parseInt(a360Used1.getText())==used && Integer.parseInt(a360Available1.getText())==available) 
				UtilHBM.reportOK(attibute + " Verified for used & availalve credits");
			else 
				UtilHBM.reportKO(attibute + " values for used & availalve credits are incorrect!!!"
						+ '\n'+ "Used 360=" + a360Used1.getText()+ 
						'\n'+ "Available 360=" + a360Available1.getText() );
		}
		
		else if(attibute.contains("Projects")) {
			if(Integer.parseInt(projectsUsed1.getText())==used && Integer.parseInt(projectsAvailable1.getText())==available) 
				UtilHBM.reportOK(attibute + " Verified for used & availalve credits");
			else 
				UtilHBM.reportKO(attibute + " values for used & availalve credits are incorrect!!!"
						+ '\n'+ "Used Projects=" + projectsUsed1.getText()+ 
						'\n'+ "Available Projects=" + projectsAvailable1.getText() );
		} 
		
		else if(attibute.contains("Realistic")) {
			if(Integer.parseInt(realisticUsed1.getText())==used && Integer.parseInt(realisticAvailable1.getText())==available) 
				UtilHBM.reportOK(attibute + " Verified for used & availalve credits");
			else 
				UtilHBM.reportKO(attibute + " values for used & availalve credits are incorrect!!!" 
			+ '\n'+ "Used HQ=" + realisticUsed1.getText()+ 
			'\n'+ "Available HQ=" + realisticAvailable1.getText() );
		}
		allYourActivityClose.click();
		UtilHBM.waitFixTime(1000);
		
		return PageFactory.initElements(driver, UserHomePage.class);
	}

	public int getUsedValue(String attribute) {
		allYourActivity.click();
		UtilHBM.waitExplicitDisplayed(driver, yourActivityHeader);
		String attribute1= driver.findElement(By.xpath("//div[@class='head']/span/strong[contains(text(),'"+attribute+"')]/../../following-sibling::div[1]")).getText();
		allYourActivityClose.click();
		return Integer.parseInt(attribute1);
		}
	
	public int getAvailableValue(String attribute) {
		allYourActivity.click();
		String attribute2= driver.findElement(By.xpath("//div[@class='head']/span/strong[contains(text(),'"+attribute+"')]/../../following-sibling::div[2]")).getText();
		allYourActivityClose.click();
		return Integer.parseInt(attribute2);
		}
	
	
}
