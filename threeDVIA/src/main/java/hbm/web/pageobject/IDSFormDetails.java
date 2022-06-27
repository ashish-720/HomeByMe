package hbm.web.pageobject;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class IDSFormDetails {
	WebDriver driver;
	public IDSFormDetails(WebDriver driver) {
		 this.driver = driver;
	}
	
	@FindBy(css = "html[class=''] #intro>.wrapper>.table>.cell.u-txtCenter>h1")
	WebElement idsHeader1;
	
	@FindBy(css = "#intro>.wrapper>.table>.cell.u-txtCenter>p")
	WebElement idsHeader2;
	
	@FindBy(css = "div.content-details.favorite-colors>div>ul>li.is-active")
	List<WebElement> selectedcolors;
	
	@FindBy(xpath = "//div[@class='content-details upload-inspiration']/div/div[@class='upload-preview']/img")
	List<WebElement> uploadedInspirationalImages;
	
	@FindBy(xpath = "//div[@class='content-details upload']/div/div[@class='upload-preview']/img")
	List<WebElement> uploadedImages;

	@FindBy(xpath ="//div[@class='offer-summary']/p[@class='u-mtn u-mbn u-txtBold'][not(@style = 'display: none;')]/span[1]")
	public WebElement priceofOfferSelected;
	
	@FindBy(css="div.offer-summary>p:nth-child(1)")
	public WebElement offerSelected;
	
	@FindBy(xpath ="//div[@class='wrapper']/h2[.='Tell us more about your project']")
	public WebElement pageHeader;
	
	@FindBy(css ="#form-details>div>nav>ol>li>p>a[class='router-link-exact-active router-link-active']")
	public WebElement currentBreadcrumb;
	
	@FindBy(css ="div.content-details.upload>div>div.upload-preview")
	List<WebElement> uploadedImgMandatory;

	@FindBy(css ="div.content-details.upload-inspiration>div>div.upload-preview")
	List<WebElement> uploadedImgInspirational;
	
	@FindBy(css ="div.wrapper.resume>div>form>button")
	public WebElement sendRequest;
	
	@FindBy(css ="div.wrapper>div.content-details.room>ul>li")
	List<WebElement> roomType;
	
	@FindBy(css ="div.wrapper>div.content-details.room>ul>li.is-active")
	List<WebElement> roomTypeSelected;
	
	@FindBy(css ="div.wrapper>div.content-details.with>ul.flex>li[class='with-item icon-content']")
	List<WebElement> roomUsers;
	
	@FindBy(css ="ul[class='form-radios']>li>label")
	List<WebElement> roomChangeReason;
	
	@FindBy(css ="div.content-details.upload>div>div.upload-button>input#upload-room-image")
	public WebElement uploadImgMandatory;
	
	@FindBy(css ="div.content-details.upload-inspiration>div>div.upload-button>input")
	public WebElement uploadImgInspirational;
	
	@FindBy(css ="div.styles-item>figure")
	List<WebElement> favoriteStyle;
	
	@FindBy(css ="div.is-active.styles-item>figcaption")
	public WebElement selectedFavoriteStyle;
	
	@FindBy(css ="div.content-details.favorite-colors>div>ul>li")
	List<WebElement> favoriteColors;
	
	@FindBy(css ="div.content-details.request>textarea")
	public WebElement specificRequests;
	
	@FindBy(css ="div.module-actions>div>p>a")
	public WebElement nextButton;
	
	@FindBy(css ="div.wrapper>article>div>a")
	public WebElement selectDifferentProjectOrRoom;
	
	@FindBy(css ="#form-details>section>div.wrapper>h3:nth-child(17)")
	public WebElement favoriteColorText;
	
	public IDSFormVerifyDetails iDSFillForm(String idsInput)    {
		UtilHBM.waitExplicitClickable(driver, roomType.get(0));
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		String roomsToSelect = UtilHBM.getProperty("testData", idsInput + "TypeofRoom");
		String reason = UtilHBM.getProperty("testData", idsInput + "Reason");
		String users = UtilHBM.getProperty("testData", idsInput + "Users");
		String roomImages = UtilHBM.getProperty("testData", idsInput + "CurrentRoomImages");
		String[] roomImages1 = roomImages.split(",");
		String inspirationalImages = UtilHBM.getProperty("testData", idsInput + "InspirationalImages");
		String[] inspirationalImages1 = inspirationalImages.split(",");
		String colours = UtilHBM.getProperty("testData", idsInput + "Colours");
		String idsOffer = UtilHBM.getProperty("testData", idsInput + "Offer");
		String request=UtilHBM.getProperty("testData", idsInput + "Request");
		String style=UtilHBM.getProperty("testData", idsInput + "Style");
		String price=UtilHBM.getProperty("testData", idsInput + "Price");
		WebElement users1=driver.findElement(By.xpath("//div[@class='wrapper']/div/ul/li/span[contains(text(),'" + users + "')]/.."));
		WebElement reason1=driver.findElement(By.xpath("//ul[@class='form-radios']/li/label[contains(text(),'" + reason + "')]/.."));
		WebElement favoriteStyle = driver.findElement(By.xpath("//div[@class='styles-item']/figcaption[contains(text(),'"+ style + "')]/preceding-sibling::figure"));
		
		if (!roomsToSelect.contains(",")) {
			driver.findElement(By.xpath("//div[@class='wrapper']/div/ul/li/span[contains(text(),'" + roomsToSelect + "')]/..")).click();
		} else if (roomsToSelect.contains(",")) {
			List<String> rooms1 = Arrays.asList(roomsToSelect.split(","));
			if (rooms1.size() <= 3) {
				for (String a : rooms1) {
					driver.findElement(By.xpath("//div[@class='wrapper']/div/ul/li/span[contains(text(),'" + a + "')]/..")).click();
				}
			} else
				UtilHBM.reportKO("More than 3 room entered in input");
		}
		for (WebElement a : roomTypeSelected) {
			if (roomsToSelect.contains(a.getText()))
				UtilHBM.reportOK(a.getText() + " option selected");
			else
				UtilHBM.reportKO(a.getText() + " option not selected. Rooms to select were :" + roomsToSelect);
		}
		reason1.click();
		String selectedID = driver.findElement(By.xpath("//ul[@class='form-radios']/li[1]/label/preceding-sibling::input")).getAttribute("value1");
		Verification.VerifyEquals("Incorrect reason selected",driver.findElement(By.xpath("//*[@id='" + selectedID + "']/following-sibling::label")).getText(),reason);
		users1.click();
		Verification.VerifyEquals("Wrong user selected",driver.findElement(By.cssSelector("div.wrapper>div.content-details.with>ul>li.is-active")).getText(),users);
		for (String a : roomImages1) {
			uploadImgMandatory.clear();
			uploadImgMandatory.sendKeys(new File(Setting.imgPath + a).getAbsolutePath());
			UtilHBM.waitFixTime(1000);
			
		}
		if (roomImages1.length == uploadedImages.size()) {
			UtilHBM.reportOK("All images uploaded");
		} else {
			UtilHBM.reportKO("Image Upload error!!! Expected image count: " + roomImages1.length
					+ " , Uploaded image count: " + uploadedImages.size());
		}
		UtilHBM.waitExplicitClickable(driver, favoriteStyle);
		favoriteStyle.click();
		UtilHBM.waitExplicitDisplayed(driver, selectedFavoriteStyle);
		Verification.VerifyEquals("Wrong style selected", selectedFavoriteStyle.getText(),style);		
		for (String a : inspirationalImages1) {			
			uploadImgInspirational.clear();
			uploadImgInspirational.sendKeys(new File(Setting.imgPath + a).getAbsolutePath());	
			UtilHBM.waitFixTime(1000);
		}
		if (inspirationalImages1.length == uploadedInspirationalImages.size()) {
			UtilHBM.reportOK("ALL inspirational images uploaded");
		} else {
			UtilHBM.reportKO("Inspirational Image Upload error!!! Expected image count: " + inspirationalImages1.length
					+ " , Uploaded image count: " + uploadedInspirationalImages.size());
		}
		new Actions(driver).moveToElement(specificRequests).build().perform();
		List<String> colours1 = Arrays.asList(colours.split(","));
		UtilHBM.waitExplicitClickable(driver,
				driver.findElement(By.xpath("//li[contains(@class, '" + colours.split(",")[0] + "')]")));
		for (String a : colours1) {
			driver.findElement(By.xpath("//li[contains(@class, '" + a + "')]")).click();
		}
		if (selectedcolors.isEmpty())
			UtilHBM.reportKO("No colors selected");
		else {
			for (WebElement a : selectedcolors) {
				if (colours.contains(a.getAttribute("class").split(" ")[2])) {
					UtilHBM.reportOK(a.getAttribute("class").split(" ")[2] + " colour selected.");
				} else {
					UtilHBM.reportKO(a.getAttribute("class").split(" ")[2] + " colour not selected.");
				}
			}
		}
		specificRequests.sendKeys(Keys.CONTROL + "a");
		specificRequests.sendKeys(request);
		if (idsOffer.contains("One")) {
			Verification.elementContainsString(offerSelected, "one room to design", "offerSelected");
			for (int i = 0; i < 30 && priceofOfferSelected.getText().equals(""); i++) {
				UtilHBM.waitFixTime(500);
			}
			Verification.elementContainsString(priceofOfferSelected,price, "price of OfferSelected - One room");
		} else if (idsOffer.contains("Multi")) {
			Verification.elementContainsString(offerSelected, "multi rooms to design", "offerSelected");
			for (int i = 0; i < 30 && priceofOfferSelected.getText().equals(""); i++) {
				UtilHBM.waitFixTime(500);
			}
			Verification.elementContainsString(priceofOfferSelected,price, "price of OfferSelected - Multi room");
		}
		clickNextButton().iDSformSelectProject(idsInput).iDSFormSelectRoom(idsInput).iDSFormVerifyDetails(idsInput);
		return PageFactory.initElements(driver, IDSFormVerifyDetails.class);
	}
	
	public IDSFormSelectProject clickNextButton() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.END);
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitDisplayed(driver, nextButton);
		UtilHBM.waitExplicitClickable(driver, nextButton);
		nextButton.click();
		UtilHBM.reportOK("Next button clicked after filling form");
		return PageFactory.initElements(driver, IDSFormSelectProject.class);
	}
	

	public IDSFormDetails clearFormDetails() {
		UtilHBM.waitExplicitDisplayed(driver, pageHeader);
		Verification.VerifyEquals("Wrong Breadcrumb in IDS form", currentBreadcrumb.getText(),"Tell us about your project");
		UtilHBM.turnOffImplicitWaits(driver);
		if (roomTypeSelected.isEmpty())
			UtilHBM.reportKO("No Room type selected initially");
		else {
			int i=0;
			while (!roomTypeSelected.isEmpty() && i < 20) {
				UtilHBM.reportInfo("Clicking "+roomTypeSelected.get(0).getText() + " option to deselect");
				roomTypeSelected.get(0).click();
				UtilHBM.waitFixTime(200);
				i++;
			}
			if (roomTypeSelected.isEmpty()) {
				UtilHBM.reportOK("All rooms deselected.No of iterations taken : "+i);
			} else {
				for (WebElement a : roomTypeSelected) {
					UtilHBM.reportKO(a.getText() + "option not deselected");
				}
			}
		}
		if (uploadedImages.isEmpty()) {
			UtilHBM.reportKO("Uploaded images not displayed");
		} else {
			new Actions(driver).moveToElement(uploadedImages.get(0)).build().perform();
			while (!uploadedImages.isEmpty()) {
				new Actions(driver).moveToElement(uploadedImages.get(0).findElement(By.xpath("parent::div"))).build().perform();
				WebElement deleteUploadedImage = driver.findElement(By.xpath("//div[@class='content-details upload']/div/div[@class='upload-preview'][1]/div/div/a"));
				UtilHBM.waitExplicitDisplayed(driver, deleteUploadedImage);
				deleteUploadedImage.click();
			}
		}
		if (uploadedInspirationalImages.isEmpty()) {
			UtilHBM.reportKO("Uploaded images not displayed");
		} else {
			new Actions(driver).moveToElement(uploadedInspirationalImages.get(0).findElement(By.xpath("parent::div"))).build().perform();
			while (!uploadedInspirationalImages.isEmpty()) {
				new Actions(driver).moveToElement(uploadedInspirationalImages.get(0)).build().perform();
				WebElement deleteUploadedInspirational = driver.findElement(By.xpath("//div[@class='content-details upload-inspiration']/div/div[@class='upload-preview'][1]/div/div/a"));
				UtilHBM.waitExplicitDisplayed(driver, deleteUploadedInspirational);
				deleteUploadedInspirational.click();
			}
		}
		if (selectedcolors.isEmpty()) {
			UtilHBM.reportKO("No colors selected initially");
		}else {
			for (WebElement a : selectedcolors) {
				a.click();
			}
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}
	
}


