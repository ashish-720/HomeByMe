package hbm.web.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.Verification;

public class ShareYourIdeas {
	WebDriver driver;
	
	public ShareYourIdeas(WebDriver driver){
		this.driver = driver;		
	}
	
	@FindBy(css="body>main>div>#intro>div>article>div:nth-child(1)>h1")
	WebElement syiPageHeader1;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(1)>div>h2")
	WebElement syiPageHeader2;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(2)>div>h2")
	WebElement syiPageHeader3;
		
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(3)>div>h2")
	WebElement syiPageHeader4;
	
	@FindBy(css="body>main>div>#intro>div>article>div:nth-child(1)>p")
	WebElement syiHeader1Desc1;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(1)>div>p:nth-child(2)")
	WebElement syiHeader2Desc1;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(1)>div>p:nth-child(3)")
	WebElement syiHeader2Desc2;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(2)>div>p")
	WebElement syiHeader3Desc1;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(3)>div>p")
	WebElement syiHeader4Desc1;
	
	@FindBy(css="body>main>#features>section.pleine-page-hero>div>div>p")
	WebElement syiLastMessage;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(1)>figure>img")
	WebElement exchangeWithTheCommunityImage;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(2)>figure>img")
	WebElement needHelpWithYourProjectImage;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(3)>figure>img")
	WebElement communicateEasilyAboutYourProjectImage;
	
	@FindBy(css="body>main>div>#intro>div>article>div:nth-child(1)>a")
	WebElement visitTheProjectGalleryButton;
	
	@FindBy(css=".button.button--big.js-open-ajax-modal")
	WebElement startNowButton;
	
	private String syiHeader1Desc1Text="Share online, exchange ideas with your friends, and ask for feedback from the Homebyme community to get the most out of your project.";
	private String syiHeader2Desc1Text="Be proud of your creations and become a source of inspiration for the Homebyme community by sharing the story of your projects both on your project page and on the social networks.";
	private String syiHeader2Desc2Text="Share your floor plans or realistic images with your family, friends, and professionals to get ideas and suggestions for improving your project.";
	private String descImage1="https://preprod-home.by.me/dist/images/features/en/echanger-avec-communautee.26605efb69bf7a5508f4e40f3342c570.jpg";
	private String syiHeader3Desc1Text="Talk to other Homebyme community members and meet users who have a similar project. You'll be able to exchange with them to find the answers to questions that arise as you create your project.";
	private String descImage2="https://preprod-home.by.me/dist/images/features/en/poser-question.c210796bb037f5d29acdf83667a67fcd.jpg";
	private String syiHeader4Desc1Text="Homebyme is a service for exchanging ideas allowing you to simplify your discussions and easily share your floor plans with housing professionals by submitting your 3D mockups, 360° images or realistic images directly to them.";
	private String descImage3="https://preprod-home.by.me/dist/images/features/rendu-hd.df5580ed2e27c157a47aea2d7a5405e4.jpg";
	
	public LandingPage verifyPage()
	{
		Verification.VerifyEquals("PageHeader text not displayed", syiPageHeader1.getText(), "Share Your Project Ideas");
		Verification.VerifyEquals("PageHeader Desc text not displayed",syiHeader1Desc1.getText(), syiHeader1Desc1Text);
		Verification.disabledWebElement(visitTheProjectGalleryButton);
		Verification.VerifyEquals("PageHeader text not displayed", syiPageHeader2.getText(), "Exchange with the community");
		Verification.VerifyEquals("PageHeader Desc text not displayed",syiHeader2Desc1.getText(), syiHeader2Desc1Text);
		Verification.VerifyEquals("PageHeader Desc text not displayed",syiHeader2Desc2.getText(), syiHeader2Desc2Text);
		Verification.VerifyEquals("Image not displayed", descImage1, exchangeWithTheCommunityImage.getAttribute("src"));
		Verification.VerifyEquals("PageHeader text not displayed", syiPageHeader3.getText(), "NEED HELP WITH YOUR PROJECT?");
		Verification.VerifyEquals("PageHeader Desc text not displayed",syiHeader3Desc1.getText(), syiHeader3Desc1Text);
		Verification.VerifyEquals("Image not displayed", descImage2, needHelpWithYourProjectImage.getAttribute("src"));
		Verification.VerifyEquals("PageHeader text not displayed", syiPageHeader4.getText(), "COMMUNICATE EASILY ABOUT YOUR PROJECT");
		Verification.VerifyEquals("PageHeader Desc text not displayed",syiHeader4Desc1.getText(), syiHeader4Desc1Text);
		Verification.VerifyEquals("Image not displayed", descImage3, communicateEasilyAboutYourProjectImage.getAttribute("src"));
		Verification.VerifyEquals("PageHeader text not displayed", syiLastMessage.getText(), "ET VOILÀ!"+"\n"+"IT'S YOUR TURN NOW");
		Verification.displayOfWebElement(startNowButton);
		return PageFactory.initElements(driver, LandingPage.class);
	}
}
