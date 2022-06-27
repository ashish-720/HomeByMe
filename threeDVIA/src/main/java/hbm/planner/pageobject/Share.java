package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Share {
	
	WebDriver driver;
	
	public Share(WebDriver driver) {
		 this.driver = driver;
	}
	
	@FindBy(css=".mod-sublayer-media-share.mod-open>header>h4")
	private WebElement title;
	
	@FindBy(css=".mod-sublayer-media-share.mod-open>.content>img[src*='https://byme']")
	private WebElement image;
	
	@FindBy(css=".content>.mod-social-sharing>li>button[data-ui-id='facebook']")
	private WebElement facebook;
	
	@FindBy(css=".content>.mod-social-sharing>li>button[data-ui-id='twitter']")
	private WebElement twitter;
	
	@FindBy(css=".content>.mod-social-sharing>li>button[data-ui-id='pinterest']")
	private WebElement pinterest;
	
	@FindBy(css=".content>.mod-social-sharing>li>button[data-ui-id='mail']")
	private WebElement mail;
	
	@FindBy(css=".content>.mod-copy-input>input")
	private WebElement linkTextBox;
	
	@FindBy(css=".content>.mod-copy-input>button")
	private WebElement copyBtn;
	
	@FindBy(css=".mod-sublayer-media-share.mod-open>footer>button.cta-secondary-l")
	private WebElement cancelBtn;
	
	protected MyImages verifyShare(String img, String mediaType){
		WebElement copyIcon= copyBtn.findElement(By.cssSelector(".icon-container.mod-tooltip-bottom"));
		UtilHBM.waitExplicitDisplayed(driver, image);
		String imgThumb=image.getAttribute("src").split("_")[0];
		Verification.VerifyEquals("Image in Share page is not same as image to be shared", imgThumb, img);
		Verification.displayNAttributeCheckOfElement(title, "Share Page Title", "text", "Share this media");
		Verification.displayOfWebElement(facebook);
		Verification.displayOfWebElement(twitter);
		Verification.displayOfWebElement(pinterest);
		Verification.displayOfWebElement(mail);	
		String link = linkTextBox.getAttribute("value");		
		if(mediaType.equalsIgnoreCase("snapshot")){
			Verification.VerifyEquals("Image link in copy field is not same as image displayed", image.getAttribute("src"), link);
		}
		if(mediaType.startsWith("real")){
			link=link.replace(".jpg", "_960_540.jpg");
			Verification.VerifyEquals("Image link in copy field is not same as image displayed", image.getAttribute("src"), link);
		}
		if(mediaType.equalsIgnoreCase("360")){
			link=link.replace("/vtour/tour.xml", "_960_540.jpg");
		}
		copyIcon.click();
		UtilHBM.waitFixTime(500);
		Verification.VerifyEquals("Copy icon in share not changed after click", copyIcon.getAttribute("aria-hidden"), "true");
		UtilHBM.waitFixTime(4000);
		Verification.VerifyEquals("Copy icon in share not changed after click", copyIcon.getAttribute("aria-hidden"), "false");
		cancelBtn.click();
		return PageFactory.initElements(driver, MyImages.class);
	}

}
