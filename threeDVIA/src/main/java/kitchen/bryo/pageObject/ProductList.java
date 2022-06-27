package kitchen.bryo.pageObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import hbm.planner.utility.UtilHBM;
import hbm.planner.utility.Verification;
import org.openqa.selenium.support.PageFactory;

public class ProductList {
	WebDriver driver;

	public ProductList(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = ".totals>table>tbody>tr>td>span[data-ui='current-price']")
	private List<WebElement> productListPriceTotalsList;

	@FindBy(css = ".product>td[cols^='total']>span>span[data-ui='current-price']")
	private List<WebElement> productListTotalColsPrice;

	@FindBy(css = ".mod-layer-item-list.mod-open>div>main>header>div>button[data-ui-action='layer-close']")
	private WebElement closeProductList;

	@FindBy(xpath = "//article[@class='mod-layer-item-list mod-open']/div/aside/div/div/h2[@class='tt-2']")
	private WebElement productListHeader;

	@FindBy(css = ".mod-layer-item-list.mod-open>div>aside>div>div>p")
	private WebElement productListProjectName;

	@FindBy(xpath = "//table[@id='cabinets-table']/preceding-sibling::figcaption/parent::figure/table/tbody/tr")
	private List<WebElement> cabinetsTable;

	@FindBy(xpath = "//table[@id='linears-table']/preceding-sibling::figcaption/parent::figure/table/tbody/tr")
	private List<WebElement> linearsTable;

	@FindBy(xpath = "//table[@id='others-table']/preceding-sibling::figcaption/parent::figure/table/tbody/tr")
	private List<WebElement> othersTable;

	@FindBy(xpath = "//table/preceding-sibling::figcaption/parent::figure/table/thead/tr/th")
	private List<WebElement> tableHead;

	@FindBy(xpath = "//table/preceding-sibling::figcaption/parent::figure/table/tbody/tr")
	private List<WebElement> productListTable;

	@FindBy(xpath = "//table/preceding-sibling::figcaption/parent::figure")
	private List<WebElement> productListContent;

	@FindBy(xpath = "//tfoot/tr/td/span[@class='final-price']")
	private WebElement totalPrice;

	@FindBy(css = "tbody>tr>th")
	private List<WebElement> subPriceCategoryListNames;

	@FindBy(css = "article.mod-layer-item-list main div.content")
	private WebElement itemListMain;

	@FindBy(xpath = "//table[@id='cabinets-table']/tbody/tr[@class='product']/td[@cols='pic-1']/img[starts-with(@src, 'data:image/png;')]")
	private List<WebElement> cabinetTablePictures;

	@FindBy(css=".no-item-placeholder>p")
	private WebElement noItemPlaceHolder;
	
	public ProductList productListDetails(String filePath, String price) {
		try {

			driver.switchTo().parentFrame();
			UtilHBM.waitExplicitDisplayed(driver, productListHeader);
			Verification.VerifyEquals("Product list Header is incorrect", productListHeader.getText(), "Item List");
			Verification.VerifyEquals("Product List project name is incorrect", productListProjectName.getText(),
					"My Kitchen");
			List<WebElement> arrowList = driver.findElements(By.xpath("//td/button"));
			if (arrowList.size() > 0) {
				for (WebElement arr : arrowList) {
					arr.click();
					UtilHBM.waitFixTime(1500);
				}

			}
//			writeFile().verifyPriceTotal(price);
			compareProductList(filePath).verifyPriceTotal(price).closeProductList();

		} catch (

		Exception e) {
			// TODO: handle exception
		}

		return this;
	}

	public MakeItYours closeProductList() {
		UtilHBM.waitExplicitDisplayed(driver, closeProductList);
		UtilHBM.waitExplicitClickable(driver, closeProductList);
		closeProductList.sendKeys(Keys.ENTER);
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='iframeContainer']/iframe")));
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	public ProductList createFile() {
		try {
			File file = new File("..\\threeDVIA\\src\\test\\resources\\BOM.txt");
			boolean fvar = file.createNewFile();
			if (fvar) {
				System.out.println("File has been created successfully");
			} else {
				System.out.println("File already present at the specified location");
			}
		} catch (IOException e) {
			System.out.println("Exception Occurred:");
			e.printStackTrace();
		}
		return this;
	}

