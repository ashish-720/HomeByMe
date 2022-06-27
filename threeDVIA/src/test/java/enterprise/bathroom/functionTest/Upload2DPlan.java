package enterprise.bathroom.functionTest;

import enterprise.bathroom.plannerPO.StartNowBathroom;
import enterprise.bathroom.plannerPO.Upload2DPlanBathroom;
import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


@Test
public class Upload2DPlan extends Browser {

    @Test(dataProvider = "bathroomUserData", dataProviderClass = SignUpData.class)
    public void upload2DPlan(SignUpData signUpData) throws InterruptedException {
        StartNowBathroom start = PageFactory.initElements(driver, StartNowBathroom.class);
        start.loginBathroom(signUpData)
                .openMyProjectList()
                .myProjectPage()
                .openProjectBathroom(0, "Upload a 2D plan")
                .clickFloorplanBathroom()
                .uploadTwoPlan()
                .getStarted()
                .selectFile("2DFP.jpg")
                .selectFloorPlan(50, 60)
                .zoomIn(2)
                .zoomOut(2)
                .yourPlan()
                .deleteYourPlan()
                .deleteNo()
                .changeYourPlan()
                .selectFile("2DFP.png")
                .selectFloorPlan(50, 60)
                .undo(driver, 1)
                .redo(driver, 1)
                .selectFloorPlan(50, 60)
                .yourPlan()
                .deleteYourPlan()
                .deleteYes()
                .selectFile("singlePage2DPlan.pdf")
                .chooseThisPage()
                .selectFloorPlan(50, 60)
                .rotation(-10, 20, "243")
                .opacity(20, 0, "66")
                .move()
                .movePlanBathroom(50, 60, 100, 120)
                .zoomIn(2)
                .zoomOut(2)
                .yourPlan()
                .deleteYourPlan()
                .deleteYes()
                .selectFile("multiplePage2DPlan.pdf")
                .nextBtn(2)
                .chooseThisPage()
                .zoomIn(2)
                .zoomOut(2);


    }
}



