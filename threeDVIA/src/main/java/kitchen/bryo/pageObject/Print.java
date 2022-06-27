package kitchen.bryo.pageObject;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class Print {

	WebDriver driver;

	public Print(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = ".mod-layer-print.mod-open")
	private WebElement printOverlay;

	@FindBy(xpath = "//div[@class='list']/figure/ul/li")
	private List<WebElement> listOfPlanImages;

	@FindBy(xpath = "//article[@class='mod-layer-print mod-open']/div/main/div/div/div/div/div[@class='list']/figure/ul[@id='print-medias-list']/li[@data-item-type='3d']")
	private List<WebElement> threeDPlansList;

	@FindBy(xpath = "//article[@class='mod-layer-print mod-open']/div/main/div/div/div/div/div[@class='list']/figure/ul[@id='print-plans-list']/li[@data-item-type='plan']")
	private List<WebElement> plansList;

	@FindBy(xpath = "//article[@class='mod-layer-print mod-open']/div/main/div/div/div/div/div[@class='list']/figure/ul[@id='print-medias-list']/li[@data-item-type='realistic']")
	private List<WebElement> realisticPlansList;

	@FindBy(xpath = "//article[@class='mod-layer-print mod-open']/div/main/div/div/div/div/div[@class='list']/figure/ul[@id='print-medias-list']/li[@data-item-type='3d']/div[@class='item on']")
	private List<WebElement> selectedthreeDPlansList;

	@FindBy(xpath = "//article[@class='mod-layer-print mod-open']/div/main/div/div/div/div/div[@class='list']/figure/ul[@id='print-plans-list']/li[@data-item-type='plan']/div[@class='item on']")
	private List<WebElement> selectedplansList;

	@FindBy(xpath = "//article[@class='mod-layer-print mod-open']/div/main/div/div/div/div/div[@class='list']/figure/ul[@id='print-medias-list']/li[@data-item-type='realistic']/div[@class='item on']")
	private List<WebElement> selectedrealisticPlansList;

	@FindBy(css = "article[class='mod-layer-print mod-open']>div>main>footer>div[class='footer-actions']>div>label[for='select-all']")
	private WebElement selectAll;

	@FindBy(css = "span[data-ui-selector='selected-medias']")
	private WebElement all3Ds;

	@FindBy(css = "span[data-ui-selector='selected-plans']")
	private WebElement allPlans;

	@FindBy(css = "span[data-ui-selector='checked-img-number']")
	private WebElement printsSelected;

	@FindBy(css = "button[data-ui-action='print-images']")
	private WebElement printButton;

	@FindBy(css = "span[data-ui-selector='display-measures-text']")
	private WebElement measurementText;

	@FindBy(css = "span[data-ui-selector='display-measures-text']>span>label[for='display-measures']")
	private WebElement measurementToggle;

	@FindBy(xpath = "//article[@class='mod-layer-print mod-open']/div/main/header/div/button[@data-ui-action='layer-close']")
	private WebElement closePrint;

	@FindBy(xpath = "//figure[@class='figure-plans']")
	private List<WebElement> figurePlans;

//	public Print checkPrintPage(int renderCount, int planCount) {
//		driver.switchTo().parentFrame();
//		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
//		UtilHBM.waitExplicitDisplayed(driver,
//				driver.findElement(By.xpath("//main/div/div/div/div[@class='print-selection']")));
//		UtilHBM.waitExplicitDisplayed(driver, selectAll);
//		UtilHBM.waitExplicitClickable(driver, selectAll);
//		UtilHBM.waitTillElementDisappear(driver, ".mod-loader");
//		verifyMediasDisplayed(renderCount, planCount);
//		if (selectAll.isEnabled()) {
//			System.out.println("Select text : " + selectAll.getText());
//			WebElement selectInput = selectAll
//					.findElement(By.xpath("input[@id='select-all']/following-sibling::span[@class='state']"));
//			new Actions(driver).moveToElement(selectInput).build().perform();
//			selectInput.click();
//			if (selectAll.findElement(By.xpath("input[@id='select-all']")).getAttribute("checked")
//					.equalsIgnoreCase("true")) {
//				System.out.println("Total plans images displayed are " + listOfPlanImages.size());
//				if (listOfPlanImages.size() != 0) {
//
//					int noOf3DPlans = Integer.parseInt(all3Ds.getText());
//
//					int totalMedia = threeDPlansList.size() + realisticPlansList.size();
//					if (totalMedia == noOf3DPlans) {
//						UtilHBM.reportOK("Count displayed for selected Medias is" + noOf3DPlans);
//						UtilHBM.reportOK("Number of Medias selected from list are " + "3D media : "
//								+ threeDPlansList.size() + " + " + " rendering media: " + realisticPlansList.size());
//
//					} else
//						UtilHBM.reportKO(
//								"Count displayed for selected 3D plans  are not same as No of 3D plans selected from list");
//
//					int noOfPlans = Integer.parseInt(allPlans.getText());
//					if (plansList.size() == noOfPlans) {
//						UtilHBM.reportOK("Count displayed for plans " + noOfPlans);
//						UtilHBM.reportOK("Number of plans selected from list are " + plansList.size());
//
//					} else
//						UtilHBM.reportKO(
//								"Count displayed for selected  plans  are not same as No of  plans selected from list");
//				} else
//					UtilHBM.reportKO("Select all input not clicked");
//
//			}
//			if (figurePlans.size() > 0) {
//				Verification.displayOfWebElement(measurementText);
//				Verification.VerifyEquals("Measurement text incorrect", "Measurements", measurementText.getText());
//				Verification.displayOfWebElement(measurementToggle);
//				Verification.displayOfWebElement(printButton);
//			}
//		} else {
//			UtilHBM.reportKO("Plans are still not loaded");
//		}
//
//		
//		return PageFactory.initElements(driver, Print.class);
//	}

	public Print printSelection(int renderCount, int planCount) {
		if (selectAll.isEnabled()) {
			System.out.println("Select text : " + selectAll.getText());
			WebElement selectInput = selectAll
					.findElement(By.xpath("input[@id='select-all']/following-sibling::span[@class='state']"));
			new Actions(driver).moveToElement(selectInput).build().perform();
			selectInput.click();
			if (selectAll.findElement(By.xpath("input[@id='select-all']")).getAttribute("checked")
					.equalsIgnoreCase("true")) {

				int noOf3DPlans = Integer.parseInt(all3Ds.getText());
				if (noOf3DPlans == renderCount + 1) {
					UtilHBM.reportOK("Number of medias selected and selected count displayed are same and count is :"+noOf3DPlans);
				}
				int noOfPlans = Integer.parseInt(allPlans.getText());
				if (noOfPlans == planCount) {
					UtilHBM.reportOK("Number of plans selected and selected count displayed are same and count is :"+noOfPlans);
				}
				int totalMediaCount = noOf3DPlans + noOfPlans;
				WebElement printCount = driver
						.findElement(By.xpath("//button[@data-ui-action='print-images']/span/span"));
				int noOfPrint = Integer.parseInt(printCount.getText().substring(printCount.getText().indexOf("(") + 1,
						(printCount.getText().indexOf(")"))));

				if (totalMediaCount == noOfPrint) {
					UtilHBM.reportOK("Total number of images selected and print count displayed are same and count is :"+noOfPrint);
				}
			}
		}
	
		return PageFactory.initElements(driver, Print.class);
	}

	public Print verifyMediasDisplayed(int renderCount, int planCount) {
		UtilHBM.waitFixTime(500);
		driver.switchTo().parentFrame();
		
//		@SuppressWarnings("deprecation")
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(500, TimeUnit.SECONDS)
//				.pollingEvery(500, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);	
//		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
//			public Boolean apply(WebDriver driver) {
//				WebElement element =driver.findElement(By.cssSelector("article[class='mod-layer-print mod-open']>div>main>div>div>div>div[class='print-selection']"));
//				if (element.isDisplayed()) {
//						return true;
//				}
//				return false;
//			}
//		};
//
//		wait.until(function);
	
		for (int i = 0; i > driver.findElements(By.xpath("//article[@class='mod-layer-print mod-open']")).size(); i++) {
			if (!driver.findElement(By.cssSelector("article[class='mod-layer-print mod-open']>div>main>div>div>div>div[class='print-selection']")).isDisplayed()) {
				UtilHBM.waitFixTime(2000);
			} else {
				break;
			}
		}
//		UtilHBM.waitExplicitDisplayed(driver,driver.findElement(By.cssSelector("article[class='mod-layer-print mod-open']>div>main>div>div>div>div[class='print-selection']")));
		UtilHBM.waitExplicitDisplayed(driver, selectAll);
		UtilHBM.waitExplicitClickable(driver, selectAll);
		media().rendering(renderCount).plans(planCount).printSelection(renderCount, planCount).measurements(renderCount, planCount).closePrint();
		return PageFactory.initElements(driver, Print.class);
	}

	public Print media() {
		if (threeDPlansList.size() == 1) {
			int defaultMedia = threeDPlansList.size();
			UtilHBM.reportOK("Number of default 3d image available are: " + defaultMedia);
			Verification.displayOfWebElement(threeDPlansList.get(0).findElement(By.xpath("div/label/img[starts-with(@src,'data:image')]")));
		} else {
			UtilHBM.reportKO("Default media image not displayed");
		}
		return PageFactory.initElements(driver, Print.class);
	}

	public Print rendering(int renderCount) {
		if (renderCount == 0 && realisticPlansList.size() == 0) {
			UtilHBM.reportOK("No realistic images generated and count is : " + realisticPlansList.size());
		}
		else if (realisticPlansList.size() > 0) {
			int renderMedia = realisticPlansList.size();
			if (renderMedia == renderCount) {
				Verification.displayOfWebElement(realisticPlansList.get(0).findElement(By.xpath("div/label")));
				UtilHBM.reportOK(
						"Given rendering count and displayed rendering images are same and count is : " + renderMedia);
			}
		} else {
			UtilHBM.reportKO("Rendering images not displayed in print");
		}
		return PageFactory.initElements(driver, Print.class);
	}

	public Print plans(int planCount) {
		if (planCount == 0 && figurePlans.size() == 0) {
			UtilHBM.reportOK("No product available in room to generate plan and count is : " + figurePlans.size());
		} else if (plansList.size() > 0) {
			int planMedia = plansList.size();
			if (planMedia == planCount) {
				Verification.displayOfWebElement(plansList.get(0).findElement(By.xpath("div/label/img[starts-with(@src,'data:image')]")));
				Verification.displayOfWebElement(plansList.get(0).findElement(By.xpath("div/label/div/b")));
				Verification.displayOfWebElement(plansList.get(0).findElement(By.xpath("div/label/div/span")));
				UtilHBM.reportOK("Correct number of 2D plan image available and count is : " + planMedia);
				Verification.displayOfWebElement(measurementText);
				Verification.VerifyEquals("Measurement text incorrect", "Measurements", measurementText.getText());
				Verification.displayOfWebElement(measurementToggle);
			}
		} else {
			UtilHBM.reportKO("2D plan images not displayed in print");
		}

		return PageFactory.initElements(driver, Print.class);
	}
	public Print measurements(int renderCount, int planCount) {
		if(driver.findElements(By.cssSelector("span[data-ui-selector='display-measures-text']>span>label[for='display-measures']")).size()>0) {
		UtilHBM.waitExplicitDisplayed(driver, measurementToggle);
		UtilHBM.waitExplicitClickable(driver, measurementToggle);
		measurementToggle.click();
		UtilHBM.waitExplicitDisplayed(driver,driver.findElement(By.xpath("//article[@class='mod-layer-print mod-open']/div/main/div/div/div/div[@class='print-selection']")));
		media().rendering(renderCount).plans(planCount);
		}
		return PageFactory.initElements(driver, Print.class);
	}
	
	public Print closePrint() {
		UtilHBM.waitExplicitDisplayed(driver, closePrint);
		UtilHBM.waitExplicitClickable(driver, closePrint);
		closePrint.click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("#iframeContainer>iframe")));
		return PageFactory.initElements(driver, Print.class);
	}
}
