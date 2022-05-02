package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.Techfios101Page;
import util.BrowserFactory;

public class ValidateMonthDropDownContainsAllMonths {

	static WebDriver driver;
	Techfios101Page techfiosPage;
	BrowserFactory browserFactory = new BrowserFactory();
	
	@Test
	public void validateMonthDropDown() {
	
		driver = BrowserFactory.init();

		techfiosPage = PageFactory.initElements(driver, Techfios101Page.class);
		
		techfiosPage.selectDropdownAndValidateAllMonths();
		
		driver.close();
	}
}
