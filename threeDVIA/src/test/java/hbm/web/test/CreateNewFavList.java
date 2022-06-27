package hbm.web.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.MyFavorites;

public class CreateNewFavList extends Browser {

	@Test(dataProvider = "loginData", dataProviderClass = SignUpData.class)
	public void createNewCollections(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
				.goToInspiration()
				.addItemInCollectionFromFeed(true, false, "FavWeb-New-ImgPage-Prd", 0, 1, "Product")
				.goToInspiration()
				.addItemInCollectionFromFeed(true, false, "FavWeb-New-Feed-Img", 1, 0, "Image")
				.goToInspiration()
				.addItemInCollectionFrmImgPage(true, false, "FavWeb-New-ImgPin-Prd", 0, 1, "Product")	
				.goToInspiration()
				.addItemInCollectionFrmImgPage(true, false, "FavWeb-New-ImgPage-Img", 1, 0, "Image")
				.goToMyProjects()
				.openOwnProject(0, "Duplicate")
				.goToProductsTab()
				.addItemInCollection(true, false, "FavWeb-New-ProductsTab-Prd", 0, 1, "Product", "LUMYS;LORENOVE")
				.goToMyProjects()
				.openOwnProject(0, "Duplicate")
				.goToImagesTab()
				.goToMediaType("Realistic images", false)
//				.addItemInCollection(true, false,  "FavWeb-New-ImagesTab-Img", 1, 0, "Image", "https://byme-preprod-697c4ef6b5ec31e272ee67749bea4b727f31d5b0.s3-eu-west-1.amazonaws.com/data/homebymeProjects/6B3EAACD-5E16-4390-8341-C96CA22792DB/images/renderHQ/9966FA08-EA50-4187-9640-2A1610626478")
				.addItemInCollection(true, false, "FavWeb-New-ImagesTab-Img", 1, 0, "Image", "https://byme-preprod-697c4ef6b5ec31e272ee67749bea4b727f31d5b0.s3-eu-west-1.amazonaws.com/data/homebymeProjects/BC7089CE-75CA-457E-A0B0-CD6C35D7E107/images/renderHQ/CF48C822-C15D-4D3A-A199-8022D43B104E")				
				.clickHbmLogo()
				.logout()
				;
	}

	@Test(dataProvider = "loginData", dataProviderClass = SignUpData.class, dependsOnMethods = "createNewCollections")
	public void verifyCollections(SignUpData signUpData) {
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData)
				.goToMyCollections()
				.verifyFirstCollectionName("FavWeb-New-ImagesTab-Img")
				.verifyCollection("FavWeb-New-ImgPage-Prd", 0, 1)
				.verifyCollection("FavWeb-New-Feed-Img", 1, 0)
				.verifyCollection("FavWeb-New-ImgPin-Prd", 0, 1)
				.verifyCollection("FavWeb-New-ImgPage-Img", 1, 0)
				.verifyCollection("FavWeb-New-ProductsTab-Prd", 0, 1)
				.verifyCollection("FavWeb-New-ImagesTab-Img", 1, 0)
				;
		}

	@Test(dependsOnMethods = "verifyCollections")
	public void deleteNewCollections() {
		MyFavorites myFavorites = PageFactory.initElements(driver, MyFavorites.class);
		myFavorites.openCollection(0, "FavWeb-New-ImagesTab-Img")
				.deleteCollection("FavWeb-New-ImagesTab-Img", 1)
				.verifyFirstCollectionName("FavWeb-New-ProductsTab-Prd")
				.openCollection(0, "FavWeb-New-ProductsTab-Prd")
				.deleteCollection("FavWeb-New-ProductsTab-Prd", 1)
				.verifyFirstCollectionName("FavWeb-New-ImgPage-Img")
				.openCollection(0, "FavWeb-New-ImgPage-Img")
				.deleteCollection("FavWeb-New-ImgPage-Img", 1)
				.verifyFirstCollectionName("FavWeb-New-ImgPin-Prd")
				.openCollection(0, "FavWeb-New-ImgPin-Prd")
				.deleteCollection("FavWeb-New-ImgPin-Prd", 1)
				.verifyFirstCollectionName("FavWeb-New-Feed-Img")
				.openCollection(0, "FavWeb-New-Feed-Img")
				.deleteCollection("FavWeb-New-Feed-Img", 1)
				.verifyFirstCollectionName("FavWeb-New-ImgPage-Prd")
				.openCollection(0, "FavWeb-New-ImgPage-Prd")
				.deleteCollection("FavWeb-New-ImgPage-Prd", 1)
				.clickHbmLogo()
				.logout()
				;
		}
}