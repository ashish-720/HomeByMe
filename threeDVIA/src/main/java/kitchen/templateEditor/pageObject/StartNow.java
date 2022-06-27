package kitchen.templateEditor.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

	
public class StartNow {
		WebDriver driver;
		
		public StartNow(WebDriver driver) {
			this.driver=driver;	
		}
	
		@FindBy(css="button.cta-primary-alt-l")
		WebElement okButton;		

		@FindBy(css="h1")
		WebElement title;
		
		@FindBy(css="p[class='subtitle']")
		WebElement subtitle;
		
		@FindBy(css="label[for='legalEntity']")
		WebElement subtitle1;
		
		@FindBy(css="label[for='appDistrib']")
		WebElement subtitle2;
		
		@FindBy(css="body>div>main>div>div>div>fieldset>p.info")
		WebElement subtitle3;
		
		@FindBy(css="button[data-state='design']")
		WebElement designButton;
			
		@FindBy(css="li.current>button")
		WebElement title1;
		
		@FindBy(css="#objects>span")
		WebElement subtitle4;
		
		@FindBy(css="#openings>span")
		WebElement subtitle5;
		
		@FindBy(css="#covering:paint>span")
		WebElement subtitle6;
		
		@FindBy(css="#toolbox-tools>li>button>span")
		WebElement subtitle7;
		
		@FindBy(css="label[for='floorplan-ceiling']")
		WebElement subtitle8;
		
		public Floorplan startNow() {
			Verification.VerifyEquals("Page title not displayed", title.getText(), "Template Editor access");
			Verification.VerifyEquals("Page subtitle not displayed",subtitle.getText(),"Fill in the information of this template");
			Verification.VerifyEquals("Page subtitle not displayed", subtitle1.getText(), "Legal Entity *");
			Verification.VerifyEquals("Page subtitle not displayed", subtitle2.getText(), "Application distribution *");
			Verification.VerifyEquals("Page subtitle not displayed", subtitle3.getText(), "* Mandatory fields");
			okButton.click();
			UtilHBM.waitFixTime(1000);
			driver.switchTo().frame(driver.findElement(By.id("embedded-app-frame")));
			UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "div[class*='room Tag3D']>input"));
			return PageFactory.initElements(driver, Floorplan.class);
	}
	
}
