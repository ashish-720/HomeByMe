package hbm.web.pageobject;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class BOValidateFP {

	WebDriver driver;

	public BOValidateFP(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Medias preview']/following-sibling::td/a/img")
	WebElement mediasPreview;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='In progress date']/following-sibling::td")
	WebElement inProgressDate;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='In progress decider']/following-sibling::td")
	WebElement inProgressDecider;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Appointment']/following-sibling::td")
	WebElement appointmentDate;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Property type']/following-sibling::td")
	WebElement propertyType;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Name']/following-sibling::td")
	WebElement name;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Address']/following-sibling::td")
	WebElement address;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Firstname']/following-sibling::td")
	WebElement firstName;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Lastname']/following-sibling::td")
	WebElement lastName;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Phone number']/following-sibling::td")
	WebElement phoneNumber;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Area']/following-sibling::td")
	WebElement area1;

	@FindBy(css = "ul.sidebar-menu>li.treeview.active>ul>li.active>a")
	WebElement activeTab;

	@FindBy(css = "div.navbar-header>span.navbar-brand")
	WebElement IDSHeader;

	@FindBy(css = "table.table>tbody>tr>td>div.row.centered.floor-plan-action>a.btn.btn-success")
	WebElement releaseIDSProject;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='File name']/following-sibling::td")
	WebElement fileName;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='File format']/following-sibling::td")
	WebElement fileFormat;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Surface']/following-sibling::td")
	WebElement surface;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Furnished']/following-sibling::td")
	WebElement Furnish;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Project name']/following-sibling::td")
	WebElement project_name;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Comment']/following-sibling::td")
	WebElement comment;

	@FindBy(css = "table.table>tbody>tr.sonata-ba-view-container>td>a.view-fullscreen>img")
	WebElement floorplanImage;

	@FindBy(css = "table.table>tbody>tr>td>div.row.centered.floor-plan-action>a.btn.btn-primary")
	WebElement validateFloorplan;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Reference']/following-sibling::td")
	WebElement reference;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Date of request']/following-sibling::td")
	WebElement requestDate;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Validation due date']/following-sibling::td")
	WebElement ValiDate;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Delivery due date']/following-sibling::td")
	WebElement DelivDate;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Delivery date']/following-sibling::td")
	WebElement DeliveryDate;
	
	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Due date']/following-sibling::td")
	WebElement DeliveryDueDate;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Language']/following-sibling::td")
	WebElement language;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Invoice']/following-sibling::td")
	WebElement invoice;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Purchase id']/following-sibling::td")
	WebElement purchaseId;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Initial project']/following-sibling::td")
	WebElement initialProject;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Offer']/following-sibling::td")
	WebElement offerText;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Type of room']/following-sibling::td")
	WebElement typeOfRoom;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Room label']/following-sibling::td")
	WebElement roomLabel;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Room surface']/following-sibling::td")
	WebElement roomSurface;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Living situation']/following-sibling::td")
	WebElement livingSituation;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='People']/following-sibling::td")
	WebElement people;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Photo preview']/following-sibling::td/a/img")
	List<WebElement> photoPreviewList;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Inspiration preview']/following-sibling::td/a/img")
	List<WebElement> inspirationPreviewList;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Inspiration']/following-sibling::td/img")
	WebElement inspirationImage;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Liked colors']/following-sibling::td/div/div")
	List<WebElement> likedColors;

	@FindBy(xpath = "//tr[@class='sonata-ba-view-container']/th[.='Special request']/following-sibling::td")
	WebElement specialRequest;

	@FindBy(css = ".btn.btn-primary.pull-right.view-fullscreen")
	WebElement viewThisPlan;

	@FindBy(css = "a[class = 'btn btn-primary pull-right']")
	WebElement downloadThisPlan;

	@FindBy(css = "#myModal>div>div>div.modal-footer>button")
	WebElement closeButton;

	@FindBy(css = "#myModal>div>div>div.modal-body>img")
	WebElement fullscreenImg;

	@FindBy(css = "#myModal>div>div>div.modal-header>h4")
	WebElement imageTitle;

	@FindBy(xpath = "//li/a[contains(text(), 'General')]")
	WebElement generalTab;

	@FindBy(css = "button.btn.btn-success")
	WebElement validateOrder;

	@FindBy(xpath = "//li/a[contains(text(), 'History')]")
	WebElement historyTab;

	@FindBy(xpath = "//div[@class='col-xs-2 fp-history-step complete']/div[.='Uploaded']")
	WebElement uploadedText;

	@FindBy(xpath = "//div[@class='col-xs-2 fp-history-step complete']/div[.='Uploaded']/following-sibling::div[@class='fp-history-info text-center']")
	WebElement uploadedDate;

	@FindBy(xpath = "//div[@class='col-xs-2 fp-history-step complete']/div[.='Paid']")
	WebElement invoiceText;

	@FindBy(xpath = "//div[@class='col-xs-2 fp-history-step complete']/div[.='Paid']/following-sibling::div[@class='fp-history-info text-center']")
	WebElement invoicePaidDate;

	@FindBy(xpath = "//span[.='Due date: ']/following-sibling::span")
	WebElement dueDate;

	@FindBy(xpath = "//div[@class='navbar-header']/span[@class='navbar-brand']")
	WebElement checkRefernce;

	@FindBy(xpath = "//a[@class='sonata-action-element']")
	WebElement returnToList;

	public BOValidateFP validateUploadedFloorplan(String fpInput, String orderKey)   {
		String Furnished = UtilHBM.getProperty("testData", fpInput + "Offer");
		String floorplan = UtilHBM.getProperty("testData", fpInput + "Floorplan");
		String area = UtilHBM.getProperty("testData", fpInput + "Area");
		String area1 = null;
		String measuringUnit = null;
		String invoiceReference1 = UtilHBM.getProperty("testData", orderKey);
		if (area.contains(",")) {
			area1 = Arrays.asList(area.split(",")).get(0);
			measuringUnit = Arrays.asList(area.split(",")).get(1);
		} else
			UtilHBM.reportKO("Area value or unit not displayed or are incorrect!!!");
		String area2 = area1 + " " + measuringUnit;

		String projectName = "Auto_" + UtilHBM.getDate(0, "yyyyMMdd");
		Verification.VerifyEquals("FileName is Incorrect", fileName.getText(), floorplan);

		if (fileName.getText().contains("jpg") && fileFormat.getText().contains("jpeg")
				|| fileName.getText().contains("png") && fileFormat.getText().contains("png")
				|| fileName.getText().contains("pdf") && fileFormat.getText().contains("pdf")) {
			UtilHBM.reportOK("File Format Verified");
		} else {
			UtilHBM.reportKO("Incorrect FileFormat");
		}
		Verification.VerifyEquals("Area is Incorrect", surface.getText(), area2);
		Verification.VerifyEquals("Project Name is Incorrect", project_name.getText(), projectName);
		Verification.VerifyEquals("Comment is Incorrect", comment.getText(), projectName);
		if (Furnished.equalsIgnoreCase("Unfurnished project")) {
			Verification.VerifyEquals("Furnished Text is Incorrect", Furnish.getText(), "No");
		} else if (Furnished.equalsIgnoreCase("Furnished project")) {
			Verification.VerifyEquals("Furnished Text is Incorrect", Furnish.getText(), "Yes");
		} else {
			UtilHBM.reportKO("Wrong offer input");
		}
		Verification.elementContainsString(reference, BackOffice.getDate(), "Reference");
		Verification.VerifyEquals("Incorrect Invoice", invoice.getText(), invoiceReference1);
		Verification.elementContainsString(dueDate, BackOffice.getDeliveryDate().toUpperCase(), "Due Date");
		Verification.elementContainsString(requestDate, BackOffice.getReqstDate(), "RequestDate");
		Verification.elementContainsString(ValiDate, BackOffice.getValidationDate(), "ValidationDueDate");
		Verification.elementContainsString(DelivDate, BackOffice.getDeliveryDate(), "DeliveryDueDate");
		Verification.displayOfWebElement(language);

		if (floorplanImage.getAttribute("src").contains(".png") || floorplanImage.getAttribute("src").contains(".jpg")
				|| floorplanImage.getAttribute("src").contains(".pdf")) {
			UtilHBM.reportOK("FloorPlanImage added Properly");
		} else {
			UtilHBM.reportKO("FloorPlanImage not added Properly");
		}
		Verification.displayOfWebElement(downloadThisPlan);
		viewThisPlan.click();
		UtilHBM.waitExplicitClickable(driver, fullscreenImg);
		Verification.VerifyEquals("Image Name is Incorrect", imageTitle.getText(), floorplan);
		if (fullscreenImg.getAttribute("src").contains(".png") || fullscreenImg.getAttribute("src").contains(".jpg")
				|| fullscreenImg.getAttribute("src").contains(".pdf")) {
			UtilHBM.reportOK("fullscreenImg is visible");
		} else {
			UtilHBM.reportKO("fullscreenImg not visible");
		}
		closeButton.click();
		UtilHBM.waitFixTime(2000);
		historyTab.click();
		UtilHBM.waitExplicitDisplayed(driver, uploadedText);
		UtilHBM.waitExplicitDisplayed(driver, invoiceText);
		Verification.VerifyEquals("UploadedText incorrect", uploadedText.getText(), "Uploaded");
		Verification.VerifyEquals("InvoicePaidText incorrect", invoiceText.getText(), "Paid");
		Verification.elementContainsString(uploadedDate, BackOffice.getReqstDate(), "Uploaded Date");
		Verification.elementContainsString(invoicePaidDate, BackOffice.getReqstDate(), "InvoicePaid Date");
		generalTab.click();
		UtilHBM.waitExplicitDisplayed(driver, fileName);
		return PageFactory.initElements(driver, BOValidateFP.class);
	}

	public BOInProgress validateFloorplanRequest() {
		new Actions(driver).moveToElement(validateFloorplan);
		UtilHBM.waitExplicitDisplayed(driver, validateFloorplan);
		UtilHBM.waitExplicitClickable(driver, validateFloorplan);
		validateFloorplan.click();
		validateOrder.click();
		return PageFactory.initElements(driver, BOInProgress.class);
	}

	public BONewFP returnToList() {
		returnToList.click();
		return PageFactory.initElements(driver, BONewFP.class);
	}

	public BackOffice releaseIDSProject() {
		String handle = driver.getWindowHandle();
		for (String handle1 : driver.getWindowHandles()) {
			if (!handle1.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle1);
			}
		}
		driver.navigate().refresh();
		UtilHBM.waitExplicitClickable(driver, validateFloorplan);
		releaseIDSProject.click();
		validateOrder.click();
		return PageFactory.initElements(driver, BackOffice.class);
	}

	public void releaseHMSProject() {
		releaseIDSProject.click();
		validateOrder.click();
	}

	public void validateIDS(String idsInput, String orderKey)   {
		String selectedRoom = UtilHBM.getProperty("testData", idsInput + "SelectedRoom");
		String roomsToSelect = UtilHBM.getProperty("testData", idsInput + "TypeofRoom");
		String area = UtilHBM.getProperty("testData", idsInput + "Area");
		String reason = UtilHBM.getProperty("testData", idsInput + "Reason");
		String users = UtilHBM.getProperty("testData", idsInput + "Users");
		String request = UtilHBM.getProperty("testData", idsInput + "Request");
		String invoiceReference1 = UtilHBM.getProperty("testData", orderKey);
		String roomImages = UtilHBM.getProperty("testData", idsInput + "CurrentRoomImages");
		String[] roomImages1 = roomImages.split(",");
		String[] colours = UtilHBM.getProperty("testData", idsInput + "Colours").split(",");
		int noOfRoomImages = roomImages1.length;
		Verification.elementContainsString(IDSHeader, BackOffice.getDate(), "IDS Header");
		Verification.elementContainsString(dueDate, BackOffice.getDeliveryDateIDS().toUpperCase(), "Due Date");
		Verification.displayOfWebElement(initialProject);
		Verification.VerifyEquals("Incorrect Room Label", roomLabel.getText(), selectedRoom);
		if (roomsToSelect.contains(",")) {
			Verification.VerifyEquals("Incorrect Offer displayed", offerText.getText(),"Multi-purpose room decoration");
			List<String> rooms1 = Arrays.asList(typeOfRoom.getText().trim().split(","));
			if (rooms1.size() <= 3) {
				for (String a : rooms1) {
					if (roomsToSelect.contains(a.trim())) {
						UtilHBM.reportOK("Validation success for " + a);
					} else {
						UtilHBM.reportKO(a + " not available in input");
					}
				}
			} else {
				UtilHBM.reportKO("More than 3 room available");
			}
		} else if (!roomsToSelect.contains(",")) {
			Verification.VerifyEquals("Incorrect Offer displayed", offerText.getText(), "One Room design");
			Verification.VerifyEquals("Incorrect Type of room displayed.", typeOfRoom.getText(), roomsToSelect);
		}

		if (area.contains(",")) {
			List<String> area1 = Arrays.asList(area.split(","));
			int areaValue = (int) Double.parseDouble(area1.get(0));
			Verification.elementContainsString(roomSurface, Integer.toString(areaValue), "Room area ");
			Verification.elementContainsString(roomSurface, area1.get(1), "Room area unit ");
		} else {
			UtilHBM.reportKO("Incorrect area value!!!");
		}
		Verification.VerifyEquals("Incorrect Living situation Text", livingSituation.getText(), reason);
		Verification.VerifyEquals("Incorrect People Text", people.getText(), users);
		int i = 0;
		for (WebElement a : photoPreviewList) {
			UtilHBM.waitExplicitDisplayed(driver, a);
			if (a.getAttribute("src").contains(".png") || a.getAttribute("src").contains(".jpg")) {
				i++;
			} else {
				UtilHBM.reportKO("Image not displayed");
			}
		}
		photoPreviewList.get(0).click();
		UtilHBM.waitExplicitClickable(driver, fullscreenImg);
		if (fullscreenImg.getAttribute("src").contains(".png") || fullscreenImg.getAttribute("src").contains(".jpg")) {
			UtilHBM.reportOK("Fullscren Image Displayed");
		} else {
			UtilHBM.reportKO("fullscreenImg not visible");
		}
		closeButton.click();
		UtilHBM.waitFixTime(1000);

		if (i == noOfRoomImages) {
			UtilHBM.reportOK("Photo preview Image List verified");
		} else {
			UtilHBM.reportKO("Photo preview List not displayed");
		}
		if (inspirationPreviewList.isEmpty()) {
			UtilHBM.reportKO("Inspirational Image List is Empty");
		} else {
			for (WebElement a : inspirationPreviewList) {
				if (a.getAttribute("src").contains(".png") || a.getAttribute("src").contains(".jpg"))
					UtilHBM.reportOK("Inspirational Image Preview Displayed");
				else
					UtilHBM.reportKO("Inspirational Image Preview not displayed");
			}
		}
		Verification.displayOfWebElement(inspirationImage);

		if (likedColors.isEmpty()) {
			UtilHBM.reportKO("Liked colors not displayed");
		} else if (likedColors.size() == colours.length) {
			for (WebElement a : likedColors)
				Verification.displayOfWebElement(a);
		} else {
			UtilHBM.reportKO("Additional colors displayed in Liked colors");
		}
		Verification.VerifyEquals("Special request text is wrong", specialRequest.getText(), request);
		Verification.elementContainsString(purchaseId, BackOffice.getDate(), "Purchase Id");
		Verification.VerifyEquals("Incorrect Invoice", invoice.getText(), invoiceReference1);
		Verification.elementContainsString(requestDate, BackOffice.getReqstDateIDS(), "RequestDate");
		Verification.elementContainsString(DeliveryDueDate, BackOffice.getDeliveryDateIDS(), "DeliveryDueDate");
		Verification.VerifyEquals("Incorrect Language", language.getText(), "en");
		UtilHBM.reportOK("Verified Page :" + activeTab.getText());
		
	}

	public BOValidateFP validateHMS(String hmsInput, String orderKey) {
		String address1 = UtilHBM.getProperty("testData", hmsInput + "Address");
		String firstname1 = UtilHBM.getProperty("testData", hmsInput + "FirstName");
		String lastname1 = UtilHBM.getProperty("testData", hmsInput + "LastName");
		String phone1 = UtilHBM.getProperty("testData", hmsInput + "Phone");
		String typeofhousing1 = UtilHBM.getProperty("testData", hmsInput + "TypeOfHousing");

		String area2 = UtilHBM.getProperty("testData", hmsInput + "Area");
		String area5 = null;
		if (area2.contains(",")) {
			List<String> area1 = Arrays.asList(area2.split(","));
			area5 = area1.get(0) + " " + area1.get(1);
		} else {
			UtilHBM.reportKO("Area value or unit not displayed or are incorrect!!!");
		}
		Verification.VerifyEquals("Incorrect Address", address.getText(), address1);
		Verification.VerifyEquals("Incorrect FirstName", firstName.getText(), firstname1);
		Verification.VerifyEquals("Incorrect LastName", lastName.getText(), lastname1);
		Verification.VerifyEquals("Incorrect Phone Number", phoneNumber.getText(), phone1);
		Verification.VerifyEquals("Incorrect Area", area1.getText(), area5);
		Verification.VerifyEquals("Incorrect property type", propertyType.getText(), typeofhousing1);
		if (!activeTab.getText().equalsIgnoreCase("New")) {
			Verification.elementContainsString(name, "Auto", "HMS Name");
			Verification.displayOfWebElement(mediasPreview);
			Verification.displayOfWebElement(purchaseId);
			Verification.elementContainsString(DeliveryDueDate, UtilHBM.getProperty("testData", hmsInput + "DueDate"),
					"Due date");
		} else {
			Verification.VerifyEquals("HMS Incorrect Name", name.getText(), "Auto" + BackOffice.getDate());
			Verification.elementContainsString(purchaseId, BackOffice.getDate(), "Purchase Id");
			Verification.elementContainsString(appointmentDate, BackOffice.getValidationDateHMS(), "Appointment date");
			UtilHBM.setProperty("testData", hmsInput + "RequestDate", BackOffice.getReqstDateHMS());
		}
		if (activeTab.getText().equalsIgnoreCase("To be treated")) {
			String valiDateHMS = appointmentDate.getText();
			UtilHBM.setProperty("testData", hmsInput + "ValidationDate",
					valiDateHMS.substring(0, valiDateHMS.lastIndexOf(" ")));
			UtilHBM.setProperty("testData", orderKey, invoice.getText());
		} else {
			String invoiceReference1 = UtilHBM.getProperty("testData", orderKey);
			Verification.VerifyEquals("Incorrect Invoice", invoice.getText(), invoiceReference1);
			if (!activeTab.getText().equalsIgnoreCase("New")) {
				Verification.elementContainsString(appointmentDate,
						UtilHBM.getProperty("testData", hmsInput + "ValidationDate"), "Appointment date");
			}
		}
		Verification.elementContainsString(requestDate, UtilHBM.getProperty("testData", hmsInput + "RequestDate"),
				"RequestDate");

		if (activeTab.getText().equalsIgnoreCase("Delivered")) {
			Verification.elementContainsString(DeliveryDate, BackOffice.getReqstDateHMS(), "Delivery date");
		}

		Verification.VerifyEquals("Incorrect Language", language.getText(), "en");
		return this;
	}
}