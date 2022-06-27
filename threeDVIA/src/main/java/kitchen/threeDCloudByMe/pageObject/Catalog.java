package kitchen.threeDCloudByMe.pageObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class Catalog {
	WebDriver driver;

	public Catalog(WebDriver driver) {
		this.driver=driver;	
	}

	@FindBy(css="#catalog_name")
	WebElement catalogNameInput;

	@FindBy(css=".chosen-container.chosen-container-multi")
	WebElement appDistribution;

	@FindBy(css="li.search-field>input")
	WebElement appDistributionSearchInput;

	@FindBy(css="#catalog_startDate")
	WebElement catalogStartDate;

	@FindBy(css="#catalog_endDate")
	WebElement catalogEndDate;
	
	@FindBy(css="table[id*='DataTables_Table']>tbody>tr")
	List<WebElement> addedProducts;

	@FindBy(css="#menu-edit-catalog")
	WebElement addProductsButton;

	@FindBy(css="li>a[href='/en/dashboard/catalog']")
	WebElement backButton;

	@FindBy(css=".dataTables_processing")
	List<WebElement> processingLabel;
	
	@FindBy(css="#btnSubmitForm")
	WebElement saveButton;

	@FindBy(css=".footer-fixed>.mod-notification>.success.show")
	WebElement successMsg;

	@FindBy(css="#nav-search")
	WebElement searchInput;
	
	@FindBy(css=".div-datatable-dashboard>div>table>tbody>tr")
	List<WebElement> catalogList;

	@FindBy(css="div[class='div-datatable-search']>div>div>div[id*='DataTables_Table_'][id$='_info']")
	WebElement allPrdInfo;

	@FindBy(css="#catalog_name")
	WebElement catalogNameText;

	@FindBy(css="#button-delete-catalog-product")
	WebElement deleteButton;

	@FindBy(css="label[for='catalog_applicationDistributions']")
	WebElement pageHeader1;
	
	@FindBy(css="label[for='catalog_startDate']")
	WebElement pageHeader2;
	
	@FindBy(css="label[for='catalog_endDate']")
	WebElement pageHeader3;
	
	@FindBy(css="label.steps-item-label")
	WebElement pageHeader4;
	
	@FindBy(css="#menu-edit-catalog>span")
	WebElement pageHeader5;
	
	@FindBy(css="th[aria-label*='Name']")
	WebElement colomnHeader1;
	
	@FindBy(css="th[aria-label*='Reference']")
	WebElement colomnHeader2;
	
	@FindBy(css="th[aria-label='Type']")
	WebElement colomnHeader3;
	
	@FindBy(css="th[aria-label='Catalogs']")
	WebElement colomnHeader4;
	
	@FindBy(css="th[aria-label*='Start date']")
	WebElement colomnHeader5;
	
	@FindBy(css="th[aria-label*='End date']")
	WebElement colomnHeader6;
	
	@FindBy(css="th[aria-label='3d model']")
	WebElement colomnHeader7;
	
	@FindBy(css="th[aria-label='Override']")
	WebElement colomnHeader8;
	
	@FindBy(css="th[aria-label*='Last']")
	WebElement colomnHeader9;
	
	@FindBy(css="#DataTables_Table_0>thead>tr>#checkboxCheckAll-header>label")
	WebElement selectAllCheckBox;
	
	
	public Content deleteDate()
	{
		catalogStartDate.clear();
		catalogEndDate.clear();
		clickSave();
		clickBackButton();
		return PageFactory.initElements(driver, Content.class);
	}
	
	public Content deleteAllPrdFromCatalog(String role)
	{
		for(int i=0;i<catalogList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, catalogList.get(i));
		int x=catalogList.size();
		selectAllCheckBox.click();
		clickDeleteButton();
		clickSave();
		int z=driver.findElements(By.cssSelector(".div-datatable-dashboard>div>table>tbody>tr")).size();
		if(x-catalogList.size()==z)
		{
			UtilHBM.reportOK(catalogList.size()+" products "+" deleted from catalog "+catalogNameText.getAttribute("value"));
		}
		else
			UtilHBM.reportKO("Products not deleted");	
		clickBackButton();
		return PageFactory.initElements(driver, Content.class);
	}
	
	public Content deletePrdFromCatalog(String productName,String role)
	{
		for(int i=0;i<catalogList.size();i++)
			UtilHBM.waitExplicitDisplayed(driver, catalogList.get(i));
		int x=catalogList.size();
		searchInput.clear();
		searchInput.sendKeys(productName+"*"+Keys.ENTER);
		List<WebElement> l=driver.findElements(By.xpath("//div[@class='div-datatable-search']/div/table[starts-with(@id,'DataTables_Table')]/tbody/tr/td[3][contains(text(),'"+productName+"')]"));
		for(int i=0;i<l.size();i++)
		{
			UtilHBM.waitExplicitDisplayed(driver, l.get(i));
			UtilHBM.waitExplicitClickable(driver, l.get(i));
		}
		int y=Integer.parseInt(allPrdInfo.getText().split(" ")[5].replace(",", ""));
		List<WebElement> deletedProducts=driver.findElements(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr[contains(@data-name,'"+productName+"')]/td[2]"));
		List<WebElement> prdToBeDeleted=driver.findElements(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr[contains(@data-name,'"+productName+"')]/td/label"));
		if(prdToBeDeleted.size()>0){
			UtilHBM.reportOK("Products to be Deleted:");
			for(int i=0;i<prdToBeDeleted.size();i++)
			{
				prdToBeDeleted.get(i).click();
				UtilHBM.reportOK(deletedProducts.get(i).getText());
			}
			clickDeleteButton();		
			int z=driver.findElements(By.cssSelector(".div-datatable-dashboard>div>table>tbody>tr")).size();
			if(x-y==z)
			{
				UtilHBM.reportOK(y+" products "+" deleted from catalog "+catalogNameText.getAttribute("value"));
			}
			else
				UtilHBM.reportKO("Products not deleted");
			clickSave();
			UtilHBM.waitExplicitDisplayed(driver, successMsg);
		}else{
			UtilHBM.reportKO(productName +" product not displayed after search for deleting from catalog");
		}
		clickBackButton();
		return PageFactory.initElements(driver, Content.class);
	}

	Catalog clickDeleteButton()
	{
		deleteButton.click();
		return this;
	}

	Catalog pageverfication()
	{
		Verification.VerifyEquals("Text not displayed", pageHeader1.getText(), "Application distributions");
		Verification.VerifyEquals("Text not displayed", pageHeader2.getText(), "Start date");
		Verification.VerifyEquals("Text not displayed", pageHeader3.getText(), "End date");
		Verification.VerifyEquals("Text not displayed", pageHeader4.getText(), "Catalog information");
		Verification.VerifyEquals("Text not displayed", pageHeader5.getText(), "ADD PRODUCTS");
		Verification.VerifyEquals("Text not displayed", colomnHeader1.getText(), "Name");
		Verification.VerifyEquals("Text not displayed", colomnHeader2.getText(), "Reference");
		Verification.VerifyEquals("Text not displayed", colomnHeader3.getText(), "Type");
		Verification.VerifyEquals("Text not displayed", colomnHeader4.getText(), "Catalogs");
		Verification.VerifyEquals("Text not displayed", colomnHeader5.getText(), "Start date");
		Verification.VerifyEquals("Text not displayed", colomnHeader6.getText(), "End date");
		Verification.VerifyEquals("Text not displayed", colomnHeader7.getText(), "3d model");
		Verification.VerifyEquals("Text not displayed", colomnHeader8.getText(), "Override");
		Verification.VerifyEquals("Text not displayed", colomnHeader9.getText(), "Last update");
		return this;
	}
	
	public Content addproductsToExistingCatalog(String productName,String role)
	{
		clickAddProduct()
		.addCatalogProducts(productName,role);
		clickSave().clickBackButton();
		return PageFactory.initElements(driver, Content.class);
	}
	public Content newCatalog(String catalogName,String applicationDist,String productName,String role)
	{
		UtilHBM.reportInfo("Creating new catalog");
		pageverfication();
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy_HH_mm");
		Date date=new Date();
		String s=dateFormat.format(date);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		String startDate = sdf.format(c.getTime());
		c.setTime(new Date());
		c.add(Calendar.DATE, 2);
		String endDate = sdf.format(c.getTime());
		String s1="Auto_"+catalogName+"_"+role+"_"+s;
		catalogNameInput.sendKeys(s1);
		appDistribution.click();
		if(applicationDist.contains(";"))
		{
			for(String a:applicationDist.split(";"))
			{
				appDistributionSearchInput.sendKeys(a);
				WebElement appDist = driver.findElement(By.xpath("//div/ul/li[.='"+a+"']"));
				appDist.click();
			}
		}
		else
		{
			appDistributionSearchInput.sendKeys(applicationDist);
			WebElement appDist = driver.findElement(By.xpath("//div/ul/li[.='"+applicationDist+"']"));
			appDist.click();
		}
		catalogStartDate.sendKeys(startDate);
		catalogEndDate.sendKeys(endDate);
		clickAddProduct()
		.addCatalogProducts(productName,role);
		clickSave();
		UtilHBM.waitExplicitDisplayed(driver, successMsg);
		for(int i=0;i<addedProducts.size();i++)
		{
			for(int j=0;j<Level1DlgBox.getSelectedPrd().size();j++)
			{
				if(addedProducts.get(i).getAttribute("data-name").contentEquals(Level1DlgBox.getSelectedPrd().get(j)))
				{
					if(i==0)
						UtilHBM.reportOK("Added products:");
					UtilHBM.reportOK(addedProducts.get(i).getAttribute("data-name"));
					break;
				}
				else
				{
					if(j==Level1DlgBox.getSelectedPrd().size()-1)
						UtilHBM.reportKO("Searched products not added");
				}
			}
		}
		clickBackButton();
		return PageFactory.initElements(driver, Content.class);
	}
	
	public Catalog addAppDistribution(String applicationDist) {
		appDistribution.click();
		if (applicationDist.contains(";")) {
			for (String a : applicationDist.split(";")) {
				appDistributionSearchInput.sendKeys(a);
				WebElement appDist = driver.findElement(By.xpath("//div/ul/li[.='" + a + "']"));
				appDist.click();
			}
		} else {
			appDistributionSearchInput.sendKeys(applicationDist);
			WebElement appDist = driver.findElement(By.xpath("//div/ul/li[.='" + applicationDist + "']"));
			appDist.click();
		}
		return this;
	}

	public Catalog clickSave() {
		UtilHBM.waitExplicitDisplayed(driver, saveButton);
		UtilHBM.waitExplicitClickable(driver, saveButton);
		saveButton.click();
		UtilHBM.waitFixTime(500);
		UtilHBM.waitExplicitDisplayed(driver, successMsg);
		UtilHBM.reportOK(successMsg.getText());
		return this;
	}

	public Content clickBackButton() {
		backButton.click();
		return PageFactory.initElements(driver, Content.class);
	}

	Level1DlgBox clickAddProduct() {
		addProductsButton.click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("body>div>div>div>div>div>iframe")));
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}
}
