package teststeps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import testCases.BookFlightpage_tc;
import testCases.BookTourpage_tc;
import testCases.Homepage_tc;
import testCases.Searchpage_tc;

@Listeners(utility.CustomListeners.class)
public class BookTour extends BookTourpage_tc {
	
	public static WebDriver navigateToTour(WebDriver driver) throws Throwable {
		Reporter.log("\nBefore Navigating to Tour Tab ", true);
		isElementPresent("search_Tour_CSS");
//		driver.findElement(By.cssSelector(".text-center.tours")).click();
		click("search_Tour_CSS");
//		isElementPresent("oneway_trip_CSS");
		Reporter.log("\nAfter Navigating Tour Tab", true);
		return driver;
	}
	
	public static WebDriver selectTour(WebDriver driver) throws Throwable {
		Reporter.log("\nBefore Submitting to Tour Tab ", true);
		isElementPresent("search_Tour_CSS");
		click("tourBox_CSS");
		type("tourOf_XPATH", "Australia, North Bondi");
		driver.findElement(By.xpath(config.getFromObjectRepo("tourOf_XPATH"))).sendKeys(Keys.ENTER);
		Reporter.log("\nAfter Selecting Tour For", true);
		return driver;
	}	
	
	public static WebDriver selectTourCheckIn(WebDriver driver) throws Throwable {
		Reporter.log("\nBefore Selecting  to Tour CheckIn ", true);
		isElementPresent("tourType_CSS");
		click("tourType_CSS");
		select("tourTypeDrop_CSS","Ferry");
		
//		Select select = new Select(driver.findElement(By.cssSelector("tourType_CSS")));
//		select.selectByValue("268");
		Reporter.log("\nAfter Selecting  to Tour CheckIn", true);
		Thread.sleep(5000);
		return driver;
	}
}
