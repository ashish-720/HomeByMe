package hbm.web.pageobject;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class HMSVerifyDetails {

	WebDriver driver;

	public HMSVerifyDetails(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//*[@id='home-measure']/article/section/div/div[not(@style ='display: none;')]/a")
	WebElement editMyRequest;

	@FindBy(xpath = "//*[@id='home-measure']/article/section/div/div[not(@style ='display: none;')]/div[2]/a")
	WebElement purchase;

	@FindBy(xpath = "//section[@class='resume-home-measure']/div/div/span[.='Appointment']/../following-sibling::div/span")
	WebElement appointment;

	@FindBy(xpath = "//section[@class='resume-home-measure']/div/div/span[.='Project name']/../following-sibling::div/span")
	WebElement projectName;

	@FindBy(xpath = "//section[@class='resume-home-measure']/div/div/span[.='First name']/../following-sibling::div/span")
	WebElement firstName;

	@FindBy(xpath = "//section[@class='resume-home-measure']/div/div/span[.='Lastname']/../following-sibling::div/span")
	WebElement lastName;

	@FindBy(xpath = "//section[@class='resume-home-measure']/div/div/span[.='Phone number']/../following-sibling::div/span")
	WebElement phone;

	@FindBy(xpath = "//section[@class='resume-home-measure']/div/div/span[.='Type of housing']/../following-sibling::div/span")
	WebElement typeOfHousing;

	@FindBy(xpath = "//section[@class='resume-home-measure']/div/div/span[.='Address']/../following-sibling::div/span")
	WebElement address;

	@FindBy(xpath = "//section[@class='resume-home-measure']/div/div/span[.='Area']/../following-sibling::div")
	WebElement area;

	@FindBy(xpath = "//section[@class='resume-home-measure']/div/div/span[.='Further details']/../following-sibling::div/span")
	WebElement furtherDetails;

	@FindBy(css = "div.flex.flex-row>span:nth-child(2)")
	WebElement price;

	public HMSVerifyDetails hmsEditMyRequest(String hmsInput)   {
		UtilHBM.waitExplicitClickable(driver, editMyRequest);
		editMyRequest.click();
		BuyHMSForm buyHMSForm = PageFactory.initElements(driver, BuyHMSForm.class);
		buyHMSForm.buyHMSForm(hmsInput);
		HMSSelectAppointment buyHMSSelectAppointment = PageFactory.initElements(driver, HMSSelectAppointment.class);
		buyHMSSelectAppointment.hmsEditAppointment(hmsInput, 2);
		return PageFactory.initElements(driver, HMSVerifyDetails.class);
	}

	public HMSVerifyDetails hmsVerifyDetails(String hmsInput) {
		String area2 = UtilHBM.getProperty("testData", hmsInput + "Area");
		String area5 = null;
		String projectName1 = "Auto" + UtilHBM.getDate(0, "yyyyMMdd");
		String firstName1 = UtilHBM.getProperty("testData", hmsInput + "FirstName");
		String lastName1 = UtilHBM.getProperty("testData", hmsInput + "LastName");
		String phone1 = UtilHBM.getProperty("testData", hmsInput + "Phone");
		String typeOfHousing1 = UtilHBM.getProperty("testData", hmsInput + "TypeOfHousing");
		String address1 = UtilHBM.getProperty("testData", hmsInput + "Address");
		String comment1 = UtilHBM.getProperty("testData", hmsInput + "Comment");
		String appointment1 = UtilHBM.getProperty("testData", hmsInput + "Appointment");
		if (area2.contains(",")) {
			List<String> area1 = Arrays.asList(area2.split(","));
			area5 = area1.get(0) + " " + area1.get(1);
		} else
			UtilHBM.reportKO("Area value or unit not displayed or are incorrect!!!");

		UtilHBM.waitExplicitDisplayed(driver, appointment);
		Verification.elementContainsString(appointment, UtilHBM.getProperty("testData", hmsInput + "Appointment"),
				"appointment");
		Verification.VerifyEquals("Incorrect Project Name", appointment1, appointment.getText());
		Verification.VerifyEquals("Incorrect Project Name", projectName.getText(), projectName1);
		Verification.VerifyEquals("IncorrectfirstName", firstName.getText(), firstName1);
		Verification.VerifyEquals("Incorrect lastName", lastName.getText(), lastName1);
		Verification.VerifyEquals("Incorrect phone", phone.getText(), phone1);
		Verification.VerifyEquals("Incorrect typeOfHousing", typeOfHousing.getText(), typeOfHousing1);
		Verification.VerifyEquals("Incorrect address", address.getText(), address1);
		Verification.VerifyEquals("Incorrect area", area.getText(), area5);
		Verification.VerifyEquals("Incorrect furtherDetails", furtherDetails.getText(), comment1);
		Verification.elementContainsString(price, UtilHBM.getProperty("testData", hmsInput + "Price"), "Price");
		return PageFactory.initElements(driver, HMSVerifyDetails.class);
	}

	public Payment hmsPurchase() {
		UtilHBM.waitExplicitClickable(driver, purchase);
		purchase.click();
		return PageFactory.initElements(driver, Payment.class);
	}
}
