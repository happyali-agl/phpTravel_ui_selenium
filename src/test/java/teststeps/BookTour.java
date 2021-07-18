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
import testCases.Homepage_tc;
import testCases.Searchpage_tc;

@Listeners(utility.CustomListeners.class)
public class BookTour extends BookFlightpage_tc {
	
	public static WebDriver navigateToTour(WebDriver driver) throws Throwable {
		Reporter.log("\nBefore Navigating to Tour Tab ", true);
		isElementPresent("search_Tour_CSS");
//		driver.findElement(By.cssSelector(".text-center.flights")).click();
		click("search_Tour_CSS");
//		isElementPresent("oneway_trip_CSS");
		return driver;
	}
	
	public static WebDriver submitTour(WebDriver driver) throws Throwable {
		Reporter.log("\nBefore Submitting to Tour Tab ", true);
//		isElementPresent("search_Tour_CSS");
//		driver.findElement(By.cssSelector(".text-center.flights")).click();
//		click("search_flights_CSS");
//		isElementPresent("oneway_trip_CSS");
		return driver;
	}	
}
