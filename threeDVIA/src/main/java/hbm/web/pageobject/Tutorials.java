package hbm.web.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.Verification;

public class Tutorials {
	WebDriver driver;
	
	public Tutorials(WebDriver driver){
		this.driver = driver;		
	}
	@FindBy(css="body>div.site>div>div>main>div.subheader.subheader--category.container>header>h1")
	WebElement tutPageHeader1;
	
	@FindBy(css="body>div.site>div>div>main>div.section.section--academy>div.container.containerFooterVignettes>footer>div.FooterVignettes--text>h1")
	WebElement tutPageHeader2;	
	
	@FindBy(css="div[class='fRight text-tutoriaux']>h2>a[href='/en/academy/articles/']")
	WebElement tutPageHeader3;
	
	@FindBy(css="div[class='fRight text-tutoriaux']>h2>a[href='/en/academy/practical-guide/']")
	WebElement tutPageHeader4;
	
	@FindBy(css="div[class='fRight text-tutoriaux']>h2>a[href='/en/academy/tutorials/']")
	WebElement tutPageHeader5;
	
	@FindBy(css="body>div.site>div>div>main>div.subheader.subheader--category.container>header>div>p:nth-child(2)")
	WebElement tutHeader1Desc1;
		
	@FindBy(css="div[class='fRight text-tutoriaux']>span>a[href='/en/academy/post/cerused-wood-welcome-home-to-natural-wood-grain/']")
	WebElement tutHeader3Desc1;
	
	@FindBy(css="div[class='fRight text-tutoriaux']>span>a[href='/en/academy/post/christmas-decorations-part-of-the-holiday-cheer/']")
	WebElement tutHeader4Desc1;
	
	@FindBy(css="div[class='fRight text-tutoriaux']>span>a[href='/en/academy/post/whats-homebyme/']")
	WebElement tutHeader5Desc1;
		
	@FindBy(css="a[title='What’s Homebyme ?']>img[src*='https://s3-eu-west-1.amazonaws.'][src$='.jpg']")
	WebElement whatsHomebymeImage;
	
	@FindBy(css="a[title='How to start a project']>img[src*='https://s3-eu-west-1.amazonaws.'][src$='.jpg']")
	WebElement howToStartAProjectImage;
	
	@FindBy(css="a[title='3 ways to start your project']>img[src*='https://s3-eu-west-1.amazonaws.'][src$='.jpg']")
	WebElement waysToStartYourProjectImage;
	
	@FindBy(css="a[title='How to add doors and windows']>img[src*='https://s3-eu-west-1.amazonaws.'][src$='.jpg']")
	WebElement howToAddDoorsAndWindowsImage;
	
	@FindBy(css="a[title='How to move furniture']>img[src*='https://s3-eu-west-1.amazonaws.'][src$='.jpg']")
	WebElement howToMoveFurnitureImage;
	
	@FindBy(css="a[title='How to move in your project']>img[src*='https://s3-eu-west-1.amazonaws.'][src$='.jpg']")
	WebElement howToMoveInYourProjectImage;
			
	@FindBy(css="a[title='How to customize walls and floors']>img[src*='https://s3-eu-west-1.amazonaws.'][src$='.jpg']")
	WebElement howToCustomizeWallsAndFloorsImage;
	
	@FindBy(css="a[title='How to use generic products']>img[src*='https://s3-eu-west-1.amazonaws.'][src$='.jpg']")
	WebElement howToUseGenericProductsImage;
	
	@FindBy(css="a[title='How to share your project']>img[src*='https://s3-eu-west-1.amazonaws.'][src$='.jpg']")
	WebElement howToShareYourProjectImage;
	
	@FindBy(css="a[title='How to duplicate an item']>img[src*='https://s3-eu-west-1.amazonaws.'][src$='.jpg']")
	WebElement howToDuplicateAnItemImage;
	
	@FindBy(css="a[title='How to import a floorplan']>img[src*='https://s3-eu-west-1.amazonaws.'][src$='.jpg']")
	WebElement howToImportAFloorplanImage;
	
	@FindBy(css="a[title='How to add a floor']>img[src*='https://s3-eu-west-1.amazonaws.'][src$='.jpg']")
	WebElement howToAddAFloorImage;

	@FindBy(css="a[title='How to create realistic images']>img[src*='https://s3-eu-west-1.amazonaws.'][src$='.jpg']")
	WebElement howToCreateRealisticImagesImage;
	
