package hbm.web.pageobject;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import hbm.planner.utility.UtilHBM;

public class BuyHMSForm {

	WebDriver driver;

	public BuyHMSForm(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "home_measure_request_name")
	WebElement projectName;

	@FindBy(id = "translate_property_typehouse")
	WebElement typeOfHousing1;

	@FindBy(id = "translate_property_typeoffice")
	WebElement typeOfHousing2;

	@FindBy(id = "home_measure_request_address")
	WebElement homeMeasureRequestAddress;

	@FindBy(id = "home_measure_request_firstname")
	WebElement homeMeasureRequestFirstName;

	@FindBy(id = "home_measure_request_lastname")
	WebElement homeMeasureRequestLastName;

	@FindBy(id = "home_measure_request_phone_number")
	WebElement homeMeasureRequestPhoneNumber;

	@FindBy(id = "home_measure_request_comment")
	WebElement homeMeasureRequestComment;

	@FindBy(id = "home_measure_request_area")
	WebElement homeMeasureRequestArea;

	@FindBy(css = "div.u-pbs.u-ptm.u-txtCenter > a[class='button']")
	WebElement homeMeasureRequestInformationNextButton;

	@FindBy(css = "#home_measure_request_area+span")
	WebElement homeMeasureRequestAreaUnit;

	@FindBy(xpath = "//a[@href='/en/home-measurement-service']/following-sibling::a")
	WebElement buyMeasuringService;

	public HMSSelectAppointment buyHMSForm(String hmsInput)  {
		String systemDateAndTime = UtilHBM.getDate(0, "yyyyMMdd");
		UtilHBM.waitExplicitDisplayed(driver, projectName);
		projectName.sendKeys(Keys.CONTROL + "a");
		projectName.sendKeys("Auto" + systemDateAndTime);
		String typeOfHousing = UtilHBM.getProperty("testData", hmsInput + "TypeOfHousing");
		driver.findElement(By.xpath(
				"//div[@class='wrapper form']/div[not(@style ='display: none;')]/div[@class='radio-bloc u-mtm']/ul/li/span[.='"
						+ typeOfHousing + "']/.."))
				.click();
		String area2 = UtilHBM.getProperty("testData", hmsInput + "Area");
		String area = null, measuringUnit = null;
		if (area2.contains(",")) {
			List<String> area1 = Arrays.asList(area2.split(","));
			area = area1.get(0);
			measuringUnit = area1.get(1);
		} else
			UtilHBM.reportKO("Area value or unit not displayed or are incorrect!!!");
		homeMeasureRequestArea.sendKeys(Keys.CONTROL + "a");
		homeMeasureRequestArea.sendKeys(area);
		homeMeasureRequestComment.sendKeys(Keys.CONTROL + "a");
		homeMeasureRequestComment.sendKeys(UtilHBM.getProperty("testData", hmsInput + "Comment"));
		if (homeMeasureRequestAreaUnit.getText().contains(measuringUnit))
			UtilHBM.reportOK("homeMeasureRequestAreaUnit Verified");
		else
			UtilHBM.reportKO("Wrong homeMeasureRequestAreaUnit");
		homeMeasureRequestAddress.sendKeys(Keys.CONTROL + "a");
		homeMeasureRequestAddress.sendKeys(UtilHBM.getProperty("testData", hmsInput + "Address"));
		homeMeasureRequestFirstName.sendKeys(Keys.CONTROL + "a");
		homeMeasureRequestFirstName.sendKeys(UtilHBM.getProperty("testData", hmsInput + "FirstName"));
		homeMeasureRequestLastName.sendKeys(Keys.CONTROL + "a");
		homeMeasureRequestLastName.sendKeys(UtilHBM.getProperty("testData", hmsInput + "LastName"));
		homeMeasureRequestPhoneNumber.sendKeys(Keys.CONTROL + "a");
		homeMeasureRequestPhoneNumber.sendKeys(UtilHBM.getProperty("testData", hmsInput + "Phone"));
		UtilHBM.waitExplicitClickable(driver, homeMeasureRequestInformationNextButton);
		homeMeasureRequestInformationNextButton.click();
		UtilHBM.reportOK("Fill HMS form OK");
		return PageFactory.initElements(driver, HMSSelectAppointment.class);
	}


}
