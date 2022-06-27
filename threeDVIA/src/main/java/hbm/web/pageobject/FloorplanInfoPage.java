package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import hbm.planner.utility.Verification;

public class FloorplanInfoPage {
	WebDriver driver;

	public FloorplanInfoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css = "html[class=''] body>main>#floor-plan>section.intro.flex.flex-center>article>div.container-intro.u-prs.w-50>h1")
	WebElement fpInfoPageHeader1;
	
	@FindBy(css = ".hero-services__content>h1")
	WebElement fpInfoPageHeader1RS4;
	
	@FindBy(css = "html[class=''] body>main>#floor-plan>section.intro.flex.flex-center>article>div.container-intro.u-prs.w-50>p[class='textL']")
	WebElement fpInfoPageHeader2;
	
	@FindBy(css = "div[class='claim__container row']>p>span")
	WebElement fpInfoPageText1RS4;
	
	@FindBy(css = "html[class=''] body>main>#floor-plan>section.intro.flex.flex-center>article>div.container-intro.u-prs.w-50>a[class='anchor-link button button--l flex-self-left u-mtxxs']")
	WebElement buyNow;
	
	@FindBy(xpath = "//div[@class='cell-4 page--services__sticky']//a[@data-tag-label='buy_floor_plan_service']")
	WebElement buyRS4;
	
	public FloorplanInfoPage verifyFPInfoPage() {
		Verification.VerifyEquals("Wrong fpInfoPageHeader1!!!", fpInfoPageHeader1RS4.getText(), "We draw for you");
		Verification.VerifyEquals("Wrong fpInfoPageHeader2!!!", fpInfoPageText1RS4.getText(),"Would you like to have a 3D turnkey project? Let us do it for you!"); 
				Verification.displayOfWebElement(buyRS4);
		return this;
	}
}
