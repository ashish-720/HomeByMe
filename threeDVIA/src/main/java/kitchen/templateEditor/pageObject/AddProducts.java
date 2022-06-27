package kitchen.templateEditor.pageObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
public class AddProducts {
	WebDriver driver;

	public AddProducts(WebDriver driver) {
		this.driver=driver;	
	}

	@FindBy(css="main>div>#topbar>div>div>ul>li>button")
	List<WebElement> menuOptions;

	@FindBy(css="#moreResults>button")
	List<WebElement> showMoreButton;

	@FindBy(css="#design-catalog-browser>div.mod-loader>div.content>span.spinner")
	WebElement loader;
	
	@FindBy(css="#bmSVG")
	WebElement container3D;

	ArrayList<String> arraylist = new ArrayList<String>();

	//	HashMap<String, String> map = new HashMap<>();
	Design clickBlank() 
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(container3D,321,-330).clickAndHold().pause(500).release().build().perform();
		return PageFactory.initElements(driver, Design.class);
	}

	public AddProducts addToCatalog(String fileName) throws IOException
	{ 
		UtilHBM.waitFixTime(3000);
		
		for(int i=0;i<menuOptions.size();i++)
		{
			if(!menuOptions.get(i).getAttribute("id").contains("search"))
			{
				menuOptions.get(i).click();
				System.out.println(menuOptions.get(i).getAttribute("id"));
				UtilHBM.waitFixTime(3000);
				List<WebElement> subcatagory=driver.findElements(By.cssSelector("ul.subcat>li>ul[data-ui-subcat='"+menuOptions.get(i).getAttribute("id")+"']>li"));
				for(int j=0;j<subcatagory.size();j++)
				{
					if(j!=0)
					{
						menuOptions.get(i).click();
						UtilHBM.waitFixTime(3000);
						UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("div[id$='"+menuOptions.get(i).getAttribute("id")+"']")));
					}
					UtilHBM.waitFixTime(5000);
					System.out.println(subcatagory.get(j));
					String subCatagory=subcatagory.get(j).findElement(By.cssSelector("button")).getText();
					subcatagory.get(j).click();
					
					UtilHBM.waitFixTime(5000);
//					UtilHBM.waitExplicitDisplayed(driver, driver.findElement(By.cssSelector("article[class='mod-panel-catalog-browser mod-open']")));
					
					
					List<WebElement> productList=driver.findElements(By.cssSelector("div.content-inner>ul[id='mod-product-list']>li"));
					Catalog catalog=PageFactory.initElements(driver, Catalog.class);
					catalog.getProductDetails();
					System.out.println(productList.size()+" "+subCatagory);
					for(int k=0;k<productList.size();k++)
					{						
						System.out.println(Catalog.getProducts().get(k)
								+" "+productList.get(k).getAttribute("data-ui-id")
								+" "+menuOptions.get(i).getAttribute("id"));
						
						UtilHBM.waitExplicitDisplayed(driver, productList.get(k));
						arraylist.add(Catalog.getProducts().get(k)+";"+productList.get(k).getAttribute("data-ui-id")+","+menuOptions.get(i).getAttribute("id")+">"+subCatagory);
					}
					UtilHBM.webElement(driver, "button[data-ui-action='panel-close']>span>svg").click();
					System.out.println(arraylist);

				}

			}
		}
		String path = new java.io.File(Setting.testDatapath + fileName + ".data").getAbsolutePath();
		FileWriter fw=new FileWriter(path);
		try {
			for(int i=0;i<arraylist.size();i++) {
				fw.write(arraylist.get(i)+"\r\n");
			}  
			fw.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}

		return PageFactory.initElements(driver, AddProducts.class);
	}

}
