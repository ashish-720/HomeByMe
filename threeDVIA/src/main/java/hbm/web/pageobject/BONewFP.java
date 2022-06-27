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
import hbm.planner.utility.Verification;

public class BONewFP {
	WebDriver driver;
	
	public BONewFP(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath="//table[@class='table table-bordered table-striped table-hover sonata-ba-list']/thead/tr/th")
	List<WebElement> columnListIDS;
	
	@FindBy(xpath="//table[@class='table table-bordered table-striped table-hover sonata-ba-list']/tbody/tr[1]/td")
	List<WebElement> columnListDataIDS;
	
	@FindBy(css="ul.sidebar-menu>li.treeview.active>ul>li.active>a")
	WebElement activeTab;
	
	@FindBy(css="div.container-fluid>div.navbar-header>span.label")
	WebElement projectStatus;
	
	@FindBy(xpath="//table[@class='table table-bordered table-striped table-hover sonata-ba-list']/thead/tr/th[2]")
	WebElement dateOfRequestHeader;
	
	@FindBy(xpath="//table[@class='table table-bordered table-striped table-hover sonata-ba-list']/tbody/tr/td[2]")
	WebElement dateOfRequest;
	
	@FindBy(xpath="//table[@class='table table-bordered table-striped table-hover sonata-ba-list']/tbody/tr/td[3]")
	WebElement thirdColumnData;
	
	@FindBy(xpath="//table[@class='table table-bordered table-striped table-hover sonata-ba-list']/thead/tr/th[3]/a")
	WebElement thirdHeader;
	
	@FindBy(xpath="//table[@class='table table-bordered table-striped table-hover sonata-ba-list']/thead/tr/th[3]")
	WebElement thirdHeaderPendingInfo;
	
	@FindBy(xpath="//table[@class='table table-bordered table-striped table-hover sonata-ba-list']/thead/tr/th[4]")
	WebElement fourthHeader;
	
	@FindBy(xpath="//table[@class='table table-bordered table-striped table-hover sonata-ba-list']/thead/tr/th[4]/a")
	WebElement fourthHeaderPendingInfo;
	
	@FindBy(xpath="//table[@class='table table-bordered table-striped table-hover sonata-ba-list']/tbody/tr/td[4]/span/strong")
	WebElement furnish1;
	
	@FindBy(xpath="//table[@class='table table-bordered table-striped table-hover sonata-ba-list']/tbody/tr/td[4]")
	WebElement roomType;
	
	@FindBy(xpath="//table[@class='table table-bordered table-striped table-hover sonata-ba-list']/thead/tr/th[5]/a")
	WebElement fifthHeader;
	
	@FindBy(xpath="//table[@class='table table-bordered table-striped table-hover sonata-ba-list']/tbody/tr/td[5]")
	WebElement floorplanFile;
	
	@FindBy(xpath="//table[@class='table table-bordered table-striped table-hover sonata-ba-list']/thead/tr/th[6]")
	WebElement floorplanSurfaceAreaHeader;
	
	@FindBy(xpath="//table[@class='table table-bordered table-striped table-hover sonata-ba-list']/tbody/tr/td[6]")
	WebElement floorplanSurfaceArea;
	
	@FindBy(xpath="//table[@class='table table-bordered table-striped table-hover sonata-ba-list']/tbody/tr")
	List<WebElement> floorplanReference;
	
	@FindBy(css="a.dropdown-toggle.sonata-ba-action")
	WebElement filters;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-scrollable']/li[2]/a")
	WebElement invoiceReference;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-scrollable']/li[3]/a")
	WebElement dateOfRequestFilter;
	
	@FindBy(id="filter_invoice__reference_value")
	WebElement referenceSearchBox;
	
	@FindBy(id="filter_createdAt_value_start")
	WebElement requestDateStart;
	
	@FindBy(id="filter_createdAt_value_end")
	WebElement requestDateEnd;
	
	@FindBy(css="div.form-group>button.btn.btn-primary")
	WebElement filterButton;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-scrollable']/li/a[normalize-space()='User']")
	WebElement userFilter;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-scrollable']/li/a[normalize-space()='Delivered At']")
	WebElement deliveredAtFilter;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-scrollable']/li/a[normalize-space()='Template Name']")
	WebElement templateNameFilter;
	
