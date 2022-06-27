package kitchen.bryo.pageObject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TemplatesInformationWindow {
	WebDriver driver;

	public TemplatesInformationWindow(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = ".canvas-tools-info-window>.info-title")
	private WebElement solutionInfoTitle;

	@FindBy(css = "p[class='price']>span[data-ui='total-price-container']")
	private WebElement solutionPrice;

	@FindBy(xpath =  "//button[@data-ui-action='priceInfo']")
	private WebElement priceInfoIcon;

	@FindBy(css = "button[data-more='Show more']")
	private List<WebElement> showMore;

	@FindBy(css = "button[data-less='Show less']")
	private List<WebElement> showLess;

	@FindBy(id = "more-content")
	private WebElement moreContent;

	@FindBy(css = "div>div>.canvas-tools-zoom")
	private WebElement canvasTools;

	@FindBy(css = "div>div>.canvas-tools-options>.bt-icon")
	private WebElement toolsOption;

	@FindBy(xpath =  "//div/div/div[@class='mod-overlay-container mod-open']")
	private WebElement viewMode;

	@FindBy(id = "project-title")
	private WebElement projectTitle;

	public TemplatesInformationWindow verifyPickALayoutStep() {
//		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "#canvas-wrap-1:not([class*='loading'])"));
		Verification.displayOfWebElement(canvasTools);
		Verification.displayOfWebElement(toolsOption);
//		toolsOption.click();
		new Actions(driver).moveToElement(toolsOption).click().build().perform();
		UtilHBM.waitExplicitDisplayed(driver, viewMode);
		Verification.displayOfWebElement(solutionInfoTitle);
		UtilHBM.waitExplicitDisplayed(driver, solutionPrice);
		Verification.displayOfWebElement(solutionPrice);

		if (showMore.size() == 0)
			UtilHBM.reportKO("Show more link not available");
		else if (showMore.get(0).isDisplayed()) {
			UtilHBM.reportOK("Show more link available");
			UtilHBM.waitExplicitClickable(driver, showMore.get(0));
			new Actions(driver).moveToElement(showMore.get(0)).click().build().perform();
			UtilHBM.waitExplicitDisplayed(driver, moreContent);

			UtilHBM.reportOK("More Content: " + moreContent.getText());
			moreContent.getAttribute("aria-hidden");
			if (showLess.get(0).isDisplayed()) {
				UtilHBM.reportOK("Show less link available");
				showLess.get(0).click();
			}

		}
		return PageFactory.initElements(driver, TemplatesInformationWindow.class);
	}

	public PickALayout verifyTemplatesPrice(String price,String pricePerMonth) {
		UtilHBM.waitExplicitDisplayed(driver, priceInfoIcon);
		UtilHBM.waitExplicitClickable(driver, priceInfoIcon);
//		new Actions(driver).moveToElement(priceInfoIcon.get(0)).click().perform();
		priceInfoIcon.click();
		Price p = PageFactory.initElements(driver, Price.class);
		p.priceInfo(price, pricePerMonth, "48 months");
		return PageFactory.initElements(driver, PickALayout.class);
	}

}
