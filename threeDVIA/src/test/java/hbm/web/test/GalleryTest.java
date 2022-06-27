package hbm.web.test;

import hbm.planner.utility.Browser;
import hbm.web.pageobject.Gallery;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

	@Test
public class GalleryTest extends Browser{
	
	@Test	
	public void galleryTest(){	
		Gallery gallery = PageFactory.initElements(driver, Gallery.class);
		gallery.checkFeaturedProject();
	}
}
