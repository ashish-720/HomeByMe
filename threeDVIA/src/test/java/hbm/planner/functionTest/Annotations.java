package hbm.planner.functionTest;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.web.pageobject.LandingPage;
import hbm.web.pageobject.ProjectPage;
import hbm.web.pageobject.UserHomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class Annotations extends Browser{	
	
	@Test(dataProvider="loginData", dataProviderClass=SignUpData.class)
	public void annotations (SignUpData signUpData){
		LandingPage homepage = PageFactory.initElements(driver, LandingPage.class);
		homepage.loginExistingUser(signUpData);
//		Browser.openUrl(driver, "https://preprod-home.by.me/en/?alpha");
		UserHomePage home = PageFactory.initElements(driver, UserHomePage.class);
		home.editLatestProject()
		
		//Reuse Alpha feature
		.edit3DWallPropertiesDev(-300, 200, "Satin paint", 11, "10705", 1)
		.reUseDev(-300, 200)
		.clickInPlanner(100, 100)
		.reUseValidate()
		.verify3DWallPropertiesDev(100, 100, "Satin paint", 11, "10705", 1)
		.snapshot3D("reuse", 0)
		
		//Annotation Alpha feature
		.twoDView()
		.annotation("Arrow", -500, 0)
//		.clickInPlanner(-500, 0)
		.dragNDrop(-500, 0, -550, 50)
//		.editAnnotationsDev(-550, 50)
		.editLineAnnotations(-550, 50, "8", 14, 2, "arrow", "straight")
//		.lineEditAnnotation(-550, 50, "8", 14, 2, "arrow", "straight")
		.annotation("Rectangle", 100, 100)
//		.clickInPlanner(100, 100)
		.dragNDrop(100, 100, 150, 100)
//		.editAnnotationsDev(150, 150)
		.editAnnotations(150, 150,false, 2, 50, 0, "3", 4, 2, 15, "Georgia", "24")
		.verifyAnnotation(150, 150, false, "DC143C", "F08080", "F08080")
		.textInput(150, 150, "first text", 0)
		.annotation("Ellipse", -500, -100)
//		.clickInPlanner(-500, -100)
		.dragNDrop(-500, -100, -600, -200)
		.textInput(-550, -150, "second text", 1)
//		.editAnnotationsDev(-550, -150)
		.editAnnotations(-550, -150, true, 2, 50, 0, "3", 8, 2, 15, "Georgia", "24")
		.verifyAnnotation(-550, -150, false, "DC143C", "F08080", "F08080")
//		.editAnnotationsDev(-550, -150)
		.editAnnotations(-550, -150, true, 2, 50, 0, "16", 10, 2, 17, "Corbel", "30")
		.deleteDev(-550, -150)
		.undo(1)
		.zoomOut(5)
		.snapshot2D("QR code & Annotations", "on floor", false, false, "", false, false, true, true)
		.zoomIn(5)
		.annotation("Hide annotations", -500, -100)
		.snapshot2D("room name and QR code", "on floor", true, false, "", true, false, true, false)
		.annotation("Show annotations", -500, -100)
		.snapshot2D("room name and annotations", "on floor", true, false, "", true, false, false, true)
		.snapshot2D("room name & no area", "on floor", true, false, "", true, false, false, false)
		.closePlannerWithoutSave();
		
		Browser.openUrl(driver, "https://preprod-home.by.me/en/project/reetie.y+41-1900/annotationcheckaftersave/");
		ProjectPage home1 = PageFactory.initElements(driver, ProjectPage.class);
		home1.clickOpenProjectButtonOld()
		.twoDView()
		.annotation("Ellipse", -500, -100)
//		.clickInPlanner(-500, -100)
		.dragNDrop(-500, -100, -600, -200)
		.textInput(-550, -150, "check text", 0)
//		.editAnnotationsDev(-550, -150)
		.editAnnotations(-550, -150, true, 2, 50, 0, "3", 8, 2, 15, "Georgia", "24")
		.saveClick()
		.saveAsCopy("Annotations")
		.twoDView()
//		.editAnnotationsDev(-550, -150)
		.editAnnotations(-550, -150, true, 2, 50, 0, "16", 10, 2, 17, "Georgia", "24")
		.snapshot2D("room name & QR code & annotations", "on floor", true, false, "", true, false, true, true)
		.save()
		.closePlanner()
		.goToMyProjects()
		.openOwnProject(2)
		.clickOpenProjectButtonOld()
		.twoDView()
		.save()
		.closePlanner();
		
			
	}
}
