package hbm.web.pageobject;

import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class FloorPlanConversion {
	WebDriver driver;
	
	public FloorPlanConversion(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css = "#intro>.wrapper>.table>.cell.u-txtCenter>h1")
	WebElement floorplanConversionHeader1;
	
	@FindBy(css = "#intro>.wrapper>.table>.cell.u-txtCenter>p")
	WebElement floorplanConversionHeader2;
	
	@FindBy(css = "div.confirm-box>div>button.button")
	WebElement deleteFloorPlanYes;
	
	@FindBy(css = "a[title='Delete']")
	WebElement deleteFloorPlan;
	
	@CacheLookup
	@FindBy(css = "#uploadifive-upload-plan>input[type=\"file\"]:nth-child(2)")
	WebElement uploadFloorPlan;

	@FindBy(id = "upload_plan_name")
	WebElement uploadPlanName;
	
	@FindBy(id = "upload_plan_estimatedSurface")
	WebElement uploadPlanArea;
	
	@FindBy(css = "button.button")
	WebElement nextButton;
	
	@FindBy(id = "upload_plan_estimatedSurfaceUnit")
	WebElement selectMeasuringUnit;
	
	@FindBy(css = "div.form-item-field>textarea[id='upload_plan_comment']")
	WebElement uploadFPComments;
	
	@FindBy(css = "div.uploadedPlan>img")
	WebElement confirmFPImage;
	
	@FindBy(css ="div.form-item.form-item--inline>strong")
	WebElement confirmFPName;
	
	@FindBy(css = "div.resume-text-area>p")
	WebElement confirmFPArea;

	@FindBy(css ="div.resume-text-comment.u-mbs.viewmore")
	WebElement confirmFPComment;
	
	@FindBy(css ="div.form-item.form-item--inline>a")
	WebElement editYourInformation;
	
	public UploadedFloorplanDetails uploadFloorPlan(String fpInput)   {
		String floorplan = UtilHBM.getProperty("testData", fpInput + "Floorplan");
		uploadFloorPlan.sendKeys(new File(Setting.imgPath + floorplan).getAbsolutePath());
		UtilHBM.waitFixTime(2000);
		String uploadFPName = "Auto_" + UtilHBM.getDate(0, "yyyyMMdd");
		String area = UtilHBM.getProperty("testData", fpInput + "Area");
		String area2 = null, measuringUnit = null;
		if (area.contains(",")) {
			List<String> area1 = Arrays.asList(area.split(","));
			area2 = area1.get(0);
			measuringUnit = area1.get(1);
		} else {
			UtilHBM.reportKO("Area value or unit not displayed or are incorrect!!!");
		}
		String uploadArea = area2 + " " + measuringUnit;
		uploadPlanName.sendKeys(uploadFPName);
		uploadPlanArea.sendKeys(area2);
		Select select = new Select(selectMeasuringUnit);
		if (select.getFirstSelectedOption().getText().equals(measuringUnit)) {
			UtilHBM.reportOK("Correct Measuring unit is available");
		} else {
			UtilHBM.reportOK("Incorrect Measuring unit is available");
		}
		select.selectByVisibleText(measuringUnit);
		uploadFPComments.sendKeys(uploadFPName);
		clickNextButton().verifyUploadFloorPlan(uploadFPName, uploadArea);
		return PageFactory.initElements(driver,UploadedFloorplanDetails.class);
	}
	
	public UploadedFloorplanDetails clickNextButton() {
		UtilHBM.waitExplicitClickable(driver, nextButton);
		nextButton.click();
		return PageFactory.initElements(driver,UploadedFloorplanDetails.class);
	}

	public FloorPlanConversion clearfields() {
		UtilHBM.waitExplicitClickable(driver, deleteFloorPlan);
		deleteFloorPlan.click();
		UtilHBM.waitExplicitDisplayed(driver, deleteFloorPlanYes);
		deleteFloorPlanYes.click();
		uploadPlanName.clear();
		uploadPlanArea.clear();
		uploadFPComments.clear();
		return this;
	}
	
}