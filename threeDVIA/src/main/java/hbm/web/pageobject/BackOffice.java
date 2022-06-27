package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import hbm.planner.dataobject.NewProjectData;
import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;

public class BackOffice {
	WebDriver driver;
	
	public BackOffice(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css="ul.sidebar-menu>li.treeview.active>ul>li>a[href$='/design-coaching/pending_info/list']")
	WebElement pendingInfoIDS;
	
	@FindBy(css="button.btn.btn-success")
	WebElement deliverOrderIDS;
	
	@FindBy(css="ul.sidebar-menu>li.treeview.active>ul>li>a[href$='/design-coaching/in_progress_project/list']")
	WebElement iDSInProgress;
	
	@FindBy(css="ul.sidebar-menu>li.treeview>a>i.fa.fa-paint-brush")
	WebElement designCoaching;
	
	@FindBy(css="ul.sidebar-menu>li.treeview>a>i.fa.fa-home")
	WebElement homeMeasure;
	
	@FindBy(css="ul.sidebar-menu>li.treeview.active>ul>li>a[href$='/design-coaching/in_progress_book/list']")
	WebElement iDSUploadBook;
	
	@FindBy(css="ul.sidebar-menu>li.treeview.active>ul>li>a[href$='/design-coaching/delivered/list']")
	WebElement iDSDelivered;
	
	@FindBy(id="design_coaching_book_pdf")
	WebElement uploadPDF;
	
	@FindBy(id="design_coaching_book_image")
	WebElement uploadIMG;
	
    @FindBy(css="ul.sidebar-menu>li.treeview.menu-open>ul>li>a[href$='/design-coaching/to_be_treated/list']")
	WebElement iDSToBeTreated;
	
	@FindBy(css="ul.sidebar-menu>li.treeview.active>ul>li>a[href$='/home-measure/new/list']")
	WebElement hmsNew;
	
	@FindBy(css="ul.sidebar-menu>li.treeview.active>ul>li>a[href$='/home-measure/to_be_treated/list']")
	WebElement hmsToBeTreated;
	
	@FindBy(css="ul.sidebar-menu>li.treeview.active>ul>li>a[href$='/home-measure/in_progress_project/list']")
	WebElement hmsInProgress;
	
	@FindBy(css="ul.sidebar-menu>li.treeview.active>ul>li>a[href$='/home-measure/delivered/list']")
	WebElement hmsDelivered;
	
	@FindBy(css="div.row.centered.floor-plan-action>a.btn.btn-primary")
	WebElement iDSUploadBookButton;
	
	@FindBy(css="div.row.centered.floor-plan-action>a.btn.btn-primary")
	WebElement iDSOpenUsersProject;
	
	@FindBy(css="ul.sidebar-menu>li.treeview>a>i.fa.fa-map-o")
	WebElement floorPlanCreation;
	
	@FindBy(css="div.row.centered.floor-plan-action>a")
	WebElement rejectThisRequest;
		
    @FindBy(css="ul.sidebar-menu>li.treeview.treeview.menu-open>ul>li>a[href$='/floor-plan/new/list']")
	WebElement findNewFPRequest;
	
	@FindBy(css="ul.sidebar-menu>li.treeview.active>ul>li>a[href$='/floor-plan/in_progress/list']")
	WebElement findInProgressFP;
	
	@FindBy(css="div.row.centered.floor-plan-action>a[href$='/open-assignee-project']")
	WebElement openCreatedProject;
	
	@FindBy(css="table.table>tbody>tr>td>div.row.centered.floor-plan-action>a[href$='/reject']")
	WebElement rejectUploadedFloorplan;

	@FindBy(css="ul.sidebar-menu>li.treeview>a>i.fa.fa-envelope")
	WebElement mails;
	
	@FindBy(css="ul.sidebar-menu>li.treeview.active>ul>li>a[href$='mailing/log/list']>i")
	WebElement logs;
	
	@FindBy(xpath="//header[@class='headr']/div/nav/span/span/span[contains(text(),'MAGAZINE')]")
	WebElement magazine;
	
	@FindBy(xpath="//header[@class='headr']/div/nav/span[1]/div/div/a[1]")
	WebElement magazineHomePage;

	@FindBy(css="section.content-header.clearfix>ol>li>a")
	WebElement backToSite;
	
	@FindBy(xpath="//li/a[contains(@href,'dashboard')]")
	WebElement backofficeHome;

	private static String reqstDate;

	private static String validationDate1;

	private static String deliveryDate1;

	private static String validationDate;

	private static String deliveryDate;
	
	private static String d;
	
	private static String validationDate2;

