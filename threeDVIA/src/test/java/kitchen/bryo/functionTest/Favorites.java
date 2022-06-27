package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import kitchen.bryo.pageObject.StartNow;


	@Test
	public class Favorites extends Browser {
		
		@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
		public void favorites(SignUpData signUpData) {
			StartNow start = PageFactory.initElements(driver, StartNow.class);
			start.startDemo("en-GB")
			.login(signUpData)
			.startFromScratch()
			.step3()
			.clickOnFavorites()
			.createNewFavoritesList("BRYO Fav List")
			.searchProductInFav()
			.search("CKT800")
			.favIconInCatalogList("0", "BRYO Fav List", 0)
			.addProductDesignStep("CKT800", true, false, false)
			 .clickSearch()
			.search("WOODEN SHELF")
			.favIconInCatalogList("0", "BRYO Fav List", 0)
			.addProductDesignStep("WOODEN SHELF", true, false, false)
			.clickOnFavorites()
			.removeProductFromFavoritesList("BRYO Fav List","CKT800", 0, true)
			.deleteFavoritesList("BRYO Fav List", 0, false)
			.clickOnFavList1("BRYO Fav List", 0)
			.favIconInFavoriteList("0", 0, 1) //yes=1, no=2
			.editFavListName("new fav list")
			.backButton()
			.deleteFavoritesList("new fav list", 0, true);
		}
	}



