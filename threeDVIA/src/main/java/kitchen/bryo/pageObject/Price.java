package kitchen.bryo.pageObject;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Price {
	WebDriver driver;
	public static String projectNameVerification;

	public Price(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//button[@data-ui-action='priceInfo']")
	private WebElement priceInfoIcon;

	@FindBy(css = ".mod-open>div>header>div>div>h3")
	private WebElement priceInfoHeader;

	@FindBy(css = ".mod-popin-price-info.mod-open>div>header>div>div>b")
	private WebElement priceInfoProjectName;

	@FindBy(xpath = "//article[@class='mod-popin-price-info mod-open']/div/div[@class='main']/div/div/p")
	private WebElement priceNoFurnitureInfo;
	
	@FindBy(css = ".mod-open>div>header>div>div>button[data-ui-action='popin-close']")
	private WebElement closePricePopUp;

	@FindBy(css = "article[class='mod-popin-price-info mod-open']>div>div>div>div>table>tbody>tr>td>span>span[data-ui='current-price']")
	private List<WebElement> subPriceCategoryList;

	@FindBy(css = "tbody>tr>th")
	private List<WebElement> subPriceCategoryListNames;

	@FindBy(css = "tfoot>tr>td>span>span[data-ui='current-price']")
	private WebElement priceTotal;

	@FindBy(css = ".mod-popin-alert-price.mod-open>div>div>div>.img-container")
	private List<WebElement> priceNotAvailableImgContainer;

	@FindBy(css = "span[data-ui='total-price-container']>span[class='standard-price ']")
	private List<WebElement> kitchenPrice;

	@FindBy(css = "button[data-ui-action='product-list']")
	private WebElement productListIcon;

	@FindBy(xpath = "//span[@class='price-monthly']")
	private WebElement monthlyPrice;
	
	public MakeItYours priceVerification(String price) {
		UtilHBM.waitFixTime(1000);
		if (kitchenPrice.size() != 0) {
			if (!kitchenPrice.get(0).isDisplayed()) {
				UtilHBM.reportKO("Kitchen Price not available");
			} else {
				UtilHBM.waitExplicitDisplayed(driver, kitchenPrice.get(0));
				UtilHBM.waitFixTime(1000);
				WebElement p = driver
						.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'" + price + "')]"));
				WebElement currency = driver
						.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'€')]"));
				Verification.displayOfWebElement(p);
				Verification.displayOfWebElement(currency);
			}

		} else {
			UtilHBM.reportInfo("Price not displayed");
		}
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public Price priceTextVerification() {
		UtilHBM.waitExplicitDisplayed(driver, priceInfoHeader);
		UtilHBM.turnOffImplicitWaits(driver);
		if (priceNotAvailableImgContainer.size() > 0) {
			Verification.VerifyEquals("Price Information Header is incorrect", priceInfoHeader.getText(),
					"Price information");
			UtilHBM.reportInfo(
					"Price not available for given template and text displayed is: " + priceInfoHeader.getText());
		} else {
			Verification.VerifyEquals("Price Information Header is incorrect", priceInfoHeader.getText(),
					"Price information");
			String a = priceInfoProjectName.getText();
			if (a.equalsIgnoreCase("My Kitchen") || priceInfoProjectName.getText().equalsIgnoreCase(a)) {
				Verification.VerifyEquals("Price Information project name is incorrect", priceInfoProjectName.getText(),
						a);
			}
		}
		return PageFactory.initElements(driver, Price.class);
	}
	
	public Price priceInfoInEditors() {

		driver.switchTo().parentFrame();
		priceTextVerification();
		int sum = 0;
		for (WebElement li : subPriceCategoryList) {
			System.out.println("li" +li.getText());
			System.out.println("li2" +li.getText().replaceAll("[^0-9]", ""));
			String s = li.getText().replaceAll("[^0-9]", "");
			sum = sum + Integer.parseInt(s);

		}
		for (WebElement li : subPriceCategoryListNames) {
			Verification.displayOfWebElement(li);
		}
		
		int s2 = Integer.parseInt(priceTotal.getText().replaceAll("[^0-9]", ""));
		System.out.println("s2 " + s2);
		if (s2 == sum) {
			UtilHBM.reportOK(
					"Total kitchen price displayed is " + "\"" + s2 + "\"" + "  and  calculated price is " + sum);
		} else {
			UtilHBM.reportKO(
					"Total kitchen price displayed is " + "\"" + s2 + "\"" + " and calculated price is " + sum);
		}

		UtilHBM.turnOnImplicitWaits(driver);

		closePricePopUp.click();
		List<WebElement> frames = driver.findElements(By.cssSelector("#iframeContainer>iframe"));
		driver.switchTo().frame(frames.get(0));

		return this;
	}

	public Price priceInfo(String price,String pricePerMonth, String loanDuration) {

		driver.switchTo().parentFrame();
		if(price.equalsIgnoreCase("0,00")) {
			Verification.VerifyEquals("Price Information Header is incorrect", priceInfoHeader.getText(),
					"Price information");
			Verification.VerifyEquals("Price Information project name is incorrect", priceInfoProjectName.getText(),
					"My kitchen project");
			Verification.VerifyEquals("Price No furniture info is incorrect", priceNoFurnitureInfo.getText(),
					"Add some furniture to your kitchen to get a detailed price.");
		}
		else {
		priceTextVerification();
		int sum = 0;
		for (WebElement li : subPriceCategoryList) {
			String s = li.getText().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("[^0-9]", "");
			System.out.println("s:"+s);
			sum = sum + Integer.parseInt(s);

		}
		for (WebElement li : subPriceCategoryListNames) {
			Verification.displayOfWebElement(li);
		}
	
		Verification.VerifyEquals("VAT included text not displayed",
				driver.findElement(By.xpath("//tfoot/tr/th/span[@class='price-taxes']")).getText(), "(VAT included)");
		Verification.VerifyEquals("Illustartion purpose text not displayed", driver.findElement(By.xpath("//tfoot/tr[2]/th")).getText(), "Products marked as \"Illustration purpose only\" are for visual use and not included in the project price.");
		Verification.VerifyEquals("Monthly price text not displayed", driver.findElement(By.xpath("//tfoot/tr[3]/th")).getText(), "* "+loanDuration+" loan period with a 6.9% APR. Applying for finance is subject to application, financial circumstances and borrowing history.");
		int s2 = Integer.parseInt(priceTotal.getText().replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("[^0-9]", ""));
		System.out.println("s2 " + s2);
		System.out.println("sum "+sum);
		int p=Integer.parseInt(price.replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("[^0-9]", ""));
		if (s2 == sum&&s2==p) {
			UtilHBM.reportOK(
					"Total kitchen price displayed is " + "\"" + s2 + "\"" + "  and  calculated price is " + sum);
		} else {
			UtilHBM.reportKO(
					"Total kitchen price displayed is " + "\"" + s2 + "\"" + " and calculated price is " + sum);
		}

		UtilHBM.turnOnImplicitWaits(driver);
		if (!pricePerMonth.isEmpty()) {
			if(monthlyPrice.getText().contains("or")&&monthlyPrice.getText().contains("per month*")&&monthlyPrice.getText().contains("€")) {
				String p1 = monthlyPrice.getText().trim()
						.replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", "");
				System.out.println("p1:" + p1);
				if (p1.equalsIgnoreCase(pricePerMonth)) {
					UtilHBM.reportOK("Step 2 : Expected price: " + pricePerMonth + " SAME as actual price: " + p1);
				} else {
					UtilHBM.reportKO("Step 2 : Expected price " + pricePerMonth + " NOT SAME as actual price: " + p1);
				}
			}
			
		}
		}
		closePricePopUp.click();
		List<WebElement> frames = driver.findElements(By.cssSelector("#iframeContainer>iframe"));
		driver.switchTo().frame(frames.get(0));

		return this;
	}
	public Price priceInfoInCompose() {

		driver.switchTo().parentFrame();
		priceTextVerification();
		int sum = 0;
		for (WebElement li : subPriceCategoryList) {
			String s = li.getText().replaceAll("[^0-9]", "");
			sum = sum + Integer.parseInt(s);

		}
		for (WebElement li : subPriceCategoryListNames) {
			Verification.displayOfWebElement(li);
		}
		Verification.VerifyEquals("VAT included text not displayed",
				driver.findElement(By.xpath("//tfoot/tr/th/span[@class='price-taxes']")).getText(), "(VAT included)");
		Verification.VerifyEquals("Illustartion purpose text not displayed", driver.findElement(By.xpath("//th[@class='footnote']")).getText(), "Products marked as \"Illustration purpose only\" are for visual use and not included in the project price.");
		Verification.VerifyEquals("Compose editor information for price not displayed", driver.findElement(By.xpath("//tfoot/tr/following-sibling::tr/following-sibling::tr")).getText(),
				"Items such as plinth, legs, worktop, etc are sold separately.");
		int s2 = Integer.parseInt(priceTotal.getText().replaceAll("[^0-9]", ""));
		System.out.println("s2 " + s2);
		if (s2 == sum) {
			UtilHBM.reportOK(
					"Total kitchen price displayed is " + "\"" + s2 + "\"" + "  and  calculated price is " + sum);
		} else {
			UtilHBM.reportKO(
					"Total kitchen price displayed is " + "\"" + s2 + "\"" + " and calculated price is " + sum);
		}

		UtilHBM.turnOnImplicitWaits(driver);

		closePricePopUp.click();
		List<WebElement> frames = driver.findElements(By.cssSelector("#iframeContainer>iframe"));
		driver.switchTo().frame(frames.get(0));

		return this;
	}
	public PickALayout verifyPriceInStep2(String price) {
//		if (!price.isEmpty()) {
//			UtilHBM.waitExplicitDisplayed(driver, priceInfoIcon);
//			WebElement p = driver
//					.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'" + price + "')]"));
//			WebElement currency = driver
//					.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'£')]"));
//			Verification.displayOfWebElement(p);
//			Verification.displayOfWebElement(currency);
//		}
//		*********************PRE-PROD****************************
		if (!price.isEmpty()) {
//			UtilHBM.waitExplicitClickable(driver, productListIcon);
//			WebElement p = driver
//					.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'" + price + "')]"));
			WebElement currency = driver
					.findElement(By.xpath("//span[@class='standard-price '][contains(text(),'\u20AC')]"));
//			Verification.displayOfWebElement(p);
			Verification.displayOfWebElement(currency);
			String p1 = driver.findElement(By.xpath("//span[@class='standard-price ']")).getText().trim()
					.replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", "");
			System.out.println("p1:" + p1);
			if (p1.equalsIgnoreCase(price)) {
				UtilHBM.reportOK("Step 2 : Expected price: " + price + " SAME as actual price: " + p1);
			} else {
				UtilHBM.reportKO("Step 2 : Expected price " + price + " NOT SAME as actual price: " + p1);
			}
		}
		return PageFactory.initElements(driver, PickALayout.class);
	}
	public PickALayout verifyPricePerMonthInStep2(String pricePerMonth) {

		if (!pricePerMonth.isEmpty()) {
//			String a="or €&nbsp;358,78 per month*";
//			String a1=a.replaceAll("&nbsp;", "");
//			a.substring(a.indexOf("or €&nbsp;")+1, a.indexOf(" per month*"));
//			System.out.println("a: "+a1);
//			System.out.println("a: "+a1.substring(a1.indexOf("or €")+4, a.indexOf(" per month*")));
////			WebElement currency = monthlyPrice.findElement(By.xpath("[contains(text(),'\u20AC')]"));
////			Verification.displayOfWebElement(p);
////			Verification.displayOfWebElement(currency);
			if(monthlyPrice.getText().contains("or")&&monthlyPrice.getText().contains("per month*")&&monthlyPrice.getText().contains("€")) {
				String p1 = monthlyPrice.getText().trim()
						.replaceAll("([ ]*+[^\\d\\,\\s]++[ ]*+)+", "").replaceAll("\\n", "");
				System.out.println("p1:" + p1);
				if (p1.equalsIgnoreCase(pricePerMonth)) {
					UtilHBM.reportOK("Step 2 : Expected price: " + pricePerMonth + " SAME as actual price: " + p1);
				} else {
					UtilHBM.reportKO("Step 2 : Expected price " + pricePerMonth + " NOT SAME as actual price: " + p1);
				}
			}
			
		}
		return PageFactory.initElements(driver, PickALayout.class);
	}
}
