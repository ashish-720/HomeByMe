package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.MyFavorites;

public class VerifyFavorites extends Browser {

	@Test(dataProvider = "loginData", dataProviderClass = SignUpData.class)
	public void createCollection(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
				.goToMyCollections()
				.verifyCreateAListDialog()
				.createNewCollection("ODTFavWeb-MyFav-Daily")
				.createNewCollection("ODTFavWeb-MyFav-ToBeDel")
				.verifyCollection("ODTFavWeb-MyFav-Daily", 0, 0)
				.verifyCollection("ODTFavWeb-MyFav-ToBeDel", 0, 0)
				;
		}
	
	@Test( dependsOnMethods = "createCollection")
	public void addToCollectionFrmFeed() {
		MyFavorites myFavorites = PageFactory.initElements(driver, MyFavorites.class);
		myFavorites.verifyFirstCollectionName("ODTFavWeb-MyFav-ToBeDel")
				.openCollection(0,"ODTFavWeb-MyFav-Daily")
				.clickFindInspiration()
				.addItemInCollectionFromFeed(false, false, "ODTFavWeb-MyFav-Daily", 0, 1, "Product")
				.goToInspiration()
				.addItemInCollectionFromFeed(false, false, "ODTFavWeb-MyFav-Daily", 1, 1, "Image")
				.goToInspiration()
				.addItemInCollectionFrmImgPage(false, false, "ODTFavWeb-MyFav-Daily", 1, 2, "Product")	
				.goToInspiration()
				.addItemInCollectionFrmImgPage(false, false, "ODTFavWeb-MyFav-Daily", 2, 2, "Image")
				.goToMyCollections()
				.verifyCollection("ODTFavWeb-MyFav-Daily", 2, 2)
				;
		}
	
	@Test( dependsOnMethods = "addToCollectionFrmFeed")
	public void addExistingItemsInCollection() {
		MyFavorites myFavorites = PageFactory.initElements(driver, MyFavorites.class);
		myFavorites.goToInspiration()
				.addItemInCollectionFromFeed(false, true, "ODTFavWeb-MyFav-Daily", 0, 1, "Product")
				.goToInspiration()
				.addItemInCollectionFromFeed(false, true, "ODTFavWeb-MyFav-Daily", 1, 1, "Image")
				.goToInspiration()
				.addItemInCollectionFrmImgPage(false, true, "ODTFavWeb-MyFav-Daily", 1, 2, "Product")	
				.goToInspiration()
				.addItemInCollectionFrmImgPage(false, true, "ODTFavWeb-MyFav-Daily", 2, 2, "Image")
				.goToMyCollections()
				.verifyCollection("ODTFavWeb-MyFav-Daily", 2, 2)
				.verifyFirstCollectionName("ODTFavWeb-MyFav-Daily")
				.openCollection(0)
				.editCollectionNameFromActions("EditedFromActions-"+ UtilHBM.getDate(0, "ddMMyyyy"))
				.goToMyCollections()
				.verifyFirstCollectionName("EditedFromActions-"+ UtilHBM.getDate(0, "ddMMyyyy"))
				;
		}
	
	@Test(dependsOnMethods = "addExistingItemsInCollection")
	public void addToCollectionFrmProject() {
		MyFavorites myFavorites = PageFactory.initElements(driver, MyFavorites.class);
		myFavorites
				.openCollection(0,"ODTOldFavList")
				.clickShareCollectionButton()
				.verifyShareCollectionContainer()
				.verifyShareCollectionByCopyLink("ODTOldFavList", 10, 10)
				.editCollectionNameFromTitle("Edited-ODTOldFavList")
				.goToMyCollections()
				.verifyFirstCollectionName("Edited-ODTOldFavList")
				.goToMyProjects()
				.openOwnProject(0, "Duplicate")
				.goToProductsTab()
				.addItemInCollection(false, false, "Edited-ODTOldFavList", 10, 11, "Product", "LUMYS;LORENOVE")
				.goToMyProjects()
				.openOwnProject(0, "Duplicate")
				.goToImagesTab()
				.goToMediaType("Realistic images", false)
//				.addItemInCollection(false, false, "Edited-ODTOldFavList", 11, 11, "Image","https://byme-preprod-697c4ef6b5ec31e272ee67749bea4b727f31d5b0.s3-eu-west-1.amazonaws.com/data/homebymeProjects/6B3EAACD-5E16-4390-8341-C96CA22792DB/images/renderHQ/9966FA08-EA50-4187-9640-2A1610626478")
				.addItemInCollection(false, false, "Edited-ODTOldFavList", 11, 11,"Image", "https://byme-preprod-697c4ef6b5ec31e272ee67749bea4b727f31d5b0.s3-eu-west-1.amazonaws.com/data/homebymeProjects/BC7089CE-75CA-457E-A0B0-CD6C35D7E107/images/renderHQ/CF48C822-C15D-4D3A-A199-8022D43B104E")			
				.goToMyCollections()
				.verifyCollection("Edited-ODTOldFavList", 11, 11)
				.clickHbmLogo()
				.logout()
				;
		}
	
