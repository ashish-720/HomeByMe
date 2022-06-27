package hbm.web.pageobject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class LandingPage {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "header[class='headr']>div.header__container.row>a.header__logo>svg.icon.icon-logo")
	public WebElement hbmLogo;

	@FindBy(xpath = "//header[@class='headr']/div/nav[@class='header__nav']/a[contains(@href,'/en/inspiration/selection')]")
	public WebElement inspirationLink;

	@FindBy(css = "header[class='headr']>div.header__container.row>nav.header__nav>a[href$='/en/offers/']")
	public WebElement offersLink;

	@FindBy(css = "header[class='headr']>div.header__container.row>nav.header__nav>span:nth-child(4)")
	public WebElement solutionLink;

	@FindBy(css = "header[class='headr']>div.header__container.row>nav.header__nav>span:nth-child(5)")
	public WebElement proLink;

	@FindBy(xpath = "//header[@class='headr']//button[@title='Log in']/span[text()='Log in']")
	public WebElement login;

	@FindBy(xpath = "//header[@class='headr']//span/span[text()='SIGN UP FREE']")
	public WebElement signUp;

	@FindBy(css = "div.hero-home__text__align>div>h1.hero-home__text__title.title")
	public WebElement trialProjectInfoText;

	@FindBy(css = "div.hero-home__text__align>div>div.hero-home__text__content>a.button.button--l")
	public WebElement tryNowButton;

	@FindBy(css = "div.hero-home__image>img[src='https://d22oxwf9h3y4am.cloudfront.net/assets/app/uploads/sites/3/2020/05/homebyme-consumer-homepage-1-e1637334702438-728x794.png']")
	public WebElement trialProjectInfoImg;

	@FindBy(css = "div.hero-home__framed-tablet.panel>div>div>div.tablet-media>img[src='https://d22oxwf9h3y4am.cloudfront.net/assets/app/uploads/sites/3/2020/12/homeb2c-hero2x-en-1420x1065.jpg']")
	public WebElement tabletPanelImg;

	@FindBy(css = "section.panel.panel--default.claim>div.claim__container.row>p")
	public WebElement inspirationText1;

	@FindBy(css = "section.panel.panel--default.gallery-grid>div.gallery-grid__header>div>div>div.title-text>h2.title-text__title.title")
	public WebElement galleryGridText1;

	@FindBy(css = "section.panel.panel--default.gallery-grid>div.gallery-grid__header>div>div>div.title-text>div.title-text__text")
	public WebElement galleryGridText2;

	@FindBy(css = "section.panel.panel--default.gallery-grid>div.gallery-grid__header>div>div>a[href^='https://preprod-home.by.me/en/inspiration?content=true']")
	public WebElement beInspiraedButton;

	@FindBy(css = "div.gallery-grid__container>div.gallery-grid__layout>div.colcade>div.colcade-col>a")
	public List<WebElement> galleryGridImages;

	@FindBy(css = "div.modal.modal--fullscreen.modal--carousel>div.modal__content>div.carousel.carousel--fullscreen.is-first-item>div.carousel__wrapper>img")
	public List<WebElement> fullscreenImages;

	@FindBy(xpath = "//section[3]/div/div/div/div[@class='push__media push__media--image']/picture/img[@src='https://d22oxwf9h3y4am.cloudfront.net/assets/app/uploads/sites/3/2020/12/hompage-b2c-cons-usp-002x-en-1-627x486.jpg']")
	public WebElement designYourFutureHomeImg;

	@FindBy(xpath = "//section[3]/div/div/div/div[@class='title-text']/h2")
	public WebElement designYourFutureHomeTitle;

	@FindBy(xpath = "//section[3]/div/div/div/div[@class='title-text']/div/p")
	public WebElement designYourFutureHomeText;

	@FindBy(xpath = "//section[4]/div/div/div/div[@class='push__media push__media--image']/picture/img[@src='https://d22oxwf9h3y4am.cloudfront.net/assets/app/uploads/sites/3/2020/09/hompage-b2c-cons-furnishwithrealbrands-en2x-1-600x273.png']")
	public WebElement furnishYourProjectImg;

	@FindBy(xpath = "//section[4]/div/div/div/div[@class='title-text']/h2")
	public WebElement furnishYourProjectTitle;

	@FindBy(xpath = "//section[4]/div/div/div/div[@class='title-text']/div")
	public WebElement furnishYourProjectText;

	@FindBy(xpath = "//section[5]/div/div/div/div[@class='push__media push__media--image']/picture/img[@src='https://d22oxwf9h3y4am.cloudfront.net/assets/app/uploads/sites/3/2020/06/hompage-b2c-cons-usp-022x-627x486.png']")
	public WebElement makeAmazingHDImg;

	@FindBy(xpath = "//section[5]/div/div/div/div[@class='title-text']/h2")
	public WebElement makeAmazingHDTitle;

	@FindBy(xpath = "//section[5]/div/div/div/div[@class='title-text']/div/p")
	public WebElement makeAmazingHDText;

	@FindBy(xpath = "//section[6]/div/div/div/div[@class='push__media push__media--image']/picture/img[@src='https://d22oxwf9h3y4am.cloudfront.net/assets/app/uploads/sites/3/2020/06/hompage-b2c-cons-usp-032x-1-627x486.png']")
	public WebElement getFeedbacksFromFamilyImg;

	@FindBy(xpath = "//section[6]/div/div/div/div[@class='title-text']/h2")
	public WebElement getFeedbacksFromFamilyTitle;

	@FindBy(xpath = "//section[6]/div/div/div/div[@class='title-text']/div/p")
	public WebElement getFeedbacksFromFamilyText;

	@FindBy(xpath = "//section[7]/div/div/div/div[@class='push__media push__media--image']/picture/img[@src='https://d22oxwf9h3y4am.cloudfront.net/assets/app/uploads/sites/3/2020/10/mobile-app-usp-082x-627x486.png']")
	public WebElement takeYourProjectAnywhereImg;

	@FindBy(xpath = "//section[7]/div/div/div/div[@class='title-text']/h2")
	public WebElement takeYourProjectAnywhereTitle;

	@FindBy(xpath = "//section[7]/div/div/div/div[@class='title-text']/div/p")
	public WebElement takeYourProjectAnywhereText;

	@FindBy(xpath = "//section[8]/div/div/div/h3[@class='push-testimony-slider__title']")
	public WebElement becomeanAmbassadorTitle;

	@FindBy(xpath = "//section[8]/div/div/div/div[@class='push-testimony-slider__text']")
	public WebElement becomeanAmbassadorText;

	@FindBy(xpath = "//section[8]/div/div/div/div[@class='testimony-slider']/div[@class='testimony-slider__medias']/div[@class='testimony-slider__media is-active']/a[@class='cover-media cover-media--video js-modal-video']/img[@src='https://d22oxwf9h3y4am.cloudfront.net/assets/app/uploads/sites/3/2020/08/hbm-user-2-e1596803882560-1122x671.jpg']")
	public WebElement becomeanAmbassadorVideo;

	@FindBy(xpath = "//section[@class='panel panel--focus1 video-playlist']/div[@class='video-playlist__header']/div/div/h3[@class='video-playlist__title']")
	public WebElement videoPlaylistTitle;

	@FindBy(xpath = "//section[9]/div/div/div/h3[@class='video-playlist__title']")
	public WebElement videoPlaylistHeader;

	@FindBy(css = "div.modal.modal--fullscreen.modal--carousel>button.modal__close")
	public WebElement closeFullscreenImage;

	@FindBy(xpath = "//div[@class='video-playlist__container row']/div/div[contains(@class,'video-playlist__items')]/div")
	public List<WebElement> videoPlaylistItems;

	@FindBy(xpath = "//div[@class='video-playlist__container row']/div/div[contains(@class,'video-playlist__videos')]/div")
	public List<WebElement> videoPlaylistVideos;

	@FindBy(css = "div.wrapper>.header-right>.header-start>a[title='Log in']")
	public WebElement loginMDM;

	@FindBy(css = "header[class='headr']>div>button>svg.icon.icon-burger")
	public WebElement headerMenuMobile;

	@FindBy(css = "div.footer__bottom__left>form.lang-switch>select")
	public WebElement languageSelect;
	
	@FindBy(xpath = "//footer[@class='footer']/div[@class='footer__container']/div/div[4]/nav/a[contains(@href,'/en/partner')]")
	public WebElement brandLink;
	
	@FindBy(xpath = "//footer[@class='footer']/div[@class='footer__container']/div/div[3]/nav/a[contains(@href,'en/community-content')]")
	public WebElement communityContent;
	
	@FindBy(css = "body>header[class='headr']>div>nav>span:nth-child(2)>span")
	public WebElement magazine;

	List<String> videoPlaylistTitleExpected = Arrays.asList("Easy floorplan creation", "Several styles in minutes",
			"Amazing HD images");
	List<String> videoPlaylistTextExpected = Arrays.asList("Sketch your 3D plan in a few clicks",
			"Test and compare different furnishings for your room", "Show off your home project to family and friends");
	List<String> videoPlaylistSrcExpected = Arrays.asList(
			"https://d22oxwf9h3y4am.cloudfront.net/assets/app/uploads/sites/3/2021/01/all-you-need-design-home-en-1.mp4",
			"https://d22oxwf9h3y4am.cloudfront.net/assets/app/uploads/sites/3/2021/01/all-you-need-design-home-en-2.mp4",
			"https://d22oxwf9h3y4am.cloudfront.net/assets/app/uploads/sites/3/2021/01/all-you-need-design-home-en-3.mp4");

	public CompleteProfile signUpNewUser(SignUpData signUpData){
		signUp.click();
		SignUp signUp = PageFactory.initElements(driver, SignUp.class);
		signUp.createNewUser(signUpData);
		return PageFactory.initElements(driver, CompleteProfile.class);
	}
	
	public CompleteProfile signUpNewUserWithDate(SignUpData signUpData, int index) {
		signUp.click();
		SignUp signUp = PageFactory.initElements(driver, SignUp.class);
		String email = signUpData.getLoginId();
		String newDateEmail = email.split("@")[0] + "+" + UtilHBM.getDate(0, "ddMMyyyy") + "-" + String.valueOf(index)
				+ "@" + email.split("@")[1];
		String newDateLoginId = email.split("@")[0] + "+" + UtilHBM.getDate(0, "ddMMyyyy") + "-"
				+ String.valueOf(index);
		signUp.enterEmail(newDateEmail).enterLoginId(newDateLoginId).enterRegistrationPassword(signUpData.getPassword())
				.selectCountry(signUpData.getCountry()).acceptTnC().clickSIGNUP();
		return PageFactory.initElements(driver, CompleteProfile.class);
	}
	
	public SignUp signUp(){
		signUp.click();
//		SignUp newUser = PageFactory.initElements(driver, SignUp.class);
//		newUser.gmailUser(signUpData);
		return PageFactory.initElements(driver, SignUp.class);
	}
	
	public CompleteProfile signUpFB(SignUpData signUpData){
		signUp.click();
		SignUp newUser = PageFactory.initElements(driver, SignUp.class);
		newUser.createFBUser(signUpData);
		return PageFactory.initElements(driver, CompleteProfile.class);
	}
	
	public UserHomePage signUpExistingUser(SignUpData signUpData){
		signUp.click();
		String handle = driver.getWindowHandle();
		for (String handle1 : driver.getWindowHandles()) {
			if (!handle1.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle1);
			}
		}
		SignUp signUp = PageFactory.initElements(driver, SignUp.class);
		signUp.loginFromSignUp(signUpData);
		driver.switchTo().window(handle);
		UserHomePage userHomePage=PageFactory.initElements(driver, UserHomePage.class);
		userHomePage.checkLoginStatus(signUpData.getLoginId());
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public UserHomePage loginExistingUser(SignUpData signUpData){
		login.click();
		Login login = PageFactory.initElements(driver, Login.class);
		login.login(signUpData).closeDiscountPopupIfAvailable();
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public UserHomePage loginExistingUserMDM(SignUpData signUpData){
		loginMDM.click();
		Login login = PageFactory.initElements(driver, Login.class);
		login.login(signUpData);
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public LandingPage loginInvalidUser(SignUpData signUpData){
		login.click();
		Login login = PageFactory.initElements(driver, Login.class);
		login.loginInvalidUser(signUpData).checkLoginForInvalidUser(signUpData);
		return PageFactory.initElements(driver, LandingPage.class);
	}
	
	public Login login (){
		login.click();	
		return PageFactory.initElements(driver, Login.class);
	}
	
	public UserHomePage loginFBUser(SignUpData signUpData){
		login.click();
		Login login = PageFactory.initElements(driver, Login.class);
		login.loginUsingFB(signUpData).closeDiscountPopupIfAvailable();
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		UtilHBM.waitExplicitDisplayed(driver, home.welcomeLoginId);
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public UserHomePage loginGmailUser(SignUpData signUpData){
		login.click();
		Login login = PageFactory.initElements(driver, Login.class);
		login.loginUsingGmail(signUpData).closeDiscountPopupIfAvailable();
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		UtilHBM.waitExplicitDisplayed(driver, home.welcomeLoginId);
		return PageFactory.initElements(driver, UserHomePage.class);
	}
	
	public LandingPage checkLinksLayout(){		
		List<String> actualLinkText = new ArrayList<String>();		
		List<WebElement> anchorList = driver.findElements(By.tagName("a"));
		for(WebElement element:anchorList){
			System.out.println(element.getText());
			actualLinkText.add(element.getText());		
		}
		

		//Accept cookies
//		driver.findElement(By.id("accept-cookie-law")).click();
		
		/*assert actualLinkText.containsAll(linkText);		
	//Navigate to Gallery
		driver.findElement(By.linkText("Gallery")).click();
		
		
	//Navigate to Academy page
		driver.findElement(By.linkText("Academy")).click();
		//List<String> academyLinks = Arrays.asList("ACADEMY", "GALLERY", "LOG IN", "SIGN UP", "BATHROOM", "DECORATION", "EXTENSION", "INTERIOR DESIGN", "KITCHEN", "LIGHTING", "OUTDOOR", "All articles", "Articles", "5 Tips to Design Your Ideal Bathroom!", "Practical guide", "10 tips to install an Italian shower", "Practical guide", "How to light up a bathroom", "All articles", "Interview", "How to warm up your interior", "Practical guide", "How to choose a fireplace", "Interview", "Interior Design Ideas for Your Kid’s Room", "All articles", "Articles", "Increase the value of small spaces", "Practical guide", "Design your studio in 10 steps", "Articles", "5 Ways to Expand your Home", "All articles", "Articles", "How to apply Feng Shui principles to your interior", "academy", "An artistic atrium window", "Articles", "The best way to tidy up with Marie Kondo’s method", "All articles", "Articles", "Open or a Closed Kitchen: choose your style!", "Practical guide", "10 tips for a great kitchen lighting", "Articles", "Kitchen Layouts: 5 Ideas from the Experts", "All articles", "Articles", "5 Ways to Maximise Light in a Room: Tom Dixon’s Lighting", "Practical guide", "10 Tips for the Best Room Lighting", "Practical guide", "10 Expert Lighting Advices for Your Interior", "All articles", "Articles", "Terrace or balcony equipment safety rules", "Practical guide", "10 Tips to Design the Best Outdoor Kitchen", "Articles", "Decorating Ideas for Your Balcony", "Articles", "How to apply Feng Shui principles to your interior", "Practical guides", "10 tips to install an Italian shower", "Tutorials", "How to start a new project", "Design your home", "Exchange your project ideas", "Immerse yourself in your new interior", "Trial", "Tutorials", "Support", "Overview", "Our partners", "News", "General service conditions", "Privacy policy", "EN");
		//List<String> academyLinks = Arrays.asList("privacy policy", "cookies page", "ACADEMY", "GALLERY", "LOG IN", "SIGN UP", "BATHROOM", "DECORATION", "EXTENSION", "INTERIOR DESIGN", "KITCHEN", "LIGHTING", "OUTDOOR", "All articles", "Articles", "5 Tips to Design Your Ideal Bathroom!", "Practical guide", "10 tips to install an Italian shower", "Practical guide", "How to light up a bathroom", "All articles", "Interview", "How to warm up your interior", "Practical guide", "How to choose a fireplace", "Interview", "Interior Design Ideas for Your Kid’s Room", "All articles", "Articles", "Increase the value of small spaces", "Practical guide", "Design your studio in 10 steps", "Articles", "5 Ways to Expand your Home", "All articles", "Articles", "Veranda, a new room to extend your home!", "academy", "An artistic atrium window", "Articles", "Layout a small studio", "All articles", "Articles", "Open or a Closed Kitchen: choose your style!", "Practical guide", "10 tips for a great kitchen lighting", "Articles", "Kitchen Layouts: 5 Ideas from the Experts", "All articles", "Articles", "5 Ways to Maximise Light in a Room: Tom Dixon’s Lighting", "Practical guide", "10 Tips for the Best Room Lighting", "Practical guide", "10 Expert Lighting Advices for Your Interior", "All articles", "Articles", "Terrace or balcony equipment safety rules", "Practical guide", "10 Tips to Design the Best Outdoor Kitchen", "Articles", "Decorating Ideas for Your Balcony", "Articles", "Veranda, a new room to extend your home!", "Practical guides", "10 tips to install an Italian shower", "Tutorials", "How to name a room", "Design your home", "Exchange your project ideas", "Immerse yourself in your new interior", "Trial", "Tutorials", "Support", "Overview", "Our partners", "News", "General service conditions", "Privacy policy", "EN");
		List<String> actualAcademyLinks = new ArrayList<String>();
		List<WebElement> academy= driver.findElements(By.tagName("a"));				
		for (WebElement e:academy){
			actualAcademyLinks.add(e.getText());
			System.out.println(e.getText());						
		}
		//assert actualAcademyLinks.containsAll(academyLinks);
		
	//Navigate to home page		
		
		driver.findElement(By.cssSelector(".header-logo")).click();*/
	return new LandingPage(driver);
	}
	
	public LandingPage openHomebymeSite(String link){
		if (link.startsWith("prod")){
			driver.get(Setting.prodLink);
		}else{
			driver.get(Setting.preProdLink);			
		}
		try{
			driver.findElement(By.id("accept-cookie-law")).click();
		}catch (Exception e){
			UtilHBM.reportWarning("Accept cookies message not displayed");
		}		
		return PageFactory.initElements(driver, LandingPage.class);
	}
	
	public LandingPage verifyPage() {
		UtilHBM.waitExplicitDisplayed(driver, hbmLogo);
		Verification.displayOfWebElement(hbmLogo);
		Verification.VerifyEquals("Wrong inspiration link text displayed!!",
				inspirationLink.findElement(By.tagName("span")).getText(), "Inspiration");
//			Verification.VerifyEquals("Wrong solution link text displayed!!",
//					offersLink.findElement(By.tagName("span")).getText(), "Offers");
		Verification.VerifyEquals("Wrong pricing link text displayed!!",
				solutionLink.findElement(By.tagName("span")).getText(), "Solution");
		Verification.VerifyEquals("Wrong pricing link text displayed!!",
				proLink.findElement(By.tagName("span")).getText(), "Pro");
		Verification.VerifyEquals("Wrong login link text displayed!!", login.getText(), "Log in");
		Verification.VerifyEquals("Wrong signup link text displayed!!", signUp.getText(), "SIGN UP FREE");
		Verification.VerifyEquals("Wrong trialProjectInfoText displayed!!", trialProjectInfoText.getText(),
				"Find inspiration to furnish and decorate your home in 3D");
		Verification.VerifyEquals("Wrong signup link text displayed!!",
				tryNowButton.findElement(By.tagName("span")).getText(), "Sign up Free");
		Verification.displayOfWebElement(trialProjectInfoImg);
		Verification.displayOfWebElement(tabletPanelImg);
		Verification.VerifyEquals("Wrong signup link text displayed!!", inspirationText1.getText(),
				"Use the images of our community to find inspiration then create your own project and make amazing HD images to share with everyone");
		Verification.VerifyEquals("Wrong galleryGridText1 displayed!!", galleryGridText1.getText(),
				"Images created with talent by our users");
		Verification.VerifyEquals("Wrong galleryGridText2 displayed!!", galleryGridText2.getText(),
				"Get inspired by our HomeByMe community images to find ideas for your own project!");
//			Verification.VerifyEquals("Wrong beInspiraedButton text displayed!!", beInspiraedButton.getText(),
//					"Be inspired");
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(galleryGridImages.get(3)).build().perform();
		for (int i = 0; i < galleryGridImages.size(); i++) {
			String currentImgSrc = galleryGridImages.get(i).findElement(By.tagName("img")).getAttribute("src");
			if (!(currentImgSrc.contains("https://") && currentImgSrc.contains(".jpg"))) {
				UtilHBM.reportKO("Image not displayed correctly!!Img src : " + currentImgSrc);
			}
			Actions actions = new Actions(driver);
			actions.moveToElement(galleryGridImages.get(i)).build().perform();
			UtilHBM.waitFixTime(500);
			WebElement currentMaximizeButton = galleryGridImages.get(i)
					.findElement(By.cssSelector("div[class='colcade-item__maximize']"));
			UtilHBM.waitExplicitDisplayed(driver, currentMaximizeButton);
			UtilHBM.waitExplicitClickable(driver, currentMaximizeButton);
			Verification.displayOfWebElement(currentMaximizeButton);
			if (i == 0) {
				currentMaximizeButton.click();
				UtilHBM.waitFixTime(1000);
				String firstFullscreenImgSrc = fullscreenImages.get(0).getAttribute("src");
				String firstFullscreenImgSrc1 = firstFullscreenImgSrc.substring(0,
						firstFullscreenImgSrc.lastIndexOf("."));
				if (currentImgSrc.contains(firstFullscreenImgSrc1)) {
					UtilHBM.reportOK("Fullscreen image displayed for first image!!");
				} else {
					UtilHBM.reportKO("Fullscreen image not displayed for first image!!");
				}
				UtilHBM.waitExplicitClickable(driver, closeFullscreenImage);
				closeFullscreenImage.click();
				UtilHBM.waitFixTime(1000);
			}
		}
		Actions actions2=new Actions(driver);
		actions2.moveToElement(designYourFutureHomeTitle).build().perform();
		Verification.VerifyEquals("Wrong DesignYourFutureHomeTitle displayed!!", designYourFutureHomeTitle.getText(),
				"Design your future home");
		Verification.VerifyEquals("Wrong DesignYourFutureHomeText displayed!!", designYourFutureHomeText.getText(),
				"Both easy and intuitive, HomeByMe allows you to create your floor plans in 2D and furnish your home in 3D, while expressing your decoration style.");
		Verification.displayOfWebElement(designYourFutureHomeImg);
		actions2.moveToElement(furnishYourProjectTitle).build().perform();
		Verification.VerifyEquals("Wrong furnishYourProjectTitle displayed!!", furnishYourProjectTitle.getText(),
				"Furnish your project with real brands");
		Verification.VerifyEquals("Wrong furnishYourProjectText displayed!!", furnishYourProjectText.getText(),
				"Express your style with a catalog of branded products : furniture, rugs, wall and floor coverings...");
		Verification.displayOfWebElement(furnishYourProjectImg);
		actions2.moveToElement(makeAmazingHDTitle).build().perform();
		Verification.VerifyEquals("Wrong MakeAmazingHDTitle displayed!!", makeAmazingHDTitle.getText(),
				"Make amazing HD images");
		Verification.VerifyEquals("Wrong MakeAmazingHDText displayed!!", makeAmazingHDText.getText(),
				"Enhance your project with HD images and visualize it as in real life.");
		Verification.displayOfWebElement(makeAmazingHDImg);
		actions2.moveToElement(getFeedbacksFromFamilyTitle).build().perform();
		Verification.VerifyEquals("Wrong GetFeedbacksFromFamilyTitle displayed!!",
				getFeedbacksFromFamilyTitle.getText(), "Get feedbacks from family and pros");
		Verification.VerifyEquals("Wrong GetFeedbacksFromFamilyText displayed!!", getFeedbacksFromFamilyText.getText(),
				"Share online, exchange ideas with your friends, and ask for feedback from the HomeByMe community to get the most out of your project.");
		Verification.displayOfWebElement(getFeedbacksFromFamilyImg);
		actions2.moveToElement(takeYourProjectAnywhereTitle).build().perform();
		Verification.VerifyEquals("Wrong TakeYourProjectAnywhereTitle displayed!!",
				takeYourProjectAnywhereTitle.getText(), "Take your project anywhere with you");
		Verification.VerifyEquals("Wrong TakeYourProjectAnywhereText displayed!!",
				takeYourProjectAnywhereText.getText(),
				"Find inspiration to furnish and decorate your home in 3D or create your project on the go with the mobile app!");
		Verification.displayOfWebElement(takeYourProjectAnywhereImg);
		actions2.moveToElement(becomeanAmbassadorTitle).build().perform();
		Verification.VerifyEquals("Wrong becomeanAmbassadorTitle displayed!!", becomeanAmbassadorTitle.getText(),
				"Become an ambassador");
		Verification.VerifyEquals("Wrong becomeanAmbassadorText displayed!!", becomeanAmbassadorText.getText(),
				"Be part of our vibrant community of ambassadors to share your creativity online!");
		Verification.displayOfWebElement(becomeanAmbassadorVideo);

		UtilHBM.waitExplicitDisplayed(driver, videoPlaylistHeader);
		Verification.VerifyEquals("Wrong videoPlaylistHeader", videoPlaylistHeader.getText(),
				"All you need to design your home");
		Actions actions=new Actions(driver);
		actions.moveToElement(videoPlaylistItems.get(2).findElement(By.tagName("button"))).build().perform();
		for (int k = 0; k < 5; k++) {
			if (videoPlaylistItems.get(0).getAttribute("class").contains("is-active")) {
				videoPlaylistItems.get(0).findElement(By.tagName("button")).click();
				break;
			} 
			UtilHBM.waitFixTime(1000);
		}
		for (int j = 0; j < 3; j++) {
			if (videoPlaylistItems.get(j).getAttribute("class").contains("is-active")) {
				UtilHBM.reportOK("Active video number " + (j + 1) + "displayed from playlist");
			} else {
				UtilHBM.reportKO("Active video not selected after clicking");
			}
			UtilHBM.waitExplicitDisplayed(driver, videoPlaylistItems.get(j).findElement(By.xpath("div[1]")));
			WebElement videoPlaylistTitleCurrent = videoPlaylistItems.get(j).findElement(By.cssSelector("button>h4"));
			WebElement videoPlaylistTextCurrent = videoPlaylistItems.get(j).findElement(By.xpath("div[1]"));
			WebElement videoPlaylistSrcCurrent = videoPlaylistVideos.get(j).findElement(By.cssSelector("video>source"));
			Verification.VerifyEquals("Wrong videoPlaylistTitle Displayed for video : " + (j + 1),
					videoPlaylistTitleCurrent.getText(), videoPlaylistTitleExpected.get(j));
			Verification.VerifyEquals("Wrong videoPlaylistText Displayed for video : " + (j + 1),
					videoPlaylistTextCurrent.getText(), videoPlaylistTextExpected.get(j));
			Verification.VerifyEquals("Wrong videoPlaylistSrc Displayed for video : " + (j + 1),
					videoPlaylistSrcCurrent.getAttribute("src"), videoPlaylistSrcExpected.get(j));
			UtilHBM.waitFixTime(3100);
		}
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, LandingPage.class);
	}

	public ThreeDPlanner trialProject() {
		UtilHBM.waitExplicitDisplayed(driver, tryNowButton);
		UtilHBM.waitExplicitClickable(driver, tryNowButton);
		UtilHBM.reportInfo("Clicking on try now button to open trial project!!");
		tryNowButton.click();
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public SignUp clickTryNow() {
		UtilHBM.waitExplicitDisplayed(driver, tryNowButton);
		UtilHBM.waitExplicitClickable(driver, tryNowButton);
		UtilHBM.reportInfo("Clicking on try now button to open trial project!!");
		tryNowButton.click();
		return PageFactory.initElements(driver, SignUp.class);
	}

	public LandingPage verifyLanguages(String page) {
		String linksToTest = UtilHBM.getKeyValue(Setting.hyperlinks).get(page);
		System.out.println(linksToTest);
		String[] linkList = linksToTest.split(",");
		List<String> languageOptions = new ArrayList<>();
		languageOptions.add("EN");
		languageOptions.add("FR");
		languageOptions.add("DE");
		languageOptions.add("ES");
		int i = 0;
		Select select = new Select(languageSelect);
		for (String link : linkList) {
			Actions action = new Actions(driver);
			action.moveToElement(UtilHBM.webElement(driver, ".footer")).build().perform();
			select.selectByVisibleText(languageOptions.get(i));
			UtilHBM.waitFixTime(1000);
			if (page.equalsIgnoreCase("MDMLn")) {
				UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "html[class=''] .table>.cell>h1"));
			} else if (page.equalsIgnoreCase("HBMLn")) {
				UtilHBM.waitExplicitDisplayed(driver,
						UtilHBM.webElement(driver, "div.page.page--home>div>div>div>div>div>div>h1"));
			}
			UtilHBM.reportInfo("Verifying link in " + link);
			if (driver.getCurrentUrl().contains("/" + link.split(" ")[1].toLowerCase() + "/")) {
				UtilHBM.reportOK("URL contains " + link.split(" ")[1] + " keyword");
			} else {
				UtilHBM.reportKO("URL does not contains " + link.split(" ")[1] + " keyword");
			}
			for (String str : UtilHBM.getKeyValue(Setting.hyperlinks).keySet()) {
				if (str.startsWith(link + " css")) {
					String cssPath = UtilHBM.getKeyValue(Setting.hyperlinks).get(str).split("==")[0];
					String text = UtilHBM.getKeyValue(Setting.hyperlinks).get(str).split("==")[1];
					Verification.displayNAttributeCheckOfElementExcludeLineBreak(UtilHBM.webElement(driver, cssPath),
							"Text " + str + " in " + link, "text", text);
				}
			}
			i++;
		}

		Actions action = new Actions(driver);
		action.moveToElement(UtilHBM.webElement(driver, ".footer")).build().perform();
		UtilHBM.waitFixTime(1000);
		select.selectByVisibleText("EN");
		return PageFactory.initElements(driver, LandingPage.class);
	}
	
	public LandingPage verifyLanguagesHBMFor(String page) {
		String linksToTest = UtilHBM.getKeyValue(Setting.hyperlinks).get(page);
		System.out.println(linksToTest);
		String[] linkList = linksToTest.split(",");
		for (String link : linkList) {
			Actions action = new Actions(driver);
			action.moveToElement(UtilHBM.webElement(driver, ".footer-bar-left")).build().perform();
			WebElement languageBar = UtilHBM.webElement(driver, ".footer-bar-lang>li>a");
			action.moveToElement(languageBar).build().perform();
			UtilHBM.waitFixTime(1000);
			WebElement element = driver.findElement(By.linkText(link.split(" ")[1]));
			element.click();
			if (page.equalsIgnoreCase("HBMForLn")) {
				UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, ".table>.cell>h1"));
			} else if (page.equalsIgnoreCase("HBMLn")) {
				UtilHBM.waitExplicitDisplayed(driver,
						UtilHBM.webElement(driver, "html[class=''] .wrapper.u-txtCenter>.u-mbs"));
			}
			UtilHBM.reportInfo("Verifying link in " + link);
			if (driver.getCurrentUrl().contains("/" + link.split(" ")[1].toLowerCase() + "/")) {
				UtilHBM.reportOK("URL contains " + link.split(" ")[1] + " keyword");
			} else {
				UtilHBM.reportKO("URL does not contains " + link.split(" ")[1] + " keyword");
			}
			for (String str : UtilHBM.getKeyValue(Setting.hyperlinks).keySet()) {
				if (str.startsWith(link + " css")) {
					String cssPath = UtilHBM.getKeyValue(Setting.hyperlinks).get(str).split("==")[0];
					String text = UtilHBM.getKeyValue(Setting.hyperlinks).get(str).split("==")[1];
					Verification.displayNAttributeCheckOfElementExcludeLineBreak(UtilHBM.webElement(driver, cssPath),
							"Text " + str + " in " + link, "text", text);
				}
			}
		}

		Actions action = new Actions(driver);
		action.moveToElement(UtilHBM.webElement(driver, ".footer-bar-left")).build().perform();
		WebElement languageBar = UtilHBM.webElement(driver, ".footer-bar-lang>li>a");
		action.moveToElement(languageBar).build().perform();
		UtilHBM.waitFixTime(1000);
		WebElement element = driver.findElement(By.linkText("EN"));
		UtilHBM.reportOK("Opening URL in language " + element.getAttribute("title"));
		element.click();
		return PageFactory.initElements(driver, LandingPage.class);
	}

	public DecorationInspiration goToInspiration() {
		UtilHBM.waitExplicitDisplayed(driver, inspirationLink);
		UtilHBM.waitExplicitClickable(driver, inspirationLink);
		Verification.VerifyEquals("Wrong inspiration link text displayed!!",
				inspirationLink.findElement(By.tagName("span")).getText(), "Inspiration");
		UtilHBM.reportInfo("Clicking on inspiration page link!!");
		inspirationLink.click();
		return PageFactory.initElements(driver, DecorationInspiration.class);
	}
	
	public Magazine goToMagazine() {
		UtilHBM.waitExplicitDisplayed(driver, magazine);
		UtilHBM.waitExplicitClickable(driver, magazine);
		magazine.click();
		return PageFactory.initElements(driver, Magazine.class);
	}

	public OurOffers goToOffers() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.HOME);
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, offersLink);
		UtilHBM.waitExplicitClickable(driver, offersLink);
		offersLink.click();
