package util;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.Techfios101Page;
public class BrowserFactory{

	static WebDriver driver;
	static String browser;
	static String url;

	
	@BeforeTest
	public static WebDriver init() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://techfios.com/test/101/index.php");
		
		return driver;	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}