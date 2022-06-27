package kitchen.bryo.pageObject;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class DeliveryAndInstallationService {
	WebDriver driver;

	public DeliveryAndInstallationService(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//span[@data-i18n='kitchen.index.delivery_service;planner.index.delivery_service']")
	private WebElement deliveryServiceTitle;

	@FindBy(xpath = "//span[@data-ui-selector='delivery-date']")
	private WebElement deliveryDate;

	@FindBy(xpath = "//span[@data-i18n='kitchen.index.installation_service;planner.index.installation_service']")
	private WebElement installationServiceTitle;

	@FindBy(xpath = "//span[@data-ui-selector='installation-date']")
	private WebElement installationDate;

	@FindBy(xpath = "//span[@data-ui-selector='installation-price']")
	private WebElement installationPrice;

	@FindBy(xpath = "//li/span[@aria-controls='project-content-section-services']")
	private WebElement servicesToogle;
	
	public DeliveryAndInstallationService deliveryService() {
//	UtilHBM.waitExplicitDisplayed(driver, exportButton);
		UtilHBM.waitFixTime(1500);
		Verification
				.displayOfWebElement(driver.findElement(By.cssSelector("span[class='icon-action-delivery']>svg>use")));
		Verification.VerifyEquals("Delivery service text not correct", deliveryServiceTitle.getText(),
				"Delivery service");
		String temp[] = deliveryDate.getText().split(":");
		String serviceText = temp[0].trim();
		String serviceDate = temp[1].trim();
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		date = calendar.getTime();
		int workDays = 10;

		if (workDays < 0) {
			for (int i = 0; i > workDays;) {
				calendar.add(Calendar.DAY_OF_MONTH, -1);
				if (calendar.get(Calendar.DAY_OF_WEEK) != 7 && calendar.get(Calendar.DAY_OF_WEEK) != 1)
					i--;
			}
		} else {
			for (int i = 0; i < workDays;) {
				calendar.add(Calendar.DAY_OF_MONTH, 1);
				if (calendar.get(Calendar.DAY_OF_WEEK) != 7 && calendar.get(Calendar.DAY_OF_WEEK) != 1)
					i++;
			}
		}
		date = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(date);
		System.out.println(strDate);
		String systemDateAndTime = formatter.format(date);
		System.out.println("format 1 :" + systemDateAndTime);
		if (serviceText.equalsIgnoreCase("Estimated date")) {
			UtilHBM.reportOK("Estimated delivery text displayed is correct and value is :" + serviceText);
		} else {
			UtilHBM.reportKO("Estimated delivery text not displayed and message is : " + serviceText);
		}
		if (serviceDate.equalsIgnoreCase("Searching for delivery information")) {

		} else if (serviceDate.equalsIgnoreCase("No delivery information available")) {
			UtilHBM.reportMsg("Estimated delivery message displayed and message is : " + serviceDate);
		} else {

			if (systemDateAndTime.equalsIgnoreCase(serviceDate)) {
				UtilHBM.reportOK("Estimated delivery date displayed is correct and value is :" + systemDateAndTime);
			} else {
				UtilHBM.reportKO("Estimated delivery date not displayed and message is : " + serviceDate);
			}
		}
		return this;
	}

	public DeliveryAndInstallationService installationService() {
//		UtilHBM.waitExplicitDisplayed(driver, exportButton);
		UtilHBM.waitFixTime(1500);
		Verification.displayOfWebElement(
				driver.findElement(By.cssSelector("span[class='icon-action-installation']>svg>use")));
		Verification.VerifyEquals("Installation service text not correct", installationServiceTitle.getText(),
				"Installation service");
		String temp[] = installationDate.getText().split(":");
		String serviceText = temp[0].trim();
		String serviceDate = temp[1].trim();
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		date = calendar.getTime();
		int workDays = 15;

		if (workDays < 0) {
			for (int i = 0; i > workDays;) {
				calendar.add(Calendar.DAY_OF_MONTH, -1);
				if (calendar.get(Calendar.DAY_OF_WEEK) != 7 && calendar.get(Calendar.DAY_OF_WEEK) != 1)
					i--;
			}
		} else {
			for (int i = 0; i < workDays;) {
				calendar.add(Calendar.DAY_OF_MONTH, 1);
				if (calendar.get(Calendar.DAY_OF_WEEK) != 7 && calendar.get(Calendar.DAY_OF_WEEK) != 1)
					i++;
			}
		}
		date = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(date);
		System.out.println(strDate);
		String systemDateAndTime = formatter.format(date);
		System.out.println("format 1 :" + systemDateAndTime);
		if (serviceText.equalsIgnoreCase("Estimated date")) {
			UtilHBM.reportOK("Installation service text displayed is correct and value is :" + serviceText);
		} else {
			UtilHBM.reportKO("Installation service text not displayed and message is : " + serviceText);
		}
		if (serviceDate.equalsIgnoreCase("Searching for installation information")) {

		} else if (serviceDate.equalsIgnoreCase("No installation information available")) {
			UtilHBM.reportMsg("Installation service message displayed and message is : " + serviceDate);
		} else {

			if (systemDateAndTime.equalsIgnoreCase(serviceDate)) {
				UtilHBM.reportOK("Installation service date displayed is correct and value is :" + systemDateAndTime);
			} else {
				UtilHBM.reportKO("Installation service date not displayed and message is : " + serviceDate);
			}
		}
		return this;
	}

	public DeliveryAndInstallationService installationPrice() {
		String temp[] = installationPrice.getText().split(":");
		String servicePriceText = temp[0].trim();
		String servicePrice = temp[1].trim().split("\\,")[0].replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "");
		String p=driver.findElement(By.xpath("//span[@class='standard-price ']")).getText().split("\\,")[0].replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "");
		Float discount=((Float.parseFloat(p))/100)*20;
		String installationPrice=String.valueOf(Math.round(discount));
		if (servicePriceText.equalsIgnoreCase("Estimated cost")) {
			UtilHBM.reportOK("Estimated cost text displayed is correct and value is :" + servicePriceText);
		} else {
			UtilHBM.reportKO("Estimated cost text not displayed and message is : " + servicePriceText);
		}
		if (servicePrice.equalsIgnoreCase(installationPrice)) {
			UtilHBM.reportOK("Estimated cost price displayed is correct and value is :" + servicePrice);
		} else {
			UtilHBM.reportKO("Estimated cost price not displayed and message is : " + servicePrice);
		}
		return this;
	}
	public DeliveryAndInstallationService toggleServices() {
		UtilHBM.waitExplicitClickable(driver, servicesToogle);
		Actions actions=new Actions(driver);
		actions.moveToElement(servicesToogle).build().perform();
		servicesToogle.click();
		UtilHBM.waitFixTime(1000);
				Verification.displayOfWebElement(driver.findElement(By.xpath(
				"//li/span[@aria-controls='project-content-section-services'][@aria-expanded='false']")));
		actions.moveToElement(servicesToogle).click().build().perform();
		UtilHBM.waitFixTime(1000);
		Verification.displayOfWebElement(driver.findElement(By.xpath(
				"//li/span[@aria-controls='project-content-section-services'][@aria-expanded='true']")));
		return this;
		
	}
}