	@FindBy(id="s2id_filter_user_value_autocomplete_input")
	WebElement userDropdown;
	
	@FindBy(id="s2id_autogen9_search")
	WebElement userInput;
	
	@FindBy(id="s2id_autogen2_search")
	WebElement templateNameInput;
	
	@FindBy(xpath="//ul[@id='select2-results-9']/li[starts-with(@class,'select2-results')]")
	List<WebElement> userSuggestions;
	
	@FindBy(id="filter_deliveredAt_value_start")
	WebElement deliveredAtFrom;
	
	@FindBy(id="filter_deliveredAt_value_end")
	WebElement deliveredAtTo;
	
	@FindBy(id="s2id_filter_templateName_value")
	WebElement templateNameDropdown;
	
	@FindBy(xpath ="//div[@class='select2-container per-page small']")
	WebElement paginationDropdown;
	
	@FindBy(xpath ="//ul[@id='select2-results-8']/li[4]")
	WebElement paginationOption;
	
	public void searchAndOpenNewFPRequest(String fpInput, String orderKey)   {
		String Furnished = UtilHBM.getProperty("testData", fpInput + "Offer");
		String area = UtilHBM.getProperty("testData", fpInput + "Area");
		String area1 = null;
		String measuringUnit = null;
		if (area.contains(",")) {
			area1 = Arrays.asList(area.split(",")).get(0);
			measuringUnit = Arrays.asList(area.split(",")).get(1);
		} else
			UtilHBM.reportKO("Area value or unit not displayed or are incorrect!!!");
		String area2 = area1 + " " + measuringUnit;
		String invoiceReference1 = UtilHBM.getProperty("testData", orderKey);
		UtilHBM.reportInfo("Invoice Reference :" + invoiceReference1);
		searchAndOpen(invoiceReference1);
		for (int i = 1; i < columnListIDS.size(); i++) {
			WebElement columnName = columnListIDS.get(i);
			WebElement columnData = columnListDataIDS.get(i);
			switch (columnName.getText().trim()) {

			case "Date of request":
				Verification.elementContainsString(columnData, BackOffice.getReqstDate(), "Date of request");
				break;

			case "Due validation date":
				Verification.elementContainsString(columnData, BackOffice.getValidationDate(), "Due validation date");
				break;
			case "Reference":
				Verification.elementContainsString(columnData, BackOffice.getDate(), "Reference");
				break;

			case "Furnished":
				if (Furnished.equalsIgnoreCase("Unfurnished project"))
					Verification.VerifyEquals("Furnished Text is Incorrect", columnData.getText(), "No");
				else if (Furnished.equalsIgnoreCase("Furnished project"))
					Verification.VerifyEquals("Furnished Text is Incorrect", columnData.getText(), "Yes");
				break;

			case "File":
				Verification.VerifyEquals("Filename is Incorrect", columnData.getText(),
						UtilHBM.getProperty("testData", fpInput + "Floorplan"));
				break;

			case "Surface":
				Verification.VerifyEquals("Surface Area is Incorrect", columnData.getText(), area2);
				break;

			case "Due delivery date":
				Verification.elementContainsString(columnData, BackOffice.getDeliveryDate(), "Due delivery date");
				break;

			case "Language":
				Verification.elementContainsString(columnData, "en", "Language");
				break;

			case "Delivery date":
				Verification.elementContainsString(columnData, BackOffice.getReqstDate(), "Delivery date");
				break;

			case "Rejection date":
				Verification.elementContainsString(columnData, BackOffice.getReqstDate(), "Rejection date");
				break;

			case "Invoice status":
				Verification.VerifyEquals("Invoice status is Incorrect", columnData.getText(), "Paid");
				break;

			default:
				UtilHBM.reportKO("Column not available for " + columnName.getText().trim());
				break;
			}
		}

		/*
		 * if(dateOfRequestHeader.getText().equals("Date of request"))
		 * Verification.elementContainsString(dateOfRequest, BackOffice.getReqstDate(),
		 * "Request Date"); else UtilHBM.reportKO("Date of request Column changed!!!");
		 * 
		 * if(thirdHeader.getText().equals("Due validation date"))
		 * Verification.elementContainsString(thirdColumnData,
		 * BackOffice.getValidationDate(),"Validation Date"); else
		 * if(thirdHeader.getText().equals("Due delivery date"))
		 * Verification.elementContainsString(thirdColumnData,
		 * BackOffice.getDeliveryDate(),"Due Delivery Date"); else
		 * UtilHBM.reportKO("Due Validation or Delivery Date Column changed!!!");
		 * 
		 * if(fourthHeader.getText().equals("Furnished")) {
		 * if(Furnished.equalsIgnoreCase("Unfurnished project"))
		 * Verification.VerifyEquals("Furnished Text is Incorrect", furnish1.getText(),
		 * "No"); else if(Furnished.equalsIgnoreCase("Furnished project"))
		 * Verification.VerifyEquals("Furnished Text is Incorrect", furnish1.getText(),
		 * "Yes"); } else UtilHBM.reportKO("Furnished Column changed!!!");
		 * 
		 * 
		 * if(fifthHeader.getText().equals("File"))
		 * Verification.VerifyEquals("Filename is Incorrect", floorplanFile.getText(),
		 * fpPath1); else UtilHBM.reportKO("File Column changed!!!");
		 * 
		 * if(floorplanSurfaceAreaHeader.getText().equals("Surface"))
		 * Verification.VerifyEquals("Surface Area is Incorrect",
		 * floorplanSurfaceArea.getText(), area2); else
		 * UtilHBM.reportKO("Surface Column changed!!!");
		 */
		floorplanReference.get(0).findElement(By.xpath("td[1]/a")).click();
		UtilHBM.reportOK("New FloorPlan Request");
		UtilHBM.waitExplicitDisplayed(driver, projectStatus);
		Verification.VerifyEquals("Wrong Project Status Displayed", activeTab.getText(), projectStatus.getText());
	}

	
	public void searchAndOpenIDS(String idsInput, String orderKey)   {
		String invoiceReference1 = UtilHBM.getProperty("testData", orderKey);
		UtilHBM.reportInfo("Invoice Reference :" + invoiceReference1);
		searchAndOpen(invoiceReference1);
		for (int i = 1; i < columnListIDS.size(); i++) {
			WebElement columnName = columnListIDS.get(i);
			WebElement columnData = columnListDataIDS.get(i);
			switch (columnName.getText().trim()) {

			case "Date of request":
				Verification.elementContainsString(columnData, BackOffice.getReqstDateIDS(), "Date of request");
				break;

			case "Order id":
				Verification.elementContainsString(columnData, BackOffice.getDate(), "Order id");
				break;

			case "Due validation date":
				Verification.elementContainsString(columnData, BackOffice.getValidationDateIDS(),
						"Due validation date");
				break;

			case "Type of room":
				String typeOfRoom = UtilHBM.getProperty("testData", idsInput + "TypeofRoom");
				if (typeOfRoom.contains(",")) {
					List<String> rooms1 = Arrays.asList(columnData.getText().trim().split(","));
					if (rooms1.size() <= 3) {
						for (String a : rooms1) {
							if (typeOfRoom.contains(a.trim())) {
								UtilHBM.reportOK("Validation success for " + a);
							} else {
								UtilHBM.reportKO(a + " not available in input");
							}
						}
					} else {
						UtilHBM.reportKO("More than 3 room available");
					}
				} else if (!typeOfRoom.contains(",")) {
					Verification.VerifyEquals("Type of room is incorrect", columnData.getText().trim(), typeOfRoom);
				}
				break;

			case "Room surface":
				String area = UtilHBM.getProperty("testData", idsInput + "Area");
				if (area.contains(",")) {
					List<String> area1 = Arrays.asList(area.split(","));
					int areaValue = (int) Double.parseDouble(area1.get(0));
					Verification.elementContainsString(columnData, Integer.toString(areaValue), "Room surface1");
					Verification.elementContainsString(columnData, area1.get(1), "Room surface2");
				} else
					UtilHBM.reportKO("Area value or unit not displayed or are incorrect!!!");
				break;

			case "Due delivery date":
				Verification.elementContainsString(columnData, BackOffice.getDeliveryDateIDS(), "Due delivery date");
				break;

			case "Language":
				Verification.elementContainsString(columnData, "en", "Language");
				break;

			case "Delivery date":
				Verification.elementContainsString(columnData, BackOffice.getReqstDateIDS(), "Delivery date");
				break;

			case "Rejection date":
				// Verification.elementContainsString(columnData,BackOffice.getReqstDateIDS()
				// ,"Rejection date");
				break;

			case "Invoice status":
				// Verification.elementContainsString(columnData,"Paid" ,"Invoice status");
				break;

			case "Reason for rejection":
				// Verification.elementContainsString(columnData,"To be
				// added-rejectReason","Reason for rejection");
				break;

			default:
				UtilHBM.reportKO("Column not available for " + columnName.getText().trim());
				break;
			}
		}

		floorplanReference.get(0).findElement(By.xpath("td[1]/a")).click();
		UtilHBM.reportOK("IDS Search and Open OK");
		UtilHBM.waitExplicitDisplayed(driver, projectStatus);
		Verification.VerifyEquals("Wrong Project Status Displayed", activeTab.getText(), projectStatus.getText());
	}
	
