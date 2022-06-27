package hr.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ConfigurableProduct extends Browser {
	
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void configurableProduct(SignUpData signUpData) {	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);	
		home.login(signUpData).planMyRoomClick().furnish().catelogSubCategory("wardrobes")
		.filter("", "Wardrobes", "")
		.addProduct("Gautier Configurable Module 1", "2")
		.closeCatalog()
		.editProperties(0,  -66)
		.configure()
		.verifyConfigurator()
		.closeConfigurator()
		.clickInPlanner(0, -66)
		.deleteProd()
		.undo()
		
		.clickInPlanner(0, -66)
		.productInfo()
		//product sheet is open
		
		.image("Gautier Configurable Module 1")
		.similarProducts("2", "Existe en différentes finitions")
		.clickFavIconInSimilarList("0")
		.clickOnNewFavList("Configurable FavList")
		.closeProductSheet()
		.productInfo()
		.similarProducts("2", "Existe en différentes finitions")
		.clickOnSimilarProduct("0")
		.back()
		.clickfavInProductSheet()
		.clickOnFavList("Configurable FavList", 0)
		.addInProject()
		.clickInPlanner(100, -100)
		.editFurniture(71, 78, "", "", "") //verify product is added
		.clickOnFavorites()
		.clickOnFavList1("Configurable FavList", 0)
		.favIconInFavoriteList("0", 0, 1) //yes=1, no=2
		.backButton()
		.deleteFavoritesList("Configurable FavList", 1, true)
		.maximizePanel()
		.minimizePanel()
		.closeFavPanel()
		.editFurniture(71, 78, "", "", "")
		.productInfo()
//		.configure() //not working
//		.verifyConfigurator()
//		.closeConfigurator()
//		.productInfo()
		.visitStore()
		
		
		
		
		
		
//		
//		.similarProducts("2", "Exist in different colors")
//		.information()
//		.image("Gautier Configurable Module 1")
//		.similarProducts("2", "Exist in different colors")
//		.clickFavIconInSimilarList("0")
//		.clickOnNewFavList("new list")
//		.clickfavInProductSheet()
//		.clickOnFavList("new name", 0)
////		.configure()
////		.verifyConfigurator()
////		.closeConfigurator()
////		.productInfo()
////		.close()
////		.productInfo()
////		.addInProject()
		;
	}
}
