package hr.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class ProductSheet extends Browser {
	
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void productSheet(SignUpData signUpData) {
	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
	
		home.login(signUpData)
		.planMyRoomClick()
		.furnish()
		.catelogSubCategory("sofas_armchairs_poufs")
		.addProduct("Saar armchair", "1")
		.closeCatalog()
		.editFurniture(10, 19, "96", "85", "86")
		.replaceProd()
		.addProduct("Baker Francis Chairs", "0")//catalog closes be default
		.clickInPlanner(10, 19)
		.productInfo()
		//product sheet is open
		.image("Baker Francis Chairs")
		.similarProducts("8", "Put some sweetness in your living room")
		.clickFavIconInSimilarList("0")
		.clickOnNewFavList("Chair ProductSheet FavList")
		.closeProductSheet()
		.productInfo()
		.similarProducts("8", "Put some sweetness in your living room")
		.clickOnSimilarProduct("0")
		.back()
		.similarProducts("8", "Put some sweetness in your living room")
		.clickfavInProductSheet()
		.clickOnFavList("Chair ProductSheet FavList", 0)
		.addInProject()
		.editFurniture(71, 78, "90", "", "") //verify product is added
		.clickOnFavorites()
		.clickOnFavList1("Chair ProductSheet FavList", 0)
		.favIconInFavoriteList("0", 0, 1) //yes=1, no=2
		.backButton()
		.deleteFavoritesList("Chair ProductSheet FavList", 1, true)
		
		
		;
	}
}
