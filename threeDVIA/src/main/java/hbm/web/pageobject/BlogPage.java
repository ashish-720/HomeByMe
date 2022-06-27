package hbm.web.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class BlogPage {
	WebDriver driver;
	
	public BlogPage(WebDriver driver){
		this.driver = driver;		
	}

	@FindBy(css="body>div.site>div>div>main>div>div>aside>section.widget.custom>h3")
	WebElement blogPageHeader1;
	
	@FindBy(css="body>div.site>div>div>main>div>div>aside>#text-2>h3")
	WebElement blogPageHeader2;

	@FindBy(css="body>div.site>div>div>main>div>div>aside>#categories-2>h3")
	WebElement blogPageHeader3;
	
	@FindBy(css="body>div.site>div>div>main>div>div>aside>#nav_menu-4>h3")
	WebElement blogPageHeader4;
		
	@FindBy(css="body>div.site>div>div>main>div>div>aside>#text-2>div>p")
	WebElement blogHeader2Desc1;
	
	@FindBy(css="body>div.site>div>div>main>div>div>aside>#text-2>div>.button")
	WebElement blogHeader2Button1;
	
	@FindBy(css="div.blog__background")
	WebElement blogImage1;
	
	@FindBy(css="body>div.site>div>div>main>div>div>aside>section.widget.custom>ol>li:nth-child(1)>a")
	WebElement blogHeader1Link1;
	
	@FindBy(css="body>div.site>div>div>main>div>div>aside>section.widget.custom>ol>li:nth-child(2)>a")
	WebElement blogHeader1Link2;
	
	@FindBy(css="body>div.site>div>div>main>div>div>aside>section.widget.custom>ol>li:nth-child(3)>a")
	WebElement blogHeader1Link3;
	
	@FindBy(css="body>div.site>div>div>main>div>div>aside>section.widget.custom>ol>li:nth-child(4)>a")
	WebElement blogHeader1Link4;
	
	@FindBy(css="body>div.site>div>div>main>div>div>aside>section.widget.custom>ol>li:nth-child(5)>a")
	WebElement blogHeader1Link5;
	
	@FindBy(css="body>div.site>div>div>main>div>div>aside>section.widget.custom>ol>li:nth-child(6)>a")
	WebElement blogHeader1Link6;
	
	@FindBy(css="body>div.site>div>div>main>div>div>aside>#categories-2>ul>li.cat-item.cat-item-32>a")
	WebElement blogHeader3Link1;
	
	@FindBy(css="body>div.site>div>div>main>div>div>aside>#categories-2>ul>li.cat-item.cat-item-36>a")
	WebElement blogHeader3Link2;
	
	@FindBy(css="body>div.site>div>div>main>div>div>aside>#categories-2>ul>li.cat-item.cat-item-13>a")
	WebElement blogHeader3Link3;
	
	@FindBy(css="body>div.site>div>div>main>div>div>aside>#categories-2>ul>li.cat-item.cat-item-35>a")
	WebElement blogHeader3Link4;
	
	@FindBy(css="body>div.site>div>div>main>div>div>aside>#categories-2>ul>li.cat-item.cat-item-53>a")
	WebElement blogHeader3Link5;
	
	@FindBy(css="body>div.site>div>div>main>div>div>aside>#nav_menu-4>#menu-blog-favories>li.nav__item.nav__menu__item.menu-aventure-deco>a")
	WebElement blogHeader4Link1;
	
	@FindBy(css="body>div.site>div>div>main>div>div>aside>#nav_menu-4>#menu-blog-favories>li.nav__item.nav__menu__item.menu-mh-deco>a")
	WebElement blogHeader4Link2;
	
	@FindBy(css="body>div.site>div>div>main>div>div>aside>#nav_menu-4>#menu-blog-favories>li.nav__item.nav__menu__item.menu-la-minute-deco>a")
	WebElement blogHeader4Link3;
	
	@FindBy(css="body>div.site>div>div>main>div>div>aside>#nav_menu-4>#menu-blog-favories>li.nav__item.nav__menu__item.menu-apartment-therapy>a")
	WebElement blogHeader4Link4;
	
	@FindBy(css="body>div.site>div>div>main>div>div>aside>#nav_menu-4>#menu-blog-favories>li.nav__item.nav__menu__item.menu-le-blog-deco>a")
	WebElement blogHeader4Link5;
	
	@FindBy(css="a[class='page larger'][href='/blog/page/3']")
	WebElement nextPage;
	
	@FindBy(css="body>div.site>div>div>main>div>div>div>article:nth-child(1)>header>ul>li.article__meta__item.byline.author.vcard")
	WebElement blogAuthorName;
	
	@FindBy(css="body>div.site>div>div>main>div>div>div>article:nth-child(1)>header>ul>li:nth-child(2)>time")
	WebElement blogPublishDate;
	
	@FindBy(css="article.blog__article>div>p>a>img")
	List<WebElement> list;
	
	@FindBy(css="article.blog__article")
	List<WebElement> l;
	
	
	public LandingPage verifyPage()
	{
		verifySideColomn();
		verifyBlogContent();
		verifyImages();
		nextPage.click();
		return PageFactory.initElements(driver, LandingPage.class);
	}
	
	public void verifyImages()
	{
		for(int i=0;i<l.size();i++)
		{
			
			
		}
	}
	public void verifyBlogContent()
	{
		Verification.displayOfWebElement(blogAuthorName);
		Verification.displayOfWebElement(blogPublishDate);
		Verification.displayOfWebElement(blogImage1);
		
		for(int i=0;i<=list.size();i++)
		{
			if(list.get(i).getAttribute("src").contains("jpg")||list.get(i).getAttribute("src").contains("jpeg")||list.get(i).getAttribute("src").contains("png"))
			{
				WebElement we=list.get(i);
				Verification.displayOfWebElement(we);
			}
		}
		
	}
	
	public void verifySideColomn() {
		Verification.VerifyEquals("PageHeader text not displayed", blogPageHeader1.getText(), "Follow us");
		Verification.VerifyEquals("Link Address not appropriate", blogHeader1Link1.getAttribute("href"), "https://www.facebook.com/HomeByMe");
		Verification.VerifyEquals("Link Address not appropriate", blogHeader1Link2.getAttribute("href"), "https://twitter.com/HomeByMe");
		Verification.VerifyEquals("Link Address not appropriate", blogHeader1Link3.getAttribute("href"), "http://www.pinterest.com/homebyme/");
		Verification.VerifyEquals("Link Address not appropriate", blogHeader1Link4.getAttribute("href"), "https://www.youtube.com/user/homebyme");
		Verification.VerifyEquals("Link Address not appropriate", blogHeader1Link5.getAttribute("href"), "https://plus.google.com/u/0/+Homebyme/posts");
		Verification.VerifyEquals("Link Address not appropriate", blogHeader1Link6.getAttribute("href"), "http://instagram.com/homebyme");
		Verification.VerifyEquals("PageHeader text not displayed", blogPageHeader2.getText(), "Newsletter");
		Verification.VerifyEquals("PageHeader Desc text not displayed",blogHeader2Desc1.getText(), "Sign up to subscribe to our newsletter");
		Verification.displayOfWebElement(blogHeader2Button1);
		Verification.VerifyEquals("Button text not displayed", blogHeader2Button1.getText(), "Subscribe");
		Verification.VerifyEquals("PageHeader text not displayed", blogPageHeader3.getText(), "Categories");
		UtilHBM.waitExplicitClickable(driver, blogHeader3Link1);
		Verification.VerifyEquals("SubHeader text not appropriate", blogHeader3Link1.getText(), "Events");
		UtilHBM.waitExplicitClickable(driver, blogHeader3Link2);
		Verification.VerifyEquals("SubHeader text not appropriate", blogHeader3Link2.getText(), "Featured");
		UtilHBM.waitExplicitClickable(driver, blogHeader3Link3);
		Verification.VerifyEquals("SubHeader text not appropriate", blogHeader3Link3.getText(), "News");
		UtilHBM.waitExplicitClickable(driver, blogHeader3Link4);
		Verification.VerifyEquals("SubHeader text not appropriate", blogHeader3Link4.getText(), "Project of the month");
		UtilHBM.waitExplicitClickable(driver, blogHeader3Link5);
		Verification.VerifyEquals("SubHeader text not appropriate", blogHeader3Link5.getText(), "Tutorials");
		Verification.VerifyEquals("PageHeader text not displayed", blogPageHeader4.getText(), "Favorite Blogs");
		Verification.VerifyEquals("Link Address not appropriate", blogHeader4Link1.getAttribute("href"), "http://aventuredeco.fr/");
		Verification.VerifyEquals("Link Address not appropriate", blogHeader4Link2.getAttribute("href"), "http://www.mh-deco.fr/");
		Verification.VerifyEquals("Link Address not appropriate", blogHeader4Link3.getAttribute("href"), "http://www.laminutedeco.com/");
		Verification.VerifyEquals("Link Address not appropriate", blogHeader4Link4.getAttribute("href"), "http://www.apartmenttherapy.com/");
		Verification.VerifyEquals("Link Address not appropriate", blogHeader4Link5.getAttribute("href"), "http://www.leblogdeco.fr/");
	}
}