	public ProductList writeFile() {

		try {
			FileWriter fr = new FileWriter("..\\threeDVIA\\src\\test\\resources\\15-I-shaped-kitchen-BOM.txt");
			BufferedWriter br = new BufferedWriter(fr);

			for (WebElement figure : productListContent) {
				WebElement figcaption = figure.findElement(By.xpath("figcaption"));

				System.out.println("figcaption " + figcaption.getText().replaceAll("\n", ""));
				System.out.println("\n");

				br.write(figcaption.getText().replaceAll("\n", " "));
				br.newLine();

				WebElement titleHead = figure.findElement(By.xpath("table/thead"));

				System.out.println("titleHead " + titleHead.getText().replaceAll("\n", ""));
				System.out.println("\n");

				br.write(titleHead.getText().replaceAll("\n", " "));
				br.newLine();

				List<WebElement> tableData = figure.findElements(By.xpath("table/tbody/tr"));
				for (WebElement tr : tableData) {

					System.out.println("tableData " + tr.getText().replaceAll("\n", ""));
					System.out.println("\n");

					br.write(tr.getText().replaceAll("\n", " "));
					br.newLine();
				}

			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return this;
	}

	public ProductList compareProductList(String filePath) {
		try {
			BufferedReader reader = new BufferedReader(
					new FileReader("..\\threeDVIA\\src\\test\\resources\\" + filePath));
			boolean areEqual = true;
			String line1 = null;

			String line2 = null;
			int lineNum = 0;

			for (WebElement figure : productListContent) {

				line1 = reader.readLine();
				System.out.println("line1 " + line1);

				WebElement figcaption = figure.findElement(By.xpath("figcaption"));
				line2 = figcaption.getText().replaceAll("[\\n\\r\\s]+", "");
//				System.out.println("line2 " + figcaption.getText());
				System.out.println("line2 " + figcaption.getText().replaceAll("[\\S+\\n\\r\\s]+", ""));
				System.out.println("\n");

				line1 = reader.readLine();
				System.out.println("line1 " + line1);
				WebElement titleHead = figure.findElement(By.xpath("table/thead"));

				line2 = titleHead.getText().replaceAll("\n", " ");
				System.out.println("line2 " + titleHead.getText().replaceAll("\n", ""));
				System.out.println("\n");

				List<WebElement> tableData = figure.findElements(By.xpath("table/tbody/tr"));
				for (WebElement tr : tableData) {
					line1 = reader.readLine();
					System.out.println("line1 " + line1);
					line2 = tr.getText().replaceAll("\n", " ");
					System.out.println("line2 " + tr.getText().replaceAll("\n", ""));
					System.out.println("\n");

				}
				while (line1 != null || line2 != null) {
					if (line1 == null || line2 == null) {
						areEqual = false;
						break;
					} else if (!line1.equalsIgnoreCase(line2)) {
						areEqual = false;
						break;
					}
					lineNum++;
					break;
				}

			}

			if (areEqual) {
				UtilHBM.reportOK("Two files have same content.");
			} else {
				UtilHBM.reportKO("Two files have different content. They differ at line " + lineNum);
				UtilHBM.reportKO("Expected Text file content : " + line1 + " and available getText content : " + line2
						+ " at line " + lineNum);
			}
			reader.close();

		} catch (Exception e) {
			UtilHBM.reportKO(e.toString());
			UtilHBM.reportKO("Product list comparision failed.");
		}
		return this;
	}

	public ProductList verifyPriceTotal(String price) {
		if (!price.isEmpty()) {
			int sum = 0;
			int sum1 = 0;
			for (WebElement li : productListPriceTotalsList) {
				System.out.println("product list size " + productListPriceTotalsList.size());
				System.out.println(li.getText());

				String s = li.getText().replaceAll("[^0-9.]", "");
				sum = sum + Integer.parseInt(s);
				System.out.println("Product list Sum in for loop" + sum);
			}
			for (WebElement li : subPriceCategoryListNames) {
				System.out.println(li.getText());
				Verification.displayOfWebElement(li);
			}
			Verification.VerifyEquals("VAT included text not displayed",
					driver.findElement(By.cssSelector("tfoot>tr>th>span[class='price-taxes']")).getText(),
					"(VAT included)");
			System.out.println("Product list Sum" + sum);
			int p = Integer.parseInt(price.replaceAll("[^0-9.]", ""));
			if (p == sum) {
				UtilHBM.reportOK(
						"Total kitchen price displayed in product list is " + p + " and  calculated price is " + sum);
			} else {
				UtilHBM.reportKO(
						"Total kitchen price displayed in product list is " + p + " and  calculated price is " + sum);
			}
		}
		return this;
	}

//	public ProductList productListDetails() {
//		new Actions(driver).moveToElement(productListIcon).click().build().perform();
//		driver.switchTo().parentFrame();
//		UtilHBM.waitExplicitDisplayed(driver, productListHeader);
//		Verification.VerifyEquals("Product list Header is incorrect", productListHeader.getText(), "Item List");
//		Verification.VerifyEquals("Product List project name is incorrect", productListProjectName.getText(),
//				"My Kitchen");
//
//		UtilHBM.reportInfo("Number of tables available in item list are " + figure.size());
//		List<WebElement> arrowList = driver.findElements(By.xpath("//td/button"));
//		UtilHBM.reportInfo("Arrow list available  are " + arrowList.size());
//		if (arrowList.size() > 0) {
//			for (WebElement arr : arrowList) {
//				arr.click();
//				UtilHBM.waitFixTime(1500);
//			}
//		}
//		for (WebElement a : figure) {
//			String tableName = a.getText().split("\\r?\\n")[0];
//			UtilHBM.reportInfo("Tables available in item list are " + "\"" + tableName + "\"");
//			if (!(a.findElement(By.tagName("figcaption")).getText().equalsIgnoreCase(""))
//					&& !(a.findElement(By.tagName("figcaption")).getText().isEmpty())) {
//				UtilHBM.reportOK("Table name displayed and name is " + "\"" + tableName + "\"");
//			} else {
//				UtilHBM.reportKO("Table name not displayed and name is " + "\"" + tableName + "\"");
//			}
//			UtilHBM.waitFixTime(1000);
//
//			UtilHBM.turnOffImplicitWaits(driver);
//			List<WebElement> ee = a.findElements(By.xpath("table/tbody/tr"));
//			UtilHBM.reportInfo("Number of tr available in item list for " + "\"" + tableName + "\"" + " table are "
//					+ "\"" + ee.size() + "\"");
//			// ************Image Test*****************************
//			for (WebElement tab : ee) {
//				if (tab.findElement(By.xpath("td[1]/img")).isDisplayed()) {
//					if (tab.findElement(By.xpath("td[1]/img")).getAttribute("src").contains("https:")
//							&& (tab.findElement(By.xpath("td[1]/img")).getAttribute("src").contains(".jpg"))
//							|| tab.findElement(By.xpath("td[1]/img")).getAttribute("src").contains(".png")) {
//						UtilHBM.reportOK("Product image displayed for " + "\"" + tableName + "\"" + " table in cols "
//								+ "\"" + tab.findElement(By.tagName("td")).getAttribute("cols") + "\"");
//					} else {
//						UtilHBM.reportKO(
//								"Product image not displayed for " + "\"" + tableName + "\"" + " table in cols " + "\""
//										+ tab.findElement(By.tagName("td")).getAttribute("cols") + "\"");
//					}
//
//				}
//				// ************Reference Test*****************************
//				if (!(tab.findElement(By.xpath("td[2]")).getText().equalsIgnoreCase(""))
//						&& !(tab.findElement(By.xpath("td[2]")).getText().isEmpty())) {
//
//					UtilHBM.reportOK("Product reference displayed for " + "\"" + tableName + "\""
//							+ " table and reference name is " + "\"" + tab.findElement(By.xpath("td[2]")).getText()
//							+ "\"");
//				} else {
//					UtilHBM.reportKO("Product reference not displayed for " + "\"" + tableName + "\""
//							+ " table and reference name is " + "\"" + tab.findElement(By.tagName("td")).getText()
//							+ "\"");
//				}
//				// ************Product Name Test*****************************
//				if (!(tab.findElement(By.xpath("td[3]/b")).getText().equalsIgnoreCase(""))
//						&& !(tab.findElement(By.xpath("td[3]/b")).getText().isEmpty())
//						&& !(tab.findElement(By.xpath("td[3]/span")).getText().equalsIgnoreCase(""))
//						&& !(tab.findElement(By.xpath("td[3]/span")).getText().isEmpty())) {
//
//					UtilHBM.reportOK("Product name displayed in " + "\"" + tableName + "\""
//							+ " table and product name is " + "\"" + tab.findElement(By.xpath("td[3]/b")).getText()
//							+ "\"" + " with desc : " + "\"" + tab.findElement(By.xpath("td[3]/span")).getText() + "\"");
//				} else {
//					UtilHBM.reportKO("Product name not displayed in " + "\"" + tableName + "\""
//							+ " table and product name is " + "\"" + tab.findElement(By.xpath("td[3]/b")).getText()
//							+ "\"" + " with desc : " + "\"" + tab.findElement(By.xpath("td[3]/span")).getText() + "\"");
//				}
//
//				// ************Price Test*****************************
//				List<WebElement> regularPrice = tab.findElements(By.xpath("td[4]/span/span[@class='regular-price ']"));
//
//				if (regularPrice.size() > 0) {
//
//					if (!(tab.findElement(By.xpath("td[4]/span/span[@class='regular-price ']")).getText()
//							.equalsIgnoreCase("")
//							&& !(tab.findElement(By.xpath("td[4]/span/span[@class='regular-price ']")).getText()
//									.isEmpty()))) {
//						UtilHBM.reportOK("Product price displayed for " + "\""
//								+ tab.findElement(By.xpath("td[2]")).getText() + "\"" + "  and price is : " + "\""
//								+ tab.findElement(By.xpath("td[4]/span/span[@class='regular-price ']")).getText()
//								+ "\"");
//						List<WebElement> reducedPrice = a
//								.findElements(By.xpath("td[4]/span/span[@class='reduced-price ']"));
//						List<WebElement> standardPrice = a
//								.findElements(By.xpath("td[4]/span/span[@class='standard-price']"));
//						List<WebElement> membershipPrice = a
//								.findElements(By.xpath("td[4]/span/span[@class='membership-price']"));
//						if (standardPrice.size() > 0) {
//							for (WebElement standard : standardPrice) {
//								if (!(standard.getText().equalsIgnoreCase("") && !(standard.getText().isEmpty()))) {
//									UtilHBM.reportOK("Standard price displayed for " + "\""
//											+ tab.findElement(By.xpath("td[2]")).getText() + "\""
//											+ "  and standard price is : " + "\"" + standard.getText() + "\"");
//
//								}
//							}
//						}
//						if (reducedPrice.size() > 0) {
//							for (WebElement reduced : reducedPrice) {
//								if (!(reduced.getText().equalsIgnoreCase("") && !(reduced.getText().isEmpty()))) {
//									UtilHBM.reportOK("Reduced price displayed for " + "\""
//											+ tab.findElement(By.xpath("td[2]")).getText() + "\""
//											+ "  and reduced price is : " + "\"" + reduced.getText() + "\"");
//
//								}
//							}
//						}
//						if (membershipPrice.size() > 0) {
//							for (WebElement member : membershipPrice) {
//								if (!(member.getText().equalsIgnoreCase("") && !(member.getText().isEmpty()))) {
//									UtilHBM.reportOK("Membership price displayed for " + "\""
//											+ tab.findElement(By.xpath("td[2]")).getText() + "\""
//											+ "  and membership price is : " + "\"" + member.getText() + "\"");
//
//								}
//							}
//						}
//					}
//				} else {
//					UtilHBM.reportInfo("Product price not displayed for " + "\""
//							+ tab.findElement(By.xpath("td[2]")).getText() + "\"" + "  and price is : " + "\""
//							+ tab.findElement(By.xpath("td[4]")).getText() + "\"");
//				}
//
//				// ********************QUANTITY*********************
//				if (!(tab.findElement(By.xpath("td[5]")).getText().equalsIgnoreCase(""))
//						&& !(tab.findElement(By.xpath("td[5]")).getText().isEmpty())) {
//
//					UtilHBM.reportOK("Quantity displayed for " + "\"" + tab.findElement(By.xpath("td[2]")).getText()
//							+ "\"" + "  and Quantity  is " + "\"" + tab.findElement(By.xpath("td[5]")).getText()
//							+ "\"");
//				} else {
//					UtilHBM.reportInfo("Quantity not displayed for " + "\""
//							+ tab.findElement(By.xpath("td[2]")).getText() + "\"" + "  and Quantity  is " + "\""
//							+ tab.findElement(By.xpath("td[5]")).getText() + "\"");
//				}
//
//				// ******************TOTAL*************************
//
//				List<WebElement> totalRegularPrice = tab
//						.findElements(By.xpath("td[4]/span/span[@class='regular-price ']"));
//
//				if (totalRegularPrice.size() > 0) {
//
//					if (!(tab.findElement(By.xpath("td[4]/span/span[@class='regular-price ']")).getText()
//							.equalsIgnoreCase("")
//							&& !(tab.findElement(By.xpath("td[4]/span/span[@class='regular-price ']")).getText()
//									.isEmpty()))) {
//						UtilHBM.reportOK("Total price displayed for " + "\""
//								+ tab.findElement(By.xpath("td[2]")).getText() + "\"" + "  and total price is : " + "\""
//								+ tab.findElement(By.xpath("td[4]/span/span[@class='regular-price ']")).getText()
//								+ "\"");
//						List<WebElement> totalReducedPrice = a
//								.findElements(By.xpath("td[4]/span/span[@class='reduced-price ']"));
//						List<WebElement> totalStandardPrice = a
//								.findElements(By.xpath("td[4]/span/span[@class='standard-price']"));
//						List<WebElement> totalMembershipPrice = a
//								.findElements(By.xpath("td[4]/span/span[@class='membership-price']"));
//						if (totalStandardPrice.size() > 0) {
//							for (WebElement totalStandard : totalStandardPrice) {
//								if (!(totalStandard.getText().equalsIgnoreCase("")
//										&& !(totalStandard.getText().isEmpty()))) {
//									UtilHBM.reportOK("Total Standard price displayed for " + "\""
//											+ tab.findElement(By.xpath("td[2]")).getText() + "\""
//											+ "  and total standard price is : " + "\"" + totalStandard.getText()
//											+ "\"");
//
//								}
//							}
//						}
//						if (totalReducedPrice.size() > 0) {
//							for (WebElement totalReduced : totalReducedPrice) {
//								if (!(totalReduced.getText().equalsIgnoreCase("")
//										&& !(totalReduced.getText().isEmpty()))) {
//									UtilHBM.reportOK("Total Reduced price displayed for " + "\""
//											+ tab.findElement(By.xpath("td[2]")).getText() + "\""
//											+ "  and total reduced price is : " + "\"" + totalReduced.getText() + "\"");
//
//								}
//							}
//						}
//						if (totalMembershipPrice.size() > 0) {
//							for (WebElement totalMember : totalMembershipPrice) {
//								if (!(totalMember.getText().equalsIgnoreCase("")
//										&& !(totalMember.getText().isEmpty()))) {
//									UtilHBM.reportOK("Total Membership price displayed for " + "\""
//											+ tab.findElement(By.xpath("td[2]")).getText() + "\""
//											+ "  and total membership price is : " + "\"" + totalMember.getText()
//											+ "\"");
//
//								}
//							}
//						}
//					}
//				} else {
//					UtilHBM.reportInfo("Product total price not displayed for " + "\""
//							+ tab.findElement(By.xpath("td[2]")).getText() + "\"" + "  and total price is : " + "\""
//							+ tab.findElement(By.xpath("td[4]")).getText() + "\"");
//				}
//
//			}
//
//		}
//
//		int sum = 0;
////		int sum1 = 0;
//		for (WebElement li : productListPriceTotalsList) {
//			System.out.println("product list size " + productListPriceTotalsList.size());
//			System.out.println(li.getText());
//			String s = li.getText().replaceAll("[^0-9.]", "");
//			sum = sum + Integer.parseInt(s);
//			System.out.println("Product list Sum in for loop" + sum);
//		}
//		System.out.println("Product list Sum" + sum);
//		UtilHBM.reportMsg("Total price calculated for product list is : " + sum);
////		for (WebElement li : productListTotalColsPrice) {
////			System.out.println(li.getText());
////			String s1 = li.getText().replaceAll("[^0-9.]", "");
////			System.out.println("Product list string s1 in for loop" + s1);
////			if (s1 == null || s1.trim().isEmpty()) {
////				System.out.println("Incorrect format of string");
////				System.out.println("s1" + s1);
////			} else {
////				System.out.println("s1" + s1);
////				sum1 = sum1 + Integer.parseInt(s1);
////			}
////		}
//		int s2=Integer.parseInt(totalPrice.getText().replaceAll("[^0-9.]", ""));
//		if (s2 == sum) {
//			UtilHBM.reportOK("Total kitchen price displayed in product list is "+s2+" and  calculated price is " + sum);
//		} else {
//			UtilHBM.reportKO("Total kitchen price displayed in product list is "+s2+" and  calculated price is " + sum);
//		}
//		UtilHBM.turnOnImplicitWaits(driver);
//		closeProductList.click();
//		UtilHBM.waitTillElementDisappear(driver, ".mod-layer-item-list");
//		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
//		driver.switchTo().frame(frames.get(0));
//		return PageFactory.initElements(driver, ProductList.class);
//	}

	/**
	 *
	 * @param searchType = "startswith", "contains" or "exactmatch" (defaults to
	 *                   exactmatch)
	 * @param itemName   = item name (or partial name ) to be searched
	 * @param section    = which section to search under
	 */
	public MakeItYours verifyIfItemPriced(String searchType, String section, String itemName, boolean isPriced) {
		driver.switchTo().parentFrame();
		UtilHBM.waitExplicitDisplayed(driver, itemListMain);
		WebElement table = itemListMain
				.findElement(By.xpath(".//figcaption[text()='" + section + "']/following-sibling::table"));
		List<String> tableHeaders = getTableHeaders(table.findElements(By.cssSelector("thead th")));
		List<WebElement> tableRows = table.findElements(By.cssSelector("tbody tr"));

		boolean itemFound = false;
		outerFor: for (WebElement tableRow : tableRows) {
			switch (searchType.toLowerCase()) {
			case "startswith":
				if (tableRow.findElement(By.cssSelector("td:nth-of-Type(" + (tableHeaders.indexOf("Name") + 1) + ")"))
						.getText().startsWith(itemName)) {
					itemFound = true;
					break outerFor;
				}
				break;
			case "contains":
				if (tableRow.findElement(By.cssSelector("td:nth-of-Type(" + (tableHeaders.indexOf("Name") + 1) + ")"))
						.getText().contains(itemName)) {
					itemFound = true;
					break outerFor;
				}
				break;
			case "exactmatch":
			default:
				if (tableRow.findElement(By.cssSelector("td:nth-of-Type(" + (tableHeaders.indexOf("Name") + 1) + ")"))
						.getText().equals(itemName)) {
					itemFound = true;
					break outerFor;
				}
			}
		}
		if (itemFound != isPriced) {
			UtilHBM.reportKO("Item '" + itemName + "' " + (isPriced ? "not found" : "found")
					+ " in ItemList under section " + section + ", when searched using searchType = " + searchType);
		} else {
			UtilHBM.reportOK("Item '" + itemName + "' " + (isPriced ? "found" : "not found")
					+ " in ItemList under section " + section + ", when searched using searchType = " + searchType);
		}

		closeProductList();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	private List<String> getTableHeaders(List<WebElement> tableHeaderElems) {
		List<String> tableHeaders = new ArrayList<>();
		if (tableHeaderElems.size() == 0) {
			UtilHBM.reportKO("No header Elements present");
		} else {
			for (WebElement hdrElem : tableHeaderElems) {
				if (hdrElem.getAttribute("id").startsWith("pic"))
					tableHeaders.add("Picture");
				else
					tableHeaders.add(hdrElem.getText());
			}
		}
		return tableHeaders;
	}


	/**
	 * Method for verifying data in the Item List / Product list
	 * @param section : Under which section the expected nfo is present ex. "Worktops and wall panels"
	 *
	 * @param expectedProductInfo : Product info to ve verified , format/ex. : "Reference:DKACRYLIC_1 > Price:50\n100 > Quantity:1"
	 *                            For picture format verification, use : Picture:picureType/altOfPicture where pictureType can be 'crosscut', 'Thumbnail' or 'placeholder
	 *                            ex 'Picture:thumbnail/ACRYLIC WHITE'  or 'Picture:crosscut/W2001'
	 *
	 * @param expRowCount : At least, how many rows with the above data is expected. If user doesnt want to verify count, empty
	 *                       string ("") can be passed. For ex, if user passes "2", verification will pass if there are 2 or more rows with the above data
	 *
	 * @return Pageobject of MakeItYours class
	 */
	public MakeItYours verifyProductInfoInItemList(String section, String expectedProductInfo, String expRowCount) {
		int rowsFound = 0;
		Map<String, String> expectedInfo = new HashMap<>();
		for (String info : expectedProductInfo.split("\\s*>\\s*")) {
			expectedInfo.put(info.split(":")[0].trim(), info.split(":")[1].trim());
		}

		driver.switchTo().parentFrame();
		UtilHBM.waitExplicitDisplayed(driver, itemListMain);
		WebElement table = itemListMain
				.findElement(By.xpath(".//figcaption[text()='" + section + "']/following-sibling::table"));
		if(section.equalsIgnoreCase("Cabinets")) {
			verifyCrossCutImages();
		}
		List<String> tableHeaders = getTableHeaders(table.findElements(By.cssSelector("thead th")));
		List<WebElement> tableRows = table.findElements(By.cssSelector("tbody tr"));

		boolean matchFound = false;
		nextrow:
		for (WebElement tableRow : tableRows) {
			for (String hdr : expectedInfo.keySet()) {
				String val = expectedInfo.get(hdr);
				expandTableRow(tableRow);
				switch (hdr) {
					case "Picture":
						if (!imageMatched(tableRow.findElement(By.cssSelector("td:nth-of-Type(" + (tableHeaders.indexOf(hdr) + 1) + ")")), val))
							continue nextrow;
						break;
					default:
						if (!tableRow.findElement(By.cssSelector("td:nth-of-Type(" + (tableHeaders.indexOf(hdr) + 1) + ")")).getText().equals(val)) {
							continue nextrow;
						}
				}

			}
			rowsFound++;
			if(expRowCount.isEmpty() || Integer.toString(rowsFound).equals(expRowCount))break;
		}

		matchFound = expRowCount.isEmpty() ? (rowsFound == 1) : (Integer.toString(rowsFound).equals(expRowCount));
		if (matchFound) {
			UtilHBM.reportOK("Match found for Expected info in item list, no. of rows found  = " + rowsFound);
		} else {
			UtilHBM.reportKO("Match not found for Expected info [" + expectedProductInfo.replace("\\", "\\\\")
					+ "] in item list, \nExpected no. of rows = " + (expRowCount.isEmpty() ? "1" : expRowCount)
					+ " , no. of rows found = " + rowsFound);
		}

		closeProductList();
		return PageFactory.initElements(driver, MakeItYours.class);
	}

	private void expandTableRow(WebElement tableRow) {
		UtilHBM.turnOffImplicitWaits(driver);
		try {
			WebElement expandIcon = tableRow.findElement(By.cssSelector("td>button.bt-icon"));
			if (expandIcon.getAttribute("aria-expanded").equals("false"))
				expandIcon.click();
		} catch (NoSuchElementException e) {
		}
		UtilHBM.turnOnImplicitWaits(driver);
	}

	//FUN123168 :As a user, I can see cross cut images directly in the Bryo item list
	public ProductList verifyCrossCutImages() {
			for (WebElement a : cabinetTablePictures) {
				String img = a.getAttribute("src");
				UtilHBM.waitExplicitDisplayed(driver, a);
				Verification.displayOfWebElement(a);
				if (img.startsWith("data:image/png;") && (!img.contains("https://")) && (!img.endsWith(".png"))
						|| (!img.endsWith(".jpg"))) {
					UtilHBM.reportOK("Cross-cut images correctly displayed and src is: "+img);
				} else {
					UtilHBM.reportKO("Incorrect Cross-cut images displayed and src is: "+img);
				}
			}
		return PageFactory.initElements(driver, ProductList.class);
	}

	private boolean imageMatched(WebElement element, String expectedPictureType) {
		String expectedImageType = expectedPictureType.split("/")[0].trim().toLowerCase();
		String imageFor = expectedPictureType.split("/")[1].trim();
		int imgCount;
		WebElement imageElem1,imageElem2;
		switch (expectedImageType) {
			case "crosscut":
				imgCount = element.findElements(By.cssSelector("img")).size();
				if (imgCount < 2)
					return false;
				imageElem1 = element.findElement(By.cssSelector("img:nth-of-Type(1)"));
				imageElem2 = element.findElement(By.cssSelector("img:nth-of-Type(2)"));
				if (!(imageElem1.getAttribute("src").startsWith("data:image/png;base64") && imageElem1.getAttribute("alt").equals(imageFor)))
					return false;
				if (!(imageElem2.getAttribute("src").startsWith("data:image/png;base64") && imageElem2.getAttribute("alt").equals(imageFor)))
					return false;
				return true;

			case "placeholder":
				imgCount = element.findElements(By.cssSelector("img")).size();
				imageElem1 = element.findElement(By.cssSelector("img:nth-of-Type(1)"));
				if (imgCount == 1 && imageElem1.getAttribute("src").contains("/placeholders/") && imageElem1.getAttribute("alt").equals(imageFor))
					return true;
				else
					return false;

			case "thumbnail":
			default:
				imgCount = element.findElements(By.cssSelector("img")).size();
				imageElem1 = element.findElement(By.cssSelector("img"));
				if (imgCount == 1 && imageElem1.getAttribute("src").contains("/Thumbnails/") && imageElem1.getAttribute("alt").equals(imageFor))
					return true;
				else
					return false;
		}
	}
	public MakeItYours verifyEmptyItemList() {
		UtilHBM.waitExplicitDisplayed(driver, noItemPlaceHolder);
		Verification.VerifyEquals("Empty product list text", "You have not yet added a product to your project", noItemPlaceHolder.getText());
		Verification.displayOfWebElement(driver.findElement(By.xpath("//div[@class='no-item-placeholder']/img[@src='../media/img/placeholders/item-list-content.png'][@srcset='../media/img/placeholders/item-list-content@2x.png 168w']")));
		closeProductList();
		return PageFactory.initElements(driver, MakeItYours.class);
	}
}
