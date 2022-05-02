package util;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.Techfios101Page;
@SuppressWarnings("unused")

public class BrowserFactory{

	static WebDriver driver;
	static String browser;
	static String url;

	
	
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
	
	
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}