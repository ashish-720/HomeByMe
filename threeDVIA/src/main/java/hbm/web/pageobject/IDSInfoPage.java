package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class IDSInfoPage {
	WebDriver driver;

	public IDSInfoPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "html[class=''] body>main>div>#intro>div>article>div>h1")
	WebElement idsInfoPageHeader1;

	@FindBy(css = "div.hero-services__content>h1")
	WebElement idsInfoPageHeader1RS4;
	
	@FindBy(css = "html[class=''] body>main>div>#intro>div>article>div>div.header-content>p.u-fs20")
	WebElement idsInfoPageHeader2;

	@FindBy(css = "html[class=''] body>main>div>#intro>div>article>div>div.header-content>p:nth-child(2)")
	WebElement idsInfoPageText1;

	@FindBy(css = "div[class='claim__container row']>p>span")
	WebElement idsInfoPageText1RS4;
	
	@FindBy(css = "html[class=''] body>main>div>#intro>div>article>div>div.flex.flex-middle>a[class='button button--l anchor-link flex-self-left u-mtxxs']")
	WebElement chooseMyOffer;
	
	@FindBy(xpath = "//div[@class='cell-4 page--services__sticky']//a[@data-tag-label='buy_one_room_design_service']")
	WebElement buyRS4;

	public IDSInfoPage verifyIDSInfoPage() {
		UtilHBM.waitExplicitDisplayed(driver, idsInfoPageHeader1RS4);
		Verification.VerifyEquals("Wrong idsInfoPageHeader1!!!", idsInfoPageHeader1RS4.getText(),
				"We decorate for you");
		//Verification.VerifyEquals("Wrong idsInfoPageHeader2!!!", idsInfoPageHeader2.getText(), "We design for you");
		Verification.VerifyEquals("Wrong idsInfoPageText1!!!", idsInfoPageText1RS4.getText(),
				"Running out of ideas or need an expert eye for the decoration of your home project? We can help you to design your room!");
		Verification.displayOfWebElement(buyRS4);
		return this;
	}
}