	public BOValidateFP searchAndOpenHMS(String hmsInput, String orderKey) {
		String invoiceReference1 = UtilHBM.getProperty("testData", orderKey);
		UtilHBM.reportInfo("Invoice Reference :" + invoiceReference1);
		searchAndOpen(invoiceReference1);
		if (dateOfRequestHeader.getText().equals("Date of request"))
			if (activeTab.getText().equalsIgnoreCase("New")) {
				Verification.elementContainsString(dateOfRequest, BackOffice.getReqstDateHMS(), "Request Date");
			} else {
				Verification.elementContainsString(dateOfRequest,
						UtilHBM.getProperty("testData", hmsInput + "RequestDate"), "Request Date");
			}
		else
			UtilHBM.reportKO("Date of request Column changed!!!");

		if (activeTab.getText().equalsIgnoreCase("Pending info")) {
			if (thirdHeader.getText().trim().equals("Delivery date"))
				Verification.elementContainsString(thirdColumnData, BackOffice.getReqstDateHMS(), "");
			else
				UtilHBM.reportKO("Due Date Column changed!!!");
		}
		floorplanReference.get(0).findElement(By.xpath("td[1]/a")).click();
		UtilHBM.waitExplicitDisplayed(driver, projectStatus);
		Verification.VerifyEquals("Wrong Project Status Displayed", activeTab.getText(), projectStatus.getText());
		return PageFactory.initElements(driver, BOValidateFP.class);
	}

