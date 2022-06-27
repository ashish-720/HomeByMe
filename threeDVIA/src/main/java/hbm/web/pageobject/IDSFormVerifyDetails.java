package hbm.web.pageobject;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;


public class IDSFormVerifyDetails {
	WebDriver driver;
	public IDSFormVerifyDetails(WebDriver driver) {
		 this.driver = driver;
	}
	
	@FindBy(css="div.wrapper.resume > div.u-txtCenter.u-mbl > p.u-mbn")
	public WebElement offerSelected;

	@FindBy(xpath ="//div[@class='wrapper resume']/div[2]/p[2]/span")
	public WebElement priceofOfferSelected;
	
	@FindBy(xpath ="//div[@class='wrapper resume']/h2[normalize-space(text())='Request summary']")
	public WebElement pageHeader;
	
	@FindBy(css ="#form-details>div>nav>ol>li>p>a[class='router-link-exact-active router-link-active']")
	public WebElement currentBreadcrumb;
	
	@FindBy(css ="div.wrapper.resume>div>a")
	public WebElement purchaseButton;
	
	@FindBy(css ="div.wrapper.resume>div>form>button")
	public WebElement sendRequest;
	
	@FindBy(xpath ="//div[@class='wrapper resume']/p/a/i")
	public WebElement editMyRequest;
	
	@FindBy(xpath ="//div[@class='label']/span[.='Room name']/../following-sibling::div/span")
	public WebElement roomName;
	
	@FindBy(xpath ="//div[@class='label']/span[.='Offer']/../following-sibling::div/span")
	public WebElement offer;
	
	@FindBy(xpath ="//div[@class='label']/span[.='Type of room']/../following-sibling::div/span")
	public WebElement typeOfRoom;
	
	@FindBy(xpath ="//div[@class='label']/span[.='Reason for redesign']/../following-sibling::div/span")
	public WebElement reasonForRedesign;
	
	@FindBy(xpath ="//div[@class='label']/span[.='Family status']/../following-sibling::div/span")
	public WebElement familyStatus;
	
	@FindBy(xpath ="//div[@class='label']/span[.='Your selected project']/../following-sibling::div/figure/img")
	public WebElement selectedProjectPreview;
	
	@FindBy(xpath ="//div[@class='label']/span[.='Favorite style']/../following-sibling::div/figure/figcaption")
	public WebElement favoriteStyleName;
	
	@FindBy(xpath ="//div[@class='label']/span[.='Favorite style']/../following-sibling::div/figure/picture/img")
	public WebElement favoriteStyleImg;
	
	@FindBy(xpath ="//div[@class='label']/span[.='Your selected project']/../following-sibling::div/figure/figcaption")
	public WebElement selectedProjectName;
	
	@FindBy(xpath ="//section[@class='resume-picture']/div[@class='item']//div[@class='label']/span[.='Photos of your room']/../following-sibling::div/figure/img")
	List<WebElement> photoPreviewList;
	
	@FindBy(xpath ="//section[@class='resume-picture']/div[@class='item']//div[@class='label']/span[.='Inspirational images']/../following-sibling::div/figure/img")
	List<WebElement> inspirationalImages;
	
	@FindBy(xpath ="//section[@class='resume-colors']/div[@class='item']//div[@class='label']/span[.='Favorite color(s)']/../following-sibling::div/ul/li")
	List<WebElement> likedColors;
	
	@FindBy(xpath ="//div[@class='label']/span[.='Specific request']/../following-sibling::div/p")
	public WebElement specificRequest;
	
	public IDSFormVerifyDetails iDSFormEditDetails(String idsInput) {
		UtilHBM.waitExplicitDisplayed(driver, pageHeader);
		new Actions(driver).moveToElement(currentBreadcrumb).build().perform();
		Verification.VerifyEquals("Wrong PageHeader in IDS form", pageHeader.getText(), "Request summary");
		Verification.VerifyEquals("Wrong Breadcrumb in IDS form", currentBreadcrumb.getText(), "Confirm");
		clickEditMyRequest().clearFormDetails().iDSFillForm(idsInput);
		return PageFactory.initElements(driver, IDSFormVerifyDetails.class);
	}
	
	public IDSFormDetails clickEditMyRequest() {
		UtilHBM.waitExplicitDisplayed(driver, editMyRequest);
		UtilHBM.waitExplicitClickable(driver, editMyRequest);
		editMyRequest.click();
		return PageFactory.initElements(driver, IDSFormDetails.class);
	}
	
