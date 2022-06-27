package hbm.web.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Services {

	private WebDriver driver;
	
	public Services(WebDriver driver) {
		this.driver=driver;
	}
	
	public void chceckServices() {
		driver.findElement(By.cssSelector("ul.header-menu > li:nth-child(1) > a")).click();
		driver.findElement(By.cssSelector("div.flex.flex-spaceBetween > div:nth-child(1) > footer > nav > a.button.u-mbxs")).click();		
		
	
	}

}
