package hbm.web.pageobject;

import hbm.planner.utility.Verification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesignYourHome {
	WebDriver driver;
	
	public DesignYourHome(WebDriver driver){
		this.driver = driver;		
	}	
	
	@FindBy (css="body>main>div>#intro>div>article>div:nth-child(1)>h1")
	WebElement dyhPageHeader1;
	
	@FindBy(css="body>main>div#features>section.row-2col>div>article:nth-child(1)>div>h2")
	WebElement dyhPageHeader2;
	
	@FindBy(css="body>main>div#features>section.row-2col>div>article:nth-child(2)>div>h2")
	WebElement dyhPageHeader3;
	
	@FindBy(css="body>main>div#features>section.row-2col>div>article:nth-child(3)>div>h2")
	WebElement dyhPageHeader4;
	
	@FindBy(css="body>main>div#features>section.row-2col>div>article:nth-child(4)>div>h2")
	WebElement dyhPageHeader5;
	
	@FindBy (css="body>main>#features>#intro>div>article>div:nth-child(1)>p")
	WebElement dyhHeader1Desc;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(1)>div>p:nth-child(2)")
	WebElement dyhHeader2Desc1;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(1)>div>p:nth-child(3)")
	WebElement dyhHeader2Desc2;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(1)>div>p:nth-child(4)")
	WebElement dyhHeader2Desc3;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(2)>div>p:nth-child(2)")
	WebElement dyhHeader3Desc1;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(2)>div>p:nth-child(3)")
	WebElement dyhHeader3Desc2;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(3)>div>p:nth-child(2)")
	WebElement dyhHeader4Desc1;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(3)>div>p:nth-child(3)")
	WebElement dyhHeader4Desc2;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(3)>div>p:nth-child(4)")
	WebElement dyhHeader4Desc3;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(4)>div>p:nth-child(2)")
	WebElement dyhHeader5Desc1;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(4)>div>p:nth-child(3)")
	WebElement dyhHeader5Desc2;
	
	@FindBy(css="body>main>#features>section.pleine-page-hero>div>div>p")
	WebElement dyhLastMessage;
	
	@FindBy(css="body>main>div>#intro>div>article>div:nth-child(1)>a")
	WebElement tryNowButton;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(1)>div>a")
	WebElement createYour2dButton;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(2)>div>a")
	WebElement makeYour3dPlanButton;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(3)>div>a")
	WebElement decorateYourInteriorButton;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(4)>div>a")
	WebElement discoverOurServiceButton;
		
	@FindBy(css=".button.button--big.js-open-ajax-modal")
	WebElement startNowButton;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(1)>figure>img")
	WebElement floorPlanImg;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(2)>figure>img")
	WebElement furnishYourHomeImage;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(3)>figure>img")
	WebElement expressYourStyleImage;
	
	@FindBy(css="body>main>#features>section.row-2col>div>article:nth-child(4)>figure>img")
	WebElement letUsHelpYouImage;
	
	private String dyhHeader1DescText="Use Homebyme to design your home in 3D. Both easy and intuitive, Homebyme allows you to create your floor plans in 2D and furnish your home in 3D, while expressing your decoration style.";
	private String dyhHeader2DescText1="Quickly sketch a detailed 2D plan to get a first glimpse at your project layout using our home creation tool.";
	private String dyhHeader2DescText2="Import your floor plans, create your rooms, add doors and windows, and then add floors and stairs if necessary.";
	private String dyhHeader2DescText3="If you do not want to create your floorplan, Homebyme can do it for you!";
	private String descImage1="https://preprod-home.by.me/dist/images/features/en/realiser-plan-2D.437df2b65687dd6165c15494ff23f606.gif";
	private String dyhHeader3DescText1="Your 2D plan is finished? View the 3D plan to bring your project to life.";
	private String dyhHeader3DescText2="Use the avatar to move from room to room to explore your new home.";
	private String descImage2="https://preprod-home.by.me/dist/images/features/en/donner-vie-plan-3D.34b50ace1ab56e990aa6ba9ba9deb1b1.gif";
	private String dyhHeader4DescText1="You’ll find everything you need to express your style in the catalog : furniture, lighting, rugs… Create the home of your dreams!";
	private String dyhHeader4DescText2="If necessary, our designers can also redesign your interior!";
	private String dyhHeader4DescText3="Simulate various scenarios by playing with different wall and floor coverings. Give your space a fresh new look in a few clicks.";
	private String descImage3="https://preprod-home.by.me/dist/images/features/en/featured-products.be1441067f0f8ba784032c613047dc12.jpg";
	private String dyhHeader5DescText1="Homebyme can give you a hand by turning your floorplan into a 3D project at a good scale.";
	private String dyhHeader5DescText2="Then, up to you to transform, renovate and decorate it to infinity!";
	private String descImage4="https://preprod-home.by.me/dist/images/features/Visuel_Creer_Plan.e670820b58cad2bf9962fdc818c03348.jpg";
	
	public DesignYourHome verifyPage()
	{
		Verification.VerifyEquals("PageHeader text not displayed", dyhPageHeader1.getText(), "Design your home");
		Verification.VerifyEquals("PageHeader Desc text not displayed",dyhHeader1Desc.getText(), dyhHeader1DescText);
		Verification.VerifyEquals("PageHeader text not displayed", dyhPageHeader2.getText(), "CREATE YOUR FLOOR PLAN IN 2D");
		Verification.VerifyEquals("PageHeader Desc text not displayed", dyhHeader2Desc1.getText(), dyhHeader2DescText1);
		Verification.displayOfWebElement(tryNowButton);
		Verification.VerifyEquals("PageHeader Desc text not displayed", dyhHeader2Desc2.getText(), dyhHeader2DescText2);
		Verification.VerifyEquals("PageHeader Desc text not displayed", dyhHeader2Desc3.getText(), dyhHeader2DescText3);
		Verification.VerifyEquals("Video not displayed", descImage1, floorPlanImg.getAttribute("src"));
		Verification.displayOfWebElement(createYour2dButton);
		Verification.VerifyEquals("PageHeader text not displayed", dyhPageHeader3.getText(), "FURNISH YOUR HOME IN 3D");
		Verification.VerifyEquals("PageHeader Desc text not displayed", dyhHeader3Desc1.getText(), dyhHeader3DescText1);
		Verification.VerifyEquals("PageHeader Desc text not displayed", dyhHeader3Desc2.getText(), dyhHeader3DescText2);
		Verification.VerifyEquals("Video not displayed", descImage2, furnishYourHomeImage.getAttribute("src"));
		Verification.displayOfWebElement(makeYour3dPlanButton);
		Verification.VerifyEquals("PageHeader text not displayed", dyhPageHeader4.getText(), "EXPRESS YOUR STYLE");
		Verification.VerifyEquals("PageHeader Desc text not displayed", dyhHeader4Desc1.getText(), dyhHeader4DescText1);
		Verification.VerifyEquals("PageHeader Desc text not displayed", dyhHeader4Desc2.getText(), dyhHeader4DescText2);
		Verification.VerifyEquals("PageHeader Desc text not displayed", dyhHeader4Desc3.getText(), dyhHeader4DescText3);
		Verification.VerifyEquals("Video not displayed", descImage3, expressYourStyleImage.getAttribute("src"));
		Verification.displayOfWebElement(decorateYourInteriorButton);
		Verification.VerifyEquals("PageHeader text not displayed", dyhPageHeader5.getText(), "LET US HELP YOU");
		Verification.VerifyEquals("PageHeader Desc text not displayed", dyhHeader5Desc1.getText(), dyhHeader5DescText1);
		Verification.VerifyEquals("PageHeader Desc text not displayed", dyhHeader5Desc2.getText(), dyhHeader5DescText2);
		Verification.VerifyEquals("PageHeader text not displayed", dyhLastMessage.getText(), "ET VOILÀ!"+"\n"+"IT'S YOUR TURN NOW");
		Verification.VerifyEquals("FloorPlan Video not displayed", descImage4, letUsHelpYouImage.getAttribute("src"));
		Verification.displayOfWebElement(discoverOurServiceButton);
		Verification.displayOfWebElement(startNowButton);
		return PageFactory.initElements(driver, DesignYourHome.class);
		
		
	}
}