	private static String deliveryDate2;
	



	public BackOffice dates() {
		setDate(UtilHBM.getDate(0, "yyyyMMdd"));
		
		setReqstDate(UtilHBM.getDate(0, "MMMMM d, yyyy"));
		setValidationDate(UtilHBM.getDate(1, "MMMMM d, yyyy"));
		setDeliveryDate(UtilHBM.getDate(3, "MMMMM d, yyyy"));
		
		setReqstDateIDS(UtilHBM.getDate(0, "MMMMM d, yyyy"));
		setValidationDateIDS(UtilHBM.getDate(1, "MMMMM d, yyyy"));
		setDeliveryDateIDS(UtilHBM.getDate(7, "MMMMM d, yyyy"));
		
		setReqstDateHMS(UtilHBM.getDate(0, "MMMMM d, yyyy"));
		setValidationDateHMS(UtilHBM.getDate(1, "MMMMM d, yyyy"));
		setDueDateHMS(UtilHBM.getDate(7, "MMMMM d, yyyy"));

		return PageFactory.initElements(driver, BackOffice.class);
	}
	
	public BOCompleteProject validateNewFPRequest(String fpInput,String orderKey)   {
		BackOffice backOffice= PageFactory.initElements(driver, BackOffice.class);
		backOffice.dates();
		floorPlanCreation.click();
		findNewFPRequest.click();
		
		BONewFP newFloorplanRequest = PageFactory.initElements(driver, BONewFP.class);
		newFloorplanRequest.searchAndOpenNewFPRequest(fpInput, orderKey);
		BOValidateFP boValidateFP=PageFactory.initElements(driver,BOValidateFP.class);
		boValidateFP.validateUploadedFloorplan(fpInput, orderKey)
		.validateFloorplanRequest()
		.validateFPDetails(fpInput,orderKey);
		return PageFactory.initElements(driver, BOCompleteProject.class);
	}

	public BackOffice createProject(NewProjectData newProjectData, int roomNumber, String surfaceArea,String selectRoomType) {
		BOCompleteProject boCompleteProject = PageFactory.initElements(driver, BOCompleteProject.class);
		boCompleteProject.createProject(newProjectData, roomNumber, surfaceArea, selectRoomType);
		return PageFactory.initElements(driver, BackOffice.class);
	}
	
	
	public void setReqstDate(String reqDate) {
		reqstDate = reqDate;
	}
	
	public static String getReqstDate() {		
		return reqstDate;
	}
	
	public void setReqstDateIDS(String reqDate) {
		reqstDate = reqDate;
	}
	
	public static String getReqstDateHMS() {		
		return reqstDate;
	}
	
	public void setReqstDateHMS(String reqDate) {
		reqstDate = reqDate;
	}
	
	public static String getReqstDateIDS() {		
		return reqstDate;
	}	
	
	public static String getValidationDateHMS() {
		return validationDate2;
	}

	public void setValidationDateHMS(String validationDate) {
		BackOffice.validationDate2 = validationDate;
	}

	public static String getDueDateHMS() {
		return deliveryDate2;
	}

	public void setDueDateHMS(String deliveryDate2) {
		BackOffice.deliveryDate2 = deliveryDate2;
	}

	
	public void setValidationDate(String valDate) {
		validationDate1=valDate;
	}
	
	public static String getValidationDate() {		
		return validationDate1;
	}
	
	public void setValidationDateIDS(String valDate) {
		validationDate=valDate;
	}
	
	public static String getValidationDateIDS() {		
		return validationDate;
	}
	
	public void setDeliveryDate(String delivDate) {
		deliveryDate1=delivDate;
	}
	
	public static String getDeliveryDate() {		
		return deliveryDate1;
	}
	
	public void setDeliveryDateIDS(String delivDate) {
		deliveryDate=delivDate;
	}
	
	public static String getDeliveryDateIDS() {		
		return deliveryDate;
	}
	
	
	public void setDate(String d1) {
		d=d1;
	}
	
	public static String getDate() {		
		return d;
	}


	public BODeliverProject deliverProject(String fpInput,String orderKey)   {
		findInProgressFP.click();
		BONewFP newFloorplanRequest=PageFactory.initElements(driver, BONewFP.class);
		newFloorplanRequest.searchAndOpenNewFPRequest(fpInput, orderKey);
		BOInProgress boInProgressRequest=PageFactory.initElements(driver, BOInProgress.class);
		boInProgressRequest.deliverFPProject();
		UtilHBM.reportOK("Deliverd FloorPlan Project");
		return PageFactory.initElements(driver, BODeliverProject.class);
	}

