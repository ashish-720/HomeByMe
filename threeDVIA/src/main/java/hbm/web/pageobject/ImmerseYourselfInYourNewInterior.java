package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.Verification;

public class ImmerseYourselfInYourNewInterior {	
	WebDriver driver;
	
	public ImmerseYourselfInYourNewInterior(WebDriver driver){
		this.driver = driver;		
	}
	
	@FindBy(css="body>main>div>#intro>div>article>div:nth-child(1)>h1")
	WebElement iyiyniPageHeader1;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(1)>div>h2")
	WebElement iyiyniPageHeader2;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(2)>div>h2")
	WebElement iyiyniPageHeader3;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(3)>div>h2")
	WebElement iyiyniPageHeader4;
	
	@FindBy(css="body>main>div>#intro>div>article>div:nth-child(1)>p")
	WebElement iyiyniHeader1Desc1;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(1)>div>p")
	WebElement iyiyniHeader2Desc1;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(2)>div>p")
	WebElement iyiyniHeader3Desc1;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(3)>div>p")
	WebElement iyiyniHeader4Desc1;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(1)>figure>a:nth-child(1)>img")
	WebElement createRealisticImagesImg;
	
	@FindBy(css="#trigger-overlay-img>img")
	WebElement shareYour360ViewsImage;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(3)>figure>img")
	WebElement createVirtualToursImage;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(1)>div>a")
	WebElement iyiyniHeader2Link1;
		
	@FindBy(css="#trigger-overlay")
	WebElement iyiyniHeader3Link1;
	
	@FindBy(css="body>main>div>#intro>div>article>div:nth-child(1)>a")
	WebElement discoverTheProjectPageButton;
	
	@FindBy(css="body>main>#features>section.pleine-page-hero>div>div>p")
	WebElement iyiyniLastMessage;
	
	@FindBy(css=".button.button--big.js-open-ajax-modal")
	WebElement startNowButton;
	
	private String iyiyniHeader1Desc1Text="Be the first to explore your new home by creating realistic images of your project or visualizing it during a one-of-a-kind virtual tour.";
	private String iyiyniHeader2Desc1Text="As soon as you’re satisfied with your project, use our image engine to see a realistic representation of your interior, and then easily share your realistic images by e-mail or on your social networks.";
	private String descImage1="https://preprod-home.by.me/dist/images/features/rendu-hd-bon.ad8fa04e300a9d0db37da85d081a00b7.jpg";
	private String iyiyniHeader3Desc1Text="Don’t hesitate to share the 360° HD view of your project. This will enable you to get a global view of your project so you can share with your friends, as well as experts.";
	private String descImage2="https://preprod-home.by.me/dist/images/features/panoramic,w_480.7b468e56eb0499cd54cfeccda116d435.jpg";
	private String iyiyniHeader4Desc1Text="Invite your friends to visit your home and to move from one room to another thanks to the latest technologies at your disposal, such as cardboards, virtual reality helmets... Your project can be experienced in countless ways!";
	private String descImage3="https://preprod-home.by.me/dist/images/features/cardboard.28830dfbc14e37cb0cc9de983bd6b876.jpg";
	
	
	
	public LandingPage verifyPage()
	{
		Verification.VerifyEquals("PageHeader text not displayed", iyiyniPageHeader1.getText(), "IMMERSE YOURSELF IN YOUR NEW INTERIOR");	
		Verification.VerifyEquals("PageHeader Desc text not displayed",iyiyniHeader1Desc1.getText(), iyiyniHeader1Desc1Text);
		Verification.disabledWebElement(discoverTheProjectPageButton);
		Verification.VerifyEquals("PageHeader text not displayed", iyiyniPageHeader2.getText(), "CREATE REALISTIC IMAGES");
		Verification.VerifyEquals("PageHeader Desc text not displayed",iyiyniHeader2Desc1.getText(), iyiyniHeader2Desc1Text);
		Verification.disabledWebElement(iyiyniHeader2Link1);
		Verification.VerifyEquals("Image not displayed", descImage1, createRealisticImagesImg.getAttribute("src"));
		Verification.VerifyEquals("PageHeader text not displayed", iyiyniPageHeader3.getText(), "SHARE YOUR 360° VIEWS");
		Verification.VerifyEquals("PageHeader Desc text not displayed",iyiyniHeader3Desc1.getText(), iyiyniHeader3Desc1Text);
		Verification.disabledWebElement(iyiyniHeader3Link1);
		Verification.VerifyEquals("Image not displayed", descImage2, shareYour360ViewsImage.getAttribute("src"));
		Verification.VerifyEquals("PageHeader text not displayed", iyiyniPageHeader4.getText(), "CREATE VIRTUAL TOURS");
		Verification.VerifyEquals("PageHeader Desc text not displayed",iyiyniHeader4Desc1.getText(), iyiyniHeader4Desc1Text);
		Verification.VerifyEquals("Image not displayed", descImage3, createVirtualToursImage.getAttribute("src"));
		Verification.VerifyEquals("PageHeader text not displayed", iyiyniLastMessage.getText(), "ET VOILÀ!"+"\n"+"IT'S YOUR TURN NOW");
		Verification.displayOfWebElement(startNowButton);
		return PageFactory.initElements(driver, LandingPage.class);
	}
}
