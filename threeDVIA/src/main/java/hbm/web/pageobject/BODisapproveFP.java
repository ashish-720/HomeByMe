package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class BODisapproveFP {
	WebDriver driver;

	public BODisapproveFP(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "table.table>tbody>tr>td>div.row.centered.floor-plan-action>a.btn.btn-danger")
	WebElement needMoreInfoButtonFP;

	@FindBy(css = "ul.sidebar-menu>li.treeview.active>ul>li>a[href$='/design-coaching/pending_info/list']")
	WebElement pendingInfoIDS;

	@FindBy(css = "ul.sidebar-menu>li.treeview.active>ul>li>a[href$='/design-coaching/rejected/list']")
	WebElement rejectedIDS;

	@FindBy(id = "form_reason")
	WebElement idsReason;

	@FindBy(id = "s2id_form_reason")
	WebElement idsReasonSelect;

	@FindBy(id = "form_comment")
	WebElement idsComment;

	@FindBy(css = "table.table>tbody>tr>td>div.row.centered.floor-plan-action>a.btn.btn-info")
	WebElement needMoreInfoButtonIDS;

	@FindBy(css = "table.table>tbody>tr>td>div.row.centered.floor-plan-action>a.btn.btn-danger")
	WebElement rejectIDSButton;

	@FindBy(xpath = "//tr/th[.='Reason']/following-sibling::td")
	WebElement reasonVeri;

	@FindBy(xpath = "//div[@class='container-fluid']/table/tbody/tr/th[.='Comment']/following-sibling::td")
	WebElement rejectCommentVeri;

	@FindBy(id = "form_comment")
	WebElement rejectComment;

	@FindBy(css = "select#form_reason")
	WebElement rejectReasonDD;

	@FindBy(css = "ul.select2-results>li:nth-child(2)>div")
	WebElement rejectReasonDDOption;

	@FindBy(css = "ul.select2-results>li:nth-child(7)>div")
	WebElement needMoreInfoReasonIDS;

	@FindBy(css = "a.btn.btn-danger")
	WebElement cancelRejectOrder;

	@FindBy(css = "button.btn.btn-success")
	WebElement rejectOrderButton;

	@FindBy(css = "span.label.label-danger")
	WebElement rejectedProjectStatus;

	@FindBy(css = "span.label.label-primary")
	WebElement pendingInfoProjectStatus;
	
	@FindBy(css = "span.label.label-danger")
	WebElement rejectedIDSStatus;

	@FindBy(css = "div.box-header>h4")
	WebElement confirmTextH4;

	@FindBy(css = "div.col-lg-12>p:nth-child(1)")
	WebElement confirmTextDescription1;

	@FindBy(css = "div.col-lg-12>p:nth-child(2)")
	WebElement confirmTextDescription2;

	@FindBy(xpath = "//div[@id='sonata-ba-field-container-form_reason']/following-sibling::p")
	WebElement reasonText;

	@FindBy(xpath = "//div[@id='sonata-ba-field-container-form_comment']/following-sibling::p")
	WebElement commentText;

	public BODisapproveFP rejectFloorplanRequest() {
		Select select = new Select(rejectReasonDD);
		select.selectByVisibleText("The plan is composed of several floors");
		rejectOrderButton.click();
		Verification.VerifyEquals("FP Project Request Rejection failed", rejectedProjectStatus.getText(), "REJECTED");
		Verification.VerifyEquals("Reject Reason doesn't match", reasonVeri.getText(),
				"The plan is composed of several floors");
		Verification.VerifyEquals("Reject Comment doesn't match", rejectCommentVeri.getText(),
				"Reject Comment available here!!!");
		return PageFactory.initElements(driver, BODisapproveFP.class);
	}

	public BODisapproveFP needMoreFPInformation() {
		needMoreInfoButtonFP.click();

		if (confirmTextH4.getText().contains("Confirm your validation of order")) {
			UtilHBM.reportOK("confirmTextH4 displayed");
		} else {
			UtilHBM.reportKO("confirmTextH4 not displayed");
		}
		Verification.verifyText(confirmTextDescription1,
				"This order will be listed as «Pending information» and an email asking for additional information will be sent to the final user.",
				"confirmTextDescription1");
		Verification.VerifyEquals("confirmTextDescription2 doesn't match", confirmTextDescription2.getText(),
				"In order to confirm this action, please select the reason of your rejection.");
		Verification.VerifyEquals("Reason Text doesn't match", reasonText.getText(),
				"This is the reason that will be transmitted to the final user.");
		Verification.VerifyEquals("Reason Text doesn't match", commentText.getText(),
				"This section is for internal use only. Its content will not will be transmitted to the final user.");
		Select select = new Select(rejectReasonDD);
		select.selectByVisibleText("Your floor plan has several floors");
		rejectComment.sendKeys("Reject Comment available here!!!");
		Verification.displayOfWebElement(cancelRejectOrder);
		rejectOrderButton.click();
		Verification.VerifyEquals("FP Project Send More Information Request failed", pendingInfoProjectStatus.getText(),
				"PENDING INFO");
		Verification.VerifyEquals("Reject Reason doesn't match", reasonVeri.getText(),
				"Your floor plan has several floors");
		Verification.VerifyEquals("Reject Comment doesn't match", rejectCommentVeri.getText(),
				"Reject Comment available here!!!");

		return PageFactory.initElements(driver, BODisapproveFP.class);
	}

	public void idsNeedMoreInfo(String idsInput, String orderKey) {
		UtilHBM.waitExplicitClickable(driver, needMoreInfoButtonIDS);
		needMoreInfoButtonIDS.click();
		UtilHBM.waitExplicitClickable(driver, confirmTextH4);
		if (confirmTextH4.getText().contains("Confirm your validation of order")) {
			UtilHBM.reportOK("confirmTextH4 displayed");
		} else {
			UtilHBM.reportKO("confirmTextH4 not displayed");
		}
		Verification.verifyText(confirmTextDescription1,
				"This order will be listed as «Pending information» and an email asking for additional information will be sent to the final user.",
				"confirmTextDescription1");
		Verification.VerifyEquals("confirmTextDescription2 doesn't match", confirmTextDescription2.getText(),
				"In order to confirm this action, please select the reason of your rejection.");
		Verification.VerifyEquals("Reason Text doesn't match", reasonText.getText(),
				"This is the reason that will be transmitted to the final user.");
		Verification.VerifyEquals("Reason Text doesn't match", commentText.getText(),
				"This section is for internal use only. Its content will not will be transmitted to the final user.");
		Select select = new Select(rejectReasonDD);
		select.selectByVisibleText("The images provided do not match with the selected room.");
		rejectComment.sendKeys("Reject Comment available here!!!");
		Verification.displayOfWebElement(cancelRejectOrder);
		rejectOrderButton.click();

		pendingInfoIDS.click();
		BONewFP newFloorplanRequest = PageFactory.initElements(driver, BONewFP.class);
		newFloorplanRequest.searchAndOpenIDS(idsInput, orderKey);

		Verification.VerifyEquals("IDS Send More Information Request failed", pendingInfoProjectStatus.getText(),
				"PENDING INFO");
		Verification.VerifyEquals("Reject Reason doesn't match", reasonVeri.getText(),
				"The images provided do not match with the selected room.");
		Verification.VerifyEquals("Reject Comment doesn't match", rejectCommentVeri.getText(),
				"Reject Comment available here!!!");

	}

	public void idsReject(String idsInput, String orderKey) {
		UtilHBM.waitExplicitClickable(driver, rejectIDSButton);
		rejectIDSButton.click();
		UtilHBM.waitExplicitClickable(driver, confirmTextH4);
		if (confirmTextH4.getText().contains("Reject")) {
			UtilHBM.reportOK("confirmTextH4 displayed");
		} else {
			UtilHBM.reportKO("confirmTextH4 not displayed");
		}
		Select select = new Select(rejectReasonDD);
		select.selectByVisibleText("The images provided do not match with the selected room.");
		rejectComment.sendKeys("Reject Comment available here!!!");
		Verification.displayOfWebElement(cancelRejectOrder);
		UtilHBM.waitExplicitClickable(driver, rejectOrderButton);
		rejectOrderButton.click();
		rejectedIDS.click();
		BONewFP newFloorplanRequest = PageFactory.initElements(driver, BONewFP.class);
		newFloorplanRequest.searchAndOpenIDS(idsInput, orderKey);
		Verification.VerifyEquals("IDS reject request failed", rejectedIDSStatus.getText(),
				"REJECTED");
		Verification.VerifyEquals("Reject Reason doesn't match", reasonVeri.getText(),
				"The images provided do not match with the selected room.");
		Verification.VerifyEquals("Reject Comment doesn't match", rejectCommentVeri.getText(),
				"Reject Comment available here!!!");
	}

}