	public IDSFormVerifyDetails iDSFormVerifyDetails(String idsInput)   {
		String idsOffer = UtilHBM.getProperty("testData", idsInput + "Offer");
		UtilHBM.waitExplicitDisplayed(driver, selectedProjectPreview);
		Verification.displayOfWebElement(selectedProjectPreview);
		Verification.VerifyEquals("Incorrect projectName", selectedProjectName.getText(),UtilHBM.getProperty("testData", idsInput + "Project"));
		Verification.VerifyEquals("Incorrect roomName", roomName.getText(),UtilHBM.getProperty("testData", idsInput + "SelectedRoom"));

		if (idsOffer.contains("One")) {
			Verification.elementContainsString(offer, "One room design", "Offer");
			Verification.VerifyEquals("Incorrect typeOfRoom", typeOfRoom.getText(),UtilHBM.getProperty("testData", idsInput + "TypeofRoom"));
		} else if (idsOffer.contains("Multi")) {
			Verification.elementContainsString(offer, "Multi-purpose room decoration", "Offer");
			String roomsToSelect = UtilHBM.getProperty("testData", idsInput + "TypeofRoom");
			if (roomsToSelect.contains(",")) {
				List<String> rooms1 = Arrays.asList(roomsToSelect.split(","));
				Verification.elementContainsString(typeOfRoom, rooms1.get(0), rooms1.get(0));
				Verification.elementContainsString(typeOfRoom, rooms1.get(1), rooms1.get(1));
				Verification.elementContainsString(typeOfRoom, rooms1.get(2), rooms1.get(2));
			} else
				UtilHBM.reportKO("Multiple rooms not found!!!");
		} else
			UtilHBM.reportKO("Invalid offer");

		Verification.VerifyEquals("Incorrect reasonForRedesign", reasonForRedesign.getText(),UtilHBM.getProperty("testData", idsInput + "Reason"));
		Verification.VerifyEquals("Incorrect familyStatus", familyStatus.getText(),UtilHBM.getProperty("testData", idsInput + "Users"));
		int i = 0;
		String roomImages = UtilHBM.getProperty("testData", idsInput + "CurrentRoomImages");
		String[] roomImages1 = roomImages.split(",");
		int noOfRoomImages = roomImages1.length;
		for (WebElement a : photoPreviewList) {
			UtilHBM.waitExplicitDisplayed(driver, a);
			if (a.getAttribute("src").contains(".png") || a.getAttribute("src").contains(".jpg"))
				i++;
			else
				UtilHBM.reportKO("Photo of room not displayed");
		}
		if (i == noOfRoomImages)
			UtilHBM.reportOK("Photo preview Image List verified");
		else
			UtilHBM.reportKO("Photo preview List not displayed or contains only " + i + " images");
		Verification.VerifyEquals("Incorrect favoriteStyleName", favoriteStyleName.getText(),UtilHBM.getProperty("testData", idsInput + "Style"));
		Verification.displayOfWebElement(favoriteStyleImg);
		int i1 = 0;
		String inspirationalImages1 = UtilHBM.getProperty("testData", idsInput + "InspirationalImages");
		String[] inspirationalImages2 = inspirationalImages1.split(",");
		int noOfInspirationalImages = inspirationalImages2.length;
		for (WebElement a : inspirationalImages) {
			UtilHBM.waitExplicitDisplayed(driver, a);
			if (a.getAttribute("src").contains(".png") || a.getAttribute("src").contains(".jpg"))
				i1++;
			else
				UtilHBM.reportKO("Photo of room not displayed");
		}
		if (i1 == noOfInspirationalImages)
			UtilHBM.reportOK("Photo preview Image List verified");
		else
			UtilHBM.reportKO("Photo preview List not displayed or contains only " + i + " images");

		String[] colours = UtilHBM.getProperty("testData", idsInput + "Colours").split(",");
		if (likedColors.isEmpty())
			UtilHBM.reportKO("Liked colors not displayed");
		else if (likedColors.size() == colours.length) {
			for (WebElement a : likedColors)
				Verification.displayOfWebElement(a);
		} else
			UtilHBM.reportKO("Additional colors displayed in Liked colors");

		Verification.VerifyEquals("Incorrect Specific request", specificRequest.getText(),
				UtilHBM.getProperty("testData", idsInput + "Request"));
		if (idsOffer.contains("One")) {
			Verification.elementContainsString(offerSelected, "one room to design", "offerSelected");
			for (int j = 0; j < 30 && priceofOfferSelected.getText().equals(""); j++) {
				UtilHBM.waitFixTime(500);
			}
			Verification.elementContainsString(priceofOfferSelected,
					UtilHBM.getProperty("testData", idsInput + "Price"), "price of OfferSelected - One room");
		} else if (idsOffer.contains("Multi")) {
			Verification.elementContainsString(offerSelected, "multi rooms to design", "offerSelected");
			for (int j = 0; j < 30 && priceofOfferSelected.getText().equals(""); j++) {
				UtilHBM.waitFixTime(500);
			}
			Verification.elementContainsString(priceofOfferSelected,
					UtilHBM.getProperty("testData", idsInput + "Price"), "price of OfferSelected - Multi room");
		}
		return this;
	}
	
	public Payment iDSPurchaseRequest() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_UP);
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, purchaseButton);
		UtilHBM.waitExplicitClickable(driver, purchaseButton);
		UtilHBM.reportInfo("Clicking \"" + purchaseButton.getText() + "\" Button");
		purchaseButton.click();
		return PageFactory.initElements(driver, Payment.class);
	}
}
