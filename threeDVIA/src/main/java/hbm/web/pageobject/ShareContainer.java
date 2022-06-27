package hbm.web.pageobject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShareContainer {
WebDriver driver;

@FindBy(css="body>img[src*='https:']")
private WebElement shareImage;

@FindBy(xpath="//div[@class='sharing-toolbox']/div/button[@data-tooltip='Copy']")
private WebElement copyToClipboardButton;

@FindBy(id="copy-link")
private WebElement copyToClipboardInput;

@FindBy(id="image-link")
private WebElement copyToClipboardUserPrd;

@FindBy(css=".at-expanded-menu-page-title")
private WebElement emailProjectTitle;

@FindBy(css=".at-expanded-menu-page-url")
private WebElement emailProjectURL;

@FindBy(id="at-expanded-menu-title")
private WebElement emailAFriendTitle;

@FindBy(xpath="//div[@class='sharing-container']/div[not(@style ='display: none;')]/h2")
private WebElement shareContainerHeader;

@FindBy(xpath="//div[@class='ReactModalPortal']/div/div[not(@style ='display: none;')]/h2")
private WebElement shareContainerHeaderUserPrd;

@FindBy(xpath="//div[@class='sharing-container']/div[not(@style ='display: none;')]/div[@class='modal-close button-close']")
private WebElement shareContainerClose;

@FindBy(xpath="//div[@class='modal-close button-close']")
private WebElement shareProductContainerClose;

@FindBy(xpath="//div[@class='sharing-container']/div[not(@style ='display: none;')]/div[@class='sharing-toolbox']/ul/li/a[@class='addthis_button_facebook']")
private WebElement facebookShare;

@FindBy(xpath="//div[@class='sharing-container']/div[not(@style ='display: none;')]/div[@class='sharing-toolbox']/ul/li/a[@class='addthis_button_pinterest_share']")
private WebElement pinterestShare;

@FindBy(xpath="//div[@class='sharing-container']/div[not(@style ='display: none;')]/div[@class='sharing-toolbox']/ul/li/a[@class='addthis_button_twitter']")
private WebElement twitterShare;

@FindBy(xpath="//div[@class='sharing-container']/div[not(@style ='display: none;')]/div[@class='sharing-toolbox']/ul/li/a[@class='addthis_button_whatsapp']")
private WebElement whatsappShare;

@FindBy(xpath="//div[@class='sharing-container']/div[not(@style ='display: none;')]/div[@class='sharing-toolbox']/ul/li/a[@class='addthis_button_messenger']")
private WebElement messengerShare;

@FindBy(xpath="//div[@class='sharing-container']/div[not(@style ='display: none;')]/div[@class='sharing-toolbox']/ul/li/a/figure/i[contains(@class,'icon icon-email')]/../..")
private WebElement emailShare;


@FindBy(xpath="//div[@class='ReactModalPortal']/div/div[not(@style ='display: none;')]/div[@class='modal-close button-close']")
private WebElement shareContainerCloseUserPrd;

@FindBy(xpath="//div[@class='ReactModalPortal']/div/div[not(@style ='display: none;')]/div[@class='share-options']/div/button/span[contains(text(),'Facebook')]")
private WebElement facebookShareUserPrd;

@FindBy(xpath="//div[@class='ReactModalPortal']/div/div[not(@style ='display: none;')]/div[@class='share-options']/div/button/span[contains(text(),'Pinterest')]")
private WebElement pinterestShareUserPrd;

@FindBy(xpath="//div[@class='ReactModalPortal']/div/div[not(@style ='display: none;')]/div[@class='share-options']/div/button/span[contains(text(),'Twitter')]")
private WebElement twitterShareUserPrd;

@FindBy(xpath="//div[@class='ReactModalPortal']/div/div[not(@style ='display: none;')]/div[@class='share-options']/div/button/span[contains(text(),'Whatsapp')]")
private WebElement whatsappShareUserPrd;

@FindBy(xpath="//div[@class='ReactModalPortal']/div/div[not(@style ='display: none;')]/div[@class='share-options']/div/button/span[contains(text(),'Messenger')]")
private WebElement messengerShareUserPrd;

@FindBy(xpath="//div[@class='ReactModalPortal']/div/div[not(@style ='display: none;')]/div[@class='share-options']/div/button/span[contains(text(),'LinkedIn')]")
private WebElement linkedInShareUserPrd;

@FindBy(xpath="//div[@class='sharing-container']/div[not(@style ='display: none;')]/div[@class='sharing-toolbox']/ul/li[@class='button_email']/a")
private WebElement emailShareMobile;

@FindBy(xpath="//div[@class='sharing-container']/div[not(@style ='display: none;')]/div[@class='sharing-toolbox']/ul/li/a/figcaption[contains(text(),'Message')]/..")
private WebElement messageShareMobile;

@FindBy(xpath="//div[@class='sharing-container']/div[not(@style ='display: none;')]/div[@class='sharing-toolbox']/ul/li/a/figure/i[@class='icon icon-embed u-fs22']/../..")
private WebElement shareEmbedded;

@FindBy(css =".truste_box_overlay_inner>iframe")
List<WebElement> emailIframe;

@FindBy(xpath="//h2[@class='modal-title']")
private WebElement shareBoxNewHeader;

@FindBy(xpath="//div[@class='ReactModal__Content ReactModal__Content--after-open']/img")
private WebElement shareBoxNewImg;

@FindBy(xpath="//div[@class='modal-close button-close']")
private WebElement shareBoxNewClose;

@FindBy(xpath="//div[@class='leg-copy-input']/button[@data-tooltip='Copy']")
private WebElement copyToClipboardNew;

@FindBy(xpath="//div[@class='leg-copy-input']/button[@data-tooltip='Copy']")
private WebElement copyToClipboardProduct;

@FindBy(id="image-link")
private WebElement copyToClipboardInputNew;

@FindBy(xpath="//*[@class='share-options']/div/button[@class='react-share__ShareButton']/span[contains(text(),'Facebook')]")
private WebElement facebookNewShare;

@FindBy(xpath="//*[@class='share-options']/div/button[@class='react-share__ShareButton']/span[contains(text(),'Pinterest')]")
private WebElement pinterestNewShare;

@FindBy(xpath="//*[@class='share-options']/div/button[@class='react-share__ShareButton']/span[contains(text(),'Twitter')]")
private WebElement twitterNewShare;

@FindBy(xpath="//*[@class='share-options']/div/button[@class='react-share__ShareButton']/span[contains(text(),'LinkedIn')]")
private WebElement linkedInNewShare;

@FindBy(xpath="//*[@class='share-options']/div/button[@class='react-share__ShareButton']/span[contains(text(),'Whatsapp')]")
private WebElement whatsappNewShare;

@FindBy(xpath="//*[@class='share-options']/div/button[@class='react-share__ShareButton']/span[contains(text(),'Messenger')]")
private WebElement messengerNewShare;


	public ShareContainer(WebDriver driver) {
		this.driver = driver;		 
	}
	
	public ShareContainer verifyShareContainer(String mediaOrProject){
		UtilHBM.waitExplicitDisplayed(driver, shareContainerHeader);
		if (mediaOrProject.equalsIgnoreCase("project")) {
			Verification.VerifyEquals("Incorrect shareContainerHeader", shareContainerHeader.getText(), "SHARE YOUR PROJECT");
			Verification.displayOfWebElement(shareEmbedded.findElement(By.tagName("figure")));
			Verification.VerifyEquals("Wrong display text for shareEmbedded", shareEmbedded.findElement(By.tagName("figcaption")).getText(), "Embed");
		}
		else if (mediaOrProject.equalsIgnoreCase("media")) {
			Verification.VerifyEquals("Incorrect shareContainerHeader", shareContainerHeader.getText(), "Share your image");
		}
		Verification.displayOfWebElement(facebookShare.findElement(By.tagName("figure")));
		Verification.displayOfWebElement(pinterestShare.findElement(By.tagName("figure")));
		Verification.displayOfWebElement(twitterShare.findElement(By.tagName("figure")));
		Verification.displayOfWebElement(whatsappShare.findElement(By.tagName("figure")));
		Verification.displayOfWebElement(messengerShare.findElement(By.tagName("figure")));
		Verification.displayOfWebElement(emailShare.findElement(By.tagName("figure")));
		Verification.VerifyEquals("Wrong display text for facebookShare", facebookShare.findElement(By.tagName("figcaption")).getText(), "Facebook");
		Verification.VerifyEquals("Wrong display text for pinterestShare", pinterestShare.findElement(By.tagName("figcaption")).getText(), "Pinterest");
		Verification.VerifyEquals("Wrong display text for twitterShare", twitterShare.findElement(By.tagName("figcaption")).getText(), "Twitter");
		Verification.VerifyEquals("Wrong display text for whatsappShare", whatsappShare.findElement(By.tagName("figcaption")).getText(), "WhatsApp");
		Verification.VerifyEquals("Wrong display text for messengerShare", messengerShare.findElement(By.tagName("figcaption")).getText(), "Messenger");
		Verification.VerifyEquals("Wrong display text for emailShare", emailShare.findElement(By.tagName("figcaption")).getText(), "Mail");
		verifyCopyToClipbioard(mediaOrProject);
		return this;
	}
	
	public ShareContainer verifyShareContainerUserProduct() {
		UtilHBM.waitExplicitDisplayed(driver, shareContainerHeaderUserPrd);
		Verification.VerifyEquals("Incorrect shareContainerHeader", shareContainerHeaderUserPrd.getText(), "Share");
		Verification.VerifyEquals("Wrong display text for facebookShare", facebookShareUserPrd.getText(), "Facebook");
		Verification.VerifyEquals("Wrong display text for pinterestShare", pinterestShareUserPrd.getText(),
				"Pinterest");
		Verification.VerifyEquals("Wrong display text for twitterShare", twitterShareUserPrd.getText(), "Twitter");
		Verification.VerifyEquals("Wrong display text for whatsappShare", whatsappShareUserPrd.getText(), "WhatsApp");
		Verification.VerifyEquals("Wrong display text for messengerShare", messengerShareUserPrd.getText(),
				"Messenger");
		Verification.VerifyEquals("Wrong display text for emailShare", linkedInNewShare.getText(), "LinkedIn");
		String link = copyToClipboardUserPrd.getAttribute("value");
		UtilHBM.reportInfo("Share by copying user product link : " + link);
		return this;
	}
	
	public ShareContainer verifyShareCollectionContainer() {
		UtilHBM.waitExplicitDisplayed(driver, shareContainerHeaderUserPrd);
		Verification.VerifyEquals("Incorrect shareContainerHeader", shareContainerHeaderUserPrd.getText(),
				"Share your collection");
		Verification.VerifyEquals("Wrong display text for facebookShare", facebookShareUserPrd.getText(), "Facebook");
		Verification.VerifyEquals("Wrong display text for pinterestShare", pinterestShareUserPrd.getText(),
				"Pinterest");
		Verification.VerifyEquals("Wrong display text for twitterShare", twitterShareUserPrd.getText(), "Twitter");
		Verification.VerifyEquals("Wrong display text for whatsappShare", whatsappShareUserPrd.getText(), "WhatsApp");
		Verification.VerifyEquals("Wrong display text for messengerShare", messengerShareUserPrd.getText(),
				"Messenger");
		Verification.VerifyEquals("Wrong display text for emailShare", linkedInNewShare.getText(), "LinkedIn");

		String link = copyToClipboardUserPrd.getAttribute("value");
		Verification.VerifyEquals("Wrong share url displayed while sharing collection!!", link, driver.getCurrentUrl());
		return this;
	}

	public FavoritesListPage verifyShareCollectionByCopyLink(String collectionTitle, int noOfImages, int noOfProducts) {
		UtilHBM.waitExplicitDisplayed(driver, shareContainerHeaderUserPrd);
		String link = copyToClipboardUserPrd.getAttribute("value");
		String collectionID = link.split("collections/")[1];
		if (driver.getCurrentUrl().contains(collectionID)) {
			UtilHBM.reportOK("Correct collection link displayed in share dialog!!");
		} else {
			UtilHBM.reportKO("Incorrect collection link displayed in share dialog!!Expected : " + collectionID
					+ " , Available : " + driver.getCurrentUrl());
		}
		Verification.VerifyEquals("Wrong share url displayed while sharing collection!!", collectionID,
				driver.getCurrentUrl());
		String handle1 = driver.getWindowHandle();
		WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
		newTab.get(link);
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				driver.switchTo().window(handle);
			}
		}
		FavoritesListPage favoritesListPage = PageFactory.initElements(driver, FavoritesListPage.class);
		favoritesListPage.verifyCollectionTitle(collectionTitle).verifyCollectionContents(noOfImages, noOfProducts);
		driver.close();
		driver.switchTo().window(handle1);
		closeSharePoductContainer();
		return PageFactory.initElements(driver, FavoritesListPage.class);
	}
	
	public ShareContainer shareMedia() {
		verifyShareContainer("media");
		ArrayList<WebElement> shareOptions = new ArrayList<WebElement>();
		shareOptions.add(facebookShare);
		shareOptions.add(pinterestShare);
		shareOptions.add(twitterShare);
		shareOptions.add(whatsappShare);
		shareOptions.add(messengerShare);
//		shareOptions.add(emailShare);
		for (WebElement b : shareOptions) {			
			String site = b.getAttribute("title");
			UtilHBM.waitExplicitClickable(driver, b);
			b.click();
			String handle = driver.getWindowHandle();
			for (String handle1 : driver.getWindowHandles()) {
				if (!handle1.equalsIgnoreCase(handle)) {
					driver.switchTo().window(handle1);
				}
			}
			UtilHBM.waitFixTime(2000);
			switch (site) {
			case "Facebook":
				UtilHBM.waitExplicitDisplayed(driver,UtilHBM.webElement(driver, "body>div#booklet>div>div>div>h2#homelink"));
				Verification.VerifyEquals("Wrong Header for Facebook",UtilHBM.webElement(driver, "body>div#booklet>div>div>div>h2#homelink").getText(), "Facebook");
				if (driver.getCurrentUrl().contains("facebook")) {
					UtilHBM.reportOK("Facebook link verified");
				} else {
					UtilHBM.reportKO("Facebook link not opened");
				}
				break;

			case "Twitter":
				UtilHBM.waitExplicitDisplayed(driver,UtilHBM.webElementXPath(driver, "//span[.='Want to log in first?']"));	
				if (driver.getCurrentUrl().contains("twitter")) {
					UtilHBM.reportOK("Twitter link verified");
				} else {
					UtilHBM.reportKO("Twitter link not opened");
				}
				break;

			case "Pinterest":
//				UtilHBM.waitExplicitDisplayed(driver,UtilHBM.webElementXPath(driver, "//div/h3"));
//				Verification.VerifyEquals("Wrong text displayed for Pinterest",UtilHBM.webElementXPath(driver, "//div/h3").getText(),"Log in for more ideas you'll love");
//				UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "#email"));
				if (driver.getCurrentUrl().contains("pinterest")) {
					UtilHBM.reportOK("Pinterest link verified");	
				} else {
					UtilHBM.reportKO("Pinterest link not opened");
				}
				break;

			case "Email":
				UtilHBM.waitFixTime(1000);
				if (!emailIframe.isEmpty()) {
					driver.switchTo().frame(emailIframe.get(0));
					UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector(
							"body > div:nth-child(16) >div.mainContent > div > div:nth-child(2) > div.pdynamicbutton > .call")));
					WebElement acceptCookies = driver.findElement(By.cssSelector(
							"body > div:nth-child(16) >div.mainContent > div > div:nth-child(2) > div.pdynamicbutton > .call"));
					UtilHBM.waitExplicitClickable(driver, acceptCookies);
					UtilHBM.waitExplicitClickable(driver, acceptCookies);
					acceptCookies.click();
					driver.switchTo().parentFrame();
				}
				if (driver.getCurrentUrl().contains("addthis")) {
					UtilHBM.reportOK("Email link verified");
					UtilHBM.waitExplicitDisplayed(driver, emailAFriendTitle);
					Verification.displayOfWebElement(emailProjectTitle);
					Verification.displayOfWebElement(emailProjectURL);
					UtilHBM.webElement(driver, "#at-expanded-menu-email-to").sendKeys("toexample@abc.com");
					UtilHBM.webElement(driver, "#at-expanded-menu-email-from").sendKeys("fromexample@abc.com");
					UtilHBM.webElement(driver, "#at-expanded-menu-email-note").sendKeys("Example note");
//					Verification.VerifyEquals("Wrong Recaptcha text",UtilHBM.webElement(driver, "#recaptcha-anchor-label").getText(), "I'm not a robot");
				} else {
					UtilHBM.reportKO("Email link not opened");
				}
				break;	
				
			case "WhatsApp":
				if (driver.getCurrentUrl().contains("whatsapp")) {
					UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver,"a[href*='https://www.whatsapp.com']"));
					Verification.displayOfWebElement(UtilHBM.webElement(driver,"a[href*='https://www.whatsapp.com']"));
					UtilHBM.reportOK("Whatsapp link verified");
				} else {
					UtilHBM.reportKO("Whatsapp link not opened");
				}
				break;
							
			case "Messenger":
				if (driver.getCurrentUrl().contains("facebook")) {
					UtilHBM.reportOK("Messenger link verified");
					UtilHBM.waitExplicitDisplayed(driver,UtilHBM.webElement(driver, "div.clearfix.loggedout_menubar>div>h1>a>i>u"));
					Verification.VerifyEquals("Wrong Header for FB Messenger",UtilHBM.webElement(driver, "div.clearfix.loggedout_menubar>div>h1>a>i>u").getText(), "Facebook");
				} else {
					UtilHBM.reportKO("Messenger link not opened");
				}
				break;
			}
			driver.close();
			driver.switchTo().window(handle);
		}
		return this;
	}
	

	public ShareContainer shareProject() {
		verifyShareContainer("project");
		ArrayList<WebElement> shareOptions = new ArrayList<WebElement>();
		shareOptions.add(facebookShare);
		shareOptions.add(pinterestShare);
		shareOptions.add(twitterShare);
		shareOptions.add(whatsappShare);
		shareOptions.add(messengerShare);
		shareOptions.add(shareEmbedded);
//		shareOptions.add(emailShare);
		for (WebElement b : shareOptions) {			
			String site = b.findElement(By.tagName("figcaption")).getText();
			UtilHBM.waitExplicitClickable(driver, b);
			b.click();
			String handle=null;
			if (!site.equalsIgnoreCase("Pinterest")) {
				handle = driver.getWindowHandle();
				for (String handle1 : driver.getWindowHandles()) {
					if (!handle1.equalsIgnoreCase(handle)) {
						driver.switchTo().window(handle1);
					}
				}
			}
			UtilHBM.waitFixTime(2000);
			switch (site) {
			case "Facebook":
				UtilHBM.waitExplicitDisplayed(driver,UtilHBM.webElement(driver, "body>div#booklet>div>div>div>h2#homelink"));
				Verification.VerifyEquals("Wrong Header for Facebook",UtilHBM.webElement(driver, "body>div#booklet>div>div>div>h2#homelink").getText(), "Facebook");
				if (driver.getCurrentUrl().contains("facebook")) {
					UtilHBM.reportOK("Facebook link verified");
				} else {
					UtilHBM.reportKO("Facebook link not opened");
				}
				break;

			case "Twitter":
//				UtilHBM.waitExplicitDisplayed(driver,UtilHBM.webElementXPath(driver, "//span[.='Want to log in first?']"));
				if (driver.getCurrentUrl().contains("twitter")) {
					UtilHBM.reportOK("Twitter link verified");
				} else {
					UtilHBM.reportKO("Twitter link not opened");
				}
				break;

			case "Pinterest":
				UtilHBM.waitFixTime(1000);
				WebElement iframe1 = driver.findElement(By.cssSelector("iframe[id*='PIN']"));
				driver.switchTo().frame(iframe1);
				UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "#choosePin"));
				Verification.VerifyEquals("Wrong Pinterrest message",UtilHBM.webElement(driver, "#choosePin").getText(),"Choose a Pin to save");

				new Actions(driver).moveToElement(UtilHBM.webElement(driver, "#ct>span:nth-child(2)")).build().perform();
				UtilHBM.waitFixTime(1000);
				 UtilHBM.webElement(driver, "#ct>span:nth-child(2)>span").click();
				 handle = driver.getWindowHandle();
					for (String handle1 : driver.getWindowHandles()) {
						if (!handle1.equalsIgnoreCase(handle)) {
							driver.switchTo().window(handle1);
						}
					}
					
//				UtilHBM.waitExplicitDisplayed(driver,UtilHBM.webElementXPath(driver, "//div/h3"));
//				Verification.VerifyEquals("Wrong text displayed for Pinterest",UtilHBM.webElementXPath(driver, "//div/h3").getText(),"Log in for more ideas you'll love");
//				UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "#email"));
				if (driver.getCurrentUrl().contains("pinterest")) {
					UtilHBM.reportOK("Pinterest link verified");	
				} else {
					UtilHBM.reportKO("Pinterest link not opened");
				}
				break;

			case "Mail":
				if (!emailIframe.isEmpty()) {
					driver.switchTo().frame(emailIframe.get(0));
					UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector(
							"body > div:nth-child(16) >div.mainContent > div > div:nth-child(2) > div.pdynamicbutton > .call")));
					WebElement acceptCookies = driver.findElement(By.cssSelector(
							"body > div:nth-child(16) >div.mainContent > div > div:nth-child(2) > div.pdynamicbutton > .call"));
					UtilHBM.waitExplicitClickable(driver, acceptCookies);
					UtilHBM.waitExplicitClickable(driver, acceptCookies);
					acceptCookies.click();
					driver.switchTo().parentFrame();
				}
				if (driver.getCurrentUrl().contains("addthis")) {
					UtilHBM.reportOK("Email link verified");
					UtilHBM.waitExplicitDisplayed(driver, emailAFriendTitle);
					Verification.displayOfWebElement(emailProjectTitle);
					Verification.displayOfWebElement(emailProjectURL);
					UtilHBM.webElement(driver, "#at-expanded-menu-email-to").sendKeys("toexample@abc.com");
					UtilHBM.webElement(driver, "#at-expanded-menu-email-from").sendKeys("fromexample@abc.com");
					UtilHBM.webElement(driver, "#at-expanded-menu-email-note").sendKeys("Example note");
//					Verification.VerifyEquals("Wrong Recaptcha text",UtilHBM.webElement(driver, "#recaptcha-anchor-label").getText(), "I'm not a robot");
				} else {
					UtilHBM.reportKO("Email link not opened");
				}
				break;	
				
			case "WhatsApp":
				if (driver.getCurrentUrl().contains("whatsapp")) {
					UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver,"a[href*='https://www.whatsapp.com']"));
					Verification.displayOfWebElement(UtilHBM.webElement(driver,"a[href*='https://www.whatsapp.com']"));
					UtilHBM.reportOK("Whatsapp link verified");
				} else {
					UtilHBM.reportKO("Whatsapp link not opened");
				}
				break;
							
			case "Messenger":
				if (driver.getCurrentUrl().contains("facebook")) {
					UtilHBM.reportOK("Messenger link verified");
					UtilHBM.waitExplicitDisplayed(driver,UtilHBM.webElement(driver, "div.clearfix.loggedout_menubar>div>h1>a>i>u"));
					Verification.VerifyEquals("Wrong Header for FB Messenger",UtilHBM.webElement(driver, "div.clearfix.loggedout_menubar>div>h1>a>i>u").getText(), "Facebook");
				} else {
					UtilHBM.reportKO("Messenger link not opened");
				}
				break;
			
			case "Embed":
				ShareEmbedDialog embedProject=PageFactory.initElements(driver, ShareEmbedDialog.class);
				embedProject.verifyEmbedProject();
				break;
			
			default:
				UtilHBM.reportKO("Wrong input!!!");
			}
			if (!site.equalsIgnoreCase("Embed")) {
				driver.close();
				driver.switchTo().window(handle);
			}
			
		}
		return this;
	}

	public ProjectPage closeShareContainer() {
		UtilHBM.waitExplicitDisplayed(driver, shareContainerClose);
		UtilHBM.waitExplicitClickable(driver, shareContainerClose);
		shareContainerClose.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, ProjectPage.class);
	}
	
	public ProductInfo closeSharePoductContainer() {
		UtilHBM.waitExplicitDisplayed(driver, shareProductContainerClose);
		UtilHBM.waitExplicitClickable(driver, shareProductContainerClose);
		shareProductContainerClose.click();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, ProductInfo.class);
	}	

	public ShareEmbedDialog clickShareEmbed() {
		UtilHBM.waitExplicitClickable(driver, shareEmbedded);
		shareEmbedded.click();
		return PageFactory.initElements(driver, ShareEmbedDialog.class);
	}

	public ShareContainer verifyCopyToClipbioard(String mediaOrProject) {
		Verification.displayOfWebElement(copyToClipboardButton);
		if (mediaOrProject.equalsIgnoreCase("project")) {
			String link = copyToClipboardInput.getAttribute("value");
			String currentLink = driver.getCurrentUrl();
			if (currentLink.contains(link)) {
				UtilHBM.reportOK("Copy to clipboard Success");
			} else {
				UtilHBM.reportKO(
						"Copy to clipboard Failed!!!Expected Value : " + link + ",Actual value : " + currentLink);
			}
		}
		return this;
	}

	public ProjectPage shareMediaByCopyLink(String mediaOrProject, String mediaType) {
		UtilHBM.waitExplicitDisplayed(driver, copyToClipboardButton);
		Verification.displayOfWebElement(copyToClipboardButton);
		String link = copyToClipboardInput.getAttribute("value");
		closeShareContainer();
		UtilHBM.reportInfo("Opening copied link in new tab!!");
		String handle = driver.getWindowHandle();
		WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
		newTab.get(link);
		for (String handle1 : driver.getWindowHandles()) {
			if (!handle1.equals(handle)) {
				driver.switchTo().window(handle1);
			}
		}
		UtilHBM.waitFixTime(1000);
		List<WebElement> fullScrnImg = driver.findElements(By.xpath("//figure/img[starts-with(@src,'https:')]"));
		if (mediaType.equalsIgnoreCase("Realistic images")) {
			UtilHBM.reportKO("Fullscreen media displayed after sharing by copying link!! Media link : " + link);
			UtilHBM.turnOffImplicitWaits(driver);
			boolean isFullsceenMediaDisplayed = !(fullScrnImg.isEmpty());
			UtilHBM.turnOnImplicitWaits(driver);
			if (isFullsceenMediaDisplayed) {
				UtilHBM.waitExplicitDisplayed(driver, fullScrnImg.get(0));
				Verification.displayOfWebElement(fullScrnImg.get(0));
				String currentLink = driver.getCurrentUrl();
				UtilHBM.reportOK("Copy to clipboard Success!!Fulscreen media link : " + currentLink);
				WebElement shareButton1 = driver
						.findElement(By.xpath("//figure/div/ul/li/a/i[@class='icon icon-share u-fs20']/.."));
				UtilHBM.waitExplicitClickable(driver, shareButton1);
				UtilHBM.waitExplicitDisplayed(driver, shareButton1);
				shareButton1.click();
				verifyShareContainer("media").closeShareContainer();
			} else {
				FeaturedMediaPage featuredMediaPage = PageFactory.initElements(driver, FeaturedMediaPage.class);
				featuredMediaPage.verifyMediaDisplayed();
			}
		} else {
			UtilHBM.waitExplicitDisplayed(driver, fullScrnImg.get(0));
			Verification.displayOfWebElement(fullScrnImg.get(0));
			String currentLink = driver.getCurrentUrl();
			UtilHBM.reportOK("Copy to clipboard Success!!Fulscreen media link : " + currentLink);
			WebElement shareButton1 = driver
					.findElement(By.xpath("//figure/div/ul/li/a/i[@class='icon icon-share u-fs20']/.."));
			UtilHBM.waitExplicitClickable(driver, shareButton1);
			UtilHBM.waitExplicitDisplayed(driver, shareButton1);
			shareButton1.click();
			verifyShareContainer("media").closeShareContainer();
		}
		driver.close();
		driver.switchTo().window(handle);
		UtilHBM.waitFixTime(500);
		return PageFactory.initElements(driver, ProjectPage.class);
	}

	public FeaturedMediaPage openImagePageByCopyLink() {
		UtilHBM.waitExplicitDisplayed(driver, copyToClipboardButton);
		Verification.displayOfWebElement(copyToClipboardButton);
		String link = copyToClipboardInput.getAttribute("value");
		closeShareContainer();
		UtilHBM.reportInfo("Verifying share container in shared media!!");
		driver.get(link);
		return PageFactory.initElements(driver, FeaturedMediaPage.class);
	}
	
