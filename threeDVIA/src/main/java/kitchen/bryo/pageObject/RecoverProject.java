package kitchen.bryo.pageObject;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class RecoverProject {

	WebDriver driver;

	public RecoverProject(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//article[@class='mod-popin-backup-recovery-small mod-open']/div/div/h1")
	private WebElement recoverTitle;

	@FindBy(xpath = "//article[@class='mod-popin-backup-recovery-small mod-open']/div/div/div[@class='text']/div/p")
	private WebElement recoverInfo;

	@FindBy(xpath = "//article[@class='mod-popin-backup-recovery-small mod-open']/div/footer/button[@data-ui-action='primary-button-action']")
	private WebElement recoverProjectYes;

	@FindBy(xpath = "//article[@class='mod-popin-backup-recovery-small mod-open']/div/footer/button[@data-ui-action='secondary-button-action']")
	private WebElement recoverProjectNo;

//	public MakeItYours recoverProject(String yesOrNo) {
//
//		verifyRecoverProjectPopUp();
//		if (yesOrNo.equalsIgnoreCase("yes")) {
//			recoverProjectYes.click();
//		} else {
//			recoverProjectNo.click();
//		}
//
//		return PageFactory.initElements(driver, MakeItYours.class);
//	}
//
//	public MakeItYours verifyRecoverProjectPopUp() {
//		String titleText = "Recover project";
//		String message = "Would you like to continue with this project?";
//
//		Verification.displayNAttributeCheckOfElement(recoverTitle, "Recover Project Title", "text", titleText);
//		Verification.displayNAttributeCheckOfElement(recoverInfo, "Recover Project Message", "text", message);
//		return PageFactory.initElements(driver, MakeItYours.class);
//	}

	public MakeItYours recoverProject(String yesOrNo) {
		String titleText = "Recover project";
//		String message = "Would you like to continue with this project?";
		if (recoverInfo.getText().contains("minute") || recoverInfo.getText().contains(":")) {
			UtilHBM.reportOK("Recover project info contains recovery time and message displayed is : "+recoverInfo.getText());
		} else {
			UtilHBM.reportKO("Recover project info does not show recovery time and message displayed is : "+recoverInfo.getText());
		}
		Verification.displayNAttributeCheckOfElement(recoverTitle, "Recover Project Title", "text", titleText);
//		Verification.displayNAttributeCheckOfElement(recoverInfo, "Recover Project Message", "text", message);

		if (yesOrNo.equalsIgnoreCase("yes")) {
			recoverProjectYes.click();
		} else {
			System.out.println("text : " + recoverProjectNo.getText());
			if (recoverProjectNo.getText().equalsIgnoreCase("Start from scratch")) {
				Verification.displayOfWebElement(
						recoverProjectNo.findElement(By.xpath("span[contains(text(),'Start from scratch')]")));
			} else {
				Verification.displayOfWebElement(
						recoverProjectNo.findElement(By.xpath("span[contains(text(),'Open last saved')]")));
			}
			recoverProjectNo.click();
		}

		return PageFactory.initElements(driver, MakeItYours.class);
	}

}
