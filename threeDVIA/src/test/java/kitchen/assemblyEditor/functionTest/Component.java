package kitchen.assemblyEditor.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.utility.Browser;
import kitchen.assemblyEditor.pageObject.StartApplication;

@Test
public class Component extends Browser {
    public void aeComponent() {
        StartApplication startApplication = PageFactory.initElements(driver, StartApplication.class);
        startApplication.startApp()
                .addNewComponent("legAssembly_1", "catalog", "legAssembly_ODT", "legAssembly_ODT")
                .verifyComponent("legAssembly_1", "legAssembly_ODT")
                .duplicateComponent("legAssembly_1")
                .verifyComponent("legAssembly_1-copy0", "legAssembly_ODT")
                .verifyComponentCount(2)
                .addNewParameter("legHeight", "number", "80")
                .addNewParameter("leg", "component", "Legs", "Leg")
                .addNewParameter("leftLegOption", "integer", "1")
                .addComponentOverloads("legAssembly_1", "leg", "symbol", "leg")
                .addComponentOverloads("legAssembly_1", "legHeight", "symbol", "legHeight")
                .addComponentOverloads("legAssembly_1", "leftLegOption", "symbol", "leftLegOption")
                .selectComponent("legAssembly_1").verifyComponentOverloads("leg", true, "symbol", "leg")
                .editComponent("legAssembly_1", "boxAssembly_1", "catalog", "box", "U2DA80_box")
                .deleteComponent("boxAssembly_1");
    }
}