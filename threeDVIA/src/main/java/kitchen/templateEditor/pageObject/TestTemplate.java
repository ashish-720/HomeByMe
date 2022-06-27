package kitchen.templateEditor.pageObject;

import java.util.List;

import hbm.planner.utility.Verification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;

public class TestTemplate {
	WebDriver driver;
	
	public TestTemplate(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css="#step-test>button")
	WebElement testPageButton;
	
	@FindBy(css=".cta-primary-alt-xl")
	WebElement validateButton;
	
	@FindBy(css="#input-room-l")
	WebElement room2;
	
	@FindBy(css="#input-room-polygon")
	WebElement room3;
	
	@FindBy(css="button[aria-controls='room-shape-open-kitchen']")
	WebElement openKitchenButton;
	
	@FindBy(css="#input-room-square-open")
	WebElement room4;
	
	@FindBy(css="#input-room-bar-open")
	WebElement room5;
	
	@FindBy(css="#input-room-l-open")
	WebElement room6;
	
	@FindBy(css="button[class='cta-primary']")
	WebElement originalRoom; 
	
	@FindBy(css="div[class='solutions swiper-container-initialized swiper-container-horizontal']>ul>li")
	List<WebElement> solutionsList;
	
	@FindBy(css="article[class='mod-popin-no-solution-2-small mod-open']>div>div")
	List<WebElement> noSolutionsWindow;
	
	@FindBy(css="article[class='mod-popin-no-solution-2-small mod-open']>div>footer>button")
	WebElement editTemplateButton;
	
	@FindBy(xpath="//button[@data-state='design']/parent::li")
	WebElement designButton;
	
	@FindBy(css="#bmSVG")
	WebElement container3D;

	@FindBy(css="div.solutions ul")
	WebElement availableSolutionsList;

	public Design goToDesignPage()
	{
		designButton.click();
		UtilHBM.waitExplicitDisplayed(driver, container3D);
		UtilHBM.waitFixTime(3000);
		return PageFactory.initElements(driver, Design.class);
	}
	
