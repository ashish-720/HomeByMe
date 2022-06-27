package kitchen.bryo.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hbm.planner.utility.Setting;
import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class MultipleDelete {
	WebDriver driver;

	public MultipleDelete(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = ".mod-properties-window-wide.mod-open button[data-ui-action='position']")
	private WebElement positionButton;

	@FindBy(css = ".mod-properties-window-wide.mod-open button[data-ui-action='delete']")
	private WebElement deleteButton;

	@FindBy(css = ".mod-properties-window-wide.mod-open button[data-ui-action='duplicate']")
	private WebElement duplicateButton;

	@FindBy(id = "bmSVG")
	private WebElement container3D;

	@FindBy(xpath = "//button[@data-ui-action='undo']/span[@class='icon-action-undo']")
	private WebElement undoButton;

	@FindBy(css = "article[class='mod-properties-window-wide mod-open']")
	List<WebElement> dimList;

	@FindBy(css = ".mod-properties-window-wide.mod-open>.text>h3")
	List<WebElement> ballon;

	@FindBy(css = ".inner-content>h1")
	private WebElement noSpaceTitle;

	@FindBy(css = ".inner-content>.text>div>p")
	private WebElement noSpaceMessage;

	@FindBy(css = ".popin-footer .cta-primary-alt-xl")
	private WebElement noSpaceYes;
	
	public MultipleDelete deleteMultipleProductsStep3(String deleteMultipleProductsInStep3) {
		multipleSelect(deleteMultipleProductsInStep3);
//		UtilHBM.waitExplicitDisplayed(driver, deleteButton);
//		UtilHBM.waitExplicitClickable(driver, deleteButton);
//		deleteButton.click();
		/*
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(By.cssSelector(
						"article[id='design-mod-properties-window-wide']>ul>li>button[data-ui-action='delete']"))
						.click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		*/
		UtilHBM.waitFixTime(1000);
		deleteButton.click();
		return PageFactory.initElements(driver, MultipleDelete.class);
	}

	public MultipleDelete duplicateMultipleProductsStep3(String duplicateMultipleProductsInStep3) {
		multipleSelect(duplicateMultipleProductsInStep3);

		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(By.cssSelector(
						"article[id='design-mod-properties-window-wide']>ul>li>ul>li>button[data-ui-action='duplicate']"))
						.click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		UtilHBM.waitExplicitDisplayed(driver,
				driver.findElement(By.cssSelector("article[class='mod-popin-no-space-small mod-open']")));
		String titleText = "No space available";
		String message = "We have not found enough space to correctly position the items. We will put them in the middle of the screen so that you can move them manually.";

		Verification.displayNAttributeCheckOfElement(noSpaceTitle, "No Space available title", "text", titleText);
		Verification.displayNAttributeCheckOfElement(noSpaceMessage, "No Space available message", "text", message);
		noSpaceYes.click();
		return PageFactory.initElements(driver, MultipleDelete.class);
	}

	public MultipleDelete positionMultipleProductsInStep3(String positionMultipleProductsInStep3,
			String positionValueToChange, String pos1) {
		multipleSelect(positionMultipleProductsInStep3);
		UtilHBM.waitExplicitDisplayed(driver, positionButton);
		UtilHBM.waitExplicitClickable(driver, positionButton);
		positionButton.click();
		List<WebElement> li = driver.findElements(By.cssSelector(".WallMeasure"));
		boolean measureFound= false;
		for (WebElement index : li){
			if (positionValueToChange.equalsIgnoreCase(index.getAttribute("value"))) {
//				new Actions(driver).moveToElement(index).click().build().perform();
				index.click();
				for (int i = 0; i < positionValueToChange.length(); i++) {
//					new Actions(driver).moveToElement(index).build().perform();
					index.sendKeys(Keys.BACK_SPACE);
				}
//				new Actions(driver).moveToElement(index).sendKeys(pos1).build().perform();
				index.sendKeys(pos1);
				UtilHBM.waitFixTime(5000);
				measureFound= true;
				UtilHBM.reportOK("Position value changed from "+positionValueToChange+" to "+pos1 );
				break;
			}
		}		
		if(!measureFound){
			for (WebElement index : li){
				UtilHBM.reportKO("Position value to edit is not found. Expected value: "+positionValueToChange+", actual value is: ");
				UtilHBM.reportKO(index.getAttribute("value"));
			}
		}			
		return PageFactory.initElements(driver, MultipleDelete.class);
	}

	public MultipleDelete verifyPositionMultipleProInStep3(String verifyPositionMultipleProductsInStep3, String dim) {
		multipleSelect(verifyPositionMultipleProductsInStep3);
		try {
			UtilHBM.waitExplicitDisplayed(driver, positionButton);
			UtilHBM.waitExplicitClickable(driver, positionButton);
			positionButton.click();
			List<WebElement> pos = driver.findElements(By.cssSelector(".WallMeasure.Tag3D"));
			int index = 0;
			for (WebElement image : pos) {
				if (dim.equalsIgnoreCase(image.getAttribute("value"))) {
					index++;
				}
			}
			if (index > 0) {
				UtilHBM.reportOK("Number of dimensions for position with value  " + dim + " are  " + index);
			}else{
				UtilHBM.reportKO("Position value verification failed. Expected Value is: "+dim+", actual values are:");
				for (WebElement image : pos) {
					UtilHBM.reportKO(image.getAttribute("value"));;
				}
			}

		} catch (StaleElementReferenceException e) {

		}
		PageFactory.initElements(driver, ProductProperties.class).closePositionPanel();
		return PageFactory.initElements(driver, MultipleDelete.class);
	}

	public MultipleDelete deleteMultipleRoomObjects(String roomObjectMultipleDelete) {
		multipleSelect(roomObjectMultipleDelete);
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(By.cssSelector(
						"ul>li>button[data-ui-action='delete']"))
						.click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}

		return PageFactory.initElements(driver, MultipleDelete.class);
	}

	public MultipleDelete duplicateMultipleRoomObjects(String roomObjectMultipleDup) {
		multipleSelect(roomObjectMultipleDup);
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				driver.findElement(By.cssSelector(
						"ul>li>button[data-ui-action='duplicate']"))
						.click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		Verification.displayOfWebElement(driver.findElement(By.xpath(
				"//article[@class='mod-properties-window-regular mod-open']/div/h3[contains(text(),'Multiple Items')]")));
		UtilHBM.waitFixTime(500);
		Verification.displayOfWebElement(positionButton);
		Verification.displayOfWebElement(duplicateButton);
		Verification.displayOfWebElement(deleteButton);
		return PageFactory.initElements(driver, MultipleDelete.class);
	}

	public MultipleDelete positionMultipleRoomObjects(String roomObjectMultiplePosition, String positionValueToChange,
			String pos1) {
		multipleSelect(roomObjectMultiplePosition);
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
		try {
			driver.findElement(By.cssSelector(
					"ul>li>button[data-ui-action='position']"))
					.click();
		
			List<WebElement> li = driver.findElements(By.cssSelector(".WallMeasure.Tag3D"));

			for (WebElement index : li) {

				if (positionValueToChange.equalsIgnoreCase(index.getAttribute("value"))) {
					System.out.println("i2 " + index.getAttribute("value"));
					new Actions(driver).moveToElement(index).click().build().perform();
					for (int i = 0; i < positionValueToChange.length(); i++) {
//						new Actions(driver).moveToElement(index).build().perform();
						index.sendKeys(Keys.BACK_SPACE);
					}
//					new Actions(driver).moveToElement(index).sendKeys(pos1).build().perform();
					index.sendKeys(pos1);
					UtilHBM.waitFixTime(5000);
				}
			}

		} catch (StaleElementReferenceException e) {

		}
		attempts++;
		}

		return PageFactory.initElements(driver, MultipleDelete.class);
	}

	public MultipleDelete verifyPositionMultipleRoomObjects(String roomObjectMultipleVerifyPosition, String dim) {
		multipleSelect(roomObjectMultipleVerifyPosition);
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
		try {
			driver.findElement(By.cssSelector(
					"ul>li>button[data-ui-action='position']"))
					.click();
			List<WebElement> pos = driver.findElements(By.cssSelector(".WallMeasure.Tag3D"));
			int index = 0;
			for (WebElement image : pos) {
				if (dim.equalsIgnoreCase(image.getAttribute("value"))) {
					index++;
				}
			}
			if (index > 0) {
				UtilHBM.reportOK("Number of dimensions for position with value  " + dim + " are  " + index);

			}

		} catch (StaleElementReferenceException e) {

		}
		attempts++;
		}


		return PageFactory.initElements(driver, MultipleDelete.class);
	}

	public MultipleDelete clickProduct(int xOffset, int yOffset) {
		Actions action = new Actions(driver);
		action.moveToElement(container3D, xOffset, yOffset).clickAndHold().pause(500).release().build().perform();
		return PageFactory.initElements(driver, MultipleDelete.class);
	}

	public MultipleDelete hoverProduct(int xOffset, int yOffset) {
		Actions action = new Actions(driver);
		action.moveToElement(container3D, xOffset, yOffset).pause(500).build().perform();
		return PageFactory.initElements(driver, MultipleDelete.class);
	}

	public MultipleDelete multipleSelect(String productOffsets) {
		String pixels = UtilHBM.getKeyValue(Setting.wallParametersPath).get(productOffsets).split("/")[0];
		new Actions(driver).keyDown(Keys.CONTROL).perform();
		for (String a : pixels.split(">")) {
			System.out.println("a: " + Integer.parseInt(a.split(",")[0]));
			System.out.println("b: " + Integer.parseInt(a.split(",")[1]));
			hoverProduct(Integer.parseInt(a.split(",")[0]), Integer.parseInt(a.split(",")[1]));
			clickProduct(Integer.parseInt(a.split(",")[0]), Integer.parseInt(a.split(",")[1]));	
			UtilHBM.waitFixTime(500);
		}
		new Actions(driver).keyUp(Keys.CONTROL).perform();
		return PageFactory.initElements(driver, MultipleDelete.class);
	}

	public MultipleDelete multipleSelect(String[] productOffsets) {
		new Actions(driver).keyDown(Keys.CONTROL).perform();
		for (String a : productOffsets) {
			System.out.println("a: " + Integer.parseInt(a.split(",")[0].trim()));
			System.out.println("b: " + Integer.parseInt(a.split(",")[1].trim()));
			hoverProduct(Integer.parseInt(a.split(",")[0].trim()), Integer.parseInt(a.split(",")[1].trim()));
			clickProduct(Integer.parseInt(a.split(",")[0].trim()), Integer.parseInt(a.split(",")[1].trim()));
			UtilHBM.waitFixTime(500);
		}
		new Actions(driver).keyUp(Keys.CONTROL).perform();
		UtilHBM.waitFixTime(1000);
		return PageFactory.initElements(driver, MultipleDelete.class);
	}

}
