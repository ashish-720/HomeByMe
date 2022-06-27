package kitchen.threeDCloudByMe.pageObject;

import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Templates {

	WebDriver driver;

	public Templates(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css="#template_names_values_en")
	WebElement templateNameInput;
	
	@FindBy(css="#template_reference")
	WebElement tempRefInput;

	@FindBy(css="#template_brand")
	WebElement tempBrand;

	@FindBy(css="#template_shortDescriptions_values_en")
	WebElement shortDescInput;
	
	@FindBy(css="#template_descriptions_values_en")
	WebElement commDescInput;
	
	@FindBy(css="div.bootstrap-tagsinput>input[placeholder='Add free tags']")
	WebElement freeTagsInput;
	
	@FindBy(css="#template_technicalComment")
	WebElement notesInput;
	
	@FindBy(css="#btnSubmitForm")
	WebElement saveButton;
	
	@FindBy(css="a[title='Templates']")
	WebElement backButton;

	@FindBy(css=".footer-fixed>.mod-notification>p.success.show")
	WebElement successMsg;

	@FindBy(css=".footer-fixed>.mod-notification>p.error.show")
	WebElement errorMsg;

	@FindBy(css="label[for='template_file']")
	WebElement uploadButtonText;
	
	@FindBy(css="span.js-upload-file.upload-file-placeholder.u-mtxs")
	WebElement pageHeader14;
	
	@FindBy(css="#template_file")
	WebElement uploadTemplate;
	
	@FindBy(css="div.steps>div[data-step='template']")
	WebElement templateButton;

	@FindBy(xpath="//div[contains(@class,'steps-content') and @data-step='template']/div[contains(@class, 'form-group')]/p[text()='TEMPLATE FILE INFORMATIONS:']/following-sibling::div")
	WebElement templateFileInfo;

	@FindBy(xpath="//div[contains(@class,'steps-content') and @data-step='template']/div[contains(@class, 'form-group')]/p[text()='TEMPLATE FILE INFORMATIONS:']/following-sibling::div/a[text()='Download template file']")
	WebElement downloadTemplateFileLink;

	public Content createTemplate(String templateName, String brand)
	{
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date date=new Date();
		String s=dateFormat.format(date);
		templateNameInput.sendKeys(templateName+"_"+s);
		tempRefInput.sendKeys(templateName+"_"+s);
		(new Select(tempBrand)).selectByVisibleText(brand);
		shortDescInput.sendKeys("Short_description_"+templateName+"_"+s);
		commDescInput.sendKeys("Commencial_desc_"+templateName+"_"+s);
		freeTagsInput.sendKeys("Free_tags1"+templateName+s);
		notesInput.sendKeys(templateName+"_"+s);
		clickTemplateButton();
		uploadTemplate.sendKeys(new File(Setting.threeDCloudData + "Template" + "/"+templateName+".BMTPROJ").getAbsolutePath());
		UtilHBM.waitFixTime(2000);
		Verification.VerifyEquals("Template upload unsuccessful", UtilHBM.webElement(driver, ".js-upload-file.upload-file-placeholder.u-mtxs").getText(), templateName+".BMTPROJ");
		clickSaveButton()
		.verifyUploadedTemplateFileInfo()
		.clickBackButton();
		return PageFactory.initElements(driver, Content.class);
	}
	
	Templates clickTemplateButton()
	{
		templateButton.click();
		return this;
	}
	
	public Templates clickSaveButton()
	{
		UtilHBM.waitFixTime(1000);
		saveButton.click();
		UtilHBM.waitExplicitDisplayed(driver, successMsg);
		UtilHBM.reportOK(successMsg.getText());
		return this;
	}
	 
	Content clickBackButton()
	{
		backButton.click();
		return PageFactory.initElements(driver, Content.class);
	}

	public Templates updateTemplateName(String name, String operation) {
		UtilHBM.waitExplicitDisplayed(driver,templateNameInput);
		switch (operation.toUpperCase()) {
			case "APPEND":
				String currentName = templateNameInput.getAttribute("value");
				templateNameInput.clear();
				templateNameInput.sendKeys(currentName + name + Keys.ENTER);
				break;

			case "MODIFY":
			default:
				templateNameInput.clear();
				templateNameInput.sendKeys(name + Keys.ENTER);
		}
		return this;
	}

	public Templates templateNameVerify(String templateName)
	{
		Verification.VerifyEquals("Product Name incorrect", templateNameInput.getAttribute("value"), templateName);
		return PageFactory.initElements(driver, Templates.class);
	}

	public Templates uploadTemplate(String templateFile){
		clickTemplateButton();
		uploadTemplate.sendKeys(new File(Setting.threeDCloudData + "Template" + "/"+templateFile+".BMTPROJ").getAbsolutePath());
		UtilHBM.waitFixTime(2000);
		Verification.VerifyEquals("Template upload unsuccessful", UtilHBM.webElement(driver, ".js-upload-file.upload-file-placeholder.u-mtxs").getText(), templateFile+".BMTPROJ");
		clickSaveButton();
		return PageFactory.initElements(driver, Templates.class);
	}

	public Templates verifyUploadedTemplateFileInfo() {
		clickTemplateButton();
		UtilHBM.waitExplicitDisplayed(driver, templateFileInfo);

		//Verify Upload date information displayed correctly
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date currentDateTime = new Date();

		String actualText = UtilHBM.getTextMatchingPattern("Last upload date: " + "\\d{4}-\\d{2}-\\d{2}" + "T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}Z", templateFileInfo.getText());
		if (actualText == null)
			UtilHBM.reportKO("Upload date/time format not correct");
		else {
			String displayedDateTime = UtilHBM.getTextMatchingPattern("\\d{4}-\\d{2}-\\d{2}" + "T\\d{2}:\\d{2}:\\d{2}", actualText);
			Date uploadDateTime = null;
			try {
				uploadDateTime = dateFormat.parse(displayedDateTime);
			} catch (ParseException e) {
			}
			if (uploadDateTime == null) UtilHBM.reportKO("Unable to parse displayed Date ");

			int differenceInMins = (int) ((currentDateTime.getTime() - uploadDateTime.getTime()) / (1000 * 60));
			if (differenceInMins >= 0 && differenceInMins <=1)
				UtilHBM.reportOK("Upload date & time displayed  correctly");
			else
				UtilHBM.reportKO("Upload date & time not correct, Displayed date/time : " + displayedDateTime + " , current date/time : " + dateFormat.format(currentDateTime) + ", Difference is " + differenceInMins + " mins");
		}

		//Verify Download link works correctly
		String fileName = tempRefInput.getAttribute("value") + ".BMTPROJ";
		File file=new File(System.getProperty("user.home") + "\\Downloads\\" + fileName);
		if(file.exists())file.delete();

		for (int tryCount = 0; tryCount < 5; tryCount++) {
			downloadTemplateFileLink.click();
			UtilHBM.waitFixTime(7000);
			if (new File(System.getProperty("user.home") + "\\Downloads\\" + fileName).exists()) {
				UtilHBM.reportOK("File : " + fileName + " downloaded successfully");
				break;
			}
			if (tryCount == 4) UtilHBM.reportKO("File : " + fileName + " couldn't be downloaded");
		}

		return PageFactory.initElements(driver, Templates.class);
	}
}