	public Design testTemplate(int roomShape, int requiredSolutions, int selectTemplate, String price)
	{
		testPageButton.click();
		switch(roomShape) 
		{
		case 1:
			validateButton.click();
			UtilHBM.waitTillElementDisappear(driver, ".spinner>.icon-view-loader");
			if(solutionsList.size()==requiredSolutions)
			{
				UtilHBM.reportOK("Test for room shape "+roomShape+" successful."+" Test solution available:"+solutionsList.size());
				if(requiredSolutions==0)editTemplateButton.click();
			}
			else if(noSolutionsWindow.size()>0)
			{
				UtilHBM.reportKO("Something wrong in template parameters. Change parameters");
				editTemplateButton.click();

			}
			else
			{
				UtilHBM.reportKO("Test for room shape "+roomShape+" unsuccessful"+" Test solution available:"+solutionsList.size()+" Test solutions required:"+requiredSolutions);

			}
			break;
		case 2:
			room2.click();
			UtilHBM.waitTillElementDisappear(driver, ".spinner>.icon-view-loader");
			if(solutionsList.size()==requiredSolutions)
			{
				UtilHBM.reportOK("Test for room shape "+roomShape+" successful"+" Test solution available:"+solutionsList.size());
				if(requiredSolutions==0)editTemplateButton.click();

			}				
			else if(noSolutionsWindow.size()>0)
			{
				UtilHBM.reportKO("Something wrong in template parameters. Change parameters");
				editTemplateButton.click();
				goToDesignPage();
			}
			else
			{
				UtilHBM.reportKO("Test for room shape "+roomShape+" unsuccessful"+" Test solution available:"+solutionsList.size()+" Test solutions required:"+requiredSolutions);

			}
			break;
		case 3:
			room3.click();
			UtilHBM.waitTillElementDisappear(driver, ".spinner>.icon-view-loader");
			if(solutionsList.size()==requiredSolutions)
			{
				UtilHBM.reportOK("Test for room shape "+roomShape+" successful"+" Test solution available:"+solutionsList.size());
				if(requiredSolutions==0)editTemplateButton.click();

			}
			else if(noSolutionsWindow.size()>0)
			{
				UtilHBM.reportKO("Something wrong in template parameters. Change parameters");
				editTemplateButton.click();

			}
			else
			{
				UtilHBM.reportKO("Test for room shape "+roomShape+" unsuccessful"+" Test solution available:"+solutionsList.size()+" Test solutions required:"+requiredSolutions);

			}
			
			break;
		case 4:
			openKitchenButton.click();
			room4.click();
			UtilHBM.waitTillElementDisappear(driver, ".spinner>.icon-view-loader");
			if(solutionsList.size()==requiredSolutions)
			{
				UtilHBM.reportOK("Test for room shape "+roomShape+" successful"+" Test solution available:"+solutionsList.size());
				if(requiredSolutions==0)editTemplateButton.click();

			}
			else if(noSolutionsWindow.size()>0)
			{
				UtilHBM.reportKO("Something wrong in template parameters. Change parameters");
				editTemplateButton.click();

			}
			else
			{
				UtilHBM.reportKO("Test for room shape "+roomShape+" unsuccessful"+" Test solution available:"+solutionsList.size()+" Test solutions required:"+requiredSolutions);

			}
			break;
		case 5: 
			openKitchenButton.click();
			room5.click();
			UtilHBM.waitTillElementDisappear(driver, ".spinner>.icon-view-loader");
			if(solutionsList.size()==requiredSolutions)
			{
				UtilHBM.reportOK("Test for room shape "+roomShape+" successful"+" Test solution available:"+solutionsList.size());
				if(requiredSolutions==0)editTemplateButton.click();
			}
			else if(noSolutionsWindow.size()>0)
			{
				UtilHBM.reportKO("Something wrong in template parameters. Change parameters");
				editTemplateButton.click();

			}
			else
			{
				UtilHBM.reportKO("Test for room shape "+roomShape+" unsuccessful"+" Test solution available:"+solutionsList.size()+" Test solutions required:"+requiredSolutions);

			}
			break;
		case 6:
			openKitchenButton.click();
			room6.click();
			UtilHBM.waitTillElementDisappear(driver, ".spinner>.icon-view-loader");
			if(solutionsList.size()==requiredSolutions)
			{
				UtilHBM.reportOK("Test for room shape "+roomShape+" successful"+" Test solution available:"+solutionsList.size());
				if(requiredSolutions==0)editTemplateButton.click();

			}
			else if(noSolutionsWindow.size()>0)
			{
				UtilHBM.reportKO("Something wrong in template parameters. Change parameters");
				editTemplateButton.click();
			}
			else
			{
				UtilHBM.reportKO("Test for room shape "+roomShape+" unsuccessful"+" Test solution available:"+solutionsList.size()+" Test solutions required:"+requiredSolutions);
			}
			break;
		case 0:
			originalRoom.click();
			UtilHBM.waitTillElementDisappear(driver, ".spinner>.icon-view-loader");
			if(solutionsList.size()==requiredSolutions)
			{
				UtilHBM.reportOK("Test for current room shape successful"+" Test solution available:"+solutionsList.size());
				if(requiredSolutions==0)editTemplateButton.click();
			}
			else if(noSolutionsWindow.size()>0)
			{
				UtilHBM.reportKO("Something wrong in template parameters. Change parameters");
				editTemplateButton.click();

			}
			else
			{
				UtilHBM.reportKO("Test for room shape "+roomShape+" unsuccessful"+" Test solution available:"+solutionsList.size()+" Test solutions required:"+requiredSolutions);

			}
				
			break;
		}
		//KIT-1596
		if(selectTemplate!=0)checkTemplate(selectTemplate,price);
		goToDesignPage();
		return PageFactory.initElements(driver, Design.class);
	}

	public TestTemplate checkTemplate(int selectedTemplate,String price)
	{
		UtilHBM.waitExplicitDisplayed(driver, availableSolutionsList);
		availableSolutionsList.findElement(By.xpath("./li//span[text()='"+selectedTemplate+"']/parent::button")).click();
		UtilHBM.waitFixTime(1000);

		if(!price.isEmpty()){
			verifyPrice(price);
		}
		return this;
	}

	public TestTemplate verifyPrice(String price) {
		if (!price.isEmpty()) {
			UtilHBM.waitFixTime(4000);
			WebElement currency = driver
					.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'\u20AC')]"));
			Verification.displayOfWebElement(currency);

			String p1 = driver.findElement(By.xpath("//span[@class='standard-price ']")).getText().trim()
					.replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", "");

			System.out.println("p1:" + p1.replaceAll("\\n", "") + "price:" + price);
			System.out.println("equals :" + p1.equalsIgnoreCase(price));
			if (p1.equalsIgnoreCase(price)) {
				UtilHBM.reportOK("Test Template : Expected price: " + price + " SAME as actual price: " + p1);
			} else {
				UtilHBM.reportKO("Test Template : Expected price: " + price + " NOT SAME as actual price: " + p1);
			}

		}
		return this;
	}
}

