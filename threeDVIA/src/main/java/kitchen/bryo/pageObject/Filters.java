package kitchen.bryo.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.UtilHBM;

public class Filters {

	WebDriver driver;

	public Filters(WebDriver driver) {
		this.driver = driver;
	}

	protected Catalog filters() {
		
		String dimensions = Catalog.getFilter();
		String[] temp = dimensions.split("x");
		UtilHBM.waitTillElementDisappear(driver, "li>ul[class='subsubcat']");
		UtilHBM.waitFixTime(2500);
		for (String dim : temp) {
			String[] temp2 = dim.split("(?<=\\D)(?=\\d)");
			String key = temp2[0].trim();
			String value = temp2[1].trim();
			if (key.equalsIgnoreCase("D")) {
				filterNew(key, value);
			}
			if (key.equalsIgnoreCase("W")) {
				filterNew(key, value);
			}

		}
		return PageFactory.initElements(driver, Catalog.class);
	}

	protected Catalog filterProperty() {
		String dimensions = Catalog.getFilter();

		String[] temp = dimensions.split("\\s");
		System.out.println("Temp "+temp);
//		UtilHBM.waitTillElementDisappear(driver, "li>ul[class='subsubcat']");
		UtilHBM.waitFixTime(2500);
		for (String dim : temp) {
			String[] temp2 = dim.split("\\s");
			String key = temp2[0].trim();
			System.out.println("Key :" +key);
			String value = temp2[1].trim();
			System.out.println("Value :" +value);
			if (key.equalsIgnoreCase("custom")) {
				filterNew(key, value);
			}
			if (key.equalsIgnoreCase("38mm")) {
				filterNew(key, value);
			}
			if (key.equalsIgnoreCase("38mm")) {
				filterNew(key, value);
			}
		}
		return PageFactory.initElements(driver, Catalog.class);
	}
	
	public Catalog filterNew(String attribute, String dimValue) {
		UtilHBM.webElementXPath(
				driver,
				"//div[@id='filters']/ul/li/button[contains(text(),'"
						+ attribute + "')]").click();
		WebElement option = UtilHBM
				.webElementXPath(
						driver,
						"//div[@id='filters']/div/div/form/ul[@class='subsubcat']/li/label/input[contains(@data-name,'"
								+ attribute
								+ "')]/../span[@class='label'][contains(text(),'"
								+ dimValue + "')]/preceding-sibling::span");
		UtilHBM.waitExplicitDisplayed(driver, option);
		option.click();
		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
		return PageFactory.initElements(driver, Catalog.class);

	}

}
