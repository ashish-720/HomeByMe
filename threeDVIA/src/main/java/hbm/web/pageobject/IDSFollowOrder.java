package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import hbm.web.pageobject.MyAccount;


public class IDSFollowOrder {
	WebDriver driver;
	public IDSFollowOrder(WebDriver driver) {
		 this.driver = driver;
	}

	@FindBy(css ="div.wrapper.thank-you>div>a")
	public WebElement followMyOrder;
	
	@FindBy(css ="div>h1")
	public WebElement idsHeader;
	
	@FindBy(css ="div>h2")
	public WebElement whatsNext;
	
	@FindBy(xpath ="//div[@class='wrapper thank-you']/p[1]")
	public WebElement followMyOrderText1;
	
	@FindBy(xpath ="//div[@class='wrapper thank-you']/p[2]")
	public WebElement followMyOrderText2;
	
	public MyAccount iDSFollowMyOrder() {
		UtilHBM.waitExplicitDisplayed(driver,idsHeader);
		Verification.VerifyEquals("Incorrect IDSHeader", idsHeader.getText(), "Interior design service");
		Verification.VerifyEquals("Incorrect whatsNext",whatsNext.getText(),"What's next?");
		Verification.VerifyEquals("Incorrect followMyOrderText1", followMyOrderText1.getText(), "A confirmation email has been sent to you. Our architects analyze your information and will keep you informed once your project is finished.");
		Verification.VerifyEquals("Incorrect followMyOrderText2", followMyOrderText2.getText(), "You can track the status of your order on the page my account.");
		Verification.displayNAttributeCheckOfElement(followMyOrder, "followMyOrder", "href", "https://preprod-home.by.me/en/my-account/purchase");
		UtilHBM.waitExplicitClickable(driver,followMyOrder);
		followMyOrder.click();
		return PageFactory.initElements(driver, MyAccount.class);	
	}
	
}
