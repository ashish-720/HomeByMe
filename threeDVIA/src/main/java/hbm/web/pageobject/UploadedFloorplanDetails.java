package hbm.web.pageobject;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;


public class UploadedFloorplanDetails {
	WebDriver driver;
	
	public UploadedFloorplanDetails(WebDriver driver) {
		this.driver = driver;
	}
	
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
	
	@FindBy(css = "div.grid-4-4.u-txtCenter.u-mtl.cta > div > a")
	WebElement purchaseButton;
	
	
	public UploadedFloorplanDetails verifyUploadFloorPlan(String uploadFPName,String uploadArea)   {
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "div.uploadedPlan>img"));
		if (confirmFPImage.getAttribute("src").contains(".png") 
			|| confirmFPImage.getAttribute("src").contains(".jpg")
			|| confirmFPImage.getAttribute("src").contains(".pdf")  ) {
			UtilHBM.reportOK("FloorPlanImage added Properly");}
		else {
			UtilHBM.reportKO("FloorPlanImage not added Properly");
		}
		Verification.VerifyEquals("UPloaded FP Project Name is not correct", confirmFPName.getText(), uploadFPName);
		Verification.VerifyEquals("Uploaded Area is not correct", confirmFPArea.getText(), uploadArea);
		Verification.VerifyEquals("Uploaded FP Project Comment is not correct", confirmFPComment.getText(),
				uploadFPName);
		return this;
	}
	
	public Payment editFPInformation(String fpInput)   {
		clickEditYourInformation().clearfields().uploadFloorPlan(fpInput).clickPurchase();
		UtilHBM.reportOK("FloorPlan Uploaded Successfully");
		return PageFactory.initElements(driver, Payment.class);	
	}
	
	public Payment clickPurchase() {
		UtilHBM.waitExplicitDisplayed(driver, purchaseButton);
		UtilHBM.waitExplicitClickable(driver, purchaseButton);
		purchaseButton.click();
		return PageFactory.initElements(driver, Payment.class);	
	}
	
	public FloorPlanConversion clickEditYourInformation() {
		UtilHBM.waitExplicitClickable(driver, editYourInformation);
		editYourInformation.click();
		return PageFactory.initElements(driver, FloorPlanConversion.class);	
	}
	
	
}