	public void searchOpenHMSToBeTreated(String hmsInput, String orderKey) {
		filters.click();
		dateOfRequestFilter.click();
		requestDateStart.click();
		requestDateStart.sendKeys(UtilHBM.getDate(-5, "MMM d, yyyy"));
		requestDateEnd.sendKeys(UtilHBM.getDate(0, "MMM d, yyyy"));
		filterButton.click();
		UtilHBM.waitFixTime(2000);
		String requestDateHMS = floorplanReference.get(0).findElement(By.xpath("td[2]")).getText();
		UtilHBM.setProperty("testData", hmsInput + "RequestDate",
				requestDateHMS.substring(0, requestDateHMS.lastIndexOf(" ") - 1));
		String dueDateHMS = floorplanReference.get(0).findElement(By.xpath("td[3]")).getText();
		UtilHBM.setProperty("testData", hmsInput + "DueDate", dueDateHMS.substring(0, dueDateHMS.lastIndexOf(" ") - 1));
		floorplanReference.get(0).findElement(By.xpath("td[1]/a")).click();
		UtilHBM.waitExplicitDisplayed(driver, projectStatus);
		Verification.VerifyEquals("Wrong Project Status Displayed", activeTab.getText(), projectStatus.getText());
	}

	public BONewFP searchAndOpen(String invoiceReference1) {
		int i = 0;
		filters.click();
		invoiceReference.click();
		referenceSearchBox.sendKeys(invoiceReference1 + Keys.ENTER);
		UtilHBM.turnOffImplicitWaits(driver);
		while (i < 30 && floorplanReference.isEmpty()) {
			filterButton.click();
			UtilHBM.waitFixTime(2000);
			i++;
		}
		UtilHBM.turnOnImplicitWaits(driver);
		return this;
	}
		
	