	@Test(dataProvider = "loginData", dataProviderClass = SignUpData.class, dependsOnMethods = "addToCollectionFrmProject")
	public void deleteOneCollectionItem(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
				.goToMyCollections()
				.verifyCollection("Edited-ODTOldFavList", 11, 11)
				.openCollection(0,"Edited-ODTOldFavList")
				.openImagesTab(11)
				.clickCollectionActions()
				.clickEditCollection()
//				.deleteCollectionItem("Image","9966FA08-EA50-4187-9640-2A1610626478")
				.deleteCollectionItem("Image","CF48C822-C15D-4D3A-A199-8022D43B104E")
				.openProductsTab(11)
				.clickCollectionActions()
				.clickEditCollection()
				.deleteCollectionItem("Product","LUMYS;LORENOVE")
				.goToMyCollections()
				.verifyFirstCollectionName("Edited-ODTOldFavList")
				.verifyCollection("Edited-ODTOldFavList", 10, 10)
				.openCollection(0,"Edited-ODTOldFavList")
				.editCollectionNameFromActions("ODTOldFavList")
				.goToMyCollections();
}
	
	@Test(dependsOnMethods = "deleteOneCollectionItem")
	public void deleteCollectionItemsBySelectAll() {
		MyFavorites myFavorites = PageFactory.initElements(driver, MyFavorites.class);
		myFavorites
				.verifyCollection("EditedFromActions-"+ UtilHBM.getDate(0, "ddMMyyyy"), 2, 2)
				.openCollection(0,"EditedFromActions-"+ UtilHBM.getDate(0, "ddMMyyyy"))
				.openImagesTab(2)
				.clickCollectionActions()
				.clickEditCollection()
				.clickSelectAll()
				.verifyEditCollectionHeader(2)
				.clickDeleteItem()
				.clickConfirmDeleteItem()
				.openAllItemsTab(2)
				.verifyCollectionContents(0, 2)
				.openProductsTab(2)
				.clickCollectionActions()
				.clickEditCollection()
				.clickSelectAll()
				.verifyEditCollectionHeader(2)
				.clickDeleteItem()
				.clickConfirmDeleteItem()
				.verifyCollectionContents(0, 0)
				.goToMyCollections()
				;
		}
	
	@Test(dependsOnMethods = "deleteCollectionItemsBySelectAll")
	public void deleteCollections() {
		MyFavorites myFavorites = PageFactory.initElements(driver, MyFavorites.class);
		myFavorites.openCollection(0,"ODTFavWeb-MyFav-ToBeDel")
				.editCollectionNameFromActions("Edited-MyFav-ToBeDel")
				.goToMyCollections()
				.verifyFirstCollectionName("Edited-MyFav-ToBeDel")
				.openCollection(0)
				.deleteCollection("Edited-MyFav-ToBeDel", 0)
				.openCollection(0,"EditedFromActions-"+ UtilHBM.getDate(0, "ddMMyyyy"))
				.verifyCollectionTitle("EditedFromActions-"+ UtilHBM.getDate(0, "ddMMyyyy"))
				.editCollectionNameFromTitle("ODTFavWeb-" + UtilHBM.getDate(0, "ddMMyyyy"))
				.deleteCollection("ODTFavWeb-" + UtilHBM.getDate(0, "ddMMyyyy"), 0)
				.verifyPageTitle()
				.clickHbmLogo()
				.logout()
				;		
		}
}
	