	public BOInProgress openProjectFromBackoffice() {
		BOInProgress boInProgressRequest=PageFactory.initElements(driver, BOInProgress.class);
		boInProgressRequest.openProject();
		return PageFactory.initElements(driver, BOInProgress.class);
		
	}

	public BackOffice rejectFloorPlanRequest(String fpInput,String orderKey)   {
		floorPlanCreation.click();
		findNewFPRequest.click();
		BONewFP newFloorplanRequest=PageFactory.initElements(driver, BONewFP.class);
		newFloorplanRequest.searchAndOpenNewFPRequest(fpInput, orderKey);
		BODisapproveFP boDisapproveFPRequest=PageFactory.initElements(driver, BODisapproveFP.class);
		rejectUploadedFloorplan.click();
		boDisapproveFPRequest.rejectFloorplanRequest();
		return PageFactory.initElements(driver, BackOffice.class);
	}

	public BackOffice needMoreFPInformation(String fpInput,String orderKey)   {
		dates();
		floorPlanCreation.click();
		findNewFPRequest.click();
		BONewFP boNewFP=PageFactory.initElements(driver, BONewFP.class);
		boNewFP.searchAndOpenNewFPRequest(fpInput, orderKey);
		BODisapproveFP boDisapproveFP=PageFactory.initElements(driver, BODisapproveFP.class);
		boDisapproveFP.needMoreFPInformation();
		return PageFactory.initElements(driver, BackOffice.class);
	}

	public void bOValidateIDS(String idsInput,String orderKey)  {
		dates();
		UtilHBM.waitExplicitClickable(driver, designCoaching);
		designCoaching.click();
		UtilHBM.waitExplicitClickable(driver, iDSToBeTreated);
		iDSToBeTreated.click();
		BONewFP boNewFP = PageFactory.initElements(driver, BONewFP.class);
		boNewFP.searchAndOpenIDS(idsInput, orderKey);
		BOValidateFP boValidateFP=PageFactory.initElements(driver, BOValidateFP.class);
		boValidateFP.validateIDS(idsInput,orderKey);
		boValidateFP.validateFloorplanRequest();
		iDSInProgress.click();
		boNewFP.searchAndOpenIDS(idsInput,orderKey);
		boValidateFP.validateIDS(idsInput,orderKey);
		BOCompleteProject boCompleteProject=PageFactory.initElements(driver, BOCompleteProject.class);
		boCompleteProject.openProjectIDS();		
	}
	
	public BODeliverProject uploadBookIDS(String idsInput,String orderKey)   {
		iDSUploadBook.click();
		BONewFP newFloorplanRequest=PageFactory.initElements(driver, BONewFP.class);
		BOValidateFP boValidateFP=PageFactory.initElements(driver, BOValidateFP.class);
		newFloorplanRequest.searchAndOpenIDS(idsInput,orderKey);
		boValidateFP.validateIDS(idsInput,orderKey);
		iDSUploadBookButton.click();
		UtilHBM.waitExplicitDisplayed(driver, uploadPDF);
		uploadPDF.sendKeys(new java.io.File(Setting.imgPath + UtilHBM.getProperty("testData",idsInput+"PDF")).getAbsolutePath());
		String roomImages=UtilHBM.getProperty("testData",idsInput+"CurrentRoomImages");
		String roomImages1=roomImages.split(",")[0];
		uploadIMG.sendKeys(new java.io.File(Setting.imgPath + roomImages1).getAbsolutePath());
		deliverOrderIDS.click();
		iDSDelivered.click();
		newFloorplanRequest.searchAndOpenIDS(idsInput,orderKey);
		boValidateFP.validateIDS(idsInput,orderKey);
		return PageFactory.initElements(driver,BODeliverProject.class);
	}