	public BONewFP filterMails() {
		UtilHBM.waitExplicitClickable(driver, paginationDropdown);
		paginationDropdown.click();
		UtilHBM.waitExplicitClickable(driver, paginationOption);
		paginationOption.click();
		UtilHBM.waitFixTime(3000);
		String currentDate = UtilHBM.getDate(0, "MMM dd, yyyy");
		String nextDate = UtilHBM.getDate(1, "MMM dd, yyyy");
		String from = currentDate + ", 12:00:00 AM";
		String to = nextDate + ", 12:00:00 AM";
		filters.click();
		deliveredAtFilter.click();
		filters.click();
		deliveredAtFrom.clear();
		deliveredAtFrom.sendKeys(from);
		deliveredAtTo.clear();
		deliveredAtTo.sendKeys(to);
		filterButton.click();
		return this;
	}

	public BONewFP validateMails(String user, String mailPurpose, int expectedNoOfMails) {
		String templateName = null;
		switch (mailPurpose) {
		case "HQ Render ready":
			templateName = "render.ready";
			break;
		case "360 Render ready":
			templateName = "render360.ready";
			break;
		case "Floorplan payment confirmation":
			templateName = "floor-plan.payment-confirmation";
			break;
		case "Floorplan validation":
			templateName = "floor-plan.validation";
			break;
		case "Floorplan rejection":
			templateName = "floor-plan.rejection";
			break;
		case "Floorplan review needed":
			templateName = "floor-plan.review-needed";
			break;
		case "Floorplan delivery":
			templateName = "floor-plan.delivery";
			break;
		case "Design coaching payment confirmation":
			templateName = "design-coaching.payment-confirmation";
			break;
		case "Design coaching validation":
			templateName = "design-coaching.validation";
			break;
		case "Design coaching review needed":
			templateName = "design-coaching.review-needed";
			break;
		case "Design coaching delivery":
			templateName = "design-coaching.delivery";
			break;
		case "Project comment and like":
			templateName = "project.comment.like";
			break;
		case "Project buy more":
			templateName = "project.buy-more";
			break;
		case "HMS payment confirmation":
			templateName = "home-measure.payment-confirmation";
			break;
		case "HMS delivery":
			templateName = "home-measure.delivery";
			break;
		case "HMS reminder":
			templateName = "home-measure.reminder";
			break;
		case "Password reset":
			templateName = "security.password-reset";
			break;
		case "Password change":
			templateName = "security.password-change";
			break;
		case "Floorplan abamdoned cart":
			templateName = "floor-plan.abandoned-cart";
			break;
		case "Design coaching abamdoned cart":
			templateName = "welcome";
			break;
		case "Partner welcome":
			templateName = "partnership.welcome";
			break;
		case "Partner optout":
			templateName = "partnership.optout";
			break;
		case "Friendship incentive":
			templateName = "friendship.incentive";
			break;
		case "Friendship gift":
			templateName = "friendship.gift";
			break;
		default:
			UtilHBM.reportInfo("Incorrect mail template");
			break;
		}

		List<WebElement> resultsDisplayed = driver.findElements(By.xpath(
				"//table[@class='table table-bordered table-striped table-hover sonata-ba-list']/tbody/tr/td[2][normalize-space()='"
						+ templateName + "']/../td[4]/a[normalize-space()='" + user + "']/../.."));
		int resultCount = resultsDisplayed.size();
		if (resultCount == expectedNoOfMails) {
			UtilHBM.reportOK("Correct no. of mails displayed");
		} else {
			UtilHBM.reportKO("Incorrect no. of mails displayed for " + mailPurpose + ".Expected no. of mails : "
					+ expectedNoOfMails + " ,No. of mails available : " + resultCount);
		}

		for (WebElement a : resultsDisplayed) {
			Verification.displayOfWebElement(a.findElement(By.xpath("td[1]/a")));
			Verification.VerifyEquals("Wrong mail purpose", a.findElement(By.xpath("td[2]")).getText(), templateName);
			Verification.displayOfWebElement(a.findElement(By.xpath("td[3]")));
			Verification.VerifyEquals("Wrong user", a.findElement(By.xpath("td[4]/a")).getText(), user);
			Verification.VerifyEquals("Status is not equal to delivered",
					a.findElement(By.xpath("td[5]/span")).getText(), "Delivered");
			Verification.elementContainsString(a.findElement(By.xpath("td[6]/time")),
					UtilHBM.getDate(0, "MMMM dd, yyyy"), "Mail queued at");
		}
		return this;
	}
}
	
	
