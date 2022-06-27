package kitchen.bryo.functionTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import hbm.planner.dataobject.SignUpData;
import hbm.planner.utility.Browser;
import hbm.planner.utility.UtilHBM;
import kitchen.bryo.pageObject.HomePage;
import kitchen.bryo.pageObject.SelectMapping;
import kitchen.bryo.pageObject.StartNow;

public class PriceTest4 extends Browser {
	@Test(dataProvider = "bryoLogin", dataProviderClass = SignUpData.class)
	public void priceTestFour(SignUpData signUpData){
		StartNow start=PageFactory.initElements(driver, StartNow.class);
    	start.startDemo("en-GB")
    
      .startFromScratch()
                .nextStep()
                .skipLayoutNo()
                .waterSupplyPositionPopUp("No", 0, 0)
                
                .lookingForNeedMapping("Update my needs", SelectMapping.class)
                .updateStyleMapping("Paris - Grey", "38mm Acrylic Worktop", "170mm Bar Handle")
                .updateLayoutMapping("I-shaped")
                .updateCookingMapping("Integrated")
                .updateRefrigerationMapping("Integrated")
                .generateNewLayouts()
              
                .findSolutions("13 - I Shaped kitchen")
                .verifyPriceInStep2("17 978,88")
                .verifyPricePerMonthInStep2("374,95")
                .verifyTemplatePriceInStep2("17 431,33","374,95")
                .nextStepDesignYourKitchen("no", "no")
                .step4()
                .clickMonthlyPayment()
                .verifyPricePerMonthInStep4("374,95")
                
                .clickShowFinanceDetail()
                .verifyFinanceOptions("€ 483,69/month for 36 months")
                .verifyPricePerMonthInStep4("483,69")
                .clickDesignStep()
                .verifyPricePerMonthInStep3("483,69")
                .verifyPriceInformation("17 431,33","483,69", "36 months");
              
	}
}
