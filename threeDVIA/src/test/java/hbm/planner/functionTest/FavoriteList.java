package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.pageobject.ThreeDPlanner;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.UserHomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FavoriteList extends Browser{
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void createFavoriteList(SignUpData signUpData){
		LandingPage home = PageFactory.initElements(driver, LandingPage.class);
		home.loginExistingUser(signUpData);
		UserHomePage userHome = PageFactory.initElements(driver, UserHomePage.class);
		userHome.editLatestProject();
		ThreeDPlanner planner = PageFactory.initElements(driver, ThreeDPlanner.class);
		planner.edit3DWallPropertiesDev(100,50, "Satin paint", 7, "10666", 0)
		.verify3DWallPropertiesDev(100, 50, "Satin paint", 7, "10666", 1)
		.addMtlFrmWallToFavorite(100, 50, "ODTPlanner", "existing", true)
		.addMtlFrmWallToFavorite(100, 50, "ODTPlanner", "existing", false)
		.removePrdFrmFavList("ODTPlanner", "10666")
//		.removePrdFrmFavList("ODTPlanner", "2747")
		.createFavoriteList("NewAutoTest", "253;459", true)
//		.addAProductFromFavorites("AutoTest", "253", "GuestRoom", -150, -200)
		.removePrdFrmFavList("NewAutoTest", "253")
		.deleteFavoriteList("NewAutoTest");
		
	}
}
