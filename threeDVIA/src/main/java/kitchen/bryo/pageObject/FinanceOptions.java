package kitchen.bryo.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;

public class FinanceOptions {
	WebDriver driver;

	public FinanceOptions(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = "article.mod-popin-finance-options-large div.content .inner-content")
	private WebElement financeOptionsMain;

	@FindBy(xpath = "//h1[@data-i18n='popin.finance_detail.title']")
	private WebElement financeDetailTitle;

	@FindBy(xpath = "//span[@data-i18n='popin.finance_detail.select_button_title']")
	private WebElement selectAmountTitle;

	@FindBy(xpath = "//span[@data-i18n='popin.finance_detail.select_button_description']")
	private WebElement selectAmountDesc;

	@FindBy(xpath = "//select[@name='select-finance-option']")
	private WebElement selectFinanceOption;

	@FindBy(xpath = "//span[@data-i18n='popin.finance_detail.loan_period'][contains(text(),'Loan period')]/../following-sibling::div")
	private WebElement loanPeriod;

	@FindBy(xpath = "//span[@data-i18n='popin.finance_detail.monthly_price'][contains(text(),'Monthly repayments')]/../following-sibling::div")
	private WebElement monthlyRepayment;

	@FindBy(xpath = "//span[@data-i18n='common.validate']")
	private WebElement validate;

	public MakeItHappen verifyFinanceOptions(String monthlyFinanceOption) {
		Verification.VerifyEquals("Finance Options title not displayed", financeDetailTitle.getText(),
				"Finance options for your kitchen");
		Verification.VerifyEquals("Select Amount title not displayed", selectAmountTitle.getText(),
				"Select a monthly amount");
		Verification.VerifyEquals("Select Amount desc not displayed", selectAmountDesc.getText(),
				"calculated according to loan period");
		UtilHBM.waitExplicitDisplayed(driver, financeOptionsMain);
		if (!(monthlyFinanceOption.isEmpty())) {
			Select oSelect = new Select(selectFinanceOption);
			oSelect.selectByVisibleText(monthlyFinanceOption);
		}

		String price = monthlyFinanceOption.substring(monthlyFinanceOption.indexOf("€ ") + 1,
				monthlyFinanceOption.indexOf("/"));
		String loan = monthlyFinanceOption.substring(monthlyFinanceOption.lastIndexOf("for ") + 4);
		System.out.println("a1:" + price);
		System.out.println("a2:" + loan);
		if (monthlyRepayment.getText().replaceAll("€", "").equalsIgnoreCase(price)) {
			UtilHBM.reportOK(
					"Match found for Expected monthly repayment and payment is  = " + monthlyRepayment.getText());
		} else {
			UtilHBM.reportKO(
					"Match not found for Expected monthly repayment and payment is  = " + monthlyRepayment.getText());
		}
		if (loanPeriod.getText().equalsIgnoreCase(loan)) {
			UtilHBM.reportOK("Match found for Expected loan period and period is  = " + loanPeriod.getText());
		} else {
			UtilHBM.reportKO("Match not found for Expected loan period and period is  = " + loanPeriod.getText());
		}
		validate();
		return PageFactory.initElements(driver, MakeItHappen.class);
	}

	public MakeItHappen validate() {
		validate.click();
		return PageFactory.initElements(driver, MakeItHappen.class);
	}

}
