package hbm.web.pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class MagazinePage {
	WebDriver driver;

	public MagazinePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "header[class='header ']>div.header__container.row>a.header__logo>svg.icon.icon-logo")
	public WebElement hbmLogo;

	@FindBy(xpath = "//header[@class='resource__header']/div/div/p/span[@class='resource__category label']/a")
	public WebElement magazineCategory;

	@FindBy(xpath = "//header[@class='resource__header']/div/div/h1")
	public WebElement magazinePageHeader;

	@FindBy(xpath = "//header[@class='resource__header']/div/div/picture/img")
	public WebElement magazinePageImg;

	@FindBy(xpath = "//div[@class='resource__sidebar'][@style='opacity: 1;']/p/span/a")
	public WebElement magazineCategoryInSideBar;

	@FindBy(xpath = "//div[@class='resource__sidebar'][@style='opacity: 1;']/p[@class='resource__sidebar__title']")
	public WebElement magazineCardTitleInSideBar;

	@FindBy(xpath = "//div[@class='resource__sidebar'][@style='opacity: 1;']/div[@class='resource__sidebar__socials socials']/a[contains(@href,'https://twitter.com')]")
	public WebElement twitterLink;

	@FindBy(xpath = "//div[@class='resource__sidebar'][@style='opacity: 1;']/div[@class='resource__sidebar__socials socials']/a[contains(@href,'https://www.facebook.com')]")
	public WebElement facebookLink;

	@FindBy(xpath = "//div[@class='resource__sidebar'][@style='opacity: 1;']/div[@class='resource__sidebar__socials socials']/a[contains(@href,'https://www.linkedin.com')]")
	public WebElement linkedinLink;

	@FindBy(xpath = "//div[@class='resource__sidebar'][@style='opacity: 1;']/div[@class='resource__sidebar__socials socials']/a[contains(@href,'https://pinterest.com')]")
	public WebElement pinterestLink;

	@FindBy(xpath = "//div[@class='resource__sidebar'][@style='opacity: 1;']")
	public WebElement sideBar;

	public void verifyMagazinPage(String magazineCardCategory, String magazineCardTitle, String imgSrc) {
		UtilHBM.waitExplicitDisplayed(driver, magazinePageImg);
		Verification.VerifyEquals("Wrong magazineCardCategory", magazineCategory.getText(), magazineCardCategory);
		Verification.VerifyEquals("Wrong magazinePageHeader", magazinePageHeader.getText(), magazineCardTitle);
		String currentImgSrc = magazinePageImg.getAttribute("src");
		String currentSrc1 = currentImgSrc.substring(0, currentImgSrc.lastIndexOf("."));
		if (imgSrc.contains(currentSrc1)) {
			UtilHBM.reportOK("Correct magazinePageImg displyed");
		} else {
			UtilHBM.reportKO("Incorrect magazinePageImg displyed!! Expected ImgSrc : " + imgSrc + ", Available ImgSrc"
					+ currentSrc1);
		}
		magazineCategory.sendKeys(Keys.PAGE_DOWN);
		UtilHBM.waitExplicitDisplayed(driver, sideBar);
		Verification.VerifyEquals("Wrong magazineCategoryInSideBar", magazineCategoryInSideBar.getText(),
				magazineCardCategory);
		Verification.VerifyEquals("Wrong magazineCardTitleInSideBar", magazineCardTitleInSideBar.getText(),
				magazineCardTitle);
		Verification.displayOfWebElement(twitterLink);
		Verification.displayOfWebElement(facebookLink);
		Verification.displayOfWebElement(linkedinLink);
		Verification.displayOfWebElement(pinterestLink);
		driver.navigate().back();
	}

	public LandingPage clickHBMLogo() {
		UtilHBM.waitExplicitClickable(driver, hbmLogo);
		hbmLogo.click();
		return PageFactory.initElements(driver, LandingPage.class);
	}
}
