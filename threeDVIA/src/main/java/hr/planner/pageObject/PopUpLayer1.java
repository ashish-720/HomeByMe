package hr.planner.pageObject;

import java.util.ArrayList;
import java.util.List;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import hr.web.pageObject.MyPictureNTwoDPlan;
import hr.web.pageObject.ProjectOverview;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopUpLayer1 {
	WebDriver driver;
	public PopUpLayer1(WebDriver driver){
		this.driver = driver;
		
	}
	
//	@FindBy(css = "[data-ui-selector='share-bubble']>div>ul>li>button")
//	List<WebElement> share;

	@FindBy(xpath = "//div[@data-ui-selector='share-bubble']/div/ul/li/button//span[.='Facebook']/parent::button")
	private WebElement facebook;
	
	@FindBy(xpath = "//div[@data-ui-selector='share-bubble']/div/ul/li/button//span[.='Twitter']/parent::button")
	private WebElement twitter;
	
	@FindBy(xpath = "//div[@data-ui-selector='share-bubble']/div/ul/li/button//span[.='Pinterest']/parent::button")
	private WebElement pinterest;
	
	@FindBy(xpath = "//div[@data-ui-selector='share-bubble']/div/ul/li/button//span[.='Embed']/parent::button")
	private WebElement embed;
	
	@FindBy(xpath = "//div[@data-ui-selector='share-bubble']/div/ul/li/button//span[.='Mail']/parent::button")
	private WebElement mail;
	
	@FindBy(css = "[data-ui-selector='share-section']>div>ul>li>button>.icon-share-facebook")
	private WebElement facebookPS;
	
	@FindBy(css = "[data-ui-selector='share-section']>div>ul>li>button>.icon-share-twitter")
	private WebElement twitterPS;
	
	@FindBy(css = "[data-ui-selector='share-section']>div>ul>li>button>.icon-share-pinterest")
	private WebElement pinterestPS;
	
	@FindBy(css = "[data-ui-selector='share-section']>div>ul>li>button>.icon-action-embed")
	private WebElement embedPS;
	
	@FindBy(css = "[data-ui-selector='share-section']>div>ul>li>button>.icon-share-mail")
	private WebElement mailPS;
	
	@FindBy(css = "[data-ui-selector='share-project-bubble']>div>ul>li>button>.icon-share-facebook")
	private WebElement facebookPrjPage;
	
	@FindBy(css = "[data-ui-selector='share-project-bubble']>div>ul>li>button>.icon-share-twitter")
	private WebElement twitterPrjPage;
	
	@FindBy(css = "[data-ui-selector='share-project-bubble']>div>ul>li>button>.icon-share-pinterest")
	private WebElement pinterestPrjPage;
	
	@FindBy(css = "[data-ui-selector='share-project-bubble']>div>ul>li>button>.icon-action-embed")
	private WebElement embedPrjPage;
	
	@FindBy(css = "[data-ui-selector='share-project-bubble']>div>ul>li>button>.icon-share-mail")
	private WebElement mailPrjPage;
	
//	@FindBy(css = "#copy-link-product-simple")
//	private WebElement copyLink;
	
	@FindBy(css = ".mod-copy-input>#copy-link-product-simple+button[data-ui-action='copy-link']")
	private WebElement copyLink;
	
	@FindBy(css = ".mod-bubble-action.mod-open.position-bottom-center [data-ui-action='copy-link']")
	private WebElement copyLinkPrjPage;
	

	@FindBy(xpath = "//*[contains(@class, 'mod-open')]//span[text()='Facebook']")
	private WebElement fbText;
	
	@FindBy(xpath = "//*[contains(@class, 'mod-open')]//span[text()='Twitter']")
	private WebElement twitterText;
	
	@FindBy(xpath = "//*[contains(@class, 'mod-open')]//span[text()='Pinterest']")
	private WebElement pinterestText;
	
	@FindBy(xpath = "//*[contains(@class, 'mod-open')]//span[text()='Embed']")
	private WebElement embedText;
	
	@FindBy(xpath = "//*[contains(@class, 'mod-open')]//span[text()='Mail']")
	private WebElement mailText;
	
	public PopUpLayer1 facebook(){		
		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElementXPath(driver, "//span[text()='Share this media']"));	
		UtilHBM.waitExplicitClickable(driver, facebook);
		WebElement icon = facebook.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(facebook, "Facebook command", "text", "Facebook");
		Verification.displayNAttributeCheckOfElement(icon, "Facebook command icon", "xlink:href", "/Shared/icons/icons.svg#icon-share-facebook");
		return PageFactory.initElements(driver, PopUpLayer1.class);
	}
	
	public PopUpLayer1 facebookPS(){
		
		UtilHBM.waitExplicitClickable(driver, facebookPS);
		WebElement icon = facebookPS.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(icon, "Facebook command icon", "xlink:href", "/Shared/icons/icons.svg#icon-share-facebook");
		Verification.displayNAttributeCheckOfElement(fbText, "Facebook command", "text", "Facebook");
		
		return PageFactory.initElements(driver, PopUpLayer1.class);
	}
	
	public PopUpLayer1 facebookPrjPage(){
			
			UtilHBM.waitExplicitDisplayed(driver, fbText);
			WebElement icon = facebookPrjPage.findElement(By.cssSelector("svg>use"));
			Verification.displayNAttributeCheckOfElement(icon, "Facebook command icon", "xlink:href", "../Shared/icons/icons.svg#icon-share-facebook");
			Verification.displayNAttributeCheckOfElement(fbText, "Facebook command", "text", "Facebook");
			
			return PageFactory.initElements(driver, PopUpLayer1.class);
		}
	
	public PopUpLayer1 twitter(){

		UtilHBM.waitExplicitClickable(driver, twitter);
		WebElement icon = twitter.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(twitter, "Twitter command", "text", "Twitter");
		Verification.displayNAttributeCheckOfElement(icon, "Twitter command icon", "xlink:href", "/Shared/icons/icons.svg#icon-share-twitter");
		return PageFactory.initElements(driver, PopUpLayer1.class);
		}
	
	public PopUpLayer1 twitterPS(){

		UtilHBM.waitExplicitClickable(driver, twitterPS);
		WebElement icon = twitterPS.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(twitterText, "Twitter command", "text", "Twitter");
		Verification.displayNAttributeCheckOfElement(icon, "Twitter command icon", "xlink:href", "/Shared/icons/icons.svg#icon-share-twitter");
		return PageFactory.initElements(driver, PopUpLayer1.class);
		}
	
	public PopUpLayer1 twitterPrjPage(){

		UtilHBM.waitExplicitDisplayed(driver, twitterText);
		WebElement icon = twitterPrjPage.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(twitterText, "Twitter command", "text", "Twitter");
		Verification.displayNAttributeCheckOfElement(icon, "Twitter command icon", "xlink:href", "../Shared/icons/icons.svg#icon-share-twitter");
		return PageFactory.initElements(driver, PopUpLayer1.class);
		}
	
	public PopUpLayer1 pinterest(){

		UtilHBM.waitExplicitClickable(driver, pinterest);
		WebElement icon = pinterest.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(pinterest, "pinterest command", "text", "Pinterest");
		Verification.displayNAttributeCheckOfElement(icon, "pinterest command icon", "xlink:href", "/Shared/icons/icons.svg#icon-share-pinterest");
		return PageFactory.initElements(driver, PopUpLayer1.class);
		}
	
	public PopUpLayer1 pinterestPS(){

		UtilHBM.waitExplicitClickable(driver, pinterestPS);
		WebElement icon = pinterestPS.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(pinterestText, "pinterest command", "text", "Pinterest");
		Verification.displayNAttributeCheckOfElement(icon, "pinterest command icon", "xlink:href", "/Shared/icons/icons.svg#icon-share-pinterest");
		return PageFactory.initElements(driver, PopUpLayer1.class);
		}
	
	public PopUpLayer1 pinterestPrjPage(){

		UtilHBM.waitExplicitDisplayed(driver, pinterestText);
		WebElement icon = pinterestPrjPage.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(pinterestText, "pinterest command", "text", "Pinterest");
		Verification.displayNAttributeCheckOfElement(icon, "pinterest command icon", "xlink:href", "../Shared/icons/icons.svg#icon-share-pinterest");
		return PageFactory.initElements(driver, PopUpLayer1.class);
		}
	
	public PopUpLayer1 embed(){

		UtilHBM.waitExplicitClickable(driver, embed);
		WebElement icon = embed.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(embed, "embed command", "text", "Embed");
		Verification.displayNAttributeCheckOfElement(icon, "embed command icon", "xlink:href", "/Shared/icons/icons.svg#icon-action-embed");
		return PageFactory.initElements(driver, PopUpLayer1.class);
		}
	
	public PopUpLayer1 embedPS(){

		UtilHBM.waitExplicitClickable(driver, embedPS);
		WebElement icon = embedPS.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(embedText, "embed command", "text", "Embed");
		Verification.displayNAttributeCheckOfElement(icon, "embed command icon", "xlink:href", "/Shared/icons/icons.svg#icon-action-embed");
		return PageFactory.initElements(driver, PopUpLayer1.class);
		}
	
	public PopUpLayer1 embedPrjPage(){

		UtilHBM.waitExplicitDisplayed(driver, embedText);
		WebElement icon = embedPrjPage.findElement(By.cssSelector("svg>use"));
		Verification.displayNAttributeCheckOfElement(embedText, "embed command", "text", "Embed");
		Verification.displayNAttributeCheckOfElement(icon, "embed command icon", "xlink:href", "../Shared/icons/icons.svg#icon-action-embed");
		return PageFactory.initElements(driver, PopUpLayer1.class);
		}
	
	public PopUpLayer1 mail(){

		UtilHBM.waitExplicitClickable(driver, mail);
		WebElement icon = mail.findElement(By.cssSelector(".icon-share-mail>use"));
		Verification.displayNAttributeCheckOfElement(mail, "mail command", "text", "Mail");
		Verification.displayNAttributeCheckOfElement(icon, "mail command icon", "xlink:href", "/Shared/icons/icons.svg#icon-share-mail");
		return PageFactory.initElements(driver, PopUpLayer1.class);
		}
	
	public PopUpLayer1 mailPS(){

		UtilHBM.waitExplicitClickable(driver, mailPS);
		WebElement icon = mailPS.findElement(By.cssSelector(".icon-share-mail>use"));
		Verification.displayNAttributeCheckOfElement(mailText, "mail command", "text", "Mail");
		Verification.displayNAttributeCheckOfElement(icon, "mail command icon", "xlink:href", "/Shared/icons/icons.svg#icon-share-mail");
		return PageFactory.initElements(driver, PopUpLayer1.class);
		}
	
	public PopUpLayer1 mailPrjPage(){

		UtilHBM.waitExplicitDisplayed(driver, mailText);
		WebElement icon = mailPrjPage.findElement(By.cssSelector(".icon-share-mail>use"));
		Verification.displayNAttributeCheckOfElement(mailText, "mail command", "text", "Mail");
		Verification.displayNAttributeCheckOfElement(icon, "mail command icon", "xlink:href", "../Shared/icons/icons.svg#icon-share-mail");
		return PageFactory.initElements(driver, PopUpLayer1.class);
		}
	
	public ProjectOverview copyLInk(){

		copyLink.click();
		//paste this url in new window
		
//		String url = copyLink.getAttribute("value");
		
		
//		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
//		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//		driver.switchTo().window(tabs.get(1));
		
//		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
//		driver.findElement(By.linkText(url)).sendKeys(selectLinkOpeninNewTab);
		
		
//		driver.get(url);
//		driver.navigate().back();
//		UtilHBM.waitFixTime(1000);
//		driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src*='https://preprod-widgets.enterprise-dev.by.me/ProjectOverviewView/fullpage.html']"));
//		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, ProjectOverview.class);
		}
	
	public ProjectOverview copyLInkPrjPage(){

		copyLinkPrjPage.click();
		//paste this url in new window
		
//		String url = copyLink.getAttribute("value");
		
		
//		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
//		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//		driver.switchTo().window(tabs.get(1));
		
//		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
//		driver.findElement(By.linkText(url)).sendKeys(selectLinkOpeninNewTab);
		
		
//		driver.get(url);
//		driver.navigate().back();
//		UtilHBM.waitFixTime(1000);
//		driver.switchTo().frame(UtilHBM.webElement(driver, "iframe[src*='https://preprod-widgets.enterprise-dev.by.me/ProjectOverviewView/fullpage.html']"));
//		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, ProjectOverview.class);
		}
	
	
	}
