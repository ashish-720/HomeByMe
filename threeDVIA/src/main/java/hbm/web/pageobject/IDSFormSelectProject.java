package hbm.web.pageobject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class IDSFormSelectProject {
	WebDriver driver;
	public IDSFormSelectProject(WebDriver driver) {
		 this.driver = driver;
	}
	
	@FindBy(xpath ="//div[@class='offer-summary']/p[@class='u-mtn u-mbn u-txtBold'][not(@style = 'display: none;')]/span[1]")
	public WebElement priceofOfferSelected;
	
	@FindBy(css="div.offer-summary>p:nth-child(1)")
	public WebElement offerSelected;
	
	@FindBy(css ="div.module-actions>div>p>a")
	public WebElement nextButton;
	
	@FindBy(xpath ="//div[@class='wrapper']/h2[.='Select your project']")
	public WebElement pageHeader;
	
	@FindBy(css ="#form-details>div>nav>ol>li>p>a[class='router-link-exact-active router-link-active']")
	public WebElement currentBreadcrumb;
	
	@FindBy(id ="select_room_type")
	public WebElement selectRoomType;
	
	@FindBy(css ="#viewer2D>div.wrapper.form.select-room>h2")
	public WebElement selectRoomTitle;
	
	@FindBy(css ="#viewer2D>div.wrapper.form.select-room>p")
	public WebElement selectRoomText;
	
	public IDSFormSelectProject iDSformSelectProject(String idsInput)   {
		String idsProjectName=UtilHBM.getProperty("testData",idsInput+"Project");
		UtilHBM.waitFixTime(2000);
		Verification.VerifyEquals("Wrong Breadcrumb in IDS form", currentBreadcrumb.getText(),"Define your project");
		List<WebElement> projList = driver.findElements(By.xpath("//*[@id='project-list']/div/div/p[normalize-space(.)='"+idsProjectName+"']/../.."));
		UtilHBM.reportInfo("Clicking project \""+projList.get(0).findElement(By.xpath("div/p")).getText()+"\"");
		projList.get(0).click();
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, selectRoomTitle);
		return this;
	}
	
	public IDSFormVerifyDetails iDSFormSelectRoom(String idsInput) {
		Actions actions = new Actions(driver);
		actions.moveToElement(selectRoomTitle, 10, 500);
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, selectRoomTitle);
		String idsOffer = UtilHBM.getProperty("testData", idsInput + "Offer");
		String price = UtilHBM.getProperty("testData", idsInput + "Price");
		UtilHBM.waitExplicitDisplayed(driver, selectRoomType);
		UtilHBM.waitExplicitClickable(driver, selectRoomType);
		UtilHBM.turnOffImplicitWaits(driver);
		Select select1 = new Select(selectRoomType);
		List<WebElement> options = select1.getOptions();
		String temp = null;
		for (WebElement a : options) {
			if (a.getText().contains(UtilHBM.getProperty("testData", idsInput + "SelectedRoom"))) {
				temp = a.getText();
				break;
			}
		}
		UtilHBM.turnOnImplicitWaits(driver);
		UtilHBM.reportInfo("Selecting Room :" + temp);
		select1.selectByVisibleText(temp);
		if (idsOffer.contains("One")) {
			Verification.elementContainsString(offerSelected, "one room to design", "offerSelected");
			for (int i = 0; i < 30 && priceofOfferSelected.getText().equals(""); i++) {
				UtilHBM.waitFixTime(500);
			}
			Verification.elementContainsString(priceofOfferSelected, price, "price of OfferSelected - One room");
		} else if (idsOffer.contains("Multi")) {
			Verification.elementContainsString(offerSelected, "multi rooms to design", "offerSelected");
			for (int i = 0; i < 30 && priceofOfferSelected.getText().equals(""); i++) {
				UtilHBM.waitFixTime(500);
			}
			Verification.elementContainsString(priceofOfferSelected, price, "price of OfferSelected - Multi room");
		}
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.END);
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitDisplayed(driver, nextButton);
		UtilHBM.waitExplicitClickable(driver, nextButton);
		nextButton.click();
		UtilHBM.reportInfo("Next button clicked after selecting project and room");
		return PageFactory.initElements(driver, IDSFormVerifyDetails.class);
	}
}

