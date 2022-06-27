package hr.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class Door extends Browser {
	
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void door(SignUpData signUpData) {
	
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
	
		home.login(signUpData)
		.planMyRoomClick()
		.build()
		.catelogSubCategory("folding_doors")
		.filter("Wood", "", "Brown")//verification fails plz check
		//.favIconInCatalogList("0", "Retailer Fav List", 1)
		.addProduct("Interior door", "0")
		.closeCatalog()
		.clickInPlanner(56, 165)
		.duplicateProd()//check verification not working
		.deleteProd()
		.editBuild(56, 165, "", "100", "") //Error in height: element not interactable
		.closeEditPanel()
		.clickInPlanner(56, 165)
		.productInfo()
		//product sheet is open
		.image("Interior door")
		.similarProducts("30", "")
		.clickFavIconInSimilarList("0") //check if this is not required at all
		.clickOnNewFavList("Door ProductSheet FavList")
		.closeProductSheet()
		.productInfo()
		.clickOnSimilarProduct("0")
		.back()
		.clickfavInProductSheet()
		.clickOnFavList("Door ProductSheet FavList", 0)
		.addInProject()
		.editBuild(0, -165, "", "", "") //verify product is added
		.clickOnFavorites()
		.clickOnFavList1("Door ProductSheet FavList", 0)
		.favIconInFavoriteList("0", 0, 1) //yes=1, no=2 // check not required
		.backButton()
		.deleteFavoritesList("Door ProductSheet FavList", 1, true)
		;
	}
}
