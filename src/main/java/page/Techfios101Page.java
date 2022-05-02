package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import util.CollectionContainer;


public class Techfios101Page {

	WebDriver driver;
	CollectionContainer container = new CollectionContainer();

	public Techfios101Page(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "categorydata")
	WebElement ADD_CATEGORY_FIELD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@type='submit'][@value='Add category']")
	WebElement ADD_CATEGORY_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'testArshia')]")
	WebElement ADDED_CATEGORY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'dupeArshia')]")
	WebElement ADDED_DUPLICATE_CATEGORY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Yes')]")
	WebElement YES_REMOVE_ITEM_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Nevermind')]")
	WebElement NEVERMIND_REMOVE_ITEM_ELEMENT;
	@FindBy(how = How.XPATH, using = "//body[contains(text(),'The category you want to add already exists: ')]")
	WebElement DUPLICATE_CATEGORY_WARNING_TEXT_ELEMENT;
	@FindBy(how = How.NAME, using = "due_month")
	WebElement DUE_MONTH_DROPDOWN_ELEMENT;
		

	public void validateotherCheckBoxes() {

		List<WebElement> listItems = driver.findElements(By.xpath("//li/input[@type='checkbox']"));

		for (int i = 0; i <= listItems.size(); i++) {
			try {
				listItems.get(i).isSelected();
				if (i == listItems.size()) {
					System.out.println("All items were checked");
				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Number " + i + " was the last item on the list");
			}
		}
	}

	public void createNewCategory() {
		ADD_CATEGORY_FIELD_ELEMENT.sendKeys("testArshia");
		ADD_CATEGORY_BUTTON_ELEMENT.click();
	}

	public void createNewCategoryForDuplicateCheck() {
		ADD_CATEGORY_FIELD_ELEMENT.sendKeys("dupeArshia");
		ADD_CATEGORY_BUTTON_ELEMENT.click();
	}

	public void validateCreatedCategoryAndRemove() {
		try {
			ADDED_CATEGORY_ELEMENT.isDisplayed();
			System.out.println("Category was successfuly added and validated.");
			if(ADDED_CATEGORY_ELEMENT.isDisplayed()) {
				ADDED_CATEGORY_ELEMENT.click();
				YES_REMOVE_ITEM_ELEMENT.click();	
			}
		} catch (NoSuchElementException e) {
			System.out.println("Added category was not found.");
		}	
	}
	
	public void validateDuplicateWarningPage() {
		try {
			DUPLICATE_CATEGORY_WARNING_TEXT_ELEMENT.isDisplayed();
			NEVERMIND_REMOVE_ITEM_ELEMENT.click();
			System.out.println("The duplicate was not permitted.");
		}catch(NoSuchElementException e) {
		System.out.println("Validation failed.");
		}
	}
	public void removeDuplicateCategory() {
		ADDED_DUPLICATE_CATEGORY_ELEMENT.click();
		YES_REMOVE_ITEM_ELEMENT.click();
	}
	
	public void selectDropdownAndValidateAllMonths() {
		
		Select dropdown = new Select(DUE_MONTH_DROPDOWN_ELEMENT);
		List<String> actualList = new ArrayList<String>();
		List<String> expectedMonths = container.returnList();
		
		for (WebElement element : dropdown.getOptions()) {
			actualList.add(element.getText());
		}
			
		for (int i = 0; i < actualList.size() ; i++) {
			System.out.println("Actual : " + actualList.get(i)+" & Expected : "+expectedMonths.get(i));
			Assert.assertTrue(actualList.get(i).equals(expectedMonths.get(i)));
		}
		
		
		
		
	}

}
