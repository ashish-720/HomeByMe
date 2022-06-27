package hbm.web.test;

import hbm.planner.utility.Browser;
import hbm.web.pageobject.Academy;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

	@Test
public class AcademyTest extends Browser{
//Test will be added in web.xml by renaming for tutorials page once it is available on preprod	
	@Test
	@Parameters("link")
	public void academyTest(@Optional ("preprod") String link){	
		Academy academy = PageFactory.initElements(driver, Academy.class);
		academy.checkFeaturedArticles().checkExploreLinks();
//		academy.checkAspectsOfInteriorDesign();
	}	
}