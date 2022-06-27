package hbm.web.pageobject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;

public class HMSSelectAppointment {

	WebDriver driver;

	public HMSSelectAppointment(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//*[@id='home-measure']/article/section/div/div[not(@style ='display: none;')]/div[@class='datepicker']/div/a")
	List<WebElement> viewMoreAvailableHours;

	@FindBy(xpath = "//*[@id='home-measure']/article/section/div/div[not(@style ='display: none;')]/div[2]/a[@class='button']")
	WebElement nextButton;

	@FindBy(xpath = "//*[@id='home-measure']/article/section/div/div[not(@style ='display: none;')]/div[@class='datepicker']/div[1]/div/ul[@class='picker']/li/p/..")
	List<WebElement> appointmentList;

	@FindBy(xpath = "//div[not(@style ='display: none;')]/h2")
	WebElement scheduleAppointment;
	
	@FindBy(xpath = "//*[@id='home-measure']/article/section/div/div[not(@style ='display: none;')]//li[@class='is-active list-reset time u-mbxs']/p")
	WebElement selectedAppointmentTime;

	public HMSVerifyDetails hmsSelectAppointment(String hmsInput) {
		UtilHBM.waitExplicitDisplayed(driver, scheduleAppointment);
		viewMoreAvailableHours();
		for (WebElement a : appointmentList)
			UtilHBM.waitExplicitClickable(driver, a);
		String time = appointmentList.get(1).findElement(By.tagName("p")).getText();
		UtilHBM.setProperty("testData", hmsInput + "Appointment", time);
		appointmentList.get(1).click();
		setAppointmentTime(hmsInput);
		hmsClickNext();
		return PageFactory.initElements(driver, HMSVerifyDetails.class);
	}

	public BuyHMSForm hmsEditAppointment(String hmsInput, int i)   {
		UtilHBM.waitExplicitDisplayed(driver, scheduleAppointment);
		viewMoreAvailableHours();
		for (WebElement a : appointmentList) {
			UtilHBM.waitExplicitClickable(driver, a);
		}
		UtilHBM.setProperty("testData", hmsInput + "Appointment",appointmentList.get(i + 1).findElement(By.tagName("p")).getText());
		appointmentList.get(i + 1).click();
		setAppointmentTime(hmsInput);
		hmsClickNext();
		return PageFactory.initElements(driver, BuyHMSForm.class);
	}

	public HMSSelectAppointment viewMoreAvailableHours() {
		if (!viewMoreAvailableHours.isEmpty())
			viewMoreAvailableHours.get(0).click();
		return this;
	}

	public HMSVerifyDetails hmsClickNext() {
		UtilHBM.waitFixTime(2000);
		nextButton.click();
		return PageFactory.initElements(driver, HMSVerifyDetails.class);
	}
	
	public HMSSelectAppointment setAppointmentTime(String hmsInput) {
		UtilHBM.turnOffImplicitWaits(driver);
		List<WebElement> days = driver.findElements(By.xpath("//*[@id='home-measure']/article/section/div/div[not(@style ='display: none;')]/div[1]/div[1]/div[@class='flex-column w-100']"));
		int i = 1,temp=0;
		for (WebElement a : days) {
			List<WebElement> selectedAppointment = a.findElements(By.className("is-active"));
			if (!selectedAppointment.isEmpty()) {
				temp=1;
				break;
			}
			i++;
		}
		if(temp==0) {
			UtilHBM.reportKO("No appointment selected initially!!!");
		}
		String date = driver.findElement(By.xpath("//*[@id='home-measure']/article/section/div/div[not(@style ='display: none;')]/div[1]/ul/li[" + i + "]/p")).getText().trim();
		UtilHBM.setProperty("testData", hmsInput + "Appointment", date + " " + selectedAppointmentTime.getText().trim());
		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}
}