	public UserHomePage needMoreInfoIDS(String idsInput,String orderKey)   {
		designCoaching.click();
		iDSToBeTreated.click();
		BONewFP boNewFP=PageFactory.initElements(driver, BONewFP.class);
		boNewFP.searchAndOpenIDS(idsInput,orderKey);
		BOValidateFP boValidateFP=PageFactory.initElements(driver, BOValidateFP.class);
		boValidateFP.validateIDS(idsInput,orderKey);
		BODisapproveFP boDisapproveFPRequest=PageFactory.initElements(driver, BODisapproveFP.class);
		boDisapproveFPRequest.idsNeedMoreInfo(idsInput,orderKey);
		goToBackOfficeHome().clickBackToSite();
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public UserHomePage rejectIDS(String idsInput,String orderKey)   {
		designCoaching.click();
		iDSToBeTreated.click();
		BONewFP boNewFP=PageFactory.initElements(driver, BONewFP.class);
		boNewFP.searchAndOpenIDS(idsInput,orderKey);
		BOValidateFP boValidateFP=PageFactory.initElements(driver, BOValidateFP.class);
		boValidateFP.validateIDS(idsInput,orderKey);
		BODisapproveFP boDisapproveFPRequest=PageFactory.initElements(driver, BODisapproveFP.class);
		boDisapproveFPRequest.idsReject(idsInput,orderKey);
		goToBackOfficeHome().clickBackToSite();
		return PageFactory.initElements(driver, UserHomePage.class);
	}

	public void boValidateNeedMoreRequest(String idsInput,String orderKey)   {
		designCoaching.click();
		iDSInProgress.click();
		BONewFP boNewFP=PageFactory.initElements(driver, BONewFP.class);
		boNewFP.searchAndOpenIDS(idsInput,orderKey);
		BOValidateFP boValidateFP=PageFactory.initElements(driver, BOValidateFP.class);
		boValidateFP.validateIDS(idsInput,orderKey);
		BOCompleteProject boCompleteProject=PageFactory.initElements(driver, BOCompleteProject.class);
		boCompleteProject.openProjectIDS();	
	}

	public BOValidateFP bONewHMS(String hmsInput,String orderKey)  {
		dates();
		homeMeasure.click();
		hmsNew.click();
		BONewFP boNewFP=PageFactory.initElements(driver, BONewFP.class);
		boNewFP.searchAndOpenHMS(hmsInput,orderKey).validateHMS(hmsInput,orderKey);
		return PageFactory.initElements(driver,BOValidateFP.class);
	}
	
	public BackOffice bOValidateHMS(String hmsInput, String orderKey) {
		homeMeasure.click();
		hmsToBeTreated.click();
		BONewFP boNewFP = PageFactory.initElements(driver, BONewFP.class);
		boNewFP.searchOpenHMSToBeTreated(hmsInput, orderKey);
		BOValidateFP boValidateFP = PageFactory.initElements(driver, BOValidateFP.class);
		boValidateFP.validateHMS(hmsInput, orderKey);
		boValidateFP.validateFloorplanRequest();
		hmsInProgress.click();
		boNewFP.searchAndOpenHMS(hmsInput, orderKey);
		return this;
	}

	public BOValidateFP deliverHMS(String hmsInput, String orderKey) {
		hmsInProgress.click();
		BONewFP boNewFP = PageFactory.initElements(driver, BONewFP.class);
		boNewFP.searchAndOpenHMS(hmsInput, orderKey).releaseHMSProject();
		hmsDelivered.click();
		boNewFP.searchAndOpenHMS(hmsInput, orderKey).validateHMS(hmsInput, orderKey);
		return PageFactory.initElements(driver, BOValidateFP.class);
	}

	public BackOffice clickMails() {
		UtilHBM.waitExplicitClickable(driver, mails);
		mails.click();
		return PageFactory.initElements(driver, BackOffice.class);
	}
	
	public BONewFP clickLogs() {
		UtilHBM.waitExplicitClickable(driver, logs);
		logs.click();
		return PageFactory.initElements(driver, BONewFP.class);
	}
	
	public UserHomePage clickBackToSite() {
		UtilHBM.waitExplicitDisplayed(driver, backToSite);
		UtilHBM.waitExplicitClickable(driver, backToSite);
		backToSite.click();
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public BackOffice goToBackOfficeHome() {
		UtilHBM.waitExplicitDisplayed(driver, backofficeHome);
		UtilHBM.waitExplicitClickable(driver, backofficeHome);
		backofficeHome.click();
		return PageFactory.initElements(driver, BackOffice.class);
	}
	
	public Magazine goToMagazine() {
		UtilHBM.waitExplicitDisplayed(driver, magazine);
		Actions actions=new Actions(driver);
		actions.moveToElement(magazine).build().perform();
		UtilHBM.waitExplicitDisplayed(driver, magazineHomePage);
		UtilHBM.waitExplicitClickable(driver, magazineHomePage);
		magazineHomePage.click();
		return PageFactory.initElements(driver, Magazine.class);
	}
	
	public BackOffice verifyPageTitle() {
		String pageTitle = driver.getTitle();
		if (pageTitle.equals("Admin Dashboard")) {
			UtilHBM.reportOK("Backoffice page displayed from RS4 page!!");
		} else {
			UtilHBM.reportKO("Backoffice page not displayed from RS4 page!!");
			Assert.assertFalse(pageTitle.contains("Error"));
		}
		return this;
	}
}

		
