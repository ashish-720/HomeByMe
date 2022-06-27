package kitchen.threeDCloudByMe.pageObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;

public class Family {
	WebDriver driver;

	public Family(WebDriver driver) {
		this.driver=driver;	
	}
	
	@FindBy(css="input#name")
	WebElement familyNameInput;
	
	@FindBy(css="table[id*='DataTables_Table']>tbody>tr")
	List<WebElement> addedProducts;
	
	@FindBy(css="#menu-edit-family")
	WebElement editProductsButton;
	
	@FindBy(css="li>a[href='/en/dashboard/family']")
	WebElement backButtonFamily;
	
	@FindBy(css=".dataTables_processing")
	List<WebElement> processingLabel;
	
	@FindBy(css="#btnSubmitForm")
	WebElement saveButton;
	
	@FindBy(css=".footer-fixed>.mod-notification>.success.show")
	WebElement successMsg;
	
	@FindBy(css="#nav-search")
	WebElement searchPrd;
	
	@FindBy(css=".div-datatable-dashboard>div>table>tbody>tr")
	List<WebElement> prdList;
	
	@FindBy(css="div[class='div-datatable-search']>div>div>div[id*='DataTables_Table_'][id$='_info']")
	WebElement allPrdInfo;
		
	@FindBy(css="#button-delete-catalog-product")
	WebElement deleteButton;
	
	@FindBy(css="#btnSubmitForm")
	WebElement saveFamily;
	
	@FindBy(css="a[href='/en/dashboard/family']")
	WebElement backButton;
	
	@FindBy(css="#name")
	WebElement familyNameText;
	
	@FindBy(id="name")
	WebElement familyName;

	@FindBy(xpath="//div[@class='mod-notification']/p[contains(@class, 'error') and contains(text(), 'Permission denied')]")
	private WebElement permissionDeniedErrPopup;

	public Content deletePrdFromFamily(String productName,String role)
	{
		int x=prdList.size();
		searchPrd.sendKeys(productName+"*"+Keys.ENTER);
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy");
		Date date=new Date();
		String s=dateFormat.format(date);
		List<WebElement> l=driver.findElements(By.xpath("//div[@class='div-datatable-search']/div/table[starts-with(@id,'DataTables_Table')]/tbody/tr/td[3][contains(text(),"+productName+"_"+s+")]"));
		for(int i=0;i<l.size();i++)
		{
			UtilHBM.waitExplicitDisplayed(driver, l.get(i));
			UtilHBM.waitExplicitClickable(driver, l.get(i));
		}
		int y=Integer.parseInt(allPrdInfo.getText().split(" ")[5].replace(",", ""));
		List<WebElement> deletedProducts=driver.findElements(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr[contains(@data-name,'"+productName+"_"+"')]/td[2]"));
		List<WebElement> prdToBeDeleted=driver.findElements(By.xpath("//div[@class='div-datatable-search']/div/table/tbody/tr[contains(@data-name,'"+productName+"_"+"')]/td/label"));
		UtilHBM.reportOK("Products to be Deleted:");
		for(int i=0;i<prdToBeDeleted.size();i++)
		{
			prdToBeDeleted.get(i).click();
			UtilHBM.reportOK(deletedProducts.get(i).getText());
		}
		clickDeleteButton();
		for(int i=0;i<prdList.size();i++)
		{
			UtilHBM.waitExplicitDisplayed(driver, prdList.get(i));
		}
		clickSave();
		UtilHBM.waitExplicitDisplayed(driver, successMsg);
		int z=driver.findElements(By.cssSelector(".div-datatable-dashboard>div>table>tbody>tr")).size();
		System.out.println("z="+z);
		if(x-y==z)
		{
			UtilHBM.reportOK(y+" products "+" deleted from family "+familyNameText.getAttribute("value"));
		}
		else
			UtilHBM.reportKO("Products not deleted");	
		
		clickBackButton();
		return PageFactory.initElements(driver, Content.class);
	}
	
	Family clickDeleteButton()
	{
		deleteButton.click();
		return this;
	}
	
	public Content createNewFamily(String familyName,String productName,String role)
	{
		UtilHBM.reportInfo("Creating new family");
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy_HH_mm");
		Date date=new Date();
		String s=dateFormat.format(date);
		familyNameInput.sendKeys(familyName+"_"+role+"_"+s);
		clickEditProducts()
		.addFamilyProducts(productName);
		clickSave();
		UtilHBM.waitExplicitDisplayed(driver, successMsg);	
		for(int i=0;i<addedProducts.size();i++)
		{
			for(int j=0;j<Level1DlgBox.getSelectedPrd().size();j++)
			{
				if(addedProducts.get(i).findElement(By.cssSelector("td:nth-child(2)>span")).getText().contentEquals(Level1DlgBox.getSelectedPrd().get(j)))
				{
					if(i==0)
						UtilHBM.reportOK("Added products:");
					UtilHBM.reportOK(addedProducts.get(i).findElement(By.cssSelector("td:nth-child(2)>span")).getText());
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
	
	Family clickSave() {
		saveButton.click();
		UtilHBM.waitExplicitClickable(driver, successMsg);
		UtilHBM.reportOK(successMsg.getText());
		return this;
	}
	
	Content clickBackButton()
	{
		backButtonFamily.click();
		return PageFactory.initElements(driver, Content.class);
	}
	
	Level1DlgBox clickEditProducts()
	{
		editProductsButton.click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("body>div>div>div>div>div>iframe")));
		return PageFactory.initElements(driver, Level1DlgBox.class);
	}

	public Family updateFamilyName(String name, String operation) {
		UtilHBM.waitExplicitDisplayed(driver,familyNameInput);
		switch (operation.toUpperCase()) {
			case "APPEND":
				String currentName = familyNameInput.getAttribute("value");
				familyNameInput.clear();
				familyNameInput.sendKeys(currentName + name + Keys.TAB);
				break;

			case "MODIFY":
			default:
				familyNameInput.clear();
				familyNameInput.sendKeys(name + Keys.TAB);
		}
		return this;
	}

	public Family clickSaveAndVerifyPermissionDenied()
	{
		saveButton.click();
		UtilHBM.waitExplicitDisplayed(driver, permissionDeniedErrPopup);
		UtilHBM.reportOK("Error popup verified : "+permissionDeniedErrPopup.getText());
		return PageFactory.initElements(driver, Family.class);
	}
}
