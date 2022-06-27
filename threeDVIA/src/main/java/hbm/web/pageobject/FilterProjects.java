package hbm.web.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterProjects {
	WebDriver driver;

	public FilterProjects(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = ".search-container.flex.flex-spaceBetween>aside>header>a[title='Clear All']")
	WebElement clearAll;

	@FindBy(css = ".search-container.flex.flex-spaceBetween>aside>header>p.lead")
	WebElement filtersHeader;

	@FindBy(css = ".search-container.flex.flex-spaceBetween>aside>header>span>i.icon.icon-close")
	WebElement closeButton;

	public void filterProjects(String sortBy) {

		List<WebElement> sortProjectBy=driver.findElements(By.xpath(
				"//article/div[@class='categories radio-bloc']/ul[@class='list-reset flex']/li[not(@class = 'is-active flex flex-middle')]/span[contains(text(),'"+sortBy+"')]/.."));
		if(!sortProjectBy.isEmpty()) {
			sortProjectBy.get(0);
		}
	}

	public void clearAllFilters() {

	}

}
