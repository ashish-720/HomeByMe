package kitchen.templateEditor.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Information {
		WebDriver driver;
		
		public Information(WebDriver driver) {
			this.driver=driver;	
		}
		
		@FindBy(css="div.product-head>p.name")
		WebElement productName;
		
		Design verification(String prodName )
		{
			
			return PageFactory.initElements(driver, Design.class);
		}
}
