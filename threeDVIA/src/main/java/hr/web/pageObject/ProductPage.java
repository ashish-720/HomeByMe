package hr.web.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import hbm.planner.utility.Verification;

public class ProductPage {

	
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//div/ul[@class='list']/li[@class='item swiper-slide-visible swiper-slide-active']/img")
	private WebElement image1;
	
	@FindBy(xpath = "//div/ul[@class='list']/li[@class='item swiper-slide-visible swiper-slide-next swiper-slide-thumb-active']/img")
	private WebElement image2;
	
	@FindBy(xpath = "//div/ul[@class='list']/li[@class='item swiper-slide-visible']/img")
	private WebElement image3;
	
	@FindBy(xpath = "//div/ul[@class='list']/li[@class='item tag-3d swiper-slide-visible']/img")
	private WebElement image4;
	
	@FindBy(xpath = "//div[@class='header']/ul/li[@aria-controls='product-buying']/span")
	private WebElement buyingOurFurniture;
	
	@FindBy(xpath = "//div[@class='header']/ul/li[@aria-controls='product-details']/span")
	private WebElement productDetails;
	
	@FindBy(xpath = "//div/div[@class='text']/h2/span")
	private WebElement doltSofaText;
	

	public void verifyroductionPage() {

		Verification.displayOfWebElement(image1);
		Verification.displayOfWebElement(image2);
		Verification.displayOfWebElement(image3);
		Verification.displayOfWebElement(image4);
		Verification.displayOfWebElement(doltSofaText);
//		Verification.VerifyEquals(errorMsg, actualText, expectedText);
//		Verification.displayNAttributeCheckOfElementExcludeLineBreak(element, elementName, attribute, attributeValue);
		}
}