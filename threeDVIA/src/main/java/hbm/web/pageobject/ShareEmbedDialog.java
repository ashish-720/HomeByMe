package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class ShareEmbedDialog {
	WebDriver driver;
	
	public ShareEmbedDialog(WebDriver driver) {
		 this.driver=driver;
	}
	
	@FindBy(xpath="//div[@class='sharing-container']/div[not(@style ='display: none;')]/form/section/div/div/label[@for='embed_width']")
	private WebElement widthText;

	@FindBy(id="embed_width")
	private WebElement widthInputField;

	@FindBy(xpath="//div[@class='sharing-container']/div[not(@style ='display: none;')]/form/section/div/div/label[@for='embed_height']")
	private WebElement heightText;

	@FindBy(id="embed_height")
	private WebElement heightInputField;

	@FindBy(xpath="//div[@class='sharing-container']/div[not(@style ='display: none;')]/h2")
	private WebElement shareContainerHeader;
	
	@FindBy(xpath="//textarea[@id='codeIframe']")
	private WebElement textArea;
	
	@FindBy(xpath="//div[@class='sharing-container']/div[not(@style ='display: none;')]/form/div/a[@class='button--alt u-mrxs']")
	private WebElement cancelButton;
	
	@FindBy(xpath="//div[@class='sharing-container']/div[not(@style ='display: none;')]/form/div/a[@class='button']")
	private WebElement copyButton;
	
	@FindBy(xpath="//div[@class='modal current']/div/div[@class='modal-header']/div/img[1]")
	private WebElement mdmEmbedLogo1;
	
	@FindBy(xpath="//div[@class='modal current']/div/div[@class='modal-header']/div/img[2]")
	private WebElement mdmEmbedLogo2;
	
	@FindBy(xpath="//div[@class='modal current']/div/div[@class='modal-inner']/p")
	private WebElement mdmEmbedText1;
	
	@FindBy(xpath="//div[@class='modal current']/div/div[@class='modal-inner']/div[@class='form-item-field']/div/div/button[@class='button']")
	private WebElement mdmEmbedCopy;
	
	@FindBy(xpath="//div[@class='modal current']/a[@class='close-modal button-close']")
	private WebElement mdmEmbedClose;
	
	public ShareContainer verifyEmbedProject() {
		UtilHBM.waitExplicitDisplayed(driver, shareContainerHeader);
		Verification.VerifyEquals("Incorrect shareContainerHeader", shareContainerHeader.getText(),"Embed this project");
		Verification.VerifyEquals("Wrong field name for Width",widthText.getText(),"Width");
		Verification.VerifyEquals("Wrong initial input value for widthInputField", widthInputField.getAttribute("value"), "800");
		widthInputField.clear();
		widthInputField.sendKeys("1000");
		Verification.VerifyEquals("Wrong field name for Height",heightText.getText(),"Height");
		Verification.VerifyEquals("Wrong initial input value for heightInputField", heightInputField.getAttribute("value"), "600");
		heightInputField.clear();
		heightInputField.sendKeys("800");
		Verification.displayOfWebElement(copyButton);
		UtilHBM.waitExplicitClickable(driver, copyButton);
		String textAreaValue = textArea.getAttribute("value");
		if (textAreaValue.contains("width=\"1000\" height=\"800\"")) {
			UtilHBM.reportOK("Embedded link modifications OK");
		} else {
			UtilHBM.reportKO("Embedded link modifications failed!!Expected contains text : width=\"1000\" height=\"800\" Actual Value : "+ textAreaValue);
		}
		Verification.displayOfWebElement(cancelButton);
		clickCancelButton();
		return PageFactory.initElements(driver, ShareContainer.class);
	}

	ShareContainer clickCancelButton() {
		UtilHBM.waitExplicitClickable(driver, cancelButton);
		cancelButton.click();
		return PageFactory.initElements(driver, ShareContainer.class);
	}
	
	
	public ProjectPage verifyEmbedProjectMDM() {
		UtilHBM.waitExplicitDisplayed(driver, mdmEmbedText1);
		Verification.displayNAttributeCheckOfElement(mdmEmbedLogo1, "mdmEmbedLogo1", "src","https://d31ax5swi3lxrl.cloudfront.net/dist/images/logotype-hbm.0b4ec956686490e146e4.svg");
		Verification.displayNAttributeCheckOfElement(mdmEmbedLogo2, "mdmEmbedLogo2", "src","https://byme.s3-eu-west-1.amazonaws.com/data/brands/logos/14/default.png");
		Verification.VerifyEquals("Wrong mdmEmbedText1", mdmEmbedText1.getText(),"Use this code to embed a live version of your project");
		UtilHBM.waitExplicitDisplayed(driver, textArea);
		String link = textArea.getText();
		Verification.displayOfWebElement(mdmEmbedCopy);
		UtilHBM.waitExplicitClickable(driver, mdmEmbedCopy);
		String copiedLink = link.substring(link.indexOf("h", 2), (link.indexOf("embed", 10) + 5));
		String currentLink = driver.getCurrentUrl();
		if (copiedLink.contains(currentLink)) {
			UtilHBM.reportOK("Embed Link verification Success");
		} else {
			UtilHBM.reportKO("Embed Link verification Failed!!!Expected Value : " + copiedLink + ",Actual value : " + currentLink);
		}
		mdmEmbedClose.click();
		return PageFactory.initElements(driver, ProjectPage.class);
		
	}
	
}
