package hbm.web.pageobject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class BOInProgress {
	WebDriver driver;
	
	public BOInProgress(WebDriver driver) {
		this.driver = driver;
	}
	

	
	@FindBy(css="ul.sidebar-menu>li.treeview.active>ul>li>a[href$='/floor-plan/in_progress/list']")
	WebElement findInProgressFP;
	
	@FindBy(css="table.table.table-bordered.table-striped.sonata-ba-list>tbody>tr:nth-child(1)>td:nth-child(1)>a")
	WebElement firstFPlListElement;
	
	@FindBy(xpath="//div[@class='navbar-header']/span[@class='navbar-brand']")
	WebElement checkRefernce;
	
	@FindBy(xpath="//ul[@class='nav nav-tabs']/li[@class='active']/preceding-sibling::li")
	WebElement generalTab;
	
	@FindBy(xpath="//ul[@class='nav nav-tabs']/li[@class='active']/following-sibling::li")
	WebElement historyTab;
	
	@FindBy(xpath="//div[@class='col-xs-2 fp-history-step complete']/div[.='Uploaded']")
	WebElement uploadedText;
	
	@FindBy(xpath="//div[@class='col-xs-2 fp-history-step complete']/div[.='Uploaded']/following-sibling::div[@class='fp-history-info text-center']")
	WebElement uploadedDate;

	@FindBy(xpath="//div[@class='col-xs-2 fp-history-step complete']/div[.='Paid']")
	WebElement invoiceText;
	
	@FindBy(xpath="//div[@class='col-xs-2 fp-history-step complete']/div[.='Paid']/following-sibling::div[@class='fp-history-info text-center']")
	WebElement invoicePaidDate;
	
	@FindBy(xpath="//div[@class='col-xs-2 fp-history-step complete']/div[.='Validated']")
	WebElement validatedText;
	
	@FindBy(xpath="//div[@class='col-xs-2 fp-history-step complete']/div[.='Validated']/following-sibling::div[@class='fp-history-info text-center']")
	WebElement validatedDate;
	
	@FindBy(xpath="//div[@class='col-xs-2 fp-history-step complete']/div[.='Assigned']")
	WebElement assignedText;
	
	@FindBy(xpath="//div[@class='col-xs-2 fp-history-step complete']/div[.='Assigned']/following-sibling::div[@class='fp-history-info text-center']")
	WebElement assignedDate;
	
	@FindBy(css="div.row.centered.floor-plan-action>a.btn.btn-primary")
	WebElement openProject;
	
	@FindBy(css="div.box-body.table-responsive.no-padding > table > tbody > tr > td > div > a[href$='/deliver']")
	WebElement deliverProject;

	@FindBy(xpath="//table[@class='table table-bordered table-striped sonata-ba-list']/tbody/tr")
	List<WebElement> listFloorPlanRow;
	
	@FindBy(css="a.dropdown-toggle.sonata-ba-action")
	WebElement filters;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']/li[2]/a")
	WebElement invoiceReference;
	
	@FindBy(id="filter_invoice__reference_value")
	WebElement referenceSearchBox;
	
	@FindBy(css="li.turntable-content.slick-slide.slick-current.slick-active>div>div[class*='reel  reel-overlay']>img")
	WebElement checkTurnable;
	
	@FindBy(css="div.box-header>h4")
	WebElement deliverPageHeaderText;
	
	@FindBy(css="div.box-body>button.btn.btn-success")
	WebElement deliverPageDeliverButton;
	
	@FindBy(css="a.btn.btn-danger")
	WebElement deliverPageCancelButton;
	
	@FindBy(css="span.label.label-success")
	WebElement projectStatusTag;
	
	@FindBy(css="table.table.table-bordered.table-striped.sonata-ba-list>tbody>tr:nth-child(1)>td:nth-child(1)>a")
	WebElement firstFPListReference;
	
	@FindBy(xpath="//div[@class='col-xs-2 fp-history-step complete']/div[.='Delivered']")
	WebElement deliverededText;
	
	public BOCompleteProject validateFPDetails(String fpInput, String orderKey)   {
		Verification.elementContainsString(checkRefernce, UtilHBM.getDate(0, "yyyyMMdd"), "Reference Title");
		historyTab.click();
		UtilHBM.waitFixTime(2000);
		Verification.VerifyEquals("UploadedText incorrect", uploadedText.getText(), "Uploaded");
		Verification.VerifyEquals("InvoicePaidText incorrect", invoiceText.getText(), "Paid");
		Verification.VerifyEquals("ValidatedText incorrect", validatedText.getText(), "Validated");
		Verification.VerifyEquals("AssignedText incorrect", assignedText.getText(), "Assigned");
		Verification.elementContainsString(uploadedDate, BackOffice.getReqstDate(), "Uploaded Date");
		Verification.elementContainsString(invoicePaidDate, BackOffice.getReqstDate(), "InvoicePaid Date");
		Verification.elementContainsString(validatedDate, BackOffice.getReqstDate(), "Validated Date");
		Verification.elementContainsString(assignedDate, BackOffice.getReqstDate(), "Assigned Date");
		UtilHBM.waitFixTime(2000);
		generalTab.click();
		UtilHBM.waitFixTime(2000);
		UtilHBM.reportOK("Validated FloorPolan Details");
		return PageFactory.initElements(driver, BOCompleteProject.class);
	}
	
	public BOInProgress openProject() {
		driver.navigate().refresh();
		openProject.click();
		String handle=driver.getWindowHandle();
		for(String handle1:driver.getWindowHandles()) {
				driver.switchTo().window(handle1);
		}	
		ProjectPage projectPage=PageFactory.initElements(driver, ProjectPage.class);
		projectPage.openProject().twoDView().save().closePlanner();
		driver.switchTo().window(handle);
		UtilHBM.reportOK("Opened Project successfully");
		return PageFactory.initElements(driver, BOInProgress.class);
	}
	
	
	
	public BODeliverProject deliverFPProject() {
		
		deliverProject.click();
		Verification.verifyText(deliverPageHeaderText,"Deliver","deliverPageHeaderText");
		Verification.displayOfWebElement(deliverPageCancelButton);
		deliverPageDeliverButton.click();
		UtilHBM.waitExplicitDisplayed(driver, projectStatusTag);
		Verification.VerifyEquals("Project Status Incorrect", projectStatusTag.getText(), "DELIVERED");
		historyTab.click();
		UtilHBM.waitFixTime(2000);
		
		Verification.VerifyEquals("Delivered Text Not visible", deliverededText.getText(), "Delivered");
		UtilHBM.waitFixTime(2000);
		generalTab.click();
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, BODeliverProject.class);
	}
	

	
}
