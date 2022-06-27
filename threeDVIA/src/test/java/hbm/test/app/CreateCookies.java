package hbm.test.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateCookies {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./src/main/ChromeDriver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://preprod-home.by.me/en/");
		driver.findElement(By.id("accept-cookie-law")).click();
		File file = new File("./src/main/ChromeDriver/preprodCookiesChrome.data");
		
			try {
				file.delete();
				file.createNewFile();
				FileWriter fileWrite = new FileWriter(file);
				BufferedWriter BWrite = new BufferedWriter(fileWrite);
				for(Cookie ck:driver.manage().getCookies()){
					BWrite.write(ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure());
					BWrite.newLine();
				}
				BWrite.flush();
				BWrite.close();
				fileWrite.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			driver.close();
			driver.quit();
		
		
	}

}
