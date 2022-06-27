package kitchen.bryo.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}


	@FindBy(css = ".cardProduct-thumb")
	private List<WebElement> kitcheckStyle;

	@FindBy(css = "a[href='./collection-paris.html']>span")
	private WebElement discoverButton;

	@FindBy(css = "figcaption>a[data-ui-link='to-need-mapping']")
	private WebElement startKitchenDesignButton;

	@FindBy(css = "img[src='../media/img/collection/paris/collection-4-496.jpg']~button.cta-primary")
	private WebElement openParisCollectionDesignBtn;


	/*
	@FindBy(css="#access-code")
	private WebElement accessCode;
	
	@FindBy(css=".locale-switch-box>button[data-locale='en-GB']")
	private WebElement startGBDemo;
*/
	public StylePage selectStyle(int styleIndex) {
		UtilHBM.waitExplicitClickable(driver, kitcheckStyle.get(styleIndex));
		kitcheckStyle.get(styleIndex).click();
		return PageFactory.initElements(driver, StylePage.class);
	}

	public StylePage startKitchenDesign() {
//		UtilHBM.waitTillElementDisappear(driver, "");
		/*
		UtilHBM.waitExplicitDisplayed(driver, accessCode);
		accessCode.sendKeys("Next!Gen01");
		startGBDemo.click();
		*/
//		StartNow start=PageFactory.initElements(driver, StartNow.class);
//		start.startDemo("en-GB");
		clickDiscover();
		startKitchenDesignButton.click();
		return PageFactory.initElements(driver, StylePage.class);
	}

	public HomePage clickDiscover() {
//		StartNow start=PageFactory.initElements(driver, StartNow.class);
//		start.startDemo("en-GB");
		UtilHBM.waitExplicitDisplayed(driver, discoverButton);
		UtilHBM.waitExplicitClickable(driver, discoverButton);
		discoverButton.click();
		return PageFactory.initElements(driver, HomePage.class);
	}

	public MakeItYours openPariCollectionDesign(){
		UtilHBM.waitExplicitDisplayed(driver, openParisCollectionDesignBtn);
		UtilHBM.waitExplicitClickable(driver, openParisCollectionDesignBtn);
		openParisCollectionDesignBtn.click();
		UtilHBM.waitFixTime(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src*='kitchen.enterprise']")));
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, MakeItYours.class);
	}
	
//	<************************MOBILE METHODS*****************************>
	public StylePage startKitchenDesignMobile() {
//		UtilHBM.waitTillElementDisappear(driver, "");
		/*
		UtilHBM.waitExplicitDisplayed(driver, accessCode);
		accessCode.sendKeys("Next!Gen01");
		startGBDemo.click();
		*/
//		StartNow start=PageFactory.initElements(driver, StartNow.class);
//		start.startDemo("en-GB");
		clickDiscover();
		startKitchenDesignButton.click();
		return PageFactory.initElements(driver, StylePage.class);
	}
}
