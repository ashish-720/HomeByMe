package hbm.web.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class Overview {
	WebDriver driver;
	
	public Overview(WebDriver driver){
		this.driver = driver;		
	}
	
	@FindBy(css="body>div.site>div>div>main>div.subheader.container>header>h1")
	WebElement ovrPageHeader1;
	
	@FindBy(css="body>div.site>div>div>main>div.subheader.container>header>p")
	WebElement ovrHeader1Desc1;
	
	@FindBy(css="body>div.site>div>div>main>div.nav--about>div>nav>#menu-about>li>a[href='#overview']")
	WebElement ovrHeader1Link1;
	
	@FindBy(css="body>div.site>div>div>main>div.nav--about>div>nav>#menu-about>li>a[href='#press']")
	WebElement ovrHeader1Link2;
	
	@FindBy(css="body>div.site>div>div>main>div.nav--about>div>nav>#menu-about>li>a[href='#news']")
	WebElement ovrHeader1Link3;
	
	@FindBy(css="body>div.site>div>div>main>div.section--about>div>div.section--about__inner.overview>#overview>h2")
	WebElement ovrPageHeader2;
	
	@FindBy(css="body>div.site>div>div>main>div.section--about>div>div.section--about__inner.overview>#overview")
	WebElement ovrHeader2Desc1;
	
	@FindBy(css="body>div.site>div>div>main>div.section--about.fixed_helper>div>div.section--about__inner.press>#press>h2")
	WebElement ovrPageHeader3;
	
	@FindBy(css="body>div.site>div>div>main>div.section--about.fixed_helper>div>div.section--about__inner.press>#press>div>div.contact>h3")
	WebElement ovrHeader3SubHeader1;
	
	@FindBy(css="#imcontent>a")
	WebElement ovrHeader3Link1;
	
	@FindBy(css="body>div.site>div>div>main>div.section--about.fixed_helper>div>div.section--about__inner.press>#press>div>div.contact")
	WebElement ovrHeader3Desc1;
	
	@FindBy(css="body>div.site>div>div>main>div.section--about.fixed_helper>div>div.section--about__inner.press>#press>div>div.press>div:nth-child(1)>h3")
	WebElement ovrHeader3Desc2;
	
	@FindBy(css="body>div.site>div>div>main>div.section--about.fixed_helper>div>div.section--about__inner.press>#press>div>div.press>div:nth-child(1)>a[href$='DP-HBM_17022017_EN.pdf']")
	WebElement ovrHeader3Desc3;
	
	@FindBy(css="body>div.site>div>div>main>div.section--about.fixed_helper>div>div.section--about__inner.press>#press>div>div.press>div:nth-child(1)>aside")
	WebElement ovrHeader3Desc4;
	
	@FindBy(css="body>div.site>div>div>main>div.section--about.fixed_helper>div>div.section--about__inner.press>#press>div>div.press>div:nth-child(2)>h3")
	WebElement ovrHeader3Desc5;
	
	@FindBy(css="body>div.site>div>div>main>div.section--about.fixed_helper>div>div.section--about__inner.press>#press>div>div.press>div:nth-child(2)>a[href$='Media-Kit-EN.pdf']")
	WebElement ovrHeader3Desc6;
	
	@FindBy(css="body>div.site>div>div>main>div.section--about.fixed_helper>div>div.section--about__inner.press>#press>div>div.press>div:nth-child(2)>aside")
	WebElement ovrHeader3Desc7;
	
	@FindBy(css="body>div.site>div>div>main>div.section--about.fixed_helper>div>div.section--about__inner.news>#news > h2")
	WebElement ovrPageHeader4;
	
	@FindBy(css="aside.about__news__poster>img[src*='https://s3-eu-west-1.amazonaws.com'][src$='mcadcafe.jpg']")
	WebElement ovrHeader4Img1;
	
	@FindBy(css="aside.about__news__poster>img[src*='https://s3-eu-west-1.amazonaws.com'][src$='TheRecord-logo.jpg']")
	WebElement ovrHeader4Img2;
	
	@FindBy(css="aside.about__news__poster>img[src*='https://s3-eu-west-1.amazonaws.com'][src$='selfbuilder.png']")
	WebElement ovrHeader4Img3;
	
	@FindBy(css="body>div.site>div>div>main>div.section--about.fixed_helper>div>div.section--about__inner.news>#news>ol>li:nth-child(1)>article>a")
	WebElement ovrHeader4Link1;
	
	@FindBy(css="body>div.site>div>div>main>div.section--about.fixed_helper>div>div.section--about__inner.news>#news>ol>li:nth-child(1)>article>strong")
	WebElement ovrHeader4Link1Desc;
	
	@FindBy(css="body>div.site>div>div>main>div.section--about.fixed_helper>div>div.section--about__inner.news>#news>ol>li:nth-child(1)>article>time")
	WebElement ovrHeader4Link1Time;
	
	@FindBy(css="body>div.site>div>div>main>div.section--about.fixed_helper>div>div.section--about__inner.news>#news>ol>li:nth-child(3)>article>a")
	WebElement ovrHeader4Link2;
	
	@FindBy(css="body>div.site>div>div>main>div.section--about.fixed_helper>div>div.section--about__inner.news>#news>ol>li:nth-child(3)>article>strong")
	WebElement ovrHeader4Link2Desc;
	
	@FindBy(css="body>div.site>div>div>main>div.section--about.fixed_helper>div>div.section--about__inner.news>#news>ol>li:nth-child(3)>article>time")
	WebElement ovrHeader4Link2Time;

	@FindBy(css="body>div.site>div>div>main>div.section--about.fixed_helper>div>div.section--about__inner.news>#news>ol>li:nth-child(5)>article>a")
	WebElement ovrHeader4Link3;
	
	@FindBy(css="body>div.site>div>div>main>div.section--about.fixed_helper>div>div.section--about__inner.news>#news>ol>li:nth-child(5)>article>strong")
	WebElement ovrHeader4Link3Desc;
	
	@FindBy(css="body>div.site>div>div>main>div.section--about.fixed_helper>div>div.section--about__inner.news>#news>ol>li:nth-child(5)>article>time")
	WebElement ovrHeader4Link3Time;
		
	@FindBy(css="a[href*='https://squareclockdata.s3-eu-west-1.amazonaws.com']>img")
	WebElement overviewImage;
	
	
	private String ovrHeader1Desc1Text="Homebyme started as a side project but quickly developed into one of our most exciting ideas. Our goal was to design the best online 3D home design service in order to create, plan and manage home-related projects.";
	private String ovrHeader2Desc1Text="Overview"+"\n"+"Homebyme is an online 3D home planning service developed by 3DVIA, a Dassault Systèmes SE brand, based in the center of Paris – France. At 3DVIA, we strongly believe that 3D technologies can transform consumers’ decision processes, as they know it. Homebyme is about imagining, configuring, visualizing and reviewing home products and furniture layouts, using a virtual version of your home surroundings before making any purchasing or remodeling decisions. We believe that  designing floor plans or selecting new bedroom colors should be fun, easy and should reflect the consumer’s style and personality in a unique way. Using the latest 3D technologies, consumers can easily create detailed floor plans, test various furniture from today’s top designers and manufacturers, play with thousands of decoration elements, as well as experience a virtual immersion into their dream home. We also believe that sharing your ideas with friends and professionals to get third party advice is an important factor in designing your dream home. Homebyme is used all over the world and our growing community has already shared over 1.5 million floor plans and interior design ideas with home builders, kitchen retailers, architects, friends and family.";
	private String ovrHeader4Link1Text="“Homebyme brings the entire design community at the doorstep of a user, where users can imagine, innovate, and inspire. “";
	private String ovrHeader4Link2Text="“Users can view online elements such as personalised furniture, flooring, walls, layouts and designs. This helps with decision-making before purchases and projects get underway”";
	private String ovrHeader4Link3Text="“Homebyme helps consumers transform the home with fully browser-based immersive 3D Experience”";
	
	
	public LandingPage verifyPage()
	{
		Verification.VerifyEquals("PageHeader text not displayed", ovrPageHeader1.getText(), "About Homebyme");
		Verification.VerifyEquals("PageHeader Desc text not displayed",ovrHeader1Desc1.getText(), ovrHeader1Desc1Text);
		UtilHBM.waitExplicitClickable(driver, ovrHeader1Link1);
		Verification.displayOfWebElement(ovrHeader1Link1);
		UtilHBM.waitExplicitClickable(driver, ovrHeader1Link2);
		Verification.displayOfWebElement(ovrHeader1Link2);
		UtilHBM.waitExplicitClickable(driver, ovrHeader1Link3);
		Verification.displayOfWebElement(ovrHeader1Link3);
		Verification.VerifyEquals("PageHeader text not displayed", ovrPageHeader2.getText(), "Overview");
		UtilHBM.waitExplicitDisplayed(driver, overviewImage);
		Verification.displayOfWebElement(overviewImage);
		Verification.VerifyEquals("PageHeader Desc text not displayed",ovrHeader2Desc1.getText(), ovrHeader2Desc1Text);
		Verification.VerifyEquals("PageHeader text not displayed", ovrPageHeader3.getText(), "Press");
		Verification.VerifyEquals("PageHeader text not displayed", ovrHeader3SubHeader1.getText(), "CONTACT PRESS");
		UtilHBM.waitExplicitClickable(driver, ovrHeader3Link1);
		Verification.VerifyEquals("PageHeader text not displayed", ovrHeader3Link1.getText(), "Contact Email");
		Verification.VerifyEquals("PageHeader Desc text not displayed",ovrHeader3Desc2.getText(),"OUR PRESS RELEASE" );
		UtilHBM.waitExplicitClickable(driver, ovrHeader3Desc3);
		Verification.VerifyEquals("PageHeader Desc text not displayed",ovrHeader3Desc3.getText(),"Download");
		Verification.VerifyEquals("PageHeader Desc text not displayed",ovrHeader3Desc4.getText(),".pdf / 753 Ko");
		Verification.VerifyEquals("PageHeader Desc text not displayed",ovrHeader3Desc5.getText(),"OUR MEDIA KIT");
		UtilHBM.waitExplicitClickable(driver, ovrHeader3Desc6);
		Verification.VerifyEquals("PageHeader Desc text not displayed",ovrHeader3Desc6.getText(),"Download");
		Verification.VerifyEquals("PageHeader Desc text not displayed",ovrHeader3Desc7.getText(),".pdf / 458 Mo");
		Verification.VerifyEquals("PageHeader text not displayed", ovrPageHeader4.getText(), "In the news");
		Verification.displayOfWebElement(ovrHeader4Img1);
		Verification.displayOfWebElement(ovrHeader4Img2);
		Verification.displayOfWebElement(ovrHeader4Img3);
		UtilHBM.waitExplicitClickable(driver, ovrHeader4Link1);
		Verification.VerifyEquals("PageHeader Desc text not displayed",ovrHeader4Link1.getText(), ovrHeader4Link1Text);
		Verification.VerifyEquals("PageHeader text not displayed", ovrHeader4Link1Desc.getText(), "MCADCafe");
		Verification.VerifyEquals("PageHeader text not displayed", ovrHeader4Link1Time.getText(), "May 31, 2016");
		UtilHBM.waitExplicitClickable(driver, ovrHeader4Link2);
		Verification.VerifyEquals("PageHeader Desc text not displayed",ovrHeader4Link2.getText(), ovrHeader4Link2Text);
		Verification.VerifyEquals("PageHeader text not displayed", ovrHeader4Link2Desc.getText(), "The Record");
		Verification.VerifyEquals("PageHeader text not displayed", ovrHeader4Link2Time.getText(), "May 10, 2015");
		UtilHBM.waitExplicitClickable(driver, ovrHeader4Link3);
		Verification.VerifyEquals("PageHeader Desc text not displayed",ovrHeader4Link3.getText(), ovrHeader4Link3Text);
		Verification.VerifyEquals("PageHeader text not displayed", ovrHeader4Link3Desc.getText(), "Selfbuilder & Homemaker");
		Verification.VerifyEquals("PageHeader text not displayed", ovrHeader4Link3Time.getText(), "May 5, 2014");
		return PageFactory.initElements(driver, LandingPage.class);
	}
}