//	public ShareContainer shareMediaNew() {
//		verifyShareContainer("media");
//		ArrayList<WebElement> shareOptions = new ArrayList<WebElement>();
//		shareOptions.add(facebookShare);
//		shareOptions.add(pinterestShare);
//		shareOptions.add(twitterShare);
//		shareOptions.add(whatsappShare);
//		shareOptions.add(messengerShare);
////		shareOptions.add(emailShare);
//		for (WebElement b : shareOptions) {			
//			String site = b.getAttribute("title");
//			UtilHBM.waitExplicitClickable(driver, b);
//			b.click();
//			String handle = driver.getWindowHandle();
//			for (String handle1 : driver.getWindowHandles()) {
//				if (!handle1.equalsIgnoreCase(handle)) {
//					driver.switchTo().window(handle1);
//				}
//			}
//			UtilHBM.waitFixTime(2000);
//			switch (site) {
//			case "Facebook":
//				UtilHBM.waitExplicitDisplayed(driver,UtilHBM.webElement(driver, "body>div#booklet>div>div>div>h2#homelink"));
//				Verification.VerifyEquals("Wrong Header for Facebook",UtilHBM.webElement(driver, "body>div#booklet>div>div>div>h2#homelink").getText(), "Facebook");
//				if (driver.getCurrentUrl().contains("facebook")) {
//					UtilHBM.reportOK("Facebook link verified");
//				} else {
//					UtilHBM.reportKO("Facebook link not opened");
//				}
//				break;
//
//			case "Twitter":
//				UtilHBM.waitExplicitDisplayed(driver,UtilHBM.webElementXPath(driver, "//span[.='Want to log in first?']"));	
//				if (driver.getCurrentUrl().contains("twitter")) {
//					UtilHBM.reportOK("Twitter link verified");
//				} else {
//					UtilHBM.reportKO("Twitter link not opened");
//				}
//				break;
//
//			case "Pinterest":
////				UtilHBM.waitExplicitDisplayed(driver,UtilHBM.webElementXPath(driver, "//div/h3"));
////				Verification.VerifyEquals("Wrong text displayed for Pinterest",UtilHBM.webElementXPath(driver, "//div/h3").getText(),"Log in for more ideas you'll love");
////				UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "#email"));
//				if (driver.getCurrentUrl().contains("pinterest")) {
//					UtilHBM.reportOK("Pinterest link verified");	
//				} else {
//					UtilHBM.reportKO("Pinterest link not opened");
//				}
//				break;
//
//			case "Email":
//				UtilHBM.waitFixTime(1000);
//				if (!emailIframe.isEmpty()) {
//					driver.switchTo().frame(emailIframe.get(0));
//					UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector(
//							"body > div:nth-child(16) >div.mainContent > div > div:nth-child(2) > div.pdynamicbutton > .call")));
//					WebElement acceptCookies = driver.findElement(By.cssSelector(
//							"body > div:nth-child(16) >div.mainContent > div > div:nth-child(2) > div.pdynamicbutton > .call"));
//					UtilHBM.waitExplicitClickable(driver, acceptCookies);
//					UtilHBM.waitExplicitClickable(driver, acceptCookies);
//					acceptCookies.click();
//					driver.switchTo().parentFrame();
//				}
//				if (driver.getCurrentUrl().contains("addthis")) {
//					UtilHBM.reportOK("Email link verified");
//					UtilHBM.waitExplicitDisplayed(driver, emailAFriendTitle);
//					Verification.displayOfWebElement(emailProjectTitle);
//					Verification.displayOfWebElement(emailProjectURL);
//					UtilHBM.webElement(driver, "#at-expanded-menu-email-to").sendKeys("toexample@abc.com");
//					UtilHBM.webElement(driver, "#at-expanded-menu-email-from").sendKeys("fromexample@abc.com");
//					UtilHBM.webElement(driver, "#at-expanded-menu-email-note").sendKeys("Example note");
////					Verification.VerifyEquals("Wrong Recaptcha text",UtilHBM.webElement(driver, "#recaptcha-anchor-label").getText(), "I'm not a robot");
//				} else {
//					UtilHBM.reportKO("Email link not opened");
//				}
//				break;	
//				
//			case "WhatsApp":
//				if (driver.getCurrentUrl().contains("whatsapp")) {
//					UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver,"a[href*='https://www.whatsapp.com']"));
//					Verification.displayOfWebElement(UtilHBM.webElement(driver,"a[href*='https://www.whatsapp.com']"));
//					UtilHBM.reportOK("Whatsapp link verified");
//				} else {
//					UtilHBM.reportKO("Whatsapp link not opened");
//				}
//				break;
//							
//			case "Messenger":
//				if (driver.getCurrentUrl().contains("facebook")) {
//					UtilHBM.reportOK("Messenger link verified");
//					UtilHBM.waitExplicitDisplayed(driver,UtilHBM.webElement(driver, "div.clearfix.loggedout_menubar>div>h1>a>i>u"));
//					Verification.VerifyEquals("Wrong Header for FB Messenger",UtilHBM.webElement(driver, "div.clearfix.loggedout_menubar>div>h1>a>i>u").getText(), "Facebook");
//				} else {
//					UtilHBM.reportKO("Messenger link not opened");
//				}
//				break;
//			}
//			driver.close();
//			driver.switchTo().window(handle);
//		}
//		return this;
//	}
	
	public FeaturedMediaPage verifyShareContainerNew() {

		UtilHBM.waitExplicitDisplayed(driver, shareBoxNewImg);
		String imgSrc=shareBoxNewImg.getAttribute("src");
		if(imgSrc.contains("https:")&&imgSrc.contains(".jpg")) {
			UtilHBM.reportOK("Image displayed in share dialog");
		} else {
			UtilHBM.reportKO("Image not displayed in share dialog");
		}
		
		Verification.VerifyEquals("Incorrect shareContainerHeader", shareBoxNewHeader.getText(), "Share your image");
		Verification.displayOfWebElement(facebookNewShare);
		Verification.displayOfWebElement(pinterestNewShare);
		Verification.displayOfWebElement(twitterNewShare);
		Verification.displayOfWebElement(whatsappNewShare);
		Verification.displayOfWebElement(messengerNewShare);
		Verification.displayOfWebElement(linkedInNewShare);
		UtilHBM.waitExplicitDisplayed(driver, copyToClipboardNew);
		Verification.displayOfWebElement(copyToClipboardNew);
		String link = copyToClipboardInputNew.getAttribute("value");
		UtilHBM.webElement(driver, ".modal-close.button-close").click();
		driver.get(link);
		UtilHBM.waitFixTime(1000);
		String currentLink = driver.getCurrentUrl();
		if (currentLink.contains(link)) {
			UtilHBM.reportOK("Copy to clipboard Success");
		} else {
			UtilHBM.reportKO("Copy to clipboard Failed!!!Expected Value : " + link + ",Actual value : " + currentLink);
		}
		FeaturedMediaPage featuredMediaPage = PageFactory.initElements(driver, FeaturedMediaPage.class);
		featuredMediaPage.verifyMediaDisplayed();	
		return PageFactory.initElements(driver, FeaturedMediaPage.class);
	}
	
	public ShareContainer verifyShareProductDialog() {
		UtilHBM.waitExplicitDisplayed(driver, facebookNewShare);
	
		Verification.VerifyEquals("Incorrect shareContainerHeader", shareBoxNewHeader.getText(), "Share");
		Verification.displayOfWebElement(facebookNewShare);
		Verification.displayOfWebElement(pinterestNewShare);
		Verification.displayOfWebElement(twitterNewShare);
		Verification.displayOfWebElement(whatsappNewShare);
		Verification.displayOfWebElement(messengerNewShare);
		Verification.displayOfWebElement(linkedInNewShare);
		UtilHBM.waitExplicitDisplayed(driver, copyToClipboardProduct);
		Verification.displayOfWebElement(copyToClipboardProduct);
		String link = copyToClipboardInputNew.getAttribute("value");
		if (!link.equals("")) {
			UtilHBM.reportOK("Share product link displayed");
			UtilHBM.reportInfo("Product link copied to clipboard :" + link);
		} else {
			UtilHBM.reportKO("Share product link not displayed");
		}	
		return PageFactory.initElements(driver, ShareContainer.class);
	}
	
	