	@FindBy(css="a[title='How to customize your project page']>img[src*='https://s3-eu-west-1.amazonaws.'][src$='.jpg']")
	WebElement howToCustomizeYourProjectPageImage;
	
	@FindBy(css="a[title='How to name a room']>img[src*='https://s3-eu-west-1.amazonaws.'][src$='.jpg']")
	WebElement howToNameARoomImage;
	
	@FindBy(css="a[title='How to search by brand']>img[src*='https://s3-eu-west-1.amazonaws.'][src$='.jpg']")
	WebElement howToSearchByBrandImage;
	
	@FindBy(css="a[title='How to delete a project']>img[src*='https://s3-eu-west-1.amazonaws.'][src$='.jpg']")
	WebElement howToDeleteAProductImage;
	
	@FindBy(css="div[class='fLeft pictos']>img[src$='Academy_Home_15.jpg']")
	WebElement articlesLogoImage;
	
	@FindBy(css="div[class='fLeft pictos']>img[src$='Academy_Home_18.jpg']")
	WebElement practicalGuidesLogoImage;
	
	@FindBy(css="div[class='fLeft pictos']>img[src$='Academy_Home_21.jpg']")
	WebElement tutorialsLogoImage;
	
	@FindBy(css="div[class='FooterVignettes--image hidden-mobile']>img[src$='Academy_Home_13.jpg']")
	WebElement exploreImage;
	
	private String tutHeader1Desc1Text="Simple, fast and efficient, Homebyme tutorials give you all the tips and tricks to advance in the construction of your project.";
	private String tutHeader3Desc1Text="Cerused wood: Welcome home to natural wood grain";
	private String tutHeader4Desc1Text="Christmas decorations - part of the holiday cheer";
	private String tutHeader5Desc1Text="What's Homebyme ?";
			
	public LandingPage verifyPage()
	{
		Verification.VerifyEquals("PageHeader text not displayed", tutPageHeader1.getText(), "TUTORIALS");
		Verification.VerifyEquals("PageHeader Desc text not displayed",tutHeader1Desc1.getText(), tutHeader1Desc1Text);
		Verification.displayOfWebElement(whatsHomebymeImage);
		Verification.displayOfWebElement(howToStartAProjectImage);
		Verification.displayOfWebElement(waysToStartYourProjectImage);
		Verification.displayOfWebElement(howToAddDoorsAndWindowsImage);
		Verification.displayOfWebElement(howToMoveFurnitureImage);
		Verification.displayOfWebElement(howToMoveInYourProjectImage);
		Verification.displayOfWebElement(howToCustomizeWallsAndFloorsImage);
		Verification.displayOfWebElement(howToDuplicateAnItemImage);
		Verification.displayOfWebElement(howToImportAFloorplanImage);
		Verification.displayOfWebElement(howToUseGenericProductsImage);
		Verification.displayOfWebElement(howToShareYourProjectImage);
		Verification.displayOfWebElement(howToAddAFloorImage);
		Verification.displayOfWebElement(howToCreateRealisticImagesImage);
		Verification.displayOfWebElement(howToCustomizeYourProjectPageImage);
		Verification.displayOfWebElement(howToNameARoomImage);
		Verification.displayOfWebElement(howToSearchByBrandImage);
		Verification.displayOfWebElement(howToDeleteAProductImage);
		Verification.VerifyEquals("PageHeader text not displayed", tutPageHeader2.getText(), "Explore");
		Verification.displayOfWebElement(articlesLogoImage);
		Verification.displayOfWebElement(practicalGuidesLogoImage);
		Verification.displayOfWebElement(tutorialsLogoImage);
		Verification.displayOfWebElement(exploreImage);
		Verification.VerifyEquals("PageHeader text not displayed", tutPageHeader3.getText(), "Articles");
		Verification.VerifyEquals("PageHeader Desc text not displayed",tutHeader3Desc1.getText(), tutHeader3Desc1Text);
		Verification.VerifyEquals("PageHeader text not displayed", tutPageHeader4.getText(), "Practical guides");
		Verification.VerifyEquals("PageHeader Desc text not displayed",tutHeader4Desc1.getText(), tutHeader4Desc1Text);
		Verification.VerifyEquals("PageHeader text not displayed", tutPageHeader5.getText(), "Tutorials");
		Verification.VerifyEquals("PageHeader Desc text not displayed",tutHeader5Desc1.getText(), tutHeader5Desc1Text);
		return PageFactory.initElements(driver, LandingPage.class);
		
	}
}
