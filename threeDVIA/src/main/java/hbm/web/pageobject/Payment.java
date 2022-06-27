package hbm.web.pageobject;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class Payment {
	
	WebDriver driver;
	
	public Payment(WebDriver driver) {
		this.driver=driver;
	}
	
	@CacheLookup
	@FindBy(css = "div.well > h3")
	WebElement thankYou;
	
	
	@FindBy(id = "card-number")
	WebElement cardNumber;
	
	@FindBy(id = "card-expire-month")
	WebElement cardExpiryM;
	
	@FindBy(id = "card-expire-year")
	WebElement cardExpiryY;
	
	@FindBy(id = "card-security")
	WebElement cardSecurity;
	
	@FindBy(css = "div.modal-footer > button")
	WebElement purchase;
	
	@FindBy(css ="div.pay-button-wrapper.pay-button-full-width>button")
	WebElement purchaseNew;
	
	@FindBy(css ="div#pin-modal>fieldset>div>div>button")
	WebElement continueButton;
	
	@FindBy(css ="td.description-cell>div>strong.product-title.ng-isolate-scope>span.ng-binding")
	WebElement paymentTitle;
	
	@FindBy(xpath ="//html/body[@class='loaded']//div[@id='panel-payment']/div/div[@class='well total-well']/div//div/span[2]")
	List<WebElement> expectedTotalPrice;

	@FindBy(xpath = "//span[.='Credit / Debit Card']")
	WebElement paymentOption;
	
	@FindBy(xpath ="//body[@class='loaded']//div[@class='price-row ng-scope']/div[@class='ng-scope']/div[@class='price-item ng-scope']/select")
	WebElement noOfPacketsSelect;
	
	@FindBy(xpath ="//div[@class='price-row ng-scope']/div[@class='ng-scope']/div[@class='price-item ng-scope']/select/parent::div")
	WebElement noOfPacketsDiv;
	
	@FindBy(css = ".input-checkbox.checkbox>label>span>span")
	WebElement termsOfServiceCheckbox;
	
	@FindBy(xpath="//html/body[@class='loaded']//*[@class='table no-padding no-margin ng-scope ng-isolate-scope']/tbody/tr/td[3]/div//div[1]/strong")
	List<WebElement> finalPrice;
	
	@FindBy(css="body>div>div>div>div>div>div>a>.logo-retina.ng-scope")
	private WebElement hbmLogo;
	
	@FindBy(css="#contact-first-name")
	private WebElement firstName;
	
	@FindBy(css="#contact-last-name")
	private WebElement lastName;
	
	@FindBy (id="contact-company")
	private WebElement company;
	
	@FindBy(css="#contact-email")
	private WebElement email;
	
	@FindBy(css="#contact-addressline1")
	private WebElement addressLine1;
	
	@FindBy(css="#contact-city")
	private WebElement city;
	
	@FindBy(css="#contact-phone")
	private WebElement phone;
	
	@FindBy(css="#contact-region")
	private WebElement state;
	
	@FindBy(css="#contact-postal")
	private WebElement postalCode;
	
	@FindBy(css=".container.flex.flex-center.flex-middle.u-txtCenter>div>img[src*='https://d31ax5swi3lxrl.cloudfront.net/dist/images/logotype']+p>svg>circle")
	private WebElement loadingCircle;
	
	@FindBy(css="div#fscCanvas>img[style$='display: none;']")
	private List<WebElement> loadingCircleNotDisplayed;
	
	@FindBy(css="div#fscCanvas>iframe[id='fsc-popup-frame']")
	private WebElement iFrame;
	
	@FindBy(css="div#pin-modal>div>div>div>div>div>div.checkout-text.ng-binding.ng-scope")
	private WebElement fastspringCheckoutText;
	
	@FindBy(css="div#pin-modal>fieldset>div>div>div[ng-if='orderReference']>code")
	private WebElement invoiceReference;
	
	public void makePayment(String noOfPackets, String orderKey, String orderDataInput, String firstPaymentYesOrNo) {
		String handle = driver.getWindowHandle();
		if (!(orderDataInput.equalsIgnoreCase("LaCarte1")) && !(orderDataInput.equalsIgnoreCase("LaCarte2"))) {
			for (String handle1 : driver.getWindowHandles()) {
				if (!handle1.equalsIgnoreCase(handle)) {
					driver.switchTo().window(handle1);
				}
			}
		}
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, expectedTotalPrice.get(0));
		UtilHBM.waitExplicitDisplayed(driver, finalPrice.get(0));
		UtilHBM.waitExplicitClickable(driver, finalPrice.get(0));
		String expectedPrice = null;
//		 if (paymentTitle.getText().contains("room design")
//		 || paymentTitle.getText().contains("Floor plan conversion")
//		 || paymentTitle.getText().contains("Home Measurement Service")) {
		expectedPrice = UtilHBM.getProperty("testData", orderDataInput + "Price");
//		 } else {
//		 double expectedPrice1 = Double.parseDouble(OurOffers.getPrice());
//		 expectedPrice = String.valueOf(expectedPrice1 - ((expectedPrice1) * 0.1));
//		 expectedPrice = expectedPrice.substring(0, expectedPrice.indexOf(".") + 3);
//		 }
		Verification.VerifyEquals("Final Price is Incorrect", finalPrice.get(0).getText().substring(3), expectedPrice);

		if (paymentTitle.getText().contains("Home Measurement Service")
				|| paymentTitle.getText().contains("Floor plan conversion")
				|| paymentTitle.getText().contains("room design")) {
		} else {
			selectNoOfPackets(noOfPackets);
//			UtilHBM.waitFixTime(2000);
			int temp = 5;
			for (int i = 0; i < temp; i++) {
				UtilHBM.turnOffImplicitWaits(driver);
				boolean isFinalPriceDisplayed = !finalPrice.isEmpty();
				boolean isTotalPriceDisplayed = !expectedTotalPrice.isEmpty();
				UtilHBM.turnOnImplicitWaits(driver);
				if (isFinalPriceDisplayed && isTotalPriceDisplayed) {
					break;
				} else {
					UtilHBM.waitFixTime(1000);
					UtilHBM.reportInfo(
							"Waiting for price to displayed for " + i + " seconds after selecting noOfPackets");
					continue;
				}
			}
			String finalPrice2 = null;
			String expectedTotalPrice2 = null;
			if (finalPrice.get(0).getText().contains("€")) {
				finalPrice2 = finalPrice.get(0).getText().substring(3);
				expectedTotalPrice2 = expectedTotalPrice.get(0).getText().substring(3);
			} else if (finalPrice.get(0).getText().contains("$")) {
				finalPrice2 = finalPrice.get(0).getText().substring(3);
				expectedTotalPrice2 = expectedTotalPrice.get(0).getText().substring(3);
			}
			if (orderDataInput.equalsIgnoreCase("LaCarte1")) {
				double finalPrice1 = Double.parseDouble(finalPrice2) * Double.parseDouble(noOfPackets);
				Verification.VerifyEquals("Incorrect final price  on change of quantity required",
						String.valueOf(finalPrice1), expectedTotalPrice2);
			}
		}
//		termsOfServiceCheckbox.click();
		paymentOption.click();
		paymentForm(firstPaymentYesOrNo);
		UtilHBM.waitExplicitDisplayed(driver, thankYou);
		Verification.VerifyEquals("Order not successful", thankYou.getText(), "Thank you for your order!");
		String data = driver.findElement(By.cssSelector("div[ng-if='order.reference']")).getText();
		data = data.substring(data.lastIndexOf(" ") + 1);
		UtilHBM.reportInfo("Invoice Reference :" + data);

		if (!orderKey.equals("")) {
			UtilHBM.setProperty("testData", orderKey, data);
		}
		UtilHBM.reportOK("Payment Successful");
		if (orderDataInput.equalsIgnoreCase("LaCarte1")) {
			WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
			newTab.get("https://preprod-home.by.me/en/");
			String handle1 = driver.getWindowHandle();
			driver.switchTo().window(handle);
			driver.close();
			driver.switchTo().window(handle1);
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_UP);
		} else if (orderDataInput.equalsIgnoreCase("LaCarte2")) {
			driver.close();
		} else {
			driver.close();
			driver.switchTo().window(handle);
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_UP);
		}
		UtilHBM.waitFixTime(500);
	}
	
	public UserHomePage makePaymentNew(String noOfPackets, String orderKey, String orderDataInput, String firstPaymentYesOrNo) {
		UtilHBM.waitFixTime(1000);
		for (int i = 0; i < 10; i++) {
			UtilHBM.turnOffImplicitWaits(driver);
			boolean isLoaderDisappeared = !loadingCircleNotDisplayed.isEmpty();
			UtilHBM.turnOnImplicitWaits(driver);
			if (isLoaderDisappeared) {
				break;
			} else {
				UtilHBM.waitFixTime(1000);
			}
		}
		UtilHBM.waitExplicitDisplayed(driver, iFrame);
		driver.switchTo().frame(iFrame);
		UtilHBM.waitExplicitDisplayed(driver, fastspringCheckoutText);
		paymentFormNew();
		UtilHBM.waitExplicitDisplayed(driver, invoiceReference);
		if (!orderKey.equals("")) {
			UtilHBM.setProperty("testData", orderKey, invoiceReference.getText());
		}
		UtilHBM.waitExplicitDisplayed(driver, continueButton);
		UtilHBM.waitExplicitDisplayed(driver, continueButton);
		continueButton.click();
		driver.switchTo().parentFrame();
		return PageFactory.initElements(driver, UserHomePage.class); 
	}
	
	public Payment selectNoOfPackets(String noOfPackets) {
		if (!noOfPackets.equals("0")) {
			UtilHBM.waitExplicitDisplayed(driver, noOfPacketsSelect);
//		noOfPacketsDiv.click();
			Select select = new Select(noOfPacketsSelect);
			select.selectByVisibleText(noOfPackets);
		}
		return PageFactory.initElements(driver, Payment.class);
	}