//		UtilHBM.waitExplicitDisplayed(driver, UtilHBM.webElement(driver, "div.page.page--pricing"));
//		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("#kmab-container-7704-close")));
//		UtilHBM.waitExplicitClickable(driver, driver.findElement(By.cssSelector("#kmab-container-7704-close")));
//		WebElement notInterested2 = driver.findElement(By.cssSelector("#kmab-container-7704-close"));
//		notInterested2.click();
		return PageFactory.initElements(driver, OurOffers.class);
	}
	
	public BecomeAPartner goToBrandPage() {
		UtilHBM.waitExplicitDisplayed(driver, brandLink);
		UtilHBM.waitExplicitClickable(driver, brandLink);
		brandLink.click();
		return PageFactory.initElements(driver, BecomeAPartner.class);
	}
	
	public CommunityContent goToCommunityContent() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.END);
		UtilHBM.waitFixTime(1000);
		UtilHBM.waitExplicitDisplayed(driver, communityContent);
		UtilHBM.waitExplicitClickable(driver, communityContent);
		communityContent.click();
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("div.feed-view>div>div#header-text>h1")));
		return PageFactory.initElements(driver, CommunityContent.class);
	}
	
	public LandingPage verifyPageTitle() {
		UtilHBM.waitExplicitDisplayed(driver, hbmLogo);
		String pageTitle = driver.getTitle();
		if (pageTitle.equals("Home inspirations trends and decorating ideas | HomeByMe")) {
			UtilHBM.reportOK("Landing page displayed after logging out!!");
		} else {
			UtilHBM.reportKO("Landing page not displayed after logging out!!");
			Assert.assertFalse(pageTitle.contains("Error"));
		}
		return this;
	}
	
	public void goToAmbassadorPage() {
//		UtilHBM.waitExplicitDisplayed(driver, becomeanAmbassadorButton);
//		UtilHBM.waitExplicitClickable(driver, becomeanAmbassadorButton);
//		becomeanAmbassadorButton.click();
	}


