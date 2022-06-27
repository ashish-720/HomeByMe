package hbm.web.pageobject;

import hbm.planner.utility.Verification;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OurPartners {
	WebDriver driver;
	
	public OurPartners(WebDriver driver){
		this.driver = driver;		
	}
	
	@FindBy(css="body>div.site>div>div>main>div.subheader.subheader--partners.container>header.subheader__inner>h1")
	WebElement parPageHeader1;
	
	@FindBy(css="body>div.site>div>div>main>div.subheader.subheader--partners.container>header.subheader__inner>div>p")	
	WebElement parHeader1Desc1;
	
	@FindBy(css="body>div.site>div>div>main>div.section--partners.container>ul>li.grid--partners__p>div.inner")	
	WebElement parHeader1Desc2;	
	
	@FindBy(css="body>div.site>div>div>main>div.section--partners.container>ul>li.grid--partners__p>div.add-your-brand.hidden-tablet")
	WebElement parPageHeader2;
	
	@FindBy(css="li>img.picture.picture--centered")
	List<WebElement> list;
	
	private String parHeader1Desc1Text="Homebyme is an online 3D space planning service for consumers which allows them to imagine, design and share housing projects in 3D using real furniture, appliances and home decor similar to your own.";
	private String parHeader1Desc2Text="Let’s go and meet your clients! Add your brand to Homebyme’s catalog.\n"+"Complete the form to have a Homebyme representative contact you about getting started.\n"+"BECOME A PARTNER";
	
	public LandingPage verifyPage()
	{
		Verification.VerifyEquals("PageHeader text not displayed", parPageHeader1.getText(), "PARTNERS");
		Verification.VerifyEquals("PageHeader Desc text not displayed",parHeader1Desc1.getText(), parHeader1Desc1Text);
		Verification.VerifyEquals("PageHeader Desc text not displayed",parHeader1Desc2.getText(), parHeader1Desc2Text);
		Verification.VerifyEquals("PageHeader text not displayed", parPageHeader2.getText(), "Add Your brand");
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getAttribute("src").contains("jpg")||list.get(i).getAttribute("src").contains("jpeg")||list.get(i).getAttribute("src").contains("png"))
			{
				System.out.println(list.get(i).getAttribute("src")+" is valid");
			}
			if(i==list.size()-1)
			{
				WebElement we=list.get(i);
				Verification.displayOfWebElement(we);
			}
		}

		return PageFactory.initElements(driver, LandingPage.class);
	}
}
