package kitchen.threeDCloudByMe.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class Stats {
	WebDriver driver;

	public Stats(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "date_filter_startDate")
	WebElement startDate;

	@FindBy(id = "date_filter_endDate")
	WebElement endDate;

	@FindBy(xpath = "//div[@id='table_users_paginate'][not(@style = 'display: none;')]/span[@id='table_users_next']")
	List<WebElement> nextButton;

	@FindBy(xpath = "//*[@id='table_users']/tbody/tr/td[5]")
	List<WebElement> userEmailId;

	@FindBy(css = "a>label[class='tabs-item-label']")
	WebElement pageHeader1;

	@FindBy(css = "a[id='export-csv']>span")
	WebElement button1;

	@FindBy(css = "div>div[class='col-xs-2 bold u-mtm']")
	WebElement label1;

	@FindBy(css = "label[for='date_filter_startDate']")
	WebElement label2;

	@FindBy(css = "label[for='date_filter_endDate']")
	WebElement label3;

	@FindBy(css = "th[aria-label*='Username']")
	WebElement colomnHeader1;

	@FindBy(css = "th[aria-label*='First']")
	WebElement colomnHeader2;

	@FindBy(css = "th[aria-label*='Last']")
	WebElement colomnHeader3;

	@FindBy(css = "th[aria-label*='Email']")
	WebElement colomnHeader4;

	@FindBy(css = "th[aria-label*='Country']")
	WebElement colomnHeader5;

	@FindBy(css = "th[aria-label*='Creation']")
	WebElement colomnHeader6;

	@FindBy(css = "span.paginate_of")
	WebElement noOfPAgesAvailable;

	@FindBy(css = "#date_filter_startDate")
	WebElement minDate;

	@FindBy(css = "#date_filter_endDate")
	WebElement maxDate;

	public Stats userAvailability(SignUpData signUpData, String expectedUserAvailability) {
		pageVerification();
		minDate.sendKeys(UtilHBM.getDate(0, "MM/dd/yyyy") + Keys.ENTER);
		maxDate.sendKeys(UtilHBM.getDate(0, "MM/dd/yyyy") + Keys.TAB);
		int noOfPages = 0;
		if (!noOfPAgesAvailable.getText().equals(""))
			noOfPages = Integer.parseInt(noOfPAgesAvailable.getText().split(" ")[1].trim());
		else
			noOfPages = 2;
		String emailID = signUpData.getEmailId();
		int temp = 0;
		UtilHBM.waitFixTime(2000);
		for (int i = 1; i < noOfPages; i++) {
			UtilHBM.turnOffImplicitWaits(driver);
			List<WebElement> userFound = driver.findElements(
					By.xpath("//*[@id='table_users']/tbody/tr/td[5][contains(text(),'" + emailID + "')]/.."));
			UtilHBM.turnOnImplicitWaits(driver);
			if (userFound.isEmpty()) {
				if (!nextButton.isEmpty()) {
					nextButton.get(0).click();
					continue;
				}
			} else {
				if(expectedUserAvailability.equalsIgnoreCase("NO")) {
					UtilHBM.reportKO("Data sharing not stopped!!User "+emailID+" Found!!! Expected User Availability is "+expectedUserAvailability);
					Assert.fail();
					temp = 1;
					break;
				}
				UtilHBM.reportOK("User "+emailID+" Found!!! Expected User Availability is "+expectedUserAvailability);
				WebElement username = userFound.get(0).findElement(By.xpath("td[2]"));
				WebElement userEmail = userFound.get(0).findElement(By.xpath("td[5]"));
				WebElement country = userFound.get(0).findElement(By.xpath("td[6]"));
				WebElement creationDate = userFound.get(0).findElement(By.xpath("td[7]"));
				Verification.elementContainsString(username, signUpData.getEmailId().split("@")[0], "UserName");
				Verification.VerifyEquals("Wrong Email ID!!", userEmail.getText(), emailID);
				Verification.VerifyEquals("Wrong Country!!", country.getText(), "India");
				Verification.elementContainsString(creationDate, UtilHBM.getDate(0, "yyyy-MM-dd"), "Creation Date");
				temp = 1;
				break;
			}
		}
		if (temp == 0) {
			if(expectedUserAvailability.equalsIgnoreCase("YES")) {
				UtilHBM.reportKO("User not found!!!Expected User Availability is "+expectedUserAvailability);
				Assert.fail();
			}
			else {
				UtilHBM.reportOK("User not found!!!Data sharing Stopped!!Expected User Availability is "+expectedUserAvailability);
			}
				
		}
		return PageFactory.initElements(driver,Stats.class);
	}
	
	Stats pageVerification() {
		Verification.VerifyEquals("Page header not displayed", pageHeader1.getText(), "Stats");
		Verification.VerifyEquals("Button text not displayed", button1.getText(), "EXPORT CSV");
		Verification.VerifyEquals("Filters Label not displayed", label1.getText(), "Filters :");
		Verification.VerifyEquals("Creation min date Label not displayed", label2.getText(), "Creation min date");
		Verification.VerifyEquals("Creation max date Label not displayed", label3.getText(), "Creation max date");
		Verification.VerifyEquals("Username header not displayed", colomnHeader1.getText(), "Username");
		Verification.VerifyEquals("First name header not displayed", colomnHeader2.getText(), "First name");
		Verification.VerifyEquals("Last name header not displayed", colomnHeader3.getText(), "Last name");
		Verification.VerifyEquals("Country header not displayed", colomnHeader5.getText(), "Country");
		Verification.VerifyEquals("Creation date header not displayed", colomnHeader6.getText(), "Creation date");
		return PageFactory.initElements(driver,Stats.class);
	}
}
