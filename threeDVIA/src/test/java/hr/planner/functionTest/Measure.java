package hr.planner.functionTest;

import hbm.planner.utility.Browser;
import hr.web.pageObject.LandingPageHR;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class Measure extends Browser {
	
	public void measure() {
		
		LandingPageHR home = PageFactory.initElements(driver, LandingPageHR.class);
		
		home.planMyRoomClick()
		.measure()
		.zoomIn(1)
		.zoomOut(1)
		.measureIn3D(-122, -23, 117, -23, "316 cm")
		.editMeasureDev(120, -23, -125, -23, "200 cm")
		.okMeasure()
		//.twoD()
		
		
		;
	}
}
 