/*---------------------Following methods are used for mobile automation---------------------*/
	
	public LandingPage verifyPlayStoreBanner() {
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("div.smartbanner-container>span")));
		WebElement bannerHBMLogo = driver.findElement(By.cssSelector("div.smartbanner-container>span"));
		if (bannerHBMLogo.getAttribute("style").contains(
				"url(https://d22oxwf9h3y4am.cloudfront.net/assets/app/themes/homebyme/resources/public/favicons/smart-app-banner-icon.png)")) {
			UtilHBM.reportOK("bannerHBMLogo displayed");
		} else {
			UtilHBM.reportKO(
					"bannerHBMLogo not displayed correctly!!Expected URL: https://d22oxwf9h3y4am.cloudfront.net/assets/app/themes/homebyme/resources/public/favicons/smart-app-banner-icon.png , Avaialble : "
							+ bannerHBMLogo.getAttribute("style"));
		}
		WebElement bannerTitle = driver.findElement(By.cssSelector("div.smartbanner-info>.smartbanner-title"));
		WebElement bannerSubTitle = driver.findElement(By.cssSelector("div.smartbanner-info>span"));
		Verification.VerifyEquals("Wrong bannerTitle", bannerTitle.getText(), "HomeByMe");
		Verification.VerifyEquals("Wrong bannerSubTitle", bannerSubTitle.getText(), "FREE - In Google Play");
		WebElement bannerViewButton = driver.findElement(By.cssSelector("a.smartbanner-button"));
		Verification.VerifyEquals("Wrong bannerViewButton", bannerViewButton.getText(), "VIEW");
		return this;
	}

	public LandingPage closePlayStoreBanner() {
		UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("a.smartbanner-close")));
		UtilHBM.waitExplicitClickable(driver, driver.findElement(By.cssSelector("a.smartbanner-close")));
		driver.findElement(By.cssSelector("a.smartbanner-close")).click();
		return this;
	}

	public HeaderMenusMobile clickHeaderMenuMobile() {
		UtilHBM.waitExplicitDisplayed(driver, headerMenuMobile);
		UtilHBM.waitExplicitClickable(driver, headerMenuMobile);
		headerMenuMobile.click();
		UtilHBM.waitFixTime(2000);
		return PageFactory.initElements(driver, HeaderMenusMobile.class);
	}

	public LandingPage verifyPageMobile() {
		UtilHBM.waitExplicitDisplayed(driver, hbmLogo);
		Verification.displayOfWebElement(hbmLogo);
		Verification.VerifyEquals("Wrong trialProjectInfoText displayed!!", trialProjectInfoText.getText(),
				"Find inspiration to furnish and decorate your home in 3D");
		Verification.VerifyEquals("Wrong signup link text displayed!!",
				tryNowButton.findElement(By.tagName("span")).getText(), "Sign up Free");
		Verification.displayOfWebElement(trialProjectInfoImg);
		Verification.displayOfWebElement(tabletPanelImg);
		Verification.VerifyEquals("Wrong signup link text displayed!!", inspirationText1.getText(),
				"Use the images of our community to find inspiration then create your own project and make amazing HD images to share with everyone");
		Verification.VerifyEquals("Wrong galleryGridText1 displayed!!", galleryGridText1.getText(),
				"Images created with talent by our users");
		Verification.VerifyEquals("Wrong galleryGridText2 displayed!!", galleryGridText2.getText(),
				"Get inspired by our HomeByMe community images to find ideas for your own project!");
		List<WebElement> galleryGridImages = driver.findElements(
				By.cssSelector("div.gallery-grid__container>div.gallery-grid__layout>div.colcade>div.colcade-col>a"));
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(galleryGridImages.get(2)).build().perform();
		UtilHBM.waitFixTime(1000);
		for (int i = 0; i < galleryGridImages.size(); i++) {
			if (i == 3 || i == 6) {
				TouchActions action1 = new TouchActions(driver);
				action1.moveToElement(galleryGridImages.get(i)).build().perform();
				UtilHBM.waitFixTime(1000);
			}
			String currentImgSrc = galleryGridImages.get(i).findElement(By.tagName("img")).getAttribute("src");
			if (!(currentImgSrc.contains("https://") && currentImgSrc.contains(".jpg"))) {
				UtilHBM.reportKO("Image not displayed correctly!!Img src : " + currentImgSrc);
			}
		}
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(designYourFutureHomeTitle).build().perform();
		Verification.VerifyEquals("Wrong DesignYourFutureHomeTitle displayed!!", designYourFutureHomeTitle.getText(),
				"Design your future home");
		Verification.VerifyEquals("Wrong DesignYourFutureHomeText displayed!!", designYourFutureHomeText.getText(),
				"Both easy and intuitive, HomeByMe allows you to create your floor plans in 2D and furnish your home in 3D, while expressing your decoration style.");
		Verification.displayOfWebElement(designYourFutureHomeImg);
		actions2.moveToElement(furnishYourProjectTitle).build().perform();
		Verification.VerifyEquals("Wrong furnishYourProjectTitle displayed!!", furnishYourProjectTitle.getText(),
				"Furnish your project with real brands");
		Verification.VerifyEquals("Wrong furnishYourProjectText displayed!!", furnishYourProjectText.getText(),
				"Express your style with a catalog of branded products : furniture, rugs, wall and floor coverings...");
		Verification.displayOfWebElement(furnishYourProjectImg);
		actions2.moveToElement(makeAmazingHDTitle).build().perform();
		Verification.VerifyEquals("Wrong MakeAmazingHDTitle displayed!!", makeAmazingHDTitle.getText(),
				"Make amazing HD images");
		Verification.VerifyEquals("Wrong MakeAmazingHDText displayed!!", makeAmazingHDText.getText(),
				"Enhance your project with HD images and visualize it as in real life.");
		Verification.displayOfWebElement(makeAmazingHDImg);
		actions2.moveToElement(getFeedbacksFromFamilyTitle).build().perform();
		Verification.VerifyEquals("Wrong GetFeedbacksFromFamilyTitle displayed!!",
				getFeedbacksFromFamilyTitle.getText(), "Get feedbacks from family and pros");
		Verification.VerifyEquals("Wrong GetFeedbacksFromFamilyText displayed!!", getFeedbacksFromFamilyText.getText(),
				"Share online, exchange ideas with your friends, and ask for feedback from the HomeByMe community to get the most out of your project.");
		Verification.displayOfWebElement(getFeedbacksFromFamilyImg);
		actions2.moveToElement(takeYourProjectAnywhereTitle).build().perform();
		Verification.VerifyEquals("Wrong TakeYourProjectAnywhereTitle displayed!!",
				takeYourProjectAnywhereTitle.getText(), "Take your project anywhere with you");
		Verification.VerifyEquals("Wrong TakeYourProjectAnywhereText displayed!!",
				takeYourProjectAnywhereText.getText(),
				"Find inspiration to furnish and decorate your home in 3D or create your project on the go with the mobile app!");
		Verification.displayOfWebElement(takeYourProjectAnywhereImg);
		actions2.moveToElement(becomeanAmbassadorTitle).build().perform();
		Verification.VerifyEquals("Wrong becomeanAmbassadorTitle displayed!!", becomeanAmbassadorTitle.getText(),
				"Become an ambassador");
		Verification.VerifyEquals("Wrong becomeanAmbassadorText displayed!!", becomeanAmbassadorText.getText(),
				"Be part of our vibrant community of ambassadors to share your creativity online!");
		Verification.displayOfWebElement(becomeanAmbassadorVideo);
		UtilHBM.waitExplicitDisplayed(driver, videoPlaylistHeader);
		Verification.VerifyEquals("Wrong videoPlaylistHeader", videoPlaylistHeader.getText(),
				"All you need to design your home");
		Actions actions = new Actions(driver);
		actions.moveToElement(videoPlaylistItems.get(2).findElement(By.tagName("button"))).build().perform();
		TouchActions action2 = new TouchActions(driver);
		action2.scroll(0, 200);
		for (int k = 0; k < 5; k++) {
			if (!videoPlaylistItems.get(0).getAttribute("class").contains("is-active")) {
				videoPlaylistItems.get(0).findElement(By.tagName("button")).click();
				break;
			}
			UtilHBM.waitFixTime(1000);
		}
		for (int j = 0; j < 3; j++) {
			Actions actions11 = new Actions(driver);
			actions11.moveToElement(
					videoPlaylistItems.get(j).findElement(By.xpath("div[contains(@class,'video-playlist__video')]")))
					.build().perform();
			if (videoPlaylistItems.get(j).getAttribute("class").contains("is-active")) {
				UtilHBM.reportOK("Active video number " + (j + 1) + "displayed from playlist");
			} else {
				UtilHBM.reportKO("Active video not selected after clicking");
			}
			UtilHBM.waitExplicitDisplayed(driver, videoPlaylistItems.get(j).findElement(By.xpath("div[1]")));
			WebElement videoPlaylistTitleCurrent = videoPlaylistItems.get(j).findElement(By.cssSelector("button>h4"));
			WebElement videoPlaylistTextCurrent = videoPlaylistItems.get(j).findElement(By.xpath("div[1]"));
			WebElement videoPlaylistSrcCurrent = videoPlaylistItems.get(j)
					.findElement(By.xpath("div[contains(@class,'video-playlist__video')]"))
					.findElement(By.cssSelector("video>source"));
			Verification.VerifyEquals("Wrong videoPlaylistTitle Displayed for video : " + (j + 1),
					videoPlaylistTitleCurrent.getText(), videoPlaylistTitleExpected.get(j));
			Verification.VerifyEquals("Wrong videoPlaylistText Displayed for video : " + (j + 1),
					videoPlaylistTextCurrent.getText(), videoPlaylistTextExpected.get(j));
			Verification.VerifyEquals("Wrong videoPlaylistSrc Displayed for video : " + (j + 1),
					videoPlaylistSrcCurrent.getAttribute("src"), videoPlaylistSrcExpected.get(j));
			UtilHBM.waitFixTime(3100);
		}
		return PageFactory.initElements(driver, LandingPage.class);
	}
}