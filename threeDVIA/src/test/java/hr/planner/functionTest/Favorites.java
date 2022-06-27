package hr.planner.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;


	@Test
	public class Favorites extends Browser {
		
		@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
		public void favorites(SignUpData signUpData) {
		
			LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
		
			home.login(signUpData)
			.planMyRoomClick()
			.clickOnFavorites()
			.createNewFavoritesList("Retailer Fav List")
			
			.searchProductInFav()
			.search("Sofa")
			.favIconInCatalogList("0", "Retailer Fav List", 0)
			.addProduct("Sofa", "0")
			.closeCatalog()
			.clickOnFavorites()
			.deleteFavoritesList("Retailer Fav List", 3, false)
			.deleteFavoritesList("Retailer Fav List", 3, true)//change name to 'new name'
			//add success msg verification
			.clickOnFavList1("Retailer Fav List", 0)
//			.favIconInFavoriteList("0", 0, 1) //yes=1, no=2 //check : not required now
			.editFavListName("new name")
			.backButton()
			
			
			;
		}
		// edit name,delete product in fav list, delete fav list
	}