/*---------------------Following methods are used for mobile automation---------------------*/
	ShareContainer verifyShareContainerMobile(String mediaOrProject){
		UtilHBM.waitExplicitDisplayed(driver, shareContainerHeader);
		if (mediaOrProject.equalsIgnoreCase("project")) {
			Verification.VerifyEquals("Incorrect shareContainerHeader", shareContainerHeader.getText(), "SHARE YOUR PROJECT");
			Verification.displayOfWebElement(shareEmbedded.findElement(By.tagName("figure")));
			Verification.VerifyEquals("Wrong display text for shareEmbedded", shareEmbedded.findElement(By.tagName("figcaption")).getText(), "Embed");
		}
		else if (mediaOrProject.equalsIgnoreCase("media")) {
			Verification.VerifyEquals("Incorrect shareContainerHeader", shareContainerHeader.getText(), "Share your image");
		}
		Verification.displayOfWebElement(facebookShare.findElement(By.tagName("figure")));
		Verification.displayOfWebElement(pinterestShare.findElement(By.tagName("figure")));
		Verification.displayOfWebElement(twitterShare.findElement(By.tagName("figure")));
		Verification.displayOfWebElement(whatsappShare.findElement(By.tagName("figure")));
		Verification.displayOfWebElement(messengerShare.findElement(By.tagName("figure")));
		Verification.displayOfWebElement(emailShareMobile.findElement(By.tagName("figure")));
		Verification.displayOfWebElement(messageShareMobile.findElement(By.tagName("figure")));
		Verification.VerifyEquals("Wrong display text for facebookShare", facebookShare.findElement(By.tagName("figcaption")).getText(), "Facebook");
		Verification.VerifyEquals("Wrong display text for pinterestShare", pinterestShare.findElement(By.tagName("figcaption")).getText(), "Pinterest");
		Verification.VerifyEquals("Wrong display text for twitterShare", twitterShare.findElement(By.tagName("figcaption")).getText(), "Twitter");
		Verification.VerifyEquals("Wrong display text for whatsappShare", whatsappShare.findElement(By.tagName("figcaption")).getText(), "WhatsApp");
		Verification.VerifyEquals("Wrong display text for messengerShare", messengerShare.findElement(By.tagName("figcaption")).getText(), "Messenger");
		Verification.VerifyEquals("Wrong display text for emailShare", emailShareMobile.findElement(By.tagName("figcaption")).getText(), "Mail");
		Verification.VerifyEquals("Wrong display text for emailShare",messageShareMobile.findElement(By.tagName("figcaption")).getText(), "Message");
		verifyCopyToClipbioard(mediaOrProject);
		return this;
	}
	
	public ProjectPage shareMediaByCopyLinkMobile(String mediaOrProject) {
		UtilHBM.waitExplicitDisplayed(driver, copyToClipboardButton);
		Verification.displayOfWebElement(copyToClipboardButton);
		String link = copyToClipboardInput.getAttribute("value");
		closeShareContainer();
		UtilHBM.reportInfo("Verifying share container in shared media!!");
		driver.get(link);
		WebElement fullScrnImg=driver.findElement(By.xpath("//figure/img[starts-with(@src,'https:')]"));
		UtilHBM.waitExplicitDisplayed(driver, fullScrnImg);
		Verification.displayOfWebElement(fullScrnImg);
		String currentLink = driver.getCurrentUrl();
		if (currentLink.contains(link)) {
			UtilHBM.reportOK("Copy to clipboard Success");
		} else {
			UtilHBM.reportKO("Copy to clipboard Failed!!!Expected Value : " + link + ",Actual value : " + currentLink);
		}
		WebElement shareButton1 = driver
				.findElement(By.xpath("//figure/div/ul/li/a/i[@class='icon icon-share u-fs20']/.."));
		UtilHBM.waitExplicitClickable(driver, shareButton1);
		UtilHBM.waitExplicitDisplayed(driver, shareButton1);
		shareButton1.click();
		verifyShareContainerMobile("media");
		driver.navigate().back();
		return PageFactory.initElements(driver, ProjectPage.class);
	}

}