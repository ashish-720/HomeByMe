package hbm.planner.pageobject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFavList {
	
	WebDriver driver;
	
	public SelectFavList(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(css=".modal.modal-favorite-sheet.current>div>h2>span")
	private WebElement brandName;
	
	@FindBy(css=".modal.modal-favorite-sheet.current>div>h2")
	private WebElement prdName;
	
	@FindBy(css=".modal.modal-favorite-sheet.current>div>div>div>div>div>.main-product")
	private WebElement prdImg;
	
	@FindBy(css=".right-inner-favorites>.right-inner-footer-favorites>button")
	private WebElement addToNewList;
	
	@FindBy(css=".ReactModalPortal>div>div>div>div>input")
	private WebElement listNameInputBox;
	
//	@FindBy(css=".ReactModalPortal>div>div>div>.confirm-box-btns>button[class='button']")
//	private WebElement createListButton;
	@FindBy(css=".ReactModalPortal>div>div>div>div>button[data-testid='collection-create']")
	private WebElement createListButton;
	
	@FindBy(css = "#app-notification>p.success")
	private WebElement notifcationMsgSuccess;
	
	@FindBy(css = "#app-notification>p.success>button>span.icon-view-close.icon-content")
	private WebElement closeNotifcationMsgSuccess;
	
	@FindBy(css = "#app-notification>p.error")
	private WebElement alreadyAvailableNotifcationMsg;
	
	@FindBy(css = "#app-notification>p.error>button>span.icon-view-close.icon-content")
	private WebElement closeAlreadyAvailableNotifcationMsg;
	
//	@FindBy(css="#app-notification>.success")
//	private WebElement notifcationMsg;
	
	@FindBy(css="div[id='app-notification']>p")
	private WebElement notifcationMsg;
	
	@FindBy(css="#app-notification>p>button>span")
	private WebElement closeMessageBtn;
	
	@FindBy(css=".modal.modal-favorite-sheet.current>div>div>div>div>div>.main-product")
	private WebElement favList;
	
	@FindBy(css=".ReactModalPortal>div>div>div>div>div>div>input")
	private WebElement searchInputBox;
	
	@FindBy(css=".icon-view-close")
	private WebElement closeButton;
	
	@FindBy(css="[data-testid='favorite-add-new-list']")
	private WebElement addToNewCollection;
	
	
	protected Catalog selectFavList(String productInfo, String listName, String newOrExistingList, boolean isNewProduct) {
//				String brand= productInfo.split(">")[0];
//				String productName= productInfo.split(">")[1];
//				String img= productInfo.split(">")[2];
//				UtilHBM.waitExplicitDisplayed(driver, searchInputBox);
//				if(!(searchInputBox.isDisplayed())){
//					UtilHBM.reportKO("Search favorite list input box is not displayed while addign product to favorite");
//				}
				/*
				if(brandName.getText().equalsIgnoreCase(brand)||prdName.getText().contains(productName) 
						|| prdImg.getAttribute("src").equalsIgnoreCase(img)){
					UtilHBM.reportOK("Product Info verified while adding product in Favorite List " + listName);
				}else{
					UtilHBM.reportOK("Product Info verification failed while adding product in Favorite List " + listName);
				}	
				*/			
//				if(newOrExistingList.equalsIgnoreCase("new")){
//					addToNewList.click();
//					UtilHBM.waitExplicitClickable(driver, listNameInputBox);
//					listNameInputBox.sendKeys(listName);
//					createListButton.click();
//				}else{
//					searchInputBox.sendKeys(listName + Keys.ENTER);
//					UtilHBM.waitFixTime(1000);
//					WebElement list = driver.findElements(By.xpath("//div/div/div[@class='favorite-infos']/div[.='"+listName +"']")).get(0);
//					list.click();
//				}
				
				if(newOrExistingList.equalsIgnoreCase("new")){
					addToNewCollection.click();
					UtilHBM.waitExplicitClickable(driver, listNameInputBox);
					listNameInputBox.sendKeys(listName);
					createListButton.click();
				}else{
					WebElement listAddButton = driver.findElements(By.xpath("//div/div/div[@class='sheet-hairclip']/span[.='"+listName+"']/parent::div[@class='sheet-hairclip']//div/button[@class='button']")).get(0);
					UtilHBM.waitExplicitDisplayed(driver, listAddButton);
					UtilHBM.waitFixTime(4000);
					listAddButton.click();
				}
				/*
				UtilHBM.waitExplicitClickable(driver, notifcationMsg);
				if(isNewProduct){
					Verification.verifyText(notifcationMsg, "Added to ODTPlanner", "Favotite list success message");
					Verification.displayNAttributeCheckOfElement(notifcationMsg, "Favorite list notification", "class", "success");
					
//					Verification.verifyText(notifcationMsg, "Added to " + favList, "Favotite list success message");
					if(!(notifcationMsg.getText().equalsIgnoreCase("Added to " + listName))){
						UtilHBM.reportKO("Notification message not displayed after adding product to Favorite list " + listName);
						}
					}else{
						
						Verification.verifyText(notifcationMsg, "Your product has already been added to this collection", "Favotite list success message");
						Verification.displayNAttributeCheckOfElement(notifcationMsg, "Favorite list notification", "class", "error");
						if(!(notifcationMsg.getText().equalsIgnoreCase("Your product has already been added to this collection"))){
							UtilHBM.reportKO("Notification message not displayed after adding product to Favorite list " + listName);
						}
						closeMessageBtn.click();
						closeButton.click();
					}
					*/
				verifyAddToFavSuccess(listName, isNewProduct);
				
				
		return PageFactory.initElements(driver, Catalog.class);
	}
	
//	protected ThreeDPlanner searchNSelectFavList(String favList){
//		UtilHBM.waitExplicitDisplayed(driver, searchInputBox);
//		searchInputBox.sendKeys(favList);
//		UtilHBM.waitFixTime(1000);
//		WebElement list = driver.findElements(By.xpath("//div/div/div[@class='favorite-infos']/div[.='"+favList +"']")).get(0);
//		list.click();
//		UtilHBM.waitExplicitClickable(driver, notifcationMsg);
//		if(!notifcationMsg.getText().equalsIgnoreCase("Added to " + favList)){
//			UtilHBM.reportKO("Notification message not displayed after adding product to Favorite list " + favList);
//		}
//		closeMessageBtn.click();
//		return PageFactory.initElements(driver, ThreeDPlanner.class);
//	}
	
	protected ThreeDPlanner searchNSelectFavList(String favList, boolean isNew){
		UtilHBM.waitExplicitDisplayed(driver, searchInputBox);
		searchInputBox.sendKeys(favList+Keys.ENTER);
		UtilHBM.waitFixTime(1000);
		WebElement list = driver.findElements(By.xpath("//div/div/div[@class='favorite-infos']/div[.='"+favList +"']")).get(0);
		list.click();
		verifyAddToFavSuccess(favList, isNew);
		/*
		closeButton.click();
		UtilHBM.waitExplicitDisplayed(driver, notifcationMsg);
		//driver.switchTo().frame(driver.findElement(By.id("planner-embed-iframe")));
		
		//UtilHBM.waitExplicitClickable(driver, notifcationMsg);
		if(isNew){
			Verification.verifyText(notifcationMsg, "Your product has already been added to this favorites list", "Favotite list success message");
			Verification.displayNAttributeCheckOfElement(notifcationMsg, "Favorite list notification", "class", "error");
			}else{
				Verification.verifyText(notifcationMsg, "Added to " + favList, "Favotite list success message");
		
			}
		closeMessageBtn.click();
		*/
		return PageFactory.initElements(driver, ThreeDPlanner.class);
	}
	
	public SelectFavList verifyAddToFavSuccess(String favListName, boolean isItemAlreadyAvailableInFavList) {
		if (isItemAlreadyAvailableInFavList) {
			UtilHBM.waitExplicitDisplayed(driver, notifcationMsgSuccess);
			Verification.VerifyEquals("Added to favorite list succcess message not displayed",
					notifcationMsgSuccess.getText(), "Added to " + favListName);
			UtilHBM.waitExplicitDisplayed(driver, closeNotifcationMsgSuccess);
			UtilHBM.waitExplicitClickable(driver, closeNotifcationMsgSuccess);
			closeNotifcationMsgSuccess.click();
			UtilHBM.waitFixTime(500);
			
		} else {
			UtilHBM.waitExplicitDisplayed(driver, alreadyAvailableNotifcationMsg);
			Verification.VerifyEquals(
					"Your product has already been added to this favorites list message not displayed",
					alreadyAvailableNotifcationMsg.getText(), "Your product has already been added to this collection");
			UtilHBM.waitExplicitDisplayed(driver, closeAlreadyAvailableNotifcationMsg);
			UtilHBM.waitExplicitClickable(driver, closeAlreadyAvailableNotifcationMsg);
			closeAlreadyAvailableNotifcationMsg.click();
			UtilHBM.waitFixTime(500);
			closeButton.click();
		}
		return this;
	}
	

}