//	public void makePaymentBuyExhausted(String noOfPackets, String orderDataInput, String firstPaymentYesOrNo){		
//		String handle=driver.getWindowHandle();
//		for(String handle1:driver.getWindowHandles()) {
//			if(!handle1.equalsIgnoreCase(handle)) {
//				driver.switchTo().window(handle1);					
//			}			
//		}	
//		UtilHBM.waitExplicitDisplayed(driver, loadingCircle);
//		UtilHBM.waitExplicitDisplayed(driver, finalPrice);
//		UtilHBM.waitExplicitClickable(driver, finalPrice);
//		String expectedPrice = UtilHBM.getProperty("testData", orderDataInput + "Price");
//		Verification.VerifyEquals("Final Price is Incorrect", finalPrice.getText().substring(1), expectedPrice);
//		noOfPacketsDiv.click();
//		Select select=new Select(noOfPacketsSelect);
//		select.selectByVisibleText(noOfPackets);
//		UtilHBM.waitFixTime(1000);
//		double finalPrice1 = Double.parseDouble(finalPrice.getText().substring(1))*Double.parseDouble(noOfPackets);		
//		Verification.VerifyEquals("final price Incorrect on change of quantity required", String.valueOf(finalPrice1),expectedTotalPrice.getText().substring(1));
//		termsOfServiceCheckbox.click();
//		paymentOption.click();
//		paymentForm(firstPaymentYesOrNo);		
//		Verification.VerifyEquals("Order not successful", thankYou.getText(), "Thank you for your order!");
//		String data = driver.findElement(By.cssSelector("div[ng-if='order.reference']")).getText();
//		data=data.substring(data.lastIndexOf(" ")+1);
//		UtilHBM.reportInfo("Invoice Reference :"+data);	
//		UtilHBM.reportOK("Payment Successful");
//		driver.close();    
//		driver.switchTo().window(handle);
//	}
	
	public void verifyPaymentPage(){		
		UtilHBM.waitExplicitDisplayed(driver, paymentTitle);
		if(paymentOption.isDisplayed()&& hbmLogo.isDisplayed() 
//				&& termsOfServiceCheckbox.isDisplayed() 
				&& finalPrice.get(0).isDisplayed()){
			UtilHBM.reportOK("FastString page verified");
		}else{
			UtilHBM.reportKO("FastSpring Page verification KO");
		}		
	}	
	
	private void paymentForm(String firstPaymentYesOrNo) {
		if (firstPaymentYesOrNo.equalsIgnoreCase("Yes")) {
			Properties properties = new Properties();
			try {
				properties.load(SignUpData.class.getResourceAsStream("/signupdata.properties"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			firstName.clear();
			firstName.click();
			firstName.sendKeys("FirstName");
			lastName.clear();
			lastName.click();
			lastName.sendKeys("LastName");
			company.clear();
			company.click();
			company.sendKeys("3DS");
			email.clear();
			email.click();
			email.sendKeys(properties.getProperty("emailId"));
			phone.clear();
			phone.click();
			phone.sendKeys("1234567890");
			cardNumber.clear();
			cardNumber.click();
			cardNumber.sendKeys("4242424242424242");
			cardExpiryM.clear();
			cardExpiryM.click();
			cardExpiryM.sendKeys("12");
			cardExpiryY.clear();
			cardExpiryY.click();
			cardExpiryY.sendKeys("23");
			cardSecurity.clear();
			cardSecurity.click();
			cardSecurity.sendKeys("*8mjz");
		} else {
			Properties properties = new Properties();
			try {
				properties.load(SignUpData.class.getResourceAsStream("/signupdata.properties"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cardNumber.clear();
			cardNumber.click();
			cardNumber.sendKeys("4242424242424242");
			cardExpiryM.clear();
			cardExpiryM.click();
			cardExpiryM.sendKeys("12");
			cardExpiryY.clear();
			cardExpiryY.click();
			cardExpiryY.sendKeys("23");
			cardSecurity.clear();
			cardSecurity.click();
			cardSecurity.sendKeys("*8mjz");
			addressLine1.clear();
			addressLine1.click();
			addressLine1.sendKeys("AddressLine1");
			city.clear();
			city.click();
			city.sendKeys("city");
			state.clear();
			state.click();
			state.sendKeys("State");
			postalCode.clear();
			postalCode.click();
			postalCode.sendKeys("000000");
			purchase.click();
		}
	}
	
	private void paymentFormNew(){
		Properties properties = new Properties();
		try {
			properties.load(SignUpData.class.getResourceAsStream("/signupdata.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
//		UtilHBM.waitExplicitDisplayed(driver, firstName);
//		firstName.clear();
//		firstName.click();
//		firstName.sendKeys("FirstName");			
//		lastName.clear();
//		lastName.click();
//		lastName.sendKeys("LastName");			
//		company.clear();
//		company.click();
//		company.sendKeys("3DS");			
//		email.clear();
//		email.click();
//		email.sendKeys(properties.getProperty("emailId"));
//		phone.clear();
//		phone.click();
//		phone.sendKeys("1234567890");
		cardNumber.clear();
		cardNumber.click();
		cardNumber.sendKeys("4242424242424242");
		cardExpiryM.clear();
		cardExpiryM.click();
		cardExpiryM.sendKeys("12");		
		cardExpiryY.clear();
		cardExpiryY.click();
		cardExpiryY.sendKeys("23");		
		cardSecurity.clear();
		cardSecurity.click();
		cardSecurity.sendKeys("*8mjz");	
		addressLine1.clear();
		addressLine1.click();
		addressLine1.sendKeys("AddressLine1");		
		city.clear();
		city.click();
		city.sendKeys("city");		
		state.clear();
		state.click();
		state.sendKeys("State");		
		postalCode.clear();
		postalCode.click();
		postalCode.sendKeys("000000");		
		purchaseNew.click();
	}
	
}